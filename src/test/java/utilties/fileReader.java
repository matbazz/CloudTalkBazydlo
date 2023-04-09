package utilties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class fileReader {

        public static List<String> getDataFromFile(){
            List<String> list = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/testData.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    list.add(line);
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
            return list;
        }
}
