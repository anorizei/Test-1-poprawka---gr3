import java.util.ArrayList;

public class zad1 {
    public static void main(String[] args) {
        ArrayList<Integer> listA = new ArrayList<Integer>();
        listA.add(2);
        listA.add(4);
        listA.add(3);
        listA.add(8);

        ArrayList<Integer> listB = new ArrayList<Integer>();
        listB.add(1);
        listB.add(3);
        listB.add(7);
        listB.add(6);
        System.out.print(merge(listA, listB));
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> combinedList = new ArrayList<Integer>();
        ArrayList<Integer> copyA = new ArrayList<Integer>(a);
        ArrayList<Integer> copyB = new ArrayList<Integer>(b);

        a.forEach(
                (Integer n) -> {
                    if(copyB.contains(n)) {
                        copyB.remove(n);
                    }

                    if(!combinedList.contains(n)) {
                        combinedList.add(n);
                    }
                    copyA.remove(n);

                    if(!copyB.isEmpty()) {
                        if(copyA.contains(copyB.get(0))) {
                            copyA.remove(copyB.get(0));
                        }
                        combinedList.add(copyB.get(0));
                        copyB.remove(0);
                    }
                }
        );
        copyB.forEach(
                (Integer n) -> {
                    combinedList.add(copyB.get(0));
                    copyB.remove(0);
                }
        );

        return combinedList;
    }
}