package com.byazt.nys;

import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import com.zj.adlib.dv9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_LIKE, 46})
public class n {
    public static StringBuffer c = new StringBuffer();

    public static void c(String str, String str2) {
        StringBuffer stringBuffer = c;
        if (stringBuffer == null || str2 == null) {
            return;
        }
        try {
            if (stringBuffer.length() > 204800) {
                return;
            }
            StringBuffer stringBuffer2 = c;
            stringBuffer2.append(System.currentTimeMillis());
            stringBuffer2.append(dv9.e);
            stringBuffer2.append(str);
            stringBuffer2.append(dv9.e);
            stringBuffer2.append(str2);
            stringBuffer2.append('\n');
        } catch (Exception unused) {
        }
    }

    public static String tt() {
        StringBuffer stringBuffer = c;
        String string = stringBuffer != null ? stringBuffer.toString() : "";
        c = null;
        return string;
    }

    public static void c() {
        c = null;
    }
}
