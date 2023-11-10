package org.test.archive;

import org.test.animals.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ArchiveParser {
    public List<Animal> parse(File file) {
        List<Livestock> archive = new LinkedList<>();
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                var line = sc.nextLine().split(" ");
                archive.add(switch (line[0]){
                    case "Cow" -> new Cow(line[1], line[2]);
                    case "Sheep" -> new Sheep(line[1], line[2]);
                    case "Pig" -> new Pig(line[1], line[2], Double.parseDouble(line[3]));
                    default -> null;
                });
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < archive.size(); i++) {
            if (archive.get(i) == null)
                archive.remove(i--);
        }

        return archive.stream().map(a -> (Animal) a).toList();

    }
}
