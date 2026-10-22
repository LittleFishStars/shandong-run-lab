package com.byazt.e;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 443, 15})
public class uj {
    public String c;
    public String tt;

    @com.byazt.zqa.c(c = {0, 1, 443, 123})
    public static class c {
        public String c;
        public String tt;

        public c c(String str) {
            this.c = str;
            return this;
        }

        public c tt(String str) {
            this.tt = str;
            return this;
        }

        public uj c() {
            return new uj(this);
        }
    }

    public uj(c cVar) {
        this.c = cVar.c;
        this.tt = cVar.tt;
    }

    public String c() {
        return this.c;
    }
}
