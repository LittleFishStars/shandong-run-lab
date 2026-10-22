package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class i extends p {
    private int bkv;
    private int bkw;
    private int blQ;
    private int blR;
    private int blS;
    private int blT;
    private int blU;

    public i(com.kwad.sdk.pngencrypt.k kVar) {
        super("IHDR", kVar);
        if (kVar != null) {
            Tw();
        }
    }

    private int SY() {
        return this.bkv;
    }

    private int SZ() {
        return this.bkw;
    }

    private int Ts() {
        return this.blQ;
    }

    private int Tt() {
        return this.blR;
    }

    private int Tu() {
        return this.blU;
    }

    private void Tw() {
        fv(this.bkK.bkw);
        fw(this.bkK.bkv);
        fx(this.bkK.bkO);
        com.kwad.sdk.pngencrypt.k kVar = this.bkK;
        int i = kVar.bkQ ? 4 : 0;
        if (kVar.bkS) {
            i++;
        }
        if (!kVar.bkR) {
            i += 2;
        }
        fy(i);
        fz(0);
        fA(0);
        fB(0);
    }

    private void Ty() {
        if (this.bkw <= 0 || this.bkv <= 0 || this.blS != 0 || this.blT != 0) {
            throw new PngjException("bad IHDR: col/row/compmethod/filmethod invalid");
        }
        int i = this.blQ;
        if (i != 1 && i != 2 && i != 4 && i != 8 && i != 16) {
            throw new PngjException("bad IHDR: bitdepth invalid");
        }
        int i2 = this.blU;
        if (i2 < 0 || i2 > 1) {
            throw new PngjException("bad IHDR: interlace invalid");
        }
        int i3 = this.blR;
        if (i3 != 0) {
            if (i3 != 6 && i3 != 2) {
                if (i3 == 3) {
                    if (i == 16) {
                        throw new PngjException("bad IHDR: bitdepth invalid");
                    }
                    return;
                } else if (i3 != 4) {
                    throw new PngjException("bad IHDR: invalid colormodel");
                }
            }
            if (i != 8 && i != 16) {
                throw new PngjException("bad IHDR: bitdepth invalid");
            }
        }
    }

    private void fA(int i) {
        this.blT = 0;
    }

    private void fB(int i) {
        this.blU = 0;
    }

    private void fv(int i) {
        this.bkw = i;
    }

    private void fw(int i) {
        this.bkv = i;
    }

    private void fx(int i) {
        this.blQ = i;
    }

    private void fy(int i) {
        this.blR = i;
    }

    private void fz(int i) {
        this.blS = 0;
    }

    public final boolean Tv() {
        return Tu() == 1;
    }

    public final com.kwad.sdk.pngencrypt.k Tx() {
        Ty();
        return new com.kwad.sdk.pngencrypt.k(SZ(), SY(), Ts(), (Tt() & 4) != 0, Tt() == 0 || Tt() == 4, (Tt() & 1) != 0);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 13) {
            throw new PngjException("Bad IDHR len " + dVar.len);
        }
        ByteArrayInputStream byteArrayInputStreamTo = dVar.To();
        this.bkw = com.kwad.sdk.pngencrypt.n.f(byteArrayInputStreamTo);
        this.bkv = com.kwad.sdk.pngencrypt.n.f(byteArrayInputStreamTo);
        this.blQ = com.kwad.sdk.pngencrypt.n.e(byteArrayInputStreamTo);
        this.blR = com.kwad.sdk.pngencrypt.n.e(byteArrayInputStreamTo);
        this.blS = com.kwad.sdk.pngencrypt.n.e(byteArrayInputStreamTo);
        this.blT = com.kwad.sdk.pngencrypt.n.e(byteArrayInputStreamTo);
        this.blU = com.kwad.sdk.pngencrypt.n.e(byteArrayInputStreamTo);
    }
}
