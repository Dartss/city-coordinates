package FilesReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesDataReaderImpl implements FilesDataReader {
    private static final String CONFIG_FILE_PATH = "config.txt";

    @Override
    public List<String> readConfigFile() throws IOException {
        return readFile(CONFIG_FILE_PATH);
    }

    @Override
    public List<String> readFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {

            lines = stream.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
