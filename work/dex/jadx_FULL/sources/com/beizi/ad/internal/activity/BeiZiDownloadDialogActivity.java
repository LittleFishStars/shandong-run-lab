package com.beizi.ad.internal.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.ad.DownloadService;
import com.beizi.ad.lance.ApkBean;
import com.beizi.ad.v2.activity.BeiZiLandingPageActivity;
import com.beizi.fusion.R;
import com.beizi.fusion.bm;
import com.beizi.fusion.nh;
import com.beizi.fusion.of;
import com.beizi.fusion.x1;
import com.beizi.fusion.x3;
import com.beizi.fusion.x7;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BeiZiDownloadDialogActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FrameLayout f26858a;
    private TextView b;
    private TextView c;
    private TextView d;
    private ImageView e;
    private ImageView f;
    private ExpandableListView g;
    private LinearLayout h;
    private LinearLayout i;
    private TextView j;
    private TextView k;
    private ApkBean l;
    private int m = -1;
    private int n = 1;
    private List o;
    private String p;
    private boolean q;
    private boolean r;
    private String s;
    private int t;
    private x1.b.C0333b u;
    private nh v;
    private boolean w;

    public class a implements ExpandableListView.OnGroupClickListener {
        public a() {
        }

        @Override // android.widget.ExpandableListView.OnGroupClickListener
        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            try {
                if (BeiZiDownloadDialogActivity.this.g.isGroupExpanded(i)) {
                    BeiZiDownloadDialogActivity.this.g.collapseGroup(i);
                } else {
                    BeiZiDownloadDialogActivity.this.g.expandGroup(i);
                    if (i == 0) {
                        BeiZiDownloadDialogActivity.this.g.collapseGroup(1);
                        BeiZiDownloadDialogActivity.this.g.collapseGroup(2);
                    } else if (i == 1) {
                        BeiZiDownloadDialogActivity.this.g.collapseGroup(0);
                        BeiZiDownloadDialogActivity.this.g.collapseGroup(2);
                    } else if (i == 2) {
                        BeiZiDownloadDialogActivity.this.g.collapseGroup(0);
                        BeiZiDownloadDialogActivity.this.g.collapseGroup(1);
                    }
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BeiZiDownloadDialogActivity.this.finish();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BeiZiDownloadDialogActivity.this.a();
            BeiZiDownloadDialogActivity.this.finish();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BeiZiDownloadDialogActivity.this.d();
            BeiZiDownloadDialogActivity.this.finish();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BeiZiDownloadDialogActivity.this.a();
            BeiZiDownloadDialogActivity.this.finish();
        }
    }

    public class f implements of.f {
        public f() {
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            try {
                BeiZiDownloadDialogActivity.this.f.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            if (this.l == null) {
                return;
            }
            if (this.n != 2) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("apkBean", this.l);
                Intent intent = new Intent(this, (Class<?>) DownloadService.class);
                intent.putExtra("data", bundle);
                startService(intent);
                return;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(this.l.getApkUrl()));
            intent2.setFlags(268435456);
            startActivity(intent2);
            List list = this.o;
            if (list != null) {
                bm.a(list);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void b() {
        try {
            Bundle bundleExtra = getIntent().getBundleExtra("data");
            if (bundleExtra == null) {
                return;
            }
            if (bundleExtra.containsKey("apkBean")) {
                this.l = (ApkBean) bundleExtra.getSerializable("apkBean");
            }
            if (bundleExtra.containsKey("type")) {
                this.n = bundleExtra.getInt("type");
            }
            if (bundleExtra.containsKey("openList")) {
                this.o = bundleExtra.getStringArrayList("openList");
            }
            if (bundleExtra.containsKey("landingPageUrl")) {
                this.p = bundleExtra.getString("landingPageUrl");
            }
            if (bundleExtra.containsKey("isCanJump")) {
                this.q = bundleExtra.getBoolean("isCanJump", false);
            }
            if (bundleExtra.containsKey("isDownload")) {
                this.r = bundleExtra.getBoolean("isDownload", false);
            }
            if (bundleExtra.containsKey("deeplinkUrl")) {
                this.s = bundleExtra.getString("deeplinkUrl");
            }
            if (bundleExtra.containsKey("webDeepLink")) {
                this.t = bundleExtra.getInt("webDeepLink");
            }
            if (bundleExtra.containsKey("followTrackExt")) {
                this.u = (x1.b.C0333b) bundleExtra.getSerializable("followTrackExt");
            }
            if (bundleExtra.containsKey("lpOptimizeModule")) {
                this.v = (nh) bundleExtra.getSerializable("lpOptimizeModule");
            }
            if (bundleExtra.containsKey("isForbidOpenLandingPage")) {
                this.w = bundleExtra.getBoolean("isForbidOpenLandingPage");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c() {
        try {
            this.f26858a = (FrameLayout) findViewById(R.id.beizi_download_dialog_container_fl);
            this.e = (ImageView) findViewById(R.id.beizi_download_dialog_close_iv);
            this.f = (ImageView) findViewById(R.id.beizi_download_dialog_icon_iv);
            this.b = (TextView) findViewById(R.id.beizi_download_dialog_name_tv);
            this.c = (TextView) findViewById(R.id.beizi_download_dialog_version_tv);
            this.d = (TextView) findViewById(R.id.beizi_download_dialog_developer_tv);
            this.g = (ExpandableListView) findViewById(R.id.beizi_download_dialog_expand_lv);
            this.h = (LinearLayout) findViewById(R.id.beizi_download_dialog_download_container_ll);
            this.i = (LinearLayout) findViewById(R.id.beizi_download_dialog_market_container_ll);
            this.j = (TextView) findViewById(R.id.beizi_download_dialog_market_cancel_tv);
            this.k = (TextView) findViewById(R.id.beizi_download_dialog_market_confirm_tv);
            this.g.setOnGroupClickListener(new a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.n == 2 && !this.w && !TextUtils.isEmpty(this.p) && this.p.startsWith("http")) {
            try {
                Intent intent = new Intent(this, (Class<?>) BeiZiLandingPageActivity.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isRedirectionCanJump", this.q);
                bundle.putBoolean("isDownload", this.r);
                if (!TextUtils.isEmpty(this.s)) {
                    boolean z = true;
                    if (this.t != 1) {
                        z = false;
                    }
                    bundle.putBoolean("webDeepLink", z);
                    bundle.putString("deeplinkUrl", this.s);
                }
                if (!TextUtils.isEmpty(this.p)) {
                    bundle.putString("landingPageUrl", this.p);
                }
                x1.b.C0333b c0333b = this.u;
                if (c0333b != null) {
                    bundle.putSerializable("followTrackExt", c0333b);
                }
                nh nhVar = this.v;
                if (nhVar != null) {
                    bundle.putSerializable("lpOptimizeModule", nhVar);
                }
                intent.putExtra("data", bundle);
                intent.setFlags(268435456);
                startActivity(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void e() {
        try {
            if (this.l == null) {
                return;
            }
            if (this.n == 1) {
                this.e.setVisibility(0);
                this.e.setOnClickListener(new b());
                this.h.setVisibility(0);
                this.h.setOnClickListener(new c());
                this.i.setVisibility(8);
            } else {
                this.e.setVisibility(8);
                this.h.setVisibility(8);
                this.i.setVisibility(0);
                this.j.setOnClickListener(new d());
                this.k.setOnClickListener(new e());
            }
            if (this.f != null && !TextUtils.isEmpty(this.l.getAppIconURL())) {
                try {
                    of.a(this).a(this.l.getAppIconURL(), new f());
                } catch (Exception unused) {
                }
            }
            if (this.b != null && !TextUtils.isEmpty(this.l.getApkTittleName())) {
                this.b.setText(this.l.getApkTittleName());
            }
            if (this.c != null && !TextUtils.isEmpty(this.l.getAppVersion())) {
                this.c.setText("版本号 ：" + this.l.getAppVersion());
            }
            if (this.d != null && !TextUtils.isEmpty(this.l.getAppDeveloper())) {
                this.d.setText("开发者 ：" + this.l.getAppDeveloper());
            }
            ArrayList arrayList = new ArrayList();
            x7 x7Var = new x7();
            x7Var.c("应用权限");
            if (!TextUtils.isEmpty(this.l.getAppPermissionsUrl())) {
                x7Var.a(this.l.getAppPermissionsUrl());
                x7Var.b("h5");
            } else if (!TextUtils.isEmpty(this.l.getAppPermissionsDesc())) {
                x7Var.a(this.l.getAppPermissionsDesc());
                x7Var.b("text");
            }
            arrayList.add(x7Var);
            x7 x7Var2 = new x7();
            x7Var2.c("隐私协议");
            String appPrivacyUrl = this.l.getAppPrivacyUrl();
            if (!TextUtils.isEmpty(appPrivacyUrl)) {
                if (appPrivacyUrl.startsWith("http")) {
                    x7Var2.a(appPrivacyUrl);
                    x7Var2.b("h5");
                } else {
                    x7Var2.a(appPrivacyUrl);
                    x7Var2.b("text");
                }
            }
            arrayList.add(x7Var2);
            x7 x7Var3 = new x7();
            x7Var3.c("产品功能介绍");
            String appintro = this.l.getAppintro();
            if (!TextUtils.isEmpty(appintro)) {
                if (appintro.startsWith("http")) {
                    x7Var3.a(appintro);
                    x7Var3.b("h5");
                } else {
                    x7Var3.a(appintro);
                    x7Var3.b("text");
                }
            }
            arrayList.add(x7Var3);
            this.g.setAdapter(new x3(this, arrayList));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.beizi_download_dialog);
        setFinishOnTouchOutside(false);
        b();
        c();
        e();
    }
}
