package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b {
    private String b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f37463a = 4;
    private d c = new c();

    public void a(Context context, int i, String str) {
        this.f37463a = i;
        this.b = str;
        this.c.a(context, "HMSCore");
    }

    public void b(int i, String str, String str2, Throwable th) {
        try {
            if (a(i)) {
                e eVarA = a(i, str, str2, th);
                String str3 = eVarA.c() + eVarA.a();
                this.c.a(str3, i, str, str2 + '\n' + Log.getStackTraceString(th));
            }
        } catch (OutOfMemoryError unused) {
            b();
        }
    }

    public d a() {
        return this.c;
    }

    public void a(d dVar) {
        this.c = dVar;
    }

    private void b() {
        try {
            Log.e("HMSSDK_LogAdaptor", "log happened OOM error.");
        } catch (Throwable unused) {
        }
    }

    public boolean a(int i) {
        return i >= this.f37463a;
    }

    public void a(int i, String str, String str2) {
        try {
            if (a(i)) {
                e eVarA = a(i, str, str2, null);
                this.c.a(eVarA.c() + eVarA.a(), i, str, str2);
            }
        } catch (OutOfMemoryError unused) {
            b();
        }
    }

    public void a(String str, String str2) {
        try {
            e eVarA = a(4, str, str2, null);
            this.c.a(eVarA.c() + '\n' + eVarA.a(), 4, str, str2);
        } catch (OutOfMemoryError unused) {
            b();
        }
    }

    private e a(int i, String str, String str2, Throwable th) {
        e eVar = new e(8, this.b, i, str);
        eVar.a(str2);
        eVar.a(th);
        return eVar;
    }
}
