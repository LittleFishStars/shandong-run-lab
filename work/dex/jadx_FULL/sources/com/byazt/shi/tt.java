package com.byazt.shi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.byazt.vb.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 991, 13})
public class tt implements a {
    public static final tt c = new tt();
    public volatile SQLiteDatabase tt;

    @Override // com.byazt.vb.a
    public String a() {
        return null;
    }

    @Override // com.byazt.vb.a
    public SQLiteDatabase c(Context context) {
        if (this.tt == null) {
            synchronized (this) {
                if (this.tt == null) {
                    this.tt = new c(context, this).getWritableDatabase();
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
