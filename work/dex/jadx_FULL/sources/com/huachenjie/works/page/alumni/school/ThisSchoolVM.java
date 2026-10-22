package com.huachenjie.works.page.alumni.school;

import android.graphics.Color;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.works.bean.PostCategoryDataBean;
import com.huachenjie.works.bean.PostedSchoolBean;
import com.huachenjie.works.bean.SchoolBannerBean;
import com.huachenjie.works.bean.ThisSchoolBean;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.huachenjie.works.page.campus_wall.post.PostAdapter;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bC\u0010DJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R%\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a0\u000f8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014R\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014R%\u0010$\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a0\u000f8\u0006¢\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u0014R%\u0010'\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00070\u00070\u000f8\u0006¢\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b&\u0010\u0014R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u000f8\u0006¢\u0006\f\n\u0004\b)\u0010\u0012\u001a\u0004\b*\u0010\u0014R\"\u00102\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00109\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R%\u0010<\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00070\u00070\u000f8\u0006¢\u0006\f\n\u0004\b:\u0010\u0012\u001a\u0004\b;\u0010\u0014R#\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0=0\u000f8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b?\u0010\u0014R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u0002030\u000f8\u0006¢\u0006\f\n\u0004\b*\u0010\u0012\u001a\u0004\bA\u0010\u0014¨\u0006E"}, d2 = {"Lcom/huachenjie/works/page/alumni/school/ThisSchoolVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "A", "Lcom/huachenjie/works/bean/SchoolBannerBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "j", "", "queryBySchoolChange", "C", "w", "B", "x", j.o, "y", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/works/bean/ThisSchoolBean;", "b", "Landroidx/lifecycle/MutableLiveData;", "r", "()Landroidx/lifecycle/MutableLiveData;", "schoolBean", "Lcom/huachenjie/works/bean/PostCategoryDataBean;", "c", j.b, "postCategoryData", "", "kotlin.jvm.PlatformType", "d", "u", "verticalOffset", "e", "m", "clickedBannerBean", "f", t.d, "backgroundColor", y6b.f, "v", "isRefreshing", "Lcom/huachenjie/works/page/campus_wall/post/PostAdapter;", y6b.g, "k", "adapter", "K", "I", "n", "()I", "E", "(I)V", "pageNum", "", "Ljava/lang/String;", "q", "()Ljava/lang/String;", "F", "(Ljava/lang/String;)V", "refreshTime", "i", "t", "showSwitchSchool", "", "Lcom/huachenjie/works/bean/PostedSchoolBean;", "p", "postedSchoolList", "s", "schoolCode", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nThisSchoolVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThisSchoolVM.kt\ncom/huachenjie/works/page/alumni/school/ThisSchoolVM\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,153:1\n470#2:154\n*S KotlinDebug\n*F\n+ 1 ThisSchoolVM.kt\ncom/huachenjie/works/page/alumni/school/ThisSchoolVM\n*L\n32#1:154\n*E\n"})
public final class ThisSchoolVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ThisSchoolBean> schoolBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<PostCategoryDataBean> postCategoryData = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> verticalOffset = new MutableLiveData<>(0);

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SchoolBannerBean> clickedBannerBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> backgroundColor = new MutableLiveData<>(Integer.valueOf(Color.parseColor("#00000000")));

    /* JADX INFO: renamed from: f, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<PostAdapter> adapter;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showSwitchSchool;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<PostedSchoolBean>> postedSchoolList;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> schoolCode;

    public ThisSchoolVM() {
        Boolean bool = Boolean.FALSE;
        this.isRefreshing = new MutableLiveData<>(bool);
        this.adapter = new MutableLiveData<>();
        this.pageNum = 1;
        this.showSwitchSchool = new MutableLiveData<>(bool);
        this.postedSchoolList = new MutableLiveData<>();
        this.schoolCode = new MutableLiveData<>();
    }

    public static /* synthetic */ void D(ThisSchoolVM thisSchoolVM, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        thisSchoolVM.C(z);
    }

    public final void A() {
        BaseViewModelExtKt.b(this, true, false, null, null, new ThisSchoolVM$queryPostedSchoolList$1(this, null), 12, null);
    }

    public final void B() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.alumni.school.ThisSchoolVM$queryThisSchoolInfo$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.r().setValue(new ThisSchoolBean(null, null, 3, null));
                return Boolean.FALSE;
            }
        }, null, new ThisSchoolVM$queryThisSchoolInfo$2(this, null), 11, null);
    }

    public final void C(boolean queryBySchoolChange) {
        B();
        if (!queryBySchoolChange) {
            z();
            x();
        }
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        this.refreshTime = null;
        y();
    }

    public final void E(int i) {
        this.pageNum = i;
    }

    public final void F(@Nullable String str) {
        this.refreshTime = str;
    }

    public final void j(@NotNull SchoolBannerBean bean) {
        Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
        BaseViewModelExtKt.b(this, false, true, null, null, new ThisSchoolVM$checkBannerAdStatus$1(bean, this, null), 13, null);
    }

    @NotNull
    public final MutableLiveData<PostAdapter> k() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Integer> l() {
        return this.backgroundColor;
    }

    @NotNull
    public final MutableLiveData<SchoolBannerBean> m() {
        return this.clickedBannerBean;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    @NotNull
    public final MutableLiveData<PostCategoryDataBean> o() {
        return this.postCategoryData;
    }

    @NotNull
    public final MutableLiveData<List<PostedSchoolBean>> p() {
        return this.postedSchoolList;
    }

    @Nullable
    /* JADX INFO: renamed from: q, reason: from getter */
    public final String getRefreshTime() {
        return this.refreshTime;
    }

    @NotNull
    public final MutableLiveData<ThisSchoolBean> r() {
        return this.schoolBean;
    }

    @NotNull
    public final MutableLiveData<String> s() {
        return this.schoolCode;
    }

    @NotNull
    public final MutableLiveData<Boolean> t() {
        return this.showSwitchSchool;
    }

    @NotNull
    public final MutableLiveData<Integer> u() {
        return this.verticalOffset;
    }

    @NotNull
    public final MutableLiveData<Boolean> v() {
        return this.isRefreshing;
    }

    public final void w() {
        this.pageNum++;
        y();
    }

    public final void x() {
        BaseViewModelExtKt.b(this, false, false, null, null, new ThisSchoolVM$queryOperatorCount$1(this, null), 13, null);
    }

    public final void y() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.alumni.school.ThisSchoolVM$queryPageList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (this.this$0.getPageNum() == 1) {
                    this.this$0.v().setValue(Boolean.FALSE);
                    PostAdapter value = this.this$0.k().getValue();
                    if (value != null) {
                        value.setList(null);
                    }
                    PostAdapter value2 = this.this$0.k().getValue();
                    if (value2 != null) {
                        value2.p();
                    }
                } else {
                    ThisSchoolVM thisSchoolVM = this.this$0;
                    thisSchoolVM.E(thisSchoolVM.getPageNum() - 1);
                }
                PostAdapter value3 = this.this$0.k().getValue();
                if (value3 != null && (loadMoreModule = value3.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
                return Boolean.FALSE;
            }
        }, null, new ThisSchoolVM$queryPageList$2(this, null), 11, null);
    }

    public final void z() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.alumni.school.ThisSchoolVM$queryPostCategory$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.o().setValue(new PostCategoryDataBean(null, null, 3, null));
                return Boolean.FALSE;
            }
        }, null, new ThisSchoolVM$queryPostCategory$2(this, null), 11, null);
    }
}
