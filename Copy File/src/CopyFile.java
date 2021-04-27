import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class CopyFile {
    private static void copyFileUsingJava7Files(File source, File dest) throws IOException{
        Files.copy(source.toPath(),dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException{
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] bf = new byte[1024];
            int length;
            while ((length = is.read()) > 0){
                os.write(bf,0,length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);


            File sourceFile = new File("sourcePath.txt");
            File desFile = new File("desPath.txt");
            if (sourceFile.exists()) System.out.println("File already exists.");
            else sourceFile.createNewFile();

            if (desFile.exists()) System.out.println("File already exists.");
            else desFile.createNewFile();

            copyFileUsingJava7Files(sourceFile,desFile);
            System.out.println("Copy completed");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
