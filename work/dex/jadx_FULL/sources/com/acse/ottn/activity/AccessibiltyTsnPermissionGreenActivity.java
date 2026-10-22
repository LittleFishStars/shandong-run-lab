package com.acse.ottn.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.acse.ottn.R;
import com.acse.ottn.a0;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.acse.ottn.b5;
import com.acse.ottn.d5;
import com.acse.ottn.e0;
import com.acse.ottn.f4;
import com.acse.ottn.g2;
import com.acse.ottn.g3;
import com.acse.ottn.h0;
import com.acse.ottn.h2;
import com.acse.ottn.i1;
import com.acse.ottn.n3;
import com.acse.ottn.p2;
import com.acse.ottn.p4;
import com.acse.ottn.q2;
import com.acse.ottn.r1;
import com.acse.ottn.s0;
import com.acse.ottn.util.HelpShopAppUtil;
import com.acse.ottn.z0;
import com.igexin.assist.util.AssistUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AccessibiltyTsnPermissionGreenActivity extends a0 {
    public RelativeLayout A;
    public RelativeLayout B;
    public RelativeLayout C;
    public RelativeLayout D;
    public AutoScrollViewPager E;
    public TextView G;
    public RelativeLayout H;
    public String I;
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public TextView n;
    public AlertDialog o;
    public AppCompatCheckBox p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public TextView z;
    public int F = 0;
    public e0.b J = new b();
    public long K = 0;
    public Handler L = new Handler(Looper.getMainLooper());
    public Runnable M = new d();
    public Runnable N = new e();

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(AccessibiltyTsnPermissionGreenActivity.this, (Class<?>) SeedWebViewActivity.class);
            intent.putExtra("url", h0.a().c(AccessibiltyTsnPermissionGreenActivity.this));
            AccessibiltyTsnPermissionGreenActivity.this.startActivity(intent);
        }
    }

    public class b implements e0.b<Integer> {
        public b() {
        }

        @Override // com.acse.ottn.e0.b
        @RequiresApi(api = 23)
        public void a(int i, Integer num) {
            AccessibiltyTsnPermissionGreenActivity.this.l();
        }
    }

    public class c implements z0.c {
        public c() {
        }

        @Override // com.acse.ottn.z0.c
        public void a() {
            q2.b().a("refuse_vivo_buttery_manage");
        }

        @Override // com.acse.ottn.z0.c
        public void b() {
            q2.b().a("allow_vivo_buttery_manage");
            String strA = n3.a().a("battery_hignt_size", "0");
            if (strA.equals("0")) {
                n3.a().b("battery_hignt_size", "1");
            } else if (strA.equals("1")) {
                n3.a().b("battery_hignt_size", "2");
            }
            b5.a((Activity) AccessibiltyTsnPermissionGreenActivity.this);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        @RequiresApi(api = 23)
        public void run() {
            AccessibiltyTsnPermissionGreenActivity.this.l();
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        @RequiresApi(api = 23)
        public void run() {
            AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity = AccessibiltyTsnPermissionGreenActivity.this;
            accessibiltyTsnPermissionGreenActivity.c(accessibiltyTsnPermissionGreenActivity.getResources().getString(R.string.dialog_vivo_battery_message));
        }
    }

    public class f implements z0.c {
        public f() {
        }

        @Override // com.acse.ottn.z0.c
        public void a() {
            q2.b().a("refuse_service_permission");
        }

        @Override // com.acse.ottn.z0.c
        public void b() {
            q2.b().a("allow_service_permission");
            n3.a().b("OpenPermissionName", "应用启动管理");
            d5 d5VarA = d5.a();
            AccessibiltyTsnPermissionGreenActivity accessibiltyTsnPermissionGreenActivity = AccessibiltyTsnPermissionGreenActivity.this;
            d5VarA.a(accessibiltyTsnPermissionGreenActivity, accessibiltyTsnPermissionGreenActivity.getPackageName());
        }
    }

    public class g implements z0.c {
        public g() {
        }

        @Override // com.acse.ottn.z0.c
        public void a() {
        }

        @Override // com.acse.ottn.z0.c
        public void b() {
            q2.b().a("all_permission_open");
            AccessibiltyTsnPermissionGreenActivity.this.setResult(-1);
            AccessibiltyTsnPermissionGreenActivity.this.finish();
        }
    }

    public class h implements com.acse.ottn.c.d {
        public h() {
        }

        @Override // com.acse.ottn.c.d
        public void onDismiss() {
            q2.b().a("refuse_continue_open_permission");
            AccessibiltyTsnPermissionGreenActivity.this.finish();
        }

        @Override // com.acse.ottn.c.d
        public void onOpen() {
            q2.b().a("continue_open_permission");
            AccessibiltyTsnPermissionGreenActivity.this.l();
        }
    }

    public class i implements z0.c {
        public i() {
        }

        @Override // com.acse.ottn.z0.c
        public void a() {
            q2.b().a("cancle_flow_window_list");
        }

        @Override // com.acse.ottn.z0.c
        public void b() {
            i1.b().a((Activity) AccessibiltyTsnPermissionGreenActivity.this, 10011);
        }
    }

    public class j implements f4.h {
        public j() {
        }

        @Override // com.acse.ottn.f4.h
        public void onDismiss() {
            q2.b().a("refuse_service");
        }

        @Override // com.acse.ottn.f4.h
        public void onOpen() {
            n3.a().a("is_agree_service", Boolean.TRUE);
            q2.b().a("allow_service");
            AccessibiltyTsnPermissionGreenActivity.this.p.setChecked(true);
            AccessibiltyTsnPermissionGreenActivity.this.l();
        }
    }

    public class k implements CompoundButton.OnCheckedChangeListener {
        public k() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                AccessibiltyTsnPermissionGreenActivity.this.p.setSupportButtonTintList(ColorStateList.valueOf(Color.parseColor(h0.a().f(AccessibiltyTsnPermissionGreenActivity.this))));
            }
        }
    }

    public class l implements z0.c {
        public l() {
        }

        @Override // com.acse.ottn.z0.c
        public void a() {
            q2.b().a("refuse_minu_service_run");
        }

        @Override // com.acse.ottn.z0.c
        public void b() {
            q2.b().a("allow_minu_service_run");
            p2.c(AccessibiltyTsnPermissionGreenActivity.this);
        }
    }

    public class m implements z0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22804a;

        public m(String str) {
            this.f22804a = str;
        }

        @Override // com.acse.ottn.z0.c
        public void a() {
        }

        @Override // com.acse.ottn.z0.c
        public void b() {
            if (n3.a().c("location_permission_size") != 0) {
                if (this.f22804a.equals("1")) {
                    n3.a().a("location_permission_size", 2);
                    g2.a().c((Activity) AccessibiltyTsnPermissionGreenActivity.this);
                    return;
                } else {
                    if (this.f22804a.equals("2")) {
                        if ("samsung".equals(AccessibiltyTsnPermissionGreenActivity.this.I)) {
                            n3.a().a("battery_white_samsung", Boolean.TRUE);
                        }
                        n3.a().a("location_permission_size", 3);
                        g2.a().b((Activity) AccessibiltyTsnPermissionGreenActivity.this);
                        return;
                    }
                    return;
                }
            }
            n3.a().a("location_permission_size", 1);
            if (!AssistUtils.BRAND_HON.equals(AccessibiltyTsnPermissionGreenActivity.this.I) || Build.VERSION.SDK_INT < 36) {
                n3.a().a("battery_white", Boolean.TRUE);
                g2.a().f(AccessibiltyTsnPermissionGreenActivity.this);
                return;
            }
            n3 n3VarA = n3.a();
            Boolean bool = Boolean.TRUE;
            n3VarA.a("battery_white", bool);
            n3.a().b("OpenPermissionName", "权限管理");
            n3.a().a("location_permission", bool);
            g2.a().d(AccessibiltyTsnPermissionGreenActivity.this);
        }
    }

    public class n implements z0.c {
        public n() {
        }

        @Override // com.acse.ottn.z0.c
        public void a() {
            q2.b().a("refuse_service_permission");
        }

        @Override // com.acse.ottn.z0.c
        public void b() {
            n3 n3VarA = n3.a();
            Boolean bool = Boolean.TRUE;
            n3VarA.a("oppo_35_autostart", bool);
            n3.a().a("battery_white", bool);
            AccessibiltyTsnPermissionGreenActivity.this.startActivity(new Intent("android.settings.SETTINGS"));
        }
    }

    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.l();
        }
    }

    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.l();
        }
    }

    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.l();
        }
    }

    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.l();
        }
    }

    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.l();
        }
    }

    public class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        @RequiresApi(api = 23)
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.l();
        }
    }

    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AccessibiltyTsnPermissionGreenActivity.this.f();
        }
    }

    public class v implements View.OnClickListener {
        public v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(AccessibiltyTsnPermissionGreenActivity.this, (Class<?>) SeedWebViewActivity.class);
            intent.putExtra("url", h0.a().e(AccessibiltyTsnPermissionGreenActivity.this));
            AccessibiltyTsnPermissionGreenActivity.this.startActivity(intent);
        }
    }

    public final void e() {
        if (System.currentTimeMillis() - this.K <= 2000) {
            finish();
        } else {
            Toast.makeText(this, "再按返回键一次退出", 0).show();
            this.K = System.currentTimeMillis();
        }
    }

    public final void f() {
        a(this, this.o);
        this.o = com.acse.ottn.c.a(this, getResources().getString(R.string.permission_warning), new h());
    }

    @RequiresApi(api = 23)
    @SuppressLint({"RestrictedApi"})
    public final void g() {
        this.e = (ImageView) findViewById(R.id.banner);
        this.t = (TextView) findViewById(R.id.tv_first_line);
        this.u = (TextView) findViewById(R.id.tv_secend_line);
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) findViewById(R.id.checkbox);
        this.p = appCompatCheckBox;
        appCompatCheckBox.setSupportButtonTintList(ColorStateList.valueOf(Color.parseColor(h0.a().f(this))));
        this.p.setOnCheckedChangeListener(new k());
        this.E = (AutoScrollViewPager) findViewById(R.id.banner1);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_accessiblity);
        this.A = relativeLayout;
        relativeLayout.setOnClickListener(new o());
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.rl_location);
        this.C = relativeLayout2;
        relativeLayout2.setOnClickListener(new p());
        this.e.setOnClickListener(new q());
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.rl_flow_window);
        this.B = relativeLayout3;
        relativeLayout3.setOnClickListener(new r());
        RelativeLayout relativeLayout4 = (RelativeLayout) findViewById(R.id.rl_battery);
        this.D = relativeLayout4;
        relativeLayout4.setOnClickListener(new s());
        this.f = (ImageView) findViewById(R.id.iv_accessiblity_two);
        this.g = (ImageView) findViewById(R.id.iv_flow_window_two);
        this.h = (ImageView) findViewById(R.id.iv_battery_two);
        this.i = (ImageView) findViewById(R.id.iv_accessiblity);
        this.k = (ImageView) findViewById(R.id.iv_location);
        this.l = (ImageView) findViewById(R.id.iv_location_two);
        this.j = (ImageView) findViewById(R.id.iv_flow_window);
        this.m = (ImageView) findViewById(R.id.iv_battery);
        this.H = (RelativeLayout) findViewById(R.id.rl_service);
        this.z = (TextView) findViewById(R.id.tv_location_describe);
        this.q = (TextView) findViewById(R.id.tv_accessiblity_describe);
        this.r = (TextView) findViewById(R.id.tv_flow_describe);
        this.n = (TextView) findViewById(R.id.tv_content);
        this.G = (TextView) findViewById(R.id.tv_warning);
        h0.a().a(this, (LinearLayout) findViewById(R.id.linearLayout_1));
        TextView textView = (TextView) findViewById(R.id.step_one);
        TextView textView2 = (TextView) findViewById(R.id.step_two);
        TextView textView3 = (TextView) findViewById(R.id.step_three);
        TextView textView4 = (TextView) findViewById(R.id.step_four);
        h0.a().a(this, textView, this.q);
        h0.a().a(this, textView2, this.r);
        h0.a().a(this, textView3, this.n);
        h0.a().a(this, textView4, this.z);
        RelativeLayout relativeLayout5 = (RelativeLayout) findViewById(R.id.av_back);
        RelativeLayout relativeLayout6 = (RelativeLayout) findViewById(R.id.rl_context);
        h0.a().b(this, relativeLayout5);
        h0.a().b(this, relativeLayout6);
        j();
        this.e.setImageResource(R.mipmap.banner_6);
        TextView textView5 = (TextView) findViewById(R.id.tv_open);
        this.s = textView5;
        textView5.setOnClickListener(new t());
        this.y = (TextView) findViewById(R.id.tv_my_think);
        h0.a().a(this, (TextView) null, this.y);
        this.y.setOnClickListener(new u());
        this.w = (TextView) findViewById(R.id.tv_service);
        this.v = (TextView) findViewById(R.id.tv_privacy);
        i();
    }

    public final boolean h() {
        if (!g3.a().d()) {
            return true;
        }
        boolean z = com.acse.ottn.b.c().e() && com.acse.ottn.b.c().a() && d5.a().b(getPackageName());
        if (("oneplus".equals(this.I) || "oppo".equals(this.I) || "realme".equals(this.I)) && Build.VERSION.SDK_INT >= 35) {
            return z && n3.a().a("oppo_35_autostart");
        }
        return z;
    }

    public final void i() {
        h0.a().e(this, this.t);
        h0.a().e(this, this.w);
        h0.a().e(this, this.v);
        h0.a().b(this, this.s);
        this.s.setText(R.string.permission_commit);
        this.t.setText(R.string.permission_title);
        this.u.setText(R.string.permission_title_two);
        h0.a().a(this, this.u, (TextView) null);
        this.q.setText(R.string.permission_accessiblity);
        this.r.setText(R.string.permission_flowwindow);
        this.n.setText(R.string.permission_home_back);
        this.w.setOnClickListener(new v());
        this.v.setOnClickListener(new a());
        h0.a().a(this, this.i, this.k, this.j, this.m, this.E, this.e);
    }

    public final void j() {
        h0.a().a(this, this.f, this.l, this.g, this.h, this.A, this.C, this.B, this.D, this.z);
    }

    public final void k() {
        this.o = z0.a(this, null, getString(R.string.permission_all_open), "好的", false, new g());
    }

    public final void l() {
        if (h()) {
            c();
            return;
        }
        if (!this.p.isChecked()) {
            m();
            return;
        }
        if (!com.acse.ottn.b.c().e()) {
            com.acse.ottn.a.c().b(this, 10010, this.F);
            this.F++;
            return;
        }
        if (n3.a().a("oppo_start_white_list")) {
            n3.a().a("oppo_start_white_list", Boolean.FALSE);
            n3.a().a("pay_secure", Boolean.TRUE);
            startActivity(new Intent("android.settings.SETTINGS"));
            return;
        }
        if (!com.acse.ottn.b.c().a()) {
            b(getPackageName());
            return;
        }
        if (("xiaomi".equals(this.I) || "redmi".equals(this.I)) && !n3.a().a("background_battery_hignt") && "2".equals(n3.a().e("flow_window_state"))) {
            a(getPackageName());
            return;
        }
        if (!d5.a().b(getPackageName())) {
            String string = getResources().getString(R.string.dialog_keep_back_two_title);
            if (this.I.equals("vivo")) {
                string = getResources().getString(R.string.dialog_keep_back_message);
            }
            a(getPackageName(), string);
            return;
        }
        if (this.I.equals("vivo")) {
            if (d5.a().b()) {
                c();
                return;
            } else {
                d(getPackageName());
                return;
            }
        }
        if ((!"oneplus".equals(this.I) && !"oppo".equals(this.I) && !"realme".equals(this.I)) || Build.VERSION.SDK_INT < 35) {
            c();
        } else if (n3.a().a("oppo_35_autostart") || n3.a().e("auto_start").equals("1")) {
            c();
        } else {
            this.L.postDelayed(this.N, 100L);
        }
    }

    public final void m() {
        a(this, this.o);
        this.o = f4.a(this, new j());
    }

    @Override // com.acse.ottn.a0, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        e();
    }

    @Override // com.acse.ottn.a0, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @RequiresApi(api = 23)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(Color.argb(0, 0, 0, 0));
        new AcseHelpManager.InitSdk().setContext(getApplication()).build();
        setContentView(R.layout.activity_vivo_accessibilty_permission);
        if (HelpShopAppUtil.getContext() == null) {
            new AcseHelpManager.InitSdk().setContext(getApplication()).build();
        }
        a(false);
        q2.b().a("open_accessiblity_page");
        if (n3.a() != null) {
            n3.a().b("flow_window_state", "1");
            n3 n3VarA = n3.a();
            Boolean bool = Boolean.FALSE;
            n3VarA.a("open_battery_white", bool);
            n3.a().a("background_battery_hignt", bool);
            n3.a().b("battery_hignt_size", "0");
            n3.a().a("open_battery_white_size", bool);
        }
        this.I = p4.b();
        this.F = 0;
        g();
        if (AssistUtils.BRAND_HON.equals(this.I)) {
            g2.a().c((Activity) this);
        } else if ("vivo".equals(this.I)) {
            r1.c();
            r1.f();
        }
    }

    @Override // com.acse.ottn.a0, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        a(this, this.o);
        h2.a("AccessibiltyTsnPermissionGreenActivity", "onDestroy");
        super.onDestroy();
    }

    @Override // com.acse.ottn.a0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        a(this, this.o);
        super.onPause();
    }

    @Override // com.acse.ottn.a0, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        q2.b().a("open_accessiblity_page_pv");
        try {
            j();
            boolean zA = com.acse.ottn.b.c().a();
            if (com.acse.ottn.b.c().e() && this.p.isChecked()) {
                a(this, this.o);
                this.L.postDelayed(this.M, 500L);
            }
            String strA = s0.d().a();
            String strE = n3.a().e("send_open_flow_window");
            if (!zA || strA.equals(strE)) {
                return;
            }
            q2.b().a("open_flow_window");
            n3.a().b("send_open_flow_window", strA);
        } catch (Exception e2) {
            h2.a("samon", "Exception e =" + e2.getMessage());
        }
    }

    public final void b(String str) {
        com.acse.ottn.b.c().a(false);
        a(this, this.o);
        this.o = z0.a(this, getResources().getString(R.string.dialog_flow_title), getResources().getString(R.string.dialog_flow_message), "好的", false, new i());
    }

    public final void c() {
        d();
    }

    public final void d(String str) {
        a(this, this.o);
        this.o = z0.a(this, "耗电管理:", getResources().getString(R.string.dialog_vivo_battery_message), "好的", false, new c());
    }

    public final void a(String str, String str2) {
        String str3 = Build.VERSION.SDK_INT >= 35 ? "允许后台运行:" : "允许后台运行和自启动权限:";
        a(this, this.o);
        this.o = z0.a(this, str3, str2, "好的", false, new f());
    }

    public final void c(String str) {
        a(this, this.o);
        this.o = z0.a(this, "允许自启动权限:", str, "好的", false, new n());
    }

    public final void d() {
        a(this, this.o);
        int iC = n3.a().c("location_permission_size");
        if (!d5.a().b(getPackageName())) {
            a(getPackageName(), getResources().getString(R.string.dialog_keep_back_two_title));
            return;
        }
        if (this.I.equals("vivo")) {
            if (!d5.a().b()) {
                d(getPackageName());
                return;
            }
            if (!g2.a().a((Context) this) && iC <= 1) {
                a(getResources().getString(R.string.location_title), getResources().getString(R.string.location_content), "1");
                return;
            } else if (!g2.a().b((Context) this) && iC <= 2) {
                a(getResources().getString(R.string.location_background_title), getResources().getString(R.string.location_background_content), "2");
                return;
            }
        } else {
            if (("oneplus".equals(this.I) || "oppo".equals(this.I) || "realme".equals(this.I)) && Build.VERSION.SDK_INT >= 35 && !n3.a().a("oppo_35_autostart") && !n3.a().e("auto_start").equals("1")) {
                this.L.postDelayed(this.N, 100L);
                return;
            }
            if (!g2.a().a((Context) this) && iC <= 1) {
                a(getResources().getString(R.string.location_title), getResources().getString(R.string.location_content), "1");
                return;
            } else if (!g2.a().b((Context) this) && iC <= 2) {
                a(getResources().getString(R.string.location_background_title), getResources().getString(R.string.location_background_content), "2");
                return;
            }
        }
        k();
    }

    public final void a(AppCompatActivity appCompatActivity, String str, int i2) {
        com.acse.ottn.a.c().a(appCompatActivity, i2);
    }

    @Override // com.acse.ottn.a0
    public void a(int i2) {
        Window window = getWindow();
        a(this, i2, 0);
        window.addFlags(2048);
        window.clearFlags(1024);
        window.getDecorView().setSystemUiVisibility(1280);
    }

    public final void a(String str) {
        String string = getResources().getString(R.string.dialog_keep_back_title);
        a(this, this.o);
        this.o = z0.a(this, string, getResources().getString(R.string.dialog_keep_back_message), "好的", false, new l());
    }

    public static void a(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        } catch (Exception unused) {
        }
    }

    public final void a(String str, String str2, String str3) {
        a(this, this.o);
        this.o = z0.a(this, str, str2, "好的", false, new m(str3));
    }
}
