package com.huachenjie.run.page.run_detail;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.bean.PaceInfo;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.run.bean.RunDetailEntity;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.ai9;
import com.zj.adlib.jj8;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\u000b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R%\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u000f8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R%\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00040\u00040\u000f8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/run/page/run_detail/RunDetailVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "q", "", "visible", "", "j", "k", "runRecordCode", "semesterCode", "p", "Lcom/huachenjie/run/bean/RunDetailEntity;", "data", j.b, "Landroidx/lifecycle/MutableLiveData;", "a", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "detailLiveData", "", "kotlin.jvm.PlatformType", "b", "m", "mapHeightPx", "c", "n", "userInfoVisible", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRunDetailVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunDetailVM.kt\ncom/huachenjie/run/page/run_detail/RunDetailVM\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,87:1\n1559#2:88\n1590#2,4:89\n*S KotlinDebug\n*F\n+ 1 RunDetailVM.kt\ncom/huachenjie/run/page/run_detail/RunDetailVM\n*L\n65#1:88\n65#1:89,4\n*E\n"})
public final class RunDetailVM extends BaseViewModel {
    public static final int K = 420;
    public static final int L = 272;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<RunDetailEntity> detailLiveData = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Float> mapHeightPx = new MutableLiveData<>(Float.valueOf(jj8.a(420.0f)));

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> userInfoVisible = new MutableLiveData<>(Boolean.TRUE);

    @NotNull
    public final String j(boolean visible) {
        return visible ? ai9.e().getUserName() : "******";
    }

    @NotNull
    public final String k(boolean visible) {
        return visible ? "学号：" + ai9.e().getStudentNumber() : "********************";
    }

    @NotNull
    public final MutableLiveData<RunDetailEntity> l() {
        return this.detailLiveData;
    }

    @NotNull
    public final MutableLiveData<Float> m() {
        return this.mapHeightPx;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.userInfoVisible;
    }

    public final void o(RunDetailEntity data) {
        int iIntValue;
        List<Long> paceList = data.getPaceList();
        List<Long> list = paceList;
        int i = 0;
        if (list == null || list.isEmpty()) {
            data.setPaceInfoList(CollectionsKt.emptyList());
            return;
        }
        Intrinsics.checkNotNullExpressionValue(paceList, "paceList");
        List listSorted = CollectionsKt.sorted(paceList);
        Long l = (Long) CollectionsKt.last(listSorted);
        Long l2 = (Long) CollectionsKt.first(listSorted);
        boolean z = paceList.size() > 1;
        List<Long> list2 = paceList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Object obj : list2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Long l3 = (Long) obj;
            PaceInfo paceInfo = new PaceInfo();
            paceInfo.setKilometerNo(i2);
            Intrinsics.checkNotNullExpressionValue(l3, "pace");
            paceInfo.setPace(l3.longValue());
            paceInfo.setTime(l3.longValue());
            if (l != null && l.longValue() == 0) {
                iIntValue = 100;
            } else {
                BigDecimal bigDecimalValueOf = BigDecimal.valueOf(paceInfo.getPace());
                Intrinsics.checkNotNullExpressionValue(l, "maxPace");
                iIntValue = bigDecimalValueOf.divide(BigDecimal.valueOf(l.longValue()), 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(0.5d)).add(BigDecimal.valueOf(0.5d)).multiply(BigDecimal.valueOf(100L)).intValue();
            }
            paceInfo.setPercents(iIntValue);
            if (z && Intrinsics.areEqual(l3, l2)) {
                paceInfo.setFasePace(true);
            }
            arrayList.add(paceInfo);
            i = i2;
        }
        data.setPaceInfoList(arrayList);
    }

    public final void p(@Nullable String runRecordCode, @Nullable String semesterCode) {
        BaseViewModelExtKt.b(this, true, false, null, null, new RunDetailVM$queryRunDetail$1(runRecordCode, semesterCode, this, null), 14, null);
    }

    public final void q() {
        MutableLiveData<Boolean> mutableLiveData = this.userInfoVisible;
        Boolean value = mutableLiveData.getValue();
        if (value == null) {
            value = Boolean.TRUE;
        }
        mutableLiveData.setValue(Boolean.valueOf(!value.booleanValue()));
    }
}
