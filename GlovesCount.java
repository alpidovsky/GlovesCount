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
        int white; // Количество белых перчаток
        int black; // Количество черных перчаток
        int iteration; // Счетчик количесва циклов

        // Массивы, из которых случайно выбирается один элемент
        String[] stringArray = {"ЧЕРНЫЕ", "БЕЛЫЕ", "РАЗНЫЕ"};
        String[] stringArrayWhites = {"БЕЛЫЕ", "РАЗНЫЕ"};
        String[] stringArrayBlacks = {"ЧЕРНЫЕ", "РАЗНЫЕ"};

        String random = null; // Переменная, в которую записывается случайное значение
        String again; // Переменная определяет, повторить ли решение задачи еще раз
        String log; // Переменная
        boolean yn;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("(c) 2019 Александр Андреевич Альпидовский. Программа GlovesCount v0.5.");
        System.out.println("");
        System.out.println("Данная программа решает задачу о цвете последней перчатки в мешке.");
        System.out.println("");
        System.out.println("Условия задачи:");
        System.out.println("В мешке находится X белых перчаток и Y чёрных перчаток.");
        System.out.println("Перчатки достают из мешка парами.");
        System.out.println("Если достали пару перчаток одного цвета, то в мешок кладут чёрную перчатку.");
        System.out.println("Если достали пару перчаток разного цвета, то в мешок кладут белую перчатку.");
        System.out.println("Какого цвета окажется перчатка, которая останется в мешке последней?");

        // Цикл, если пользователь решит попробовать решить задачу еще раз с другими данными
        while (true) {
            // Вводим количество перчаток
            while (true) {
                System.out.println("");
                System.out.println("Пожалуйста, введите количество БЕЛЫХ перчаток (X):");
                try {
                    white = Integer.parseInt(reader.readLine());
                    System.out.println("Принято. Количество белых перчаток в мешке - " + white);
                    break;
                } catch (Exception e) {
                    System.out.println("ОШИБКА! Вы ввели недопустимое значение! Введите целое число!");
                }
            }
            while (true) {
                System.out.println("Пожалуйста, введите количество ЧЕРНЫХ перчаток (Y):");
                try {
                    black = Integer.parseInt(reader.readLine());
                    System.out.println("Принято. Количество черных перчаток в мешке - " + black);
                    break;
                } catch (Exception e) {
                    System.out.println("ОШИБКА! Вы ввели недопустимое значение! Введите целое число!");
                }
            }

            // Переменные для указания в конце, перед ответом
            int whiteStart = white;
            int blackStart = black;
            iteration = 0; // Сброс счетчика циклов

            // Печатаем начальные заданные условия
            System.out.println("");
            System.out.println("Всего в мешке: БЕЛЫХ перчаток - " + white + ", ЧЕРНЫХ перчаток - " + black);
            System.out.println("");

            System.out.println("Программа может отобразить список всех действий.");
            System.out.println("Каждое действие, когда достают и кладут перчатки, отобразится в списке.");
            System.out.println("Вы увидите номер действия, цвет перчаток, которые достали из мешка,");
            System.out.println("какого цвета перчатку положили обратно,");
            System.out.println("и сколько перчаток осталось в мешке после этого.");
            System.out.println("Если введете N, получите ответ на задачу сразу без спска действий.");
            System.out.println("");
            System.out.println("Хотите, чтобы программа отобразила список всех действий? [Y(да)/N(нет)]");
            while (true) {
                log = reader.readLine();
                if (Objects.equals(log, "y") || Objects.equals(log, "Y")) {
                    yn = true;
                    break;
                } else if (Objects.equals(log, "n") || Objects.equals(log, "N")) {
                    yn = false;
                    break;
                } else {
                    System.out.println("Недопустимое значение! Хотите, чтобы программа отобразила список действий? [Y(да)/N(нет)]");
                }
            }

            // Основной цикл задачи
            while (true) {
                int idx = new Random().nextInt(stringArray.length);
                int idw = new Random().nextInt(stringArrayWhites.length);
                int idb = new Random().nextInt(stringArrayBlacks.length);

                if ((black == 1 && white == 0) || (white == 1 && black == 0)) { // Условие остановки цикла
                    break;
                } else if (black == 1 && white == 1) {
                    random = "РАЗНЫЕ";
                    black--;
                } else if (black == 1 && white >= 2) {
                    random = (stringArrayWhites[idw]);
                    if (Objects.equals(random, "БЕЛЫЕ")) {
                        white = white - 2;
                        black++;
                    } else if (Objects.equals(random, "РАЗНЫЕ")) {
                        black--;
                    }
                } else if (black == 0 && white >= 2) {
                    random = "БЕЛЫЕ";
                    white = white - 2;
                    black++;
                } else if (black >= 2 && white == 1) {
                    random = (stringArrayBlacks[idb]);
                    if (Objects.equals(random, "ЧЕРНЫЕ")) {
                        black--;
                    } else if (Objects.equals(random, "РАЗНЫЕ")) {
                        black--;
                    }
                } else if (black >= 2 && white == 0) {
                    random = "ЧЕРНЫЕ";
                    black--;
                } else if (black >= 2 && white >= 2) {
                    random = (stringArray[idx]);
                    if (Objects.equals(random, "ЧЕРНЫЕ")) {
                        black--;
                    } else if (Objects.equals(random, "РАЗНЫЕ")) {
                        black--;
                    } else if (Objects.equals(random, "БЕЛЫЕ")) {
                        white = white - 2;
                        black++;
                    }
                }

                iteration++;

                if (yn) {
                    System.out.println("Действие №: " + iteration);
                    System.out.print("Забрали две " + random + " перчатки");
                    if (Objects.equals(random, "БЕЛЫЕ") || Objects.equals(random, "ЧЕРНЫЕ")) {
                        System.out.println(" и положили обратно одну ЧЕРНУЮ.");
                    } else {
                        System.out.println(" и положили обратно одну БЕЛУЮ.");
                    }
                    System.out.println("Осталось: БЕЛЫХ - " + white + ", ЧЕРНЫХ - " + black);
                    System.out.println("");
                }
            }

            System.out.println("----------");
            System.out.println("Изначальное количество перчаток в мешке: БЕЛЫХ - " + whiteStart + ", ЧЕРНЫХ - " + blackStart);
            System.out.println("ВОПРОС:");
            System.out.println("Какого цвета перчатка осталась в мешке последней?");
            System.out.println("ОТВЕТ:");
            if (white == 1 && black == 0) {
                System.out.println("Последней в мешке оказалась БЕЛАЯ перчатка.");
            } else if (black == 1 && white == 0) {
                System.out.println("Последней в мешке оказалась ЧЕРНАЯ перчатка.");
            }
            System.out.println("----------");
            System.out.println("");
            System.out.println("Хотите выполнить решение с другими данными? [Y(да)/N(нет)]");
            while (true) {
                again = reader.readLine();
                if (Objects.equals(again, "y") || Objects.equals(again, "Y")) {
                    yn = true;
                    break;
                } else if (Objects.equals(again, "n") || Objects.equals(again, "N")) {
                    yn = false;
                    break;
                } else {
                    System.out.println("Недопустимое значение! Хотите решить задачу еще раз? [Y(да)/N(нет)]");
                }
            }
            if (!yn) {
                break; // Условие завершения программы
            }
        }
        System.out.println("");
        System.out.println("(c) 2019 Александр Андреевич Альпидовский. Программа GlovesCount v0.5.");
        System.out.println("");
    }
}
