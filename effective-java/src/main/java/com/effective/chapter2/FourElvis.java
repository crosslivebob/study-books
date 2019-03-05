package com.effective.chapter2;

import java.io.*;

public class FourElvis implements Serializable {
    public static final FourElvis INSTANCE = new FourElvis();

    private String name;

    private FourElvis() {name="test";}

    public static FourElvis getInstance() {
        return INSTANCE;
    }

    //防止反序列的时候创建多个对象，破坏Singleton
    private Object readResolve() {
        return INSTANCE;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bInputStream;
        ByteArrayOutputStream byOutputStream;
        ObjectOutputStream outputStream ;
        ObjectInputStream inputStream;

        FourElvis fourElvis = FourElvis.getInstance();

        byOutputStream = new ByteArrayOutputStream();
        outputStream = new ObjectOutputStream(byOutputStream);
        outputStream.writeObject(fourElvis);

        bInputStream = new ByteArrayInputStream(byOutputStream.toByteArray());
        inputStream = new ObjectInputStream(bInputStream);

        FourElvis test = (FourElvis) inputStream.readObject();
        System.out.println(test.toString());
    }
}
