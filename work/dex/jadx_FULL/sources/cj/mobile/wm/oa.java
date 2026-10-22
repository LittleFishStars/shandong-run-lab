package cj.mobile.wm;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class oa {
    public final int dexa;
    public final List<aa> dexb;
    public final int dexc;
    public final InputStream dexd;
    public final byte[] dexe;

    public oa(int i, List<aa> list) {
        this(i, list, -1, null);
    }

    public oa(int i, List<aa> list, int i2, InputStream inputStream) {
        this.dexa = i;
        this.dexb = list;
        this.dexc = i2;
        this.dexd = inputStream;
        this.dexe = null;
    }

    public final InputStream dexa() {
        InputStream inputStream = this.dexd;
        if (inputStream != null) {
            return inputStream;
        }
        byte[] bArr = this.dexe;
        if (bArr != null) {
            return new ByteArrayInputStream(bArr);
        }
        return null;
    }

    public final int dexb() {
        return this.dexc;
    }

    public final List<aa> dexc() {
        return Collections.unmodifiableList(this.dexb);
    }

    public final int dexd() {
        return this.dexa;
    }
}
