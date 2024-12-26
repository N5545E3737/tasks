/**
 * Задание 2.
 * Напишите программу, которая рассчитывает положение точки относительно
 * окружности.
 * Координаты центра окружности и его радиус считываются из файла 1
 * Пример:
 * 1 1
 * 5
 * Координаты точек считываются из файла 2
 * Пример:
 * 0 0
 * 1 6
 * 6 6
 * Вывод для данных примеров файлов:
 * 1
 * 0
 * 2
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            // координаты центра окружности и его радиус
            File cyrcle = new File(args[0]);
            Scanner scan1 = new Scanner(cyrcle);
            scan1.hasNextInt();
            int xCenter = scan1.nextInt();
            scan1.hasNextInt();
            int yCenter = scan1.nextInt();
            scan1.hasNextInt();
            int radius = scan1.nextInt();

            // координаты точек
            File dots = new File(args[1]);
            Scanner scan2 = new Scanner(dots);
            String ln;

            // цикл обработки координат точек
            while (scan2.hasNextLine()) {
                ln = scan2.nextLine();
                int x = Integer.parseInt(ln.split(" ")[0]);
                int y = Integer.parseInt(ln.split(" ")[1]);
                calcPos(x, y, xCenter, yCenter, radius);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файлы не найдены");
        }
    }

    // метод вычисления позиции точки
    public static void calcPos(int x, int y, int xCenter, int yCenter, int radius) {
        double distance = Math.sqrt(Math.pow(x - xCenter, 2) + Math.pow(y - yCenter, 2));
        if (distance < (double)radius) {
            System.out.println(1); // Точка внутри окружности
        } else if (distance == (double)radius) {
            System.out.println(0); // Точка на окружности
        } else {
            System.out.println(2); // Точка снаружи окружности
        }
    }
}