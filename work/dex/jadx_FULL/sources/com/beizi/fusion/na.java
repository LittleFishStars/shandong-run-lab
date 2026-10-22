package com.beizi.fusion;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class na extends eb {
    private String c;

    public na(Context context, boolean z) {
        super(context, z);
        this.c = "101,1001";
    }

    public void a(String str) {
        this.c = str;
    }

    @Override // com.beizi.fusion.eb
    public q5 a(cm cmVar, String str, sa saVar) {
        q5 q5VarA = super.a(cmVar, str, saVar);
        if (q5VarA == null) {
            return super.a(cmVar, str, saVar);
        }
        q5VarA.a("Accept-Encrypt", this.c);
        return q5VarA;
    }
}
