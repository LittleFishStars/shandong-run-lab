package com.google.android.exoplayer2.source.rtsp.reader;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.rtsp.b;
import com.zj.adlib.bk7;
import com.zj.adlib.ck7;
import com.zj.adlib.dk7;
import com.zj.adlib.fk7;
import com.zj.adlib.gk7;
import com.zj.adlib.hk7;
import com.zj.adlib.ik7;
import com.zj.adlib.jk7;
import com.zj.adlib.nk7;
import com.zj.adlib.pk7;
import com.zj.adlib.qk7;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements RtpPayloadReader.Factory {
    @Override // com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader.Factory
    @Nullable
    public RtpPayloadReader a(b bVar) {
        String str = (String) sb0.g(bVar.f4394a.k);
        str.hashCode();
        switch (str) {
            case "video/3gpp":
                return new fk7(bVar);
            case "video/hevc":
                return new hk7(bVar);
            case "audio/amr-wb":
            case "audio/3gpp":
                return new dk7(bVar);
            case "audio/mp4a-latm":
                return new bk7(bVar);
            case "audio/ac3":
                return new ck7(bVar);
            case "audio/raw":
            case "audio/g711-alaw":
            case "audio/g711-mlaw":
                return new nk7(bVar);
            case "video/mp4v-es":
                return new ik7(bVar);
            case "video/avc":
                return new gk7(bVar);
            case "audio/opus":
                return new jk7(bVar);
            case "video/x-vnd.on2.vp8":
                return new pk7(bVar);
            case "video/x-vnd.on2.vp9":
                return new qk7(bVar);
            default:
                return null;
        }
    }
}
