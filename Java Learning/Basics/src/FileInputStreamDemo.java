import java.io.FileInputStream;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("E:\\\\java\\\\new.txt");)
        {
            int i = 0;
            while((i = fis.read()) != -1)
            {
                System.out.print((char) i);
            }

        } catch (Exception e) {
            System.out.println("Some Error occurred");
            throw new RuntimeException(e);
        }
    }
}
