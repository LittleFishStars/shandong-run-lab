package com.huachenjie.mine.page.home.post;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.base.broadcast.post.PostOperateListener;
import com.huachenjie.base.broadcast.post.PostOperateReceiver;
import com.huachenjie.base.works.BaseSearchResultFragment;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.mine.databinding.MineFragmentMyChannelBinding;
import com.huachenjie.mine.page.home.post.MyPostFragment;
import com.huachenjie.works.R;
import com.zj.adlib.i4a;
import com.zj.adlib.ik0;
import com.zj.adlib.tv6;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\b\u0010$\u001a\u00020\u0016H\u0002J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006'"}, d2 = {"Lcom/huachenjie/mine/page/home/post/MyPostFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/mine/databinding/MineFragmentMyChannelBinding;", "Lcom/huachenjie/mine/page/home/post/MyPostVM;", "()V", "hasInitData", "", "hasInitModel", "hiddenChanged", "Ljava/lang/Boolean;", BaseSearchResultFragment.NEED_REFRESH_KEY, "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "postOperateReceiver", "Lcom/huachenjie/base/broadcast/post/PostOperateReceiver;", "getPostOperateReceiver", "()Lcom/huachenjie/base/broadcast/post/PostOperateReceiver;", "postOperateReceiver$delegate", "Lkotlin/Lazy;", "realVisible", "visibleToUser", "checkVisible", "", "getLayoutResID", "", "getVariables", "", "", "initAdapter", "initData", "initView", "onDestroyView", "onHiddenChanged", "hidden", "onResume", "onViewCreated", "onVisibleToUser", "setUserVisibleHint", "isVisibleToUser", "mine_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MyPostFragment extends BaseMVVMFragment<MineFragmentMyChannelBinding, MyPostVM> {
    private boolean hasInitData;
    private boolean hasInitModel;

    @Nullable
    private Boolean hiddenChanged;
    private boolean needRefresh;

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.cv5
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            MyPostFragment.onRefreshListener$lambda$0(this.f41046a);
        }
    };

    /* JADX INFO: renamed from: postOperateReceiver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy postOperateReceiver = LazyKt.lazy(new Function0<PostOperateReceiver>() { // from class: com.huachenjie.mine.page.home.post.MyPostFragment$postOperateReceiver$2

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/huachenjie/mine/page/home/post/MyPostFragment$postOperateReceiver$2$a", "Lcom/huachenjie/base/broadcast/post/PostOperateListener;", "", "b", "c", "mine_release"}, k = 1, mv = {1, 8, 0})
        public static final class a implements PostOperateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MyPostFragment f35397a;

            public a(MyPostFragment myPostFragment) {
                this.f35397a = myPostFragment;
            }

            @Override // com.huachenjie.base.broadcast.post.PostOperateListener
            public void b() {
                this.f35397a.needRefresh = true;
            }

            @Override // com.huachenjie.base.broadcast.post.PostOperateListener
            public void c() {
                this.f35397a.needRefresh = true;
            }
        }

        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final PostOperateReceiver m601invoke() {
            return new PostOperateReceiver(new a(this.this$0));
        }
    });
    private boolean realVisible;

    @Nullable
    private Boolean visibleToUser;

    private final void checkVisible() {
        i4a.c("checkVisible:" + this.hasInitModel + ',' + this.hasInitData + ',' + this.hiddenChanged + ',' + this.visibleToUser + ',' + this.realVisible + ',' + this.needRefresh);
        Boolean bool = this.hiddenChanged;
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, bool2) || !Intrinsics.areEqual(this.visibleToUser, bool2)) {
            this.realVisible = false;
        } else {
            onVisibleToUser();
            this.realVisible = true;
        }
    }

    private final PostOperateReceiver getPostOperateReceiver() {
        return (PostOperateReceiver) this.postOperateReceiver.getValue();
    }

    private final void initAdapter() {
        MyPostAdapter myPostAdapter = new MyPostAdapter();
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_empty_work, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
        myPostAdapter.h(viewInflate);
        myPostAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.bv5
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                MyPostFragment.initAdapter$lambda$1(this.f40844a);
            }
        });
        getMViewModel().i().setValue(myPostAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$1(MyPostFragment myPostFragment) {
        Intrinsics.checkNotNullParameter(myPostFragment, "this$0");
        myPostFragment.getMViewModel().m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(MyPostFragment myPostFragment) {
        Intrinsics.checkNotNullParameter(myPostFragment, "this$0");
        myPostFragment.getMViewModel().o();
    }

    private final void onVisibleToUser() {
        i4a.c("onVisibleToUser:" + this.hasInitModel + ',' + this.hasInitData + ',' + this.hiddenChanged + ',' + this.visibleToUser + ',' + this.realVisible + ',' + this.needRefresh);
        if (!this.hasInitData && this.hasInitModel) {
            this.hasInitData = true;
            getMViewModel().o();
        } else if (this.needRefresh) {
            this.needRefresh = false;
            getMViewModel().o();
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return com.huachenjie.mine.R.layout.mine_fragment_post;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ik0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(ik0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        this.hasInitModel = true;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        tv6 tv6Var = tv6.f45013a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        tv6Var.unregisterReceiver(contextRequireContext, getPostOperateReceiver());
        super.onDestroyView();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        this.hiddenChanged = Boolean.valueOf(hidden);
        checkVisible();
        super.onHiddenChanged(hidden);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        checkVisible();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void onViewCreated() {
        super.onViewCreated();
        tv6 tv6Var = tv6.f45013a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        tv6Var.registerReceiver(contextRequireContext, getPostOperateReceiver());
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.visibleToUser = Boolean.valueOf(isVisibleToUser);
        checkVisible();
        super.setUserVisibleHint(isVisibleToUser);
    }
}
