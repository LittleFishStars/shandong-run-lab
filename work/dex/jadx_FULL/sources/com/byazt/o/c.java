package com.byazt.o;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME, 20})
public class c implements i {
    public int da;
    public int i;
    public int[] n;
    public int sl;
    public boolean sp;
    public int[] t;
    public uj tt;
    public int u;
    public a uj;
    public int x;
    public int yp;
    public int z;
    public boolean ve = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0485c f28862a = new C0485c();

    public c() {
        sp();
    }

    private final void sp() {
        this.x = -1;
        this.i = -1;
        this.da = -1;
        this.sl = -1;
        this.t = null;
        this.u = -1;
        this.yp = -1;
        this.z = -1;
    }

    private final void x() throws IOException {
        if (this.uj == null) {
            tt.c(this.tt, 524291);
            this.tt.ve();
            this.uj = a.c(this.tt);
            this.f28862a.n();
            this.ve = true;
        }
        int i = this.x;
        if (i == 1) {
            return;
        }
        sp();
        while (true) {
            if (this.sp) {
                this.sp = false;
                this.f28862a.a();
            }
            int i2 = 3;
            if (i == 3 && this.f28862a.uj() == 1 && this.f28862a.tt() == 0) {
                this.x = 1;
                return;
            }
            int iTt = i == 0 ? 1048834 : this.tt.tt();
            if (iTt == 524672) {
                int iTt2 = this.tt.tt();
                if (iTt2 < 8 || iTt2 % 4 != 0) {
                    throw new IOException("Invalid resource ids size (" + iTt2 + ").");
                }
                this.n = this.tt.tt((iTt2 / 4) - 2);
            } else {
                if (iTt < 1048832 || iTt > 1048836) {
                    throw new IOException("Invalid chunk type (" + iTt + ").");
                }
                if (iTt == 1048834 && i == -1) {
                    this.x = 0;
                    return;
                }
                this.tt.ve();
                int iTt3 = this.tt.tt();
                this.tt.ve();
                if (iTt != 1048832 && iTt != 1048833) {
                    this.i = iTt3;
                    if (iTt == 1048834) {
                        this.sl = this.tt.tt();
                        this.da = this.tt.tt();
                        this.tt.ve();
                        int iTt4 = this.tt.tt();
                        this.u = (iTt4 >>> 16) - 1;
                        int iTt5 = this.tt.tt();
                        this.z = (iTt5 >>> 16) - 1;
                        this.yp = (65535 & iTt5) - 1;
                        this.t = this.tt.tt((iTt4 & 65535) * 5);
                        while (true) {
                            int[] iArr = this.t;
                            if (i2 >= iArr.length) {
                                this.f28862a.n();
                                this.x = 2;
                                return;
                            } else {
                                iArr[i2] = iArr[i2] >>> 24;
                                i2 += 5;
                            }
                        }
                    } else {
                        if (iTt == 1048835) {
                            this.sl = this.tt.tt();
                            this.da = this.tt.tt();
                            this.x = 3;
                            this.sp = true;
                            return;
                        }
                        if (iTt == 1048836) {
                            this.da = this.tt.tt();
                            this.tt.ve();
                            this.tt.ve();
                            this.x = 4;
                            return;
                        }
                    }
                } else if (iTt == 1048832) {
                    this.f28862a.c(this.tt.tt(), this.tt.tt());
                } else {
                    this.tt.ve();
                    this.tt.ve();
                    this.f28862a.ve();
                }
            }
        }
    }

    @Override // com.byazt.o.sp
    public int a() {
        return -1;
    }

    public void c(InputStream inputStream) {
        c();
        if (inputStream != null) {
            this.tt = new uj(inputStream, false);
        }
    }

    public int n() {
        if (this.x != 2) {
            return -1;
        }
        return this.t.length / 5;
    }

    public int tt() throws x, IOException {
        if (this.tt == null) {
            throw new x("Parser is not opened.", this, null);
        }
        try {
            x();
            return this.x;
        } catch (IOException e) {
            c();
            throw e;
        }
    }

    @Override // com.byazt.o.sp
    public String uj() {
        return "XML line #" + ve();
    }

    @Override // com.byazt.o.sp
    public int ve() {
        return this.i;
    }

    /* JADX INFO: renamed from: com.byazt.o.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME, 44})
    public static final class C0485c {
        public int[] c = new int[32];
        public int tt;
        public int ve;

        public final void a() {
            int i = this.tt;
            if (i != 0) {
                int i2 = i - 1;
                int i3 = this.c[i2] * 2;
                if ((i2 - 1) - i3 != 0) {
                    this.tt = i - (i3 + 2);
                    this.ve--;
                }
            }
        }

        public final void c() {
            this.tt = 0;
            this.ve = 0;
        }

        public final void n() {
            c(2);
            int i = this.tt;
            int[] iArr = this.c;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.tt = i + 2;
            this.ve++;
        }

        public final int tt() {
            int i = this.tt;
            if (i == 0) {
                return 0;
            }
            return this.c[i - 1];
        }

        public final int uj() {
            return this.ve;
        }

        public final boolean ve() {
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

        public final void c(int i, int i2) {
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
            if (i3 <= i) {
                int[] iArr2 = new int[(iArr.length + i3) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.c = iArr2;
            }
        }
    }

    private final int n(int i) {
        if (this.x != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.t.length) {
            return i2;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
    }

    public String uj(int i) {
        int iN = n(i);
        int[] iArr = this.t;
        if (iArr[iN + 3] != 3) {
            return "";
        }
        return this.uj.c(iArr[iN + 2]);
    }

    public int ve(int i) {
        return this.t[n(i) + 4];
    }

    public void c() {
        if (this.ve) {
            this.ve = false;
            this.tt.c();
            this.tt = null;
            this.uj = null;
            this.n = null;
            this.f28862a.c();
            sp();
        }
    }

    public int tt(int i) {
        return this.t[n(i) + 3];
    }

    public String c(int i) {
        int i2 = this.t[n(i) + 1];
        return i2 == -1 ? "" : this.uj.c(i2);
    }
}
