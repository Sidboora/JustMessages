package com.example.JustMessages;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;



    public class algo {
        public static final String algo ="AES";

        //this is byte array for secret key that we provide in main
        private byte[] keyValue;

        public algo(String key)
        {
            //getBytes() will convert key from string to bytes
            keyValue=key.getBytes();

        }

        //this will generate  secret key used for encryption process
        private Key generateKey() throws Exception
        {

            Key key = new SecretKeySpec(keyValue,algo);
            return key;

        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public String encrypt(String msg) throws Exception
        {
            Key key = generateKey();
            Cipher c = Cipher.getInstance(algo);
            c.init(Cipher.ENCRYPT_MODE,key);

            //we will create a byte array which will contain encrypted data in byte form
            byte[] encodedMsg = c.doFinal(msg.getBytes());//doFinal takes input as byte array and decode and return message in bytes
            String encryptedMsg = Base64.getEncoder().encodeToString(encodedMsg); //Getting and converting encoded message to String
            return encryptedMsg;

        }
        @RequiresApi(api = Build.VERSION_CODES.O)
        public String decrypt(String encryptedMsg) throws Exception
        {
            Key key = generateKey();
            Cipher c = Cipher.getInstance(algo);
            c.init(Cipher.DECRYPT_MODE,key);

            //This will get the encrypted message for decoding
            byte[] decodedMsg = Base64.getDecoder().decode(encryptedMsg);
            //this will decode the message and takes byte array as input
            byte[] decMsg = c.doFinal(decodedMsg);
            String decryptedMsg = new String(decMsg); //Converting byte into String
            return decryptedMsg;
        }
}
