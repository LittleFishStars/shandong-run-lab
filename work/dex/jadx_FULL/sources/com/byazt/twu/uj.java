package com.byazt.twu;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 970, 15})
public class uj extends a {
    public uj(Context context, com.byazt.rz.c cVar, com.byazt.vb.n nVar) {
        super(context, cVar, nVar);
    }

    public static String tt(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    public static String ve(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }

    @Override // com.byazt.twu.a, com.byazt.twu.tt
    public String c() {
        com.byazt.vb.a aVarTt = ((a) this).tt.tt();
        if (aVarTt != null) {
            return aVarTt.c();
        }
        return null;
    }

    @Override // com.byazt.twu.a
    public byte tt() {
        return (byte) 1;
    }

    @Override // com.byazt.twu.a
    public byte ve() {
        return (byte) 0;
    }

    @Override // com.byazt.twu.a, com.byazt.uf.c
    public boolean c(com.byazt.vb.tt ttVar) {
        return com.byazt.ml.c.ve(ttVar);
    }
}
