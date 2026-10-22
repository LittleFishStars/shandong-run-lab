package com.byazt.twu;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 970, 20})
public class c extends sp {
    public c(Context context, com.byazt.rz.c cVar, com.byazt.vb.n nVar) {
        super(context, cVar, nVar);
    }

    public static String tt(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    public static String ve(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }

    @Override // com.byazt.twu.sp, com.byazt.twu.tt
    public String c() {
        return ((sp) this).tt.tt().n();
    }

    @Override // com.byazt.twu.sp
    public byte tt() {
        return (byte) 1;
    }

    @Override // com.byazt.twu.sp
    public byte ve() {
        return (byte) 3;
    }

    @Override // com.byazt.twu.sp, com.byazt.uf.c
    public boolean c(com.byazt.vb.tt ttVar) {
        return com.byazt.ml.c.sp(ttVar);
    }
}
