package com.huachenjie.works.page.broadcast_floor.comment;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.bean.BroadcastFloorMessageImageBean;
import com.huachenjie.works.bean.BroadcastFloorMessageVoiceBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R%\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007R%\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007R%\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u0007¨\u0006!"}, d2 = {"Lcom/huachenjie/works/page/broadcast_floor/comment/CommentInputVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "hint", "b", "i", "comment", "Lcom/huachenjie/works/bean/BroadcastFloorMessageImageBean;", "c", "k", "image", "Lcom/huachenjie/works/bean/BroadcastFloorMessageVoiceBean;", "d", j.b, "voice", "", "kotlin.jvm.PlatformType", "e", "n", "showKeyboard", "f", "m", "showEmoji", y6b.f, t.d, "showAudio", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class CommentInputVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> hint = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> comment = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BroadcastFloorMessageImageBean> image = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BroadcastFloorMessageVoiceBean> voice = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showKeyboard;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showEmoji;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showAudio;

    public CommentInputVM() {
        Boolean bool = Boolean.FALSE;
        this.showKeyboard = new MutableLiveData<>(bool);
        this.showEmoji = new MutableLiveData<>(bool);
        this.showAudio = new MutableLiveData<>(bool);
    }

    @NotNull
    public final MutableLiveData<String> i() {
        return this.comment;
    }

    @NotNull
    public final MutableLiveData<String> j() {
        return this.hint;
    }

    @NotNull
    public final MutableLiveData<BroadcastFloorMessageImageBean> k() {
        return this.image;
    }

    @NotNull
    public final MutableLiveData<Boolean> l() {
        return this.showAudio;
    }

    @NotNull
    public final MutableLiveData<Boolean> m() {
        return this.showEmoji;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.showKeyboard;
    }

    @NotNull
    public final MutableLiveData<BroadcastFloorMessageVoiceBean> o() {
        return this.voice;
    }
}
