package com.byazt.on;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE, 46})
public class n implements a {
    public a c;

    public n(a aVar) {
        this.c = aVar;
    }

    @Override // com.byazt.on.a
    public long c(long j) throws IOException {
        return this.c.c(j);
    }

    @Override // com.byazt.on.a
    public byte c_() throws IOException {
        return this.c.c_();
    }

    @Override // com.byazt.on.a
    public void d_() throws IOException {
        this.c.d_();
    }

    @Override // com.byazt.on.a
    public InputStream n() throws IOException {
        d_();
        return this.c.n();
    }

    @Override // com.byazt.on.a
    public int uj() throws IOException {
        return this.c.uj();
    }

    @Override // com.byazt.on.a
    public int ve() {
        return this.c.ve();
    }

    @Override // com.byazt.on.a
    public int c(byte[] bArr, int i, int i2) throws IOException {
        return this.c.c(bArr, i, i2);
    }
}
