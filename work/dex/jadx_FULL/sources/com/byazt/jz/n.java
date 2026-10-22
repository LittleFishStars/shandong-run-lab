package com.byazt.jz;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 232, 46})
public class n {
    public String c;
    public byte[] n;
    public String tt;
    public boolean uj;
    public boolean ve;

    @com.byazt.zqa.c(c = {0, 1, 232, 151})
    public static class c {
        public String c;
        public byte[] n;
        public String tt;
        public boolean uj;
        public boolean ve;

        public c c(String str) {
            this.c = str;
            return this;
        }

        public c c(boolean z) {
            this.uj = z;
            return this;
        }

        public c c(byte[] bArr) {
            this.n = bArr;
            return this;
        }

        public n c() {
            n nVar = new n();
            nVar.c = this.c;
            nVar.tt = this.tt;
            nVar.ve = this.ve;
            nVar.uj = this.uj;
            nVar.n = this.n;
            return nVar;
        }
    }

    public byte[] ve() {
        return this.n;
    }

    public boolean tt() {
        return this.uj;
    }

    public String c() {
        return this.c;
    }
}
