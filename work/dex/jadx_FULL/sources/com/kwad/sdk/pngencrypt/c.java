package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.ChunkLoadBehaviour;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends b {
    protected k bjM;
    protected k bjN;
    protected e bjO;
    protected int bjP = -1;
    protected com.kwad.sdk.pngencrypt.chunk.e bjQ = null;
    private long bjS = 0;
    private boolean bjT = true;
    private boolean bjU = false;
    private Set<String> bjV = new HashSet();
    private long bjW = 0;
    private long bjX = 0;
    private long bjY = 0;
    private ChunkLoadBehaviour bka = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;
    protected final boolean bjR = false;
    private g bjZ = new com.kwad.sdk.pngencrypt.chunk.a();

    /* JADX INFO: renamed from: com.kwad.sdk.pngencrypt.c$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] bkb;

        static {
            int[] iArr = new int[ChunkLoadBehaviour.values().length];
            bkb = iArr;
            try {
                iArr[ChunkLoadBehaviour.LOAD_CHUNK_IF_SAFE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                bkb[ChunkLoadBehaviour.LOAD_CHUNK_NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(boolean z) {
    }

    private int SK() {
        return this.bjP;
    }

    private k SP() {
        return this.bjN;
    }

    private void hm(String str) {
        if (str.equals("IHDR")) {
            if (this.bjP < 0) {
                this.bjP = 0;
                return;
            }
            new PngjException("unexpected chunk " + str);
            return;
        }
        if (str.equals("PLTE")) {
            int i = this.bjP;
            if (i == 0 || i == 1) {
                this.bjP = 2;
                return;
            }
            new PngjException("unexpected chunk here " + str);
            return;
        }
        if (str.equals("IDAT")) {
            int i2 = this.bjP;
            if (i2 >= 0 && i2 <= 4) {
                this.bjP = 4;
                return;
            }
            new PngjException("unexpected chunk " + str);
            return;
        }
        if (str.equals("IEND")) {
            if (this.bjP >= 4) {
                this.bjP = 6;
                return;
            }
            new PngjException("unexpected chunk " + str);
            return;
        }
        int i3 = this.bjP;
        if (i3 <= 1) {
            this.bjP = 1;
        } else if (i3 <= 3) {
            this.bjP = 3;
        } else {
            this.bjP = 5;
        }
    }

    private static boolean hn(String str) {
        return !com.kwad.sdk.pngencrypt.chunk.b.hq(str);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean D(int i, String str) {
        if (super.D(i, str)) {
            return true;
        }
        if (this.bjW > 0 && ((long) i) + SG() > this.bjW) {
            new PngjException("Maximum total bytes to read exceeeded: " + this.bjW + " offset:" + SG() + " len=" + i);
        }
        if (this.bjV.contains(str)) {
            return true;
        }
        if (com.kwad.sdk.pngencrypt.chunk.b.hq(str)) {
            return false;
        }
        long j = this.bjX;
        if (j > 0 && i > j) {
            return true;
        }
        long j2 = this.bjY;
        if (j2 > 0 && i > j2 - this.bjS) {
            return true;
        }
        int i2 = AnonymousClass1.bkb[this.bka.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return true;
            }
        } else if (!com.kwad.sdk.pngencrypt.chunk.b.hs(str)) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean SF() {
        return this.bjT;
    }

    public final boolean SL() {
        return SK() < 4;
    }

    public final j SM() {
        DeflatedChunksSet deflatedChunksSetSH = SH();
        if (deflatedChunksSetSH instanceof j) {
            return (j) deflatedChunksSetSH;
        }
        return null;
    }

    public final k SN() {
        return this.bjM;
    }

    public final e SO() {
        return this.bjO;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final void a(ChunkReader chunkReader) {
        super.a(chunkReader);
        if (chunkReader.SD().id.equals("IHDR")) {
            com.kwad.sdk.pngencrypt.chunk.i iVar = new com.kwad.sdk.pngencrypt.chunk.i(null);
            iVar.a(chunkReader.SD());
            k kVarTx = iVar.Tx();
            this.bjM = kVarTx;
            this.bjN = kVarTx;
            if (iVar.Tv()) {
                this.bjO = new e(this.bjN);
            }
            this.bjQ = new com.kwad.sdk.pngencrypt.chunk.e(this.bjM);
        }
        ChunkReader.ChunkReaderMode chunkReaderMode = chunkReader.bjt;
        ChunkReader.ChunkReaderMode chunkReaderMode2 = ChunkReader.ChunkReaderMode.BUFFER;
        if (chunkReaderMode == chunkReaderMode2 && hn(chunkReader.SD().id)) {
            this.bjS += (long) chunkReader.SD().len;
        }
        if (chunkReader.bjt == chunkReaderMode2 || this.bjU) {
            try {
                this.bjQ.a(this.bjZ.a(chunkReader.SD(), SN()), this.bjP);
            } catch (PngjException e) {
                throw e;
            }
        }
    }

    public final void aW(long j) {
        this.bjW = j;
    }

    public final void aX(long j) {
        this.bjX = j;
    }

    public final void aY(long j) {
        this.bjY = j;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final void c(int i, String str, long j) {
        hm(str);
        super.c(i, str, j);
    }

    public final void cj(boolean z) {
        this.bjT = false;
    }

    @Override // com.kwad.sdk.pngencrypt.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.bjP != 6) {
            this.bjP = 6;
        }
        super.close();
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final DeflatedChunksSet hk(String str) {
        return new j(str, this.bjR, SP(), this.bjO);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean hl(String str) {
        return str.equals("IDAT");
    }

    @Override // com.kwad.sdk.pngencrypt.b, com.kwad.sdk.pngencrypt.f
    public final int a(byte[] bArr, int i, int i2) {
        return super.a(bArr, i, i2);
    }
}
