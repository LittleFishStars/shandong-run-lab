package com.byakv.q;

import com.byazt.bj.a;
import com.byazt.bj.da;
import com.byazt.bj.n;
import com.byazt.bj.sp;
import com.byazt.bj.tt;
import com.byazt.bj.u;
import com.byazt.bj.uj;
import com.byazt.bj.ve;
import com.byazt.bj.x;
import com.byazt.bj.yp;
import com.byazt.bx.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@c
public abstract class YogaNodeJNIBase extends da implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f28269a;

    @c
    public float[] arr;
    public long c;

    @c
    public int mLayoutDirection;
    public tt n;
    public boolean sp;
    public YogaNodeJNIBase tt;
    public sp uj;
    public List<YogaNodeJNIBase> ve;

    private YogaNodeJNIBase(long j) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.sp = true;
        if (j == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.c = j;
    }

    @c
    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i) {
        List<YogaNodeJNIBase> list = this.ve;
        if (list == null) {
            throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
        }
        list.remove(i);
        this.ve.add(i, yogaNodeJNIBase);
        yogaNodeJNIBase.tt = this;
        return yogaNodeJNIBase.c;
    }

    @Override // com.byazt.bj.da
    public void a(float f) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.c, f);
    }

    @c
    public final float baseline(float f, float f2) {
        return this.n.c(this, f, f2);
    }

    @Override // com.byazt.bj.da
    public void da(float f) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.c, f);
    }

    @Override // com.byazt.bj.da
    public void i(float f) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.c, f);
    }

    @c
    public final long measure(float f, int i, float f2, int i2) {
        if (t()) {
            return this.uj.c(this, f, x.c(i), f2, x.c(i2));
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    @Override // com.byazt.bj.da
    public void n(float f) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.c, f);
    }

    @Override // com.byazt.bj.da
    /* JADX INFO: renamed from: sl, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase tt() {
        return this.tt;
    }

    @Override // com.byazt.bj.da
    public void sp(float f) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.c, f);
    }

    @Override // com.byazt.bj.da
    public void t(float f) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.c, f);
    }

    @Override // com.byazt.bj.da
    /* JADX INFO: renamed from: uj, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase tt(int i) {
        List<YogaNodeJNIBase> list = this.ve;
        if (list == null) {
            throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
        }
        YogaNodeJNIBase yogaNodeJNIBaseRemove = list.remove(i);
        yogaNodeJNIBaseRemove.tt = null;
        YogaNative.jni_YGNodeRemoveChildJNI(this.c, yogaNodeJNIBaseRemove.c);
        return yogaNodeJNIBaseRemove;
    }

    @Override // com.byazt.bj.da
    /* JADX INFO: renamed from: ve, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase c(int i) {
        List<YogaNodeJNIBase> list = this.ve;
        if (list != null) {
            return list.get(i);
        }
        throw new IllegalStateException("YogaNode does not have children");
    }

    @Override // com.byazt.bj.da
    public void x(float f) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.c, f);
    }

    @Override // com.byazt.bj.da
    public float a() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    @Override // com.byazt.bj.da
    public int c() {
        List<YogaNodeJNIBase> list = this.ve;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.byazt.bj.da
    public Object da() {
        return this.f28269a;
    }

    @Override // com.byazt.bj.da
    public float i() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }

    @Override // com.byazt.bj.da
    public void n() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.c);
    }

    @Override // com.byazt.bj.da
    public void sl(float f) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.c, f);
    }

    @Override // com.byazt.bj.da
    public float sp() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    public boolean t() {
        return this.uj != null;
    }

    @Override // com.byazt.bj.da
    public float x() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    @Override // com.byazt.bj.da
    public void c(da daVar, int i) {
        if (daVar instanceof YogaNodeJNIBase) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) daVar;
            if (yogaNodeJNIBase.tt == null) {
                if (this.ve == null) {
                    this.ve = new ArrayList(4);
                }
                this.ve.add(i, yogaNodeJNIBase);
                yogaNodeJNIBase.tt = this;
                YogaNative.jni_YGNodeInsertChildJNI(this.c, yogaNodeJNIBase.c, i);
                return;
            }
            throw new IllegalStateException("Child already has a parent, it must be removed first.");
        }
    }

    @Override // com.byazt.bj.da
    public void tt(com.byazt.bj.c cVar) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.c, cVar.c());
    }

    @Override // com.byazt.bj.da
    public void tt(float f) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.c, f);
    }

    @Override // com.byazt.bj.da
    public void ve(com.byazt.bj.c cVar) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.c, cVar.c());
    }

    @Override // com.byazt.bj.da
    public void tt(uj ujVar, float f) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.c, ujVar.c(), f);
    }

    @Override // com.byazt.bj.da
    public void ve(float f) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.c, f);
    }

    @Override // com.byazt.bj.da
    public void uj(float f) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.c, f);
    }

    @Override // com.byazt.bj.da
    public void ve() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.c);
    }

    public YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    @Override // com.byazt.bj.da
    public void uj() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.c);
    }

    @Override // com.byazt.bj.da
    public void ve(uj ujVar, float f) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.c, ujVar.c(), f);
    }

    @Override // com.byazt.bj.da
    public int c(da daVar) {
        List<YogaNodeJNIBase> list = this.ve;
        if (list == null) {
            return -1;
        }
        return list.indexOf(daVar);
    }

    @Override // com.byazt.bj.da
    public void c(float f, float f2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i = 0; i < arrayList.size(); i++) {
            List<YogaNodeJNIBase> list = ((YogaNodeJNIBase) arrayList.get(i)).ve;
            if (list != null) {
                Iterator<YogaNodeJNIBase> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            }
        }
        YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
        long[] jArr = new long[yogaNodeJNIBaseArr.length];
        for (int i2 = 0; i2 < yogaNodeJNIBaseArr.length; i2++) {
            jArr[i2] = yogaNodeJNIBaseArr[i2].c;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.c, f, f2, jArr, yogaNodeJNIBaseArr);
    }

    @Override // com.byazt.bj.da
    public void c(ve veVar) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.c, veVar.c());
    }

    @Override // com.byazt.bj.da
    public void c(n nVar) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.c, nVar.c());
    }

    @Override // com.byazt.bj.da
    public void c(a aVar) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.c, aVar.c());
    }

    @Override // com.byazt.bj.da
    public void c(com.byazt.bj.c cVar) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.c, cVar.c());
    }

    @Override // com.byazt.bj.da
    public void c(u uVar) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.c, uVar.c());
    }

    @Override // com.byazt.bj.da
    public void c(yp ypVar) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.c, ypVar.c());
    }

    @Override // com.byazt.bj.da
    public void c(float f) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.c, f);
    }

    @Override // com.byazt.bj.da
    public void c(uj ujVar, float f) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.c, ujVar.c(), f);
    }

    @Override // com.byazt.bj.da
    public void c(sp spVar) {
        this.uj = spVar;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(this.c, spVar != null);
    }

    @Override // com.byazt.bj.da
    public void c(boolean z) {
        YogaNative.jni_YGNodeSetAlwaysFormsContainingBlockJNI(this.c, z);
    }

    @Override // com.byazt.bj.da
    public void c(Object obj) {
        this.f28269a = obj;
    }
}
