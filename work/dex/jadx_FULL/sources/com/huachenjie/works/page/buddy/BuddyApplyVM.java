package com.huachenjie.works.page.buddy;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.kernel.RVParams;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002R%\u0010\r\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00020\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR%\u0010\u0010\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00020\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR%\u0010\u0013\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00020\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00078\u0006¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\fR%\u0010\u001b\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00180\u00180\u00078\u0006¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/works/page/buddy/BuddyApplyVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "i", "buddyCode", "", j.b, "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", AvatarFragment.AVATAR_URL, "b", "n", "title", "c", "j", "applyMessage", "", "d", "k", "applySuccess", "", "e", "m", RVParams.KEYBOARD_HEIGHT, "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class BuddyApplyVM extends BaseViewModel {
    public static final int K = 30;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> avatarUrl = new MutableLiveData<>("");

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> title = new MutableLiveData<>("");

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> applyMessage = new MutableLiveData<>("");

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> applySuccess = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> keyboardHeight = new MutableLiveData<>(0);

    @NotNull
    public final String i() {
        String value = this.applyMessage.getValue();
        return (value != null ? value.length() : 0) + "/30";
    }

    @NotNull
    public final MutableLiveData<String> j() {
        return this.applyMessage;
    }

    @NotNull
    public final MutableLiveData<Boolean> k() {
        return this.applySuccess;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.avatarUrl;
    }

    @NotNull
    public final MutableLiveData<Integer> m() {
        return this.keyboardHeight;
    }

    @NotNull
    public final MutableLiveData<String> n() {
        return this.title;
    }

    public final void o(@NotNull String buddyCode) {
        Intrinsics.checkNotNullParameter(buddyCode, "buddyCode");
        if (buddyCode.length() == 0) {
            return;
        }
        String value = this.applyMessage.getValue();
        if (value == null) {
            value = "";
        }
        String string = StringsKt.trim(value).toString();
        if (string.length() == 0) {
            return;
        }
        BaseViewModelExtKt.b(this, true, false, null, null, new BuddyApplyVM$submitApply$1(buddyCode, string, this, null), 14, null);
    }
}
