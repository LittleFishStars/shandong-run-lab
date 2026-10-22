package com.huachenjie.channel.page.add_friend;

import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.MayKnowFriendBean;
import com.huachenjie.im.DefaultCallback;
import com.netease.nimlib.sdk.uinfo.model.NimUserInfo;
import com.zj.adlib.dj1;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import java.util.Iterator;
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
@DebugMetadata(c = "com.huachenjie.channel.page.add_friend.AddFriendVM$loadMoreData$1", f = "AddFriendVM.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
public final class AddFriendVM$loadMoreData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AddFriendVM this$0;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/huachenjie/channel/page/add_friend/AddFriendVM$loadMoreData$1$a", "Lcom/huachenjie/im/DefaultCallback;", "", "Lcom/netease/nimlib/sdk/uinfo/model/NimUserInfo;", "", "code", "result", "", c.f25231a, "", "onResult", "channel_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nAddFriendVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AddFriendVM.kt\ncom/huachenjie/channel/page/add_friend/AddFriendVM$loadMoreData$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,48:1\n1549#2:49\n1620#2,3:50\n*S KotlinDebug\n*F\n+ 1 AddFriendVM.kt\ncom/huachenjie/channel/page/add_friend/AddFriendVM$loadMoreData$1$1\n*L\n41#1:49\n41#1:50,3\n*E\n"})
    public static final class a extends DefaultCallback<List<? extends NimUserInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AddFriendVM f33353a;

        public a(AddFriendVM addFriendVM) {
            this.f33353a = addFriendVM;
        }

        @Override // com.huachenjie.im.DefaultCallback
        public void onResult(int code, @Nullable List<? extends NimUserInfo> result, @Nullable Throwable exception) {
            ArrayList arrayList;
            PageEntity<?> pageEntity = new PageEntity<>();
            pageEntity.setPageNum(this.f33353a.getPageNum());
            if (result != null) {
                List<? extends NimUserInfo> list = result;
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new MayKnowFriendBean((NimUserInfo) it.next(), false));
                }
            } else {
                arrayList = null;
            }
            pageEntity.setList(arrayList);
            this.f33353a.u().setValue(pageEntity);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddFriendVM$loadMoreData$1(AddFriendVM addFriendVM, Continuation<? super AddFriendVM$loadMoreData$1> continuation) {
        super(2, continuation);
        this.this$0 = addFriendVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AddFriendVM$loadMoreData$1(this.this$0, continuation);
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
            int pageNum = this.this$0.getPageNum();
            this.label = 1;
            obj = requestModel.e0(pageNum, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        PageEntity pageEntity = (PageEntity) obj;
        if (pageEntity == null) {
            return Unit.INSTANCE;
        }
        dj1.F(pageEntity.getList(), new a(this.this$0));
        return Unit.INSTANCE;
    }
}
