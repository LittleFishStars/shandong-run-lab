package com.zj.adlib;

import android.util.Log;
import com.facebook.common.logging.LoggingDelegate;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class bd3 implements LoggingDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bd3 f40727a = new bd3();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f15493a = "unknown";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f15492a = 5;

    public static bd3 h() {
        return f40727a;
    }

    public static String j(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public int a() {
        return this.f15492a;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void b(String str, String str2, Throwable th) {
        m(2, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void c(String str, String str2, Throwable th) {
        m(4, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void d(int i) {
        this.f15492a = i;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void e(String str, String str2) {
        l(6, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void f(String str, String str2, Throwable th) {
        m(6, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public boolean g(int i) {
        return this.f15492a <= i;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void i(String str, String str2) {
        l(4, str, str2);
    }

    public final String k(String str) {
        if (this.f15493a == null) {
            return str;
        }
        return this.f15493a + u15.f19942b + str;
    }

    public final void l(int i, String str, String str2) {
        Log.println(i, k(str), str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void log(int i, String str, String str2) {
        l(i, str, str2);
    }

    public final void m(int i, String str, String str2, Throwable th) {
        Log.println(i, k(str), i(str2, th));
    }

    public void n(String str) {
        this.f15493a = str;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void v(String str, String str2) {
        l(2, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void w(String str, String str2) {
        l(5, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void wtf(String str, String str2) {
        l(6, str, str2);
    }

    public static String i(String str, Throwable th) {
        return str + '\n' + j(th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void d(String str, String str2) {
        l(3, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void e(String str, String str2, Throwable th) {
        m(6, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void w(String str, String str2, Throwable th) {
        m(5, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void d(String str, String str2, Throwable th) {
        m(3, str, str2, th);
    }
}
