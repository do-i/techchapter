package com.djd.fun.techchapter.demo016;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;


public class StringCompressTest {

  @Test
  public void compress_null() {
    assertThat(StringCompress.compress(null)).isNull();
  }

  @Test
  public void compress_empty() {
    assertThat(StringCompress.compress("")).isEqualTo("");
  }

  @Test
  public void compress_singleChar() {
    assertThat(StringCompress.compress("a")).isEqualTo("a");
  }

  @Test
  public void compress_twoSameChars() {
    assertThat(StringCompress.compress("aa")).isEqualTo("aa");
  }

  @Test
  public void compress_twoDiffChars() {
    assertThat(StringCompress.compress("ab")).isEqualTo("ab");
  }

  @Test
  public void compress_threeDiffChars() {
    assertThat(StringCompress.compress("abc")).isEqualTo("abc");
  }

  @Test
  public void compress_threeSameChars() {
    assertThat(StringCompress.compress("aaa")).isEqualTo("a3");
  }

  @Test
  public void compress_dddooog_d3o3g1() {
    assertThat(StringCompress.compress("dddooog")).isEqualTo("d3o3g1");
  }
}