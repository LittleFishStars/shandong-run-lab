package com.byazt.h;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.android.arouter.utils.Consts;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 518, 137})
public class nu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28595a;
    public final String c;
    public final AtomicLong da;
    public String i;
    public final List<u> n;
    public boolean sp;
    public final String tt;
    public final boolean uj;
    public final String ve;
    public int x;

    public nu(String str, boolean z) {
        this.n = new ArrayList();
        this.da = new AtomicLong();
        this.c = str;
        this.uj = z;
        this.tt = null;
        this.ve = null;
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int iLastIndexOf = str.lastIndexOf(Consts.DOT);
            if (iLastIndexOf <= 0 || iLastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, iLastIndexOf);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
            return null;
        }
    }

    private String n() {
        if (this.i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.c);
            sb.append(LoginConstants.UNDER_LINE);
            String str = this.tt;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append(LoginConstants.UNDER_LINE);
            sb.append(this.uj);
            this.i = sb.toString();
        }
        return this.i;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof nu) {
            return n().equals(((nu) obj).n());
        }
        return false;
    }

    public int hashCode() {
        if (this.x == 0) {
            this.x = n().hashCode();
        }
        return this.x;
    }

    public String toString() {
        return "UrlRecord{url='" + this.c + "', ip='" + this.tt + "', ipFamily='" + this.ve + "', isMainUrl=" + this.uj + ", failedTimes=" + this.f28595a + ", isCurrentFailed=" + this.sp + '}';
    }

    public synchronized void tt(u uVar) {
        try {
            this.n.remove(uVar);
        } catch (Throwable unused) {
        }
    }

    public synchronized boolean uj() {
        return this.sp;
    }

    public synchronized void ve() {
        this.sp = false;
    }

    public synchronized void tt() {
        this.f28595a++;
        this.sp = true;
    }

    public synchronized void c(u uVar) {
        this.n.add(uVar);
    }

    public nu(String str, String str2) {
        this.n = new ArrayList();
        this.da = new AtomicLong();
        this.c = str;
        this.uj = false;
        this.tt = str2;
        this.ve = c(str2);
    }

    public synchronized int c() {
        return this.n.size();
    }

    public void c(long j) {
        this.da.addAndGet(j);
    }
}
