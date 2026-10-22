package com.huachenjie.channel.page.all_channel;

import com.huachenjie.channel.R;
import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.JoinChannelCategoryBean;
import com.huachenjie.channel.bean.JoinChannelCategoryListBean;
import com.zj.adlib.ys8;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.all_channel.JoinAllChannelVM$queryCategory$1", f = "JoinAllChannelVM.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
public final class JoinAllChannelVM$queryCategory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ JoinAllChannelVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JoinAllChannelVM$queryCategory$1(JoinAllChannelVM joinAllChannelVM, Continuation<? super JoinAllChannelVM$queryCategory$1> continuation) {
        super(2, continuation);
        this.this$0 = joinAllChannelVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new JoinAllChannelVM$queryCategory$1(this.this$0, continuation);
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
            RequestModel requestModel = RequestModel.f33012a;
            this.label = 1;
            obj = requestModel.d0(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        JoinChannelCategoryListBean joinChannelCategoryListBean = (JoinChannelCategoryListBean) obj;
        if (joinChannelCategoryListBean == null) {
            return Unit.INSTANCE;
        }
        List<JoinChannelCategoryBean> list = joinChannelCategoryListBean.getList();
        String strE = ys8.e(R.string.channel_join_all_channel_rec);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.channel_join_all_channel_rec)");
        list.add(0, new JoinChannelCategoryBean(strE, "0"));
        this.this$0.k().setValue(joinChannelCategoryListBean);
        return Unit.INSTANCE;
    }
}
