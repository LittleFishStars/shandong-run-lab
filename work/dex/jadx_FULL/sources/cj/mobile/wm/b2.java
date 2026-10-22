package cj.mobile.wm;

import android.content.Context;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b2<ModelType, DataType, ResourceType, TranscodeType> implements Cloneable {
    public boolean dex01;
    public Drawable dex02;
    public int dex03;
    public final Class<ModelType> dexa;
    public final Context dexb;
    public final d2 dexc;
    public final Class<TranscodeType> dexd;
    public final w7 dexe;
    public final q7 dexf;
    public z7<ModelType, DataType, ResourceType, TranscodeType> dexg;
    public ModelType dexh;
    public r2 dexi;
    public boolean dexj;
    public int dexk;
    public int dexl;
    public h8<? super ModelType, TranscodeType> dexm;
    public Float dexn;
    public b2<?, ?, ?, TranscodeType> dexo;
    public Float dexp;
    public Drawable dexq;
    public Drawable dexr;
    public com.wangmai.insightvision.openadsdk.image.b.i dexs;
    public boolean dext;
    public n8<TranscodeType> dexu;
    public int dexv;
    public int dexw;
    public com.wangmai.insightvision.openadsdk.image.b.n.i.b dexx;
    public v2<ResourceType> dexy;
    public boolean dexz;

    public b2(Context context, Class<ModelType> cls, e8<ModelType, DataType, ResourceType, TranscodeType> e8Var, Class<TranscodeType> cls2, d2 d2Var, w7 w7Var, q7 q7Var) {
        this.dexi = w8.dexa();
        this.dexp = Float.valueOf(1.0f);
        this.dexs = null;
        this.dext = true;
        this.dexu = o8.dexc();
        this.dexv = -1;
        this.dexw = -1;
        this.dexx = com.wangmai.insightvision.openadsdk.image.b.n.i.b.d;
        this.dexy = q5.dexa();
        this.dexb = context;
        this.dexa = cls;
        this.dexd = cls2;
        this.dexc = d2Var;
        this.dexe = w7Var;
        this.dexf = q7Var;
        this.dexg = e8Var != null ? new z7<>(e8Var) : null;
        if (context == null) {
            throw new NullPointerException("Context can't be null");
        }
        if (cls != null && e8Var == null) {
            throw new NullPointerException("LoadProvider must not be null");
        }
    }

    public b2(e8<ModelType, DataType, ResourceType, TranscodeType> e8Var, Class<TranscodeType> cls, b2<ModelType, ?, ?, ?> b2Var) {
        this(b2Var.dexb, b2Var.dexa, e8Var, cls, b2Var.dexc, b2Var.dexe, b2Var.dexf);
        this.dexh = b2Var.dexh;
        this.dexj = b2Var.dexj;
        this.dexi = b2Var.dexi;
        this.dexx = b2Var.dexx;
        this.dext = b2Var.dext;
    }

    private f8 dexa(v8<TranscodeType> v8Var, float f, com.wangmai.insightvision.openadsdk.image.b.i iVar, g8 g8Var) {
        return com.wangmai.insightvision.openadsdk.image.b.r.a.l(this.dexg, this.dexh, this.dexi, this.dexb, iVar, v8Var, f, this.dexq, this.dexk, this.dexr, this.dexl, this.dex02, this.dex03, this.dexm, g8Var, this.dexc.dexd(), this.dexy, this.dexd, this.dext, this.dexu, this.dexw, this.dexv, this.dexx);
    }

    private f8 dexa(v8<TranscodeType> v8Var, j8 j8Var) {
        j8 j8Var2;
        f8 f8VarDexa;
        f8 f8VarDexa2;
        b2<?, ?, ?, TranscodeType> b2Var = this.dexo;
        if (b2Var != null) {
            if (this.dex01) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            if (b2Var.dexu.equals(o8.dexc())) {
                this.dexo.dexu = this.dexu;
            }
            b2<?, ?, ?, TranscodeType> b2Var2 = this.dexo;
            if (b2Var2.dexs == null) {
                b2Var2.dexs = dexb();
            }
            if (e9.dexa(this.dexw, this.dexv)) {
                b2<?, ?, ?, TranscodeType> b2Var3 = this.dexo;
                if (!e9.dexa(b2Var3.dexw, b2Var3.dexv)) {
                    this.dexo.dexa(this.dexw, this.dexv);
                }
            }
            j8Var2 = new j8(j8Var);
            f8VarDexa = dexa(v8Var, this.dexp.floatValue(), this.dexs, j8Var2);
            this.dex01 = true;
            f8VarDexa2 = this.dexo.dexa(v8Var, j8Var2);
            this.dex01 = false;
        } else {
            if (this.dexn == null) {
                return dexa(v8Var, this.dexp.floatValue(), this.dexs, j8Var);
            }
            j8Var2 = new j8(j8Var);
            f8VarDexa = dexa(v8Var, this.dexp.floatValue(), this.dexs, j8Var2);
            f8VarDexa2 = dexa(v8Var, this.dexn.floatValue(), dexb(), j8Var2);
        }
        j8Var2.dexa(f8VarDexa, f8VarDexa2);
        return j8Var2;
    }

    private f8 dexb(v8<TranscodeType> v8Var) {
        if (this.dexs == null) {
            this.dexs = com.wangmai.insightvision.openadsdk.image.b.i.c;
        }
        return dexa(v8Var, (j8) null);
    }

    private com.wangmai.insightvision.openadsdk.image.b.i dexb() {
        com.wangmai.insightvision.openadsdk.image.b.i iVar = this.dexs;
        if (iVar == com.wangmai.insightvision.openadsdk.image.b.i.d) {
            return com.wangmai.insightvision.openadsdk.image.b.i.c;
        }
        return iVar == com.wangmai.insightvision.openadsdk.image.b.i.c ? com.wangmai.insightvision.openadsdk.image.b.i.b : com.wangmai.insightvision.openadsdk.image.b.i.a;
    }

    @Override // 
    /* JADX INFO: renamed from: dexa, reason: merged with bridge method [inline-methods] */
    public b2<ModelType, DataType, ResourceType, TranscodeType> clone() {
        try {
            b2<ModelType, DataType, ResourceType, TranscodeType> b2Var = (b2) super.clone();
            z7<ModelType, DataType, ResourceType, TranscodeType> z7Var = this.dexg;
            b2Var.dexg = z7Var != null ? z7Var.clone() : null;
            return b2Var;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public b2<ModelType, DataType, ResourceType, TranscodeType> dexa(int i, int i2) {
        if (!e9.dexa(i, i2)) {
            throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
        }
        this.dexw = i;
        this.dexv = i2;
        return this;
    }

    public b2<ModelType, DataType, ResourceType, TranscodeType> dexa(n8<TranscodeType> n8Var) {
        if (n8Var == null) {
            throw new NullPointerException("Animation factory must not be null!");
        }
        this.dexu = n8Var;
        return this;
    }

    public b2<ModelType, DataType, ResourceType, TranscodeType> dexa(q2<DataType> q2Var) {
        z7<ModelType, DataType, ResourceType, TranscodeType> z7Var = this.dexg;
        if (z7Var != null) {
            z7Var.dexa(q2Var);
        }
        return this;
    }

    public b2<ModelType, DataType, ResourceType, TranscodeType> dexa(r2 r2Var) {
        if (r2Var == null) {
            throw new NullPointerException("Signature must not be null");
        }
        this.dexi = r2Var;
        return this;
    }

    public b2<ModelType, DataType, ResourceType, TranscodeType> dexa(t2<DataType, ResourceType> t2Var) {
        z7<ModelType, DataType, ResourceType, TranscodeType> z7Var = this.dexg;
        if (z7Var != null) {
            z7Var.dexa(t2Var);
        }
        return this;
    }

    public b2<ModelType, DataType, ResourceType, TranscodeType> dexa(com.wangmai.insightvision.openadsdk.image.b.n.i.b bVar) {
        this.dexx = bVar;
        return this;
    }

    public b2<ModelType, DataType, ResourceType, TranscodeType> dexa(ModelType modeltype) {
        this.dexh = modeltype;
        this.dexj = true;
        return this;
    }

    public b2<ModelType, DataType, ResourceType, TranscodeType> dexa(boolean z) {
        this.dext = !z;
        return this;
    }

    public b2<ModelType, DataType, ResourceType, TranscodeType> dexa(v2<ResourceType>... v2VarArr) {
        this.dexz = true;
        if (v2VarArr.length == 1) {
            this.dexy = v2VarArr[0];
        } else {
            this.dexy = new s2(v2VarArr);
        }
        return this;
    }

    public <Y extends v8<TranscodeType>> Y dexa(Y y) {
        e9.dexa();
        if (y == null) {
            throw new IllegalArgumentException("You must pass in a non null Target");
        }
        if (!this.dexj) {
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
        f8 f8VarC = y.c();
        if (f8VarC != null) {
            f8VarC.clear();
            this.dexe.dexa(f8VarC);
            f8VarC.b();
        }
        f8 f8VarDexb = dexb(y);
        y.dexa(f8VarDexb);
        this.dexf.dexa(y);
        this.dexe.dexb(f8VarDexb);
        return y;
    }
}
