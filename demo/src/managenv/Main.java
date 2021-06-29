package managenv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
        static List<NhanVien> list = new ArrayList<>();
        static File nhanVien = new File("./src/managenv/nhanVien.txt");

    public static void main(String[] args) throws IOException {
        docFile();
        for (NhanVien nv : list) {
            System.out.println(nv);
        }
        list.add(new NhanVien("Nam5555555", 18, "nam", "0988788", 10));
        ghiFile();

    }

    public static void docFile() throws IOException {
        FileReader fileReader = new FileReader(nhanVien);
        BufferedReader br = new BufferedReader(fileReader);
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] str = line.split(",");
            if (str.length >= 5) {
                list.add((new NhanVien(str[0], Integer.parseInt(str[1].trim()), str[2].trim(), str[3].trim(), Double.parseDouble(str[4].trim()))));
            }
        }
        br.close();
    }

    public static void ghiFile() throws IOException {
        FileWriter fileWriter = new FileWriter(nhanVien);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        for (NhanVien nv : list) {
            bw.write(nv.ghi());
            bw.newLine();
        }
        bw.close();
    }
}
