package com.nombrecompania.envioxmlapp.connections;

import com.nombrecompania.envioxmlapp.exceptions.ErrorCerrandoConexionException;
import com.nombrecompania.envioxmlapp.exceptions.ErrorDeConexionException;
import com.nombrecompania.envioxmlapp.exceptions.ErrorEnviandoDatosException;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConexionCliente {
  private Socket socket;

  public ConexionCliente(String IPDeEnvio, Integer puerto) throws ErrorDeConexionException {
      InetAddress ip;
     try {
        ip= InetAddress.getByName(IPDeEnvio);
        socket = new Socket(ip,puerto);
     } catch (UnknownHostException e) {
         throw new RuntimeException(e);
     }catch (IOException e) {
         throw new ErrorDeConexionException(e);
        }
  }

  public void enviarDatos(String datos) throws ErrorEnviandoDatosException {
     try {

     OutputStream os =socket.getOutputStream();
     DataOutputStream osw=new DataOutputStream(os);
     osw.writeUTF(datos);
     osw.flush();
     osw.close();
     os.close();
  } catch (IOException e) {
            throw new ErrorEnviandoDatosException(e);
        }
  }


  public void cerrarConexion() throws ErrorCerrandoConexionException {
    try {
      socket.close();
     } catch (IOException e) {
            throw new ErrorCerrandoConexionException(e);
        }
  }
}
