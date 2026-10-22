package com.huachenjie.common.reconfig.mvvm;

import androidx.annotation.CallSuper;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import huachenjie.sdk.http.PageEntity;
import java.util.Collection;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bE\u0010FJE\u0010\f\u001a\u00020\u000b\"\u0010\b\u0000\u0010\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ9\u0010\u000f\u001a\u00020\u000b\"\u0010\b\u0000\u0010\u0003*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00028\u00002\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u000bH\u0017J\u0012\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\tH\u0017R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R2\u0010+\u001a\u001d\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\t0\"8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R!\u0010/\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030,0\u001c8\u0006¢\u0006\f\n\u0004\b-\u0010\u001e\u001a\u0004\b.\u0010 R%\u00103\u001a\u0010\u0012\f\u0012\n 0*\u0004\u0018\u00010\t0\t0\u001c8\u0006¢\u0006\f\n\u0004\b1\u0010\u001e\u001a\u0004\b2\u0010 R$\u0010;\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010A\u001a\u00020\t8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b'\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020#0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010\u001eR\u0016\u0010D\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010<¨\u0006G"}, d2 = {"Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "T", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/huachenjie/common/page/statelayout/StateLayout;", "stateView", "adapter", "", RVParams.LONG_SHOW_LOADING, "", j.b, "(Landroidx/lifecycle/LifecycleOwner;Lcom/huachenjie/common/page/statelayout/StateLayout;Lcom/chad/library/adapter/base/BaseQuickAdapter;Z)V", "needShowEmpty", "m", "(Landroidx/lifecycle/LifecycleOwner;Lcom/chad/library/adapter/base/BaseQuickAdapter;Z)V", "y", "isRefreshData", "w", "", "K", "I", "s", "()I", j.o, "(I)V", "pageNum", "Landroidx/lifecycle/MutableLiveData;", "b", "Landroidx/lifecycle/MutableLiveData;", "r", "()Landroidx/lifecycle/MutableLiveData;", "layoutState", "Lkotlin/Function1;", "Lcom/huachenjie/common/reconfig/net/exception/ResultException;", "Lkotlin/ParameterName;", "name", c.f25231a, "a", "Lkotlin/jvm/functions/Function1;", "q", "()Lkotlin/jvm/functions/Function1;", "errorFunc", "Lhuachenjie/sdk/http/PageEntity;", "c", "u", "requestPageData", "kotlin.jvm.PlatformType", "d", "v", "isRefreshing", "", "f", "Ljava/lang/String;", "t", "()Ljava/lang/String;", "A", "(Ljava/lang/String;)V", "refreshTime", "Z", "getShowLoadEndView", "()Z", "setShowLoadEndView", "(Z)V", "showLoadEndView", "e", "errorResult", "isShowedContent", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public class BaseStateRequestModel extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    public boolean isShowedContent;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> layoutState = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Function1<ResultException, Boolean> errorFunc = new Function1<ResultException, Boolean>() { // from class: com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel$errorFunc$1
        {
            super(1);
        }

        @NotNull
        public final Boolean invoke(@NotNull ResultException resultException) {
            Intrinsics.checkNotNullParameter(resultException, o.f);
            this.this$0.errorResult.setValue(resultException);
            MutableLiveData<Boolean> mutableLiveDataV = this.this$0.v();
            Boolean bool = Boolean.FALSE;
            mutableLiveDataV.setValue(bool);
            return bool;
        }
    };

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<PageEntity<?>> requestPageData = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean showLoadEndView = true;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ResultException> errorResult = new MutableLiveData<>();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33862a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33862a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33862a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33862a.invoke(obj);
        }
    }

    public static /* synthetic */ void n(BaseStateRequestModel baseStateRequestModel, LifecycleOwner lifecycleOwner, BaseQuickAdapter baseQuickAdapter, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindAdapterDataObserver");
        }
        if ((i & 4) != 0) {
            z = true;
        }
        baseStateRequestModel.m(lifecycleOwner, baseQuickAdapter, z);
    }

    public static /* synthetic */ void p(BaseStateRequestModel baseStateRequestModel, LifecycleOwner lifecycleOwner, StateLayout stateLayout, BaseQuickAdapter baseQuickAdapter, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindStateView");
        }
        if ((i & 4) != 0) {
            baseQuickAdapter = null;
        }
        if ((i & 8) != 0) {
            z = true;
        }
        baseStateRequestModel.o(lifecycleOwner, stateLayout, baseQuickAdapter, z);
    }

    public static /* synthetic */ void x(BaseStateRequestModel baseStateRequestModel, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadMoreData");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        baseStateRequestModel.w(z);
    }

    public final void A(@Nullable String str) {
        this.refreshTime = str;
    }

    public final boolean getShowLoadEndView() {
        return this.showLoadEndView;
    }

    public final <T extends BaseQuickAdapter<?, ?>> void m(@NotNull LifecycleOwner owner, @NotNull final T adapter, final boolean needShowEmpty) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.requestPageData.observe(owner, new a(new Function1<PageEntity<?>, Unit>() { // from class: com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel$bindAdapterDataObserver$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (TT;Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;Z)V */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PageEntity<?>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PageEntity<?> pageEntity) {
                BaseQuickAdapter baseQuickAdapter = adapter;
                BaseStateRequestModel baseStateRequestModel = this;
                boolean z = needShowEmpty;
                if (pageEntity == null) {
                    return;
                }
                if (pageEntity.getPageNum() == 1) {
                    List list = pageEntity.getList();
                    Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.Collection<kotlin.Nothing>");
                    baseQuickAdapter.setList(list);
                    baseStateRequestModel.v().setValue(Boolean.FALSE);
                } else {
                    List list2 = pageEntity.getList();
                    Intrinsics.checkNotNull(list2, "null cannot be cast to non-null type kotlin.collections.Collection<kotlin.Nothing>");
                    baseQuickAdapter.addData((Collection) list2);
                    if (baseQuickAdapter instanceof LoadMoreModule) {
                        baseQuickAdapter.getLoadMoreModule().loadMoreComplete();
                    }
                }
                baseStateRequestModel.A(pageEntity.getRefreshTime());
                if (!pageEntity.getHasNext() && (baseQuickAdapter instanceof LoadMoreModule)) {
                    baseQuickAdapter.getLoadMoreModule().loadMoreEnd(!baseStateRequestModel.getShowLoadEndView());
                }
                if (z && baseQuickAdapter.getData().isEmpty()) {
                    baseStateRequestModel.r().setValue(2);
                } else {
                    baseStateRequestModel.r().setValue(1);
                }
            }
        }));
    }

    public final <T extends BaseQuickAdapter<?, ?>> void o(@NotNull LifecycleOwner owner, @NotNull final StateLayout stateView, @Nullable final T adapter, boolean showLoading) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(stateView, "stateView");
        this.layoutState.observe(owner, new a(new Function1<Integer, Unit>() { // from class: com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel$bindStateView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code duplicated, block: B:8:0x000d  */
            public final void invoke(Integer num) {
                boolean z;
                BaseStateRequestModel baseStateRequestModel = this.this$0;
                if (num != null) {
                    z = num.intValue() == 1;
                }
                baseStateRequestModel.isShowedContent = z;
                StateLayout stateLayout = stateView;
                Intrinsics.checkNotNullExpressionValue(num, o.f);
                stateLayout.setState(num.intValue());
            }
        }));
        if (showLoading) {
            this.layoutState.setValue(4);
        }
        this.errorResult.observe(owner, new a(new Function1<ResultException, Unit>() { // from class: com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel$bindStateView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (TT;Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;Lcom/huachenjie/common/page/statelayout/StateLayout;)V */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ResultException) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ResultException resultException) {
                if (adapter == null || !this.isShowedContent) {
                    StateLayout.showError$default(stateView, null, 1, null);
                    return;
                }
                if (this.getPageNum() > 1) {
                    BaseStateRequestModel baseStateRequestModel = this;
                    baseStateRequestModel.z(baseStateRequestModel.getPageNum() - 1);
                }
                BaseQuickAdapter baseQuickAdapter = adapter;
                if (baseQuickAdapter instanceof LoadMoreModule) {
                    baseQuickAdapter.getLoadMoreModule().loadMoreFail();
                }
            }
        }));
    }

    @NotNull
    public final Function1<ResultException, Boolean> q() {
        return this.errorFunc;
    }

    @NotNull
    public final MutableLiveData<Integer> r() {
        return this.layoutState;
    }

    /* JADX INFO: renamed from: s, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    public final void setShowLoadEndView(boolean z) {
        this.showLoadEndView = z;
    }

    @Nullable
    /* JADX INFO: renamed from: t, reason: from getter */
    public final String getRefreshTime() {
        return this.refreshTime;
    }

    @NotNull
    public final MutableLiveData<PageEntity<?>> u() {
        return this.requestPageData;
    }

    @NotNull
    public final MutableLiveData<Boolean> v() {
        return this.isRefreshing;
    }

    @CallSuper
    public void w(boolean isRefreshData) {
        if (isRefreshData) {
            return;
        }
        this.pageNum++;
    }

    @CallSuper
    public void y() {
        this.pageNum = 1;
        this.refreshTime = null;
        w(true);
    }

    public final void z(int i) {
        this.pageNum = i;
    }
}
