package com.huachenjie.run.page.activities_run;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.ActivityRunBean;
import com.huachenjie.run.databinding.RunActivityActivityRunListBinding;
import com.huachenjie.run.page.activities_run.ActivityRunListFragment;
import com.zj.adlib.lk0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\nH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016R\u001b\u0010\u0014\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/run/page/activities_run/ActivityRunListFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/run/databinding/RunActivityActivityRunListBinding;", "Lcom/huachenjie/run/page/activities_run/ActivityRunListFragmentVM;", "Lcom/huachenjie/run/bean/ActivityRunBean;", "item", "", "goDetail", "", "getLayoutResID", "", "getVariables", "initView", "", "isAdd2ViewPager2", "lazyLoadData", "currentSemester$delegate", "Lkotlin/Lazy;", "getCurrentSemester", "()Z", "currentSemester", "<init>", "()V", "Companion", "a", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nActivityRunListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityRunListFragment.kt\ncom/huachenjie/run/page/activities_run/ActivityRunListFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,62:1\n1#2:63\n*E\n"})
public final class ActivityRunListFragment extends BaseMVVMFragment<RunActivityActivityRunListBinding, ActivityRunListFragmentVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_CURRENT_SEMESTER = "current_semester";

    /* JADX INFO: renamed from: currentSemester$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy currentSemester = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.run.page.activities_run.ActivityRunListFragment$currentSemester$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m634invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean("current_semester") : false);
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.run.page.activities_run.ActivityRunListFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/run/page/activities_run/ActivityRunListFragment$a;", "", "", "currentSemester", "Lcom/huachenjie/run/page/activities_run/ActivityRunListFragment;", "a", "", "KEY_CURRENT_SEMESTER", "Ljava/lang/String;", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ActivityRunListFragment a(boolean currentSemester) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(ActivityRunListFragment.KEY_CURRENT_SEMESTER, currentSemester);
            ActivityRunListFragment activityRunListFragment = new ActivityRunListFragment();
            activityRunListFragment.setArguments(bundle);
            return activityRunListFragment;
        }
    }

    private final boolean getCurrentSemester() {
        return ((Boolean) this.currentSemester.getValue()).booleanValue();
    }

    private final void goDetail(ActivityRunBean item) {
        Context context;
        if (item.getActivityStatus() == 1 && (context = getContext()) != null) {
            DetailActivity.INSTANCE.a(context, item.getSunRunActivityCode(), item.getRunPlanCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1$lambda$0(ActivityRunListFragment activityRunListFragment, ActivityRunListAdapter activityRunListAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(activityRunListFragment, "this$0");
        Intrinsics.checkNotNullParameter(activityRunListAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        activityRunListFragment.goDetail(activityRunListAdapter.getItem(i));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_fragment_activity_run_list;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, ActivityRunListFragmentVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        final ActivityRunListAdapter activityRunListAdapter = new ActivityRunListAdapter();
        activityRunListAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.cu
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ActivityRunListFragment.initView$lambda$1$lambda$0(this.f15892a, activityRunListAdapter, baseQuickAdapter, view, i);
            }
        });
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_common_empty, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "layoutInflater.inflate(R…ayout_common_empty, null)");
        activityRunListAdapter.setEmptyView(viewInflate);
        getMViewModel().i().setValue(activityRunListAdapter);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public boolean isAdd2ViewPager2() {
        return true;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void lazyLoadData() {
        super.lazyLoadData();
        getMViewModel().j(getCurrentSemester());
    }
}
