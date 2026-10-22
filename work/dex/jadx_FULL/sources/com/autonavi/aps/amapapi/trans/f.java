package com.autonavi.aps.amapapi.trans;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.amap.api.col.p0003l.fj;
import com.autonavi.aps.amapapi.restruct.g;
import com.autonavi.aps.amapapi.utils.i;
import com.zj.adlib.j4b;
import com.zj.adlib.mhb;
import com.zj.adlib.u15;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@SuppressLint({"NewApi"})
public final class f {
    protected static String I;
    protected static String K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f26199a = "1";
    protected short b = 0;
    protected String c = null;
    protected String d = null;
    protected String e = null;
    protected String f = null;
    protected String g = null;
    public String h = null;
    public String i = null;
    protected String j = null;
    protected String k = null;
    protected String l = null;
    protected String m = null;
    protected String n = null;
    protected String o = null;
    protected String p = null;
    protected String q = null;
    protected String r = null;
    protected String s = null;
    protected String t = null;
    protected String u = null;
    protected String v = null;
    protected String w = null;
    protected String x = null;
    protected String y = null;
    protected int z = 0;
    protected ArrayList<com.autonavi.aps.amapapi.restruct.d> A = new ArrayList<>();
    protected ArrayList<com.autonavi.aps.amapapi.restruct.d> B = new ArrayList<>();
    protected String C = null;
    protected String D = null;
    protected ArrayList<mhb> E = new ArrayList<>();
    protected String F = null;
    protected String G = null;
    protected byte[] H = null;
    private byte[] Q = null;
    private int R = 0;
    protected String J = null;
    protected String L = null;
    protected String M = null;
    protected String N = null;
    protected int O = 0;
    private List<com.autonavi.aps.amapapi.restruct.f> S = null;
    private List<com.autonavi.aps.amapapi.restruct.d> T = Collections.synchronizedList(new ArrayList());
    final int P = 3;

