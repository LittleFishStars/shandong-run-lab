package com.huachenjie.channel.page.notify.post;

import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.adapter.notify.NotifyFavoritesAdapter;
import com.huachenjie.channel.bean.notify.NotifyFavoritesBean;
import com.huachenjie.channel.databinding.ChannelFragmentNotifyPostLikeBinding;
import com.huachenjie.channel.page.notify.post.NotifyPostLikeFragment;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.zj.adlib.tk0;
import com.zj.adlib.y57;
import com.zj.adlib.zj7;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/channel/page/notify/post/NotifyPostLikeFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/channel/databinding/ChannelFragmentNotifyPostLikeBinding;", "Lcom/huachenjie/channel/page/notify/post/NotifyPostLikeVM;", "()V", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "getLayoutResID", "", "getVariables", "", "", "initAdapter", "", "initView", "onResume", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NotifyPostLikeFragment extends BaseMVVMFragment<ChannelFragmentNotifyPostLikeBinding, NotifyPostLikeVM> {

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.w36
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            NotifyPostLikeFragment.onRefreshListener$lambda$0(this.f45517a);
        }
    };

    private final void initAdapter() {
        RecyclerView recyclerView;
        ChannelFragmentNotifyPostLikeBinding mBinding = getMBinding();
        RecyclerView.ItemAnimator itemAnimator = (mBinding == null || (recyclerView = mBinding.f33213a) == null) ? null : recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0L);
        }
        MutableLiveData<NotifyFavoritesAdapter> mutableLiveDataB = getMViewModel().B();
        final NotifyFavoritesAdapter notifyFavoritesAdapter = new NotifyFavoritesAdapter();
        notifyFavoritesAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.t36
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                NotifyPostLikeFragment.initAdapter$lambda$4$lambda$1(this.f44838a);
            }
        });
        NotifyPostLikeVM mViewModel = getMViewModel();
        ChannelFragmentNotifyPostLikeBinding mBinding2 = getMBinding();
        Intrinsics.checkNotNull(mBinding2);
        StateLayout stateLayout = mBinding2.f7891a;
        Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding!!.stateLayout");
        BaseStateRequestModel.p(mViewModel, this, stateLayout, notifyFavoritesAdapter, false, 8, null);
        BaseStateRequestModel.n(getMViewModel(), this, notifyFavoritesAdapter, false, 4, null);
        notifyFavoritesAdapter.addChildClickViewIds(R.id.iv_avatar);
        y57.b(notifyFavoritesAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.u36
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                NotifyPostLikeFragment.initAdapter$lambda$4$lambda$2(notifyFavoritesAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        y57.d(notifyFavoritesAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.v36
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                NotifyPostLikeFragment.initAdapter$lambda$4$lambda$3(notifyFavoritesAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataB.setValue(notifyFavoritesAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$4$lambda$1(NotifyPostLikeFragment notifyPostLikeFragment) {
        Intrinsics.checkNotNullParameter(notifyPostLikeFragment, "this$0");
        BaseStateRequestModel.x(notifyPostLikeFragment.getMViewModel(), false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$4$lambda$2(NotifyFavoritesAdapter notifyFavoritesAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(notifyFavoritesAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", notifyFavoritesAdapter.getData().get(i).getFavorUserCode()).navigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$4$lambda$3(NotifyFavoritesAdapter notifyFavoritesAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(notifyFavoritesAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        NotifyFavoritesBean notifyFavoritesBean = notifyFavoritesAdapter.getData().get(i);
        notifyFavoritesBean.setReadFlag(false);
        notifyFavoritesAdapter.notifyItemChanged(i);
        ARouter.getInstance().build(zj7.i.POST_DETAIL).withString("postNo", notifyFavoritesBean.getPostNo()).navigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(NotifyPostLikeFragment notifyPostLikeFragment) {
        Intrinsics.checkNotNullParameter(notifyPostLikeFragment, "this$0");
        notifyPostLikeFragment.getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_fragment_notify_post_like;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getMViewModel().y();
    }
}
