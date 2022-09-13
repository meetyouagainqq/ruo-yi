package com.javasm.sys.util;

import com.javasm.commons.enums.E;
import com.javasm.sys.enums.DepartEnum;

public class DepartException extends RuntimeException {
    private DepartEnum e;

    public DepartException(DepartEnum e) {
        this.e = e;
    }

    public DepartEnum getE() {
        return e;
    }

    public void setE(DepartEnum e) {
        this.e = e;
    }
}