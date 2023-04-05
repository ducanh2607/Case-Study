package iotextfile;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class IOTextFiles<k, v> {
    private HashMap<k,v> hashMap;
    public IOTextFiles() {
        hashMap = new HashMap<>();
    }
    public HashMap<k,v> readFile(String path) {

        HashMap<k,v> hashMap1 = new HashMap<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            if (fileInputStream.available() > 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                hashMap1 = (HashMap<k,v>) objectInputStream.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return hashMap1;
    }

    public void writeFile(HashMap<k,v> list, String path) {

        try (ObjectOutputStream objectOutputStream
                     = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(list);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
