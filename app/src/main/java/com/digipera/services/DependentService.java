package com.digipera.services;

import com.digipera.commons.Formatter;
import com.digipera.dto.Dependent;
import com.digipera.mockdata.DependentData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class DependentService {

    public static List<Dependent> getAllDependents() {
        List<Dependent> dependentList = new ArrayList<>();
        DependentData dependentData = new DependentData();
        Map<String, Dependent> dependents = dependentData.getDependents();
        //Creating duplicate dependents to keep cards coming
        int counter = 10;
        for (int i = 0; i < counter; i++) {
            dependentList.add(dependents.get("ishita"));
            dependentList.add(dependents.get("rohan"));
        }
        return dependentList;
    }

}
