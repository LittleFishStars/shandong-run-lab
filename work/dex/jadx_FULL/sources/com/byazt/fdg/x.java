package com.byazt.fdg;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.DigestException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 71})
public class x implements sl {
    public final ByteBuffer c;

    public x(ByteBuffer byteBuffer) {
        this.c = byteBuffer.slice();
    }

    @Override // com.byazt.fdg.sl
    public long c() {
        return this.c.capacity();
    }

    @Override // com.byazt.fdg.sl
    public void c(da daVar, long j, int i) throws DigestException, IOException {
        ByteBuffer byteBufferSlice;
        synchronized (this.c) {
            this.c.position(0);
            int i2 = (int) j;
            this.c.limit(i + i2);
            this.c.position(i2);
            byteBufferSlice = this.c.slice();
        }
        daVar.c(byteBufferSlice);
    }
}
