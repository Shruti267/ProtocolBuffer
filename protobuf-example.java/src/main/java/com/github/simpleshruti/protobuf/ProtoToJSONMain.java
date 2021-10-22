package com.github.simpleshruti.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple.SimpleMessage;

import java.util.Arrays;

public class ProtoToJSONMain {

    public static void main(String[] args) throws InvalidProtocolBufferException {

        SimpleMessage.Builder builder = SimpleMessage.newBuilder();

        builder.setId(42);
        builder.setIsSimple(true);
        builder.setName("My Simple Message Name");

        builder.addSampleList(1);
        builder.addSampleList(2);
        builder.addSampleList(3);

        builder.addAllSampleList(Arrays.asList(4, 5, 6));

        String jsonString = JsonFormat.printer().print(builder);
        System.out.println(jsonString);

        SimpleMessage.Builder builder2 = SimpleMessage.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(jsonString, builder2);

        System.out.println(builder2);
    }
}
