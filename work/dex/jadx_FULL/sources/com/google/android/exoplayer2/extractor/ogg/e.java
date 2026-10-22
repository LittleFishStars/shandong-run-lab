package com.google.android.exoplayer2.extractor.ogg;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.j;
import com.google.common.collect.ImmutableList;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e extends StreamReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public j.b f30698a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public j.d f3053a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public a f3054a;
    public boolean c;
    public int g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30699a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final j.b f3055a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final j.d f3056a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final byte[] f3057a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final j.c[] f3058a;

        public a(j.d dVar, j.b bVar, byte[] bArr, j.c[] cVarArr, int i) {
            this.f3056a = dVar;
            this.f3055a = bVar;
            this.f3057a = bArr;
            this.f3058a = cVarArr;
            this.f30699a = i;
        }
    }

    @VisibleForTesting
    public static void h(om6 om6Var, long j) {
        if (om6Var.b() < om6Var.f() + 4) {
            om6Var.P(Arrays.copyOf(om6Var.d(), om6Var.f() + 4));
        } else {
            om6Var.R(om6Var.f() + 4);
        }
        byte[] bArrD = om6Var.d();
        bArrD[om6Var.f() - 4] = (byte) (j & 255);
        bArrD[om6Var.f() - 3] = (byte) ((j >>> 8) & 255);
        bArrD[om6Var.f() - 2] = (byte) ((j >>> 16) & 255);
        bArrD[om6Var.f() - 1] = (byte) ((j >>> 24) & 255);
    }

    public static int i(byte b, a aVar) {
        return !aVar.f3058a[j(b, aVar.f30699a, 1)].f2787a ? aVar.f3056a.g : aVar.f3056a.h;
    }

    @VisibleForTesting
    public static int j(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    public static boolean l(om6 om6Var) {
        try {
            return j.m(1, om6Var, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Nullable
    @VisibleForTesting
    public a k(om6 om6Var) throws IOException {
        j.d dVar = this.f3053a;
        if (dVar == null) {
            this.f3053a = j.k(om6Var);
            return null;
        }
        j.b bVar = this.f30698a;
        if (bVar == null) {
            this.f30698a = j.i(om6Var);
            return null;
        }
        byte[] bArr = new byte[om6Var.f()];
        System.arraycopy(om6Var.d(), 0, bArr, 0, om6Var.f());
        j.c[] cVarArrL = j.l(om6Var, dVar.b);
        return new a(dVar, bVar, bArr, cVarArrL, j.a(cVarArrL.length - 1));
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void onSeekEnd(long j) {
        super.onSeekEnd(j);
        this.c = j != 0;
        j.d dVar = this.f3053a;
        this.g = dVar != null ? dVar.g : 0;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public long preparePayload(om6 om6Var) {
        if ((om6Var.d()[0] & 1) == 1) {
            return -1L;
        }
        int i = i(om6Var.d()[0], (a) sb0.k(this.f3054a));
        long j = this.c ? (this.g + i) / 4 : 0;
        h(om6Var, j);
        this.c = true;
        this.g = i;
        return j;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean readHeaders(om6 om6Var, long j, StreamReader.b bVar) throws IOException {
        if (this.f3054a != null) {
            sb0.g(bVar.f30691a);
            return false;
        }
        a aVarK = k(om6Var);
        this.f3054a = aVarK;
        if (aVarK == null) {
            return true;
        }
        j.d dVar = aVarK.f3056a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar.f2789a);
        arrayList.add(aVarK.f3057a);
        bVar.f30691a = new com.google.android.exoplayer2.d.b().e0("audio/vorbis").G(dVar.e).Z(dVar.d).H(dVar.b).f0(dVar.c).T(arrayList).X(j.c(ImmutableList.copyOf(aVarK.f3055a.f2786a))).E();
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void reset(boolean z) {
        super.reset(z);
        if (z) {
            this.f3054a = null;
            this.f3053a = null;
            this.f30698a = null;
        }
        this.g = 0;
        this.c = false;
    }
}
