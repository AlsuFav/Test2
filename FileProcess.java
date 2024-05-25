package test2;

import java.io.*;

public class FileProcess implements Runnable {
    private final File file;

    public FileProcess(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            int sz = dis.readInt();

            byte[] imgBytes = new byte[sz];
            dis.read(imgBytes);

            int even = dis.readInt();
            int part = dis.readInt();
            if (checkEven(imgBytes) == even) {
                synchronized (Main.imgParts) {
                    Main.imgParts.put(part, imgBytes);
                }
            } else {
                throw new Exception();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Wrong evenness");
        }
    }

    private int checkEven(byte[] data) {
        int even = 0;
        for (byte b : data) {
            int count = 0;
            for (int i = 0; i < 8; i++) {
                count += (b >> i & 1);
            }

            if (count % 2 == 0) {
                even += 0;
            }

            else {
                even += 1;
            }
        }
        return even % 2;
    }
}