package com.zj.adlib;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import cn.hzjizhun.admin.cn_oaid.OAIDException;
import cn.hzjizhun.admin.ddakd;
import cn.hzjizhun.admin.dddssad;
import cn.hzjizhun.admin.dkdkadssa;
import cn.hzjizhun.admin.sdkdda;
import com.alipay.sdk.m.u0.c;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class cia implements sdkdda {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f40974a;

    public cia(Context context) {
        this.f40974a = context;
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return dkdkadssa.m(c.c, "0").equals("1");
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public void b(ddakd ddakdVar) {
        if (this.f40974a == null || ddakdVar == null) {
            return;
        }
        try {
            Cursor cursorQuery = this.f40974a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            try {
                Objects.requireNonNull(cursorQuery);
                cursorQuery.moveToFirst();
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                if (string == null || string.length() == 0) {
                    throw new OAIDException("OAID query failed");
                }
                dddssad.a("OAID query success: " + string);
                ddakdVar.a(string);
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
        } catch (Throwable th3) {
            dddssad.a(th3);
            ddakdVar.b(th3);
        }
    }
}
