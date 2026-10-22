package com.huachenjie.social_contact.page.dormitory.replenish_energy;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.DrinkCategory;
import com.huachenjie.social_contact.databinding.ActivityReplenishEnergyBinding;
import com.huachenjie.social_contact.page.dormitory.replenish_energy.ReplenishEnergyActivity;
import com.igexin.push.g.o;
import com.zj.adlib.nk0;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0002¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/social_contact/page/dormitory/replenish_energy/ReplenishEnergyActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/social_contact/databinding/ActivityReplenishEnergyBinding;", "Lcom/huachenjie/social_contact/page/dormitory/replenish_energy/ReplenishEnergyVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "W", "b0", "<init>", "()V", "a", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class ReplenishEnergyActivity extends BaseMVVMActivity<ActivityReplenishEnergyBinding, ReplenishEnergyVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.huachenjie.social_contact.page.dormitory.replenish_energy.ReplenishEnergyActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/social_contact/page/dormitory/replenish_energy/ReplenishEnergyActivity$a;", "", "Landroid/content/Context;", "context", "", "a", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) ReplenishEnergyActivity.class));
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36230a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36230a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36230a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36230a.invoke(obj);
        }
    }

    public static final void c0(ReplenishEnergyActivity replenishEnergyActivity, View view) {
        Intrinsics.checkNotNullParameter(replenishEnergyActivity, "this$0");
        replenishEnergyActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(nk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().j().observe(this, new b(new Function1<List<? extends DrinkCategory>, Unit>() { // from class: com.huachenjie.social_contact.page.dormitory.replenish_energy.ReplenishEnergyActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<DrinkCategory>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(final List<DrinkCategory> list) {
                Intrinsics.checkNotNullExpressionValue(list, o.f);
                List<DrinkCategory> list2 = list;
                final ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((DrinkCategory) it.next()).getName());
                }
                this.this$0.getMBinding().f36100a.setOffscreenPageLimit(-1);
                this.this$0.getMBinding().f36100a.setAdapter(new FragmentStateAdapter(this.this$0) { // from class: com.huachenjie.social_contact.page.dormitory.replenish_energy.ReplenishEnergyActivity$initDataObserve$1.1
                    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
                    @NotNull
                    public Fragment createFragment(int position) {
                        return ReplenishEnergyListFragment.Companion.a(list.get(position).getCode());
                    }

                    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
                    public int getItemCount() {
                        return arrayList.size();
                    }
                });
                this.this$0.getMBinding().f12764a.setViewPager(this.this$0.getMBinding().f36100a, arrayList);
            }
        }));
    }

    public final void b0() {
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
        bindingTitleBean.setTitleName("补充能量");
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.black_main));
        bindingTitleBean.setBackground(-1);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ye7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReplenishEnergyActivity.c0(this.f46016a, view);
            }
        });
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setShowDivider(true);
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.activity_replenish_energy;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().k();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        b0();
    }
}
