import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LinkedList<Animal> animals = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            animals.add(new Cat(i + 1, random.nextInt(10, 50)));
            animals.add(new Dog(i + 1, random.nextInt(10, 50)));
        }
        int count = 0;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i) instanceof Cat) {
                count++;
                if (count == 5) {
                    animals.remove(animals.get(i));
                    count = 0;
                }
            }
            // System.out.println(animals.get(i));
        }
        int counter = 0;
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i) instanceof Dog) {
                counter++;
                if (counter == 4) {
                    animals.add(i, new Mouse(i, random.nextInt(10, 50)));
                    counter = 0;
                }
            }
            // System.out.println(animals.get(i));
        }
        LinkedList<Cat> cats = new LinkedList<>();
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i) instanceof Mouse) {
                if (animals.get(i + 1) instanceof Cat) {
                    cats.add((Cat) animals.get(i + 1));
                    animals.remove(i + 1);
                }
                if (animals.get(i) instanceof Mouse) {
                    if (animals.get(i - 1) instanceof Cat) {
                        cats.add((Cat) animals.get(i - 1));
                        animals.remove(i - 1);
                    }
                }
            }
        }
        ArrayList<Animal> animals1 = new ArrayList<>();
        for (int i = 0; i < animals.size(); i++) {
            animals1.add(animals.get(i));
        }
        ArrayList<Cat> cats1 = new ArrayList<>();
        for (int i = 0; i < cats.size(); i++) {
            cats1.add(cats.get(i));
        }
        int catsSum = 0;
        int dogsSum = 0;
        int mouseSum = 0;
        for (int i = 0; i < cats1.size(); i++) {
            catsSum = +cats1.get(i).getAge();
        }
        System.out.println("Cats age sum: " + catsSum);
        for (int i = 0; i < animals1.size(); i++) {
            if (animals1.get(i) instanceof Dog) {
                dogsSum = +((Dog) animals1.get(i)).getAge();
            }
            if (animals1.get(i) instanceof Mouse) {
                mouseSum = +((Mouse) animals1.get(i)).getAge();
            }
        }
        System.out.println("Dogs age sum: " + dogsSum);
        System.out.println("Mouse age sum: " + mouseSum);
    }
}