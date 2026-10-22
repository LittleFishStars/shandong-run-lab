package com.kwad.sdk.pngencrypt;

import java.io.Closeable;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class b implements f, Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final int bjA;
    private byte[] bjB;
    private int bjC;
    protected boolean bjD;
    protected boolean bjE;
    private int bjF;
    private long bjG;
    private DeflatedChunksSet bjH;
    private ChunkReader bjI;
    private long bjJ;
    private ErrorBehaviour bjK;
    private final byte[] bjz;
    protected boolean closed;

    public b() {
        this(n.Tg());
    }

    private static String SI() {
        return "IHDR";
    }

    private static String SJ() {
        return "IEND";
    }

    private static void l(byte[] bArr) {
        if (Arrays.equals(bArr, n.Tg())) {
            return;
        }
        new PngjException("Bad signature:" + Arrays.toString(bArr));
    }

    public boolean D(int i, String str) {
        return false;
    }

    public boolean SF() {
        return true;
    }

    public final long SG() {
        return this.bjG;
    }

    public final DeflatedChunksSet SH() {
        return this.bjH;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public int a(byte[] bArr, int i, int i2) {
        if (this.closed) {
            return -1;
        }
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            new PngjException("This should not happen. Bad length: " + i2);
        }
        if (!this.bjD) {
            int i3 = this.bjA;
            int i4 = this.bjC;
            int i5 = i3 - i4;
            if (i5 <= i2) {
                i2 = i5;
            }
            System.arraycopy(bArr, i, this.bjB, i4, i2);
            int i6 = this.bjC + i2;
            this.bjC = i6;
            if (i6 == this.bjA) {
                l(this.bjB);
                this.bjC = 0;
                this.bjD = true;
            }
            int i7 = i2 + 0;
            this.bjG += (long) i2;
            return i7;
        }
        ChunkReader chunkReader = this.bjI;
        if (chunkReader != null && !chunkReader.isDone()) {
            int iA = this.bjI.a(bArr, i, i2);
            if (iA < 0) {
                return -1;
            }
            int i8 = iA + 0;
            this.bjG += (long) iA;
            return i8;
        }
        int i9 = this.bjC;
        int i10 = 8 - i9;
        if (i10 <= i2) {
            i2 = i10;
        }
        System.arraycopy(bArr, i, this.bjB, i9, i2);
        int i11 = this.bjC + i2;
        this.bjC = i11;
        int i12 = i2 + 0;
        this.bjG += (long) i2;
        if (i11 != 8) {
            return i12;
        }
        this.bjF++;
        c(n.g(this.bjB, 0), com.kwad.sdk.pngencrypt.chunk.b.i(this.bjB, 4), this.bjG - 8);
        this.bjC = 0;
        return i12;
    }

    public void c(int i, String str, long j) {
        if (str.length() != 4 || !com.kwad.sdk.pngencrypt.chunk.b.blA.matcher(str).matches()) {
            new PngjException("Bad chunk id: " + str);
        }
        if (i < 0) {
            new PngjException("Bad chunk len: " + i);
        }
        if (str.equals("IDAT")) {
            this.bjJ += (long) i;
        }
        boolean zSF = SF();
        boolean zD = D(i, str);
        boolean zHl = hl(str);
        DeflatedChunksSet deflatedChunksSet = this.bjH;
        boolean zHo = (deflatedChunksSet == null || deflatedChunksSet.isClosed()) ? false : this.bjH.ho(str);
        if (!zHl || zD) {
            this.bjI = a(str, i, j, zD);
        } else {
            if (!zHo) {
                DeflatedChunksSet deflatedChunksSet2 = this.bjH;
                if (deflatedChunksSet2 != null && !deflatedChunksSet2.isDone()) {
                    new PngjException("new IDAT-like chunk when previous was not done");
                }
                this.bjH = hk(str);
            }
            this.bjI = new d(i, str, zSF, j, this.bjH) { // from class: com.kwad.sdk.pngencrypt.b.1
                @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
                public final void SE() {
                    super.SE();
                    b.this.a(this);
                }
            };
        }
        ChunkReader chunkReader = this.bjI;
        if (chunkReader == null || zSF) {
            return;
        }
        chunkReader.ci(false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DeflatedChunksSet deflatedChunksSet = this.bjH;
        if (deflatedChunksSet != null) {
            deflatedChunksSet.close();
        }
        this.closed = true;
    }

    public abstract DeflatedChunksSet hk(String str);

    public boolean hl(String str) {
        return false;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.bjE;
    }

    private b(byte[] bArr) {
        this.bjB = new byte[8];
        this.bjC = 0;
        this.bjD = false;
        this.bjE = false;
        this.closed = false;
        this.bjF = 0;
        this.bjG = 0L;
        this.bjK = ErrorBehaviour.STRICT;
        this.bjz = bArr;
        int length = bArr == null ? 0 : bArr.length;
        this.bjA = length;
        this.bjD = length <= 0;
    }

    private ChunkReader a(String str, int i, long j, boolean z) {
        return new ChunkReader(i, str, j, z ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: com.kwad.sdk.pngencrypt.b.2
            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            public final void SE() {
                b.this.a(this);
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            public final void a(int i2, byte[] bArr, int i3, int i4) {
                new PngjException("should never happen");
            }
        };
    }

    public void a(ChunkReader chunkReader) {
        if (this.bjF == 1 && !SI().equals(chunkReader.SD().id)) {
            String str = "Bad first chunk: " + chunkReader.SD().id + " expected: " + SI();
            if (this.bjK.c < ErrorBehaviour.SUPER_LENIENT.c) {
                new PngjException(str);
            }
        }
        SJ();
        if (chunkReader.SD().id.equals(SJ())) {
            this.bjE = true;
            close();
        }
    }
}
