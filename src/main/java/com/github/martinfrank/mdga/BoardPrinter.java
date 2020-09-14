package com.github.martinfrank.mdga;

import com.sun.javafx.UnmodifiableArrayList;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BoardPrinter {

    private static final String TEMPLATE_FILE = "src/main/resources/boardtemplate.txt";
    private final UnmodifiableArrayList<String> template;
    private static final String BLANK_FIELD = "     ";

    public BoardPrinter() throws IOException {
        this(Files.readAllLines(Paths.get(new File(TEMPLATE_FILE).toURI())));
    }

    public BoardPrinter(List<String> template) {
        this.template = new UnmodifiableArrayList<>(template.toArray(new String[]{}), template.size());
    }

    public void print(Board board) {
        print(board, System.out);
    }

    public void print(Board board, PrintStream out) {
        //template.forEach(out::println);
        List<String> field = replaceFields(template, board.getFields());
        field.forEach(out::println);
    }

    private List<String> replaceFields(List<String> template, List<Field> fields) {
        List<String> result = new ArrayList<>();
        for (String line : template) {
            for (Field field : fields) {
                String replacement = field.getFigurine() == null ? BLANK_FIELD : createFieldReplacement(field.getFigurine());
                line = line.replace(field.getIdentifier().getToken(), replacement);
            }
            result.add(line);
        }
        return result;
    }

    private String createFieldReplacement(Figurine figurine) {
        PlayerColor playerIdentifier = figurine.getColor();
        return " " + playerIdentifier + "-" + figurine.getNumber() + " ";
    }
}
