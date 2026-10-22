package com.google.android.exoplayer2.extractor;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataReader;
import com.zj.adlib.om6;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d implements TrackOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f30639a = new byte[4096];

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void a(om6 om6Var, int i, int i2) {
        om6Var.T(i);
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public int d(DataReader dataReader, int i, boolean z, int i2) throws IOException {
        int i3 = dataReader.read(this.f30639a, 0, Math.min(this.f30639a.length, i));
        if (i3 != -1) {
            return i3;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void e(long j, int i, int i2, int i3, @Nullable TrackOutput.a aVar) {
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void f(com.google.android.exoplayer2.d dVar) {
    }
}
