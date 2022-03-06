package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    // 요구사항 1
    @Test
    void split(){
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1","2");
        assertThat(actual).containsExactly("1","2");
    }
    // 요구사항 2
    @Test
    void substring(){
        String actual = "(1,2)";
        actual = actual.substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }

    // 요구사항 3
    @DisplayName("StringIndexOutOfBoundsException")
    @Test
    void charAt(){
        String actual = "abc";

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    assertThat(actual.charAt(4)).isEqualTo('b');
                }).withMessageMatching("Index: \\d+, Size: \\d+");
    }
}
