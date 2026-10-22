package com.huachenjie.run.page;

import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.acse.ottn.activity.AcseHelpManager;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.SpanUtils;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunActivityMorePermissionBinding;
import com.huachenjie.run.page.MorePermissionActivity;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.lk0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0014¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/run/page/MorePermissionActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/run/databinding/RunActivityMorePermissionBinding;", "Lcom/huachenjie/run/page/MorePermissionVM;", "", "", "", "V", "getLayoutResID", "", "initView", "onResume", "<init>", "()V", "a", "run_release"}, k = 1, mv = {1, 8, 0})
public final class MorePermissionActivity extends BaseMVVMActivity<RunActivityMorePermissionBinding, MorePermissionVM> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/run/page/MorePermissionActivity$a;", "", "Landroid/view/View;", "view", "", "b", "a", "<init>", "(Lcom/huachenjie/run/page/MorePermissionActivity;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View view) {
            ARouter.getInstance().build(RoutePathConstants.Run.g).navigation();
        }

        public final void b(@Nullable View view) {
            AcseHelpManager.openWithOneButton(MorePermissionActivity.this, 110, null);
        }
    }

    public static final void e0(MorePermissionActivity morePermissionActivity, View view) {
        Intrinsics.checkNotNullParameter(morePermissionActivity, "this$0");
        morePermissionActivity.finish();
    }

    public static final void f0(final MorePermissionActivity morePermissionActivity, View view) {
        Intrinsics.checkNotNullParameter(morePermissionActivity, "this$0");
        ft1.s(morePermissionActivity, "提示", "辅助功能可以帮助您快速打开跑步的权限，以及优化运动轨迹。是否仍要关闭提示?", false, "关闭提示", "再试试", new View.OnClickListener() { // from class: com.zj.adlib.pr5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MorePermissionActivity.g0(this.f44049a, view2);
            }
        }, new View.OnClickListener() { // from class: com.zj.adlib.qr5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MorePermissionActivity.h0(view2);
            }
        });
    }

    public static final void g0(MorePermissionActivity morePermissionActivity, View view) {
        Intrinsics.checkNotNullParameter(morePermissionActivity, "this$0");
        AcseHelpManager.close_remind();
        fv5.b("已记录，我们将尽快支持您的手机型号");
        morePermissionActivity.finish();
    }

    public static final void h0(View view) {
    }

    public static final void i0(MorePermissionActivity morePermissionActivity, String str) {
        Intrinsics.checkNotNullParameter(morePermissionActivity, "this$0");
        morePermissionActivity.getMViewModel().j().setValue(Boolean.valueOf(str.equals("0")));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(lk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_activity_more_permission;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName("必要权限设置").setTitleTextColor(RunIndexRecordAdapter.K).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(RunIndexRecordAdapter.K)).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.rr5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MorePermissionActivity.e0(this.f44518a, view);
            }
        }));
        SpanUtils.c0(getMBinding().f11517b).a("如果无法一键开启，请点击:").a("不再提醒").t().x(RunIndexRecordAdapter.N, false, new View.OnClickListener() { // from class: com.zj.adlib.sr5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MorePermissionActivity.f0(this.f44758a, view);
            }
        }).p();
        getMBinding().f11517b.setTextColor(-9078407);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        AcseHelpManager.setOpenWithOneButtonColorState(this, new AcseHelpManager.OnCurrentStateCallBack() { // from class: com.zj.adlib.tr5
            @Override // com.acse.ottn.activity.AcseHelpManager.OnCurrentStateCallBack
            public final void onState(String str) {
                MorePermissionActivity.i0(this.f44992a, str);
            }
        });
    }
}
