package com.huachenjie.works.page.post;

import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.PostCategoryBean;
import huachenjie.sdk.http.PageEntity;
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
@DebugMetadata(c = "com.huachenjie.works.page.post.PublishPostVM$queryTagList$1", f = "PublishPostVM.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nPublishPostVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PublishPostVM.kt\ncom/huachenjie/works/page/post/PublishPostVM$queryTagList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,171:1\n1864#2,3:172\n*S KotlinDebug\n*F\n+ 1 PublishPostVM.kt\ncom/huachenjie/works/page/post/PublishPostVM$queryTagList$1\n*L\n58#1:172,3\n*E\n"})
public final class PublishPostVM$queryTagList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $selTagCode;
    int label;
    final /* synthetic */ PublishPostVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishPostVM$queryTagList$1(PublishPostVM publishPostVM, String str, Continuation<? super PublishPostVM$queryTagList$1> continuation) {
        super(2, continuation);
        this.this$0 = publishPostVM;
        this.$selTagCode = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PublishPostVM$queryTagList$1(this.this$0, this.$selTagCode, continuation);
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
            String strP = this.this$0.getPostType();
            if (strP == null) {
                strP = "";
            }
            this.label = 1;
            obj = requestModel.a0(strP, this);
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
        if (pageEntity == null) {
            return Unit.INSTANCE;
        }
        PublishPostAdapter value = this.this$0.m().getValue();
        if (value != null) {
            value.setList(pageEntity.getList());
        }
        List list = pageEntity.getList();
        Intrinsics.checkNotNullExpressionValue(list, "pageEntity.list");
        String str = this.$selTagCode;
        PublishPostVM publishPostVM = this.this$0;
        int i2 = 0;
        for (Object obj2 : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(((PostCategoryBean) obj2).getTagCode(), str)) {
                PublishPostAdapter value2 = publishPostVM.m().getValue();
                if (value2 != null) {
                    value2.e(i2);
                }
                publishPostVM.s().setValue(Boxing.boxInt(i2));
            }
            i2 = i3;
        }
        return Unit.INSTANCE;
    }
}
