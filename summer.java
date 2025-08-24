import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class summer {
    public static void main(String[] var0) {
        String[] commandString = new String[]{};

        if (var0.length == 3) {
            commandString = new String[]{"groovy", "./scripts/create.groovy", var0[0], var0[1], var0[2]};
        }

        if (var0.length == 2) {
            commandString = new String[]{"groovy", "./scripts/create.groovy", var0[0], var0[1]};
        }

        if (var0.length < 2) {
            System.out.println("Use mode: groovy create.groovy <Name> -all -nosql (optional for no sql db)");
            System.out.println("options: -all -c -e -dto -rep -s");
            return;
        }

        runCommand(commandString);
    }

    private static void runCommand(String[] var0) {
        try {
            Process scriptProcess = Runtime.getRuntime().exec(var0);
            BufferedReader scriptOutput = new BufferedReader(new InputStreamReader(scriptProcess.getInputStream()));

            String line;
            while ((line = scriptOutput.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }
}
