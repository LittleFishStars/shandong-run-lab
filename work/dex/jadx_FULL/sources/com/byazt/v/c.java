package com.byazt.v;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, 20})
public class c implements tt {
    public final RandomAccessFile c;

    public c(File file) throws FileNotFoundException {
        this.c = new RandomAccessFile(file, "r");
    }

    @Override // com.byazt.v.tt
    public long c() throws IOException {
        return this.c.length();
    }

    @Override // com.byazt.v.tt
    public void tt() throws IOException {
        this.c.close();
    }

    @Override // com.byazt.v.tt
    public int c(byte[] bArr, int i, int i2) throws IOException {
        return this.c.read(bArr, i, i2);
    }

    @Override // com.byazt.v.tt
    public void c(long j, long j2) throws IOException {
        this.c.seek(j);
    }
}
