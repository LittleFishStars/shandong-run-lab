package com.google.android.inner_exoplayer2.extractor.avi;

import com.google.android.inner_exoplayer2.util.ParsableByteArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class AviMainHeaderChunk implements AviChunk {
    private static final int AVIF_HAS_INDEX = 16;
    public final int flags;
    public final int frameDurationUs;
    public final int streams;
    public final int totalFrames;

    private AviMainHeaderChunk(int i, int i2, int i3, int i4) {
        this.frameDurationUs = i;
        this.flags = i2;
        this.totalFrames = i3;
        this.streams = i4;
    }

    public static AviMainHeaderChunk parseFrom(ParsableByteArray parsableByteArray) {
        int littleEndianInt = parsableByteArray.readLittleEndianInt();
        parsableByteArray.skipBytes(8);
        int littleEndianInt2 = parsableByteArray.readLittleEndianInt();
        int littleEndianInt3 = parsableByteArray.readLittleEndianInt();
        parsableByteArray.skipBytes(4);
        int littleEndianInt4 = parsableByteArray.readLittleEndianInt();
        parsableByteArray.skipBytes(12);
        return new AviMainHeaderChunk(littleEndianInt, littleEndianInt2, littleEndianInt3, littleEndianInt4);
    }

    @Override // com.google.android.inner_exoplayer2.extractor.avi.AviChunk
    public int getType() {
        return 1751742049;
    }

    public boolean hasIndex() {
        return (this.flags & 16) == 16;
    }
}
