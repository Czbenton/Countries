import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Countries {
    public static void main(String[] args) throws Exception {

        String previousChar = "#";
        List<Country> countryList = new ArrayList<>();
        Map<String, List<Country>> countryMap = new HashMap<>();

        File f = new File("countries.txt");
        Scanner fileScanner = new Scanner(f);

        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Country country = new Country((columns[1]), columns[0]);

            if (country.getName().startsWith(previousChar)) {
                countryList.add(country);
                countryMap.put(previousChar, countryList);
            } else {
                previousChar = country.getName().substring(0, 1);
                countryList = new ArrayList<>();
                countryList.add(country);
                countryMap.put(previousChar, countryList);
            }
        }
        
        System.out.println("Please enter a letter");
        Scanner scanner = new Scanner(System.in);

        boolean promptAgain = true;
        while (promptAgain) {
            String userInput = scanner.nextLine();
            if (!(userInput.isEmpty() || userInput.length() >= 2)) {

                List newFile = countryMap.get(userInput);

                writeFile(userInput + "_countries.txt", newFile.toString());
                System.out.println("Your file has been created!!");
                promptAgain = false;
            } else {
                System.out.println("bad input\nPlease enter a letter");
            }
        }
    }

    static void writeFile(String fileName, String fileContent) throws IOException {
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(fileContent);
        fw.close();
    }
}
