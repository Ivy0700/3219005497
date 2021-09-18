import utils.ProcessUtils;

import java.io.IOException;

public class TestCommandLine {
    public static void main(String[] args) throws IOException {
        String originFile = args[0];
        String fakeFile = args[1];
        String outputFilePath = args[2];

        ProcessUtils.applicationProcess(originFile, fakeFile, outputFilePath);

    }
}
