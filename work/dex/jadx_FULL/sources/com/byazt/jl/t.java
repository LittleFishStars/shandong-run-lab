package com.byazt.jl;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 157, 66})
public class t extends n {
    public static final int c = n.c("IHDR");
    public int tt;
    public int ve;
    public byte[] x = new byte[5];

    @Override // com.byazt.jl.n
    public void c(com.byazt.on.c cVar) throws IOException {
        this.tt = cVar.tt();
        this.ve = cVar.tt();
        byte[] bArr = this.x;
        cVar.c(bArr, 0, bArr.length);
    }
}
