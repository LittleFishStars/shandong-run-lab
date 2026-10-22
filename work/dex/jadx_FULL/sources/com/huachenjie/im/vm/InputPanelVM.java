package com.huachenjie.im.vm;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.im.custom.ShareGoodsAttachment;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b!\u0010\"R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R%\u0010\r\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007R%\u0010\u0010\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R%\u0010\u0012\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007R%\u0010\u0015\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007R%\u0010\u0017\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R%\u0010\u0018\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R%\u0010\u0019\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R%\u0010\u001c\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u001a0\u001a0\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007¨\u0006$"}, d2 = {"Lcom/huachenjie/im/vm/InputPanelVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "r", "()Landroidx/lifecycle/MutableLiveData;", "textMessage", "", "kotlin.jvm.PlatformType", "j", t.d, "showAudioIcon", "k", "n", "showCameraIcon", j.b, "showEmojiIcon", "m", "q", "showKeyboardPanel", "p", "showEmojiPanel", "showAudioPanel", "keyboardShowing", "", y6b.g, "clickTypeToShow", "shopNo", "Lcom/huachenjie/im/custom/ShareGoodsAttachment;", "s", "goodsAttachment", "<init>", "()V", "a", "IM_release"}, k = 1, mv = {1, 8, 0})
public final class InputPanelVM extends BaseVM {
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = 2;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> textMessage = new MutableLiveData<>("");

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showAudioIcon;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showCameraIcon;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showEmojiIcon;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showKeyboardPanel;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showEmojiPanel;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showAudioPanel;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> keyboardShowing;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> clickTypeToShow;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> shopNo;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ShareGoodsAttachment> goodsAttachment;

    public InputPanelVM() {
        Boolean bool = Boolean.TRUE;
        this.showAudioIcon = new MutableLiveData<>(bool);
        this.showCameraIcon = new MutableLiveData<>(bool);
        this.showEmojiIcon = new MutableLiveData<>(bool);
        Boolean bool2 = Boolean.FALSE;
        this.showKeyboardPanel = new MutableLiveData<>(bool2);
        this.showEmojiPanel = new MutableLiveData<>(bool2);
        this.showAudioPanel = new MutableLiveData<>(bool2);
        this.keyboardShowing = new MutableLiveData<>(bool2);
        this.clickTypeToShow = new MutableLiveData<>(0);
        this.shopNo = new MutableLiveData<>();
        this.goodsAttachment = new MutableLiveData<>();
    }

    @NotNull
    public final MutableLiveData<Integer> h() {
        return this.clickTypeToShow;
    }

    @NotNull
    public final MutableLiveData<ShareGoodsAttachment> i() {
        return this.goodsAttachment;
    }

    @NotNull
    public final MutableLiveData<Boolean> j() {
        return this.keyboardShowing;
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.shopNo;
    }

    @NotNull
    public final MutableLiveData<Boolean> l() {
        return this.showAudioIcon;
    }

    @NotNull
    public final MutableLiveData<Boolean> m() {
        return this.showAudioPanel;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.showCameraIcon;
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        return this.showEmojiIcon;
    }

    @NotNull
    public final MutableLiveData<Boolean> p() {
        return this.showEmojiPanel;
    }

    @NotNull
    public final MutableLiveData<Boolean> q() {
        return this.showKeyboardPanel;
    }

    @NotNull
    public final MutableLiveData<String> r() {
        return this.textMessage;
    }
}
