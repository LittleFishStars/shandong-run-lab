package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.zj.adlib.fn8;
import com.zj.adlib.m53;
import com.zj.adlib.r54;
import com.zj.adlib.s90;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface MetadataDecoderFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MetadataDecoderFactory f30775a = new a();

    public class a implements MetadataDecoderFactory {
        @Override // com.google.android.exoplayer2.metadata.MetadataDecoderFactory
        public boolean a(d dVar) {
            String str = dVar.k;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }

        @Override // com.google.android.exoplayer2.metadata.MetadataDecoderFactory
        public MetadataDecoder b(d dVar) {
            String str = dVar.k;
            if (str != null) {
                switch (str) {
                    case "application/vnd.dvb.ait":
                        return new s90();
                    case "application/x-icy":
                        return new r54();
                    case "application/id3":
                        return new Id3Decoder();
                    case "application/x-emsg":
                        return new m53();
                    case "application/x-scte35":
                        return new fn8();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(d dVar);

    MetadataDecoder b(d dVar);
}
