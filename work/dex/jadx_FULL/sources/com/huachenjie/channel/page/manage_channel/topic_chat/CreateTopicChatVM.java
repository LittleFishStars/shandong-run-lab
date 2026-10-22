package com.huachenjie.channel.page.manage_channel.topic_chat;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.yj7;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR$\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0013\u0010\tR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0017\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/topic_chat/CreateTopicChatVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "n", "Landroidx/lifecycle/MutableLiveData;", "", "b", "Landroidx/lifecycle/MutableLiveData;", "m", "()Landroidx/lifecycle/MutableLiveData;", "title", "f", "Ljava/lang/String;", t.d, "()Ljava/lang/String;", j.b, "(Ljava/lang/String;)V", yj7.b.SUBJECT_NO, "c", "k", "subjectName", "", "d", "j", "addFlag", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class CreateTopicChatVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> title = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> subjectName = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> addFlag = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String subjectNo;

    @NotNull
    public final MutableLiveData<Boolean> j() {
        return this.addFlag;
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.subjectName;
    }

    @Nullable
    /* JADX INFO: renamed from: l, reason: from getter */
    public final String getSubjectNo() {
        return this.subjectNo;
    }

    @NotNull
    public final MutableLiveData<String> m() {
        return this.title;
    }

    public final void n() {
        BaseViewModelExtKt.b(this, true, false, null, null, new CreateTopicChatVM$saveData$1(this, null), 14, null);
    }

    public final void o(@Nullable String str) {
        this.subjectNo = str;
    }
}
