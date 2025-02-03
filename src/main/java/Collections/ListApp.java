package Collections;

import java.util.*;

public class ListApp {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(5);
        list1.add(4);
        list1.add(1);
        list1.get(0);
        list1.remove(0);
        list1.set(0,3);

        System.out.println(list1);

        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.add(5);
        list2.add(4);
        list2.add(1);
        list2.get(0);
        list2.remove(0);
        list2.set(0,3);

        System.out.println(list2);

        Set<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(9);
        set.add(0);
        set.add(4);
        set.add(51);
        set.add(12);
        set.add(24);
        set.add(5);
        System.out.println(set);

    }
}
