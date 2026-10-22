package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.k;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.zj.adlib.ds4;
import com.zj.adlib.j45;
import com.zj.adlib.j88;
import com.zj.adlib.m60;
import com.zj.adlib.vj9;
import com.zj.adlib.zt4;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements DrawingContent, PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f23332a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f376a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Path f377a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f378a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LottieDrawable f379a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public k f380a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f381a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<Content> f382a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f383a;
    public final RectF b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public List<PathContent> f384b;

    public a(LottieDrawable lottieDrawable, BaseLayer baseLayer, j88 j88Var) {
        this(lottieDrawable, baseLayer, j88Var.c(), j88Var.d(), e(lottieDrawable, baseLayer, j88Var.b()), j(j88Var.b()));
    }

    public static List<Content> e(LottieDrawable lottieDrawable, BaseLayer baseLayer, List<ContentModel> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            Content contentA = list.get(i).a(lottieDrawable, baseLayer);
            if (contentA != null) {
                arrayList.add(contentA);
            }
        }
        return arrayList;
    }

    @Nullable
    public static m60 j(List<ContentModel> list) {
        for (int i = 0; i < list.size(); i++) {
            ContentModel contentModel = list.get(i);
            if (contentModel instanceof m60) {
                return (m60) contentModel;
            }
        }
        return null;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f23332a.set(matrix);
        k kVar = this.f380a;
        if (kVar != null) {
            this.f23332a.preConcat(kVar.f());
        }
        this.b.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f382a.size() - 1; size >= 0; size--) {
            Content content = this.f382a.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).a(this.b, this.f23332a, z);
                rectF.union(this.b);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void b(Canvas canvas, Matrix matrix, int i) {
        if (this.f383a) {
            return;
        }
        this.f23332a.set(matrix);
        k kVar = this.f380a;
        if (kVar != null) {
            this.f23332a.preConcat(kVar.f());
            i = (int) (((((this.f380a.h() == null ? 100 : this.f380a.h().f().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = this.f379a.k0() && m() && i != 255;
        if (z) {
            this.f378a.set(0.0f, 0.0f, 0.0f, 0.0f);
            a(this.f378a, this.f23332a, true);
            this.f376a.setAlpha(i);
            vj9.n(canvas, this.f378a, this.f376a);
        }
        if (z) {
            i = 255;
        }
        for (int size = this.f382a.size() - 1; size >= 0; size--) {
            Content content = this.f382a.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).b(canvas, this.f23332a, i);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void c(List<Content> list, List<Content> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f382a.size());
        arrayList.addAll(list);
        for (int size = this.f382a.size() - 1; size >= 0; size--) {
            Content content = this.f382a.get(size);
            content.c(arrayList, this.f382a.subList(0, size));
            arrayList.add(content);
        }
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path f() {
        this.f23332a.reset();
        k kVar = this.f380a;
        if (kVar != null) {
            this.f23332a.set(kVar.f());
        }
        this.f377a.reset();
        if (this.f383a) {
            return this.f377a;
        }
        for (int size = this.f382a.size() - 1; size >= 0; size--) {
            Content content = this.f382a.get(size);
            if (content instanceof PathContent) {
                this.f377a.addPath(((PathContent) content).f(), this.f23332a);
            }
        }
        return this.f377a;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void g(ds4 ds4Var, int i, List<ds4> list, ds4 ds4Var2) {
        if (ds4Var.h(getName(), i) || "__container".equals(getName())) {
            if (!"__container".equals(getName())) {
                ds4Var2 = ds4Var2.a(getName());
                if (ds4Var.c(getName(), i)) {
                    list.add(ds4Var2.j(this));
                }
            }
            if (ds4Var.i(getName(), i)) {
                int iE = i + ds4Var.e(getName(), i);
                for (int i2 = 0; i2 < this.f382a.size(); i2++) {
                    Content content = this.f382a.get(i2);
                    if (content instanceof KeyPathElement) {
                        ((KeyPathElement) content).g(ds4Var, iE, list, ds4Var2);
                    }
                }
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f381a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void h() {
        this.f379a.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void i(T t, @Nullable j45<T> j45Var) {
        k kVar = this.f380a;
        if (kVar != null) {
            kVar.c(t, j45Var);
        }
    }

    public List<PathContent> k() {
        if (this.f384b == null) {
            this.f384b = new ArrayList();
            for (int i = 0; i < this.f382a.size(); i++) {
                Content content = this.f382a.get(i);
                if (content instanceof PathContent) {
                    this.f384b.add((PathContent) content);
                }
            }
        }
        return this.f384b;
    }

    public Matrix l() {
        k kVar = this.f380a;
        if (kVar != null) {
            return kVar.f();
        }
        this.f23332a.reset();
        return this.f23332a;
    }

    public final boolean m() {
        int i = 0;
        for (int i2 = 0; i2 < this.f382a.size(); i2++) {
            if ((this.f382a.get(i2) instanceof DrawingContent) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    public a(LottieDrawable lottieDrawable, BaseLayer baseLayer, String str, boolean z, List<Content> list, @Nullable m60 m60Var) {
        this.f376a = new zt4();
        this.f378a = new RectF();
        this.f23332a = new Matrix();
        this.f377a = new Path();
        this.b = new RectF();
        this.f381a = str;
        this.f379a = lottieDrawable;
        this.f383a = z;
        this.f382a = list;
        if (m60Var != null) {
            k kVarB = m60Var.b();
            this.f380a = kVarB;
            kVarB.a(baseLayer);
            this.f380a.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof GreedyContent) {
                arrayList.add((GreedyContent) content);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((GreedyContent) arrayList.get(size2)).e(list.listIterator(list.size()));
        }
    }
}
