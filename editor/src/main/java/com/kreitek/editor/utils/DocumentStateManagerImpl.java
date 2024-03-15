package com.kreitek.editor.memento;

import java.util.ArrayList;
import java.util.List;

public class DocumentStateManager {

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
