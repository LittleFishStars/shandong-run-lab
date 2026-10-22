package com.huachenjie.channel.page.friend_list;

import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.FriendListBean;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.im.bean.FriendUserInfo;
import com.zj.adlib.jo2;
import com.zj.adlib.v41;
import com.zj.adlib.ys8;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.friend_list.FriendListViewModel$queryFriendList$2$1$onResult$2", f = "FriendListViewModel.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
public final class FriendListViewModel$queryFriendList$2$1$onResult$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ List<FriendUserInfo> $result;
    final /* synthetic */ StateLayout $stateLayout;
    Object L$0;
    int label;
    final /* synthetic */ FriendListViewModel this$0;

    /* JADX INFO: renamed from: com.huachenjie.channel.page.friend_list.FriendListViewModel$queryFriendList$2$1$onResult$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/huachenjie/channel/bean/FriendListBean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.channel.page.friend_list.FriendListViewModel$queryFriendList$2$1$onResult$2$1", f = "FriendListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nFriendListViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FriendListViewModel.kt\ncom/huachenjie/channel/page/friend_list/FriendListViewModel$queryFriendList$2$1$onResult$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,159:1\n1549#2:160\n1620#2,3:161\n1045#2:164\n1855#2,2:165\n*S KotlinDebug\n*F\n+ 1 FriendListViewModel.kt\ncom/huachenjie/channel/page/friend_list/FriendListViewModel$queryFriendList$2$1$onResult$2$1\n*L\n62#1:160\n62#1:161,3\n69#1:164\n78#1:165,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<FriendListBean>>, Object> {
        final /* synthetic */ List<FriendUserInfo> $result;
        int label;
        final /* synthetic */ FriendListViewModel this$0;

        /* JADX INFO: renamed from: com.huachenjie.channel.page.friend_list.FriendListViewModel$queryFriendList$2$1$onResult$2$1$a */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 FriendListViewModel.kt\ncom/huachenjie/channel/page/friend_list/FriendListViewModel$queryFriendList$2$1$onResult$2$1\n*L\n1#1,328:1\n70#2:329\n*E\n"})
        public static final class a<T> implements Comparator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FriendListViewModel f33408a;

            public a(FriendListViewModel friendListViewModel) {
                this.f33408a = friendListViewModel;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(this.f33408a.k((FriendListBean) t), this.f33408a.k((FriendListBean) t2));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List<FriendUserInfo> list, FriendListViewModel friendListViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$result = list;
            this.this$0 = friendListViewModel;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$result, this.this$0, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<FriendListBean>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<FriendUserInfo> list = this.$result;
            List<FriendListBean> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new FriendListBean((FriendUserInfo) it.next(), null, null, 6, null));
            }
            FriendListViewModel friendListViewModel = this.this$0;
            if (arrayList.size() == 1) {
                friendListViewModel.k((FriendListBean) CollectionsKt.first(arrayList));
            } else {
                arrayList = CollectionsKt.sortedWith(arrayList, new a(friendListViewModel));
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (FriendListBean friendListBean : arrayList) {
                if (!arrayList3.contains(friendListBean.getFirstLetter())) {
                    arrayList2.add(new FriendListBean(null, null, friendListBean.getFirstLetter(), 3, null));
                    arrayList3.add(friendListBean.getFirstLetter());
                }
                arrayList2.add(friendListBean);
            }
            return arrayList2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendListViewModel$queryFriendList$2$1$onResult$2(FriendListViewModel friendListViewModel, StateLayout stateLayout, String str, List<FriendUserInfo> list, Continuation<? super FriendListViewModel$queryFriendList$2$1$onResult$2> continuation) {
        super(2, continuation);
        this.this$0 = friendListViewModel;
        this.$stateLayout = stateLayout;
        this.$key = str;
        this.$result = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FriendListViewModel$queryFriendList$2$1$onResult$2(this.this$0, this.$stateLayout, this.$key, this.$result, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FriendListViewModel friendListViewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FriendListViewModel friendListViewModel2 = this.this$0;
            CoroutineDispatcher coroutineDispatcherC = jo2.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$result, this.this$0, null);
            this.L$0 = friendListViewModel2;
            this.label = 1;
            Object objH = v41.h(coroutineDispatcherC, anonymousClass1, this);
            if (objH == coroutine_suspended) {
                return coroutine_suspended;
            }
            friendListViewModel = friendListViewModel2;
            obj = objH;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            friendListViewModel = (FriendListViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        friendListViewModel.t((List) obj);
        if (this.this$0.m().isEmpty()) {
            this.$stateLayout.setEmptyLabel(ys8.e(R.string.common_empty_info));
            this.this$0.l().setValue(Boxing.boxInt(2));
            this.this$0.o().setValue(Boxing.boxBoolean(false));
        } else {
            this.this$0.s(this.$key, this.$stateLayout);
        }
        this.this$0.n().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
