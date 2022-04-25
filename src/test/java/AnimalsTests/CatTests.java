package AnimalsTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import oop.Cat;

public class CatTests {
    @BeforeMethod
    public void setupMethod(){
        System.out.println("Uruchamiam kolejną metodę");
    }

    @AfterMethod
    public void teardownMethod(){
        System.out.println("Kończę metodę testową");
    }

    @BeforeClass
    public void printBeforeRuningClass(){
        System.out.println("Przygotowuję środowisko");
    }

//    Powyższe metody są uruchamiane adekwatnie do adnotacji Before/After czyli przed/po uruchomieniu klasy/metody
//    mogą posłużyć do celów przygotowania/uprzątnięcia środowiska lub debugowych (logowanie)

    @Test
    public void checkCatString(){
        Cat cat = new Cat("Mruczek");

        Assert.assertEquals(cat.toString(), "Kot | nazwa=Mruczek");
//        if(cat.toString().equals(".....")){
//
//        } else {
//
//        }
//        Powyższa asercja (assertEquals) odpowiada przedstawionej sekwencji if/else. Asercje służą do upenwniania się
//        że jakiś warunek jest spełniony - czyli do tego co jest istotą testowania. Każdy test powinien kończyć się
//        asercją lub inną metodą która zakończy się błędem jeśli aplikacja nie będzie działać tak jak tego oczekiwaliśmy
    }

    @Test(description = "To jest opis testu", dependsOnMethods = {"catIsCreated"})
//    Tutaj pojawia się zależność (dependencja - depends) od innej metody. Czasem uruchomienie jakiejś metody nie ma
//    sensu, jeśli inna zakończyła się niepowodzeniem
    public void checkCatVoice(){
        Cat cat = new Cat("Filemon");

        Assert.assertEquals(cat.useVoice(), "Meow");
    }

    @Test(enabled = false)
//  Mogą przytrafić się sytuacje, kiedy uruchamianie testu nie ma sensu - nie jest dokończony, czasowo jakaś
//  funkcjonalność nie działą, lub zawiera błędy, wtedy możemy wyłączyć test wykorzystująć 'enabled=false'
//  zawsze warto dodać komentarz, któr będzie opisywał dlaczego dany test jest wyłączony
    public void displaySomething(){
        System.out.println("something");
        boolean isTrue = true;

        Assert.assertTrue(isTrue);
    }

    @Test(priority = 1)
//    Domyślnie testy są uruchamiane w kolejności alfabetycznej. Jeśli zależy nam na innej kolejności, najlepiej
//    skorzystać z priorytetów, lub zależności. To drugie rozwiązanie jednak wiąże się również z niewykonaniem
//    testów jeśli te, na których bazują zakończą się niepowodzeniem.
    public void catIsCreated(){
        Cat cat = new Cat("Filemon");

        Assert.assertNotNull(cat);
    }
}
