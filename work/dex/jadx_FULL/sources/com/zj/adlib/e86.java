package com.zj.adlib;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e86 {
    public static final int f = 27;
    public static final int g = 255;
    public static final int h = 65025;
    public static final int i = 65307;
    public static final int j = 1332176723;
    public static final int k = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41371a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f16228a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f16231b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f16232c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f16233d;
    public int e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f16230a = new int[255];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f16229a = new om6(255);

    public boolean a(ExtractorInput extractorInput, boolean z) throws IOException {
        b();
        this.f16229a.O(27);
        if (!fc3.b(extractorInput, this.f16229a.d(), 0, 27, z) || this.f16229a.I() != 1332176723) {
            return false;
        }
        int iG = this.f16229a.G();
        this.f41371a = iG;
        if (iG != 0) {
            if (z) {
                return false;
            }
            throw ParserException.createForUnsupportedContainerFeature("unsupported bit stream revision");
        }
        this.b = this.f16229a.G();
        this.f16228a = this.f16229a.t();
        this.f16231b = this.f16229a.v();
        this.f16232c = this.f16229a.v();
        this.f16233d = this.f16229a.v();
        int iG2 = this.f16229a.G();
        this.c = iG2;
        this.d = iG2 + 27;
        this.f16229a.O(iG2);
        if (!fc3.b(extractorInput, this.f16229a.d(), 0, this.c, z)) {
            return false;
        }
        for (int i2 = 0; i2 < this.c; i2++) {
            this.f16230a[i2] = this.f16229a.G();
            this.e += this.f16230a[i2];
        }
        return true;
    }

    public void b() {
        this.f41371a = 0;
        this.b = 0;
        this.f16228a = 0L;
        this.f16231b = 0L;
        this.f16232c = 0L;
        this.f16233d = 0L;
        this.c = 0;
        this.d = 0;
        this.e = 0;
    }

    public boolean c(ExtractorInput extractorInput) throws IOException {
        return d(extractorInput, -1L);
    }

    public boolean d(ExtractorInput extractorInput, long j2) throws IOException {
        sb0.a(extractorInput.getPosition() == extractorInput.getPeekPosition());
        this.f16229a.O(4);
        while (true) {
            if ((j2 != -1 && extractorInput.getPosition() + 4 >= j2) || !fc3.b(extractorInput, this.f16229a.d(), 0, 4, true)) {
                break;
            }
            this.f16229a.S(0);
            if (this.f16229a.I() == 1332176723) {
                extractorInput.resetPeekPosition();
                return true;
            }
            extractorInput.skipFully(1);
        }
        do {
            if (j2 != -1 && extractorInput.getPosition() >= j2) {
                break;
            }
        } while (extractorInput.skip(1) != -1);
        return false;
    }
}
