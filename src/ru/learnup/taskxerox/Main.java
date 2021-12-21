package ru.learnup.taskxerox;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String [] args) {

        copyFile(args[0], args[1]);

        /*
        Задача программы, открыть первый файл (изображение),
        прочитать его и содержимое скопировать в новосозданный файл с заданным именем.
        Помните, ни один байтик не должен потеряться, а лишних байтов быть не должно!
        */

    }

    public static void uselessMethod(){

    }

    private static boolean validityOfFile(String pathToExsiststingFileAndNewNameOfFile) {
        String[] array = pathToExsiststingFileAndNewNameOfFile.split("\\s+"); // собственно смотрим, чтобы в строке был минимум 1 пробел, и защищаемся от тролей

        String fileToCopy = array[0]; // путь до файла
        String fileToWrite = array[1]; // сам файл

        if (array.length != 2) {
            return false;
        }
        return true;
    }

    private static void createFile() {
        Scanner scan = new Scanner(System.in);
        String pathToFileAndNameOfNewFile; // вводим путь до файла и имя нового файла, через пробел само собой

        do {
            pathToFileAndNameOfNewFile = scan.nextLine(); // do while, потому что строку нам сначала нужно ввести, а потом уже проверить на наличие косяка в ней
        } while (!validityOfFile(pathToFileAndNameOfNewFile));

        scan.close();
        copyFileToNew(pathToFileAndNameOfNewFile);
    }

    private static void copyFileToNew(String smth) {
        String[] array = smth.split("\\s+");

        String fileToInput = array[0];
        String fileToOutput = "src/ru.learnup/taskxerox/" + array[1]; // копирую себе так как прошлый тест скопировал файл далекооооооо

        try (BufferedInputStream iS = new BufferedInputStream(new FileInputStream(fileToInput));
             BufferedOutputStream oS = new BufferedOutputStream(new FileOutputStream(fileToOutput))) {

            byte[] buffer = new byte[iS.available()];
            iS.read(buffer, 0, buffer.length);
            oS.write(buffer, 0, buffer.length);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile(String fileName1, String fileName2) {

        try (BufferedInputStream iS = new BufferedInputStream(new FileInputStream(fileName1)); // точка отпраки
             BufferedOutputStream oS = new BufferedOutputStream(new FileOutputStream(fileName2))) { // точка назначения

            byte[] buffer = new byte[iS.available()]; // соответственно нас интересует количество доступных байт в точке отправки, чтобы ничего не потерять
            iS.read(buffer, 0, buffer.length); // сколько читаем,
            oS.write(buffer, 0, buffer.length); // столько и записываем
            // сё, файл скопировался
            System.out.println("File copied successfully");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // фух это было тяжело

}
