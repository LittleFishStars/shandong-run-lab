package com.huachenjie.sport.page.mine.attendance;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.api.BaseModel;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.bean.SemesterBean;
import com.huachenjie.sport.bean.CalendarDate;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.gq1;
import com.zj.adlib.i4a;
import com.zj.adlib.n76;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0012R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00148\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u0016\u0010\u0019R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u00148\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R#\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0!0\u00148\u0006¢\u0006\f\n\u0004\b\"\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\"\u0010*\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b\"\u0010'\"\u0004\b(\u0010)R\"\u0010-\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010&\u001a\u0004\b\u001e\u0010'\"\u0004\b,\u0010)¨\u00060"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/AttendanceVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "r", "", "message", "s", "m", "n", "", "time", "Lcom/huachenjie/sport/bean/CalendarDate;", "t", "Lcom/zj/adlib/gq1;", "a", "Lcom/zj/adlib/gq1;", "commonModel", "Lcom/huachenjie/base/api/BaseModel;", "Lcom/huachenjie/base/api/BaseModel;", "baseModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/CommonUserInfo;", "i", "Landroidx/lifecycle/MutableLiveData;", j.b, "()Landroidx/lifecycle/MutableLiveData;", "userInfo", "j", "currentTime", "Lcom/huachenjie/common/bean/SemesterBean;", "k", y6b.g, "currentSemester", "", t.d, "mSemesterList", "", "K", "I", "()I", "q", "(I)V", "retryServerTimes", "L", "p", "retrySemesterTimes", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class AttendanceVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final gq1 commonModel = new gq1();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final BaseModel baseModel = new BaseModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<CommonUserInfo> userInfo = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<CalendarDate> currentTime = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SemesterBean> currentSemester = new MutableLiveData<>();

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<SemesterBean>> mSemesterList = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int retryServerTimes = 3;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public int retrySemesterTimes = 3;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\f"}, d2 = {"com/huachenjie/sport/page/mine/attendance/AttendanceVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "Lcom/huachenjie/common/bean/SemesterBean;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "sport_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nAttendanceVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AttendanceVM.kt\ncom/huachenjie/sport/page/mine/attendance/AttendanceVM$getSemesterList$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n1#2:134\n*E\n"})
    public static final class a extends DialogVMSubscriber<List<? extends SemesterBean>> {
        public a() {
            super(AttendanceVM.this, true);
        }

        public void onFailed(int code, @Nullable String message) {
            AttendanceVM.this.n(message);
        }

        public void onCCSuccess(@Nullable List<SemesterBean> data) {
            Object obj;
            Object next;
            if (data == null) {
                AttendanceVM.this.m();
                return;
            }
            AttendanceVM.this.a();
            List<SemesterBean> list = data;
            Iterator<T> it = list.iterator();
            do {
                obj = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((SemesterBean) next).getStatus() == 1));
            SemesterBean semesterBean = (SemesterBean) next;
            if (semesterBean == null) {
                for (Object obj2 : list) {
                    if (((SemesterBean) obj2).getStatus() == 2) {
                        obj = obj2;
                        break;
                    }
                }
                semesterBean = (SemesterBean) obj;
            }
            if (semesterBean == null) {
                AttendanceVM.this.m();
                return;
            }
            Collections.reverse(data);
            AttendanceVM.this.h().setValue(semesterBean);
            AttendanceVM.this.j().setValue(data);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/sport/page/mine/attendance/AttendanceVM$b", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DialogVMSubscriber<JSONObject> {
        public b() {
            super(AttendanceVM.this, true, true);
        }

        public void onFailed(int code, @Nullable String message) {
            AttendanceVM.this.s(message);
        }

        public void onCCSuccess(@Nullable JSONObject data) {
            if (data == null) {
                AttendanceVM.this.r();
                return;
            }
            AttendanceVM attendanceVM = AttendanceVM.this;
            if (data.containsKey("serverTime")) {
                attendanceVM.i().setValue(attendanceVM.t(data.getLongValue("serverTime")));
            }
        }
    }

    @NotNull
    public final MutableLiveData<SemesterBean> h() {
        return this.currentSemester;
    }

    @NotNull
    public final MutableLiveData<CalendarDate> i() {
        return this.currentTime;
    }

    @NotNull
    public final MutableLiveData<List<SemesterBean>> j() {
        return this.mSemesterList;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final int getRetrySemesterTimes() {
        return this.retrySemesterTimes;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final int getRetryServerTimes() {
        return this.retryServerTimes;
    }

    public final void m() {
        n(null);
    }

    public final void n(@Nullable String message) {
        int i = this.retrySemesterTimes;
        if (i > 0) {
            this.retrySemesterTimes = i - 1;
            n76.e(this, this.baseModel.e()).p5(new a());
            return;
        }
        a();
        if (TextUtils.isEmpty(message)) {
            fv5.b("数据异常，请关闭界面再试");
        } else {
            fv5.b(message);
        }
    }

    @NotNull
    public final MutableLiveData<CommonUserInfo> o() {
        return this.userInfo;
    }

    public final void p(int i) {
        this.retrySemesterTimes = i;
    }

    public final void q(int i) {
        this.retryServerTimes = i;
    }

    public final void r() {
        s(null);
    }

    public final void s(@Nullable String message) {
        int i = this.retryServerTimes;
        if (i > 0) {
            this.retryServerTimes = i - 1;
            n76.e(this, this.commonModel.C()).p5(new b());
            return;
        }
        a();
        if (TextUtils.isEmpty(message)) {
            fv5.b("数据异常，请关闭界面再试");
        } else {
            fv5.b(message);
        }
    }

    @NotNull
    public final CalendarDate t(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(time));
        CalendarDate calendarDate = new CalendarDate(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
        i4a.a(calendarDate.toString());
        return calendarDate;
    }
}
