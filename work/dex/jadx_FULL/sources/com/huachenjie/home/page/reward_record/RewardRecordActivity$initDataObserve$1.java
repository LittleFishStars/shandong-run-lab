package com.huachenjie.home.page.reward_record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.p002lifecycle.LifecycleOwnerKt;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.home.R;
import com.igexin.push.g.o;
import com.zj.adlib.v41;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", o.f, "", "kotlin.jvm.PlatformType", BridgeDSL.INVOKE, "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class RewardRecordActivity$initDataObserve$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ RewardRecordActivity this$0;

    /* JADX INFO: renamed from: com.huachenjie.home.page.reward_record.RewardRecordActivity$initDataObserve$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.home.page.reward_record.RewardRecordActivity$initDataObserve$1$2", f = "RewardRecordActivity.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RewardRecordAdapter $adapter;
        int label;
        final /* synthetic */ RewardRecordActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(RewardRecordAdapter rewardRecordAdapter, RewardRecordActivity rewardRecordActivity, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$adapter = rewardRecordAdapter;
            this.this$0 = rewardRecordActivity;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.$adapter, this.this$0, continuation);
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
                this.label = 1;
                if (DelayKt.b(500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (!this.$adapter.getData().isEmpty()) {
                return Unit.INSTANCE;
            }
            this.$adapter.setFooterWithEmptyEnable(true);
            View viewInflate = LayoutInflater.from(this.this$0).inflate(R.layout.home_layout_reward_record_bottom_none, (ViewGroup) this.this$0.getMBinding().f34217a, false);
            RewardRecordAdapter rewardRecordAdapter = this.$adapter;
            Intrinsics.checkNotNullExpressionValue(viewInflate, "footerView");
            BaseQuickAdapter.setFooterView$default(rewardRecordAdapter, viewInflate, 0, 0, 6, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardRecordActivity$initDataObserve$1(RewardRecordActivity rewardRecordActivity) {
        super(1);
        this.this$0 = rewardRecordActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(RewardRecordActivity rewardRecordActivity) {
        Intrinsics.checkNotNullParameter(rewardRecordActivity, "this$0");
        BaseStateRequestModel.x(rewardRecordActivity.getMViewModel(), false, 1, null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) throws IllegalAccessException, NoSuchFieldException {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Boolean bool) throws IllegalAccessException, NoSuchFieldException {
        RewardRecordAdapter value = this.this$0.getMViewModel().C().getValue();
        if (value == null) {
            return;
        }
        Field declaredField = BaseQuickAdapter.class.getDeclaredField("mLoadMoreModule");
        declaredField.setAccessible(true);
        BaseLoadMoreModule baseLoadMoreModuleAddLoadMoreModule = value.addLoadMoreModule(value);
        declaredField.set(value, baseLoadMoreModuleAddLoadMoreModule);
        final RewardRecordActivity rewardRecordActivity = this.this$0;
        baseLoadMoreModuleAddLoadMoreModule.setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.huachenjie.home.page.reward_record.a
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                RewardRecordActivity$initDataObserve$1.invoke$lambda$0(rewardRecordActivity);
            }
        });
        v41.e(LifecycleOwnerKt.getLifecycleScope(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(value, this.this$0, null), 3, (Object) null);
    }
}
