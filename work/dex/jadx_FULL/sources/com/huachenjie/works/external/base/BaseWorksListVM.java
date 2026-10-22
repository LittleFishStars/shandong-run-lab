package com.huachenjie.works.external.base;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.works.external.adapter.WorksAdapter;
import com.huachenjie.works.external.bean.WorkItemBean;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.jo2;
import com.zj.adlib.v41;
import huachenjie.sdk.http.PageEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005J9\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eR%\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/huachenjie/works/external/base/BaseWorksListVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "p", "m", "Lcom/huachenjie/works/external/bean/WorkItemBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "n", "", "pageNum", "", "refreshTime", "Lhuachenjie/sdk/http/PageEntity;", "q", "(ILjava/lang/String;Lcom/huachenjie/works/external/bean/WorkItemBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "isRefreshing", "Lcom/huachenjie/works/external/adapter/WorksAdapter;", "b", "i", "adapter", "K", "I", "j", "()I", "t", "(I)V", "f", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "u", "(Ljava/lang/String;)V", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public abstract class BaseWorksListVM extends BaseViewModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>(Boolean.TRUE);

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<WorksAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    public static /* synthetic */ void o(BaseWorksListVM baseWorksListVM, WorkItemBean workItemBean, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryPageList");
        }
        if ((i & 1) != 0) {
            workItemBean = null;
        }
        baseWorksListVM.n(workItemBean);
    }

    public static /* synthetic */ Object r(BaseWorksListVM baseWorksListVM, int i, String str, WorkItemBean workItemBean, Continuation continuation, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestList");
        }
        if ((i2 & 4) != 0) {
            workItemBean = null;
        }
        return baseWorksListVM.q(i, str, workItemBean, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static /* synthetic */ Object s(BaseWorksListVM baseWorksListVM, int i, String str, WorkItemBean workItemBean, Continuation<? super PageEntity<WorkItemBean>> continuation) {
        BaseWorksListVM$requestList$1 baseWorksListVM$requestList$1;
        if (continuation instanceof BaseWorksListVM$requestList$1) {
            baseWorksListVM$requestList$1 = (BaseWorksListVM$requestList$1) continuation;
            int i2 = baseWorksListVM$requestList$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                baseWorksListVM$requestList$1.label = i2 - Integer.MIN_VALUE;
            } else {
                baseWorksListVM$requestList$1 = new BaseWorksListVM$requestList$1(baseWorksListVM, continuation);
            }
        } else {
            baseWorksListVM$requestList$1 = new BaseWorksListVM$requestList$1(baseWorksListVM, continuation);
        }
        Object obj = baseWorksListVM$requestList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = baseWorksListVM$requestList$1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher coroutineDispatcherC = jo2.c();
            BaseWorksListVM$requestList$2 baseWorksListVM$requestList$2 = new BaseWorksListVM$requestList$2(null);
            baseWorksListVM$requestList$1.label = 1;
            if (v41.h(coroutineDispatcherC, baseWorksListVM$requestList$2, baseWorksListVM$requestList$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return null;
    }

    @NotNull
    public final MutableLiveData<WorksAdapter> i() {
        return this.adapter;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    @Nullable
    /* JADX INFO: renamed from: k, reason: from getter */
    public final String getRefreshTime() {
        return this.refreshTime;
    }

    @NotNull
    public final MutableLiveData<Boolean> l() {
        return this.isRefreshing;
    }

    public final void m() {
        this.pageNum++;
        o(this, null, 1, null);
    }

    public final void n(@Nullable final WorkItemBean bean) {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.external.base.BaseWorksListVM$queryPageList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (this.this$0.getPageNum() == 1) {
                    if (bean == null) {
                        WorksAdapter value = this.this$0.i().getValue();
                        if (value != null) {
                            value.setList(null);
                        }
                        WorksAdapter value2 = this.this$0.i().getValue();
                        if (value2 != null) {
                            value2.r();
                        }
                    } else {
                        WorksAdapter value3 = this.this$0.i().getValue();
                        if (value3 != null) {
                            value3.p();
                        }
                        WorksAdapter value4 = this.this$0.i().getValue();
                        if (value4 != null) {
                            value4.setList(CollectionsKt.listOf(bean));
                        }
                    }
                    this.this$0.l().setValue(Boolean.FALSE);
                } else {
                    BaseWorksListVM baseWorksListVM = this.this$0;
                    baseWorksListVM.t(baseWorksListVM.getPageNum() - 1);
                }
                WorksAdapter value5 = this.this$0.i().getValue();
                if (value5 != null && (loadMoreModule = value5.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
                return Boolean.FALSE;
            }
        }, null, new BaseWorksListVM$queryPageList$2(this, bean, null), 11, null);
    }

    public void p() {
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        this.refreshTime = null;
        o(this, null, 1, null);
    }

    @Nullable
    public Object q(int i, @Nullable String str, @Nullable WorkItemBean workItemBean, @NotNull Continuation<? super PageEntity<WorkItemBean>> continuation) {
        return s(this, i, str, workItemBean, continuation);
    }

    public final void t(int i) {
        this.pageNum = i;
    }

    public final void u(@Nullable String str) {
        this.refreshTime = str;
    }
}
