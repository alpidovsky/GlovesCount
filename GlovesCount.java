/**
 * Created by Alexander Alpidovskiy on 20.05.2019.
 */
/*
В мешке находится 24 белые перчатки и 20 чёрных перчаток.
Перчатки достают из мешка парами.
Если достали пару перчаток одного цвета, то в мешок кладут чёрную перчатку.
Если достали пару перчаток разного цвета, то в мешок кладут белую перчатку.
Какого цвета окажется перчатка, которая останется в мешке последней?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Random;

public class GlovesCount {
    public static void main(String[] args) throws Exception {

        // Задаем количество перчаток
        int white = 0;
        int black = 0;
        int iteration = 0; // Счетчик количесва циклов

        // Массивы, из которых случайно выбирается один элемент
        String[] stringArray = {"Черные", "Белые", "Разные"};
        String[] stringArrayWhites = {"Белые", "Разные"};
        String[] stringArrayBlacks = {"Черные", "Разные"};

        String random = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("(c) 2019 Александр Андреевич Альпидовский. GlovesCount v0.4.");
        System.out.println("");
        System.out.println("Данная программа решает математическую задачу о количестве перчаток в мешке.");
        System.out.println("Условия задачи:");
        System.out.println("В мешке находится X белых перчаток и Y чёрных перчаток.");
        System.out.println("Перчатки достают из мешка парами.");
        System.out.println("Если достали пару перчаток одного цвета, то в мешок кладут чёрную перчатку.");
        System.out.println("Если достали пару перчаток разного цвета, то в мешок кладут белую перчатку.");
        System.out.println("Какого цвета окажется перчатка, которая останется в мешке последней?");
        System.out.println("");

        // Вводим количество перчаток
        System.out.println("Пожалуйста, введите количество БЕЛЫХ перчаток (X):");
        try {
            white = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.err.println("Ошибка! Вы ввели недопустимый символ! Запустите программу заново и введите целое число!");
            throw new Exception(e);
        }
        System.out.println("Пожалуйста, введите количество ЧЕРНЫХ перчаток (Y):");
        try {
            black = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.err.println("Ошибка! Вы ввели недопустимый символ! Запустите программу заново и введите целое число!");
            throw new Exception(e);
        }
        System.out.println("");

        // Переменные для указания в конце, перед ответом
        int whiteStart = white;
        int blackStart = black;

        // Печатаем начальные заданные условия
        System.out.println("Всего в мешке " + white + " белых перчаток и " + black + " черных.");
        System.out.println("");

        // Основной цикл задачи
        while (true) {
            int idx = new Random().nextInt(stringArray.length);
            int idw = new Random().nextInt(stringArrayWhites.length);
            int idb = new Random().nextInt(stringArrayBlacks.length);

            if ((black == 1 && white == 0) || (white == 1 && black == 0)) { // Условие остановки цикла
                break;
            } else if (black == 1 && white == 1) {
                random = "Разные";
                black--;
            } else if (black == 1 && white >= 2) {
                random = (stringArrayWhites[idw]);
                if (Objects.equals(random, "Белые")) {
                    white = white - 2;
                    black++;
                } else if (Objects.equals(random, "Разные")) {
                    black--;
                }
            } else if (black == 0 && white >= 2) {
                random = "Белые";
                white = white - 2;
                black++;
            } else if (black >= 2 && white == 1) {
                random = (stringArrayBlacks[idb]);
                if (Objects.equals(random, "Черные")) {
                    black--;
                } else if (Objects.equals(random, "Разные")) {
                    black--;
                }
            } else if (black >= 2 && white == 0) {
                random = "Черные";
                black--;
            } else if (black >= 2 && white >= 2) {
                random = (stringArray[idx]);
                if (Objects.equals(random, "Черные")) {
                    black--;
                } else if (Objects.equals(random, "Разные")) {
                    black--;
                } else if (Objects.equals(random, "Белые")) {
                    white = white - 2;
                    black++;
                }
            }

            iteration++;

            System.out.println("Действие №: " + iteration);
            System.out.println("Забрали две " + random + " перчатки");
            System.out.println("Осталось: БЕЛЫХ - " + white + ", ЧЕРНЫХ - " + black);
            System.out.println("");
        }

        System.out.println("------");
        System.out.println("Изначальное количество перчаток в мешке: белых - " + whiteStart + ", черных - " + blackStart);
        System.out.println("Какого цвета перчатка осталась в мешке последней?");
        System.out.println("ОТВЕТ:");
        if (white == 1 && black == 0) {
            System.out.println("Последней в мешке оказалась БЕЛАЯ перчатка.");
        } else if (black == 1 && white == 0) {
            System.out.println("Последней в мешке оказалась ЧЕРНАЯ перчатка.");
        }
        System.out.println("------");
        System.out.println("");
        System.out.println("(c) 2019 Александр Андреевич Альпидовский. GlovesCount v0.4.");
    }
}
