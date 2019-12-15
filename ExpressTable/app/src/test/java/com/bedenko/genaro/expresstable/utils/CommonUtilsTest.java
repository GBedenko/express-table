package com.bedenko.genaro.expresstable.utils;

/*
  Created by Genaro Bedenko
  
  @author gbedenko
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class CommonUtilsTest {

    @Test
    public void md5Hash() {
        CommonUtils commonUtils = new CommonUtils();

        String testHash = commonUtils.md5Hash("test_input");
        assertTrue(testHash.getClass().equals(String.class));
    }
}