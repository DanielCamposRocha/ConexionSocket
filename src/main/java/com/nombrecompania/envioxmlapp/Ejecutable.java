package com.nombrecompania.envioxmlapp;

import com.nombrecompania.envioxmlapp.actions.EnviarXmlAction;
import com.nombrecompania.envioxmlapp.exceptions.ErrorCerrandoConexionException;
import com.nombrecompania.envioxmlapp.exceptions.ErrorDeConexionException;
import com.nombrecompania.envioxmlapp.exceptions.ErrorEnviandoDatosException;
import com.nombrecompania.envioxmlapp.utils.ValidacionUtil;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 */
public class Ejecutable {
    public static void main(String[] args) {
        app();
    }

    private static void app() {
        String IPDeEnvio;
        int puerto;
        String identificador;
        int op;
        InetAddress ip;
        do {
            op=0;
            IPDeEnvio = pedirString("Introduzca IP a la que enviar la extension");
            if(!ValidacionUtil.isValidIp(IPDeEnvio))op++;
        }while(op!=0);
        do{
            op=0;
            puerto=pedirInt("Introduzca puerto de envio");
            if(!ValidacionUtil.isValidPuerto(puerto)){
                op++;
                System.out.println("Recuerde por favor, debe introducir un numero entero entre 0 y 65535");
            }
        }while(op!=0);

        identificador=pedirString("Introduzca identificador");


        try {
          ConexionCliente conexionCliente = new ConexionCliente(IPDeEnvio, puerto);
          new EnviarXmlAction(conexionCliente).enviarXML(identificador);
          conexionCliente.cerrarConexion();
        } catch (RuntimeException ex) {
          System.out.println("Problema enviando el mensaje. " + ex.getMessage());
        } catch (ErrorDeConexionException e) {
            throw new RuntimeException(e);
        } catch (ErrorCerrandoConexionException e) {
            throw new RuntimeException(e);
        } catch (ErrorEnviandoDatosException e) {
            throw new RuntimeException(e);
        }


    }




    public static String pedirString(String textoimpreso){
        Scanner scn=new Scanner(System.in);
        System.out.println(textoimpreso);
        return scn.nextLine();
    }

    public static int pedirInt(String textoimpreso) {
        int comprobacion;
        int lectura=0;
        do{
            comprobacion=0;
            System.out.println(textoimpreso);
            try{
                Scanner scn=new Scanner(System.in);
                lectura=scn.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Recuerde por favor, debe introducir un numero entero");
                comprobacion=1;
            }
        }while(comprobacion==1);
        return lectura;
    }
}
