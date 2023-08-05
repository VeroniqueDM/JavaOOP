package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ToyStoryTest {
    //TODO: Write your tests here

    private ToyStore toyStore;
    private Toy toy;


    @Before
    public void setUp() throws Exception {
        toyStore = new ToyStore();
        toy = new Toy("lego", "1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyWrongShelf() throws IllegalArgumentException, OperationNotSupportedException {
        toyStore.addToy("H", toy);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddToyShelfTaken() throws IllegalArgumentException, OperationNotSupportedException {
        toyStore.addToy("G", toy);
        Toy toy1 = new Toy("lego2", "2");
        toyStore.addToy("G", toy1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddToyWhenToyExists() throws IllegalArgumentException, OperationNotSupportedException {
        toyStore.addToy("G", toy);
        toyStore.addToy("F", toy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyWrongShelf() throws IllegalArgumentException {
        toyStore.removeToy("H", toy);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyWhenToyNotThere() throws IllegalArgumentException, OperationNotSupportedException {
        toyStore.addToy("G", toy);
        Toy toy1 = new Toy("lego2", "2");
        toyStore.addToy("D", toy1);
        toyStore.removeToy("D",toy);
    }

    @Test
    public void testAddToyValidData() throws OperationNotSupportedException {
        Assert.assertEquals(toyStore.addToy("G", toy),"Toy:1 placed successfully!");
        Assert.assertEquals(toy,toyStore.getToyShelf().get("G"));
    }
    @Test
    public void testRemoveToyValidData() throws OperationNotSupportedException {
        toyStore.addToy("G", toy);
        Assert.assertEquals(toyStore.removeToy("G", toy),"Remove toy:1 successfully!");
        Assert.assertNull(toyStore.getToyShelf().get("G"));
    }
}