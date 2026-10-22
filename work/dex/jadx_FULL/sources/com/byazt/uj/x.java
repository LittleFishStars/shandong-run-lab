package com.byazt.uj;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.byazt.nr.m;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 15, 71})
public abstract class x extends ve {
    public int da;
    public int sl;
    public boolean t;

    public x(com.byazt.wn.tt ttVar, Function<SparseArray<Object>, Object> function) {
        super(ttVar, function);
        this.da = 0;
        this.sl = 0;
        this.t = false;
    }

    public final void checkClick(c cVar) {
        int i = this.sl;
        if (i >= 60) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, "自定义Adapter click方法回调次数需要小于60次");
            return;
        }
        this.sl = i + 1;
        if (cVar != null) {
            cVar.c();
        }
    }

    public final void checkShow(c cVar) {
        if (!this.t) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, "自定义Adapter show方法回调必须由GroMore触发show时才会生效");
            return;
        }
        int i = this.da;
        if (i >= 2) {
            com.byazt.eu.tt.uj(MediationConstant.TAG, "自定义Adapter show方法回调次数需要小于2次");
            return;
        }
        this.da = i + 1;
        if (cVar != null) {
            cVar.c();
        }
    }

    public abstract void register(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.me.da daVar);

    @Override // com.byazt.yl.ve
    public void registerViewForInteraction(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.me.da daVar, List<View> list4) {
        super.registerViewForInteraction(activity, viewGroup, list, list2, list3, daVar, list4);
        try {
            this.t = true;
            register(activity, viewGroup, list, list2, list3, daVar);
        } catch (Exception e) {
            m.c(e);
        }
    }

    @Override // com.byazt.yl.ve
    public void render() {
        try {
            this.t = true;
            if (((ve) this).i != null) {
                ((ve) this).i.apply(com.byazt.yxi.uj.c().c(6083).c(Void.class).tt());
            }
        } catch (Exception e) {
            m.c(e);
        }
    }
}
