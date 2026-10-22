package com.huachenjie.college.page.lightningPlay;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.e;
import com.huachenjie.base.util.ThirdUtil;
import com.huachenjie.college.R;
import com.huachenjie.college.page.lightningPlay.LightningPlayActivity;
import com.huachenjie.common.base.data_binding.BaseTitleVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.zj.adlib.ai9;
import com.zj.adlib.ft1;
import com.zj.adlib.i62;
import com.zj.adlib.r90;
import com.zj.adlib.uk0;
import com.zj.adlib.zj7;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0014J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/college/page/lightningPlay/LightningPlayActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/common/base/data_binding/BaseTitleVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "", "initViewModel", "e0", "injectArouter", "Landroid/os/Bundle;", "savedInstanceState", "init", "onBackPressed", "h0", "i0", "Lcom/huachenjie/college/page/lightningPlay/MoxiPlayFragment;", "a", "Lcom/huachenjie/college/page/lightningPlay/MoxiPlayFragment;", "fragment", "", "Lkotlin/Lazy;", "g0", "()Ljava/lang/String;", "url", "<init>", "()V", "college_release"}, k = 1, mv = {1, 8, 0})
public final class LightningPlayActivity extends BaseVmActivity<BaseTitleVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String x = "url";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public MoxiPlayFragment fragment;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy url = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.college.page.lightningPlay.LightningPlayActivity$url$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("url");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.college.page.lightningPlay.LightningPlayActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/huachenjie/college/page/lightningPlay/LightningPlayActivity$a;", "", "Landroid/content/Context;", "context", "", "url", "", "a", "KEY_URL", "Ljava/lang/String;", "<init>", "()V", "college_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String url) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            Intent intent = new Intent(context, (Class<?>) LightningPlayActivity.class);
            intent.putExtra("url", url);
            context.startActivity(intent);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/college/page/lightningPlay/LightningPlayActivity$b", "Lcom/alibaba/android/arouter/facade/callback/NavCallback;", "Lcom/alibaba/android/arouter/facade/Postcard;", "postcard", "", "onArrival", "college_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends NavCallback {
        public b() {
        }

        @Override // com.alibaba.android.arouter.facade.callback.NavCallback, com.alibaba.android.arouter.facade.callback.NavigationCallback
        public void onArrival(@NotNull Postcard postcard) {
            Intrinsics.checkNotNullParameter(postcard, "postcard");
            LightningPlayActivity.this.finish();
        }
    }

    public static final void j0(LightningPlayActivity lightningPlayActivity, View view) {
        Intrinsics.checkNotNullParameter(lightningPlayActivity, "this$0");
        if (r90.G()) {
            ARouter.getInstance().build(zj7.f.LOGIN).navigation(lightningPlayActivity, lightningPlayActivity.new b());
        } else {
            lightningPlayActivity.startActivity(lightningPlayActivity.getApplication().getPackageManager().getLaunchIntentForPackage(lightningPlayActivity.getApplicationInfo().packageName));
            lightningPlayActivity.finish();
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e eVarP3 = e.p3(this);
        int i = R.color.transparent;
        eVarP3.G2(i).T2(true).u1(i).G1(true).a1();
    }

    public final String g0() {
        return (String) this.url.getValue();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.college_activity_lightning_play), Integer.valueOf(uk0.p0), ((BaseVmActivity) this).f8507a);
    }

    public final void h0() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fragmentManager.beginTransaction()");
        int i = R.id.flContainer;
        MoxiPlayFragment moxiPlayFragment = this.fragment;
        MoxiPlayFragment moxiPlayFragment2 = null;
        if (moxiPlayFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            moxiPlayFragment = null;
        }
        MoxiPlayFragment moxiPlayFragment3 = this.fragment;
        if (moxiPlayFragment3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
        } else {
            moxiPlayFragment2 = moxiPlayFragment3;
        }
        fragmentTransactionBeginTransaction.add(i, moxiPlayFragment, moxiPlayFragment2.getClass().getName());
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
    }

    public final void i0() {
        ft1.g(this).X("登录提示").Q("我们需要您登录闪动校园APP，进行登录授权之后才能参加活动。").N("去登录").J(new View.OnClickListener() { // from class: com.zj.adlib.jx4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LightningPlayActivity.j0(this.f42694a, view);
            }
        }).Y();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        ThirdUtil thirdUtil = ThirdUtil.f7255a;
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "this.application");
        thirdUtil.h(application);
        MoxiPlayFragment.Companion companion = MoxiPlayFragment.INSTANCE;
        String strG0 = g0();
        Intrinsics.checkNotNullExpressionValue(strG0, "url");
        this.fragment = companion.a(strG0);
        if (ai9.l()) {
            h0();
        } else {
            i0();
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void injectArouter() {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        MoxiPlayFragment moxiPlayFragment = this.fragment;
        if (moxiPlayFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            moxiPlayFragment = null;
        }
        if (moxiPlayFragment.canGoBack()) {
            return;
        }
        super.onBackPressed();
    }
}
