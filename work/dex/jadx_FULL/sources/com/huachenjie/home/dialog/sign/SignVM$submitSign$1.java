package com.huachenjie.home.dialog.sign;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.home.api.HomeRequest;
import com.huachenjie.home.bean.SignBean;
import com.huachenjie.home.bean.SignConfigBean;
import java.util.Iterator;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.home.dialog.sign.SignVM$submitSign$1", f = "SignVM.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nSignVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SignVM.kt\ncom/huachenjie/home/dialog/sign/SignVM$submitSign$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,63:1\n1#2:64\n*E\n"})
public final class SignVM$submitSign$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ SignVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignVM$submitSign$1(SignVM signVM, Continuation<? super SignVM$submitSign$1> continuation) {
        super(2, continuation);
        this.this$0 = signVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SignVM$submitSign$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData mutableLiveData;
        Object next;
        SignAdapter value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData<Integer> mutableLiveDataK = this.this$0.k();
            HomeRequest homeRequest = HomeRequest.f34197a;
            this.L$0 = mutableLiveDataK;
            this.label = 1;
            Object objC = homeRequest.C(this);
            if (objC == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = mutableLiveDataK;
            obj = objC;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableLiveData = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        mutableLiveData.setValue(obj);
        SignConfigBean value2 = this.this$0.j().getValue();
        if (value2 != null) {
            SignVM signVM = this.this$0;
            value2.setTodaySigned(true);
            value2.setContinueDays(value2.getContinueDays() + 1);
            Iterator<T> it = value2.getSignList().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!((SignBean) next).getToday());
            SignBean signBean = (SignBean) next;
            if (signBean != null) {
                signBean.setSigned(true);
            }
            if (signBean != null) {
                signBean.setFromSign(true);
            }
            signVM.j().setValue(value2);
            if (signBean != null) {
                int day = signBean.getDay();
                boolean z = false;
                if (1 <= day && day < 8) {
                    z = true;
                }
                if (z && (value = signVM.i().getValue()) != null) {
                    value.notifyItemChanged(signBean.getDay() - 1);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
