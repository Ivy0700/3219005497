package utils;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class SimHashUtils {
    private static Integer hashBit = 128;

    /**
     * 获取分词频率
     * @param segmenter IKSegmenter里存有分词后的内容
     * @return 存有词频率的哈希表
     * @throws IOException 可能发生的IO异常
     */
    private static Map<String, Integer> getWordFrequency(IKSegmenter segmenter) throws IOException {
        Map<String, Integer> frequencyMap = new HashMap<>();

        Lexeme word = segmenter.next();

        while (word != null) {
            String text = word.getLexemeText();
            frequencyMap.put(text, frequencyMap.getOrDefault(text, 0) + 1);
            word = segmenter.next();
        }

        return frequencyMap;
    }

    /**
     * 对该词进行MD5加密，如果少于hashBit则用0补全
     * @param word 词
     * @return 哈希值
     */
    private static String getMD5Hash(String word) {
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            StringBuilder hash = new StringBuilder(new BigInteger(1, messageDigest.digest(word.getBytes(StandardCharsets.UTF_8))).toString(2));

            //如果hash小于hashBit，则用0补全
            if(hash.length() < hashBit) {
                int diff = hashBit - hash.length();
                for(int i = 0; i < diff; i++) {
                    hash.append("0");
                }
            }
            return hash.toString();
        }catch(Exception e){
            e.printStackTrace();
            return word;
        }

    }

    /**
     * 获取SimHash值
     * @param segmenter IKSegementer里存有分词后的内容
     * @return SimHash
     */
    public static String getSimHash(IKSegmenter segmenter) throws IOException {
        int[] vector = new int[hashBit];
        //1. 分词
        Map<String, Integer> wordFrequency = getWordFrequency(segmenter);
        //2. MD5Hash、加权、合并
        for(String word : wordFrequency.keySet()){
            //获取该词出现的频率
            Integer frequency = wordFrequency.get(word);
            //获取MD5加密后的hash
            String wordHash = getMD5Hash(word);

            //加权、合并
            //这里的加权是加上了该词出现的频率，利用数组来存储合并之后的值
            for(int i = 0 ; i < vector.length; i++) {
                if(wordHash.charAt(i) == '1') {
                    vector[i] += frequency;
                } else{
                    vector[i] -= frequency;
                }
            }

        }


        //3. 降维
        StringBuilder simHash = new StringBuilder();
        for(int i = 0; i< vector.length; i++) {
            if(vector[i] >= 1) {
                simHash.append("1");
            } else {
                simHash.append("0");
            }
        }

        return simHash.toString();
    }


}
