package com.huachenjie.ad.api;

import com.huachenjie.common.bean.BaseEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J9\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/huachenjie/ad/api/AdApi;", "", "", "advertisementPlanCode", "position", "", "eventType", "Lcom/huachenjie/common/bean/BaseEntity;", "a", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ad_release"}, k = 1, mv = {1, 8, 0})
public interface AdApi {
    @FormUrlEncoded
    @POST("run-front/ad/saveEvent")
    @Nullable
    Object a(@Field("advertisementPlanCode") @NotNull String str, @Field("position") @NotNull String str2, @Field("eventType") int i, @NotNull Continuation<? super BaseEntity<Object>> continuation);
}
