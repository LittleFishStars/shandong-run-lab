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
public class e4 extends l3 {
    private LinearLayout d1;
    private LinearLayout e1;
    private FrameLayout f1;
    private CustomRoundImageView g1;
    private TextView h1;
    private TextView i1;
    private TextView j1;
    private ImageView k1;

    public class a implements v5.b {
        public a() {
        }

        @Override // com.beizi.fusion.v5.b
        public void a(String str) {
            try {
                e4 e4Var = e4.this;
                co.b(e4Var.U, e4Var.v0, Long.valueOf(System.currentTimeMillis()));
                e4.this.b.setComplain(str);
                e4.this.H0();
                e4.this.c0();
                e4.this.h1();
                if (e4.this.d != null && e4.this.d.z() != 2) {
                    e4.this.d.a(e4.this.x(), e4.this.b0);
                }
                e4.this.b0();
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
            e4.this.m0 = motionEvent.getX();
            e4.this.n0 = motionEvent.getY();
            e4.this.o0 = motionEvent.getRawX();
            e4.this.p0 = motionEvent.getRawY();
            return false;
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (!e4.this.V0()) {
                    e4.this.e1();
                    return;
                }
                e4 e4Var = e4.this;
                e4Var.N0 = false;
                e4.this.a(new String[]{String.valueOf(e4Var.m0), String.valueOf(e4.this.n0), String.valueOf(e4.this.o0), String.valueOf(e4.this.p0)}, 0);
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
            e4.this.a(i, i2);
        }

        @Override // com.beizi.fusion.widget.BZVideoView.i
        public void b() {
            e4 e4Var = e4.this;
            if (e4Var.Y0) {
                return;
            }
            e4Var.Y0 = true;
            e4Var.b(0);
        }

        @Override // com.beizi.fusion.widget.BZVideoView.i
        public void a() {
            e4 e4Var = e4.this;
            if (e4Var.c1) {
                return;
            }
            e4Var.c1 = true;
            e4Var.b(100);
        }
    }

