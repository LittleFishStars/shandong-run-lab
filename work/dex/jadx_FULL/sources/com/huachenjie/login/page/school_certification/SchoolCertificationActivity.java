package com.huachenjie.login.page.school_certification;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.gyf.immersionbar.e;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.login.R;
import com.huachenjie.login.databinding.LoginActivitySchoolCertificationBinding;
import com.huachenjie.login.page.school_certification.SchoolCertificationActivity;
import com.zj.adlib.y57;
import com.zj.adlib.zk0;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/login/page/school_certification/SchoolCertificationActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/login/databinding/LoginActivitySchoolCertificationBinding;", "Lcom/huachenjie/login/page/school_certification/SchoolCertificationVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "g0", "f0", "c0", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class SchoolCertificationActivity extends BaseMVVMActivity<LoginActivitySchoolCertificationBinding, SchoolCertificationVM> {
    public static final void d0(SchoolCertificationAdapter schoolCertificationAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(schoolCertificationAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        ARouter.getInstance().build(RoutePathConstants.Login.b).withString("url", schoolCertificationAdapter.getData().get(i).getLoginUrl()).navigation();
    }

    public static final void e0(SchoolCertificationActivity schoolCertificationActivity) {
        Intrinsics.checkNotNullParameter(schoolCertificationActivity, "this$0");
        schoolCertificationActivity.getMViewModel().l();
    }

    public static final void h0(SchoolCertificationActivity schoolCertificationActivity, View view) {
        Intrinsics.checkNotNullParameter(schoolCertificationActivity, "this$0");
        schoolCertificationActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(zk0.p0), getMViewModel()));
    }

    public final void c0() {
        final SchoolCertificationAdapter schoolCertificationAdapter = new SchoolCertificationAdapter();
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_empty_common, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_empty);
        if (textView != null) {
            textView.setText("暂无开通的学校");
        }
        Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
        schoolCertificationAdapter.g(viewInflate);
        y57.d(schoolCertificationAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.zv7
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SchoolCertificationActivity.d0(schoolCertificationAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        schoolCertificationAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.aw7
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                SchoolCertificationActivity.e0(this.f40629a);
            }
        });
        getMViewModel().j().setValue(schoolCertificationAdapter);
    }

    public final void f0() {
        e.p3(this).M2(0).T2(true).u1(R.color.black).G1(false).g0(true).a1();
    }

    public final void g0() {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        if (value == null) {
            iIntValue = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(value, "mViewModel.uiLiveData.statusBarHeight.value ?: 0");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        bindingTitleBean.setTitleName("学校认证");
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.black_main));
        bindingTitleBean.setBackground(-1);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.bw7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SchoolCertificationActivity.h0(this.f40852a, view);
            }
        });
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setShowDivider(true);
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.login_activity_school_certification;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().n();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        f0();
        g0();
        c0();
    }
}
