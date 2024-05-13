package org.myllds.uuidgenerator;

import org.myllds.uuidgenerator.service.UUIDGeneratorService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UUIDGeneratorService uuidGeneratorService
                = new UUIDGeneratorService(1, 16, 4096);
        List<String> strings = uuidGeneratorService.generateUUIDs(System.currentTimeMillis());
        System.out.println(strings.size());
    }
}