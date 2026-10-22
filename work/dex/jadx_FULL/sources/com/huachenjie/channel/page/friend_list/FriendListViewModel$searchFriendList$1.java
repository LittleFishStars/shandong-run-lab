package com.huachenjie.channel.page.friend_list;

import com.huachenjie.channel.R;
import com.huachenjie.channel.adapter.FriendListAdapter;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.zj.adlib.jo2;
import com.zj.adlib.v41;
import com.zj.adlib.ys8;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.friend_list.FriendListViewModel$searchFriendList$1", f = "FriendListViewModel.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
public final class FriendListViewModel$searchFriendList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ StateLayout $stateLayout;
    int label;
    final /* synthetic */ FriendListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendListViewModel$searchFriendList$1(FriendListViewModel friendListViewModel, StateLayout stateLayout, String str, Continuation<? super FriendListViewModel$searchFriendList$1> continuation) {
        super(2, continuation);
        this.this$0 = friendListViewModel;
        this.$stateLayout = stateLayout;
        this.$key = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FriendListViewModel$searchFriendList$1(this.this$0, this.$stateLayout, this.$key, continuation);
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
            CoroutineDispatcher coroutineDispatcherC = jo2.c();
            FriendListViewModel$searchFriendList$1$searchList$1 friendListViewModel$searchFriendList$1$searchList$1 = new FriendListViewModel$searchFriendList$1$searchList$1(this.this$0, this.$key, null);
            this.label = 1;
            obj = v41.h(coroutineDispatcherC, friendListViewModel$searchFriendList$1$searchList$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        List list = (List) obj;
        FriendListAdapter value = this.this$0.j().getValue();
        if (value != null) {
            value.setList(list);
        }
        this.$stateLayout.setEmptyLabel(ys8.e(R.string.channel_friend_list_empty));
        this.this$0.l().setValue(list.isEmpty() ? Boxing.boxInt(2) : Boxing.boxInt(1));
        this.this$0.o().setValue(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }
}
