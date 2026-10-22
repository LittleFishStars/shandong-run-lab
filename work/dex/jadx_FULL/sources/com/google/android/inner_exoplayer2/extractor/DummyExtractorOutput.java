package com.google.android.inner_exoplayer2.extractor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class DummyExtractorOutput implements ExtractorOutput {
    @Override // com.google.android.inner_exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
    }

    @Override // com.google.android.inner_exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int i, int i2) {
        return new DummyTrackOutput();
    }
}
