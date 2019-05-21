/**
 * Created by Alexander Alpidovskiy on 20.05.2019.
 */
/*
� ����� ��������� 24 ����� �������� � 20 ������ ��������.
�������� ������� �� ����� ������.
���� ������� ���� �������� ������ �����, �� � ����� ������ ������ ��������.
���� ������� ���� �������� ������� �����, �� � ����� ������ ����� ��������.
������ ����� �������� ��������, ������� ��������� � ����� ���������?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Random;

public class GlovesCount {
    public static void main(String[] args) throws Exception {

        // ������ ���������� ��������
        int white = 0;
        int black = 0;
        int iteration = 0; // ������� ��������� ������

        // �������, �� ������� �������� ���������� ���� �������
        String[] stringArray = {"������", "�����", "������"};
        String[] stringArrayWhites = {"�����", "������"};
        String[] stringArrayBlacks = {"������", "������"};

        String random = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("(c) 2019 ��������� ��������� ������������. GlovesCount v0.4.");
        System.out.println("");
        System.out.println("������ ��������� ������ �������������� ������ � ���������� �������� � �����.");
        System.out.println("������� ������:");
        System.out.println("� ����� ��������� X ����� �������� � Y ������ ��������.");
        System.out.println("�������� ������� �� ����� ������.");
        System.out.println("���� ������� ���� �������� ������ �����, �� � ����� ������ ������ ��������.");
        System.out.println("���� ������� ���� �������� ������� �����, �� � ����� ������ ����� ��������.");
        System.out.println("������ ����� �������� ��������, ������� ��������� � ����� ���������?");
        System.out.println("");

        // ������ ���������� ��������
        System.out.println("����������, ������� ���������� ����� �������� (X):");
        try {
            white = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.err.println("������! �� ����� ������������ ������! ��������� ��������� ������ � ������� ����� �����!");
            throw new Exception(e);
        }
        System.out.println("����������, ������� ���������� ������ �������� (Y):");
        try {
            black = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.err.println("������! �� ����� ������������ ������! ��������� ��������� ������ � ������� ����� �����!");
            throw new Exception(e);
        }
        System.out.println("");

        // ���������� ��� �������� � �����, ����� �������
        int whiteStart = white;
        int blackStart = black;

        // �������� ��������� �������� �������
        System.out.println("����� � ����� " + white + " ����� �������� � " + black + " ������.");
        System.out.println("");

        // �������� ���� ������
        while (true) {
            int idx = new Random().nextInt(stringArray.length);
            int idw = new Random().nextInt(stringArrayWhites.length);
            int idb = new Random().nextInt(stringArrayBlacks.length);

            if ((black == 1 && white == 0) || (white == 1 && black == 0)) { // ������� ��������� �����
                break;
            } else if (black == 1 && white == 1) {
                random = "������";
                black--;
            } else if (black == 1 && white >= 2) {
                random = (stringArrayWhites[idw]);
                if (Objects.equals(random, "�����")) {
                    white = white - 2;
                    black++;
                } else if (Objects.equals(random, "������")) {
                    black--;
                }
            } else if (black == 0 && white >= 2) {
                random = "�����";
                white = white - 2;
                black++;
            } else if (black >= 2 && white == 1) {
                random = (stringArrayBlacks[idb]);
                if (Objects.equals(random, "������")) {
                    black--;
                } else if (Objects.equals(random, "������")) {
                    black--;
                }
            } else if (black >= 2 && white == 0) {
                random = "������";
                black--;
            } else if (black >= 2 && white >= 2) {
                random = (stringArray[idx]);
                if (Objects.equals(random, "������")) {
                    black--;
                } else if (Objects.equals(random, "������")) {
                    black--;
                } else if (Objects.equals(random, "�����")) {
                    white = white - 2;
                    black++;
                }
            }

            iteration++;

            System.out.println("�������� �: " + iteration);
            System.out.println("������� ��� " + random + " ��������");
            System.out.println("��������: ����� - " + white + ", ������ - " + black);
            System.out.println("");
        }

        System.out.println("------");
        System.out.println("����������� ���������� �������� � �����: ����� - " + whiteStart + ", ������ - " + blackStart);
        System.out.println("������ ����� �������� �������� � ����� ���������?");
        System.out.println("�����:");
        if (white == 1 && black == 0) {
            System.out.println("��������� � ����� ��������� ����� ��������.");
        } else if (black == 1 && white == 0) {
            System.out.println("��������� � ����� ��������� ������ ��������.");
        }
        System.out.println("------");
        System.out.println("");
        System.out.println("(c) 2019 ��������� ��������� ������������. GlovesCount v0.4.");
    }
}
