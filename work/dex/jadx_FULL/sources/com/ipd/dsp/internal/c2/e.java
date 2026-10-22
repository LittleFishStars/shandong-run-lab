package com.ipd.dsp.internal.c2;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e {
    public static String a(String str, String str2) {
        return a(str, str2, a(a()).getBytes(StandardCharsets.UTF_8));
    }

    public static int[] b() {
        return new int[]{130, 276, 664, 94, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME, 672, 164, 188, 640, 150, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME, 664, 106, 320, 776, 200, 400, 840, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, 412};
    }

    public static String a(String str, String str2, byte[] bArr) {
        try {
            byte[] bArr2 = new byte[32];
            byte[] bytes = str2.getBytes(StandardCharsets.UTF_8);
            System.arraycopy(bytes, 0, bArr2, 0, Math.min(32, bytes.length));
            Cipher cipher = Cipher.getInstance(a(b()));
            cipher.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr));
            return new String(cipher.doFinal(b.a(str)));
        } catch (Throwable unused) {
            if (!com.ipd.dsp.internal.l1.a.a().isDebug()) {
                return null;
            }
            k.f("Cipher", "de error");
            return null;
        }
    }

    public static int[] a() {
        return new int[]{204, 436, 832, 198, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_UNRELIABLE, 768, 158, 216, 592, 158, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR, 664, 132, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 128};
    }

    public static String a(int[] iArr) {
        byte[] bArr = new byte[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            bArr[i] = (byte) (iArr[i] >> ((i % 3) + 1));
        }
        return new String(bArr);
    }
}
