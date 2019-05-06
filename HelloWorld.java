

public class HelloWorld 
{
	public static void main(String[] args)
	{
		
		byte[] example = {72, 101, 108, 108, 111, 33};
        CharSequence answer = (CharSequence) new Car(example);
        Aaa a = new Aaa();
        Bbb b = (Bbb) a;
        System.out.println("Последовательность - " + answer.toString());//Hello!
        System.out.println("Размер ее - " + answer.length());//6
        System.out.println("Символ под № 1 - " + answer.charAt(1));//e
        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5));//ello
//проверка на нарушение инкапсуляции private поля
        System.out.println(answer.toString());//Hello!
        example[0] = 74;
        System.out.println(answer.toString());//Hello!
    
	}
}