import java.io.IOException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Summer {

    public static void main(String[] args) {

        String[] start = {"groovy", "./scripts/create", args[0], args[1]}; // Fix with dependencys

        runCommand(start);

    }

    /**
     * No Output Capture: Runtime.exec() runs commands in a separate process but doesn't display their output in your Java console.
     * The echo hola and ls a outputs go to their own process streams, which aren't connected to your terminal.
     *
     * @param command
     */
    private static void runCommand(String[] command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}