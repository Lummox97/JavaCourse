import java.util.ArrayList;
import java.util.HashMap;

public class StupidTask{
	private static String printTextPerRole(String[] roles, String[] textLines) {
		StringBuilder out = new StringBuilder();
    	HashMap<String, ArrayList<Integer>> roles2 = new HashMap<String, ArrayList<Integer>>();
    	//String [] lines = roles.split("\n");
    	int i = 0, num;
    
		while (i < roles.length){
    		if (roles[i].equals("textLines:")){
            	//System.out.println("1");
    	    	break;
        	}
        	roles2.put(roles[i], new ArrayList<Integer>());
        	//System.out.println(roles[i] + "2222");
        	i++;
    	}
    	num = i;
    	i = 0;
    	while (i < textLines.length){
        	roles2.get(textLines[i].split(":", 2)[0]).add(i);
        	//System.out.println(a[0]);
        	//System.out.println(roles[i].split(":", 2) + "3333333");
        	i++;
    	}
   		for (i = 0; i < num; i++){
        	out.append(roles[i] + ":\n");
        	for (int j : roles2.get(roles[i])){
            	out.append(j + 1 + ")" + textLines[j].split(":", 2)[1] + "\n");
        	}
        	out.append("\n");
    	}
    	return out.toString();
	}
	public static void main (String [] argc){
		String [] roles= {"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич"};
		String [] textLines={"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.", "Аммос Федорович: Как ревизор?", "Артемий Филиппович: Как ревизор?", "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.", "Аммос Федорович: Вот те на!", "Артемий Филиппович: Вот не было заботы, так подай!", "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        String out2 = printTextPerRole(roles, textLines);
        System.out.print(out2);
	}
}