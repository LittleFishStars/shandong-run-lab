package com.huachenjie.sport.page.mine.attendance;

import android.graphics.Color;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.api.BaseModel;
import com.huachenjie.base.bean.AliPay;
import com.huachenjie.base.bean.BindInfo;
import com.huachenjie.base.widget.calendar.Calendar;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.run.map.RouteOverlay;
import com.huachenjie.sport.R;
import com.huachenjie.sport.api.SportModel;
import com.huachenjie.sport.bean.AttendDate;
import com.huachenjie.sport.bean.AttendanceCalendar;
import com.huachenjie.sport.bean.AttendanceCalendarBean;
import com.huachenjie.sport.bean.AttendanceRecordBean;
import com.huachenjie.sport.bean.AttendanceRecordData;
import com.huachenjie.sport.bean.AttendanceStatisticsBean;
import com.huachenjie.sport.bean.AttendanceType;
import com.huachenjie.sport.bean.ClockRecordBean;
import com.huachenjie.sport.bean.OutsideAttendanceData;
import com.huachenjie.sport.bean.OutsideAttendanceDetail;
import com.huachenjie.sport.bean.OutsideCalendarData;
import com.huachenjie.sport.bean.OutsideRecord;
import com.huachenjie.sport.bean.RecordBean;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.i4a;
import com.zj.adlib.n76;
import com.zj.adlib.s72;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010%\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b`\u0010aJ\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J.\u0010\r\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010\u000e\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u0016\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018JC\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0005J\u0017\u0010&\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b*\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u00100R\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u001d028\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u000208028\u0006¢\u0006\f\n\u0004\b9\u00104\u001a\u0004\b:\u00106R\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020\u0002028\u0006¢\u0006\f\n\u0004\b<\u00104\u001a\u0004\b=\u00106R\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020\u0011028\u0006¢\u0006\f\n\u0004\b?\u00104\u001a\u0004\b@\u00106R\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020\u0002028\u0006¢\u0006\f\n\u0004\bB\u00104\u001a\u0004\bC\u00106R\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001d028\u0006¢\u0006\f\n\u0004\b\b\u00104\u001a\u0004\bE\u00106R%\u0010I\u001a\u0010\u0012\f\u0012\n G*\u0004\u0018\u00010\u00020\u0002028\u0006¢\u0006\f\n\u0004\bH\u00104\u001a\u0004\bH\u00106R\u001d\u0010K\u001a\b\u0012\u0004\u0012\u00020\u001d028\u0006¢\u0006\f\n\u0004\bE\u00104\u001a\u0004\bJ\u00106R\u001d\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001d028\u0006¢\u0006\f\n\u0004\b&\u00104\u001a\u0004\bL\u00106R\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020\u001d028\u0006¢\u0006\f\n\u0004\b*\u00104\u001a\u0004\bN\u00106R\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u001d028\u0006¢\u0006\f\n\u0004\b(\u00104\u001a\u0004\bP\u00106R\u001d\u0010S\u001a\b\u0012\u0004\u0012\u00020\u001d028\u0006¢\u0006\f\n\u0004\b\t\u00104\u001a\u0004\bR\u00106R\u001d\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001d028\u0006¢\u0006\f\n\u0004\b\u0006\u00104\u001a\u0004\bT\u00106R%\u0010W\u001a\u0010\u0012\f\u0012\n G*\u0004\u0018\u00010\u00110\u0011028\u0006¢\u0006\f\n\u0004\bL\u00104\u001a\u0004\bV\u00106R%\u0010X\u001a\u0010\u0012\f\u0012\n G*\u0004\u0018\u00010\u00110\u0011028\u0006¢\u0006\f\n\u0004\b5\u00104\u001a\u0004\bB\u00106R%\u0010[\u001a\u0010\u0012\f\u0012\n G*\u0004\u0018\u00010\u00020\u0002028\u0006¢\u0006\f\n\u0004\bY\u00104\u001a\u0004\bZ\u00106R\u001d\u0010]\u001a\b\u0012\u0004\u0012\u00020\u0011028\u0006¢\u0006\f\n\u0004\bC\u00104\u001a\u0004\b\\\u00106R)\u0010_\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130^028\u0006¢\u0006\f\n\u0004\b=\u00104\u001a\u0004\bY\u00106¨\u0006b"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/AttendanceSubVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "semesterCode", "attendDate", "", "u", "yearMonth", "n", "t", "outsideConfigCode", "H", "date", "F", "G", "", "time", "", "missing", "Lcom/huachenjie/base/widget/calendar/Calendar;", "I", "Q", "R", "S", "Lcom/huachenjie/sport/bean/RecordBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "Lcom/huachenjie/sport/bean/ClockRecordBean;", "T", "signIn", "", "status", "locationName", "", "img", "U", "(ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lcom/huachenjie/sport/bean/ClockRecordBean;", "O", "P", "q", "(Ljava/lang/Integer;)Ljava/lang/String;", "s", "(Ljava/lang/Integer;)I", "r", "Lcom/huachenjie/sport/api/SportModel;", "a", "Lcom/huachenjie/sport/api/SportModel;", "sportModel", "Lcom/huachenjie/base/api/BaseModel;", "Lcom/huachenjie/base/api/BaseModel;", "baseModel", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "w", "()Landroidx/lifecycle/MutableLiveData;", "attendanceType", "Lcom/huachenjie/sport/page/mine/attendance/AttendanceAdapter;", "j", "E", "mAdapter", "k", j.o, "currentSelectedMonth", t.d, "J", "showStaticHeader", "m", "y", "currentPlanCode", "p", "attendancePlanStatus", "kotlin.jvm.PlatformType", j.b, UserConstants.MINE_PARAMS.h, "N", "totalAttendanceTimes", "v", "attendanceTimes", "B", "errorAttendanceTimes", "D", "leaveAttendanceTimes", "C", "lateAttendanceTimes", "A", "earlyAttendanceTimes", "K", "showTapCard", "aliPayBound", "x", "L", "tapLocationName", "M", "tapSigned", "", "calendarMap", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nAttendanceSubVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AttendanceSubVM.kt\ncom/huachenjie/sport/page/mine/attendance/AttendanceSubVM\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,554:1\n1#2:555\n*E\n"})
public final class AttendanceSubVM extends BaseVM {

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showTapCard;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> aliPayBound;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> tapLocationName;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> tapSigned;

    /* JADX INFO: renamed from: z, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Map<String, Calendar>> calendarMap;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SportModel sportModel = new SportModel();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final BaseModel baseModel = new BaseModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> attendanceType = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<AttendanceAdapter> mAdapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> currentSelectedMonth = new MutableLiveData<>();

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showStaticHeader = new MutableLiveData<>();

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> currentPlanCode = new MutableLiveData<>("");

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> attendancePlanStatus = new MutableLiveData<>(0);

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> attendancePlanName = new MutableLiveData<>("");

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> totalAttendanceTimes = new MutableLiveData<>(0);

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> attendanceTimes = new MutableLiveData<>(0);

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> errorAttendanceTimes = new MutableLiveData<>(0);

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> leaveAttendanceTimes = new MutableLiveData<>(0);

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> lateAttendanceTimes = new MutableLiveData<>(0);

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> earlyAttendanceTimes = new MutableLiveData<>(0);

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/attendance/AttendanceSubVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/sport/bean/AttendanceCalendarBean;", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<AttendanceCalendarBean> {
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2) {
            super(AttendanceSubVM.this, true);
            this.f = str;
            this.g = str2;
        }

        public void onCCSuccess(@Nullable AttendanceCalendarBean data) {
            if (data != null) {
                AttendanceSubVM attendanceSubVM = AttendanceSubVM.this;
                List<AttendanceCalendar> attendDateList = data.getAttendDateList();
                HashMap map = new HashMap();
                for (AttendanceCalendar attendanceCalendar : attendDateList) {
                    long attendTimestamp = attendanceCalendar.getAttendTimestamp();
                    boolean z = true;
                    if (attendanceCalendar.getAttendStatus() == 1) {
                        z = false;
                    }
                    Calendar calendarI = attendanceSubVM.I(attendTimestamp, z);
                    String string = calendarI.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "calendar.toString()");
                    map.put(string, calendarI);
                }
                attendanceSubVM.x().setValue(map);
            }
            String str = this.f;
            if (str != null) {
                AttendanceSubVM.this.t(this.g, str);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/sport/page/mine/attendance/AttendanceSubVM$b", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/sport/bean/AttendanceRecordData;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DialogVMSubscriber<AttendanceRecordData> {
        public b() {
            super(AttendanceSubVM.this, true);
        }

        public void onFailed(int code, @Nullable String message) {
            AttendanceAdapter value = AttendanceSubVM.this.E().getValue();
            if (value != null) {
                value.setList(null);
            }
            AttendanceAdapter value2 = AttendanceSubVM.this.E().getValue();
            if (value2 != null) {
                value2.k();
            }
            super.onFailed(code, message);
        }

        public void onCCSuccess(@Nullable AttendanceRecordData data) {
            if (data == null || data.getRecordList() == null || data.getRecordList().isEmpty()) {
                AttendanceAdapter value = AttendanceSubVM.this.E().getValue();
                if (value != null) {
                    value.setList(null);
                }
                AttendanceAdapter value2 = AttendanceSubVM.this.E().getValue();
                if (value2 != null) {
                    value2.k();
                    return;
                }
                return;
            }
            AttendanceAdapter value3 = AttendanceSubVM.this.E().getValue();
            if (value3 != null) {
                value3.i();
            }
            ArrayList arrayList = new ArrayList();
            Iterator<RecordBean> it = data.getRecordList().iterator();
            while (it.hasNext()) {
                arrayList.add(new AttendanceRecordBean(AttendanceSubVM.this.T(it.next()), null));
            }
            AttendanceAdapter value4 = AttendanceSubVM.this.E().getValue();
            if (value4 != null) {
                value4.setList(arrayList);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/attendance/AttendanceSubVM$c", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/sport/bean/AttendanceStatisticsBean;", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DialogVMSubscriber<AttendanceStatisticsBean> {
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2) {
            super(AttendanceSubVM.this, true);
            this.f = str;
            this.g = str2;
        }

        public void onCCSuccess(@Nullable AttendanceStatisticsBean data) {
            if (data != null) {
                AttendanceSubVM attendanceSubVM = AttendanceSubVM.this;
                attendanceSubVM.N().setValue(Integer.valueOf(data.getSemesterAttendTotal()));
                attendanceSubVM.v().setValue(Integer.valueOf(data.getSemesterAttendSuccessTotal()));
                attendanceSubVM.B().setValue(Integer.valueOf(data.getSemesterAttendAbsenceTotal()));
                attendanceSubVM.D().setValue(Integer.valueOf(data.getSemesterAttendLeaveTotal()));
                attendanceSubVM.C().setValue(Integer.valueOf(data.getSemesterAttendLateTotal()));
                attendanceSubVM.A().setValue(Integer.valueOf(data.getSemesterAttendEarlyTotal()));
            }
            String value = AttendanceSubVM.this.z().getValue();
            if (value != null) {
                AttendanceSubVM.this.n(this.f, value, this.g);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/attendance/AttendanceSubVM$d", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/sport/bean/OutsideCalendarData;", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends DialogVMSubscriber<OutsideCalendarData> {
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, String str2, String str3) {
            super(AttendanceSubVM.this, true);
            this.f = str;
            this.g = str2;
            this.h = str3;
        }

        public void onCCSuccess(@Nullable OutsideCalendarData data) {
            if ((data != null ? data.getAttendDateList() : null) == null || data.getAttendDateList().isEmpty()) {
                AttendanceSubVM.this.x().setValue(null);
            } else {
                HashMap map = new HashMap();
                for (AttendDate attendDate : data.getAttendDateList()) {
                    AttendanceSubVM attendanceSubVM = AttendanceSubVM.this;
                    long attendTimestamp = attendDate.getAttendTimestamp();
                    boolean z = true;
                    if (attendDate.getStatus() == 1) {
                        z = false;
                    }
                    Calendar calendarI = attendanceSubVM.I(attendTimestamp, z);
                    String string = calendarI.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "calendar.toString()");
                    map.put(string, calendarI);
                }
                AttendanceSubVM.this.x().setValue(map);
            }
            String str = this.f;
            if (str != null) {
                AttendanceSubVM.this.G(this.g, str, this.h);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/sport/page/mine/attendance/AttendanceSubVM$e", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/sport/bean/OutsideAttendanceData;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class e extends DialogVMSubscriber<OutsideAttendanceData> {
        public e() {
            super(AttendanceSubVM.this, true);
        }

        public void onFailed(int code, @Nullable String message) {
            AttendanceAdapter value = AttendanceSubVM.this.E().getValue();
            if (value != null) {
                value.setList(null);
            }
            AttendanceAdapter value2 = AttendanceSubVM.this.E().getValue();
            if (value2 != null) {
                value2.k();
            }
            super.onFailed(code, message);
        }

        public void onCCSuccess(@Nullable OutsideAttendanceData data) {
            Integer signOutStatus;
            if (data == null || data.getRecordList() == null || data.getRecordList().isEmpty()) {
                AttendanceAdapter value = AttendanceSubVM.this.E().getValue();
                if (value != null) {
                    value.setList(null);
                }
                AttendanceAdapter value2 = AttendanceSubVM.this.E().getValue();
                if (value2 != null) {
                    value2.k();
                    return;
                }
                return;
            }
            AttendanceAdapter value3 = AttendanceSubVM.this.E().getValue();
            if (value3 != null) {
                value3.i();
            }
            ArrayList arrayList = new ArrayList();
            for (OutsideRecord outsideRecord : data.getRecordList()) {
                Integer signOutStatus2 = outsideRecord.getSignOutStatus();
                if ((signOutStatus2 != null && signOutStatus2.intValue() == 1) || ((signOutStatus = outsideRecord.getSignOutStatus()) != null && signOutStatus.intValue() == 2)) {
                    arrayList.add(new AttendanceRecordBean(AttendanceSubVM.this.U(true, outsideRecord.getSignInTime(), outsideRecord.getSignInStatus(), outsideRecord.getSignInLocationName(), outsideRecord.getSignInImgUrl()), AttendanceSubVM.this.U(false, outsideRecord.getSignOutTime(), outsideRecord.getSignOutStatus(), outsideRecord.getSignOutLocationName(), outsideRecord.getSignOutImgUrl())));
                } else {
                    arrayList.add(new AttendanceRecordBean(AttendanceSubVM.this.U(true, outsideRecord.getSignInTime(), outsideRecord.getSignInStatus(), outsideRecord.getSignInLocationName(), outsideRecord.getSignInImgUrl()), null));
                }
            }
            AttendanceAdapter value4 = AttendanceSubVM.this.E().getValue();
            if (value4 != null) {
                value4.setList(arrayList);
            }
            AttendanceAdapter value5 = AttendanceSubVM.this.E().getValue();
            if (value5 != null) {
                value5.l(data.getSignInSegmentList(), data.getSignOutSegmentList());
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/sport/page/mine/attendance/AttendanceSubVM$f", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/sport/bean/OutsideAttendanceDetail;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class f extends DialogVMSubscriber<OutsideAttendanceDetail> {
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, String str2) {
            super(AttendanceSubVM.this, true, true);
            this.f = str;
            this.g = str2;
        }

        public void onFailed(int code, @Nullable String message) {
            super.onFailed(code, message);
            AttendanceSubVM.this.a();
            MutableLiveData<Boolean> mutableLiveDataJ = AttendanceSubVM.this.J();
            Boolean bool = Boolean.FALSE;
            mutableLiveDataJ.setValue(bool);
            AttendanceSubVM.this.K().setValue(bool);
            AttendanceSubVM.this.y().setValue("");
        }

        public void onCCSuccess(@Nullable OutsideAttendanceDetail data) {
            if (data != null) {
                MutableLiveData<Boolean> mutableLiveDataJ = AttendanceSubVM.this.J();
                Boolean bool = Boolean.TRUE;
                mutableLiveDataJ.setValue(bool);
                AttendanceSubVM.this.K().setValue(Boolean.valueOf(Intrinsics.areEqual(data.getAllowTapClock(), bool)));
                AttendanceSubVM.this.L().setValue(data.getTapLocationTypeName());
                AttendanceSubVM.this.N().setValue(Integer.valueOf(data.getSignTotalTimes()));
                AttendanceSubVM.this.v().setValue(Integer.valueOf(data.getNormalTimes()));
                AttendanceSubVM.this.B().setValue(Integer.valueOf(data.getErrorTimes()));
                AttendanceSubVM.this.y().setValue(data.getOutsideConfigCode());
                AttendanceSubVM.this.p().setValue(Integer.valueOf(data.getStatus()));
                AttendanceSubVM.this.o().setValue(data.getAttendanceName());
                AttendanceSubVM attendanceSubVM = AttendanceSubVM.this;
                attendanceSubVM.F(this.f, attendanceSubVM.z().getValue(), data.getOutsideConfigCode(), this.g);
                return;
            }
            AttendanceSubVM.this.a();
            MutableLiveData<Boolean> mutableLiveDataJ2 = AttendanceSubVM.this.J();
            Boolean bool2 = Boolean.FALSE;
            mutableLiveDataJ2.setValue(bool2);
            AttendanceSubVM.this.K().setValue(bool2);
            AttendanceSubVM.this.y().setValue("");
            AttendanceAdapter value = AttendanceSubVM.this.E().getValue();
            if (value != null) {
                value.setList(null);
            }
            AttendanceAdapter value2 = AttendanceSubVM.this.E().getValue();
            if (value2 != null) {
                value2.k();
            }
            AttendanceSubVM.this.N().setValue(0);
            AttendanceSubVM.this.v().setValue(0);
            AttendanceSubVM.this.B().setValue(0);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/attendance/AttendanceSubVM$g", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/huachenjie/base/bean/BindInfo;", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class g extends BizSubscriber<BindInfo> {
        public g() {
            super(false);
        }

        public void onCCSuccess(@Nullable BindInfo data) {
            AliPay aliPay;
            AttendanceSubVM.this.m().setValue(Boolean.valueOf((data == null || (aliPay = data.getAliPay()) == null) ? false : Intrinsics.areEqual(aliPay.getBindStatus(), Boolean.TRUE)));
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/attendance/AttendanceSubVM$h", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class h extends DialogVMSubscriber<JSONObject> {
        public h() {
            super(AttendanceSubVM.this, true);
        }

        public void onCCSuccess(@Nullable JSONObject data) {
            if (data != null ? Intrinsics.areEqual(data.getBoolean(UserTrackConstant.SIGN), Boolean.TRUE) : false) {
                AttendanceSubVM.this.M().setValue(Boolean.TRUE);
            } else {
                fv5.b("暂未查询到碰一碰结果，重新碰一碰试试");
            }
        }
    }

    public AttendanceSubVM() {
        Boolean bool = Boolean.FALSE;
        this.showTapCard = new MutableLiveData<>(bool);
        this.aliPayBound = new MutableLiveData<>(bool);
        this.tapLocationName = new MutableLiveData<>("");
        this.tapSigned = new MutableLiveData<>();
        this.calendarMap = new MutableLiveData<>();
    }

    @NotNull
    public final MutableLiveData<Integer> A() {
        return this.earlyAttendanceTimes;
    }

    @NotNull
    public final MutableLiveData<Integer> B() {
        return this.errorAttendanceTimes;
    }

    @NotNull
    public final MutableLiveData<Integer> C() {
        return this.lateAttendanceTimes;
    }

    @NotNull
    public final MutableLiveData<Integer> D() {
        return this.leaveAttendanceTimes;
    }

    @NotNull
    public final MutableLiveData<AttendanceAdapter> E() {
        return this.mAdapter;
    }

    public final void F(String semesterCode, String date, String outsideConfigCode, String attendDate) {
        if (Intrinsics.areEqual(this.showStaticHeader.getValue(), Boolean.TRUE)) {
            n76.e(this, this.sportModel.h(semesterCode, date, outsideConfigCode)).p5(new d(attendDate, semesterCode, outsideConfigCode));
        } else {
            i4a.a("当前没有考勤计划，不需要请求数据");
        }
    }

    public final void G(String semesterCode, String date, String outsideConfigCode) {
        n76.e(this, this.sportModel.i(semesterCode, date, outsideConfigCode)).p5(new e());
    }

    public final void H(String semesterCode, String outsideConfigCode, String attendDate) {
        n76.e(this, this.sportModel.k(semesterCode, outsideConfigCode)).p5(new f(semesterCode, attendDate));
    }

    public final Calendar I(long time, boolean missing) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(new Date(time));
        Calendar calendar2 = new Calendar();
        calendar2.setYear(calendar.get(1));
        calendar2.setMonth(calendar.get(2) + 1);
        calendar2.setDay(calendar.get(5));
        calendar2.setScheme(missing ? AttendanceType.MISSING_IN : AttendanceType.CLOCKED_IN);
        return calendar2;
    }

    @NotNull
    public final MutableLiveData<Boolean> J() {
        return this.showStaticHeader;
    }

    @NotNull
    public final MutableLiveData<Boolean> K() {
        return this.showTapCard;
    }

    @NotNull
    public final MutableLiveData<String> L() {
        return this.tapLocationName;
    }

    @NotNull
    public final MutableLiveData<Boolean> M() {
        return this.tapSigned;
    }

    @NotNull
    public final MutableLiveData<Integer> N() {
        return this.totalAttendanceTimes;
    }

    public final void O() {
        n76.e(this, this.baseModel.f()).p5(new g());
    }

    public final void P() {
        n76.e(this, this.sportModel.l(3)).p5(new h());
    }

    public final void Q(@NotNull String semesterCode, @Nullable String attendDate) {
        Intrinsics.checkNotNullParameter(semesterCode, "semesterCode");
        Integer value = this.attendanceType.getValue();
        if (value != null && value.intValue() == 1) {
            u(semesterCode, attendDate);
            return;
        }
        Integer value2 = this.attendanceType.getValue();
        if (value2 != null && value2.intValue() == 2) {
            H(semesterCode, this.currentPlanCode.getValue(), attendDate);
        }
    }

    public final void R(@NotNull String semesterCode, @NotNull String yearMonth) {
        String value;
        Intrinsics.checkNotNullParameter(semesterCode, "semesterCode");
        Intrinsics.checkNotNullParameter(yearMonth, "yearMonth");
        Integer value2 = this.attendanceType.getValue();
        if (value2 != null && value2.intValue() == 1) {
            n(semesterCode, yearMonth, null);
            return;
        }
        Integer value3 = this.attendanceType.getValue();
        if (value3 == null || value3.intValue() != 2 || (value = this.currentPlanCode.getValue()) == null) {
            return;
        }
        F(semesterCode, yearMonth, value, null);
    }

    public final void S(@NotNull String semesterCode, @NotNull String attendDate) {
        String value;
        Intrinsics.checkNotNullParameter(semesterCode, "semesterCode");
        Intrinsics.checkNotNullParameter(attendDate, "attendDate");
        i4a.a(attendDate);
        Integer value2 = this.attendanceType.getValue();
        if (value2 != null && value2.intValue() == 1) {
            t(semesterCode, attendDate);
            return;
        }
        Integer value3 = this.attendanceType.getValue();
        if (value3 == null || value3.intValue() != 2 || (value = this.currentPlanCode.getValue()) == null) {
            return;
        }
        G(semesterCode, attendDate, value);
    }

    @NotNull
    public final ClockRecordBean T(@NotNull RecordBean bean) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
        ClockRecordBean clockRecordBean = new ClockRecordBean(0, null, 0, null, 0, 0, null, null, 255, null);
        clockRecordBean.setIcon(bean.getAttendStatus() == 20 ? R.drawable.ic_attendance_attendclass_start : R.drawable.ic_attendance_attendclass_missing);
        if (bean.getAttendStatus() == 20) {
            str = "上课  " + s72.c(bean.getAttendDateTimestamp(), "HH:mm");
        } else {
            str = "上课  未打卡";
        }
        clockRecordBean.setText(str);
        clockRecordBean.setTextColor(bean.getAttendStatus() == 20 ? Color.parseColor("#FFFFFF") : Color.parseColor("#FF762F"));
        int attendStatus = bean.getAttendStatus();
        if (attendStatus == 10) {
            str2 = "请假";
        } else if (attendStatus == 20) {
            int signType = bean.getSignType();
            if (signType != 1) {
                str2 = signType != 2 ? "" : "数字打卡";
            } else {
                str2 = "扫码打卡";
            }
        } else if (attendStatus != 30) {
            str2 = attendStatus != 40 ? "缺卡" : "早退";
        } else {
            str2 = "迟到";
        }
        clockRecordBean.setStatus(str2);
        clockRecordBean.setStatusColor(bean.getAttendStatus() == 20 ? Color.parseColor("#FF650AEC") : Color.parseColor("#FFFFFF"));
        clockRecordBean.setStatusBackground(bean.getAttendStatus() == 20 ? R.drawable.bg_attendance_clocked_in : R.drawable.bg_attendance_clocked_out);
        clockRecordBean.setLocation(bean.getAttendStatus() == 20 ? bean.getAttendLocationName() : "");
        return clockRecordBean;
    }

    @NotNull
    public final ClockRecordBean U(boolean signIn, @Nullable String time, @Nullable Integer status, @Nullable String locationName, @Nullable List<String> img) {
        int i;
        long j;
        String str;
        ClockRecordBean clockRecordBean = new ClockRecordBean(0, null, 0, null, 0, 0, null, null, 255, null);
        if (status == null || status.intValue() == 0) {
            i = R.drawable.ic_attendance_attendclass_missing;
        } else {
            i = signIn ? R.drawable.ic_attendance_attendclass_start : R.drawable.ic_attendance_attendclass_end;
        }
        clockRecordBean.setIcon(i);
        try {
            j = Long.parseLong(time);
        } catch (Exception unused) {
            j = 0;
        }
        if (j == 0) {
            clockRecordBean.setText(signIn ? "锻炼开始" : "锻炼结束");
        } else {
            if (signIn) {
                str = "锻炼开始 " + s72.c(j, "HH:mm");
            } else {
                str = "锻炼结束 " + s72.c(j, "HH:mm");
            }
            clockRecordBean.setText(str);
        }
        clockRecordBean.setTextColor((status != null && status.intValue() == 1) ? Color.parseColor("#FFFFFF") : Color.parseColor("#FF762F"));
        clockRecordBean.setStatus((status != null && status.intValue() == 1) ? AttendanceType.CLOCKED_IN : "异常");
        clockRecordBean.setStatusColor((status != null && status.intValue() == 1) ? Color.parseColor("#FF650AEC") : Color.parseColor("#FFFFFF"));
        clockRecordBean.setStatusBackground((status != null && status.intValue() == 1) ? R.drawable.bg_attendance_clocked_in : R.drawable.bg_attendance_clocked_out);
        clockRecordBean.setLocation(locationName == null ? "" : locationName);
        if (img != null && (!img.isEmpty())) {
            clockRecordBean.setImgUrl(img.get(0));
        }
        return clockRecordBean;
    }

    @NotNull
    public final MutableLiveData<Boolean> m() {
        return this.aliPayBound;
    }

    public final void n(String semesterCode, String yearMonth, String attendDate) {
        n76.e(this, this.sportModel.d(semesterCode, yearMonth)).p5(new a(attendDate, semesterCode));
    }

    @NotNull
    public final MutableLiveData<String> o() {
        return this.attendancePlanName;
    }

    @NotNull
    public final MutableLiveData<Integer> p() {
        return this.attendancePlanStatus;
    }

    @NotNull
    public final String q(@Nullable Integer status) {
        if (status != null && status.intValue() == 0) {
            return "未开始";
        }
        if (status != null && status.intValue() == 1) {
            return "进行中";
        }
        if (status != null) {
            status.intValue();
        }
        return "已结束";
    }

    public final int r(@Nullable Integer status) {
        if (status != null && status.intValue() == 0) {
            return R.drawable.bg_attendance_plan_unstart;
        }
        if (status != null && status.intValue() == 1) {
            return R.drawable.bg_attendance_plan_start;
        }
        return (status != null && status.intValue() == 2) ? R.drawable.bg_attendance_plan_end : R.drawable.bg_attendance_plan_end;
    }

    public final int s(@Nullable Integer status) {
        if (status != null && status.intValue() == 0) {
            return Color.parseColor(RouteOverlay.f12338c);
        }
        if ((status == null || status.intValue() != 1) && status != null) {
            status.intValue();
        }
        return -1;
    }

    public final void t(String semesterCode, String attendDate) {
        n76.e(this, this.sportModel.e(semesterCode, attendDate)).p5(new b());
    }

    public final void u(String semesterCode, String attendDate) {
        n76.e(this, this.sportModel.f(semesterCode)).p5(new c(semesterCode, attendDate));
    }

    @NotNull
    public final MutableLiveData<Integer> v() {
        return this.attendanceTimes;
    }

    @NotNull
    public final MutableLiveData<Integer> w() {
        return this.attendanceType;
    }

    @NotNull
    public final MutableLiveData<Map<String, Calendar>> x() {
        return this.calendarMap;
    }

    @NotNull
    public final MutableLiveData<String> y() {
        return this.currentPlanCode;
    }

    @NotNull
    public final MutableLiveData<String> z() {
        return this.currentSelectedMonth;
    }
}
