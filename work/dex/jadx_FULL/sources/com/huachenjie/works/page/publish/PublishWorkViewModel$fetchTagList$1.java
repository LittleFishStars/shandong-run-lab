package com.huachenjie.works.page.publish;

import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.WorksTagBean;
import huachenjie.sdk.http.PageEntity;
import java.util.Iterator;
import java.util.List;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.publish.PublishWorkViewModel$fetchTagList$1", f = "PublishWorkViewModel.kt", i = {}, l = {256}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nPublishWorkViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PublishWorkViewModel.kt\ncom/huachenjie/works/page/publish/PublishWorkViewModel$fetchTagList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,279:1\n350#2,7:280\n*S KotlinDebug\n*F\n+ 1 PublishWorkViewModel.kt\ncom/huachenjie/works/page/publish/PublishWorkViewModel$fetchTagList$1\n*L\n258#1:280,7\n*E\n"})
public final class PublishWorkViewModel$fetchTagList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $categoryNo;
    final /* synthetic */ String $tagNo;
    int label;
    final /* synthetic */ PublishWorkViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishWorkViewModel$fetchTagList$1(String str, String str2, PublishWorkViewModel publishWorkViewModel, Continuation<? super PublishWorkViewModel$fetchTagList$1> continuation) {
        super(2, continuation);
        this.$categoryNo = str;
        this.$tagNo = str2;
        this.this$0 = publishWorkViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PublishWorkViewModel$fetchTagList$1(this.$categoryNo, this.$tagNo, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f36762a;
            String str = this.$categoryNo;
            this.label = 1;
            obj = requestModel.F0(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        PageEntity pageEntity = (PageEntity) obj;
        List list = pageEntity != null ? pageEntity.getList() : null;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        String str2 = this.$tagNo;
        int i2 = 0;
        if (str2 != null && str2.length() != 0) {
            z = false;
        }
        if (!z) {
            String str3 = this.$tagNo;
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (Intrinsics.areEqual(((WorksTagBean) it.next()).getCode(), str3)) {
                    break;
                }
                i2++;
            }
        } else {
            i2 = -1;
            break;
        }
        this.this$0.I(i2 > -1 ? (WorksTagBean) CollectionsKt.getOrNull(list, i2) : null);
        PublishWorkTagAdapter value = this.this$0.C().getValue();
        if (value != null) {
            value.g(list, i2);
        }
        if (i2 >= 0) {
            this.this$0.t().put(this.$categoryNo, Boxing.boxInt(i2));
        }
        this.this$0.cacheCategoryMap.put(this.$categoryNo, list);
        return Unit.INSTANCE;
    }
}
