package model;

import java.util.ArrayList;
import java.util.List;

public class Environment {
    private EnvironmentModel test1;
    private EnvironmentModel test2;
    private EnvironmentModel test3;

    public EnvironmentModel getTest1() {
        return test1;
    }

    public EnvironmentModel getTest2() {
        return test2;
    }

    public EnvironmentModel getTest3() {
        return test3;
    }

    public List<EnvironmentModel> getEnvironments() {
        List<EnvironmentModel> environments = new ArrayList<>();
        environments.add(getTest1());
        environments.add(getTest2());
        environments.add(getTest3());
        return environments;
    }
}