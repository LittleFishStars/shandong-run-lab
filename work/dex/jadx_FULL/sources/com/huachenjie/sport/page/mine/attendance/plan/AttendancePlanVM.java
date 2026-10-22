package com.huachenjie.sport.page.mine.attendance.plan;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.sport.api.SportModel;
import com.huachenjie.sport.bean.AttendancePlanBean;
import com.zj.adlib.n76;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\n\u0010\rR%\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0013\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/plan/AttendancePlanVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "j", "Lcom/huachenjie/sport/api/SportModel;", "a", "Lcom/huachenjie/sport/api/SportModel;", "sportModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "Lcom/huachenjie/sport/page/mine/attendance/plan/AttendancePlanAdapter;", "mAdapter", "", "kotlin.jvm.PlatformType", y6b.g, "currentPlanCode", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class AttendancePlanVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final SportModel sportModel = new SportModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<AttendancePlanAdapter> mAdapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> currentPlanCode = new MutableLiveData<>("");

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014¨\u0006\u0007"}, d2 = {"com/huachenjie/sport/page/mine/attendance/plan/AttendancePlanVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "Lcom/huachenjie/sport/bean/AttendancePlanBean;", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<List<? extends AttendancePlanBean>> {
        public a() {
            super(AttendancePlanVM.this, true);
        }

        public void onCCSuccess(@Nullable List<AttendancePlanBean> data) {
            Object next;
            int iIndexOf;
            AttendancePlanAdapter value;
            if (data != null) {
                AttendancePlanVM attendancePlanVM = AttendancePlanVM.this;
                if (data.isEmpty()) {
                    return;
                }
                AttendancePlanAdapter value2 = attendancePlanVM.i().getValue();
                if (value2 != null) {
                    value2.setList(data);
                }
                Iterator<T> it = data.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!TextUtils.equals(((AttendancePlanBean) next).getOutsideConfigCode(), attendancePlanVM.h().getValue()));
                AttendancePlanBean attendancePlanBean = (AttendancePlanBean) next;
                if (attendancePlanBean == null || (iIndexOf = data.indexOf(attendancePlanBean)) <= -1 || (value = attendancePlanVM.i().getValue()) == null) {
                    return;
                }
                value.h(iIndexOf);
            }
        }
    }

    @NotNull
    public final MutableLiveData<String> h() {
        return this.currentPlanCode;
    }

    @NotNull
    public final MutableLiveData<AttendancePlanAdapter> i() {
        return this.mAdapter;
    }

    public final void j() {
        n76.e(this, this.sportModel.j()).p5(new a());
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> k() {
        return this.titleBean;
    }
}
