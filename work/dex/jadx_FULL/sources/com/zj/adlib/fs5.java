package com.zj.adlib;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class fs5 extends SimpleSubtitleDecoder {
    public static final int d = 8;
    public static final int e = 1885436268;
    public static final int f = 1937011815;
    public static final int g = 1987343459;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final om6 f41748a;

    public fs5() {
        super("Mp4WebvttDecoder");
        this.f41748a = new om6();
    }

    public static Cue m(om6 om6Var, int i) throws SubtitleDecoderException {
        CharSequence charSequenceQ = null;
        Cue.b bVarO = null;
        while (i > 0) {
            if (i < 8) {
                throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
            int iO = om6Var.o();
            int iO2 = om6Var.o();
            int i2 = iO - 8;
            String strJ = gj9.J(om6Var.d(), om6Var.e(), i2);
            om6Var.T(i2);
            i = (i - 8) - i2;
            if (iO2 == 1937011815) {
                bVarO = dv9.o(strJ);
            } else if (iO2 == 1885436268) {
                charSequenceQ = dv9.q(null, strJ.trim(), Collections.emptyList());
            }
        }
        if (charSequenceQ == null) {
            charSequenceQ = "";
        }
        return bVarO != null ? bVarO.A(charSequenceQ).a() : dv9.l(charSequenceQ);
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.f41748a.Q(bArr, i);
        ArrayList arrayList = new ArrayList();
        while (this.f41748a.a() > 0) {
            if (this.f41748a.a() < 8) {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int iO = this.f41748a.o();
            if (this.f41748a.o() == 1987343459) {
                arrayList.add(m(this.f41748a, iO - 8));
            } else {
                this.f41748a.T(iO - 8);
            }
        }
        return new gs5(arrayList);
    }
}
