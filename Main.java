package test2;

import java.io.*;
import java.util.*;
public class Main {
    public static TreeMap<Integer, byte[]> imgParts;

    public static void main(String[] args) {
        try {
            imgParts = new TreeMap<>();

            File folder = new File("v25");
            File[] files = folder.listFiles();

            List<Thread> threads = new ArrayList<>();

            for (File file : files) {
                Thread thread = new Thread(new FileProcess(file));
                threads.add(thread);
                thread.start();
            }

                for (Thread thread : threads) {
                    thread.join();
                }

            try (FileOutputStream writer = new FileOutputStream("v25.png")) {
                for (int key: imgParts.keySet()) {
                    writer.write(imgParts.get(key));
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}