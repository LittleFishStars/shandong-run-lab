package com.huachenjie.mine.page.home.topic;

import android.content.Context;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.base.broadcast.topic.TopicOperateListener;
import com.huachenjie.base.broadcast.topic.TopicOperateReceiver;
import com.huachenjie.base.works.BaseSearchResultFragment;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.mine.R;
import com.huachenjie.mine.databinding.MineFragmentMyTopicBinding;
import com.huachenjie.mine.page.home.topic.MyTopicFragment;
import com.zj.adlib.e99;
import com.zj.adlib.ik0;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u0016H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0002J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006%"}, d2 = {"Lcom/huachenjie/mine/page/home/topic/MyTopicFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/mine/databinding/MineFragmentMyTopicBinding;", "Lcom/huachenjie/mine/page/home/topic/MyTopicVM;", "()V", "hasInitData", "", "hasInitModel", "hiddenChanged", "Ljava/lang/Boolean;", BaseSearchResultFragment.NEED_REFRESH_KEY, "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "realVisible", "topicOperateReceiver", "Lcom/huachenjie/base/broadcast/topic/TopicOperateReceiver;", "getTopicOperateReceiver", "()Lcom/huachenjie/base/broadcast/topic/TopicOperateReceiver;", "topicOperateReceiver$delegate", "Lkotlin/Lazy;", "visibleToUser", "checkVisible", "", "getLayoutResID", "", "getVariables", "", "", "initData", "onDestroyView", "onHiddenChanged", "hidden", "onResume", "onViewCreated", "onVisibleToUser", "setUserVisibleHint", "isVisibleToUser", "mine_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MyTopicFragment extends BaseMVVMFragment<MineFragmentMyTopicBinding, MyTopicVM> {
    private boolean hasInitData;
    private boolean hasInitModel;

    @Nullable
    private Boolean hiddenChanged;
    private boolean needRefresh;
    private boolean realVisible;

    @Nullable
    private Boolean visibleToUser;

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.gv5
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            MyTopicFragment.onRefreshListener$lambda$0(this.f41992a);
        }
    };

    /* JADX INFO: renamed from: topicOperateReceiver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy topicOperateReceiver = LazyKt.lazy(new Function0<TopicOperateReceiver>() { // from class: com.huachenjie.mine.page.home.topic.MyTopicFragment$topicOperateReceiver$2

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/huachenjie/mine/page/home/topic/MyTopicFragment$topicOperateReceiver$2$a", "Lcom/huachenjie/base/broadcast/topic/TopicOperateListener;", "", "a", "b", "mine_release"}, k = 1, mv = {1, 8, 0})
        public static final class a implements TopicOperateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MyTopicFragment f35401a;

            public a(MyTopicFragment myTopicFragment) {
                this.f35401a = myTopicFragment;
            }

            @Override // com.huachenjie.base.broadcast.topic.TopicOperateListener
            public void a() {
                this.f35401a.needRefresh = true;
            }

            @Override // com.huachenjie.base.broadcast.topic.TopicOperateListener
            public void b() {
                this.f35401a.needRefresh = true;
            }
        }

        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TopicOperateReceiver m603invoke() {
            return new TopicOperateReceiver(new a(this.this$0));
        }
    });

    private final void checkVisible() {
        Boolean bool = this.hiddenChanged;
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, bool2) || !Intrinsics.areEqual(this.visibleToUser, bool2)) {
            this.realVisible = false;
        } else {
            onVisibleToUser();
            this.realVisible = true;
        }
    }

    private final TopicOperateReceiver getTopicOperateReceiver() {
        return (TopicOperateReceiver) this.topicOperateReceiver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(MyTopicFragment myTopicFragment) {
        Intrinsics.checkNotNullParameter(myTopicFragment, "this$0");
        myTopicFragment.getMViewModel().s();
    }

    private final void onVisibleToUser() {
        if (!this.hasInitData && this.hasInitModel) {
            this.hasInitData = true;
            getMViewModel().s();
        } else if (this.needRefresh) {
            this.needRefresh = false;
            getMViewModel().s();
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mine_fragment_my_topic;
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

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        e99 e99Var = e99.f16248a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        e99Var.unregisterReceiver(contextRequireContext, getTopicOperateReceiver());
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
        e99 e99Var = e99.f16248a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        e99Var.registerReceiver(contextRequireContext, getTopicOperateReceiver());
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.visibleToUser = Boolean.valueOf(isVisibleToUser);
        checkVisible();
        super.setUserVisibleHint(isVisibleToUser);
    }
}
