package ua.in.SmartHome.util;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class CloneMaker<T> {

    public CloneMaker() {
    }

    public T deepClone(T original){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        T clone = null;
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(original);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            clone = (T)objectInputStream.readObject();
        }catch (ClassNotFoundException e) {
            System.out.println("An error with casting book object");
        }catch (IOException e) {
            System.out.println("An error with ByteOutputStream");
        }finally {
            return clone;
        }
    }
}
