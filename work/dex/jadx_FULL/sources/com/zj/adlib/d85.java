package com.zj.adlib;

import android.graphics.Path;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d85 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<BaseKeyframeAnimation<g88, Path>> f41125a;
    public final List<BaseKeyframeAnimation<Integer, Integer>> b;
    public final List<Mask> c;

    public d85(List<Mask> list) {
        this.c = list;
        this.f41125a = new ArrayList(list.size());
        this.b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.f41125a.add(list.get(i).b().a());
            this.b.add(list.get(i).c().a());
        }
    }

    public List<BaseKeyframeAnimation<g88, Path>> a() {
        return this.f41125a;
    }

    public List<Mask> b() {
        return this.c;
    }

    public List<BaseKeyframeAnimation<Integer, Integer>> c() {
        return this.b;
    }
}
