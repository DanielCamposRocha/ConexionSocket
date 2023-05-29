package com.nombrecompania.envioxmlapp;

public class ConexionCliente {
  private Socket socket;

  public ConexionCliente(IP ip, Integer puerto) {
     try {
            socket = new Socket(ipDeEnvio,puerto);           
        } catch (IOException e) {
            throw new ErrorCreandoConexion(e);
        }
  }

  public enviarDatos(String datos) {
     try {

     OutputStream os =socket.getOutputStream();
            DataOutputStream osw=new DataOutputStream(os);
            osw.writeUTF(xmlEnviable);
            osw.flush();
            osw.close();
            os.close();
  } catch (IOException e) {
            throw new ErrorEnviandoDatos(e);
        }
  }


  public cerrarConexion() {
    try {
      socket.close();
     } catch (IOException e) {
            throw new ErrorCerrandoConexion(e);
        }
  }
}
