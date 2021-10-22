package com.github.simpleshruti.protobuf;

import example.complex.Complex.*;

public class ComplexMain {
    public static void main(String[] args) {
        System.out.println("Complex Example");

        DummyMessage oneDummy = newDummyMessage(55, "one dummy message");

        ComplexMessage.Builder builder = ComplexMessage.newBuilder();

        builder.setOneDummy(oneDummy);

        builder.addMultipleDummy(newDummyMessage(66, "second dummy"));
        builder.addMultipleDummy(newDummyMessage(77, "third dummy"));

        ComplexMessage message = builder.build();

        System.out.println(message.toString());

    }

    public static DummyMessage newDummyMessage(Integer id, String name) {
        DummyMessage.Builder dummyMessageBuilder = DummyMessage.newBuilder();
        DummyMessage message = dummyMessageBuilder.setName(name)
                .setId(id)
                .build();
        return message;
    }
}
