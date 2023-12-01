package org.test.archive;

import org.test.animals.Cow;
import org.test.animals.Livestock;
import org.test.animals.Pig;
import org.test.animals.Sheep;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArchiveWriter {
    public static void write(List<Livestock> livestocks, File file) {
        try (FileWriter writer = new FileWriter(file, true)) {
            for (Livestock animal : livestocks) {
                if (animal instanceof Cow cow) {
                    writer.write(cow.getClass().getSimpleName());
                    writer.write(cow.getVetID());
                    writer.write(cow.getID());
                    writer.write("\n");
                } else if (animal instanceof Pig pig) {
                    writer.append(pig.getClass().getSimpleName())
                            .append(pig.getVetID())
                            .append(pig.getID())
                            .append(String.valueOf(pig.getMass()))
                            .append("\n");
                } else if (animal instanceof Sheep sheep) {
                    writer.append(sheep.getClass().getSimpleName())
                            .append(sheep.getVetID())
                            .append(sheep.getID())
                            .append("\n");
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
