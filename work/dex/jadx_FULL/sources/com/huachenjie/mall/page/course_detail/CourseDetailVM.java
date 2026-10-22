package com.huachenjie.mall.page.course_detail;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.mall.bean.EpisodeDetailBean;
import com.huachenjie.mall.bean.EpisodeItemBean;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u00100J$\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J(\u0010\u0010\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00118\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00118\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u0016R$\u0010&\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R(\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0014\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010*R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\u00118\u0006¢\u0006\f\n\u0004\b,\u0010\u0014\u001a\u0004\b-\u0010\u0016¨\u00061"}, d2 = {"Lcom/huachenjie/mall/page/course_detail/CourseDetailVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "episodeNo", "orderItemNo", "skuNo", "", "p", "Lcom/huachenjie/mall/bean/EpisodeItemBean;", "episodeItem", "q", "episodeItemNo", "", "sort", "", "watchDuration", "r", "Landroidx/lifecycle/MutableLiveData;", "", "b", "Landroidx/lifecycle/MutableLiveData;", "m", "()Landroidx/lifecycle/MutableLiveData;", "hasBuy", "Lcom/huachenjie/mall/page/course_detail/CourseDetailAdapter;", "c", "j", "adapter", "Lcom/huachenjie/mall/bean/EpisodeDetailBean;", "d", t.d, "episodeDetail", "a", "Lcom/huachenjie/mall/bean/EpisodeItemBean;", "n", "()Lcom/huachenjie/mall/bean/EpisodeItemBean;", "t", "(Lcom/huachenjie/mall/bean/EpisodeItemBean;)V", "lastPlayItem", "e", "k", "s", "(Landroidx/lifecycle/MutableLiveData;)V", "currentPlayItem", "f", j.b, "playStatus", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class CourseDetailVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public EpisodeItemBean lastPlayItem;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> hasBuy = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<CourseDetailAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<EpisodeDetailBean> episodeDetail = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<EpisodeItemBean> currentPlayItem = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> playStatus = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<CourseDetailAdapter> j() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<EpisodeItemBean> k() {
        return this.currentPlayItem;
    }

    @NotNull
    public final MutableLiveData<EpisodeDetailBean> l() {
        return this.episodeDetail;
    }

    @NotNull
    public final MutableLiveData<Boolean> m() {
        return this.hasBuy;
    }

    @Nullable
    /* JADX INFO: renamed from: n, reason: from getter */
    public final EpisodeItemBean getLastPlayItem() {
        return this.lastPlayItem;
    }

    @NotNull
    public final MutableLiveData<Integer> o() {
        return this.playStatus;
    }

    public final void p(@Nullable String episodeNo, @Nullable String orderItemNo, @Nullable String skuNo) {
        BaseViewModelExtKt.b(this, true, false, null, null, new CourseDetailVM$loadData$1(episodeNo, orderItemNo, skuNo, this, null), 14, null);
    }

    public final void q(@NotNull EpisodeItemBean episodeItem, @Nullable String orderItemNo) {
        Intrinsics.checkNotNullParameter(episodeItem, "episodeItem");
        BaseViewModelExtKt.b(this, true, false, null, null, new CourseDetailVM$queryVideoUrl$1(episodeItem, orderItemNo, this, null), 14, null);
    }

    public final void r(@Nullable String orderItemNo, @NotNull String episodeItemNo, int sort, long watchDuration) {
        Intrinsics.checkNotNullParameter(episodeItemNo, "episodeItemNo");
        BaseViewModelExtKt.b(this, false, false, null, null, new CourseDetailVM$reportWatchedProgress$1(orderItemNo, episodeItemNo, sort, watchDuration, null), 15, null);
    }

    public final void s(@NotNull MutableLiveData<EpisodeItemBean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.currentPlayItem = mutableLiveData;
    }

    public final void t(@Nullable EpisodeItemBean episodeItemBean) {
        this.lastPlayItem = episodeItemBean;
    }
}
