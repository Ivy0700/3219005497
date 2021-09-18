package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HammingUtils {
    /**
     * 计算海明距离
     * @param simHash1 原文件的simHash
     * @param simHash2 抄袭文件的simHash
     * @return 海明距离
     */
    private static int getHammingDistance(String simHash1, String simHash2) {
        int length = simHash1.length();
        int distance = 0;
        for(int i = 0; i < length; i++) {
            if(simHash1.charAt(i) != simHash2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    /**
     * 计算相似度
     * @param simHash1 原文件SimHash
     * @param simHash2 抄袭文件SimHash
     * @return 相似度
     */
    public static double getSimilarity(String simHash1, String simHash2){
        //获取两者之间的海明距离
        int distance = getHammingDistance(simHash1, simHash2);

        //计算出SimHash之间的交集
        int intersection = simHash1.length() - distance;
        //SimHash之间的并集
        int union = simHash1.length() + distance;

        BigDecimal bigDecimal = new BigDecimal(  100 * (double) intersection / union);

        return bigDecimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
