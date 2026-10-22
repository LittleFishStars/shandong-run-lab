package com.zj.adlib;

import androidx.annotation.Nullable;
import com.huachenjie.common.step.StepCountListener;
import com.huachenjie.common.step.StepValuePassListener;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class hr8 implements StepCountListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StepValuePassListener f42186a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nr8 f17057a;

    public hr8() {
        nr8 nr8Var = new nr8();
        this.f17057a = nr8Var;
        nr8Var.f(this);
    }

    @Override // com.huachenjie.common.step.StepCountListener
    public void a() {
        e();
    }

    @Nullable
    public List<AccData> b() {
        return null;
    }

    public nr8 c() {
        return this.f17057a;
    }

    public void d(StepValuePassListener listener) {
        this.f42186a = listener;
    }

    public final void e() {
        StepValuePassListener stepValuePassListener = this.f42186a;
        if (stepValuePassListener != null) {
            stepValuePassListener.a(1);
        }
    }
}
