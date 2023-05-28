package main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class EnviarXmlAction {
    /**
     * metodo que envia el xml, una vez recibidos los parametros validados
     * @param ipDeEnvio
     * @param puerto
     * @param identificador
     */
    static String enviarXML(InetAddress ipDeEnvio, int puerto, String identificador) {
        String xmlEnviable="<?xml version=\"1.0\" encoding=\"UTF-8\"?><Msg Name=\"OpenStudies\" Type=\"XA\"><Param Name=\"ProcessId\">"+identificador+"</Param></Msg>";
        Socket socket;
        try {
            socket = new Socket(ipDeEnvio,puerto);
            OutputStream os =socket.getOutputStream();
            DataOutputStream osw=new DataOutputStream(os);
            osw.writeUTF(xmlEnviable);
            osw.flush();
            osw.close();
            os.close();
            socket.close();
            return "Extensión enviada correctamente";

        } catch (IOException e) {
            return "La conexion no se ha podido establecer";
        }
    }


}
