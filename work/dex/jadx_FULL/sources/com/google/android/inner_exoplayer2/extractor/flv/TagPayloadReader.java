package com.google.android.inner_exoplayer2.extractor.flv;

import com.google.android.inner_exoplayer2.ParserException;
import com.google.android.inner_exoplayer2.extractor.TrackOutput;
import com.google.android.inner_exoplayer2.util.ParsableByteArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
abstract class TagPayloadReader {
    protected final TrackOutput output;

    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str, null, false, 1);
        }
    }

    public TagPayloadReader(TrackOutput trackOutput) {
        this.output = trackOutput;
    }

    public final boolean consume(ParsableByteArray parsableByteArray, long j) {
        return parseHeader(parsableByteArray) && parsePayload(parsableByteArray, j);
    }

    public abstract boolean parseHeader(ParsableByteArray parsableByteArray);

    public abstract boolean parsePayload(ParsableByteArray parsableByteArray, long j);

    public abstract void seek();
}
