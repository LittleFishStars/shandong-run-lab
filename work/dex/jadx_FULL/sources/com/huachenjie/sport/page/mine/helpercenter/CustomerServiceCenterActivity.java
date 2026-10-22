package com.huachenjie.sport.page.mine.helpercenter;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.e;
import com.huachenjie.ad.interfaces.FDAdListener;
import com.huachenjie.base.util.CustomerServiceUtil;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.sport.R;
import com.huachenjie.sport.databinding.ActivityCustomerServiceCenterBinding;
import com.huachenjie.sport.page.mine.helpercenter.CustomerServiceCenterActivity;
import com.huachenjie.sport.page.mine.helpercenter.problem_tree.ProblemDecoration;
import com.zj.adlib.ew;
import com.zj.adlib.hp4;
import com.zj.adlib.i62;
import com.zj.adlib.kq5;
import com.zj.adlib.ok0;
import com.zj.adlib.r90;
import com.zj.adlib.xf7;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/sport/page/mine/helpercenter/CustomerServiceCenterActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/helpercenter/CustomerServiceCenterVM;", "", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "initData", "g0", "i0", "<init>", "()V", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class CustomerServiceCenterActivity extends BaseVmActivity<CustomerServiceCenterVM> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/sport/page/mine/helpercenter/CustomerServiceCenterActivity$a;", "", "Landroid/view/View;", "v", "", "b", "a", "<init>", "(Lcom/huachenjie/sport/page/mine/helpercenter/CustomerServiceCenterActivity;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ARouter.getInstance().build(RoutePathConstants.Sport.k).navigation();
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            CustomerServiceUtil.f32958a.g(CustomerServiceCenterActivity.this);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/sport/page/mine/helpercenter/CustomerServiceCenterActivity$b", "Lcom/huachenjie/ad/interfaces/FDAdListener;", "", "d", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends FDAdListener {
        public b() {
        }

        @Override // com.huachenjie.ad.interfaces.FDAdListener
        public void d() {
            kq5.b(CustomerServiceCenterActivity.this, "BagAdLoadedSuccessful", null);
        }
    }

    public static final void h0(CustomerServiceCenterActivity customerServiceCenterActivity, View view) {
        Intrinsics.checkNotNullParameter(customerServiceCenterActivity, "this$0");
        customerServiceCenterActivity.finish();
    }

    public final void g0() {
        e.p3(this).l3().T2(false).a1();
        BindingTitleBean titleName = new BindingTitleBean().setBackShow(true).setBackIconResId(R.drawable.ic_back_white).setTitleName("客服中心");
        Integer value = ((BaseVM) ((CustomerServiceCenterVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        Intrinsics.checkNotNull(value);
        ((CustomerServiceCenterVM) ((BaseVmActivity) this).f8507a).l().setValue(titleName.setStatusBarHeight(value.intValue()).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.vz1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomerServiceCenterActivity.h0(this.f45492a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_customer_service_center), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(ok0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    public final void i0() {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.sport.databinding.ActivityCustomerServiceCenterBinding");
        ew.f().g(hp4.c, this, getLifecycle(), ((ActivityCustomerServiceCenterBinding) binding).f36386a, new b());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        g0();
        initData();
    }

    public final void initData() {
        ((CustomerServiceCenterVM) ((BaseVmActivity) this).f8507a).j();
        MutableLiveData<RecyclerView.ItemDecoration> mutableLiveDataK = ((CustomerServiceCenterVM) ((BaseVmActivity) this).f8507a).k();
        Drawable drawableF = xf7.f(R.drawable.divider_problem);
        Intrinsics.checkNotNullExpressionValue(drawableF, "getDrawable(R.drawable.divider_problem)");
        mutableLiveDataK.setValue(new ProblemDecoration(drawableF));
        AdPlatformSwitch adPlatformSwitchE = r90.e("cslb");
        boolean z = false;
        if (adPlatformSwitchE != null && adPlatformSwitchE.getOpenFlag()) {
            z = true;
        }
        if (z) {
            i0();
        }
        ew.o(this, getLifecycle());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }
}
