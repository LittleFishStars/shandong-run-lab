package com.byazt.nk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.oq.WriggleGuideAnimationView;
import com.byazt.tm.DynamicBaseWidget;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 234, 145})
public class my implements sp<WriggleGuideAnimationView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28834a;
    public int c;
    public com.byazt.aq.sp n;
    public com.byazt.aq.da sp;
    public WriggleGuideAnimationView tt;
    public DynamicBaseWidget uj;
    public Context ve;
    public boolean x;

    public my(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.aq.sp spVar, String str, com.byazt.aq.da daVar, boolean z, int i) {
        this.ve = context;
        this.uj = dynamicBaseWidget;
        this.n = spVar;
        this.f28834a = str;
        this.sp = daVar;
        this.x = z;
        this.c = i;
        n();
    }

    private void n() {
        int iLr = this.n.lr();
        final com.byazt.wl.c dynamicClickListener = this.uj.getDynamicClickListener();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("convertActionType", 2);
            dynamicClickListener.c(jSONObject);
        } catch (Throwable unused) {
        }
        if ("18".equals(this.f28834a)) {
            Context context = this.ve;
            WriggleGuideAnimationView wriggleGuideAnimationView = new WriggleGuideAnimationView(context, com.byazt.xc.tt.i(context), this.sp, this.x, this.c);
            this.tt = wriggleGuideAnimationView;
            if (wriggleGuideAnimationView.getWriggleLayout() != null) {
                this.tt.getWriggleLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
            if (this.tt.getTopTextView() != null) {
                if (TextUtils.isEmpty(this.n.r())) {
                    this.tt.getTopTextView().setText("扭动手机 或 点击图标");
                } else {
                    this.tt.getTopTextView().setText(this.n.r());
                }
            }
        } else {
            Context context2 = this.ve;
            this.tt = new WriggleGuideAnimationView(context2, com.byazt.xc.tt.i(context2), this.sp, this.x, this.c);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        this.tt.setTranslationY(-((int) com.byazt.or.x.c(this.ve, iLr)));
        this.tt.setLayoutParams(layoutParams);
        this.tt.setShakeText(this.n.lt());
        this.tt.setClipChildren(false);
        final View wriggleProgressIv = this.tt.getWriggleProgressIv();
        this.tt.setOnShakeViewListener(new WriggleGuideAnimationView.c() { // from class: com.byazt.nk.my.1
            @Override // com.byazt.oq.WriggleGuideAnimationView.c
            public void c() {
                if (wriggleProgressIv != null) {
                    if (my.this.tt != null) {
                        my.this.tt.setOnClickListener((View.OnClickListener) dynamicClickListener);
                        my.this.tt.performClick();
                    }
                    if (my.this.n == null || !my.this.n.kp()) {
                        return;
                    }
                    my.this.tt.setOnClickListener(null);
                }
            }
        });
    }

    @Override // com.byazt.nk.sp
    /* JADX INFO: renamed from: uj, reason: merged with bridge method [inline-methods] */
    public WriggleGuideAnimationView ve() {
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
