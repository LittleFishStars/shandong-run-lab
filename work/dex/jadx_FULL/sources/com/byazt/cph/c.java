package com.byazt.cph;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1059, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28369a;
    public String c;
    public int n;
    public JSONObject sp;
    public String tt;
    public int uj;
    public String ve;

    /* JADX INFO: renamed from: com.byazt.cph.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 1059, 44})
    public static class C0378c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f28370a;
        public String c;
        public int n;
        public JSONObject sp;
        public String tt;
        public int uj;
        public String ve;

        public C0378c c(String str) {
            this.c = str;
            return this;
        }

        public C0378c tt(String str) {
            this.tt = str;
            return this;
        }

        public C0378c ve(String str) {
            this.ve = str;
            return this;
        }

        public C0378c c(int i) {
            this.uj = i;
            return this;
        }

        public C0378c tt(int i) {
            this.n = i;
            return this;
        }

        public C0378c c(long j) {
            this.f28370a = j;
            return this;
        }

        public C0378c c(JSONObject jSONObject) {
            this.sp = jSONObject;
            return this;
        }

        public c c() {
            c cVar = new c();
            cVar.c = this.c;
            cVar.tt = this.tt;
            cVar.ve = this.ve;
            cVar.uj = this.uj;
            cVar.n = this.n;
            cVar.f28369a = this.f28370a;
            cVar.sp = this.sp;
            return cVar;
        }
    }

    public long a() {
        return this.f28369a;
    }

    public int n() {
        return this.n;
    }

    public JSONObject sp() {
        return this.sp;
    }

    public int uj() {
        return this.uj;
    }

    public String ve() {
        return this.ve;
    }

    public String tt() {
        return this.tt;
    }

    public String c() {
        return this.c;
    }
}
