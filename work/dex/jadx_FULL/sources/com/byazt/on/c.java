package com.byazt.on;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE, 20})
public class c extends n {
    public static ThreadLocal<byte[]> tt = new ThreadLocal<>();

    public c(a aVar) {
        super(aVar);
    }

    public static byte[] c() {
        byte[] bArr = tt.get();
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[4];
        tt.set(bArr2);
        return bArr2;
    }

    public short a_() throws IOException {
        byte[] bArrC = c();
        c(bArrC, 0, 2);
        return (short) (((bArrC[0] & 255) << 8) | (bArrC[1] & 255));
    }

    public int b_() throws IOException {
        byte[] bArrC = c();
        c(bArrC, 0, 4);
        return ((bArrC[3] & 255) << 24) | (bArrC[0] & 255) | ((bArrC[1] & 255) << 8) | ((bArrC[2] & 255) << 16);
    }

    public int tt() throws IOException {
        byte[] bArrC = c();
        c(bArrC, 0, 4);
        return ((bArrC[0] & 255) << 24) | (bArrC[3] & 255) | ((bArrC[2] & 255) << 8) | ((bArrC[1] & 255) << 16);
    }

    public boolean c(String str) throws IOException {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return false;
        }
        int iB_ = b_();
        for (int i = 0; i < 4; i++) {
            if (((iB_ >> (i * 8)) & 255) != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
