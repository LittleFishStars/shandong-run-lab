package com.huachenjie.works.page.alumni.find_alumni;

import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.zj.adlib.y6b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-J\u0012\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bJ\u0006\u0010\u000b\u001a\u00020\u0004J0\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bJ\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fR%\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u00130\u00128\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00128\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010#R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010)R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010+¨\u0006."}, d2 = {"Lcom/huachenjie/works/page/alumni/find_alumni/FindAlumniVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "sex", "", j.o, "gradeCode", "w", "", "tagNoList", "B", "y", "u", "t", "D", "Landroid/view/View;", "emptyView", "r", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", "s", "()Landroidx/lifecycle/MutableLiveData;", "isRefreshing", "Lcom/huachenjie/works/page/alumni/find_alumni/FindAlumniAdapter;", "b", "q", "adapter", "", "K", "I", "pageNum", "f", "Ljava/lang/String;", "refreshTime", y6b.f, "selectedSex", y6b.g, "selectedGradeCode", "Ljava/util/List;", "selectedTagNoList", "Landroid/view/View;", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class FindAlumniVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View emptyView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public List<String> selectedTagNoList;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @Nullable
    public String selectedSex;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @Nullable
    public String selectedGradeCode;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<FindAlumniAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    public static /* synthetic */ void A(FindAlumniVM findAlumniVM, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        findAlumniVM.z(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void C(FindAlumniVM findAlumniVM, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        findAlumniVM.B(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void v(FindAlumniVM findAlumniVM, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            list = null;
        }
        findAlumniVM.u(str, str2, list);
    }

    public static /* synthetic */ void x(FindAlumniVM findAlumniVM, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        findAlumniVM.w(str);
    }

    public final void B(@Nullable List<String> tagNoList) {
        u(this.selectedSex, this.selectedGradeCode, tagNoList);
    }

    public final void D() {
        BaseViewModelExtKt.b(this, false, false, null, null, new FindAlumniVM$reportSocialSayHello$1(null), 15, null);
    }

    @NotNull
    public final MutableLiveData<FindAlumniAdapter> q() {
        return this.adapter;
    }

    public final void r(@NotNull View emptyView) {
        Intrinsics.checkNotNullParameter(emptyView, "emptyView");
        this.emptyView = emptyView;
    }

    @NotNull
    public final MutableLiveData<Boolean> s() {
        return this.isRefreshing;
    }

    public final void t() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.alumni.find_alumni.FindAlumniVM$loadMoreData$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (this.this$0.pageNum == 1) {
                    this.this$0.s().setValue(Boolean.FALSE);
                } else {
                    FindAlumniAdapter value = this.this$0.q().getValue();
                    if (value != null && (loadMoreModule = value.getLoadMoreModule()) != null) {
                        loadMoreModule.loadMoreFail();
                    }
                }
                return Boolean.FALSE;
            }
        }, null, new FindAlumniVM$loadMoreData$2(this, null), 11, null);
    }

    public final void u(@Nullable String sex, @Nullable String gradeCode, @Nullable List<String> tagNoList) {
        this.selectedSex = sex;
        this.selectedGradeCode = gradeCode;
        this.selectedTagNoList = tagNoList;
        this.pageNum = 1;
        this.refreshTime = null;
        this.isRefreshing.setValue(Boolean.TRUE);
        t();
    }

    public final void w(@Nullable String gradeCode) {
        u(this.selectedSex, gradeCode, this.selectedTagNoList);
    }

    public final void y() {
        u(this.selectedSex, this.selectedGradeCode, this.selectedTagNoList);
    }

    public final void z(@Nullable String sex) {
        u(sex, this.selectedGradeCode, this.selectedTagNoList);
    }
}
