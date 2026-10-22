package com.huachenjie.channel.page.friend_list;

import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.bean.FriendUserInfo;
import com.igexin.push.g.o;
import com.zj.adlib.dj1;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.friend_list.FriendListViewModel$queryFriendList$2", f = "FriendListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FriendListViewModel$queryFriendList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ StateLayout $stateLayout;
    int label;
    final /* synthetic */ FriendListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendListViewModel$queryFriendList$2(FriendListViewModel friendListViewModel, StateLayout stateLayout, String str, Continuation<? super FriendListViewModel$queryFriendList$2> continuation) {
        super(2, continuation);
        this.this$0 = friendListViewModel;
        this.$stateLayout = stateLayout;
        this.$key = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FriendListViewModel$queryFriendList$2(this.this$0, this.$stateLayout, this.$key, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        final FriendListViewModel friendListViewModel = this.this$0;
        final StateLayout stateLayout = this.$stateLayout;
        final String str = this.$key;
        dj1.B(new DefaultCallback<List<? extends FriendUserInfo>>() { // from class: com.huachenjie.channel.page.friend_list.FriendListViewModel$queryFriendList$2.1
            @Override // com.huachenjie.im.DefaultCallback
            public /* bridge */ /* synthetic */ void onResult(int i, List<? extends FriendUserInfo> list, Throwable th) {
                onResult2(i, (List<FriendUserInfo>) list, th);
            }

            /* JADX INFO: renamed from: onResult, reason: avoid collision after fix types in other method */
            public void onResult2(int code, @Nullable List<FriendUserInfo> result, @Nullable Throwable exception) {
                if (code != 200 || result == null) {
                    friendListViewModel.l().setValue(3);
                } else {
                    final FriendListViewModel friendListViewModel2 = friendListViewModel;
                    BaseViewModelExtKt.b(friendListViewModel2, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.channel.page.friend_list.FriendListViewModel$queryFriendList$2$1$onResult$1
                        {
                            super(1);
                        }

                        @NotNull
                        public final Boolean invoke(@NotNull ResultException resultException) {
                            Intrinsics.checkNotNullParameter(resultException, o.f);
                            friendListViewModel2.l().setValue(3);
                            return Boolean.FALSE;
                        }
                    }, null, new FriendListViewModel$queryFriendList$2$1$onResult$2(friendListViewModel, stateLayout, str, result, null), 11, null);
                }
            }
        });
        return Unit.INSTANCE;
    }
}
