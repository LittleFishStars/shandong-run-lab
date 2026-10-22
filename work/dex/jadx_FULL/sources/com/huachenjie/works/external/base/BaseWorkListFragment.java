package com.huachenjie.works.external.base;

import androidx.annotation.CallSuper;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.databinding.WorksFragmentWorkListBinding;
import com.huachenjie.works.external.adapter.WorksAdapter;
import com.huachenjie.works.external.base.BaseWorkListFragment;
import com.huachenjie.works.external.base.BaseWorksListVM;
import com.zj.adlib.qk0;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0017J\b\u0010\u0017\u001a\u00020\u0013H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/works/external/base/BaseWorkListFragment;", "V", "Lcom/huachenjie/works/databinding/WorksFragmentWorkListBinding;", "VM", "Lcom/huachenjie/works/external/base/BaseWorksListVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "()V", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "enableRefresh", "", "getLayoutResID", "", "getVariables", "", "", "initAdapter", "Lcom/huachenjie/works/external/adapter/WorksAdapter;", "initData", "", "initLayoutManager", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "initView", "onRefreshList", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseWorkListFragment<V extends WorksFragmentWorkListBinding, VM extends BaseWorksListVM> extends BaseMVVMFragment<V, VM> {

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.gs0
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            BaseWorkListFragment.onRefreshListener$lambda$0(this.f41976a);
        }
    };

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37130a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37130a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37130a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37130a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ WorksFragmentWorkListBinding access$getMBinding(BaseWorkListFragment baseWorkListFragment) {
        return (WorksFragmentWorkListBinding) baseWorkListFragment.getMBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$2$lambda$1(BaseWorkListFragment baseWorkListFragment) {
        Intrinsics.checkNotNullParameter(baseWorkListFragment, "this$0");
        ((BaseWorksListVM) baseWorkListFragment.getMViewModel()).m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onRefreshListener$lambda$0(BaseWorkListFragment baseWorkListFragment) {
        Intrinsics.checkNotNullParameter(baseWorkListFragment, "this$0");
        baseWorkListFragment.onRefreshList();
        ((BaseWorksListVM) baseWorkListFragment.getMViewModel()).p();
    }

    public boolean enableRefresh() {
        return true;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_work_list;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.R), this.onRefreshListener)});
    }

    @NotNull
    public abstract WorksAdapter initAdapter();

    public void initData() {
        getMViewModel().p();
    }

    @NotNull
    public StaggeredGridLayoutManager initLayoutManager() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        staggeredGridLayoutManager.setGapStrategy(0);
        return staggeredGridLayoutManager;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    @CallSuper
    public void initView() {
        V mBinding = getMBinding();
        if (mBinding != null) {
            mBinding.f36968a.setLayoutManager(initLayoutManager());
            WorksAdapter worksAdapterInitAdapter = initAdapter();
            worksAdapterInitAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.hs0
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    BaseWorkListFragment.initView$lambda$2$lambda$1(this.f42190a);
                }
            });
            getMViewModel().i().setValue(worksAdapterInitAdapter);
            mBinding.f14357a.setEnabled(enableRefresh());
            StateLayout stateLayout = mBinding.f14358a;
            Intrinsics.checkNotNullExpressionValue(stateLayout, "stateLayout");
            StateLayout.showLoading$default(stateLayout, null, false, false, 7, null);
        }
        getMViewModel().l().observe(this, new a(new Function1<Boolean, Unit>(this) { // from class: com.huachenjie.works.external.base.BaseWorkListFragment.initView.2
            final /* synthetic */ BaseWorkListFragment<V, VM> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                WorksFragmentWorkListBinding worksFragmentWorkListBindingAccess$getMBinding;
                StateLayout stateLayout2;
                if (bool.booleanValue() || (worksFragmentWorkListBindingAccess$getMBinding = BaseWorkListFragment.access$getMBinding(this.this$0)) == null || (stateLayout2 = worksFragmentWorkListBindingAccess$getMBinding.f14358a) == null) {
                    return;
                }
                StateLayout.showContent$default(stateLayout2, null, 1, null);
            }
        }));
    }

    public void onRefreshList() {
    }
}
