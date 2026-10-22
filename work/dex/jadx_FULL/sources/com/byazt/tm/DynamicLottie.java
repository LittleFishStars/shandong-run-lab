package com.byazt.tm;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.aq.a;
import com.byazt.aq.x;
import com.byazt.oq.DynamicLottieView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 1358})
public class DynamicLottie extends DynamicBaseWidgetImp {
    public String c;
    public x tt;

    public DynamicLottie(Context context, DynamicRootView dynamicRootView, x xVar, String str) {
        super(context, dynamicRootView, xVar);
        this.c = str;
        this.tt = xVar;
        DynamicLottieView lottieView = getLottieView();
        if (lottieView != null) {
            addView(lottieView, getWidgetLayoutParams());
        }
    }

    private DynamicLottieView getLottieView() {
        x xVar = this.u;
        if (xVar == null || xVar.da() == null || this.sl == null || TextUtils.isEmpty(this.c)) {
            return null;
        }
        a aVarN = this.u.da().n();
        String strOz = aVarN != null ? aVarN.oz() : "";
        if (TextUtils.isEmpty(strOz)) {
            return null;
        }
        String str = this.c + "static/lotties/" + strOz + ".json";
        DynamicLottieView dynamicLottieView = new DynamicLottieView(this.sl);
        dynamicLottieView.setImageLottieTosPath(str);
        dynamicLottieView.x();
        return dynamicLottieView;
    }
}
