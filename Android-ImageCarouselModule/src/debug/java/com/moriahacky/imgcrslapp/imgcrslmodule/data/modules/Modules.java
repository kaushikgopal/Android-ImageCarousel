package com.moriahacky.imgcrslapp.imgcrslmodule.data.modules;

import java.util.ArrayList;
import java.util.List;

import com.moriahacky.imgcrslapp.imgcrslmodule.BaseApplication;

public class Modules {

    public static List<Object> testModules = null;

    private Modules() {
        // Don't allow instances.
    }

    public static Object[] list(BaseApplication app) {
        // return new Object[]{ new PkkModule(app) };
        List<Object> modules = new ArrayList<Object>();
        modules.add(new BaseModule(app));

        if (testModules != null) {
            modules.addAll(testModules);
        }

        return modules.toArray();
    }
}
