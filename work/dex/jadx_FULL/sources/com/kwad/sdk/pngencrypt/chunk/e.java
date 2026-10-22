package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class e {
    final com.kwad.sdk.pngencrypt.k bjM;
    List<PngChunk> blF = new ArrayList();
    boolean blG = false;

    public e(com.kwad.sdk.pngencrypt.k kVar) {
        this.bjM = kVar;
    }

    private static List<PngChunk> a(List<PngChunk> list, final String str, final String str2) {
        return str2 == null ? b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.1
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                return pngChunk.id.equals(str);
            }
        }) : b.a(list, new c() { // from class: com.kwad.sdk.pngencrypt.chunk.e.2
            @Override // com.kwad.sdk.pngencrypt.chunk.c
            public final boolean a(PngChunk pngChunk) {
                if (!pngChunk.id.equals(str)) {
                    return false;
                }
                if (!(pngChunk instanceof t) || ((t) pngChunk).getKey().equals(str2)) {
                    return !(pngChunk instanceof n) || ((n) pngChunk).Tz().equals(str2);
                }
                return false;
            }
        });
    }

    public final List<PngChunk> Tq() {
        return this.blF;
    }

    public final List<? extends PngChunk> ap(String str, String str2) {
        return a(this.blF, str, str2);
    }

    public String toString() {
        return "ChunkList: read: " + this.blF.size();
    }

    public final void a(PngChunk pngChunk, int i) {
        pngChunk.fu(i);
        this.blF.add(pngChunk);
        if (pngChunk.id.equals("PLTE")) {
            this.blG = true;
        }
    }
}
