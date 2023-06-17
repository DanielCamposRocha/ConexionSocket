package com.nombrecompania.envioxmlapp;

import com.nombrecompania.envioxmlapp.actions.EnviarXmlAction;
import com.nombrecompania.envioxmlapp.connections.ConexionCliente;
import com.nombrecompania.envioxmlapp.exceptions.ErrorDeConexionException;
import com.nombrecompania.envioxmlapp.exceptions.ErrorEnviandoDatosException;
import org.junit.jupiter.api.Test;


class EnviarXmlActionTest {
    /**
     * En este caso, es necesario correr en primer lugar ServerITTest de esta forma hay un servidor
     * levantado que pueda recibir los datos enviados. El auténtico test se realizará en la clase ServerITTest
     * ya que alli se comprueba que los datos recibidos son los correctos
     */
    ConexionCliente conex;
    @Test
    void envioDatosCorrectos() throws ErrorEnviandoDatosException, ErrorDeConexionException {
        conex=new ConexionCliente("127.0.0.1",45000);
        EnviarXmlAction envio= new EnviarXmlAction(conex);
        envio.enviarXML("prueba");
    }
    @Test
    void envioDatosInCorrectos() throws ErrorEnviandoDatosException, ErrorDeConexionException {
        conex=new ConexionCliente("127.0.0.1",45000);
        EnviarXmlAction envio= new EnviarXmlAction(conex);
        envio.enviarXML("no pasa prueba");
    }


}