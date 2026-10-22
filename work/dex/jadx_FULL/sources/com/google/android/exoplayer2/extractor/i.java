package com.google.android.exoplayer2.extractor;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.zj.adlib.sb0;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30652a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2780a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2781a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f2782a = new byte[10];
    public int b;
    public int c;
    public int d;

    public void a(TrackOutput trackOutput, @Nullable TrackOutput.a aVar) {
        if (this.f30652a > 0) {
            trackOutput.e(this.f2780a, this.b, this.c, this.d, aVar);
            this.f30652a = 0;
        }
    }

    public void b() {
        this.f2781a = false;
        this.f30652a = 0;
    }

    public void c(TrackOutput trackOutput, long j, int i, int i2, int i3, @Nullable TrackOutput.a aVar) {
        sb0.j(this.d <= i2 + i3, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.f2781a) {
            int i4 = this.f30652a;
            int i5 = i4 + 1;
            this.f30652a = i5;
            if (i4 == 0) {
                this.f2780a = j;
                this.b = i;
                this.c = 0;
            }
            this.c += i2;
            this.d = i3;
            if (i5 >= 16) {
                a(trackOutput, aVar);
            }
        }
    }

    public void d(ExtractorInput extractorInput) throws IOException {
        if (this.f2781a) {
            return;
        }
        extractorInput.peekFully(this.f2782a, 0, 10);
        extractorInput.resetPeekPosition();
        if (Ac3Util.i(this.f2782a) == 0) {
            return;
        }
        this.f2781a = true;
    }
}
