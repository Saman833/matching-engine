package edu.harbourspace.university.matchingengine;

import java.util.Scanner;

public class InputReader {
    private final Scanner scanner;

    public InputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public long readMaxPosition() {
        return scanner.nextLong();
    }

    public String readOrder() {
        return scanner.nextLine();
    }
}
