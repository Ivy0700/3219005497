package utils;

import org.wltea.analyzer.core.IKSegmenter;

import java.io.IOException;

public class ProcessUtils {

    public static void applicationProcess(String originPath, String copyPath, String outputPath) throws IOException {


        IKSegmenter segmenter1 = FileUtils.getSegmenterByFile(originPath);
        IKSegmenter segmenter2 = FileUtils.getSegmenterByFile(copyPath);

        String simHash1 = SimHashUtils.getSimHash(segmenter1);
        String simHash2 = SimHashUtils.getSimHash(segmenter2);

        double similarity = HammingUtils.getSimilarity(simHash1, simHash2);

        FileUtils.writeFile(String.valueOf(similarity), originPath, copyPath, outputPath);

    }
}
