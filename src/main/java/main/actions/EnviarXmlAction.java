package com.nombrecompania.envioxmlapp.actions;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class EnviarXmlAction {
    private ConexionCliente conexionCliente;
    private static String XML_HEAD = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Msg Name=\"OpenStudies\" Type=\"XA\"><Param Name=\"ProcessId\">"; 
    private static String XML_TAIL = "</Param></Msg>";


    public EnviarXmlAction(ConexionCliente conexionCliente) {
      this.conexionCliente = conexionCliente;
    } 

    /**
     * metodo que envia el xml, una vez recibidos los parametros validados
     * @param ipDeEnvio
     * @param puerto
     * @param identificador
     */
    static String enviarXML(String identificador) {
        StringBuilder xmlEnviable= new StringBuilder(XML_HEAD).append(identificador).append(XML_TAIL);
        
        conexionCliente.enviarXML();
    }


}
