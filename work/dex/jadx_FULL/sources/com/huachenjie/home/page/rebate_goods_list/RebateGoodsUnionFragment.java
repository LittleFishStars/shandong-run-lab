package com.huachenjie.home.page.rebate_goods_list;

import android.text.TextUtils;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.GoodStuffBean;
import com.huachenjie.home.databinding.HomeFragmentRebateGoodsListBinding;
import com.huachenjie.home.page.good_stuff.GoodStuffAdapter;
import com.huachenjie.home.page.rebate_goods_list.RebateGoodsUnionFragment;
import com.zj.adlib.xk0;
import com.zj.adlib.y57;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016¨\u0006\r"}, d2 = {"Lcom/huachenjie/home/page/rebate_goods_list/RebateGoodsUnionFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/home/databinding/HomeFragmentRebateGoodsListBinding;", "Lcom/huachenjie/home/page/rebate_goods_list/RebateGoodsUnionVM;", "()V", "getLayoutResID", "", "getVariables", "", "initAdapter", "", "initData", "initView", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RebateGoodsUnionFragment extends BaseMVVMFragment<HomeFragmentRebateGoodsListBinding, RebateGoodsUnionVM> {
    private final void initAdapter() {
        MutableLiveData<GoodStuffAdapter> mutableLiveDataB = getMViewModel().B();
        final GoodStuffAdapter goodStuffAdapter = new GoodStuffAdapter(new WeakReference(this), 0.0f, 0.0f, 0.0f, 14, null);
        goodStuffAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.tb7
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                RebateGoodsUnionFragment.initAdapter$lambda$2$lambda$0(this.f44886a);
            }
        });
        y57.d(goodStuffAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.ub7
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RebateGoodsUnionFragment.initAdapter$lambda$2$lambda$1(goodStuffAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        RebateGoodsUnionVM mViewModel = getMViewModel();
        HomeFragmentRebateGoodsListBinding mBinding = getMBinding();
        Intrinsics.checkNotNull(mBinding);
        StateLayout stateLayout = mBinding.f9446a;
        Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding!!.stateLayout");
        mViewModel.o(this, stateLayout, goodStuffAdapter, true);
        BaseStateRequestModel.n(getMViewModel(), this, goodStuffAdapter, false, 4, null);
        mutableLiveDataB.setValue(goodStuffAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$2$lambda$0(RebateGoodsUnionFragment rebateGoodsUnionFragment) {
        Intrinsics.checkNotNullParameter(rebateGoodsUnionFragment, "this$0");
        BaseStateRequestModel.x(rebateGoodsUnionFragment.getMViewModel(), false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$2$lambda$1(GoodStuffAdapter goodStuffAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(goodStuffAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        MultiItemEntity multiItemEntity = (MultiItemEntity) goodStuffAdapter.getItem(i);
        if (multiItemEntity instanceof GoodStuffBean) {
            String clickUrl = ((GoodStuffBean) multiItemEntity).getPublishInfo().getClickUrl();
            if (TextUtils.isEmpty(clickUrl)) {
                return;
            }
            if (!StringsKt.startsWith$default(clickUrl, "http", false, 2, (Object) null)) {
                clickUrl = "https://" + clickUrl;
            }
            ARouter.getInstance().build(RoutePathConstants.Common.c).withString("url", clickUrl).navigation();
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.home_fragment_rebate_goods_list;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, RebateGoodsUnionVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(xk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        initAdapter();
    }
}
