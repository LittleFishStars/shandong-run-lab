package com.byazt.xzj;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.aas.n;
import com.byazt.aas.pf;
import com.byazt.ete.a;
import com.byazt.ete.ic;
import com.byazt.zqa.c;
import com.hzchengdun.securityguard.SecExceptionCode;
import com.king.zxing.camera.CameraManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@c(c = {0, 1, CameraManager.i, SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_INIT_FAILED})
public class RewardLandingPageAppInfoView extends LinearLayout {
    public DownloadItemView c;

    public RewardLandingPageAppInfoView(Context context) {
        super(context);
    }

    private View tt(Context context, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(context);
        textView.setText("隐私");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        textView.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (i == -1) {
            layoutParams.addRule(11, -1);
        } else {
            layoutParams.addRule(0, i);
            layoutParams.rightMargin = pf.ve(context, 6.0f);
        }
        relativeLayout.addView(textView, layoutParams);
        int iVe = pf.ve(context, 6.0f);
        pf.c(textView, iVe, iVe, 0, 0);
        return textView;
    }

    private View uj(Context context, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(context);
        textView.setText("权限");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        textView.setId(View.generateViewId());
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(0, i);
        layoutParams.rightMargin = pf.ve(context, 6.0f);
        relativeLayout.addView(textView, layoutParams);
        int iVe = pf.ve(context, 6.0f);
        pf.c(textView, iVe, iVe, 0, 0);
        return textView;
    }

    private View ve(Context context, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(context);
        textView.setText("功能");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        textView.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(0, i);
        layoutParams.rightMargin = pf.ve(context, 6.0f);
        relativeLayout.addView(textView, layoutParams);
        int iVe = pf.ve(context, 6.0f);
        pf.c(textView, iVe, iVe, 0, 0);
        return textView;
    }

    public void c(ic icVar, String str) {
        if (icVar == null) {
            return;
        }
        setBackgroundColor(-1);
        setOrientation(1);
        Context context = getContext();
        c(icVar);
        a aVarRh = icVar.rh();
        if (aVarRh == null) {
            return;
        }
        int iVe = pf.ve(context, 12.0f);
        View viewC = c(context, aVarRh);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = iVe;
        addView(viewC, layoutParams);
        View viewC2 = c(context, icVar, aVarRh, str);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = iVe;
        addView(viewC2, layoutParams2);
        int iVe2 = pf.ve(context, 16.0f);
        setPadding(iVe2, iVe, iVe2, iVe);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public void setDownLoadClickListener(View.OnClickListener onClickListener) {
        DownloadItemView downloadItemView = this.c;
        if (downloadItemView == null || onClickListener == null) {
            return;
        }
        downloadItemView.setOnClickListener(onClickListener);
    }

    private void c(ic icVar) {
        DownloadItemView downloadItemView = new DownloadItemView(getContext());
        this.c = downloadItemView;
        downloadItemView.c(icVar);
        addView(this.c);
    }

    private View c(Context context, a aVar) {
        TextView textView = new TextView(context);
        textView.setText(aVar.sp());
        textView.setTextColor(Color.parseColor("#888888"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        return textView;
    }

    private View c(final Context context, final ic icVar, a aVar, final String str) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        TextView textView = new TextView(context);
        textView.setText(String.format("版本号：%s", aVar.n()));
        textView.setTextColor(Color.parseColor("#888888"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int id = -1;
        layoutParams.addRule(9, -1);
        textView.setId(View.generateViewId());
        relativeLayout.addView(textView, layoutParams);
        if (!TextUtils.isEmpty(aVar.sl())) {
            View viewC = c(context, relativeLayout);
            id = c(context, relativeLayout, viewC.getId()).getId();
            viewC.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.xzj.RewardLandingPageAppInfoView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    n.c(icVar, context, str);
                }
            });
        }
        View viewTt = tt(context, relativeLayout, id);
        viewTt.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.xzj.RewardLandingPageAppInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.tt(icVar, context, str);
            }
        });
        View viewUj = uj(context, relativeLayout, c(context, relativeLayout, viewTt.getId()).getId());
        viewUj.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.xzj.RewardLandingPageAppInfoView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.ve(icVar, context, str);
            }
        });
        ve(context, relativeLayout, c(context, relativeLayout, viewUj.getId()).getId()).setOnClickListener(new View.OnClickListener() { // from class: com.byazt.xzj.RewardLandingPageAppInfoView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.c(context, icVar, str);
            }
        });
        return relativeLayout;
    }

    private View c(Context context, RelativeLayout relativeLayout, int i) {
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#22000000"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(pf.ve(context, 1.5f), pf.ve(context, 8.0f));
        layoutParams.rightMargin = pf.ve(context, 6.0f);
        view.setId(View.generateViewId());
        layoutParams.addRule(0, i);
        layoutParams.addRule(15, -1);
        relativeLayout.addView(view, layoutParams);
        return view;
    }

    private View c(Context context, RelativeLayout relativeLayout) {
        TextView textView = new TextView(context);
        textView.setText("备案");
        textView.setTextColor(Color.parseColor("#262626"));
        textView.setTextSize(2, 10.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(10);
        }
        textView.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11, -1);
        relativeLayout.addView(textView, layoutParams);
        int iVe = pf.ve(context, 6.0f);
        pf.c(textView, iVe, iVe, 0, 0);
        return textView;
    }
}
