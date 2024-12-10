package store.common.utils;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtils {
    private static final String CSV_DELIMITER = ",";

    public static List<List<String>> readCSV(final String filePath) {
        List<List<String>> data = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(Arrays.asList(line.split(CSV_DELIMITER)));
            }
        } catch (IOException e) {
            System.out.println("[ERROR]" + e.getMessage());
        }
        return removeHeader(data);
    }

    public static void writeCSV(final String filePath, final List<List<String>> saveData,
                                final List<String> header) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append(csvFormatRow(header));
            for (List<String> row : saveData) {
                writer.append(csvFormatRow(row));
            }
        } catch (IOException e) {
            System.out.println("[ERROR]" + e.getMessage());
        }
    }

    private static List<List<String>> removeHeader(final List<List<String>> data) {
        data.removeFirst();
        return data;
    }

    private static String csvFormatRow(final List<String> data) {
        return String.join(CSV_DELIMITER, data) + "\n";
    }
}
