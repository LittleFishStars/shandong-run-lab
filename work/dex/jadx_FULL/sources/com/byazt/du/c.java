package com.byazt.du;

import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 441, 20})
public class c {
    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/images/");
        if (str.indexOf(Consts.DOT) > 0) {
            sb.append(str);
            return sb.toString();
        }
        sb.append(str);
        sb.append(".png");
        return sb.toString();
    }
}
