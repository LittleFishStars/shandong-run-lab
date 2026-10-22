package com.byazt.yf;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 508, 71})
public class x {
    public boolean c;
    public String tt;
    public boolean uj;
    public boolean ve;

    @com.byazt.zqa.c(c = {0, 1, 508, 62})
    public static class c {
        public boolean c = false;
        public String tt = null;
        public boolean ve = false;
        public boolean uj = false;

        public c c(boolean z) {
            this.c = z;
            return this;
        }

        public c tt(boolean z) {
            this.ve = z;
            return this;
        }

        public c ve(boolean z) {
            this.uj = z;
            return this;
        }

        public c c(String str) {
            this.tt = str;
            return this;
        }

        public x c() {
            return new x(this);
        }
    }

    @Nullable
    public String c() {
        return this.tt;
    }

    public boolean tt() {
        return this.c;
    }

    public boolean uj() {
        return this.uj;
    }

    public boolean ve() {
        return this.ve;
    }

    private x(c cVar) {
        this.c = cVar.c;
        this.tt = cVar.tt;
        this.ve = cVar.ve;
        this.uj = cVar.uj;
    }
}
