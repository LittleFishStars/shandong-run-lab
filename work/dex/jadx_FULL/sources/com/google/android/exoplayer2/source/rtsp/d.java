package com.google.android.exoplayer2.source.rtsp;

import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.o;
import com.zj.adlib.gj9;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d {
    public static final String A = "Supported";
    public static final String B = "Timestamp";
    public static final String C = "Transport";
    public static final String D = "User-Agent";
    public static final String E = "Via";
    public static final String F = "WWW-Authenticate";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f30971a = new b().e();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f4400a = "Accept";
    public static final String b = "Allow";
    public static final String c = "Authorization";
    public static final String d = "Bandwidth";
    public static final String e = "Blocksize";
    public static final String f = "Cache-Control";
    public static final String g = "Connection";
    public static final String h = "Content-Base";
    public static final String i = "Content-Encoding";
    public static final String j = "Content-Language";
    public static final String k = "Content-Length";
    public static final String l = "Content-Location";
    public static final String m = "Content-Type";
    public static final String n = "CSeq";
    public static final String o = "Date";
    public static final String p = "Expires";
    public static final String q = "Location";
    public static final String r = "Proxy-Authenticate";
    public static final String s = "Proxy-Require";
    public static final String t = "Public";
    public static final String u = "Range";
    public static final String v = "RTP-Info";
    public static final String w = "RTCP-Interval";
    public static final String x = "Scale";
    public static final String y = "Session";
    public static final String z = "Speed";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableListMultimap<String, String> f4401a;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableListMultimap.a<String, String> f30972a;

        public b b(String str, String str2) {
            this.f30972a.f(d.d(str.trim()), str2.trim());
            return this;
        }

        public b c(List<String> list) {
            for (int i = 0; i < list.size(); i++) {
                String[] strArrV1 = gj9.v1(list.get(i), ":\\s?");
                if (strArrV1.length == 2) {
                    b(strArrV1[0], strArrV1[1]);
                }
            }
            return this;
        }

        public b d(Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                b(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public d e() {
            return new d(this);
        }

        public b() {
            this.f30972a = new ImmutableListMultimap.a<>();
        }

        public b(String str, @Nullable String str2, int i) {
            this();
            b("User-Agent", str);
            b(d.n, String.valueOf(i));
            if (str2 != null) {
                b(d.y, str2);
            }
        }

        public b(ImmutableListMultimap.a<String, String> aVar) {
            this.f30972a = aVar;
        }
    }

    public static String d(String str) {
        if (com.google.common.base.a.a(str, "Accept")) {
            return "Accept";
        }
        if (com.google.common.base.a.a(str, "Allow")) {
            return "Allow";
        }
        if (com.google.common.base.a.a(str, "Authorization")) {
            return "Authorization";
        }
        if (com.google.common.base.a.a(str, "Bandwidth")) {
            return "Bandwidth";
        }
        if (com.google.common.base.a.a(str, e)) {
            return e;
        }
        if (com.google.common.base.a.a(str, "Cache-Control")) {
            return "Cache-Control";
        }
        if (com.google.common.base.a.a(str, "Connection")) {
            return "Connection";
        }
        if (com.google.common.base.a.a(str, h)) {
            return h;
        }
        if (com.google.common.base.a.a(str, "Content-Encoding")) {
            return "Content-Encoding";
        }
        if (com.google.common.base.a.a(str, "Content-Language")) {
            return "Content-Language";
        }
        if (com.google.common.base.a.a(str, "Content-Length")) {
            return "Content-Length";
        }
        if (com.google.common.base.a.a(str, "Content-Location")) {
            return "Content-Location";
        }
        if (com.google.common.base.a.a(str, "Content-Type")) {
            return "Content-Type";
        }
        if (com.google.common.base.a.a(str, n)) {
            return n;
        }
        if (com.google.common.base.a.a(str, "Date")) {
            return "Date";
        }
        if (com.google.common.base.a.a(str, "Expires")) {
            return "Expires";
        }
        if (com.google.common.base.a.a(str, "Location")) {
            return "Location";
        }
        if (com.google.common.base.a.a(str, "Proxy-Authenticate")) {
            return "Proxy-Authenticate";
        }
        if (com.google.common.base.a.a(str, s)) {
            return s;
        }
        if (com.google.common.base.a.a(str, t)) {
            return t;
        }
        if (com.google.common.base.a.a(str, "Range")) {
            return "Range";
        }
        if (com.google.common.base.a.a(str, v)) {
            return v;
        }
        if (com.google.common.base.a.a(str, w)) {
            return w;
        }
        if (com.google.common.base.a.a(str, x)) {
            return x;
        }
        if (com.google.common.base.a.a(str, y)) {
            return y;
        }
        if (com.google.common.base.a.a(str, z)) {
            return z;
        }
        if (com.google.common.base.a.a(str, A)) {
            return A;
        }
        if (com.google.common.base.a.a(str, "Timestamp")) {
            return "Timestamp";
        }
        if (com.google.common.base.a.a(str, C)) {
            return C;
        }
        if (com.google.common.base.a.a(str, "User-Agent")) {
            return "User-Agent";
        }
        if (com.google.common.base.a.a(str, "Via")) {
            return "Via";
        }
        return com.google.common.base.a.a(str, "WWW-Authenticate") ? "WWW-Authenticate" : str;
    }

    public ImmutableListMultimap<String, String> b() {
        return this.f4401a;
    }

    public b c() {
        ImmutableListMultimap.a aVar = new ImmutableListMultimap.a();
        aVar.h(this.f4401a);
        return new b(aVar);
    }

    @Nullable
    public String e(String str) {
        ImmutableList<String> immutableListF = f(str);
        if (immutableListF.isEmpty()) {
            return null;
        }
        return (String) o.w(immutableListF);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            return this.f4401a.equals(((d) obj).f4401a);
        }
        return false;
    }

    public ImmutableList<String> f(String str) {
        return this.f4401a.get(d(str));
    }

    public int hashCode() {
        return this.f4401a.hashCode();
    }

    public d(b bVar) {
        this.f4401a = bVar.f30972a.a();
    }
}
