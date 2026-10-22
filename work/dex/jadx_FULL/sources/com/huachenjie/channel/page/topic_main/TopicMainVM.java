package com.huachenjie.channel.page.topic_main;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.channel.bean.TopicMainBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.external.adapter.WorksAdapter;
import com.zj.adlib.yj7;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R%\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\t8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\t8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u000fR\u0016\u0010\u001b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR%\u0010!\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\t8\u0006¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000f¨\u0006$"}, d2 = {"Lcom/huachenjie/channel/page/topic_main/TopicMainVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", yj7.b.SUBJECT_NO, "", "s", "q", "r", "t", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", j.b, "()Landroidx/lifecycle/MutableLiveData;", "toolBarColor", "Lcom/huachenjie/works/external/adapter/WorksAdapter;", "b", "m", "adapter", "Lcom/huachenjie/channel/bean/TopicMainBean;", "c", "p", "topicMainBean", "K", "I", "pageNum", "f", "Ljava/lang/String;", "refreshTime", "d", "n", "sendTopicOperate", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class TopicMainVM extends BaseViewModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> toolBarColor = new MutableLiveData<>(0);

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<WorksAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<TopicMainBean> topicMainBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> sendTopicOperate = new MutableLiveData<>(0);

    @NotNull
    public final MutableLiveData<WorksAdapter> m() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Integer> n() {
        return this.sendTopicOperate;
    }

    @NotNull
    public final MutableLiveData<Integer> o() {
        return this.toolBarColor;
    }

    @NotNull
    public final MutableLiveData<TopicMainBean> p() {
        return this.topicMainBean;
    }

    public final void q(@NotNull String subjectNo) {
        Intrinsics.checkNotNullParameter(subjectNo, yj7.b.SUBJECT_NO);
        BaseViewModelExtKt.b(this, true, false, null, null, new TopicMainVM$joinSubject$1(subjectNo, this, null), 14, null);
    }

    public final void r(@NotNull String subjectNo) {
        Intrinsics.checkNotNullParameter(subjectNo, yj7.b.SUBJECT_NO);
        BaseViewModelExtKt.b(this, true, false, null, null, new TopicMainVM$leaveSubject$1(subjectNo, this, null), 14, null);
    }

    public final void s(@NotNull String subjectNo) {
        Intrinsics.checkNotNullParameter(subjectNo, yj7.b.SUBJECT_NO);
        BaseViewModelExtKt.b(this, true, false, null, null, new TopicMainVM$loadData$1(subjectNo, this, null), 14, null);
    }

    public final void t(@NotNull String subjectNo) {
        Intrinsics.checkNotNullParameter(subjectNo, yj7.b.SUBJECT_NO);
        BaseViewModelExtKt.b(this, false, false, null, null, new TopicMainVM$loadWorksList$1(this, subjectNo, null), 15, null);
    }
}
