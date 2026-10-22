package cj.mobile.wm;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class aa {
    public final String dexa;
    public final String dexb;

    public aa(String str, String str2) {
        this.dexa = str;
        this.dexb = str2;
    }

    public final String dexa() {
        return this.dexa;
    }

    public final String dexb() {
        return this.dexb;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || aa.class != obj.getClass()) {
            return false;
        }
        aa aaVar = (aa) obj;
        return TextUtils.equals(this.dexa, aaVar.dexa) && TextUtils.equals(this.dexb, aaVar.dexb);
    }

    public int hashCode() {
        return (this.dexa.hashCode() * 31) + this.dexb.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.dexa + ",value=" + this.dexb + "]";
    }
}
