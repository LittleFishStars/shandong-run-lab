package com.huachenjie.channel.page.manage_channel.topic;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.huachenjie.channel.R;
import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.my_channel.MyChannelTopic;
import com.zj.adlib.fv5;
import com.zj.adlib.yj7;
import com.zj.adlib.ys8;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.manage_channel.topic.CreateTopicVM$addTopic$3", f = "CreateTopicVM.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
public final class CreateTopicVM$addTopic$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelNo;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $topicGroupCode;
    int label;
    final /* synthetic */ CreateTopicVM this$0;

    /* JADX INFO: renamed from: com.huachenjie.channel.page.manage_channel.topic.CreateTopicVM$addTopic$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.channel.page.manage_channel.topic.CreateTopicVM$addTopic$3$1", f = "CreateTopicVM.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ MyChannelTopic $bean;
        final /* synthetic */ String $channelNo;
        final /* synthetic */ String $topicGroupCode;
        int label;
        final /* synthetic */ CreateTopicVM this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2, MyChannelTopic myChannelTopic, CreateTopicVM createTopicVM, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$channelNo = str;
            this.$topicGroupCode = str2;
            this.$bean = myChannelTopic;
            this.this$0 = createTopicVM;
        }

        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$channelNo, this.$topicGroupCode, this.$bean, this.this$0, continuation);
        }

        @Nullable
        public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RequestModel requestModel = RequestModel.f33012a;
                String str = this.$channelNo;
                String str2 = this.$topicGroupCode;
                String subjectName = this.$bean.getSubjectName();
                String subjectImg = this.$bean.getSubjectImg();
                this.label = 1;
                obj = requestModel.o(str, str2, subjectName, subjectImg, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null) {
                MyChannelTopic myChannelTopic = this.$bean;
                CreateTopicVM createTopicVM = this.this$0;
                String string = jSONObject.getString(yj7.b.SUBJECT_NO);
                Intrinsics.checkNotNullExpressionValue(string, "it.getString(\"subjectNo\")");
                myChannelTopic.setSubjectNo(string);
                createTopicVM.n().setValue(Boxing.boxBoolean(true));
            }
            this.this$0.c();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateTopicVM$addTopic$3(CreateTopicVM createTopicVM, Context context, String str, String str2, Continuation<? super CreateTopicVM$addTopic$3> continuation) {
        super(2, continuation);
        this.this$0 = createTopicVM;
        this.$context = context;
        this.$channelNo = str;
        this.$topicGroupCode = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CreateTopicVM$addTopic$3(this.this$0, this.$context, this.$channelNo, this.$topicGroupCode, continuation);
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
            MyChannelTopic value = this.this$0.r().getValue();
            if (value == null) {
                return Unit.INSTANCE;
            }
            this.this$0.g();
            CreateTopicVM createTopicVM = this.this$0;
            Context context = this.$context;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$channelNo, this.$topicGroupCode, value, createTopicVM, null);
            final CreateTopicVM createTopicVM2 = this.this$0;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.huachenjie.channel.page.manage_channel.topic.CreateTopicVM$addTopic$3.2
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m285invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m285invoke() {
                    fv5.b(ys8.e(R.string.channel_manage_upload_error));
                    createTopicVM2.c();
                }
            };
            this.label = 1;
            if (createTopicVM.s(context, value, anonymousClass1, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
