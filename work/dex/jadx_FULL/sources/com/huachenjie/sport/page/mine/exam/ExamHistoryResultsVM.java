package com.huachenjie.sport.page.mine.exam;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseTitleVM;
import com.huachenjie.sport.api.SportModel;
import com.huachenjie.sport.bean.ExamDetailData;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.n76;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.PageEntity;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR%\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f8\u0006¢\u0006\f\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\f8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/huachenjie/sport/page/mine/exam/ExamHistoryResultsVM;", "Lcom/huachenjie/common/base/data_binding/BaseTitleVM;", "", j.b, "m", "n", "Lcom/huachenjie/sport/api/SportModel;", "a", "Lcom/huachenjie/sport/api/SportModel;", "j", "()Lcom/huachenjie/sport/api/SportModel;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "isRefreshing", "Lcom/huachenjie/sport/page/mine/exam/ExamHistoryResultsAdapter;", "k", y6b.g, "adapter", "", "K", "I", "()I", "q", "(I)V", "pageNum", "", "f", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "p", "(Ljava/lang/String;)V", ExamHistoryResultsActivity.x, "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class ExamHistoryResultsVM extends BaseTitleVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final SportModel model = new SportModel();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ExamHistoryResultsAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public String examCode = "";

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\f"}, d2 = {"com/huachenjie/sport/page/mine/exam/ExamHistoryResultsVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/sport/bean/ExamDetailData;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<PageEntity<ExamDetailData>> {
        public a() {
            super(ExamHistoryResultsVM.this, true, true);
        }

        public void onFailed(int code, @Nullable String message) {
            BaseLoadMoreModule loadMoreModule;
            super.onFailed(code, message);
            if (ExamHistoryResultsVM.this.getPageNum() == 1) {
                ExamHistoryResultsVM.this.l().setValue(Boolean.FALSE);
                ExamHistoryResultsAdapter value = ExamHistoryResultsVM.this.h().getValue();
                if (value != null) {
                    value.setList(null);
                }
            } else {
                ExamHistoryResultsVM examHistoryResultsVM = ExamHistoryResultsVM.this;
                examHistoryResultsVM.q(examHistoryResultsVM.getPageNum() - 1);
            }
            ExamHistoryResultsAdapter value2 = ExamHistoryResultsVM.this.h().getValue();
            if (value2 == null || (loadMoreModule = value2.getLoadMoreModule()) == null) {
                return;
            }
            BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
        }

        public void onCCSuccess(@Nullable PageEntity<ExamDetailData> data) {
            List list;
            BaseLoadMoreModule loadMoreModule;
            BaseLoadMoreModule loadMoreModule2;
            if (ExamHistoryResultsVM.this.getPageNum() == 1) {
                ExamHistoryResultsVM.this.l().setValue(Boolean.FALSE);
                if ((data != null ? data.getList() : null) == null || data.getList().isEmpty()) {
                    ExamHistoryResultsAdapter value = ExamHistoryResultsVM.this.h().getValue();
                    if (value != null) {
                        value.setList(null);
                    }
                } else {
                    ExamHistoryResultsAdapter value2 = ExamHistoryResultsVM.this.h().getValue();
                    if (value2 != null) {
                        value2.setList(data.getList());
                    }
                }
            } else {
                if ((data == null || (list = data.getList()) == null || !(list.isEmpty() ^ true)) ? false : true) {
                    ExamHistoryResultsAdapter value3 = ExamHistoryResultsVM.this.h().getValue();
                    if (value3 != null) {
                        List list2 = data.getList();
                        Intrinsics.checkNotNullExpressionValue(list2, "data.list");
                        value3.addData((Collection) list2);
                    }
                } else {
                    ExamHistoryResultsVM examHistoryResultsVM = ExamHistoryResultsVM.this;
                    examHistoryResultsVM.q(examHistoryResultsVM.getPageNum() - 1);
                }
            }
            if (data != null && data.getHasNext()) {
                ExamHistoryResultsAdapter value4 = ExamHistoryResultsVM.this.h().getValue();
                if (value4 == null || (loadMoreModule2 = value4.getLoadMoreModule()) == null) {
                    return;
                }
                loadMoreModule2.loadMoreComplete();
                return;
            }
            ExamHistoryResultsAdapter value5 = ExamHistoryResultsVM.this.h().getValue();
            if (value5 == null || (loadMoreModule = value5.getLoadMoreModule()) == null) {
                return;
            }
            BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
        }
    }

    @NotNull
    public final MutableLiveData<ExamHistoryResultsAdapter> h() {
        return this.adapter;
    }

    @NotNull
    /* JADX INFO: renamed from: i, reason: from getter */
    public final String getExamCode() {
        return this.examCode;
    }

    @NotNull
    /* JADX INFO: renamed from: j, reason: from getter */
    public final SportModel getModel() {
        return this.model;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    @NotNull
    public final MutableLiveData<Boolean> l() {
        return this.isRefreshing;
    }

    public final void m() {
        this.pageNum++;
        n();
    }

    public final void n() {
        n76.e(this, this.model.r(this.examCode, this.pageNum)).p5(new a());
    }

    public final void o() {
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        n();
    }

    public final void p(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.examCode = str;
    }

    public final void q(int i) {
        this.pageNum = i;
    }
}
