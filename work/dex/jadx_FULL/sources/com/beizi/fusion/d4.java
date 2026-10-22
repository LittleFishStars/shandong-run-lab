package com.beizi.fusion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.BZVideoView;
import com.beizi.fusion.widget.CustomRoundImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d4 extends l3 {
    private RelativeLayout d1;
    private TextView e1;
    private TextView f1;
    private TextView g1;
    private ImageView h1;
    private ImageView i1;
    private CustomRoundImageView j1;
    private RelativeLayout k1;

    public class a implements v5.b {
        public a() {
        }

        @Override // com.beizi.fusion.v5.b
        public void a(String str) {
            try {
                d4 d4Var = d4.this;
                co.b(d4Var.U, d4Var.v0, Long.valueOf(System.currentTimeMillis()));
                d4.this.b.setComplain(str);
                d4.this.H0();
                d4.this.c0();
                d4.this.h1();
                if (d4.this.d != null && d4.this.d.z() != 2) {
                    d4.this.d.a(d4.this.x(), d4.this.b0);
                }
                d4.this.b0();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1) {
                return false;
            }
            d4.this.m0 = motionEvent.getX();
            d4.this.n0 = motionEvent.getY();
            d4.this.o0 = motionEvent.getRawX();
            d4.this.p0 = motionEvent.getRawY();
            return false;
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (!d4.this.V0()) {
                    d4.this.e1();
                    return;
                }
                d4 d4Var = d4.this;
                d4Var.N0 = false;
                d4.this.a(new String[]{String.valueOf(d4Var.m0), String.valueOf(d4.this.n0), String.valueOf(d4.this.o0), String.valueOf(d4.this.p0)}, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class e implements BZVideoView.i {
        public e() {
        }

        @Override // com.beizi.fusion.widget.BZVideoView.i
        public void a(int i, int i2) {
            d4.this.a(i, i2);
        }

        @Override // com.beizi.fusion.widget.BZVideoView.i
        public void b() {
            d4 d4Var = d4.this;
            if (d4Var.Y0) {
                return;
            }
            d4Var.Y0 = true;
            d4Var.b(0);
        }

        @Override // com.beizi.fusion.widget.BZVideoView.i
        public void a() {
            d4 d4Var = d4.this;
            if (d4Var.c1) {
                return;
            }
            d4Var.c1 = true;
            d4Var.b(100);
        }
    }

    public d4(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, m3 m3Var, float f, float f2) {
        super(context, str, j, j2, buyerBean, forwardBean, m3Var, f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f1() {
        try {
            if (this.r0 == null) {
                return;
            }
            LinearLayout linearLayout = new LinearLayout(this.U);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout frameLayoutB = bq.b(this.U, this.r0.n());
            frameLayoutB.setVisibility(0);
            linearLayout.addView(frameLayoutB, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            View viewA = bq.a(this.U, this.r0.a());
            viewA.setVisibility(0);
            linearLayout.addView(viewA, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewA.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            viewA.setLayoutParams(layoutParams);
            this.a0.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams2.setMargins(0, 0, 15, 15);
            linearLayout.setLayoutParams(layoutParams2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void g1() {
        try {
            mi miVar = this.r0;
            if (miVar == null) {
                return;
            }
            of.a((Context) null).a(miVar.getImageUrl(), new b());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1() {
        try {
            LinearLayout linearLayout = new LinearLayout(this.U);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
            ImageView imageView = new ImageView(this.U);
            imageView.setImageResource(R.drawable.beizi_icon_checkbox);
            imageView.setColorFilter(Color.parseColor("#000000"));
            linearLayout.addView(imageView);
            TextView textView = new TextView(this.U);
            textView.setText("投诉成功，我们将重视您的反馈。");
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setTextSize(2, 13.0f);
            textView.setGravity(17);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(20, 0, 0, 0);
            linearLayout.addView(textView, layoutParams);
            this.b0.measure(0, 0);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.b0.getMeasuredWidth(), this.b0.getMeasuredHeight());
            layoutParams2.gravity = 17;
            this.a0.addView(linearLayout, layoutParams2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1() {
        try {
            AdSpacesBean.ComplainBean complainBean = this.u0;
            if (complainBean != null && complainBean.getOpen() == 1) {
                v5 v5Var = new v5();
                v5Var.a(this.U, this.a0, "3");
                v5Var.a(new a());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1() {
        View viewA;
        try {
            mi miVar = this.r0;
            if (miVar == null || miVar.p() == null || (viewA = pi.a(this.U, this.r0)) == null) {
                return;
            }
            this.a0.measure(0, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((this.a0.getMeasuredWidth() * 2) / 3, -2);
            layoutParams.gravity = 83;
            this.a0.addView(viewA, layoutParams);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x006e  */
    private void k1() {
        float fM;
        int iA;
        try {
            if (TextUtils.isEmpty(this.V0) || this.U0 == null) {
                return;
            }
            String strG = this.r0.g();
            boolean zH = this.r0.h();
            this.U0.setPlayProgressCallback(new e());
            this.U0.initVideoResource(this.V0, strG, zH);
            this.U0.setVisibility(0);
            int iA2 = (int) (((double) so.a(this.U, this.Y)) * 0.285d);
            float f = this.Z;
            if (f > 0.0f) {
                iA = so.a(this.U, f - 20.0f);
            } else {
                mi miVar = this.r0;
                if (miVar != null) {
                    fM = (float) ((((double) miVar.m()) * 1.0d) / ((double) this.r0.o()));
                    if (fM <= 1.0f) {
                        fM = 1.7f;
                    }
                } else {
                    fM = 1.7f;
                }
                iA = ((int) (iA2 / fM)) - so.a(this.U, 20.0f);
            }
            ViewGroup.LayoutParams layoutParams = this.U0.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = iA2;
                layoutParams.height = iA;
                this.U0.setLayoutParams(layoutParams);
            }
            RelativeLayout relativeLayout = this.k1;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundColor(Color.parseColor("#000000"));
            }
            a((View) this.U0);
            i1();
            j1();
            f1();
            Z0();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.l3
    public void b1() {
        try {
            if (this.r0 == null) {
                a(-991);
                return;
            }
            View viewInflate = LayoutInflater.from(this.U).inflate(R.layout.beizi_layout_native_left_text_right_picture_view, (ViewGroup) null);
            this.t0 = viewInflate;
            this.d1 = (RelativeLayout) viewInflate.findViewById(R.id.native_ad_ltrg_content_rl);
            LinearLayout linearLayout = (LinearLayout) this.t0.findViewById(R.id.native_ad_ltrg_title_ll);
            this.e1 = (TextView) this.t0.findViewById(R.id.native_ad_ltrg_title_tv);
            RelativeLayout relativeLayout = (RelativeLayout) this.t0.findViewById(R.id.native_ad_ltrg_subtitle_rl);
            this.f1 = (TextView) this.t0.findViewById(R.id.native_ad_ltrg_subtitle_tv);
            this.g1 = (TextView) this.t0.findViewById(R.id.native_ad_ltrg_go_tv);
            this.h1 = (ImageView) this.t0.findViewById(R.id.native_ad_ltrg_go_iv);
            this.k1 = (RelativeLayout) this.t0.findViewById(R.id.native_ad_ltrg_image_rl);
            this.j1 = (CustomRoundImageView) this.t0.findViewById(R.id.native_ad_ltrg_image_iv);
            this.U0 = (BZVideoView) this.t0.findViewById(R.id.native_ad_ltrg_video_iv);
            this.i1 = (ImageView) this.t0.findViewById(R.id.native_ad_ltrg_ad_text_iv);
            RelativeLayout relativeLayout2 = this.d1;
            if (relativeLayout2 != null) {
                relativeLayout2.setPadding(0, so.a(this.U, 10.0f), so.a(this.U, 10.0f), 0);
            }
            if (linearLayout != null) {
                linearLayout.setPadding(so.a(this.U, 20.0f), so.a(this.U, 8.0f), so.a(this.U, 11.0f), 0);
            }
            String strB = this.r0.b();
            if (this.e1 != null && !TextUtils.isEmpty(strB)) {
                this.e1.setText(strB);
            }
            if (relativeLayout != null) {
                relativeLayout.setPadding(0, so.a(this.U, 5.0f), 0, 0);
            }
            String strD = this.r0.d();
            if (this.f1 != null && !TextUtils.isEmpty(strD)) {
                this.f1.setText(strD);
            }
            ImageView imageView = this.i1;
            if (imageView != null) {
                imageView.setPadding(0, so.a(this.U, 10.0f), 0, 0);
            }
            TextView textView = this.g1;
            if (textView != null) {
                vn.a(textView, "#71A0FF", 0, null, so.a(this.U, 10.0f));
            }
            a(this.g1, this.h1);
            mi miVar = this.r0;
            if (miVar != null) {
                String strQ = miVar.q();
                this.V0 = strQ;
                if (TextUtils.isEmpty(strQ)) {
                    g1();
                } else {
                    k1();
                }
            }
            c1();
            d1();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.beizi.fusion.l3
    public void a(mi miVar) {
        try {
            ImageView imageView = new ImageView(this.U);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(65, 65);
            imageView.setPadding(15, 8, 8, 15);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.beizi_close);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(65, 65);
            layoutParams2.gravity = 5;
            this.a0.addView(imageView, layoutParams2);
            imageView.setOnTouchListener(new c());
            imageView.setOnClickListener(new d());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public class b implements of.f {
        public b() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                try {
                    if (d4.this.U == null) {
                        return;
                    }
                    Log.d("BeiZis", "showBeiZiUnifiedCustomAd onBitmapLoaded width:" + bitmap.getWidth() + ";height:" + bitmap.getHeight());
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    float f = (float) ((((double) width) * 1.0d) / ((double) height));
                    d4 d4Var = d4.this;
                    int iA = (int) (((double) so.a(d4Var.U, d4Var.Y)) * 0.285d);
                    d4 d4Var2 = d4.this;
                    float f2 = d4Var2.Z;
                    int iA2 = f2 > 0.0f ? so.a(d4Var2.U, f2) - so.a(d4.this.U, 20.0f) : (int) (iA / f);
                    d4 d4Var3 = d4.this;
                    d4Var3.A0 = iA;
                    d4Var3.B0 = iA2;
                    if (iA2 < 0) {
                        d4Var3.B0 = height;
                    }
                    CustomRoundImageView customRoundImageView = d4Var3.j1;
                    if (customRoundImageView != null) {
                        customRoundImageView.setVisibility(0);
                        ViewGroup.LayoutParams layoutParams = d4.this.j1.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = iA;
                            layoutParams.height = iA2;
                            d4.this.j1.setLayoutParams(layoutParams);
                        }
                    }
                    d4 d4Var4 = d4.this;
                    CustomRoundImageView customRoundImageView2 = d4Var4.j1;
                    if (customRoundImageView2 != null) {
                        customRoundImageView2.setRectRadius(so.a(d4Var4.U, 8.0f));
                        d4 d4Var5 = d4.this;
                        d4Var5.a(iA, iA2, f, bitmap, d4Var5.j1);
                        d4.this.j1.setImageBitmap(bitmap);
                    }
                    d4 d4Var6 = d4.this;
                    d4Var6.a(d4Var6.j1);
                    d4.this.i1();
                    d4.this.j1();
                    d4.this.f1();
                    d4.this.Z0();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
            Log.d("BeiZis", "showBeiZiUnifiedCustomAd onBitmapLoadFailed");
            d4.this.a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
        }
    }
}
