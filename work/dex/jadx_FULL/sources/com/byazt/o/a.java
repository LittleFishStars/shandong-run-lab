package com.byazt.o;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME, 34})
public class a {
    public int[] c;
    public int[] tt;

    private a() {
    }

    public static a c(uj ujVar) throws IOException {
        tt.c(ujVar, 1835009);
        int iTt = ujVar.tt();
        int iTt2 = ujVar.tt();
        int iTt3 = ujVar.tt();
        ujVar.tt();
        int iTt4 = ujVar.tt();
        int iTt5 = ujVar.tt();
        a aVar = new a();
        aVar.c = ujVar.tt(iTt2);
        if (iTt3 != 0) {
            ujVar.tt(iTt3);
        }
        int i = (iTt5 == 0 ? iTt : iTt5) - iTt4;
        if (i % 4 != 0) {
            throw new IOException("String data size is not multiple of 4 (" + i + ").");
        }
        aVar.tt = ujVar.tt(i / 4);
        if (iTt5 != 0) {
            int i2 = iTt - iTt5;
            if (i2 % 4 != 0) {
                throw new IOException("Style data size is not multiple of 4 (" + i2 + ").");
            }
            ujVar.tt(i2 / 4);
        }
        return aVar;
    }

    public String c(int i) {
        int[] iArr;
        if (i < 0 || (iArr = this.c) == null || i >= iArr.length) {
            return null;
        }
        int i2 = iArr[i];
        int iC = c(this.tt, i2);
        StringBuilder sb = new StringBuilder(iC);
        while (iC != 0) {
            i2 += 2;
            sb.append((char) c(this.tt, i2));
            iC--;
        }
        return sb.toString();
    }

    private static final int c(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & 65535 : i2 >>> 16;
    }
}
