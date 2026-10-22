package com.zj.adlib;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class do4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41238a = 255;
    public static final int b = 0;
    public static final int c = 216;
    public static final int d = 1;
    public static final int e = 217;
    public static final int f = 218;
    public static final int g = 225;
    public static final int h = 192;
    public static final int i = 208;
    public static final int j = 215;
    public static final int k = 1165519206;

    public static int a(int i2) {
        return u69.a(i2);
    }

    public static int b(InputStream inputStream) {
        try {
            int iE = e(inputStream);
            if (iE == 0) {
                return 0;
            }
            return u69.d(inputStream, iE);
        } catch (IOException unused) {
            return 0;
        }
    }

    public static int c(byte[] bArr) {
        return b(new ByteArrayInputStream(bArr));
    }

    public static boolean d(int i2) {
        switch (i2) {
            case 192:
            case 193:
            case MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY /* 194 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO /* 195 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY /* 197 */:
            case 198:
            case 199:
            case 201:
            case 202:
            case 203:
            case 205:
            case 206:
            case 207:
                return true;
            case MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE /* 196 */:
            case 200:
            case 204:
            default:
                return false;
        }
    }

    public static int e(InputStream inputStream) throws IOException {
        int iA;
        if (f(inputStream, 225) && (iA = gs8.a(inputStream, 2, false) - 2) > 6) {
            int iA2 = gs8.a(inputStream, 4, false);
            int iA3 = gs8.a(inputStream, 2, false);
            int i2 = (iA - 4) - 2;
            if (iA2 == 1165519206 && iA3 == 0) {
                return i2;
            }
        }
        return 0;
    }

    public static boolean f(InputStream inputStream, int i2) throws IOException {
        ax6.i(inputStream);
        while (gs8.a(inputStream, 1, false) == 255) {
            int iA = 255;
            while (iA == 255) {
                iA = gs8.a(inputStream, 1, false);
            }
            if ((i2 == 192 && d(iA)) || iA == i2) {
                return true;
            }
            if (iA != 216 && iA != 1) {
                if (iA == 217 || iA == 218) {
                    break;
                }
                inputStream.skip(gs8.a(inputStream, 2, false) - 2);
            }
        }
        return false;
    }
}
