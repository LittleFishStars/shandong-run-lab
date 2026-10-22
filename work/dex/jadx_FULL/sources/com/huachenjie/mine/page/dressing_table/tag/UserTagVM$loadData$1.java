package com.huachenjie.mine.page.dressing_table.tag;

import com.huachenjie.mine.api.RequestModel;
import com.huachenjie.mine.bean.UserTagBean;
import com.huachenjie.works.bean.InterestTag;
import com.huachenjie.works.bean.InterestTagGroupBean;
import com.huachenjie.works.page.alumni.find_alumni.SettingInterestTagsAdapter;
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
@DebugMetadata(c = "com.huachenjie.mine.page.dressing_table.tag.UserTagVM$loadData$1", f = "UserTagVM.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nUserTagVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserTagVM.kt\ncom/huachenjie/mine/page/dressing_table/tag/UserTagVM$loadData$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,47:1\n1855#2:48\n1855#2,2:49\n1856#2:51\n*S KotlinDebug\n*F\n+ 1 UserTagVM.kt\ncom/huachenjie/mine/page/dressing_table/tag/UserTagVM$loadData$1\n*L\n27#1:48\n29#1:49,2\n27#1:51\n*E\n"})
public final class UserTagVM$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ UserTagVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserTagVM$loadData$1(UserTagVM userTagVM, Continuation<? super UserTagVM$loadData$1> continuation) {
        super(2, continuation);
        this.this$0 = userTagVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UserTagVM$loadData$1(this.this$0, continuation);
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
            RequestModel requestModel = RequestModel.f35285a;
            this.label = 1;
            obj = requestModel.E(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        UserTagBean userTagBean = (UserTagBean) obj;
        if (userTagBean == null) {
            return Unit.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        List<InterestTagGroupBean> tagList = userTagBean.getTagList();
        UserTagVM userTagVM = this.this$0;
        for (InterestTagGroupBean interestTagGroupBean : tagList) {
            arrayList.add(new InterestTag(true, null, interestTagGroupBean.getTypeName(), false, 10, null));
            for (InterestTag interestTag : interestTagGroupBean.getList()) {
                if (interestTag.getSelected()) {
                    userTagVM.j().add(interestTag);
                }
                arrayList.add(interestTag);
            }
        }
        SettingInterestTagsAdapter value = this.this$0.i().getValue();
        if (value != null) {
            value.setList(arrayList);
        }
        return Unit.INSTANCE;
    }
}
