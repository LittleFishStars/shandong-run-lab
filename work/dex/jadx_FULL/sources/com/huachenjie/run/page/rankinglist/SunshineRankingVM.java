package com.huachenjie.run.page.rankinglist;

import android.text.TextUtils;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.run.bean.RankItemData;
import com.huachenjie.run.bean.SunshineRankingData;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.ai9;
import com.zj.adlib.aw8;
import com.zj.adlib.d60;
import com.zj.adlib.fq1;
import com.zj.adlib.h46;
import com.zj.adlib.ll7;
import com.zj.adlib.n76;
import com.zj.adlib.s72;
import com.zj.adlib.ta7;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bW\u0010XJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eR\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R%\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00020\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR%\u0010!\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00020\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b \u0010\u001eR%\u0010#\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00020\u00020\u00198\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\"\u0010\u001eR%\u0010&\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00020\u00020\u00198\u0006¢\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001eR%\u0010)\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00020\u00020\u00198\u0006¢\u0006\f\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010\u001eR%\u0010,\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010*0*0\u00198\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b+\u0010\u001eR(\u00100\u001a\b\u0012\u0004\u0012\u00020\b0\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001c\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010/R%\u00103\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u000101010\u00198\u0006¢\u0006\f\n\u0004\b2\u0010\u001c\u001a\u0004\b$\u0010\u001eR\u001d\u00106\u001a\b\u0012\u0004\u0012\u0002040\u00198\u0006¢\u0006\f\n\u0004\b5\u0010\u001c\u001a\u0004\b'\u0010\u001eR\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000e078\u0006¢\u0006\f\n\u0004\b\u0016\u00108\u001a\u0004\b9\u0010:R\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000e078\u0006¢\u0006\f\n\u0004\b<\u00108\u001a\u0004\b=\u0010:R\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000e078\u0006¢\u0006\f\n\u0004\b?\u00108\u001a\u0004\b@\u0010:R\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020*078\u0006¢\u0006\f\n\u0004\bB\u00108\u001a\u0004\bC\u0010:R\u001d\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000e078\u0006¢\u0006\f\n\u0004\bE\u00108\u001a\u0004\bF\u0010:R\u001d\u0010K\u001a\b\u0012\u0004\u0012\u00020H078\u0006¢\u0006\f\n\u0004\bI\u00108\u001a\u0004\bJ\u0010:R\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020*078\u0006¢\u0006\f\n\u0004\bL\u00108\u001a\u0004\bM\u0010:R\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020*078\u0006¢\u0006\f\n\u0004\bO\u00108\u001a\u0004\bP\u0010:R\u001d\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00020\u00198\u0006¢\u0006\f\n\u0004\bM\u0010\u001c\u001a\u0004\bR\u0010\u001eR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020H0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010\u001cR\u001d\u0010U\u001a\b\u0012\u0004\u0012\u00020\u0002078\u0006¢\u0006\f\n\u0004\b\u001b\u00108\u001a\u0004\b5\u0010:R\u001d\u0010V\u001a\b\u0012\u0004\u0012\u00020\u000e078\u0006¢\u0006\f\n\u0004\b\u0014\u00108\u001a\u0004\b2\u0010:¨\u0006Y"}, d2 = {"Lcom/huachenjie/run/page/rankinglist/SunshineRankingVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "sex", "", "J", "type", "I", "Lcom/huachenjie/run/bean/SunshineRankingData;", "data", "L", "H", "k", "rankNumber", "Lcom/huachenjie/run/bean/RankItemData;", "n", "K", "item", "position", "G", "j", "Lcom/zj/adlib/aw8;", "a", "Lcom/zj/adlib/aw8;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "i", "Landroidx/lifecycle/MutableLiveData;", j.b, "()Landroidx/lifecycle/MutableLiveData;", "layoutState", "w", "rankingListType", "x", "rankingType", t.d, j.o, "studentRange", "m", "A", "timeRange", "", "y", "runPlanCode", "v", "M", "(Landroidx/lifecycle/MutableLiveData;)V", "rankingData", "Lcom/huachenjie/run/page/rankinglist/SunshineRankingAdapter;", "p", "adapter", "", "q", "alpha", "Landroidx/lifecycle/MediatorLiveData;", "Landroidx/lifecycle/MediatorLiveData;", "B", "()Landroidx/lifecycle/MediatorLiveData;", "top1", "b", "C", "top2", "c", "D", "top3", "d", "E", "updateTimeStr", "e", "s", "myRank", "", "f", "F", "isShowMyRank", y6b.f, "r", "myDistance", y6b.g, "u", "myUpdateMs", "t", "mySex", "requesting", "likeType", "likeItem", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class SunshineRankingVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final aw8 model = new aw8();

    /* JADX INFO: renamed from: i, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> layoutState = new MutableLiveData<>(1);

    /* JADX INFO: renamed from: j, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> rankingListType = new MutableLiveData<>(1);

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> rankingType = new MutableLiveData<>(2);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> studentRange = new MutableLiveData<>(50);

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> timeRange = new MutableLiveData<>(30);

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> runPlanCode = new MutableLiveData<>("");

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<SunshineRankingData> rankingData = new MutableLiveData<>();

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SunshineRankingAdapter> adapter = new MutableLiveData<>(new SunshineRankingAdapter());

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Float> alpha = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MediatorLiveData<RankItemData> top1 = new MediatorLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<RankItemData> top2 = new MediatorLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<RankItemData> top3 = new MediatorLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> updateTimeStr = new MediatorLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<RankItemData> myRank = new MediatorLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<Boolean> isShowMyRank = new MediatorLiveData<>();

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> myDistance = new MediatorLiveData<>();

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> myUpdateMs = new MediatorLiveData<>();

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> mySex = new MutableLiveData<>();

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> requesting = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<Integer> likeType = new MediatorLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<RankItemData> likeItem = new MediatorLiveData<>();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/run/page/rankinglist/SunshineRankingVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/run/bean/SunshineRankingData;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<SunshineRankingData> {
        public final /* synthetic */ int K;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(SunshineRankingVM.this, true);
            this.K = i;
        }

        public void onFailed(int code, @Nullable String message) {
            super.onFailed(code, message);
            SunshineRankingVM.this.H(this.K);
        }

        public void onCCSuccess(@Nullable SunshineRankingData data) {
            SunshineRankingVM.this.L(this.K, data);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/run/page/rankinglist/SunshineRankingVM$b", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/run/bean/SunshineRankingData;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DialogVMSubscriber<SunshineRankingData> {
        public final /* synthetic */ int K;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(SunshineRankingVM.this, true);
            this.K = i;
        }

        public void onFailed(int code, @Nullable String message) {
            super.onFailed(code, message);
            SunshineRankingVM.this.H(this.K);
        }

        public void onCCSuccess(@Nullable SunshineRankingData data) {
            SunshineRankingVM.this.L(this.K, data);
        }
    }

    @NotNull
    public final MutableLiveData<Integer> A() {
        return this.timeRange;
    }

    @NotNull
    public final MediatorLiveData<RankItemData> B() {
        return this.top1;
    }

    @NotNull
    public final MediatorLiveData<RankItemData> C() {
        return this.top2;
    }

    @NotNull
    public final MediatorLiveData<RankItemData> D() {
        return this.top3;
    }

    @NotNull
    public final MediatorLiveData<String> E() {
        return this.updateTimeStr;
    }

    @NotNull
    public final MediatorLiveData<Boolean> F() {
        return this.isShowMyRank;
    }

    public final void G(@Nullable RankItemData item, int position) {
        if (TextUtils.isEmpty(item != null ? item.getAppUserCode() : null) || item == null) {
            return;
        }
        if (item.getHasLiked()) {
            ta7 ta7Var = ta7.f44881a;
            String appUserCode = item.getAppUserCode();
            Integer value = this.rankingListType.getValue();
            if (value == null) {
                value = 0;
            }
            Intrinsics.checkNotNullExpressionValue(value, "rankingListType.value ?: 0");
            ta7Var.c(appUserCode, value.intValue());
        } else {
            ta7 ta7Var2 = ta7.f44881a;
            String appUserCode2 = item.getAppUserCode();
            Integer value2 = this.rankingListType.getValue();
            if (value2 == null) {
                value2 = 0;
            }
            Intrinsics.checkNotNullExpressionValue(value2, "rankingListType.value ?: 0");
            ta7Var2.b(appUserCode2, value2.intValue());
        }
        this.likeType.setValue(Integer.valueOf(position));
        this.likeItem.setValue(item);
    }

    public final void H(int sex) {
        L(sex, null);
    }

    public final void I(int sex, int type) {
        aw8 aw8Var = this.model;
        Integer value = this.studentRange.getValue();
        Intrinsics.checkNotNull(value);
        int iIntValue = value.intValue();
        Integer value2 = this.timeRange.getValue();
        Intrinsics.checkNotNull(value2);
        int iIntValue2 = value2.intValue();
        String value3 = this.runPlanCode.getValue();
        if (value3 == null) {
            value3 = "";
        }
        n76.e(this, aw8Var.i(sex, iIntValue, iIntValue2, type, value3)).p5(new a(sex));
    }

    public final void J(int sex) {
        Integer value = this.studentRange.getValue();
        if (value != null) {
            aw8 aw8Var = this.model;
            int iIntValue = value.intValue();
            String value2 = this.runPlanCode.getValue();
            if (value2 == null) {
                value2 = "";
            }
            aw8Var.j(sex, iIntValue, value2).u5(Schedulers.io()).G3(d60.c()).p5(new b(sex));
        }
    }

    public final void K(int sex) {
        Boolean value = this.requesting.getValue();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(value, bool)) {
            return;
        }
        this.requesting.setValue(bool);
        Integer value2 = this.rankingListType.getValue();
        if (value2 != null && value2.intValue() == 1) {
            I(sex, 1);
            return;
        }
        if (value2 != null && value2.intValue() == 2) {
            I(sex, 2);
        } else if (value2 != null && value2.intValue() == 3) {
            J(sex);
        }
    }

    public final void L(int sex, SunshineRankingData data) {
        this.requesting.setValue(Boolean.FALSE);
        this.isShowMyRank.setValue(Boolean.valueOf(ai9.e().getSex() == sex));
        this.rankingData.setValue(data == null ? new SunshineRankingData(new RankItemData(2, "", "", "", 0L, "", 0, 0.0f, null, 0L, null, null, 0, false, 16256, null), new ArrayList(), 0L) : data);
        k(this.rankingData.getValue());
        this.rankingType.setValue(Integer.valueOf(sex));
    }

    public final void M(@NotNull MutableLiveData<SunshineRankingData> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.rankingData = mutableLiveData;
    }

    @NotNull
    public final RankItemData j(@NotNull RankItemData item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getHasLiked()) {
            item.setHasLiked(false);
            if (item.getLikeCount() > 0) {
                item.setLikeCount(item.getLikeCount() - 1);
            }
        } else {
            item.setHasLiked(true);
            item.setLikeCount(item.getLikeCount() + 1);
        }
        return item;
    }

    public final void k(SunshineRankingData data) {
        String strF;
        if (data != null) {
            if (data.getRankUpdateTime() != 0) {
                this.updateTimeStr.setValue("上次更新时间: " + s72.c(data.getRankUpdateTime(), "yyyy-MM-dd HH:mm:ss"));
            }
            this.myRank.setValue(data.getMyRank());
            RankItemData value = this.myRank.getValue();
            Long lValueOf = value != null ? Long.valueOf(value.getUpdateTime()) : null;
            if (lValueOf == null || lValueOf.longValue() == 0) {
                lValueOf = Long.valueOf(System.currentTimeMillis());
            }
            this.myUpdateMs.setValue(fq1.a(lValueOf.longValue(), "MM/dd HH:mm"));
            MediatorLiveData<String> mediatorLiveData = this.myDistance;
            Integer value2 = this.rankingListType.getValue();
            if (value2 != null && value2.intValue() == 3) {
                h46 h46Var = h46.f42049a;
                RankItemData myRank = data.getMyRank();
                strF = h46Var.f(myRank != null ? myRank.getProgress() : 0.0f);
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Object[] objArr = new Object[1];
                ll7 ll7Var = ll7.f43096a;
                RankItemData value3 = this.myRank.getValue();
                objArr[0] = ll7Var.g(value3 != null ? Long.valueOf(value3.getDistance()) : null);
                strF = String.format("%skm", Arrays.copyOf(objArr, 1));
                Intrinsics.checkNotNullExpressionValue(strF, "format(format, *args)");
            }
            mediatorLiveData.setValue(strF);
            ArrayList<RankItemData> rankList = data.getRankList();
            if (rankList == null || rankList.isEmpty()) {
                this.top1.setValue(n(1));
                this.top2.setValue(n(2));
                this.top3.setValue(n(3));
            } else {
                int size = data.getRankList().size();
                if (size == 1) {
                    this.top1.setValue(data.getRankList().get(0));
                    this.top2.setValue(n(2));
                    this.top3.setValue(n(3));
                } else if (size != 2) {
                    this.top1.setValue(data.getRankList().get(0));
                    this.top2.setValue(data.getRankList().get(1));
                    this.top3.setValue(data.getRankList().get(2));
                } else {
                    this.top1.setValue(data.getRankList().get(0));
                    this.top2.setValue(data.getRankList().get(1));
                    this.top3.setValue(n(3));
                }
            }
        }
        this.mySex.setValue(Integer.valueOf(ai9.e().getSex()));
        this.rankingType.setValue(Integer.valueOf(ai9.e().getSex()));
    }

    @NotNull
    public final MutableLiveData<SunshineRankingAdapter> l() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Float> m() {
        return this.alpha;
    }

    public final RankItemData n(int rankNumber) {
        return new RankItemData(2, "", "", "", 0L, "虚位以待", rankNumber, 0.0f, "0", 0L, "", "萌新", 0, false);
    }

    @NotNull
    public final MutableLiveData<Integer> o() {
        return this.layoutState;
    }

    @NotNull
    public final MediatorLiveData<RankItemData> p() {
        return this.likeItem;
    }

    @NotNull
    public final MediatorLiveData<Integer> q() {
        return this.likeType;
    }

    @NotNull
    public final MediatorLiveData<String> r() {
        return this.myDistance;
    }

    @NotNull
    public final MediatorLiveData<RankItemData> s() {
        return this.myRank;
    }

    @NotNull
    public final MutableLiveData<Integer> t() {
        return this.mySex;
    }

    @NotNull
    public final MediatorLiveData<String> u() {
        return this.myUpdateMs;
    }

    @NotNull
    public final MutableLiveData<SunshineRankingData> v() {
        return this.rankingData;
    }

    @NotNull
    public final MutableLiveData<Integer> w() {
        return this.rankingListType;
    }

    @NotNull
    public final MutableLiveData<Integer> x() {
        return this.rankingType;
    }

    @NotNull
    public final MutableLiveData<String> y() {
        return this.runPlanCode;
    }

    @NotNull
    public final MutableLiveData<Integer> z() {
        return this.studentRange;
    }
}
