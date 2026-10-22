package com.fl.saas;

import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: renamed from: com.fl.saas.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class C1414i0 implements N {
    private String b(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return (iLastIndexOf == -1 || iLastIndexOf <= str.lastIndexOf(47) || iLastIndexOf + 6 <= str.length()) ? "" : str.substring(iLastIndexOf + 1, str.length());
    }

    @Override // com.fl.saas.N
    public String a(String str) {
        String strB = b(str);
        String strA = A0.a(str);
        if (TextUtils.isEmpty(strB)) {
            return strA;
        }
        return strA + Consts.DOT + strB;
    }
}
