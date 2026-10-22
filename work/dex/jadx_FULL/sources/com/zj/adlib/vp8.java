package com.zj.adlib;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class vp8 implements ExtractorOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f45413a;
    public final ExtractorOutput b;

    public class a implements SeekMap {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SeekMap f45414a;

        public a(SeekMap seekMap) {
            this.f45414a = seekMap;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public SeekMap.a a(long j) {
            SeekMap.a aVarA = this.f45414a.a(j);
            x38 x38Var = aVarA.f30623a;
            x38 x38Var2 = new x38(x38Var.f20602a, x38Var.b + vp8.this.f45413a);
            x38 x38Var3 = aVarA.b;
            return new SeekMap.a(x38Var2, new x38(x38Var3.f20602a, x38Var3.b + vp8.this.f45413a));
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.f45414a.getDurationUs();
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return this.f45414a.isSeekable();
        }
    }

    public vp8(long j, ExtractorOutput extractorOutput) {
        this.f45413a = j;
        this.b = extractorOutput;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput b(int i, int i2) {
        return this.b.b(i, i2);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void d(SeekMap seekMap) {
        this.b.d(new a(seekMap));
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        this.b.endTracks();
    }
}
