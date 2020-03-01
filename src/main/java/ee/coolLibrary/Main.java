package ee.coolLibrary;

import ee.coolLibrary.controllers.MainControllerToCMD;
import ee.coolLibrary.core.Core;
import ee.coolLibrary.repositories.DatabaseUtil;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Core.run(MainControllerToCMD.class);
        DatabaseUtil.shutdown();
    }




}
