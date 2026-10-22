package com.huachenjie.works.page.alumni.original;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.LifecycleOwnerKt;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.OriginalChannelHotspotBean;
import com.huachenjie.works.bean.OriginalPageEntity;
import com.huachenjie.works.databinding.WorksFragmentOriginalChannelSubBinding;
import com.huachenjie.works.page.alumni.original.OriginalChannelSubFragment;
import com.igexin.push.g.o;
import com.zj.adlib.jo2;
import com.zj.adlib.qk0;
import com.zj.adlib.v41;
import com.zj.adlib.y57;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import huachenjie.sdk.http.PageEntity;
import java.util.List;
import java.util.Map;
import kotlin.Function;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001#B\u0007¢\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/huachenjie/works/page/alumni/original/OriginalChannelSubFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/works/databinding/WorksFragmentOriginalChannelSubBinding;", "Lcom/huachenjie/works/page/alumni/original/OriginalChannelSubVM;", "", "initAdapter", "recordRvScroll", "restoreRvScroll", "", "", "", "getVariables", "getLayoutResID", "initView", "initDataObservable", "onResume", "onDestroyView", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "", yj7.g.WORKS_PUBLISH_CATEGORY_NO, "Ljava/lang/String;", "lastOffset", "I", "lastPosition", "Lcom/huachenjie/works/page/alumni/original/OriginalChannelFragment;", "channelFragment$delegate", "Lkotlin/Lazy;", "getChannelFragment", "()Lcom/huachenjie/works/page/alumni/original/OriginalChannelFragment;", "channelFragment", "<init>", "()V", "Companion", "a", "works_release"}, k = 1, mv = {1, 8, 0})
public final class OriginalChannelSubFragment extends BaseMVVMFragment<WorksFragmentOriginalChannelSubBinding, OriginalChannelSubVM> {

