package com.huachenjie.works.page.alumni.good_stuff;

import android.text.TextUtils;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.ad.util.OAIDUtil;
import com.huachenjie.works.api.RequestModel;
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
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.alumni.good_stuff.GoodStuffItemVM$queryPageList$2", f = "GoodStuffItemVM.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
public final class GoodStuffItemVM$queryPageList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GoodStuffItemVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodStuffItemVM$queryPageList$2(GoodStuffItemVM goodStuffItemVM, Continuation<? super GoodStuffItemVM$queryPageList$2> continuation) {
        super(2, continuation);
        this.this$0 = goodStuffItemVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GoodStuffItemVM$queryPageList$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:76:0x014e  */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        List list;
        GoodStuffAdapter value;
        BaseLoadMoreModule loadMoreModule;
        BaseLoadMoreModule loadMoreModule2;
        List list2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (TextUtils.isEmpty(OAIDUtil.com.kc.openset.constant.DeviceIdType.OAID java.lang.String)) {
                str = "";
            } else {
                String str2 = OAIDUtil.com.kc.openset.constant.DeviceIdType.OAID java.lang.String;
                Intrinsics.checkNotNull(str2);
                str = str2;
            }
            String str3 = TextUtils.isEmpty(str) ? "" : "OAID";
            RequestModel requestModel = RequestModel.f36762a;
            int pageNum = this.this$0.getPageNum();
            String zoneNo = this.this$0.getZoneNo();
            this.label = 1;
            obj = requestModel.S(pageNum, zoneNo, str3, str, this);
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
        this.this$0.r(pageEntity != null ? pageEntity.getRefreshTime() : null);
        if (this.this$0.getPageNum() == 1) {
            this.this$0.m().setValue(Boxing.boxBoolean(false));
            if ((pageEntity != null ? pageEntity.getList() : null) == null || pageEntity.getList().isEmpty()) {
                GoodStuffAdapter value2 = this.this$0.i().getValue();
                if (value2 != null) {
                    value2.setList(null);
                }
                GoodStuffAdapter value3 = this.this$0.i().getValue();
                if (value3 != null) {
                    value3.q();
                }
            } else {
                GoodStuffAdapter value4 = this.this$0.i().getValue();
                if (value4 != null) {
                    value4.m();
                }
                GoodStuffAdapter value5 = this.this$0.i().getValue();
                if (value5 != null) {
                    value5.setList(pageEntity.getList());
                }
            }
        } else {
            if ((pageEntity == null || (list = pageEntity.getList()) == null || !(list.isEmpty() ^ true)) ? false : true) {
                GoodStuffAdapter value6 = this.this$0.i().getValue();
                if (value6 != null) {
                    List list3 = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list3, "data.list");
                    value6.addData((Collection) list3);
                }
            } else {
                GoodStuffItemVM goodStuffItemVM = this.this$0;
                goodStuffItemVM.q(goodStuffItemVM.getPageNum() - 1);
            }
        }
        if (pageEntity != null && pageEntity.getHasNext()) {
            if ((pageEntity == null || (list2 = pageEntity.getList()) == null || !(list2.isEmpty() ^ true)) ? false : true) {
                GoodStuffAdapter value7 = this.this$0.i().getValue();
                if (value7 != null && (loadMoreModule2 = value7.getLoadMoreModule()) != null) {
                    loadMoreModule2.loadMoreComplete();
                }
            } else {
                value = this.this$0.i().getValue();
                if (value != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
            }
        } else {
            value = this.this$0.i().getValue();
            if (value != null && (loadMoreModule = value.getLoadMoreModule()) != null) {
                BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
            }
        }
        return Unit.INSTANCE;
    }
}
