package AnimalsTests;

import oop.Dog;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DogTests {
    @Test
    public void checkDogName(){
        Dog dog = new Dog("Azor");

        Assert.assertEquals(dog.getName(), "Azor");
    }
}
