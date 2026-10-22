package com.zj.adlib;

import android.annotation.SuppressLint;
import android.media.MediaFormat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class fh5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41675a = 1073741824;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f16526a = "exo-pixel-width-height-ratio-float";
    public static final String b = "exo-pcm-encoding-int";
    public static final String c = "max-bitrate";

    @SuppressLint({"InlinedApi"})
    public static MediaFormat a(d dVar) {
        MediaFormat mediaFormat = new MediaFormat();
        e(mediaFormat, com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE, dVar.O);
        e(mediaFormat, "max-bitrate", dVar.N);
        e(mediaFormat, com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT, dVar.U);
        c(mediaFormat, dVar.f2568a);
        h(mediaFormat, "mime", dVar.k);
        h(mediaFormat, "codecs-string", dVar.i);
        d(mediaFormat, "frame-rate", dVar.f2564a);
        e(mediaFormat, "width", dVar.Q);
        e(mediaFormat, "height", dVar.R);
        j(mediaFormat, dVar.f2569a);
        f(mediaFormat, dVar.W);
        h(mediaFormat, com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_LANGUAGE, dVar.h);
        e(mediaFormat, "max-input-size", dVar.P);
        e(mediaFormat, com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE, dVar.V);
        e(mediaFormat, "caption-service-number", dVar.Z);
        mediaFormat.setInteger("rotation-degrees", dVar.S);
        int i = dVar.K;
        i(mediaFormat, "is-autoselect", i & 4);
        i(mediaFormat, "is-default", i & 1);
        i(mediaFormat, "is-forced-subtitle", i & 2);
        mediaFormat.setInteger("encoder-delay", dVar.X);
        mediaFormat.setInteger("encoder-padding", dVar.Y);
        g(mediaFormat, dVar.f2571b);
        return mediaFormat;
    }

    public static void b(MediaFormat mediaFormat, String str, @Nullable byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void c(MediaFormat mediaFormat, @Nullable tn1 tn1Var) {
        if (tn1Var != null) {
            e(mediaFormat, "color-transfer", tn1Var.M);
            e(mediaFormat, "color-standard", tn1Var.K);
            e(mediaFormat, "color-range", tn1Var.L);
            b(mediaFormat, "hdr-static-info", tn1Var.f19867a);
        }
    }

    public static void d(MediaFormat mediaFormat, String str, float f) {
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
    }

    public static void e(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    @SuppressLint({"InlinedApi"})
    public static void f(MediaFormat mediaFormat, int i) {
        int i2;
        if (i == -1) {
            return;
        }
        e(mediaFormat, "exo-pcm-encoding-int", i);
        if (i == 0) {
            i2 = 0;
        } else if (i == 536870912) {
            i2 = 21;
        } else if (i != 805306368) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        return;
                    }
                }
            }
        } else {
            i2 = 22;
        }
        mediaFormat.setInteger("pcm-encoding", i2);
    }

    @SuppressLint({"InlinedApi"})
    public static void g(MediaFormat mediaFormat, float f) {
        int i;
        mediaFormat.setFloat("exo-pixel-width-height-ratio-float", f);
        int i2 = 1073741824;
        if (f < 1.0f) {
            i2 = (int) (f * 1073741824);
            i = 1073741824;
        } else if (f > 1.0f) {
            i = (int) (1073741824 / f);
        } else {
            i2 = 1;
            i = 1;
        }
        mediaFormat.setInteger("sar-width", i2);
        mediaFormat.setInteger("sar-height", i);
    }

    public static void h(MediaFormat mediaFormat, String str, @Nullable String str2) {
        if (str2 != null) {
            mediaFormat.setString(str, str2);
        }
    }

    public static void i(MediaFormat mediaFormat, String str, int i) {
        mediaFormat.setInteger(str, i != 0 ? 1 : 0);
    }

    public static void j(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i = 0; i < list.size(); i++) {
            mediaFormat.setByteBuffer("csd-" + i, ByteBuffer.wrap(list.get(i)));
        }
    }
}
