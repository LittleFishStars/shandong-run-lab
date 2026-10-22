package com.zj.adlib;

import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class us2 extends SimpleSubtitleDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vs2 f45222a;

    public us2(List<byte[]> list) {
        super("DvbDecoder");
        om6 om6Var = new om6(list.get(0));
        this.f45222a = new vs2(om6Var.M(), om6Var.M());
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i, boolean z) {
        if (z) {
            this.f45222a.r();
        }
        return new ws2(this.f45222a.b(bArr, i));
    }
}
