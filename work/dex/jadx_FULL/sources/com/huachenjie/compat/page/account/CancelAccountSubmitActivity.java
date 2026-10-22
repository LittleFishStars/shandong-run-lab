package com.huachenjie.compat.page.account;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.dialog.AlertDialog;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.compat.R;
import com.huachenjie.compat.page.account.CancelAccountSubmitActivity;
import com.huachenjie.run.map.RouteOverlay;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.i62;
import com.zj.adlib.m25;
import com.zj.adlib.wk0;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Route(path = RoutePathConstants.Compat.o)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/compat/page/account/CancelAccountSubmitActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/compat/page/account/CancelAccountSubmitVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initViewModel", "j0", "m0", bo.g, "", "x", "Ljava/lang/String;", "ticket", "y", AliyunLogCommon.TERMINAL_TYPE, "<init>", "()V", "compat_release"}, k = 1, mv = {1, 8, 0})
public final class CancelAccountSubmitActivity extends BaseVmActivity<CancelAccountSubmitVM> {

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    @Autowired(name = UserConstants.MINE_PARAMS.b)
    @JvmField
    @Nullable
    public String ticket;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    @Autowired(name = UserConstants.MINE_PARAMS.c)
    @JvmField
    @Nullable
    public String phone;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34086a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34086a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34086a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34086a.invoke(obj);
        }
    }

    public static final void k0(CancelAccountSubmitActivity cancelAccountSubmitActivity, View view) {
        Intrinsics.checkNotNullParameter(cancelAccountSubmitActivity, "this$0");
        cancelAccountSubmitActivity.finish();
    }

    public static final void l0(CancelAccountSubmitActivity cancelAccountSubmitActivity, View view) {
        Intrinsics.checkNotNullParameter(cancelAccountSubmitActivity, "this$0");
        cancelAccountSubmitActivity.m0();
    }

    public static final void n0(CancelAccountSubmitActivity cancelAccountSubmitActivity, View view) {
        Intrinsics.checkNotNullParameter(cancelAccountSubmitActivity, "this$0");
        cancelAccountSubmitActivity.p0();
    }

    public static final void o0(View view) {
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_cancel_account_submit), Integer.valueOf(wk0.p0), ((BaseVmActivity) this).f8507a);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        j0();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((CancelAccountSubmitVM) ((BaseVmActivity) this).f8507a).i().observe(this, new a(new Function1<Boolean, Unit>() { // from class: com.huachenjie.compat.page.account.CancelAccountSubmitActivity.initViewModel.1

            /* JADX INFO: renamed from: com.huachenjie.compat.page.account.CancelAccountSubmitActivity$initViewModel$1$a */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/compat/page/account/CancelAccountSubmitActivity$initViewModel$1$a", "Lcom/alibaba/android/arouter/facade/callback/NavCallback;", "Lcom/alibaba/android/arouter/facade/Postcard;", "postcard", "", "onArrival", "compat_release"}, k = 1, mv = {1, 8, 0})
            public static final class a extends NavCallback {
                @Override // com.alibaba.android.arouter.facade.callback.NavCallback, com.alibaba.android.arouter.facade.callback.NavigationCallback
                public void onArrival(@Nullable Postcard postcard) {
                    ActivityLifecycleManager.l().j(zj7.f.LOGIN);
                }
            }

            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    m25.b(CancelAccountSubmitActivity.this);
                    ARouter.getInstance().build(zj7.f.LOGIN).addFlags(268468224).navigation(CancelAccountSubmitActivity.this, new a());
                }
            }
        }));
    }

    public final void j0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = ((BaseVM) ((CancelAccountSubmitVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        Intrinsics.checkNotNull(value);
        BindingTitleBean titleName = bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(zn1.a(R.color.white)).setTitleName("注销账号");
        int i = R.color.color_2C3E50;
        ((CancelAccountSubmitVM) ((BaseVmActivity) this).f8507a).k().setValue(titleName.setTitleTextColor(zn1.a(i)).setBackShow(true).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(zn1.a(i))).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.pd1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CancelAccountSubmitActivity.k0(this.f43952a, view);
            }
        }).setShowRightText(true).setRightButtonText("提交").setRightButtonTextColor(Color.parseColor(RouteOverlay.f12338c)).setRightTextClick(new View.OnClickListener() { // from class: com.zj.adlib.qd1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CancelAccountSubmitActivity.l0(this.f44177a, view);
            }
        }));
    }

    public final void m0() {
        AlertDialog.AlertDataBean alertDataBean = new AlertDialog.AlertDataBean(null, 0.0f, 0, null, 0.0f, 0, null, 0.0f, 0, null, 0.0f, 0, false, 8191, null);
        alertDataBean.setContent("提交成功后，我们将在7个工作日内向学校核对注销信息并进行账户注销处理，请耐心等待。");
        alertDataBean.setContentColor(-16777216);
        alertDataBean.setCancel(OptionsPickerHelper.e);
        alertDataBean.setConfirm("确定");
        alertDataBean.setConfirmColor(Color.parseColor(RouteOverlay.f12338c));
        AlertDialog.INSTANCE.c(alertDataBean, new View.OnClickListener() { // from class: com.zj.adlib.nd1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CancelAccountSubmitActivity.n0(this.f43496a, view);
            }
        }, new View.OnClickListener() { // from class: com.zj.adlib.od1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CancelAccountSubmitActivity.o0(view);
            }
        }).show(getSupportFragmentManager(), AlertDialog.class.getName());
    }

    public final void p0() {
        ((CancelAccountSubmitVM) ((BaseVmActivity) this).f8507a).h(this.ticket, this.phone);
    }
}
