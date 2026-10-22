package com.huachenjie.mine.page.history.fragment;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.mine.R;
import com.huachenjie.mine.databinding.MineFragmentHistoryChannelBinding;
import com.huachenjie.mine.page.history.IHistoryFragmentListener;
import com.huachenjie.mine.page.history.fragment.HistoryChannelFragment;
import com.huachenjie.works.external.adapter.AllChannelListAdapter;
import com.zj.adlib.qk0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/mine/page/history/fragment/HistoryChannelFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/mine/databinding/MineFragmentHistoryChannelBinding;", "Lcom/huachenjie/mine/page/history/fragment/HistoryChannelViewModel;", "Lcom/huachenjie/mine/page/history/IHistoryFragmentListener;", "()V", "isRequestData", "", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "clearHistory", "", "getLayoutResID", "", "getVariables", "", "", "initAdapter", "initView", "onResume", "mine_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HistoryChannelFragment extends BaseMVVMFragment<MineFragmentHistoryChannelBinding, HistoryChannelViewModel> implements IHistoryFragmentListener {
    private boolean isRequestData;

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.k04
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            HistoryChannelFragment.onRefreshListener$lambda$0(this.f42713a);
        }
    };

    private final void initAdapter() {
        AllChannelListAdapter value = getMViewModel().B().getValue();
        if (value != null) {
            MineFragmentHistoryChannelBinding mBinding = getMBinding();
            Intrinsics.checkNotNull(mBinding);
            mBinding.f11250a.setEmptyLabel(getString(R.string.mine_history_record_empty));
            HistoryChannelViewModel mViewModel = getMViewModel();
            MineFragmentHistoryChannelBinding mBinding2 = getMBinding();
            Intrinsics.checkNotNull(mBinding2);
            StateLayout stateLayout = mBinding2.f11250a;
            Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding!!.stateLayout");
            BaseStateRequestModel.p(mViewModel, this, stateLayout, value, false, 8, null);
            BaseStateRequestModel.n(getMViewModel(), this, value, false, 4, null);
            value.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.l04
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    HistoryChannelFragment.initAdapter$lambda$2$lambda$1(this.f42959a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$2$lambda$1(HistoryChannelFragment historyChannelFragment) {
        Intrinsics.checkNotNullParameter(historyChannelFragment, "this$0");
        BaseStateRequestModel.x(historyChannelFragment.getMViewModel(), false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(HistoryChannelFragment historyChannelFragment) {
        Intrinsics.checkNotNullParameter(historyChannelFragment, "this$0");
        historyChannelFragment.getMViewModel().y();
    }

    @Override // com.huachenjie.mine.page.history.IHistoryFragmentListener
    public void clearHistory() {
        AllChannelListAdapter value;
        if (getMViewModel() == null) {
            return;
        }
        Integer value2 = getMViewModel().r().getValue();
        if ((value2 != null && value2.intValue() == 3) || (value = getMViewModel().B().getValue()) == null) {
            return;
        }
        value.setList(CollectionsKt.emptyList());
        getMViewModel().r().setValue(2);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mine_fragment_history_channel;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!isVisible() || this.isRequestData) {
            return;
        }
        this.isRequestData = true;
        getMViewModel().v().setValue(Boolean.TRUE);
        getMViewModel().y();
    }
}
