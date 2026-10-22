package com.huachenjie.college.api;

import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.college.bean.CampusApplicationBean;
import com.huachenjie.college.bean.CampusLetterRedDotBean;
import com.huachenjie.college.bean.CollegeTownBean;
import com.huachenjie.college.bean.FitnessPermissionBean;
import com.huachenjie.college.bean.GameUserBean;
import com.huachenjie.college.bean.HWHealthSportDetailBean;
import com.huachenjie.college.bean.HuaweiHealthDeductionOptionBean;
import com.huachenjie.college.bean.HuaweiHealthEntryStatusBean;
import com.huachenjie.college.bean.HuaweiHealthSportRecordBean;
import com.huachenjie.college.bean.HuaweiHealthTodayDataBean;
import com.huachenjie.college.bean.PointActivityBean;
import com.huachenjie.college.bean.RecommendItemBean;
import com.huachenjie.college.bean.RunTaskBean;
import com.huachenjie.college.bean.SchoolDetailBean;
import com.huachenjie.college.page.hw_health_detail.HWHealthSportDetailActivity;
import com.huachenjie.common.bean.BaseEntity;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.PageEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J!\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006J\u001b\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0006J\u001b\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0006J9\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0011\u001a\u00020\u000fH§@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0006JH\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001b0\u001a2\b\b\u0001\u0010\u0017\u001a\u00020\u00162\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0018\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u0019\u001a\u00020\u0016H'J\u001b\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0006JI\u0010$\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00030\u00022\b\b\u0001\u0010\u001f\u001a\u00020\u000f2\b\b\u0001\u0010 \u001a\u00020\u00162\b\b\u0001\u0010!\u001a\u00020\u000f2\b\b\u0001\u0010\"\u001a\u00020\u0016H§@ø\u0001\u0000¢\u0006\u0004\b$\u0010%J5\u0010'\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00030\u00022\b\b\u0001\u0010\u001f\u001a\u00020\u000f2\b\b\u0001\u0010!\u001a\u00020\u000fH§@ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001b\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u0002H§@ø\u0001\u0000¢\u0006\u0004\b*\u0010\u0006J\u001b\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0\u0002H§@ø\u0001\u0000¢\u0006\u0004\b,\u0010\u0006J\u001b\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0\u0002H§@ø\u0001\u0000¢\u0006\u0004\b.\u0010\u0006JM\u00102\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000201\u0018\u00010\u00030\u00022\n\b\u0003\u0010/\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u00100\u001a\u0004\u0018\u00010\u000f2\b\b\u0001\u0010\u001f\u001a\u00020\u000f2\b\b\u0001\u0010!\u001a\u00020\u000fH§@ø\u0001\u0000¢\u0006\u0004\b2\u00103J%\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u00022\b\b\u0001\u00104\u001a\u00020\u0016H§@ø\u0001\u0000¢\u0006\u0004\b6\u00107J+\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000208\u0018\u00010\u00030\u00022\b\b\u0001\u00104\u001a\u00020\u0016H§@ø\u0001\u0000¢\u0006\u0004\b9\u00107J/\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\b\b\u0001\u00104\u001a\u00020\u00162\b\b\u0001\u0010:\u001a\u00020\u0016H§@ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006="}, d2 = {"Lcom/huachenjie/college/api/CollegeApi;", "", "Lcom/huachenjie/common/bean/BaseEntity;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/college/bean/CampusApplicationBean;", y6b.f, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/college/bean/FitnessPermissionBean;", "q", "Lcom/huachenjie/college/bean/CampusLetterRedDotBean;", "m", "Lcom/huachenjie/college/bean/GameUserBean;", j.b, "", "startTime", "", "viewTime", "receiveFlag", "d", "(JIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/college/bean/SchoolDetailBean;", t.d, "", "adCode", "durationTime", "thirdUserId", "Lrx/Observable;", "Lhuachenjie/sdk/http/BaseEntity;", "k", "Lcom/huachenjie/college/bean/CollegeTownBean;", "j", "pageNum", "refreshTime", "pageSize", "type", "Lcom/huachenjie/college/bean/RecommendItemBean;", "p", "(ILjava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/college/bean/PointActivityBean;", "i", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/college/bean/RunTaskBean;", "n", "Lcom/huachenjie/college/bean/HuaweiHealthEntryStatusBean;", "f", "Lcom/huachenjie/college/bean/HuaweiHealthTodayDataBean;", "c", "year", "month", "Lcom/huachenjie/college/bean/HuaweiHealthSportRecordBean;", y6b.g, "(Ljava/lang/Integer;Ljava/lang/Integer;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", HWHealthSportDetailActivity.x, "Lcom/huachenjie/college/bean/HWHealthSportDetailBean;", "b", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/college/bean/HuaweiHealthDeductionOptionBean;", "a", "dedPlanCode", "e", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "college_release"}, k = 1, mv = {1, 8, 0})
public interface CollegeApi {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ Object a(CollegeApi collegeApi, Integer num, Integer num2, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                return collegeApi.h((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : num2, i, i2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryHuaweiHealthSportRecords");
        }
    }

    @FormUrlEncoded
    @POST("run-front/api/huawei/health/deduction/options")
    @Nullable
    Object a(@Field(HWHealthSportDetailActivity.x) @NotNull String str, @NotNull Continuation<? super BaseEntity<PageEntity<HuaweiHealthDeductionOptionBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/huawei/health/sport/record/detail")
    @Nullable
    Object b(@Field(HWHealthSportDetailActivity.x) @NotNull String str, @NotNull Continuation<? super BaseEntity<HWHealthSportDetailBean>> continuation);

    @POST("run-front/api/huawei/health/data/today")
    @Nullable
    Object c(@NotNull Continuation<? super BaseEntity<HuaweiHealthTodayDataBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/game/adRecord")
    @Nullable
    Object d(@Field("startTime") long j, @Field("viewTime") int i, @Field("receiveFlag") int i2, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/huawei/health/deduction/submit")
    @Nullable
    Object e(@Field(HWHealthSportDetailActivity.x) @NotNull String str, @Field("dedPlanCode") @NotNull String str2, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/api/huawei/health/entry/status")
    @Nullable
    Object f(@NotNull Continuation<? super BaseEntity<HuaweiHealthEntryStatusBean>> continuation);

    @POST("run-front/account/getUserResourceList")
    @Nullable
    Object g(@NotNull Continuation<? super BaseEntity<PageEntity<CampusApplicationBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/huawei/health/sport/records")
    @Nullable
    Object h(@Field("year") @Nullable Integer num, @Field("month") @Nullable Integer num2, @Field("pageNum") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<HuaweiHealthSportRecordBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/activity/page")
    @Nullable
    Object i(@Field("pageNum") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<PointActivityBean>>> continuation);

    @POST("run-front/api/user/cs/index")
    @Nullable
    Object j(@NotNull Continuation<? super BaseEntity<CollegeTownBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/ad/adReward")
    @NotNull
    Observable<huachenjie.sdk.http.BaseEntity<Object>> k(@Field("adCode") @NotNull String adCode, @Field("platformType") int viewTime, @Field("durationTime") long durationTime, @Field("startTime") long startTime, @Field("thirdUserId") @NotNull String thirdUserId);

    @POST("run-front/api/school/details")
    @Nullable
    Object l(@NotNull Continuation<? super BaseEntity<SchoolDetailBean>> continuation);

    @POST("run-front/api/message/campusLetters")
    @Nullable
    Object m(@NotNull Continuation<? super BaseEntity<CampusLetterRedDotBean>> continuation);

    @POST("run-front/api/tasks/runTask")
    @Nullable
    Object n(@NotNull Continuation<? super BaseEntity<RunTaskBean>> continuation);

    @POST("run-front/game/getUserNo")
    @Nullable
    Object o(@NotNull Continuation<? super BaseEntity<GameUserBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/user/cs/banner/page")
    @Nullable
    Object p(@Field("pageNum") int i, @Field("refreshTime") @NotNull String str, @Field("pageSize") int i2, @Field("type") @NotNull String str2, @NotNull Continuation<? super BaseEntity<PageEntity<RecommendItemBean>>> continuation);

    @POST("run-front/fitness/permission/query")
    @Nullable
    Object q(@NotNull Continuation<? super BaseEntity<FitnessPermissionBean>> continuation);
}
