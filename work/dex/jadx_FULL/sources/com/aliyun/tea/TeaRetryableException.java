package com.aliyun.tea;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class TeaRetryableException extends TeaException {
    private static final long serialVersionUID = 3883312421128465122L;

    public TeaRetryableException(Throwable th) {
        super("", th);
        this.message = th.getMessage();
    }

    public TeaRetryableException(Map<String, ?> map) {
        super(map);
    }

    public TeaRetryableException() {
    }
}
