package com.byazt.te;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 14, 15})
public class uj extends c {
    public String kz;
    public int mq;
    public String vi;

    public uj(Context context) {
        super(context);
    }

    @Override // com.byazt.te.c
    public void c(int i, int i2, int i3) {
        if (i3 <= 0 && !TextUtils.isEmpty(((c) this).vp)) {
            String str = ((c) this).vp;
            ((com.byazt.sm.tt) this).c = str;
            sl(str);
            return;
        }
        int i4 = this.mq;
        int i5 = i4 - i2;
        if (i4 <= 0 || i5 <= 0) {
            ((com.byazt.sm.tt) this).c = this.vi;
        } else {
            ((com.byazt.sm.tt) this).c = this.kz;
        }
        String strReplace = ((com.byazt.sm.tt) this).c.replace("${_countdownTime_}", String.valueOf(i5)).replace("${_remainTime_}", String.valueOf(i3));
        ((com.byazt.sm.tt) this).c = strReplace;
        sl(strReplace);
    }

    @Override // com.byazt.te.c, com.byazt.sm.tt, com.byazt.xj.ve
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        switch (str) {
            case "text1":
                this.kz = str2;
                break;
            case "text2":
                this.vi = str2;
                break;
            case "startCountDown":
                this.mq = com.byazt.cd.ve.c(str2, -1);
                break;
        }
    }
}
