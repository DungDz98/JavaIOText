package exercise1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int count = docFile();
        ghiFile(count);
    }

    public static int docFile() throws IOException {
        File sf = new File("./src/exercise1/sourceFile.txt");
        BufferedReader br = null;
        int count = 0;
        try {
            br = new BufferedReader(new FileReader(sf));
            String line = "";
            while ((line = br.readLine()) != null) {
                list.add(line);
                String[] str = line.split("");
                for (String c : str) {
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File khong ton tai hoac bi loi!");
        } finally {
            br.close();
        }
        return count;
    }

    public static void ghiFile(int count) throws IOException {
        File cf = new File("./src/exercise1/copyFile.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(cf));
        for (String c : list) {
            bw.write(c);
            bw.newLine();
        }
        bw.write("So ky tu la: " + count);
        bw.close();
    }
}
