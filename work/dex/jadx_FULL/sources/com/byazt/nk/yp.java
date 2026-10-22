package com.byazt.nk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.triver.kit.api.TinyApp;
import com.byazt.oq.ShakeAnimationView;
import com.byazt.tm.DynamicBaseWidget;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 234, 215})
public class yp implements sp<ShakeAnimationView>, z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28835a;
    public int c;
    public com.byazt.aq.sp n;
    public com.byazt.aq.da sp;
    public ShakeAnimationView tt;
    public DynamicBaseWidget uj;
    public Context ve;
    public boolean x;

    public yp(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.aq.sp spVar, String str, com.byazt.aq.da daVar, boolean z, int i) {
        this.ve = context;
        this.uj = dynamicBaseWidget;
        this.n = spVar;
        this.f28835a = str;
        this.sp = daVar;
        this.x = z;
        this.c = i;
        a();
    }

    private void a() {
        final com.byazt.wl.c dynamicClickListener = this.uj.getDynamicClickListener();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("convertActionType", 1);
            dynamicClickListener.c(jSONObject);
        } catch (Throwable unused) {
        }
        if (TinyApp.SUB_TYPE_BRAND_ZONE.equals(this.f28835a)) {
            Context context = this.ve;
            ShakeAnimationView shakeAnimationView = new ShakeAnimationView(context, com.byazt.xc.tt.x(context), this.sp, this.x, this.c);
            this.tt = shakeAnimationView;
            if (shakeAnimationView.getShakeLayout() != null) {
                this.tt.getShakeLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
        } else {
            Context context2 = this.ve;
            this.tt = new ShakeAnimationView(context2, com.byazt.xc.tt.sp(context2), this.sp, this.x, this.c);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.tt.setGravity(17);
        layoutParams.gravity = 17;
        this.tt.setLayoutParams(layoutParams);
        this.tt.setTranslationY(com.byazt.or.x.c(this.ve, this.n.oz()));
        this.tt.setShakeText(this.n.lt());
        this.tt.setClipChildren(false);
        this.tt.setOnShakeViewListener(new ShakeAnimationView.c() { // from class: com.byazt.nk.yp.1
            @Override // com.byazt.oq.ShakeAnimationView.c
            public void c(boolean z) {
                com.byazt.wl.c cVar = dynamicClickListener;
                if (cVar != null) {
                    cVar.c(z, yp.this);
                }
                yp.this.tt.setOnClickListener((View.OnClickListener) dynamicClickListener);
                yp.this.tt.performClick();
                if (yp.this.n == null || !yp.this.n.kp()) {
                    return;
                }
                yp.this.tt.setOnClickListener(null);
            }
        });
    }

    @Override // com.byazt.nk.z
    public void n() {
        if (this.tt.getParent() != null) {
            ((ViewGroup) this.tt.getParent()).setVisibility(8);
        }
    }

    @Override // com.byazt.nk.sp
    /* JADX INFO: renamed from: uj, reason: merged with bridge method [inline-methods] */
    public ShakeAnimationView ve() {
        return this.tt;
    }

    @Override // com.byazt.nk.sp
    public void c() {
        this.tt.c();
    }

    @Override // com.byazt.nk.sp
    public void tt() {
        this.tt.clearAnimation();
    }
}
