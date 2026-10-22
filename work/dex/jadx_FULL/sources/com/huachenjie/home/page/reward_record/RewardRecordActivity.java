package com.huachenjie.home.page.reward_record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.base.bean.reward.RewardInfoBean;
import com.huachenjie.base.bean.reward.RewardInfoDetailBean;
import com.huachenjie.base.bean.reward.RewardInfoMaterialBean;
import com.huachenjie.base.bean.reward.RewardInfoOrderBean;
import com.huachenjie.base.bean.reward.RewardInfoReceiveBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.home.R;
import com.huachenjie.home.databinding.HomeActivityRewardRecordBinding;
import com.huachenjie.home.page.reward_detail.RewardDetailActivity;
import com.huachenjie.home.page.reward_record.RewardRecordActivity;
import com.huachenjie.mall.utils.RewardOrderHelp;
import com.zj.adlib.su9;
import com.zj.adlib.xk0;
import com.zj.adlib.y57;
import com.zj.adlib.zj7;
import huachenjie.sdk.http.PageEntity;
import java.util.Iterator;
import java.util.List;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Route(path = zj7.e.REWARD_RECORD)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001%B\u0007¢\u0006\u0004\b#\u0010$J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0014J\b\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u001d\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u001cR#\u0010\"\u001a\n \u0019*\u0004\u0018\u00010\u001e0\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/huachenjie/home/page/reward_record/RewardRecordActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/home/databinding/HomeActivityRewardRecordBinding;", "Lcom/huachenjie/home/page/reward_record/RewardRecordVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "W", "onDestroy", "k0", "Lcom/huachenjie/home/page/reward_record/RewardRecordAdapter;", "adapter", "o0", "Lcom/huachenjie/mall/utils/RewardOrderHelp$RewardOrderReceiver;", "b", "Lkotlin/Lazy;", "j0", "()Lcom/huachenjie/mall/utils/RewardOrderHelp$RewardOrderReceiver;", "receiver", "Landroid/view/View;", "kotlin.jvm.PlatformType", "c", "i0", "()Landroid/view/View;", "headView", "Landroid/view/ViewGroup;", "d", "h0", "()Landroid/view/ViewGroup;", "emptyView", "<init>", "()V", "a", "home_release"}, k = 1, mv = {1, 8, 0})
public final class RewardRecordActivity extends BaseMVVMActivity<HomeActivityRewardRecordBinding, RewardRecordVM> {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy receiver = LazyKt.lazy(new Function0<RewardOrderHelp.RewardOrderReceiver>() { // from class: com.huachenjie.home.page.reward_record.RewardRecordActivity$receiver$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final RewardOrderHelp.RewardOrderReceiver m430invoke() {
            final RewardRecordActivity rewardRecordActivity = this.this$0;
            return new RewardOrderHelp.RewardOrderReceiver(new Function2<String, String, Unit>() { // from class: com.huachenjie.home.page.reward_record.RewardRecordActivity$receiver$2.1
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((String) obj, (String) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull String str, @NotNull String str2) {
                    List<RewardInfoBean> data;
                    Object next;
                    Intrinsics.checkNotNullParameter(str, "orderNo");
                    Intrinsics.checkNotNullParameter(str2, "exchangeCode");
                    RewardRecordAdapter value = rewardRecordActivity.getMViewModel().C().getValue();
                    if (value == null || (data = value.getData()) == null) {
                        return;
                    }
                    Iterator<T> it = data.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.areEqual(((RewardInfoBean) next).getWinningRecordNo(), str2));
                    RewardInfoBean rewardInfoBean = (RewardInfoBean) next;
                    if (rewardInfoBean == null) {
                        return;
                    }
                    RewardInfoOrderBean rewardInfoOrderBean = new RewardInfoOrderBean(str, null, 2, null);
                    rewardInfoBean.setReceiveRecord(new RewardInfoReceiveBean(null, 0L, null, 7, null));
                    RewardInfoReceiveBean receiveRecord = rewardInfoBean.getReceiveRecord();
                    Intrinsics.checkNotNull(receiveRecord);
                    receiveRecord.setOrderInfo(rewardInfoOrderBean);
                    rewardInfoBean.setReceivedStatus(9);
                    RewardRecordAdapter value2 = rewardRecordActivity.getMViewModel().C().getValue();
                    if (value2 != null) {
                        value2.notifyItemChanged(value2.getData().indexOf(rewardInfoBean) + value2.getHeaderLayoutCount());
                    }
                }
            });
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy headView = LazyKt.lazy(new Function0<View>() { // from class: com.huachenjie.home.page.reward_record.RewardRecordActivity$headView$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final View m429invoke() {
            return LayoutInflater.from(this.this$0).inflate(R.layout.home_layout_reward_record, (ViewGroup) this.this$0.getMBinding().f34217a, false);
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy emptyView = LazyKt.lazy(new Function0<ViewGroup>() { // from class: com.huachenjie.home.page.reward_record.RewardRecordActivity$emptyView$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ViewGroup m428invoke() {
            return (ViewGroup) this.this$0.i0().findViewById(R.id.ll_empty);
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/home/page/reward_record/RewardRecordActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/home/page/reward_record/RewardRecordActivity;)V", "home_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            RewardRecordActivity.this.onBackPressed();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34368a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34368a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34368a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34368a.invoke(obj);
        }
    }

    public static final void l0(RewardRecordActivity rewardRecordActivity) {
        Intrinsics.checkNotNullParameter(rewardRecordActivity, "this$0");
        BaseStateRequestModel.x(rewardRecordActivity.getMViewModel(), false, 1, null);
    }

    public static final void m0(RewardRecordActivity rewardRecordActivity, RewardRecordAdapter rewardRecordAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(rewardRecordActivity, "this$0");
        Intrinsics.checkNotNullParameter(rewardRecordAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        RewardDetailActivity.INSTANCE.a(rewardRecordActivity, rewardRecordAdapter.getItem(i));
    }

    public static final void n0(RewardRecordAdapter rewardRecordAdapter, RewardRecordActivity rewardRecordActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        RewardInfoMaterialBean materialInfo;
        RewardInfoMaterialBean materialInfo2;
        RewardInfoOrderBean orderInfo;
        String orderNo;
        RewardInfoMaterialBean materialInfo3;
        String itemNo;
        Intrinsics.checkNotNullParameter(rewardRecordAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(rewardRecordActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.tv_sure) {
            RewardInfoBean item = rewardRecordAdapter.getItem(i);
            RewardInfoDetailBean awardInfo = item.getAwardInfo();
            Integer numValueOf = awardInfo != null ? Integer.valueOf(awardInfo.getAwardType()) : null;
            if (numValueOf != null && numValueOf.intValue() == 1) {
                String str = "";
                if (item.getReceivedStatus() == 1) {
                    Postcard postcardBuild = ARouter.getInstance().build(zj7.g.GOOD_DETAIL);
                    RewardInfoDetailBean awardInfo2 = item.getAwardInfo();
                    if (awardInfo2 != null && (materialInfo3 = awardInfo2.getMaterialInfo()) != null && (itemNo = materialInfo3.getItemNo()) != null) {
                        str = itemNo;
                    }
                    postcardBuild.withString("goodsNo", str).withBoolean("fromReward", true).withString("exchangeCode", item.getWinningRecordNo()).navigation();
                    return;
                }
                Postcard postcardBuild2 = ARouter.getInstance().build(zj7.g.ORDER_DETAIL);
                RewardInfoReceiveBean receiveRecord = item.getReceiveRecord();
                if (receiveRecord != null && (orderInfo = receiveRecord.getOrderInfo()) != null && (orderNo = orderInfo.getOrderNo()) != null) {
                    str = orderNo;
                }
                postcardBuild2.withString("orderNo", str).navigation();
                return;
            }
            if (numValueOf != null && numValueOf.intValue() == 6) {
                su9.x(rewardRecordActivity);
                return;
            }
            if (numValueOf != null && numValueOf.intValue() == 2) {
                RewardInfoDetailBean awardInfo3 = item.getAwardInfo();
                if ((awardInfo3 == null || (materialInfo2 = awardInfo3.getMaterialInfo()) == null || materialInfo2.getMaterialSubType() != 20) ? false : true) {
                    ARouter.getInstance().build(RoutePathConstants.SocialContact.b).navigation();
                    return;
                }
                return;
            }
            if (numValueOf != null && numValueOf.intValue() == 4) {
                RewardInfoDetailBean awardInfo4 = item.getAwardInfo();
                if ((awardInfo4 == null || (materialInfo = awardInfo4.getMaterialInfo()) == null || materialInfo.getMaterialSubType() != 0) ? false : true) {
                    su9.e(rewardRecordActivity);
                }
            }
        }
    }

    public static final void p0(RewardRecordActivity rewardRecordActivity, RewardRecordAdapter rewardRecordAdapter, View view, View view2) {
        Intrinsics.checkNotNullParameter(rewardRecordActivity, "this$0");
        Intrinsics.checkNotNullParameter(rewardRecordAdapter, "$adapter");
        rewardRecordActivity.getMViewModel().F().setValue(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(view, "footerView");
        rewardRecordAdapter.removeFooterView(view);
        BaseStateRequestModel.x(rewardRecordActivity.getMViewModel(), false, 1, null);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @Nullable
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(xk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(xk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().D().observe(this, new b(new RewardRecordActivity$initDataObserve$1(this)));
        getMViewModel().u().observe(this, new b(new Function1<PageEntity<?>, Unit>() { // from class: com.huachenjie.home.page.reward_record.RewardRecordActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PageEntity<?>) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code duplicated, block: B:9:0x0027  */
            public final void invoke(PageEntity<?> pageEntity) {
                boolean z;
                List<RewardInfoBean> data;
                ViewGroup viewGroupH0 = this.this$0.h0();
                RewardRecordAdapter value = this.this$0.getMViewModel().C().getValue();
                if (value != null && (data = value.getData()) != null) {
                    z = data.isEmpty();
                }
                viewGroupH0.setVisibility((z && pageEntity.getList().isEmpty()) ? 0 : 8);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.home_activity_reward_record;
    }

    public final ViewGroup h0() {
        return (ViewGroup) this.emptyView.getValue();
    }

    public final View i0() {
        return (View) this.headView.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        k0();
        RewardOrderHelp.f35274a.a(this, j0());
    }

    public final RewardOrderHelp.RewardOrderReceiver j0() {
        return (RewardOrderHelp.RewardOrderReceiver) this.receiver.getValue();
    }

    public final void k0() {
        final RewardRecordAdapter value = getMViewModel().C().getValue();
        if (value != null) {
            value.setHeaderWithEmptyEnable(true);
            View viewI0 = i0();
            Intrinsics.checkNotNullExpressionValue(viewI0, "headView");
            BaseQuickAdapter.setHeaderView$default(value, viewI0, 0, 0, 6, null);
            o0(value);
            value.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.xh7
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    RewardRecordActivity.l0(this.f45825a);
                }
            });
            RewardRecordVM mViewModel = getMViewModel();
            StateLayout stateLayout = getMBinding().f9330a;
            Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding.stateLayout");
            BaseStateRequestModel.p(mViewModel, this, stateLayout, value, false, 8, null);
            getMViewModel().m(this, value, false);
            y57.d(value, 0L, new OnItemClickListener() { // from class: com.zj.adlib.yh7
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    RewardRecordActivity.m0(this.f46032a, value, baseQuickAdapter, view, i);
                }
            }, 1, null);
            value.addChildClickViewIds(R.id.tv_sure);
            y57.b(value, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.zh7
                @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    RewardRecordActivity.n0(value, this, baseQuickAdapter, view, i);
                }
            }, 1, null);
        }
    }

    public final void o0(final RewardRecordAdapter adapter) {
        final View viewInflate = LayoutInflater.from(this).inflate(R.layout.home_layout_reward_record_bottom, (ViewGroup) getMBinding().f34217a, false);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.wh7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RewardRecordActivity.p0(this.f20445a, adapter, viewInflate, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(viewInflate, "footerView");
        BaseQuickAdapter.setFooterView$default(adapter, viewInflate, 0, 0, 6, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        RewardOrderHelp.f35274a.c(this, j0());
    }
}
