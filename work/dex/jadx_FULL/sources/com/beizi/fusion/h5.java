package com.beizi.fusion;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class h5 extends v8 {
    private String d;

    public h5(String str) {
        super(false, false);
        this.d = str;
    }

    @Override // com.beizi.fusion.v8
    public String a() {
        return this.d;
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
        new h5(strC).execute(new Void[0]);
    }
}
