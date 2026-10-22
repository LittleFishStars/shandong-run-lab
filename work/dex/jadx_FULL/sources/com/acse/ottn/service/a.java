package com.acse.ottn.service;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.R;
import com.acse.ottn.h2;
import com.acse.ottn.io.reactivex.functions.Consumer;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import com.acse.ottn.l1;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.n3;
import com.acse.ottn.n4;
import com.acse.ottn.q2;
import com.acse.ottn.util.HelpShopAppUtil;
import com.acse.ottn.widget.RoundRectImageView;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.bumptech.glide.Glide;
import java.io.ObjectStreamException;
import java.util.TimerTask;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static String c = "ViewUtil";
    public static a d;
    public static TimerTask e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f23212a;
    public float b;

    /* JADX INFO: renamed from: com.acse.ottn.service.a$a, reason: collision with other inner class name */
    public class C0114a implements com.acse.ottn.n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23213a;

        /* JADX INFO: renamed from: com.acse.ottn.service.a$a$a, reason: collision with other inner class name */
        public class RunnableC0115a implements Runnable {
            public RunnableC0115a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h2.a("liuqiang-->", "countDown CommonUtil.isShowConpunInfor=" + com.acse.ottn.l0.e);
                if (com.acse.ottn.l0.e) {
                    return;
                }
                TimerTask timerTask = a.e;
                if (timerTask != null) {
                    timerTask.cancel();
                    a.e = null;
                }
                a.a(C0114a.this.f23213a);
            }
        }

        /* JADX INFO: renamed from: com.acse.ottn.service.a$a$b */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.a(C0114a.this.f23213a);
            }
        }

        public C0114a(u0 u0Var) {
            this.f23213a = u0Var;
        }

        @Override // com.acse.ottn.n0.d
        public void a(long j) {
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0115a(), 0L);
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
            h2.a(a.c, "结束了");
            new Handler(Looper.getMainLooper()).postDelayed(new b(), 0L);
        }
    }

    public class a0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23216a;

        public a0(u0 u0Var) {
            this.f23216a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f23216a);
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23217a;

        public b(u0 u0Var) {
            this.f23217a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f23217a);
        }
    }

    public class b0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23218a;
        public final /* synthetic */ AccessiblityModel b;
        public final /* synthetic */ u0 c;

        public b0(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f23218a = context;
            this.b = accessiblityModel;
            this.c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f23218a, this.b, this.c);
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23219a;
        public final /* synthetic */ AccessiblityModel b;
        public final /* synthetic */ u0 c;

        public c(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f23219a = context;
            this.b = accessiblityModel;
            this.c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f23219a, this.b, this.c);
        }
    }

    public class c0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23220a;

        public c0(u0 u0Var) {
            this.f23220a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f23220a);
        }
    }

    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23221a;

        public d(u0 u0Var) {
            this.f23221a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f23221a);
        }
    }

    public class d0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23222a;
        public final /* synthetic */ AccessiblityModel b;
        public final /* synthetic */ u0 c;

        public d0(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f23222a = context;
            this.b = accessiblityModel;
            this.c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f23222a, this.b, this.c);
        }
    }

    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23223a;
        public final /* synthetic */ AccessiblityModel b;
        public final /* synthetic */ u0 c;

        public e(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f23223a = context;
            this.b = accessiblityModel;
            this.c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f23223a, this.b, this.c);
        }
    }

    public class e0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23224a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;

        public e0(u0 u0Var, String str, boolean z) {
            this.f23224a = u0Var;
            this.b = str;
            this.c = z;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f23224a != null) {
                a.this.a(this.b, this.c);
                a.a(this.f23224a);
            }
        }
    }

    public class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23225a;

        public f(u0 u0Var) {
            this.f23225a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f23225a);
        }
    }

    public class f0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23226a;

        public f0(u0 u0Var) {
            this.f23226a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f23226a);
        }
    }

    public class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23227a;
        public final /* synthetic */ AccessiblityModel b;
        public final /* synthetic */ u0 c;

        public g(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f23227a = context;
            this.b = accessiblityModel;
            this.c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f23227a, this.b, this.c);
        }
    }

    public class g0 implements Consumer<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23228a;

        public g0(u0 u0Var) {
            this.f23228a = u0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            h2.b(a.c, "报错了=" + th.getMessage());
            a.a(this.f23228a);
        }
    }

    public class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23229a;

        public h(u0 u0Var) {
            this.f23229a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f23229a);
        }
    }

    public class h0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23230a;

        public h0(u0 u0Var) {
            this.f23230a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f23230a);
        }
    }

    public class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23231a;
        public final /* synthetic */ AccessiblityModel b;
        public final /* synthetic */ u0 c;

        public i(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f23231a = context;
            this.b = accessiblityModel;
            this.c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f23231a, this.b, this.c);
        }
    }

    public class i0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23232a;
        public final /* synthetic */ AccessiblityModel b;
        public final /* synthetic */ u0 c;

        public i0(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f23232a = context;
            this.b = accessiblityModel;
            this.c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f23232a, this.b, this.c);
        }
    }

    public class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23233a;

        public j(u0 u0Var) {
            this.f23233a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f23233a);
        }
    }

    public class j0 implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RelativeLayout f23234a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;
        public final /* synthetic */ u0 d;
        public final /* synthetic */ AccessiblityModel e;
        public final /* synthetic */ Context f;

        public j0(RelativeLayout relativeLayout, float f, float f2, u0 u0Var, AccessiblityModel accessiblityModel, Context context) {
            this.f23234a = relativeLayout;
            this.b = f;
            this.c = f2;
            this.d = u0Var;
            this.e = accessiblityModel;
            this.f = context;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            a.d();
            int action = motionEvent.getAction();
            if (action == 0) {
                a.this.f23212a = motionEvent.getX();
                a.this.b = motionEvent.getY();
            } else if (action == 1) {
                a.b(4000, this.d);
                if (a.this.b - motionEvent.getY() > 100.0f) {
                    this.f23234a.scrollTo(-((int) this.c), 300);
                    q2.b().a("close_coupon_window");
                    a.a(this.d);
                } else {
                    if (motionEvent.getX() - a.this.f23212a <= n3.a().c("screenWidth") / 3) {
                        this.f23234a.scrollTo(0, 0);
                        if (Math.abs(a.this.b - motionEvent.getY()) < 100.0f && Math.abs(a.this.f23212a - motionEvent.getX()) < 100.0f) {
                            h2.c(a.c, "点击了");
                            if (this.e == null) {
                                return false;
                            }
                            a.a(this.d);
                            a.this.a(this.f, this.e, this.d);
                        }
                        return false;
                    }
                    this.f23234a.scrollTo(n3.a().c("screenWidth"), (int) this.b);
                    q2.b().a("close_coupon_window");
                    a.a(this.d);
                }
            } else if (action == 2) {
                if (Math.abs(motionEvent.getX() - a.this.f23212a) > Math.abs(motionEvent.getY() - a.this.b)) {
                    if (motionEvent.getX() - a.this.f23212a < 0.0f) {
                        return false;
                    }
                    this.f23234a.scrollTo(-((int) (motionEvent.getX() - a.this.f23212a)), -((int) this.b));
                } else {
                    if (motionEvent.getY() - a.this.b > 0.0f) {
                        return false;
                    }
                    this.f23234a.scrollTo(-((int) this.c), -((int) (motionEvent.getY() - a.this.b)));
                }
            }
            return true;
        }
    }

    public class k implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23235a;
        public final /* synthetic */ AccessiblityModel b;
        public final /* synthetic */ u0 c;

        public k(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f23235a = context;
            this.b = accessiblityModel;
            this.c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f23235a, this.b, this.c);
        }
    }

    public class k0 implements Consumer<String> {
        public k0() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            h2.b("ShopHelperService", "cutdown=" + str);
        }
    }

    public class l implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23237a;

        public l(u0 u0Var) {
            this.f23237a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f23237a);
        }
    }

    public class l0 implements Consumer<Throwable> {
        public l0() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    public class m implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23239a;
        public final /* synthetic */ AccessiblityModel b;
        public final /* synthetic */ u0 c;

        public m(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f23239a = context;
            this.b = accessiblityModel;
            this.c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f23239a, this.b, this.c);
        }
    }

    public class m0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23240a;

        public m0(u0 u0Var) {
            this.f23240a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f23240a);
        }
    }

    public class n implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23241a;

        public n(u0 u0Var) {
            this.f23241a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f23241a);
        }
    }

    public class n0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23242a;
        public final /* synthetic */ AccessiblityModel b;
        public final /* synthetic */ u0 c;

        public n0(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f23242a = context;
            this.b = accessiblityModel;
            this.c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f23242a, this.b, this.c);
        }
    }

    public class o implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23243a;
        public final /* synthetic */ AccessiblityModel b;
        public final /* synthetic */ u0 c;

        public o(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f23243a = context;
            this.b = accessiblityModel;
            this.c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f23243a, this.b, this.c);
        }
    }

    public class o0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23244a;

        public o0(u0 u0Var) {
            this.f23244a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f23244a);
        }
    }

    public class p implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23245a;

        public p(u0 u0Var) {
            this.f23245a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f23245a);
        }
    }

    public class p0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23246a;
        public final /* synthetic */ AccessiblityModel b;
        public final /* synthetic */ u0 c;

        public p0(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f23246a = context;
            this.b = accessiblityModel;
            this.c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f23246a, this.b, this.c);
        }
    }

    public class q implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23247a;
        public final /* synthetic */ AccessiblityModel b;
        public final /* synthetic */ u0 c;

        public q(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f23247a = context;
            this.b = accessiblityModel;
            this.c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f23247a, this.b, this.c);
        }
    }

    public class q0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23248a;

        public q0(u0 u0Var) {
            this.f23248a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f23248a);
        }
    }

    public class r implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23249a;

        public r(u0 u0Var) {
            this.f23249a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f23249a);
        }
    }

    public class r0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23250a;
        public final /* synthetic */ AccessiblityModel b;
        public final /* synthetic */ u0 c;

        public r0(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f23250a = context;
            this.b = accessiblityModel;
            this.c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f23250a, this.b, this.c);
        }
    }

    public class s implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23251a;
        public final /* synthetic */ AccessiblityModel b;
        public final /* synthetic */ u0 c;

        public s(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f23251a = context;
            this.b = accessiblityModel;
            this.c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f23251a, this.b, this.c);
        }
    }

    public class s0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23252a;

        public s0(u0 u0Var) {
            this.f23252a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f23252a);
        }
    }

    public class t implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23253a;

        public t(u0 u0Var) {
            this.f23253a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f23253a);
        }
    }

    public class t0 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23254a;
        public final /* synthetic */ AccessiblityModel b;
        public final /* synthetic */ u0 c;

        public t0(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f23254a = context;
            this.b = accessiblityModel;
            this.c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f23254a, this.b, this.c);
        }
    }

    public class u implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23255a;
        public final /* synthetic */ AccessiblityModel b;
        public final /* synthetic */ u0 c;

        public u(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f23255a = context;
            this.b = accessiblityModel;
            this.c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f23255a, this.b, this.c);
        }
    }

    public interface u0 {
        void a();

        void a(String str);
    }

    public class v implements Consumer<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23256a;
        public final /* synthetic */ AccessiblityModel b;
        public final /* synthetic */ Context c;

        public v(u0 u0Var, AccessiblityModel accessiblityModel, Context context) {
            this.f23256a = u0Var;
            this.b = accessiblityModel;
            this.c = context;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("r") == 0) {
                a.a(this.f23256a);
                return;
            }
            String string = jSONObject.getString("gwc_link");
            this.b.getData().setSpop_deeplink(jSONObject.getString("gwc_deeplink"));
            this.b.getData().setSpop_link(string);
            n4.c().b(this.c, this.b);
            a.a(this.f23256a);
        }
    }

    public class w implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23257a;

        public w(u0 u0Var) {
            this.f23257a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f23257a);
        }
    }

    public class x implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f23258a;
        public final /* synthetic */ AccessiblityModel b;
        public final /* synthetic */ u0 c;

        public x(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
            this.f23258a = context;
            this.b = accessiblityModel;
            this.c = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.a(this.f23258a, this.b, this.c);
        }
    }

    public class y implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u0 f23259a;

        public y(u0 u0Var) {
            this.f23259a = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q2.b().a("close_coupon_window");
            a.a(this.f23259a);
        }
    }

    public class z implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f23260a;
        public final /* synthetic */ u0 b;

        public z(String str, u0 u0Var) {
            this.f23260a = str;
            this.b = u0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.a(this.f23260a, this.b);
        }
    }

    public static a b() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    public void A(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RoundRectImageView roundRectImageView = (RoundRectImageView) view.findViewById(R.id.iv_tb_big_recommend_icon);
        if (!TextUtils.isEmpty(accessiblityModel.getData().getSpop_pic())) {
            Glide.with(context).load(accessiblityModel.getData().getSpop_pic()).into(roundRectImageView);
        }
        TextView textView = (TextView) view.findViewById(R.id.tb_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.tb_small);
        a((ImageView) view.findViewById(R.id.iv_smill_close), u0Var);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_setting);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        a(imageView, accessiblityModel.getData().getPackage_name(), u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        textView.setText(accessiblityModel.getData().getSpop_title());
        b(8000, u0Var);
    }

    public void B(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.jd_lijin_close).setOnClickListener(new n(u0Var));
        ((LinearLayout) view.findViewById(R.id.jd_lijin_big)).setOnClickListener(new o(context, accessiblityModel, u0Var));
        Glide.with(context).load(Integer.valueOf(R.drawable.zkj_suiji)).into((ImageView) view.findViewById(R.id.jd_lijin_coupon_price));
        b(8000, u0Var);
    }

    public void C(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RoundRectImageView roundRectImageView = (RoundRectImageView) view.findViewById(R.id.iv_tb_big_recommend_icon);
        if (!TextUtils.isEmpty(accessiblityModel.getData().getSpop_pic())) {
            Glide.with(context).load(accessiblityModel.getData().getSpop_pic()).into(roundRectImageView);
        }
        TextView textView = (TextView) view.findViewById(R.id.tb_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.tb_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.tb_small);
        a((ImageView) view.findViewById(R.id.iv_smill_close), u0Var);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_setting);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        a(imageView, accessiblityModel.getData().getPackage_name(), u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b(8000, u0Var);
    }

    public void D(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.xbk_close).setOnClickListener(new c0(u0Var));
        view.setOnClickListener(new d0(context, accessiblityModel, u0Var));
        b(8000, u0Var);
    }

    public void E(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.eleme_close).setOnClickListener(new p(u0Var));
        view.setOnClickListener(new q(context, accessiblityModel, u0Var));
        if (a(accessiblityModel.getData().getSpop_coupon_price())) {
            return;
        }
        ((TextView) view.findViewById(R.id.eleme_coupon_price)).setText("¥" + accessiblityModel.getData().getSpop_coupon_price());
        b(8000, u0Var);
    }

    public void F(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        TextView textView = (TextView) view.findViewById(R.id.eleme_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.eleme_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.eleme_small_layout);
        a((ImageView) view.findViewById(R.id.iv_eleme_smile_close), u0Var);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        a((ImageView) view.findViewById(R.id.iv_eleme_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b(8000, u0Var);
    }

    public void G(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.eleme_small_layout);
        a((ImageView) view.findViewById(R.id.iv_eleme_smile_close), u0Var);
        a((ImageView) view.findViewById(R.id.iv_fz_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(8000, u0Var);
    }

    public void H(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.hxz_close).setOnClickListener(new h(u0Var));
        ((LinearLayout) view.findViewById(R.id.hxz_big)).setOnClickListener(new i(context, accessiblityModel, u0Var));
        if (a(accessiblityModel.getData().getNew_time_remaining()) || a(accessiblityModel.getData().getSpop_coupon_title())) {
            return;
        }
        ((TextView) view.findViewById(R.id.hxz_content_info)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(8000, u0Var);
    }

    public void I(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.jd_close).setOnClickListener(new j(u0Var));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.jd_big);
        linearLayout.setOnClickListener(new k(context, accessiblityModel, u0Var));
        linearLayout.setVisibility(0);
        if (a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        ((TextView) view.findViewById(R.id.jd_coupon_price)).setText("¥" + accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(R.id.jd_action_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(8000, u0Var);
    }

    public void J(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.jd_lijin_close).setOnClickListener(new l(u0Var));
        ((LinearLayout) view.findViewById(R.id.jd_lijin_big)).setOnClickListener(new m(context, accessiblityModel, u0Var));
        Glide.with(context).load(Integer.valueOf(R.drawable.zkj_suiji)).into((ImageView) view.findViewById(R.id.jd_lijin_coupon_price));
        b(8000, u0Var);
    }

    public void K(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RoundRectImageView roundRectImageView = (RoundRectImageView) view.findViewById(R.id.iv_jd_recommend_icon);
        TextView textView = (TextView) view.findViewById(R.id.jd_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.jd_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.jd_small);
        a((ImageView) view.findViewById(R.id.iv_jd_smill_close), u0Var);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getSpop_pic()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        a((ImageView) view.findViewById(R.id.iv_jd_smill_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        relativeLayout.setVisibility(0);
        a(context, relativeLayout, accessiblityModel, u0Var);
        Glide.with(context).load(accessiblityModel.getData().getSpop_pic()).into(roundRectImageView);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b(8000, u0Var);
    }

    public final Object c() throws ObjectStreamException {
        return d;
    }

    public void d(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.idlefish_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_idlefish_smile_close);
        a((ImageView) view.findViewById(R.id.iv_idlefish_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(8000, u0Var);
    }

    public void e(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.jd_home_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_jd_home_smile_close);
        a((ImageView) view.findViewById(R.id.iv_jd_home_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(8000, u0Var);
    }

    public void f(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.kfc_wp_close).setOnClickListener(new s0(u0Var));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.kfc_wp);
        linearLayout.setOnClickListener(new t0(context, accessiblityModel, u0Var));
        linearLayout.setVisibility(0);
        b(10000, u0Var);
    }

    public void g(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.ks_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_ks_smile_close);
        a((ImageView) view.findViewById(R.id.iv_ks_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(8000, u0Var);
    }

    public void h(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.shangou_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_shangou_smile_close);
        a((ImageView) view.findViewById(R.id.iv_shangou_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(8000, u0Var);
    }

    public void i(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.tb_home_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_tb_home_smile_close);
        a((ImageView) view.findViewById(R.id.iv_tb_home_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(8000, u0Var);
    }

    public void j(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.tencent_close).setOnClickListener(new b(u0Var));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.tencent_wp);
        linearLayout.setOnClickListener(new c(context, accessiblityModel, u0Var));
        linearLayout.setVisibility(0);
        if (a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        ((TextView) view.findViewById(R.id.tencent_price)).setText(accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(R.id.tencent_surplus_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(10000, u0Var);
    }

    public void k(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.aiqiyi_close).setOnClickListener(new o0(u0Var));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.video_aiqiyi);
        linearLayout.setOnClickListener(new p0(context, accessiblityModel, u0Var));
        linearLayout.setVisibility(0);
        if (a(accessiblityModel.getData().getNew_time_remaining()) || a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getOriginal_price())) {
            return;
        }
        ((TextView) view.findViewById(R.id.aiqiyi_monery)).setText(accessiblityModel.getData().getSpop_coupon_price());
        TextView textView = (TextView) view.findViewById(R.id.aiqiyi_all_monery);
        textView.setText(accessiblityModel.getData().getOriginal_price());
        textView.getPaint().setFlags(16);
        ((TextView) view.findViewById(R.id.aiqiyi_surplus_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(10000, u0Var);
    }

    public void l(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.wph_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_wph_smile_close);
        a((ImageView) view.findViewById(R.id.iv_wph_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(8000, u0Var);
    }

    public void m(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.taobao_close).setOnClickListener(new m0(u0Var));
        ((ImageView) view.findViewById(R.id.taobao_main_box)).setOnClickListener(new n0(context, accessiblityModel, u0Var));
        if (TextUtils.isEmpty(accessiblityModel.getData().getSpop_pic())) {
            return;
        }
        b(10000, u0Var);
    }

    public void n(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.youku_close).setOnClickListener(new d(u0Var));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.youku_wp);
        linearLayout.setOnClickListener(new e(context, accessiblityModel, u0Var));
        linearLayout.setVisibility(0);
        if (a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        ((TextView) view.findViewById(R.id.youku_price)).setText(accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(R.id.youku_surplus_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(10000, u0Var);
    }

    public void o(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.mt_xh_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_mt_xh_smile_close);
        a((ImageView) view.findViewById(R.id.iv_mt_xh_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(8000, u0Var);
    }

    public void p(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.mt_hotel_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_mt_hotel_smile_close);
        a((ImageView) view.findViewById(R.id.iv_mt_hotel_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(8000, u0Var);
    }

    public void q(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.mt_yy_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_mt_yy_smile_close);
        a((ImageView) view.findViewById(R.id.iv_mt_yy_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(8000, u0Var);
    }

    public void r(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.mt_shop_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_mt_shop_smile_close);
        a((ImageView) view.findViewById(R.id.iv_mt_shop_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(8000, u0Var);
    }

    public void s(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.didi_close).setOnClickListener(new w(u0Var));
        ((LinearLayout) view.findViewById(R.id.didi_big)).setOnClickListener(new x(context, accessiblityModel, u0Var));
        b(8000, u0Var);
    }

    public void t(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        TextView textView = (TextView) view.findViewById(R.id.didi_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.didi_small_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.didi_small);
        a((ImageView) view.findViewById(R.id.iv_didi_close), u0Var);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getSpop_title())) {
            return;
        }
        a((ImageView) view.findViewById(R.id.iv_didi_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        relativeLayout.setVisibility(0);
        a(context, relativeLayout, accessiblityModel, u0Var);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b(8000, u0Var);
    }

    public void u(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.fz_close).setOnClickListener(new t(u0Var));
        view.setOnClickListener(new u(context, accessiblityModel, u0Var));
        if (a(accessiblityModel.getData().getSpop_coupon_price())) {
            return;
        }
        b(8000, u0Var);
    }

    public void v(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.jdwm_close).setOnClickListener(new r(u0Var));
        view.setOnClickListener(new s(context, accessiblityModel, u0Var));
        if (a(accessiblityModel.getData().getSpop_coupon_price())) {
            return;
        }
        ((TextView) view.findViewById(R.id.jdwm_coupon_price)).setText(accessiblityModel.getData().getSpop_coupon_price());
        b(8000, u0Var);
    }

    public void w(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        TextView textView = (TextView) view.findViewById(R.id.jdwm_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.jdwm_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.jdwm_small_layout);
        a((ImageView) view.findViewById(R.id.iv_jdwm_smile_close), u0Var);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        a((ImageView) view.findViewById(R.id.iv_jdwm_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(context, relativeLayout, accessiblityModel, u0Var);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b(8000, u0Var);
    }

    public void x(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        TextView textView = (TextView) view.findViewById(R.id.meituan_content_info);
        TextView textView2 = (TextView) view.findViewById(R.id.meituan_content);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.meituan_small_layout);
        a((ImageView) view.findViewById(R.id.iv_meituan_smile_close), u0Var);
        if (a(accessiblityModel.getData().getPackage_name()) || a(accessiblityModel.getData().getSpop_title())) {
            return;
        }
        a((ImageView) view.findViewById(R.id.iv_meituan_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        relativeLayout.setVisibility(0);
        a(context, relativeLayout, accessiblityModel, u0Var);
        textView2.setText(accessiblityModel.getData().getSpop_title());
        textView.setText(accessiblityModel.getData().getNew_time_remaining());
        b(8000, u0Var);
    }

    public void y(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.meituan_close).setOnClickListener(new a0(u0Var));
        view.setOnClickListener(new b0(context, accessiblityModel, u0Var));
        b(8000, u0Var);
    }

    public void z(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.iv_close).setOnClickListener(new f(u0Var));
        ((ImageView) view.findViewById(R.id.taobao_treasure_box)).setOnClickListener(new g(context, accessiblityModel, u0Var));
        if (a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getSpop_coupon_title())) {
            return;
        }
        ((TextView) view.findViewById(R.id.tb_coupon_price)).setText("¥" + accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(R.id.tb_textview)).setText(accessiblityModel.getData().getSpop_coupon_title());
        b(8000, u0Var);
    }

    public void c(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.custom_small_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_custom_smile_close);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_custom);
        a((ImageView) view.findViewById(R.id.iv_custom_smile_setting), accessiblityModel.getData().getPackage_name(), u0Var);
        a(imageView, u0Var);
        if (TextUtils.isEmpty(accessiblityModel.getData().getSpop_pic())) {
            return;
        }
        Glide.with(context).load(accessiblityModel.getData().getSpop_pic()).into(imageView2);
        a(context, relativeLayout, accessiblityModel, u0Var);
        b(8000, u0Var);
    }

    public static void a(String str, u0 u0Var) {
        d();
        if (u0Var != null) {
            u0Var.a(str);
        }
    }

    public static void a(u0 u0Var) {
        TimerTask timerTask = e;
        if (timerTask != null) {
            timerTask.cancel();
            e = null;
        }
        if (u0Var != null) {
            u0Var.a();
        }
    }

    public static void b(int i2, u0 u0Var) {
        e = com.acse.ottn.n0.a().b(i2, 100, new C0114a(u0Var));
    }

    public static void d() {
        try {
            if (e != null) {
                h2.a(c, "timer is not null");
                e.cancel();
                e = null;
            }
        } catch (Exception unused) {
            h2.a(c, "current window is Destroy");
        }
    }

    public void b(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.taobao_close).setOnClickListener(new h0(u0Var));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.video_taobao_man);
        ImageView imageView = (ImageView) view.findViewById(R.id.taobao_main_box);
        imageView.setOnClickListener(new i0(context, accessiblityModel, u0Var));
        if (TextUtils.isEmpty(accessiblityModel.getData().getSpop_pic())) {
            return;
        }
        Glide.with(context).load(accessiblityModel.getData().getSpop_pic()).into(imageView);
        linearLayout.setVisibility(0);
        b(10000, u0Var);
    }

    public void a(Context context, AccessiblityModel accessiblityModel, u0 u0Var) {
        if (!TextUtils.isEmpty(accessiblityModel.getData().getTkl_url())) {
            if (accessiblityModel.getData().getTkl_url().startsWith("https")) {
                Intent intent = new Intent(context, (Class<?>) DemoService.class);
                intent.putExtra("tkl_url", accessiblityModel.getData().getTkl_url());
                context.startService(intent);
            } else {
                com.acse.ottn.o.c().a(context, accessiblityModel.getData().getTkl_url());
            }
        }
        h2.c(c, "开始点击");
        if (a(accessiblityModel.getData().getSpop_link()) || a(accessiblityModel.getData().getSpop_deeplink())) {
            return;
        }
        if (!"1".equals(accessiblityModel.getData().getPic_type()) && !"1".equals(accessiblityModel.getData().getShort_link())) {
            n4.c().b(context, accessiblityModel);
            a(u0Var);
            return;
        }
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("spop_coupon_price", accessiblityModel.getData().getSpop_coupon_price());
        treeMap.put(NativeCallContext.DOMAIN_APP, accessiblityModel.getData().getPackage_name());
        treeMap.put("spop_link", accessiblityModel.getData().getSpop_link());
        new l1().f(com.acse.ottn.t0.b().a(treeMap, "")).u5(Schedulers.newThread()).G3(com.acse.ottn.i.a()).s5(new v(u0Var, accessiblityModel, context), new g0(u0Var));
    }

    public void a(Context context, View view, AccessiblityModel accessiblityModel, u0 u0Var) {
        view.findViewById(R.id.baidu_wp_close).setOnClickListener(new q0(u0Var));
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.baidu_wp);
        linearLayout.setOnClickListener(new r0(context, accessiblityModel, u0Var));
        linearLayout.setVisibility(0);
        if (a(accessiblityModel.getData().getSpop_coupon_price()) || a(accessiblityModel.getData().getNew_time_remaining())) {
            return;
        }
        ((TextView) view.findViewById(R.id.baidu_wp_price)).setText(accessiblityModel.getData().getSpop_coupon_price());
        ((TextView) view.findViewById(R.id.baidu_wp_surplus_time)).setText(accessiblityModel.getData().getNew_time_remaining());
        b(10000, u0Var);
    }

    public final void a(ImageView imageView, u0 u0Var) {
        imageView.setOnClickListener(new y(u0Var));
    }

    public final void a(ImageView imageView, String str, u0 u0Var) {
        imageView.setOnClickListener(new z(str, u0Var));
    }

    public void a(View view, String str, boolean z2, u0 u0Var) {
        ((TextView) view.findViewById(R.id.tv_close)).setOnClickListener(new e0(u0Var, str, z2));
        ((ImageView) view.findViewById(R.id.iv_no_show_smill_close)).setOnClickListener(new f0(u0Var));
        b(4000, u0Var);
    }

    public final void a(Context context, RelativeLayout relativeLayout, AccessiblityModel accessiblityModel, u0 u0Var) {
        relativeLayout.setOnTouchListener(new j0(relativeLayout, relativeLayout.getY(), relativeLayout.getX(), u0Var, accessiblityModel, context));
    }

    public final void a(String str, boolean z2) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("limitType", z2 ? "coupon" : "lj");
        treeMap.put("is_snt", "0");
        treeMap.put("package_name", str);
        new com.acse.ottn.g0().r(com.acse.ottn.t0.b().a(treeMap, "")).u5(Schedulers.newThread()).G3(com.acse.ottn.i.a()).s5(new k0(), new l0());
    }

    public final boolean a(String str) {
        return TextUtils.isEmpty(str);
    }
}
