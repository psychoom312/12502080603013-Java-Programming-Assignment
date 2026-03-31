public class JavaFundamentalsDemo {

    public static void main(String[] args) {
        
        int primitiveInt = 25;
        Integer wrapperInt = primitiveInt; 
        
        Integer anotherWrapper = 50;
        int anotherPrimitive = anotherWrapper; 
        
        System.out.println("Wrapper Value: " + wrapperInt);
        System.out.println("Max Integer: " + Integer.MAX_VALUE);
        System.out.println("Binary: " + Integer.toBinaryString(primitiveInt));

        String str = "Hello";
        String originalStrRef = str;
        str = str + " World"; 
        
        System.out.println("\nString: " + str);
        System.out.println("String Reference Changed: " + (str != originalStrRef));

        StringBuffer sBuf = new StringBuffer("Hello");
        StringBuffer originalBufRef = sBuf;
        sBuf.append(" World");
        
        System.out.println("StringBuffer: " + sBuf);
        System.out.println("Buffer Reference Same: " + (sBuf == originalBufRef));

        sBuf.reverse();
        System.out.println("Reversed Buffer: " + sBuf);
        
        sBuf.delete(0, 5);
        System.out.println("Deleted Buffer: " + sBuf);
    }
}
