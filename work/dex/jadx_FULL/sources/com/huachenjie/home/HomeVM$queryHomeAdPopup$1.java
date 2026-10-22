package com.huachenjie.home;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.home.api.HomeRequest;
import com.huachenjie.home.bean.AdPopupBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.home.HomeVM$queryHomeAdPopup$1", f = "HomeVM.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
public final class HomeVM$queryHomeAdPopup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ HomeVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeVM$queryHomeAdPopup$1(HomeVM homeVM, Continuation<? super HomeVM$queryHomeAdPopup$1> continuation) {
        super(2, continuation);
        this.this$0 = homeVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HomeVM$queryHomeAdPopup$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData<AdPopupBean> mutableLiveDataQ = this.this$0.q();
            HomeRequest homeRequest = HomeRequest.f34197a;
            this.L$0 = mutableLiveDataQ;
            this.label = 1;
            Object objK = homeRequest.k(this);
            if (objK == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = mutableLiveDataQ;
            obj = objK;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableLiveData = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        mutableLiveData.setValue(obj);
        return Unit.INSTANCE;
    }
}
