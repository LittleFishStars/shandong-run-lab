package com.acse.ottn.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.R;
import com.acse.ottn.a0;
import com.acse.ottn.animator.SwitchOnAnimView;
import com.acse.ottn.h0;
import com.acse.ottn.h2;
import com.acse.ottn.l0;
import com.acse.ottn.o1;
import com.acse.ottn.p4;
import com.acse.ottn.util.HelpShopAppUtil;
import com.igexin.assist.util.AssistUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TransparentGreenActivity extends a0 {
    public RelativeLayout e;
    public RelativeLayout f;
    public Handler g = new Handler(Looper.getMainLooper());
    public SwitchOnAnimView h;
    public SwitchOnAnimView i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public String m;
    public TextView n;
    public TextView o;
    public AnimatorSet p;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AnimatorSet animatorSet = TransparentGreenActivity.this.p;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            if (TransparentGreenActivity.this.h != null) {
                TransparentGreenActivity.this.h.f();
                TransparentGreenActivity.this.h = null;
            }
            if (TransparentGreenActivity.this.i != null) {
                TransparentGreenActivity.this.i.f();
                TransparentGreenActivity.this.i = null;
            }
            TransparentGreenActivity.this.finishAndRemoveTask();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AnimatorSet animatorSet = TransparentGreenActivity.this.p;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            if (TransparentGreenActivity.this.h != null) {
                TransparentGreenActivity.this.h.f();
                TransparentGreenActivity.this.h = null;
            }
            if (TransparentGreenActivity.this.i != null) {
                TransparentGreenActivity.this.i.f();
                TransparentGreenActivity.this.i = null;
            }
            TransparentGreenActivity.this.finishAndRemoveTask();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TransparentGreenActivity.this.h.b();
                TransparentGreenActivity.this.i.b();
            } catch (Exception e) {
                h2.b("TransparentActivity", e.getMessage());
            }
        }
    }

    public static Bitmap d() {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = HelpShopAppUtil.getContext().getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(HelpShopAppUtil.getContext().getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return a(packageManager.getApplicationIcon(applicationInfo));
    }

    public String c() {
        return o1.c().b();
    }

    public final void e() {
        h0.a().b(this, this.n);
        this.m = h0.a().f(this);
    }

    public final void f() {
        ((TextView) findViewById(R.id.tv_step)).setText(Html.fromHtml("滑动列表找到“<font color=" + this.m + ">" + l0.f23074a + "</font>”"));
        Spanned spannedFromHtml = Html.fromHtml("👉【<font color=" + this.m + ">" + l0.f23074a + "</font>】—请启用🏃");
        TextView textView = (TextView) findViewById(R.id.tv_permission_name);
        this.o = textView;
        textView.setText(spannedFromHtml);
        this.l = (TextView) findViewById(R.id.tv_permission);
        ((TextView) findViewById(R.id.tv_step_two)).setText(Html.fromHtml("第二步：滑动列表，找到“<font color=" + this.m + ">" + l0.f23074a + "</font>”"));
        this.k = (TextView) findViewById(R.id.tv_step_one);
        StringBuilder sb = new StringBuilder();
        sb.append("第一步：滑动列表，打开“<font color=");
        sb.append(this.m);
        sb.append(">已安装的服务</font>”");
        this.k.setText(Html.fromHtml(sb.toString()));
    }

    public void g() {
        if (p4.b() != null) {
            byte b2 = 8;
            this.f.setVisibility(8);
            this.e.setVisibility(8);
            String strB = p4.b();
            strB.hashCode();
            switch (strB.hashCode()) {
                case -1443430368:
                    b2 = !strB.equals("smartisan") ? (byte) -1 : (byte) 0;
                    break;
                case -1320380160:
                    b2 = !strB.equals("oneplus") ? (byte) -1 : (byte) 1;
                    break;
                case -1206476313:
                    b2 = !strB.equals(AssistUtils.BRAND_HW) ? (byte) -1 : (byte) 2;
                    break;
                case -934971466:
                    b2 = !strB.equals("realme") ? (byte) -1 : (byte) 3;
                    break;
                case -878077690:
                    b2 = !strB.equals("tdtech") ? (byte) -1 : (byte) 4;
                    break;
                case -874016782:
                    b2 = !strB.equals("tianyi") ? (byte) -1 : (byte) 5;
                    break;
                case -759499589:
                    b2 = !strB.equals("xiaomi") ? (byte) -1 : (byte) 6;
                    break;
                case 3318203:
                    b2 = !strB.equals("letv") ? (byte) -1 : (byte) 7;
                    break;
                case 3418016:
                    if (!strB.equals("oppo")) {
                        b2 = -1;
                    }
                    break;
                case 3620012:
                    b2 = !strB.equals("vivo") ? (byte) -1 : (byte) 9;
                    break;
                case 99462250:
                    b2 = !strB.equals(AssistUtils.BRAND_HON) ? (byte) -1 : (byte) 10;
                    break;
                case 103777484:
                    b2 = !strB.equals(AssistUtils.BRAND_MZ) ? (byte) -1 : (byte) 11;
                    break;
                case 108389869:
                    b2 = !strB.equals("redmi") ? (byte) -1 : (byte) 12;
                    break;
                case 1864941562:
                    b2 = !strB.equals("samsung") ? (byte) -1 : (byte) 13;
                    break;
                default:
                    b2 = -1;
                    break;
            }
            switch (b2) {
                case 0:
                case 7:
                case 11:
                    if (Build.VERSION.SDK_INT < 29) {
                        this.f.setVisibility(0);
                        a((ImageView) findViewById(R.id.iv_up));
                    } else {
                        a((ImageView) findViewById(R.id.iv_jiantou));
                        this.e.setVisibility(0);
                        this.k.setText(Html.fromHtml("第一步：滑动列表，打开“<font color=" + this.m + ">已下载的服务</font>”"));
                        this.l.setText(Html.fromHtml("滑动列表，找到“<font color=" + this.m + ">已下载的服务</font>”"));
                    }
                    break;
                case 1:
                case 3:
                case 8:
                    int i = Build.VERSION.SDK_INT;
                    if (i > 31) {
                        a((ImageView) findViewById(R.id.iv_jiantou));
                        this.e.setVisibility(0);
                        this.k.setText(Html.fromHtml("第一步：滑动列表，打开“<font color=" + this.m + ">已下载的应用</font>”"));
                        this.l.setText(Html.fromHtml("滑动列表，找到“<font color=" + this.m + ">已下载的应用</font>”"));
                    } else if (i <= 31) {
                        this.f.setVisibility(0);
                    }
                    break;
                case 2:
                case 4:
                case 5:
                case 10:
                    if (!p4.t()) {
                        this.f.setVisibility(0);
                        a((ImageView) findViewById(R.id.iv_up));
                    } else {
                        a((ImageView) findViewById(R.id.iv_jiantou));
                        this.k.setText(Html.fromHtml("第一步：滑动列表，找到“<font color=" + this.m + ">已安装的服务</font>”"));
                        this.e.setVisibility(0);
                        this.l.setText(Html.fromHtml("滑动列表，找到“<font color=" + this.m + ">已安装的服务</font>”"));
                    }
                    break;
                case 6:
                case 12:
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 > 29) {
                        a((ImageView) findViewById(R.id.iv_jiantou));
                        this.e.setVisibility(0);
                        this.k.setText(Html.fromHtml("第一步：滑动列表，打开“<font color=" + this.m + ">已下载的应用</font>”"));
                    } else if (i2 <= 29) {
                        a((ImageView) findViewById(R.id.iv_jiantou));
                        this.e.setVisibility(0);
                        this.k.setText(Html.fromHtml("第一步：滑动列表，打开“<font color=" + this.m + ">更多已下载的服务</font>”"));
                    }
                    this.l.setText(Html.fromHtml("滑动列表，找到“<font color=" + this.m + ">已下载的应用</font>”"));
                    break;
                case 9:
                    if (Build.VERSION.SDK_INT < 32) {
                        this.f.setVisibility(0);
                    } else {
                        a((ImageView) findViewById(R.id.iv_jiantou));
                        this.e.setVisibility(0);
                        this.k.setText(Html.fromHtml("第一步：滑动列表，找到“<font color=" + this.m + ">已下载的服务</font>”"));
                        this.l.setText(Html.fromHtml("滑动列表，找到“<font color=" + this.m + ">已下载的服务</font>”"));
                    }
                    break;
                case 13:
                    this.k.setText("第一步:滑动列表");
                    a((ImageView) findViewById(R.id.iv_jiantou));
                    this.e.setVisibility(0);
                    this.k.setText(Html.fromHtml("找到“<font color=" + this.m + ">已安装的应用程序</font>”"));
                    this.o.setText(Html.fromHtml("请将<font color=" + this.m + "></font><font color=" + this.m + ">第1项</font>开关打开<br/>(注意不是点“<font color=" + this.m + "></font><font color=" + this.m + ">快捷方式</font>”)❌"));
                    break;
                default:
                    this.f.setVisibility(0);
                    a((ImageView) findViewById(R.id.iv_up));
                    break;
            }
        }
    }

    @Override // com.acse.ottn.a0, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(Color.argb(0, 0, 0, 0));
        setContentView(R.layout.activity_seeding_green_transparent);
        if (HelpShopAppUtil.getContext() == null) {
            new AcseHelpManager.InitSdk().setContext(getApplication()).build();
        }
        a(false);
        this.f = (RelativeLayout) findViewById(R.id.rl_other);
        this.e = (RelativeLayout) findViewById(R.id.rl_xiaomi);
        this.j = (ImageView) findViewById(R.id.tv_icon);
        this.n = (TextView) findViewById(R.id.tv_open);
        this.j.setImageBitmap(d());
        e();
        f();
        g();
        findViewById(R.id.container).setOnClickListener(new a());
        this.n.setOnClickListener(new b());
        this.h = (SwitchOnAnimView) findViewById(R.id.switch_on_anim_view);
        this.i = (SwitchOnAnimView) findViewById(R.id.click_on_anim_view);
        this.g.postDelayed(new c(), 500L);
    }

    @Override // com.acse.ottn.a0, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AnimatorSet animatorSet = this.p;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        SwitchOnAnimView switchOnAnimView = this.h;
        if (switchOnAnimView != null) {
            switchOnAnimView.f();
            this.h = null;
        }
        SwitchOnAnimView switchOnAnimView2 = this.i;
        if (switchOnAnimView2 != null) {
            switchOnAnimView2.f();
            this.i = null;
        }
        super.onDestroy();
    }

    public static Bitmap a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public void a(ImageView imageView) {
        h0.a().a((Activity) this, imageView);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "translationY", -20.0f, 20.0f, -20.0f);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(1);
        objectAnimatorOfFloat.start();
        AnimatorSet animatorSet = new AnimatorSet();
        this.p = animatorSet;
        animatorSet.playTogether(objectAnimatorOfFloat);
        this.p.setStartDelay(10000L);
        this.p.start();
    }
}
