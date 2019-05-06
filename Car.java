public class Car implements CharSequence {
    
    private final byte [] value;
    
    public Car(byte [] bytes) {
        //value = bytes.clone();
        value = new byte [bytes.length];
        int i = 0;
        while (i < bytes.length){
            value[i] = bytes[i];
            i++;
        }
    }
    
    public Car(byte [] bytes, int from, int to) {
        //value = bytes.clone();
        value = new byte [bytes.length];
        int i = from;
        while (i < to){
            value[i - from] = bytes[i];
            i++;
        }
    }
    
    @Override
    public String toString() {
        String str = new String(value);
        return str;
    }
    
    @Override
    public int length() {
        return value.length;
    }

    @Override
    public char charAt(int index) {
        return (char)value[index];
    }
    
    @Override
    public Car subSequence(int start, int end) {
        return new Car(value, start, end);
    }
    // implementation
}