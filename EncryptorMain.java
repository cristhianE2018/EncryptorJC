package EncryptorJC;
import java.security.Key;
import java.util.logging.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;
public class EncryptorMain {

    private static final String ALGO = "AES";
    private byte[] keyValue;

    public EncryptorMain(String key){
        keyValue = key.getBytes();
    }

    public String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE,key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encrytedValue = Base64.getEncoder().encodeToString(encVal);
        return encrytedValue;
    }

    public String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        //byte[] decordedValue = new base64Decoder().decodeBuffer(encryptedData);
        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;

    }
    public Key generateKey(){
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    }
    public static void main(String[] args) {
        Scanner lee = new Scanner(System.in);
        int opcion = 0;
        try{
            EncryptorMain aes = new EncryptorMain("lv39eptlvuhaqqsr");
            String texto = "";
            System.out.println("¿Qué deseas hacer? 1.- Encriptar    2.- Desencriptar");
            opcion = Integer.parseInt(lee.nextLine());
            switch(opcion){
                case 1: 
                        System.out.println("Ingresa texto: ");
                        texto = lee.nextLine();
                        System.out.println("Texto original : "+ texto);   
                        String encdata = aes.encrypt(texto);
                        System.out.println("************************");
                        System.out.println("Datos encriptados: " + encdata);
                        
                break;
                case 2:
                        System.out.println("Ingresa texto encriptado: ");
                        texto = lee.nextLine();
                        System.out.println("Texto encriptado: " + texto);
                        String decdata = aes.decrypt(texto);
                        System.out.println("************************");
                        System.out.println("Texto descencriptado : " + decdata);
                break;
            }
           
        }
        catch(Exception ex) {
            Logger.getLogger(EncryptorMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
