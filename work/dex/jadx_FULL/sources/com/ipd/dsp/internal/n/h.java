package com.ipd.dsp.internal.n;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class h implements com.ipd.dsp.internal.f.f {
    public static final String j = "@#&=*+-_.,:!?()/~'%;$";
    public final i c;

    @Nullable
    public final URL d;

    @Nullable
    public final String e;

    @Nullable
    public String f;

    @Nullable
    public URL g;

    @Nullable
    public volatile byte[] h;
    public int i;

    public h(URL url) {
        this(url, i.b);
    }

    public String a() {
        String str = this.e;
        return str != null ? str : ((URL) com.ipd.dsp.internal.d0.m.a(this.d)).toString();
    }

    public final byte[] b() {
        if (this.h == null) {
            this.h = a().getBytes(com.ipd.dsp.internal.f.f.b);
        }
        return this.h;
    }

    public Map<String, String> c() {
        return this.c.a();
    }

    public final String d() {
        if (TextUtils.isEmpty(this.f)) {
            String string = this.e;
            if (TextUtils.isEmpty(string)) {
                string = ((URL) com.ipd.dsp.internal.d0.m.a(this.d)).toString();
            }
            this.f = Uri.encode(string, j);
        }
        return this.f;
    }

    public final URL e() throws MalformedURLException {
        if (this.g == null) {
            this.g = new URL(d());
        }
        return this.g;
    }

    @Override // com.ipd.dsp.internal.f.f
    public boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (a().equals(hVar.a()) && this.c.equals(hVar.c)) {
                return true;
            }
        }
        return false;
    }

    public String f() {
        return d();
    }

    public URL g() throws MalformedURLException {
        return e();
    }

    @Override // com.ipd.dsp.internal.f.f
    public int hashCode() {
        if (this.i == 0) {
            int iHashCode = a().hashCode();
            this.i = iHashCode;
            this.i = (iHashCode * 31) + this.c.hashCode();
        }
        return this.i;
    }

    public String toString() {
        return a();
    }

    public h(String str) {
        this(str, i.b);
    }

    @Override // com.ipd.dsp.internal.f.f
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(b());
    }

    public h(URL url, i iVar) {
        this.d = (URL) com.ipd.dsp.internal.d0.m.a(url);
        this.e = null;
        this.c = (i) com.ipd.dsp.internal.d0.m.a(iVar);
    }

    public h(String str, i iVar) {
        this.d = null;
        this.e = com.ipd.dsp.internal.d0.m.a(str);
        this.c = (i) com.ipd.dsp.internal.d0.m.a(iVar);
    }
}
