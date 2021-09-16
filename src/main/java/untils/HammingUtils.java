package untils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HammingUtils {
    /**
     * 计算海明距离
     * @param simHash1
     * @param simHash2
     * @return
     */
    private static int getHammingDistance(String simHash1, String simHash2) {
        int length = simHash1.length();
        int distance = 0;
        //TODO 后续可能需要一些异常处理
        for(int i = 0; i < length; i++) {
            if(simHash1.charAt(i) != simHash2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    /**
     * 计算相似度
     * @param simHash1
     * @param simHash2
     * @return
     */
    public static double getSimilarity(String simHash1, String simHash2){
        //获取两者之间的海明距离
        int distance = getHammingDistance(simHash1, simHash2);

        BigDecimal bigDecimal = new BigDecimal(1 - (double) distance / simHash1.length());
        double value = bigDecimal.setScale(2, RoundingMode.HALF_UP).doubleValue();

        return value;
    }
}
