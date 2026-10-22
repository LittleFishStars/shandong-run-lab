package com.byazt.ds;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 145})
public class my extends ve {
    public final Context n;

    public my(Context context) {
        super(true, false);
        this.n = context;
    }

    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws JSONException {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        Signature signature;
        String strTt = null;
        try {
            packageInfo = this.n.getPackageManager().getPackageInfo(this.n.getPackageName(), 64);
        } catch (Throwable th) {
            com.byazt.yv.da.tt(th);
            packageInfo = null;
        }
        if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null) {
            strTt = com.byazt.yv.ve.tt(signature.toByteArray());
        }
        if (strTt == null) {
            return true;
        }
        jSONObject.put("sig_hash", strTt);
        return true;
    }
}
