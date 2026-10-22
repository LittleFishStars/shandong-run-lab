package com.kc.cw.ad.internal.d.a;

import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.kc.cw.ad.internal.d.q;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f implements c {
    private String b(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return (iLastIndexOf == -1 || iLastIndexOf <= str.lastIndexOf(47) || (iLastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(iLastIndexOf + 1, str.length());
    }

    @Override // com.kc.cw.ad.internal.d.a.c
    public String a(String str) {
        String strB = b(str);
        String strD = q.d(str);
        if (TextUtils.isEmpty(strB)) {
            return strD;
        }
        return strD + Consts.DOT + strB;
    }
}
