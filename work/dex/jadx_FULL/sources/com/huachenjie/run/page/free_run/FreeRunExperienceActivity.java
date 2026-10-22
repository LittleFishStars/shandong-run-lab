package com.huachenjie.run.page.free_run;

import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.byazt.hv.TTDownloadField;
import com.gyf.immersionbar.e;
import com.hjq.permissions.Permission;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.permission.RequiredSettingComponent;
import com.huachenjie.common.util.permission.PermissionResultListener;
import com.huachenjie.run.R;
import com.huachenjie.run.page.free_run.FreeRunExperienceActivity;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.en7;
import com.zj.adlib.fv5;
import com.zj.adlib.i62;
import com.zj.adlib.lj0;
import com.zj.adlib.lk0;
import com.zj.adlib.r90;
import com.zj.adlib.vo6;
import huachenjie.sdk.map.adapter.location.callback.HCJLocationListener;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import java.lang.ref.WeakReference;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Route(path = RoutePathConstants.Run.o)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\n\u001a\u00020\u0003H\u0014J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/run/page/free_run/FreeRunExperienceActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "e0", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "initViewModel", "d0", bo.g, "m0", "n0", "l0", "", "code", "k0", "o0", "Lcom/huachenjie/common/permission/RequiredSettingComponent;", "", "a", "Lcom/huachenjie/common/permission/RequiredSettingComponent;", "requiredSettingComponent", "Lcom/huachenjie/run/page/free_run/FreeRunExperienceActivity$b;", "Lcom/huachenjie/run/page/free_run/FreeRunExperienceActivity$b;", "mLocationListener", "<init>", "()V", "b", "run_release"}, k = 1, mv = {1, 8, 0})
public final class FreeRunExperienceActivity extends BaseVmActivity<BaseVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public RequiredSettingComponent<Object> requiredSettingComponent;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public b mLocationListener;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/run/page/free_run/FreeRunExperienceActivity$a;", "", "Landroid/view/View;", "view", "", "c", "b", "<init>", "(Lcom/huachenjie/run/page/free_run/FreeRunExperienceActivity;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public static final void d(FreeRunExperienceActivity freeRunExperienceActivity, boolean z) {
            Intrinsics.checkNotNullParameter(freeRunExperienceActivity, "this$0");
            if (z) {
                freeRunExperienceActivity.p0();
            }
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            FreeRunExperienceActivity.this.finish();
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (!vo6.a(FreeRunExperienceActivity.this)) {
                RequiredSettingComponent requiredSettingComponent = FreeRunExperienceActivity.this.requiredSettingComponent;
                if (requiredSettingComponent != null) {
                    requiredSettingComponent.d(1);
                    return;
                }
                return;
            }
            if (vo6.c(FreeRunExperienceActivity.this, Permission.POST_NOTIFICATIONS)) {
                final FreeRunExperienceActivity freeRunExperienceActivity = FreeRunExperienceActivity.this;
                en7.e(freeRunExperienceActivity, new PermissionResultListener() { // from class: com.zj.adlib.ym3
                    @Override // com.huachenjie.common.util.permission.PermissionResultListener
                    public final void onResult(boolean z) {
                        FreeRunExperienceActivity.a.d(freeRunExperienceActivity, z);
                    }
                });
            } else {
                RequiredSettingComponent requiredSettingComponent2 = FreeRunExperienceActivity.this.requiredSettingComponent;
                if (requiredSettingComponent2 != null) {
                    requiredSettingComponent2.d(2);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/run/page/free_run/FreeRunExperienceActivity$b;", "Lhuachenjie/sdk/map/adapter/location/callback/HCJLocationListener;", "", "code", "Lhuachenjie/sdk/map/lib_base/HCJAddressInfo;", "hcjAddressInfo", "", "onLocationListener", "Ljava/lang/ref/WeakReference;", "Lcom/huachenjie/run/page/free_run/FreeRunExperienceActivity;", "a", "Ljava/lang/ref/WeakReference;", "weakReference", TTDownloadField.TT_ACTIVITY, "<init>", "(Lcom/huachenjie/run/page/free_run/FreeRunExperienceActivity;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements HCJLocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        public WeakReference<FreeRunExperienceActivity> weakReference;

        public b(@NotNull FreeRunExperienceActivity freeRunExperienceActivity) {
            Intrinsics.checkNotNullParameter(freeRunExperienceActivity, TTDownloadField.TT_ACTIVITY);
            this.weakReference = new WeakReference<>(freeRunExperienceActivity);
        }

        public void onLocationListener(int code, @Nullable HCJAddressInfo hcjAddressInfo) {
            WeakReference<FreeRunExperienceActivity> weakReference = this.weakReference;
            if (weakReference == null) {
                return;
            }
            FreeRunExperienceActivity freeRunExperienceActivity = weakReference != null ? weakReference.get() : null;
            if (freeRunExperienceActivity == null || freeRunExperienceActivity.isDestroyed()) {
                return;
            }
            freeRunExperienceActivity.o0();
            freeRunExperienceActivity.dismissLoadingDialogs();
            if (code != 0 || hcjAddressInfo == null) {
                freeRunExperienceActivity.k0(code);
            } else {
                r90.k0(hcjAddressInfo);
                freeRunExperienceActivity.l0();
            }
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void d0() {
        super.d0();
        o0();
        this.mLocationListener = null;
        dismissLoadingDialogs();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e.p3(this).G2(R.color.transparent).T2(false).u1(R.color.white).G1(true).a1();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.run_activity_free_run_experience), Integer.valueOf(lk0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(lk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        RequiredSettingComponent<Object> requiredSettingComponent = new RequiredSettingComponent<>(this);
        getLifecycle().addObserver(requiredSettingComponent);
        this.requiredSettingComponent = requiredSettingComponent;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    public final void k0(int code) {
        fv5.b("定位失败" + code);
    }

    public final void l0() {
        n0();
    }

    public final void m0() {
        showLoadingDialog(false);
        if (this.mLocationListener == null) {
            this.mLocationListener = new b(this);
        }
        b bVar = this.mLocationListener;
        Intrinsics.checkNotNull(bVar);
        lj0.p(this, false, null, bVar, 6, null);
    }

    public final void n0() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        ARouter.getInstance().build(RoutePathConstants.Run.e).withString("runRecordCode", string).navigation();
    }

    public final void o0() {
        lj0.t(this, false, 2, null);
    }

    public final void p0() {
        HCJAddressInfo hCJAddressInfoO = r90.o();
        if (hCJAddressInfoO == null || System.currentTimeMillis() - hCJAddressInfoO.getTime() >= 3000) {
            m0();
        } else {
            n0();
        }
    }
}
