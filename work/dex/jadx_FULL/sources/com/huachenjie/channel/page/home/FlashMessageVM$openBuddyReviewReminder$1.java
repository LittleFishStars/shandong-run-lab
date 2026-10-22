package com.huachenjie.channel.page.home;

import android.content.Context;
import com.huachenjie.channel.R;
import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.notify.BuddyReviewReminderBean;
import com.huachenjie.channel.bean.notify.BuddyReviewReminderItemBean;
import com.huachenjie.common.constants.Environment;
import com.zj.adlib.fv5;
import com.zj.adlib.su9;
import com.zj.adlib.ys8;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.home.FlashMessageVM$openBuddyReviewReminder$1", f = "FlashMessageVM.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nFlashMessageVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlashMessageVM.kt\ncom/huachenjie/channel/page/home/FlashMessageVM$openBuddyReviewReminder$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,225:1\n1#2:226\n*E\n"})
public final class FlashMessageVM$openBuddyReviewReminder$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlashMessageVM$openBuddyReviewReminder$1(Context context, Continuation<? super FlashMessageVM$openBuddyReviewReminder$1> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FlashMessageVM$openBuddyReviewReminder$1(this.$context, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List<BuddyReviewReminderItemBean> buddyList;
        BuddyReviewReminderItemBean buddyReviewReminderItemBean;
        String buddyCode;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f33012a;
            this.label = 1;
            obj = requestModel.v0(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        BuddyReviewReminderBean buddyReviewReminderBean = (BuddyReviewReminderBean) obj;
        String str = null;
        if (buddyReviewReminderBean != null && (buddyList = buddyReviewReminderBean.getBuddyList()) != null && (buddyReviewReminderItemBean = (BuddyReviewReminderItemBean) CollectionsKt.firstOrNull(buddyList)) != null && (buddyCode = buddyReviewReminderItemBean.getBuddyCode()) != null) {
            if (buddyCode.length() > 0) {
                str = buddyCode;
            }
        }
        if (str == null) {
            fv5.b(ys8.e(R.string.channel_buddy_review_reminder_empty));
            return Unit.INSTANCE;
        }
        su9.l(this.$context, Environment.c + "/#/buddy/review?buddyCode=" + str);
        return Unit.INSTANCE;
    }
}
