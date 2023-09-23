package com.che.demo.Controller;

import com.che.demo.once.ReadExcel;
import com.che.demo.utils.AlgorithmUtils;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/car")
@Slf4j
public class CarTypeController {

    @GetMapping("/match")
    public void match () throws IOException {
        List<String> listA = ReadExcel.getCarData("A");
        List<String> listB = ReadExcel.getCarData("B");

        Map<String, String> matchMap = new HashMap<>();

        List<Pair<String, Integer>> list  = new ArrayList<>();
        for (int i = 0; i < listA.size(); i++) {
            for (int j = 0; j < listB.size(); j++) {
                String s1 = listA.get(i);
                String s2 = listB.get(j);
                int minDistance = AlgorithmUtils.minDistance(s1, s2);
                list.add(new Pair<>(s1, minDistance));

                matchMap.put(s1,s2);
            }
        }
    }
}