    @NotNull
    private static final String CATEGORY_KEY = "category";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int lastOffset;
    private int lastPosition;

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.gf6
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            OriginalChannelSubFragment.onRefreshListener$lambda$0(this.f41890a);
        }
    };

    @NotNull
    private String categoryNo = "";

    /* JADX INFO: renamed from: channelFragment$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy channelFragment = LazyKt.lazy(new Function0<OriginalChannelFragment>() { // from class: com.huachenjie.works.page.alumni.original.OriginalChannelSubFragment$channelFragment$2
        {
            super(0);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final OriginalChannelFragment m855invoke() {
            if (!(this.this$0.getParentFragment() instanceof OriginalChannelFragment)) {
                return null;
            }
            Fragment parentFragment = this.this$0.getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.huachenjie.works.page.alumni.original.OriginalChannelFragment");
            return (OriginalChannelFragment) parentFragment;
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.works.page.alumni.original.OriginalChannelSubFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/huachenjie/works/page/alumni/original/OriginalChannelSubFragment$a;", "", "", yj7.g.WORKS_PUBLISH_CATEGORY_NO, "Lcom/huachenjie/works/page/alumni/original/OriginalChannelSubFragment;", "a", "CATEGORY_KEY", "Ljava/lang/String;", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OriginalChannelSubFragment a(@NotNull String categoryNo) {
            Intrinsics.checkNotNullParameter(categoryNo, yj7.g.WORKS_PUBLISH_CATEGORY_NO);
            OriginalChannelSubFragment originalChannelSubFragment = new OriginalChannelSubFragment();
            Bundle bundle = new Bundle();
            bundle.putString("category", categoryNo);
            originalChannelSubFragment.setArguments(bundle);
            return originalChannelSubFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f37183a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f37183a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f37183a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f37183a.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.alumni.original.OriginalChannelSubFragment$restoreRvScroll$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.works.page.alumni.original.OriginalChannelSubFragment$restoreRvScroll$1", f = "OriginalChannelSubFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C14791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C14791(Continuation<? super C14791> continuation) {
            super(2, continuation);
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return OriginalChannelSubFragment.this.new C14791(continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            OriginalPageEntity originalPageEntityQueryCachePageEntity;
            RecyclerView recyclerView;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            OriginalChannelFragment channelFragment = OriginalChannelSubFragment.this.getChannelFragment();
            if (channelFragment == null || (originalPageEntityQueryCachePageEntity = channelFragment.queryCachePageEntity(OriginalChannelSubFragment.this.categoryNo)) == null) {
                return Unit.INSTANCE;
            }
            WorksFragmentOriginalChannelSubBinding worksFragmentOriginalChannelSubBindingAccess$getMBinding = OriginalChannelSubFragment.access$getMBinding(OriginalChannelSubFragment.this);
            RecyclerView.LayoutManager layoutManager = (worksFragmentOriginalChannelSubBindingAccess$getMBinding == null || (recyclerView = worksFragmentOriginalChannelSubBindingAccess$getMBinding.f36921a) == null) ? null : recyclerView.getLayoutManager();
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (linearLayoutManager == null) {
                return Unit.INSTANCE;
            }
            linearLayoutManager.scrollToPositionWithOffset(originalPageEntityQueryCachePageEntity.getPosition(), originalPageEntityQueryCachePageEntity.getOffset());
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ WorksFragmentOriginalChannelSubBinding access$getMBinding(OriginalChannelSubFragment originalChannelSubFragment) {
        return originalChannelSubFragment.getMBinding();
    }

    public static final /* synthetic */ OriginalChannelSubVM access$getMViewModel(OriginalChannelSubFragment originalChannelSubFragment) {
        return originalChannelSubFragment.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OriginalChannelFragment getChannelFragment() {
        return (OriginalChannelFragment) this.channelFragment.getValue();
    }

    private final void initAdapter() {
        final OriginalChannelSubAdapter value = getMViewModel().B().getValue();
        if (value != null) {
            value.h(Intrinsics.areEqual(this.categoryNo, "-1"));
            OriginalChannelSubVM mViewModel = getMViewModel();
            WorksFragmentOriginalChannelSubBinding mBinding = getMBinding();
            Intrinsics.checkNotNull(mBinding);
            StateLayout stateLayout = mBinding.f14231a;
            Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding!!.stateLayout");
            mViewModel.o(this, stateLayout, value, getMViewModel().u().getValue() == null);
            BaseStateRequestModel.n(getMViewModel(), this, value, false, 4, null);
            value.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.hf6
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    OriginalChannelSubFragment.initAdapter$lambda$3$lambda$1(this.f42116a);
                }
            });
            y57.d(value, 0L, new OnItemClickListener() { // from class: com.zj.adlib.if6
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    OriginalChannelSubFragment.initAdapter$lambda$3$lambda$2(value, baseQuickAdapter, view, i);
                }
            }, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$3$lambda$1(OriginalChannelSubFragment originalChannelSubFragment) {
        Intrinsics.checkNotNullParameter(originalChannelSubFragment, "this$0");
        BaseStateRequestModel.x(originalChannelSubFragment.getMViewModel(), false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$3$lambda$2(OriginalChannelSubAdapter originalChannelSubAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(originalChannelSubAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        ARouter.getInstance().build(zj7.b.CHANNEL_MAIN).withString("channelNo", originalChannelSubAdapter.getData().get(i).getChannelNo()).navigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(OriginalChannelSubFragment originalChannelSubFragment) {
        Intrinsics.checkNotNullParameter(originalChannelSubFragment, "this$0");
        originalChannelSubFragment.getMViewModel().y();
    }

    private final void recordRvScroll() {
        WorksFragmentOriginalChannelSubBinding mBinding;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        WorksFragmentOriginalChannelSubBinding mBinding2 = getMBinding();
        RecyclerView.LayoutManager layoutManager = (mBinding2 == null || (recyclerView2 = mBinding2.f36921a) == null) ? null : recyclerView2.getLayoutManager();
        final LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || (mBinding = getMBinding()) == null || (recyclerView = mBinding.f36921a) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.huachenjie.works.page.alumni.original.OriginalChannelSubFragment.recordRvScroll.1
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
        v41.e(LifecycleOwnerKt.getLifecycleScope(this), jo2.e(), (CoroutineStart) null, new C14791(null), 2, (Object) null);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.works_fragment_original_channel_sub;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(qk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(qk0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        super.initDataObservable();
        getMViewModel().u().observe(this, new b(new Function1<PageEntity<?>, Unit>() { // from class: com.huachenjie.works.page.alumni.original.OriginalChannelSubFragment.initDataObservable.1

            /* JADX INFO: renamed from: com.huachenjie.works.page.alumni.original.OriginalChannelSubFragment$initDataObservable$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
            @DebugMetadata(c = "com.huachenjie.works.page.alumni.original.OriginalChannelSubFragment$initDataObservable$1$1", f = "OriginalChannelSubFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C08301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PageEntity<?> $it;
                int label;
                final /* synthetic */ OriginalChannelSubFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C08301(PageEntity<?> pageEntity, OriginalChannelSubFragment originalChannelSubFragment, Continuation<? super C08301> continuation) {
                    super(2, continuation);
                    this.$it = pageEntity;
                    this.this$0 = originalChannelSubFragment;
                }

                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C08301(this.$it, this.this$0, continuation);
                }

                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    List<OriginalChannelHotspotBean> list;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    PageEntity<?> pageEntity = this.$it;
                    OriginalChannelSubAdapter value = OriginalChannelSubFragment.access$getMViewModel(this.this$0).B().getValue();
                    if (value == null || (list = value.getData()) == null) {
                        list = this.$it.getList();
                    }
                    pageEntity.setList(list);
                    PageEntity<?> pageEntity2 = this.$it;
                    Intrinsics.checkNotNull(pageEntity2, "null cannot be cast to non-null type com.huachenjie.works.bean.OriginalPageEntity");
                    ((OriginalPageEntity) pageEntity2).setOffset(this.this$0.lastOffset);
                    ((OriginalPageEntity) this.$it).setPosition(this.this$0.lastPosition);
                    OriginalChannelFragment channelFragment = this.this$0.getChannelFragment();
                    if (channelFragment != null) {
                        String str = this.this$0.categoryNo;
                        PageEntity<?> pageEntity3 = this.$it;
                        Intrinsics.checkNotNullExpressionValue(pageEntity3, o.f);
                        channelFragment.saveCachePageEntity(str, (OriginalPageEntity) pageEntity3);
                    }
                    return Unit.INSTANCE;
                }
            }

            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PageEntity<?>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PageEntity<?> pageEntity) {
                v41.e(LifecycleOwnerKt.getLifecycleScope(OriginalChannelSubFragment.this), jo2.e(), (CoroutineStart) null, new C08301(pageEntity, OriginalChannelSubFragment.this, null), 2, (Object) null);
            }
        }));
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
        getChannelFragment();
        getMViewModel().D(getChannelFragment());
        initAdapter();
        recordRvScroll();
        restoreRvScroll();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        PageEntity<?> value = getMViewModel().u().getValue();
        if (value instanceof OriginalPageEntity) {
            OriginalPageEntity originalPageEntity = (OriginalPageEntity) value;
            originalPageEntity.setOffset(this.lastOffset);
            originalPageEntity.setPosition(this.lastPosition);
            OriginalChannelFragment channelFragment = getChannelFragment();
            if (channelFragment != null) {
                channelFragment.saveCachePageEntity(this.categoryNo, originalPageEntity);
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
