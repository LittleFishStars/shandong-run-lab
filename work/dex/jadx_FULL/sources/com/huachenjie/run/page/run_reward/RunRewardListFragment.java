package com.huachenjie.run.page.run_reward;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunRewardBean;
import com.huachenjie.run.databinding.RunRunFragmentRunRewardListBinding;
import com.huachenjie.run.page.run_reward.RunRewardListFragment;
import com.zj.adlib.lk0;
import com.zj.adlib.y57;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001d\u001eB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001b\u0010\u0019\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/run/page/run_reward/RunRewardListFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/run/databinding/RunRunFragmentRunRewardListBinding;", "Lcom/huachenjie/run/page/run_reward/RunRewardListVM;", "", "", "getVariables", "getLayoutResID", "", "isAdd2ViewPager2", "", "initView", "lazyLoadData", "", "semesterCode$delegate", "Lkotlin/Lazy;", "getSemesterCode", "()Ljava/lang/String;", "semesterCode", "runPlanCode$delegate", "getRunPlanCode", "runPlanCode", "type$delegate", "getType", "()I", "type", "<init>", "()V", "Companion", "a", "b", "run_release"}, k = 1, mv = {1, 8, 0})
public final class RunRewardListFragment extends BaseMVVMFragment<RunRunFragmentRunRewardListBinding, RunRewardListVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_RUN_PLAN_CODE = "runPlanCode";

    @NotNull
    private static final String KEY_SEMESTER_CODE = "semesterCode";

    @NotNull
    private static final String KEY_TYPE = "type";

    /* JADX INFO: renamed from: semesterCode$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy semesterCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.run.page.run_reward.RunRewardListFragment$semesterCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("semesterCode")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: runPlanCode$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy runPlanCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.run.page.run_reward.RunRewardListFragment$runPlanCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("runPlanCode")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: type$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy type = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.run.page.run_reward.RunRewardListFragment$type$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m692invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("type") : 0);
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.run.page.run_reward.RunRewardListFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/run/page/run_reward/RunRewardListFragment$a;", "", "", "semesterCode", "runPlanCode", "", "type", "Lcom/huachenjie/run/page/run_reward/RunRewardListFragment;", "a", "KEY_RUN_PLAN_CODE", "Ljava/lang/String;", "KEY_SEMESTER_CODE", "KEY_TYPE", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RunRewardListFragment a(@NotNull String semesterCode, @NotNull String runPlanCode, int type) {
            Intrinsics.checkNotNullParameter(semesterCode, "semesterCode");
            Intrinsics.checkNotNullParameter(runPlanCode, "runPlanCode");
            RunRewardListFragment runRewardListFragment = new RunRewardListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("semesterCode", semesterCode);
            bundle.putString("runPlanCode", runPlanCode);
            bundle.putInt("type", type);
            runRewardListFragment.setArguments(bundle);
            return runRewardListFragment;
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002R\u0014\u0010\u0017\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/run/page/run_reward/RunRewardListFragment$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "onDraw", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "getItemOffsets", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "adapter", "", "position", "", "a", "K", "I", "dividerHeight", "L", "horizontalPadding", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nRunRewardListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunRewardListFragment.kt\ncom/huachenjie/run/page/run_reward/RunRewardListFragment$RunRewardDividerDecoration\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,134:1\n470#2:135\n*S KotlinDebug\n*F\n+ 1 RunRewardListFragment.kt\ncom/huachenjie/run/page/run_reward/RunRewardListFragment$RunRewardDividerDecoration\n*L\n99#1:135\n*E\n"})
    public static final class b extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: K, reason: from kotlin metadata */
        public final int dividerHeight = SizeUtils.b(1.0f);

        /* JADX INFO: renamed from: L, reason: from kotlin metadata */
        public final int horizontalPadding = SizeUtils.b(16.0f);

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public final Paint paint;

        public b() {
            Paint paint = new Paint(1);
            paint.setColor(Color.parseColor("#E8E8E8"));
            paint.setStyle(Paint.Style.FILL);
            this.paint = paint;
        }

        public final boolean a(BaseQuickAdapter<?, ?> adapter, int position) {
            int headerLayoutCount;
            return position != -1 && (headerLayoutCount = position - adapter.getHeaderLayoutCount()) >= 0 && headerLayoutCount < CollectionsKt.getLastIndex(adapter.getData());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            RecyclerView.Adapter adapter = parent.getAdapter();
            BaseQuickAdapter<?, ?> baseQuickAdapter = adapter instanceof BaseQuickAdapter ? (BaseQuickAdapter) adapter : null;
            if (baseQuickAdapter != null && a(baseQuickAdapter, parent.getChildAdapterPosition(view))) {
                outRect.bottom = this.dividerHeight;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(@NotNull Canvas c, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(c, "c");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            RecyclerView.Adapter adapter = parent.getAdapter();
            BaseQuickAdapter<?, ?> baseQuickAdapter = adapter instanceof BaseQuickAdapter ? (BaseQuickAdapter) adapter : null;
            if (baseQuickAdapter == null) {
                return;
            }
            float paddingLeft = parent.getPaddingLeft() + this.horizontalPadding;
            float width = (parent.getWidth() - parent.getPaddingRight()) - this.horizontalPadding;
            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = parent.getChildAt(i);
                if (a(baseQuickAdapter, parent.getChildAdapterPosition(childAt))) {
                    float bottom = childAt.getBottom();
                    c.drawRect(paddingLeft, bottom, width, bottom + this.dividerHeight, this.paint);
                }
            }
        }
    }

    private final String getRunPlanCode() {
        return (String) this.runPlanCode.getValue();
    }

    private final String getSemesterCode() {
        return (String) this.semesterCode.getValue();
    }

    private final int getType() {
        return ((Number) this.type.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$1(RunRewardListAdapter runRewardListAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(runRewardListAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        RunRewardBean runRewardBean = runRewardListAdapter.getData().get(i);
        if (view.getId() == R.id.bt_remark_look && Intrinsics.areEqual(runRewardBean.getShowLookMore(), Boolean.TRUE)) {
            runRewardBean.setExpanded(!runRewardBean.getExpanded());
            runRewardListAdapter.notifyItemChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$2(RunRewardListFragment runRewardListFragment) {
        Intrinsics.checkNotNullParameter(runRewardListFragment, "this$0");
        RunRewardListVM mViewModel = runRewardListFragment.getMViewModel();
        String semesterCode = runRewardListFragment.getSemesterCode();
        Intrinsics.checkNotNullExpressionValue(semesterCode, "semesterCode");
        String runPlanCode = runRewardListFragment.getRunPlanCode();
        Intrinsics.checkNotNullExpressionValue(runPlanCode, "runPlanCode");
        mViewModel.l(semesterCode, runPlanCode, runRewardListFragment.getType());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_run_fragment_run_reward_list;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, RunRewardListVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        RunRunFragmentRunRewardListBinding mBinding = getMBinding();
        View root = mBinding != null ? mBinding.getRoot() : null;
        Intrinsics.checkNotNull(root, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView) root).addItemDecoration(new b());
        MutableLiveData<RunRewardListAdapter> mutableLiveDataK = getMViewModel().k();
        final RunRewardListAdapter runRewardListAdapter = new RunRewardListAdapter();
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_empty_work, (ViewGroup) null);
        viewInflate.setPadding(0, SizeUtils.b(80.0f), 0, 0);
        ((TextView) viewInflate.findViewById(R.id.tv_empty)).setText("空空如也…");
        Intrinsics.checkNotNullExpressionValue(viewInflate, "layoutInflater.inflate(R…t = \"空空如也…\"\n            }");
        runRewardListAdapter.setEmptyView(viewInflate);
        runRewardListAdapter.addChildClickViewIds(R.id.bt_remark_look);
        y57.b(runRewardListAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.pm7
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RunRewardListFragment.initView$lambda$3$lambda$1(runRewardListAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        runRewardListAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.qm7
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                RunRewardListFragment.initView$lambda$3$lambda$2(this.f44245a);
            }
        });
        mutableLiveDataK.setValue(runRewardListAdapter);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public boolean isAdd2ViewPager2() {
        return true;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void lazyLoadData() {
        RunRewardListVM mViewModel = getMViewModel();
        String semesterCode = getSemesterCode();
        Intrinsics.checkNotNullExpressionValue(semesterCode, "semesterCode");
        String runPlanCode = getRunPlanCode();
        Intrinsics.checkNotNullExpressionValue(runPlanCode, "runPlanCode");
        mViewModel.l(semesterCode, runPlanCode, getType());
    }
}
