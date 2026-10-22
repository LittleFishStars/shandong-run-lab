package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.zj.adlib.gj9;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class i {
    public static final String i = "0";
    public static final String j = "control";
    public static final String k = "fmtp";
    public static final String l = "length";
    public static final String m = "range";
    public static final String n = "rtpmap";
    public static final String o = "tool";
    public static final String p = "type";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f30979a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Uri f4420a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableList<MediaDescription> f4421a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableMap<String, String> f4422a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f4423a;

    @Nullable
    public final String b;

    @Nullable
    public final String c;

    @Nullable
    public final String d;

    @Nullable
    public final String e;

    @Nullable
    public final String f;

    @Nullable
    public final String g;

    @Nullable
    public final String h;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Uri f4424a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public String f4426a;

        @Nullable
        public String b;

        @Nullable
        public String c;

        @Nullable
        public String d;

        @Nullable
        public String e;

        @Nullable
        public String f;

        @Nullable
        public String g;

        @Nullable
        public String h;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final HashMap<String, String> f4427a = new HashMap<>();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ImmutableList.a<MediaDescription> f4425a = new ImmutableList.a<>();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30980a = -1;

        public b m(String str, String str2) {
            this.f4427a.put(str, str2);
            return this;
        }

        public b n(MediaDescription mediaDescription) {
            this.f4425a.a(mediaDescription);
            return this;
        }

        public i o() {
            return new i(this);
        }

        public b p(int i) {
            this.f30980a = i;
            return this;
        }

        public b q(String str) {
            this.d = str;
            return this;
        }

        public b r(String str) {
            this.g = str;
            return this;
        }

        public b s(String str) {
            this.e = str;
            return this;
        }

        public b t(String str) {
            this.b = str;
            return this;
        }

        public b u(String str) {
            this.h = str;
            return this;
        }

        public b v(String str) {
            this.f = str;
            return this;
        }

        public b w(String str) {
            this.f4426a = str;
            return this;
        }

        public b x(String str) {
            this.c = str;
            return this;
        }

        public b y(Uri uri) {
            this.f4424a = uri;
            return this;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f30979a == iVar.f30979a && this.f4422a.equals(iVar.f4422a) && this.f4421a.equals(iVar.f4421a) && gj9.c(this.b, iVar.b) && gj9.c(this.f4423a, iVar.f4423a) && gj9.c(this.c, iVar.c) && gj9.c(this.h, iVar.h) && gj9.c(this.f4420a, iVar.f4420a) && gj9.c(this.f, iVar.f) && gj9.c(this.g, iVar.g) && gj9.c(this.d, iVar.d) && gj9.c(this.e, iVar.e);
    }

    public int hashCode() {
        int iHashCode = (((217 + this.f4422a.hashCode()) * 31) + this.f4421a.hashCode()) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f4423a;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int iHashCode4 = (((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f30979a) * 31;
        String str4 = this.h;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Uri uri = this.f4420a;
        int iHashCode6 = (iHashCode5 + (uri == null ? 0 : uri.hashCode())) * 31;
        String str5 = this.f;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.g;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.d;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.e;
        return iHashCode9 + (str8 != null ? str8.hashCode() : 0);
    }

    public i(b bVar) {
        this.f4422a = ImmutableMap.copyOf((Map) bVar.f4427a);
        this.f4421a = bVar.f4425a.e();
        this.f4423a = (String) gj9.k(bVar.f4426a);
        this.b = (String) gj9.k(bVar.b);
        this.c = (String) gj9.k(bVar.c);
        this.f4420a = bVar.f4424a;
        this.d = bVar.d;
        this.f30979a = bVar.f30980a;
        this.e = bVar.e;
        this.f = bVar.g;
        this.g = bVar.h;
        this.h = bVar.f;
    }
}
