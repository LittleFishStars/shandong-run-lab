package com.huachenjie.mine.page.dressing_table.tag;

import com.huachenjie.mine.api.RequestModel;
import com.huachenjie.works.bean.InterestTag;
import java.util.ArrayList;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mine.page.dressing_table.tag.UserTagVM$settingTags$1", f = "UserTagVM.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nUserTagVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserTagVM.kt\ncom/huachenjie/mine/page/dressing_table/tag/UserTagVM$settingTags$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,47:1\n1549#2:48\n1620#2,3:49\n*S KotlinDebug\n*F\n+ 1 UserTagVM.kt\ncom/huachenjie/mine/page/dressing_table/tag/UserTagVM$settingTags$1\n*L\n42#1:48\n42#1:49,3\n*E\n"})
public final class UserTagVM$settingTags$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ UserTagVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserTagVM$settingTags$1(UserTagVM userTagVM, Continuation<? super UserTagVM$settingTags$1> continuation) {
        super(2, continuation);
        this.this$0 = userTagVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UserTagVM$settingTags$1(this.this$0, continuation);
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
            List<InterestTag> listJ = this.this$0.j();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listJ, 10));
            Iterator<T> it = listJ.iterator();
            while (it.hasNext()) {
                arrayList.add(((InterestTag) it.next()).getTagNo());
            }
            RequestModel requestModel = RequestModel.f35285a;
            this.label = 1;
            if (requestModel.K(arrayList, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.k().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
