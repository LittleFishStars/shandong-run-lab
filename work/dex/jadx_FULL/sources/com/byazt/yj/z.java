package com.byazt.yj;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.ImageView;
import com.byazt.ut.ATSKeep;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1197, 133})
public class z implements yp, Function {
    public volatile Function c;
    public volatile yp tt;

    public z(yp ypVar) {
        this.tt = ypVar;
    }

    public z(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object zmVar = sparseArray.get(1);
                Object obj2 = sparseArray.get(2);
                if (zmVar != null) {
                    zmVar = new zm((Function) zmVar);
                }
                t tVar = this.tt.to((gr) zmVar, ((Integer) obj2).intValue());
                return tVar != null ? new u(tVar) : tVar;
            case 2:
                Object zmVar2 = sparseArray.get(1);
                if (zmVar2 != null) {
                    zmVar2 = new zm((Function) zmVar2);
                }
                t tVar2 = this.tt.to((gr) zmVar2);
                return tVar2 != null ? new u(tVar2) : tVar2;
            case 3:
                t tVar3 = this.tt.to((ImageView) sparseArray.get(1));
                return tVar3 != null ? new u(tVar3) : tVar3;
            case 4:
                return this.tt.from((String) sparseArray.get(1));
            case 5:
                return this.tt.key((String) sparseArray.get(1));
            case 6:
                Object veVar = sparseArray.get(1);
                if (veVar != null) {
                    veVar = new ve((Function) veVar);
                }
                return this.tt.cache((tt) veVar);
            case 7:
                return this.tt.cacheDir((String) sparseArray.get(1));
            case 8:
                return this.tt.scaleType((ImageView.ScaleType) sparseArray.get(1));
            case 9:
                return this.tt.config((Bitmap.Config) sparseArray.get(1));
            case 10:
                return this.tt.width(((Integer) sparseArray.get(1)).intValue());
            case 11:
                return this.tt.height(((Integer) sparseArray.get(1)).intValue());
            case 12:
                return this.tt.type(((Integer) sparseArray.get(1)).intValue());
            case 13:
                Object cuVar = sparseArray.get(1);
                if (cuVar != null) {
                    cuVar = new cu((Function) cuVar);
                }
                return this.tt.track((or) cuVar);
            case 14:
                return this.tt.headers(((Boolean) sparseArray.get(1)).booleanValue());
            case 15:
                return this.tt.requestTime(((Boolean) sparseArray.get(1)).booleanValue());
            case 16:
                return this.tt.runIn((ExecutorService) sparseArray.get(1));
            case 17:
                Object slVar = sparseArray.get(1);
                if (slVar != null) {
                    slVar = new sl((Function) slVar);
                }
                return this.tt.converter((da) slVar);
            case 18:
                return this.tt.maxWidth(((Integer) sparseArray.get(1)).intValue());
            case 19:
                return this.tt.maxHeight(((Integer) sparseArray.get(1)).intValue());
            case 20:
                return this.tt.sync(((Boolean) sparseArray.get(1)).booleanValue());
            case 21:
                Object rlVar = sparseArray.get(1);
                if (rlVar != null) {
                    rlVar = new rl((Function) rlVar);
                }
                return this.tt.loadSetp((gt) rlVar);
            case 22:
                return this.tt.isLocalRes(((Boolean) sparseArray.get(1)).booleanValue());
            default:
                return null;
        }
    }

    @Override // com.byazt.yj.yp
    public yp cache(tt ttVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        if (ttVar != null) {
            ttVar = new ve(ttVar);
        }
        sparseArray.put(1, ttVar);
        this.c.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.yj.yp
    public yp cacheDir(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        this.c.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.yj.yp
    public yp config(Bitmap.Config config) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        sparseArray.put(1, config);
        this.c.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.yj.yp
    public yp converter(da daVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        if (daVar != null) {
            daVar = new sl(daVar);
        }
        sparseArray.put(1, daVar);
        this.c.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.yj.yp
    public yp from(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        this.c.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.yj.yp
    public yp headers(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, Boolean.valueOf(z));
        this.c.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.yj.yp
    public yp height(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.yj.yp
    public yp isLocalRes(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        sparseArray.put(1, Boolean.valueOf(z));
        this.c.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.yj.yp
    public yp key(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        this.c.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.yj.yp
    public yp loadSetp(gt gtVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        if (gtVar != null) {
            gtVar = new rl(gtVar);
        }
        sparseArray.put(1, gtVar);
        this.c.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.yj.yp
    public yp maxHeight(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.yj.yp
    public yp maxWidth(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.yj.yp
    public yp requestTime(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, Boolean.valueOf(z));
        this.c.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.yj.yp
    public yp runIn(ExecutorService executorService) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, executorService);
        this.c.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.yj.yp
    public yp scaleType(ImageView.ScaleType scaleType) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, scaleType);
        this.c.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.yj.yp
    public yp sync(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        sparseArray.put(1, Boolean.valueOf(z));
        this.c.apply(sparseArray);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // com.byazt.yj.yp
    public t to(ImageView imageView) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, imageView);
        ?? Apply = this.c.apply(sparseArray);
        ?? uVar = Apply;
        if (Apply != 0) {
            uVar = new u((Function) Apply);
        }
        return (t) uVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // com.byazt.yj.yp
    public t to(gr grVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        if (grVar != null) {
            grVar = new zm(grVar);
        }
        sparseArray.put(1, grVar);
        ?? Apply = this.c.apply(sparseArray);
        ?? uVar = Apply;
        if (Apply != 0) {
            uVar = new u((Function) Apply);
        }
        return (t) uVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.byazt.yj.yp
    public t to(gr grVar, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (grVar != null) {
            grVar = new zm(grVar);
        }
        sparseArray.put(1, grVar);
        sparseArray.put(2, Integer.valueOf(i));
        ?? Apply = this.c.apply(sparseArray);
        ?? uVar = Apply;
        if (Apply != 0) {
            uVar = new u((Function) Apply);
        }
        return (t) uVar;
    }

    @Override // com.byazt.yj.yp
    public yp track(or orVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        if (orVar != null) {
            orVar = new cu(orVar);
        }
        sparseArray.put(1, orVar);
        this.c.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.yj.yp
    public yp type(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.yj.yp
    public yp width(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
        return this;
    }
}
