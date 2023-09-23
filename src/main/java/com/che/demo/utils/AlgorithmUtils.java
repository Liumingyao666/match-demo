package com.che.demo.utils;

import java.util.List;
import java.util.Objects;

/**
 * 算法工具类
 *
 * @author LiuMingyao
 *
 */
public class AlgorithmUtils {

    /**
     * 编辑距离算法
     * 计算最相似的两个车型
     *
     * @param carTypeNameA
     * @param carTypeNameB
     * @return
     */
    public static int minDistance(String carTypeNameA, String carTypeNameB){
        int n = carTypeNameA.length();
        int m = carTypeNameB.length();

        if(n * m == 0)
            return n + m;

        int[][] d = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++){
            d[i][0] = i;
        }

        for (int j = 0; j < m + 1; j++){
            d[0][j] = j;
        }

        for (int i = 1; i < n + 1; i++){
            for (int j = 1; j < m + 1; j++){
                int left = d[i - 1][j] + 1;
                int down = d[i][j - 1] + 1;
                int left_down = d[i - 1][j - 1];
                if (carTypeNameA.charAt(i - 1) != carTypeNameB.charAt(j - 1))
                    left_down += 1;
                d[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return d[n][m];
    }

    /**
     * 编辑距离算法
     * 计算最相似的两个车型
     *
     * @param carTypeNameALit
     * @param carTypeNameBList
     * @return
     */
    public static int minDistanceByList(List<String> carTypeNameALit, List<String> carTypeNameBList){
        int n = carTypeNameALit.size();
        int m = carTypeNameBList.size();

        if(n * m == 0)
            return n + m;

        int[][] d = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++){
            d[i][0] = i;
        }

        for (int j = 0; j < m + 1; j++){
            d[0][j] = j;
        }

        for (int i = 1; i < n + 1; i++){
            for (int j = 1; j < m + 1; j++){
                int left = d[i - 1][j] + 1;
                int down = d[i][j - 1] + 1;
                int left_down = d[i - 1][j - 1];
                if (!Objects.equals(carTypeNameALit.get(i-1), carTypeNameBList.get(j - 1)))
                    left_down += 1;
                d[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return d[n][m];
    }

}
