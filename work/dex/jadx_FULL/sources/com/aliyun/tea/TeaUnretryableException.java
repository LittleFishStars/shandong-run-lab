package com.aliyun.tea;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class TeaUnretryableException extends RuntimeException {
    private static final long serialVersionUID = -7006694712718176751L;
    private TeaRequest lastRequest;

    public TeaUnretryableException(TeaRequest teaRequest, Throwable th) {
        super(th.getMessage(), th);
        this.lastRequest = teaRequest;
    }

    public TeaRequest getLastRequest() {
        return this.lastRequest;
    }

    public TeaUnretryableException(TeaRequest teaRequest) {
        this.lastRequest = teaRequest;
    }

    public TeaUnretryableException(Throwable th) {
        super(th);
        this.lastRequest = null;
    }

    public TeaUnretryableException() {
        this.lastRequest = null;
    }
}
