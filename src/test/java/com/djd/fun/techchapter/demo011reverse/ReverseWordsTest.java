package com.djd.fun.techchapter.demo011reverse;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

/**
 * @author ninja
 * @since 08/11/2017
 */
public class ReverseWordsTest {

  @Test
  public void reverseWords() {
    char[] input = "I am very happy".toCharArray(); // mutable array
    ReverseWords.reverseWords(input);
    assertThat(input).isEqualTo("happy very am I".toCharArray());
  }

  @Test
  public void reverseWords_whiteSpaceSuffix() {
    char[] input = "happy ".toCharArray(); // mutable array
    ReverseWords.reverseWords(input);
    assertThat(input).isEqualTo("happy ".toCharArray());
  }

  @Test
  public void reverseWords_whiteSpacePrefix() {
    char[] input = " happy".toCharArray(); // mutable array
    ReverseWords.reverseWords(input);
    assertThat(input).isEqualTo(" happy".toCharArray());
  }

  @Test
  public void reverseWords_singleWord() {
    char[] input = "happy".toCharArray(); // mutable array
    ReverseWords.reverseWords(input);
    assertThat(input).isEqualTo("happy".toCharArray());
  }

  @Test
  public void reverseWords_empty() {
    ReverseWords.reverseWords(new char[0]);
  }

  @Test
  public void reverseWords_null() {
    ReverseWords.reverseWords(null);
  }

  @Test
  public void reverseWords_singleChar() {
    char[] input = new char[] {'a'};
    ReverseWords.reverseWords(input);
    assertThat(input).hasLength(1);
    assertThat(input).isEqualTo(new char[] {'a'});
  }
}
