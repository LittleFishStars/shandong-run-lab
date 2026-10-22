package com.czhj.volley;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class Header {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f29466a;
    private final String b;

    public Header(String str, String str2) {
        this.f29466a = str;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Header.class != obj.getClass()) {
            return false;
        }
        Header header = (Header) obj;
        return TextUtils.equals(this.f29466a, header.f29466a) && TextUtils.equals(this.b, header.b);
    }

    public final String getName() {
        return this.f29466a;
    }

    public final String getValue() {
        return this.b;
    }

    public int hashCode() {
        return (this.f29466a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f29466a + ",value=" + this.b + "]";
    }
}
