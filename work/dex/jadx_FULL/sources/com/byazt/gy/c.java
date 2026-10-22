package com.byazt.gy;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2085, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28593a;
    public int[] i;
    public a sl;
    public boolean sp;
    public tt x;
    public boolean da = false;
    public final ve t = new ve();
    public int c = 0;
    public int tt = 1;
    public int ve = 2;
    public int uj = 3;
    public int n = 4;

    public c() {
        uj();
    }

    private int n(int i) {
        if (this.f28593a != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.i.length) {
            return i2;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
    }

    public void c(InputStream inputStream) {
        c();
        if (inputStream != null) {
            this.x = new tt(inputStream);
        }
    }

    public int tt() throws IOException {
        try {
            if (this.x == null) {
                throw new IOException("Parser is not opened.");
            }
            n();
            return this.f28593a;
        } catch (IOException e) {
            c();
            throw e;
        }
    }

    public String uj(int i) {
        int iN = n(i);
        int[] iArr = this.i;
        if (iArr[iN + 3] != 3) {
            return "";
        }
        return this.sl.c(iArr[iN + 2]);
    }

    public int ve() {
        if (this.f28593a != 2) {
            return -1;
        }
        return this.i.length / 5;
    }

    public int ve(int i) {
        return this.i[n(i) + 4];
    }

    public void c() {
        if (this.da) {
            this.da = false;
            this.x.c();
            this.sl = null;
            this.x = null;
            this.t.c();
            uj();
        }
    }

    private void n() throws IOException {
        if (this.sl == null) {
            this.x.tt(524291);
            this.x.ve();
            this.sl = a.c(this.x);
            this.t.n();
            this.da = true;
        }
        int i = this.f28593a;
        if (i == this.tt) {
            return;
        }
        uj();
        while (true) {
            if (this.sp) {
                this.sp = false;
                this.t.a();
            }
            if (i == this.uj && this.t.uj() == 1 && this.t.tt() == 0) {
                this.f28593a = this.tt;
                return;
            }
            int iTt = i == this.c ? 1048834 : this.x.tt();
            if (iTt == 524672) {
                int iTt2 = this.x.tt();
                if (iTt2 >= 8 && iTt2 % 4 == 0) {
                    this.x.c((iTt2 / 4) - 2);
                } else {
                    throw new IOException("Invalid resource ids size (" + iTt2 + ").");
                }
            } else {
                if (iTt < 1048832 || iTt > 1048836) {
                    throw new IOException("Invalid chunk type (" + iTt + ").");
                }
                if (iTt == 1048834 && i == -1) {
                    this.f28593a = this.c;
                    return;
                }
                this.x.ve();
                this.x.tt();
                this.x.ve();
                if (iTt == 1048832 || iTt == 1048833) {
                    if (iTt == 1048832) {
                        this.t.c(this.x.tt(), this.x.tt());
                    } else {
                        this.x.ve();
                        this.x.ve();
                        this.t.ve();
                    }
                } else if (iTt == 1048834) {
                    this.x.tt();
                    this.x.tt();
                    this.x.ve();
                    int iTt3 = this.x.tt() & 65535;
                    this.x.tt();
                    this.i = this.x.c(iTt3 * 5);
                    int i2 = 3;
                    while (true) {
                        int[] iArr = this.i;
                        if (i2 < iArr.length) {
                            iArr[i2] = iArr[i2] >>> 24;
                            i2 += 5;
                        } else {
                            this.t.n();
                            this.f28593a = this.ve;
                            return;
                        }
                    }
                } else {
                    if (iTt == 1048835) {
                        this.x.tt();
                        this.x.tt();
                        this.f28593a = this.uj;
                        this.sp = true;
                        return;
                    }
                    if (iTt == 1048836) {
                        this.x.tt();
                        this.x.ve();
                        this.x.ve();
                        this.f28593a = this.n;
                        return;
                    }
                }
            }
        }
    }

    private void uj() {
        this.i = null;
        this.f28593a = -1;
    }

    public int tt(int i) {
        return this.i[n(i) + 3];
    }

    public String c(int i) {
        int i2 = this.i[n(i) + 1];
        return i2 == -1 ? "" : this.sl.c(i2);
    }
}
