import java.util.ArrayList;
import java.util.HashMap;

public class Quiz2 {
    public static void main (String [] argc){
 		String text = new String("roles:\nГородничий\nАммос Федорович\nАртемий Филиппович\nЛука Лукич\ntextLines:\nГородничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.\nАммос Федорович: Как ревизор?\nАртемий Филиппович: Как ревизор?\nГородничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.\nАммос Федорович: Вот те на!\nАртемий Филиппович: Вот не было заботы, так подай!\nЛука Лукич: Господи боже! еще и с секретным предписаньем!");

        HashMap<String, ArrayList<Integer>> roles = new HashMap<String, ArrayList<Integer>>();
    	String out = new String();
        String [] lines = text.split("\n");
    	int i = 1, num;
	   	while (i < lines.length){
    		if (lines[i].equals("textLines:"))
    			break;
            roles.put(lines[i], new ArrayList<Integer>());
            //roles.get(lines[i]).add(i);
    		//System.out.println(lines[i]);
            i++;
    	}
        num = i;
        i++;
        while (i < lines.length){
            roles.get(lines[i].split(":", 2)[0]).add(i);
            //System.out.println(a[0]);
            i++;
        }
        for (i = 1; i < num; i++){
            out += lines[i] + ":\n";
            System.out.println(lines[i] + ":");
            for (int j : roles.get(lines[i])){
                out += j - num + ")" + lines[j].split(":", 2)[1] + "\n";
                System.out.println(j - num + ")" + lines[j].split(":", 2)[1]);
            }
            out += "\n";
            System.out.print("\n");
        }
        System.out.print(out);
	}  
}