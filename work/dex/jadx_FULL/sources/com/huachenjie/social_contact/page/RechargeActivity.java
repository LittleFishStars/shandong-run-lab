package com.huachenjie.social_contact.page;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.BuyStarDrillInfo;
import com.huachenjie.social_contact.bean.PayBean;
import com.huachenjie.social_contact.vm.PayVM;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.SocialContact.g)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0014¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/social_contact/page/RechargeActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/social_contact/vm/PayVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "init", "initViewModel", "<init>", "()V", "a", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class RechargeActivity extends BaseVmActivity<PayVM> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/social_contact/page/RechargeActivity$a;", "", "Landroid/view/View;", "v", "", "a", "b", "c", "<init>", "(Lcom/huachenjie/social_contact/page/RechargeActivity;)V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            RechargeActivity.this.finish();
        }

        public final void b(@NotNull View v) {
            String str;
            Intrinsics.checkNotNullParameter(v, "v");
            BuyStarDrillInfo value = ((PayVM) ((BaseVmActivity) RechargeActivity.this).f8507a).v().getValue();
            if (value != null) {
                RechargeActivity rechargeActivity = RechargeActivity.this;
                BuyStarDrillInfo value2 = ((PayVM) ((BaseVmActivity) rechargeActivity).f8507a).v().getValue();
                if ((value2 != null ? value2.getDoubleStarDill() : 0) == 1) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    str = String.format("%d星空钻", Arrays.copyOf(new Object[]{Integer.valueOf(value.getLeftStarDrill())}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                } else {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    str = String.format("%d星空钻", Arrays.copyOf(new Object[]{Integer.valueOf(value.getLeftStarDrill())}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                }
                ARouter.getInstance().build(RoutePathConstants.SocialContact.i).withParcelable(UserConstants.SOCIAL_CONTACT_PARAMS.f33737a, new PayBean(1, 11, null, value.getLeftPayAmount(), str)).withTransition(R.anim.actionsheet_dialog_in, R.anim.actionsheet_dialog_out).navigation(rechargeActivity);
            }
        }

        public final void c(@NotNull View v) {
            String str;
            Intrinsics.checkNotNullParameter(v, "v");
            BuyStarDrillInfo value = ((PayVM) ((BaseVmActivity) RechargeActivity.this).f8507a).v().getValue();
            if (value != null) {
                RechargeActivity rechargeActivity = RechargeActivity.this;
                BuyStarDrillInfo value2 = ((PayVM) ((BaseVmActivity) rechargeActivity).f8507a).v().getValue();
                if ((value2 != null ? value2.getDoubleStarDill() : 0) == 1) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    str = String.format("%d星空钻", Arrays.copyOf(new Object[]{Integer.valueOf(value.getRightStarDrill())}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                } else {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    str = String.format("%d星空钻", Arrays.copyOf(new Object[]{Integer.valueOf(value.getRightStarDrill())}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                }
                ARouter.getInstance().build(RoutePathConstants.SocialContact.i).withParcelable(UserConstants.SOCIAL_CONTACT_PARAMS.f33737a, new PayBean(1, 12, null, value.getRightPayAmount(), str)).withTransition(R.anim.actionsheet_dialog_in, R.anim.actionsheet_dialog_out).navigation(rechargeActivity);
            }
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_recharge), Integer.valueOf(nk0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(nk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        ((PayVM) ((BaseVmActivity) this).f8507a).i();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(-1);
        }
        super.onCreate(savedInstanceState);
    }
}
