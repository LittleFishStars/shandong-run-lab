package com.huachenjie.sport.page.mine.sport_test.test_list;

import android.os.Bundle;
import android.view.View;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.sport.R;
import com.huachenjie.sport.databinding.ActivitySportTestListBinding;
import com.huachenjie.sport.page.mine.sport_test.test_list.SportTestListActivity;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(extras = 1, path = RoutePathConstants.Sport.d)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\n\u001a\u00020\u0003H\u0014J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/test_list/SportTestListActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/sport_test/test_list/SportTestListVM;", "", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "onResume", "h0", "initView", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class SportTestListActivity extends BaseVmActivity<SportTestListVM> {
    public static final void i0(SportTestListActivity sportTestListActivity, View view) {
        Intrinsics.checkNotNullParameter(sportTestListActivity, "this$0");
        sportTestListActivity.finish();
    }

    public static final void j0(SportTestListActivity sportTestListActivity, View view) {
        Intrinsics.checkNotNullParameter(sportTestListActivity, "this$0");
        Object objNavigation = ARouter.getInstance().build(RoutePathConstants.Sport.c).navigation();
        if (objNavigation instanceof DialogFragment) {
            ((DialogFragment) objNavigation).show(sportTestListActivity.getSupportFragmentManager(), "MINE_QR_CODE");
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_sport_test_list), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a);
    }

    public final void h0() {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataK = ((SportTestListVM) ((BaseVmActivity) this).f8507a).k();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        bindingTitleBean.setTitleName("体质测试");
        int i = R.color.color_333333;
        bindingTitleBean.setTitleTextColor(zn1.a(i));
        bindingTitleBean.setBackTintColor(Integer.valueOf(zn1.a(i)));
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.on8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SportTestListActivity.i0(this.f43787a, view);
            }
        });
        bindingTitleBean.setRightIconResId(R.drawable.icon_sport_test_mine_qrcode);
        bindingTitleBean.setShowRightIcon(true);
        bindingTitleBean.setRightIconClick(new View.OnClickListener() { // from class: com.zj.adlib.pn8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SportTestListActivity.j0(this.f44022a, view);
            }
        });
        Integer value = ((BaseVM) ((SportTestListVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        if (value == null) {
            iIntValue = 24;
        } else {
            Intrinsics.checkNotNullExpressionValue(value, "mState.statusBarHeight.value ?: 24");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        mutableLiveDataK.setValue(bindingTitleBean);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        h0();
        initView();
    }

    public final void initView() {
        ArrayList arrayList = new ArrayList();
        SportTestListFragment.Companion aVar = SportTestListFragment.INSTANCE;
        SportTestListFragment sportTestListFragmentA = aVar.a(1);
        SportTestListFragment sportTestListFragmentA2 = aVar.a(2);
        arrayList.add(sportTestListFragmentA);
        arrayList.add(sportTestListFragmentA2);
        TestVPAdapter testVPAdapter = new TestVPAdapter(arrayList, this);
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.sport.databinding.ActivitySportTestListBinding");
        ActivitySportTestListBinding activitySportTestListBinding = (ActivitySportTestListBinding) binding;
        activitySportTestListBinding.f36434a.setAdapter(testVPAdapter);
        activitySportTestListBinding.f13360a.setViewPager(activitySportTestListBinding.f36434a, new String[]{"未完成", "已结束"});
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ((SportTestListVM) ((BaseVmActivity) this).f8507a).m();
    }
}
