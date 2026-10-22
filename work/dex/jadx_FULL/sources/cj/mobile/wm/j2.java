package cj.mobile.wm;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j2 {
    public static final String dexq = "a";
    public static final Bitmap.Config dexr = Bitmap.Config.ARGB_8888;
    public int[] dexa;
    public ByteBuffer dexc;
    public short[] dexe;
    public byte[] dexf;
    public byte[] dexg;
    public byte[] dexh;
    public int[] dexi;
    public int dexj;
    public byte[] dexk;
    public dexa dexm;
    public Bitmap dexn;
    public boolean dexo;
    public int dexp;
    public final int[] dexb = new int[256];
    public final byte[] dexd = new byte[256];
    public l2 dexl = new l2();

    public interface dexa {
        void a(Bitmap bitmap);

        Bitmap dexa(int i, int i2, Bitmap.Config config);
    }

    public j2(dexa dexaVar) {
        this.dexm = dexaVar;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0030  */
    private Bitmap dexa(k2 k2Var, k2 k2Var2) {
        int i;
        int i2;
        int i3;
        Bitmap bitmap;
        int i4;
        l2 l2Var = this.dexl;
        int i5 = l2Var.dexf;
        int i6 = l2Var.dexg;
        int[] iArr = this.dexi;
        int i7 = 0;
        if (k2Var2 == null) {
            Arrays.fill(iArr, 0);
        }
        int i8 = 2;
        if (k2Var2 != null && (i3 = k2Var2.dexg) > 0) {
            if (i3 == 2) {
                if (k2Var.dexf) {
                    i4 = 0;
                } else {
                    l2 l2Var2 = this.dexl;
                    i4 = l2Var2.dexl;
                    if (k2Var.dexk != null && l2Var2.dexj == k2Var.dexh) {
                        i4 = 0;
                    }
                }
                int i9 = (k2Var2.dexb * i5) + k2Var2.dexa;
                int i10 = (k2Var2.dexd * i5) + i9;
                while (i9 < i10) {
                    int i11 = k2Var2.dexc + i9;
                    for (int i12 = i9; i12 < i11; i12++) {
                        iArr[i12] = i4;
                    }
                    i9 += i5;
                }
            } else if (i3 == 3 && (bitmap = this.dexn) != null) {
                bitmap.getPixels(iArr, 0, i5, 0, 0, i5, i6);
            }
        }
        dexa(k2Var);
        int i13 = 8;
        int i14 = 1;
        int i15 = 0;
        while (true) {
            int i16 = k2Var.dexd;
            if (i7 >= i16) {
                break;
            }
            if (k2Var.dexe) {
                if (i15 >= i16) {
                    i14++;
                    if (i14 == i8) {
                        i15 = 4;
                    } else if (i14 == 3) {
                        i15 = i8;
                        i13 = 4;
                    } else if (i14 == 4) {
                        i13 = i8;
                        i15 = 1;
                    }
                }
                i2 = i15 + i13;
            } else {
                i2 = i15;
                i15 = i7;
            }
            int i17 = i15 + k2Var.dexb;
            l2 l2Var3 = this.dexl;
            if (i17 < l2Var3.dexg) {
                int i18 = l2Var3.dexf;
                int i19 = i17 * i18;
                int i20 = k2Var.dexa + i19;
                int i21 = k2Var.dexc;
                int i22 = i20 + i21;
                int i23 = i19 + i18;
                if (i23 < i22) {
                    i22 = i23;
                }
                int i24 = i21 * i7;
                while (i20 < i22) {
                    int i25 = i24 + 1;
                    int i26 = this.dexa[this.dexh[i24] & 255];
                    if (i26 != 0) {
                        iArr[i20] = i26;
                    }
                    i20++;
                    i24 = i25;
                }
            }
            i7++;
            i15 = i2;
            i8 = 2;
        }
        if (this.dexo && ((i = k2Var.dexg) == 0 || i == 1)) {
            if (this.dexn == null) {
                this.dexn = dexg();
            }
            this.dexn.setPixels(iArr, 0, i5, 0, 0, i5, i6);
        }
        Bitmap bitmapDexg = dexg();
        bitmapDexg.setPixels(iArr, 0, i5, 0, 0, i5, i6);
        return bitmapDexg;
    }

    @TargetApi(12)
    public static void dexa(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v16, types: [short] */
    /* JADX WARN: Type inference failed for: r3v18 */
    private void dexa(k2 k2Var) {
        int i;
        int i2;
        short s;
        if (k2Var != null) {
            this.dexc.position(k2Var.dexj);
        }
        if (k2Var == null) {
            l2 l2Var = this.dexl;
            i = l2Var.dexf;
            i2 = l2Var.dexg;
        } else {
            i = k2Var.dexc;
            i2 = k2Var.dexd;
        }
        int i3 = i * i2;
        byte[] bArr = this.dexh;
        if (bArr == null || bArr.length < i3) {
            this.dexh = new byte[i3];
        }
        if (this.dexe == null) {
            this.dexe = new short[4096];
        }
        if (this.dexf == null) {
            this.dexf = new byte[4096];
        }
        if (this.dexg == null) {
            this.dexg = new byte[4097];
        }
        int iDexh = dexh();
        int i4 = 1;
        int i5 = 1 << iDexh;
        int i6 = i5 + 1;
        int i7 = i5 + 2;
        int i8 = iDexh + 1;
        int i9 = (1 << i8) - 1;
        for (int i10 = 0; i10 < i5; i10++) {
            this.dexe[i10] = 0;
            this.dexf[i10] = (byte) i10;
        }
        int i11 = -1;
        int i12 = i8;
        int i13 = i7;
        int i14 = i9;
        int i15 = 0;
        int iDexi = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = -1;
        while (i15 < i3) {
            if (iDexi == 0) {
                iDexi = dexi();
                if (iDexi <= 0) {
                    this.dexp = 3;
                    break;
                }
                i18 = 0;
            }
            i17 += (this.dexd[i18] & 255) << i16;
            i16 += 8;
            i18 += i4;
            iDexi += i11;
            i20 = i20;
            i13 = i13;
            i12 = i12;
            int i23 = i22;
            while (true) {
                if (i16 < i12) {
                    i4 = 1;
                    i11 = -1;
                    i22 = i23;
                    i8 = i8;
                    break;
                }
                int i24 = i17 & i14;
                i17 >>= i12;
                i16 -= i12;
                if (i24 != i5) {
                    i8 = i8;
                    if (i24 > i13) {
                        this.dexp = 3;
                    } else if (i24 != i6) {
                        i6 = i6;
                        int i25 = i23;
                        if (i25 == -1) {
                            this.dexg[i21] = this.dexf[i24];
                            i21++;
                            i20 = i24;
                            i23 = i20;
                        } else {
                            if (i24 >= i13) {
                                this.dexg[i21] = (byte) i20;
                                s = i25;
                                i21++;
                            } else {
                                s = i24;
                            }
                            while (s >= i5) {
                                this.dexg[i21] = this.dexf[s];
                                s = this.dexe[s];
                                i21++;
                                i5 = i5;
                            }
                            int i26 = i5;
                            byte[] bArr2 = this.dexf;
                            i20 = bArr2[s] & 255;
                            int i27 = i21 + 1;
                            int i28 = i7;
                            byte b = (byte) i20;
                            this.dexg[i21] = b;
                            if (i13 < 4096) {
                                this.dexe[i13] = (short) i25;
                                bArr2[i13] = b;
                                i13++;
                                if ((i13 & i14) == 0 && i13 < 4096) {
                                    i12++;
                                    i14 += i13;
                                }
                            }
                            i21 = i27;
                            while (i21 > 0) {
                                i21--;
                                this.dexh[i19] = this.dexg[i21];
                                i15++;
                                i19++;
                            }
                            i23 = i24;
                            i5 = i26;
                            i7 = i28;
                        }
                    }
                    i8 = i8;
                    i22 = i23;
                    i4 = 1;
                    i11 = -1;
                    break;
                }
                i12 = i8;
                i13 = i7;
                i14 = i9;
                i23 = -1;
            }
        }
        for (int i29 = i19; i29 < i3; i29++) {
            this.dexh[i29] = 0;
        }
    }

    private Bitmap dexg() {
        dexa dexaVar = this.dexm;
        l2 l2Var = this.dexl;
        int i = l2Var.dexf;
        int i2 = l2Var.dexg;
        Bitmap.Config config = dexr;
        Bitmap bitmapDexa = dexaVar.dexa(i, i2, config);
        if (bitmapDexa == null) {
            l2 l2Var2 = this.dexl;
            bitmapDexa = Bitmap.createBitmap(l2Var2.dexf, l2Var2.dexg, config);
        }
        dexa(bitmapDexa);
        return bitmapDexa;
    }

    private int dexh() {
        try {
            return this.dexc.get() & 255;
        } catch (Exception unused) {
            this.dexp = 1;
            return 0;
        }
    }

    private int dexi() {
        int iDexh = dexh();
        int i = 0;
        if (iDexh > 0) {
            while (i < iDexh) {
                int i2 = iDexh - i;
                try {
                    this.dexc.get(this.dexd, i, i2);
                    i += i2;
                } catch (Exception e) {
                    Log.w(dexq, "Error Reading Block", e);
                    this.dexp = 1;
                }
            }
        }
        return i;
    }

    public int dexa(int i) {
        if (i >= 0) {
            l2 l2Var = this.dexl;
            if (i < l2Var.dexc) {
                return l2Var.dexe.get(i).dexi;
            }
        }
        return -1;
    }

    public void dexa() {
        this.dexj = (this.dexj + 1) % this.dexl.dexc;
    }

    public void dexa(l2 l2Var, byte[] bArr) {
        this.dexl = l2Var;
        this.dexk = bArr;
        this.dexp = 0;
        this.dexj = -1;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.dexc = byteBufferWrap;
        byteBufferWrap.rewind();
        this.dexc.order(ByteOrder.LITTLE_ENDIAN);
        this.dexo = false;
        Iterator<k2> it = l2Var.dexe.iterator();
        while (it.hasNext()) {
            if (it.next().dexg == 3) {
                this.dexo = true;
                break;
            }
        }
        int i = l2Var.dexf * l2Var.dexg;
        this.dexh = new byte[i];
        this.dexi = new int[i];
    }

    public void dexb() {
        this.dexl = null;
        this.dexk = null;
        this.dexh = null;
        this.dexi = null;
        Bitmap bitmap = this.dexn;
        if (bitmap != null) {
            this.dexm.a(bitmap);
        }
        this.dexn = null;
        this.dexc = null;
    }

    public int dexc() {
        return this.dexj;
    }

    public int dexd() {
        return this.dexl.dexc;
    }

    public int dexe() {
        int i;
        if (this.dexl.dexc <= 0 || (i = this.dexj) < 0) {
            return -1;
        }
        return dexa(i);
    }

    public synchronized Bitmap dexf() {
        if (this.dexl.dexc <= 0 || this.dexj < 0) {
            String str = dexq;
            if (Log.isLoggable(str, 3)) {
                f1.dexa(str, "unable to decode frame, frameCount=" + this.dexl.dexc + " framePointer=" + this.dexj);
            }
            this.dexp = 1;
        }
        int i = this.dexp;
        if (i != 1 && i != 2) {
            this.dexp = 0;
            k2 k2Var = this.dexl.dexe.get(this.dexj);
            int i2 = this.dexj - 1;
            k2 k2Var2 = i2 >= 0 ? this.dexl.dexe.get(i2) : null;
            int[] iArr = k2Var.dexk;
            if (iArr == null) {
                iArr = this.dexl.dexa;
            }
            this.dexa = iArr;
            if (iArr == null) {
                String str2 = dexq;
                if (Log.isLoggable(str2, 3)) {
                    f1.dexa(str2, "No Valid Color Table");
                }
                this.dexp = 1;
                return null;
            }
            if (k2Var.dexf) {
                System.arraycopy(iArr, 0, this.dexb, 0, iArr.length);
                int[] iArr2 = this.dexb;
                this.dexa = iArr2;
                iArr2[k2Var.dexh] = 0;
            }
            return dexa(k2Var, k2Var2);
        }
        String str3 = dexq;
        if (Log.isLoggable(str3, 3)) {
            f1.dexa(str3, "Unable to decode frame, status=" + this.dexp);
        }
        return null;
    }
}
