package com.huachenjie.mall.page.my_order;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.huachenjie.base.internal.AdCancelInterface;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.OrderCountBean;
import com.huachenjie.mall.databinding.MallActivityMyOrderBinding;
import com.huachenjie.mall.page.my_order.MyOrderActivity;
import com.huachenjie.mall.page.my_order.MyOrderActivity.MyOrderReceiver;
import com.huachenjie.mall.page.refund.RefundListFragment;
import com.zj.adlib.hk0;
import com.zj.adlib.wd6;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Route(path = zj7.g.MY_ORDER)
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001+B\u0007¢\u0006\u0004\b)\u0010*J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\rH\u0014J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002R!\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001f\u0010(\u001a\u00060$R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/huachenjie/mall/page/my_order/MyOrderActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityMyOrderBinding;", "Lcom/huachenjie/mall/page/my_order/MyOrderVM;", "Lcom/huachenjie/base/internal/AdCancelInterface;", "Lcom/huachenjie/mall/page/my_order/OrderOperationInterface;", "", "", "", "V", "getLayoutResID", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "initView", "initData", "W", "", "orderNo", "e", "k", "I", "n", "j", "onDestroy", "onRestoreInstanceState", "h0", "g0", "", "Landroidx/fragment/app/Fragment;", "b", "Lkotlin/Lazy;", "d0", "()Ljava/util/List;", "fragmentArray", "Lcom/huachenjie/mall/page/my_order/MyOrderActivity$MyOrderReceiver;", "c", "e0", "()Lcom/huachenjie/mall/page/my_order/MyOrderActivity$MyOrderReceiver;", "orderReceiver", "<init>", "()V", "MyOrderReceiver", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMyOrderActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyOrderActivity.kt\ncom/huachenjie/mall/page/my_order/MyOrderActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,296:1\n1855#2,2:297\n1002#2,2:299\n*S KotlinDebug\n*F\n+ 1 MyOrderActivity.kt\ncom/huachenjie/mall/page/my_order/MyOrderActivity\n*L\n264#1:297,2\n271#1:299,2\n*E\n"})
public final class MyOrderActivity extends BaseMVVMActivity<MallActivityMyOrderBinding, MyOrderVM> implements AdCancelInterface, OrderOperationInterface {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy fragmentArray = LazyKt.lazy(new Function0<List<Fragment>>() { // from class: com.huachenjie.mall.page.my_order.MyOrderActivity$fragmentArray$2
        @NotNull
        public final List<Fragment> invoke() {
            MyOrderListFragment.Companion companion = MyOrderListFragment.INSTANCE;
            return CollectionsKt.mutableListOf(new Fragment[]{companion.a(0), companion.a(1), companion.a(2), companion.a(3), companion.a(4), new RefundListFragment()});
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy orderReceiver = LazyKt.lazy(new Function0<MyOrderReceiver>() { // from class: com.huachenjie.mall.page.my_order.MyOrderActivity$orderReceiver$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MyOrderActivity.MyOrderReceiver m565invoke() {
            return this.this$0.new MyOrderReceiver();
        }
    });

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/huachenjie/mall/page/my_order/MyOrderActivity$MyOrderReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/huachenjie/mall/page/my_order/MyOrderActivity;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class MyOrderReceiver extends BroadcastReceiver {
        public MyOrderReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @Nullable Intent intent) {
            String stringExtra;
            Intrinsics.checkNotNullParameter(context, "context");
            if (intent == null || (stringExtra = intent.getStringExtra("order_no")) == null) {
                return;
            }
            switch (intent.getIntExtra(wd6.ORDER_OPERATE_TYPE_KEY, 1)) {
                case 1:
                    MyOrderActivity.this.e(stringExtra);
                    break;
                case 2:
                    MyOrderActivity.this.k(stringExtra);
                    break;
                case 3:
                    MyOrderActivity.this.n(stringExtra);
                    break;
                case 4:
                    MyOrderActivity.this.j(stringExtra);
                    break;
                case 5:
                    Object objLast = CollectionsKt.last(MyOrderActivity.this.d0());
                    Intrinsics.checkNotNull(objLast, "null cannot be cast to non-null type com.huachenjie.mall.page.refund.RefundListFragment");
                    ((RefundListFragment) objLast).refreshData();
                    break;
                case 6:
                    MyOrderActivity.this.I(stringExtra);
                    break;
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 MyOrderActivity.kt\ncom/huachenjie/mall/page/my_order/MyOrderActivity\n*L\n1#1,328:1\n271#2:329\n*E\n"})
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            Fragment fragment = (Fragment) t;
            Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.huachenjie.mall.page.my_order.MyOrderListFragment");
            Integer numValueOf = Integer.valueOf(((MyOrderListFragment) fragment).getStatus());
            Fragment fragment2 = (Fragment) t2;
            Intrinsics.checkNotNull(fragment2, "null cannot be cast to non-null type com.huachenjie.mall.page.my_order.MyOrderListFragment");
            return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(((MyOrderListFragment) fragment2).getStatus()));
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35234a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35234a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35234a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35234a.invoke(obj);
        }
    }

    public static final boolean f0(MyOrderActivity myOrderActivity) {
        Intrinsics.checkNotNullParameter(myOrderActivity, "this$0");
        myOrderActivity.getMViewModel().l();
        return false;
    }

    public static final void i0(MyOrderActivity myOrderActivity, View view) {
        Intrinsics.checkNotNullParameter(myOrderActivity, "this$0");
        myOrderActivity.finish();
    }

    @Override // com.huachenjie.mall.page.my_order.OrderOperationInterface
    public void I(@NotNull String orderNo) {
        Intrinsics.checkNotNullParameter(orderNo, "orderNo");
        Fragment fragment = d0().get(0);
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.huachenjie.mall.page.my_order.MyOrderListFragment");
        MyOrderListFragment.updateOrder$default((MyOrderListFragment) fragment, orderNo, 5, 0, 4, null);
        getMViewModel().l();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().k().observe(this, new b(new Function1<OrderCountBean, Unit>() { // from class: com.huachenjie.mall.page.my_order.MyOrderActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((OrderCountBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(OrderCountBean orderCountBean) {
                Integer[] numArr = {Integer.valueOf(orderCountBean.getWaitPayCount()), Integer.valueOf(orderCountBean.getWaitDeliveryCount()), Integer.valueOf(orderCountBean.getWaitReceiptCount()), Integer.valueOf(orderCountBean.getWaitCommentCount()), Integer.valueOf(orderCountBean.getAfterSaleCount())};
                int tabCount = this.this$0.getMBinding().f10298a.getTabCount();
                for (int i = 1; i < tabCount; i++) {
                    TabLayout.Tab tabAt = this.this$0.getMBinding().f10298a.getTabAt(i);
                    int i2 = i - 1;
                    if (numArr[i2].intValue() > 0) {
                        BadgeDrawable orCreateBadge = tabAt != null ? tabAt.getOrCreateBadge() : null;
                        if (orCreateBadge != null) {
                            orCreateBadge.setBackgroundColor(this.this$0.getResources().getColor(R.color.color_FF3D3D));
                        }
                        if (orCreateBadge != null) {
                            orCreateBadge.setNumber(numArr[i2].intValue());
                        }
                        if (orCreateBadge != null) {
                            orCreateBadge.setMaxCharacterCount(3);
                        }
                    } else if (tabAt != null) {
                        tabAt.removeBadge();
                    }
                }
            }
        }));
        getMViewModel().j().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.mall.page.my_order.MyOrderActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                Object objFirst = CollectionsKt.first(this.this$0.d0());
                Intrinsics.checkNotNull(objFirst, "null cannot be cast to non-null type com.huachenjie.mall.page.my_order.MyOrderListFragment");
                ((MyOrderListFragment) objFirst).countDownTime();
                Object obj = this.this$0.d0().get(1);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.huachenjie.mall.page.my_order.MyOrderListFragment");
                ((MyOrderListFragment) obj).countDownTime();
            }
        }));
    }

    public final List<Fragment> d0() {
        return (List) this.fragmentArray.getValue();
    }

    @Override // com.huachenjie.mall.page.my_order.OrderOperationInterface
    public void e(@NotNull String orderNo) {
        Intrinsics.checkNotNullParameter(orderNo, "orderNo");
        Fragment fragment = d0().get(0);
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.huachenjie.mall.page.my_order.MyOrderListFragment");
        MyOrderListFragment.updateOrder$default((MyOrderListFragment) fragment, orderNo, 4, 0, 4, null);
        Fragment fragment2 = d0().get(1);
        Intrinsics.checkNotNull(fragment2, "null cannot be cast to non-null type com.huachenjie.mall.page.my_order.MyOrderListFragment");
        ((MyOrderListFragment) fragment2).removeOrder(orderNo);
        getMViewModel().l();
    }

    public final MyOrderReceiver e0() {
        return (MyOrderReceiver) this.orderReceiver.getValue();
    }

    public final void g0() {
        getMBinding().f34820a.setAdapter(new FragmentStateAdapter() { // from class: com.huachenjie.mall.page.my_order.MyOrderActivity$initTab$1
            {
                super(this.f35235a);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter
            @NotNull
            public Fragment createFragment(int position) {
                return (Fragment) this.f35235a.d0().get(position);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return this.f35235a.d0().size();
            }
        });
        String[] stringArray = getResources().getStringArray(R.array.mall_my_order_tab);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray….array.mall_my_order_tab)");
        SelectBoldTabLayout selectBoldTabLayout = getMBinding().f10298a;
        ViewPager2 viewPager2 = getMBinding().f34820a;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "mBinding.viewPager");
        selectBoldTabLayout.attachViewPager(viewPager2, stringArray);
        getMBinding().f34820a.setOffscreenPageLimit(stringArray.length);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_my_order;
    }

    public final void h0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName(getString(R.string.mall_my_order_title)).setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.qu5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyOrderActivity.i0(this.f44298a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().m();
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.zj.adlib.ru5
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                return MyOrderActivity.f0(this.f44537a);
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.color_f5f5f5));
        h0();
        g0();
    }

    @Override // com.huachenjie.mall.page.my_order.OrderOperationInterface
    public void j(@NotNull String orderNo) {
        Intrinsics.checkNotNullParameter(orderNo, "orderNo");
        Fragment fragment = d0().get(0);
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.huachenjie.mall.page.my_order.MyOrderListFragment");
        ((MyOrderListFragment) fragment).updateOrder(orderNo, 3, 2);
        Fragment fragment2 = d0().get(4);
        Intrinsics.checkNotNull(fragment2, "null cannot be cast to non-null type com.huachenjie.mall.page.my_order.MyOrderListFragment");
        ((MyOrderListFragment) fragment2).removeOrder(orderNo);
        getMViewModel().l();
    }

    @Override // com.huachenjie.mall.page.my_order.OrderOperationInterface
    public void k(@NotNull String orderNo) {
        Intrinsics.checkNotNullParameter(orderNo, "orderNo");
        Fragment fragment = d0().get(0);
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.huachenjie.mall.page.my_order.MyOrderListFragment");
        MyOrderListFragment.updateOrder$default((MyOrderListFragment) fragment, orderNo, 1, 0, 4, null);
        Fragment fragment2 = d0().get(1);
        Intrinsics.checkNotNull(fragment2, "null cannot be cast to non-null type com.huachenjie.mall.page.my_order.MyOrderListFragment");
        ((MyOrderListFragment) fragment2).removeOrder(orderNo);
        Fragment fragment3 = d0().get(2);
        Intrinsics.checkNotNull(fragment3, "null cannot be cast to non-null type com.huachenjie.mall.page.my_order.MyOrderListFragment");
        ((MyOrderListFragment) fragment3).refreshList();
        getMViewModel().l();
    }

    @Override // com.huachenjie.mall.page.my_order.OrderOperationInterface
    public void n(@NotNull String orderNo) {
        Intrinsics.checkNotNullParameter(orderNo, "orderNo");
        Fragment fragment = d0().get(0);
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.huachenjie.mall.page.my_order.MyOrderListFragment");
        MyOrderListFragment.updateOrder$default((MyOrderListFragment) fragment, orderNo, 3, 0, 4, null);
        Fragment fragment2 = d0().get(3);
        Intrinsics.checkNotNull(fragment2, "null cannot be cast to non-null type com.huachenjie.mall.page.my_order.MyOrderListFragment");
        ((MyOrderListFragment) fragment2).removeOrder(orderNo);
        Fragment fragment3 = d0().get(4);
        Intrinsics.checkNotNull(fragment3, "null cannot be cast to non-null type com.huachenjie.mall.page.my_order.MyOrderListFragment");
        ((MyOrderListFragment) fragment3).refreshList();
        getMViewModel().l();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity, com.huachenjie.common.reconfig.baseView.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wd6.f20422a.a(this, e0());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        wd6.f20422a.c(this, e0());
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NotNull Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        ArrayList arrayList = new ArrayList();
        Object objLast = CollectionsKt.last(d0());
        for (Fragment fragment : fragments) {
            if (fragment instanceof MyOrderListFragment) {
                arrayList.add(fragment);
            } else if (fragment instanceof RefundListFragment) {
                objLast = fragment;
            }
        }
        if (arrayList.size() > 1) {
            CollectionsKt.sortWith(arrayList, new a());
        }
        arrayList.add(objLast);
        if (arrayList.size() == d0().size()) {
            d0().clear();
            d0().addAll(arrayList);
        }
    }
}
