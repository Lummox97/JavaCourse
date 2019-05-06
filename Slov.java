import java.util.*;
import java.lang.*;
public class Slov {
    public static void main(String [] argc) {
        Map<String, Integer> tran = new HashMap<>();
        Scanner scan = new Scanner(System.in).useDelimiter("[^A-Za-z0-9]");
        String str = null;
        while (scan.hasNext()){
            str = scan.next().toLowerCase();
            if (str.equals(" ") || str.equals(""))
                continue;
            if (tran.containsKey(str))
                tran.put(str, tran.get(str) + 1);
            else
                tran.put(str, 1);
        }
        List<Map.Entry<String, Integer>> list = new LinkedList<>(tran.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> el1, Map.Entry<String, Integer> el2) {
                return el2.getValue().compareTo(el1.getValue()) * 1000 + el1.getKey().compareTo(el2.getKey());
            }
        });
        //System.out.println(list);
        int i = 0;
        for (Map.Entry one : list) {
            System.out.println(one.getKey());
            i++;
            if (i == 10)
                break;
        }
    }
}