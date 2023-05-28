package main;

import org.junit.jupiter.api.Test;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServerITTest {
    @Test
    void recepcionServerCorrecto() throws IOException {
        ServerSocket serverSocket = new ServerSocket(45000);
        Socket clientSocket = serverSocket.accept();
        InputStream inputStream = clientSocket.getInputStream();
        DataInputStream dis = new DataInputStream(inputStream);
        String extension = dis.readUTF();
        if (extension != null && !extension.isEmpty()) {
            System.out.println(extension);
        } else {
            System.out.println("No se ha recibido la extensión o ha ocurrido un error.");
        }
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Msg Name=\"OpenStudies\" Type=\"XA\"><Param Name=\"ProcessId\">prueba</Param></Msg>",extension);
        dis.close();
        inputStream.close();
        clientSocket.close();
        serverSocket.close();
    }
}
