package com.byazt.zk;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.byazt.dg.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 909, 54})
public abstract class ve implements com.byazt.zy.n, com.byazt.dg.c.InterfaceC0385c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BlurMaskFilter f29244a;
    public final Matrix c;
    public boolean d;
    public Paint eo;
    public com.byazt.dg.uj gr;
    public final RectF gt;
    public com.byazt.dg.x gu;
    public boolean h;
    public final Paint m;
    public final List<com.byazt.dg.c<?, ?>> md;
    public final RectF my;
    public float n;
    public final RectF nu;
    public float or;
    public List<ve> p;
    public final String qy;
    public final RectF rh;
    public final RectF rl;
    public final com.byazt.ga.x tt;
    public final m uj;
    public final x ve;
    public boolean x;
    public ve yv;
    public final Paint z;
    public final Matrix zb;
    public ve zm;
    public final Handler sp = new Handler(Looper.getMainLooper());
    public final Path i = new Path();
    public final Matrix da = new Matrix();
    public final Matrix sl = new Matrix();
    public final Paint t = new com.byazt.xg.c(1);
    public final Paint u = new com.byazt.xg.c(1, PorterDuff.Mode.DST_IN);
    public final Paint yp = new com.byazt.xg.c(1, PorterDuff.Mode.DST_OUT);

    /* JADX INFO: renamed from: com.byazt.zk.ve$2, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 909, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME})
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] c;
        public static final /* synthetic */ int[] tt;

        static {
            int[] iArr = new int[com.byazt.jx.x.c.values().length];
            tt = iArr;
            try {
                iArr[com.byazt.jx.x.c.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                tt[com.byazt.jx.x.c.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                tt[com.byazt.jx.x.c.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                tt[com.byazt.jx.x.c.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[x.c.values().length];
            c = iArr2;
            try {
                iArr2[x.c.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                c[x.c.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                c[x.c.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                c[x.c.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                c[x.c.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                c[x.c.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                c[x.c.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public ve(com.byazt.ga.x xVar, x xVar2) {
        com.byazt.xg.c cVar = new com.byazt.xg.c(1);
        this.z = cVar;
        this.m = new com.byazt.xg.c(PorterDuff.Mode.CLEAR);
        this.nu = new RectF();
        this.rh = new RectF();
        this.my = new RectF();
        this.gt = new RectF();
        this.rl = new RectF();
        this.c = new Matrix();
        this.md = new ArrayList();
        this.h = true;
        this.n = 0.0f;
        this.zb = new Matrix();
        this.or = 1.0f;
        this.tt = xVar;
        this.ve = xVar2;
        this.qy = xVar2.a() + "#draw";
        if (xVar2.t() == x.tt.INVERT) {
            cVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            cVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        m mVarDa = xVar2.z().da();
        this.uj = mVarDa;
        mVarDa.c((com.byazt.dg.c.InterfaceC0385c) this);
        if (xVar2.da() != null && !xVar2.da().isEmpty()) {
            com.byazt.dg.x xVar3 = new com.byazt.dg.x(xVar2.da());
            this.gu = xVar3;
            Iterator<com.byazt.dg.c<com.byazt.jx.yp, Path>> it = xVar3.tt().iterator();
            while (it.hasNext()) {
                it.next().c(this);
            }
            for (com.byazt.dg.c<Integer, Integer> cVar2 : this.gu.ve()) {
                c(cVar2);
                cVar2.c(this);
            }
        }
        yp();
    }

    private boolean m() {
        if (this.gu.tt().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.gu.c().size(); i++) {
            if (this.gu.c().get(i).c() != com.byazt.jx.x.c.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void nu() {
        if (this.p != null) {
            return;
        }
        if (this.yv == null) {
            this.p = Collections.emptyList();
            return;
        }
        this.p = new ArrayList();
        for (ve veVar = this.yv; veVar != null; veVar = veVar.yv) {
            this.p.add(veVar);
        }
    }

    private void yp() {
        if (this.ve.uj().isEmpty()) {
            tt(true);
            return;
        }
        com.byazt.dg.uj ujVar = new com.byazt.dg.uj(this.ve.uj());
        this.gr = ujVar;
        ujVar.c();
        this.gr.c(new com.byazt.dg.c.InterfaceC0385c() { // from class: com.byazt.zk.ve.1
            @Override // com.byazt.dg.c.InterfaceC0385c
            public void c() {
                ve veVar = ve.this;
                veVar.tt(veVar.gr.i() == 1.0f);
            }
        });
        tt(this.gr.sp().floatValue() == 1.0f);
        c(this.gr);
    }

    private void z() {
        this.tt.invalidateSelf();
    }

    public Matrix a() {
        return this.zb;
    }

    @Override // com.byazt.zy.ve
    public void c(List<com.byazt.zy.ve> list, List<com.byazt.zy.ve> list2) {
    }

    public boolean da() {
        return this.h;
    }

    public boolean i() {
        com.byazt.dg.x xVar = this.gu;
        return (xVar == null || xVar.tt().isEmpty()) ? false : true;
    }

    public boolean n() {
        return this.zm != null;
    }

    public String sl() {
        return this.ve.a();
    }

    public String sp() {
        x xVar = this.ve;
        if (xVar != null) {
            return xVar.sp();
        }
        return null;
    }

    public com.byazt.jx.c t() {
        return this.ve.gu();
    }

    public boolean tt() {
        return this.x;
    }

    public com.byazt.fs.da u() {
        return this.ve.gr();
    }

    public x uj() {
        return this.ve;
    }

    public float x() {
        return this.or;
    }

    private void n(Canvas canvas, Matrix matrix, com.byazt.dg.c<com.byazt.jx.yp, Path> cVar, com.byazt.dg.c<Integer, Integer> cVar2) {
        com.byazt.kk.da.c(canvas, this.nu, this.u);
        canvas.drawRect(this.nu, this.t);
        this.yp.setAlpha((int) (cVar2.sp().intValue() * 2.55f));
        this.i.set(cVar.sp());
        this.i.transform(matrix);
        canvas.drawPath(this.i, this.yp);
        canvas.restore();
    }

    private void uj(Canvas canvas, Matrix matrix, com.byazt.dg.c<com.byazt.jx.yp, Path> cVar, com.byazt.dg.c<Integer, Integer> cVar2) {
        com.byazt.kk.da.c(canvas, this.nu, this.u);
        this.i.set(cVar.sp());
        this.i.transform(matrix);
        this.t.setAlpha((int) (cVar2.sp().intValue() * 2.55f));
        canvas.drawPath(this.i, this.t);
        canvas.restore();
    }

    public void c(Runnable runnable) {
        this.sp.post(runnable);
    }

    public void tt(ve veVar) {
        this.yv = veVar;
    }

    public void ve() {
        this.x = true;
    }

    public static ve c(uj ujVar, x xVar, com.byazt.ga.x xVar2, com.byazt.ga.a aVar, Context context) {
        switch (AnonymousClass2.c[xVar.sl().ordinal()]) {
            case 1:
                return new da(xVar2, xVar, ujVar, aVar);
            case 2:
                return new uj(xVar2, xVar, aVar.tt(xVar.sp()), aVar, context);
            case 3:
                return new sl(xVar2, xVar);
            case 4:
                if (c(xVar2, xVar, "text:")) {
                    return new a(xVar2, xVar, context);
                }
                if (c(xVar2, xVar, "videoview:")) {
                    com.byazt.ga.i.c cVarC = c(xVar2, xVar);
                    if (cVarC != null) {
                        com.byazt.ga.i.c.C0410c c0410c = cVarC.c;
                        if (c0410c != null && c0410c.c > 0.0f) {
                            return new n(xVar2, xVar, context, c0410c);
                        }
                        if (cVarC.tt) {
                            return new tt(xVar2, xVar, context);
                        }
                        return new yp(xVar2, xVar, context);
                    }
                    return new yp(xVar2, xVar, context);
                }
                if (c(xVar2, xVar, "animview:")) {
                    return new c(xVar2, xVar, context);
                }
                if (c(xVar2, xVar, "view:")) {
                    return new u(xVar2, xVar, context);
                }
                sp spVar = new sp(xVar2, xVar);
                spVar.yp();
                return spVar;
            case 5:
                return new i(xVar2, xVar);
            case 6:
                return new t(xVar2, xVar);
            default:
                com.byazt.kk.a.tt("Unknown layer type " + xVar.sl());
                return null;
        }
    }

    private void tt(RectF rectF, Matrix matrix) {
        if (n() && this.ve.t() != x.tt.INVERT) {
            this.gt.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.zm.c(this.gt, matrix, true);
            if (rectF.intersect(this.gt)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void ve(float f) {
        this.tt.p().ve().c(this.ve.a(), f);
    }

    private void ve(Canvas canvas, Matrix matrix, com.byazt.dg.c<com.byazt.jx.yp, Path> cVar, com.byazt.dg.c<Integer, Integer> cVar2) {
        com.byazt.kk.da.c(canvas, this.nu, this.yp);
        canvas.drawRect(this.nu, this.t);
        this.yp.setAlpha((int) (cVar2.sp().intValue() * 2.55f));
        this.i.set(cVar.sp());
        this.i.transform(matrix);
        canvas.drawPath(this.i, this.yp);
        canvas.restore();
    }

    public void tt(Canvas canvas, Matrix matrix, int i) {
        c(i);
    }

    private void tt(Canvas canvas, Matrix matrix, com.byazt.dg.c<com.byazt.jx.yp, Path> cVar, com.byazt.dg.c<Integer, Integer> cVar2) {
        com.byazt.kk.da.c(canvas, this.nu, this.t);
        canvas.drawRect(this.nu, this.t);
        this.i.set(cVar.sp());
        this.i.transform(matrix);
        this.t.setAlpha((int) (cVar2.sp().intValue() * 2.55f));
        canvas.drawPath(this.i, this.yp);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(boolean z) {
        if (z != this.h) {
            this.h = z;
            z();
        }
    }

    public BlurMaskFilter tt(float f) {
        if (this.n == f) {
            return this.f29244a;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.f29244a = blurMaskFilter;
        this.n = f;
        return blurMaskFilter;
    }

    private static com.byazt.ga.i.c c(com.byazt.ga.x xVar, x xVar2) {
        com.byazt.ga.i iVarA;
        if (xVar == null || xVar2 == null || (iVarA = xVar.a(xVar2.sp())) == null) {
            return null;
        }
        return iVarA.da();
    }

    private static boolean c(com.byazt.ga.x xVar, x xVar2, String str) {
        com.byazt.ga.i iVarA;
        if (xVar == null || xVar2 == null || str == null || (iVarA = xVar.a(xVar2.sp())) == null) {
            return false;
        }
        return str.equals(iVarA.yp());
    }

    public void c(boolean z) {
        if (z && this.eo == null) {
            this.eo = new com.byazt.xg.c();
        }
        this.d = z;
    }

    @Override // com.byazt.dg.c.InterfaceC0385c
    public void c() {
        z();
    }

    public void c(ve veVar) {
        this.zm = veVar;
    }

    public void c(com.byazt.dg.c<?, ?> cVar) {
        if (cVar == null) {
            return;
        }
        this.md.add(cVar);
    }

    @Override // com.byazt.zy.n
    public void c(RectF rectF, Matrix matrix, boolean z) {
        this.nu.set(0.0f, 0.0f, 0.0f, 0.0f);
        nu();
        this.c.set(matrix);
        if (z) {
            List<ve> list = this.p;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.c.preConcat(this.p.get(size).uj.uj());
                }
            } else {
                ve veVar = this.yv;
                if (veVar != null) {
                    this.c.preConcat(veVar.uj.uj());
                }
            }
        }
        this.c.preConcat(this.uj.uj());
    }

    @Override // com.byazt.zy.n
    public void c(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        Integer numSp;
        com.byazt.ga.n.c(this.qy);
        if (this.h && !this.ve.qy()) {
            nu();
            com.byazt.ga.n.c("Layer#parentMatrix");
            this.zb.set(matrix);
            this.da.reset();
            this.da.set(matrix);
            for (int size = this.p.size() - 1; size >= 0; size--) {
                this.da.preConcat(this.p.get(size).uj.uj());
            }
            com.byazt.ga.n.tt("Layer#parentMatrix");
            com.byazt.dg.c<?, Integer> cVarC = this.uj.c();
            int iIntValue = (int) ((((i / 255.0f) * ((cVarC == null || (numSp = cVarC.sp()) == null) ? 100 : numSp.intValue())) / 100.0f) * 255.0f);
            if (!n() && !i()) {
                this.da.preConcat(this.uj.uj());
                com.byazt.ga.n.c("Layer#drawLayer");
                tt(canvas, this.da, iIntValue);
                com.byazt.ga.n.tt("Layer#drawLayer");
                ve(com.byazt.ga.n.tt(this.qy));
                return;
            }
            com.byazt.ga.n.c("Layer#computeBounds");
            c(this.nu, this.da, false);
            tt(this.nu, matrix);
            this.da.preConcat(this.uj.uj());
            c(this.nu, this.da);
            this.rh.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            canvas.getMatrix(this.sl);
            if (!this.sl.isIdentity()) {
                Matrix matrix2 = this.sl;
                matrix2.invert(matrix2);
                this.sl.mapRect(this.rh);
            }
            if (!this.nu.intersect(this.rh)) {
                this.nu.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            com.byazt.ga.n.tt("Layer#computeBounds");
            if (this.nu.width() >= 1.0f && this.nu.height() >= 1.0f) {
                com.byazt.ga.n.c("Layer#saveLayer");
                this.t.setAlpha(255);
                com.byazt.kk.da.c(canvas, this.nu, this.t);
                com.byazt.ga.n.tt("Layer#saveLayer");
                c(canvas);
                com.byazt.ga.n.c("Layer#drawLayer");
                tt(canvas, this.da, iIntValue);
                com.byazt.ga.n.tt("Layer#drawLayer");
                if (i()) {
                    c(canvas, this.da);
                }
                if (n()) {
                    com.byazt.ga.n.c("Layer#drawMatte");
                    com.byazt.ga.n.c("Layer#saveLayer");
                    com.byazt.kk.da.c(canvas, this.nu, this.z, 19);
                    com.byazt.ga.n.tt("Layer#saveLayer");
                    c(canvas);
                    this.zm.c(canvas, matrix, iIntValue);
                    com.byazt.ga.n.c("Layer#restoreLayer");
                    canvas.restore();
                    com.byazt.ga.n.tt("Layer#restoreLayer");
                    com.byazt.ga.n.tt("Layer#drawMatte");
                }
                com.byazt.ga.n.c("Layer#restoreLayer");
                canvas.restore();
                com.byazt.ga.n.tt("Layer#restoreLayer");
            }
            if (this.d && (paint = this.eo) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.eo.setColor(-251901);
                this.eo.setStrokeWidth(4.0f);
                canvas.drawRect(this.nu, this.eo);
                this.eo.setStyle(Paint.Style.FILL);
                this.eo.setColor(1357638635);
                canvas.drawRect(this.nu, this.eo);
            }
            ve(com.byazt.ga.n.tt(this.qy));
            return;
        }
        com.byazt.ga.n.tt(this.qy);
    }

    private void c(Canvas canvas) {
        com.byazt.ga.n.c("Layer#clearLayer");
        RectF rectF = this.nu;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.m);
        com.byazt.ga.n.tt("Layer#clearLayer");
    }

    private void c(RectF rectF, Matrix matrix) {
        this.my.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (i()) {
            int size = this.gu.c().size();
            for (int i = 0; i < size; i++) {
                com.byazt.jx.x xVar = this.gu.c().get(i);
                Path pathSp = this.gu.tt().get(i).sp();
                if (pathSp != null) {
                    this.i.set(pathSp);
                    this.i.transform(matrix);
                    int i2 = AnonymousClass2.tt[xVar.c().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        return;
                    }
                    if ((i2 == 3 || i2 == 4) && xVar.uj()) {
                        return;
                    }
                    this.i.computeBounds(this.rl, false);
                    if (i == 0) {
                        this.my.set(this.rl);
                    } else {
                        RectF rectF2 = this.my;
                        rectF2.set(Math.min(rectF2.left, this.rl.left), Math.min(this.my.top, this.rl.top), Math.max(this.my.right, this.rl.right), Math.max(this.my.bottom, this.rl.bottom));
                    }
                }
            }
            if (rectF.intersect(this.my)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public void c(int i) {
        this.or = ((this.uj.c() != null ? this.uj.c().sp().intValue() : 100) / 100.0f) * (i / 255.0f);
    }

    private void c(Canvas canvas, Matrix matrix) {
        com.byazt.ga.n.c("Layer#saveLayer");
        com.byazt.kk.da.c(canvas, this.nu, this.u, 19);
        if (Build.VERSION.SDK_INT < 28) {
            c(canvas);
        }
        com.byazt.ga.n.tt("Layer#saveLayer");
        for (int i = 0; i < this.gu.c().size(); i++) {
            com.byazt.jx.x xVar = this.gu.c().get(i);
            com.byazt.dg.c<com.byazt.jx.yp, Path> cVar = this.gu.tt().get(i);
            com.byazt.dg.c<Integer, Integer> cVar2 = this.gu.ve().get(i);
            int i2 = AnonymousClass2.tt[xVar.c().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.t.setColor(-16777216);
                        this.t.setAlpha(255);
                        canvas.drawRect(this.nu, this.t);
                    }
                    if (xVar.uj()) {
                        ve(canvas, matrix, cVar, cVar2);
                    } else {
                        c(canvas, matrix, cVar);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (xVar.uj()) {
                            tt(canvas, matrix, cVar, cVar2);
                        } else {
                            c(canvas, matrix, cVar, cVar2);
                        }
                    }
                } else if (xVar.uj()) {
                    n(canvas, matrix, cVar, cVar2);
                } else {
                    uj(canvas, matrix, cVar, cVar2);
                }
            } else if (m()) {
                this.t.setAlpha(255);
                canvas.drawRect(this.nu, this.t);
            }
        }
        com.byazt.ga.n.c("Layer#restoreLayer");
        canvas.restore();
        com.byazt.ga.n.tt("Layer#restoreLayer");
    }

    private void c(Canvas canvas, Matrix matrix, com.byazt.dg.c<com.byazt.jx.yp, Path> cVar, com.byazt.dg.c<Integer, Integer> cVar2) {
        this.i.set(cVar.sp());
        this.i.transform(matrix);
        this.t.setAlpha((int) (cVar2.sp().intValue() * 2.55f));
        canvas.drawPath(this.i, this.t);
    }

    private void c(Canvas canvas, Matrix matrix, com.byazt.dg.c<com.byazt.jx.yp, Path> cVar) {
        this.i.set(cVar.sp());
        this.i.transform(matrix);
        canvas.drawPath(this.i, this.yp);
    }

    public void c(float f) {
        this.uj.c(f);
        if (this.gu != null) {
            for (int i = 0; i < this.gu.tt().size(); i++) {
                this.gu.tt().get(i).c(f);
            }
        }
        com.byazt.dg.uj ujVar = this.gr;
        if (ujVar != null) {
            ujVar.c(f);
        }
        ve veVar = this.zm;
        if (veVar != null) {
            veVar.c(f);
        }
        for (int i2 = 0; i2 < this.md.size(); i2++) {
            this.md.get(i2).c(f);
        }
    }
}
