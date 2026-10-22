package com.huachenjie.mall.page.home_tab;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.bean.MallSearchBannerBean;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.home_tab.MallHomeVM$queryMallSearchBanner$2", f = "MallHomeVM.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nMallHomeVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MallHomeVM.kt\ncom/huachenjie/mall/page/home_tab/MallHomeVM$queryMallSearchBanner$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,105:1\n1549#2:106\n1620#2,3:107\n*S KotlinDebug\n*F\n+ 1 MallHomeVM.kt\ncom/huachenjie/mall/page/home_tab/MallHomeVM$queryMallSearchBanner$2\n*L\n84#1:106\n84#1:107,3\n*E\n"})
public final class MallHomeVM$queryMallSearchBanner$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MallHomeVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MallHomeVM$queryMallSearchBanner$2(MallHomeVM mallHomeVM, Continuation<? super MallHomeVM$queryMallSearchBanner$2> continuation) {
        super(2, continuation);
        this.this$0 = mallHomeVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MallHomeVM$queryMallSearchBanner$2(this.this$0, continuation);
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
            MallModel mallModel = MallModel.f34763a;
            this.label = 1;
            obj = mallModel.H(this);
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
        if (pageEntity == null || pageEntity.getList() == null || pageEntity.getList().isEmpty()) {
            this.this$0.m().setValue(Boxing.boxBoolean(true));
            this.this$0.o().setValue(CollectionsKt.mutableListOf(new String[]{"请输入搜索词"}));
        } else {
            this.this$0.m().setValue(Boxing.boxBoolean(false));
            MutableLiveData<List<String>> mutableLiveDataO = this.this$0.o();
            List list = pageEntity.getList();
            Intrinsics.checkNotNullExpressionValue(list, "data.list");
            List list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((MallSearchBannerBean) it.next()).getPresetWord());
            }
            mutableLiveDataO.setValue(CollectionsKt.toList(arrayList));
        }
        return Unit.INSTANCE;
    }
}
