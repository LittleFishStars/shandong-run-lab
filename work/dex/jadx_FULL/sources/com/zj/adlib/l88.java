package com.zj.adlib;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.airbnb.lottie.animation.content.ShapeModifierContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class l88 extends BaseKeyframeAnimation<g88, Path> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f43017a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g88 f17906a;
    public List<ShapeModifierContent> b;

    public l88(List<ps4<g88>> list) {
        super(list);
        this.f17906a = new g88();
        this.f43017a = new Path();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public Path g(ps4<g88> ps4Var, float f) {
        this.f17906a.c(ps4Var.f18928a, ps4Var.f18932b, f);
        g88 g88VarD = this.f17906a;
        List<ShapeModifierContent> list = this.b;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                g88VarD = this.b.get(size).d(g88VarD);
            }
        }
        up5.i(g88VarD, this.f43017a);
        return this.f43017a;
    }

    public void n(@Nullable List<ShapeModifierContent> list) {
        this.b = list;
    }
}
