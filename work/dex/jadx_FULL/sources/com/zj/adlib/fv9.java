package com.zj.adlib;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class fv9 extends SimpleSubtitleDecoder {
    public static final String b = "NOTE";
    public static final String c = "STYLE";
    public static final int d = -1;
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bv9 f41767a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f16635a;

    public fv9() {
        super("WebvttDecoder");
        this.f16635a = new om6();
        this.f41767a = new bv9();
    }

    public static int m(om6 om6Var) {
        int i = -1;
        int iE = 0;
        while (i == -1) {
            iE = om6Var.e();
            String strQ = om6Var.q();
            if (strQ == null) {
                i = 0;
            } else if (c.equals(strQ)) {
                i = 2;
            } else {
                i = strQ.startsWith(b) ? 1 : 3;
            }
        }
        om6Var.S(iE);
        return i;
    }

    public static void n(om6 om6Var) {
        while (!TextUtils.isEmpty(om6Var.q())) {
        }
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        cv9 cv9VarM;
        this.f16635a.Q(bArr, i);
        ArrayList arrayList = new ArrayList();
        try {
            hv9.e(this.f16635a);
            while (!TextUtils.isEmpty(this.f16635a.q())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int iM = m(this.f16635a);
                if (iM == 0) {
                    return new jv9(arrayList2);
                }
                if (iM == 1) {
                    n(this.f16635a);
                } else if (iM == 2) {
                    if (!arrayList2.isEmpty()) {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                    this.f16635a.q();
                    arrayList.addAll(this.f41767a.d(this.f16635a));
                } else if (iM == 3 && (cv9VarM = dv9.m(this.f16635a, arrayList)) != null) {
                    arrayList2.add(cv9VarM);
                }
            }
        } catch (ParserException e2) {
            throw new SubtitleDecoderException(e2);
        }
    }
}
