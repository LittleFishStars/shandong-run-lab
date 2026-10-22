package com.huachenjie.compat.page.settings;

import com.huachenjie.base.bean.NotifyConfig;
import com.huachenjie.base.bean.NotifyConfigList;
import com.huachenjie.base.bean.NotifySubConfig;
import com.huachenjie.compat.api.CompatNewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.compat.page.settings.PushSettingViewModel$loadData$1", f = "PushSettingViewModel.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nPushSettingViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PushSettingViewModel.kt\ncom/huachenjie/compat/page/settings/PushSettingViewModel$loadData$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,45:1\n1855#2,2:46\n*S KotlinDebug\n*F\n+ 1 PushSettingViewModel.kt\ncom/huachenjie/compat/page/settings/PushSettingViewModel$loadData$1\n*L\n28#1:46,2\n*E\n"})
public final class PushSettingViewModel$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PushSettingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushSettingViewModel$loadData$1(PushSettingViewModel pushSettingViewModel, Continuation<? super PushSettingViewModel$loadData$1> continuation) {
        super(2, continuation);
        this.this$0 = pushSettingViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PushSettingViewModel$loadData$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List<NotifyConfig> notifyConfigList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CompatNewModel compatNewModel = CompatNewModel.f33981a;
            this.label = 1;
            obj = compatNewModel.f(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        NotifyConfigList notifyConfigList2 = (NotifyConfigList) obj;
        ArrayList arrayList = new ArrayList();
        this.this$0.notifyConfigList = notifyConfigList2 != null ? notifyConfigList2.getNotifyConfigList() : null;
        if (notifyConfigList2 != null && (notifyConfigList = notifyConfigList2.getNotifyConfigList()) != null) {
            for (NotifyConfig notifyConfig : notifyConfigList) {
                arrayList.add(notifyConfig);
                NotifySubConfig notifySubConfig = (NotifySubConfig) CollectionsKt.lastOrNull(notifyConfig.getChildList());
                if (notifySubConfig != null) {
                    notifySubConfig.setGroupLastItem(true);
                }
                arrayList.addAll(notifyConfig.getChildList());
            }
        }
        PushSettingAdapter value = this.this$0.l().getValue();
        if (value != null) {
            value.setList(arrayList);
        }
        return Unit.INSTANCE;
    }
}
