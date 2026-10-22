package com.huachenjie.sport.api;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
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
import com.huachenjie.sport.bean.ExamAnswersData;
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
import com.huachenjie.sport.page.campus_letter.LetterDetailActivity;
import com.huachenjie.sport.page.mine.choose_classes.PEClassesSearchActivity;
import com.huachenjie.sport.page.mine.exam.ExamHistoryResultsActivity;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.a63;
import com.zj.adlib.lo7;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.BaseEntity;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bv\u0010wJ\u0018\u0010\u0005\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u0002J&\u0010\n\u001a\u001a\u0012\u0014\u0012\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0018\u00010\u0003\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\"\u0010\r\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\"\u0010\u000e\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ \u0010\u0010\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0003\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ \u0010\u0011\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0003\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ \u0010\u0014\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u00030\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\u0016\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u00030\u0002J \u0010\u0018\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u00030\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\u001a\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u00030\u0002J \u0010\u001c\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u00030\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bJ\"\u0010\u001e\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u0003\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bJ*\u0010!\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bJ8\u0010&\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00030\u00022\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010(\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010\u00030\u0002J\\\u00101\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010\u00030\u00022\b\b\u0001\u0010)\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\u000b2\u0006\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000b2\b\u0010.\u001a\u0004\u0018\u00010\u000b2\u0006\u0010/\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J \u00103\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u00010\u00030\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bJ \u00104\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00030\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bJ \u00107\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u000106\u0018\u00010\u00030\u00022\b\u00105\u001a\u0004\u0018\u00010\u000bJ \u00108\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00030\u00022\b\u00105\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010:\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u000109\u0018\u00010\u00030\u0002J.\u0010>\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00030\u00022\u0006\u0010;\u001a\u00020\u000b2\u000e\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0<J&\u0010A\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010@\u0018\u00010\u00030\u00022\u0006\u0010?\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010D\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010C\u0018\u00010\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u000bJ'\u0010H\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010G\u0018\u00010\u00030\u00022\b\u0010F\u001a\u0004\u0018\u00010E¢\u0006\u0004\bH\u0010IJ'\u0010K\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010J\u0018\u00010\u00030\u00022\b\u0010F\u001a\u0004\u0018\u00010E¢\u0006\u0004\bK\u0010IJ'\u0010L\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u00022\b\u0010F\u001a\u0004\u0018\u00010E¢\u0006\u0004\bL\u0010IJ\u001e\u0010M\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u00022\u0006\u0010F\u001a\u00020EJ \u0010O\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010N\u0018\u00010\u00030\u00022\b\u0010,\u001a\u0004\u0018\u00010\u000bJ*\u0010R\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010Q\u0018\u00010\u00030\u00022\b\u0010,\u001a\u0004\u0018\u00010\u000b2\b\u0010P\u001a\u0004\u0018\u00010\u000bJ*\u0010U\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010T\u0018\u00010\u00030\u00022\b\u0010,\u001a\u0004\u0018\u00010\u000b2\b\u0010S\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010W\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0<0\u00030\u0002J*\u0010Z\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010Y\u0018\u00010\u00030\u00022\b\u0010,\u001a\u0004\u0018\u00010\u000b2\b\u0010X\u001a\u0004\u0018\u00010\u000bJ4\u0010]\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\\\u0018\u00010\u00030\u00022\b\u0010,\u001a\u0004\u0018\u00010\u000b2\b\u0010[\u001a\u0004\u0018\u00010\u000b2\b\u0010X\u001a\u0004\u0018\u00010\u000bJ4\u0010_\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010^\u0018\u00010\u00030\u00022\b\u0010,\u001a\u0004\u0018\u00010\u000b2\b\u0010[\u001a\u0004\u0018\u00010\u000b2\b\u0010X\u001a\u0004\u0018\u00010\u000bJ&\u0010b\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010a\u0018\u00010\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010`\u001a\u00020\u000bJ&\u0010c\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010a\u0018\u00010\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010`\u001a\u00020\u000bJ\u001e\u0010f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010e\u0018\u00010\u00030\u00022\u0006\u0010d\u001a\u00020\u000bJ\u001e\u0010g\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u00022\u0006\u0010d\u001a\u00020\u000bJ*\u0010h\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020G\u0018\u00010\b0\u00030\u00022\u0006\u0010F\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006J\u001a\u0010j\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020i0\u00030\u00022\u0006\u0010d\u001a\u00020\u000bJ2\u0010m\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020l\u0018\u00010\b0\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010`\u001a\u00020\u00062\u0006\u0010k\u001a\u00020\u000bJ+\u0010o\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0018\u00010\u00022\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bo\u0010pR\u001b\u0010u\u001a\u00020q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010r\u001a\u0004\bs\u0010t¨\u0006x"}, d2 = {"Lcom/huachenjie/sport/api/SportModel;", "", "Lrx/Observable;", "Lhuachenjie/sdk/http/BaseEntity;", "Lcom/alibaba/fastjson/JSONObject;", "K", "", "pageNum", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/sport/bean/CampusLetterBean;", "A", "", LetterDetailActivity.x, "a", "J", "Lcom/huachenjie/base/bean/LetterBean;", "B", "p", "code", "Lcom/huachenjie/sport/bean/SportTestDetailBean;", "E", "Lcom/huachenjie/sport/bean/SportTestResultYearBean;", "I", "Lcom/huachenjie/sport/bean/SportTestResultBean;", "H", "Lcom/huachenjie/sport/bean/SportTestListBean;", "F", "Lcom/huachenjie/sport/bean/SportTestPeriodBean;", "G", "Lcom/huachenjie/sport/bean/InformedConsentDetailBean;", "u", "", "hasConsent", "S", "testCode", "yearCode", "dayCode", "timeCode", "N", "Lcom/huachenjie/sport/bean/PEClassesSelectorBean;", "x", "searchType", PEClassesSearchActivity.x, "notSignUp", "semesterCode", "subjectCode", "attendWeekDay", "pageSize", "Lcom/huachenjie/sport/bean/PEClassesListBean;", "w", "Lcom/huachenjie/sport/bean/ClassDetailBean;", "q", "P", "courseCode", "Lcom/huachenjie/sport/bean/RemainCountBean;", y6b.f, "L", "Lcom/huachenjie/sport/bean/ProblemData;", "n", "content", "", "fileUrlList", "b", "auditStatus", "Lcom/huachenjie/common/bean/SunshineRecordListEntity;", j.b, "examName", "Lcom/huachenjie/sport/bean/ExamPageList;", "s", "", ExamHistoryResultsActivity.x, "Lcom/huachenjie/sport/bean/ExamDetailData;", "t", "(Ljava/lang/Long;)Lrx/Observable;", "Lcom/huachenjie/sport/bean/ExamQuestionData;", "Q", "M", "R", "Lcom/huachenjie/sport/bean/AttendanceStatisticsBean;", "f", "yearMonth", "Lcom/huachenjie/sport/bean/AttendanceCalendarBean;", "d", "attendDate", "Lcom/huachenjie/sport/bean/AttendanceRecordData;", "e", "Lcom/huachenjie/sport/bean/AttendancePlanBean;", "j", "outsideConfigCode", "Lcom/huachenjie/sport/bean/OutsideAttendanceDetail;", "k", "date", "Lcom/huachenjie/sport/bean/OutsideAttendanceData;", "i", "Lcom/huachenjie/sport/bean/OutsideCalendarData;", y6b.g, BaseConstants.MARKET_URI_AUTHORITY_SEARCH, "Lcom/huachenjie/sport/bean/SchoolyardBean;", "D", "v", "activityCode", "Lcom/huachenjie/sport/bean/HuodongDetailBean;", "C", "O", "r", "Lcom/huachenjie/sport/bean/UserRunRankBean;", "y", "schoolActivityCode", "Lcom/huachenjie/sport/bean/RunRankBean;", j.o, "scene", t.d, "(Ljava/lang/Integer;)Lrx/Observable;", "Lcom/huachenjie/sport/api/SportApi;", "Lkotlin/Lazy;", "c", "()Lcom/huachenjie/sport/api/SportApi;", "api", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class SportModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy api = LazyKt.lazy(new Function0<SportApi>() { // from class: com.huachenjie.sport.api.SportModel$api$2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SportApi m767invoke() {
            return (SportApi) lo7.e().d(SportApi.class);
        }
    });

    public static /* synthetic */ Observable m(SportModel sportModel, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        return sportModel.l(num);
    }

    @Nullable
    public final Observable<BaseEntity<PageEntity<CampusLetterBean>>> A(int pageNum) {
        return c().k(pageNum, 10);
    }

    @Nullable
    public final Observable<BaseEntity<LetterBean>> B(@Nullable String letterCode) {
        return c().g(letterCode);
    }

    @NotNull
    public final Observable<BaseEntity<HuodongDetailBean>> C(@NotNull String activityCode) {
        Intrinsics.checkNotNullParameter(activityCode, "activityCode");
        return c().u(activityCode);
    }

    @NotNull
    public final Observable<BaseEntity<SchoolyardBean>> D(int pageNum, @NotNull String search) {
        Intrinsics.checkNotNullParameter(search, BaseConstants.MARKET_URI_AUTHORITY_SEARCH);
        return c().o(10, pageNum, search);
    }

    @NotNull
    public final Observable<BaseEntity<SportTestDetailBean>> E(@Nullable String code) {
        return c().w(code);
    }

    @NotNull
    public final Observable<BaseEntity<SportTestListBean>> F() {
        return c().B();
    }

    @NotNull
    public final Observable<BaseEntity<SportTestPeriodBean>> G(@Nullable String code) {
        return c().n(code);
    }

    @NotNull
    public final Observable<BaseEntity<SportTestResultBean>> H(@Nullable String code) {
        return c().v(code);
    }

    @NotNull
    public final Observable<BaseEntity<SportTestResultYearBean>> I() {
        return c().F();
    }

    @Nullable
    public final Observable<BaseEntity<Object>> J(@Nullable String letterCode) {
        return c().H(letterCode);
    }

    @Nullable
    public final Observable<BaseEntity<JSONObject>> K() {
        return c().d();
    }

    @NotNull
    public final Observable<BaseEntity<Object>> L(@Nullable String courseCode) {
        return c().f(courseCode);
    }

    @NotNull
    public final Observable<BaseEntity<JSONObject>> M(@Nullable Long examCode) {
        return c().m(examCode);
    }

    @NotNull
    public final Observable<BaseEntity<Object>> N(@NotNull String testCode, @NotNull String yearCode, @NotNull String dayCode, @Nullable String timeCode) {
        Intrinsics.checkNotNullParameter(testCode, "testCode");
        Intrinsics.checkNotNullParameter(yearCode, "yearCode");
        Intrinsics.checkNotNullParameter(dayCode, "dayCode");
        HashMap map = new HashMap();
        map.put("yearMonthCode", yearCode);
        map.put("dayCode", dayCode);
        map.put("timeFragmentCode", timeCode);
        HashMap map2 = new HashMap();
        map2.put("fitnessTestConfigCode", testCode);
        map2.put("uniqueCode", map);
        String jSONString = JSON.toJSONString(map2);
        RequestBody.Companion companion = RequestBody.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return c().q(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)));
    }

    @NotNull
    public final Observable<BaseEntity<JSONObject>> O(@NotNull String activityCode) {
        Intrinsics.checkNotNullParameter(activityCode, "activityCode");
        return c().O(activityCode);
    }

    @NotNull
    public final Observable<BaseEntity<Object>> P(@Nullable String code) {
        return c().L(code);
    }

    @NotNull
    public final Observable<BaseEntity<ExamQuestionData>> Q(@Nullable Long examCode) {
        return c().G(examCode);
    }

    @NotNull
    public final Observable<BaseEntity<JSONObject>> R(long examCode) {
        Map<Long, Set<Long>> mapD = a63.d(Long.valueOf(examCode));
        ArrayList arrayList = new ArrayList();
        if (mapD != null) {
            Iterator<Long> it = mapD.keySet().iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                Set<Long> set = mapD.get(Long.valueOf(jLongValue));
                if (set != null && !set.isEmpty()) {
                    arrayList.add(new ExamAnswersData(jLongValue, set));
                }
            }
        }
        HashMap map = new HashMap();
        map.put(ExamHistoryResultsActivity.x, Long.valueOf(examCode));
        map.put("answers", arrayList);
        RequestBody.Companion companion = RequestBody.Companion;
        String jSONString = JSON.toJSONString(map);
        Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(map)");
        return c().r(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)));
    }

    @Nullable
    public final Observable<BaseEntity<Object>> S(boolean hasConsent, @Nullable String code) {
        return c().M(hasConsent, code);
    }

    @Nullable
    public final Observable<BaseEntity<Object>> a(@Nullable String letterCode) {
        return c().c(letterCode);
    }

    @NotNull
    public final Observable<BaseEntity<Object>> b(@NotNull String content, @NotNull List<String> fileUrlList) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(fileUrlList, "fileUrlList");
        HashMap map = new HashMap();
        map.put("content", content);
        map.put("fileUrlList", fileUrlList);
        String jSONString = JSON.toJSONString(map);
        RequestBody.Companion companion = RequestBody.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return c().J(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)));
    }

    public final SportApi c() {
        Object value = this.api.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-api>(...)");
        return (SportApi) value;
    }

    @NotNull
    public final Observable<BaseEntity<AttendanceCalendarBean>> d(@Nullable String semesterCode, @Nullable String yearMonth) {
        return c().C(semesterCode, yearMonth);
    }

    @NotNull
    public final Observable<BaseEntity<AttendanceRecordData>> e(@Nullable String semesterCode, @Nullable String attendDate) {
        return c().A(semesterCode, attendDate);
    }

    @NotNull
    public final Observable<BaseEntity<AttendanceStatisticsBean>> f(@Nullable String semesterCode) {
        return c().j(semesterCode);
    }

    @NotNull
    public final Observable<BaseEntity<RemainCountBean>> g(@Nullable String courseCode) {
        return c().h(courseCode);
    }

    @NotNull
    public final Observable<BaseEntity<OutsideCalendarData>> h(@Nullable String semesterCode, @Nullable String date, @Nullable String outsideConfigCode) {
        return c().Q(semesterCode, date, outsideConfigCode);
    }

    @NotNull
    public final Observable<BaseEntity<OutsideAttendanceData>> i(@Nullable String semesterCode, @Nullable String date, @Nullable String outsideConfigCode) {
        return c().x(semesterCode, date, outsideConfigCode);
    }

    @NotNull
    public final Observable<BaseEntity<List<AttendancePlanBean>>> j() {
        return c().a();
    }

    @NotNull
    public final Observable<BaseEntity<OutsideAttendanceDetail>> k(@Nullable String semesterCode, @Nullable String outsideConfigCode) {
        return c().K(semesterCode, outsideConfigCode);
    }

    @Nullable
    public final Observable<BaseEntity<JSONObject>> l(@Nullable Integer scene) {
        return c().N(scene);
    }

    @NotNull
    public final Observable<BaseEntity<ProblemData>> n() {
        return c().t();
    }

    @NotNull
    public final Observable<BaseEntity<SunshineRecordListEntity>> o(int auditStatus, int pageNum) {
        return c().I(auditStatus, 10, pageNum);
    }

    @Nullable
    public final Observable<BaseEntity<LetterBean>> p(@Nullable String letterCode) {
        return c().P(letterCode);
    }

    @NotNull
    public final Observable<BaseEntity<ClassDetailBean>> q(@Nullable String code) {
        return c().p(code);
    }

    @NotNull
    public final Observable<BaseEntity<PageEntity<ExamDetailData>>> r(@NotNull String examCode, int pageNum) {
        Intrinsics.checkNotNullParameter(examCode, ExamHistoryResultsActivity.x);
        return c().l(examCode, 10, pageNum);
    }

    @NotNull
    public final Observable<BaseEntity<ExamPageList>> s(int pageNum, @NotNull String examName) {
        Intrinsics.checkNotNullParameter(examName, "examName");
        return c().E(examName);
    }

    @NotNull
    public final Observable<BaseEntity<ExamDetailData>> t(@Nullable Long examCode) {
        return c().s(examCode);
    }

    @Nullable
    public final Observable<BaseEntity<InformedConsentDetailBean>> u(@Nullable String code) {
        return c().e(code);
    }

    @NotNull
    public final Observable<BaseEntity<SchoolyardBean>> v(int pageNum, @NotNull String search) {
        Intrinsics.checkNotNullParameter(search, BaseConstants.MARKET_URI_AUTHORITY_SEARCH);
        return c().i(10, pageNum, search);
    }

    @NotNull
    public final Observable<BaseEntity<PEClassesListBean>> w(@IntRange(from = 1, to = 2) int searchType, @Nullable String searchText, boolean notSignUp, @NotNull String semesterCode, @NotNull String subjectCode, @Nullable String attendWeekDay, int pageSize, int pageNum) {
        Intrinsics.checkNotNullParameter(semesterCode, "semesterCode");
        Intrinsics.checkNotNullParameter(subjectCode, "subjectCode");
        HashMap map = new HashMap();
        map.put("searchType", Integer.valueOf(searchType));
        if (searchType == 1) {
            map.put(PEClassesSearchActivity.x, searchText);
            map.put("notSignUp", Boolean.valueOf(notSignUp));
            map.put("semesterCode", semesterCode);
            if (!TextUtils.isEmpty(subjectCode)) {
                map.put("subjectCode", subjectCode);
            }
            if (!TextUtils.isEmpty(attendWeekDay)) {
                map.put("attendWeekDay", attendWeekDay);
            }
        }
        map.put("pageSize", Integer.valueOf(pageSize));
        map.put("pageNum", Integer.valueOf(pageNum));
        String jSONString = JSON.toJSONString(map);
        RequestBody.Companion companion = RequestBody.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return c().y(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)));
    }

    @NotNull
    public final Observable<BaseEntity<PEClassesSelectorBean>> x() {
        return c().b();
    }

    @NotNull
    public final Observable<BaseEntity<UserRunRankBean>> y(@NotNull String activityCode) {
        Intrinsics.checkNotNullParameter(activityCode, "activityCode");
        return c().z(activityCode);
    }

    @NotNull
    public final Observable<BaseEntity<PageEntity<RunRankBean>>> z(int pageNum, int search, @NotNull String schoolActivityCode) {
        Intrinsics.checkNotNullParameter(schoolActivityCode, "schoolActivityCode");
        return c().D(20, pageNum, search, schoolActivityCode);
    }
}
