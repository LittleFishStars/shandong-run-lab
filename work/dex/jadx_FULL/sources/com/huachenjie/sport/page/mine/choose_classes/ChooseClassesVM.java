package com.huachenjie.sport.page.mine.choose_classes;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.sport.api.SportModel;
import com.huachenjie.sport.bean.PEClassBean;
import com.huachenjie.sport.bean.PEClassesListBean;
import com.huachenjie.sport.bean.PEClassesSelectorBean;
import com.huachenjie.sport.bean.RemainCountBean;
import com.huachenjie.sport.bean.SemesterBean;
import com.huachenjie.sport.bean.SubjectBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.d60;
import com.zj.adlib.fv5;
import com.zj.adlib.n76;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b$\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bY\u0010ZJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u0002R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u00158\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019R\u001b\u0010&\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u000e8\u0006¢\u0006\f\n\u0004\b(\u0010\u0011\u001a\u0004\b(\u0010\u0013R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020*0\u000e8\u0006¢\u0006\f\n\u0004\b+\u0010\u0011\u001a\u0004\b,\u0010\u0013R$\u00103\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010/\u001a\u0004\b+\u00100\"\u0004\b1\u00102R%\u00106\u001a\u0010\u0012\f\u0012\n 4*\u0004\u0018\u00010\u00040\u00040\u000e8\u0006¢\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b5\u0010\u0013R%\u0010:\u001a\u0010\u0012\f\u0012\n 4*\u0004\u0018\u000107070\u000e8\u0006¢\u0006\f\n\u0004\b8\u0010\u0011\u001a\u0004\b9\u0010\u0013R\"\u0010@\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u00101\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R%\u0010B\u001a\u0010\u0012\f\u0012\n 4*\u0004\u0018\u00010\t0\t0\u000e8\u0006¢\u0006\f\n\u0004\b9\u0010\u0011\u001a\u0004\bA\u0010\u0013R\"\u0010E\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u00101\u001a\u0004\bD\u0010=\"\u0004\b;\u0010?R\"\u0010H\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u00101\u001a\u0004\bG\u0010=\"\u0004\bC\u0010?R\"\u0010K\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u00101\u001a\u0004\bJ\u0010=\"\u0004\bF\u0010?R\u001a\u0010O\u001a\u00020\t8\u0006X\u0086D¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\b\u0010\u0010NR%\u0010P\u001a\u0010\u0012\f\u0012\n 4*\u0004\u0018\u00010\t0\t0\u000e8\u0006¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b8\u0010\u0013R%\u0010R\u001a\u0010\u0012\f\u0012\n 4*\u0004\u0018\u00010\u00040\u00040\u000e8\u0006¢\u0006\f\n\u0004\bQ\u0010\u0011\u001a\u0004\bQ\u0010\u0013R%\u0010U\u001a\u0010\u0012\f\u0012\n 4*\u0004\u0018\u000107070\u000e8\u0006¢\u0006\f\n\u0004\bS\u0010\u0011\u001a\u0004\bT\u0010\u0013R%\u0010V\u001a\u0010\u0012\f\u0012\n 4*\u0004\u0018\u00010\t0\t0\u000e8\u0006¢\u0006\f\n\u0004\bT\u0010\u0011\u001a\u0004\bS\u0010\u0013R%\u0010X\u001a\u0010\u0012\f\u0012\n 4*\u0004\u0018\u00010\u00040\u00040\u000e8\u0006¢\u0006\f\n\u0004\bA\u0010\u0011\u001a\u0004\bW\u0010\u0013¨\u0006["}, d2 = {"Lcom/huachenjie/sport/page/mine/choose_classes/ChooseClassesVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "G", "", "isRefresh", "F", y6b.g, "E", "", "getEmptyText", "courseCode", t.d, "H", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", "C", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "", "a", "Ljava/util/List;", "w", "()Ljava/util/List;", "semesterList", "c", j.o, "subjectList", "", "d", "B", "timeList", "Lcom/huachenjie/sport/api/SportModel;", "Lkotlin/Lazy;", j.b, "()Lcom/huachenjie/sport/api/SportModel;", ze1.k, "Lcom/huachenjie/sport/page/mine/choose_classes/ChooseClassesAdapter;", "j", "classesAdapter", "Lcom/huachenjie/sport/bean/PEClassesSelectorBean;", "k", "u", "selectorData", "Lcom/huachenjie/sport/bean/PEClassesListBean;", "Lcom/huachenjie/sport/bean/PEClassesListBean;", "()Lcom/huachenjie/sport/bean/PEClassesListBean;", "I", "(Lcom/huachenjie/sport/bean/PEClassesListBean;)V", "classesListData", "kotlin.jvm.PlatformType", "D", "isRefreshing", "", "m", "n", "layoutState", "K", "t", "()I", "J", "(I)V", "searchType", "s", PEClassesSearchActivity.x, "L", "v", "semesterIndex", "M", "y", "subjectIndex", "N", "A", "timeIndex", "f", "Ljava/lang/String;", "()Ljava/lang/String;", "attendDay", "filterString", "p", "notSignUp", "q", "r", "resetCourseCount", "resetCourseCode", "x", "startChooseCourse", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class ChooseClassesVM extends BaseVM {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int searchType;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public int semesterIndex;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    public int subjectIndex;

    /* JADX INFO: renamed from: N, reason: from kotlin metadata */
    public int timeIndex;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public PEClassesListBean classesListData;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final String attendDay;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> layoutState;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> searchText;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> filterString;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> notSignUp;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> resetCourseCount;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> resetCourseCode;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> startChooseCourse;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final List<String> semesterList = new ArrayList();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final List<String> subjectList = new ArrayList();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final List<String> timeList = CollectionsKt.listOf(new String[]{"全部", "周一", "周二", "周三", "周四", "周五", "周六", "周日"});

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy model = LazyKt.lazy(new Function0<SportModel>() { // from class: com.huachenjie.sport.page.mine.choose_classes.ChooseClassesVM$model$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SportModel m770invoke() {
            return new SportModel();
        }
    });

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ChooseClassesAdapter> classesAdapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<PEClassesSelectorBean> selectorData = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/choose_classes/ChooseClassesVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/sport/bean/RemainCountBean;", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<RemainCountBean> {
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(ChooseClassesVM.this, true);
            this.f = str;
        }

        public void onCCSuccess(@Nullable RemainCountBean data) {
            Integer remainCount;
            if (data == null || (remainCount = data.getRemainCount()) == null) {
                return;
            }
            ChooseClassesVM chooseClassesVM = ChooseClassesVM.this;
            String str = this.f;
            chooseClassesVM.r().setValue(Integer.valueOf(remainCount.intValue()));
            chooseClassesVM.q().setValue(str);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0014¨\u0006\f"}, d2 = {"com/huachenjie/sport/page/mine/choose_classes/ChooseClassesVM$b", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/sport/bean/PEClassesListBean;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "onFinish", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DialogVMSubscriber<PEClassesListBean> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Ref.IntRef f13736a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ref.IntRef intRef) {
            super(ChooseClassesVM.this, true);
            this.f13736a = intRef;
        }

        public void onFailed(int code, @Nullable String message) {
            super.onFailed(code, message);
            ChooseClassesVM.this.n().setValue(3);
        }

        public void onFinish() {
            super.onFinish();
            ChooseClassesVM.this.D().setValue(Boolean.FALSE);
        }

        public void onCCSuccess(@Nullable PEClassesListBean data) {
            ChooseClassesVM.this.I(data);
            if (data == null) {
                ChooseClassesVM.this.n().setValue(2);
                return;
            }
            List<PEClassBean> list = data.getList();
            if (list != null) {
                Ref.IntRef intRef = this.f13736a;
                ChooseClassesVM chooseClassesVM = ChooseClassesVM.this;
                if (intRef.element == 1) {
                    ChooseClassesAdapter value = chooseClassesVM.j().getValue();
                    Intrinsics.checkNotNull(value);
                    value.setList(list);
                } else {
                    ChooseClassesAdapter value2 = chooseClassesVM.j().getValue();
                    Intrinsics.checkNotNull(value2);
                    value2.addData((Collection) list);
                }
            }
            if (Intrinsics.areEqual(data.getHasNext(), Boolean.TRUE)) {
                ChooseClassesAdapter value3 = ChooseClassesVM.this.j().getValue();
                Intrinsics.checkNotNull(value3);
                value3.getLoadMoreModule().loadMoreComplete();
            } else {
                ChooseClassesAdapter value4 = ChooseClassesVM.this.j().getValue();
                Intrinsics.checkNotNull(value4);
                BaseLoadMoreModule.loadMoreEnd$default(value4.getLoadMoreModule(), false, 1, null);
            }
            Integer pageNum = data.getPageNum();
            if (pageNum == null || pageNum.intValue() != 1) {
                ChooseClassesVM.this.n().setValue(1);
            } else if (data.getList() == null || data.getList().isEmpty()) {
                ChooseClassesVM.this.n().setValue(2);
            } else {
                ChooseClassesVM.this.n().setValue(1);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/choose_classes/ChooseClassesVM$c", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/sport/bean/PEClassesSelectorBean;", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DialogVMSubscriber<PEClassesSelectorBean> {
        public c() {
            super(ChooseClassesVM.this, true);
        }

        public void onCCSuccess(@Nullable PEClassesSelectorBean data) {
            if ((data != null ? data.getSemesterList() : null) == null || data.getSemesterList().isEmpty()) {
                ChooseClassesVM.this.n().setValue(3);
                return;
            }
            Iterator<SemesterBean> it = data.getSemesterList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SemesterBean next = it.next();
                if (next != null) {
                    List<String> listW = ChooseClassesVM.this.w();
                    String semesterName = next.getSemesterName();
                    listW.add(semesterName != null ? semesterName : "");
                }
            }
            ChooseClassesVM.this.z().add("全部");
            if (data.getSubjectList() != null) {
                for (SubjectBean subjectBean : data.getSubjectList()) {
                    if (subjectBean != null) {
                        List<String> listZ = ChooseClassesVM.this.z();
                        String subjectName = subjectBean.getSubjectName();
                        if (subjectName == null) {
                            subjectName = "";
                        }
                        listZ.add(subjectName);
                    }
                }
            }
            ChooseClassesVM.this.h();
            ChooseClassesVM.this.u().setValue(data);
            ChooseClassesVM.this.F(true);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/choose_classes/ChooseClassesVM$d", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends DialogVMSubscriber<Object> {
        public d() {
            super(ChooseClassesVM.this, true);
        }

        public void onCCSuccess(@Nullable Object data) {
            ChooseClassesVM.this.q().setValue("");
            ChooseClassesVM.this.x().setValue(Boolean.TRUE);
        }
    }

    public ChooseClassesVM() {
        Boolean bool = Boolean.FALSE;
        this.isRefreshing = new MutableLiveData<>(bool);
        this.layoutState = new MutableLiveData<>(1);
        this.searchType = 1;
        this.searchText = new MutableLiveData<>("");
        this.attendDay = "";
        this.filterString = new MutableLiveData<>("");
        this.notSignUp = new MutableLiveData<>(Boolean.TRUE);
        this.resetCourseCount = new MutableLiveData<>(-1);
        this.resetCourseCode = new MutableLiveData<>("");
        this.startChooseCourse = new MutableLiveData<>(bool);
    }

    /* JADX INFO: renamed from: A, reason: from getter */
    public final int getTimeIndex() {
        return this.timeIndex;
    }

    @NotNull
    public final List<String> B() {
        return this.timeList;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> C() {
        return this.titleBean;
    }

    @NotNull
    public final MutableLiveData<Boolean> D() {
        return this.isRefreshing;
    }

    public final void E() {
        F(true);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x008d  */
    public final void F(boolean isRefresh) {
        String subjectCode;
        String semesterCode;
        String strValueOf;
        if (isRefresh) {
            this.classesListData = null;
        }
        String value = this.searchText.getValue();
        Boolean value2 = this.notSignUp.getValue();
        if (this.searchType == 1) {
            PEClassesSelectorBean value3 = this.selectorData.getValue();
            if ((value3 != null ? value3.getSemesterList() : null) == null) {
                this.isRefreshing.setValue(Boolean.FALSE);
                return;
            }
            List<SemesterBean> semesterList = value3.getSemesterList();
            if (this.searchType == 1 && (semesterList.isEmpty() || semesterList.size() < this.semesterIndex + 1)) {
                fv5.b("没有查询到学期数据");
                this.isRefreshing.setValue(Boolean.FALSE);
                return;
            }
            semesterCode = semesterList.get(this.semesterIndex).getSemesterCode();
            List<SubjectBean> subjectList = value3.getSubjectList();
            if (subjectList == null || !(!subjectList.isEmpty())) {
                subjectCode = null;
            } else {
                int size = subjectList.size();
                int i = this.subjectIndex;
                if (size <= i - 1 || i == 0) {
                    subjectCode = null;
                } else {
                    subjectCode = subjectList.get(i - 1).getSubjectCode();
                }
            }
            int i2 = this.timeIndex;
            strValueOf = i2 != 0 ? String.valueOf(i2) : null;
        } else {
            subjectCode = null;
            semesterCode = null;
            strValueOf = null;
        }
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 1;
        PEClassesListBean pEClassesListBean = this.classesListData;
        if (pEClassesListBean != null) {
            Intrinsics.checkNotNull(pEClassesListBean);
            if (pEClassesListBean.getPageNum() != null) {
                PEClassesListBean pEClassesListBean2 = this.classesListData;
                Integer pageNum = pEClassesListBean2 != null ? pEClassesListBean2.getPageNum() : null;
                Intrinsics.checkNotNull(pageNum);
                intRef.element = pageNum.intValue() + 1;
            }
        }
        SportModel sportModelO = o();
        int i3 = this.searchType;
        Intrinsics.checkNotNull(value2);
        sportModelO.w(i3, value, value2.booleanValue(), semesterCode == null ? "" : semesterCode, subjectCode == null ? "" : subjectCode, strValueOf, 10, intRef.element).u5(Schedulers.io()).G3(d60.c()).p5(new b(intRef));
    }

    public final void G() {
        o().x().u5(Schedulers.io()).G3(d60.c()).p5(new c());
    }

    public final void H() {
        n76.e(this, o().L(this.resetCourseCode.getValue())).p5(new d());
    }

    public final void I(@Nullable PEClassesListBean pEClassesListBean) {
        this.classesListData = pEClassesListBean;
    }

    public final void J(int i) {
        this.searchType = i;
    }

    public final void K(int i) {
        this.semesterIndex = i;
    }

    public final void L(int i) {
        this.subjectIndex = i;
    }

    public final void M(int i) {
        this.timeIndex = i;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVM
    @NotNull
    public String getEmptyText() {
        if (this.searchType == 2) {
            return "暂无学期数据";
        }
        return TextUtils.isEmpty(this.searchText.getValue()) ? "暂无选课课程" : "没有查询到相关课程";
    }

    public final void h() {
        String str = this.semesterList.get(this.semesterIndex);
        int i = this.subjectIndex;
        String str2 = i == 0 ? "全部科目" : this.subjectList.get(i);
        int i2 = this.timeIndex;
        this.filterString.setValue("筛选: " + str + " / " + str2 + " / " + (i2 == 0 ? "全部上课时间" : this.timeList.get(i2)));
    }

    @NotNull
    /* JADX INFO: renamed from: i, reason: from getter */
    public final String getAttendDay() {
        return this.attendDay;
    }

    @NotNull
    public final MutableLiveData<ChooseClassesAdapter> j() {
        return this.classesAdapter;
    }

    @Nullable
    /* JADX INFO: renamed from: k, reason: from getter */
    public final PEClassesListBean getClassesListData() {
        return this.classesListData;
    }

    public final void l(@NotNull String courseCode) {
        Intrinsics.checkNotNullParameter(courseCode, "courseCode");
        n76.e(this, o().g(courseCode)).p5(new a(courseCode));
    }

    @NotNull
    public final MutableLiveData<String> m() {
        return this.filterString;
    }

    @NotNull
    public final MutableLiveData<Integer> n() {
        return this.layoutState;
    }

    public final SportModel o() {
        return (SportModel) this.model.getValue();
    }

    @NotNull
    public final MutableLiveData<Boolean> p() {
        return this.notSignUp;
    }

    @NotNull
    public final MutableLiveData<String> q() {
        return this.resetCourseCode;
    }

    @NotNull
    public final MutableLiveData<Integer> r() {
        return this.resetCourseCount;
    }

    @NotNull
    public final MutableLiveData<String> s() {
        return this.searchText;
    }

    /* JADX INFO: renamed from: t, reason: from getter */
    public final int getSearchType() {
        return this.searchType;
    }

    @NotNull
    public final MutableLiveData<PEClassesSelectorBean> u() {
        return this.selectorData;
    }

    /* JADX INFO: renamed from: v, reason: from getter */
    public final int getSemesterIndex() {
        return this.semesterIndex;
    }

    @NotNull
    public final List<String> w() {
        return this.semesterList;
    }

    @NotNull
    public final MutableLiveData<Boolean> x() {
        return this.startChooseCourse;
    }

    /* JADX INFO: renamed from: y, reason: from getter */
    public final int getSubjectIndex() {
        return this.subjectIndex;
    }

    @NotNull
    public final List<String> z() {
        return this.subjectList;
    }
}
