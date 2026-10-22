package com.byazt.zk;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.byazt.dg.z;
import com.byazt.ga.gt;
import com.byazt.jx.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zj.adlib.b85;
import com.zj.adlib.v39;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 909, 66})
public class t extends ve {
    public final Paint da;
    public com.byazt.dg.c<Float, Float> gr;
    public com.byazt.dg.c<Integer, Integer> gt;
    public com.byazt.dg.c<Float, Float> gu;
    public String h;
    public final Matrix i;
    public final z m;
    public com.byazt.dg.c<Typeface, Typeface> md;
    public com.byazt.dg.c<Integer, Integer> my;
    public final com.byazt.ga.x nu;
    public com.byazt.dg.c<Float, Float> p;
    public com.byazt.dg.c<Integer, Integer> qy;
    public final com.byazt.ga.a rh;
    public com.byazt.dg.c<Integer, Integer> rl;
    public final Paint sl;
    public final StringBuilder sp;
    public final Map<com.byazt.nb.uj, List<com.byazt.zy.uj>> t;
    public final LongSparseArray<String> u;
    public final RectF x;
    public final List<c> yp;
    public com.byazt.dg.c<Float, Float> yv;
    public int z;
    public com.byazt.dg.c<Float, Float> zm;

    /* JADX INFO: renamed from: com.byazt.zk.t$3, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 909, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION})
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[com.byazt.nb.tt.c.values().length];
            c = iArr;
            try {
                iArr[com.byazt.nb.tt.c.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[com.byazt.nb.tt.c.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[com.byazt.nb.tt.c.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 909, 125})
    public static class c {
        public String c;
        public float tt;

        private c() {
            this.c = "";
            this.tt = 0.0f;
        }

        public void c(String str, float f) {
            this.c = str;
            this.tt = f;
        }
    }

    public t(com.byazt.ga.x xVar, x xVar2) {
        com.byazt.kd.tt ttVar;
        com.byazt.kd.tt ttVar2;
        com.byazt.kd.c cVar;
        com.byazt.kd.c cVar2;
        super(xVar, xVar2);
        this.sp = new StringBuilder(2);
        this.x = new RectF();
        this.i = new Matrix();
        int i = 1;
        this.da = new Paint(i) { // from class: com.byazt.zk.t.1
            {
                setStyle(Paint.Style.FILL);
            }
        };
        this.sl = new Paint(i) { // from class: com.byazt.zk.t.2
            {
                setStyle(Paint.Style.STROKE);
            }
        };
        this.t = new HashMap();
        this.u = new LongSparseArray<>();
        this.yp = new ArrayList();
        this.z = 0;
        this.nu = xVar;
        this.rh = xVar2.c();
        z zVarC = xVar2.my().c();
        this.m = zVarC;
        zVarC.c(this);
        c(zVarC);
        com.byazt.kd.sl slVarGt = xVar2.gt();
        if (slVarGt != null && (cVar2 = slVarGt.c) != null) {
            com.byazt.dg.c<Integer, Integer> cVarC = cVar2.c();
            this.my = cVarC;
            cVarC.c(this);
            c(this.my);
        }
        if (slVarGt != null && (cVar = slVarGt.tt) != null) {
            com.byazt.dg.c<Integer, Integer> cVarC2 = cVar.c();
            this.rl = cVarC2;
            cVarC2.c(this);
            c(this.rl);
        }
        if (slVarGt != null && (ttVar2 = slVarGt.ve) != null) {
            com.byazt.dg.c<Float, Float> cVarC3 = ttVar2.c();
            this.gu = cVarC3;
            cVarC3.c(this);
            c(this.gu);
        }
        if (slVarGt == null || (ttVar = slVarGt.uj) == null) {
            return;
        }
        com.byazt.dg.c<Float, Float> cVarC4 = ttVar.c();
        this.zm = cVarC4;
        cVarC4.c(this);
        c(this.zm);
    }

    private String ve(String str, float f, float f2, com.byazt.nb.ve veVar, float f3, float f4, boolean z) {
        if (str.length() <= 1) {
            return str + v39.CHARACTER_ELLIPSIZE;
        }
        float f5 = f / 2.0f;
        float fC = 0.0f;
        float f6 = 0.0f;
        int i = 0;
        int i2 = 0;
        while (i < str.length() / 2) {
            float fC2 = c(str.charAt(i), veVar, f3, f4, z) + f6;
            if (fC2 > f5) {
                break;
            }
            i2 = i + 1;
            i = i2;
            f6 = fC2;
        }
        float f7 = f - f6;
        int length = str.length();
        for (int length2 = str.length() - 1; length2 >= str.length() / 2; length2--) {
            fC += c(str.charAt(length2), veVar, f3, f4, z);
            if (fC > f7) {
                break;
            }
            length = length2;
        }
        if (i2 == 0 || length == str.length()) {
            return c(str, f, f2, veVar, f3, f4, z);
        }
        return str.substring(0, i2) + v39.CHARACTER_ELLIPSIZE + str.substring(length);
    }

    private void yp() {
        this.z = 0;
    }

    private c z() {
        if (this.z >= this.yp.size()) {
            this.yp.add(new c());
        }
        List<c> list = this.yp;
        int i = this.z;
        this.z = i + 1;
        return list.get(i);
    }

    @Override // com.byazt.zk.ve, com.byazt.zy.n
    public void c(RectF rectF, Matrix matrix, boolean z) {
        super.c(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.rh.uj().width(), this.rh.uj().height());
    }

    @Override // com.byazt.zk.ve
    public void tt(Canvas canvas, Matrix matrix, int i) {
        super.tt(canvas, matrix, i);
        com.byazt.nb.tt ttVarSp = this.m.sp();
        com.byazt.nb.ve veVar = this.rh.m().get(ttVarSp.tt);
        if (veVar == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        c(ttVarSp, matrix);
        if (this.nu.yv()) {
            c(ttVarSp, matrix, veVar, canvas);
        } else {
            c(ttVarSp, veVar, canvas);
        }
        canvas.restore();
    }

    private void c(com.byazt.nb.tt ttVar, Matrix matrix) {
        com.byazt.dg.c<Integer, Integer> cVar = this.gt;
        if (cVar != null) {
            this.da.setColor(cVar.sp().intValue());
        } else {
            com.byazt.dg.c<Integer, Integer> cVar2 = this.my;
            if (cVar2 != null) {
                this.da.setColor(cVar2.sp().intValue());
            } else {
                this.da.setColor(ttVar.x);
            }
        }
        com.byazt.dg.c<Integer, Integer> cVar3 = this.qy;
        if (cVar3 != null) {
            this.sl.setColor(cVar3.sp().intValue());
        } else {
            com.byazt.dg.c<Integer, Integer> cVar4 = this.rl;
            if (cVar4 != null) {
                this.sl.setColor(cVar4.sp().intValue());
            } else {
                this.sl.setColor(ttVar.i);
            }
        }
        int iIntValue = ((this.uj.c() == null ? 100 : this.uj.c().sp().intValue()) * 255) / 100;
        this.da.setAlpha(iIntValue);
        this.sl.setAlpha(iIntValue);
        com.byazt.dg.c<Float, Float> cVar5 = this.gr;
        if (cVar5 != null) {
            this.sl.setStrokeWidth(cVar5.sp().floatValue());
            return;
        }
        com.byazt.dg.c<Float, Float> cVar6 = this.gu;
        if (cVar6 != null) {
            this.sl.setStrokeWidth(cVar6.sp().floatValue());
        } else {
            this.sl.setStrokeWidth(ttVar.da * com.byazt.kk.da.c());
        }
    }

    private List<String> tt(String str) {
        return Arrays.asList(str.replaceAll("\r\n", b85.b).replaceAll("\u0003", b85.b).replaceAll("\n", b85.b).split(b85.b));
    }

    private String tt(String str, float f, float f2, com.byazt.nb.ve veVar, float f3, float f4, boolean z) {
        int i;
        int length = str.length();
        int length2 = str.length() - 1;
        float fC = 0.0f;
        while (true) {
            int i2 = length2;
            i = length;
            length = i2;
            if (length < 0) {
                break;
            }
            fC += c(str.charAt(length), veVar, f3, f4, z);
            if (fC > f) {
                break;
            }
            length2 = length - 1;
        }
        return v39.CHARACTER_ELLIPSIZE + str.substring(i);
    }

    private boolean tt(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 8 || Character.getType(i) == 19;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:42:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:43:0x00cc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:49:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:52:0x00eb A[LOOP:0: B:51:0x00e9->B:52:0x00eb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:55:0x012c  */
    /* JADX WARN: Code duplicated, block: B:56:0x012e  */
    /* JADX WARN: Code duplicated, block: B:60:0x0147 A[LOOP:1: B:58:0x0141->B:60:0x0147, LOOP_END] */
    private void c(com.byazt.nb.tt ttVar, Matrix matrix, com.byazt.nb.ve veVar, Canvas canvas) {
        float fFloatValue;
        gt gtVarZm;
        float fFloatValue2;
        float f;
        PointF pointF;
        int iMin;
        int i;
        int i2;
        int i3;
        PointF pointF2;
        float f2;
        ArrayList arrayList;
        int i4;
        ArrayList arrayList2;
        int i5;
        int i6;
        List<c> listC;
        int i7;
        gt gtVarZm2;
        String strVe;
        yp();
        com.byazt.dg.c<Float, Float> cVar = this.p;
        if (cVar != null) {
            fFloatValue = cVar.sp().floatValue();
        } else if (!TextUtils.isEmpty(ttVar.m) && (gtVarZm = this.nu.zm()) != null) {
            try {
                fFloatValue = Float.parseFloat(gtVarZm.ve(sl(), ttVar.m));
            } catch (NumberFormatException unused) {
                fFloatValue = ttVar.ve;
            }
        } else {
            fFloatValue = ttVar.ve;
        }
        float f3 = fFloatValue / 100.0f;
        float fC = com.byazt.kk.da.c(matrix);
        String str = this.h;
        if (TextUtils.isEmpty(str)) {
            str = ttVar.c;
            if (!TextUtils.isEmpty(ttVar.z) && (gtVarZm2 = this.nu.zm()) != null && (strVe = gtVarZm2.ve(sl(), ttVar.z)) != null) {
                str = strVe;
            }
        }
        List<String> listTt = tt(str);
        int size = listTt.size();
        float f4 = ttVar.n / 10.0f;
        com.byazt.dg.c<Float, Float> cVar2 = this.yv;
        if (cVar2 != null) {
            fFloatValue2 = cVar2.sp().floatValue();
        } else {
            com.byazt.dg.c<Float, Float> cVar3 = this.zm;
            if (cVar3 != null) {
                fFloatValue2 = cVar3.sp().floatValue();
            }
            f = f4;
            com.byazt.nb.n nVar = ttVar.yp;
            pointF = ttVar.u;
            if (pointF != null || pointF.y <= 0.0f) {
                iMin = Integer.MAX_VALUE;
            } else {
                float fC2 = com.byazt.kk.da.c();
                float f5 = ttVar.u.y;
                float f6 = ttVar.f28809a;
                float f7 = f6 * fC2;
                if (f7 > 0.0f) {
                    float f8 = f5 - ((f6 * 0.6f) * fC2);
                    if (f8 > 0.0f) {
                        iMin = ((int) (f8 / f7)) + 1;
                    } else {
                        iMin = Integer.MAX_VALUE;
                    }
                } else {
                    iMin = Integer.MAX_VALUE;
                }
            }
            i = nVar.c;
            if (i == 1) {
                i2 = 1;
            } else {
                if (i != 0) {
                    iMin = Math.min(i, iMin);
                }
                i2 = iMin;
            }
            i3 = nVar.tt;
            pointF2 = ttVar.u;
            if (pointF2 == null) {
                f2 = 0.0f;
            } else {
                f2 = pointF2.x;
            }
            arrayList = new ArrayList();
            i4 = 0;
            while (i4 < size) {
                ArrayList arrayList3 = arrayList;
                arrayList3.addAll(c(listTt.get(i4), f2, veVar, f3, f, true, Integer.MAX_VALUE, 0));
                i4++;
                arrayList = arrayList3;
                i2 = i2;
                i3 = i3;
                listTt = listTt;
            }
            arrayList2 = arrayList;
            i5 = i3;
            i6 = i2;
            if (arrayList2.size() <= i6) {
                listC = arrayList2;
            } else {
                listC = c((List<c>) arrayList2, i6, i5, f2, veVar, f3, f, true);
            }
            for (i7 = 0; i7 < listC.size(); i7++) {
                c cVar4 = listC.get(i7);
                canvas.save();
                c(canvas, ttVar, i7, cVar4.tt);
                c(cVar4.c, ttVar, veVar, canvas, fC, f3, f);
                canvas.restore();
            }
        }
        f4 += fFloatValue2;
        f = f4;
        com.byazt.nb.n nVar2 = ttVar.yp;
        pointF = ttVar.u;
        if (pointF != null) {
            iMin = Integer.MAX_VALUE;
        } else {
            iMin = Integer.MAX_VALUE;
        }
        i = nVar2.c;
        if (i == 1) {
            i2 = 1;
        } else {
            if (i != 0) {
                iMin = Math.min(i, iMin);
            }
            i2 = iMin;
        }
        i3 = nVar2.tt;
        pointF2 = ttVar.u;
        if (pointF2 == null) {
            f2 = 0.0f;
        } else {
            f2 = pointF2.x;
        }
        arrayList = new ArrayList();
        i4 = 0;
        while (i4 < size) {
            ArrayList arrayList4 = arrayList;
            arrayList4.addAll(c(listTt.get(i4), f2, veVar, f3, f, true, Integer.MAX_VALUE, 0));
            i4++;
            arrayList = arrayList4;
            i2 = i2;
            i3 = i3;
            listTt = listTt;
        }
        arrayList2 = arrayList;
        i5 = i3;
        i6 = i2;
        if (arrayList2.size() <= i6) {
            listC = arrayList2;
        } else {
            listC = c((List<c>) arrayList2, i6, i5, f2, veVar, f3, f, true);
        }
        while (i7 < listC.size()) {
            c cVar5 = listC.get(i7);
            canvas.save();
            c(canvas, ttVar, i7, cVar5.tt);
            c(cVar5.c, ttVar, veVar, canvas, fC, f3, f);
            canvas.restore();
        }
    }

