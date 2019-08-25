package com.djd.fun.techchapter.demo021Cipher;

/**
 * The intelligence service intercepted some ciphertexts.
 * It is known that plain text was encrypted using a cyclical shift method (Ceasar method).
 * The idea of this method is that every letter in the plain text substituted with another
 * letter with the fixed distance DIST. For example, for DIST=2 letter D will be replaced
 * with F, Q with S and Z with B. It is known the enemy uses DIST= [0-25] and only
 * English alphabet capital letters. Also, every message uses different DIST to make
 * communication more secure.  After hard work cryptographers could uncover partial content of
 * the messages, now we can tell one of the words included for every message.
 * <p>
 * Input data:
 * In the first line, there is ciphertext intercepted by security service,
 * in the second line is the plaintext word from the message.
 * Both lines only contain English capitalized letters. Both lines are at most 40 letters length.
 * <p>
 * Output Data:
 * Print the decrypted text or "IMPOSSIBLE" if ciphertext cannot be decrypted.
 * If more then 1 DIST can be used to decrypt the ciphertext,
 * print the text associated with the lowest DIST.
 * <p>
 * test:
 * 1
 * Input:
 * HELLOAMERICA
 * AMERICA
 * Output:
 * HELLOAMERICA
 * <p>
 * 2.
 * Input:
 * KHOORDPHULFD
 * HELLOAMERICA
 * Output:
 * HELLOAMERICA
 * <p>
 * 3.
 * Input:
 * KHOORDPHULFD
 * KHOORDPHULFC
 * Output:
 * IMPOSSIBLE
 */
public class SimpleCipher {
  // Goal is to find DIST number which decipher the text.
  // Step 1: interactively check the plaintext partial string inside ciphered message.
  // Step 2: if all letters in plain test match then stop then print the deciphered msg.
  // Step 3: if none of DIST number can create text that match with plaintext then print "IMPOSSIBLE"
  public static void main(String args[]) {
    String cipherText = "BA";
    String plainText = "A";

    for (int dist = 0; dist <= 25; dist++) {
      StringBuilder decipheredMsg = new StringBuilder();
      for (char letter : cipherText.toCharArray()) {
        char targetLetter = (char)(((letter - 'A' + dist) % 26) + 'A');
        decipheredMsg.append(targetLetter);
      }
      String decipheredString = decipheredMsg.toString();
      if (decipheredString.contains(plainText)) {
        //O(N) linear search algo? KMP??? Knuth Morrison Pratt ?
        //BUT in Java contains is N^2
        System.out.println(decipheredString);
        return;
      }
    }
    System.out.println("IMPOSSIBLE");
  }
}
