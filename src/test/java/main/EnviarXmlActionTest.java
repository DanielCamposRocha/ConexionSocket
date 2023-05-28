package main;

import org.junit.jupiter.api.Test;
import java.net.InetAddress;
import java.net.UnknownHostException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EnviarXmlActionTest {
    /**
     * En este caso, es necesario correr en primer lugar ServerITTest de esta forma hay un servidor
     * levantado que pueda recibir los datos enviados
     */

    @Test
    void enviarXmlCorrecto() throws UnknownHostException {
        InetAddress ip= InetAddress.getByName("127.0.0.1");
        assertEquals("Extensión enviada correctamente",EnviarXmlAction.enviarXML(ip,45000, "prueba"));
    }

    @Test
    void enviarXmlPuertoINCorrecto() throws UnknownHostException {
        InetAddress ip= InetAddress.getByName("127.0.0.1");
        assertEquals("La conexion no se ha podido establecer",EnviarXmlAction.enviarXML(ip,50000, "prueba"));
    }

    @Test
    void enviarXmlIPINCorrecta() throws UnknownHostException {
        InetAddress ip= InetAddress.getByName("250.0.0.1");
        assertEquals("La conexion no se ha podido establecer",EnviarXmlAction.enviarXML(ip,45000, "prueba"));
    }
}
/**
 * si quisiera controlar una excepcion sin controlar
 * @Test
 *     void enviarXmlIPINCorrecta() throws UnknownHostException {
 *         InetAddress ip= InetAddress.getByName("250.0.0.1");
 *         assertThrows(RuntimeException.class,()->EnviarXmlAction.enviarXML(ip,45000, "prueba"));
 *     }
 */