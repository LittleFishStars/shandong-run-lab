package com.huachenjie.channel.page.all_channel;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.JoinAllChannelEntity;
import com.huachenjie.channel.databinding.ChannelFragmentJoinAllChannelBinding;
import com.huachenjie.channel.page.all_channel.JoinAllChannelFragment;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.zj.adlib.jo2;
import com.zj.adlib.tk0;
import com.zj.adlib.v41;
import com.zj.adlib.y57;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import huachenjie.sdk.http.PageEntity;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001#B\u0007¢\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/huachenjie/channel/page/all_channel/JoinAllChannelFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/channel/databinding/ChannelFragmentJoinAllChannelBinding;", "Lcom/huachenjie/channel/page/all_channel/JoinAllChannelFVM;", "", "initAdapter", "recordRvScroll", "restoreRvScroll", "", "", "", "getVariables", "getLayoutResID", "initView", "initDataObservable", "onResume", "onDestroyView", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "", yj7.g.WORKS_PUBLISH_CATEGORY_NO, "Ljava/lang/String;", "lastOffset", "I", "lastPosition", "Lcom/huachenjie/channel/page/all_channel/JoinAllChannelActivity;", "channelActivity$delegate", "Lkotlin/Lazy;", "getChannelActivity", "()Lcom/huachenjie/channel/page/all_channel/JoinAllChannelActivity;", "channelActivity", "<init>", "()V", "Companion", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class JoinAllChannelFragment extends BaseMVVMFragment<ChannelFragmentJoinAllChannelBinding, JoinAllChannelFVM> {

    @NotNull
    private static final String CATEGORY_KEY = "category";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int lastOffset;
    private int lastPosition;

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.oo4
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            JoinAllChannelFragment.onRefreshListener$lambda$0(this.f43792a);
        }
    };

    @NotNull
    private String categoryNo = "";

    /* JADX INFO: renamed from: channelActivity$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy channelActivity = LazyKt.lazy(new Function0<JoinAllChannelActivity>() { // from class: com.huachenjie.channel.page.all_channel.JoinAllChannelFragment$channelActivity$2
        {
            super(0);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final JoinAllChannelActivity m251invoke() {
            if (!(this.this$0.getActivity() instanceof JoinAllChannelActivity)) {
                return null;
            }
            FragmentActivity activity = this.this$0.getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.huachenjie.channel.page.all_channel.JoinAllChannelActivity");
            return (JoinAllChannelActivity) activity;
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.channel.page.all_channel.JoinAllChannelFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/channel/page/all_channel/JoinAllChannelFragment$a;", "", "", yj7.g.WORKS_PUBLISH_CATEGORY_NO, "Lcom/huachenjie/channel/page/all_channel/JoinAllChannelFragment;", "a", "CATEGORY_KEY", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final JoinAllChannelFragment a(@NotNull String categoryNo) {
            Intrinsics.checkNotNullParameter(categoryNo, yj7.g.WORKS_PUBLISH_CATEGORY_NO);
            JoinAllChannelFragment joinAllChannelFragment = new JoinAllChannelFragment();
            Bundle bundle = new Bundle();
            bundle.putString("category", categoryNo);
            joinAllChannelFragment.setArguments(bundle);
            return joinAllChannelFragment;
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.all_channel.JoinAllChannelFragment$restoreRvScroll$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.channel.page.all_channel.JoinAllChannelFragment$restoreRvScroll$1", f = "JoinAllChannelFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C14571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C14571(Continuation<? super C14571> continuation) {
            super(2, continuation);
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return JoinAllChannelFragment.this.new C14571(continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            JoinAllChannelEntity joinAllChannelEntityH0;
            RecyclerView recyclerView;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            JoinAllChannelActivity channelActivity = JoinAllChannelFragment.this.getChannelActivity();
            if (channelActivity == null || (joinAllChannelEntityH0 = channelActivity.h0(JoinAllChannelFragment.this.categoryNo)) == null) {
                return Unit.INSTANCE;
            }
            ChannelFragmentJoinAllChannelBinding channelFragmentJoinAllChannelBindingAccess$getMBinding = JoinAllChannelFragment.access$getMBinding(JoinAllChannelFragment.this);
            RecyclerView.LayoutManager layoutManager = (channelFragmentJoinAllChannelBindingAccess$getMBinding == null || (recyclerView = channelFragmentJoinAllChannelBindingAccess$getMBinding.f33170a) == null) ? null : recyclerView.getLayoutManager();
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (linearLayoutManager == null) {
                return Unit.INSTANCE;
            }
            linearLayoutManager.scrollToPositionWithOffset(joinAllChannelEntityH0.getPosition(), joinAllChannelEntityH0.getOffset());
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ ChannelFragmentJoinAllChannelBinding access$getMBinding(JoinAllChannelFragment joinAllChannelFragment) {
        return joinAllChannelFragment.getMBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JoinAllChannelActivity getChannelActivity() {
        return (JoinAllChannelActivity) this.channelActivity.getValue();
    }

    private final void initAdapter() {
        final JoinAllChannelAdapter value = getMViewModel().B().getValue();
        if (value != null) {
            JoinAllChannelFVM mViewModel = getMViewModel();
            ChannelFragmentJoinAllChannelBinding mBinding = getMBinding();
            Intrinsics.checkNotNull(mBinding);
            StateLayout stateLayout = mBinding.f7790a;
            Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding!!.stateLayout");
            mViewModel.o(this, stateLayout, value, getMViewModel().u().getValue() == null);
            BaseStateRequestModel.n(getMViewModel(), this, value, false, 4, null);
            value.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.po4
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    JoinAllChannelFragment.initAdapter$lambda$3$lambda$1(this.f44026a);
                }
            });
            y57.d(value, 0L, new OnItemClickListener() { // from class: com.zj.adlib.qo4
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    JoinAllChannelFragment.initAdapter$lambda$3$lambda$2(value, baseQuickAdapter, view, i);
                }
            }, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$3$lambda$1(JoinAllChannelFragment joinAllChannelFragment) {
        Intrinsics.checkNotNullParameter(joinAllChannelFragment, "this$0");
        BaseStateRequestModel.x(joinAllChannelFragment.getMViewModel(), false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$3$lambda$2(JoinAllChannelAdapter joinAllChannelAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(joinAllChannelAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        ARouter.getInstance().build(zj7.b.CHANNEL_MAIN).withString("channelNo", joinAllChannelAdapter.getData().get(i).getChannelNo()).navigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(JoinAllChannelFragment joinAllChannelFragment) {
        Intrinsics.checkNotNullParameter(joinAllChannelFragment, "this$0");
        joinAllChannelFragment.getMViewModel().y();
    }

    private final void recordRvScroll() {
        ChannelFragmentJoinAllChannelBinding mBinding;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ChannelFragmentJoinAllChannelBinding mBinding2 = getMBinding();
        RecyclerView.LayoutManager layoutManager = (mBinding2 == null || (recyclerView2 = mBinding2.f33170a) == null) ? null : recyclerView2.getLayoutManager();
        final LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || (mBinding = getMBinding()) == null || (recyclerView = mBinding.f33170a) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.huachenjie.channel.page.all_channel.JoinAllChannelFragment.recordRvScroll.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView3, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView3, "recyclerView");
                View childAt = linearLayoutManager.getChildAt(0);
                if (childAt == null) {
                    return;
                }
                this.lastOffset = childAt.getTop();
                this.lastPosition = linearLayoutManager.getPosition(childAt);
            }
        });
    }

    private final void restoreRvScroll() {
        v41.e(LifecycleOwnerKt.getLifecycleScope(this), jo2.e(), (CoroutineStart) null, new C14571(null), 2, (Object) null);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_fragment_join_all_channel;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        super.initDataObservable();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("category") : null;
        if (string == null) {
            string = "";
        }
        this.categoryNo = string;
        getMViewModel().E(this.categoryNo);
        getMViewModel().D(getChannelActivity());
        initAdapter();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        PageEntity<?> value = getMViewModel().u().getValue();
        if (value instanceof JoinAllChannelEntity) {
            JoinAllChannelEntity joinAllChannelEntity = (JoinAllChannelEntity) value;
            joinAllChannelEntity.setOffset(this.lastOffset);
            joinAllChannelEntity.setPosition(this.lastPosition);
            JoinAllChannelActivity channelActivity = getChannelActivity();
            if (channelActivity != null) {
                channelActivity.i0(this.categoryNo, joinAllChannelEntity);
            }
        }
        getMViewModel().u().setValue(null);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getMViewModel().u().getValue() == null) {
            getMViewModel().y();
        }
    }
}
