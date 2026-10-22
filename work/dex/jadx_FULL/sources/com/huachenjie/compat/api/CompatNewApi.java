package com.huachenjie.compat.api;

import com.huachenjie.base.bean.BindInfo;
import com.huachenjie.base.bean.NotifyConfigList;
import com.huachenjie.common.bean.BaseEntity;
import com.huachenjie.compat.bean.PhonePreCheck;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ%\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\b\b\u0001\u0010\u000b\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0005J\u001b\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0005J%\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\tJ%\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\tJ\u001b\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/compat/api/CompatNewApi;", "", "Lcom/huachenjie/common/bean/BaseEntity;", "Lcom/huachenjie/base/bean/NotifyConfigList;", "e", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lokhttp3/RequestBody;", "body", "a", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "feedbackContent", "c", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "Lcom/huachenjie/base/bean/BindInfo;", y6b.f, "b", y6b.g, "Lcom/huachenjie/compat/bean/PhonePreCheck;", "f", "compat_release"}, k = 1, mv = {1, 8, 0})
public interface CompatNewApi {
    @POST("run-front/push/updateUserNotifyConfig")
    @Nullable
    Object a(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/account/bindThirdUser")
    @Nullable
    Object b(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/ad/feedback")
    @Nullable
    Object c(@Field("feedbackContent") @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/face/closeUserFace")
    @Nullable
    Object d(@NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/push/getUserNotifyConfig")
    @Nullable
    Object e(@NotNull Continuation<? super BaseEntity<NotifyConfigList>> continuation);

    @POST("run-front/account/changePhoneCheck")
    @Nullable
    Object f(@NotNull Continuation<? super BaseEntity<PhonePreCheck>> continuation);

    @POST("run-front/account/getUserSettings")
    @Nullable
    Object g(@NotNull Continuation<? super BaseEntity<BindInfo>> continuation);

    @POST("run-front/account/unBindThirdUser")
    @Nullable
    Object h(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<Object>> continuation);
}
