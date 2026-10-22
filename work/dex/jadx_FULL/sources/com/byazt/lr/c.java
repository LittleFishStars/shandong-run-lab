package com.byazt.lr;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.byazt.gq.t;
import com.byazt.hu.u;
import com.byazt.ok.ClipImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 155, 20})
public class c extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f28778a;
    public TextView c;
    public final long da;
    public Activity i;
    public TextView n;
    public long sl;
    public ClipImageView sp;
    public final com.byazt.nn.tt t;
    public TextView tt;
    public TextView uj;
    public TextView ve;
    public LinearLayout x;

    public c(@NonNull Activity activity, long j) {
        super(activity);
        this.i = activity;
        this.da = j;
        this.t = ve.c().get(Long.valueOf(j));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.byazt.z.ve.c(this.i);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.t == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(c());
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.sl = this.t.tt;
        tt();
        sp.tt("lp_app_dialog_show", this.sl);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.byazt.lr.c.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                sp.c("lp_app_dialog_cancel", c.this.sl);
            }
        });
    }

    private View c() {
        LinearLayout linearLayout = new LinearLayout(this.i);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(u.c(this.i, 6.0f));
        linearLayout.setBackgroundDrawable(gradientDrawable);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(u.c(this.i, 300.0f), -2));
        this.sp = new ClipImageView(this.i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(u.c(this.i, 60.0f), u.c(this.i, 60.0f));
        layoutParams.topMargin = u.c(this.i, 32.0f);
        this.sp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        linearLayout.addView(this.sp, layoutParams);
        this.c = new TextView(this.i);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = u.c(this.i, 8.0f);
        this.c.setTextSize(1, 18.0f);
        this.c.setTextColor(Color.parseColor("#161823"));
        this.c.getPaint().setFakeBoldText(true);
        linearLayout.addView(this.c, layoutParams2);
        this.tt = new TextView(this.i);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = u.c(this.i, 8.0f);
        this.tt.setTextSize(1, 12.0f);
        this.tt.setTextColor(Color.parseColor("#4D161823"));
        linearLayout.addView(this.tt, layoutParams3);
        this.ve = new TextView(this.i);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = u.c(this.i, 4.0f);
        this.ve.setTextSize(1, 12.0f);
        this.ve.setTextColor(Color.parseColor("#4D161823"));
        linearLayout.addView(this.ve, layoutParams4);
        LinearLayout linearLayout2 = new LinearLayout(this.i);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        linearLayout2.setPadding(0, u.c(this.i, 4.0f), 0, u.c(this.i, 4.0f));
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = u.c(this.i, 14.0f);
        TextView textView = new TextView(this.i);
        this.uj = textView;
        textView.setText("权限详情");
        this.uj.setTextSize(1, 12.0f);
        this.uj.setTextColor(Color.parseColor("#4E90FF"));
        linearLayout2.addView(this.uj);
        View view = new View(this.i);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) ((((double) this.i.getResources().getDisplayMetrics().density) * 0.5d) + 0.5d), u.c(this.i, 9.0f));
        layoutParams6.leftMargin = u.c(this.i, 32.0f);
        layoutParams6.rightMargin = u.c(this.i, 32.0f);
        view.setBackgroundColor(Color.parseColor("#D8D8D8"));
        linearLayout2.addView(view, layoutParams6);
        TextView textView2 = new TextView(this.i);
        this.n = textView2;
        textView2.setText("隐私政策");
        this.n.setTextSize(1, 12.0f);
        this.n.setTextColor(Color.parseColor("#4E90FF"));
        linearLayout2.addView(this.n);
        linearLayout.addView(linearLayout2, layoutParams5);
        LinearLayout linearLayout3 = new LinearLayout(this.i);
        this.x = linearLayout3;
        linearLayout3.setOrientation(0);
        this.x.setGravity(17);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#4E90FF"));
        gradientDrawable2.setCornerRadius(u.c(this.i, 2.0f));
        this.x.setBackgroundDrawable(gradientDrawable2);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(u.c(this.i, 276.0f), u.c(this.i, 36.0f));
        layoutParams7.topMargin = u.c(this.i, 16.0f);
        ImageView imageView = new ImageView(this.i);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(u.c(this.i, 16.0f), u.c(this.i, 16.0f));
        layoutParams8.rightMargin = u.c(this.i, 4.0f);
        this.x.addView(imageView, layoutParams8);
        TextView textView3 = new TextView(this.i);
        textView3.setText("立即下载");
        textView3.setTextColor(-1);
        textView3.setTextSize(1, 14.0f);
        this.x.addView(textView3);
        linearLayout.addView(this.x, layoutParams7);
        TextView textView4 = new TextView(this.i);
        this.f28778a = textView4;
        textView4.setText("放弃下载");
        this.f28778a.setTextSize(1, 12.0f);
        this.f28778a.setTextColor(Color.parseColor("#4D161823"));
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.topMargin = u.c(this.i, 11.0f);
        layoutParams9.bottomMargin = u.c(this.i, 15.0f);
        linearLayout.addView(this.f28778a, layoutParams9);
        imageView.setImageDrawable(new com.byazt.gm.c());
        return linearLayout;
    }

    private void tt() {
        this.c.setText(u.c(this.t.n, "--"));
        this.tt.setText("版本号：" + u.c(this.t.f28839a, "--"));
        this.ve.setText("开发者：" + u.c(this.t.sp, "应用信息正在完善中"));
        this.sp.setRoundRadius(u.c(t.getContext(), 8.0f));
        this.sp.setBackgroundColor(Color.parseColor("#EBEBEB"));
        uj.c().c(this.da, new uj.c() { // from class: com.byazt.lr.c.2
            @Override // com.byazt.lr.uj.c
            public void c(Bitmap bitmap) {
                if (bitmap != null) {
                    c.this.sp.setImageBitmap(bitmap);
                } else {
                    sp.c(8, c.this.sl);
                }
            }
        });
        this.uj.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.lr.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                tt.c().c(c.this.i);
                sp.c("lp_app_dialog_click_detail", c.this.sl);
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.lr.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                tt.c().c(c.this.i);
                sp.c("lp_app_dialog_click_privacy", c.this.sl);
            }
        });
        this.f28778a.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.lr.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
                sp.c("lp_app_dialog_click_giveup", c.this.sl);
            }
        });
        this.x.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.lr.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                sp.c("lp_app_dialog_click_download", c.this.sl);
                tt.c().tt(c.this.sl);
                c.this.dismiss();
            }
        });
    }
}
