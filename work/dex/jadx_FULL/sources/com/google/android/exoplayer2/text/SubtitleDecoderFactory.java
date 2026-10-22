package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.text.cea.b;
import com.zj.adlib.aq6;
import com.zj.adlib.bb3;
import com.zj.adlib.fs5;
import com.zj.adlib.fv9;
import com.zj.adlib.lu8;
import com.zj.adlib.nd9;
import com.zj.adlib.us2;
import com.zj.adlib.xd9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface SubtitleDecoderFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SubtitleDecoderFactory f31005a = new a();

    public class a implements SubtitleDecoderFactory {
        @Override // com.google.android.exoplayer2.text.SubtitleDecoderFactory
        public boolean a(d dVar) {
            String str = dVar.k;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str) || "text/x-exoplayer-cues".equals(str);
        }

        @Override // com.google.android.exoplayer2.text.SubtitleDecoderFactory
        public SubtitleDecoder b(d dVar) {
            String str = dVar.k;
            if (str != null) {
                switch (str) {
                    case "application/dvbsubs":
                        return new us2(dVar.f2569a);
                    case "application/pgs":
                        return new aq6();
                    case "application/x-mp4-vtt":
                        return new fs5();
                    case "text/vtt":
                        return new fv9();
                    case "application/x-quicktime-tx3g":
                        return new xd9(dVar.f2569a);
                    case "text/x-ssa":
                        return new com.google.android.exoplayer2.text.ssa.a(dVar.f2569a);
                    case "application/x-mp4-cea-608":
                    case "application/cea-608":
                        return new com.google.android.exoplayer2.text.cea.a(str, dVar.Z, 16000L);
                    case "text/x-exoplayer-cues":
                        return new bb3();
                    case "application/cea-708":
                        return new b(dVar.Z, dVar.f2569a);
                    case "application/x-subrip":
                        return new lu8();
                    case "application/ttml+xml":
                        return new nd9();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(d dVar);

    SubtitleDecoder b(d dVar);
}
