package com.stickheroap.stickheroap;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class GameSerializableTest {
    @Test
    public void testSerializable() throws IOException, ClassNotFoundException {
        SaveData save = new SaveData(5);
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("save1.txt"));
        outputStream.writeObject(save);

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("save1.txt"));
        SaveData save2 = (SaveData) inputStream.readObject();

        assertEquals(save2.getScore(), save.getScore());
    }
}