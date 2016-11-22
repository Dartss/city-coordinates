package FilesReader;

import java.io.IOException;
import java.util.List;

public interface FilesDataReader {
    List<String> readConfigFile() throws IOException;

    List<String> readFile(String filePath) throws IOException;
}
