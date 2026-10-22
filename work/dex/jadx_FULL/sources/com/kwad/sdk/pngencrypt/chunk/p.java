package com.kwad.sdk.pngencrypt.chunk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class p extends PngChunk {
    public p(String str, com.kwad.sdk.pngencrypt.k kVar) {
        super(str, kVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        String str = this.id;
        if (str == null) {
            if (pVar.id != null) {
                return false;
            }
        } else if (!str.equals(pVar.id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.id;
        return (str == null ? 0 : str.hashCode()) + 31;
    }
}
