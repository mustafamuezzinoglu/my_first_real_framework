package net.seamlessly.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.seamlessly.utilities.Driver;

public class Hooks {


    @Before
    public void init(){

    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }
}
