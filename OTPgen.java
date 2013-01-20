/*Program to generate random key in OTP*/

import java.nio.charset.Charset;
import java.util.*;
import java.io.*;

public class OTPgen{

    String plainText,possible,key;
    Charset charSet;
    byte[] keyBytes;


    OTPgen(){
        possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$!%^&*()~_";
        Charset charSet = Charset.forName("UTF-8");
    }

    public void otpGenKey(int lm) throws Exception{               
        String text = "";
        Charset charSet = Charset.forName("UTF-8");   

        for( int i=0; i < lm; i++ )
            text += possible.charAt((int) Math.floor(Math.random() * possible.length()));

        key = text;
        keyBytes = key.getBytes(charSet);
        System.out.println("Key is "+key);
        FileWriter f2;
        f2 = new FileWriter("OTPkey.txt");
        BufferedWriter wr2 = new BufferedWriter(f2);
        wr2.write(key);
        wr2.newLine();
        wr2.close();
    }	
}
