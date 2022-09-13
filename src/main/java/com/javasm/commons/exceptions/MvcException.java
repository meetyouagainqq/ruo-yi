package com.javasm.commons.exceptions;

import com.javasm.commons.enums.E;

public class MvcException extends RuntimeException {
    private E e;

    public MvcException(E e) {
        this.e = e;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}
