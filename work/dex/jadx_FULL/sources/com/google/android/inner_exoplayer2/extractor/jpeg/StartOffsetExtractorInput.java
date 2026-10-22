package com.google.android.inner_exoplayer2.extractor.jpeg;

import com.google.android.inner_exoplayer2.extractor.ExtractorInput;
import com.google.android.inner_exoplayer2.extractor.ForwardingExtractorInput;
import com.google.android.inner_exoplayer2.util.Assertions;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class StartOffsetExtractorInput extends ForwardingExtractorInput {
    private final long startOffset;

    public StartOffsetExtractorInput(ExtractorInput extractorInput, long j) {
        super(extractorInput);
        Assertions.checkArgument(extractorInput.getPosition() >= j);
        this.startOffset = j;
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ForwardingExtractorInput, com.google.android.inner_exoplayer2.extractor.ExtractorInput
    public long getLength() {
        return super.getLength() - this.startOffset;
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ForwardingExtractorInput, com.google.android.inner_exoplayer2.extractor.ExtractorInput
    public long getPeekPosition() {
        return super.getPeekPosition() - this.startOffset;
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ForwardingExtractorInput, com.google.android.inner_exoplayer2.extractor.ExtractorInput
    public long getPosition() {
        return super.getPosition() - this.startOffset;
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ForwardingExtractorInput, com.google.android.inner_exoplayer2.extractor.ExtractorInput
    public <E extends Throwable> void setRetryPosition(long j, E e) {
        super.setRetryPosition(j + this.startOffset, e);
    }
}
