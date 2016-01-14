package day10.junit;

//import org.junit.Assert;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CatTests {

    private Cat cat;

    @Before
    public void init(){
        cat =new Cat();

    }

    @Test
    public void checkCatNameDefaultValue(){
        String name= cat.getName();
        //Assert.assertNull("Default null name", name);
        assertNull("Default null name", name);
    }

    @Test
    public void checkCatWeightDefaultValue(){
        //Assert.assertTrue("Default weight", cat.getWeight() == 0.0);
        assertTrue("Default weight", cat.getWeight() == 0.0);
    }

    @Test
    public void checkCatIsHungryDefaultValue(){
       //Assert.assertTrue("Default is hungry", cat.isHungry());
        assertTrue("Default is hungry", cat.isHungry());
    }

    @Test
    public void checkCatSetName(){
        String name="mikky";
        cat.setName(name);
        assertEquals(name, cat.getName());
    }
}
