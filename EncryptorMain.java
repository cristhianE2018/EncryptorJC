package EncryptorJC;

public class EncryptorMain {


    public String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new base64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;

    }
    public static void main(String[] args) {
        try{
            AESExample aes = new AESExample("lv39eptlvuhaqqsr");
            String encdata = aes.encrypt("ola k ase");
            System.out.println("Datos encriptados: " + encdata);
            String decdata = aes.decrypt(encdata);
            System.out.println("Datos desencriptados: " + decdata);
        }
        catch(Exception ex) {
            Logger.getLogger(AESExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
