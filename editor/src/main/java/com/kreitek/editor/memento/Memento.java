package com.kreitek.editor.memento;

import java.util.List;
import java.util.Map;

public class Memento {
    private List<String> state;
    public Memento(List<String> state) {
        this.state = state;
    }

    public List<String> getState() {
        return state;
    }
}
