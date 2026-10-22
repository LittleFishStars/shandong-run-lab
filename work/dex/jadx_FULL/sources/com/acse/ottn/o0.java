package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.app.Service;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.model.AccessiblityModel;
import com.bumptech.glide.Glide;
import java.io.ObjectStreamException;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class o0 {
    public static o0 j = null;
    public static View k = null;
    public static WindowManager l = null;
    public static String m = "CountdownService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WindowManager.LayoutParams f23113a;
    public RelativeLayout b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public ImageView g;
    public TimerTask h;
    public TimerTask i;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f23114a;
        public final /* synthetic */ AccessiblityModel b;

        public a(Service service, AccessiblityModel accessiblityModel) {
            this.f23114a = service;
            this.b = accessiblityModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o0.this.b(this.f23114a);
            n4.c().b(this.f23114a, this.b);
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f23115a;

        public b(Service service) {
            this.f23115a = service;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o0.this.b(this.f23115a);
        }
    }

    public class d implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f23117a;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (l0.e) {
                    return;
                }
                TimerTask timerTask = o0.this.h;
                if (timerTask != null) {
                    timerTask.cancel();
                }
                d dVar = d.this;
                o0.this.b(dVar.f23117a);
            }
        }

        public d(Service service) {
            this.f23117a = service;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            new Handler(Looper.getMainLooper()).postDelayed(new a(), 0L);
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            o0.this.b(this.f23117a);
        }
    }

    public static o0 a() {
        if (j == null) {
            synchronized (o0.class) {
                if (j == null) {
                    j = new o0();
                }
            }
        }
        return j;
    }

    public final Object b() throws ObjectStreamException {
        return j;
    }

    public class c implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Service f23116a;

        public c(Service service) {
            this.f23116a = service;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            o0.this.d.setText((j / 60000) + "");
            o0.this.e.setText(((j % 60000) / 1000) + "");
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            o0.this.b(this.f23116a);
        }
    }

    public void b(Service service, AccessiblityModel accessiblityModel) {
        a(service, R.layout.count_down_background);
        this.b = (RelativeLayout) k.findViewById(R.id.beijing);
        this.c = (ImageView) k.findViewById(R.id.iv_image);
        this.d = (TextView) k.findViewById(R.id.tv_hour);
        this.e = (TextView) k.findViewById(R.id.tv_minute);
        this.g = (ImageView) k.findViewById(R.id.iv_setting);
        this.f = (TextView) k.findViewById(R.id.tv_price);
        a(service, accessiblityModel);
        l.addView(k, this.f23113a);
    }

    public void a(Service service) {
        this.f23113a = new WindowManager.LayoutParams();
        if (h4.a().a(service)) {
            l = (WindowManager) service.getApplication().getSystemService("window");
            WindowManager.LayoutParams layoutParams = this.f23113a;
            layoutParams.type = 2038;
            layoutParams.flags = 8;
        } else {
            l = (WindowManager) service.getSystemService("window");
            WindowManager.LayoutParams layoutParams2 = this.f23113a;
            layoutParams2.type = 2032;
            layoutParams2.flags = 800;
        }
        WindowManager.LayoutParams layoutParams3 = this.f23113a;
        layoutParams3.format = 1;
        layoutParams3.windowAnimations = android.R.style.Animation.Translucent;
        layoutParams3.gravity = 85;
        layoutParams3.x = 30;
        layoutParams3.y = 700;
        layoutParams3.width = x0.a((Context) service, 93.0f);
        this.f23113a.height = x0.a((Context) service, 100.0f);
    }

    public void b(Service service) {
        try {
            View view = k;
            if (view != null) {
                view.setVisibility(8);
            }
            TimerTask timerTask = this.h;
            if (timerTask != null) {
                timerTask.cancel();
            }
            TimerTask timerTask2 = this.i;
            if (timerTask2 != null) {
                timerTask2.cancel();
            }
            l.removeView(k);
            if (!h4.a().a(service)) {
                service = (AccessibilityService) service;
            }
            service.stopSelf();
        } catch (Throwable unused) {
        }
    }

    public final void a(Service service, AccessiblityModel accessiblityModel) {
        if (!accessiblityModel.getData().getPackage_name().equals(o.c().O) && !accessiblityModel.getData().getPackage_name().equals(o.c().R)) {
            if (!accessiblityModel.getData().getPackage_name().equals(o.c().o) && !accessiblityModel.getData().getPackage_name().equals(o.c().p)) {
                if (accessiblityModel.getData().getPackage_name().equals(o.c().D)) {
                    this.c.setImageResource(R.mipmap.smallfloat_mtchaoshi);
                    this.f.setTextColor(Color.parseColor("#FFFFFF"));
                    this.f.setText(accessiblityModel.getData().getOriginal_price());
                } else if (accessiblityModel.getData().getPackage_name().equals(o.c().B)) {
                    this.c.setImageResource(R.mipmap.smallfloat_mtjiudian);
                    this.f.setTextColor(Color.parseColor("#FF0000"));
                    this.f.setText(accessiblityModel.getData().getOriginal_price());
                } else if (accessiblityModel.getData().getPackage_name().equals(o.c().y)) {
                    this.c.setImageResource(R.mipmap.smallfloat_mtxianhua);
                    this.f.setTextColor(Color.parseColor("#FFF344"));
                    this.f.setText(accessiblityModel.getData().getOriginal_price());
                } else if (accessiblityModel.getData().getPackage_name().equals(o.c().A)) {
                    this.c.setImageResource(R.mipmap.smallfloat_mtyiyao);
                    this.f.setTextColor(Color.parseColor("#FC5702"));
                    this.f.setText(accessiblityModel.getData().getOriginal_price());
                } else if (accessiblityModel.getData().getPackage_name().equals(o.c().G)) {
                    this.c.setImageResource(R.mipmap.smallfloat_shangou);
                    this.f.setTextColor(Color.parseColor("#EB2A23"));
                    this.f.setText(accessiblityModel.getData().getOriginal_price());
                } else if (accessiblityModel.getData().getPackage_name().equals(o.c().P)) {
                    this.c.setImageResource(R.mipmap.smallfloat_taobaoeleme);
                    this.f.setTextColor(Color.parseColor("#EB2A23"));
                    this.f.setText(accessiblityModel.getData().getOriginal_price());
                } else if (accessiblityModel.getData().getPackage_name().equals(o.c().b0)) {
                    this.f.setTextColor(Color.parseColor("#FF0057"));
                    this.c.setImageResource(R.mipmap.smallfloat_vipshop);
                } else if (accessiblityModel.getData().getPackage_name().equals(o.c().F)) {
                    this.c.setImageResource(R.mipmap.smallfloat_xianyu);
                    this.f.setTextColor(Color.parseColor("#FF5031"));
                    this.f.setText(accessiblityModel.getData().getOriginal_price());
                } else if (accessiblityModel.getData().getPackage_name().equals(o.c().a0)) {
                    this.f.setTextColor(Color.parseColor("#FFFFFF"));
                    this.c.setImageResource(R.mipmap.smallfloat_yidong);
                    this.f.setText(accessiblityModel.getData().getOriginal_price());
                } else if (accessiblityModel.getData().getPackage_name().equals(o.c().E)) {
                    this.f.setTextColor(Color.parseColor("#FFFFFF"));
                    this.c.setImageResource(R.mipmap.smallfloat_mtguoshu);
                    this.f.setText(accessiblityModel.getData().getOriginal_price());
                } else if (!accessiblityModel.getData().getPackage_name().equals(o.c().J) && !accessiblityModel.getData().getPackage_name().equals(o.c().N) && !accessiblityModel.getData().getPackage_name().equals(o.c().l)) {
                    if (accessiblityModel.getData().getPackage_name().equals(o.c().U)) {
                        Glide.with(service).load(accessiblityModel.getData().getSpop_pic()).into(this.c);
                    }
                } else {
                    this.f.setTextColor(Color.parseColor("#FFFFFF"));
                    this.c.setImageResource(R.mipmap.smallfloat_mt);
                    this.f.setText(accessiblityModel.getData().getOriginal_price());
                }
            } else {
                this.c.setImageResource(R.mipmap.smallfloat_kuaishou);
                this.f.setTextColor(Color.parseColor("#FFFCC6"));
                this.f.setText(accessiblityModel.getData().getOriginal_price());
            }
        } else {
            this.c.setImageResource(R.mipmap.smallfloat_eleme);
            this.f.setTextColor(Color.parseColor("#1A7BCF"));
            this.f.setText(accessiblityModel.getData().getOriginal_price());
        }
        this.b.setOnClickListener(new a(service, accessiblityModel));
        this.g.setOnClickListener(new b(service));
        this.i = n0.a().b(accessiblityModel.getData().getSmallfloat_hour() * 1000, 1000, new c(service));
        this.h = n0.a().b(accessiblityModel.getData().getTime_four(), 500, new d(service));
    }

    public final void a(Service service, int i) {
        try {
            View viewInflate = LayoutInflater.from(service.getApplication()).inflate(i, (ViewGroup) null);
            k = viewInflate;
            viewInflate.measure(0, 0);
        } catch (Throwable unused) {
        }
    }
}
