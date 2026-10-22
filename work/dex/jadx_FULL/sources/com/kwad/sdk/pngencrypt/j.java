package com.kwad.sdk.pngencrypt;

import java.util.Arrays;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class j extends DeflatedChunksSet {
    protected final e bjO;
    protected byte[] bkI;
    protected byte[] bkJ;
    protected final k bkK;
    final p bkL;
    protected int[] bkM;

    /* JADX INFO: renamed from: com.kwad.sdk.pngencrypt.j$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] bkN;

        static {
            int[] iArr = new int[FilterType.values().length];
            bkN = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                bkN[FilterType.FILTER_SUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                bkN[FilterType.FILTER_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                bkN[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                bkN[FilterType.FILTER_PAETH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public j(String str, boolean z, k kVar, e eVar) {
        this(str, z, kVar, eVar, null, null);
    }

    private void Tc() {
        fo(this.bkL.bls);
    }

    private int Td() {
        int iTb;
        e eVar = this.bjO;
        int i = 0;
        if (eVar == null) {
            int iST = ST();
            k kVar = this.bkK;
            if (iST < kVar.bkv - 1) {
                iTb = kVar.bkW;
                i = iTb + 1;
            }
        } else if (eVar.SU()) {
            iTb = this.bjO.Tb();
            i = iTb + 1;
        }
        if (!this.bjR) {
            fk(i);
        }
        return i;
    }

    private void fo(int i) {
        byte[] bArr = this.bkI;
        if (bArr == null || bArr.length < this.bkh.length) {
            byte[] bArr2 = this.bkh;
            this.bkI = new byte[bArr2.length];
            this.bkJ = new byte[bArr2.length];
        }
        if (this.bkL.blp == 0) {
            Arrays.fill(this.bkI, (byte) 0);
        }
        byte[] bArr3 = this.bkI;
        this.bkI = this.bkJ;
        this.bkJ = bArr3;
        byte b = this.bkh[0];
        if (!FilterType.isValidStandard(b)) {
            throw new PngjException("Filter type " + ((int) b) + " invalid");
        }
        FilterType byVal = FilterType.getByVal(b);
        int[] iArr = this.bkM;
        iArr[b] = iArr[b] + 1;
        this.bkI[0] = this.bkh[0];
        int i2 = AnonymousClass1.bkN[byVal.ordinal()];
        if (i2 == 1) {
            fq(i);
            return;
        }
        if (i2 == 2) {
            fs(i);
            return;
        }
        if (i2 == 3) {
            ft(i);
            return;
        }
        if (i2 == 4) {
            fp(i);
        } else {
            if (i2 == 5) {
                fr(i);
                return;
            }
            throw new PngjException("Filter type " + ((int) b) + " not implemented");
        }
    }

    private void fp(int i) {
        int i2 = 1;
        int i3 = 1 - this.bkK.bkV;
        while (i2 <= i) {
            this.bkI[i2] = (byte) (this.bkh[i2] + (((i3 > 0 ? this.bkI[i3] & 255 : 0) + (this.bkJ[i2] & 255)) / 2));
            i2++;
            i3++;
        }
    }

    private void fq(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.bkI[i2] = this.bkh[i2];
        }
    }

    private void fr(int i) {
        int i2 = 1;
        int i3 = 1 - this.bkK.bkV;
        while (i2 <= i) {
            int i4 = 0;
            int i5 = i3 > 0 ? this.bkI[i3] & 255 : 0;
            if (i3 > 0) {
                i4 = this.bkJ[i3] & 255;
            }
            this.bkI[i2] = (byte) (this.bkh[i2] + n.d(i5, this.bkJ[i2] & 255, i4));
            i2++;
            i3++;
        }
    }

    private void fs(int i) {
        int i2;
        int i3 = 1;
        while (true) {
            i2 = this.bkK.bkV;
            if (i3 > i2) {
                break;
            }
            this.bkI[i3] = this.bkh[i3];
            i3++;
        }
        int i4 = i2 + 1;
        int i5 = 1;
        while (i4 <= i) {
            byte[] bArr = this.bkI;
            bArr[i4] = (byte) (this.bkh[i4] + bArr[i5]);
            i4++;
            i5++;
        }
    }

    private void ft(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.bkI[i2] = (byte) (this.bkh[i2] + this.bkJ[i2]);
        }
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void SR() {
        super.SR();
        this.bkL.update(ST());
        Tc();
        p pVar = this.bkL;
        pVar.h(this.bkI, pVar.bls + 1);
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final int SS() {
        return Td();
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void close() {
        super.close();
        this.bkI = null;
        this.bkJ = null;
    }

    private j(String str, boolean z, k kVar, e eVar, Inflater inflater, byte[] bArr) {
        super(str, z, (eVar != null ? eVar.Tb() : kVar.bkW) + 1, kVar.bkW + 1, null, null);
        this.bkM = new int[5];
        this.bkK = kVar;
        this.bjO = eVar;
        this.bkL = new p(kVar, eVar);
    }
}
