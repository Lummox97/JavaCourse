import java.util.function.*;
import java.util.Objects;
public class Tern {
	public static void main(String [] argc) {
		Predicate<Object> condition = Objects::isNull;
		Function<Object, Integer> ifTrue = obj -> 0;
		Function<CharSequence, Integer> ifFalse = CharSequence::length;
		Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
		System.out.println(safeStringLength.apply("Hello world!"));

	}
	public static <T, U> Function<T, U> ternaryOperator(
        Predicate<? super T> condition,
        Function<? super T, ? extends U> ifTrue,
        Function<? super T, ? extends U> ifFalse) {
    
    	Function<T, U> a = (obj) -> condition.test(obj) ? ifTrue.apply(obj) : ifFalse.apply(obj);
    	return a;
	}
}