package com.github.simpleshruti.protobuf;

import example.enumerations.EnumExample;
import example.enumerations.EnumExample.EnumMessage;

public class EnumMain {
    public static void main(String[] args) {

        System.out.println("Example for Enum");

        EnumMessage.Builder builder = EnumMessage.newBuilder();

        builder.setId(345);

        builder.setDayOfTheWeek(EnumExample.DayOfTheWeek.FRIDAY);

        EnumMessage message = builder.build();

        System.out.println(message);
    }
}
