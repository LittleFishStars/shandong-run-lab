package com.huachenjie.shandong_school.api;

import com.alibaba.fastjson.JSONObject;
import com.huachenjie.base.bean.ActivityPopBean;
import com.huachenjie.base.bean.MainTabRedDotBean;
import com.huachenjie.common.bean.BaseEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0005J%\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\b\b\u0001\u0010\t\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\b\b\u0001\u0010\f\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000bJ\u001b\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/shandong_school/api/AppApi;", "", "Lcom/huachenjie/common/bean/BaseEntity;", "Lcom/alibaba/fastjson/JSONObject;", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/base/bean/ActivityPopBean;", "e", "", "activityNo", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cid", "d", "Lcom/huachenjie/base/bean/MainTabRedDotBean;", "b", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
public interface AppApi {
    @FormUrlEncoded
    @POST("run-front/activity/read")
    @Nullable
    Object a(@Field("activityNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/common/bottom-bar/redDot")
    @Nullable
    Object b(@NotNull Continuation<? super BaseEntity<MainTabRedDotBean>> continuation);

    @POST("run-front/api/message/redDot")
    @Nullable
    Object c(@NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @FormUrlEncoded
    @POST("run-front/push/updateGetuiCid")
    @Nullable
    Object d(@Field("cid") @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/home/sports/getPopup")
    @Nullable
    Object e(@NotNull Continuation<? super BaseEntity<ActivityPopBean>> continuation);
}
