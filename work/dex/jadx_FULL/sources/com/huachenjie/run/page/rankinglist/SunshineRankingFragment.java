package com.huachenjie.run.page.rankinglist;

import android.os.Bundle;
import android.view.View;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RankItemData;
import com.huachenjie.run.bean.SunshineRankingData;
import com.huachenjie.run.databinding.RunFootSunshineRankBinding;
import com.huachenjie.run.databinding.RunFragmentSunshineRankingBinding;
import com.huachenjie.run.databinding.RunHeadSunshineRankBinding;
import com.huachenjie.run.page.rankinglist.SunshineRankingFragment;
import com.huachenjie.run.page.rankinglist.dialog.RankingTipDialog;
import com.igexin.push.g.o;
import com.zj.adlib.ai9;
import com.zj.adlib.fv5;
import com.zj.adlib.i4a;
import com.zj.adlib.i62;
import com.zj.adlib.lk0;
import com.zj.adlib.y57;
import com.zj.adlib.zn1;
import java.util.ArrayList;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0010\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003234B\u0007¢\u0006\u0004\b/\u00100J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\u001a\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u001a\u001a\u00020\u000eJ\u0006\u0010\u001b\u001a\u00020\u000eJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0017\u0010\u001f\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b!\u0010 J\u0010\u0010\"\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010#\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020\u0007R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001c0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0017\u0010(\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010)\u001a\u0004\b,\u0010+\"\u0004\b-\u0010.¨\u00065"}, d2 = {"Lcom/huachenjie/run/page/rankinglist/SunshineRankingFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVMFragment;", "Lcom/huachenjie/run/page/rankinglist/SunshineRankingVM;", "Lcom/huachenjie/run/databinding/RunHeadSunshineRankBinding;", "initHeader", "Lcom/huachenjie/run/databinding/RunFootSunshineRankBinding;", "initFooter", "", "obsData", "Lcom/huachenjie/run/page/rankinglist/SunshineRankingActivityVM;", "getActivityState", "", "isOver", "checkScrollOffset", "", "type", "resetFilter", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "Landroid/view/View;", "view", "onViewCreated", "getScope", "getRankCycle", "", "getPlanCode", "code", "setScope", "(Ljava/lang/Integer;)V", "setRankCycle", "setPlanCode", "refreshData", "resetCode", "", "mTitles", "[Ljava/lang/String;", "tabMargin", "I", "getTabMargin", "()I", "getType", "setType", "(I)V", "<init>", "()V", "Companion", "a", "b", "c", "run_release"}, k = 1, mv = {1, 8, 0})
public final class SunshineRankingFragment extends BaseVMFragment<SunshineRankingVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String[] mTitles = {"男生榜", "女生榜"};
    private final int tabMargin = SizeUtils.b(20.0f);
    private int type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/huachenjie/run/page/rankinglist/SunshineRankingFragment$a;", "", "Landroid/view/View;", "view", "", "f", "e", "b", "c", "d", "a", "<init>", "(Lcom/huachenjie/run/page/rankinglist/SunshineRankingFragment;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            fv5.b("不能为自己点赞");
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).G(((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).B().getValue(), -1);
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).G(((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).C().getValue(), -2);
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).G(((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).D().getValue(), -3);
        }

        public final void e(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Integer value = ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).w().getValue();
            if (value != null && value.intValue() == 3) {
                return;
            }
            RankingTipDialog.INSTANCE.a().show(SunshineRankingFragment.this.getChildFragmentManager(), "RankingTipDialog");
        }

        public final void f(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.run.page.rankinglist.SunshineRankingFragment$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/run/page/rankinglist/SunshineRankingFragment$b;", "", "", "type", "Lcom/huachenjie/run/page/rankinglist/SunshineRankingFragment;", "a", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SunshineRankingFragment a(int type) {
            Bundle bundle = new Bundle();
            bundle.putInt("type", type);
            SunshineRankingFragment sunshineRankingFragment = new SunshineRankingFragment();
            sunshineRankingFragment.setArguments(bundle);
            return sunshineRankingFragment;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/run/page/rankinglist/SunshineRankingFragment$c;", "Lcom/huachenjie/common/binding_adapter/CommonBindingAdapter$OnScroll;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "a", "", "Z", "isOver", "<init>", "(Lcom/huachenjie/run/page/rankinglist/SunshineRankingFragment;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class c implements CommonBindingAdapter.OnScroll {

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        public boolean isOver;

        public c() {
        }

        @Override // com.huachenjie.common.binding_adapter.CommonBindingAdapter.OnScroll
        public void a(@NotNull RecyclerView recyclerView, int dx, int dy) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            this.isOver = SunshineRankingFragment.this.checkScrollOffset(this.isOver);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/run/page/rankinglist/SunshineRankingFragment$d", "Lcom/flyco/tablayout/listener/OnTabSelectListener;", "", "position", "", "b", "a", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class d implements OnTabSelectListener {
        public d() {
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void a(int position) {
            if (position == 0) {
                Integer value = ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).x().getValue();
                if (value != null && value.intValue() == 2) {
                    return;
                } else {
                    ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).x().setValue(2);
                }
            } else if (position == 1) {
                Integer value2 = ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).x().getValue();
                if (value2 != null && value2.intValue() == 1) {
                    return;
                } else {
                    ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).x().setValue(1);
                }
            }
            i4a.a("onTabReselect");
            SunshineRankingVM sunshineRankingVM = (SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState;
            Integer value3 = ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).x().getValue();
            if (value3 == null) {
                value3 = 1;
            }
            sunshineRankingVM.K(value3.intValue());
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void b(int position) {
            if (position == 0) {
                Integer value = ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).x().getValue();
                if (value != null && value.intValue() == 2) {
                    return;
                } else {
                    ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).x().setValue(2);
                }
            } else if (position == 1) {
                Integer value2 = ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).x().getValue();
                if (value2 != null && value2.intValue() == 1) {
                    return;
                } else {
                    ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).x().setValue(1);
                }
            }
            i4a.a("onTabSelect");
            SunshineRankingVM sunshineRankingVM = (SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState;
            Integer value3 = ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).x().getValue();
            if (value3 == null) {
                value3 = 1;
            }
            sunshineRankingVM.K(value3.intValue());
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class e implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35902a;

        public e(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35902a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35902a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35902a.invoke(obj);
        }
    }

    private final SunshineRankingActivityVM getActivityState() {
        return (SunshineRankingActivityVM) getActivityScopeViewModel(SunshineRankingActivityVM.class);
    }

    private final RunFootSunshineRankBinding initFooter() {
        RunFootSunshineRankBinding runFootSunshineRankBinding = (RunFootSunshineRankBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.run_foot_sunshine_rank, null, false);
        runFootSunshineRankBinding.setLifecycleOwner(this);
        runFootSunshineRankBinding.setVariable(lk0.p0, ((BaseVMFragment) this).mState);
        runFootSunshineRankBinding.getRoot().setTag("RankListFoot");
        runFootSunshineRankBinding.executePendingBindings();
        Intrinsics.checkNotNullExpressionValue(runFootSunshineRankBinding, "footBinding");
        return runFootSunshineRankBinding;
    }

    private final RunHeadSunshineRankBinding initHeader() {
        RunHeadSunshineRankBinding runHeadSunshineRankBinding = (RunHeadSunshineRankBinding) DataBindingUtil.inflate(getLayoutInflater(), R.layout.run_head_sunshine_rank, null, false);
        runHeadSunshineRankBinding.setLifecycleOwner(this);
        runHeadSunshineRankBinding.setVariable(lk0.p0, ((BaseVMFragment) this).mState);
        runHeadSunshineRankBinding.setVariable(lk0.k, new a());
        runHeadSunshineRankBinding.getRoot().setTag("RankListHead");
        runHeadSunshineRankBinding.f11881a.setTabData(this.mTitles);
        if (ai9.e().getSex() == 1) {
            runHeadSunshineRankBinding.f11881a.setCurrentTab(1);
        } else {
            runHeadSunshineRankBinding.f11881a.setCurrentTab(0);
        }
        runHeadSunshineRankBinding.f11881a.setOnTabSelectListener(new d());
        runHeadSunshineRankBinding.executePendingBindings();
        return runHeadSunshineRankBinding;
    }

    private final void obsData() {
        ((SunshineRankingVM) ((BaseVMFragment) this).mState).v().observe(getViewLifecycleOwner(), new e(new Function1<SunshineRankingData, Unit>() { // from class: com.huachenjie.run.page.rankinglist.SunshineRankingFragment.obsData.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SunshineRankingData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SunshineRankingData sunshineRankingData) {
                ArrayList arrayList = new ArrayList();
                ArrayList<RankItemData> rankList = sunshineRankingData.getRankList();
                if (rankList != null && rankList.size() > 3) {
                    try {
                        arrayList.addAll(rankList.subList(3, rankList.size()));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                SunshineRankingAdapter value = ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).l().getValue();
                if (value != null) {
                    value.e(((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).x().getValue(), ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).w().getValue(), arrayList);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$lambda$2(SunshineRankingFragment sunshineRankingFragment, SunshineRankingAdapter sunshineRankingAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(sunshineRankingFragment, "this$0");
        Intrinsics.checkNotNullParameter(sunshineRankingAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.ll_like_num) {
            ((SunshineRankingVM) ((BaseVMFragment) sunshineRankingFragment).mState).G(sunshineRankingAdapter.getData().get(i), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetFilter(int type) {
        if (type == 1) {
            setScope(50);
            setRankCycle(30);
            setPlanCode("");
        } else if (type == 2) {
            setScope(50);
            setRankCycle(30);
            setPlanCode("");
        } else {
            if (type != 3) {
                return;
            }
            setScope(20);
            setRankCycle(30);
            setPlanCode("");
        }
    }

    public final void checkScrollOffset() {
        checkScrollOffset(false);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.run_fragment_sunshine_ranking), Integer.valueOf(lk0.p0), ((BaseVMFragment) this).mState).a(Integer.valueOf(lk0.S), new c());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…lerScrollStateListener())");
        return i62VarA;
    }

    @NotNull
    public final String getPlanCode() {
        MutableLiveData<String> mutableLiveDataY;
        SunshineRankingVM sunshineRankingVM = (SunshineRankingVM) ((BaseVMFragment) this).mState;
        String value = (sunshineRankingVM == null || (mutableLiveDataY = sunshineRankingVM.y()) == null) ? null : mutableLiveDataY.getValue();
        return value == null ? "" : value;
    }

    public final int getRankCycle() {
        MutableLiveData<Integer> mutableLiveDataA;
        SunshineRankingVM sunshineRankingVM = (SunshineRankingVM) ((BaseVMFragment) this).mState;
        Integer value = (sunshineRankingVM == null || (mutableLiveDataA = sunshineRankingVM.A()) == null) ? null : mutableLiveDataA.getValue();
        if (value == null) {
            return 0;
        }
        return value.intValue();
    }

    public final int getScope() {
        MutableLiveData<Integer> mutableLiveDataZ;
        SunshineRankingVM sunshineRankingVM = (SunshineRankingVM) ((BaseVMFragment) this).mState;
        Integer value = (sunshineRankingVM == null || (mutableLiveDataZ = sunshineRankingVM.z()) == null) ? null : mutableLiveDataZ.getValue();
        if (value == null) {
            return 0;
        }
        return value.intValue();
    }

    public final int getTabMargin() {
        return this.tabMargin;
    }

    public final int getType() {
        return this.type;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void init(@Nullable Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.type = arguments.getInt("type");
            ((SunshineRankingVM) ((BaseVMFragment) this).mState).w().setValue(Integer.valueOf(this.type));
        }
        i4a.a("fragment" + this.type + " --> init");
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initViewModel() {
        ((SunshineRankingVM) ((BaseVMFragment) this).mState).w().observe(this, new e(new Function1<Integer, Unit>() { // from class: com.huachenjie.run.page.rankinglist.SunshineRankingFragment.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                SunshineRankingFragment sunshineRankingFragment = SunshineRankingFragment.this;
                Intrinsics.checkNotNullExpressionValue(num, o.f);
                sunshineRankingFragment.resetFilter(num.intValue());
            }
        }));
        ((SunshineRankingVM) ((BaseVMFragment) this).mState).p().observe(this, new e(new Function1<RankItemData, Unit>() { // from class: com.huachenjie.run.page.rankinglist.SunshineRankingFragment.initViewModel.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((RankItemData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(RankItemData rankItemData) {
                Integer value;
                Integer value2 = ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).q().getValue();
                if (value2 != null && value2.intValue() == -1) {
                    RankItemData value3 = ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).B().getValue();
                    if (value3 != null) {
                        SunshineRankingFragment sunshineRankingFragment = SunshineRankingFragment.this;
                        ((SunshineRankingVM) ((BaseVMFragment) sunshineRankingFragment).mState).B().setValue(((SunshineRankingVM) ((BaseVMFragment) sunshineRankingFragment).mState).j(value3));
                        return;
                    }
                    return;
                }
                if (value2 != null && value2.intValue() == -2) {
                    RankItemData value4 = ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).C().getValue();
                    if (value4 != null) {
                        SunshineRankingFragment sunshineRankingFragment2 = SunshineRankingFragment.this;
                        ((SunshineRankingVM) ((BaseVMFragment) sunshineRankingFragment2).mState).C().setValue(((SunshineRankingVM) ((BaseVMFragment) sunshineRankingFragment2).mState).j(value4));
                        return;
                    }
                    return;
                }
                if (value2 != null && value2.intValue() == -3) {
                    RankItemData value5 = ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).D().getValue();
                    if (value5 != null) {
                        SunshineRankingFragment sunshineRankingFragment3 = SunshineRankingFragment.this;
                        ((SunshineRankingVM) ((BaseVMFragment) sunshineRankingFragment3).mState).D().setValue(((SunshineRankingVM) ((BaseVMFragment) sunshineRankingFragment3).mState).j(value5));
                        return;
                    }
                    return;
                }
                SunshineRankingAdapter value6 = ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).l().getValue();
                if (value6 == null || (value = ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).q().getValue()) == null) {
                    return;
                }
                int iIntValue = value.intValue();
                value6.getData().set(iIntValue, ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).j(value6.getData().get(iIntValue)));
                value6.notifyItemChanged(iIntValue + value6.getHeaderLayoutCount());
            }
        }));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        i4a.a("fragment" + this.type + " --> onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.run.databinding.RunFragmentSunshineRankingBinding");
        ((RunFragmentSunshineRankingBinding) binding).f11864a.onRefresh(new Function2<StateLayout, Object, Unit>() { // from class: com.huachenjie.run.page.rankinglist.SunshineRankingFragment.onViewCreated.1
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((StateLayout) obj, obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull StateLayout stateLayout, @Nullable Object obj) {
                Intrinsics.checkNotNullParameter(stateLayout, "$this$onRefresh");
                SunshineRankingVM sunshineRankingVM = (SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState;
                Integer value = ((SunshineRankingVM) ((BaseVMFragment) SunshineRankingFragment.this).mState).x().getValue();
                if (value == null) {
                    value = 1;
                }
                sunshineRankingVM.K(value.intValue());
            }
        });
        final SunshineRankingAdapter value = ((SunshineRankingVM) ((BaseVMFragment) this).mState).l().getValue();
        if (value != null) {
            RunHeadSunshineRankBinding runHeadSunshineRankBindingInitHeader = initHeader();
            Intrinsics.checkNotNull(runHeadSunshineRankBindingInitHeader);
            View root = runHeadSunshineRankBindingInitHeader.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "initHeader()!!.root");
            BaseQuickAdapter.addHeaderView$default(value, root, 0, 0, 6, null);
            View root2 = initFooter().getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "initFooter().root");
            BaseQuickAdapter.addFooterView$default(value, root2, 0, 0, 6, null);
            value.addChildClickViewIds(R.id.ll_like_num);
            y57.b(value, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.nv8
                @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                    SunshineRankingFragment.onViewCreated$lambda$3$lambda$2(this.f18525a, value, baseQuickAdapter, view2, i);
                }
            }, 1, null);
        }
        obsData();
        i4a.a("onViewCreated");
        ((SunshineRankingVM) ((BaseVMFragment) this).mState).K(ai9.e().getSex());
    }

    public final void refreshData() {
        Integer value;
        MutableLiveData<Integer> mutableLiveDataX;
        i4a.a("refreshData");
        Q q = ((BaseVMFragment) this).mState;
        SunshineRankingVM sunshineRankingVM = (SunshineRankingVM) q;
        if (sunshineRankingVM != null) {
            SunshineRankingVM sunshineRankingVM2 = (SunshineRankingVM) q;
            if (sunshineRankingVM2 == null || (mutableLiveDataX = sunshineRankingVM2.x()) == null || (value = mutableLiveDataX.getValue()) == null) {
                value = 1;
            }
            sunshineRankingVM.K(value.intValue());
        }
    }

    public final void resetCode() {
        resetFilter(this.type);
        refreshData();
    }

    public final void setPlanCode(@Nullable String code) {
        if (code != null) {
            SunshineRankingVM sunshineRankingVM = (SunshineRankingVM) ((BaseVMFragment) this).mState;
            MutableLiveData<String> mutableLiveDataY = sunshineRankingVM != null ? sunshineRankingVM.y() : null;
            if (mutableLiveDataY == null) {
                return;
            }
            mutableLiveDataY.setValue(code);
        }
    }

    public final void setRankCycle(@Nullable Integer code) {
        if (this.type != 2 || code == null) {
            return;
        }
        int iIntValue = code.intValue();
        SunshineRankingVM sunshineRankingVM = (SunshineRankingVM) ((BaseVMFragment) this).mState;
        MutableLiveData<Integer> mutableLiveDataA = sunshineRankingVM != null ? sunshineRankingVM.A() : null;
        if (mutableLiveDataA == null) {
            return;
        }
        mutableLiveDataA.setValue(Integer.valueOf(iIntValue));
    }

    public final void setScope(@Nullable Integer code) {
        if (code != null) {
            int iIntValue = code.intValue();
            SunshineRankingVM sunshineRankingVM = (SunshineRankingVM) ((BaseVMFragment) this).mState;
            MutableLiveData<Integer> mutableLiveDataZ = sunshineRankingVM != null ? sunshineRankingVM.z() : null;
            if (mutableLiveDataZ == null) {
                return;
            }
            mutableLiveDataZ.setValue(Integer.valueOf(iIntValue));
        }
    }

    public final void setType(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkScrollOffset(boolean isOver) {
        MutableLiveData<Integer> mutableLiveDataK;
        MutableLiveData<Integer> mutableLiveDataK2;
        if (getBinding() == null) {
            return false;
        }
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.run.databinding.RunFragmentSunshineRankingBinding");
        RecyclerView recyclerView = ((RunFragmentSunshineRankingBinding) binding).f35591a;
        if (recyclerView == null) {
            return isOver;
        }
        int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        int i = this.tabMargin;
        if (iComputeVerticalScrollOffset <= i) {
            float f = iComputeVerticalScrollOffset / i;
            SunshineRankingActivityVM activityState = getActivityState();
            if (activityState != null && (mutableLiveDataK2 = activityState.k()) != null) {
                mutableLiveDataK2.setValue(Integer.valueOf(zn1.g(zn1.a(R.color.color_7675ca), f)));
            }
            return false;
        }
        if (isOver) {
            return isOver;
        }
        SunshineRankingActivityVM activityState2 = getActivityState();
        if (activityState2 != null && (mutableLiveDataK = activityState2.k()) != null) {
            mutableLiveDataK.setValue(Integer.valueOf(zn1.a(R.color.color_7675ca)));
        }
        return true;
    }
}
