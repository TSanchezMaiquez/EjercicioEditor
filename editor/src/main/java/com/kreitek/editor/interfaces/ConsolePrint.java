package com.kreitek.editor.interfaces;

import java.util.ArrayList;

public interface ConsolePrint {

    void printDocumentLines(ArrayList<String> textLines);
    void showHelp();
    void printErrorToConsole(String message);
    void printToConsole(String message);
}
