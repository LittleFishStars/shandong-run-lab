package com.byazt.on;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE, 54})
public class ve implements a {
    public final ByteBuffer c;

    public ve(ByteBuffer byteBuffer) {
        this.c = byteBuffer;
        byteBuffer.position(0);
    }

    @Override // com.byazt.on.a
    public long c(long j) throws IOException {
        ByteBuffer byteBuffer = this.c;
        byteBuffer.position((int) (((long) byteBuffer.position()) + j));
        return j;
    }

    @Override // com.byazt.on.a
    public byte c_() throws IOException {
        return this.c.get();
    }

    @Override // com.byazt.on.a
    public void d_() throws IOException {
        this.c.position(0);
    }

    @Override // com.byazt.on.a
    public InputStream n() throws IOException {
        return new ByteArrayInputStream(this.c.array());
    }

    @Override // com.byazt.on.a
    public int uj() throws IOException {
        return this.c.limit() - this.c.position();
    }

    @Override // com.byazt.on.a
    public int ve() {
        return this.c.position();
    }

    @Override // com.byazt.on.a
    public int c(byte[] bArr, int i, int i2) throws IOException {
        this.c.get(bArr, i, i2);
        return i2;
    }
}
