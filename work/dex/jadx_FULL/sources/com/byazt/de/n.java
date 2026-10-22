package com.byazt.de;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.byazt.hu.u;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 111, 46})
public class n extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28394a;
    public uj c;
    public String i;
    public Activity n;
    public String sp;
    public ve tt;
    public boolean uj;
    public boolean ve;
    public String x;

    @com.byazt.zqa.c(c = {0, 1, 111, 151})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f28395a;
        public Activity c;
        public String n;
        public uj sp;
        public String tt;
        public String uj;
        public String ve;
        public ve x;

        public c(Activity activity) {
            this.c = activity;
        }

        public c c(String str) {
            this.tt = str;
            return this;
        }

        public c tt(String str) {
            this.ve = str;
            return this;
        }

        public c uj(String str) {
            this.n = str;
            return this;
        }

        public c ve(String str) {
            this.uj = str;
            return this;
        }

        public c c(boolean z) {
            this.f28395a = z;
            return this;
        }

        public c c(uj ujVar) {
            this.sp = ujVar;
            return this;
        }

        public c c(ve veVar) {
            this.x = veVar;
            return this;
        }

        public n c() {
            return new n(this.c, this.tt, this.ve, this.uj, this.n, this.f28395a, this.sp, this.x);
        }
    }

    public n(@NonNull Activity activity, String str, String str2, String str3, String str4, boolean z, @NonNull uj ujVar, ve veVar) {
        super(activity);
        this.n = activity;
        this.c = ujVar;
        this.f28394a = str;
        this.sp = str2;
        this.x = str3;
        this.i = str4;
        this.tt = veVar;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCanceledOnTouchOutside(z);
        c(this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        this.uj = true;
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.n.isFinishing()) {
            this.n.finish();
        }
        if (this.ve) {
            this.c.c();
        } else if (this.uj) {
            this.tt.delete();
        } else {
            this.c.tt();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    private void c(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(c(context, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_AUTO_RANGE_OFFSET), -2);
        linearLayout2.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setBackground(c(context, "#ffffff", 4));
        linearLayout2.setOrientation(1);
        int iC = c(context, 16);
        TextView textView = new TextView(context);
        textView.setTextSize(2, 16.0f);
        textView.setText("是否在WiFi环境下恢复下载？");
        textView.setTextColor(Color.parseColor("#222222"));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(iC, iC, iC, iC);
        textView.setLayoutParams(layoutParams3);
        if (!TextUtils.isEmpty(this.f28394a)) {
            textView.setText(this.f28394a);
        }
        linearLayout2.addView(textView);
        LinearLayout linearLayout3 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = c(context, 26);
        layoutParams4.bottomMargin = iC;
        linearLayout3.setOrientation(0);
        linearLayout3.setLayoutParams(layoutParams4);
        TextView textView2 = new TextView(context);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(c(context, 70), c(context, 33)));
        textView2.setText("管理");
        textView2.setTextColor(Color.parseColor("#CFCFCF"));
        textView2.setTextSize(2, 13.0f);
        textView2.setGravity(17);
        if (!TextUtils.isEmpty(this.i)) {
            textView2.setText(this.i);
            linearLayout3.addView(textView2);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.de.n.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    n.this.delete();
                }
            });
        }
        LinearLayout linearLayout4 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout4.setOrientation(0);
        layoutParams5.rightMargin = c(context, 16);
        linearLayout4.setGravity(5);
        linearLayout4.setLayoutParams(layoutParams5);
        TextView textView3 = new TextView(context);
        textView3.setLayoutParams(new LinearLayout.LayoutParams(c(context, 70), c(context, 33)));
        textView3.setTextColor(Color.parseColor("#CFCFCF"));
        textView3.setText("不，谢谢");
        textView3.setTextSize(2, 13.0f);
        textView3.setGravity(17);
        if (!TextUtils.isEmpty(this.x)) {
            textView3.setText(this.x);
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.de.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.this.tt();
            }
        });
        linearLayout4.addView(textView3);
        TextView textView4 = new TextView(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(c(context, 70), c(context, 33));
        layoutParams6.leftMargin = c(context, 8);
        layoutParams6.gravity = 5;
        textView4.setLayoutParams(layoutParams6);
        textView4.setTextColor(Color.parseColor("#ffffff"));
        textView4.setTextSize(2, 13.0f);
        textView4.setText("好的");
        textView4.setGravity(17);
        if (!TextUtils.isEmpty(this.sp)) {
            textView4.setText(this.sp);
        }
        textView4.setBackground(c(context, "#2A90D7", 2));
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.de.n.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.this.c();
            }
        });
        linearLayout4.addView(textView4);
        linearLayout3.addView(linearLayout4);
        linearLayout2.addView(linearLayout3);
        linearLayout.addView(linearLayout2);
        setContentView(linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt() {
        dismiss();
    }

    private static GradientDrawable c(Context context, String str, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius(c(context, i));
        return gradientDrawable;
    }

    private static int c(Context context, int i) {
        return u.c(context, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.ve = true;
        dismiss();
    }
}
