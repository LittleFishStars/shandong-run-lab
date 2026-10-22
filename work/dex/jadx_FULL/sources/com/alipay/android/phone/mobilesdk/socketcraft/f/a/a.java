package com.alipay.android.phone.mobilesdk.socketcraft.f.a;

import com.zj.adlib.u15;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements c {
    private String g(String str, String str2) {
        return new Date().toLocaleString() + " " + Thread.currentThread().getId() + " " + Thread.currentThread().getName() + " " + str2 + " " + str + " ";
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void a(String str, String str2) {
        a(g(str, "I") + u15.f19942b + str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void b(String str, String str2) {
        a(g(str, "V") + u15.f19942b + str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void c(String str, String str2) {
        a(g(str, "D") + u15.f19942b + str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void d(String str, String str2) {
        a(g(str, "W") + u15.f19942b + str2);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void e(String str, String str2) {
        d(g(str, "E") + u15.f19942b + str2, (Throwable) null);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void f(String str, String str2) {
        a(str, str2);
    }

    private void d(String str, Throwable th) {
        if (th != null) {
            str = str + " " + a(th);
        }
        a(str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void a(String str, Throwable th) {
        d(g(str, "W"), th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void b(String str, Throwable th) {
        d(g(str, "E"), th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void c(String str, Throwable th) {
        b(str, th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void a(String str, String str2, Throwable th) {
        d(g(str, "W") + u15.f19942b + str2, th);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.a.c
    public void b(String str, String str2, Throwable th) {
        d(g(str, "E") + u15.f19942b + str2, th);
    }

    private void a(String str) {
        try {
            Object obj = System.class.getField("out").get(System.class);
            obj.getClass().getMethod("println", String.class).invoke(obj, str);
        } catch (Throwable unused) {
        }
    }

    public String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th.getClass().getMethod(String.format("%s%s%s", "print", "Stack", "Trace"), PrintWriter.class).invoke(th, printWriter);
            printWriter.flush();
        } catch (Throwable unused) {
        }
        return stringWriter.toString();
    }
}
