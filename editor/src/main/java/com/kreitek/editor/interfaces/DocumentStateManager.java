package com.kreitek.editor.interfaces;

import com.kreitek.editor.memento.EditorCaretaker;
import com.kreitek.editor.memento.Memento;

import java.util.List;

public interface DocumentStateManager {
    Memento restoreDocument (EditorCaretaker editorCaretaker);
    Memento getState(List<String> documentLines);
}
