package com.kreitek.editor.commands;

import com.kreitek.editor.edit.ConsoleEditor;
import com.kreitek.editor.interfaces.Command;

import java.util.ArrayList;

public class UndoCommand implements Command {
    private ConsoleEditor consoleEditor;

    public UndoCommand(ConsoleEditor consoleEditor) {
        this.consoleEditor = consoleEditor;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        consoleEditor.restore();
    }
}
