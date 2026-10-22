package com.huachenjie.sport.page.mine.sport_test.test_list;

import android.os.Bundle;
import android.view.View;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.SportTestItemBean;
import com.huachenjie.sport.bean.SportTestListBean;
import com.huachenjie.sport.databinding.FragmentSportTestListBinding;
import com.huachenjie.sport.page.mine.sport_test.test_list.SportTestListFragment;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/test_list/SportTestListFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVMFragment;", "Lcom/huachenjie/sport/page/mine/sport_test/test_list/SportTestListVM;", "", "observerData", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "Landroid/view/View;", "view", "onViewCreated", "Lcom/huachenjie/sport/page/mine/sport_test/test_list/SportTestListAdapter;", "adapter", "Lcom/huachenjie/sport/page/mine/sport_test/test_list/SportTestListAdapter;", "getAdapter", "()Lcom/huachenjie/sport/page/mine/sport_test/test_list/SportTestListAdapter;", "setAdapter", "(Lcom/huachenjie/sport/page/mine/sport_test/test_list/SportTestListAdapter;)V", "<init>", "()V", "Companion", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class SportTestListFragment extends BaseVMFragment<SportTestListVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private SportTestListAdapter adapter;

    /* JADX INFO: renamed from: com.huachenjie.sport.page.mine.sport_test.test_list.SportTestListFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/test_list/SportTestListFragment$a;", "", "", "type", "Lcom/huachenjie/sport/page/mine/sport_test/test_list/SportTestListFragment;", "a", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SportTestListFragment a(int type) {
            Bundle bundle = new Bundle();
            bundle.putInt("type", type);
            SportTestListFragment sportTestListFragment = new SportTestListFragment();
            sportTestListFragment.setArguments(bundle);
            return sportTestListFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36734a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36734a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36734a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36734a.invoke(obj);
        }
    }

    private final void observerData() {
        ((SportTestListVM) ((BaseVMFragment) this).mState).i().observe(getViewLifecycleOwner(), new b(new Function1<SportTestListBean, Unit>() { // from class: com.huachenjie.sport.page.mine.sport_test.test_list.SportTestListFragment.observerData.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SportTestListBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SportTestListBean sportTestListBean) {
                Bundle arguments = SportTestListFragment.this.getArguments();
                int i = arguments != null ? arguments.getInt("type") : 1;
                SportTestListAdapter adapter = SportTestListFragment.this.getAdapter();
                if (adapter != null) {
                    adapter.setList(i == 1 ? sportTestListBean.getUndoneTests() : sportTestListBean.getCompletedTests());
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        List data = baseQuickAdapter.getData();
        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.collections.List<com.huachenjie.sport.bean.SportTestItemBean>");
        ARouter.getInstance().build(RoutePathConstants.Sport.e).withString("code", ((SportTestItemBean) data.get(i)).getFitnessTestConfigCode()).navigation();
    }

    @Nullable
    public final SportTestListAdapter getAdapter() {
        return this.adapter;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    @NotNull
    public i62 getDataBindingConfig() {
        ((BaseVMFragment) this).mState = (Q) getActivityScopeViewModel(SportTestListVM.class);
        i62 i62Var = new i62(Integer.valueOf(R.layout.fragment_sport_test_list), Integer.valueOf(ok0.p0), ((BaseVMFragment) this).mState);
        Integer numValueOf = Integer.valueOf(ok0.o0);
        Bundle arguments = getArguments();
        i62 i62VarA = i62Var.a(numValueOf, Integer.valueOf(arguments != null ? arguments.getInt("type") : 1));
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…nts?.getInt(\"type\") ?: 1)");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void init(@Nullable Bundle savedInstanceState) {
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initViewModel() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() == null) {
            return;
        }
        Bundle arguments = getArguments();
        this.adapter = new SportTestListAdapter(arguments != null ? arguments.getInt("type") : 1);
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.sport.databinding.FragmentSportTestListBinding");
        ((FragmentSportTestListBinding) binding).f36486a.setAdapter(this.adapter);
        SportTestListAdapter sportTestListAdapter = this.adapter;
        if (sportTestListAdapter != null) {
            sportTestListAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.qn8
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                    SportTestListFragment.onViewCreated$lambda$0(baseQuickAdapter, view2, i);
                }
            });
        }
        ViewDataBinding binding2 = getBinding();
        Intrinsics.checkNotNull(binding2, "null cannot be cast to non-null type com.huachenjie.sport.databinding.FragmentSportTestListBinding");
        ((FragmentSportTestListBinding) binding2).f13514a.onRefresh(new Function2<StateLayout, Object, Unit>() { // from class: com.huachenjie.sport.page.mine.sport_test.test_list.SportTestListFragment.onViewCreated.2
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((StateLayout) obj, obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull StateLayout stateLayout, @Nullable Object obj) {
                Intrinsics.checkNotNullParameter(stateLayout, "$this$onRefresh");
                ((SportTestListVM) ((BaseVMFragment) SportTestListFragment.this).mState).m();
            }
        });
        observerData();
    }

    public final void setAdapter(@Nullable SportTestListAdapter sportTestListAdapter) {
        this.adapter = sportTestListAdapter;
    }
}
