package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // test 구현

    //요구사항1
    @Test
    void size(){
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    // 요구사항 2
    @Test
    void Numbers() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    void numbersContainTest(int number) {
        assertTrue(numbers.contains(number));
    }

    // 요구사항3
    @DisplayName("csv test")
    @ParameterizedTest
    @CsvSource({"1,true","2,4","3,5"})
    void isNumberCsvContainTest(int number,int number2){
        assertTrue(numbers.contains(number));
        assertTrue(numbers.contains(number2));
    }
}
