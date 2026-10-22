package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class wo4 implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45646a = "http://ns.adobe.com/xap/1.0/";
    public static final long b = 1165519206;
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 4;
    public static final int k = 5;
    public static final int l = 6;
    public static final int m = 6;
    public static final int n = 65496;
    public static final int o = 65498;
    public static final int p = 65504;
    public static final int q = 65505;
    public static final int r = 1024;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExtractorInput f20484a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExtractorOutput f20485a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Mp4Extractor f20486a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public MotionPhotoMetadata f20487a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public up8 f20489a;
    public int d;
    public int e;
    public int f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f20488a = new om6(6);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f20483a = -1;

    @Nullable
    public static MotionPhotoMetadata f(String str, long j2) throws IOException {
        vr5 vr5VarA;
        if (j2 == -1 || (vr5VarA = b7a.a(str)) == null) {
            return null;
        }
        return vr5VarA.a(j2);
    }

    public final void a(ExtractorInput extractorInput) throws IOException {
        this.f20488a.O(2);
        extractorInput.peekFully(this.f20488a.d(), 0, 2);
        extractorInput.advancePeekPosition(this.f20488a.M() - 2);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(ExtractorOutput extractorOutput) {
        this.f20485a = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int c(ExtractorInput extractorInput, iv6 iv6Var) throws IOException {
        int i2 = this.d;
        if (i2 == 0) {
            i(extractorInput);
            return 0;
        }
        if (i2 == 1) {
            k(extractorInput);
            return 0;
        }
        if (i2 == 2) {
            j(extractorInput);
            return 0;
        }
        if (i2 == 4) {
            long position = extractorInput.getPosition();
            long j2 = this.f20483a;
            if (position != j2) {
                iv6Var.f42452a = j2;
                return 1;
            }
            l(extractorInput);
            return 0;
        }
        if (i2 != 5) {
            if (i2 == 6) {
                return -1;
            }
            throw new IllegalStateException();
        }
        if (this.f20489a == null || extractorInput != this.f20484a) {
            this.f20484a = extractorInput;
            this.f20489a = new up8(extractorInput, this.f20483a);
        }
        int iC = ((Mp4Extractor) sb0.g(this.f20486a)).c(this.f20489a, iv6Var);
        if (iC == 1) {
            iv6Var.f42452a += this.f20483a;
        }
        return iC;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean d(ExtractorInput extractorInput) throws IOException {
        if (h(extractorInput) != 65496) {
            return false;
        }
        int iH = h(extractorInput);
        this.e = iH;
        if (iH == 65504) {
            a(extractorInput);
            this.e = h(extractorInput);
        }
        if (this.e != 65505) {
            return false;
        }
        extractorInput.advancePeekPosition(2);
        this.f20488a.O(6);
        extractorInput.peekFully(this.f20488a.d(), 0, 6);
        return this.f20488a.I() == b && this.f20488a.M() == 0;
    }

    public final void e() {
        g(new Metadata.Entry[0]);
        ((ExtractorOutput) sb0.g(this.f20485a)).endTracks();
        this.f20485a.d(new SeekMap.b(-9223372036854775807L));
        this.d = 6;
    }

    public final void g(Metadata.Entry... entryArr) {
        ((ExtractorOutput) sb0.g(this.f20485a)).b(1024, 4).f(new d.b().K("image/jpeg").X(new Metadata(entryArr)).E());
    }

    public final int h(ExtractorInput extractorInput) throws IOException {
        this.f20488a.O(2);
        extractorInput.peekFully(this.f20488a.d(), 0, 2);
        return this.f20488a.M();
    }

    public final void i(ExtractorInput extractorInput) throws IOException {
        this.f20488a.O(2);
        extractorInput.readFully(this.f20488a.d(), 0, 2);
        int iM = this.f20488a.M();
        this.e = iM;
        if (iM == 65498) {
            if (this.f20483a != -1) {
                this.d = 4;
                return;
            } else {
                e();
                return;
            }
        }
        if ((iM < 65488 || iM > 65497) && iM != 65281) {
            this.d = 1;
        }
    }

    public final void j(ExtractorInput extractorInput) throws IOException {
        String strA;
        if (this.e == 65505) {
            om6 om6Var = new om6(this.f);
            extractorInput.readFully(om6Var.d(), 0, this.f);
            if (this.f20487a == null && f45646a.equals(om6Var.A()) && (strA = om6Var.A()) != null) {
                MotionPhotoMetadata motionPhotoMetadataF = f(strA, extractorInput.getLength());
                this.f20487a = motionPhotoMetadataF;
                if (motionPhotoMetadataF != null) {
                    this.f20483a = motionPhotoMetadataF.videoStartPosition;
                }
            }
        } else {
            extractorInput.skipFully(this.f);
        }
        this.d = 0;
    }

    public final void k(ExtractorInput extractorInput) throws IOException {
        this.f20488a.O(2);
        extractorInput.readFully(this.f20488a.d(), 0, 2);
        this.f = this.f20488a.M() - 2;
        this.d = 2;
    }

    public final void l(ExtractorInput extractorInput) throws IOException {
        if (!extractorInput.peekFully(this.f20488a.d(), 0, 1, true)) {
            e();
            return;
        }
        extractorInput.resetPeekPosition();
        if (this.f20486a == null) {
            this.f20486a = new Mp4Extractor();
        }
        up8 up8Var = new up8(extractorInput, this.f20483a);
        this.f20489a = up8Var;
        if (!this.f20486a.d(up8Var)) {
            e();
        } else {
            this.f20486a.b(new vp8(this.f20483a, (ExtractorOutput) sb0.g(this.f20485a)));
            m();
        }
    }

    public final void m() {
        g((Metadata.Entry) sb0.g(this.f20487a));
        this.d = 5;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
        Mp4Extractor mp4Extractor = this.f20486a;
        if (mp4Extractor != null) {
            mp4Extractor.release();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j2, long j3) {
        if (j2 == 0) {
            this.d = 0;
            this.f20486a = null;
        } else if (this.d == 5) {
            ((Mp4Extractor) sb0.g(this.f20486a)).seek(j2, j3);
        }
    }
}
