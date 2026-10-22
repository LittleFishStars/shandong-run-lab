package com.kwad.sdk.pngencrypt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class d extends ChunkReader {
    protected final DeflatedChunksSet bkc;
    protected boolean bkd;
    protected boolean bke;
    protected byte[] bkf;
    protected int bkg;

    public d(int i, String str, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.bkd = false;
        this.bke = false;
        this.bkg = -1;
        this.bkc = deflatedChunksSet;
        deflatedChunksSet.a(this);
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void SE() {
        int iG;
        if (!this.bke || this.bkg < 0 || (iG = n.g(this.bkf, 0)) == this.bkg) {
            return;
        }
        new PngjException("bad chunk sequence for fDAT chunk " + iG + " expected " + this.bkg);
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public final void a(int i, byte[] bArr, int i2, int i3) {
        if (this.bke && i < 4) {
            while (i < 4 && i3 > 0) {
                this.bkf[i] = bArr[i2];
                i++;
                i2++;
                i3--;
            }
        }
        if (i3 > 0) {
            this.bkc.b(bArr, i2, i3);
            if (this.bkd) {
                System.arraycopy(bArr, i2, SD().data, this.bjv, i3);
            }
        }
    }

    public final void fj(int i) {
        this.bkg = i;
    }
}
