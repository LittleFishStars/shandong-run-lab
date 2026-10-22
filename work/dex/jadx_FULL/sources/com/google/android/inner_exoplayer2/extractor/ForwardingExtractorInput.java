package com.google.android.inner_exoplayer2.extractor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ForwardingExtractorInput implements ExtractorInput {
    private final ExtractorInput input;

    public ForwardingExtractorInput(ExtractorInput extractorInput) {
        this.input = extractorInput;
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ExtractorInput
    public boolean advancePeekPosition(int i, boolean z) {
        return this.input.advancePeekPosition(i, z);
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ExtractorInput
    public long getLength() {
        return this.input.getLength();
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ExtractorInput
    public long getPeekPosition() {
        return this.input.getPeekPosition();
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ExtractorInput
    public long getPosition() {
        return this.input.getPosition();
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ExtractorInput
    public int peek(byte[] bArr, int i, int i2) {
        return this.input.peek(bArr, i, i2);
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ExtractorInput
    public boolean peekFully(byte[] bArr, int i, int i2, boolean z) {
        return this.input.peekFully(bArr, i, i2, z);
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ExtractorInput, com.google.android.inner_exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i, int i2) {
        return this.input.read(bArr, i, i2);
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ExtractorInput
    public boolean readFully(byte[] bArr, int i, int i2, boolean z) {
        return this.input.readFully(bArr, i, i2, z);
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ExtractorInput
    public void resetPeekPosition() {
        this.input.resetPeekPosition();
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ExtractorInput
    public <E extends Throwable> void setRetryPosition(long j, E e) {
        this.input.setRetryPosition(j, e);
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ExtractorInput
    public int skip(int i) {
        return this.input.skip(i);
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ExtractorInput
    public boolean skipFully(int i, boolean z) {
        return this.input.skipFully(i, z);
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ExtractorInput
    public void advancePeekPosition(int i) {
        this.input.advancePeekPosition(i);
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ExtractorInput
    public void peekFully(byte[] bArr, int i, int i2) {
        this.input.peekFully(bArr, i, i2);
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ExtractorInput
    public void readFully(byte[] bArr, int i, int i2) {
        this.input.readFully(bArr, i, i2);
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ExtractorInput
    public void skipFully(int i) {
        this.input.skipFully(i);
    }
}
