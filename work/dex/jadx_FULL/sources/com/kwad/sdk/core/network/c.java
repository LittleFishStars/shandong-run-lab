package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c {
    public int aSW = -1;
    public Exception aSX;
    public String aSY;
    public int code;

    public final boolean Mf() {
        return this.code == 200;
    }

    @NonNull
    public final String toString() {
        return "BaseResponse{code=" + this.code + ", rawCode=" + this.aSW + ", rawException=" + this.aSX + ", body='" + this.aSY + "'}";
    }
}
