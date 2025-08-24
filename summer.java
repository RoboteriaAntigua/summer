//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class summer {
    public static void main(String[] var0) {
        String[] var1 = new String[]{"groovy", "./scripts/create.groovy", var0[0], var0[1]};
        runCommand(var1);
    }

    private static void runCommand(String[] var0) {
        try {
            Process var1 = Runtime.getRuntime().exec(var0);
            BufferedReader var2 = new BufferedReader(new InputStreamReader(var1.getInputStream()));

            String var3;
            while ((var3 = var2.readLine()) != null) {
                System.out.println(var3);
            }
        } catch (IOException var4) {
            System.out.println("Error: " + var4.getMessage());
        }

    }
}
