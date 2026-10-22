package com.google.android.exoplayer2.extractor.flv;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.i;
import com.zj.adlib.om6;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a extends TagPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f30645a = {AVMDLDataLoader.KeyIsIsMaxTlsVersion, 11025, 22050, i.K};
    public static final int b = 2;
    public static final int c = 7;
    public static final int d = 8;
    public static final int e = 10;
    public static final int f = 0;
    public static final int g = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f2749a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2750a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2751b;

    public a(TrackOutput trackOutput) {
        super(trackOutput);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void b() {
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean parseHeader(om6 om6Var) throws TagPayloadReader.UnsupportedFormatException {
        if (this.f2750a) {
            om6Var.T(1);
        } else {
            int iG = om6Var.G();
            int i = (iG >> 4) & 15;
            this.f2749a = i;
            if (i == 2) {
                ((TagPayloadReader) this).f30644a.f(new com.google.android.exoplayer2.d.b().e0("audio/mpeg").H(1).f0(f30645a[(iG >> 2) & 3]).E());
                this.f2751b = true;
            } else if (i == 7 || i == 8) {
                ((TagPayloadReader) this).f30644a.f(new com.google.android.exoplayer2.d.b().e0(i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw").H(1).f0(8000).E());
                this.f2751b = true;
            } else if (i != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.f2749a);
            }
            this.f2750a = true;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean parsePayload(om6 om6Var, long j) throws ParserException {
        if (this.f2749a == 2) {
            int iA = om6Var.a();
            ((TagPayloadReader) this).f30644a.c(om6Var, iA);
            ((TagPayloadReader) this).f30644a.e(j, 1, iA, 0, null);
            return true;
        }
        int iG = om6Var.G();
        if (iG != 0 || this.f2751b) {
            if (this.f2749a == 10 && iG != 1) {
                return false;
            }
            int iA2 = om6Var.a();
            ((TagPayloadReader) this).f30644a.c(om6Var, iA2);
            ((TagPayloadReader) this).f30644a.e(j, 1, iA2, 0, null);
            return true;
        }
        int iA3 = om6Var.a();
        byte[] bArr = new byte[iA3];
        om6Var.k(bArr, 0, iA3);
        AacUtil.b bVarF = AacUtil.f(bArr);
        ((TagPayloadReader) this).f30644a.f(new com.google.android.exoplayer2.d.b().e0("audio/mp4a-latm").I(bVarF.f2344a).H(bVarF.b).f0(bVarF.f30530a).T(Collections.singletonList(bArr)).E());
        this.f2751b = true;
        return false;
    }
}
