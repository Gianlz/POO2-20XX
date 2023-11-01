package Junit.calcular;


import junit.framework.TestCase;

public class Tests extends TestCase{
    Calculo calc = new Calculo();
    double[] arrayTeste = new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 4.0, 3.0, 2.0, 1.0};

    public void testeModa(){
        assertEquals(4.0,calc.Moda(arrayTeste));
    }

    public void testeMedia(){
        assertEquals(2.7777777777777777,calc.Media(arrayTeste));
    }

    public void testeMediana(){
        assertEquals(3.0,calc.Mediana(arrayTeste));
    }

    public void testeVariancia(){
        assertEquals(1.7283950617283952,calc.Variancia(arrayTeste));
    }

    public void testeDesvioPadrao(){
        assertEquals(1.314684396244359,calc.DesvioPadrao(arrayTeste));
    }
}
