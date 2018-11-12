package com.example.novi.temperature;


import org.junit.*;
import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ConverterTest {

    private Converter conv;
    private double min = 0.0;
    private  double max = 100.0;

    @Before
    public void initBlankClass(){
        conv = new Converter();
    }

    @Test
    public void firstConstructorTest(){
        assertEquals(0.0, conv.getCelcius(),0);
    }

    @Test
    public void secondConstructorTest(){
        double x = (Math.random()*((max-min)+1))+min;
        conv = new Converter(x);
        assertEquals(x, conv.getCelcius(),0);
    }

    @Test
    public void variableTest() throws NoSuchFieldException, SecurityException {
        // Get "temperature" variable
        Field f1 = conv.getClass().getDeclaredField("temperature");// variable 1
        // Check the number of variables in author class.
        Field[] f = conv.getClass().getDeclaredFields();
        assertEquals(1, f.length);
        // Check data type for each variable
        assertEquals(f1.getType(), double.class);
    }

    @Test
    public void methodsNameTest() throws NoSuchMethodException, SecurityException {
        // Check the number of methods in author class.
        Method[] m = conv.getClass().getDeclaredMethods();
        assertEquals(4, m.length);
        // Check method name
        Class[] cArg = new Class[1];
        cArg[0] = double.class;
        Method m1 = conv.getClass().getDeclaredMethod("setTemperature", cArg);// method
        Method m2 = conv.getClass().getDeclaredMethod("getCelcius");// method
        Method m3 = conv.getClass().getDeclaredMethod("getFahrenheit");// method
        Method m4 = conv.getClass().getDeclaredMethod("getKelvin",null);// method
        // check data type for each Method
        assertEquals(Void.TYPE, m1.getReturnType());
        assertEquals(double.class, m2.getReturnType());
        assertEquals(double.class, m3.getReturnType());
        assertEquals(double.class, m4.getReturnType());
    }

    @Test
    public void toFarenheitTest(){
        double x = (Math.random()*((max-min)+1))+min;
        conv.setTemperature(x);
        assertEquals((x*1.8)+32.0, conv.getFahrenheit(),0);
    }

    @Test
    public void toKelvinTest(){
        double x = (Math.random()*((max-min)+1))+min;
        conv.setTemperature(x);
        assertEquals(x+273.15, conv.getKelvin(),0);
    }

}
