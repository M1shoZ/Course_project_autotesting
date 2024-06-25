package com.zakaryan.tests.task4;

import com.zakaryan.framework.managers.DriverManager;
import com.zakaryan.framework.managers.InitManager;
import com.zakaryan.framework.managers.PageManager;
import com.zakaryan.framework.managers.TestPropManager;
import com.zakaryan.framework.utils.PropConst;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class BaseTests {
    private final DriverManager driverManager = DriverManager.getInstance();
    private final TestPropManager propManager = TestPropManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();


    @BeforeClass
    public static void beforeClass(){
        InitManager.initFramework();
    }

    @Before
    public void before(){
        driverManager.getDriver().get(propManager.getProperty(PropConst.CHESS_URL));
    }

    @AfterClass
    public static void after(){
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        InitManager.quitFramework();
    }
}