    public e4(Context context, String str, long j, long j2, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, m3 m3Var, float f, float f2) {
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
            this.a0.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 53));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            if (U0()) {
                layoutParams2.setMargins(0, so.a(this.U, 16.0f), so.a(this.U, 40.0f), 0);
            } else {
                layoutParams2.setMargins(0, so.a(this.U, 16.0f), so.a(this.U, 16.0f), 0);
            }
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
            linearLayout.setOrientation(1);
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
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 30, 0, 0);
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
                v5Var.a(this.U, this.a0, "2");
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
            this.f1.measure(0, 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((this.f1.getMeasuredWidth() * 2) / 3, -2);
            layoutParams.gravity = 83;
            this.f1.addView(viewA, layoutParams);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x007d  */
    private void k1() {
        float f;
        int iA;
        try {
            if (TextUtils.isEmpty(this.V0) || this.U0 == null) {
                return;
            }
            String strG = this.r0.g();
            boolean zH = this.r0.h();
            this.U0.setPlayProgressCallback(new e());
            this.U0.initVideoResource(this.V0, strG, zH);
            int measuredHeight = 0;
            this.U0.setVisibility(0);
            int iA2 = so.a(this.U, this.Y - 16.0f);
            if (this.Z > 0.0f) {
                LinearLayout linearLayout = this.e1;
                if (linearLayout != null) {
                    linearLayout.measure(0, 0);
                    measuredHeight = this.e1.getMeasuredHeight();
                }
                iA = so.a(this.U, this.Z - 16.0f);
                if (iA > measuredHeight) {
                    iA -= measuredHeight;
                }
            } else {
                mi miVar = this.r0;
                if (miVar != null) {
                    int iM = miVar.m();
                    int iO = this.r0.o();
                    if (iM <= 0 || iO <= 0) {
                        f = 1.7f;
                    } else {
                        f = (float) ((((double) iM) * 1.0d) / ((double) iO));
                        if (f <= 1.0f) {
                            f = 1.7f;
                        }
                    }
                } else {
                    f = 1.7f;
                }
                iA = (int) (iA2 / f);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, iA);
            FrameLayout frameLayout = this.f1;
            if (frameLayout != null) {
                frameLayout.setLayoutParams(layoutParams);
                this.f1.setBackgroundColor(Color.parseColor("#000000"));
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
            View viewInflate = LayoutInflater.from(this.U).inflate(R.layout.beizi_layout_native_top_picture_bottom_text_view, (ViewGroup) null);
            this.t0 = viewInflate;
            this.d1 = (LinearLayout) viewInflate.findViewById(R.id.native_ad_tpbt_container_ll);
            this.f1 = (FrameLayout) this.t0.findViewById(R.id.native_ad_tpbt_img_container_fl);
            this.g1 = (CustomRoundImageView) this.t0.findViewById(R.id.native_ad_tpbt_image_iv);
            this.U0 = (BZVideoView) this.t0.findViewById(R.id.native_ad_tpbt_video_iv);
            this.e1 = (LinearLayout) this.t0.findViewById(R.id.native_ad_tpbt_content_ll);
            this.h1 = (TextView) this.t0.findViewById(R.id.native_ad_tpbt_title_tv);
            this.i1 = (TextView) this.t0.findViewById(R.id.native_ad_tpbt_subtitle_tv);
            this.j1 = (TextView) this.t0.findViewById(R.id.native_ad_tpbt_go_tv);
            this.k1 = (ImageView) this.t0.findViewById(R.id.native_ad_tpbt_go_iv);
            int iA = so.a(this.U, this.Y);
            float f = this.Z;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iA, f > 0.0f ? so.a(this.U, f) : -2);
            int iA2 = so.a(this.U, 8.0f);
            LinearLayout linearLayout = this.d1;
            if (linearLayout != null) {
                linearLayout.setPadding(iA2, iA2, iA2, iA2);
                this.d1.setLayoutParams(layoutParams);
            }
            LinearLayout linearLayout2 = this.e1;
            if (linearLayout2 != null) {
                linearLayout2.setPadding(0, so.a(this.U, 8.0f), 0, so.a(this.U, 8.0f));
            }
            String strB = this.r0.b();
            if (this.h1 != null && !TextUtils.isEmpty(strB)) {
                this.h1.setText(strB);
            }
            String strD = this.r0.d();
            if (this.i1 != null && !TextUtils.isEmpty(strD)) {
                this.i1.setText(strD);
            }
            TextView textView = this.j1;
            if (textView != null) {
                textView.setBackground(this.U.getDrawable(R.drawable.beizi_bg_operate_button));
            }
            if (this.k1 != null) {
                this.k1.setLayoutParams(new RelativeLayout.LayoutParams(so.a(this.U, 63.0f), so.a(this.U, 24.0f)));
                this.k1.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            a(this.j1, this.k1);
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
            int iA = so.a(this.U, 24.0f) + 42;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
            int iA2 = so.a(this.U, 16.0f);
            int iA3 = so.a(this.U, 8.0f);
            imageView.setPadding(iA3, iA2, iA2, iA3);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.beizi_close_two);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iA, iA);
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
            int measuredHeight;
            if (bitmap != null) {
                try {
                    if (e4.this.U == null) {
                        return;
                    }
                    Log.d("BeiZis", "showBeiZiNativeAd onBitmapLoaded width:" + bitmap.getWidth() + ";height:" + bitmap.getHeight());
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    float f = (float) ((((double) width) * 1.0d) / ((double) height));
                    e4 e4Var = e4.this;
                    int iA = so.a(e4Var.U, e4Var.Y - 16.0f);
                    int i = (int) (iA / f);
                    e4 e4Var2 = e4.this;
                    if (e4Var2.Z > 0.0f) {
                        LinearLayout linearLayout = e4Var2.e1;
                        if (linearLayout != null) {
                            linearLayout.measure(0, 0);
                            measuredHeight = e4.this.e1.getMeasuredHeight();
                        } else {
                            measuredHeight = 0;
                        }
                        e4 e4Var3 = e4.this;
                        int iA2 = so.a(e4Var3.U, e4Var3.Z - 16.0f);
                        if (iA2 > measuredHeight) {
                            i = iA2 - measuredHeight;
                        }
                    }
                    e4 e4Var4 = e4.this;
                    e4Var4.A0 = iA;
                    e4Var4.B0 = i;
                    if (i < 0) {
                        e4Var4.B0 = height;
                    }
                    CustomRoundImageView customRoundImageView = e4Var4.g1;
                    if (customRoundImageView != null) {
                        customRoundImageView.setVisibility(0);
                        ViewGroup.LayoutParams layoutParams = e4.this.g1.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = iA;
                            layoutParams.height = i;
                            e4.this.g1.setLayoutParams(layoutParams);
                        }
                    }
                    e4 e4Var5 = e4.this;
                    CustomRoundImageView customRoundImageView2 = e4Var5.g1;
                    if (customRoundImageView2 != null) {
                        customRoundImageView2.setRectRadius(so.a(e4Var5.U, 4.0f));
                        e4 e4Var6 = e4.this;
                        e4Var6.a(iA, i, f, bitmap, e4Var6.g1);
                        e4.this.g1.setImageBitmap(bitmap);
                    }
                    e4 e4Var7 = e4.this;
                    e4Var7.a(e4Var7.g1);
                    e4.this.i1();
                    e4.this.j1();
                    e4.this.f1();
                    e4.this.Z0();
                } catch (Exception e) {
                    e.printStackTrace();
                    e4.this.a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
                }
            }
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
            Log.d("BeiZis", "showBeiZiNativeAd onBitmapLoadFailed");
            e4.this.a("sdk custom error ".concat("onBitmapLoadFailed"), 99991);
        }
    }
}
