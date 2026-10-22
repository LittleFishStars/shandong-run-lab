package com.zj.adlib;

import com.google.android.exoplayer2.extractor.ExtractorInput;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class up8 extends dl3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f45202a;

    public up8(ExtractorInput extractorInput, long j) {
        super(extractorInput);
        sb0.a(extractorInput.getPosition() >= j);
        this.f45202a = j;
    }

    @Override // com.zj.adlib.dl3, com.google.android.exoplayer2.extractor.ExtractorInput
    public long getLength() {
        return super.getLength() - this.f45202a;
    }

    @Override // com.zj.adlib.dl3, com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPeekPosition() {
        return super.getPeekPosition() - this.f45202a;
    }

    @Override // com.zj.adlib.dl3, com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPosition() {
        return super.getPosition() - this.f45202a;
    }

    @Override // com.zj.adlib.dl3, com.google.android.exoplayer2.extractor.ExtractorInput
    public <E extends Throwable> void setRetryPosition(long j, E e) throws Throwable {
        super.setRetryPosition(j + this.f45202a, e);
    }
}
