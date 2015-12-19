package com.btanabe.fsdu.test.integration.processors;

import com.btanabe.fsdu.models.EspnNbaProjectionModel;
import com.btanabe.fsdu.parsers.ValueExtractor;
import com.btanabe.fsdu.processors.BoundedThreadPoolExecutor;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Brian on 12/12/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BoundedThreadPoolExecutorTests {
    private static BoundedThreadPoolExecutor threadPool;

    @Autowired
    @Qualifier("espnProjectionsPlayerIdValueExtractor")
    private ValueExtractor espnPlayerIdValueExtractor;

    @Autowired
    @Qualifier("espnProjectionsPageKyrieIrving")
    private String kyrieIrvingEspnProjectionPageHtml;


    @Autowired
    @Qualifier("kyrieIrvingEspnProjectionModel")
    private EspnNbaProjectionModel expectedKyrieIrvingEspnNbaProjectionModel;

    @BeforeClass
    public static void setupTestThreadPool() {
        threadPool = BoundedThreadPoolExecutor.getInstance();
    }

    @Test
    public void shouldBeAbleToSubmitValueExtractorTasksToTheThreadPool() {
//        threadPool.queueAndExecuteTask(espnPlayerIdValueExtractor);
    }
}
