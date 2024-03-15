package com.kreitek.editor.utils;

import com.kreitek.editor.interfaces.DocumentStateManager;
import com.kreitek.editor.memento.EditorCaretaker;
import com.kreitek.editor.memento.Memento;

import java.util.ArrayList;
import java.util.List;

public class DocumentStateManagerImpl implements DocumentStateManager {

    public Memento restoreDocument (EditorCaretaker editorCaretaker){
        Memento memento = editorCaretaker.pop();
        return memento;
    }
    public Memento getState(List<String> documentLines){
        List<String> state = new ArrayList<>();
        state = new ArrayList<>(documentLines);
        return new Memento (state);
    }
}