    private void b() {
        String[] strArr = new String[27];
        strArr[0] = this.f26199a;
        strArr[1] = this.c;
        strArr[2] = this.d;
        strArr[3] = this.e;
        strArr[4] = this.f;
        strArr[5] = this.g;
        strArr[6] = this.h;
        strArr[7] = this.i;
        strArr[8] = this.l;
        strArr[9] = this.m;
        strArr[10] = this.n;
        strArr[11] = this.o;
        strArr[12] = this.p;
        strArr[13] = this.q;
        strArr[14] = this.r;
        strArr[15] = this.s;
        strArr[16] = this.t;
        strArr[17] = this.u;
        strArr[18] = this.v;
        strArr[19] = this.w;
        strArr[20] = this.x;
        strArr[21] = this.D;
        strArr[22] = this.F;
        strArr[23] = this.G;
        strArr[24] = I;
        strArr[25] = this.M;
        strArr[26] = this.N;
        for (int i = 0; i < 27; i++) {
            if (TextUtils.isEmpty(strArr[i])) {
                strArr[i] = "";
            }
        }
        if (TextUtils.isEmpty(this.j)) {
            this.j = "0";
        } else if (!"0".equals(this.j) && !"2".equals(this.j)) {
            this.j = "0";
        }
        if (TextUtils.isEmpty(this.k)) {
            this.k = "0";
        } else if (!"0".equals(this.k) && !"1".equals(this.k)) {
            this.k = "0";
        }
        if (TextUtils.isEmpty(this.y)) {
            this.y = "0";
        } else if (!"1".equals(this.y) && !"2".equals(this.y)) {
            this.y = "0";
        }
        if (!com.autonavi.aps.amapapi.restruct.e.a(this.z)) {
            this.z = 0;
        }
        if (this.H == null) {
            this.H = new byte[0];
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:103:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:106:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:112:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:114:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:115:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:118:0x0307  */
    /* JADX WARN: Code duplicated, block: B:121:0x030c  */
    /* JADX WARN: Code duplicated, block: B:123:0x031c  */
    /* JADX WARN: Code duplicated, block: B:125:0x0324  */
    /* JADX WARN: Code duplicated, block: B:127:0x0327  */
    /* JADX WARN: Code duplicated, block: B:130:0x0333  */
    /* JADX WARN: Code duplicated, block: B:134:0x034d A[PHI: r0
      0x034d: PHI (r0v51 int) = (r0v50 int), (r0v50 int), (r0v162 int) binds: [B:129:0x0331, B:131:0x0336, B:360:0x034d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:137:0x0364 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:199:0x0537  */
    /* JADX WARN: Code duplicated, block: B:202:0x0547  */
    /* JADX WARN: Code duplicated, block: B:228:0x05f0  */
    /* JADX WARN: Code duplicated, block: B:231:0x0607  */
    /* JADX WARN: Code duplicated, block: B:232:0x060d  */
    /* JADX WARN: Code duplicated, block: B:234:0x0619  */
    /* JADX WARN: Code duplicated, block: B:235:0x061b  */
    /* JADX WARN: Code duplicated, block: B:237:0x061e  */
    /* JADX WARN: Code duplicated, block: B:240:0x062b  */
    /* JADX WARN: Code duplicated, block: B:246:0x0662 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:248:0x0666  */
    /* JADX WARN: Code duplicated, block: B:253:0x0678  */
    /* JADX WARN: Code duplicated, block: B:255:0x0683  */
    /* JADX WARN: Code duplicated, block: B:257:0x0686  */
    /* JADX WARN: Code duplicated, block: B:263:0x06c1  */
    /* JADX WARN: Code duplicated, block: B:265:0x06c4 A[Catch: all -> 0x06d6, TryCatch #4 {all -> 0x06d6, blocks: (B:261:0x06b6, B:265:0x06c4, B:266:0x06c8), top: B:369:0x06b6 }] */
    /* JADX WARN: Code duplicated, block: B:266:0x06c8 A[Catch: all -> 0x06d6, TRY_LEAVE, TryCatch #4 {all -> 0x06d6, blocks: (B:261:0x06b6, B:265:0x06c4, B:266:0x06c8), top: B:369:0x06b6 }] */
    /* JADX WARN: Code duplicated, block: B:273:0x06e9 A[Catch: all -> 0x070c, TRY_LEAVE, TryCatch #9 {all -> 0x070c, blocks: (B:271:0x06e1, B:273:0x06e9), top: B:377:0x06e1 }] */
    /* JADX WARN: Code duplicated, block: B:290:0x0724  */
    /* JADX WARN: Code duplicated, block: B:291:0x0726  */
    /* JADX WARN: Code duplicated, block: B:294:0x0735  */
    /* JADX WARN: Code duplicated, block: B:297:0x074f  */
    /* JADX WARN: Code duplicated, block: B:299:0x0753  */
    /* JADX WARN: Code duplicated, block: B:300:0x0758  */
    /* JADX WARN: Code duplicated, block: B:306:0x0773 A[Catch: all -> 0x0826, TryCatch #2 {all -> 0x0826, blocks: (B:303:0x0766, B:304:0x076d, B:306:0x0773, B:314:0x0788, B:316:0x078d, B:317:0x0790, B:328:0x080a, B:329:0x080b, B:320:0x07be, B:322:0x07c3, B:323:0x07c6, B:324:0x07e5, B:326:0x07ea, B:327:0x07ed), top: B:365:0x0766 }] */
    /* JADX WARN: Code duplicated, block: B:308:0x077f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:324:0x07e5 A[Catch: all -> 0x0826, TryCatch #2 {all -> 0x0826, blocks: (B:303:0x0766, B:304:0x076d, B:306:0x0773, B:314:0x0788, B:316:0x078d, B:317:0x0790, B:328:0x080a, B:329:0x080b, B:320:0x07be, B:322:0x07c3, B:323:0x07c6, B:324:0x07e5, B:326:0x07ea, B:327:0x07ed), top: B:365:0x0766 }] */
    /* JADX WARN: Code duplicated, block: B:326:0x07ea A[Catch: all -> 0x0826, TryCatch #2 {all -> 0x0826, blocks: (B:303:0x0766, B:304:0x076d, B:306:0x0773, B:314:0x0788, B:316:0x078d, B:317:0x0790, B:328:0x080a, B:329:0x080b, B:320:0x07be, B:322:0x07c3, B:323:0x07c6, B:324:0x07e5, B:326:0x07ea, B:327:0x07ed), top: B:365:0x0766 }] */
    /* JADX WARN: Code duplicated, block: B:336:0x0847  */
    /* JADX WARN: Code duplicated, block: B:338:0x084b  */
    /* JADX WARN: Code duplicated, block: B:339:0x084d  */
    /* JADX WARN: Code duplicated, block: B:342:0x0858  */
    /* JADX WARN: Code duplicated, block: B:345:0x0864  */
    /* JADX WARN: Code duplicated, block: B:347:0x0876  */
    /* JADX WARN: Code duplicated, block: B:350:0x08b8  */
    /* JADX WARN: Code duplicated, block: B:354:0x08ee  */
    /* JADX WARN: Code duplicated, block: B:365:0x0766 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:371:0x06fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:392:0x08bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:395:0x0687 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x0206  */
    /* JADX WARN: Code duplicated, block: B:70:0x0211  */
    /* JADX WARN: Code duplicated, block: B:72:0x0214  */
    /* JADX WARN: Code duplicated, block: B:77:0x0225  */
    /* JADX WARN: Code duplicated, block: B:78:0x0238  */
    /* JADX WARN: Code duplicated, block: B:81:0x0243  */
    /* JADX WARN: Code duplicated, block: B:84:0x0248  */
    /* JADX WARN: Code duplicated, block: B:87:0x0256  */
    /* JADX WARN: Code duplicated, block: B:89:0x025e  */
    /* JADX WARN: Code duplicated, block: B:90:0x0264  */
    /* JADX WARN: Code duplicated, block: B:92:0x0272  */
    /* JADX WARN: Code duplicated, block: B:94:0x027a  */
    /* JADX WARN: Code duplicated, block: B:95:0x0285  */
    /* JADX WARN: Code duplicated, block: B:98:0x0298  */
    /* JADX WARN: Code duplicated, block: B:99:0x02a3  */
    public final byte[] a() {
        int length;
        int length2;
        int length3;
        int i;
        long jB;
        byte[] bArr;
        int size;
        int i2;
        int i3;
        int i4;
        int i5;
        byte[] bArr2;
        long jB2;
        String str;
        int i6;
        byte[] bArr3;
        byte[] bArr4;
        byte b;
        int length4;
        byte b2;
        byte b3;
        int length5;
        ArrayList<mhb> arrayList;
        int iMin;
        int length6;
        boolean z;
        int i7;
        byte b4;
        int length7;
        mhb mhbVar;
        int length8;
        int i8;
        int length9;
        int i9;
        int i10;
        int i11;
        int length10;
        byte[] bArrA;
        int i12;
        int length11;
        byte[] bArr5;
        int length12;
        int length13;
        List<com.autonavi.aps.amapapi.restruct.f> list;
        int size2;
        int iCurrentTimeMillis;
        float f;
        List<com.autonavi.aps.amapapi.restruct.d> list2;
        int size3;
        int i13;
        int length14;
        int i14;
        byte b5;
        int length15;
        int length16;
        boolean zIsEmpty;
        byte[] bytes;
        int i15;
        byte[] bArr6;
        int length17;
        int length18;
        b();
        int i16 = 2;
        byte[] bArr7 = new byte[2];
        byte[] bArr8 = new byte[4];
        byte[] bArr9 = this.H;
        int i17 = 1;
        int length19 = bArr9 != null ? 4096 + bArr9.length + 1 : 4096;
        byte[] bArr10 = this.Q;
        if (bArr10 == null || length19 > this.R) {
            bArr10 = new byte[length19];
            this.Q = bArr10;
            this.R = length19;
        }
        byte[] bArr11 = bArr10;
        int i18 = 0;
        bArr11[0] = i.g(this.f26199a);
        byte[] bArr12 = null;
        byte[] bArrA2 = i.a(this.b, (byte[]) null);
        System.arraycopy(bArrA2, 0, bArr11, 1, bArrA2.length);
        int iA = a(this.q, bArr11, a(this.p, bArr11, a(this.h, bArr11, a(this.u, bArr11, a(this.g, bArr11, a(this.f, bArr11, a(this.e, bArr11, a(this.o, bArr11, a(this.d, bArr11, a(this.c, bArr11, bArrA2.length + 1))))))))));
        try {
            if (TextUtils.isEmpty(this.t)) {
                bArr11[iA] = 0;
                length = iA + 1;
            } else {
                byte[] bArrA3 = a(this.t);
                bArr11[iA] = (byte) bArrA3.length;
                int i19 = iA + 1;
                System.arraycopy(bArrA3, 0, bArr11, i19, bArrA3.length);
                length = i19 + bArrA3.length;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Req", "buildV4Dot219");
            bArr11[iA] = 0;
        }
        int iA2 = a(this.x, bArr11, a(K, bArr11, a(I, bArr11, a(this.w, bArr11, a(this.v, bArr11, length)))));
        bArr11[iA2] = Byte.parseByte(this.y);
        int i20 = iA2 + 1;
        bArr11[i20] = Byte.parseByte(this.j);
        int i21 = i20 + 1;
        int i22 = this.z;
        int i23 = i22 & 3;
        bArr11[i21] = (byte) i22;
        int length20 = i21 + 1;
        try {
            try {
                try {
                    try {
                        try {
                            if (i23 == 1 || i23 == 2) {
                                byte[] bArrA4 = i.a(this.A.size() > 0 ? this.A.get(0).f26182a : 0, (byte[]) null);
                                System.arraycopy(bArrA4, 0, bArr11, length20, bArrA4.length);
                                int length21 = length20 + bArrA4.length;
                                if (i23 != 1) {
                                    if (i23 != 2) {
                                        if (this.A.size() > 0) {
                                            i = this.A.get(0).k;
                                        } else {
                                            i = 0;
                                        }
                                        if (i <= 127 || i < -128) {
                                            i = 0;
                                        }
                                        bArr11[length21] = (byte) i;
                                        int i24 = length21 + 1;
                                        if (this.A.size() > 0) {
                                            jB = (i.b() - this.A.get(0).t) / 1000;
                                        } else {
                                            jB = 0;
                                        }
                                        if (jB > 65535) {
                                            jB = 65535;
                                        }
                                        if (jB < 0) {
                                            jB = 0;
                                        }
                                        byte[] bArrA5 = i.a((int) jB, bArr7);
                                        System.arraycopy(bArrA5, 0, bArr11, i24, bArrA5.length);
                                        length20 = i24 + 2;
                                        if (i23 == 1) {
                                            bArr = bArr11;
                                            if (i23 == 2) {
                                                bArr[length20] = 0;
                                                length20++;
                                            }
                                        } else if (this.A.size() == 0) {
                                            bArr11[length20] = 0;
                                            length20++;
                                        } else {
                                            size = this.A.size();
                                            bArr11[length20] = (byte) size;
                                            length20++;
                                            i2 = 0;
                                            while (i2 < size) {
                                                if (this.A.size() > 0) {
                                                    i3 = this.A.get(i2).c;
                                                } else {
                                                    i3 = 0;
                                                }
                                                byte[] bArrA6 = i.a(i3, bArr12);
                                                System.arraycopy(bArrA6, 0, bArr11, length20, bArrA6.length);
                                                int length22 = length20 + bArrA6.length;
                                                if (this.A.size() > 0) {
                                                    i4 = this.A.get(i2).d;
                                                } else {
                                                    i4 = 0;
                                                }
                                                byte[] bArrB = i.b(i4, bArr12);
                                                System.arraycopy(bArrB, 0, bArr11, length22, bArrB.length);
                                                int length23 = length22 + bArrB.length;
                                                if (this.A.size() > 0) {
                                                    i5 = this.A.get(i2).k;
                                                } else {
                                                    i5 = 0;
                                                }
                                                if (i5 <= 127 || i5 < -128) {
                                                    i5 = 0;
                                                }
                                                bArr11[length23] = (byte) i5;
                                                length20 = length23 + i17;
                                                if (Double.valueOf(com.autonavi.aps.amapapi.utils.b.f26202a).doubleValue() >= 5.2d) {
                                                    if (this.A.size() > 0) {
                                                        jB2 = (i.b() - this.A.get(0).t) / 1000;
                                                    } else {
                                                        jB2 = 0;
                                                    }
                                                    if (jB2 > 65535) {
                                                        jB2 = 65535;
                                                    }
                                                    if (jB2 < 0) {
                                                        jB2 = 0;
                                                    }
                                                    byte[] bArrA7 = i.a((int) jB2, bArr7);
                                                    bArr2 = bArr11;
                                                    System.arraycopy(bArrA7, 0, bArr2, length20, bArrA7.length);
                                                    length20 += bArrA7.length;
                                                } else {
                                                    bArr2 = bArr11;
                                                }
                                                i2++;
                                                bArr11 = bArr2;
                                                i17 = 1;
                                                bArr12 = null;
                                            }
                                        }
                                    } else {
                                        byte[] bArrA8 = i.a(this.A.size() > 0 ? this.A.get(0).h : 0, (byte[]) null);
                                        System.arraycopy(bArrA8, 0, bArr11, length21, bArrA8.length);
                                        int length24 = length21 + bArrA8.length;
                                        byte[] bArrA9 = i.a(this.A.size() > 0 ? this.A.get(0).i : 0, (byte[]) null);
                                        System.arraycopy(bArrA9, 0, bArr11, length24, bArrA9.length);
                                        int length25 = length24 + bArrA9.length;
                                        byte[] bArrA10 = i.a(this.A.size() > 0 ? this.A.get(0).j : 0, (byte[]) null);
                                        System.arraycopy(bArrA10, 0, bArr11, length25, bArrA10.length);
                                        int length26 = length25 + bArrA10.length;
                                        byte[] bArrB2 = i.b(this.A.size() > 0 ? this.A.get(0).g : 0, (byte[]) null);
                                        System.arraycopy(bArrB2, 0, bArr11, length26, bArrB2.length);
                                        length2 = length26 + bArrB2.length;
                                        byte[] bArrB3 = i.b(this.A.size() > 0 ? this.A.get(0).f : 0, (byte[]) null);
                                        System.arraycopy(bArrB3, 0, bArr11, length2, bArrB3.length);
                                        length3 = bArrB3.length;
                                    }
                                    str = this.C;
                                    if (str == null && (this.z & 8) == 8) {
                                        try {
                                            byte[] bytes2 = str.getBytes("GBK");
                                            int iMin2 = Math.min(bytes2.length, 60);
                                            bArr[length20] = (byte) iMin2;
                                            length20++;
                                            System.arraycopy(bytes2, 0, bArr, length20, iMin2);
                                            i6 = length20 + iMin2;
                                        } catch (Exception unused) {
                                            bArr[length20] = 0;
                                            i6 = length20 + 1;
                                        }
                                    } else {
                                        bArr[length20] = 0;
                                        i6 = length20 + 1;
                                    }
                                    ArrayList<com.autonavi.aps.amapapi.restruct.d> arrayList2 = this.B;
                                    int size4 = arrayList2.size();
                                    int i25 = 5;
                                    int i26 = 3;
                                    if ((this.z & 4) == 4 || size4 <= 0) {
                                        bArr3 = bArr;
                                        bArr4 = bArr8;
                                        bArr3[i6] = 0;
                                        b = 1;
                                        length4 = i6 + 1;
                                    } else {
                                        arrayList2.get(0);
                                        bArr[i6] = (byte) size4;
                                        int i27 = 1;
                                        length4 = i6 + 1;
                                        int i28 = 0;
                                        while (i28 < size4) {
                                            com.autonavi.aps.amapapi.restruct.d dVar = arrayList2.get(i28);
                                            int i29 = dVar.l;
                                            if (i29 == i27 || i29 == i26 || i29 == 4) {
                                                bArr6 = bArr8;
                                                byte b6 = (byte) i29;
                                                if (dVar.n) {
                                                    b6 = (byte) (b6 | 8);
                                                }
                                                bArr[length4] = b6;
                                                int i30 = length4 + 1;
                                                byte[] bArrA11 = i.a(dVar.f26182a, bArr7);
                                                System.arraycopy(bArrA11, i18, bArr, i30, bArrA11.length);
                                                int length27 = i30 + bArrA11.length;
                                                byte[] bArrA12 = i.a(dVar.b, bArr7);
                                                System.arraycopy(bArrA12, i18, bArr, length27, bArrA12.length);
                                                int length28 = length27 + bArrA12.length;
                                                byte[] bArrA13 = i.a(dVar.c, bArr7);
                                                System.arraycopy(bArrA13, i18, bArr, length28, bArrA13.length);
                                                int length29 = length28 + bArrA13.length;
                                                byte[] bArrB4 = i.b(dVar.d, bArr6);
                                                System.arraycopy(bArrB4, i18, bArr, length29, bArrB4.length);
                                                length4 = length29 + bArrB4.length;
                                            } else if (i29 == i16) {
                                                byte b7 = (byte) i29;
                                                if (dVar.n) {
                                                    b7 = (byte) (b7 | 8);
                                                }
                                                bArr[length4] = b7;
                                                int i31 = length4 + 1;
                                                byte[] bArrA14 = i.a(dVar.f26182a, bArr7);
                                                System.arraycopy(bArrA14, i18, bArr, i31, bArrA14.length);
                                                int length30 = i31 + bArrA14.length;
                                                byte[] bArrA15 = i.a(dVar.h, bArr7);
                                                System.arraycopy(bArrA15, i18, bArr, length30, bArrA15.length);
                                                int length31 = length30 + bArrA15.length;
                                                byte[] bArrA16 = i.a(dVar.i, bArr7);
                                                System.arraycopy(bArrA16, i18, bArr, length31, bArrA16.length);
                                                int length32 = length31 + bArrA16.length;
                                                byte[] bArrA17 = i.a(dVar.j, bArr7);
                                                System.arraycopy(bArrA17, i18, bArr, length32, bArrA17.length);
                                                int length33 = length32 + bArrA17.length;
                                                bArr6 = bArr8;
                                                byte[] bArrB5 = i.b(dVar.g, bArr6);
                                                System.arraycopy(bArrB5, i18, bArr, length33, bArrB5.length);
                                                int length34 = length33 + bArrB5.length;
                                                byte[] bArrB6 = i.b(dVar.f, bArr6);
                                                System.arraycopy(bArrB6, i18, bArr, length34, bArrB6.length);
                                                length4 = length34 + bArrB6.length;
                                            } else {
                                                bArr6 = bArr8;
                                                if (i29 == i25) {
                                                    byte b8 = (byte) i29;
                                                    if (dVar.n) {
                                                        b8 = (byte) (b8 | 8);
                                                    }
                                                    bArr[length4] = b8;
                                                    int i32 = length4 + 1;
                                                    byte[] bArrA18 = i.a(dVar.f26182a, bArr7);
                                                    System.arraycopy(bArrA18, i18, bArr, i32, bArrA18.length);
                                                    int length35 = i32 + bArrA18.length;
                                                    byte[] bArrA19 = i.a(dVar.b, bArr7);
                                                    System.arraycopy(bArrA19, i18, bArr, length35, bArrA19.length);
                                                    int length36 = length35 + bArrA19.length;
                                                    byte[] bArrA20 = i.a(dVar.c, bArr7);
                                                    System.arraycopy(bArrA20, i18, bArr, length36, bArrA20.length);
                                                    int length37 = length36 + bArrA20.length;
                                                    System.arraycopy(i.a(dVar.e), i18, bArr, length37, 8);
                                                    length4 = length37 + 8;
                                                }
                                            }
                                            int i33 = dVar.k;
                                            if (i33 > 127 || i33 < -128) {
                                                i33 = 99;
                                            }
                                            bArr[length4] = (byte) i33;
                                            int i34 = length4 + 1;
                                            byte[] bArr13 = bArr;
                                            byte[] bArrA21 = i.a((short) ((i.b() - dVar.t) / 1000), bArr7);
                                            System.arraycopy(bArrA21, 0, bArr13, i34, bArrA21.length);
                                            length4 = i34 + bArrA21.length;
                                            int i35 = dVar.l;
                                            if (i35 == 3 || i35 == 4 || i35 == 5) {
                                                if (Double.valueOf(com.autonavi.aps.amapapi.utils.b.f26202a).doubleValue() >= 5.0d) {
                                                    int i36 = dVar.o;
                                                    if (i36 > 32767) {
                                                        i36 = 32767;
                                                    }
                                                    byte[] bArrA22 = i.a(i36 >= 0 ? i36 : 32767, bArr7);
                                                    System.arraycopy(bArrA22, 0, bArr13, length4, bArrA22.length);
                                                    length4 += bArrA22.length;
                                                    if (Double.valueOf(com.autonavi.aps.amapapi.utils.b.f26202a).doubleValue() >= 5.3d) {
                                                        byte[] bArrB7 = i.b(dVar.p, bArr6);
                                                        System.arraycopy(bArrB7, 0, bArr13, length4, bArrB7.length);
                                                        length17 = length4 + bArrB7.length;
                                                        byte[] bArrB8 = i.b(dVar.q, bArr6);
                                                        System.arraycopy(bArrB8, 0, bArr13, length17, bArrB8.length);
                                                        length18 = bArrB8.length;
                                                        length4 = length17 + length18;
                                                    }
                                                }
                                            } else if (i35 == 1 && Double.valueOf(com.autonavi.aps.amapapi.utils.b.f26202a).doubleValue() >= 5.3d) {
                                                int i37 = dVar.o;
                                                if (i37 > 32767) {
                                                    i37 = 32767;
                                                }
                                                byte[] bArrA23 = i.a(i37 >= 0 ? i37 : 32767, bArr7);
                                                System.arraycopy(bArrA23, 0, bArr13, length4, bArrA23.length);
                                                int length38 = length4 + bArrA23.length;
                                                byte[] bArrB9 = i.b(dVar.p, bArr6);
                                                System.arraycopy(bArrB9, 0, bArr13, length38, bArrB9.length);
                                                length17 = length38 + bArrB9.length;
                                                byte[] bArrB10 = i.b(dVar.q, bArr6);
                                                System.arraycopy(bArrB10, 0, bArr13, length17, bArrB10.length);
                                                length18 = bArrB10.length;
                                                length4 = length17 + length18;
                                            }
                                            i28++;
                                            bArr8 = bArr6;
                                            bArr = bArr13;
                                            i16 = 2;
                                            i18 = 0;
                                            i27 = 1;
                                            i25 = 5;
                                            i26 = 3;
                                        }
                                        bArr3 = bArr;
                                        bArr4 = bArr8;
                                        b = 1;
                                    }
                                    if (!TextUtils.isEmpty(this.D) || this.D.length() == 0) {
                                        b2 = b;
                                        b3 = 0;
                                        bArr3[length4] = 0;
                                        length5 = length4 + 1;
                                    } else {
                                        bArr3[length4] = b;
                                        length5 = length4 + 1;
                                        try {
                                            String[] strArrSplit = this.D.split(",");
                                            byte[] bArrA24 = a(strArrSplit[0]);
                                            System.arraycopy(bArrA24, 0, bArr3, length5, bArrA24.length);
                                            length5 += bArrA24.length;
                                            try {
                                                byte[] bytes3 = strArrSplit[2].getBytes("GBK");
                                                int length39 = bytes3.length;
                                                if (length39 > 127) {
                                                    length39 = 127;
                                                }
                                                bArr3[length5] = (byte) length39;
                                                length5++;
                                                System.arraycopy(bytes3, 0, bArr3, length5, length39);
                                                i15 = length5 + length39;
                                            } catch (Throwable th2) {
                                                com.autonavi.aps.amapapi.utils.b.a(th2, "Req", "buildV4Dot214");
                                                bArr3[length5] = 0;
                                                i15 = length5 + 1;
                                            }
                                            int i38 = Integer.parseInt(strArrSplit[1]);
                                            if (i38 > 127 || i38 < -128) {
                                                i38 = 0;
                                            }
                                            bArr3[i15] = Byte.parseByte(String.valueOf(i38));
                                            length5 = i15 + 1;
                                            if (Double.valueOf(com.autonavi.aps.amapapi.utils.b.f26202a).doubleValue() >= 5.2d) {
                                                byte[] bArrA25 = i.a(this.O, bArr7);
                                                System.arraycopy(bArrA25, 0, bArr3, length5, bArrA25.length);
                                                length5 += bArrA25.length;
                                            }
                                            b2 = 1;
                                            b3 = 0;
                                        } catch (Throwable th3) {
                                            com.autonavi.aps.amapapi.utils.b.a(th3, "Req", "buildV4Dot216");
                                            byte[] bArrA26 = a(com.alipay.sdk.m.y.d.f25528a);
                                            b3 = 0;
                                            System.arraycopy(bArrA26, 0, bArr3, length5, bArrA26.length);
                                            int length40 = length5 + bArrA26.length;
                                            bArr3[length40] = 0;
                                            b2 = 1;
                                            int i39 = length40 + 1;
                                            bArr3[i39] = Byte.parseByte("0");
                                            length5 = i39 + 1;
                                        }
                                    }
                                    arrayList = this.E;
                                    iMin = Math.min(arrayList.size(), 25);
                                    if (iMin == 0) {
                                        bArr3[length5] = b3;
                                        length7 = length5 + b2;
                                        b4 = 0;
                                    } else {
                                        bArr3[length5] = (byte) iMin;
                                        length6 = length5 + b2;
                                        if (i.c() >= 17) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        long jB3 = z ? i.b() / 1000 : 0L;
                                        for (i7 = 0; i7 < iMin; i7++) {
                                            mhbVar = arrayList.get(i7);
                                            byte[] bArrA27 = a(mhb.c(mhbVar.f18215a));
                                            System.arraycopy(bArrA27, 0, bArr3, length6, bArrA27.length);
                                            length8 = length6 + bArrA27.length;
                                            try {
                                                byte[] bytes4 = mhbVar.f18216a.getBytes("GBK");
                                                bArr3[length8] = (byte) bytes4.length;
                                                length8++;
                                                System.arraycopy(bytes4, 0, bArr3, length8, bytes4.length);
                                                length9 = length8 + bytes4.length;
                                                i8 = 1;
                                            } catch (Exception unused2) {
                                                bArr3[length8] = 0;
                                                i8 = 1;
                                                length9 = length8 + 1;
                                            }
                                            i9 = mhbVar.f43306a;
                                            if (i9 <= 127 || i9 < -128) {
                                                i9 = 0;
                                            }
                                            bArr3[length9] = Byte.parseByte(String.valueOf(i9));
                                            int i40 = length9 + i8;
                                            if (z || (i10 = (int) (jB3 - (mhbVar.c / 1000))) < 0) {
                                                i10 = 0;
                                            }
                                            if (i10 > 65535) {
                                                i10 = 65535;
                                            }
                                            byte[] bArrA28 = i.a(i10, bArr7);
                                            System.arraycopy(bArrA28, 0, bArr3, i40, bArrA28.length);
                                            int length41 = i40 + bArrA28.length;
                                            byte[] bArrA29 = i.a(mhbVar.b, bArr7);
                                            System.arraycopy(bArrA29, 0, bArr3, length41, bArrA29.length);
                                            length6 = length41 + bArrA29.length;
                                        }
                                        b4 = 0;
                                        byte[] bArrA30 = i.a(Integer.parseInt(this.F), bArr7);
                                        System.arraycopy(bArrA30, 0, bArr3, length6, bArrA30.length);
                                        length7 = length6 + bArrA30.length;
                                    }
                                    bArr3[length7] = b4;
                                    i11 = length7 + 1;
                                    bytes = this.G.getBytes("GBK");
                                    if (bytes.length > 127) {
                                        bytes = null;
                                    }
                                    if (bytes == null) {
                                        bArr3[i11] = 0;
                                        length10 = i11 + 1;
                                    } else {
                                        bArr3[i11] = (byte) bytes.length;
                                        int i41 = i11 + 1;
                                        System.arraycopy(bytes, 0, bArr3, i41, bytes.length);
                                        length10 = i41 + bytes.length;
                                    }
                                    bArrA = new byte[]{0, 0};
                                    zIsEmpty = TextUtils.isEmpty(this.J);
                                    if (!zIsEmpty) {
                                        bArrA = i.a(this.J.length(), bArr7);
                                    }
                                    System.arraycopy(bArrA, 0, bArr3, length10, 2);
                                    length11 = length10 + 2;
                                    if (!zIsEmpty) {
                                        try {
                                            byte[] bytes5 = this.J.getBytes("GBK");
                                            System.arraycopy(bytes5, 0, bArr3, length11, bytes5.length);
                                            length11 += bytes5.length;
                                        } catch (Throwable unused3) {
                                        }
                                    }
                                    i12 = 2;
                                    System.arraycopy(i.a(0, bArr7), 0, bArr3, length11, i12);
                                    int i42 = length11 + i12;
                                    byte[] bArr14 = new byte[i12];
                                    // fill-array-data instruction
                                    bArr14[0] = 0;
                                    bArr14[1] = 0;
                                    System.arraycopy(bArr14, 0, bArr3, i42, i12);
                                    int i43 = i42 + i12;
                                    bArr5 = this.H;
                                    if (bArr5 != null) {
                                        length12 = bArr5.length;
                                    } else {
                                        length12 = 0;
                                    }
                                    byte[] bArrA31 = i.a(length12, (byte[]) null);
                                    System.arraycopy(bArrA31, 0, bArr3, i43, bArrA31.length);
                                    length13 = i43 + bArrA31.length;
                                    if (length12 > 0) {
                                        byte[] bArr15 = this.H;
                                        System.arraycopy(bArr15, 0, bArr3, length13, bArr15.length);
                                        length13 += this.H.length;
                                    }
                                    if (Double.valueOf(com.autonavi.aps.amapapi.utils.b.f26202a).doubleValue() >= 5.0d) {
                                        list2 = this.T;
                                        if (list2 != null) {
                                            size3 = list2.size();
                                        } else {
                                            size3 = 0;
                                        }
                                        bArr3[length13] = (byte) size3;
                                        i13 = length13 + 1;
                                        byte[] bArr16 = new byte[i13];
                                        System.arraycopy(bArr3, 0, bArr16, 0, i13);
                                        if (size3 > 0) {
                                            try {
                                                length14 = i13;
                                                for (com.autonavi.aps.amapapi.restruct.d dVar2 : this.T) {
                                                    i14 = dVar2.l;
                                                    if (i14 != 1 || i14 == 3 || i14 == 4) {
                                                        b5 = (byte) i14;
                                                        if (dVar2.n) {
                                                            b5 = (byte) (b5 | 8);
                                                        }
                                                        bArr3[length14] = b5;
                                                        int i44 = length14 + 1;
                                                        byte[] bArrA32 = i.a(dVar2.c, bArr7);
                                                        System.arraycopy(bArrA32, 0, bArr3, i44, bArrA32.length);
                                                        length15 = i44 + bArrA32.length;
                                                        byte[] bArrB11 = i.b(dVar2.d, bArr4);
                                                        System.arraycopy(bArrB11, 0, bArr3, length15, bArrB11.length);
                                                        length16 = bArrB11.length;
                                                    } else {
                                                        if (i14 == 2) {
                                                            byte b9 = (byte) i14;
                                                            if (dVar2.n) {
                                                                b9 = (byte) (b9 | 8);
                                                            }
                                                            bArr3[length14] = b9;
                                                            int i45 = length14 + 1;
                                                            byte[] bArrA33 = i.a(dVar2.h, bArr7);
                                                            System.arraycopy(bArrA33, 0, bArr3, i45, bArrA33.length);
                                                            int length42 = i45 + bArrA33.length;
                                                            byte[] bArrA34 = i.a(dVar2.i, bArr7);
                                                            System.arraycopy(bArrA34, 0, bArr3, length42, bArrA34.length);
                                                            length15 = length42 + bArrA34.length;
                                                            byte[] bArrA35 = i.a(dVar2.j, bArr7);
                                                            System.arraycopy(bArrA35, 0, bArr3, length15, bArrA35.length);
                                                            length16 = bArrA35.length;
                                                        } else if (i14 == 5) {
                                                            byte b10 = (byte) i14;
                                                            if (dVar2.n) {
                                                                b10 = (byte) (b10 | 8);
                                                            }
                                                            bArr3[length14] = b10;
                                                            int i46 = length14 + 1;
                                                            byte[] bArrA36 = i.a(dVar2.c, bArr7);
                                                            System.arraycopy(bArrA36, 0, bArr3, i46, bArrA36.length);
                                                            int length43 = i46 + bArrA36.length;
                                                            System.arraycopy(i.a(dVar2.e), 0, bArr3, length43, 8);
                                                            length14 = length43 + 8;
                                                        }
                                                        byte[] bArrA37 = i.a((short) ((i.b() - dVar2.t) / 1000), bArr7);
                                                        System.arraycopy(bArrA37, 0, bArr3, length14, bArrA37.length);
                                                        length14 += bArrA37.length;
                                                    }
                                                    length14 = length15 + length16;
                                                    byte[] bArrA38 = i.a((short) ((i.b() - dVar2.t) / 1000), bArr7);
                                                    System.arraycopy(bArrA38, 0, bArr3, length14, bArrA38.length);
                                                    length14 += bArrA38.length;
                                                }
                                                i13 = length14;
                                            } catch (Throwable unused4) {
                                                System.arraycopy(bArr16, 0, bArr3, 0, i13);
                                                bArr3[i13 - 1] = 0;
                                            }
                                        }
                                        length13 = a(this.M, bArr3, i13);
                                    }
                                    if (Double.valueOf(com.autonavi.aps.amapapi.utils.b.f26202a).doubleValue() >= 5.2d) {
                                        list = this.S;
                                        if (list == null) {
                                            size2 = 0;
                                        } else {
                                            size2 = list.size();
                                        }
                                        bArr3[length13] = (byte) size2;
                                        length13++;
                                        if (size2 > 0) {
                                            for (com.autonavi.aps.amapapi.restruct.f fVar : this.S) {
                                                iCurrentTimeMillis = ((int) (System.currentTimeMillis() - fVar.d)) / 1000;
                                                if (iCurrentTimeMillis > 65535) {
                                                    iCurrentTimeMillis = 65535;
                                                }
                                                System.arraycopy(i.a(iCurrentTimeMillis, bArr7), 0, bArr3, length13, 2);
                                                int i47 = length13 + 2;
                                                System.arraycopy(i.b((int) Math.round(fVar.c * 1.0E7d), bArr4), 0, bArr3, i47, 4);
                                                int i48 = i47 + 4;
                                                System.arraycopy(i.b((int) Math.round(fVar.b * 1.0E7d), bArr4), 0, bArr3, i48, 4);
                                                int i49 = i48 + 4;
                                                f = fVar.e;
                                                if (f > 65535.0f) {
                                                    f = 65535.0f;
                                                }
                                                System.arraycopy(i.a((int) f, bArr7), 0, bArr3, i49, 2);
                                                int i50 = i49 + 2;
                                                System.arraycopy(i.a((short) ((fVar.h | (fVar.f26186a << 13) | (fVar.g << 6)) & 65535), bArr7), 0, bArr3, i50, 2);
                                                length13 = i50 + 2;
                                            }
                                        }
                                    }
                                    if (Double.valueOf(com.autonavi.aps.amapapi.utils.b.f26202a).doubleValue() >= 5.3d) {
                                        length13 = a(this.N, bArr3, length13);
                                    }
                                    byte[] bArr17 = new byte[length13];
                                    System.arraycopy(bArr3, 0, bArr17, 0, length13);
                                    CRC32 crc32 = new CRC32();
                                    crc32.update(bArr17);
                                    byte[] bArrA39 = i.a(crc32.getValue());
                                    byte[] bArr18 = new byte[length13 + 8];
                                    System.arraycopy(bArr17, 0, bArr18, 0, length13);
                                    System.arraycopy(bArrA39, 0, bArr18, length13, 8);
                                    return bArr18;
                                }
                                byte[] bArrA40 = i.a(this.A.size() > 0 ? this.A.get(0).b : 0, (byte[]) null);
                                System.arraycopy(bArrA40, 0, bArr11, length21, bArrA40.length);
                                int length44 = length21 + bArrA40.length;
                                byte[] bArrA41 = i.a(this.A.size() > 0 ? this.A.get(0).c : 0, (byte[]) null);
                                System.arraycopy(bArrA41, 0, bArr11, length44, bArrA41.length);
                                length2 = length44 + bArrA41.length;
                                byte[] bArrB12 = i.b(this.A.size() > 0 ? this.A.get(0).d : 0, (byte[]) null);
                                System.arraycopy(bArrB12, 0, bArr11, length2, bArrB12.length);
                                length3 = bArrB12.length;
                                length21 = length2 + length3;
                                if (this.A.size() > 0) {
                                    i = this.A.get(0).k;
                                } else {
                                    i = 0;
                                }
                                if (i <= 127) {
                                    i = 0;
                                } else {
                                    i = 0;
                                }
                                bArr11[length21] = (byte) i;
                                int i210 = length21 + 1;
                                if (this.A.size() > 0) {
                                    jB = (i.b() - this.A.get(0).t) / 1000;
                                } else {
                                    jB = 0;
                                }
                                if (jB > 65535) {
                                    jB = 65535;
                                }
                                if (jB < 0) {
                                    jB = 0;
                                }
                                byte[] bArrA42 = i.a((int) jB, bArr7);
                                System.arraycopy(bArrA42, 0, bArr11, i210, bArrA42.length);
                                length20 = i210 + 2;
                                if (i23 == 1) {
                                    bArr = bArr11;
                                    if (i23 == 2) {
                                        bArr[length20] = 0;
                                        length20++;
                                    }
                                } else if (this.A.size() == 0) {
                                    bArr11[length20] = 0;
                                    length20++;
                                } else {
                                    size = this.A.size();
                                    bArr11[length20] = (byte) size;
                                    length20++;
                                    i2 = 0;
                                    while (i2 < size) {
                                        if (this.A.size() > 0) {
                                            i3 = this.A.get(i2).c;
                                        } else {
                                            i3 = 0;
                                        }
                                        byte[] bArrA43 = i.a(i3, bArr12);
                                        System.arraycopy(bArrA43, 0, bArr11, length20, bArrA43.length);
                                        int length210 = length20 + bArrA43.length;
                                        if (this.A.size() > 0) {
                                            i4 = this.A.get(i2).d;
                                        } else {
                                            i4 = 0;
                                        }
                                        byte[] bArrB13 = i.b(i4, bArr12);
                                        System.arraycopy(bArrB13, 0, bArr11, length210, bArrB13.length);
                                        int length211 = length210 + bArrB13.length;
                                        if (this.A.size() > 0) {
                                            i5 = this.A.get(i2).k;
                                        } else {
                                            i5 = 0;
                                        }
                                        if (i5 <= 127) {
                                            i5 = 0;
                                        } else {
                                            i5 = 0;
                                        }
                                        bArr11[length211] = (byte) i5;
                                        length20 = length211 + i17;
                                        if (Double.valueOf(com.autonavi.aps.amapapi.utils.b.f26202a).doubleValue() >= 5.2d) {
                                            if (this.A.size() > 0) {
                                                jB2 = (i.b() - this.A.get(0).t) / 1000;
                                            } else {
                                                jB2 = 0;
                                            }
                                            if (jB2 > 65535) {
                                                jB2 = 65535;
                                            }
                                            if (jB2 < 0) {
                                                jB2 = 0;
                                            }
                                            byte[] bArrA44 = i.a((int) jB2, bArr7);
                                            bArr2 = bArr11;
                                            System.arraycopy(bArrA44, 0, bArr2, length20, bArrA44.length);
                                            length20 += bArrA44.length;
                                        } else {
                                            bArr2 = bArr11;
                                        }
                                        i2++;
                                        bArr11 = bArr2;
                                        i17 = 1;
                                        bArr12 = null;
                                    }
                                }
                                str = this.C;
                                if (str == null) {
                                    bArr[length20] = 0;
                                    i6 = length20 + 1;
                                } else {
                                    bArr[length20] = 0;
                                    i6 = length20 + 1;
                                }
                                ArrayList<com.autonavi.aps.amapapi.restruct.d> arrayList3 = this.B;
                                int size5 = arrayList3.size();
                                int i211 = 5;
                                int i212 = 3;
                                if ((this.z & 4) == 4) {
                                    bArr3 = bArr;
                                    bArr4 = bArr8;
                                    bArr3[i6] = 0;
                                    b = 1;
                                    length4 = i6 + 1;
                                } else {
                                    bArr3 = bArr;
                                    bArr4 = bArr8;
                                    bArr3[i6] = 0;
                                    b = 1;
                                    length4 = i6 + 1;
                                }
                                if (TextUtils.isEmpty(this.D)) {
                                    b2 = b;
                                    b3 = 0;
                                    bArr3[length4] = 0;
                                    length5 = length4 + 1;
                                } else {
                                    b2 = b;
                                    b3 = 0;
                                    bArr3[length4] = 0;
                                    length5 = length4 + 1;
                                }
                                arrayList = this.E;
                                iMin = Math.min(arrayList.size(), 25);
                                if (iMin == 0) {
                                    bArr3[length5] = b3;
                                    length7 = length5 + b2;
                                    b4 = 0;
                                } else {
                                    bArr3[length5] = (byte) iMin;
                                    length6 = length5 + b2;
                                    if (i.c() >= 17) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                    }
                                    while (i7 < iMin) {
                                        mhbVar = arrayList.get(i7);
                                        byte[] bArrA210 = a(mhb.c(mhbVar.f18215a));
                                        System.arraycopy(bArrA210, 0, bArr3, length6, bArrA210.length);
                                        length8 = length6 + bArrA210.length;
                                        byte[] bytes6 = mhbVar.f18216a.getBytes("GBK");
                                        bArr3[length8] = (byte) bytes6.length;
                                        length8++;
                                        System.arraycopy(bytes6, 0, bArr3, length8, bytes6.length);
                                        length9 = length8 + bytes6.length;
                                        i8 = 1;
                                        i9 = mhbVar.f43306a;
                                        if (i9 <= 127) {
                                        }
                                        i9 = 0;
                                        bArr3[length9] = Byte.parseByte(String.valueOf(i9));
                                        int i410 = length9 + i8;
                                        if (z) {
                                            i10 = 0;
                                        } else {
                                            i10 = 0;
                                        }
                                        if (i10 > 65535) {
                                            i10 = 65535;
                                        }
                                        byte[] bArrA211 = i.a(i10, bArr7);
                                        System.arraycopy(bArrA211, 0, bArr3, i410, bArrA211.length);
                                        int length45 = i410 + bArrA211.length;
                                        byte[] bArrA212 = i.a(mhbVar.b, bArr7);
                                        System.arraycopy(bArrA212, 0, bArr3, length45, bArrA212.length);
                                        length6 = length45 + bArrA212.length;
                                    }
                                    b4 = 0;
                                    byte[] bArrA310 = i.a(Integer.parseInt(this.F), bArr7);
                                    System.arraycopy(bArrA310, 0, bArr3, length6, bArrA310.length);
                                    length7 = length6 + bArrA310.length;
                                }
                                bArr3[length7] = b4;
                                i11 = length7 + 1;
                                bytes = this.G.getBytes("GBK");
                                if (bytes.length > 127) {
                                    bytes = null;
                                }
                                if (bytes == null) {
                                    bArr3[i11] = 0;
                                    length10 = i11 + 1;
                                } else {
                                    bArr3[i11] = (byte) bytes.length;
                                    int i411 = i11 + 1;
                                    System.arraycopy(bytes, 0, bArr3, i411, bytes.length);
                                    length10 = i411 + bytes.length;
                                }
                                bArrA = new byte[]{0, 0};
                                zIsEmpty = TextUtils.isEmpty(this.J);
                                if (!zIsEmpty) {
                                    bArrA = i.a(this.J.length(), bArr7);
                                }
                                System.arraycopy(bArrA, 0, bArr3, length10, 2);
                                length11 = length10 + 2;
                                if (!zIsEmpty) {
                                    byte[] bytes7 = this.J.getBytes("GBK");
                                    System.arraycopy(bytes7, 0, bArr3, length11, bytes7.length);
                                    length11 += bytes7.length;
                                }
                                i12 = 2;
                                System.arraycopy(i.a(0, bArr7), 0, bArr3, length11, i12);
                                int i412 = length11 + i12;
                                byte[] bArr19 = new byte[i12];
                                // fill-array-data instruction
                                bArr19[0] = 0;
                                bArr19[1] = 0;
                                System.arraycopy(bArr19, 0, bArr3, i412, i12);
                                int i413 = i412 + i12;
                                bArr5 = this.H;
                                if (bArr5 != null) {
                                    length12 = bArr5.length;
                                } else {
                                    length12 = 0;
                                }
                                byte[] bArrA311 = i.a(length12, (byte[]) null);
                                System.arraycopy(bArrA311, 0, bArr3, i413, bArrA311.length);
                                length13 = i413 + bArrA311.length;
                                if (length12 > 0) {
                                    byte[] bArr110 = this.H;
                                    System.arraycopy(bArr110, 0, bArr3, length13, bArr110.length);
                                    length13 += this.H.length;
                                }
                                if (Double.valueOf(com.autonavi.aps.amapapi.utils.b.f26202a).doubleValue() >= 5.0d) {
                                    list2 = this.T;
                                    if (list2 != null) {
                                        size3 = list2.size();
                                    } else {
                                        size3 = 0;
                                    }
                                    bArr3[length13] = (byte) size3;
                                    i13 = length13 + 1;
                                    byte[] bArr111 = new byte[i13];
                                    System.arraycopy(bArr3, 0, bArr111, 0, i13);
                                    if (size3 > 0) {
                                        length14 = i13;
                                        while (r0.hasNext()) {
                                            i14 = dVar2.l;
                                            if (i14 != 1) {
                                                b5 = (byte) i14;
                                                if (dVar2.n) {
                                                    b5 = (byte) (b5 | 8);
                                                }
                                                bArr3[length14] = b5;
                                                int i414 = length14 + 1;
                                                byte[] bArrA312 = i.a(dVar2.c, bArr7);
                                                System.arraycopy(bArrA312, 0, bArr3, i414, bArrA312.length);
                                                length15 = i414 + bArrA312.length;
                                                byte[] bArrB14 = i.b(dVar2.d, bArr4);
                                                System.arraycopy(bArrB14, 0, bArr3, length15, bArrB14.length);
                                                length16 = bArrB14.length;
                                                length14 = length15 + length16;
                                            } else {
                                                b5 = (byte) i14;
                                                if (dVar2.n) {
                                                    b5 = (byte) (b5 | 8);
                                                }
                                                bArr3[length14] = b5;
                                                int i415 = length14 + 1;
                                                byte[] bArrA313 = i.a(dVar2.c, bArr7);
                                                System.arraycopy(bArrA313, 0, bArr3, i415, bArrA313.length);
                                                length15 = i415 + bArrA313.length;
                                                byte[] bArrB15 = i.b(dVar2.d, bArr4);
                                                System.arraycopy(bArrB15, 0, bArr3, length15, bArrB15.length);
                                                length16 = bArrB15.length;
                                                length14 = length15 + length16;
                                            }
                                            byte[] bArrA314 = i.a((short) ((i.b() - dVar2.t) / 1000), bArr7);
                                            System.arraycopy(bArrA314, 0, bArr3, length14, bArrA314.length);
                                            length14 += bArrA314.length;
                                        }
                                        i13 = length14;
                                    }
                                    length13 = a(this.M, bArr3, i13);
                                }
                                if (Double.valueOf(com.autonavi.aps.amapapi.utils.b.f26202a).doubleValue() >= 5.2d) {
                                    list = this.S;
                                    if (list == null) {
                                        size2 = 0;
                                    } else {
                                        size2 = list.size();
                                    }
                                    bArr3[length13] = (byte) size2;
                                    length13++;
                                    if (size2 > 0) {
                                        while (r0.hasNext()) {
                                            iCurrentTimeMillis = ((int) (System.currentTimeMillis() - fVar.d)) / 1000;
                                            if (iCurrentTimeMillis > 65535) {
                                                iCurrentTimeMillis = 65535;
                                            }
                                            System.arraycopy(i.a(iCurrentTimeMillis, bArr7), 0, bArr3, length13, 2);
                                            int i416 = length13 + 2;
                                            System.arraycopy(i.b((int) Math.round(fVar.c * 1.0E7d), bArr4), 0, bArr3, i416, 4);
                                            int i417 = i416 + 4;
                                            System.arraycopy(i.b((int) Math.round(fVar.b * 1.0E7d), bArr4), 0, bArr3, i417, 4);
                                            int i418 = i417 + 4;
                                            f = fVar.e;
                                            if (f > 65535.0f) {
                                                f = 65535.0f;
                                            }
                                            System.arraycopy(i.a((int) f, bArr7), 0, bArr3, i418, 2);
                                            int i51 = i418 + 2;
                                            System.arraycopy(i.a((short) ((fVar.h | (fVar.f26186a << 13) | (fVar.g << 6)) & 65535), bArr7), 0, bArr3, i51, 2);
                                            length13 = i51 + 2;
                                        }
                                    }
                                }
                                if (Double.valueOf(com.autonavi.aps.amapapi.utils.b.f26202a).doubleValue() >= 5.3d) {
                                    length13 = a(this.N, bArr3, length13);
                                }
                                byte[] bArr112 = new byte[length13];
                                System.arraycopy(bArr3, 0, bArr112, 0, length13);
                                CRC32 crc33 = new CRC32();
                                crc33.update(bArr112);
                                byte[] bArrA315 = i.a(crc33.getValue());
                                byte[] bArr113 = new byte[length13 + 8];
                                System.arraycopy(bArr112, 0, bArr113, 0, length13);
                                System.arraycopy(bArrA315, 0, bArr113, length13, 8);
                                return bArr113;
                            }
                            bArr8 = bArr8;
                            System.arraycopy(bArr19, 0, bArr3, i412, i12);
                        } catch (Throwable unused5) {
                        }
                        System.arraycopy(bArrA, 0, bArr3, length10, 2);
                        length11 = length10 + 2;
                        if (!zIsEmpty) {
                            byte[] bytes8 = this.J.getBytes("GBK");
                            System.arraycopy(bytes8, 0, bArr3, length11, bytes8.length);
                            length11 += bytes8.length;
                        }
                        i12 = 2;
                    } catch (Throwable unused6) {
                        i12 = 2;
                        length11 = length10 + i12;
                    }
                    zIsEmpty = TextUtils.isEmpty(this.J);
                    if (!zIsEmpty) {
                        bArrA = i.a(this.J.length(), bArr7);
                    }
                } catch (Throwable unused7) {
                    i12 = 2;
                }
                bytes = this.G.getBytes("GBK");
                if (bytes.length > 127) {
                    bytes = null;
                }
                if (bytes == null) {
                    bArr3[i11] = 0;
                    length10 = i11 + 1;
                } else {
                    bArr3[i11] = (byte) bytes.length;
                    int i419 = i11 + 1;
                    System.arraycopy(bytes, 0, bArr3, i419, bytes.length);
                    length10 = i419 + bytes.length;
                }
            } catch (Throwable unused8) {
                bArr3[i11] = 0;
            }
            System.arraycopy(i.a(0, bArr7), 0, bArr3, length11, i12);
        } catch (Throwable unused9) {
        }
        bArr = bArr11;
        str = this.C;
        if (str == null) {
            bArr[length20] = 0;
            i6 = length20 + 1;
        } else {
            bArr[length20] = 0;
            i6 = length20 + 1;
        }
        ArrayList<com.autonavi.aps.amapapi.restruct.d> arrayList4 = this.B;
        int size6 = arrayList4.size();
        int i213 = 5;
        int i214 = 3;
        if ((this.z & 4) == 4) {
            bArr3 = bArr;
            bArr4 = bArr8;
            bArr3[i6] = 0;
            b = 1;
            length4 = i6 + 1;
        } else {
            bArr3 = bArr;
            bArr4 = bArr8;
            bArr3[i6] = 0;
            b = 1;
            length4 = i6 + 1;
        }
        if (TextUtils.isEmpty(this.D)) {
            b2 = b;
            b3 = 0;
            bArr3[length4] = 0;
            length5 = length4 + 1;
        } else {
            b2 = b;
            b3 = 0;
            bArr3[length4] = 0;
            length5 = length4 + 1;
        }
        arrayList = this.E;
        iMin = Math.min(arrayList.size(), 25);
        if (iMin == 0) {
            bArr3[length5] = b3;
            length7 = length5 + b2;
            b4 = 0;
        } else {
            bArr3[length5] = (byte) iMin;
            length6 = length5 + b2;
            if (i.c() >= 17) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
            }
            while (i7 < iMin) {
                mhbVar = arrayList.get(i7);
                byte[] bArrA213 = a(mhb.c(mhbVar.f18215a));
                System.arraycopy(bArrA213, 0, bArr3, length6, bArrA213.length);
                length8 = length6 + bArrA213.length;
                byte[] bytes9 = mhbVar.f18216a.getBytes("GBK");
                bArr3[length8] = (byte) bytes9.length;
                length8++;
                System.arraycopy(bytes9, 0, bArr3, length8, bytes9.length);
                length9 = length8 + bytes9.length;
                i8 = 1;
                i9 = mhbVar.f43306a;
                if (i9 <= 127) {
                }
                i9 = 0;
                bArr3[length9] = Byte.parseByte(String.valueOf(i9));
                int i4110 = length9 + i8;
                if (z) {
                    i10 = 0;
                } else {
                    i10 = 0;
                }
                if (i10 > 65535) {
                    i10 = 65535;
                }
                byte[] bArrA214 = i.a(i10, bArr7);
                System.arraycopy(bArrA214, 0, bArr3, i4110, bArrA214.length);
                int length46 = i4110 + bArrA214.length;
                byte[] bArrA215 = i.a(mhbVar.b, bArr7);
                System.arraycopy(bArrA215, 0, bArr3, length46, bArrA215.length);
                length6 = length46 + bArrA215.length;
            }
            b4 = 0;
            byte[] bArrA316 = i.a(Integer.parseInt(this.F), bArr7);
            System.arraycopy(bArrA316, 0, bArr3, length6, bArrA316.length);
            length7 = length6 + bArrA316.length;
        }
        bArr3[length7] = b4;
        i11 = length7 + 1;
        bArrA = new byte[]{0, 0};
        int i4111 = length11 + i12;
        byte[] bArr114 = new byte[i12];
        // fill-array-data instruction
        bArr114[0] = 0;
        bArr114[1] = 0;
        int i4112 = i4111 + i12;
        bArr5 = this.H;
        if (bArr5 != null) {
            length12 = bArr5.length;
        } else {
            length12 = 0;
        }
        byte[] bArrA317 = i.a(length12, (byte[]) null);
        System.arraycopy(bArrA317, 0, bArr3, i4112, bArrA317.length);
        length13 = i4112 + bArrA317.length;
        if (length12 > 0) {
            byte[] bArr115 = this.H;
            System.arraycopy(bArr115, 0, bArr3, length13, bArr115.length);
            length13 += this.H.length;
        }
        if (Double.valueOf(com.autonavi.aps.amapapi.utils.b.f26202a).doubleValue() >= 5.0d) {
            list2 = this.T;
            if (list2 != null) {
                size3 = list2.size();
            } else {
                size3 = 0;
            }
            bArr3[length13] = (byte) size3;
            i13 = length13 + 1;
            byte[] bArr116 = new byte[i13];
            System.arraycopy(bArr3, 0, bArr116, 0, i13);
            if (size3 > 0) {
                length14 = i13;
                while (r0.hasNext()) {
                    i14 = dVar2.l;
                    if (i14 != 1) {
                        b5 = (byte) i14;
                        if (dVar2.n) {
                            b5 = (byte) (b5 | 8);
                        }
                        bArr3[length14] = b5;
                        int i4113 = length14 + 1;
                        byte[] bArrA318 = i.a(dVar2.c, bArr7);
                        System.arraycopy(bArrA318, 0, bArr3, i4113, bArrA318.length);
                        length15 = i4113 + bArrA318.length;
                        byte[] bArrB16 = i.b(dVar2.d, bArr4);
                        System.arraycopy(bArrB16, 0, bArr3, length15, bArrB16.length);
                        length16 = bArrB16.length;
                        length14 = length15 + length16;
                    } else {
                        b5 = (byte) i14;
                        if (dVar2.n) {
                            b5 = (byte) (b5 | 8);
                        }
                        bArr3[length14] = b5;
                        int i4114 = length14 + 1;
                        byte[] bArrA319 = i.a(dVar2.c, bArr7);
                        System.arraycopy(bArrA319, 0, bArr3, i4114, bArrA319.length);
                        length15 = i4114 + bArrA319.length;
                        byte[] bArrB17 = i.b(dVar2.d, bArr4);
                        System.arraycopy(bArrB17, 0, bArr3, length15, bArrB17.length);
                        length16 = bArrB17.length;
                        length14 = length15 + length16;
                    }
                    byte[] bArrA3110 = i.a((short) ((i.b() - dVar2.t) / 1000), bArr7);
                    System.arraycopy(bArrA3110, 0, bArr3, length14, bArrA3110.length);
                    length14 += bArrA3110.length;
                }
                i13 = length14;
            }
            length13 = a(this.M, bArr3, i13);
        }
        if (Double.valueOf(com.autonavi.aps.amapapi.utils.b.f26202a).doubleValue() >= 5.2d) {
            list = this.S;
            if (list == null) {
                size2 = 0;
            } else {
                size2 = list.size();
            }
            bArr3[length13] = (byte) size2;
            length13++;
            if (size2 > 0) {
                while (r0.hasNext()) {
                    iCurrentTimeMillis = ((int) (System.currentTimeMillis() - fVar.d)) / 1000;
                    if (iCurrentTimeMillis > 65535) {
                        iCurrentTimeMillis = 65535;
                    }
                    System.arraycopy(i.a(iCurrentTimeMillis, bArr7), 0, bArr3, length13, 2);
                    int i4115 = length13 + 2;
                    System.arraycopy(i.b((int) Math.round(fVar.c * 1.0E7d), bArr4), 0, bArr3, i4115, 4);
                    int i4116 = i4115 + 4;
                    System.arraycopy(i.b((int) Math.round(fVar.b * 1.0E7d), bArr4), 0, bArr3, i4116, 4);
                    int i4117 = i4116 + 4;
                    f = fVar.e;
                    if (f > 65535.0f) {
                        f = 65535.0f;
                    }
                    System.arraycopy(i.a((int) f, bArr7), 0, bArr3, i4117, 2);
                    int i52 = i4117 + 2;
                    System.arraycopy(i.a((short) ((fVar.h | (fVar.f26186a << 13) | (fVar.g << 6)) & 65535), bArr7), 0, bArr3, i52, 2);
                    length13 = i52 + 2;
                }
            }
        }
        if (Double.valueOf(com.autonavi.aps.amapapi.utils.b.f26202a).doubleValue() >= 5.3d) {
            length13 = a(this.N, bArr3, length13);
        }
        byte[] bArr117 = new byte[length13];
        System.arraycopy(bArr3, 0, bArr117, 0, length13);
        CRC32 crc34 = new CRC32();
        crc34.update(bArr117);
        byte[] bArrA3111 = i.a(crc34.getValue());
        byte[] bArr118 = new byte[length13 + 8];
        System.arraycopy(bArr117, 0, bArr118, 0, length13);
        System.arraycopy(bArrA3111, 0, bArr118, length13, 8);
        return bArr118;
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000f A[Catch: all -> 0x003e, TryCatch #0 {all -> 0x003e, blocks: (B:4:0x000c, B:10:0x001c, B:12:0x001f, B:14:0x0028, B:15:0x0030, B:6:0x000f, B:8:0x0014), top: B:20:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0014 A[Catch: all -> 0x003e, LOOP:0: B:7:0x0012->B:8:0x0014, LOOP_END, TryCatch #0 {all -> 0x003e, blocks: (B:4:0x000c, B:10:0x001c, B:12:0x001f, B:14:0x0028, B:15:0x0030, B:6:0x000f, B:8:0x0014), top: B:20:0x000c }] */
    private byte[] a(String str) {
        int i;
        String[] strArrSplit = str.split(u15.f19942b);
        byte[] bArr = new byte[6];
        if (strArrSplit != null) {
            try {
                if (strArrSplit.length != 6) {
                    strArrSplit = new String[6];
                    for (i = 0; i < 6; i++) {
                        strArrSplit[i] = "0";
                    }
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "Req", "getMacBa ".concat(str));
                return a(com.alipay.sdk.m.y.d.f25528a);
            }
        } else {
            strArrSplit = new String[6];
            while (i < 6) {
                strArrSplit[i] = "0";
            }
        }
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            if (strArrSplit[i2].length() > 2) {
                strArrSplit[i2] = strArrSplit[i2].substring(0, 2);
            }
            bArr[i2] = (byte) Integer.parseInt(strArrSplit[i2], 16);
        }
        return bArr;
    }

    public final void a(Context context, boolean z, boolean z2, com.autonavi.aps.amapapi.restruct.e eVar, com.autonavi.aps.amapapi.restruct.i iVar, ConnectivityManager connectivityManager, String str, g gVar) {
        String str2;
        String str3;
        StringBuilder sb;
        NetworkInfo activeNetworkInfo;
        String strA;
        String str4;
        ArrayList<mhb> arrayList;
        int length;
        String strJ = j4b.j(context);
        int iD = i.d();
        this.J = str;
        this.S = null;
        if (z2) {
            str2 = "api_serverSDK_130905";
            str3 = "S128DF1572465B890OE3F7A13167KLEI";
        } else {
            str2 = "UC_nlp_20131029";
            str3 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
        }
        String str5 = str3;
        String str6 = str2;
        StringBuilder sb2 = new StringBuilder();
        int iG = eVar.g();
        int iH = eVar.h();
        TelephonyManager telephonyManagerI = eVar.i();
        ArrayList<com.autonavi.aps.amapapi.restruct.d> arrayListC = eVar.c();
        ArrayList<com.autonavi.aps.amapapi.restruct.d> arrayListD = eVar.d();
        ArrayList<mhb> arrayListE = iVar.e();
        String str7 = "1";
        String str8 = iH == 2 ? "1" : "0";
        if (telephonyManagerI != null) {
            if (TextUtils.isEmpty(com.autonavi.aps.amapapi.utils.b.g)) {
                try {
                    com.autonavi.aps.amapapi.utils.b.g = fj.L();
                } catch (Throwable th) {
                    com.autonavi.aps.amapapi.utils.b.a(th, "Aps", "getApsReq part4");
                }
            }
            sb = sb2;
            if (TextUtils.isEmpty(com.autonavi.aps.amapapi.utils.b.g) && Build.VERSION.SDK_INT < 29) {
                com.autonavi.aps.amapapi.utils.b.g = "888888888888888";
            }
            if (TextUtils.isEmpty(com.autonavi.aps.amapapi.utils.b.h)) {
                try {
                    com.autonavi.aps.amapapi.utils.b.h = fj.h0(context);
                } catch (SecurityException unused) {
                } catch (Throwable th2) {
                    com.autonavi.aps.amapapi.utils.b.a(th2, "Aps", "getApsReq part2");
                }
            }
            if (TextUtils.isEmpty(com.autonavi.aps.amapapi.utils.b.h) && Build.VERSION.SDK_INT < 29) {
                com.autonavi.aps.amapapi.utils.b.h = "888888888888888";
            }
        } else {
            sb = sb2;
            str7 = "1";
        }
        try {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th3) {
            com.autonavi.aps.amapapi.utils.b.a(th3, "Aps", "getApsReq part");
            activeNetworkInfo = null;
        }
        boolean zA = iVar.a(connectivityManager);
        if (i.a(activeNetworkInfo) != -1) {
            strA = i.a(context, telephonyManagerI);
            str4 = zA ? "2" : str7;
        } else {
            strA = "";
            str4 = strA;
        }
        if ((iG & 4) == 4 && !arrayListD.isEmpty()) {
            this.B.clear();
            this.B.addAll(arrayListD);
        } else {
            this.B.clear();
        }
        this.A.clear();
        this.A.addAll(arrayListC);
        StringBuilder sb3 = new StringBuilder();
        if (iVar.k()) {
            if (zA) {
                WifiInfo wifiInfoM = iVar.m();
                if (com.autonavi.aps.amapapi.restruct.i.a(wifiInfoM)) {
                    sb3.append(wifiInfoM.getBSSID());
                    sb3.append(",");
                    int rssi = wifiInfoM.getRssi();
                    if (rssi < -128 || rssi > 127) {
                        rssi = 0;
                    }
                    sb3.append(rssi);
                    sb3.append(",");
                    String ssid = wifiInfoM.getSSID();
                    try {
                        length = wifiInfoM.getSSID().getBytes("UTF-8").length;
                    } catch (Exception unused2) {
                        length = 32;
                    }
                    if (length >= 32) {
                        ssid = "unkwn";
                    }
                    sb3.append(ssid.replace("*", Consts.DOT));
                }
            }
            if (arrayListE != null && (arrayList = this.E) != null) {
                arrayList.clear();
                this.E.addAll(arrayListE);
            }
        } else {
            iVar.g();
            ArrayList<mhb> arrayList2 = this.E;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
        }
        this.b = (short) 0;
        if (!z) {
            this.b = (short) (2 | 0);
        }
        this.c = str6;
        this.d = str5;
        this.f = Build.MODEL;
        this.g = "android" + Build.VERSION.RELEASE;
        this.h = i.b(context);
        this.i = str8;
        this.j = "0";
        this.k = "0";
        this.l = "0";
        this.m = "0";
        this.n = "0";
        this.o = strJ;
        this.p = com.autonavi.aps.amapapi.utils.b.g;
        this.q = com.autonavi.aps.amapapi.utils.b.h;
        this.s = String.valueOf(iD);
        this.t = i.i(context);
        this.v = "6.1.0";
        this.w = null;
        this.u = "";
        this.x = strA;
        this.y = str4;
        this.z = iG;
        this.C = eVar.l();
        this.F = com.autonavi.aps.amapapi.restruct.i.p();
        this.D = sb3.toString();
        this.O = (int) ((i.b() - iVar.q()) / 1000);
        try {
            if (TextUtils.isEmpty(I)) {
                I = fj.N(context);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (TextUtils.isEmpty(K)) {
                K = fj.t(context);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (TextUtils.isEmpty(this.M)) {
                this.M = fj.Q(context);
            }
        } catch (Throwable unused5) {
        }
        try {
            if (TextUtils.isEmpty(this.N)) {
                this.N = fj.M(context);
            }
        } catch (Throwable unused6) {
        }
        try {
            this.S = gVar.a(this.B, this.E);
            a(this.A, this.B);
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
        sb.delete(0, sb.length());
        sb3.delete(0, sb3.length());
    }

    private void a(ArrayList<com.autonavi.aps.amapapi.restruct.d> arrayList, ArrayList<com.autonavi.aps.amapapi.restruct.d> arrayList2) {
        if (arrayList2 != null && arrayList2.size() > 0) {
            for (com.autonavi.aps.amapapi.restruct.d dVar : arrayList2) {
                if (dVar.r && dVar.n) {
                    a(dVar, this.T);
                    return;
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        a(arrayList.get(0), this.T);
    }

    private static void a(com.autonavi.aps.amapapi.restruct.d dVar, List<com.autonavi.aps.amapapi.restruct.d> list) {
        if (dVar == null || list == null) {
            return;
        }
        int size = list.size();
        if (size == 0) {
            list.add(dVar);
            return;
        }
        int i = -1;
        long jMin = Long.MAX_VALUE;
        int i2 = 0;
        int i3 = -1;
        while (true) {
            if (i2 >= size) {
                i = i3;
                break;
            }
            com.autonavi.aps.amapapi.restruct.d dVar2 = list.get(i2);
            if (dVar.c() != null && dVar.c().equals(dVar2.c())) {
                int i4 = dVar.s;
                if (i4 == dVar2.s) {
                    break;
                }
                dVar2.t = dVar.t;
                dVar2.s = i4;
                break;
            }
            jMin = Math.min(jMin, dVar2.t);
            if (jMin == dVar2.t) {
                i3 = i2;
            }
            i2++;
        }
        if (i >= 0) {
            if (size < 3) {
                list.add(dVar);
            } else {
                if (dVar.t <= jMin || i >= size) {
                    return;
                }
                list.remove(i);
                list.add(dVar);
            }
        }
    }

    private static int a(String str, byte[] bArr, int i) {
        try {
            if (TextUtils.isEmpty(str)) {
                bArr[i] = 0;
                return i + 1;
            }
            byte[] bytes = str.getBytes("GBK");
            int length = bytes.length;
            if (length > 127) {
                length = 127;
            }
            bArr[i] = (byte) length;
            int i2 = i + 1;
            System.arraycopy(bytes, 0, bArr, i2, length);
            return i2 + length;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "Req", "copyContentWithByteLen");
            bArr[i] = 0;
        }
    }
}
