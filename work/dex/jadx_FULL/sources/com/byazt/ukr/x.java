package com.byazt.ukr;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1081, 71})
public class x implements com.byazt.vb.a {
    public static final x c = new x();
    public volatile SQLiteDatabase tt;

    @Override // com.byazt.vb.a
    public String a() {
        return null;
    }

    @Override // com.byazt.vb.a
    public SQLiteDatabase c(Context context) {
        if (this.tt == null) {
            synchronized (x.class) {
                if (this.tt == null) {
                    com.byazt.yws.uj ujVarC = com.byazt.yws.ve.c(gt.getContext()).c();
                    ujVarC.c();
                    this.tt = ujVarC.tt();
                }
            }
        }
        return this.tt;
    }

    @Override // com.byazt.vb.a
    public String c() {
        return "loghighpriority";
    }

    @Override // com.byazt.vb.a
    public String n() {
        return "logstatsbatch";
    }

    @Override // com.byazt.vb.a
    public String tt() {
        return "adevent";
    }

    @Override // com.byazt.vb.a
    public String uj() {
        return "logstats";
    }

    @Override // com.byazt.vb.a
    public String ve() {
        return null;
    }
}
