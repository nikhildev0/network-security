/*Program to Encrypt a message using OTP*/

import java.nio.charset.Charset;
import java.util.*;
import java.io.*;

public class OTPenc {
    String plainText,possible;
    Scanner scan,scan1;
    Charset charSet;

    OTPenc() {
        possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$!%^&*()~_";
        Charset charSet = Charset.forName("UTF-8");
        plainText = new String();
    }
    public void otpEncrypt() throws Exception{
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);
        Charset charSet = Charset.forName("UTF-8");
        OTPgen kg=new OTPgen();
        System.out.println("Enter length of message");
        int lm = scan1.nextInt();
        System.out.println("Enter message");
        plainText = scan.nextLine();
        if(lm != plainText.length()) //exit if lengths do not match
        {
            System.out.println("Length is not matching...Quit");
            System.exit(1);
        }
        kg.otpGenKey(lm);
        byte[] plainBytes = plainText.getBytes(charSet);
        byte[] cipherBytes = new byte[plainBytes.length];
        for (int i = 0; i < plainBytes.length; i++) {
            cipherBytes[i] = (byte) (plainBytes[i] ^ kg.keyBytes[i]);
        }
        String cipherText = new String(cipherBytes,charSet);
        FileWriter f1;

        f1 = new FileWriter("OTPctext.txt");

        BufferedWriter wr1 = new BufferedWriter(f1);
        System.out.println("First output : ");
        System.out.println(cipherText);
        System.out.println(cipherBytes);
        System.out.println("last form.");

        for(int i=0;i<plainBytes.length;i++)
        {

            System.out.println(String.format("%02X ", cipherBytes[i]));
            wr1.write(String.format("%02X", cipherBytes[i]));
        }
        wr1.close();

    }	

    public static void main (String args[]) throws Exception
    {
        OTPenc enc=new OTPenc();
        enc.otpEncrypt();
    }

}
