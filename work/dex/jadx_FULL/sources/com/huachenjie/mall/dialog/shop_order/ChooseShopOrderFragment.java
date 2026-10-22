package com.huachenjie.mall.dialog.shop_order;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.base.bean.MyOrderBean;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.im.custom.ShareOrderAttachment;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallFragmentChooseShopOrderBinding;
import com.huachenjie.mall.dialog.shop_order.ChooseShopOrderFragment;
import com.huachenjie.mall.page.merchants.MerchantsActivity;
import com.zj.adlib.qk0;
import com.zj.adlib.y57;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0016\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fR1\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00040\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/mall/dialog/shop_order/ChooseShopOrderFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/mall/databinding/MallFragmentChooseShopOrderBinding;", "Lcom/huachenjie/mall/dialog/shop_order/ChooseShopOrderVm;", "", "initAdapter", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "initView", "initData", "Landroid/view/View;", "view", "onDismissDialog", "Lkotlin/Function1;", "Lcom/huachenjie/im/custom/ShareOrderAttachment;", "Lkotlin/ParameterName;", "name", "orderAttachment", RenderCallContext.TYPE_CALLBACK, "Lkotlin/jvm/functions/Function1;", "<init>", "()V", "Companion", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class ChooseShopOrderFragment extends BaseMVVMBottomDialogFragment<MallFragmentChooseShopOrderBinding, ChooseShopOrderVm> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_SHOP_ID = "shopId";
    private Function1<? super ShareOrderAttachment, Unit> callback;

    /* JADX INFO: renamed from: com.huachenjie.mall.dialog.shop_order.ChooseShopOrderFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J9\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006R\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/mall/dialog/shop_order/ChooseShopOrderFragment$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "shopId", "Lkotlin/Function1;", "Lcom/huachenjie/im/custom/ShareOrderAttachment;", "Lkotlin/ParameterName;", "name", "orderAttachment", "", "selCallback", "a", "KEY_SHOP_ID", "Ljava/lang/String;", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fragmentManager, @NotNull String shopId, @NotNull Function1<? super ShareOrderAttachment, Unit> selCallback) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(shopId, "shopId");
            Intrinsics.checkNotNullParameter(selCallback, "selCallback");
            ChooseShopOrderFragment chooseShopOrderFragment = new ChooseShopOrderFragment();
            Bundle bundle = new Bundle();
            bundle.putString("shopId", shopId);
            chooseShopOrderFragment.setArguments(bundle);
            chooseShopOrderFragment.callback = selCallback;
            chooseShopOrderFragment.show(fragmentManager, "ChooseOrderFragment");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initAdapter() {
        MutableLiveData<ChooseShopOrderAdapter> mutableLiveDataB = ((ChooseShopOrderVm) getMViewModel()).B();
        final ChooseShopOrderAdapter chooseShopOrderAdapter = new ChooseShopOrderAdapter();
        BaseStateRequestModel baseStateRequestModel = (BaseStateRequestModel) getMViewModel();
        V mBinding = getMBinding();
        Intrinsics.checkNotNull(mBinding);
        StateLayout stateLayout = ((MallFragmentChooseShopOrderBinding) mBinding).f10651a;
        Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding!!.stateLayout");
        BaseStateRequestModel.p(baseStateRequestModel, this, stateLayout, chooseShopOrderAdapter, false, 8, null);
        BaseStateRequestModel.n((BaseStateRequestModel) getMViewModel(), this, chooseShopOrderAdapter, false, 4, null);
        chooseShopOrderAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.mk1
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                ChooseShopOrderFragment.initAdapter$lambda$4$lambda$0(this.f43319a);
            }
        });
        y57.d(chooseShopOrderAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.nk1
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ChooseShopOrderFragment.initAdapter$lambda$4$lambda$2(chooseShopOrderAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        chooseShopOrderAdapter.addChildClickViewIds(R.id.iv_shop, R.id.tv_shop_name);
        y57.b(chooseShopOrderAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.ok1
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ChooseShopOrderFragment.initAdapter$lambda$4$lambda$3(chooseShopOrderAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataB.setValue(chooseShopOrderAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initAdapter$lambda$4$lambda$0(ChooseShopOrderFragment chooseShopOrderFragment) {
        Intrinsics.checkNotNullParameter(chooseShopOrderFragment, "this$0");
        BaseStateRequestModel.x((BaseStateRequestModel) chooseShopOrderFragment.getMViewModel(), false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$4$lambda$2(ChooseShopOrderAdapter chooseShopOrderAdapter, ChooseShopOrderFragment chooseShopOrderFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(chooseShopOrderAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(chooseShopOrderFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        MyOrderBean myOrderBean = chooseShopOrderAdapter.getData().get(i);
        Function1<? super ShareOrderAttachment, Unit> function1 = chooseShopOrderFragment.callback;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(RenderCallContext.TYPE_CALLBACK);
            function1 = null;
        }
        ShareOrderAttachment shareOrderAttachment = new ShareOrderAttachment();
        shareOrderAttachment.setOrderNo(myOrderBean.getOrderNo());
        shareOrderAttachment.setOrderStatus(myOrderBean.getOrderStatus());
        shareOrderAttachment.setOrderStatusDesc(myOrderBean.getOrderStatusDesc());
        shareOrderAttachment.setGoodsName(myOrderBean.getGoodsList().get(0).getGoodsName());
        shareOrderAttachment.setGoodsSpec(myOrderBean.getGoodsList().get(0).getGoodsSpec());
        shareOrderAttachment.setGoodsImage(myOrderBean.getGoodsList().get(0).getGoodsImage());
        shareOrderAttachment.setGoodsUnitPrice(myOrderBean.getGoodsList().get(0).getGoodsUnitPrice());
        shareOrderAttachment.setOrderAmount(myOrderBean.getOrderAmount());
        shareOrderAttachment.setPayAmount(myOrderBean.getPayAmount());
        shareOrderAttachment.setGoodsCount(myOrderBean.getGoodsList().get(0).getGoodsCount());
        function1.invoke(shareOrderAttachment);
        chooseShopOrderFragment.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$4$lambda$3(ChooseShopOrderAdapter chooseShopOrderAdapter, ChooseShopOrderFragment chooseShopOrderFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(chooseShopOrderAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(chooseShopOrderFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        MyOrderBean myOrderBean = chooseShopOrderAdapter.getData().get(i);
        int id = view.getId();
        boolean z = true;
        if (id != R.id.iv_shop && id != R.id.tv_shop_name) {
            z = false;
        }
        if (z) {
            MerchantsActivity.Companion companion = MerchantsActivity.INSTANCE;
            Context contextRequireContext = chooseShopOrderFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.a(contextRequireContext, myOrderBean.getShopNo());
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -2;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_fragment_choose_shop_order;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.s), this)});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        ChooseShopOrderVm chooseShopOrderVm = (ChooseShopOrderVm) getMViewModel();
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("shopId") : null;
        if (string == null) {
            string = "";
        }
        chooseShopOrderVm.D(string);
        ((ChooseShopOrderVm) getMViewModel()).y();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }

    public final void onDismissDialog(@Nullable View view) {
        dismiss();
    }
}
