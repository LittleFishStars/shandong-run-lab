package com.zj.adlib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.net.Uri;
import android.provider.Settings;
import android.util.Pair;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.d;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class qe0 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f19070a = "external_surround_sound_enabled";
    public static final int b = 8;
    public static final int c = 48000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f19072a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f19073a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final qe0 f19069a = new qe0(new int[]{2}, 8);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final qe0 f19071b = new qe0(new int[]{2, 5, 6}, 8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImmutableMap<Integer, Integer> f44186a = new ImmutableMap.b().f(5, 6).f(17, 6).f(7, 6).f(18, 6).f(6, 8).f(8, 8).f(14, 8).b();

    @RequiresApi(29)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AudioAttributes f44187a = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

        /* JADX WARN: Multi-variable type inference failed */
        @DoNotInline
        public static int[] a() {
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            UnmodifiableIterator it = qe0.f44186a.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(iIntValue).setSampleRate(48000).build(), f44187a)) {
                    aVarBuilder.a(Integer.valueOf(iIntValue));
                }
            }
            aVarBuilder.a(2);
            return Ints.B(aVarBuilder.e());
        }

        @DoNotInline
        public static int b(int i, int i2) {
            for (int i3 = 8; i3 > 0; i3--) {
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i).setSampleRate(i2).setChannelMask(gj9.N(i3)).build(), f44187a)) {
                    return i3;
                }
            }
            return 0;
        }
    }

    public qe0(@Nullable int[] iArr, int i) {
        if (iArr != null) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.f19073a = iArrCopyOf;
            Arrays.sort(iArrCopyOf);
        } else {
            this.f19073a = new int[0];
        }
        this.f19072a = i;
    }

    public static boolean b() {
        if (gj9.f41922a >= 17) {
            String str = gj9.b;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static qe0 c(Context context) {
        return d(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    @SuppressLint({"InlinedApi"})
    public static qe0 d(Context context, @Nullable Intent intent) {
        if (b() && Settings.Global.getInt(context.getContentResolver(), f19070a, 0) == 1) {
            return f19071b;
        }
        if (gj9.f41922a < 29 || !(gj9.O0(context) || gj9.H0(context))) {
            return (intent == null || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? f19069a : new qe0(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
        }
        return new qe0(a.a(), 8);
    }

    public static int e(int i) {
        int i2 = gj9.f41922a;
        if (i2 <= 28) {
            if (i == 7) {
                i = 8;
            } else if (i == 3 || i == 4 || i == 5) {
                i = 6;
            }
        }
        if (i2 <= 26 && "fugu".equals(gj9.f16787a) && i == 1) {
            i = 2;
        }
        return gj9.N(i);
    }

    @Nullable
    public static Uri g() {
        if (b()) {
            return Settings.Global.getUriFor(f19070a);
        }
        return null;
    }

    public static int i(int i, int i2) {
        return gj9.f41922a >= 29 ? a.b(i, i2) : ((Integer) sb0.g(f44186a.getOrDefault(Integer.valueOf(i), 0))).intValue();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qe0)) {
            return false;
        }
        qe0 qe0Var = (qe0) obj;
        return Arrays.equals(this.f19073a, qe0Var.f19073a) && this.f19072a == qe0Var.f19072a;
    }

    @Nullable
    public Pair<Integer, Integer> f(d dVar) {
        int iF = bp5.f((String) sb0.g(dVar.k), dVar.i);
        if (!f44186a.containsKey(Integer.valueOf(iF))) {
            return null;
        }
        if (iF == 18 && !k(18)) {
            iF = 6;
        } else if (iF == 8 && !k(8)) {
            iF = 7;
        }
        if (!k(iF)) {
            return null;
        }
        int i = dVar.U;
        if (i == -1 || iF == 18) {
            int i2 = dVar.V;
            if (i2 == -1) {
                i2 = 48000;
            }
            i = i(iF, i2);
        } else if (i > this.f19072a) {
            return null;
        }
        int iE = e(i);
        if (iE == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(iF), Integer.valueOf(iE));
    }

    public int h() {
        return this.f19072a;
    }

    public int hashCode() {
        return this.f19072a + (Arrays.hashCode(this.f19073a) * 31);
    }

    public boolean j(d dVar) {
        return f(dVar) != null;
    }

    public boolean k(int i) {
        return Arrays.binarySearch(this.f19073a, i) >= 0;
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f19072a + ", supportedEncodings=" + Arrays.toString(this.f19073a) + "]";
    }
}
