package com.xo.plus.viewer;

import com.xo.plus.data.Field;
import com.xo.plus.data.Winner;

public interface InterfaceControl {
    String startInterface();
    int[] update(String name) throws Exception;
    void endInterface(Winner winner, Field field);
}
