//package org.choongang.member.controllers;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class CodeReader {
//    public static List<String> getCodeListFromFile(String filePath, String targetNumber) throws IOException {
//        return Files.lines(Paths.get(filePath))
//                .filter(line -> line.contains(targetNumber)) // 각 줄에서 특정 번호를 포함하는지 확인
//                .collect(Collectors.toList());
//    }
//}
//
