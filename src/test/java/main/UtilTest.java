package main;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void testisValidPuerto() {
        assertTrue(Util.isValidPuerto(0));
        assertTrue(Util.isValidPuerto(32500));
        assertTrue(Util.isValidPuerto(65535));
        assertFalse(Util.isValidPuerto(-1));
        assertFalse(Util.isValidPuerto(65536));
    }

    @Test
    void testisValidIp() {
        assertTrue(Util.isValidIp("192.168.0.1"));
        assertTrue(Util.isValidIp("10.0.0.12"));
        assertTrue(Util.isValidIp("172.10.0.0"));
        assertTrue(Util.isValidIp("127.0.0.1"));
    }

    @Test
    public void testInvalidIp() {
         assertFalse(Util.isValidIp(""));//valor vacio
         assertFalse(Util.isValidIp("256.0.0.1")); // Primer número fuera de rango
         assertFalse(Util.isValidIp("255.256.255.255"));//segundo numero fuera de rango
         assertFalse(Util.isValidIp("255.255.256.255"));//tercer numero fuera de rango
         assertFalse(Util.isValidIp("255.255.255.256"));//ultimo numero fuera de rango
         assertFalse(Util.isValidIp("192.168.0")); // Faltan números
         assertFalse(Util.isValidIp("192.168.0.1.2")); // Sobran números
         assertFalse(Util.isValidIp("192.-1.0.1")); // Número negativo
    }

    /**
     *Aquí se lanza una NumberFormatException que se captura y se devuelve un false, mostrando un mensaje
     * por pantalla que indica que se debe introducir la ip en formato decimal
     */
    @Test
    public void testInvalidIPFormat(){
        assertFalse(Util.isValidIp("192.168..0.1"));//dos puntos entre numeros
        assertFalse(Util.isValidIp("192.1680.1"));//falta un punto
        assertFalse(Util.isValidIp("abc.168.0.1"));//letras en la primera posicion
        assertFalse(Util.isValidIp("192.abc.0.1"));//letras en la segunda posicion
        assertFalse(Util.isValidIp("192.168.a.1"));//letras en la tercera posicion
        assertFalse(Util.isValidIp("192.168.0.1a1"));//letras en la cuarta posicion*/
    }

    /**
     * se comprueba que se lanza la excepcion numberFormatException
     */
    @Test
    public void testInvalidIPTextFormat(){
          assertThrows(NumberFormatException.class,()->Util.isValidIp("abc.168.0.1"));

    }
}