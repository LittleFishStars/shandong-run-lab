package com.huachenjie.works.page.broadcast_floor;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alipay.sdk.m.c0.d;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.base.bean.MoreOptBean;
import com.huachenjie.base.widget.MoreOptDialog;
import com.huachenjie.base.works.BaseSearchResultFragment;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.BroadcastFloorMessageBean;
import com.huachenjie.works.databinding.WorksFragmentBroadcastFloorBinding;
import com.huachenjie.works.page.broadcast_floor.BroadcastFloorFragment;
import com.huachenjie.works.page.comment.CommentDialog;
import com.igexin.push.g.o;
import com.zj.adlib.ai9;
import com.zj.adlib.f64;
import com.zj.adlib.hg0;
import com.zj.adlib.i4a;
import com.zj.adlib.m55;
import com.zj.adlib.qk0;
import com.zj.adlib.y57;
import com.zj.adlib.ys8;
import com.zj.adlib.zj7;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 92\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001:B\u0007¢\u0006\u0004\b7\u00108J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0006J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001f\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\"\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR\u001b\u0010'\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\"\u0010+\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00101\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010,\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\"\u00104\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010,\u001a\u0004\b5\u0010.\"\u0004\b6\u00100¨\u0006;"}, d2 = {"Lcom/huachenjie/works/page/broadcast_floor/BroadcastFloorFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentBroadcastFloorBinding;", "Lcom/huachenjie/works/page/broadcast_floor/BroadcastFloorListVM;", "", "initAdapter", "", "position", "Landroid/view/View;", "findViewContainerByPosition", "checkVisible", "getLayoutResID", "", "", "getVariables", "initData", "initView", "initDataObservable", d.x, "", "isVisibleToUser", "setUserVisibleHint", "onPause", "onDestroyView", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "broadcastType$delegate", "Lkotlin/Lazy;", "getBroadcastType", "()I", BroadcastFloorFragment.BROADCAST_TYPE, "broadcastRange$delegate", "getBroadcastRange", BroadcastFloorFragment.BROADCAST_RANGE, "", "userId$delegate", "getUserId", "()Ljava/lang/String;", "userId", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "mChildAttachStateChangeListener", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "visibleToUser", "Z", "getVisibleToUser", "()Z", "setVisibleToUser", "(Z)V", BaseSearchResultFragment.NEED_REFRESH_KEY, "getNeedRefresh", "setNeedRefresh", "hasLoadData", "getHasLoadData", "setHasLoadData", "<init>", "()V", "Companion", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class BroadcastFloorFragment extends BaseMVVMFragment<WorksFragmentBroadcastFloorBinding, BroadcastFloorListVM> {

    @NotNull
    public static final String BROADCAST_RANGE = "broadcastRange";

    @NotNull
    public static final String BROADCAST_TYPE = "broadcastType";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private boolean hasLoadData;
    private boolean needRefresh;
    private boolean visibleToUser;

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.o01
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            BroadcastFloorFragment.onRefreshListener$lambda$0(this.f43638a);
        }
    };

    /* JADX INFO: renamed from: broadcastType$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy broadcastType = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.broadcast_floor.BroadcastFloorFragment$broadcastType$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m865invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt(BroadcastFloorFragment.BROADCAST_TYPE) : 0);
        }
    });

    /* JADX INFO: renamed from: broadcastRange$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy broadcastRange = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.broadcast_floor.BroadcastFloorFragment$broadcastRange$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m864invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt(BroadcastFloorFragment.BROADCAST_RANGE) : 0);
        }
    });

    /* JADX INFO: renamed from: userId$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy userId = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.works.page.broadcast_floor.BroadcastFloorFragment$userId$2
        @NotNull
        public final String invoke() {
            return ai9.e().getUserId();
        }
    });

    @NotNull
    private final RecyclerView.OnChildAttachStateChangeListener mChildAttachStateChangeListener = new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.huachenjie.works.page.broadcast_floor.BroadcastFloorFragment$mChildAttachStateChangeListener$1
        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(@NotNull View view) {
            RecyclerView recyclerView;
            RecyclerView.LayoutManager layoutManager;
            Intrinsics.checkNotNullParameter(view, "view");
            WorksFragmentBroadcastFloorBinding worksFragmentBroadcastFloorBindingAccess$getMBinding = BroadcastFloorFragment.access$getMBinding(this.f37205a);
            if (worksFragmentBroadcastFloorBindingAccess$getMBinding == null || (recyclerView = worksFragmentBroadcastFloorBindingAccess$getMBinding.f36902a) == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
                return;
            }
            int position = layoutManager.getPosition(view);
            i4a.a("onChildViewDetachedFromWindow:" + position);
            BroadcastFloorAdapter value = this.f37205a.getMViewModel().i().getValue();
            if (value == null) {
                return;
            }
            boolean z = false;
            if (position >= 0 && position < value.getData().size()) {
                z = true;
            }
            if (z) {
                BroadcastFloorMessageBean broadcastFloorMessageBean = value.getData().get(position);
                if (f64.b().f(m55.c(broadcastFloorMessageBean.formatAudioUrl()))) {
                    hg0.f42120a.b(view, broadcastFloorMessageBean);
                }
            }
        }
    };

    /* JADX INFO: renamed from: com.huachenjie.works.page.broadcast_floor.BroadcastFloorFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/huachenjie/works/page/broadcast_floor/BroadcastFloorFragment$a;", "", "", BroadcastFloorFragment.BROADCAST_RANGE, BroadcastFloorFragment.BROADCAST_TYPE, "Lcom/huachenjie/works/page/broadcast_floor/BroadcastFloorFragment;", "a", "", "BROADCAST_RANGE", "Ljava/lang/String;", "BROADCAST_TYPE", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BroadcastFloorFragment a(int broadcastRange, int broadcastType) {
            BroadcastFloorFragment broadcastFloorFragment = new BroadcastFloorFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(BroadcastFloorFragment.BROADCAST_RANGE, broadcastRange);
            bundle.putInt(BroadcastFloorFragment.BROADCAST_TYPE, broadcastType);
            broadcastFloorFragment.setArguments(bundle);
            return broadcastFloorFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37204a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37204a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37204a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37204a.invoke(obj);
        }
    }

    public static final /* synthetic */ WorksFragmentBroadcastFloorBinding access$getMBinding(BroadcastFloorFragment broadcastFloorFragment) {
        return broadcastFloorFragment.getMBinding();
    }

    private final void checkVisible() {
        if (this.visibleToUser && isAdded()) {
            if (!this.hasLoadData || this.needRefresh) {
                this.needRefresh = false;
                this.hasLoadData = true;
                getMViewModel().r();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View findViewContainerByPosition(int position) {
        RecyclerView recyclerView;
        WorksFragmentBroadcastFloorBinding mBinding = getMBinding();
        if (mBinding == null || (recyclerView = mBinding.f36902a) == null) {
            return null;
        }
        RecyclerView.ViewHolder viewHolderFindViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(position);
        View view = viewHolderFindViewHolderForLayoutPosition != null ? viewHolderFindViewHolderForLayoutPosition.itemView : null;
        if (view == null) {
            i4a.a("mLayoutView is null");
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(position);
            view = viewHolderFindViewHolderForAdapterPosition != null ? viewHolderFindViewHolderForAdapterPosition.itemView : null;
        }
        if (view == null) {
            i4a.a("mAdapterView is null");
        }
        return view;
    }

    private final int getBroadcastRange() {
        return ((Number) this.broadcastRange.getValue()).intValue();
    }

    private final int getBroadcastType() {
        return ((Number) this.broadcastType.getValue()).intValue();
    }

    private final String getUserId() {
        return (String) this.userId.getValue();
    }

    private final void initAdapter() {
        WorksFragmentBroadcastFloorBinding mBinding = getMBinding();
        if (mBinding != null) {
            final BroadcastFloorAdapter broadcastFloorAdapter = new BroadcastFloorAdapter(getBroadcastType() == 1);
            broadcastFloorAdapter.g(LayoutInflater.from(mBinding.getRoot().getContext()).inflate(R.layout.layout_empty_data, (ViewGroup) null));
            broadcastFloorAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.l01
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    BroadcastFloorFragment.initAdapter$lambda$6$lambda$5$lambda$1(this.f42957a);
                }
            });
            broadcastFloorAdapter.addChildClickViewIds(R.id.ivAvatar, R.id.llAudio, R.id.llComment);
            broadcastFloorAdapter.setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.zj.adlib.m01
                @Override // com.chad.library.adapter.base.listener.OnItemLongClickListener
                public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    return BroadcastFloorFragment.initAdapter$lambda$6$lambda$5$lambda$3(broadcastFloorAdapter, this, baseQuickAdapter, view, i);
                }
            });
            y57.b(broadcastFloorAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.n01
                @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    BroadcastFloorFragment.initAdapter$lambda$6$lambda$5$lambda$4(broadcastFloorAdapter, this, baseQuickAdapter, view, i);
                }
            }, 1, null);
            getMViewModel().i().setValue(broadcastFloorAdapter);
            mBinding.f36902a.addOnChildAttachStateChangeListener(this.mChildAttachStateChangeListener);
            StateLayout stateLayout = mBinding.f14182a;
            Intrinsics.checkNotNullExpressionValue(stateLayout, "stateLayout");
            StateLayout.showLoading$default(stateLayout, null, false, false, 7, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$6$lambda$5$lambda$1(BroadcastFloorFragment broadcastFloorFragment) {
        Intrinsics.checkNotNullParameter(broadcastFloorFragment, "this$0");
        broadcastFloorFragment.getMViewModel().p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initAdapter$lambda$6$lambda$5$lambda$3(BroadcastFloorAdapter broadcastFloorAdapter, BroadcastFloorFragment broadcastFloorFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(broadcastFloorAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(broadcastFloorFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        final BroadcastFloorMessageBean broadcastFloorMessageBean = broadcastFloorAdapter.getData().get(i);
        if (!TextUtils.equals(broadcastFloorMessageBean.getAppUserCode(), broadcastFloorFragment.getUserId()) && broadcastFloorFragment.getActivity() != null) {
            MoreOptDialog.Companion companion = MoreOptDialog.INSTANCE;
            String strE = ys8.e(R.string.works_detail_menu_report);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.works_detail_menu_report)");
            MoreOptDialog moreOptDialogA = companion.a(CollectionsKt.arrayListOf(new MoreOptBean[]{new MoreOptBean(strE, R.drawable.works_ic_detail_report, 0, 4, null)}), new Function2<MoreOptBean, Integer, Unit>() { // from class: com.huachenjie.works.page.broadcast_floor.BroadcastFloorFragment$initAdapter$1$adapter$1$2$1$1
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((MoreOptBean) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull MoreOptBean moreOptBean, int i2) {
                    Intrinsics.checkNotNullParameter(moreOptBean, "<anonymous parameter 0>");
                    ARouter.getInstance().build(RoutePathConstants.SocialContact.d).withString(UserConstants.CHAT_PARAMS.f, broadcastFloorMessageBean.getQuoteNo()).withInt(UserConstants.CHAT_PARAMS.h, 3).withInt(UserConstants.CHAT_PARAMS.e, 3).navigation();
                }
            });
            FragmentActivity activity = broadcastFloorFragment.getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity as FragmentActi…y).supportFragmentManager");
            moreOptDialogA.show(supportFragmentManager, MoreOptDialog.class.getSimpleName());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$6$lambda$5$lambda$4(BroadcastFloorAdapter broadcastFloorAdapter, final BroadcastFloorFragment broadcastFloorFragment, BaseQuickAdapter baseQuickAdapter, View view, final int i) {
        Intrinsics.checkNotNullParameter(broadcastFloorAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(broadcastFloorFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        final BroadcastFloorMessageBean broadcastFloorMessageBean = broadcastFloorAdapter.getData().get(i);
        int id = view.getId();
        if (id == R.id.ivAvatar) {
            ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", broadcastFloorMessageBean.getAppUserCode()).navigation();
            return;
        }
        if (id == R.id.llAudio) {
            hg0.f42120a.a(view, broadcastFloorMessageBean);
        } else if (id == R.id.llComment) {
            CommentDialog commentDialogA = CommentDialog.INSTANCE.a(2, broadcastFloorMessageBean.getQuoteNo(), broadcastFloorMessageBean.getAppUserCode(), broadcastFloorMessageBean.getCommentCount(), broadcastFloorMessageBean.isMatched() ? 8 : 7, (32 & 32) != 0, (32 & 64) != 0 ? null : new Function1<Integer, Unit>() { // from class: com.huachenjie.works.page.broadcast_floor.BroadcastFloorFragment$initAdapter$1$adapter$1$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2) {
                    TextView textView;
                    if (broadcastFloorMessageBean.getCommentCount() != i2) {
                        broadcastFloorMessageBean.setCommentCount(i2);
                        View viewFindViewContainerByPosition = broadcastFloorFragment.findViewContainerByPosition(i);
                        if (viewFindViewContainerByPosition == null || (textView = (TextView) viewFindViewContainerByPosition.findViewById(R.id.tvComment)) == null) {
                            return;
                        }
                        textView.setText(broadcastFloorMessageBean.formatCommentCount());
                    }
                }
            });
            FragmentManager childFragmentManager = broadcastFloorFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            commentDialogA.show(childFragmentManager, CommentDialog.class.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(BroadcastFloorFragment broadcastFloorFragment) {
        Intrinsics.checkNotNullParameter(broadcastFloorFragment, "this$0");
        broadcastFloorFragment.getMViewModel().r();
    }

    public final boolean getHasLoadData() {
        return this.hasLoadData;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_broadcast_floor;
    }

    public final boolean getNeedRefresh() {
        return this.needRefresh;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.R), this.onRefreshListener)});
    }

    public final boolean getVisibleToUser() {
        return this.visibleToUser;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().j().setValue(Integer.valueOf(getBroadcastRange()));
        getMViewModel().k().setValue(Integer.valueOf(getBroadcastType()));
        i4a.a("initData-----------------------");
        checkVisible();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        getMViewModel().o().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.works.page.broadcast_floor.BroadcastFloorFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                WorksFragmentBroadcastFloorBinding worksFragmentBroadcastFloorBindingAccess$getMBinding;
                StateLayout stateLayout;
                if (bool.booleanValue() || (worksFragmentBroadcastFloorBindingAccess$getMBinding = BroadcastFloorFragment.access$getMBinding(BroadcastFloorFragment.this)) == null || (stateLayout = worksFragmentBroadcastFloorBindingAccess$getMBinding.f14182a) == null) {
                    return;
                }
                StateLayout.showContent$default(stateLayout, null, 1, null);
            }
        }));
        getMViewModel().l().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.works.page.broadcast_floor.BroadcastFloorFragment.initDataObservable.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                FragmentActivity activity;
                Intrinsics.checkNotNullExpressionValue(bool, o.f);
                if (bool.booleanValue() && (activity = BroadcastFloorFragment.this.getActivity()) != null && (activity instanceof BroadcastFloorActivity)) {
                    ((BroadcastFloorActivity) activity).j0();
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        initAdapter();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        f64.b().a();
        super.onDestroyView();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        f64.b().j();
        super.onPause();
    }

    public final void refresh(int refresh) {
        f64.b().j();
        getMViewModel().j().setValue(Integer.valueOf(refresh));
        getMViewModel().r();
    }

    public final void setHasLoadData(boolean z) {
        this.hasLoadData = z;
    }

    public final void setNeedRefresh(boolean z) {
        this.needRefresh = z;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.visibleToUser = isVisibleToUser;
        if (isVisibleToUser) {
            checkVisible();
        }
        if (isVisibleToUser) {
            return;
        }
        f64.b().j();
    }

    public final void setVisibleToUser(boolean z) {
        this.visibleToUser = z;
    }
}
