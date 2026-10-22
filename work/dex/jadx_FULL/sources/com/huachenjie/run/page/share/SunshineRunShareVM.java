package com.huachenjie.run.page.share;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.ai9;
import com.zj.adlib.ll7;
import com.zj.adlib.s72;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R%\u0010\u0011\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00070\u00070\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R%\u0010\u0017\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00070\u00070\u000b8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R%\u0010\u001a\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00070\u00070\u000b8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R%\u0010\u001d\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00070\u00070\u000b8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010R%\u0010 \u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00070\u00070\u000b8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010R%\u0010#\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00070\u00070\u000b8\u0006¢\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\"\u0010\u0010R%\u0010&\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00070\u00070\u000b8\u0006¢\u0006\f\n\u0004\b$\u0010\u000e\u001a\u0004\b%\u0010\u0010¨\u0006)"}, d2 = {"Lcom/huachenjie/run/page/share/SunshineRunShareVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "distanceMeter", "", "paceSecond", "durationSecond", "", "calorie", "", "i", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", AvatarFragment.AVATAR_URL, "b", "j", "avatarFrameUrl", "c", j.b, UserConstants.USER_PARAMS.b, "d", "q", "userIdText", "e", "m", "distanceText", "f", t.d, "calorieText", y6b.f, "n", "durationText", y6b.g, "p", "paceText", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSunshineRunShareVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SunshineRunShareVM.kt\ncom/huachenjie/run/page/share/SunshineRunShareVM\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,40:1\n1#2:41\n*E\n"})
public final class SunshineRunShareVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> avatarUrl = new MutableLiveData<>("");

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> avatarFrameUrl = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> nickName = new MutableLiveData<>("");

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> userIdText = new MutableLiveData<>("");

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> distanceText = new MutableLiveData<>("");

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> calorieText = new MutableLiveData<>("0kcal");

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> durationText = new MutableLiveData<>("");

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> paceText = new MutableLiveData<>("");

    public final void i(int distanceMeter, long paceSecond, long durationSecond, @NotNull String calorie) {
        Intrinsics.checkNotNullParameter(calorie, "calorie");
        CommonUserInfo commonUserInfoE = ai9.e();
        MutableLiveData<String> mutableLiveData = this.avatarUrl;
        String avatar = commonUserInfoE.getAvatar();
        if (avatar.length() == 0) {
            avatar = commonUserInfoE.getDefaultAvatar();
        }
        mutableLiveData.setValue(avatar);
        this.avatarFrameUrl.setValue(commonUserInfoE.getAvatarFrameImgUrl());
        MutableLiveData<String> mutableLiveData2 = this.nickName;
        String nickName = commonUserInfoE.getNickName();
        if (nickName.length() == 0) {
            nickName = commonUserInfoE.getUserName();
        }
        mutableLiveData2.setValue(nickName);
        this.userIdText.setValue("ID：" + commonUserInfoE.getAlumniId());
        MutableLiveData<String> mutableLiveData3 = this.distanceText;
        ll7 ll7Var = ll7.f43096a;
        mutableLiveData3.setValue(ll7Var.i(Long.valueOf((long) distanceMeter), false, true, 1));
        MutableLiveData<String> mutableLiveData4 = this.calorieText;
        if (calorie.length() == 0) {
            calorie = "0kcal";
        }
        mutableLiveData4.setValue(calorie);
        this.durationText.setValue(s72.n(durationSecond));
        this.paceText.setValue(ll7Var.p(paceSecond, false));
    }

    @NotNull
    public final MutableLiveData<String> j() {
        return this.avatarFrameUrl;
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.avatarUrl;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.calorieText;
    }

    @NotNull
    public final MutableLiveData<String> m() {
        return this.distanceText;
    }

    @NotNull
    public final MutableLiveData<String> n() {
        return this.durationText;
    }

    @NotNull
    public final MutableLiveData<String> o() {
        return this.nickName;
    }

    @NotNull
    public final MutableLiveData<String> p() {
        return this.paceText;
    }

    @NotNull
    public final MutableLiveData<String> q() {
        return this.userIdText;
    }
}
