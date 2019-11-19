package com.generation.brain.bytecopying;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Start {

    public static void main(String[] args) throws Exception {
//        FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
//
//        long[] arrBytes = new long[256];
//        long startTime = System.currentTimeMillis();
//
//        while (inputStream.available() > 0) arrBytes[inputStream.read()]++;
//
//        inputStream.close();
//
//        // Выводим отсортированный по байт-коду в обратном порядке
//        for (long i = 255; i >= 0 ; i--)
//            if (arrBytes[(int) i] > 0) System.out.print(i + " ");
//
//        long finishTime = System.currentTimeMillis();
//        System.out.println("\nВремя работы = " + (finishTime-startTime) + " ms.");

        FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());

        long[] arrBytes = new long[256];

        int size = 65536;

        int bufferSize = size;
        byte buffer[] = new byte[size];

        long startTime = System.currentTimeMillis();

        while (inputStream.available() > 0) {
            if (inputStream.available() < size) bufferSize = inputStream.available();

            inputStream.read(buffer, 0, bufferSize);

            for(int i = 0; i < bufferSize; i++) arrBytes[buffer[i] & 0b11111111] = 1;
        }

        long finishTime = System.currentTimeMillis();
        System.out.println("Время работы = " + (finishTime - startTime) + " ms.");

        for (int i = 0; i < arrBytes.length; i++)
            if(arrBytes[i] == 1) System.out.print(i + " ");

    }

}