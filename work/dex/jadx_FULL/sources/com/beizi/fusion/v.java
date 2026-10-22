package com.beizi.fusion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27843a;
    private final String b;
    private final boolean c;
    private final boolean d;
    private final String e;
    private final List f;
    private final int g;
    private final i h;
    private final boolean i;
    private final p9 j;
    private final Map k;
    private final Map l;
    private final String m;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27844a;
        private String b;
        private boolean c;
        private boolean d;
        private String e;
        private final List f;
        private boolean h;
        private p9 j;
        private Map k;
        private String l;
        private Map m;
        private int g = 1;
        private i i = i.UI_MODEL_LIGHT;

        public a(String str) {
            this.f27844a = str;
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add("CNY");
        }

        public v a() {
            return new v(this);
        }

        public a a(p9 p9Var) {
            this.j = p9Var;
            return this;
        }

        public a a(boolean z) {
            this.d = z;
            return this;
        }

        public a a(Map map) {
            this.k = map;
            return this;
        }
    }

    private v(a aVar) {
        this.f27843a = aVar.f27844a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.i = aVar.h;
        this.j = aVar.j;
        this.h = aVar.i;
        this.k = aVar.k;
        this.m = aVar.l;
        this.l = aVar.m;
    }

    private boolean a() {
        p9 p9Var = this.j;
        return p9Var == null || p9Var.g();
    }

    private boolean u() {
        p9 p9Var = this.j;
        return p9Var == null || p9Var.k();
    }

    public boolean b() {
        p9 p9Var = this.j;
        return p9Var == null || p9Var.h();
    }

    public boolean c() {
        p9 p9Var = this.j;
        return p9Var == null || p9Var.i();
    }

    public boolean d() {
        return a() && u();
    }

    public String e() {
        return this.f27843a;
    }

    public int f() {
        p9 p9Var = this.j;
        return (p9Var == null || p9Var.e().b() != 1) ? 0 : 1;
    }

    public int g() {
        p9 p9Var = this.j;
        return (p9Var == null || p9Var.e().b() != 1) ? 0 : 1;
    }

    public int h() {
        return this.g;
    }

    public List i() {
        return this.f;
    }

    public String j() {
        p9 p9Var = this.j;
        return p9Var != null ? p9Var.b() : "";
    }

    public String k() {
        p9 p9Var = this.j;
        return p9Var != null ? p9Var.c() : "";
    }

    public c0 l() {
        p9 p9Var = this.j;
        if (p9Var != null) {
            return p9Var.a();
        }
        return null;
    }

    public String m() {
        p9 p9Var = this.j;
        return p9Var != null ? p9Var.d() : "";
    }

    public String n() {
        p9 p9Var = this.j;
        return p9Var != null ? p9Var.f() : "";
    }

    public String o() {
        Map map = this.l;
        return map != null ? (String) map.get("darkColor") : "";
    }

    public Map p() {
        return this.k;
    }

    public int q() {
        p9 p9Var = this.j;
        return (p9Var == null || p9Var.e().b() != 1) ? 0 : 1;
    }

    public String r() {
        Map map = this.l;
        return map != null ? (String) map.get("lightColor") : "";
    }

    public Map s() {
        return this.l;
    }

    public String t() {
        return this.m;
    }

    public i v() {
        return this.h;
    }

    public String w() {
        return this.e;
    }

    public boolean x() {
        p9 p9Var = this.j;
        return p9Var == null || p9Var.j();
    }

    public boolean y() {
        return this.i;
    }

    public boolean z() {
        return this.d;
    }
}
