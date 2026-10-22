package com.huachenjie.base.api;

import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.AddressInfo;
import com.huachenjie.base.bean.BindInfo;
import com.huachenjie.base.bean.CommonSwitchConfig;
import com.huachenjie.base.bean.EntryTypeUrlBean;
import com.huachenjie.base.bean.InspirationWidgetInfo;
import com.huachenjie.base.bean.LetterData;
import com.huachenjie.base.bean.UserThirdInfo;
import com.huachenjie.base.bean.WorksConfig;
import com.huachenjie.base.bean.reward.RewardInfoBean;
import com.huachenjie.common.bean.BrandPromotionConfigBean;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.bean.CustomerServerStatusData;
import com.huachenjie.common.bean.SemesterBean;
import com.huachenjie.common.bean.VersionUpgrade;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.BaseEntity;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u00052\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H'J1\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t2\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00060\u0005H'J\u001b\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\tH§@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\tH§@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0011J%\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\t2\b\b\u0001\u0010\u0015\u001a\u00020\u0014H§@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\t2\b\b\u0001\u0010\u0015\u001a\u00020\u0014H§@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0018J\u001b\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\tH§@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0011J\u0018\u0010\u001d\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u00060\u0005H'J\u0016\u0010\u001f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u00060\u0005H'J%\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\t2\b\b\u0001\u0010!\u001a\u00020 H§@ø\u0001\u0000¢\u0006\u0004\b#\u0010$J/\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\b\b\u0001\u0010%\u001a\u00020\u00032\b\b\u0001\u0010&\u001a\u00020 H§@ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001a\u0010*\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u00010\u0006\u0018\u00010\u0005H'J%\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\t2\b\b\u0001\u0010+\u001a\u00020 H§@ø\u0001\u0000¢\u0006\u0004\b-\u0010$J%\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\b\b\u0001\u0010.\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u001b\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH§@ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0011J\u001b\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\tH§@ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0011J'\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\n\b\u0001\u00104\u001a\u0004\u0018\u00010\u0003H§@ø\u0001\u0000¢\u0006\u0004\b5\u00100J9\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090\t2\b\b\u0001\u00106\u001a\u00020\u00032\b\b\u0001\u00107\u001a\u00020 2\b\b\u0001\u00108\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0004\b:\u0010;J9\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090\t2\b\b\u0001\u00106\u001a\u00020\u00032\b\b\u0001\u00107\u001a\u00020 2\b\b\u0001\u00108\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0004\b<\u0010;J9\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\b\b\u0001\u0010=\u001a\u00020\u00032\b\b\u0001\u0010>\u001a\u00020\u00032\b\b\u0001\u0010?\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u001b\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010B0\tH§@ø\u0001\u0000¢\u0006\u0004\bC\u0010\u0011J\u0014\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\u00060\u0005H'\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006F"}, d2 = {"Lcom/huachenjie/base/api/BaseApi;", "", "", "", "map", "Lrx/Observable;", "Lhuachenjie/sdk/http/BaseEntity;", "Lcom/huachenjie/common/bean/CommonUserInfo;", "b", "Lcom/huachenjie/common/bean/BaseEntity;", "m", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/huachenjie/common/bean/SemesterBean;", "d", "Lcom/huachenjie/base/bean/InspirationWidgetInfo;", "i", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/common/bean/VersionUpgrade;", t.d, "Lokhttp3/RequestBody;", "body", "", "t", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "r", "Lcom/huachenjie/common/bean/CustomerServerStatusData;", "s", "Lcom/huachenjie/base/bean/WorksConfig;", "u", "Lcom/huachenjie/base/bean/CommonSwitchConfig;", "a", "", "source", "Lcom/huachenjie/base/bean/UserThirdInfo;", y6b.g, "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authAgreementCode", "status", "w", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/base/bean/AddressInfo;", "v", "entryType", "Lcom/huachenjie/base/bean/EntryTypeUrlBean;", y6b.f, "faceImg", "e", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "n", "Lcom/huachenjie/base/bean/LetterData;", "q", "schoolLetterRelationCode", "k", "lotteryNo", "inspiration", "awardNo", "Lcom/huachenjie/base/bean/reward/RewardInfoBean;", "c", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "p", "runRecordCode", "bizNo", "freeDetailNo", "f", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/common/bean/BrandPromotionConfigBean;", "j", "Lcom/huachenjie/base/bean/BindInfo;", j.b, "base_release"}, k = 1, mv = {1, 8, 0})
public interface BaseApi {
    @POST("run-front/api/common/getCommonConfig")
    @NotNull
    Observable<BaseEntity<CommonSwitchConfig>> a();

