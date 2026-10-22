package com.huachenjie.channel.page.notify.broad_build;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.databinding.ChannelFragmentNotifyCommentBinding;
import com.huachenjie.channel.page.notify.broad_build.NotifyBroadCommentFragment;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.works.bean.comment.CommentReplyBean;
import com.huachenjie.works.external.adapter.CommentOnMeAdapter;
import com.huachenjie.works.external.bean.CommentOnMeBean;
import com.huachenjie.works.page.comment.CommentInputDialog;
import com.huachenjie.works.page.comment.base.CommentUtil;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import com.zj.adlib.tk0;
import com.zj.adlib.y57;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/channel/page/notify/broad_build/NotifyBroadCommentFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/channel/databinding/ChannelFragmentNotifyCommentBinding;", "Lcom/huachenjie/channel/page/notify/broad_build/NotifyBroadCommentVM;", "()V", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "getLayoutResID", "", "getVariables", "", "", "initAdapter", "", "initView", "onResume", "showCommentInputDialog", "commentBean", "Lcom/huachenjie/works/external/bean/CommentOnMeBean;", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NotifyBroadCommentFragment extends BaseMVVMFragment<ChannelFragmentNotifyCommentBinding, NotifyBroadCommentVM> {

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.c36
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            NotifyBroadCommentFragment.onRefreshListener$lambda$0(this.f40892a);
        }
    };

    public static final /* synthetic */ NotifyBroadCommentVM access$getMViewModel(NotifyBroadCommentFragment notifyBroadCommentFragment) {
        return notifyBroadCommentFragment.getMViewModel();
    }

    private final void initAdapter() {
        RecyclerView recyclerView;
        ChannelFragmentNotifyCommentBinding mBinding = getMBinding();
        RecyclerView.ItemAnimator itemAnimator = (mBinding == null || (recyclerView = mBinding.f33200a) == null) ? null : recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0L);
        }
        MutableLiveData<CommentOnMeAdapter> mutableLiveDataB = getMViewModel().B();
        final CommentOnMeAdapter commentOnMeAdapter = new CommentOnMeAdapter(1);
        commentOnMeAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.z26
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                NotifyBroadCommentFragment.initAdapter$lambda$4$lambda$1(this.f46171a);
            }
        });
        NotifyBroadCommentVM mViewModel = getMViewModel();
        ChannelFragmentNotifyCommentBinding mBinding2 = getMBinding();
        Intrinsics.checkNotNull(mBinding2);
        StateLayout stateLayout = mBinding2.f7859a;
        Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding!!.stateLayout");
        BaseStateRequestModel.p(mViewModel, this, stateLayout, commentOnMeAdapter, false, 8, null);
        BaseStateRequestModel.n(getMViewModel(), this, commentOnMeAdapter, false, 4, null);
        y57.d(commentOnMeAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.a36
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                NotifyBroadCommentFragment.initAdapter$lambda$4$lambda$2(commentOnMeAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        commentOnMeAdapter.addChildClickViewIds(R.id.bt_comment);
        commentOnMeAdapter.addChildClickViewIds(R.id.iv_avatar);
        y57.b(commentOnMeAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.b36
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                NotifyBroadCommentFragment.initAdapter$lambda$4$lambda$3(commentOnMeAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataB.setValue(commentOnMeAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$4$lambda$1(NotifyBroadCommentFragment notifyBroadCommentFragment) {
        Intrinsics.checkNotNullParameter(notifyBroadCommentFragment, "this$0");
        BaseStateRequestModel.x(notifyBroadCommentFragment.getMViewModel(), false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$4$lambda$2(CommentOnMeAdapter commentOnMeAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(commentOnMeAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        CommentOnMeBean commentOnMeBean = commentOnMeAdapter.getData().get(i);
        commentOnMeBean.setReadFlag(false);
        commentOnMeAdapter.notifyItemChanged(i);
        ARouter.getInstance().build(zj7.i.BROADCAST_FLOOR).withString(yj7.g.BROADCAST_QUOTE_NO, commentOnMeBean.getQuoteNo()).navigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$4$lambda$3(CommentOnMeAdapter commentOnMeAdapter, NotifyBroadCommentFragment notifyBroadCommentFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(commentOnMeAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(notifyBroadCommentFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        CommentOnMeBean commentOnMeBean = commentOnMeAdapter.getData().get(i);
        int id = view.getId();
        if (id == R.id.bt_comment) {
            notifyBroadCommentFragment.showCommentInputDialog(commentOnMeBean);
        } else if (id == R.id.iv_avatar) {
            ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", commentOnMeBean.getCommentUserCode()).navigation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(NotifyBroadCommentFragment notifyBroadCommentFragment) {
        Intrinsics.checkNotNullParameter(notifyBroadCommentFragment, "this$0");
        notifyBroadCommentFragment.getMViewModel().y();
    }

    private final void showCommentInputDialog(CommentOnMeBean commentBean) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.works_comment_reply_hint);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.works_comment_reply_hint)");
        String str = String.format(string, Arrays.copyOf(new Object[]{commentBean.getNickName()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        CommentInputDialog commentInputDialogA = CommentInputDialog.INSTANCE.a(2, commentBean.getQuoteNo(), (16 & 4) != 0 ? null : commentBean.getCommentNo(), str, (16 & 16) != 0 ? null : null, (16 & 32) != 0 ? null : new Function1<CommentReplyBean, Unit>() { // from class: com.huachenjie.channel.page.notify.broad_build.NotifyBroadCommentFragment.showCommentInputDialog.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CommentReplyBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull CommentReplyBean commentReplyBean) {
                Intrinsics.checkNotNullParameter(commentReplyBean, o.f);
                CommentUtil commentUtil = CommentUtil.f37253a;
                Context contextRequireContext = NotifyBroadCommentFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                commentUtil.g(contextRequireContext, NotifyBroadCommentFragment.access$getMViewModel(NotifyBroadCommentFragment.this), commentReplyBean, (8 & 8) != 0 ? false : true, 2, (8 & 32) != 0 ? null : null, new Function1<CommentReplyBean, Unit>() { // from class: com.huachenjie.channel.page.notify.broad_build.NotifyBroadCommentFragment.showCommentInputDialog.1.1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((CommentReplyBean) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull CommentReplyBean commentReplyBean2) {
                        Intrinsics.checkNotNullParameter(commentReplyBean2, o.f);
                        fv5.a(R.string.works_comment_on_success);
                    }
                });
            }
        });
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        commentInputDialogA.show(childFragmentManager, CommentInputDialog.class.getSimpleName());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_fragment_notify_comment;
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
