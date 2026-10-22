package com.huachenjie.social_contact.page.dormitory.replenish_energy;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.adapter.ReplenishEnergyListAdapter;
import com.huachenjie.social_contact.bean.DrinkDetailBean;
import com.huachenjie.social_contact.databinding.FragmentReplenishEnergyListBinding;
import com.huachenjie.social_contact.page.dormitory.replenish_energy.ReplenishEnergyListFragment;
import com.zj.adlib.kq5;
import com.zj.adlib.nk0;
import com.zj.adlib.y57;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016R\u001b\u0010\u0013\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/social_contact/page/dormitory/replenish_energy/ReplenishEnergyListFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/social_contact/databinding/FragmentReplenishEnergyListBinding;", "Lcom/huachenjie/social_contact/page/dormitory/replenish_energy/ReplenishEnergyListVM;", "", "", "", "getVariables", "getLayoutResID", "", "initView", "", "isAdd2ViewPager2", "lazyLoadData", "initDataObservable", "categoryCode$delegate", "Lkotlin/Lazy;", "getCategoryCode", "()I", ReplenishEnergyListFragment.KEY_CATEGORY_CODE, "<init>", "()V", "Companion", "a", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class ReplenishEnergyListFragment extends BaseMVVMFragment<FragmentReplenishEnergyListBinding, ReplenishEnergyListVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_CATEGORY_CODE = "categoryCode";

    /* JADX INFO: renamed from: categoryCode$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy categoryCode = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.social_contact.page.dormitory.replenish_energy.ReplenishEnergyListFragment$categoryCode$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m758invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("categoryCode") : 0);
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.social_contact.page.dormitory.replenish_energy.ReplenishEnergyListFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/social_contact/page/dormitory/replenish_energy/ReplenishEnergyListFragment$a;", "", "", ReplenishEnergyListFragment.KEY_CATEGORY_CODE, "Lcom/huachenjie/social_contact/page/dormitory/replenish_energy/ReplenishEnergyListFragment;", "a", "", "KEY_CATEGORY_CODE", "Ljava/lang/String;", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ReplenishEnergyListFragment a(int categoryCode) {
            Bundle bundle = new Bundle();
            bundle.putInt(ReplenishEnergyListFragment.KEY_CATEGORY_CODE, categoryCode);
            ReplenishEnergyListFragment replenishEnergyListFragment = new ReplenishEnergyListFragment();
            replenishEnergyListFragment.setArguments(bundle);
            return replenishEnergyListFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36231a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36231a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36231a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36231a.invoke(obj);
        }
    }

    private final int getCategoryCode() {
        return ((Number) this.categoryCode.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$0(ReplenishEnergyListAdapter replenishEnergyListAdapter, ReplenishEnergyListFragment replenishEnergyListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(replenishEnergyListAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(replenishEnergyListFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.ll_exchange) {
            DrinkDetailBean item = replenishEnergyListAdapter.getItem(i);
            kq5.b(replenishEnergyListAdapter.getContext(), "click_space_buy_drink", MapsKt.mapOf(new Pair[]{TuplesKt.to("drinkId", item.getDrinkId()), TuplesKt.to("price", String.valueOf(item.getPrice()))}));
            replenishEnergyListFragment.getMViewModel().l(item.getDrinkId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$1(ReplenishEnergyListFragment replenishEnergyListFragment) {
        Intrinsics.checkNotNullParameter(replenishEnergyListFragment, "this$0");
        replenishEnergyListFragment.getMViewModel().o(replenishEnergyListFragment.getCategoryCode());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.fragment_replenish_energy_list;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(nk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        super.initDataObservable();
        getMViewModel().n().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.social_contact.page.dormitory.replenish_energy.ReplenishEnergyListFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (bool.booleanValue()) {
                    PurchaseSuccessDialog.Companion companion = PurchaseSuccessDialog.INSTANCE;
                    FragmentManager childFragmentManager = ReplenishEnergyListFragment.this.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                    companion.a(childFragmentManager);
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        MutableLiveData<ReplenishEnergyListAdapter> mutableLiveDataM = getMViewModel().m();
        final ReplenishEnergyListAdapter replenishEnergyListAdapter = new ReplenishEnergyListAdapter();
        View viewInflate = getLayoutInflater().inflate(R.layout.view_state_empty_view, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "layoutInflater.inflate(R…w_state_empty_view, null)");
        replenishEnergyListAdapter.setEmptyView(viewInflate);
        replenishEnergyListAdapter.addChildClickViewIds(R.id.ll_exchange);
        y57.b(replenishEnergyListAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.ze7
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ReplenishEnergyListFragment.initView$lambda$2$lambda$0(replenishEnergyListAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        replenishEnergyListAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.af7
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                ReplenishEnergyListFragment.initView$lambda$2$lambda$1(this.f40524a);
            }
        });
        mutableLiveDataM.setValue(replenishEnergyListAdapter);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public boolean isAdd2ViewPager2() {
        return true;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void lazyLoadData() {
        super.lazyLoadData();
        getMViewModel().o(getCategoryCode());
    }
}
