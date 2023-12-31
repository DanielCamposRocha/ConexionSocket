package com.nombrecompania.envioxmlapp.actions;

import com.nombrecompania.envioxmlapp.connections.ConexionCliente;
import com.nombrecompania.envioxmlapp.exceptions.ErrorEnviandoDatosException;


public class EnviarXmlAction {
    private ConexionCliente conexionCliente;
    private final static String XML_HEAD = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Msg Name=\"OpenStudies\" Type=\"XA\"><Param Name=\"ProcessId\">";
    private final static String XML_TAIL = "</Param></Msg>";


    public EnviarXmlAction(ConexionCliente conexionCliente) {
      this.conexionCliente = conexionCliente;
    } 

    /**
     * metodo que envia el xml, una vez recibidos los parametros validados
     *
     * @param identificador
     */
    public void enviarXML(String identificador) throws ErrorEnviandoDatosException {
        StringBuilder xmlEnviable= new StringBuilder(XML_HEAD).append(identificador).append(XML_TAIL);
        conexionCliente.enviarDatos(xmlEnviable.toString());

    }


}
