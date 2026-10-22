package com.kc.aw;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ci {
    public String _a;
    public String _b;
    public String _c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || _ci.class != obj.getClass()) {
            return false;
        }
        _ci _ciVar = (_ci) obj;
        String str = this._a;
        if (str == null ? _ciVar._a != null : !str.equals(_ciVar._a)) {
            return false;
        }
        String str2 = this._b;
        if (str2 == null ? _ciVar._b != null : !str2.equals(_ciVar._b)) {
            return false;
        }
        String str3 = this._c;
        String str4 = _ciVar._c;
        if (str3 != null) {
            return str3.equals(str4);
        }
        return str4 == null;
    }

    public final int hashCode() {
        String str = this._a;
        int iHashCode = str != null ? str.hashCode() : 0;
        String str2 = this._b;
        int iHashCode2 = str2 != null ? str2.hashCode() : 0;
        String str3 = this._c;
        return (((iHashCode * 31) + iHashCode2) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb_a = _mm._a(_mm._a(_jf._a("DispatchMock{mockPackageName='"), this._a, '\'', ", mockCsjAppId='"), this._b, '\'', ", mockGdtAppId='");
        sb_a.append(this._c);
        sb_a.append('\'');
        sb_a.append('}');
        return sb_a.toString();
    }
}
