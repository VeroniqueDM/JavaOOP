package robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ServiceTests {
    private Service service;


    @Before
    public void setUp() throws Exception {
        service = new Service("SomeName", 15);

    }

    @Test(expected = NullPointerException.class)
    public void testConstructorWithInvalidName() throws NullPointerException {
        Service service1 = new Service(" ", 12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidCapacity() throws IllegalArgumentException {
        Service service1 = new Service("Hi", -1);
    }

    @Test
    public void testTestGetName() {
        Assert.assertEquals("SomeName", service.getName());
    }

    @Test
    public void testGetCapacity() {
        Assert.assertEquals(15, service.getCapacity());
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(0, service.getCount());
        service.add(new Robot("Pesho"));
        Assert.assertEquals(1, service.getCount());
    }

    @Test
    public void testAdd() {
        service.add(new Robot("Pesho"));
        Assert.assertEquals(1, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithInvalidCapacity() throws IllegalArgumentException {
        Service service1 = new Service("Hi", 1);
        service1.add(new Robot("Pesho"));
        service1.add(new Robot("Gosho"));
    }

    public void testRemove() {
        service.add(new Robot("Pesho"));
        Assert.assertEquals(1, service.getCount());

        service.add(new Robot("Gosho"));
        service.add(new Robot("Misho"));
        Assert.assertEquals(3, service.getCount());

        service.remove("Gosho");
        Assert.assertEquals(2, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveWithInvalidName() throws IllegalArgumentException {
        service.add(new Robot("Pesho"));
        Assert.assertEquals(1, service.getCount());

        service.add(new Robot("Misho"));
        Assert.assertEquals(2, service.getCount());

        service.remove("Gosho");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForSaleWithInvalidName() throws IllegalArgumentException {
        service.add(new Robot("Pesho"));
        Assert.assertEquals(1, service.getCount());

        service.add(new Robot("Misho"));
        Assert.assertEquals(2, service.getCount());

        service.forSale("Gosho");
    }

    @Test
    public void testForSaleWithValidArgs() {
        Robot robotOne = new Robot("Pesho");
        Robot robotTwo = new Robot("Gosho");
        Robot robotThree = new Robot("Misho");
        service.add(robotOne);
        Assert.assertEquals(1, service.getCount());

        service.add(robotTwo);
        service.add(robotThree);
        Assert.assertEquals(3, service.getCount());


        Assert.assertFalse(service.forSale("Gosho").isReadyForSale());
    }

    @Test
    public void testReport() {
        service.add(new Robot("Pesho"));
        Assert.assertEquals("The robot Pesho is in the service SomeName!", service.report());
    }
}
