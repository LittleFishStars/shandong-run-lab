package com.huachenjie.works.page.broadcast_floor;

import android.content.Context;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.BroadcastFloorMessageImageBean;
import com.huachenjie.works.bean.BroadcastFloorMessageVoiceBean;
import com.zj.adlib.jo2;
import com.zj.adlib.v41;
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
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.broadcast_floor.BroadcastFloorVM$publishQuote$2", f = "BroadcastFloorVM.kt", i = {}, l = {72, 78, 83}, m = "invokeSuspend", n = {}, s = {})
public final class BroadcastFloorVM$publishQuote$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ Context $context;
    final /* synthetic */ BroadcastFloorMessageImageBean $image;
    final /* synthetic */ BroadcastFloorMessageVoiceBean $voice;
    int label;
    final /* synthetic */ BroadcastFloorVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastFloorVM$publishQuote$2(BroadcastFloorMessageImageBean broadcastFloorMessageImageBean, BroadcastFloorMessageVoiceBean broadcastFloorMessageVoiceBean, String str, BroadcastFloorVM broadcastFloorVM, Context context, Continuation<? super BroadcastFloorVM$publishQuote$2> continuation) {
        super(2, continuation);
        this.$image = broadcastFloorMessageImageBean;
        this.$voice = broadcastFloorMessageVoiceBean;
        this.$content = str;
        this.this$0 = broadcastFloorVM;
        this.$context = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BroadcastFloorVM$publishQuote$2(this.$image, this.$voice, this.$content, this.this$0, this.$context, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0084 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x008c  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a7 A[RETURN] */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        BroadcastFloorMessageVoiceBean broadcastFloorMessageVoiceBean;
        RequestModel requestModel;
        String str;
        BroadcastFloorMessageImageBean broadcastFloorMessageImageBean;
        BroadcastFloorMessageVoiceBean broadcastFloorMessageVoiceBean2;
        String str2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                String str3 = (String) obj;
                this.$voice.setPath(str3 != null ? str3 : "");
                requestModel = RequestModel.f36762a;
                str = this.$content;
                broadcastFloorMessageImageBean = this.$image;
                broadcastFloorMessageVoiceBean2 = this.$voice;
                str2 = this.this$0.requestId;
                this.label = 3;
                if (requestModel.s(str, broadcastFloorMessageImageBean, broadcastFloorMessageVoiceBean2, str2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.s();
            this.this$0.n().setValue(Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        BroadcastFloorMessageImageBean broadcastFloorMessageImageBean2 = this.$image;
        if (broadcastFloorMessageImageBean2 == null || StringsKt.startsWith$default(broadcastFloorMessageImageBean2.getPath(), "http", false, 2, (Object) null)) {
            broadcastFloorMessageVoiceBean = this.$voice;
            if (broadcastFloorMessageVoiceBean != null && !StringsKt.startsWith$default(broadcastFloorMessageVoiceBean.getPath(), "http", false, 2, (Object) null)) {
                CoroutineDispatcher coroutineDispatcherC = jo2.c();
                BroadcastFloorVM$publishQuote$2$path$2 broadcastFloorVM$publishQuote$2$path$2 = new BroadcastFloorVM$publishQuote$2$path$2(this.this$0, this.$context, this.$voice, null);
                this.label = 2;
                obj = v41.h(coroutineDispatcherC, broadcastFloorVM$publishQuote$2$path$2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                String str4 = (String) obj;
                this.$voice.setPath(str4 != null ? str4 : "");
            }
        } else {
            CoroutineDispatcher coroutineDispatcherC2 = jo2.c();
            BroadcastFloorVM$publishQuote$2$path$1 broadcastFloorVM$publishQuote$2$path$1 = new BroadcastFloorVM$publishQuote$2$path$1(this.this$0, this.$context, this.$image, null);
            this.label = 1;
            obj = v41.h(coroutineDispatcherC2, broadcastFloorVM$publishQuote$2$path$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        requestModel = RequestModel.f36762a;
        str = this.$content;
        broadcastFloorMessageImageBean = this.$image;
        broadcastFloorMessageVoiceBean2 = this.$voice;
        str2 = this.this$0.requestId;
        this.label = 3;
        if (requestModel.s(str, broadcastFloorMessageImageBean, broadcastFloorMessageVoiceBean2, str2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.s();
        this.this$0.n().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
        String str5 = (String) obj;
        BroadcastFloorMessageImageBean broadcastFloorMessageImageBean3 = this.$image;
        if (str5 == null) {
            str5 = "";
        }
        broadcastFloorMessageImageBean3.setPath(str5);
        broadcastFloorMessageVoiceBean = this.$voice;
        if (broadcastFloorMessageVoiceBean != null) {
            CoroutineDispatcher coroutineDispatcherC3 = jo2.c();
            BroadcastFloorVM$publishQuote$2$path$2 broadcastFloorVM$publishQuote$2$path$3 = new BroadcastFloorVM$publishQuote$2$path$2(this.this$0, this.$context, this.$voice, null);
            this.label = 2;
            obj = v41.h(coroutineDispatcherC3, broadcastFloorVM$publishQuote$2$path$3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            String str6 = (String) obj;
            this.$voice.setPath(str6 != null ? str6 : "");
        }
        requestModel = RequestModel.f36762a;
        str = this.$content;
        broadcastFloorMessageImageBean = this.$image;
        broadcastFloorMessageVoiceBean2 = this.$voice;
        str2 = this.this$0.requestId;
        this.label = 3;
        if (requestModel.s(str, broadcastFloorMessageImageBean, broadcastFloorMessageVoiceBean2, str2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.s();
        this.this$0.n().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
