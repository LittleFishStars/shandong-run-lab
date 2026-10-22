package com.byazt.tm;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.aq.sp;
import com.byazt.aq.x;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 2103})
public class DynamicPrivacyView extends DynamicBaseWidgetImp {
    public TextView c;
    public TextView gt;
    public LinearLayout gu;
    public TextView qy;
    public TextView rl;
    public TextView tt;

    public DynamicPrivacyView(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.c = new TextView(this.sl);
        this.tt = new TextView(this.sl);
        this.gt = new TextView(this.sl);
        this.gu = new LinearLayout(this.sl);
        this.rl = new TextView(this.sl);
        this.qy = new TextView(this.sl);
        this.c.setTag(9);
        this.tt.setTag(10);
        this.gt.setTag(12);
        this.gu.addView(this.gt);
        this.gu.addView(this.qy);
        this.gu.addView(this.tt);
        this.gu.addView(this.rl);
        this.gu.addView(this.c);
        addView(this.gu, getWidgetLayoutParams());
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.sp, this.x);
    }

    @Override // com.byazt.tm.DynamicBaseWidget
    public boolean ve() {
        this.c.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.c.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.tt.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.tt.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.gt.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.gt.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        return true;
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        this.gt.setText("功能");
        this.tt.setText("权限");
        this.rl.setText(" | ");
        this.qy.setText(" | ");
        this.c.setText("隐私");
        sp spVar = this.t;
        if (spVar != null) {
            this.gt.setTextColor(spVar.sp());
            this.gt.setTextSize(this.t.n());
            this.tt.setTextColor(this.t.sp());
            this.tt.setTextSize(this.t.n());
            this.rl.setTextColor(this.t.sp());
            this.qy.setTextColor(this.t.sp());
            this.c.setTextColor(this.t.sp());
            this.c.setTextSize(this.t.n());
            return false;
        }
        this.gt.setTextColor(-1);
        this.gt.setTextSize(12.0f);
        this.tt.setTextColor(-1);
        this.tt.setTextSize(12.0f);
        this.rl.setTextColor(-1);
        this.qy.setTextColor(-1);
        this.c.setTextColor(-1);
        this.c.setTextSize(12.0f);
        return false;
    }
}
