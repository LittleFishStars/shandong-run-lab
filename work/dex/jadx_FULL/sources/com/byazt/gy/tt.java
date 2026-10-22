package com.byazt.gy;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2085, 13})
public class tt {
    public InputStream c;
    public int tt;

    public tt(InputStream inputStream) {
        c(inputStream);
    }

    public final void c(InputStream inputStream) {
        this.c = inputStream;
        this.tt = 0;
    }

    public final int tt() throws IOException {
        int i = 0;
        for (int i2 = 0; i2 != 32; i2 += 8) {
            int i3 = this.c.read();
            if (i3 == -1) {
                throw new EOFException();
            }
            this.tt++;
            i |= i3 << i2;
        }
        return i;
    }

    public final void ve() throws IOException {
        long jSkip = this.c.skip(4L);
        this.tt = (int) (((long) this.tt) + jSkip);
        if (jSkip != 4) {
            throw new EOFException();
        }
    }

    public final void c() {
        InputStream inputStream = this.c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            c((InputStream) null);
        }
    }

    public void tt(int i) throws IOException {
        int iTt = tt();
        if (iTt != i) {
            throw new IOException(String.format("Expected: 0x%08x got: 0x%08x", Integer.valueOf(i), Integer.valueOf(iTt)));
        }
    }

    public final int[] c(int i) throws IOException {
        int[] iArr = new int[i];
        int i2 = 0;
        while (i > 0) {
            iArr[i2] = tt();
            i--;
            i2++;
        }
        return iArr;
    }
}
