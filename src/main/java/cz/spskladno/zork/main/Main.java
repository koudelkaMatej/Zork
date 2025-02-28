package cz.spskladno.zork.main;
import cz.spskladno.zork.ui.CommandLineUI;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8));
        CommandLineUI.getInstance().start();
    }
}