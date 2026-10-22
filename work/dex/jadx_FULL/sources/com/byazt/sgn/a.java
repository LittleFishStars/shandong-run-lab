package com.byazt.sgn;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.ff.TTProgressBar;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 211, 34})
public class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f29008a;
    public TTProgressBar c;
    public View da;
    public View gt;
    public Button i;
    public String m;
    public boolean my;
    public TextView n;
    public int nu;
    public String rh;
    public ViewGroup sl;
    public Button sp;
    public Context t;
    public c tt;
    public String u;
    public ImageView uj;
    public View.OnClickListener ve;
    public Button x;
    public String yp;
    public String z;

    public interface c {
        void c();

        void tt();
    }

    public a(Context context) {
        super(context);
        this.nu = -1;
        this.my = false;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.t = context;
    }

    private void n() {
        this.sp = (Button) findViewById(2114387829);
        this.x = (Button) findViewById(2114387914);
        this.n = (TextView) findViewById(2114387802);
        this.f29008a = (TextView) findViewById(2114387857);
        this.uj = (ImageView) findViewById(2114387832);
        this.da = findViewById(2114387775);
        this.sl = (ViewGroup) findViewById(2114387849);
        this.i = (Button) findViewById(2114387749);
    }

    private void uj() {
        Button button;
        if (this.n != null) {
            if (TextUtils.isEmpty(this.yp)) {
                this.n.setVisibility(8);
            } else {
                this.n.setText(this.yp);
                this.n.setVisibility(0);
            }
        }
        if (this.f29008a != null && !TextUtils.isEmpty(this.u)) {
            this.f29008a.setText(this.u);
        }
        if (this.x != null) {
            if (TextUtils.isEmpty(this.z)) {
                this.x.setText("确定");
            } else {
                this.x.setText(this.z);
            }
            int i = this.nu;
            if (i != -1) {
                this.x.setBackgroundColor(i);
            }
        }
        if (this.sp != null) {
            if (TextUtils.isEmpty(this.m)) {
                this.sp.setText(OptionsPickerHelper.e);
            } else {
                this.sp.setText(this.m);
            }
        }
        ImageView imageView = this.uj;
        if (imageView != null) {
            String str = this.rh;
            if (str != null) {
                com.byazt.nr.z.c(this.t, str, imageView, 320);
                this.uj.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        View view = this.da;
        if (view == null || (button = this.sp) == null) {
            return;
        }
        if (this.my) {
            view.setVisibility(8);
            this.sp.setVisibility(8);
            return;
        }
        button.setVisibility(0);
        View view2 = this.da;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    private void ve() {
        pf.c(this.x, new View.OnClickListener() { // from class: com.byazt.sgn.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = a.this.tt;
                if (cVar != null) {
                    cVar.c();
                }
            }
        }, "positiveBn");
        pf.c(this.sp, new View.OnClickListener() { // from class: com.byazt.sgn.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = a.this.tt;
                if (cVar != null) {
                    cVar.tt();
                }
            }
        }, "negtiveBn");
        pf.c(this.i, new View.OnClickListener() { // from class: com.byazt.sgn.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View.OnClickListener onClickListener = a.this.ve;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }, "dialog_change_btn");
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(false);
        View viewQ = this.gt;
        if (viewQ == null) {
            viewQ = com.byazt.vfu.a.q(this.t);
        }
        setContentView(viewQ);
        n();
        uj();
        ve();
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            uj();
        } catch (Exception unused) {
        }
    }

    public a tt(String str) {
        this.yp = str;
        return this;
    }

    public a c(c cVar) {
        this.tt = cVar;
        return this;
    }

    public void tt() {
        ViewGroup viewGroup = this.sl;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public a c(View.OnClickListener onClickListener) {
        this.ve = onClickListener;
        return this;
    }

    public a c(String str) {
        this.u = str;
        return this;
    }

    public a ve(String str) {
        this.z = str;
        return this;
    }

    public a c(int i) {
        this.nu = i;
        return this;
    }

    public a c(View view) {
        this.gt = view;
        return this;
    }

    public void c() {
        if (this.sl == null) {
            return;
        }
        if (this.c == null) {
            try {
                this.c = new TTProgressBar(this.t);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(240, 240);
                layoutParams.gravity = 17;
                this.c.setLayoutParams(layoutParams);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor("#77000000"));
                gradientDrawable.setCornerRadius(pf.ve(this.t, 2.0f));
                this.c.setBackground(gradientDrawable);
                int iVe = pf.ve(this.t, 10.0f);
                this.c.setPadding(iVe, iVe, iVe, iVe);
                com.byazt.nr.z.c(this.t, "tt_normalscreen_loading", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.sgn.a.4
                    @Override // com.byazt.qr.c
                    public void c(Bitmap bitmap) {
                        a.this.c.setIndeterminateDrawable(com.byazt.vfu.n.c(a.this.t, new BitmapDrawable(a.this.t.getResources(), bitmap), 0, 360, 0.5f, 0.5f));
                    }
                }, 320);
                this.sl.addView(this.c);
            } catch (Exception unused) {
            }
        }
        this.sl.setVisibility(0);
    }

    public a n(String str) {
        this.rh = str;
        return this;
    }

    public a uj(String str) {
        this.m = str;
        return this;
    }
}
