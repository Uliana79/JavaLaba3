import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * Основной класс
 */
public class Main {
    /**
     * Ввод и проверка данных о количестве вызовов
     *
     * @param in Scanner
     * @return количество вызовов
     */
    public static int CorrectData(Scanner in) {
        System.out.print("Сколько раз вызывать методы? ");
        int a = 0;
        boolean flag = false;
        do {
            if (in.hasNextInt()) {
                a = in.nextInt();
                if (a >= 0) flag = true;
                else
                    System.out.println("Ошибка! Попробуйте снова: ");
            } else
                System.out.println("Ошибка! Попробуйте снова: ");
            in.nextLine();
        } while (!flag);
        return a;
    }

    /**
     * Основной метод (вычисление времени выполнения методов: add, get, remove)
     *
     * @param args  основные аргументы
     */
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        Scanner in = new Scanner(System.in);
        String r;
        int N;

        do {
            N = CorrectData(in);


            //подсчет времени для ArrayList метод add
            long start = System.nanoTime();
            for (int i = 0; i < N; i++) {
                arrayList.add(i);
            }
            long end = System.nanoTime();
            long durAdd1 = end - start;


            //подсчет времени для LinkedList метод add
            start = System.nanoTime();
            for (int i = 0; i < N; i++) {
                linkedList.add(i);
            }
            end = System.nanoTime();
            long durAdd2 = end - start;


            //подсчет времени для ArrayList метод get
            start = System.nanoTime();
            for (int i = 0; i < N; i++) {
                arrayList.get(i);
            }
            end = System.nanoTime();
            long durGet1 = end - start;


            //подсчет времени для LinkedList метод get
            start = System.nanoTime();
            for (int i = 0; i < N; i++) {
                linkedList.get(i);
            }
            end = System.nanoTime();
            long durGet2 = end - start;


            //подсчет времени для ArrayList метод remove
            start = System.nanoTime();
            for (int i = N - 1; i >= 0; i--) {
                arrayList.remove(i);
            }
            end = System.nanoTime();
            long durRemove1 = end - start;


            //подсчет времени для LinkedList метод remove
            start = System.nanoTime();
            for (int i = N - 1; i >= 0; i--) {
                linkedList.remove(i);
            }
            end = System.nanoTime();
            long durRemove2 = end - start;

            System.out.println(N + " вызовов");
            for (int i=0; i<43; i++)
            System.out.print("-");
            System.out.println();
            System.out.format("|%-7s| %-15s| %-15s|%n","Метод", "ArrayList", "LinkedList");
            for (int i=0; i<43; i++)
                System.out.print("-");
            System.out.println();
            System.out.format("|%-7s| %-15s| %-15s|%n", "Add", durAdd1, durAdd2);
            System.out.format("|%-7s| %-15s| %-15s|%n", "Get", durGet1, durGet2);
            System.out.format("|%-7s| %-15s| %-15s|%n", "Remove", durRemove1, durRemove2);
            for (int i=0; i<43; i++)
                System.out.print("-");
            System.out.println();

            System.out.println("Выйти? (y/n)");
            r = in.nextLine();
        } while (r != "y");

    }

    //LinkedList быстрее в add и remove, но медленнее в get
}
