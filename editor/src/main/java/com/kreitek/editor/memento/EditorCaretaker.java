package com.kreitek.editor.memento;

import java.util.ArrayList;
import java.util.List;

public class EditorCaretaker {
    List<Memento> mementos = new ArrayList<>();

    public void push(Memento memento){
        mementos.add(memento);
    }
    public Memento pop() {
        if (mementos.size() > 0){
            Memento memento = mementos.get(mementos.size()-1);
            mementos.remove(mementos.size()-1);
            return memento;
        }
        return null;
    }
}
