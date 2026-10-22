package com.zj.adlib;

import android.media.MediaFormat;
import android.media.MediaParser;
import android.media.metrics.LogSessionId;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ek5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41458a = "android.media.mediaparser.inBandCryptoInfo";
    public static final String b = "android.media.mediaparser.includeSupplementalData";
    public static final String c = "android.media.mediaparser.eagerlyExposeTrackType";
    public static final String d = "android.media.mediaparser.exposeDummySeekMap";
    public static final String e = "android.media.mediaParser.exposeChunkIndexAsMediaFormat";
    public static final String f = "android.media.mediaParser.overrideInBandCaptionDeclarations";
    public static final String g = "android.media.mediaParser.exposeCaptionFormats";
    public static final String h = "android.media.mediaparser.ignoreTimestampOffset";

    @RequiresApi(31)
    public static final class a {
        @DoNotInline
        public static void a(MediaParser mediaParser, at6 at6Var) {
            LogSessionId logSessionIdA = at6Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            mediaParser.setLogSessionId(logSessionIdA);
        }
    }

    @RequiresApi(31)
    public static void a(MediaParser mediaParser, at6 at6Var) {
        a.a(mediaParser, at6Var);
    }

    public static MediaFormat b(d dVar) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", dVar.k);
        int i = dVar.Z;
        if (i != -1) {
            mediaFormat.setInteger("caption-service-number", i);
        }
        return mediaFormat;
    }
}
