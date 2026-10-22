package com.huachenjie.works.page.comment.me_list;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.page.statelayout.StateUtilsKt;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.comment.CommentReplyBean;
import com.huachenjie.works.databinding.WorksActivityCommentOnMeListBinding;
import com.huachenjie.works.external.adapter.CommentOnMeAdapter;
import com.huachenjie.works.external.bean.CommentOnMeBean;
import com.huachenjie.works.page.comment.CommentInputDialog;
import com.huachenjie.works.page.comment.base.CommentUtil;
import com.huachenjie.works.page.comment.me_list.CommentOnMeListActivity;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import com.zj.adlib.rk0;
import com.zj.adlib.y57;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import java.util.Arrays;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Route(path = zj7.i.COMMENT_ON_ME_LIST)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0017J\b\u0010\u000b\u001a\u00020\tH\u0017J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/works/page/comment/me_list/CommentOnMeListActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/works/databinding/WorksActivityCommentOnMeListBinding;", "Lcom/huachenjie/works/page/comment/me_list/CommentOnMeListModel;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "l0", "h0", "Lcom/huachenjie/works/external/bean/CommentOnMeBean;", "commentBean", "o0", "Lcom/huachenjie/common/page/statelayout/StateLayout;", "b", "Lkotlin/Lazy;", "g0", "()Lcom/huachenjie/common/page/statelayout/StateLayout;", "stateView", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "a", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class CommentOnMeListActivity extends BaseMVVMActivity<WorksActivityCommentOnMeListBinding, CommentOnMeListModel> {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy stateView = LazyKt.lazy(new Function0<StateLayout>() { // from class: com.huachenjie.works.page.comment.me_list.CommentOnMeListActivity$stateView$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final StateLayout m910invoke() {
            SwipeRefreshLayout swipeRefreshLayout = this.this$0.getMBinding().f13842a;
            Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, "mBinding.refreshLayout");
            StateLayout stateLayoutB = StateUtilsKt.b(swipeRefreshLayout);
            stateLayoutB.setEmptyLabel(this.this$0.getString(R.string.works_comment_on_empty));
            return stateLayoutB;
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.ep1
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            CommentOnMeListActivity.n0(this.f41490a);
        }
    };

    public static final void i0(CommentOnMeListActivity commentOnMeListActivity) {
        Intrinsics.checkNotNullParameter(commentOnMeListActivity, "this$0");
        BaseStateRequestModel.x(commentOnMeListActivity.getMViewModel(), false, 1, null);
    }

    public static final void j0(CommentOnMeAdapter commentOnMeAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(commentOnMeAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        commentOnMeAdapter.getData().get(i).setReadFlag(false);
        commentOnMeAdapter.notifyItemChanged(i);
        ARouter.getInstance().build(zj7.i.WORKS_DETAIL).withString(yj7.g.WORKS_NO, commentOnMeAdapter.getData().get(i).getWorksNo()).navigation();
    }

    public static final void k0(CommentOnMeAdapter commentOnMeAdapter, CommentOnMeListActivity commentOnMeListActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(commentOnMeAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(commentOnMeListActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        CommentOnMeBean commentOnMeBean = commentOnMeAdapter.getData().get(i);
        int id = view.getId();
        if (id == R.id.bt_comment) {
            commentOnMeListActivity.o0(commentOnMeBean);
        } else if (id == R.id.iv_avatar) {
            ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", commentOnMeBean.getCommentUserCode()).navigation();
        }
    }

    public static final void m0(CommentOnMeListActivity commentOnMeListActivity, View view) {
        Intrinsics.checkNotNullParameter(commentOnMeListActivity, "this$0");
        commentOnMeListActivity.finish();
    }

    public static final void n0(CommentOnMeListActivity commentOnMeListActivity) {
        Intrinsics.checkNotNullParameter(commentOnMeListActivity, "this$0");
        commentOnMeListActivity.getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(rk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(rk0.R), this.onRefreshListener)});
    }

    public final StateLayout g0() {
        return (StateLayout) this.stateView.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_activity_comment_on_me_list;
    }

    public final void h0() {
        RecyclerView.ItemAnimator itemAnimator = getMBinding().f36775a.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0L);
        }
        MutableLiveData<CommentOnMeAdapter> mutableLiveDataB = getMViewModel().B();
        final CommentOnMeAdapter commentOnMeAdapter = new CommentOnMeAdapter(0, 1, null);
        commentOnMeAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.fp1
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                CommentOnMeListActivity.i0(this.f41724a);
            }
        });
        BaseStateRequestModel.p(getMViewModel(), this, g0(), commentOnMeAdapter, false, 8, null);
        BaseStateRequestModel.n(getMViewModel(), this, commentOnMeAdapter, false, 4, null);
        y57.d(commentOnMeAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.gp1
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CommentOnMeListActivity.j0(commentOnMeAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        commentOnMeAdapter.addChildClickViewIds(R.id.bt_comment);
        commentOnMeAdapter.addChildClickViewIds(R.id.iv_avatar);
        y57.b(commentOnMeAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.hp1
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CommentOnMeListActivity.k0(commentOnMeAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataB.setValue(commentOnMeAdapter);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    @CallSuper
    public void initData() {
        super.initData();
        getMViewModel().v().setValue(Boolean.TRUE);
        getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    @CallSuper
    public void initView() {
        l0();
        h0();
    }

    public final void l0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName(getString(R.string.works_comment_on_me_title)).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ip1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentOnMeListActivity.m0(this.f42410a, view);
            }
        }).setShowDivider(true));
    }

    public final void o0(CommentOnMeBean commentBean) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.works_comment_reply_hint);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.works_comment_reply_hint)");
        String str = String.format(string, Arrays.copyOf(new Object[]{commentBean.getNickName()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        CommentInputDialog commentInputDialogA = CommentInputDialog.INSTANCE.a(1, commentBean.getWorksNo(), (16 & 4) != 0 ? null : commentBean.getCommentNo(), str, (16 & 16) != 0 ? null : null, (16 & 32) != 0 ? null : new Function1<CommentReplyBean, Unit>() { // from class: com.huachenjie.works.page.comment.me_list.CommentOnMeListActivity$showCommentInputDialog$1
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
                CommentOnMeListActivity commentOnMeListActivity = this.this$0;
                commentUtil.g(commentOnMeListActivity, commentOnMeListActivity.getMViewModel(), commentReplyBean, (8 & 8) != 0 ? false : true, 1, (8 & 32) != 0 ? null : null, new Function1<CommentReplyBean, Unit>() { // from class: com.huachenjie.works.page.comment.me_list.CommentOnMeListActivity$showCommentInputDialog$1.1
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
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        commentInputDialogA.show(supportFragmentManager, CommentInputDialog.class.getSimpleName());
    }
}
