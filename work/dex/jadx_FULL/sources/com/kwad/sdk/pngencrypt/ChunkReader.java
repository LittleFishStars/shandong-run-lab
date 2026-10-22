package com.kwad.sdk.pngencrypt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class ChunkReader implements f {
    public final ChunkReaderMode bjt;
    private final com.kwad.sdk.pngencrypt.chunk.d bju;
    private boolean bjx;
    protected int bjv = 0;
    private int bjw = 0;
    protected ErrorBehaviour bjy = ErrorBehaviour.STRICT;

    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    public ChunkReader(int i, String str, long j, ChunkReaderMode chunkReaderMode) {
        if (chunkReaderMode == null || str.length() != 4 || i < 0) {
            new PngjException("Bad chunk paramenters: " + chunkReaderMode);
        }
        this.bjt = chunkReaderMode;
        com.kwad.sdk.pngencrypt.chunk.d dVar = new com.kwad.sdk.pngencrypt.chunk.d(i, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.bju = dVar;
        dVar.aZ(j);
        this.bjx = chunkReaderMode != ChunkReaderMode.SKIP;
    }

    public final com.kwad.sdk.pngencrypt.chunk.d SD() {
        return this.bju;
    }

    public abstract void SE();

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.kwad.sdk.pngencrypt.f
    public final int a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            new PngjException("negative length??");
        }
        if (this.bjv == 0 && this.bjw == 0 && this.bjx) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.bju;
            dVar.e(dVar.blB, 0, 4);
        }
        com.kwad.sdk.pngencrypt.chunk.d dVar2 = this.bju;
        int i4 = dVar2.len - this.bjv;
        if (i4 > i2) {
            i4 = i2;
        }
        if (i4 > 0 || this.bjw == 0) {
            if (this.bjx && this.bjt != ChunkReaderMode.BUFFER && i4 > 0) {
                dVar2.e(bArr, i, i4);
            }
            ChunkReaderMode chunkReaderMode = this.bjt;
            if (chunkReaderMode == ChunkReaderMode.BUFFER) {
                byte[] bArr2 = this.bju.data;
                if (bArr2 != bArr && i4 > 0) {
                    System.arraycopy(bArr, i, bArr2, this.bjv, i4);
                }
            } else if (chunkReaderMode == ChunkReaderMode.PROCESS) {
                a(this.bjv, bArr, i, i4);
            }
            this.bjv += i4;
            i += i4;
            i2 -= i4;
        }
        int i5 = this.bjv;
        com.kwad.sdk.pngencrypt.chunk.d dVar3 = this.bju;
        if (i5 == dVar3.len) {
            int i6 = this.bjw;
            int i7 = 4 - i6;
            if (i7 <= i2) {
                i2 = i7;
            }
            if (i2 > 0) {
                byte[] bArr3 = dVar3.blD;
                if (bArr != bArr3) {
                    System.arraycopy(bArr, i, bArr3, i6, i2);
                }
                int i8 = this.bjw + i2;
                this.bjw = i8;
                if (i8 == 4) {
                    if (this.bjx) {
                        if (this.bjt == ChunkReaderMode.BUFFER) {
                            com.kwad.sdk.pngencrypt.chunk.d dVar4 = this.bju;
                            dVar4.e(dVar4.data, 0, dVar4.len);
                        }
                        this.bju.ck(this.bjy == ErrorBehaviour.STRICT);
                    }
                    SE();
                }
            }
            i3 = i2;
        }
        if (i4 > 0 || i3 > 0) {
            return i4 + i3;
        }
        return -1;
    }

    public abstract void a(int i, byte[] bArr, int i2, int i3);

    public final void ci(boolean z) {
        this.bjx = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChunkReader chunkReader = (ChunkReader) obj;
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.bju;
        if (dVar == null) {
            if (chunkReader.bju != null) {
                return false;
            }
        } else if (!dVar.equals(chunkReader.bju)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.bju;
        return (dVar == null ? 0 : dVar.hashCode()) + 31;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.bjw == 4;
    }

    public String toString() {
        return this.bju.toString();
    }
}
