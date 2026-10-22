package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.zj.adlib.om6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
abstract class TagPayloadReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TrackOutput f30644a;

    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str, null, false, 1);
        }
    }

    public TagPayloadReader(TrackOutput trackOutput) {
        this.f30644a = trackOutput;
    }

    public final boolean a(om6 om6Var, long j) throws ParserException {
        return parseHeader(om6Var) && parsePayload(om6Var, j);
    }

    public abstract void b();

    public abstract boolean parseHeader(om6 om6Var) throws ParserException;

    public abstract boolean parsePayload(om6 om6Var, long j) throws ParserException;
}
