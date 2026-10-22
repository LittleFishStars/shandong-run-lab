package com.byazt.sy;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 528, 158})
public class sl extends com.byazt.dy.c {
    public final float[] vp;
    public String yo;

    public sl(Context context) {
        super(context);
        this.vp = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    }

    private void sl(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strTrim = str.trim();
        if (strTrim.length() <= 2 || (strArrSplit = strTrim.substring(1, strTrim.length() - 1).split(",")) == null || strArrSplit.length != 4) {
            return;
        }
        for (int i = 0; i < strArrSplit.length; i++) {
            String str2 = strArrSplit[i];
            if (!TextUtils.isEmpty(str2)) {
                try {
                    this.vp[i] = Float.parseFloat(com.byazt.qk.c.c(str2.trim(), this.uj));
                } catch (NumberFormatException e) {
                    m.c(e);
                }
            }
        }
    }

    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        if (TextUtils.equals(str, "clickableInteract")) {
            this.yo = str2;
        } else {
            super.c(str, str2);
        }
    }

    public float[] q() {
        return this.vp;
    }

    @Override // com.byazt.dy.c, com.byazt.xj.c, com.byazt.xj.ve
    public void tt() {
        sl(this.yo);
        super.tt();
    }
}
