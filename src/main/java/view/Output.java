package view;

import java.util.List;

public class Output {

    public void output(String message) {
        System.out.println(message);
    }

    public <E> void outputList(List<E> list) {
        list.forEach(System.out::println);
    }
}
