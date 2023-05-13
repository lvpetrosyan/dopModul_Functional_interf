import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        //задание 1, оставит только положительные числа
        Test test = new Test("af", 22);
        Test test1 = new Test("an", -2);
        Test test2 = new Test("hj", 0);
        List<Test> testList = new ArrayList<>();
        testList.add(test);
        testList.add(test1);
        testList.add(test2);
        /*  @FunctionalInterface
            Predicate<Test> predicate = new Predicate<Test>() {
            @Override
            public boolean test(Test testt) {
                return testt.getAge()<-1;
            }
        };
        testList.removeIf(predicate);
       System.out.println(testList);
     */
        //реализация через Лямбду
        testList.removeIf(a -> a.getAge() < -1);
        System.out.println(testList);


        //задание 2, вывод имени с приветсвием
     /* Consumer<Test> consumer = new Consumer<Test>() {
            @Override
            public void accept(Test test) {
                System.out.println(test.getName() + ", привет");
            }
        };
        for (Test test3 : testList) {
            consumer.accept(test3);
        }
     */
        Consumer<Test> consumer= a -> System.out.println(a.getName()+", hi");
        for (Test test3 : testList) {
            consumer.accept(test3);
        }


        //задание 3. принимает на вход вещественное число типа
        //Double
        //, а возвращает его округленный вариант типа
        //Long
        double a=1112.2;
       /* Function<Double, Long> function= new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble) ;
            }
        };
        System.out.println(function.apply(a));
        */
        //то же самое, только через лямбду
        Function<Double, Long> function= aDouble -> Math.round(aDouble);
        System.out.println(function.apply(a));

        //задание 4. возвращает случайное число из диапазона от 0 до 100.
        Supplier <Double> supplier= new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.floor(Math.random()*101);
            }
        };
        System.out.println(supplier.get());
        //лямбда
        Supplier <Double> suppliers= ()-> Math.floor(Math.random()*101);
        System.out.println(suppliers.get());


    }
}
