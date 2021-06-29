package exercise2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestCountry {
    static List<Country> list = new ArrayList<>();
    static File country = new File("./src/exercise2/country.csv");
    public static void main(String[] args) throws IOException {
        docFile();
        for (Country c : list) {
            System.out.println(c);
        }
    }

    public static void docFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(country));
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] str = line.split(",");
            if (str.length >= 3) {
                list.add(new Country(Integer.parseInt(str[0]), str[1], str[2]));
            }
        }
        br.close();
    }
}
