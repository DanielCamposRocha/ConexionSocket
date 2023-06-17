package com.nombrecompania.envioxmlapp;

import com.nombrecompania.envioxmlapp.actions.EnviarXmlAction;
import com.nombrecompania.envioxmlapp.connections.ConexionCliente;
import com.nombrecompania.envioxmlapp.exceptions.*;
import com.nombrecompania.envioxmlapp.utils.ValidacionUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 */
public class Ejecutable {
    public static void main(String[] args) {
        app(args);
    }

    private static void app(String[] args) {
        String IPDeEnvio;
        int puerto;
        String identificador;
        int op;
        if(args.length>0){
            try{
            IPDeEnvio = args[0];
            puerto=Integer.parseInt(args[1]);
            identificador=args[2];
            if(!ValidacionUtil.isValidIp(IPDeEnvio))  throw new IPInvalidaException("La IP no es válida");
            if(!ValidacionUtil.isValidPuerto(puerto)) throw  new PuertoInvalidoException("El puerto no es válido");
            } catch (IPInvalidaException | PuertoInvalidoException e) {
                System.err.println("Argumento invalido "+e.getMessage());
                throw new RuntimeException();
            }
        }else{
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
            identificador=pedirString("Introduzca identificador");}
        try {
          ConexionCliente conexionCliente = new ConexionCliente(IPDeEnvio, puerto);
          new EnviarXmlAction(conexionCliente).enviarXML(identificador);
          conexionCliente.cerrarConexion();
        } catch (RuntimeException ex) {
          System.out.println("Problema enviando el mensaje. " + ex.getMessage());
        } catch (ErrorDeConexionException e) {
            System.out.println("Problema creando la conexión. "+ e.getMessage());
        } catch (ErrorCerrandoConexionException e) {
            System.out.println("Problema cerrando la conexión. "+ e.getMessage());
        } catch (ErrorEnviandoDatosException e) {
            System.out.println("Problema enviando los datos. "+ e.getMessage());
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
