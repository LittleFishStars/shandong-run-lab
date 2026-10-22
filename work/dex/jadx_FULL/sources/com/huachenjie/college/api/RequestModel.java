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
import com.huachenjie.common.reconfig.mvvm.BaseRepository;
import com.huachenjie.common.reconfig.net.BaseRepositoryExtKt;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.PageEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b8\u00109J\u001b\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\n\u001a\u0004\u0018\u00010\tH\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0006J-\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0006J\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0006J3\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00032\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u00032\u0006\u0010\u0019\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\u0004\u0018\u00010#H\u0086@ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0006J\u0015\u0010&\u001a\u0004\u0018\u00010%H\u0086@ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0006J\u0015\u0010(\u001a\u0004\u0018\u00010'H\u0086@ø\u0001\u0000¢\u0006\u0004\b(\u0010\u0006JC\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u001d\u00101\u001a\u0004\u0018\u0001002\u0006\u0010/\u001a\u00020\u001aH\u0086@ø\u0001\u0000¢\u0006\u0004\b1\u00102J#\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\u00032\u0006\u0010/\u001a\u00020\u001aH\u0086@ø\u0001\u0000¢\u0006\u0004\b4\u00102J%\u00106\u001a\u0004\u0018\u00010\u00122\u0006\u0010/\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001aH\u0086@ø\u0001\u0000¢\u0006\u0004\b6\u00107\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, d2 = {"Lcom/huachenjie/college/api/RequestModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseRepository;", "Lcom/huachenjie/college/api/CollegeApi;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/college/bean/CampusApplicationBean;", "c", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/college/bean/FitnessPermissionBean;", "d", "Lcom/huachenjie/college/bean/CampusLetterRedDotBean;", j.b, "Lcom/huachenjie/college/bean/GameUserBean;", "f", "", "startTime", "", "viewTime", "receiveFlag", "", "s", "(JIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/college/bean/SchoolDetailBean;", "m", "Lcom/huachenjie/college/bean/CollegeTownBean;", "e", "pageNum", "", "refreshTime", "type", "Lcom/huachenjie/college/bean/RecommendItemBean;", "p", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/college/bean/PointActivityBean;", "q", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/college/bean/RunTaskBean;", "n", "Lcom/huachenjie/college/bean/HuaweiHealthEntryStatusBean;", y6b.g, "Lcom/huachenjie/college/bean/HuaweiHealthTodayDataBean;", t.d, "year", "month", "pageSize", "Lcom/huachenjie/college/bean/HuaweiHealthSportRecordBean;", "j", "(Ljava/lang/Integer;Ljava/lang/Integer;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", HWHealthSportDetailActivity.x, "Lcom/huachenjie/college/bean/HWHealthSportDetailBean;", "i", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/college/bean/HuaweiHealthDeductionOptionBean;", y6b.f, "dedPlanCode", "r", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "college_release"}, k = 1, mv = {1, 8, 0})
public final class RequestModel extends BaseRepository<CollegeApi> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RequestModel f33549a = new RequestModel();

    @Nullable
    public final Object c(@NotNull Continuation<? super PageEntity<CampusApplicationBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$getCampusApplication$2(null), continuation);
    }

    @Nullable
    public final Object d(@NotNull Continuation<? super FitnessPermissionBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$getFitnessPermission$2(null), continuation);
    }

    @Nullable
    public final Object e(@NotNull Continuation<? super CollegeTownBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryCollegeTown$2(null), continuation);
    }

    @Nullable
    public final Object f(@NotNull Continuation<? super GameUserBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryGameUserNo$2(null), continuation);
    }

    @Nullable
    public final Object g(@NotNull String str, @NotNull Continuation<? super PageEntity<HuaweiHealthDeductionOptionBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryHuaweiHealthDeductionOptions$2(str, null), continuation);
    }

    @Nullable
    public final Object h(@NotNull Continuation<? super HuaweiHealthEntryStatusBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryHuaweiHealthEntryStatus$2(null), continuation);
    }

    @Nullable
    public final Object i(@NotNull String str, @NotNull Continuation<? super HWHealthSportDetailBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryHuaweiHealthSportDetail$2(str, null), continuation);
    }

    @Nullable
    public final Object j(@Nullable Integer num, @Nullable Integer num2, int i, int i2, @NotNull Continuation<? super PageEntity<HuaweiHealthSportRecordBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryHuaweiHealthSportRecords$2(num, num2, i, i2, null), continuation);
    }

    @Nullable
    public final Object l(@NotNull Continuation<? super HuaweiHealthTodayDataBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryHuaweiHealthTodayData$2(null), continuation);
    }

    @Nullable
    public final Object m(@NotNull Continuation<? super SchoolDetailBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$querySchoolDetail$2(null), continuation);
    }

    @Nullable
    public final Object n(@NotNull Continuation<? super RunTaskBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryTaskStatus$2(null), continuation);
    }

    @Nullable
    public final Object o(@NotNull Continuation<? super CampusLetterRedDotBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$requestCampusLetterRedDot$2(null), continuation);
    }

    @Nullable
    public final Object p(int i, @NotNull String str, @NotNull String str2, @NotNull Continuation<? super PageEntity<RecommendItemBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$requestCollegeTownBanner$2(i, str, str2, null), continuation);
    }

    @Nullable
    public final Object q(int i, @NotNull Continuation<? super PageEntity<PointActivityBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$requestPointActivityList$2(i, null), continuation);
    }

    @Nullable
    public final Object r(@NotNull String str, @NotNull String str2, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$submitHuaweiHealthDeduction$2(str, str2, null), continuation);
    }

    @Nullable
    public final Object s(long j, int i, int i2, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$uploadGameRecordInfo$2(j, i, i2, null), continuation);
    }
}
