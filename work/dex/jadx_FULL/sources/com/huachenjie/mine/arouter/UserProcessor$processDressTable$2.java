package com.huachenjie.mine.arouter;

import android.app.Activity;
import android.app.Dialog;
import com.byazt.hv.TTDownloadField;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.mine.api.RequestModel;
import com.huachenjie.mine.bean.MineData;
import com.huachenjie.mine.page.dressing_table.DressingTableActivity;
import com.zj.adlib.ai9;
import com.zj.adlib.pm1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/zj/adlib/pm1;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mine.arouter.UserProcessor$processDressTable$2", f = "UserProcessor.kt", i = {0}, l = {61}, m = "invokeSuspend", n = {TTDownloadField.TT_ACTIVITY}, s = {"L$0"})
public final class UserProcessor$processDressTable$2 extends SuspendLambda implements Function2<pm1, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Dialog> $dialog;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProcessor$processDressTable$2(Ref.ObjectRef<Dialog> objectRef, Continuation<? super UserProcessor$processDressTable$2> continuation) {
        super(2, continuation);
        this.$dialog = objectRef;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UserProcessor$processDressTable$2(this.$dialog, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull pm1 pm1Var, @Nullable Continuation<? super Unit> continuation) {
        return create(pm1Var, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Activity activity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Activity activityM = ActivityLifecycleManager.l().m();
            if (activityM == null) {
                return Unit.INSTANCE;
            }
            this.$dialog.element = DialogUtil.m(activityM);
            Dialog dialog = (Dialog) this.$dialog.element;
            if (dialog != null) {
                dialog.show();
            }
            RequestModel requestModel = RequestModel.f35285a;
            this.L$0 = activityM;
            this.label = 1;
            Object objF = requestModel.F("", this);
            if (objF == coroutine_suspended) {
                return coroutine_suspended;
            }
            activity = activityM;
            obj = objF;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            activity = (Activity) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        MineData mineData = (MineData) obj;
        if (mineData == null) {
            return Unit.INSTANCE;
        }
        mineData.setAvatarFrameImgUrl(ai9.e().getAvatarFrameImgUrl());
        DressingTableActivity.INSTANCE.a(activity, mineData, 0);
        return Unit.INSTANCE;
    }
}
