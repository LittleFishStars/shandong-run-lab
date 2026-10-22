package com.huachenjie.sport.page.mine.sport_test.result;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.sport.api.SportModel;
import com.huachenjie.sport.bean.SportTestResultBean;
import com.huachenjie.sport.bean.SportTestResultYearBean;
import com.huachenjie.sport.bean.TestResultYearBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.d60;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR%\u0010\u0011\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000b8\u0006¢\u0006\f\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0015\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00120\u00120\u000b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R#\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u000b8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000b8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010¨\u0006 "}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestResultScoreVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", j.b, "n", "Lcom/huachenjie/sport/api/SportModel;", "a", "Lkotlin/Lazy;", "i", "()Lcom/huachenjie/sport/api/SportModel;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestResultScoreAdapter;", "kotlin.jvm.PlatformType", "Landroidx/lifecycle/MutableLiveData;", "m", "()Landroidx/lifecycle/MutableLiveData;", "scoreAdapter", "Lcom/huachenjie/sport/page/mine/sport_test/result/SportTestResultAddScoreAdapter;", "j", y6b.g, "addAdapter", "", "Lcom/huachenjie/sport/bean/TestResultYearBean;", "k", t.d, "schoolYearData", "schoolYear", "Lcom/huachenjie/sport/bean/SportTestResultBean;", "resultBean", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class SportTestResultScoreVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy model = LazyKt.lazy(new Function0<SportModel>() { // from class: com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreVM$model$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SportModel m796invoke() {
            return new SportModel();
        }
    });

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SportTestResultScoreAdapter> scoreAdapter = new MutableLiveData<>(new SportTestResultScoreAdapter());

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SportTestResultAddScoreAdapter> addAdapter = new MutableLiveData<>(new SportTestResultAddScoreAdapter());

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<TestResultYearBean>> schoolYearData = new MutableLiveData<>();

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<TestResultYearBean> schoolYear = new MutableLiveData<>();

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SportTestResultBean> resultBean = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/sport_test/result/SportTestResultScoreVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/sport/bean/SportTestResultBean;", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<SportTestResultBean> {
        public a() {
            super(SportTestResultScoreVM.this, true);
        }

        public void onCCSuccess(@Nullable SportTestResultBean data) {
            if (data == null) {
                return;
            }
            SportTestResultScoreVM.this.j().setValue(data);
            SportTestResultScoreAdapter value = SportTestResultScoreVM.this.m().getValue();
            Intrinsics.checkNotNull(value);
            value.setList(data.getScoringItems());
            SportTestResultAddScoreAdapter value2 = SportTestResultScoreVM.this.h().getValue();
            Intrinsics.checkNotNull(value2);
            value2.setList(data.getAddPointItems());
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/sport_test/result/SportTestResultScoreVM$b", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/sport/bean/SportTestResultYearBean;", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DialogVMSubscriber<SportTestResultYearBean> {
        public b() {
            super(SportTestResultScoreVM.this, true);
        }

        public void onCCSuccess(@Nullable SportTestResultYearBean data) {
            if ((data != null ? data.getList() : null) == null) {
                return;
            }
            SportTestResultScoreVM.this.l().setValue(data.getList());
        }
    }

    @NotNull
    public final MutableLiveData<SportTestResultAddScoreAdapter> h() {
        return this.addAdapter;
    }

    @NotNull
    public final SportModel i() {
        return (SportModel) this.model.getValue();
    }

    @NotNull
    public final MutableLiveData<SportTestResultBean> j() {
        return this.resultBean;
    }

    @NotNull
    public final MutableLiveData<TestResultYearBean> k() {
        return this.schoolYear;
    }

    @NotNull
    public final MutableLiveData<List<TestResultYearBean>> l() {
        return this.schoolYearData;
    }

    @NotNull
    public final MutableLiveData<SportTestResultScoreAdapter> m() {
        return this.scoreAdapter;
    }

    public final void n() {
        SportModel sportModelI = i();
        TestResultYearBean value = this.schoolYear.getValue();
        sportModelI.H(value != null ? value.getAcademicYearCode() : null).u5(Schedulers.io()).G3(d60.c()).p5(new a());
    }

    public final void o() {
        i().I().u5(Schedulers.io()).G3(d60.c()).p5(new b());
    }
}
