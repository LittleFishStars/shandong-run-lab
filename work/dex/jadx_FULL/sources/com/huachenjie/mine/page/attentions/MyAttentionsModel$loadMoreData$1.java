package com.huachenjie.mine.page.attentions;

import com.huachenjie.channel.external.bean.FansBean;
import com.huachenjie.mine.api.RequestModel;
import com.zj.adlib.n0a;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mine.page.attentions.MyAttentionsModel$loadMoreData$1", f = "MyAttentionsModel.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nMyAttentionsModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyAttentionsModel.kt\ncom/huachenjie/mine/page/attentions/MyAttentionsModel$loadMoreData$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,25:1\n766#2:26\n857#2,2:27\n*S KotlinDebug\n*F\n+ 1 MyAttentionsModel.kt\ncom/huachenjie/mine/page/attentions/MyAttentionsModel$loadMoreData$1\n*L\n19#1:26\n19#1:27,2\n*E\n"})
public final class MyAttentionsModel$loadMoreData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MyAttentionsModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyAttentionsModel$loadMoreData$1(MyAttentionsModel myAttentionsModel, Continuation<? super MyAttentionsModel$loadMoreData$1> continuation) {
        super(2, continuation);
        this.this$0 = myAttentionsModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MyAttentionsModel$loadMoreData$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ArrayList arrayList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f35285a;
            int pageNum = this.this$0.getPageNum();
            String refreshTime = this.this$0.getRefreshTime();
            this.label = 1;
            obj = requestModel.g(pageNum, refreshTime, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        PageEntity<?> pageEntity = (PageEntity) obj;
        if (pageEntity != null) {
            List list = pageEntity.getList();
            if (list != null) {
                arrayList = new ArrayList();
                for (Object obj2 : list) {
                    if (n0a.f43422a.l(((FansBean) obj2).getAppUserCode(), true)) {
                        arrayList.add(obj2);
                    }
                }
            } else {
                arrayList = null;
            }
            pageEntity.setList(arrayList);
        }
        this.this$0.u().setValue(pageEntity);
        return Unit.INSTANCE;
    }
}
