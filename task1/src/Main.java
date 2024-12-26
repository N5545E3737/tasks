/**
 * Задание 1
 * Круговой массив - массив из элементов, в котором по достижению конца массива
 * следующим элементом будет снова первый. Массив задается числом n, то есть
 * представляет собой числа от 1 до n.
 * Пример кругового массива для n=3:
 * 1231231
 * Напишите программу, которая выводит путь, по которому, двигаясь интервалом длины
 * m по заданному массиву, концом будет являться первый элемент.
 * Началом одного интервала является конец предыдущего.
 * Путь - массив из начальных элементов полученных интервалов.
 * Пример 1
 * n = 4, m = 3
 * Решение:
 * Круговой массив: 1234
 * При длине обхода 3 получаем интервалы: 123, 341 Полученный путь: 13
 * Пример 2
 * n = 5, m = 4
 * Решение:
 * Круговой массив: 12345
 * При длине обхода 4 получаем интервалы: 1234, 4512, 2345, 5123, 3451
 * Полученный путь: 14253
 * Параметры передаются в качестве аргументов командной строки!
 * Например, для последнего примера на вход подаются аргументы: 5 4, ожидаемый
 * вывод в консоль: 14253
 */

public class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); int m = Integer.parseInt(args[1]);
        //int n = 5; int m = 6;

        if (n > 9 || n < 2 || m < 2) {
            System.out.println("некоректный ввод\nn = " +n+ "; m = " +m+ "\nдолжно быть: 2 >= n <= 9; m >= 2;");
            return;
        }

        int path = 0;
        int i = 0;
        int j = 0;
        while (true) {
            while (true) {
                if (i >= n) i = 0;
                i = i + 1;
                j = j + 1;
                if ( j == 1) path = path * 10 + i;
                if (j >= m) break;
            }
            j = 0;
            if (i == 1) break;
            i = i - 1;
        }
    System.out.println(path);
    }
}