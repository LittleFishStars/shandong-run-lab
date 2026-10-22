package com.huachenjie.works.page.publish;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import androidx.collection.ArrayMap;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.ViewModelKt;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.RichSubjectBean;
import com.huachenjie.base.bean.RichUserBean;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.RecommendWorksBean;
import com.huachenjie.works.bean.WorksTagBean;
import com.huachenjie.works.bean.publish.PubWorkChannelBean;
import com.huachenjie.works.bean.publish.PubWorkLocationItemBean;
import com.huachenjie.works.database.PublicWorkDraft;
import com.huachenjie.works.page.publish.delegate.PublishWorksDelegate;
import com.huachenjie.works.page.publish.menu.permission.PubWorkMenuPermissionFragment;
import com.zj.adlib.fv5;
import com.zj.adlib.v41;
import com.zj.adlib.y6b;
import com.zj.adlib.yj7;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\bY\u0010ZJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\u0006J.\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0012J\u0016\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0006J:\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017J6\u0010\"\u001a\u00020\n2\u001a\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010!\u001a\u0004\u0018\u00010\rJ\u0012\u0010#\u001a\u00020\n2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\rR\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020%0$8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\r0$8\u0006¢\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b,\u0010)R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020.0$8\u0006¢\u0006\f\n\u0004\b/\u0010'\u001a\u0004\b0\u0010)R\u001f\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020$8\u0006¢\u0006\f\n\u0004\b3\u0010'\u001a\u0004\b4\u0010)R\u001f\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060$8\u0006¢\u0006\f\n\u0004\b7\u0010'\u001a\u0004\b8\u0010)RG\u0010=\u001a2\u0012.\u0012,\u0012\u0004\u0012\u00020\r :*\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u001dj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u001f0\u001dj\b\u0012\u0004\u0012\u00020\r`\u001f0$8\u0006¢\u0006\f\n\u0004\b;\u0010'\u001a\u0004\b<\u0010)R%\u0010@\u001a\u0010\u0012\f\u0012\n :*\u0004\u0018\u00010\u00040\u00040$8\u0006¢\u0006\f\n\u0004\b>\u0010'\u001a\u0004\b?\u0010)R\u0018\u0010B\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010AR#\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00170$8\u0006¢\u0006\f\n\u0004\bC\u0010'\u001a\u0004\bD\u0010)R\u001d\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001e0$8\u0006¢\u0006\f\n\u0004\bE\u0010'\u001a\u0004\bF\u0010)R&\u0010K\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0\u00170H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010JR#\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040H8\u0006¢\u0006\f\n\u0004\b+\u0010J\u001a\u0004\bL\u0010MR$\u0010T\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR%\u0010X\u001a\u0010\u0012\f\u0012\n :*\u0004\u0018\u00010U0U0$8\u0006¢\u0006\f\n\u0004\bV\u0010'\u001a\u0004\bW\u0010)¨\u0006["}, d2 = {"Lcom/huachenjie/works/page/publish/PublishWorkViewModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "Lcom/huachenjie/works/page/publish/PublishWorkActivity;", "context", "", "type", "", "n", "Lcom/huachenjie/works/database/PublicWorkDraft;", "workDraft", "", "L", "H", "", yj7.g.WORKS_PUBLISH_CATEGORY_NO, "s", "G", j.b, "Lkotlin/Function0;", RenderCallContext.TYPE_CALLBACK, "J", "isSelectedMedia", "m", "", "Lcom/huachenjie/base/bean/RichSubjectBean;", "topicList", "Lcom/huachenjie/base/bean/RichUserBean;", "userList", "F", "Ljava/util/ArrayList;", "Lcom/huachenjie/works/bean/RecommendWorksBean;", "Lkotlin/collections/ArrayList;", yj7.g.WORKS_PUBLISH_CATEGORY_LIST, "tagNo", "p", "q", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "a", "Landroidx/lifecycle/MutableLiveData;", "D", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "b", "E", "titleData", "Landroid/text/Spanned;", "c", "v", "contentSpan", "Lcom/huachenjie/works/bean/publish/PubWorkChannelBean;", "d", "A", "selectChannel", "Lcom/huachenjie/works/bean/publish/PubWorkLocationItemBean;", "e", "B", "selectLocation", "kotlin.jvm.PlatformType", "f", "w", "goodsListBean", y6b.f, "x", "permissionType", "Ljava/lang/String;", "requestId", y6b.g, "u", "i", "y", "selCategory", "Landroidx/collection/ArrayMap;", "Lcom/huachenjie/works/bean/WorksTagBean;", "Landroidx/collection/ArrayMap;", "cacheCategoryMap", "t", "()Landroidx/collection/ArrayMap;", "allCategorySelTagMap", "Lcom/huachenjie/works/bean/WorksTagBean;", j.o, "()Lcom/huachenjie/works/bean/WorksTagBean;", "I", "(Lcom/huachenjie/works/bean/WorksTagBean;)V", "selTag", "Lcom/huachenjie/works/page/publish/PublishWorkTagAdapter;", "j", "C", "tagAdapter", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class PublishWorkViewModel extends BaseViewModel {
    public static final int K = 9;
    public static final int L = 5;
    public static final int M = 5;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public WorksTagBean selTag;

    /* JADX INFO: renamed from: f, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public String requestId;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> titleData = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Spanned> contentSpan = new MutableLiveData<>(new SpannableStringBuilder());

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<PubWorkChannelBean> selectChannel = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<PubWorkLocationItemBean> selectLocation = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ArrayList<String>> goodsListBean = new MutableLiveData<>(new ArrayList());

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> permissionType = new MutableLiveData<>(Integer.valueOf(PubWorkMenuPermissionFragment.VISIBLE_TYPE_PUBLIC));

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<RecommendWorksBean>> categoryList = new MutableLiveData<>();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<RecommendWorksBean> selCategory = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final ArrayMap<String, List<WorksTagBean>> cacheCategoryMap = new ArrayMap<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final ArrayMap<String, Integer> allCategorySelTagMap = new ArrayMap<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<PublishWorkTagAdapter> tagAdapter = new MutableLiveData<>(new PublishWorkTagAdapter());

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void K(PublishWorkViewModel publishWorkViewModel, PublishWorkActivity publishWorkActivity, int i, PublicWorkDraft publicWorkDraft, Function0 function0, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            function0 = new Function0<Unit>() { // from class: com.huachenjie.works.page.publish.PublishWorkViewModel$updateDraft$1
                public /* bridge */ /* synthetic */ Object invoke() {
                    m947invoke();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m947invoke() {
                }
            };
        }
        publishWorkViewModel.J(publishWorkActivity, i, publicWorkDraft, function0);
    }

    public static /* synthetic */ void r(PublishWorkViewModel publishWorkViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        publishWorkViewModel.q(str);
    }

    @NotNull
    public final MutableLiveData<PubWorkChannelBean> A() {
        return this.selectChannel;
    }

    @NotNull
    public final MutableLiveData<PubWorkLocationItemBean> B() {
        return this.selectLocation;
    }

    @NotNull
    public final MutableLiveData<PublishWorkTagAdapter> C() {
        return this.tagAdapter;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> D() {
        return this.titleBean;
    }

    @NotNull
    public final MutableLiveData<String> E() {
        return this.titleData;
    }

    public final void F(@NotNull PublishWorkActivity context, int type, @NotNull PublicWorkDraft workDraft, @NotNull List<RichSubjectBean> topicList, @NotNull List<RichUserBean> userList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workDraft, "workDraft");
        Intrinsics.checkNotNullParameter(topicList, "topicList");
        Intrinsics.checkNotNullParameter(userList, "userList");
        L(context, type, workDraft);
        PublishWorksDelegate publishWorksDelegate = PublishWorksDelegate.f14925a;
        String str = this.requestId;
        ArrayList<String> value = this.goodsListBean.getValue();
        if (value == null) {
            value = new ArrayList<>();
        }
        publishWorksDelegate.i(workDraft, topicList, userList, str, value);
    }

    public final void G() {
        BaseViewModelExtKt.b(this, false, false, null, null, new PublishWorkViewModel$requestWorksPublishId$1(this, null), 15, null);
    }

    public final void H() {
        fv5.a(R.string.works_publish_work_save_success);
    }

    public final void I(@Nullable WorksTagBean worksTagBean) {
        this.selTag = worksTagBean;
    }

    public final void J(@NotNull PublishWorkActivity context, int type, @NotNull PublicWorkDraft workDraft, @NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workDraft, "workDraft");
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        if (n(context, type)) {
            v41.e(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PublishWorkViewModel$updateDraft$2(this, context, type, workDraft, callback, null), 3, (Object) null);
        }
    }

    public final void L(PublishWorkActivity context, int type, PublicWorkDraft workDraft) {
        File file = new File(workDraft.getMediaPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        String value = this.titleData.getValue();
        if (value == null) {
            value = "";
        }
        workDraft.setTitle(value);
        if (type == 1) {
            workDraft.setPicList(context.j0());
        } else {
            workDraft.setVideoMedia(context.l0());
            workDraft.setPicList(context.k0());
        }
        workDraft.setChannel(this.selectChannel.getValue());
        workDraft.setLocation(this.selectLocation.getValue());
        Integer value2 = this.permissionType.getValue();
        Intrinsics.checkNotNull(value2);
        workDraft.setPermissionType(value2.intValue());
        RecommendWorksBean value3 = this.selCategory.getValue();
        workDraft.setCategoryNo(value3 != null ? value3.getCategoryNo() : null);
        WorksTagBean worksTagBean = this.selTag;
        workDraft.setTagNo(worksTagBean != null ? worksTagBean.getCode() : null);
        workDraft.setUpdateTime(System.currentTimeMillis());
    }

    public final boolean m(int type, boolean isSelectedMedia) {
        int iG = PublishWorksDelegate.f14925a.g();
        if (iG >= 0 && iG < 100) {
            fv5.a(R.string.works_publish_work_publish_again);
            return false;
        }
        if (this.selCategory.getValue() == null || this.selTag == null) {
            fv5.a(R.string.works_publish_work_publish_tag_error);
            return false;
        }
        if (type == 1) {
            if (!isSelectedMedia) {
                fv5.a(R.string.works_publish_work_publish_photo_fail);
                return false;
            }
        } else if (!isSelectedMedia) {
            fv5.a(R.string.works_publish_work_publish_video_fail);
            return false;
        }
        return true;
    }

    public final boolean n(PublishWorkActivity context, int type) {
        String value = this.titleData.getValue();
        if (value == null || StringsKt.isBlank(value)) {
            Spanned value2 = this.contentSpan.getValue();
            if (value2 == null || StringsKt.isBlank(value2)) {
                if (type == 1) {
                    if (context.j0().isEmpty()) {
                        fv5.a(R.string.works_publish_work_save_fail);
                        return false;
                    }
                } else if (context.l0() == null) {
                    fv5.a(R.string.works_publish_work_publish_video_fail);
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean o() {
        String value = this.titleData.getValue();
        if (value == null || StringsKt.isBlank(value)) {
            Spanned value2 = this.contentSpan.getValue();
            if ((value2 == null || StringsKt.isBlank(value2)) && this.selectChannel.getValue() == null && this.selectLocation.getValue() == null) {
                return false;
            }
        }
        return true;
    }

    public final void p(@Nullable ArrayList<RecommendWorksBean> categoryList, @Nullable String categoryNo, @Nullable String tagNo) {
        BaseViewModelExtKt.b(this, false, false, null, null, new PublishWorkViewModel$fetchCategoryList$1(categoryList, this, categoryNo, tagNo, null), 15, null);
    }

    public final void q(@Nullable String tagNo) {
        if (this.selCategory.getValue() == null) {
            return;
        }
        RecommendWorksBean value = this.selCategory.getValue();
        Intrinsics.checkNotNull(value);
        String categoryNo = value.getCategoryNo();
        if (s(categoryNo)) {
            return;
        }
        BaseViewModelExtKt.b(this, false, false, null, null, new PublishWorkViewModel$fetchTagList$1(categoryNo, tagNo, this, null), 15, null);
    }

    public final boolean s(String categoryNo) {
        List<WorksTagBean> list = this.cacheCategoryMap.get(categoryNo);
        if (list == null) {
            return false;
        }
        Integer num = this.allCategorySelTagMap.get(categoryNo);
        int iIntValue = num != null ? num.intValue() : -1;
        PublishWorkTagAdapter value = this.tagAdapter.getValue();
        if (value == null) {
            return true;
        }
        value.g(list, iIntValue);
        return true;
    }

    @NotNull
    public final ArrayMap<String, Integer> t() {
        return this.allCategorySelTagMap;
    }

    @NotNull
    public final MutableLiveData<List<RecommendWorksBean>> u() {
        return this.categoryList;
    }

    @NotNull
    public final MutableLiveData<Spanned> v() {
        return this.contentSpan;
    }

    @NotNull
    public final MutableLiveData<ArrayList<String>> w() {
        return this.goodsListBean;
    }

    @NotNull
    public final MutableLiveData<Integer> x() {
        return this.permissionType;
    }

    @NotNull
    public final MutableLiveData<RecommendWorksBean> y() {
        return this.selCategory;
    }

    @Nullable
    /* JADX INFO: renamed from: z, reason: from getter */
    public final WorksTagBean getSelTag() {
        return this.selTag;
    }
}
