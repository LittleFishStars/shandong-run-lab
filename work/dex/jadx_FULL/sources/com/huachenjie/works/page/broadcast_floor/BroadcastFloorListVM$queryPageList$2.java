package com.huachenjie.works.page.broadcast_floor;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.BroadcastFloorMessageBean;
import com.zj.adlib.jo2;
import com.zj.adlib.v41;
import huachenjie.sdk.http.PageEntity;
import java.util.Collection;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.broadcast_floor.BroadcastFloorListVM$queryPageList$2", f = "BroadcastFloorListVM.kt", i = {2}, l = {68, 74, 80}, m = "invokeSuspend", n = {"data"}, s = {"L$0"})
public final class BroadcastFloorListVM$queryPageList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ BroadcastFloorListVM this$0;

    /* JADX INFO: renamed from: com.huachenjie.works.page.broadcast_floor.BroadcastFloorListVM$queryPageList$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.works.page.broadcast_floor.BroadcastFloorListVM$queryPageList$2$1", f = "BroadcastFloorListVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nBroadcastFloorListVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastFloorListVM.kt\ncom/huachenjie/works/page/broadcast_floor/BroadcastFloorListVM$queryPageList$2$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,111:1\n1855#2,2:112\n*S KotlinDebug\n*F\n+ 1 BroadcastFloorListVM.kt\ncom/huachenjie/works/page/broadcast_floor/BroadcastFloorListVM$queryPageList$2$1\n*L\n81#1:112,2\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PageEntity<BroadcastFloorMessageBean> $data;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PageEntity<BroadcastFloorMessageBean> pageEntity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$data = pageEntity;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$data, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            List<BroadcastFloorMessageBean> list;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PageEntity<BroadcastFloorMessageBean> pageEntity = this.$data;
            if (pageEntity == null || (list = pageEntity.getList()) == null) {
                return null;
            }
            for (BroadcastFloorMessageBean broadcastFloorMessageBean : list) {
                broadcastFloorMessageBean.setTextContent(RichTextUtils.j(RichTextUtils.f32968a, broadcastFloorMessageBean.getContent(), 0, 2, null));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastFloorListVM$queryPageList$2(BroadcastFloorListVM broadcastFloorListVM, Continuation<? super BroadcastFloorListVM$queryPageList$2> continuation) {
        super(2, continuation);
        this.this$0 = broadcastFloorListVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BroadcastFloorListVM$queryPageList$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00cc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x00cd  */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Integer numBoxInt;
        String str;
        Integer numBoxInt2;
        Integer value;
        PageEntity pageEntity;
        CoroutineDispatcher coroutineDispatcherC;
        AnonymousClass1 anonymousClass1;
        PageEntity pageEntity2;
        List list;
        BaseLoadMoreModule loadMoreModule;
        BaseLoadMoreModule loadMoreModule2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData<Integer> mutableLiveDataK = this.this$0.k();
            if ((mutableLiveDataK == null || (value = mutableLiveDataK.getValue()) == null || value.intValue() != 1) ? false : true) {
                RequestModel requestModel = RequestModel.f36762a;
                MutableLiveData<Integer> mutableLiveDataJ = this.this$0.j();
                if (mutableLiveDataJ == null || (numBoxInt2 = mutableLiveDataJ.getValue()) == null) {
                    numBoxInt2 = Boxing.boxInt(2);
                }
                int iIntValue = numBoxInt2.intValue();
                int pageNum = this.this$0.getPageNum();
                String refreshTime = this.this$0.getRefreshTime();
                str = refreshTime != null ? refreshTime : "";
                this.label = 1;
                obj = requestModel.B(iIntValue, pageNum, str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pageEntity = (PageEntity) obj;
                coroutineDispatcherC = jo2.c();
                anonymousClass1 = new AnonymousClass1(pageEntity, null);
                this.L$0 = pageEntity;
                this.label = 3;
                if (v41.h(coroutineDispatcherC, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pageEntity2 = pageEntity;
            } else {
                RequestModel requestModel2 = RequestModel.f36762a;
                MutableLiveData<Integer> mutableLiveDataJ2 = this.this$0.j();
                if (mutableLiveDataJ2 == null || (numBoxInt = mutableLiveDataJ2.getValue()) == null) {
                    numBoxInt = Boxing.boxInt(2);
                }
                int iIntValue2 = numBoxInt.intValue();
                int pageNum2 = this.this$0.getPageNum();
                String refreshTime2 = this.this$0.getRefreshTime();
                str = refreshTime2 != null ? refreshTime2 : "";
                this.label = 2;
                obj = requestModel2.C(iIntValue2, pageNum2, str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pageEntity = (PageEntity) obj;
                coroutineDispatcherC = jo2.c();
                anonymousClass1 = new AnonymousClass1(pageEntity, null);
                this.L$0 = pageEntity;
                this.label = 3;
                if (v41.h(coroutineDispatcherC, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pageEntity2 = pageEntity;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            pageEntity = (PageEntity) obj;
            coroutineDispatcherC = jo2.c();
            anonymousClass1 = new AnonymousClass1(pageEntity, null);
            this.L$0 = pageEntity;
            this.label = 3;
            if (v41.h(coroutineDispatcherC, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            pageEntity2 = pageEntity;
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            pageEntity = (PageEntity) obj;
            coroutineDispatcherC = jo2.c();
            anonymousClass1 = new AnonymousClass1(pageEntity, null);
            this.L$0 = pageEntity;
            this.label = 3;
            if (v41.h(coroutineDispatcherC, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            pageEntity2 = pageEntity;
        } else {
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pageEntity2 = (PageEntity) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.t(pageEntity2 != null ? pageEntity2.getRefreshTime() : null);
        if (this.this$0.getPageNum() == 1) {
            this.this$0.o().setValue(Boxing.boxBoolean(false));
            if ((pageEntity2 != null ? pageEntity2.getList() : null) == null || pageEntity2.getList().isEmpty()) {
                BroadcastFloorAdapter value2 = this.this$0.i().getValue();
                if (value2 != null) {
                    value2.setList(null);
                }
                BroadcastFloorAdapter value3 = this.this$0.i().getValue();
                if (value3 != null) {
                    value3.i();
                }
            } else {
                BroadcastFloorAdapter value4 = this.this$0.i().getValue();
                if (value4 != null) {
                    value4.f();
                }
                BroadcastFloorAdapter value5 = this.this$0.i().getValue();
                if (value5 != null) {
                    value5.setList(pageEntity2.getList());
                }
            }
        } else {
            if ((pageEntity2 == null || (list = pageEntity2.getList()) == null || !(list.isEmpty() ^ true)) ? false : true) {
                BroadcastFloorAdapter value6 = this.this$0.i().getValue();
                if (value6 != null) {
                    List list2 = pageEntity2.getList();
                    Intrinsics.checkNotNullExpressionValue(list2, "data.list");
                    value6.addData((Collection) list2);
                }
            } else {
                BroadcastFloorListVM broadcastFloorListVM = this.this$0;
                broadcastFloorListVM.s(broadcastFloorListVM.getPageNum() - 1);
            }
        }
        if (pageEntity2 != null && pageEntity2.getHasNext()) {
            BroadcastFloorAdapter value7 = this.this$0.i().getValue();
            if (value7 != null && (loadMoreModule2 = value7.getLoadMoreModule()) != null) {
                loadMoreModule2.loadMoreComplete();
            }
        } else {
            BroadcastFloorAdapter value8 = this.this$0.i().getValue();
            if (value8 != null && (loadMoreModule = value8.getLoadMoreModule()) != null) {
                BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
            }
        }
        return Unit.INSTANCE;
    }
}
