import java.io.*;

public class ReadAndWriteFIleMax {
    public static int readFile() throws IOException {
        File file = new File("./src/fileMax.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = "";
        int max = 0;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            if (max < Integer.parseInt(line)) {
                max = Integer.parseInt(line);
            }
        }
        br.close();
        return max;
    }

    public static void writeFile(int max) throws IOException {
        File file1 = new File("./src/result.txt");
        if (!file1.exists()) {
            file1.createNewFile();
        };
        BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
        bw.write("Gia tri lon nhat la: " + max);
        bw.close();
    }
    public static void main(String[] args) throws IOException {
        int max = ReadAndWriteFIleMax.readFile();
        ReadAndWriteFIleMax.writeFile(max);
    }
}
