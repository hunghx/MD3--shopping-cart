package ra.config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Config<T> {
    public static Scanner scanner = new Scanner(System.in);
    public static final String PATH_CATALOG = "E:\\JAVACORE\\MD3project\\src\\ra\\dataBase\\Catalog.txt";
    public static final String PATH_CART = "E:\\JAVACORE\\MD3project\\src\\ra\\dataBase\\Cart.txt";
    public static final String PATH_PRODUCT = "E:\\JAVACORE\\MD3project\\src\\ra\\dataBase\\Product.txt";
    public static final String PATH_USER = "E:\\JAVACORE\\MD3project\\src\\ra\\dataBase\\User.txt";
    public static final String PATH_CURRENT_ACCOUNT = "E:\\JAVACORE\\MD3project\\src\\ra\\dataBase\\currentAccount.txt";
    public List<T> readFromFile(String pathFile) {
        List<T> tList = new ArrayList<>();
        try {
            File file = new File(pathFile);
            if (file.exists()){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tList = (List<T>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
            }
        } catch (FileNotFoundException f) {
            System.err.println("File not Found!");
        } catch (EOFException eof){

        }
        catch (IOException i) {
            i.printStackTrace();
            System.err.println("IOE exception!");
        } catch (ClassNotFoundException c) {
            System.err.println("Class not Found!");
        }
        return tList;
    }

    // phuong thuc ghi file
    public void writeToFile(String pathFile, List<T> tList) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(tList);
            fileOutputStream.close();
            objectOutputStream.close();
        }catch (FileNotFoundException f){
            System.err.println("File not Found!");
        }catch (IOException i){
            System.err.println("IOE exception!");
        }
    }
}
