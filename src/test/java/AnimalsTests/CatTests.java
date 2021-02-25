package AnimalsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import oop.Cat;

public class CatTests {
    @Test
    public void checkCatString(){
        Cat cat = new Cat("Mruczek");

        Assert.assertEquals(cat.toString(), "Kot | nazwa=Mruczek");
    }

    @Test(description = "To jest opis testu")
    public void checkCatVoice(){
        Cat cat = new Cat("Filemon");

        Assert.assertEquals(cat.useVoice(), "Meow");
    }
}
