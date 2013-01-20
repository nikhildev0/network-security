/*Program to Decrypt the message using OTP*/
import java.nio.charset.Charset;
import java.util.*;
import java.io.*;

public class OTPdec {

    public static void main(String[] args)throws Exception {

        Scanner decrypt = new Scanner(System.in);
        Charset charSet = Charset.forName("UTF-8");
        System.out.println("Enter file that contains the ciphertext ?");
        String s1 = decrypt.nextLine();
        System.out.println("Enter Key");
        String s2 = decrypt.nextLine();
        FileInputStream fstream = new FileInputStream(s1);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String s = new String();
        byte[] keyBytes = s2.getBytes(charSet);

        while ((s = br.readLine()) != null)   {

            int len = s.length();
            byte[] data = new byte[len / 2];
            for (int i = 0; i < len; i += 2) {
                data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                        + Character.digit(s.charAt(i+1), 16));
            }

            System.out.println("byte array data");

            for(int i=0;i<data.length;i++)
            {
                System.out.print(String.format("%02X ", data[i]));

            }

            //xoring cipher and key
            byte [] plainBytes = new byte[keyBytes.length];
            for (int i = 0; i < keyBytes.length; i++) {

                plainBytes[i] = (byte) (data[i] ^ keyBytes[i]);
            }

            String plainText = new String(plainBytes, charSet);
            System.out.println("      ");
            //System.out.println("Message : "+plainText);
            FileWriter f2;
            f2 = new FileWriter("OTPdtext.txt");
            BufferedWriter wr2 = new BufferedWriter(f2);
            wr2.write(plainText);
            wr2.newLine();
            wr2.close();

        }




    }

}
