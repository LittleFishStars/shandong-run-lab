package com.huachenjie.channel.page.friend_list;

import com.huachenjie.channel.bean.FriendListBean;
import com.huachenjie.im.bean.FriendUserInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/huachenjie/channel/bean/FriendListBean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.friend_list.FriendListViewModel$searchFriendList$1$searchList$1", f = "FriendListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nFriendListViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FriendListViewModel.kt\ncom/huachenjie/channel/page/friend_list/FriendListViewModel$searchFriendList$1$searchList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,159:1\n766#2:160\n857#2,2:161\n*S KotlinDebug\n*F\n+ 1 FriendListViewModel.kt\ncom/huachenjie/channel/page/friend_list/FriendListViewModel$searchFriendList$1$searchList$1\n*L\n148#1:160\n148#1:161,2\n*E\n"})
public final class FriendListViewModel$searchFriendList$1$searchList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends FriendListBean>>, Object> {
    final /* synthetic */ String $key;
    int label;
    final /* synthetic */ FriendListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendListViewModel$searchFriendList$1$searchList$1(FriendListViewModel friendListViewModel, String str, Continuation<? super FriendListViewModel$searchFriendList$1$searchList$1> continuation) {
        super(2, continuation);
        this.this$0 = friendListViewModel;
        this.$key = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FriendListViewModel$searchFriendList$1$searchList$1(this.this$0, this.$key, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<FriendListBean>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String nickName;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<FriendListBean> listM = this.this$0.m();
        String str = this.$key;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : listM) {
            FriendUserInfo userInfo = ((FriendListBean) obj2).getUserInfo();
            boolean z = false;
            if (userInfo != null && (nickName = userInfo.formatNickName()) != null && StringsKt.contains(nickName, str, true)) {
                z = true;
            }
            if (z) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }
}
