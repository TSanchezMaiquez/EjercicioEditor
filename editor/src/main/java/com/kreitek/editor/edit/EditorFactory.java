package com.kreitek.editor.edit;

import com.kreitek.editor.interfaces.ConsolePrint;
import com.kreitek.editor.interfaces.DocumentStateManager;
import com.kreitek.editor.interfaces.Editor;
import com.kreitek.editor.utils.ConsolePrinterImpl;
import com.kreitek.editor.utils.DocumentStateManagerImpl;

public class EditorFactory {
    private ConsolePrint consolePrint = new ConsolePrinterImpl();
    private DocumentStateManager documentStateManager = new DocumentStateManagerImpl();
    public Editor getEditor() {
        return new ConsoleEditor(consolePrint, documentStateManager);
    }
}
