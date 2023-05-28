package main;


public class Util {
    /**
     * válida el número de puerto, tiene que estar entre 0 y 65535
     * @param puerto
     * @return
     */
    static boolean isValidPuerto(int puerto) {
        return !(puerto < 0 | puerto > 65535);
    }

    /**
     * válida la ip, como no se tienen datos de restricciones se válida
     * sobre cualquier IP4 válida, cuatro grupos de cifras entre 0 y 255
     * separados por .
     * @param ipDeEnvio
     * @return
     */
    static boolean isValidIp( String ipDeEnvio) {
        String[] numIP=ipDeEnvio.split("\\.");
        if(numIP.length !=4) return false;
        try {
            for (String numero : numIP
            ) {
                if (Integer.parseInt(numero) < 0 | Integer.parseInt(numero) > 255) return false;
            }
            return true;
        }catch (NumberFormatException e){
            System.out.println("Formato no valido: Por favor recuerde que la ip debe estar en formato de numeros decimales");
            return false;
        }
    }
}
