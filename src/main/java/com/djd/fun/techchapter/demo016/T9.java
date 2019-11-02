package com.djd.fun.techchapter.demo016;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;

/**
 * 16.20 T9: On old cell phones, users typed on a numeric keypad and the phone would provide a list
 * of words that matched these numbers. Each digit mapped to a set of 0-4 letters. Implement an
 * algorithm to return a list of matching words, given a sequence of digits. You are provided a list
 * of valid words (provided in whatever data structure you'd like). The mapping is shown below:
 *
 * <pre><code>
 * 1: []
 * 2: [a,b,c]
 * 3: [d,e,f]
 * 4: [g,h,i]
 * 5: [j,k,l]
 * 6: [m,n,o]
 * 7: [p,q,r,s]
 * 8: [t,u,v]
 * 9: [w,x,y,z]
 * 0: []
 * </code></pre>
 *
 * <p>Example: Input: 8733 Output: tree, used
 *
 * <p>from CtCI 6th ed
 */
public class T9 {

  private static final char[] EMPTY = new char[0];

  private static final ImmutableMap<Character, ImmutableList<Character>> LETTER_MAP =
      ImmutableMap.<Character, ImmutableList<Character>>builder()
          .put('0', ImmutableList.of())
          .put('1', ImmutableList.of())
          .put('2', ImmutableList.of('a', 'b', 'c'))
          .put('3', ImmutableList.of('d', 'e', 'f'))
          .put('4', ImmutableList.of('g', 'h', 'i'))
          .put('5', ImmutableList.of('j', 'k', 'l'))
          .put('6', ImmutableList.of('m', 'n', 'o'))
          .put('7', ImmutableList.of('p', 'q', 'r', 's'))
          .put('8', ImmutableList.of('t', 'u', 'v'))
          .put('9', ImmutableList.of('w', 'x', 'y', 'z'))
          .build();

  private static final ImmutableList<ImmutableList<Character>> LETTERS =
      ImmutableList.<ImmutableList<Character>>builder()
          .add(ImmutableList.of())
          .add(ImmutableList.of())
          .add(ImmutableList.of('a', 'b', 'c'))
          .add(ImmutableList.of('d', 'e', 'f'))
          .add(ImmutableList.of('g', 'h', 'i'))
          .add(ImmutableList.of('j', 'k', 'l'))
          .add(ImmutableList.of('m', 'n', 'o'))
          .add(ImmutableList.of('p', 'q', 'r', 's'))
          .add(ImmutableList.of('t', 'u', 'v'))
          .add(ImmutableList.of('w', 'x', 'y', 'z'))
          .build();

  public List<String> toWords(int digits) {
    if (digits < 0) {
      throw new IllegalArgumentException("digits should be non-negative number");
    }
    char[] digitChars = toDigitChars(digits);

    // 8733
    List<String> resultWords = new ArrayList<>();
    resultWords.add("");
    for (char digit : digitChars) {
      for (char letter : toLetters(digit)) {
        for (String word : resultWords) {
          String wordCandidate = word + letter;
          if (exists(wordCandidate)) {
            // found
          } else {
            // not found
          }
        }
      }
    }
    throw new UnsupportedOperationException("TODO");
  }

  private static boolean exists(String word) {
    // TODO implement Trie data structure
    return false;
  }

  /**
   * Converts digits to char array
   *
   * @param digits
   * @return char array representation of digits
   */
  @VisibleForTesting
  static char[] toDigitChars(int digits) {
    return String.valueOf(digits).toCharArray();
  }

  /**
   * @param digit 0-9
   * @return mapped chars
   */
  @VisibleForTesting
  static ImmutableList<Character> toLetters(char digit) {
    if (digit >= 0 && digit <= 9) {
      throw new IllegalArgumentException("it is not a valid digit: " + digit);
    }
    return LETTERS.get(digit);
  }
}
