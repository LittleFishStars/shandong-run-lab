package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _d5 implements Serializable {
    public String _a;
    public String _b;
    public long _e = -1;
    public File _c = null;
    public String _d = "";

    public _d5(String str, String str2) {
        this._b = str;
        this._a = str2;
    }

    public final File _a() {
        return this._c;
    }

    public final String _b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._b);
        File file = this._c;
        sb.append(file == null ? "" : file.getAbsolutePath());
        return sb.toString();
    }

    public final String _c() {
        return this._b;
    }
}
