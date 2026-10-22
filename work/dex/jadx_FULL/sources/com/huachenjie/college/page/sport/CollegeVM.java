package com.huachenjie.college.page.sport;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.LetterBean;
import com.huachenjie.college.bean.CampusApplicationBean;
import com.huachenjie.college.bean.CollegeTownBean;
import com.huachenjie.college.bean.HuaweiHealthEntryStatusBean;
import com.huachenjie.college.bean.SchoolDetailBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR%\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\n8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000fR\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\n8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\n8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000fR#\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\n8\u0006¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u000fR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\n8\u0006¢\u0006\f\n\u0004\b$\u0010\r\u001a\u0004\b%\u0010\u000fR\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020'0\n8\u0006¢\u0006\f\n\u0004\b(\u0010\r\u001a\u0004\b)\u0010\u000fR%\u0010-\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\n8\u0006¢\u0006\f\n\u0004\b+\u0010\r\u001a\u0004\b,\u0010\u000f¨\u00060"}, d2 = {"Lcom/huachenjie/college/page/sport/CollegeVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "w", "v", "t", "u", "s", "j", j.b, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/college/page/sport/CollegeAdapter;", "a", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", "kotlin.jvm.PlatformType", "b", "p", "redDotFlag", "Lcom/huachenjie/college/bean/SchoolDetailBean;", "c", "q", "schoolDetailBean", "Lcom/huachenjie/college/bean/CollegeTownBean;", "d", "k", "collegeTownData", "", "Lcom/huachenjie/base/bean/LetterBean;", "e", "n", "importantLetterList", "", "f", "r", "skipType", "Lcom/huachenjie/college/bean/HuaweiHealthEntryStatusBean;", y6b.f, "m", "huaweiHealthEntryStatus", y6b.g, t.d, "hasTasks", "<init>", "()V", "college_release"}, k = 1, mv = {1, 8, 0})
public final class CollegeVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<CollegeAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> redDotFlag;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SchoolDetailBean> schoolDetailBean;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<CollegeTownBean> collegeTownData;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<LetterBean>> importantLetterList;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> skipType;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<HuaweiHealthEntryStatusBean> huaweiHealthEntryStatus;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> hasTasks;

    public CollegeVM() {
        Boolean bool = Boolean.FALSE;
        this.redDotFlag = new MutableLiveData<>(bool);
        this.schoolDetailBean = new MutableLiveData<>();
        this.collegeTownData = new MutableLiveData<>();
        this.importantLetterList = new MutableLiveData<>();
        this.skipType = new MutableLiveData<>();
        this.huaweiHealthEntryStatus = new MutableLiveData<>();
        this.hasTasks = new MutableLiveData<>(bool);
    }

    @NotNull
    public final MutableLiveData<CollegeAdapter> i() {
        return this.adapter;
    }

    public final void j() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.college.page.sport.CollegeVM$getCampusApplication$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                CollegeAdapter value = this.this$0.i().getValue();
                if (value != null) {
                    value.setList(CollectionsKt.listOf(new CampusApplicationBean("扫一扫", null, 1, -1, null, 18, null)));
                }
                return Boolean.FALSE;
            }
        }, null, new CollegeVM$getCampusApplication$2(this, null), 11, null);
    }

    @NotNull
    public final MutableLiveData<CollegeTownBean> k() {
        return this.collegeTownData;
    }

    @NotNull
    public final MutableLiveData<Boolean> l() {
        return this.hasTasks;
    }

    @NotNull
    public final MutableLiveData<HuaweiHealthEntryStatusBean> m() {
        return this.huaweiHealthEntryStatus;
    }

    @NotNull
    public final MutableLiveData<List<LetterBean>> n() {
        return this.importantLetterList;
    }

    public final void o() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.college.page.sport.CollegeVM$getImportantLetterList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.n().setValue(new ArrayList());
                return Boolean.FALSE;
            }
        }, null, new CollegeVM$getImportantLetterList$2(this, null), 11, null);
    }

    @NotNull
    public final MutableLiveData<Boolean> p() {
        return this.redDotFlag;
    }

    @NotNull
    public final MutableLiveData<SchoolDetailBean> q() {
        return this.schoolDetailBean;
    }

    @NotNull
    public final MutableLiveData<Integer> r() {
        return this.skipType;
    }

    public final void s() {
        BaseViewModelExtKt.b(this, false, false, null, null, new CollegeVM$queryCollegeTown$1(this, null), 15, null);
    }

    public final void t() {
        BaseViewModelExtKt.b(this, true, false, null, null, new CollegeVM$queryHuaweiHealthEntryStatus$1(this, null), 14, null);
    }

    public final void u() {
        BaseViewModelExtKt.b(this, false, false, null, null, new CollegeVM$querySchoolDetail$1(this, null), 15, null);
    }

    public final void v() {
        BaseViewModelExtKt.b(this, false, false, null, null, new CollegeVM$queryTaskStatus$1(this, null), 15, null);
    }

    public final void w() {
        BaseViewModelExtKt.b(this, false, false, null, null, new CollegeVM$requestRedDot$1(this, null), 13, null);
    }
}
