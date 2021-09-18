package utils;

import exception.FileEmptyException;
import exception.FileNotExistException;
import exception.FileWrongFormatException;
import org.wltea.analyzer.core.IKSegmenter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        StringBuilder stringBuilder = new StringBuilder();
        try {
            System.out.print("The original File : " + originPath );
            System.out.println(" ");
            System.out.print("The copy File : " + fakePath);
            System.out.println(" ");
            System.out.print("Similarity : " + similarity + "%");
            System.out.println();
            fileWriter = new FileWriter(file, true);
            stringBuilder.append("The original File : ").append(originPath);
            stringBuilder.append("\n");
            stringBuilder.append("The copy File : ").append(fakePath);
            stringBuilder.append("\n");
            stringBuilder.append("Similarity : ").append(similarity).append("%");
            stringBuilder.append("\n");
            fileWriter.write( stringBuilder.toString());

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
