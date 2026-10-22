package com.zj.adlib;

import java.io.Closeable;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c30 {
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 4;
    public static final int g = 5;
    public static final int h = -101;
    public static final int i = -102;
    public static final int j = -103;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f40889a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f15708a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Closeable f15709a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public File f15710a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f15711a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Date f15712a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DefaultHttpClient f15713a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HttpContext f15714a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15715a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f15716a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Header[] f15717a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f15718b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f15719b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f15720b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f15721c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f15722c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f15723d;

    public c30() {
        this.f40889a = 200;
        this.f15711a = "OK";
        this.f15712a = new Date();
        this.b = 1;
        this.f15718b = System.currentTimeMillis();
    }

    public void a() {
        gq.f(this.f15709a);
        this.f15709a = null;
    }

    public c30 b(int i2) {
        this.f40889a = i2;
        return this;
    }

    public c30 c() {
        this.f15708a = System.currentTimeMillis() - this.f15718b;
        this.f15720b = true;
        this.f15723d = false;
        return this;
    }

    public c30 client(DefaultHttpClient defaultHttpClient) {
        this.f15713a = defaultHttpClient;
        return this;
    }

    public void closeLater(Closeable closeable) {
        this.f15709a = closeable;
    }

    public c30 context(HttpContext httpContext) {
        this.f15714a = httpContext;
        return this;
    }

    public boolean d(long j2) {
        return System.currentTimeMillis() - this.f15712a.getTime() > j2 && o() != 1;
    }

    public c30 data(byte[] bArr) {
        this.f15716a = bArr;
        return this;
    }

    public DefaultHttpClient e() {
        return this.f15713a;
    }

    public c30 error(String str) {
        this.f15721c = str;
        return this;
    }

    public int f() {
        return this.f40889a;
    }

    public c30 file(File file) {
        this.f15710a = file;
        return this;
    }

    public List<Cookie> g() {
        CookieStore cookieStore;
        HttpContext httpContext = this.f15714a;
        if (httpContext != null && (cookieStore = (CookieStore) httpContext.getAttribute("http.cookie-store")) != null) {
            return cookieStore.getCookies();
        }
        return Collections.emptyList();
    }

    public byte[] getData() {
        return this.f15716a;
    }

    public boolean getDone() {
        return this.f15720b;
    }

    public File getFile() {
        return this.f15710a;
    }

    public boolean getInvalid() {
        return this.f15722c;
    }

    public boolean getReauth() {
        return this.f15723d;
    }

    public long h() {
        return this.f15708a;
    }

    public c30 headers(Header[] headerArr) {
        this.f15717a = headerArr;
        return this;
    }

    public String i() {
        return this.f15721c;
    }

    public String j(String str) {
        if (this.f15717a == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            Header[] headerArr = this.f15717a;
            if (i2 >= headerArr.length) {
                return null;
            }
            if (str.equalsIgnoreCase(headerArr[i2].getName())) {
                return this.f15717a[i2].getValue();
            }
            i2++;
        }
    }

    public List<Header> k() {
        Header[] headerArr = this.f15717a;
        return headerArr == null ? Collections.emptyList() : Arrays.asList(headerArr);
    }

    public String l() {
        return this.f15711a;
    }

    public String m() {
        return this.f15719b;
    }

    public boolean n() {
        return this.f15715a;
    }

    public int o() {
        return this.b;
    }

    public Date p() {
        return this.f15712a;
    }

    public c30 q() {
        this.f15722c = true;
        return this;
    }

    public c30 r(String str) {
        this.f15711a = str;
        return this;
    }

    public c30 reauth(boolean z) {
        this.f15723d = z;
        return this;
    }

    public c30 redirect(String str) {
        this.f15719b = str;
        return this;
    }

    public c30 refresh(boolean z) {
        this.f15715a = z;
        return this;
    }

    public c30 reset() {
        this.f15708a = System.currentTimeMillis() - this.f15718b;
        this.f15720b = false;
        a();
        return this;
    }

    public c30 source(int i2) {
        this.b = i2;
        return this;
    }

    public c30 time(Date date) {
        this.f15712a = date;
        return this;
    }

    public c30(int i2, String str) {
        this.f40889a = 200;
        this.f15711a = "OK";
        this.f15712a = new Date();
        this.b = 1;
        this.f15718b = System.currentTimeMillis();
        this.f40889a = i2;
        this.f15711a = str;
    }
}
