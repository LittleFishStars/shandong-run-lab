package com.huachenjie.mine.page.dressing_table.nickName;

import com.huachenjie.mine.api.RequestModel;
import com.zj.adlib.fv5;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mine.page.dressing_table.nickName.NicknameVM$saveNickname$1", f = "NicknameVM.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
public final class NicknameVM$saveNickname$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $nickname;
    int label;
    final /* synthetic */ NicknameVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NicknameVM$saveNickname$1(String str, NicknameVM nicknameVM, Continuation<? super NicknameVM$saveNickname$1> continuation) {
        super(2, continuation);
        this.$nickname = str;
        this.this$0 = nicknameVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NicknameVM$saveNickname$1(this.$nickname, this.this$0, continuation);
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
            String string = StringsKt.trim(StringsKt.replace$default(this.$nickname, "\n", " ", false, 4, (Object) null)).toString();
            this.label = 1;
            if (requestModel.I(string, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.j().setValue(Boxing.boxBoolean(true));
        fv5.b("保存成功");
        return Unit.INSTANCE;
    }
}
