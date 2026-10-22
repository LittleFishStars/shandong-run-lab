package com.huachenjie.run.page.activities_run;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunActivityActivityRunListBinding;
import com.huachenjie.run.page.activities_run.ActivityRunListActivity;
import com.zj.adlib.lk0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Route(extras = 1, path = RoutePathConstants.Run.k)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00030\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/run/page/activities_run/ActivityRunListActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/run/databinding/RunActivityActivityRunListBinding;", "Lcom/huachenjie/run/page/activities_run/ActivityRunListVM;", "", "getLayoutResID", "", "V", "", "initView", "", "", "a", "[Ljava/lang/String;", "titles", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class ActivityRunListActivity extends BaseMVVMActivity<RunActivityActivityRunListBinding, ActivityRunListVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final String[] titles = {"本学期", "历史数据"};

    public static final void b0(ActivityRunListActivity activityRunListActivity, View view) {
        Intrinsics.checkNotNullParameter(activityRunListActivity, "this$0");
        activityRunListActivity.onBackPressed();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, ActivityRunListVM> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_activity_activity_run_list;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName("活动跑").setTitleTextColor(-13877680).setBackIconResId(R.drawable.ic_back_black).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.bu
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivityRunListActivity.b0(this.f40838a, view);
            }
        }));
        getMBinding().f35444a.setOffscreenPageLimit(-1);
        getMBinding().f35444a.setAdapter(new FragmentStateAdapter() { // from class: com.huachenjie.run.page.activities_run.ActivityRunListActivity.initView.2
            {
                super(ActivityRunListActivity.this);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter
            @NotNull
            public Fragment createFragment(int position) {
                return ActivityRunListFragment.INSTANCE.a(position == 0);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return ActivityRunListActivity.this.titles.length;
            }
        });
        getMBinding().f11413a.setViewPager(getMBinding().f35444a, this.titles);
    }
}
