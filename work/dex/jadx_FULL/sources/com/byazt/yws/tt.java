package com.byazt.yws;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 866, 13})
public abstract class tt {
    public uj c;
    public Context tt;

    public tt(Context context, String str) {
        try {
            this.tt = context == null ? gt.getContext() : context.getApplicationContext();
            if (this.c == null) {
                this.c = new uj(this.tt, str);
            }
        } catch (Throwable unused) {
        }
    }

    public uj c() {
        return this.c;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.hashCode();
        switch (str) {
            case "dpl_status_record":
            case "union_meta_cache":
            case "union_tmax_record":
            case "sdk_launch":
            case "meta_req_record_v1":
                return true;
            default:
                return false;
        }
    }
}
