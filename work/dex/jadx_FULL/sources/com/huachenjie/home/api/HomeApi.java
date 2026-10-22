package com.huachenjie.home.api;

import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.LotteryDrawBean;
import com.huachenjie.base.bean.reward.RewardInfoBean;
import com.huachenjie.common.bean.BaseEntity;
import com.huachenjie.home.bean.AccountInspirationBean;
import com.huachenjie.home.bean.AdPopupBean;
import com.huachenjie.home.bean.CompleteTaskBean;
import com.huachenjie.home.bean.DailyTasksBean;
import com.huachenjie.home.bean.EleAuthUrlBean;
import com.huachenjie.home.bean.GoodStuffBannerBean;
import com.huachenjie.home.bean.GoodStuffBean;
import com.huachenjie.home.bean.GoodStuffPickData;
import com.huachenjie.home.bean.HomeData;
import com.huachenjie.home.bean.HomeSearchBannerData;
import com.huachenjie.home.bean.InspirationRecordBean;
import com.huachenjie.home.bean.JackpotAwardBean;
import com.huachenjie.home.bean.PointsGoodsBean;
import com.huachenjie.home.bean.ReceiveRewardBean;
import com.huachenjie.home.bean.SignConfigBean;
import com.huachenjie.home.bean.reward.ChangeRewardBean;
import com.huachenjie.home.bean.reward.HomeRewardBean;
import com.huachenjie.works.bean.BuddyCardListBean;
import com.huachenjie.works.bean.BuddyTypeBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.PageEntity;
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
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0005J-\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJQ\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u000e2\b\b\u0001\u0010\u0011\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015JS\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00120\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u000e2\b\b\u0001\u0010\u0016\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0015JK\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00120\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u000e2\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\u001a\u001a\u00020\u0019H§@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0005J\u001b\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u0002H§@ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0005J\u001b\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0005J!\u0010$\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00120\u0002H§@ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0005J\u001b\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\u0002H§@ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0005J%\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u00022\b\b\u0001\u0010(\u001a\u00020'H§@ø\u0001\u0000¢\u0006\u0004\b*\u0010+J/\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0\u00022\b\b\u0001\u0010,\u001a\u00020\b2\b\b\u0001\u0010-\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u001b\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0005J\u001b\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001030\u0002H§@ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0005J5\u00106\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000205\u0018\u00010\u00120\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0004\b6\u00107J5\u00108\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000205\u0018\u00010\u00120\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0004\b8\u00107J\u001b\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090\u0002H§@ø\u0001\u0000¢\u0006\u0004\b:\u0010\u0005JA\u0010<\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020;\u0018\u00010\u00120\u00022\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u000e2\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\bH§@ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u001b\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010>0\u0002H§@ø\u0001\u0000¢\u0006\u0004\b?\u0010\u0005J\u001b\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010@0\u0002H§@ø\u0001\u0000¢\u0006\u0004\bA\u0010\u0005J\u001b\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010B0\u0002H§@ø\u0001\u0000¢\u0006\u0004\bC\u0010\u0005J\u001b\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010D0\u0002H§@ø\u0001\u0000¢\u0006\u0004\bE\u0010\u0005J\u001b\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010B0\u0002H§@ø\u0001\u0000¢\u0006\u0004\bF\u0010\u0005J\u001b\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010B0\u0002H§@ø\u0001\u0000¢\u0006\u0004\bG\u0010\u0005J\u0019\u0010I\u001a\b\u0012\u0004\u0012\u00020H0\u0002H§@ø\u0001\u0000¢\u0006\u0004\bI\u0010\u0005J-\u0010M\u001a\b\u0012\u0004\u0012\u00020L0\u00022\b\b\u0001\u0010J\u001a\u00020\u000e2\b\b\u0001\u0010K\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ/\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\b\b\u0001\u0010O\u001a\u00020\b2\b\b\u0001\u0010P\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\bQ\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006R"}, d2 = {"Lcom/huachenjie/home/api/HomeApi;", "", "Lcom/huachenjie/common/bean/BaseEntity;", "Lcom/huachenjie/home/bean/HomeSearchBannerData;", "B", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/home/bean/HomeData;", "r", "", "deviceType", "deviceNumber", "Lcom/huachenjie/home/bean/GoodStuffPickData;", j.b, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "pageNum", "pageSize", "zoneNo", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/home/bean/GoodStuffBean;", "a", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "keyword", "t", "refreshTime", "", "historyData", "Lcom/huachenjie/base/bean/reward/RewardInfoBean;", "x", "(IILjava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/home/bean/reward/ChangeRewardBean;", "s", "Lcom/huachenjie/home/bean/reward/HomeRewardBean;", "p", y6b.f, "Lcom/huachenjie/home/bean/DailyTasksBean;", "n", "Lcom/huachenjie/home/bean/EleAuthUrlBean;", "k", "Lokhttp3/RequestBody;", "body", "Lcom/huachenjie/home/bean/CompleteTaskBean;", t.d, "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "taskNo", "viewedAd", "Lcom/huachenjie/home/bean/ReceiveRewardBean;", "u", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/home/bean/AccountInspirationBean;", "y", "Lcom/huachenjie/base/bean/LotteryDrawBean;", y6b.g, "Lcom/huachenjie/home/bean/InspirationRecordBean;", "m", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", j.o, "Lcom/huachenjie/home/bean/JackpotAwardBean;", "b", "Lcom/huachenjie/home/bean/PointsGoodsBean;", "i", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/home/bean/AdPopupBean;", "A", "Lcom/huachenjie/home/bean/GoodStuffBannerBean;", "j", "Lcom/alibaba/fastjson/JSONObject;", "D", "Lcom/huachenjie/home/bean/SignConfigBean;", "C", "E", "q", "Lcom/huachenjie/works/bean/BuddyTypeBean;", "w", "scopeType", "buddyTypeCode", "Lcom/huachenjie/works/bean/BuddyCardListBean;", "v", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buddyCode", "applyMessage", "f", "home_release"}, k = 1, mv = {1, 8, 0})
public interface HomeApi {
    @POST("run-front/home/getAdPopup")
    @Nullable
    Object A(@NotNull Continuation<? super BaseEntity<AdPopupBean>> continuation);

    @POST("run-front/api/search/suggestion/list")
    @Nullable
    Object B(@NotNull Continuation<? super BaseEntity<HomeSearchBannerData>> continuation);

    @POST("run-front/api/sign/status")
    @Nullable
    Object C(@NotNull Continuation<? super BaseEntity<SignConfigBean>> continuation);

    @POST("run-front/api/sign/todayStatus")
    @Nullable
    Object D(@NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @POST("run-front/api/sign/submit")
    @Nullable
    Object E(@NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/union/goods/page")
    @Nullable
    Object a(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("zoneNo") @NotNull String str, @Field("deviceType") @NotNull String str2, @Field("deviceNumber") @NotNull String str3, @NotNull Continuation<? super BaseEntity<PageEntity<GoodStuffBean>>> continuation);

    @POST("run-front/api/jackpot/award/home")
    @Nullable
    Object b(@NotNull Continuation<? super BaseEntity<JackpotAwardBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/buddy/apply")
    @Nullable
    Object f(@Field("buddyCode") @NotNull String str, @Field("applyMessage") @NotNull String str2, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/api/tasks/requestId")
    @Nullable
    Object g(@NotNull Continuation<? super BaseEntity<String>> continuation);

    @POST("run-front/api/jackpot/award/lotteryPage")
    @Nullable
    Object h(@NotNull Continuation<? super BaseEntity<LotteryDrawBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/goods/recommend/pagePointsGoodsList")
    @Nullable
    Object i(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<PointsGoodsBean>>> continuation);

    @POST("run-front/home/boothList")
    @Nullable
    Object j(@NotNull Continuation<? super BaseEntity<GoodStuffBannerBean>> continuation);

    @POST("run-front/api/mall/ele/authUrl")
    @Nullable
    Object k(@NotNull Continuation<? super BaseEntity<EleAuthUrlBean>> continuation);

    @POST("run-front/api/tasks/complete")
    @Nullable
    Object l(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<CompleteTaskBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/account/inspiration/recentEarnPageList")
    @Nullable
    Object m(@Field("pageNum") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<InspirationRecordBean>>> continuation);

    @POST("run-front/api/tasks/available/list")
    @Nullable
    Object n(@NotNull Continuation<? super BaseEntity<PageEntity<DailyTasksBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/home/promoSlots/config")
    @Nullable
    Object o(@Field("deviceType") @NotNull String str, @Field("deviceNumber") @NotNull String str2, @NotNull Continuation<? super BaseEntity<GoodStuffPickData>> continuation);

    @POST("run-front/api/tasks/loginOnce")
    @Nullable
    Object p(@NotNull Continuation<? super BaseEntity<HomeRewardBean>> continuation);

    @POST("run-front/api/sign/videoReward")
    @Nullable
    Object q(@NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @POST("run-front/home/homePage/config")
    @Nullable
    Object r(@NotNull Continuation<? super BaseEntity<HomeData>> continuation);

    @POST("run-front/api/jackpot/award/list")
    @Nullable
    Object s(@NotNull Continuation<? super BaseEntity<ChangeRewardBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/union/goods/search")
    @Nullable
    Object t(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("keyword") @NotNull String str, @Field("deviceType") @NotNull String str2, @Field("deviceNumber") @NotNull String str3, @NotNull Continuation<? super BaseEntity<PageEntity<GoodStuffBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/tasks/receiveReward")
    @Nullable
    Object u(@Field("taskNo") @NotNull String str, @Field("viewedAd") int i, @NotNull Continuation<? super BaseEntity<ReceiveRewardBean>> continuation);

    @FormUrlEncoded
    @POST("/run-front/buddy/home")
    @Nullable
    Object v(@Field("scopeType") int i, @Field("buddyTypeCode") @NotNull String str, @NotNull Continuation<? super BaseEntity<BuddyCardListBean>> continuation);

    @POST("run-front/buddy/type/list")
    @Nullable
    Object w(@NotNull Continuation<? super BaseEntity<BuddyTypeBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/lottery/winning/record/page")
    @Nullable
    Object x(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @Field("historyData") boolean z, @NotNull Continuation<? super BaseEntity<PageEntity<RewardInfoBean>>> continuation);

    @POST("run-front/api/account/inspiration")
    @Nullable
    Object y(@NotNull Continuation<? super BaseEntity<AccountInspirationBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/account/inspiration/recentSpendPageList")
    @Nullable
    Object z(@Field("pageNum") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<InspirationRecordBean>>> continuation);
}
