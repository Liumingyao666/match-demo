package com.che.demo;

import com.che.demo.once.ReadExcel;
import com.che.demo.utils.AlgorithmUtils;
import org.apache.commons.math3.util.Pair;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void getCarData() throws IOException {
        List<String> carData = ReadExcel.getCarData("B");
        System.out.println(carData);
    }

    @Test
    void match() throws IOException {
        List<String> listA = ReadExcel.getCarData("A");
        List<String> listB = ReadExcel.getCarData("B");

        List<Pair<String, Long>> list = new ArrayList<>();
        String minStr = "";
        long minDistance = Integer.MAX_VALUE;
        //listA.size()
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < listB.size(); j++) {
                String s = listA.get(i);
                long distance = AlgorithmUtils.minDistance(s, listB.get(j));
                if (distance < minDistance) {
                    minStr = listB.get(j);
                    minDistance = distance;
                }
                list.add(new Pair<>(s, minDistance));
            }
        }
        System.out.println("奥迪 奥迪A4L 2018款 30周年版 30 TFSI 进取版");
        System.out.println(minStr);
        // 按编辑距离由小到大排序
//        List<Pair<String, Long>> topUserPairList = list.stream()
//                .sorted((a, b) -> (int) (a.getValue() - b.getValue()))
//                .limit(1)
//                .collect(Collectors.toList());
//        System.out.println(topUserPairList);
    }
}
