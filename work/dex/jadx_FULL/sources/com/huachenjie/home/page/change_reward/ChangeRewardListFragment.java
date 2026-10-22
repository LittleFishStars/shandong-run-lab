package com.huachenjie.home.page.change_reward;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.base.broadcast.inspiration.InspirationReceiver;
import com.huachenjie.base.dialog.lottery.LotteryDialog;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.reward.AwardListBean;
import com.huachenjie.home.bean.reward.JackpotListBean;
import com.huachenjie.home.databinding.HomeFragmentChangeRewardListBinding;
import com.huachenjie.home.page.change_reward.ChangeRewardListFragment;
import com.zj.adlib.fb4;
import com.zj.adlib.fv5;
import com.zj.adlib.xk0;
import com.zj.adlib.y57;
import com.zj.adlib.zj7;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/home/page/change_reward/ChangeRewardListFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/home/databinding/HomeFragmentChangeRewardListBinding;", "Lcom/huachenjie/home/page/change_reward/ChangeRewardListVM;", "", "", "", "getVariables", "getLayoutResID", "", "initView", "onViewCreated", "onDestroyView", "initData", "Lcom/huachenjie/home/bean/reward/JackpotListBean;", "jackpotList$delegate", "Lkotlin/Lazy;", "getJackpotList", "()Lcom/huachenjie/home/bean/reward/JackpotListBean;", "jackpotList", "exchangeIndex", "I", "Lcom/huachenjie/base/broadcast/inspiration/InspirationReceiver;", "inspirationOperateReceiver$delegate", "getInspirationOperateReceiver", "()Lcom/huachenjie/base/broadcast/inspiration/InspirationReceiver;", "inspirationOperateReceiver", "<init>", "()V", "Companion", "a", "home_release"}, k = 1, mv = {1, 8, 0})
public final class ChangeRewardListFragment extends BaseMVVMFragment<HomeFragmentChangeRewardListBinding, ChangeRewardListVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_JACKPOT_LIST = "jackpot_list";

    /* JADX INFO: renamed from: jackpotList$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy jackpotList = LazyKt.lazy(new Function0<JackpotListBean>() { // from class: com.huachenjie.home.page.change_reward.ChangeRewardListFragment$jackpotList$2
        {
            super(0);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final JackpotListBean m408invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return (JackpotListBean) arguments.getParcelable("jackpot_list");
            }
            return null;
        }
    });
    private int exchangeIndex = -1;

    /* JADX INFO: renamed from: inspirationOperateReceiver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy inspirationOperateReceiver = LazyKt.lazy(new ChangeRewardListFragment$inspirationOperateReceiver$2(this));

    /* JADX INFO: renamed from: com.huachenjie.home.page.change_reward.ChangeRewardListFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/home/page/change_reward/ChangeRewardListFragment$a;", "", "Lcom/huachenjie/home/bean/reward/JackpotListBean;", "listBean", "Lcom/huachenjie/home/page/change_reward/ChangeRewardListFragment;", "a", "", "KEY_JACKPOT_LIST", "Ljava/lang/String;", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ChangeRewardListFragment a(@NotNull JackpotListBean listBean) {
            Intrinsics.checkNotNullParameter(listBean, "listBean");
            ChangeRewardListFragment changeRewardListFragment = new ChangeRewardListFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(ChangeRewardListFragment.KEY_JACKPOT_LIST, listBean);
            changeRewardListFragment.setArguments(bundle);
            return changeRewardListFragment;
        }
    }

    private final InspirationReceiver getInspirationOperateReceiver() {
        return (InspirationReceiver) this.inspirationOperateReceiver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JackpotListBean getJackpotList() {
        return (JackpotListBean) this.jackpotList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$0(ChangeRewardListAdapter changeRewardListAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(changeRewardListAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        AwardListBean item = changeRewardListAdapter.getItem(i);
        if (item.getAwardType() == 1) {
            ARouter.getInstance().build(zj7.g.GOOD_DETAIL).withString("goodsNo", item.getMaterialInfo().getItemNo()).navigation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$1(ChangeRewardListFragment changeRewardListFragment, ChangeRewardListAdapter changeRewardListAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(changeRewardListFragment, "this$0");
        Intrinsics.checkNotNullParameter(changeRewardListAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != R.id.tv_exchange || changeRewardListFragment.getJackpotList() == null) {
            return;
        }
        FragmentActivity activity = changeRewardListFragment.getActivity();
        ChangeRewardActivity changeRewardActivity = activity instanceof ChangeRewardActivity ? (ChangeRewardActivity) activity : null;
        int iG0 = changeRewardActivity != null ? changeRewardActivity.g0() : 0;
        JackpotListBean jackpotList = changeRewardListFragment.getJackpotList();
        Intrinsics.checkNotNull(jackpotList);
        if (iG0 < jackpotList.getJackpotUse()) {
            fv5.b("闪金币不足，请先做任务获得闪金币");
            return;
        }
        changeRewardListFragment.exchangeIndex = i;
        AwardListBean item = changeRewardListAdapter.getItem(i);
        LotteryDialog.Companion companion = LotteryDialog.INSTANCE;
        FragmentManager childFragmentManager = changeRewardListFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        JackpotListBean jackpotList2 = changeRewardListFragment.getJackpotList();
        Intrinsics.checkNotNull(jackpotList2);
        String jackpotRemarks = jackpotList2.getJackpotRemarks();
        JackpotListBean jackpotList3 = changeRewardListFragment.getJackpotList();
        Intrinsics.checkNotNull(jackpotList3);
        String jackpotNo = jackpotList3.getJackpotNo();
        JackpotListBean jackpotList4 = changeRewardListFragment.getJackpotList();
        Intrinsics.checkNotNull(jackpotList4);
        companion.a(childFragmentManager, jackpotRemarks, jackpotNo, jackpotList4.getJackpotUse(), item.getAwardNo(), 2);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.home_fragment_change_reward_list;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(xk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        ChangeRewardListAdapter value = getMViewModel().i().getValue();
        if (value != null) {
            JackpotListBean jackpotList = getJackpotList();
            value.setList(jackpotList != null ? jackpotList.getAwardList() : null);
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        MutableLiveData<ChangeRewardListAdapter> mutableLiveDataI = getMViewModel().i();
        JackpotListBean jackpotList = getJackpotList();
        final ChangeRewardListAdapter changeRewardListAdapter = new ChangeRewardListAdapter(jackpotList != null ? jackpotList.getJackpotType() : 1);
        y57.d(changeRewardListAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.wh1
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ChangeRewardListFragment.initView$lambda$2$lambda$0(changeRewardListAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        changeRewardListAdapter.addChildClickViewIds(R.id.tv_exchange);
        y57.b(changeRewardListAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.xh1
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ChangeRewardListFragment.initView$lambda$2$lambda$1(this.f20662a, changeRewardListAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataI.setValue(changeRewardListAdapter);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        fb4 fb4Var = fb4.f41638a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        fb4Var.unregisterReceiver(contextRequireContext, getInspirationOperateReceiver());
        super.onDestroyView();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void onViewCreated() {
        super.onViewCreated();
        fb4 fb4Var = fb4.f41638a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        fb4Var.registerReceiver(contextRequireContext, getInspirationOperateReceiver());
    }
}
