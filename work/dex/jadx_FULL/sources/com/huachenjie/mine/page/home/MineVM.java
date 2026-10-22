package com.huachenjie.mine.page.home;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.MineMateData;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.mine.R;
import com.huachenjie.mine.bean.MineData;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.ai9;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J?\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fR%\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\t0\t0\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R%\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\t0\t0\r8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\r8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\r8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012R\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\r8\u0006¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u0012R\u0017\u0010'\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/huachenjie/mine/page/home/MineVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "appUserCode", "", "r", UserConstants.USER_PARAMS.b, "avatar", "avatarFrameImgUrl", "", "bisVip", "j", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", j.b, "()Landroidx/lifecycle/MutableLiveData;", "onFriendPage", "b", "q", "isOtherPage", "Lcom/huachenjie/mine/bean/MineData;", "c", "m", "mineData", "Lcom/huachenjie/base/bean/MineMateData;", "d", "n", "mineMateData", "Lcom/huachenjie/base/bean/UserInfoBean;", "e", "p", "userInfo", "Lcom/bumptech/glide/request/RequestOptions;", "Lcom/bumptech/glide/request/RequestOptions;", t.d, "()Lcom/bumptech/glide/request/RequestOptions;", "bgOptions", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class MineVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> onFriendPage;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final RequestOptions bgOptions;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isOtherPage;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<MineData> mineData;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<MineMateData> mineMateData;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<UserInfoBean> userInfo;

    public MineVM() {
        Boolean bool = Boolean.FALSE;
        this.onFriendPage = new MutableLiveData<>(bool);
        this.isOtherPage = new MutableLiveData<>(bool);
        this.mineData = new MutableLiveData<>();
        this.mineMateData = new MutableLiveData<>();
        this.userInfo = new MutableLiveData<>();
        RequestOptions requestOptionsCenterCrop = new RequestOptions().centerCrop();
        int i = R.drawable.mine_bg_my_theme_custom;
        RequestOptions requestOptionsPlaceholder = requestOptionsCenterCrop.error(i).placeholder(i);
        Intrinsics.checkNotNullExpressionValue(requestOptionsPlaceholder, "RequestOptions().centerC….mine_bg_my_theme_custom)");
        this.bgOptions = requestOptionsPlaceholder;
    }

    public static /* synthetic */ void k(MineVM mineVM, String str, String str2, String str3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            bool = null;
        }
        mineVM.j(str, str2, str3, bool);
    }

    public final void j(String nickName, String avatar, String avatarFrameImgUrl, Boolean bisVip) {
        CommonUserInfo commonUserInfoE;
        if (Intrinsics.areEqual(this.onFriendPage.getValue(), Boolean.TRUE) || (commonUserInfoE = ai9.e()) == null) {
            return;
        }
        boolean z = (nickName == null || TextUtils.equals(nickName, commonUserInfoE.getNickName())) ? false : true;
        boolean z2 = (avatar == null || TextUtils.equals(avatar, commonUserInfoE.getAvatar())) ? false : true;
        boolean z3 = (avatarFrameImgUrl == null || TextUtils.equals(avatarFrameImgUrl, commonUserInfoE.getAvatarFrameImgUrl())) ? false : true;
        boolean z4 = bisVip != null && (bisVip.booleanValue() ^ commonUserInfoE.getHasMonthCardRight());
        if (z) {
            if (nickName == null) {
                nickName = "";
            }
            commonUserInfoE.setNickName(nickName);
        }
        if (z2) {
            if (avatar == null) {
                avatar = "";
            }
            commonUserInfoE.setAvatar(avatar);
        }
        if (z3) {
            commonUserInfoE.setAvatarFrameImgUrl(avatarFrameImgUrl);
        }
        if (z4) {
            commonUserInfoE.setHasMonthCardRight(bisVip != null ? bisVip.booleanValue() : false);
        }
        if (z || z2 || z3 || z4) {
            ai9.s(commonUserInfoE);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: l, reason: from getter */
    public final RequestOptions getBgOptions() {
        return this.bgOptions;
    }

    @NotNull
    public final MutableLiveData<MineData> m() {
        return this.mineData;
    }

    @NotNull
    public final MutableLiveData<MineMateData> n() {
        return this.mineMateData;
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        return this.onFriendPage;
    }

    @NotNull
    public final MutableLiveData<UserInfoBean> p() {
        return this.userInfo;
    }

    @NotNull
    public final MutableLiveData<Boolean> q() {
        return this.isOtherPage;
    }

    public final void r(@Nullable String appUserCode) {
        BaseViewModelExtKt.b(this, false, false, null, null, new MineVM$requestData$1(this, appUserCode, null), 15, null);
    }
}
