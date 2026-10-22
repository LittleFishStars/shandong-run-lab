package com.huachenjie.compat.page.account;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.compat.R;
import com.huachenjie.compat.databinding.ActivityCancelAccountTipBinding;
import com.huachenjie.compat.page.account.CancelAccountTipActivity;
import com.zj.adlib.i62;
import com.zj.adlib.wk0;
import com.zj.adlib.zn1;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Route(path = RoutePathConstants.Compat.n)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/compat/page/account/CancelAccountTipActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/compat/page/account/CancelAccountTipVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initViewModel", "i0", "", "x", "Ljava/lang/String;", "ticket", "y", AliyunLogCommon.TERMINAL_TYPE, "<init>", "()V", "a", "compat_release"}, k = 1, mv = {1, 8, 0})
public final class CancelAccountTipActivity extends BaseVmActivity<CancelAccountTipVM> {

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

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/compat/page/account/CancelAccountTipActivity$a;", "", "Landroid/view/View;", "v", "", "a", "b", "<init>", "(Lcom/huachenjie/compat/page/account/CancelAccountTipActivity;)V", "compat_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            boolean zBooleanValue;
            Intrinsics.checkNotNullParameter(v, "v");
            Boolean value = ((CancelAccountTipVM) ((BaseVmActivity) CancelAccountTipActivity.this).f8507a).h().getValue();
            if (value == null) {
                value = Boolean.FALSE;
            }
            ((CancelAccountTipVM) ((BaseVmActivity) CancelAccountTipActivity.this).f8507a).h().setValue(Boolean.valueOf(!value.booleanValue()));
            ActivityCancelAccountTipBinding activityCancelAccountTipBinding = (ActivityCancelAccountTipBinding) CancelAccountTipActivity.this.getBinding();
            if (activityCancelAccountTipBinding != null) {
                CancelAccountTipActivity cancelAccountTipActivity = CancelAccountTipActivity.this;
                TextView textView = activityCancelAccountTipBinding.f9072a;
                Boolean value2 = ((CancelAccountTipVM) ((BaseVmActivity) cancelAccountTipActivity).f8507a).h().getValue();
                if (value2 == null) {
                    zBooleanValue = false;
                } else {
                    Intrinsics.checkNotNullExpressionValue(value2, "mState.mAgreement.value ?: false");
                    zBooleanValue = value2.booleanValue();
                }
                textView.setEnabled(zBooleanValue);
            }
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ARouter.getInstance().build(RoutePathConstants.Compat.o).withString(UserConstants.MINE_PARAMS.b, CancelAccountTipActivity.this.ticket).withString(UserConstants.MINE_PARAMS.c, CancelAccountTipActivity.this.phone).navigation();
            CancelAccountTipActivity.this.finish();
        }
    }

    public static final void j0(CancelAccountTipActivity cancelAccountTipActivity, View view) {
        Intrinsics.checkNotNullParameter(cancelAccountTipActivity, "this$0");
        cancelAccountTipActivity.finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_cancel_account_tip), Integer.valueOf(wk0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(wk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    public final void i0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = ((BaseVM) ((CancelAccountTipVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        Intrinsics.checkNotNull(value);
        BindingTitleBean titleName = bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(zn1.a(R.color.white)).setTitleName("注销账号");
        int i = R.color.color_2C3E50;
        ((CancelAccountTipVM) ((BaseVmActivity) this).f8507a).i().setValue(titleName.setTitleTextColor(zn1.a(i)).setBackShow(true).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(zn1.a(i))).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.rd1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CancelAccountTipActivity.j0(this.f44422a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        i0();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }
}
