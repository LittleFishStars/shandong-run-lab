package com.zj.adlib;

import com.google.android.exoplayer2.decoder.CryptoConfig;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class gm3 implements CryptoConfig {
    public static final boolean b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f41937a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f16822a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f16823a;

    /* JADX WARN: Code duplicated, block: B:9:0x001e  */
    static {
        boolean z;
        if ("Amazon".equals(gj9.b)) {
            String str = gj9.c;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        b = z;
    }

    public gm3(UUID uuid, byte[] bArr, boolean z) {
        this.f41937a = uuid;
        this.f16823a = bArr;
        this.f16822a = z;
    }
}
