package com.github.simpleshruti.protobuf;

import example.simple.Simple.SimpleMessage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleMain {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        SimpleMessage.Builder builder = SimpleMessage.newBuilder();

        builder.setId(42);
        builder.setIsSimple(true);
        builder.setName("My Simple Message Name");

        builder.addSampleList(1);
        builder.addSampleList(2);
        builder.addSampleList(3);

        builder.addAllSampleList(Arrays.asList(4, 5, 6));

        System.out.println(builder.toString());

        SimpleMessage message = builder.build();

        try {
            FileOutputStream outputStream = new FileOutputStream("simple_message.bin");
            message.writeTo(outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] bytes = message.toByteArray();

        try {
            System.out.println("Reading from file...");
            FileInputStream fileInputStream = new FileInputStream("simple_message.bin");
            SimpleMessage messageFromFile = SimpleMessage.parseFrom(fileInputStream);
            System.out.println("Message from file: "+ messageFromFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
