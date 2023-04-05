package iotextfile;

import java.io.*;

import java.util.ArrayList;

public class IOTextFile<T> {
    private ArrayList<T> arrayList;

    public IOTextFile() {
        arrayList = new ArrayList<>();
    }


    public ArrayList<T> readFile(String path) {

        ArrayList<T> arrayList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            if (fileInputStream.available() > 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                arrayList = (ArrayList<T>) objectInputStream.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return arrayList;
    }

    public void writeFile(ArrayList<T> list, String path) {

        try (ObjectOutputStream objectOutputStream
                     = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(list);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}