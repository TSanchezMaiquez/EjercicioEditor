package com.kreitek.editor;

import com.kreitek.editor.edit.EditorFactory;
import com.kreitek.editor.interfaces.ConsolePrint;
import com.kreitek.editor.interfaces.DocumentStateManager;
import com.kreitek.editor.interfaces.Editor;
import com.kreitek.editor.utils.ConsolePrinterImpl;
import com.kreitek.editor.utils.DocumentStateManagerImpl;

public class Application {

    public static void main(String[] args) {

        ConsolePrint consolePrint = new ConsolePrinterImpl();
        DocumentStateManager documentStateManager = new DocumentStateManagerImpl();

        EditorFactory editorFactory = new EditorFactory(consolePrint, documentStateManager);
        Editor editor = editorFactory.getEditor();
        editor.run();
    }

}