    @FormUrlEncoded
    @POST("run-front/account/queryCommonUserInfo")
    @NotNull
    Observable<BaseEntity<CommonUserInfo>> b(@FieldMap @NotNull Map<String, String> map);

    @FormUrlEncoded
    @POST("run-front/api/lottery/award/draw")
    @Nullable
    Object c(@Field("lotteryNo") @NotNull String str, @Field("inspiration") int i, @Field("awardNo") @NotNull String str2, @NotNull Continuation<? super com.huachenjie.common.bean.BaseEntity<RewardInfoBean>> continuation);

    @POST("run-front/attend/semesterSelector")
    @NotNull
    Observable<BaseEntity<List<SemesterBean>>> d();

    @FormUrlEncoded
    @POST("run-front/face/updateUserFace")
    @Nullable
    Object e(@Field("faceImg") @NotNull String str, @NotNull Continuation<? super com.huachenjie.common.bean.BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/run/free/detail")
    @Nullable
    Object f(@Field("runRecordCode") @NotNull String str, @Field("bizNo") @NotNull String str2, @Field("freeDetailNo") @NotNull String str3, @NotNull Continuation<? super com.huachenjie.common.bean.BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/home/getEntryUrl")
    @Nullable
    Object g(@Field("entryType") int i, @NotNull Continuation<? super com.huachenjie.common.bean.BaseEntity<EntryTypeUrlBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/agreement/queryUserThirdInfo")
    @Nullable
    Object h(@Field("source") int i, @NotNull Continuation<? super com.huachenjie.common.bean.BaseEntity<UserThirdInfo>> continuation);

    @POST("run-front/app/api/widget/content")
    @Nullable
    Object i(@NotNull Continuation<? super com.huachenjie.common.bean.BaseEntity<InspirationWidgetInfo>> continuation);

    @POST("run-front/brandPromotion/queryConfig")
    @Nullable
    Object j(@NotNull Continuation<? super com.huachenjie.common.bean.BaseEntity<BrandPromotionConfigBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/schoolLetter/clearNoRead")
    @Nullable
    Object k(@Field("schoolLetterRelationCode") @Nullable String str, @NotNull Continuation<? super com.huachenjie.common.bean.BaseEntity<Object>> continuation);

    @POST("run-front/common/update")
    @Nullable
    Object l(@NotNull Continuation<? super com.huachenjie.common.bean.BaseEntity<VersionUpgrade>> continuation);

    @FormUrlEncoded
    @POST("run-front/account/queryCommonUserInfo")
    @Nullable
    Object m(@FieldMap @NotNull Map<String, String> map, @NotNull Continuation<? super com.huachenjie.common.bean.BaseEntity<CommonUserInfo>> continuation);

    @POST("run-front/face/bindUserFace")
    @Nullable
    Object n(@NotNull Continuation<? super com.huachenjie.common.bean.BaseEntity<Object>> continuation);

    @POST("run-front/account/getUserSettings")
    @NotNull
    Observable<BaseEntity<BindInfo>> o();

    @FormUrlEncoded
    @POST("run-front/api/lottery/award/redeem")
    @Nullable
    Object p(@Field("lotteryNo") @NotNull String str, @Field("inspiration") int i, @Field("awardNo") @NotNull String str2, @NotNull Continuation<? super com.huachenjie.common.bean.BaseEntity<RewardInfoBean>> continuation);

    @POST("run-front/schoolLetter/importantLetterList")
    @Nullable
    Object q(@NotNull Continuation<? super com.huachenjie.common.bean.BaseEntity<LetterData>> continuation);

    @POST("run-front/rank/user/like/event")
    @Nullable
    Object r(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super com.huachenjie.common.bean.BaseEntity<Boolean>> continuation);

    @POST("run-front/customer/getCustomerStatus")
    @Nullable
    Object s(@NotNull Continuation<? super com.huachenjie.common.bean.BaseEntity<CustomerServerStatusData>> continuation);

    @POST("run-front/api/works/interact/event")
    @Nullable
    Object t(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super com.huachenjie.common.bean.BaseEntity<Boolean>> continuation);

    @POST("run-front/api/works/worksConfig")
    @NotNull
    Observable<BaseEntity<WorksConfig>> u();

    @POST("run-front/common/city")
    @Nullable
    Observable<BaseEntity<AddressInfo>> v();

    @FormUrlEncoded
    @POST("run-front/agreement/bindAuthAgreement")
    @Nullable
    Object w(@Field("authAgreementCode") @NotNull String str, @Field("status") int i, @NotNull Continuation<? super com.huachenjie.common.bean.BaseEntity<Object>> continuation);
}
