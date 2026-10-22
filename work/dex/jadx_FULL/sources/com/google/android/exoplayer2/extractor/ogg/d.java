package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.common.collect.ImmutableList;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import com.zj.adlib.sd6;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d extends StreamReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f30697a = {79, 112, 117, 115, 72, 101, 97, 100};
    public static final byte[] b = {79, 112, 117, 115, 84, 97, 103, 115};
    public boolean c;

    public static boolean i(om6 om6Var, byte[] bArr) {
        if (om6Var.a() < bArr.length) {
            return false;
        }
        int iE = om6Var.e();
        byte[] bArr2 = new byte[bArr.length];
        om6Var.k(bArr2, 0, bArr.length);
        om6Var.S(iE);
        return Arrays.equals(bArr2, bArr);
    }

    public static boolean j(om6 om6Var) {
        return i(om6Var, f30697a);
    }

    public final long h(byte[] bArr) {
        int i;
        int i2;
        int i3 = bArr[0] & 255;
        int i4 = i3 & 3;
        if (i4 != 0) {
            i = 2;
            if (i4 != 1 && i4 != 2) {
                i = bArr[1] & 63;
            }
        } else {
            i = 1;
        }
        int i5 = i3 >> 3;
        int i6 = i5 & 3;
        if (i5 >= 16) {
            i2 = 2500 << i6;
        } else if (i5 >= 12) {
            i2 = 10000 << (i6 & 1);
        } else {
            i2 = i6 == 3 ? 60000 : 10000 << i6;
        }
        return ((long) i) * ((long) i2);
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public long preparePayload(om6 om6Var) {
        return convertTimeToGranule(h(om6Var.d()));
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean readHeaders(om6 om6Var, long j, StreamReader.b bVar) throws ParserException {
        if (i(om6Var, f30697a)) {
            byte[] bArrCopyOf = Arrays.copyOf(om6Var.d(), om6Var.f());
            int iC = sd6.c(bArrCopyOf);
            List<byte[]> listA = sd6.a(bArrCopyOf);
            if (bVar.f30691a != null) {
                return true;
            }
            bVar.f30691a = new com.google.android.exoplayer2.d.b().e0("audio/opus").H(iC).f0(48000).T(listA).E();
            return true;
        }
        byte[] bArr = b;
        if (!i(om6Var, bArr)) {
            sb0.k(bVar.f30691a);
            return false;
        }
        sb0.k(bVar.f30691a);
        if (this.c) {
            return true;
        }
        this.c = true;
        om6Var.T(bArr.length);
        Metadata metadataC = j.c(ImmutableList.copyOf(j.j(om6Var, false, false).f2786a));
        if (metadataC == null) {
            return true;
        }
        bVar.f30691a = bVar.f30691a.b().X(metadataC.copyWithAppendedEntriesFrom(bVar.f30691a.f2567a)).E();
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void reset(boolean z) {
        super.reset(z);
        if (z) {
            this.c = false;
        }
    }
}
