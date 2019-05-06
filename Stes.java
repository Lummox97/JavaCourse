import java.util.*;
public class Stes {
    public static void main(String[] args) {

        Set<Integer> num1 = new HashSet<>();
        num1.add(3);
        num1.add(7);
        num1.add(9);

        HashSet<Integer> num2 = new HashSet<>();
        num2.add(5);
        num2.add(7);
        num2.add(12);

        Set<Integer> result = symmetricDifference(num1,num2);
        System.out.println(result);
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
       
        HashSet<T> newSet = new HashSet<>();
        
        outer: for (T itr1 : set1) {
            for (T itr2 : set2) {
                if (itr1.equals(itr2))
                    continue outer;
                newSet.add(itr1);
            }
        }
        
        outer2: for (T itr1 : set2) {
            for (T itr2 : set1) {
                if (itr1.equals(itr2))
                    continue outer2;
                newSet.add(itr2);
            }
        }
        
        return newSet;
    }
}