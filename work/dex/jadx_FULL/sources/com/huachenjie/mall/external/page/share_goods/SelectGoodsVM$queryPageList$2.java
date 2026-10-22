package com.huachenjie.mall.external.page.share_goods;

import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.external.bean.SelectGoodsBean;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.external.page.share_goods.SelectGoodsVM$queryPageList$2", f = "SelectGoodsVM.kt", i = {}, l = {57, 60}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nSelectGoodsVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectGoodsVM.kt\ncom/huachenjie/mall/external/page/share_goods/SelectGoodsVM$queryPageList$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,100:1\n1855#2,2:101\n*S KotlinDebug\n*F\n+ 1 SelectGoodsVM.kt\ncom/huachenjie/mall/external/page/share_goods/SelectGoodsVM$queryPageList$2\n*L\n63#1:101,2\n*E\n"})
public final class SelectGoodsVM$queryPageList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isSingleSelect;
    final /* synthetic */ ArrayList<String> $selectedList;
    final /* synthetic */ int $type;
    int label;
    final /* synthetic */ SelectGoodsVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectGoodsVM$queryPageList$2(int i, SelectGoodsVM selectGoodsVM, ArrayList<String> arrayList, boolean z, Continuation<? super SelectGoodsVM$queryPageList$2> continuation) {
        super(2, continuation);
        this.$type = i;
        this.this$0 = selectGoodsVM;
        this.$selectedList = arrayList;
        this.$isSingleSelect = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SelectGoodsVM$queryPageList$2(this.$type, this.this$0, this.$selectedList, this.$isSingleSelect, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        PageEntity pageEntity;
        List list;
        BaseLoadMoreModule loadMoreModule;
        BaseLoadMoreModule loadMoreModule2;
        List<SelectGoodsBean> list2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$type == 1) {
                MallModel mallModel = MallModel.f34763a;
                int iJ = this.this$0.getPageNum();
                String strK = this.this$0.getRefreshTime();
                str = strK != null ? strK : "";
                this.label = 1;
                obj = mallModel.r(iJ, str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pageEntity = (PageEntity) obj;
            } else {
                MallModel mallModel2 = MallModel.f34763a;
                int iJ2 = this.this$0.getPageNum();
                String strK2 = this.this$0.getRefreshTime();
                str = strK2 != null ? strK2 : "";
                this.label = 2;
                obj = mallModel2.W(iJ2, str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pageEntity = (PageEntity) obj;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            pageEntity = (PageEntity) obj;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            pageEntity = (PageEntity) obj;
        }
        ArrayList<String> arrayList = this.$selectedList;
        if (arrayList != null) {
            boolean z = this.$isSingleSelect;
            if (pageEntity != null && (list2 = pageEntity.getList()) != null) {
                for (SelectGoodsBean selectGoodsBean : list2) {
                    selectGoodsBean.setChecked(arrayList.contains(selectGoodsBean.getGoodsNo()));
                    selectGoodsBean.setSingleSelect(z);
                }
            }
        }
        this.this$0.p(pageEntity != null ? pageEntity.getRefreshTime() : null);
        if (this.this$0.getPageNum() == 1) {
            if ((pageEntity != null ? pageEntity.getList() : null) == null || pageEntity.getList().isEmpty()) {
                SelectGoodsAdapter value = this.this$0.i().getValue();
                if (value != null) {
                    value.setList(null);
                }
            } else {
                SelectGoodsAdapter value2 = this.this$0.i().getValue();
                if (value2 != null) {
                    value2.setList(pageEntity.getList());
                }
            }
        } else if ((pageEntity == null || (list = pageEntity.getList()) == null || !(list.isEmpty() ^ true)) ? false : true) {
            SelectGoodsAdapter value3 = this.this$0.i().getValue();
            if (value3 != null) {
                List list3 = pageEntity.getList();
                Intrinsics.checkNotNullExpressionValue(list3, "data.list");
                value3.addData((Collection) list3);
            }
        } else {
            SelectGoodsVM selectGoodsVM = this.this$0;
            selectGoodsVM.o(selectGoodsVM.getPageNum() - 1);
        }
        if (pageEntity != null && pageEntity.getHasNext()) {
            SelectGoodsAdapter value4 = this.this$0.i().getValue();
            if (value4 != null && (loadMoreModule2 = value4.getLoadMoreModule()) != null) {
                loadMoreModule2.loadMoreComplete();
            }
        } else {
            SelectGoodsAdapter value5 = this.this$0.i().getValue();
            if (value5 != null && (loadMoreModule = value5.getLoadMoreModule()) != null) {
                BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
            }
        }
        return Unit.INSTANCE;
    }
}
