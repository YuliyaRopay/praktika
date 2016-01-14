package day10.junit;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class HousewifeTest {

    private Cat[] cats;
    private Housewife housewife;

    @Before
    public void init(){
        housewife=new Housewife();
        cats=new Cat[2];
        cats[0]=new Cat();
        cats[0].setName("mikky0");
        cats[1]=new Cat();
        cats[1].setName("mikky1");

    }

    @Test
    public void testFeedCats(){
        housewife.feed(cats);
        for(Cat cat : cats){
            assertFalse(cat.isHungry());
        }
    }

    @Test(expected = CatNotHungryException.class)
    public void testCatNotHungryException(){
        cats[1].setName("mikky2");
        cats[1].setHungry(false);

        housewife.feed(cats);
        for(Cat cat : cats){
            assertFalse(cat.isHungry());
        }
    }
}
