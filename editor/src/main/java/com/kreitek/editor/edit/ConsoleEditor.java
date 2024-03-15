package com.kreitek.editor.edit;

import com.kreitek.editor.BadCommandException;
import com.kreitek.editor.ExitException;
import com.kreitek.editor.commands.CommandFactory;
import com.kreitek.editor.interfaces.Command;
import com.kreitek.editor.interfaces.ConsolePrint;
import com.kreitek.editor.interfaces.DocumentStateManager;
import com.kreitek.editor.interfaces.Editor;
import com.kreitek.editor.memento.EditorCaretaker;
import com.kreitek.editor.memento.Memento;
import com.kreitek.editor.utils.ConsolePrinterImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleEditor implements Editor {


    private final CommandFactory commandFactory = new CommandFactory(this);
    private ArrayList<String> documentLines = new ArrayList<String>();
    private EditorCaretaker editorCaretaker = new EditorCaretaker();
    private DocumentStateManager documentStateManager;
    private boolean restaurado;
    private ConsolePrint consolePrinterImpl;

    public ConsoleEditor(ConsolePrint consolePrint, DocumentStateManager documentStateManager){
        this.consolePrinterImpl = consolePrint;
        this.documentStateManager = documentStateManager;
    }

    @Override
    public void run() {
        boolean exit = false;
        while (!exit) {
            String commandLine = waitForNewCommand();
            try {
                Command command = commandFactory.getCommand(commandLine);
                command.execute(documentLines);
                if(!restaurado){
                    editorCaretaker.push(getState());
                }else {
                    restaurado = false;
                }

            } catch (BadCommandException e) {
                consolePrinterImpl.printErrorToConsole("Bad command");
            } catch (ExitException e) {
                exit = true;
            }
            consolePrinterImpl.printDocumentLines(documentLines);
            consolePrinterImpl.showHelp();
        }
    }

    private String waitForNewCommand() {
        consolePrinterImpl.printToConsole("Enter a command : ");
        Scanner scanner = new Scanner(System. in);
        return scanner.nextLine();
    }

    public void restore (){
        Memento memento = documentStateManager.restoreDocument(editorCaretaker);
        if (memento != null){
            documentLines = new ArrayList<>(memento.getState());
            restaurado = true;
        }else {
            reset();
        }
    }
    public Memento getState(){
        return documentStateManager.getState(documentLines);
    }

    public void reset(){
        documentLines = new ArrayList<>();
    }
}
