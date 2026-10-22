package com.aliyun.credentials.exception;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CredentialException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 634786425123290588L;

    public CredentialException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage();
    }

    public CredentialException(String str, Throwable th) {
        super(str, th);
    }
}
