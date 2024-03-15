package com.kreitek.editor;

import com.kreitek.editor.edit.EditorFactory;
import com.kreitek.editor.interfaces.ConsolePrint;
import com.kreitek.editor.interfaces.Editor;
import com.kreitek.editor.utils.ConsolePrinterImpl;

public class Application {

    public static void main(String[] args) {
        EditorFactory editorFactory = new EditorFactory();
        Editor editor = editorFactory.getEditor();
        editor.run();
    }

}
