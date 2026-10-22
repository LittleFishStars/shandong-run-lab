package com.google.android.exoplayer2.extractor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface ExtractorOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExtractorOutput f30621a = new a();

    public class a implements ExtractorOutput {
        @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
        public TrackOutput b(int i, int i2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
        public void d(SeekMap seekMap) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
        public void endTracks() {
            throw new UnsupportedOperationException();
        }
    }

    TrackOutput b(int i, int i2);

    void d(SeekMap seekMap);

    void endTracks();
}
