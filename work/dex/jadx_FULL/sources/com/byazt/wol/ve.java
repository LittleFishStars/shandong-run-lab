package com.byazt.wol;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.ff.TTProgressBar;
import com.byazt.nr.z;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 352, 54})
public class ve extends c {
    @Override // com.byazt.lbn.c
    public View inflate(final Context context) {
        RelativeLayout relativeLayoutC = c(context, 2114387616);
        relativeLayoutC.addView(tt(context, 159));
        relativeLayoutC.setVisibility(8);
        TextView textView = new TextView(context);
        textView.setId(2114387742);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, 2114387911);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, pf.ve(context, 13.0f), 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(context.getResources().getColor(R.color.white));
        textView.setTextSize(2, 16.0f);
        relativeLayoutC.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387807);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, 2114387742);
        layoutParams2.addRule(14);
        layoutParams2.setMargins(0, pf.ve(context, 8.0f), 0, 0);
        textView2.setLayoutParams(layoutParams2);
        textView2.setTextColor(context.getResources().getColor(R.color.white));
        textView2.setTextSize(2, 12.0f);
        textView2.setText("数据加载中...");
        relativeLayoutC.addView(textView2);
        final TTProgressBar tTProgressBar = new TTProgressBar(context);
        tTProgressBar.setId(2114387683);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(pf.ve(context, 32.0f), pf.ve(context, 32.0f));
        layoutParams3.addRule(3, 2114387807);
        layoutParams3.addRule(14);
        layoutParams3.setMargins(0, pf.ve(context, 32.0f), 0, 0);
        tTProgressBar.setLayoutParams(layoutParams3);
        z.c(context, "tt_live_loading", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.wol.ve.1
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                tTProgressBar.setIndeterminateDrawable(com.byazt.vfu.n.c(context, new BitmapDrawable(context.getResources(), bitmap), 0, 360, 0.5f, 0.5f));
            }
        }, 320);
        relativeLayoutC.addView(tTProgressBar);
        relativeLayoutC.addView(c(context, 158, 6));
        return relativeLayoutC;
    }
}
