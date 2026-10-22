package com.huachenjie.college.page.hw_health;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.college.bean.HuaweiHealthTodayDataBean;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J%\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\n8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\"\u0010\u001b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010%\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!¨\u0006("}, d2 = {"Lcom/huachenjie/college/page/hw_health/HWHealthVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "p", j.b, "", "year", "month", "q", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/college/bean/HuaweiHealthTodayDataBean;", "b", "Landroidx/lifecycle/MutableLiveData;", "n", "()Landroidx/lifecycle/MutableLiveData;", "todayData", "Lcom/huachenjie/college/page/hw_health/HWHealthAdapter;", "c", "j", "adapter", "K", "I", "k", "()I", "s", "(I)V", "pageNum", "a", "Ljava/lang/Integer;", "m", "()Ljava/lang/Integer;", "u", "(Ljava/lang/Integer;)V", "selectedYear", t.d, "t", "selectedMonth", "<init>", "()V", "college_release"}, k = 1, mv = {1, 8, 0})
public final class HWHealthVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public Integer selectedYear;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Integer selectedMonth;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<HuaweiHealthTodayDataBean> todayData = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<HWHealthAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    public static /* synthetic */ void r(HWHealthVM hWHealthVM, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = hWHealthVM.selectedYear;
        }
        if ((i & 2) != 0) {
            num2 = hWHealthVM.selectedMonth;
        }
        hWHealthVM.q(num, num2);
    }

    @NotNull
    public final MutableLiveData<HWHealthAdapter> j() {
        return this.adapter;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    @Nullable
    /* JADX INFO: renamed from: l, reason: from getter */
    public final Integer getSelectedMonth() {
        return this.selectedMonth;
    }

    @Nullable
    /* JADX INFO: renamed from: m, reason: from getter */
    public final Integer getSelectedYear() {
        return this.selectedYear;
    }

    @NotNull
    public final MutableLiveData<HuaweiHealthTodayDataBean> n() {
        return this.todayData;
    }

    public final void o() {
        BaseViewModelExtKt.b(this, false, false, null, null, new HWHealthVM$loadSportList$1(this, null), 15, null);
    }

    public final void p() {
        BaseViewModelExtKt.b(this, false, false, null, null, new HWHealthVM$queryHuaweiHealthTodayData$1(this, null), 15, null);
    }

    public final void q(@Nullable Integer year, @Nullable Integer month) {
        this.selectedYear = year;
        this.selectedMonth = month;
        this.pageNum = 1;
        o();
    }

    public final void s(int i) {
        this.pageNum = i;
    }

    public final void t(@Nullable Integer num) {
        this.selectedMonth = num;
    }

    public final void u(@Nullable Integer num) {
        this.selectedYear = num;
    }
}
