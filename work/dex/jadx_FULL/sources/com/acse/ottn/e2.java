package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Service;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.io.reactivex.functions.Consumer;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.util.HelpShopAppUtil;
import com.acse.ottn.widget.RoundRectImageView;
import com.bumptech.glide.Glide;
import java.io.ObjectStreamException;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e2 {
    public static View c = null;
    public static WindowManager d = null;
    public static String e = "MainService";
    public static e2 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WindowManager.LayoutParams f22969a;
    public AccessiblityModel b;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f22970a;

        public a(Service service) {
            this.f22970a = service;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q2.b().a("tb_lj_bannner_close");
            l0.h = false;
            e2.this.b(this.f22970a);
            d2.b().a();
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f22971a;
        public final /* synthetic */ AccessiblityModel b;

        public b(Service service, AccessiblityModel accessiblityModel) {
            this.f22971a = service;
            this.b = accessiblityModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l0.h = false;
            e2.this.b(this.f22971a);
            q2.b().a("tb_lj_bannner_click");
            com.acse.ottn.service.a.b().a(this.f22971a, this.b, (com.acse.ottn.service.a.u0) null);
            d2.b().a();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f22972a;

        public c(RelativeLayout relativeLayout) {
            this.f22972a = relativeLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            e2.this.a(this.f22972a);
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f22973a;

        public d(RelativeLayout relativeLayout) {
            this.f22973a = relativeLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f22973a.setScaleX(fFloatValue);
            this.f22973a.setScaleY(fFloatValue);
        }
    }

    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f22974a;

        public e(RelativeLayout relativeLayout) {
            this.f22974a = relativeLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            h2.a("samon-->", "addUpdateListener");
            this.f22974a.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public class f implements Consumer<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f22975a;
        public final /* synthetic */ String b;

        public f(Service service, String str) {
            this.f22975a = service;
            this.b = str;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("r") != 1) {
                l0.h = false;
                e2.this.b(this.f22975a);
            } else if (jSONObject.getInt("code") == 1) {
                l0.h = false;
                e2.this.b(this.f22975a, this.b);
            } else {
                l0.h = false;
                e2.this.b(this.f22975a);
            }
        }
    }

    public class g implements Consumer<Throwable> {
        public g() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    public class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f22978a;
        public final /* synthetic */ String b;

        public i(Service service, String str) {
            this.f22978a = service;
            this.b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l0.h = false;
            q2.b().a("tb_lj_bannner_setting");
            e2.this.a(this.f22978a, this.b);
        }
    }

    public class h implements com.acse.ottn.service.a.u0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f22977a;

        public h(Service service) {
            this.f22977a = service;
        }

        @Override // com.acse.ottn.service.a.u0
        public void a() {
            l0.h = false;
            e2.this.b(this.f22977a);
        }

        @Override // com.acse.ottn.service.a.u0
        public void a(String str) {
            l0.h = false;
            e2.this.b(this.f22977a);
        }
    }

    public final Object b() throws ObjectStreamException {
        return f;
    }

    public static e2 a() {
        if (f == null) {
            synchronized (e2.class) {
                if (f == null) {
                    f = new e2();
                }
            }
        }
        return f;
    }

    public void b(Service service) {
        try {
            View view = c;
            if (view != null) {
                view.setVisibility(8);
            }
            d.removeView(c);
            c = null;
            if (!h4.a().a(service)) {
                service = (AccessibilityService) service;
            }
            service.stopSelf();
        } catch (Throwable unused) {
        }
    }

    public final void b(Service service, String str) {
        h2.c(e, "noShowCoupon ");
        try {
            d.removeView(c);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a(service, R.layout.coupon_no_showbackground);
            com.acse.ottn.service.a.b().a(c, str, false, (com.acse.ottn.service.a.u0) new h(service));
            WindowManager.LayoutParams layoutParams = this.f22969a;
            layoutParams.height = -2;
            d.addView(c, layoutParams);
        } catch (Throwable th) {
            h2.c(e, "noShowCoupon e=" + th.getMessage());
        }
    }

    public void a(Service service) {
        this.f22969a = new WindowManager.LayoutParams();
        if (h4.a().a(service)) {
            d = (WindowManager) service.getApplication().getSystemService("window");
            WindowManager.LayoutParams layoutParams = this.f22969a;
            layoutParams.type = 2038;
            layoutParams.flags = 8;
        } else {
            d = (WindowManager) service.getSystemService("window");
            WindowManager.LayoutParams layoutParams2 = this.f22969a;
            layoutParams2.type = 2032;
            layoutParams2.flags = 800;
        }
        WindowManager.LayoutParams layoutParams3 = this.f22969a;
        layoutParams3.format = 1;
        layoutParams3.windowAnimations = android.R.style.Animation.Translucent;
        layoutParams3.gravity = 85;
        layoutParams3.x = 80;
        layoutParams3.y = 400;
        layoutParams3.width = -2;
    }

    public void a(Service service, AccessiblityModel accessiblityModel) {
        a(service, R.layout.lj_first_background);
        this.f22969a.height = x0.a((Context) service, 100.0f);
        TextView textView = (TextView) c.findViewById(R.id.firs_lj);
        View view = c;
        int i2 = R.id.beijing;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(i2);
        RoundRectImageView roundRectImageView = (RoundRectImageView) c.findViewById(R.id.iv_tb_big_recommend_icon);
        ImageView imageView = (ImageView) c.findViewById(R.id.iv_didi_setting);
        a(service, (ImageView) c.findViewById(R.id.iv_setting2), accessiblityModel.getData().getPackage_name());
        imageView.setOnClickListener(new a(service));
        relativeLayout.setOnClickListener(new b(service, accessiblityModel));
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        if (!TextUtils.isEmpty(accessiblityModel.getData().getSpop_pic())) {
            Glide.with(service).load(accessiblityModel.getData().getSpop_pic()).into(roundRectImageView);
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) c.findViewById(i2);
        d.addView(c, this.f22969a);
        new Handler(Looper.getMainLooper()).postDelayed(new c(relativeLayout2), accessiblityModel.getData().getSecond_price());
    }

    public final void a(Service service, int i2) {
        try {
            View viewInflate = LayoutInflater.from(service.getApplication()).inflate(i2, (ViewGroup) null);
            c = viewInflate;
            viewInflate.measure(0, 0);
        } catch (Throwable unused) {
        }
    }

    public final void a(RelativeLayout relativeLayout) {
        relativeLayout.setPivotX(relativeLayout.getWidth());
        relativeLayout.setPivotY((relativeLayout.getHeight() * 2) / 3);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new d(relativeLayout));
        valueAnimatorOfFloat.setDuration(300L);
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(100.0f, 0.0f);
        valueAnimatorOfFloat2.addUpdateListener(new e(relativeLayout));
        valueAnimatorOfFloat2.setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(valueAnimatorOfFloat).with(valueAnimatorOfFloat2);
        animatorSet.start();
    }

    public final void a(Service service, String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("limitType", "lj");
        treeMap.put("is_snt", "0");
        treeMap.put("package_name", str);
        new g0().i(t0.b().a(treeMap, "")).u5(Schedulers.newThread()).G3(com.acse.ottn.i.a()).s5(new f(service, str), new g());
    }

    public final void a(Service service, ImageView imageView, String str) {
        imageView.setOnClickListener(new i(service, str));
    }
}
