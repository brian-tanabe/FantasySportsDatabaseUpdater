package com.btanabe.fsdu.test.integration.store;

import com.btanabe.fsdu.models.EspnNbaProjectionModel;
import com.btanabe.fsdu.store.DatabaseInterface;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Brian on 11/8/15.
 */
@ContextConfiguration("classpath:spring-configuration/unit-testing-configuration.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DatabaseInterfaceTests {

    @Autowired
    @Qualifier("testDatabaseConfiguration")
    private DatabaseInterface databaseInterface;

    @Autowired
    @Qualifier("anthonyDavisEspnProjectionModel")
    private EspnNbaProjectionModel anthonyDavisEspnProjection;

    @Before
    public void clearDatabase() {
        databaseInterface.deleteAllObjectsOfType(EspnNbaProjectionModel.class);
    }

    @Test
    public void shouldBeAbleToInsertEspnNbaProjectionModelsIntoTheProperTable() throws Exception {
        databaseInterface.saveOrUpdate(anthonyDavisEspnProjection);
    }

    @Test
    public void shouldBeAbleToReadFromEspnNbaProjectionsDatabase() throws Exception {
        databaseInterface.saveOrUpdate(anthonyDavisEspnProjection);
        List<EspnNbaProjectionModel> objectsInDatabase = databaseInterface.getAllObjectsOfType(EspnNbaProjectionModel.class);

        assertThat(objectsInDatabase.size(), is(equalTo(1)));
        assertThat(objectsInDatabase.stream().findFirst().get(), is(equalTo(anthonyDavisEspnProjection)));
    }
}
