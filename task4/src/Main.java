/**
 * Задание 4
 * Дан массив целых чисел nums.
 * Напишите программу, выводящую минимальное количество ходов, требуемых для
 * приведения всех элементов к одному числу.
 * За один ход можно уменьшить или увеличить число массива на 1
 * Пример:
 * nums = [1, 2, 3]
 * Решение: [1, 2, 3] => [2, 2, 3] => [2, 2, 2].
 * Минимальное количество ходов: 2
 * Элементы массива читаются из файла, переданного в качестве аргумента
 * командной строки!
 * Пример:
 * На вход подаётся файл с содержимым:
 * 1
 * 10
 * 2
 * 9
 * Вывод в консоль: 16
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import static java.lang.Math.abs;
import static java.lang.Math.round;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        int i;
        int n = 0;

        try {
            File numstxt = new File(args[0]);
            Scanner scan = new Scanner(numstxt);

            i = 0;
            while (scan.hasNextLine()) {

                n = scan.nextInt();
                nums.add(i,n);
                i = i + 1;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файлы не найдены");
        }

      if (nums.isEmpty()) {
          System.out.println("Файл пуст");
          return;
      } else if (nums.size() == 1) {
          System.out.println("Файл содержит только одно значение");
          return;
      }

      Collections.sort(nums);

      if(steps(srarf(nums), nums) < steps(med(nums), nums)) {
          System.out.println(steps(srarf(nums), nums));
        }else{
          System.out.println(steps(med(nums), nums));
        }
    }

    //метод подсчета итераций, приведения массива к одному значение
    public static int steps(int num,ArrayList<Integer> nums) {
        int steps = 0;
        for (int i=0; i < nums.size();i++) steps = steps + abs(num - nums.get(i));
        return steps;
    }

    //метод вычисления среднего арифметического числа массива с округлением
    public static int srarf(ArrayList<Integer> n){
        int sum = 0;
        for (int i=0; i < n.size();i++) sum = sum + n.get(i);
        return (int) round(sum/n.size());
    }

    //метод вычисления медианного числа массива с округлением
    public static int med(ArrayList<Integer> n){
        if(n.size() % 2 == 0) {
            return (int) round(((n.get((int)(n.size() / 2))) + (n.get((int)(n.size() / 2)) - 1)) / 2);
        } else {
            return (n.get((int)(n.size() / 2)) - 1);
        }
    }
}