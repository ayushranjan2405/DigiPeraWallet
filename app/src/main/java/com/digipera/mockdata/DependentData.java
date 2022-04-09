package com.digipera.mockdata;

import com.digipera.dto.Dependent;
import com.digipera.dto.User;

import java.util.HashMap;
import java.util.Map;

public class DependentData {

    private Map<String, Dependent> dependents;

    public DependentData() {
        dependents = new HashMap<>();
        dependents.put("ishita",new Dependent("Ishita", "Singh", "1000.00", "50"));
        dependents.put("rohan", new Dependent("Rohan", "Singh", "2000.00", "60"));
    }

    public Map<String, Dependent> getDependents(){
        return dependents;
    }
}
