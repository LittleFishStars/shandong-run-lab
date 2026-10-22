package com.kwad.components.core.webview.tachikoma.c;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class y extends com.kwad.sdk.core.response.a.a {
    public String auA;
    public int errorCode;
    public String errorReason;
    public int rq;

    public final boolean isFailed() {
        return TextUtils.equals(com.alipay.sdk.m.y.k.j, this.auA);
    }

    public final boolean zr() {
        return TextUtils.equals("start", this.auA);
    }

    public final boolean zs() {
        return TextUtils.equals("end", this.auA);
    }

    public final boolean zt() {
        return TextUtils.equals("progress", this.auA);
    }

    public final boolean zu() {
        return TextUtils.equals("pause", this.auA);
    }

    public final boolean zv() {
        return TextUtils.equals("resume", this.auA);
    }

    public final int zw() {
        try {
            return (int) Long.parseLong(this.errorReason);
        } catch (NumberFormatException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return 0;
        }
    }
}
