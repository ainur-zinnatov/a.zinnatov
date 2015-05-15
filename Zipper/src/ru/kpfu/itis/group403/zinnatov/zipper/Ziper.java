package ru.kpfu.itis.group403.zinnatov.zipper;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Ziper {
    public static void main(String[] args) {


        String filename ="java.txt";
        try(ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(new File("JavaOutZip.zip")));
            FileInputStream file =new FileInputStream(filename); ) {
            ZipEntry entry = new ZipEntry(filename);
            zipOut.putNextEntry(entry);

            byte[] buffer = new byte[file.available()];
            file.read(buffer);
            zipOut.write(buffer);
            zipOut.closeEntry();
            zipOut.flush();
        }catch (IOException e){
            e.printStackTrace();
        }



        try(ZipInputStream zipInput = new ZipInputStream(new FileInputStream(new File("/java/JavaOutZip.zip")));
            DataOutputStream datOut = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("/java/file.txt")))) {
            String name;

            ZipEntry zip;
            while ((zip = zipInput.getNextEntry())!=null){
                if(zip.isDirectory()){
                    new File("java/pfp").mkdir();

                }
                byte[] buff = new byte[1024];
                zipInput.read(buff);
                datOut.write(buff);
                name = zip.getName();
                System.out.println(name);
                datOut.close();

                zipInput.closeEntry();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
