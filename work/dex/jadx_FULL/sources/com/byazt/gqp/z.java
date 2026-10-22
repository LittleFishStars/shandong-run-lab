package com.byazt.gqp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 323, 133})
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f28588a;
    public String c;
    public byte[] n;
    public String tt;
    public String uj;
    public da ve;

    public enum c {
        STRING_TYPE,
        BYTE_ARRAY_TYPE,
        FILE_TYPE
    }

    public z() {
    }

    public String c() {
        return this.c;
    }

    public String tt() {
        return this.tt;
    }

    public z(da daVar, String str, c cVar) {
        this.ve = daVar;
        this.uj = str;
        this.f28588a = cVar;
    }

    public static z c(da daVar, String str) {
        return new z(daVar, str, c.STRING_TYPE);
    }

    public static z c(da daVar, byte[] bArr) {
        return new z(daVar, bArr, c.BYTE_ARRAY_TYPE);
    }

    public static z c(da daVar, byte[] bArr, String str, String str2) {
        return new z(daVar, bArr, str, str2, c.FILE_TYPE);
    }

    public z(da daVar, byte[] bArr, String str, String str2, c cVar) {
        this.ve = daVar;
        this.n = bArr;
        this.tt = str;
        this.c = str2;
        this.f28588a = cVar;
    }

    public z(da daVar, byte[] bArr, c cVar) {
        this.ve = daVar;
        this.n = bArr;
        this.f28588a = cVar;
    }
}
