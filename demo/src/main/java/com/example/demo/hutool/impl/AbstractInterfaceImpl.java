package com.example.demo.hutool.impl;

import com.example.demo.hutool.AbstratctInterface;
import org.junit.jupiter.api.Test;

public class AbstractInterfaceImpl extends AbstratctInterface {
    @Test
    @Override
    public void abfun1() {
        super.abfun2();
    }
}
