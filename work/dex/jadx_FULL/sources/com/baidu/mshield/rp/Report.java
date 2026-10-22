package com.baidu.mshield.rp;

import android.content.Context;
import com.baidu.mshield.utility.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class Report {
    private static Report mReporter;
    private Context mContext;

    private Report(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized Report getInstance(Context context) {
        if (mReporter == null) {
            mReporter = new Report(context);
        }
        return mReporter;
    }

    public void fr() {
        try {
            b.a(this.mContext).a();
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public void i(String str, String str2, String str3, String str4, String str5) {
        try {
            com.baidu.mshield.utility.a.a(this.mContext, str, str2, str3, str4, str5);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public void n() {
        try {
            b.a(this.mContext).c();
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public void r(boolean z) {
        try {
            b.a(this.mContext).a(z);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public void s(String str) {
        try {
            com.baidu.mshield.b.c.a.b("send log : " + str);
            com.baidu.mshield.utility.a.b(this.mContext, str);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public void sr(String str) {
        try {
            com.baidu.mshield.b.c.a.b("send log : " + str);
            b.a(this.mContext).a(str);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public void w(String str) {
        try {
            com.baidu.mshield.utility.a.a(this.mContext, str);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }
}
