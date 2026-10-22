package com.huachenjie.base.works;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.base.R;
import com.huachenjie.base.works.BaseSearchResultFragment;
import com.huachenjie.base.works.BaseSearchResultModel;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.igexin.push.g.o;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 \u001c*\b\b\u0000\u0010\u0002*\u00020\u0001*\f\b\u0001\u0010\u0004*\u0006\u0012\u0002\b\u00030\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u00020\u0006:\u0001\u001dB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0017R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/base/works/BaseSearchResultFragment;", "Landroidx/databinding/ViewDataBinding;", "V", "Lcom/huachenjie/base/works/BaseSearchResultModel;", "VM", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/base/works/ISearchContentChangeListener;", "", "checkNeedRefresh", "initDataObservable", "", "content", "onSearchContentChange", "onResume", "startSearch", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "getOnRefreshListener", "()Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "Lcom/huachenjie/common/page/statelayout/StateLayout;", "stateView$delegate", "Lkotlin/Lazy;", "getStateView", "()Lcom/huachenjie/common/page/statelayout/StateLayout;", "stateView", "<init>", "()V", "Companion", "a", "base_release"}, k = 1, mv = {1, 8, 0})
public abstract class BaseSearchResultFragment<V extends ViewDataBinding, VM extends BaseSearchResultModel<?>> extends BaseMVVMFragment<V, VM> implements ISearchContentChangeListener {

    @NotNull
    public static final String NEED_REFRESH_KEY = "needRefresh";

    @NotNull
    public static final String SEARCH_CONTENT_KEY = "searchContent";

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.qr0
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            BaseSearchResultFragment.onRefreshListener$lambda$0(this.f44286a);
        }
    };

    /* JADX INFO: renamed from: stateView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy stateView = LazyKt.lazy(new Function0<StateLayout>(this) { // from class: com.huachenjie.base.works.BaseSearchResultFragment$stateView$2
        final /* synthetic */ BaseSearchResultFragment<V, VM> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final StateLayout m240invoke() {
            View root;
            ViewDataBinding mBinding = this.this$0.getMBinding();
            if (mBinding == null || (root = mBinding.getRoot()) == null) {
                return null;
            }
            return (StateLayout) root.findViewById(R.id.state_layout);
        }
    });

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33004a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33004a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33004a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33004a.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.base.works.BaseSearchResultFragment$initDataObservable$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\f\b\u0001\u0010\u0004*\u0006\u0012\u0002\b\u00030\u000522\u0010\u0006\u001a.\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b\u0012\u0006\b\u0001\u0012\u00020\t \n*\u0016\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00070\u0007H\n¢\u0006\u0002\b\u000b"}, d2 = {"<anonymous>", "", "V", "Landroidx/databinding/ViewDataBinding;", "VM", "Lcom/huachenjie/base/works/BaseSearchResultModel;", o.f, "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "kotlin.jvm.PlatformType", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends Lambda implements Function1<BaseQuickAdapter<? extends Object, ? extends BaseViewHolder>, Unit> {
        final /* synthetic */ BaseSearchResultFragment<V, VM> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BaseSearchResultFragment<V, VM> baseSearchResultFragment) {
            super(1);
            this.this$0 = baseSearchResultFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(BaseSearchResultFragment baseSearchResultFragment) {
            Intrinsics.checkNotNullParameter(baseSearchResultFragment, "this$0");
            BaseSearchResultFragment.access$getMViewModel(baseSearchResultFragment).w(false);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((BaseQuickAdapter<? extends Object, ? extends BaseViewHolder>) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(BaseQuickAdapter<? extends Object, ? extends BaseViewHolder> baseQuickAdapter) {
            if (this.this$0.getStateView() != null) {
                BaseSearchResultModel baseSearchResultModelAccess$getMViewModel = BaseSearchResultFragment.access$getMViewModel(this.this$0);
                BaseSearchResultFragment<V, VM> baseSearchResultFragment = this.this$0;
                StateLayout stateView = baseSearchResultFragment.getStateView();
                Intrinsics.checkNotNull(stateView);
                baseSearchResultModelAccess$getMViewModel.o(baseSearchResultFragment, stateView, baseQuickAdapter, false);
                StateLayout stateView2 = this.this$0.getStateView();
                Intrinsics.checkNotNull(stateView2);
                stateView2.setEmptyLabel(this.this$0.getString(R.string.base_works_search_search_empty));
            }
            BaseStateRequestModel.n(BaseSearchResultFragment.access$getMViewModel(this.this$0), this.this$0, baseQuickAdapter, false, 4, null);
            BaseLoadMoreModule loadMoreModule = baseQuickAdapter.getLoadMoreModule();
            final BaseSearchResultFragment<V, VM> baseSearchResultFragment2 = this.this$0;
            loadMoreModule.setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.huachenjie.base.works.a
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    BaseSearchResultFragment.AnonymousClass1.invoke$lambda$0(baseSearchResultFragment2);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ BaseSearchResultModel access$getMViewModel(BaseSearchResultFragment baseSearchResultFragment) {
        return (BaseSearchResultModel) baseSearchResultFragment.getMViewModel();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0011  */
    private final void checkNeedRefresh() {
        boolean z;
        String string;
        Bundle arguments = getArguments();
        if (arguments != null) {
            z = arguments.getBoolean(NEED_REFRESH_KEY);
        }
        if (z) {
            Bundle arguments2 = getArguments();
            if (arguments2 != null && (string = arguments2.getString(SEARCH_CONTENT_KEY)) != null) {
                startSearch(string);
            }
            Bundle arguments3 = getArguments();
            if (arguments3 != null) {
                arguments3.putBoolean(NEED_REFRESH_KEY, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StateLayout getStateView() {
        return (StateLayout) this.stateView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onRefreshListener$lambda$0(BaseSearchResultFragment baseSearchResultFragment) {
        Intrinsics.checkNotNullParameter(baseSearchResultFragment, "this$0");
        ((BaseSearchResultModel) baseSearchResultFragment.getMViewModel()).y();
    }

    @NotNull
    public final SwipeRefreshLayout.OnRefreshListener getOnRefreshListener() {
        return this.onRefreshListener;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        super.initDataObservable();
        getMViewModel().B().observe(this, new b(new AnonymousClass1(this)));
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        checkNeedRefresh();
    }

    @Override // com.huachenjie.base.works.ISearchContentChangeListener
    public void onSearchContentChange(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (isVisible()) {
            startSearch(content);
            return;
        }
        if (isAdded() && modelIsInitialized()) {
            getMViewModel().r().setValue(4);
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putString(SEARCH_CONTENT_KEY, content);
        arguments.putBoolean(NEED_REFRESH_KEY, true);
        setArguments(arguments);
    }

    @Override // com.huachenjie.base.works.ISearchContentChangeListener
    @CallSuper
    public void startSearch(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (modelIsInitialized()) {
            getMViewModel().C().setValue(content);
            getMViewModel().r().setValue(4);
            getMViewModel().v().setValue(Boolean.TRUE);
            getMViewModel().y();
            return;
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putString(SEARCH_CONTENT_KEY, content);
        arguments.putBoolean(NEED_REFRESH_KEY, true);
        setArguments(arguments);
    }
}
