package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.zj.adlib.as1;
import com.zj.adlib.l88;
import com.zj.adlib.n88;
import com.zj.adlib.yc9;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i implements PathContent, BaseKeyframeAnimation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LottieDrawable f445a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final l88 f447a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f448a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public List<ShapeModifierContent> f449a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f450a;
    public boolean b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f23342a = new Path();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final as1 f446a = new as1();

    public i(LottieDrawable lottieDrawable, BaseLayer baseLayer, n88 n88Var) {
        this.f448a = n88Var.b();
        this.f450a = n88Var.d();
        this.f445a = lottieDrawable;
        l88 l88VarA = n88Var.c().a();
        this.f447a = l88VarA;
        baseLayer.j(l88VarA);
        l88VarA.a(this);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:12:0x002a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    /* JADX WARN: Code duplicated, block: B:21:0x0036 A[SYNTHETIC] */
    @Override // com.airbnb.lottie.animation.content.Content
    public void c(List<Content> list, List<Content> list2) {
        ArrayList arrayList = null;
        for (int i = 0; i < list.size(); i++) {
            Content content = list.get(i);
            if (content instanceof yc9) {
                yc9 yc9Var = (yc9) content;
                if (yc9Var.getType() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f446a.a(yc9Var);
                    yc9Var.e(this);
                } else if (!(content instanceof ShapeModifierContent)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((ShapeModifierContent) content);
                }
            } else if (!(content instanceof ShapeModifierContent)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((ShapeModifierContent) content);
            }
        }
        this.f447a.n(arrayList);
    }

    public final void e() {
        this.b = false;
        this.f445a.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path f() {
        if (this.b) {
            return this.f23342a;
        }
        this.f23342a.reset();
        if (this.f450a) {
            this.b = true;
            return this.f23342a;
        }
        Path pathF = this.f447a.f();
        if (pathF == null) {
            return this.f23342a;
        }
        this.f23342a.set(pathF);
        this.f23342a.setFillType(Path.FillType.EVEN_ODD);
        this.f446a.b(this.f23342a);
        this.b = true;
        return this.f23342a;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f448a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void h() {
        e();
    }
}
