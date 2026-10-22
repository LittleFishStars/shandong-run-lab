package com.byazt.kr;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.byazt.mg.da;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1478, 20})
public class c {
    public static volatile c c;
    public com.byazt.tj.tt tt;
    public SQLiteDatabase ve;

    private c() {
    }

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public void c(Context context) {
        try {
            this.ve = new tt(context).getWritableDatabase();
        } catch (Throwable th) {
            da.tt(th);
        }
        this.tt = new com.byazt.tj.tt();
    }

    public synchronized void c(com.byazt.bk.c cVar) {
        com.byazt.tj.tt ttVar = this.tt;
        if (ttVar != null) {
            ttVar.insert(this.ve, cVar);
        }
    }

    public synchronized boolean c(String str) {
        com.byazt.tj.tt ttVar = this.tt;
        if (ttVar == null) {
            return false;
        }
        return ttVar.c(this.ve, str);
    }
}
