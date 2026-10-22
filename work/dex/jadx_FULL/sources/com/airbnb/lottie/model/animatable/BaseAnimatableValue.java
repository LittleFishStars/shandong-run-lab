package com.airbnb.lottie.model.animatable;

import com.zj.adlib.ps4;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ps4<V>> f23368a;

    public BaseAnimatableValue(V v) {
        this(Collections.singletonList(new ps4(v)));
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List<ps4<V>> b() {
        return this.f23368a;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean isStatic() {
        if (this.f23368a.isEmpty()) {
            return true;
        }
        return this.f23368a.size() == 1 && this.f23368a.get(0).h();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f23368a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.f23368a.toArray()));
        }
        return sb.toString();
    }

    public BaseAnimatableValue(List<ps4<V>> list) {
        this.f23368a = list;
    }
}
