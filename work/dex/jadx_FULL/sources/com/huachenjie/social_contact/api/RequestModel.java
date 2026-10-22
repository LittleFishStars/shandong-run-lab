package com.huachenjie.social_contact.api;

import com.huachenjie.common.reconfig.mvvm.BaseRepository;
import com.huachenjie.common.reconfig.net.BaseRepositoryExtKt;
import com.huachenjie.social_contact.bean.DrinkCategory;
import com.huachenjie.social_contact.bean.DrinkDetailBean;
import huachenjie.sdk.http.PageEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/social_contact/api/RequestModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseRepository;", "Lcom/huachenjie/social_contact/api/UniverseApi;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/social_contact/bean/DrinkCategory;", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "pageNum", "pageSize", "categoryCode", "Lcom/huachenjie/social_contact/bean/DrinkDetailBean;", "e", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "drinkId", "", "c", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class RequestModel extends BaseRepository<UniverseApi> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RequestModel f36069a = new RequestModel();

    @Nullable
    public final Object c(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$purchaseDrink$2(str, null), continuation);
    }

    @Nullable
    public final Object d(@NotNull Continuation<? super PageEntity<DrinkCategory>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryDrinkCategories$2(null), continuation);
    }

    @Nullable
    public final Object e(int i, int i2, int i3, @NotNull Continuation<? super PageEntity<DrinkDetailBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryDrinkList$2(i, i2, i3, null), continuation);
    }
}
