package ru.learnup.halflife;

import java.util.Scanner;

public class Main {

    protected static final String PROGRESS_CONTENT_FILENAME = "ProgressOfHero.data";


    public static void main(String[] args) {

        /*
        1) Придумайте класс, который будет описывать текущий прогресс игрока в игре.
        2) Создайте методы, которые будут сохранять прогресс,
           а также подгружать его, когда пользователь продолжает игру.
         */
        System.out.println("Do you want to save or load the game progress?");
        Scanner scan = new Scanner(System.in);

        String answer = scan.nextLine();

        Progress hero = new Progress("Desmont Miles", 60, 100.24, 12345, 1337, 228);


        if (answer.equals("save")) {
            hero.saveProgressOfHero(hero);
        } else if (answer.equals("load")) {
            System.out.println(hero.loadProgress());
        }


    }

}
