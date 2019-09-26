package com.example.googleauth;

import com.google.zxing.WriterException;

import java.io.IOException;
import java.util.Scanner;

import static com.example.googleauth.Utils.getTOTPCode;

public class MainApplication {

    public static void main(String[] args) throws IOException, WriterException {
        String secretKey = "QDWSM3OYBPGTEVSPB5FKVDM3CSNCWHVK";
        String email = "test@gmail.com";
        String companyName = "Awesome Company";
        String barCodeUrl = Utils.getGoogleAuthenticatorBarCode(secretKey, email, companyName);
        System.out.println(barCodeUrl);
        Utils.createQRCode(barCodeUrl, "QRCode.png", 400, 400);

        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        if (code.equals(getTOTPCode(secretKey))) {
            System.out.println("Logged in successfully");
        } else {
            System.out.println("Invalid 2FA Code");
        }

    }

}
