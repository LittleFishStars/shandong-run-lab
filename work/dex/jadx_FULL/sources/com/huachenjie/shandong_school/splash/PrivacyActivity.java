package com.huachenjie.shandong_school.splash;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.login.util.ProtocolUtil;
import com.huachenjie.shandong_school.R;
import com.huachenjie.shandong_school.ShandongApplication;
import com.huachenjie.shandong_school.databinding.ActivityPrivacyBinding;
import com.zj.adlib.r90;
import com.zj.adlib.u90;
import com.zj.adlib.ys8;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\tH\u0002R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/shandong_school/splash/PrivacyActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/shandong_school/databinding/ActivityPrivacyBinding;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "", "", "V", "getLayoutResID", "", "initView", "onDestroy", "d0", "Landroid/os/Handler;", "b", "Lkotlin/Lazy;", "c0", "()Landroid/os/Handler;", "handler", "<init>", "()V", "a", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
public final class PrivacyActivity extends BaseMVVMActivity<ActivityPrivacyBinding, BaseViewModel> {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy handler = LazyKt.lazy(new Function0<Handler>() { // from class: com.huachenjie.shandong_school.splash.PrivacyActivity$handler$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m750invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/shandong_school/splash/PrivacyActivity$a;", "", "Landroid/view/View;", "view", "", "b", "a", "<init>", "(Lcom/huachenjie/shandong_school/splash/PrivacyActivity;)V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public final class a {

        /* JADX INFO: renamed from: com.huachenjie.shandong_school.splash.PrivacyActivity$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/huachenjie/shandong_school/splash/PrivacyActivity$a$a", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "a", "b", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
        public static final class C0823a extends DialogUtil.PositiveNegativeClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PrivacyActivity f36052a;

            public C0823a(PrivacyActivity privacyActivity) {
                this.f36052a = privacyActivity;
            }

            @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
            public void a() {
                this.f36052a.finish();
            }

            @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
            public void b() {
                this.f36052a.d0();
            }
        }

        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            PrivacyActivity.this.d0();
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            DialogUtil.z(PrivacyActivity.this, ys8.e(R.string.do_not_agree_title), ys8.e(R.string.do_not_agree_warn), ys8.e(R.string.do_not_agree_warn_exit_app), ys8.e(R.string.do_not_agree_warn_agree), new C0823a(PrivacyActivity.this));
        }
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(10, new a()));
    }

    public final Handler c0() {
        return (Handler) this.handler.getValue();
    }

    public final void d0() {
        getMLoadingDialog().show();
        r90.J(true);
        u90 u90Var = u90.f45091a;
        ShandongApplication.Companion companion = ShandongApplication.INSTANCE;
        ShandongApplication shandongApplicationA = companion.a();
        Intrinsics.checkNotNull(shandongApplicationA);
        u90Var.h(shandongApplicationA);
        ShandongApplication shandongApplicationA2 = companion.a();
        Intrinsics.checkNotNull(shandongApplicationA2);
        u90Var.f(shandongApplicationA2, new PrivacyActivity$onAgree$1(this));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.activity_privacy;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        ProtocolUtil protocolUtil = ProtocolUtil.f10119a;
        TextView textView = getMBinding().f36021a;
        Intrinsics.checkNotNullExpressionValue(textView, "mBinding.tvInfo");
        ProtocolUtil.g(protocolUtil, textView, null, 2, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        c0().removeCallbacksAndMessages(null);
        super.onDestroy();
    }
}
