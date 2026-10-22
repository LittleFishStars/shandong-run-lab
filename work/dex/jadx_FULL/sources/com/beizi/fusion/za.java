package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class za {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f28103a;

    public za(Context context) {
        this.f28103a = context.getApplicationContext();
    }

    public void a(String str, db dbVar, sa saVar) {
        a(str, dbVar, saVar, "101,1001");
    }

    public void a(String str, db dbVar, sa saVar, String str2) {
        if (TextUtils.isEmpty(str)) {
            a(km.ERROR_INVALID_URL, saVar);
            return;
        }
        if (dbVar == null) {
            a(km.ERROR_NULL_MODEL_BUILD, saVar);
            return;
        }
        xm xmVar = new xm(this.f28103a, true);
        xmVar.a(str2);
        String strA = dbVar.a();
        if (mg.a(strA)) {
            xmVar.a(str, ((id) dh.a().b(this.f28103a)).b(strA.getBytes(), str2, id.a.NOT_APPEND, true), saVar);
        } else {
            a(km.ERROR_EMPTY_CONTENT, saVar);
        }
    }

    public void a(km kmVar, sa saVar) {
        if (saVar != null) {
            saVar.a(kmVar);
        }
    }
}
