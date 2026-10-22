package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _h0 extends Exception {
    public HttpURLConnection _a;

    public _h0(String str) {
        super(str);
    }

    public _h0(String str, HttpURLConnection httpURLConnection) {
        super(str);
        this._a = httpURLConnection;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        StringBuilder sb = new StringBuilder(String.valueOf(super.getMessage()));
        try {
            if (this._a != null) {
                sb.append(' ');
                sb.append('[');
                sb.append(this._a.toString());
                sb.append(']');
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return getMessage();
    }
}
