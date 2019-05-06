public class Gens {
	public static void main(String[] argc) {
		Pair<Integer, String> pair = Pair.of(1, null);
		Pair<Integer, Integer> pair2 = Pair.of(1, null);
		System.out.println(pair.getFirst());
		System.out.println(pair.getSecond());
		System.out.println(pair.equals(pair2));
		System.out.println(pair2.hashCode());
	}
}	