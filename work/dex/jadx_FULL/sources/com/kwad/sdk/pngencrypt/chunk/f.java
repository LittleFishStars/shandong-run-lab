package com.kwad.sdk.pngencrypt.chunk;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f extends e {
    private final List<PngChunk> blJ;

    @Override // com.kwad.sdk.pngencrypt.chunk.e
    public final String toString() {
        return "ChunkList: written: " + Tq().size() + " queue: " + this.blJ.size();
    }
}
