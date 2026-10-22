package com.ltmb.ltadsdk.adx.ad.reward;

import android.app.Activity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import com.ltmb.ltadsdk.R;
import com.ltmb.ltadsdk.api.ad.SYRewardVideoAd;
import com.ltmb.ltadsdk.pkg.b6;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.e5;
import com.ltmb.ltadsdk.pkg.e6;
import com.ltmb.ltadsdk.pkg.uc;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ltmb/ltadsdk/adx/ad/reward/AdxRewardVideoActivity;", "Landroid/app/Activity;", "<init>", "()V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class AdxRewardVideoActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e6 f40293a;

    public static final class a extends Lambda implements Function0<Unit> {
        public a() {
            super(0);
        }

        public Object invoke() {
            AdxRewardVideoActivity.this.finish();
            return Unit.INSTANCE;
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        SYRewardVideoAd sYRewardVideoAd;
        super.onCreate(bundle);
        try {
            int intExtra = getIntent().getIntExtra("get_data_key", -1);
            if (intExtra == -1) {
                finish();
                return;
            }
            e5 e5Var = e5.f;
            try {
                sYRewardVideoAd = (SYRewardVideoAd) e5.a.get(intExtra);
            } catch (Throwable th) {
                d9.d.a(th);
                sYRewardVideoAd = null;
            }
            if (!(sYRewardVideoAd instanceof b6)) {
                finish();
                return;
            }
            uc.a(getWindow(), getResources().getColor(R.color.ltad_color_half_transparent), 1.0f);
            e5 e5Var2 = e5.f;
            try {
                e5.a.remove(intExtra);
            } catch (Throwable th2) {
                d9.d.a(th2);
            }
            Intrinsics.checkNotNullParameter(this, "context");
            e6 e6Var = new e6(this, (AttributeSet) null);
            this.f40293a = e6Var;
            e6Var.setData((b6) sYRewardVideoAd);
            e6 e6Var2 = this.f40293a;
            if (e6Var2 != null) {
                e6Var2.setOnCloseCallback(new a());
            }
            e6 e6Var3 = this.f40293a;
            if (e6Var3 != null) {
                e6Var3.setPadding(0, uc.a(this), 0, 0);
            }
            setContentView((View) this.f40293a);
        } catch (Throwable th3) {
            d9.d.a(th3);
            try {
                finish();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            super.onDestroy();
            e6 e6Var = this.f40293a;
            if (e6Var != null) {
                e6Var.b();
            }
            this.f40293a = null;
        } catch (Throwable th) {
            d9.d.a(th);
        }
    }
}
