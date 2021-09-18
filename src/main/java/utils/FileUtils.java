package utils;

import exception.FileEmptyException;
import exception.FileException;
import exception.FileNotExistException;
import exception.FileWrongFormatException;
import org.wltea.analyzer.core.IKSegmenter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileUtils {

    public static IKSegmenter getSegmenterByFile(String filePath) throws FileNotFoundException {
        if(!filePath.endsWith("txt")) {
            throw new FileWrongFormatException("文件不是txt格式");
        }
        File file = new File(filePath);
        if(!file.exists()) {
            throw new FileNotExistException(filePath + "文件不存在");
        }

        if(file.length() == 0) {
            throw new FileEmptyException(filePath + "文件为空");
        }

        InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);

        IKSegmenter segmenter = new IKSegmenter(reader, true);

        return segmenter;
    }

    public static void writeFile(String similarity, String originPath, String fakePath, String filePath) {
        File file = new File(filePath);
        FileWriter fileWriter = null;
        try {
            System.out.print("The original File : " + originPath );
            System.out.print("The copy File : " + fakePath);
            System.out.print("Similarity : " + similarity + "%");
            System.out.println();
            fileWriter = new FileWriter(file);
            fileWriter.write( similarity + "%");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
