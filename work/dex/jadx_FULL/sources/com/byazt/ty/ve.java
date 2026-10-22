package com.byazt.ty;

import com.byazt.w.a;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, TTVideoEngine.PLAYER_OPTION_OUTPUT_LOG, 54})
public class ve implements tt {
    public final InputStream c;
    public final com.byazt.h.c tt;

    public ve(InputStream inputStream, int i) {
        this.c = inputStream;
        this.tt = new com.byazt.h.c(i);
    }

    @Override // com.byazt.ty.tt
    public com.byazt.h.c c() throws IOException {
        com.byazt.h.c cVar = this.tt;
        cVar.ve = this.c.read(cVar.c);
        return this.tt;
    }

    @Override // com.byazt.ty.tt
    public void c(com.byazt.h.c cVar) {
    }

    @Override // com.byazt.ty.tt
    public void tt() {
        a.c(this.c);
    }
}
