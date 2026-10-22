package com.huachenjie.mine.page.home.work;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.ViewModelKt;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.mine.api.RequestModel;
import com.huachenjie.works.external.adapter.WorksAdapter;
import com.huachenjie.works.external.base.BaseWorksListVM;
import com.huachenjie.works.external.bean.WorkItemBean;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.zj.adlib.v41;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J5\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002R%\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00050\u00050\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R%\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00160\u00160\u000f8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R%\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00070\u00070\u000f8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014R%\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00160\u00160\u000f8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/huachenjie/mine/page/home/work/MyWorksVM;", "Lcom/huachenjie/works/external/base/BaseWorksListVM;", "", "A", "p", "", "pageNum", "", "refreshTime", "Lcom/huachenjie/works/external/bean/WorkItemBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "Lhuachenjie/sdk/http/PageEntity;", "q", "(ILjava/lang/String;Lcom/huachenjie/works/external/bean/WorkItemBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "B", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "c", "Landroidx/lifecycle/MutableLiveData;", j.o, "()Landroidx/lifecycle/MutableLiveData;", "typeFlag", "", "d", "x", "onFriendPage", "e", "w", "appUserCode", "f", "y", "showQueryDraft", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMyWorksVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyWorksVM.kt\ncom/huachenjie/mine/page/home/work/MyWorksVM\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n1#1,145:1\n48#2,4:146\n48#2,4:150\n*S KotlinDebug\n*F\n+ 1 MyWorksVM.kt\ncom/huachenjie/mine/page/home/work/MyWorksVM\n*L\n38#1:146,4\n74#1:150,4\n*E\n"})
public final class MyWorksVM extends BaseWorksListVM {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> typeFlag = new MutableLiveData<>(-1);

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> onFriendPage;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> appUserCode;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showQueryDraft;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/c$a", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", c.f25231a, "", "k0", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n+ 2 MyWorksVM.kt\ncom/huachenjie/mine/page/home/work/MyWorksVM\n*L\n1#1,110:1\n40#2:111\n*E\n"})
    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.b bVar) {
            super(bVar);
        }

        public void k0(@NotNull CoroutineContext context, @NotNull Throwable exception) {
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/c$a", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", c.f25231a, "", "k0", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n+ 2 MyWorksVM.kt\ncom/huachenjie/mine/page/home/work/MyWorksVM\n*L\n1#1,110:1\n75#2,2:111\n*E\n"})
    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MyWorksVM f35404a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CoroutineExceptionHandler.b bVar, MyWorksVM myWorksVM) {
            super(bVar);
            this.f35404a = myWorksVM;
        }

        public void k0(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            MyWorksVM.C(this.f35404a, null, 1, null);
        }
    }

    public MyWorksVM() {
        Boolean bool = Boolean.FALSE;
        this.onFriendPage = new MutableLiveData<>(bool);
        this.appUserCode = new MutableLiveData<>("");
        this.showQueryDraft = new MutableLiveData<>(bool);
    }

    public static /* synthetic */ void C(MyWorksVM myWorksVM, WorkItemBean workItemBean, int i, Object obj) {
        if ((i & 1) != 0) {
            workItemBean = null;
        }
        myWorksVM.B(workItemBean);
    }

    public final void A() {
        WorksAdapter value;
        if (Intrinsics.areEqual(l().getValue(), Boolean.TRUE) || (value = i().getValue()) == null) {
            return;
        }
        v41.e(ViewModelKt.getViewModelScope(this), new a(CoroutineExceptionHandler.a), (CoroutineStart) null, new MyWorksVM$queryDraftSize$2(value, null), 2, (Object) null);
    }

    public final void B(WorkItemBean bean) {
        l().setValue(Boolean.TRUE);
        t(1);
        u(null);
        n(bean);
    }

    @Override // com.huachenjie.works.external.base.BaseWorksListVM
    public void p() {
        if (Intrinsics.areEqual(this.showQueryDraft.getValue(), Boolean.TRUE)) {
            v41.e(ViewModelKt.getViewModelScope(this), new b(CoroutineExceptionHandler.a, this), (CoroutineStart) null, new MyWorksVM$refreshList$2(this, null), 2, (Object) null);
        } else {
            C(this, null, 1, null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.huachenjie.works.external.base.BaseWorksListVM
    @Nullable
    public Object q(int i, @Nullable String str, @Nullable WorkItemBean workItemBean, @NotNull Continuation<? super PageEntity<WorkItemBean>> continuation) {
        MyWorksVM$requestList$1 myWorksVM$requestList$1;
        PageEntity pageEntity;
        if (continuation instanceof MyWorksVM$requestList$1) {
            myWorksVM$requestList$1 = (MyWorksVM$requestList$1) continuation;
            int i2 = myWorksVM$requestList$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                myWorksVM$requestList$1.label = i2 - Integer.MIN_VALUE;
            } else {
                myWorksVM$requestList$1 = new MyWorksVM$requestList$1(this, continuation);
            }
        } else {
            myWorksVM$requestList$1 = new MyWorksVM$requestList$1(this, continuation);
        }
        Object objU = myWorksVM$requestList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = myWorksVM$requestList$1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objU);
            pageEntity = null;
            if (!Intrinsics.areEqual(this.onFriendPage.getValue(), Boxing.boxBoolean(true)) || !TextUtils.isEmpty(this.appUserCode.getValue())) {
                Integer value = this.typeFlag.getValue();
                if (value != null && value.intValue() == 1) {
                    RequestModel requestModel = RequestModel.f35285a;
                    String value2 = this.appUserCode.getValue();
                    myWorksVM$requestList$1.L$0 = workItemBean;
                    myWorksVM$requestList$1.label = 1;
                    objU = requestModel.A(i, str, value2, myWorksVM$requestList$1);
                    if (objU == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pageEntity = (PageEntity) objU;
                } else if (value != null && value.intValue() == 2) {
                    RequestModel requestModel2 = RequestModel.f35285a;
                    String value3 = this.appUserCode.getValue();
                    myWorksVM$requestList$1.L$0 = workItemBean;
                    myWorksVM$requestList$1.label = 2;
                    objU = requestModel2.s(i, str, value3, myWorksVM$requestList$1);
                    if (objU == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pageEntity = (PageEntity) objU;
                } else if (value != null && value.intValue() == 3) {
                    RequestModel requestModel3 = RequestModel.f35285a;
                    String value4 = this.appUserCode.getValue();
                    myWorksVM$requestList$1.L$0 = workItemBean;
                    myWorksVM$requestList$1.label = 3;
                    objU = requestModel3.u(i, str, value4, myWorksVM$requestList$1);
                    if (objU == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pageEntity = (PageEntity) objU;
                }
            }
        } else if (i3 == 1) {
            workItemBean = (WorkItemBean) myWorksVM$requestList$1.L$0;
            ResultKt.throwOnFailure(objU);
            pageEntity = (PageEntity) objU;
        } else if (i3 == 2) {
            workItemBean = (WorkItemBean) myWorksVM$requestList$1.L$0;
            ResultKt.throwOnFailure(objU);
            pageEntity = (PageEntity) objU;
        } else {
            if (i3 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            WorkItemBean workItemBean2 = (WorkItemBean) myWorksVM$requestList$1.L$0;
            ResultKt.throwOnFailure(objU);
            workItemBean = workItemBean2;
            pageEntity = (PageEntity) objU;
        }
        if (pageEntity == null) {
            pageEntity = new PageEntity();
            pageEntity.setList(new ArrayList());
            pageEntity.setHasNext(false);
        }
        if (workItemBean != null) {
            if (pageEntity.getList() == null) {
                pageEntity.setList(new ArrayList());
            }
            if (pageEntity.getList().isEmpty()) {
                pageEntity.setList(CollectionsKt.listOf(workItemBean));
            } else {
                pageEntity.getList().add(0, workItemBean);
            }
        }
        return pageEntity;
    }

    @NotNull
    public final MutableLiveData<String> w() {
        return this.appUserCode;
    }

    @NotNull
    public final MutableLiveData<Boolean> x() {
        return this.onFriendPage;
    }

    @NotNull
    public final MutableLiveData<Boolean> y() {
        return this.showQueryDraft;
    }

    @NotNull
    public final MutableLiveData<Integer> z() {
        return this.typeFlag;
    }
}
