package com.google.android.inner_exoplayer2.text;

import com.google.android.inner_exoplayer2.Format;
import com.google.android.inner_exoplayer2.text.cea.Cea608Decoder;
import com.google.android.inner_exoplayer2.text.cea.Cea708Decoder;
import com.google.android.inner_exoplayer2.text.dvb.DvbDecoder;
import com.google.android.inner_exoplayer2.text.pgs.PgsDecoder;
import com.google.android.inner_exoplayer2.text.ssa.SsaDecoder;
import com.google.android.inner_exoplayer2.text.subrip.SubripDecoder;
import com.google.android.inner_exoplayer2.text.ttml.TtmlDecoder;
import com.google.android.inner_exoplayer2.text.tx3g.Tx3gDecoder;
import com.google.android.inner_exoplayer2.text.webvtt.Mp4WebvttDecoder;
import com.google.android.inner_exoplayer2.text.webvtt.WebvttDecoder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface SubtitleDecoderFactory {
    public static final SubtitleDecoderFactory DEFAULT = new SubtitleDecoderFactory() { // from class: com.google.android.inner_exoplayer2.text.SubtitleDecoderFactory.1
        @Override // com.google.android.inner_exoplayer2.text.SubtitleDecoderFactory
        public SubtitleDecoder createDecoder(Format format) {
            String str = format.sampleMimeType;
            if (str != null) {
                switch (str) {
                    case "application/dvbsubs":
                        return new DvbDecoder(format.initializationData);
                    case "application/pgs":
                        return new PgsDecoder();
                    case "application/x-mp4-vtt":
                        return new Mp4WebvttDecoder();
                    case "text/vtt":
                        return new WebvttDecoder();
                    case "application/x-quicktime-tx3g":
                        return new Tx3gDecoder(format.initializationData);
                    case "text/x-ssa":
                        return new SsaDecoder(format.initializationData);
                    case "application/x-mp4-cea-608":
                    case "application/cea-608":
                        return new Cea608Decoder(str, format.accessibilityChannel, 16000L);
                    case "text/x-exoplayer-cues":
                        return new ExoplayerCuesDecoder();
                    case "application/cea-708":
                        return new Cea708Decoder(format.accessibilityChannel, format.initializationData);
                    case "application/x-subrip":
                        return new SubripDecoder();
                    case "application/ttml+xml":
                        return new TtmlDecoder();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }

        @Override // com.google.android.inner_exoplayer2.text.SubtitleDecoderFactory
        public boolean supportsFormat(Format format) {
            String str = format.sampleMimeType;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str) || "text/x-exoplayer-cues".equals(str);
        }
    };

    SubtitleDecoder createDecoder(Format format);

    boolean supportsFormat(Format format);
}
