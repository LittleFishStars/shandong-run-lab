package com.huachenjie.works.page.search.hot_spot;

import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.search.SearchHotSpotBean;
import com.huachenjie.works.bean.search.SearchHotSpotItemBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.search.hot_spot.SearchHotSpotModel$requestHotSpot$1", f = "SearchHotSpotModel.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nSearchHotSpotModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchHotSpotModel.kt\ncom/huachenjie/works/page/search/hot_spot/SearchHotSpotModel$requestHotSpot$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,68:1\n1864#2,3:69\n*S KotlinDebug\n*F\n+ 1 SearchHotSpotModel.kt\ncom/huachenjie/works/page/search/hot_spot/SearchHotSpotModel$requestHotSpot$1\n*L\n59#1:69,3\n*E\n"})
public final class SearchHotSpotModel$requestHotSpot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SearchHotSpotModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchHotSpotModel$requestHotSpot$1(SearchHotSpotModel searchHotSpotModel, Continuation<? super SearchHotSpotModel$requestHotSpot$1> continuation) {
        super(2, continuation);
        this.this$0 = searchHotSpotModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SearchHotSpotModel$requestHotSpot$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f36762a;
            this.label = 1;
            obj = requestModel.A0(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        SearchHotSpotBean searchHotSpotBean = (SearchHotSpotBean) obj;
        if (searchHotSpotBean == null) {
            return Unit.INSTANCE;
        }
        int i2 = 0;
        for (Object obj2 : searchHotSpotBean.getList()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ((SearchHotSpotItemBean) obj2).setIndexFormat(String.valueOf(i3));
            i2 = i3;
        }
        this.this$0.I().setValue(searchHotSpotBean);
        this.this$0.r().setValue(Boxing.boxInt(1));
        return Unit.INSTANCE;
    }
}
