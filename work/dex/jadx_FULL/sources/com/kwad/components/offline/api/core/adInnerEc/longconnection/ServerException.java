package com.kwad.components.offline.api.core.adInnerEc.longconnection;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Keep
public class ServerException extends Exception {
    private static final long serialVersionUID = 2951014432365816643L;
    public final int errorCode;
    public final String errorMessage;
    public final int subCode;

    public ServerException(int i, int i2, String str) {
        this.errorCode = i;
        this.subCode = i2;
        this.errorMessage = str;
    }
}
