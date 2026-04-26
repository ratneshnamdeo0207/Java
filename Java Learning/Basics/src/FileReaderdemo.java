//import java.io.File;
//import java.util.Scanner;
//
//public class FileReaderdemo {
//    public void displayFiles()
//    {
//        File f = new File("E:\\\\java");
//        String [] a = f.list();
//
//        if (a != null) {
//            for(String o : a)
//            {
//                System.out.println(o);
//            }
//        }
//    }
//    public void readFile(String name)
//    {
//        try{
//            File f = new File("E:\\\\java\\\\"+name);
//            Scanner sc = new Scanner(f);
//            while(sc.hasNextLine())
//            {
//                System.out.println(sc.nextLine());
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public static void main(String[] args) {
//        FileReaderdemo fr = new FileReaderdemo();
//        fr.displayFiles();
//        fr.readFile("new.txt");
//    }
//}
