package com.huachenjie.home.page.inspiration_record;

import com.huachenjie.home.api.HomeRequest;
import com.huachenjie.home.bean.InspirationRecordBean;
import com.igexin.push.g.o;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.home.page.inspiration_record.InspirationRecordFVM$loadMoreData$1", f = "InspirationRecordFVM.kt", i = {}, l = {24, 26}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nInspirationRecordFVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InspirationRecordFVM.kt\ncom/huachenjie/home/page/inspiration_record/InspirationRecordFVM$loadMoreData$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,52:1\n1855#2,2:53\n*S KotlinDebug\n*F\n+ 1 InspirationRecordFVM.kt\ncom/huachenjie/home/page/inspiration_record/InspirationRecordFVM$loadMoreData$1\n*L\n30#1:53,2\n*E\n"})
public final class InspirationRecordFVM$loadMoreData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InspirationRecordFVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InspirationRecordFVM$loadMoreData$1(InspirationRecordFVM inspirationRecordFVM, Continuation<? super InspirationRecordFVM$loadMoreData$1> continuation) {
        super(2, continuation);
        this.this$0 = inspirationRecordFVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new InspirationRecordFVM$loadMoreData$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objP;
        Object objQ;
        PageEntity<?> pageEntity;
        List<InspirationRecordBean> list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (Intrinsics.areEqual(this.this$0.C().getValue(), Boxing.boxBoolean(true))) {
                HomeRequest homeRequest = HomeRequest.f34197a;
                int pageNum = this.this$0.getPageNum();
                this.label = 1;
                objQ = homeRequest.q(pageNum, this);
                if (objQ == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pageEntity = (PageEntity) objQ;
            } else {
                HomeRequest homeRequest2 = HomeRequest.f34197a;
                int pageNum2 = this.this$0.getPageNum();
                this.label = 2;
                objP = homeRequest2.p(pageNum2, this);
                if (objP == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pageEntity = (PageEntity) objP;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            objQ = obj;
            pageEntity = (PageEntity) objQ;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objP = obj;
            pageEntity = (PageEntity) objP;
        }
        ArrayList arrayList = new ArrayList();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        if (pageEntity != null && (list = pageEntity.getList()) != null) {
            InspirationRecordFVM inspirationRecordFVM = this.this$0;
            for (InspirationRecordBean inspirationRecordBean : list) {
                if (!Intrinsics.areEqual(objectRef.element, inspirationRecordBean.getOccurMonth())) {
                    objectRef.element = inspirationRecordBean.getOccurMonth();
                    arrayList.add(new InspirationRecordBean(0, inspirationRecordBean.getOccurMonth(), null, null, null, null, 0, false, 0L, null, null, null, false, 2, 8189, null));
                }
                Intrinsics.checkNotNullExpressionValue(inspirationRecordBean, o.f);
                arrayList.add(inspirationRecordBean);
                inspirationRecordBean.setItemType(!Intrinsics.areEqual(inspirationRecordFVM.C().getValue(), Boxing.boxBoolean(true)) ? 1 : 0);
                inspirationRecordBean.setHasNext(pageEntity.getHasNext());
            }
        }
        if (pageEntity != null) {
            pageEntity.setList(arrayList);
        }
        this.this$0.u().setValue(pageEntity);
        return Unit.INSTANCE;
    }
}
