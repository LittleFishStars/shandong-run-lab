package com.byazt.o;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME, 15})
public class uj {
    public InputStream c;
    public boolean tt;
    public int ve;

    public uj() {
    }

    public final void c(InputStream inputStream, boolean z) {
        this.c = inputStream;
        this.tt = z;
        this.ve = 0;
    }

    public final int tt() throws IOException {
        return c(4);
    }

    public final void ve(int i) throws IOException {
        if (i > 0) {
            long j = i;
            long jSkip = this.c.skip(j);
            this.ve = (int) (((long) this.ve) + jSkip);
            if (jSkip != j) {
                throw new EOFException();
            }
        }
    }

    public uj(InputStream inputStream, boolean z) {
        c(inputStream, z);
    }

    public final int[] tt(int i) throws IOException {
        int[] iArr = new int[i];
        c(iArr, 0, i);
        return iArr;
    }

    public final void c() {
        InputStream inputStream = this.c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            c(null, false);
        }
    }

    public final void ve() throws IOException {
        ve(4);
    }

    public final int c(int i) throws IOException {
        if (i >= 0 && i <= 4) {
            int i2 = 0;
            if (this.tt) {
                for (int i3 = (i - 1) * 8; i3 >= 0; i3 -= 8) {
                    int i4 = this.c.read();
                    if (i4 != -1) {
                        this.ve++;
                        i2 |= i4 << i3;
                    } else {
                        throw new EOFException();
                    }
                }
                return i2;
            }
            int i5 = i * 8;
            int i6 = 0;
            while (i2 != i5) {
                int i7 = this.c.read();
                if (i7 != -1) {
                    this.ve++;
                    i6 |= i7 << i2;
                    i2 += 8;
                } else {
                    throw new EOFException();
                }
            }
            return i6;
        }
        throw new IllegalArgumentException();
    }

    public final void c(int[] iArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            iArr[i] = tt();
            i2--;
            i++;
        }
    }
}
