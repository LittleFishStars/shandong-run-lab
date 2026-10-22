package com.huachenjie.mall.page.my_order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.base.bean.MyOrderBean;
import com.huachenjie.base.bean.OrderGoodsBean;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.OrderReasonBean;
import com.huachenjie.mall.databinding.MallFragmentMyOrderListBinding;
import com.huachenjie.mall.dialog.cancel_reason.CancelReasonDialog;
import com.huachenjie.mall.dialog.pay.PayDialog;
import com.huachenjie.mall.page.address.modify.ShippingAddressModifyActivity;
import com.huachenjie.mall.page.comment.detail.CommentDetailActivity;
import com.huachenjie.mall.page.comment.write.WriteReviewActivity;
import com.huachenjie.mall.page.course_detail.CourseDetailActivity;
import com.huachenjie.mall.page.episodes_detail.EpisodesDetailActivity;
import com.huachenjie.mall.page.express.ExpressLogisticsActivity;
import com.huachenjie.mall.page.merchants.MerchantsActivity;
import com.huachenjie.mall.page.my_order.MyOrderListFragment;
import com.huachenjie.mall.page.order_detail.OrderDetailActivity;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import com.zj.adlib.hk0;
import com.zj.adlib.y57;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001*B\u0007¢\u0006\u0004\b'\u0010(J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ \u0010\u0017\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\nR\u001b\u0010\u001c\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR)\u0010&\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010!0!0 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lcom/huachenjie/mall/page/my_order/MyOrderListFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/mall/databinding/MallFragmentMyOrderListBinding;", "Lcom/huachenjie/mall/page/my_order/MyOrderListVM;", "", "initAdapter", "Lcom/huachenjie/mall/page/my_order/OrderOperationInterface;", "getOperationInterface", "", "orderNo", "", "findIndexWithOrderNo", "", "", "getVariables", "getLayoutResID", "initView", "onResume", "countDownTime", "refreshList", "removeOrder", MyOrderListFragment.KEY_ORDER_STATUS, "commentStatus", "updateOrder", "status$delegate", "Lkotlin/Lazy;", "getStatus", "()I", "status", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "addressDispatch$delegate", "getAddressDispatch", "()Landroidx/activity/result/ActivityResultLauncher;", "addressDispatch", "<init>", "()V", "Companion", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMyOrderListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyOrderListFragment.kt\ncom/huachenjie/mall/page/my_order/MyOrderListFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,323:1\n350#2,7:324\n*S KotlinDebug\n*F\n+ 1 MyOrderListFragment.kt\ncom/huachenjie/mall/page/my_order/MyOrderListFragment\n*L\n292#1:324,7\n*E\n"})
public final class MyOrderListFragment extends BaseMVVMFragment<MallFragmentMyOrderListBinding, MyOrderListVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_ORDER_STATUS = "orderStatus";
    public static final int ORDER_STATUS_ALL = 0;
    public static final int ORDER_STATUS_COMMENT = 4;
    public static final int ORDER_STATUS_REFUND = 5;
    public static final int ORDER_STATUS_WAIT_DELIVERY = 2;
    public static final int ORDER_STATUS_WAIT_PAY = 1;
    public static final int ORDER_STATUS_WAIT_RECEIVE = 3;

    /* JADX INFO: renamed from: status$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy status = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.mall.page.my_order.MyOrderListFragment$status$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m569invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("orderStatus") : 0);
        }
    });

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.vu5
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            MyOrderListFragment.onRefreshListener$lambda$0(this.f45456a);
        }
    };

    /* JADX INFO: renamed from: addressDispatch$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy addressDispatch = LazyKt.lazy(new MyOrderListFragment$addressDispatch$2(this));

    /* JADX INFO: renamed from: com.huachenjie.mall.page.my_order.MyOrderListFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/mall/page/my_order/MyOrderListFragment$a;", "", "", MyOrderListFragment.KEY_ORDER_STATUS, "Lcom/huachenjie/mall/page/my_order/MyOrderListFragment;", "a", "", "KEY_ORDER_STATUS", "Ljava/lang/String;", "ORDER_STATUS_ALL", "I", "ORDER_STATUS_COMMENT", "ORDER_STATUS_REFUND", "ORDER_STATUS_WAIT_DELIVERY", "ORDER_STATUS_WAIT_PAY", "ORDER_STATUS_WAIT_RECEIVE", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MyOrderListFragment a(int orderStatus) {
            MyOrderListFragment myOrderListFragment = new MyOrderListFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(MyOrderListFragment.KEY_ORDER_STATUS, orderStatus);
            myOrderListFragment.setArguments(bundle);
            return myOrderListFragment;
        }
    }

    private final int findIndexWithOrderNo(String orderNo) {
        if (!modelIsInitialized()) {
            return -1;
        }
        MyOrderListAdapter value = getMViewModel().F().getValue();
        List<MyOrderBean> data = value != null ? value.getData() : null;
        List<MyOrderBean> list = data;
        int i = 0;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        Iterator<MyOrderBean> it = data.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getOrderNo(), orderNo)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivityResultLauncher<Intent> getAddressDispatch() {
        return (ActivityResultLauncher) this.addressDispatch.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OrderOperationInterface getOperationInterface() {
        if (!(getActivity() instanceof OrderOperationInterface)) {
            return null;
        }
        KeyEventDispatcher.Component activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.huachenjie.mall.page.my_order.OrderOperationInterface");
        return (OrderOperationInterface) activity;
    }

    private final void initAdapter() {
        MutableLiveData<MyOrderListAdapter> mutableLiveDataF = getMViewModel().F();
        final MyOrderListAdapter myOrderListAdapter = new MyOrderListAdapter();
        MyOrderListVM mViewModel = getMViewModel();
        MallFragmentMyOrderListBinding mBinding = getMBinding();
        Intrinsics.checkNotNull(mBinding);
        StateLayout stateLayout = mBinding.f10684a;
        Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding!!.stateLayout");
        BaseStateRequestModel.p(mViewModel, this, stateLayout, myOrderListAdapter, false, 8, null);
        BaseStateRequestModel.n(getMViewModel(), this, myOrderListAdapter, false, 4, null);
        myOrderListAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.su5
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                MyOrderListFragment.initAdapter$lambda$5$lambda$1(this.f44779a);
            }
        });
        y57.d(myOrderListAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.tu5
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MyOrderListFragment.initAdapter$lambda$5$lambda$2(myOrderListAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        myOrderListAdapter.addChildClickViewIds(R.id.iv_shop, R.id.tv_shop_name, R.id.bt_cancel, R.id.bt_change_address, R.id.bt_pay, R.id.bt_express, R.id.bt_sure, R.id.bt_comment, R.id.bt_see_comment, R.id.bt_start_learn);
        y57.b(myOrderListAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.uu5
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MyOrderListFragment.initAdapter$lambda$5$lambda$4(myOrderListAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataF.setValue(myOrderListAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$5$lambda$1(MyOrderListFragment myOrderListFragment) {
        Intrinsics.checkNotNullParameter(myOrderListFragment, "this$0");
        BaseStateRequestModel.x(myOrderListFragment.getMViewModel(), false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$5$lambda$2(MyOrderListAdapter myOrderListAdapter, MyOrderListFragment myOrderListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(myOrderListAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(myOrderListFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        MyOrderBean myOrderBean = myOrderListAdapter.getData().get(i);
        OrderDetailActivity.Companion aVar = OrderDetailActivity.INSTANCE;
        Context contextRequireContext = myOrderListFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        aVar.a(contextRequireContext, myOrderBean.getOrderNo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$5$lambda$4(MyOrderListAdapter myOrderListAdapter, final MyOrderListFragment myOrderListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        OrderGoodsBean orderGoodsBean;
        String orderItemNo;
        Intrinsics.checkNotNullParameter(myOrderListAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(myOrderListFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        final MyOrderBean myOrderBean = myOrderListAdapter.getData().get(i);
        int id = view.getId();
        if (id == R.id.iv_shop || id == R.id.tv_shop_name) {
            MerchantsActivity.Companion companion = MerchantsActivity.INSTANCE;
            Context contextRequireContext = myOrderListFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.a(contextRequireContext, myOrderBean.getShopNo());
            return;
        }
        if (id == R.id.bt_cancel) {
            if (myOrderBean.getOrderStatus() == 5) {
                fv5.a(R.string.mall_my_order_paying_hint);
                return;
            }
            CancelReasonDialog.Companion companion2 = CancelReasonDialog.INSTANCE;
            MyOrderListVM mViewModel = myOrderListFragment.getMViewModel();
            FragmentManager childFragmentManager = myOrderListFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            CancelReasonDialog.Companion.e(companion2, mViewModel, childFragmentManager, null, new Function1<OrderReasonBean, Unit>() { // from class: com.huachenjie.mall.page.my_order.MyOrderListFragment$initAdapter$1$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((OrderReasonBean) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull OrderReasonBean orderReasonBean) {
                    Intrinsics.checkNotNullParameter(orderReasonBean, o.f);
                    MyOrderListVM mViewModel2 = this.this$0.getMViewModel();
                    String tradeNo = myOrderBean.getTradeNo();
                    int code = orderReasonBean.getCode();
                    final MyOrderListFragment myOrderListFragment2 = this.this$0;
                    final MyOrderBean myOrderBean2 = myOrderBean;
                    mViewModel2.B(tradeNo, code, new Function0<Unit>() { // from class: com.huachenjie.mall.page.my_order.MyOrderListFragment$initAdapter$1$3$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m567invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m567invoke() {
                            OrderOperationInterface operationInterface = myOrderListFragment2.getOperationInterface();
                            if (operationInterface != null) {
                                operationInterface.e(myOrderBean2.getOrderNo());
                            }
                        }
                    });
                }
            }, 4, null);
            return;
        }
        if (id == R.id.bt_change_address) {
            myOrderListFragment.getMViewModel().I(myOrderBean.getOrderNo(), new Function1<ShippingAddressBean, Unit>() { // from class: com.huachenjie.mall.page.my_order.MyOrderListFragment$initAdapter$1$3$2
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ShippingAddressBean) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull ShippingAddressBean shippingAddressBean) {
                    Intrinsics.checkNotNullParameter(shippingAddressBean, o.f);
                    ActivityResultLauncher addressDispatch = this.this$0.getAddressDispatch();
                    ShippingAddressModifyActivity.Companion companion3 = ShippingAddressModifyActivity.INSTANCE;
                    Context contextRequireContext2 = this.this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                    addressDispatch.launch(companion3.a(contextRequireContext2, shippingAddressBean));
                }
            });
            return;
        }
        if (id == R.id.bt_pay) {
            if (myOrderBean.getOrderStatus() == 5) {
                fv5.a(R.string.mall_my_order_paying_hint);
                return;
            }
            PayDialog.Companion companion3 = PayDialog.INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = myOrderListFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            companion3.c(fragmentActivityRequireActivity, myOrderBean.getPayAmount(), myOrderBean.getTradeNo(), myOrderBean.getPayRemainTime(), myOrderBean.getOrderNo(), myOrderBean.getShopNo(), new Function1<Integer, Unit>() { // from class: com.huachenjie.mall.page.my_order.MyOrderListFragment$initAdapter$1$3$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2) {
                    OrderOperationInterface operationInterface;
                    if (i2 != 1) {
                        if (i2 == 2 && (operationInterface = this.this$0.getOperationInterface()) != null) {
                            operationInterface.I(myOrderBean.getOrderNo());
                            return;
                        }
                        return;
                    }
                    OrderOperationInterface operationInterface2 = this.this$0.getOperationInterface();
                    if (operationInterface2 != null) {
                        operationInterface2.k(myOrderBean.getOrderNo());
                    }
                }
            });
            return;
        }
        if (id == R.id.bt_express) {
            ExpressLogisticsActivity.Companion companion4 = ExpressLogisticsActivity.INSTANCE;
            Context contextRequireContext2 = myOrderListFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            ExpressLogisticsActivity.Companion.a(companion4, contextRequireContext2, myOrderBean.getLogisticNo(), false, 4, null);
            return;
        }
        if (id == R.id.bt_sure) {
            myOrderListFragment.getMViewModel().D(myOrderBean.getOrderNo(), new Function0<Unit>() { // from class: com.huachenjie.mall.page.my_order.MyOrderListFragment$initAdapter$1$3$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m568invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m568invoke() {
                    OrderOperationInterface operationInterface = this.this$0.getOperationInterface();
                    if (operationInterface != null) {
                        operationInterface.n(myOrderBean.getOrderNo());
                    }
                }
            });
            return;
        }
        if (id == R.id.bt_comment) {
            OrderGoodsBean orderGoodsBean2 = (OrderGoodsBean) CollectionsKt.firstOrNull(myOrderBean.getGoodsList());
            if (orderGoodsBean2 != null) {
                WriteReviewActivity.Companion bVar = WriteReviewActivity.INSTANCE;
                Context contextRequireContext3 = myOrderListFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
                bVar.a(contextRequireContext3, myOrderBean.getOrderNo(), orderGoodsBean2);
                return;
            }
            return;
        }
        if (id == R.id.bt_see_comment) {
            CommentDetailActivity.Companion aVar = CommentDetailActivity.INSTANCE;
            Context contextRequireContext4 = myOrderListFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext()");
            aVar.a(contextRequireContext4, myOrderBean.getOrderNo());
            return;
        }
        if (id != R.id.bt_start_learn || (orderGoodsBean = (OrderGoodsBean) CollectionsKt.firstOrNull(myOrderBean.getGoodsList())) == null || (orderItemNo = orderGoodsBean.getOrderItemNo()) == null) {
            return;
        }
        if (myOrderBean.getCategoryView() == 1) {
            CourseDetailActivity.Companion bVar2 = CourseDetailActivity.INSTANCE;
            Context contextRequireContext5 = myOrderListFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext()");
            bVar2.b(contextRequireContext5, orderItemNo);
            return;
        }
        EpisodesDetailActivity.Companion bVar3 = EpisodesDetailActivity.INSTANCE;
        Context contextRequireContext6 = myOrderListFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext6, "requireContext()");
        bVar3.b(contextRequireContext6, orderItemNo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(MyOrderListFragment myOrderListFragment) {
        Intrinsics.checkNotNullParameter(myOrderListFragment, "this$0");
        myOrderListFragment.getMViewModel().y();
    }

    public static /* synthetic */ void updateOrder$default(MyOrderListFragment myOrderListFragment, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        myOrderListFragment.updateOrder(str, i, i2);
    }

    public final void countDownTime() {
        if (modelIsInitialized()) {
            getMViewModel().E(getStatus(), new Function1<String, Unit>() { // from class: com.huachenjie.mall.page.my_order.MyOrderListFragment.countDownTime.1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull String str) {
                    Intrinsics.checkNotNullParameter(str, o.f);
                    MyOrderListFragment.this.removeOrder(str);
                }
            });
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_fragment_my_order_list;
    }

    public final int getStatus() {
        return ((Number) this.status.getValue()).intValue();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        RecyclerView recyclerView;
        super.initView();
        getAddressDispatch();
        MallFragmentMyOrderListBinding mBinding = getMBinding();
        RecyclerView.ItemAnimator itemAnimator = (mBinding == null || (recyclerView = mBinding.f34957a) == null) ? null : recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0L);
        }
        int status = getStatus();
        if (status == 1 || status == 2 || status == 3) {
            getMViewModel().K(Integer.valueOf(getStatus() - 1));
        } else if (status == 4) {
            getMViewModel().J(1);
        }
        initAdapter();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getMViewModel().u().getValue() == null) {
            getMViewModel().y();
        }
    }

    public final void refreshList() {
        if (modelIsInitialized()) {
            getMViewModel().y();
        }
    }

    public final void removeOrder(@NotNull String orderNo) {
        List<MyOrderBean> data;
        Intrinsics.checkNotNullParameter(orderNo, "orderNo");
        int iFindIndexWithOrderNo = findIndexWithOrderNo(orderNo);
        if (iFindIndexWithOrderNo >= 0) {
            MyOrderListAdapter value = getMViewModel().F().getValue();
            if (value != null) {
                value.removeAt(iFindIndexWithOrderNo);
            }
            MyOrderListAdapter value2 = getMViewModel().F().getValue();
            boolean z = false;
            if (value2 != null && (data = value2.getData()) != null && data.isEmpty()) {
                z = true;
            }
            if (z) {
                getMViewModel().y();
            }
        }
    }

    public final void updateOrder(@NotNull String orderNo, int orderStatus, int commentStatus) {
        MyOrderListAdapter value;
        List<MyOrderBean> data;
        MyOrderBean myOrderBean;
        Intrinsics.checkNotNullParameter(orderNo, "orderNo");
        int iFindIndexWithOrderNo = findIndexWithOrderNo(orderNo);
        if (iFindIndexWithOrderNo < 0 || (value = getMViewModel().F().getValue()) == null || (data = value.getData()) == null || (myOrderBean = (MyOrderBean) CollectionsKt.getOrNull(data, iFindIndexWithOrderNo)) == null) {
            return;
        }
        myOrderBean.setOrderStatus(orderStatus);
        myOrderBean.setCommentStatus(commentStatus);
        if (orderStatus == 1) {
            String string = getString(R.string.mall_my_order_status2);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.mall_my_order_status2)");
            myOrderBean.setOrderStatusDesc(string);
        } else if (orderStatus == 3) {
            String string2 = getString(R.string.mall_my_order_status4);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.mall_my_order_status4)");
            myOrderBean.setOrderStatusDesc(string2);
        } else if (orderStatus == 4) {
            String string3 = getString(R.string.mall_my_order_status5);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.mall_my_order_status5)");
            myOrderBean.setOrderStatusDesc(string3);
        } else if (orderStatus == 5) {
            String string4 = getString(R.string.mall_my_order_status6);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.mall_my_order_status6)");
            myOrderBean.setOrderStatusDesc(string4);
        }
        MyOrderListAdapter value2 = getMViewModel().F().getValue();
        if (value2 != null) {
            value2.notifyItemChanged(iFindIndexWithOrderNo);
        }
    }
}
