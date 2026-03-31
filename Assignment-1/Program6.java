abstract class Cipher {
    public abstract String encrypt(String text, int key);
    public abstract String decrypt(String text, int key);
}

class CaesarCipher extends Cipher {
    @Override
    public String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                result.append((char) ((character - base + key) % 26 + base));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    @Override
    public String decrypt(String text, int key) {
        return encrypt(text, 26 - (key % 26));
    }
}

public class CipherSystem {
    public static void main(String[] args) {
        Cipher myCipher = new CaesarCipher();
        
        String message = "Hello Java";
        int shift = 4;

        String encrypted = myCipher.encrypt(message, shift);
        String decrypted = myCipher.decrypt(encrypted, shift);

        System.out.println("Original:  " + message);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
