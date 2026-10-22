package com.beizi.fusion;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class zn extends v8 {
    private String d;

    public zn(String str) {
        super(false, false);
        this.d = str;
    }

    @Override // com.beizi.fusion.v8
    public String a() {
        return this.d;
    }

    public void b() {
        xn xnVarA = xn.a(a4.j().g());
        if (xnVarA.b(a4.j().g())) {
            executeOnExecutor(w3.c().g(), new Void[0]);
        } else {
            xnVarA.a(this.d, a4.j().g());
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(w8 w8Var) {
        if (w8Var == null || !w8Var.d()) {
            return;
        }
        int iA = w8Var.a();
        String strC = w8Var.c();
        if (iA != 302 || TextUtils.isEmpty(strC)) {
            return;
        }
        new zn(strC).b();
    }
}
