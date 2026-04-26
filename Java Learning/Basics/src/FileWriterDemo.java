//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Scanner;
//
//public class FileWriterDemo {
//    public void createFile(String filename)
//    {
//        try {
//            FileWriter fw = new FileWriter("E:\\java\\" + filename, true);
//            // true - is used to enable append
//
//            Scanner sc = new Scanner(System.in);
//
//            System.out.println("What you wanna write ");
//            String s = sc.nextLine();
//            File f = new File(String.valueOf(fw));
//            if(f.length() > 0)
//            {
//                fw.write("\n" + s);
//            }else{
//                fw.write(s);
//            }
//
//
//            fw.close();
//            System.out.println("File created successfully");
//        } catch (IOException e) {
//            System.out.println("Some error occurred");
//            e.printStackTrace();
//        }
//    }
//    public static void main(String[] args) {
//        FileWriterDemo f = new FileWriterDemo();
//        f.createFile("new.txt");
//
//
//    }
//}
