package com.huachenjie.sport.api;

import com.alibaba.fastjson.JSONObject;
import com.byazt.bv.BaseConstants;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.LetterBean;
import com.huachenjie.common.bean.SunshineRecordListEntity;
import com.huachenjie.sport.bean.AttendanceCalendarBean;
import com.huachenjie.sport.bean.AttendancePlanBean;
import com.huachenjie.sport.bean.AttendanceRecordData;
import com.huachenjie.sport.bean.AttendanceStatisticsBean;
import com.huachenjie.sport.bean.CampusLetterBean;
import com.huachenjie.sport.bean.ClassDetailBean;
import com.huachenjie.sport.bean.ExamDetailData;
import com.huachenjie.sport.bean.ExamPageList;
import com.huachenjie.sport.bean.ExamQuestionData;
import com.huachenjie.sport.bean.HuodongDetailBean;
import com.huachenjie.sport.bean.InformedConsentDetailBean;
import com.huachenjie.sport.bean.OutsideAttendanceData;
import com.huachenjie.sport.bean.OutsideAttendanceDetail;
import com.huachenjie.sport.bean.OutsideCalendarData;
import com.huachenjie.sport.bean.PEClassesListBean;
import com.huachenjie.sport.bean.PEClassesSelectorBean;
import com.huachenjie.sport.bean.ProblemData;
import com.huachenjie.sport.bean.RemainCountBean;
import com.huachenjie.sport.bean.RunRankBean;
import com.huachenjie.sport.bean.SchoolyardBean;
import com.huachenjie.sport.bean.SportTestDetailBean;
import com.huachenjie.sport.bean.SportTestListBean;
import com.huachenjie.sport.bean.SportTestPeriodBean;
import com.huachenjie.sport.bean.SportTestResultBean;
import com.huachenjie.sport.bean.SportTestResultYearBean;
import com.huachenjie.sport.bean.UserRunRankBean;
import com.huachenjie.sport.page.mine.exam.ExamHistoryResultsActivity;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.PageEntity;
import java.util.List;
import kotlin.Metadata;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u0002H'J4\u0010\u000b\u001a\u001a\u0012\u0014\u0012\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0018\u00010\u0003\u0018\u00010\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H'J&\u0010\u000e\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0018\u00010\u00022\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\fH'J&\u0010\u000f\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0018\u00010\u00022\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\fH'J$\u0010\u0011\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0003\u0018\u00010\u00022\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\fH'J$\u0010\u0013\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0003\u0018\u00010\u00022\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\fH'J$\u0010\u0016\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u00030\u00022\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\fH'J\u0018\u0010\u0018\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u00030\u0002H'J$\u0010\u001b\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u00030\u00022\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\fH'J\u0018\u0010\u001d\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u00030\u0002H'J$\u0010\u001f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u001e\u0018\u00010\u00030\u00022\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\fH'J&\u0010!\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010\u0003\u0018\u00010\u00022\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\fH'J0\u0010$\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0018\u00010\u00022\b\b\u0001\u0010#\u001a\u00020\"2\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\fH'J$\u0010'\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00030\u00022\n\b\u0001\u0010&\u001a\u0004\u0018\u00010%H'J$\u0010)\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010(\u0018\u00010\u00030\u00022\n\b\u0001\u0010&\u001a\u0004\u0018\u00010%H'J\u0018\u0010+\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010*\u0018\u00010\u00030\u0002H'J$\u0010.\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010-\u0018\u00010\u00030\u00022\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\fH'J$\u0010/\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00030\u00022\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\fH'J$\u00101\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010\u00030\u00022\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\fH'J$\u00102\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00030\u00022\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\fH'J\u0018\u00104\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u000103\u0018\u00010\u00030\u0002H'J$\u00105\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00030\u00022\n\b\u0001\u0010&\u001a\u0004\u0018\u00010%H'J6\u00108\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u000107\u0018\u00010\u00030\u00022\b\b\u0001\u00106\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'J\"\u0010;\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010:\u0018\u00010\u00030\u00022\b\b\u0001\u00109\u001a\u00020\fH'J+\u0010?\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010>\u0018\u00010\u00030\u00022\n\b\u0001\u0010=\u001a\u0004\u0018\u00010<H'¢\u0006\u0004\b?\u0010@J+\u0010A\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u00022\n\b\u0001\u0010=\u001a\u0004\u0018\u00010<H'¢\u0006\u0004\bA\u0010@J$\u0010B\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u00022\n\b\u0001\u0010&\u001a\u0004\u0018\u00010%H'J+\u0010D\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010C\u0018\u00010\u00030\u00022\n\b\u0001\u0010=\u001a\u0004\u0018\u00010<H'¢\u0006\u0004\bD\u0010@J$\u0010G\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010F\u0018\u00010\u00030\u00022\n\b\u0001\u0010E\u001a\u0004\u0018\u00010\fH'J0\u0010J\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010I\u0018\u00010\u00030\u00022\n\b\u0001\u0010E\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010H\u001a\u0004\u0018\u00010\fH'J0\u0010M\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010L\u0018\u00010\u00030\u00022\n\b\u0001\u0010E\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010K\u001a\u0004\u0018\u00010\fH'J\u001a\u0010P\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0N0\u00030\u0002H'J0\u0010S\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010R\u0018\u00010\u00030\u00022\n\b\u0001\u0010E\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010Q\u001a\u0004\u0018\u00010\fH'J<\u0010V\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010U\u0018\u00010\u00030\u00022\n\b\u0001\u0010E\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010T\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010Q\u001a\u0004\u0018\u00010\fH'J<\u0010X\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010W\u0018\u00010\u00030\u00022\n\b\u0001\u0010E\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010T\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010Q\u001a\u0004\u0018\u00010\fH'J6\u0010[\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010Z\u0018\u00010\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010Y\u001a\u00020\fH'J\"\u0010^\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010]\u0018\u00010\u00030\u00022\b\b\u0001\u0010\\\u001a\u00020\fH'J\"\u0010_\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u00022\b\b\u0001\u0010\\\u001a\u00020\fH'J6\u0010`\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010Z\u0018\u00010\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010Y\u001a\u00020\fH'J:\u0010a\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020C\u0018\u00010\t0\u00030\u00022\b\b\u0001\u0010=\u001a\u00020\f2\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'J\u001e\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020b0\u00030\u00022\b\b\u0001\u0010\\\u001a\u00020\fH'JD\u0010f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020e\u0018\u00010\t0\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010Y\u001a\u00020\u00062\b\b\u0001\u0010d\u001a\u00020\fH'J-\u0010h\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u00022\n\b\u0003\u0010g\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\bh\u0010i¨\u0006j"}, d2 = {"Lcom/huachenjie/sport/api/SportApi;", "", "Lrx/Observable;", "Lhuachenjie/sdk/http/BaseEntity;", "Lcom/alibaba/fastjson/JSONObject;", "d", "", "pageNum", "pageSize", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/sport/bean/CampusLetterBean;", "k", "", "schoolLetterRelationCode", "c", "H", "Lcom/huachenjie/base/bean/LetterBean;", y6b.f, "schoolLetterCode", "P", "fitnessTestConfigCode", "Lcom/huachenjie/sport/bean/SportTestDetailBean;", "w", "Lcom/huachenjie/sport/bean/SportTestResultYearBean;", "F", "academicYearCode", "Lcom/huachenjie/sport/bean/SportTestResultBean;", "v", "Lcom/huachenjie/sport/bean/SportTestListBean;", "B", "Lcom/huachenjie/sport/bean/SportTestPeriodBean;", "n", "Lcom/huachenjie/sport/bean/InformedConsentDetailBean;", "e", "", "hasConsent", "M", "Lokhttp3/RequestBody;", "body", "q", "Lcom/huachenjie/sport/bean/PEClassesListBean;", "y", "Lcom/huachenjie/sport/bean/PEClassesSelectorBean;", "b", "courseCode", "Lcom/huachenjie/sport/bean/ClassDetailBean;", "p", "L", "Lcom/huachenjie/sport/bean/RemainCountBean;", y6b.g, "f", "Lcom/huachenjie/sport/bean/ProblemData;", "t", "J", "auditStatus", "Lcom/huachenjie/common/bean/SunshineRecordListEntity;", "I", "examName", "Lcom/huachenjie/sport/bean/ExamPageList;", "E", "", ExamHistoryResultsActivity.x, "Lcom/huachenjie/sport/bean/ExamQuestionData;", "G", "(Ljava/lang/Long;)Lrx/Observable;", "m", "r", "Lcom/huachenjie/sport/bean/ExamDetailData;", "s", "semesterCode", "Lcom/huachenjie/sport/bean/AttendanceStatisticsBean;", "j", "yearMonth", "Lcom/huachenjie/sport/bean/AttendanceCalendarBean;", "C", "attendDate", "Lcom/huachenjie/sport/bean/AttendanceRecordData;", "A", "", "Lcom/huachenjie/sport/bean/AttendancePlanBean;", "a", "outsideConfigCode", "Lcom/huachenjie/sport/bean/OutsideAttendanceDetail;", "K", "date", "Lcom/huachenjie/sport/bean/OutsideAttendanceData;", "x", "Lcom/huachenjie/sport/bean/OutsideCalendarData;", "Q", BaseConstants.MARKET_URI_AUTHORITY_SEARCH, "Lcom/huachenjie/sport/bean/SchoolyardBean;", j.b, "activityCode", "Lcom/huachenjie/sport/bean/HuodongDetailBean;", "u", "O", "i", t.d, "Lcom/huachenjie/sport/bean/UserRunRankBean;", j.o, "schoolActivityCode", "Lcom/huachenjie/sport/bean/RunRankBean;", "D", "scene", "N", "(Ljava/lang/Integer;)Lrx/Observable;", "sport_release"}, k = 1, mv = {1, 8, 0})
public interface SportApi {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ Observable a(SportApi sportApi, Integer num, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPreRunCheckIn");
            }
            if ((i & 1) != 0) {
                num = null;
            }
            return sportApi.N(num);
        }
    }

    @FormUrlEncoded
    @POST("run-front/attend/studentCourseAttendList")
    @NotNull
    Observable<BaseEntity<AttendanceRecordData>> A(@Field("semesterCode") @Nullable String semesterCode, @Field("attendDate") @Nullable String attendDate);

    @POST("run-front/fitness/pageFitnessTest")
    @NotNull
    Observable<BaseEntity<SportTestListBean>> B();

    @FormUrlEncoded
    @POST("run-front/attend/courseAttendCalendar")
    @NotNull
    Observable<BaseEntity<AttendanceCalendarBean>> C(@Field("semesterCode") @Nullable String semesterCode, @Field("yearMonth") @Nullable String yearMonth);

    @FormUrlEncoded
    @POST("run-front/schoolActivity/pageSchoolActivityRank")
    @NotNull
    Observable<BaseEntity<PageEntity<RunRankBean>>> D(@Field("pageSize") int pageSize, @Field("pageNum") int pageNum, @Field(BaseConstants.MARKET_URI_AUTHORITY_SEARCH) int search, @Field("schoolActivityCode") @NotNull String schoolActivityCode);

    @FormUrlEncoded
    @POST("run-front/exam/list")
    @NotNull
    Observable<BaseEntity<ExamPageList>> E(@Field("examName") @NotNull String examName);

    @POST("run-front/fitness/listAcademicYearByGrade")
    @NotNull
    Observable<BaseEntity<SportTestResultYearBean>> F();

    @FormUrlEncoded
    @POST("run-front/exam/start")
    @NotNull
    Observable<BaseEntity<ExamQuestionData>> G(@Field(ExamHistoryResultsActivity.x) @Nullable Long examCode);

    @FormUrlEncoded
    @POST("run-front/schoolLetter/clearNoRead")
    @Nullable
    Observable<BaseEntity<Object>> H(@Field("schoolLetterRelationCode") @Nullable String schoolLetterRelationCode);

    @FormUrlEncoded
    @POST("run-front/run/pageAppealList")
    @NotNull
    Observable<BaseEntity<SunshineRecordListEntity>> I(@Field("auditStatus") int auditStatus, @Field("pageSize") int pageSize, @Field("pageNum") int pageNum);

    @POST("run-front/common/feedback")
    @NotNull
    Observable<BaseEntity<Object>> J(@Body @Nullable RequestBody body);

    @FormUrlEncoded
    @POST("run-front/outside/outsideSummary")
    @NotNull
    Observable<BaseEntity<OutsideAttendanceDetail>> K(@Field("semesterCode") @Nullable String semesterCode, @Field("outsideConfigCode") @Nullable String outsideConfigCode);

    @FormUrlEncoded
    @POST("run-front/course/electiveCourse")
    @NotNull
    Observable<BaseEntity<Object>> L(@Field("courseCode") @Nullable String courseCode);

    @FormUrlEncoded
    @POST("run-front/api/school/consent/informed/settings")
    @Nullable
    Observable<BaseEntity<Object>> M(@Field("hasConsent") boolean hasConsent, @Field("fitnessTestConfigCode") @Nullable String fitnessTestConfigCode);

    @FormUrlEncoded
    @POST("run-front/run/getPreRunCheckIn")
    @Nullable
    Observable<BaseEntity<JSONObject>> N(@Field("scene") @Nullable Integer scene);

    @FormUrlEncoded
    @POST("run-front/schoolActivity/signUp")
    @NotNull
    Observable<BaseEntity<JSONObject>> O(@Field("activityCode") @NotNull String activityCode);

    @FormUrlEncoded
    @POST("run-front/schoolLetter/letterDetail")
    @Nullable
    Observable<BaseEntity<LetterBean>> P(@Field("schoolLetterCode") @Nullable String schoolLetterCode);

    @FormUrlEncoded
    @POST("run-front/outside/calendar")
    @NotNull
    Observable<BaseEntity<OutsideCalendarData>> Q(@Field("semesterCode") @Nullable String semesterCode, @Field("yearMonth") @Nullable String date, @Field("outsideConfigCode") @Nullable String outsideConfigCode);

    @POST("run-front/outside/outsideList")
    @NotNull
    Observable<BaseEntity<List<AttendancePlanBean>>> a();

    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("run-front/course/getCourseSelector")
    @NotNull
    Observable<BaseEntity<PEClassesSelectorBean>> b();

    @FormUrlEncoded
    @POST("run-front/schoolLetter/remove")
    @Nullable
    Observable<BaseEntity<Object>> c(@Field("schoolLetterRelationCode") @Nullable String schoolLetterRelationCode);

    @POST("run-front/account/getStudentQrCode")
    @Nullable
    Observable<BaseEntity<JSONObject>> d();

    @FormUrlEncoded
    @POST("run-front/api/school/consent/informed/detail")
    @Nullable
    Observable<BaseEntity<InformedConsentDetailBean>> e(@Field("fitnessTestConfigCode") @Nullable String fitnessTestConfigCode);

    @FormUrlEncoded
    @POST("run-front/course/restElectiveCourse")
    @NotNull
    Observable<BaseEntity<Object>> f(@Field("courseCode") @Nullable String courseCode);

    @FormUrlEncoded
    @POST("run-front/schoolLetter/detail")
    @Nullable
    Observable<BaseEntity<LetterBean>> g(@Field("schoolLetterRelationCode") @Nullable String schoolLetterRelationCode);

    @FormUrlEncoded
    @POST("run-front/course/getElectiveCourseRemainCount")
    @NotNull
    Observable<BaseEntity<RemainCountBean>> h(@Field("courseCode") @Nullable String courseCode);

    @FormUrlEncoded
    @POST("run-front/schoolActivity/pageMySchoolActivity")
    @NotNull
    Observable<BaseEntity<SchoolyardBean>> i(@Field("pageSize") int pageSize, @Field("pageNum") int pageNum, @Field(BaseConstants.MARKET_URI_AUTHORITY_SEARCH) @NotNull String search);

    @FormUrlEncoded
    @POST("run-front/attend/statistics")
    @NotNull
    Observable<BaseEntity<AttendanceStatisticsBean>> j(@Field("semesterCode") @Nullable String semesterCode);

    @FormUrlEncoded
    @POST("run-front/schoolLetter/list")
    @Nullable
    Observable<BaseEntity<PageEntity<CampusLetterBean>>> k(@Field("pageNum") int pageNum, @Field("pageSize") int pageSize);

    @FormUrlEncoded
    @POST("run-front/exam/practiceList")
    @NotNull
    Observable<BaseEntity<PageEntity<ExamDetailData>>> l(@Field(ExamHistoryResultsActivity.x) @NotNull String examCode, @Field("pageSize") int pageSize, @Field("pageNum") int pageNum);

    @FormUrlEncoded
    @POST("run-front/exam/recover")
    @NotNull
    Observable<BaseEntity<JSONObject>> m(@Field(ExamHistoryResultsActivity.x) @Nullable Long examCode);

    @FormUrlEncoded
    @POST("run-front/fitness/getFitnessPeriod")
    @NotNull
    Observable<BaseEntity<SportTestPeriodBean>> n(@Field("fitnessTestConfigCode") @Nullable String fitnessTestConfigCode);

    @FormUrlEncoded
    @POST("run-front/schoolActivity/pageSchoolActivity")
    @NotNull
    Observable<BaseEntity<SchoolyardBean>> o(@Field("pageSize") int pageSize, @Field("pageNum") int pageNum, @Field(BaseConstants.MARKET_URI_AUTHORITY_SEARCH) @NotNull String search);

    @FormUrlEncoded
    @POST("run-front/course/getCourseDetail")
    @NotNull
    Observable<BaseEntity<ClassDetailBean>> p(@Field("courseCode") @Nullable String courseCode);

    @POST("run-front/fitness/reserveFitnessTest")
    @NotNull
    Observable<BaseEntity<Object>> q(@Body @Nullable RequestBody body);

    @POST("run-front/exam/submit")
    @NotNull
    Observable<BaseEntity<JSONObject>> r(@Body @Nullable RequestBody body);

    @FormUrlEncoded
    @POST("run-front/exam/result")
    @NotNull
    Observable<BaseEntity<ExamDetailData>> s(@Field(ExamHistoryResultsActivity.x) @Nullable Long examCode);

    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("run-front/customer/listProblem")
    @NotNull
    Observable<BaseEntity<ProblemData>> t();

    @FormUrlEncoded
    @POST("run-front/schoolActivity/getSchoolActivityDetailnfo")
    @NotNull
    Observable<BaseEntity<HuodongDetailBean>> u(@Field("activityCode") @NotNull String activityCode);

    @FormUrlEncoded
    @POST("run-front/fitness/getFitnessTestResult")
    @NotNull
    Observable<BaseEntity<SportTestResultBean>> v(@Field("academicYearCode") @Nullable String academicYearCode);

    @FormUrlEncoded
    @POST("run-front/fitness/getFitnessDetail")
    @NotNull
    Observable<BaseEntity<SportTestDetailBean>> w(@Field("fitnessTestConfigCode") @Nullable String fitnessTestConfigCode);

    @FormUrlEncoded
    @POST("run-front/outside/calendar/day")
    @NotNull
    Observable<BaseEntity<OutsideAttendanceData>> x(@Field("semesterCode") @Nullable String semesterCode, @Field("date") @Nullable String date, @Field("outsideConfigCode") @Nullable String outsideConfigCode);

    @POST("run-front/course/pageCourse")
    @NotNull
    Observable<BaseEntity<PEClassesListBean>> y(@Body @Nullable RequestBody body);

    @FormUrlEncoded
    @POST("run-front/schoolActivity/getSchoolActivityRankInfo")
    @NotNull
    Observable<BaseEntity<UserRunRankBean>> z(@Field("activityCode") @NotNull String activityCode);
}