    private void c(String str, com.byazt.nb.tt ttVar, com.byazt.nb.ve veVar, Canvas canvas, float f, float f2, float f3) {
        for (int i = 0; i < str.length(); i++) {
            com.byazt.nb.uj ujVar = this.rh.z().get(com.byazt.nb.uj.c(str.charAt(i), veVar.c(), veVar.ve()));
            if (ujVar != null) {
                c(ujVar, f2, ttVar, canvas);
                canvas.translate((((float) ujVar.tt()) * f2 * com.byazt.kk.da.c()) + f3, 0.0f);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:51:0x010d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0110  */
    /* JADX WARN: Code duplicated, block: B:55:0x011f A[LOOP:0: B:54:0x011d->B:55:0x011f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:58:0x015d  */
    /* JADX WARN: Code duplicated, block: B:59:0x015f  */
    /* JADX WARN: Code duplicated, block: B:63:0x0177 A[LOOP:1: B:61:0x0171->B:63:0x0177, LOOP_END] */
    private void c(com.byazt.nb.tt ttVar, com.byazt.nb.ve veVar, Canvas canvas) {
        float fFloatValue;
        float fFloatValue2;
        float fC;
        PointF pointF;
        int iMin;
        int i;
        int i2;
        List<String> listTt;
        int size;
        int i3;
        PointF pointF2;
        float f;
        ArrayList arrayList;
        int i4;
        ArrayList arrayList2;
        int i5;
        List<c> listC;
        int i6;
        yp();
        Typeface typefaceC = c(veVar);
        if (typefaceC == null) {
            return;
        }
        gt gtVarZm = this.nu.zm();
        String strVe = this.h;
        if (TextUtils.isEmpty(strVe)) {
            strVe = ttVar.c;
            if (gtVarZm != null) {
                if (!TextUtils.isEmpty(ttVar.z)) {
                    String strVe2 = gtVarZm.ve(sl(), ttVar.z);
                    if (strVe2 != null) {
                        strVe = strVe2;
                    }
                } else {
                    strVe = gtVarZm.ve(sl(), strVe);
                }
            }
        }
        this.da.setTypeface(typefaceC);
        com.byazt.dg.c<Float, Float> cVar = this.p;
        if (cVar != null) {
            fFloatValue = cVar.sp().floatValue();
        } else if (!TextUtils.isEmpty(ttVar.m) && gtVarZm != null) {
            try {
                fFloatValue = Float.parseFloat(gtVarZm.ve(sl(), ttVar.m));
            } catch (NumberFormatException unused) {
                fFloatValue = ttVar.ve;
            }
        } else {
            fFloatValue = ttVar.ve;
        }
        this.da.setTextSize(com.byazt.kk.da.c() * fFloatValue);
        this.sl.setTypeface(this.da.getTypeface());
        this.sl.setTextSize(this.da.getTextSize());
        float f2 = ttVar.n / 10.0f;
        com.byazt.dg.c<Float, Float> cVar2 = this.yv;
        if (cVar2 != null) {
            fFloatValue2 = cVar2.sp().floatValue();
        } else {
            com.byazt.dg.c<Float, Float> cVar3 = this.zm;
            if (cVar3 != null) {
                fFloatValue2 = cVar3.sp().floatValue();
            }
            fC = ((f2 * com.byazt.kk.da.c()) * fFloatValue) / 100.0f;
            com.byazt.nb.n nVar = ttVar.yp;
            pointF = ttVar.u;
            if (pointF != null || pointF.y <= 0.0f) {
                iMin = Integer.MAX_VALUE;
            } else {
                float fC2 = com.byazt.kk.da.c();
                float f3 = ttVar.u.y;
                float f4 = ttVar.f28809a;
                float f5 = f4 * fC2;
                if (f5 > 0.0f) {
                    float f6 = f3 - ((f4 * 0.6f) * fC2);
                    if (f6 > 0.0f) {
                        iMin = ((int) (f6 / f5)) + 1;
                    } else {
                        iMin = Integer.MAX_VALUE;
                    }
                } else {
                    iMin = Integer.MAX_VALUE;
                }
            }
            i = nVar.c;
            if (i == 1) {
                i2 = 1;
            } else {
                if (i != 0) {
                    iMin = Math.min(i, iMin);
                }
                i2 = iMin;
            }
            listTt = tt(strVe);
            i3 = nVar.tt;
            pointF2 = ttVar.u;
            if (pointF2 == null) {
                f = 0.0f;
            } else {
                f = pointF2.x;
            }
            arrayList = new ArrayList();
            i4 = 0;
            for (size = listTt.size(); i4 < size; size = size) {
                ArrayList arrayList3 = arrayList;
                arrayList3.addAll(c(listTt.get(i4), f, veVar, 0.0f, fC, false, Integer.MAX_VALUE, 0));
                i4++;
                arrayList = arrayList3;
                i3 = i3;
            }
            arrayList2 = arrayList;
            i5 = i3;
            if (arrayList2.size() <= i2) {
                listC = arrayList2;
            } else {
                listC = c((List<c>) arrayList2, i2, i5, f, veVar, 0.0f, fC, false);
            }
            for (i6 = 0; i6 < listC.size(); i6++) {
                c cVar4 = listC.get(i6);
                canvas.save();
                c(canvas, ttVar, i6, cVar4.tt);
                c(cVar4.c, ttVar, canvas, fC);
                canvas.restore();
            }
        }
        f2 += fFloatValue2;
        fC = ((f2 * com.byazt.kk.da.c()) * fFloatValue) / 100.0f;
        com.byazt.nb.n nVar2 = ttVar.yp;
        pointF = ttVar.u;
        if (pointF != null) {
            iMin = Integer.MAX_VALUE;
        } else {
            iMin = Integer.MAX_VALUE;
        }
        i = nVar2.c;
        if (i == 1) {
            i2 = 1;
        } else {
            if (i != 0) {
                iMin = Math.min(i, iMin);
            }
            i2 = iMin;
        }
        listTt = tt(strVe);
        i3 = nVar2.tt;
        pointF2 = ttVar.u;
        if (pointF2 == null) {
            f = 0.0f;
        } else {
            f = pointF2.x;
        }
        arrayList = new ArrayList();
        i4 = 0;
        while (i4 < size) {
            ArrayList arrayList4 = arrayList;
            arrayList4.addAll(c(listTt.get(i4), f, veVar, 0.0f, fC, false, Integer.MAX_VALUE, 0));
            i4++;
            arrayList = arrayList4;
            i3 = i3;
        }
        arrayList2 = arrayList;
        i5 = i3;
        if (arrayList2.size() <= i2) {
            listC = arrayList2;
        } else {
            listC = c((List<c>) arrayList2, i2, i5, f, veVar, 0.0f, fC, false);
        }
        while (i6 < listC.size()) {
            c cVar5 = listC.get(i6);
            canvas.save();
            c(canvas, ttVar, i6, cVar5.tt);
            c(cVar5.c, ttVar, canvas, fC);
            canvas.restore();
        }
    }

    private void c(Canvas canvas, com.byazt.nb.tt ttVar, int i, float f) {
        PointF pointF = ttVar.t;
        PointF pointF2 = ttVar.u;
        float fC = com.byazt.kk.da.c();
        float f2 = (i * ttVar.f28809a * fC) + (pointF == null ? 0.0f : (ttVar.f28809a * 0.6f * fC) + pointF.y);
        float f3 = pointF == null ? 0.0f : pointF.x;
        float f4 = pointF2 != null ? pointF2.x : 0.0f;
        int i2 = AnonymousClass3.c[ttVar.uj.ordinal()];
        if (i2 == 1) {
            canvas.translate(f3, f2);
        } else if (i2 == 2) {
            canvas.translate((f3 + f4) - f, f2);
        } else {
            if (i2 != 3) {
                return;
            }
            canvas.translate((f3 + (f4 / 2.0f)) - (f / 2.0f), f2);
        }
    }

    private Typeface c(com.byazt.nb.ve veVar) {
        Typeface typefaceSp;
        com.byazt.dg.c<Typeface, Typeface> cVar = this.md;
        if (cVar != null && (typefaceSp = cVar.sp()) != null) {
            return typefaceSp;
        }
        Typeface typefaceC = this.nu.c(veVar);
        return typefaceC != null ? typefaceC : veVar.uj();
    }

    private void c(String str, com.byazt.nb.tt ttVar, Canvas canvas, float f) {
        int length = 0;
        while (length < str.length()) {
            String strC = c(str, length);
            length += strC.length();
            c(strC, ttVar, canvas);
            canvas.translate(this.da.measureText(strC) + f, 0.0f);
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0127  */
    /* JADX WARN: Code duplicated, block: B:60:0x011e A[SYNTHETIC] */
    private List<c> c(String str, float f, com.byazt.nb.ve veVar, float f2, float f3, boolean z, int i, int i2) {
        float fMeasureText;
        float f4;
        int i3;
        int i4;
        int i5 = i;
        int i6 = this.z;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float fMeasureText2 = 0.0f;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        boolean z2 = false;
        while (i9 < str.length()) {
            char cCharAt = str.charAt(i9);
            if (z) {
                com.byazt.nb.uj ujVar = this.rh.z().get(com.byazt.nb.uj.c(cCharAt, veVar.c(), veVar.ve()));
                if (ujVar != null) {
                    fMeasureText = ((float) ujVar.tt()) * f2 * com.byazt.kk.da.c();
                } else {
                    f4 = f6;
                    i9 = i9;
                    i3 = i5;
                }
                i9++;
                i5 = i3;
                f6 = f4;
            } else {
                fMeasureText = this.da.measureText(str.substring(i9, i9 + 1));
            }
            float f7 = fMeasureText + f3;
            f4 = cCharAt == ' ' ? f7 : f6;
            float f8 = f5 + f7;
            int i10 = i7 + 1;
            boolean z3 = i10 >= i5;
            if (f <= 0.0f || f8 < f || cCharAt == ' ') {
                i9 = i9;
                i3 = i5;
                i8 = i8;
                f5 = f8;
            } else {
                if (z3) {
                    if (i2 == 3) {
                        String strC = c(str, i8, f, veVar, f2, f3, z);
                        if (strC != null) {
                            z().c(strC, f);
                            return this.yp.subList(i6, this.z);
                        }
                        i4 = i10;
                    } else {
                        if (!z2) {
                            z2 = true;
                            fMeasureText2 = z ? 3.0f * f7 : this.da.measureText(v39.CHARACTER_ELLIPSIZE) + (2.0f * f3);
                        }
                        i8 = i8;
                        i4 = i10;
                        String strC2 = c(str, i8, f, fMeasureText2, veVar, f2, f3, z, i2);
                        if (strC2 != null) {
                            z().c(strC2, f);
                            return this.yp.subList(i6, this.z);
                        }
                    }
                    c cVarZ = z();
                    String strSubstring = str.substring(i8, i9);
                    String strTrim = strSubstring.trim();
                    cVarZ.c(strTrim, (f8 - f7) - ((strTrim.length() - strSubstring.length()) * f4));
                    i3 = i;
                    i7 = i4;
                    if (i7 >= i3) {
                        return this.yp.subList(i6, this.z);
                    }
                    i8 = i9;
                    f5 = f7;
                } else {
                    i4 = i10;
                }
                c cVarZ2 = z();
                String strSubstring2 = str.substring(i8, i9);
                String strTrim2 = strSubstring2.trim();
                cVarZ2.c(strTrim2, (f8 - f7) - ((strTrim2.length() - strSubstring2.length()) * f4));
                i3 = i;
                i7 = i4;
                if (i7 >= i3) {
                    return this.yp.subList(i6, this.z);
                }
                i8 = i9;
                f5 = f7;
            }
            i9++;
            i5 = i3;
            f6 = f4;
        }
        int i11 = i8;
        if (f5 > 0.0f) {
            z().c(str.substring(i11), f5);
        }
        return this.yp.subList(i6, this.z);
    }

    private String c(String str, int i, float f, float f2, com.byazt.nb.ve veVar, float f3, float f4, boolean z, int i2) {
        if (i2 == 3) {
            return c(str, i, f, veVar, f3, f4, z);
        }
        float f5 = f - f2;
        if (f5 <= 0.0f) {
            return null;
        }
        String strSubstring = str.substring(i);
        if (i2 == 0) {
            return c(strSubstring, f5, f2, veVar, f3, f4, z);
        }
        if (i2 == 1) {
            return tt(strSubstring, f5, f2, veVar, f3, f4, z);
        }
        if (i2 != 2) {
            return c(strSubstring, f5, f2, veVar, f3, f4, z);
        }
        return ve(strSubstring, f5, f2, veVar, f3, f4, z);
    }

    private String c(String str, int i, float f, com.byazt.nb.ve veVar, float f2, float f3, boolean z) {
        String strSubstring = str.substring(i);
        float fC = 0.0f;
        int i2 = 0;
        int i3 = 0;
        while (i2 < strSubstring.length()) {
            fC += c(strSubstring.charAt(i2), veVar, f2, f3, z);
            if (fC > f) {
                break;
            }
            i3 = i2 + 1;
            i2 = i3;
        }
        return strSubstring.substring(0, i3);
    }

    private String c(String str, float f, float f2, com.byazt.nb.ve veVar, float f3, float f4, boolean z) {
        float fC = 0.0f;
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            fC += c(str.charAt(i), veVar, f3, f4, z);
            if (fC > f) {
                break;
            }
            i2 = i + 1;
            i = i2;
        }
        return str.substring(0, i2) + v39.CHARACTER_ELLIPSIZE;
    }

    private float c(char c2, com.byazt.nb.ve veVar, float f, float f2, boolean z) {
        float fMeasureText;
        if (z) {
            com.byazt.nb.uj ujVar = this.rh.z().get(com.byazt.nb.uj.c(c2, veVar.c(), veVar.ve()));
            if (ujVar == null) {
                return 0.0f;
            }
            fMeasureText = ((float) ujVar.tt()) * f * com.byazt.kk.da.c();
        } else {
            fMeasureText = this.da.measureText(String.valueOf(c2));
        }
        return fMeasureText + f2;
    }

    private void c(com.byazt.nb.uj ujVar, float f, com.byazt.nb.tt ttVar, Canvas canvas) {
        List<com.byazt.zy.uj> listC = c(ujVar);
        for (int i = 0; i < listC.size(); i++) {
            Path pathUj = listC.get(i).uj();
            pathUj.computeBounds(this.x, false);
            this.i.reset();
            this.i.preTranslate(0.0f, (-ttVar.sp) * com.byazt.kk.da.c());
            this.i.preScale(f, f);
            pathUj.transform(this.i);
            if (ttVar.sl) {
                c(pathUj, this.da, canvas);
                c(pathUj, this.sl, canvas);
            } else {
                c(pathUj, this.sl, canvas);
                c(pathUj, this.da, canvas);
            }
        }
    }

    private void c(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void c(String str, com.byazt.nb.tt ttVar, Canvas canvas) {
        if (ttVar.sl) {
            c(str, this.da, canvas);
            c(str, this.sl, canvas);
        } else {
            c(str, this.sl, canvas);
            c(str, this.da, canvas);
        }
    }

    private void c(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private List<com.byazt.zy.uj> c(com.byazt.nb.uj ujVar) {
        if (this.t.containsKey(ujVar)) {
            return this.t.get(ujVar);
        }
        List<m> listC = ujVar.c();
        int size = listC.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.byazt.zy.uj(this.nu, this, listC.get(i), this.rh));
        }
        this.t.put(ujVar, arrayList);
        return arrayList;
    }

    private String c(String str, int i) {
        int iCodePointAt = str.codePointAt(i);
        int iCharCount = Character.charCount(iCodePointAt) + i;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!tt(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j = iCodePointAt;
        if (this.u.indexOfKey(j) >= 0) {
            return this.u.get(j);
        }
        this.sp.setLength(0);
        while (i < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i);
            this.sp.appendCodePoint(iCodePointAt3);
            i += Character.charCount(iCodePointAt3);
        }
        String string = this.sp.toString();
        this.u.put(j, string);
        return string;
    }

    private List<c> c(List<c> list, int i, int i2, float f, com.byazt.nb.ve veVar, float f2, float f3, boolean z) {
        int i3;
        int i4;
        String strC;
        ArrayList arrayList = new ArrayList();
        if (i == 1) {
            String strC2 = c(list);
            if (i2 == 3) {
                strC = c(strC2, f, veVar, f2, f3, z);
            } else {
                strC = c(strC2, f, veVar, f2, f3, z, i2);
            }
            c cVarZ = z();
            cVarZ.c(strC, f);
            arrayList.add(cVarZ);
        } else {
            int i5 = 0;
            if (i2 == 0) {
                while (true) {
                    i3 = i - 1;
                    if (i5 >= i3) {
                        break;
                    }
                    arrayList.add(list.get(i5));
                    i5++;
                }
                String strC3 = c(c(list, i3, list.size()), f, veVar, f2, f3, z, 0);
                c cVarZ2 = z();
                cVarZ2.c(strC3, f);
                arrayList.add(cVarZ2);
            } else if (i2 == 1) {
                int i6 = i - 1;
                String strC4 = c(c(list, 0, list.size() - i6), f, veVar, f2, f3, z, 1);
                c cVarZ3 = z();
                cVarZ3.c(strC4, f);
                arrayList.add(cVarZ3);
                for (int size = list.size() - i6; size < list.size(); size++) {
                    arrayList.add(list.get(size));
                }
            } else if (i2 == 2) {
                int i7 = i / 2;
                while (i5 < i7) {
                    arrayList.add(list.get(i5));
                    i5++;
                }
                int i8 = (i - i7) - 1;
                int size2 = list.size() - i8;
                if (size2 <= i7) {
                    size2 = list.size();
                }
                String strC5 = c(c(list, i7, size2), f, veVar, f2, f3, z, 2);
                c cVarZ4 = z();
                cVarZ4.c(strC5, f);
                arrayList.add(cVarZ4);
                for (int size3 = list.size() - i8; size3 < list.size(); size3++) {
                    arrayList.add(list.get(size3));
                }
            } else if (i2 != 3) {
                while (true) {
                    i4 = i - 1;
                    if (i5 >= i4) {
                        break;
                    }
                    arrayList.add(list.get(i5));
                    i5++;
                }
                String strC6 = c(c(list, i4, list.size()), f, veVar, f2, f3, z, 0);
                c cVarZ5 = z();
                cVarZ5.c(strC6, f);
                arrayList.add(cVarZ5);
            } else {
                while (i5 < i) {
                    arrayList.add(list.get(i5));
                    i5++;
                }
            }
        }
        return arrayList;
    }

    private String c(List<c> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<c> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().c);
        }
        return sb.toString();
    }

    private String c(List<c> list, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        while (i < i2 && i < list.size()) {
            sb.append(list.get(i).c);
            i++;
        }
        return sb.toString();
    }

    private String c(String str, float f, com.byazt.nb.ve veVar, float f2, float f3, boolean z, int i) {
        float fMeasureText;
        if (z) {
            com.byazt.nb.uj ujVar = this.rh.z().get(com.byazt.nb.uj.c(str.length() > 0 ? str.charAt(0) : ' ', veVar.c(), veVar.ve()));
            fMeasureText = (ujVar != null ? (((float) ujVar.tt()) * f2 * com.byazt.kk.da.c()) + f3 : 10.0f) * 3.0f;
        } else {
            fMeasureText = this.da.measureText(v39.CHARACTER_ELLIPSIZE) + (2.0f * f3);
        }
        String strC = c(str, 0, f, fMeasureText, veVar, f2, f3, z, i);
        return strC != null ? strC : str;
    }

    private String c(String str, float f, com.byazt.nb.ve veVar, float f2, float f3, boolean z) {
        return c(str, 0, f, veVar, f2, f3, z);
    }

    public void c(String str) {
        this.h = str;
    }
}
