import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class ExternalIO {
    private final JSONObject params = new JSONObject();

    public ExternalIO() throws FileNotFoundException {
        File file = new File("src/main/resources/parameters.txt");
        Scanner myReader = new Scanner(Objects.requireNonNull(file));
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] split = data.split(":", 2);
            if (split[1].length() == 0) {
                System.out.println("PARAMETER FOR " + split[0] + " IS MISSING");
                continue;
            }
            params.put(split[0], split[1]);
        }
        myReader.close();
    }

    public JSONObject getParams() {
        return params;
    }
}
