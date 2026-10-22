package com.ltmb.ltadsdk.adx.dialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.ltmb.ltadsdk.R;
import com.ltmb.ltadsdk.adx.ui.view.AdxClickButton;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.e5;
import com.ltmb.ltadsdk.pkg.i1;
import com.ltmb.ltadsdk.pkg.n7;
import com.ltmb.ltadsdk.pkg.p3;
import com.ltmb.ltadsdk.pkg.s;
import com.ltmb.ltadsdk.ui.dialog.AdComplianceDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ltmb/ltadsdk/adx/dialog/AdDownloadDetailDialog;", "Landroid/app/Activity;", "<init>", "()V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class AdDownloadDetailDialog extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.ltmb.ltadsdk.pkg.e f40297a;
    public AdxClickButton b;
    public s c;
    public int d;

    public static final class a extends Lambda implements Function0<Unit> {
        public a() {
            super(0);
        }

        public Object invoke() {
            p3 p3Var;
            e5 e5Var = e5.f;
            try {
                p3Var = (p3) e5.d.get(AdDownloadDetailDialog.this.d);
            } catch (Throwable th) {
                d9.d.a(th);
                p3Var = null;
            }
            if (p3Var != null) {
                p3Var.a((Boolean) null, 0);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<s> {
        public b() {
            super(0);
        }

        public Object invoke() {
            return AdDownloadDetailDialog.this.c;
        }
    }

    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AdDownloadDetailDialog.this.finish();
        }
    }

    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.ltmb.ltadsdk.pkg.f fVar;
            AdDownloadDetailDialog adDownloadDetailDialog = AdDownloadDetailDialog.this;
            com.ltmb.ltadsdk.pkg.e eVar = adDownloadDetailDialog.f40297a;
            AdDownloadDetailDialog.a(adDownloadDetailDialog, "App功能介绍", (eVar == null || (fVar = ((com.ltmb.ltadsdk.pkg.d) eVar).g) == null) ? null : fVar.h);
        }
    }

    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.ltmb.ltadsdk.pkg.f fVar;
            AdDownloadDetailDialog adDownloadDetailDialog = AdDownloadDetailDialog.this;
            com.ltmb.ltadsdk.pkg.e eVar = adDownloadDetailDialog.f40297a;
            AdDownloadDetailDialog.a(adDownloadDetailDialog, "App权限", (eVar == null || (fVar = ((com.ltmb.ltadsdk.pkg.d) eVar).g) == null) ? null : fVar.j);
        }
    }

    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            com.ltmb.ltadsdk.pkg.f fVar;
            AdDownloadDetailDialog adDownloadDetailDialog = AdDownloadDetailDialog.this;
            com.ltmb.ltadsdk.pkg.e eVar = adDownloadDetailDialog.f40297a;
            AdDownloadDetailDialog.a(adDownloadDetailDialog, "App隐私", (eVar == null || (fVar = ((com.ltmb.ltadsdk.pkg.d) eVar).g) == null) ? null : fVar.i);
        }
    }

    public static final void a(AdDownloadDetailDialog adDownloadDetailDialog, String str, String str2) {
        adDownloadDetailDialog.getClass();
        if (str2 == null || str2.length() == 0) {
            return;
        }
        Intrinsics.checkNotNullParameter(adDownloadDetailDialog, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "url");
        Intent intent = new Intent(adDownloadDetailDialog, (Class<?>) AdComplianceDialog.class);
        intent.setPackage(adDownloadDetailDialog.getPackageName());
        intent.putExtra("title", str);
        intent.putExtra("url", str2);
        intent.addFlags(268435456);
        adDownloadDetailDialog.startActivity(intent);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        com.ltmb.ltadsdk.pkg.f fVar;
        com.ltmb.ltadsdk.pkg.f fVar2;
        com.ltmb.ltadsdk.pkg.f fVar3;
        com.ltmb.ltadsdk.pkg.f fVar4;
        com.ltmb.ltadsdk.pkg.f fVar5;
        com.ltmb.ltadsdk.pkg.f fVar6;
        boolean z = true;
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        overridePendingTransition(0, R.anim.ltad_activitydialog_exit_anim);
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("get_info_key", 0);
        this.d = intExtra;
        if (intExtra == 0) {
            finish();
            return;
        }
        this.c = getIntent().getParcelableExtra("click_info");
        setContentView(R.layout.ltad_dialog_download_detail);
        Window window = getWindow();
        if (window != null) {
            window.getAttributes().width = n7.b(this);
            window.setGravity(80);
            window.setBackgroundDrawableResource(R.color.ltad_color_transparent);
        }
        com.ltmb.ltadsdk.pkg.e eVarA = e5.f.a(this.d, true);
        this.f40297a = eVarA;
        if (eVarA == null) {
            return;
        }
        ((ImageView) findViewById(R.id.syad_iv_close)).setOnClickListener(new c());
        View viewFindViewById = findViewById(R.id.syad_btn_download);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.syad_btn_download)");
        AdxClickButton adxClickButton = (AdxClickButton) viewFindViewById;
        this.b = adxClickButton;
        if (adxClickButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBtnDownload");
        }
        adxClickButton.setOnClickCallback(new a());
        adxClickButton.setOnGetAdClickInfo(new b());
        ((TextView) findViewById(R.id.syad_tv_function)).setOnClickListener(new d());
        ((TextView) findViewById(R.id.syad_tv_permission)).setOnClickListener(new e());
        ((TextView) findViewById(R.id.syad_tv_privacy)).setOnClickListener(new f());
        com.ltmb.ltadsdk.pkg.e eVar = this.f40297a;
        if (eVar != null) {
            ImageView imageView = (ImageView) findViewById(R.id.syad_iv_ad_icon);
            TextView textView = (TextView) findViewById(R.id.syad_tv_ad_name);
            TextView textView2 = (TextView) findViewById(R.id.syad_tv_info);
            TextView textView3 = (TextView) findViewById(R.id.syad_tv_developer);
            com.ltmb.ltadsdk.pkg.e eVar2 = this.f40297a;
            String str = null;
            i1.a(imageView, (eVar2 == null || (fVar6 = ((com.ltmb.ltadsdk.pkg.d) eVar2).g) == null) ? null : fVar6.b, (i1.b) null);
            Intrinsics.checkNotNullExpressionValue(textView, "tvName");
            textView.setText(eVar.g());
            com.ltmb.ltadsdk.pkg.e eVar3 = this.f40297a;
            String str2 = (eVar3 == null || (fVar5 = ((com.ltmb.ltadsdk.pkg.d) eVar3).g) == null) ? null : fVar5.l;
            if (str2 != null && str2.length() != 0) {
                z = false;
            }
            if (z) {
                Intrinsics.checkNotNullExpressionValue(textView2, "tvInfo");
                StringBuilder sb = new StringBuilder();
                sb.append("版本号：");
                com.ltmb.ltadsdk.pkg.e eVar4 = this.f40297a;
                sb.append((eVar4 == null || (fVar4 = ((com.ltmb.ltadsdk.pkg.d) eVar4).g) == null) ? null : fVar4.o);
                textView2.setText(sb.toString());
            } else {
                Intrinsics.checkNotNullExpressionValue(textView2, "tvInfo");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("版本号：");
                com.ltmb.ltadsdk.pkg.e eVar5 = this.f40297a;
                sb2.append((eVar5 == null || (fVar2 = ((com.ltmb.ltadsdk.pkg.d) eVar5).g) == null) ? null : fVar2.o);
                sb2.append("｜备案号：");
                com.ltmb.ltadsdk.pkg.e eVar6 = this.f40297a;
                sb2.append((eVar6 == null || (fVar = ((com.ltmb.ltadsdk.pkg.d) eVar6).g) == null) ? null : fVar.l);
                textView2.setText(sb2.toString());
            }
            Intrinsics.checkNotNullExpressionValue(textView3, "tvDevelop");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("开发者：");
            com.ltmb.ltadsdk.pkg.e eVar7 = this.f40297a;
            if (eVar7 != null && (fVar3 = ((com.ltmb.ltadsdk.pkg.d) eVar7).g) != null) {
                str = fVar3.k;
            }
            sb3.append(str);
            textView3.setText(sb3.toString());
            AdxClickButton adxClickButton2 = this.b;
            if (adxClickButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBtnDownload");
            }
            adxClickButton2.setAdsBean(eVar);
        }
    }
}
