package com.ipd.dsp.internal.j;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class g implements a<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38350a = "ByteArrayPool";

    @Override // com.ipd.dsp.internal.j.a
    public String a() {
        return f38350a;
    }

    @Override // com.ipd.dsp.internal.j.a
    public int b() {
        return 1;
    }

    @Override // com.ipd.dsp.internal.j.a
    public int a(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.ipd.dsp.internal.j.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public byte[] newArray(int i) {
        return new byte[i];
    }
}
