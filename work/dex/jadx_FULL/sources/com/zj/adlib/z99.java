package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class z99 {
    public static final String b = "TrackEncryptionBox";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f46220a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TrackOutput.a f21009a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f21010a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f21011a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final byte[] f21012a;

    public z99(boolean z, @Nullable String str, int i, byte[] bArr, int i2, int i3, @Nullable byte[] bArr2) {
        sb0.a((bArr2 == null) ^ (i == 0));
        this.f21011a = z;
        this.f21010a = str;
        this.f46220a = i;
        this.f21012a = bArr2;
        this.f21009a = new TrackOutput.a(a(str), bArr, i2, i3);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int a(@Nullable String str) {
        if (str == null) {
            return 1;
        }
        byte b2 = -1;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals("cbc1")) {
                    b2 = 0;
                }
                break;
            case 3046671:
                if (str.equals("cbcs")) {
                    b2 = 1;
                }
                break;
            case 3049879:
                if (str.equals("cenc")) {
                    b2 = 2;
                }
                break;
            case 3049895:
                if (str.equals("cens")) {
                    b2 = 3;
                }
                break;
        }
        switch (b2) {
            case 0:
            case 1:
                return 2;
            default:
                Log.n(b, "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
            case 2:
            case 3:
                return 1;
        }
    }
}
