package com.xo.plus.viewer;

import com.xo.plus.data.Field;
import com.xo.plus.data.Winner;

public interface InterfaceControl {
    void startInterface();
    int[] update(String name) throws Exception;
    void endInterface(Winner winner, Field field);
}
