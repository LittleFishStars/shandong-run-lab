package com.byazt.vnu;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SIGNATRUE_UNKNOWN, 13})
public class tt {
    public sp da;
    public final byte[] i;
    public int[] m;
    public int nu;
    public int[] t;
    public final x x;
    public boolean yp;
    public int z;
    public HashMap<Integer, Integer> c = new HashMap<>();
    public boolean tt = false;
    public boolean sl = false;
    public final c u = new c();
    public int ve = 0;
    public int uj = 1;
    public int n = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f29139a = 3;
    public int sp = 4;

    public tt(byte[] bArr, x xVar) {
        this.x = xVar;
        this.i = bArr;
        uj();
    }

    private void n() throws IOException {
        int[] iArr;
        if (!this.sl) {
            this.da.c(524291, 524289);
            this.da.c();
            t.c(this.da);
            this.u.n();
            this.sl = true;
        }
        int i = this.z;
        if (i == this.uj) {
            return;
        }
        uj();
        while (true) {
            int i2 = 0;
            if (this.yp) {
                this.yp = false;
                this.u.a();
            }
            if (i == this.f29139a && this.u.uj() == 1 && this.u.tt() == 0) {
                this.z = this.uj;
                return;
            }
            int i3 = i == this.ve ? 1048834 : this.da.readInt();
            if (i3 == 524672) {
                this.c.clear();
                int i4 = this.da.readInt();
                if (i4 < 8 || i4 % 4 != 0) {
                    throw new IOException("Invalid resource ids size (" + i4 + ").");
                }
                int iC = sl.c(this.da);
                this.t = this.da.c((i4 / 4) - 2);
                ArrayList arrayList = new ArrayList();
                while (true) {
                    int[] iArr2 = this.t;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    int iC2 = sl.c(this.i, iArr2[i2], (i2 * 4) + iC, this.x);
                    if (iC2 >= 2130706432) {
                        this.c.put(Integer.valueOf(i2), Integer.valueOf(iC2));
                        arrayList.add(Integer.valueOf(iC2));
                    }
                    i2++;
                }
                ArrayList arrayList2 = new ArrayList(arrayList);
                Collections.sort(arrayList2);
                if (!arrayList.equals(arrayList2)) {
                    this.tt = true;
                }
            } else {
                if (i3 < 1048832 || i3 > 1048836) {
                    throw new IOException("Invalid chunk type (" + i3 + ").");
                }
                if (i3 == 1048834 && i == -1) {
                    this.z = this.ve;
                    return;
                }
                this.da.c();
                this.da.readInt();
                this.da.c();
                if (i3 == 1048832 || i3 == 1048833) {
                    if (i3 == 1048832) {
                        this.u.c(this.da.readInt(), this.da.readInt());
                    } else {
                        this.da.c();
                        this.da.c();
                        this.u.ve();
                    }
                } else {
                    if (i3 == 1048834) {
                        this.da.readInt();
                        this.da.readInt();
                        this.da.c();
                        int i5 = this.da.readInt() & 65535;
                        this.nu = (65535 & this.da.readInt()) - 1;
                        int iC3 = sl.c(this.da);
                        int i6 = i5 * 5;
                        this.m = this.da.c(i6);
                        int i7 = 3;
                        while (true) {
                            iArr = this.m;
                            if (i7 >= iArr.length) {
                                break;
                            }
                            iArr[i7] = iArr[i7] >>> 24;
                            i7 += 5;
                        }
                        if (iArr.length != i6) {
                            throw new RuntimeException();
                        }
                        boolean z = false;
                        while (i2 < i5) {
                            int i8 = i2 * 5;
                            if (this.c.containsKey(Integer.valueOf(this.m[i8 + 1]))) {
                                z = true;
                            }
                            int[] iArr3 = this.m;
                            int i9 = iArr3[i8 + 3];
                            if (i9 == 1 || i9 == 2) {
                                int i10 = i8 + 4;
                                sl.c(this.i, iArr3[i10], (i10 * 4) + iC3, this.x);
                            }
                            i2++;
                        }
                        if (z && this.tt) {
                            sl.c(iC3, this.i, this.m, i5, this.c);
                        }
                        this.u.n();
                        this.z = this.n;
                        return;
                    }
                    if (i3 == 1048835) {
                        this.da.readInt();
                        this.da.readInt();
                        this.z = this.f29139a;
                        this.yp = true;
                        return;
                    }
                    if (i3 == 1048836) {
                        this.da.readInt();
                        this.da.c();
                        this.da.c();
                        this.z = this.sp;
                        return;
                    }
                }
            }
        }
    }

    private void uj() {
        this.z = -1;
        this.m = null;
        this.nu = -1;
    }

    public void c(InputStream inputStream) {
        c();
        if (inputStream != null) {
            this.da = new sp(new i(new n(inputStream)));
        }
    }

    public int tt() throws IOException {
        if (this.da == null) {
            throw new RuntimeException("Parser is not opened.");
        }
        try {
            n();
            return this.z;
        } catch (IOException e) {
            c();
            throw e;
        }
    }

    public int ve() throws IOException {
        return tt();
    }

    @com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SIGNATRUE_UNKNOWN, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static final class c {
        public int[] c = new int[32];
        public int tt;
        public int ve;

        public void a() {
            int i = this.tt;
            if (i == 0) {
                return;
            }
            int i2 = i - 1;
            int i3 = this.c[i2] * 2;
            if ((i2 - 1) - i3 == 0) {
                return;
            }
            this.tt = i - (i3 + 2);
            this.ve--;
        }

        public void c() {
            this.tt = 0;
            this.ve = 0;
        }

        public void n() {
            c(2);
            int i = this.tt;
            int[] iArr = this.c;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.tt = i + 2;
            this.ve++;
        }

        public int tt() {
            int i = this.tt;
            if (i == 0) {
                return 0;
            }
            return this.c[i - 1];
        }

        public int uj() {
            return this.ve;
        }

        public boolean ve() {
            int i;
            int[] iArr;
            int i2;
            int i3 = this.tt;
            if (i3 == 0 || (i2 = (iArr = this.c)[(i = i3 - 1)]) == 0) {
                return false;
            }
            int i4 = i2 - 1;
            int i5 = i - 2;
            iArr[i5] = i4;
            iArr[i5 - ((i4 * 2) + 1)] = i4;
            this.tt = i3 - 2;
            return true;
        }

        public void c(int i, int i2) {
            if (this.ve == 0) {
                n();
            }
            c(2);
            int i3 = this.tt;
            int i4 = i3 - 1;
            int[] iArr = this.c;
            int i5 = iArr[i4];
            int i6 = (i4 - 1) - (i5 * 2);
            int i7 = i5 + 1;
            iArr[i6] = i7;
            iArr[i4] = i;
            iArr[i4 + 1] = i2;
            iArr[i4 + 2] = i7;
            this.tt = i3 + 2;
        }

        private void c(int i) {
            int[] iArr = this.c;
            int length = iArr.length;
            int i2 = this.tt;
            int i3 = length - i2;
            if (i3 > i) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i3) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.c = iArr2;
        }
    }

    public void c() {
        if (this.sl) {
            this.sl = false;
            this.da = null;
            this.t = null;
            this.u.c();
            uj();
        }
    }

    public void tt(InputStream inputStream) {
        c(inputStream);
    }
}
