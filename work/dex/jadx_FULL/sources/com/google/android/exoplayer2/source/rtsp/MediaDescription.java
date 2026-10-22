package com.google.android.exoplayer2.source.rtsp;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.common.collect.ImmutableMap;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class MediaDescription {
    public static final String f = "audio";
    public static final String g = "video";
    public static final String h = "RTP/AVP";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30946a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c f4304a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableMap<String, String> f4305a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f4306a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final String f4307b;
    public final int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public final String f4308c;

    @Nullable
    public final String d;

    @Nullable
    public final String e;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaType {
    }

    public static final class b {
        public static final int d = 0;
        public static final int e = 8;
        public static final int f = 10;

        /* JADX INFO: renamed from: f, reason: collision with other field name */
        public static final String f4309f = "%d %s/%d/%d";
        public static final int g = 11;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30947a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f4310a;
        public final int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final String f4312b;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        @Nullable
        public String f4313c;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        @Nullable
        public String f4314d;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        @Nullable
        public String f4315e;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final HashMap<String, String> f4311a = new HashMap<>();
        public int c = -1;

        public b(String str, int i, String str2, int i2) {
            this.f4310a = str;
            this.f30947a = i;
            this.f4312b = str2;
            this.b = i2;
        }

        public static String k(int i, String str, int i2, int i3) {
            return gj9.H(f4309f, Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3));
        }

        public static String l(int i) {
            sb0.a(i < 96);
            if (i == 0) {
                return k(0, com.google.android.exoplayer2.source.rtsp.b.n, 8000, 1);
            }
            if (i == 8) {
                return k(8, com.google.android.exoplayer2.source.rtsp.b.m, 8000, 1);
            }
            if (i == 10) {
                return k(10, com.google.android.exoplayer2.source.rtsp.b.l, com.google.android.exoplayer2.source.i.K, 2);
            }
            if (i == 11) {
                return k(11, com.google.android.exoplayer2.source.rtsp.b.l, com.google.android.exoplayer2.source.i.K, 1);
            }
            throw new IllegalStateException("Unsupported static paylod type " + i);
        }

        public b i(String str, String str2) {
            this.f4311a.put(str, str2);
            return this;
        }

        public MediaDescription j() {
            try {
                return new MediaDescription(this, ImmutableMap.copyOf((Map) this.f4311a), this.f4311a.containsKey(i.n) ? c.a((String) gj9.k(this.f4311a.get(i.n))) : c.a(l(this.b)));
            } catch (ParserException e2) {
                throw new IllegalStateException(e2);
            }
        }

        public b m(int i) {
            this.c = i;
            return this;
        }

        public b n(String str) {
            this.f4314d = str;
            return this;
        }

        public b o(String str) {
            this.f4315e = str;
            return this;
        }

        public b p(String str) {
            this.f4313c = str;
            return this;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30948a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f4316a;
        public final int b;
        public final int c;

        public c(int i, String str, int i2, int i3) {
            this.f30948a = i;
            this.f4316a = str;
            this.b = i2;
            this.c = i3;
        }

        public static c a(String str) throws ParserException {
            String[] strArrV1 = gj9.v1(str, " ");
            sb0.a(strArrV1.length == 2);
            int iH = g.h(strArrV1[0]);
            String[] strArrU1 = gj9.u1(strArrV1[1].trim(), WVNativeCallbackUtil.SEPERATER);
            sb0.a(strArrU1.length >= 2);
            return new c(iH, strArrU1[0], g.h(strArrU1[1]), strArrU1.length == 3 ? g.h(strArrU1[2]) : -1);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return this.f30948a == cVar.f30948a && this.f4316a.equals(cVar.f4316a) && this.b == cVar.b && this.c == cVar.c;
        }

        public int hashCode() {
            return ((((((217 + this.f30948a) * 31) + this.f4316a.hashCode()) * 31) + this.b) * 31) + this.c;
        }
    }

    public ImmutableMap<String, String> a() {
        String str = this.f4305a.get(i.k);
        if (str == null) {
            return ImmutableMap.of();
        }
        String[] strArrV1 = gj9.v1(str, " ");
        sb0.b(strArrV1.length == 2, str);
        String[] strArrSplit = strArrV1[1].split(";\\s?", 0);
        ImmutableMap.b bVar = new ImmutableMap.b();
        for (String str2 : strArrSplit) {
            String[] strArrV2 = gj9.v1(str2, "=");
            bVar.f(strArrV2[0], strArrV2[1]);
        }
        return bVar.b();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaDescription.class != obj.getClass()) {
            return false;
        }
        MediaDescription mediaDescription = (MediaDescription) obj;
        return this.f4306a.equals(mediaDescription.f4306a) && this.f30946a == mediaDescription.f30946a && this.f4307b.equals(mediaDescription.f4307b) && this.b == mediaDescription.b && this.c == mediaDescription.c && this.f4305a.equals(mediaDescription.f4305a) && this.f4304a.equals(mediaDescription.f4304a) && gj9.c(this.f4308c, mediaDescription.f4308c) && gj9.c(this.d, mediaDescription.d) && gj9.c(this.e, mediaDescription.e);
    }

    public int hashCode() {
        int iHashCode = (((((((((((((217 + this.f4306a.hashCode()) * 31) + this.f30946a) * 31) + this.f4307b.hashCode()) * 31) + this.b) * 31) + this.c) * 31) + this.f4305a.hashCode()) * 31) + this.f4304a.hashCode()) * 31;
        String str = this.f4308c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.e;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public MediaDescription(b bVar, ImmutableMap<String, String> immutableMap, c cVar) {
        this.f4306a = bVar.f4310a;
        this.f30946a = bVar.f30947a;
        this.f4307b = bVar.f4312b;
        this.b = bVar.b;
        this.f4308c = bVar.f4313c;
        this.d = bVar.f4314d;
        this.c = bVar.c;
        this.e = bVar.f4315e;
        this.f4305a = immutableMap;
        this.f4304a = cVar;
    }
}
