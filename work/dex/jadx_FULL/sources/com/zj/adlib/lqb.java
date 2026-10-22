package com.zj.adlib;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.alipay.sdk.m.u0.c;
import com.bwt.top.cn_oaid.OAIDException;
import com.bwt.top.cn_oaid.ddksa;
import com.bwt.top.cn_oaid.dkkd;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class lqb implements dkkd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f43132a;

    public lqb(Context context) {
        this.f43132a = context;
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return pqb.m(c.c, "0").equals("1");
    }

    @Override // com.bwt.top.cn_oaid.dkkd
    public void b(ddksa ddksaVar) {
        if (this.f43132a == null || ddksaVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f43132a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            try {
                Objects.requireNonNull(cursorQuery);
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                if (string == null || string.length() == 0) {
                    throw new OAIDException("OAID query failed");
                }
                ija.a("OAID query success: " + string);
                ddksaVar.a(string);
                cursorQuery.close();
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            ija.a(e);
            ddksaVar.b(e);
        }
    }
}
