package com.byazt.ga;

import android.graphics.Bitmap;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 256, 42})
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f28557a;
    public final int c;
    public final String da;
    public final List<ve> i;
    public Bitmap m;
    public final String n;
    public final int[][] sl;
    public final String sp;
    public final JSONArray t;
    public final int tt;
    public final c u;
    public final String uj;
    public final String ve;
    public final String x;
    public final tt yp;
    public final String z;

    @com.byazt.zqa.c(c = {0, 1, 256, 64})
    public static class c {
        public C0410c c = null;
        public boolean tt;

        /* JADX INFO: renamed from: com.byazt.ga.i$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 256, 1402})
        public static class C0410c {
            public float c = 5.0f;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 256, 1937})
    public static class tt {
        public int c;
        public int tt;
        public int ve;
    }

    @com.byazt.zqa.c(c = {0, 1, 256, 1943})
    public static class ve {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f28558a;
        public int c;
        public String da;
        public int i;
        public String n;
        public c sl;
        public String sp;
        public c t;
        public int tt;
        public int u;
        public String uj;
        public String ve;
        public int x;
        public int yp;

        @com.byazt.zqa.c(c = {0, 1, 256, 257})
        public static class c {
            public int c;
            public String tt;
        }
    }

    public i(int i, int i2, String str, String str2, String str3, String str4, List<ve> list, String str5, int[][] iArr, JSONArray jSONArray, String str6, String str7, c cVar, tt ttVar, String str8) {
        this.c = i;
        this.tt = i2;
        this.ve = str;
        this.uj = str2;
        this.n = str3;
        this.f28557a = str4;
        this.sp = str6;
        this.x = str7;
        this.i = list;
        this.da = str5;
        this.sl = iArr;
        this.t = jSONArray;
        this.u = cVar;
        this.yp = ttVar;
        this.z = str8;
    }

    public String a() {
        return this.x;
    }

    public int c() {
        return this.c;
    }

    public c da() {
        return this.u;
    }

    public JSONArray i() {
        return this.t;
    }

    public String m() {
        return this.z;
    }

    public String n() {
        return this.sp;
    }

    public tt sl() {
        return this.yp;
    }

    public String sp() {
        return this.da;
    }

    public String t() {
        return this.ve;
    }

    public int tt() {
        return this.tt;
    }

    public String u() {
        return this.uj;
    }

    public String uj() {
        return this.f28557a;
    }

    public List<ve> ve() {
        return this.i;
    }

    public int[][] x() {
        return this.sl;
    }

    public String yp() {
        return this.n;
    }

    public Bitmap z() {
        return this.m;
    }

    public void c(Bitmap bitmap) {
        this.m = bitmap;
    }
}
