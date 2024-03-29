package edu.harbourspace.university.matchingengine;

import java.util.Scanner;

public class InputReader {
    private final Scanner scanner;

    public InputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public long readMaxPosition() {
        long maxPosition = scanner.nextLong();
        scanner.nextLine();
        return maxPosition;
    }
    public String readOrder() {
        return scanner.nextLine();
    }
}
