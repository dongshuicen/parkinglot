package com.test;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.Java6Assertions.assertThat;

class ObjectsTest {
    @Test
    void objects_equals_should_return_false_when_str1_null_str2_not_null(){
        String str1 = null;
        String str2 = "111";
        boolean b = Objects.equals(str1,str2);
        assertThat(b).isEqualTo(false);
    }
    @Test
    void objects_equals_should_return_false_when_str1_not_null_str2_null(){
        String str1 = "null";
        String str2 = null;
        boolean b = Objects.equals(str1,str2);
        assertThat(b).isEqualTo(false);
    }
    @Test
    void objects_equals_should_return_true_when_str1_equals_str2(){
        String str1 = "null";
        String str2 = "null";
        boolean b = Objects.equals(str1,str2);
        assertThat(b).isEqualTo(true);
    }

}