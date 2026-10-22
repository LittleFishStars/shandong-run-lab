package com.huachenjie.home.page.good_stuff;

import android.text.TextUtils;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.ad.util.OAIDUtil;
import com.huachenjie.home.api.HomeRequest;
import com.huachenjie.home.bean.GoodStuffBannerBean;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.home.page.good_stuff.GoodStuffVM$queryPageList$2", f = "GoodStuffVM.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
public final class GoodStuffVM$queryPageList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $afterRefresh;
    final /* synthetic */ GoodStuffBannerBean $banner;
    int label;
    final /* synthetic */ GoodStuffVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodStuffVM$queryPageList$2(GoodStuffVM goodStuffVM, GoodStuffBannerBean goodStuffBannerBean, Function0<Unit> function0, Continuation<? super GoodStuffVM$queryPageList$2> continuation) {
        super(2, continuation);
        this.this$0 = goodStuffVM;
        this.$banner = goodStuffBannerBean;
        this.$afterRefresh = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GoodStuffVM$queryPageList$2(this.this$0, this.$banner, this.$afterRefresh, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:87:0x0190  */
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
            HomeRequest homeRequest = HomeRequest.f34197a;
            int pageNum = this.this$0.getPageNum();
            String zoneNo = this.this$0.getZoneNo();
            this.label = 1;
            obj = homeRequest.i(pageNum, zoneNo, str3, str, this);
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
        this.this$0.t(pageEntity != null ? pageEntity.getRefreshTime() : null);
        if (this.this$0.getPageNum() == 1) {
            this.this$0.n().setValue(Boxing.boxBoolean(false));
            if ((pageEntity != null ? pageEntity.getList() : null) != null && !pageEntity.getList().isEmpty()) {
                ArrayList arrayList = new ArrayList();
                GoodStuffBannerBean goodStuffBannerBean = this.$banner;
                if (goodStuffBannerBean != null) {
                    arrayList.add(goodStuffBannerBean);
                }
                List list3 = pageEntity.getList();
                Intrinsics.checkNotNullExpressionValue(list3, "data.list");
                arrayList.addAll(list3);
                GoodStuffAdapter value2 = this.this$0.j().getValue();
                if (value2 != null) {
                    value2.o();
                }
                GoodStuffAdapter value3 = this.this$0.j().getValue();
                if (value3 != null) {
                    value3.setList(arrayList);
                }
            } else if (this.$banner != null) {
                GoodStuffAdapter value4 = this.this$0.j().getValue();
                if (value4 != null) {
                    value4.o();
                }
                GoodStuffAdapter value5 = this.this$0.j().getValue();
                if (value5 != null) {
                    value5.setList(CollectionsKt.listOf(this.$banner));
                }
            } else {
                GoodStuffAdapter value6 = this.this$0.j().getValue();
                if (value6 != null) {
                    value6.setList(null);
                }
                GoodStuffAdapter value7 = this.this$0.j().getValue();
                if (value7 != null) {
                    value7.u();
                }
            }
        } else {
            if ((pageEntity == null || (list = pageEntity.getList()) == null || !(list.isEmpty() ^ true)) ? false : true) {
                GoodStuffAdapter value8 = this.this$0.j().getValue();
                if (value8 != null) {
                    List list4 = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list4, "data.list");
                    value8.addData((Collection) list4);
                }
            } else {
                GoodStuffVM goodStuffVM = this.this$0;
                goodStuffVM.s(goodStuffVM.getPageNum() - 1);
            }
        }
        if (pageEntity != null && pageEntity.getHasNext()) {
            if ((pageEntity == null || (list2 = pageEntity.getList()) == null || !(list2.isEmpty() ^ true)) ? false : true) {
                GoodStuffAdapter value9 = this.this$0.j().getValue();
                if (value9 != null && (loadMoreModule2 = value9.getLoadMoreModule()) != null) {
                    loadMoreModule2.loadMoreComplete();
                }
            } else {
                value = this.this$0.j().getValue();
                if (value != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
            }
        } else {
            value = this.this$0.j().getValue();
            if (value != null && (loadMoreModule = value.getLoadMoreModule()) != null) {
                BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
            }
        }
        Function0<Unit> function0 = this.$afterRefresh;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }
}
