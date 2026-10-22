package com.huachenjie.social_contact.page.emoji_sticker.detail;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.social_contact.api.UniverseModel;
import com.huachenjie.social_contact.bean.EmojiStickerDetailBean;
import com.huachenjie.social_contact.bean.EmojiStickerDownloadBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.n76;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R%\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u00128\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00128\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u0016R\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u00128\u0006¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u0016R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020 0\u00128\u0006¢\u0006\f\n\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010\u0016R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0006¢\u0006\f\n\u0004\b\"\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0006¢\u0006\f\n\u0004\b(\u0010\u0014\u001a\u0004\b!\u0010\u0016R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020 0\u00128\u0006¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b(\u0010\u0016R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b$\u0010\u0016R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\u00128\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b,\u0010\u0016¨\u00060"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/detail/EmojiStickerDetailVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "emojiBagCode", "", "q", "Lcom/huachenjie/social_contact/bean/EmojiStickerDetailBean;", "data", y6b.g, "i", "p", "r", "Lcom/huachenjie/social_contact/api/UniverseModel;", "a", "Lcom/huachenjie/social_contact/api/UniverseModel;", "v", "()Lcom/huachenjie/social_contact/api/UniverseModel;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "Landroidx/lifecycle/MutableLiveData;", "w", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "Lcom/huachenjie/social_contact/page/emoji_sticker/detail/EmojiStickerDetailAdapter;", "kotlin.jvm.PlatformType", "j", "adapter", "", "k", "s", UserConstants.EMOJI_PARAMS.b, "", t.d, "n", "download", "m", "u", "hideDownload", UserConstants.EMOJI_PARAMS.e, j.b, UserConstants.EMOJI_PARAMS.d, "downloadSuccess", "authUserCode", "t", "emojiStickerDetail", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class EmojiStickerDetailVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final UniverseModel model = new UniverseModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<EmojiStickerDetailAdapter> adapter = new MutableLiveData<>(new EmojiStickerDetailAdapter());

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> emojiStatus = new MutableLiveData<>();

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> download = new MutableLiveData<>();

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> hideDownload = new MutableLiveData<>();

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> authHeadImg = new MutableLiveData<>();

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> authName = new MutableLiveData<>();

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> downloadSuccess = new MutableLiveData<>();

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> authUserCode = new MutableLiveData<>();

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<EmojiStickerDetailBean> emojiStickerDetail = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/detail/EmojiStickerDetailVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/social_contact/bean/EmojiStickerDownloadBean;", "downloadBean", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<EmojiStickerDownloadBean> {
        public a() {
            super(EmojiStickerDetailVM.this, true);
        }

        public void onCCSuccess(@Nullable EmojiStickerDownloadBean downloadBean) {
            MutableLiveData<Boolean> mutableLiveDataN = EmojiStickerDetailVM.this.n();
            Boolean bool = Boolean.TRUE;
            mutableLiveDataN.setValue(bool);
            fv5.b("下载成功");
            EmojiStickerDetailVM.this.o().setValue(bool);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/detail/EmojiStickerDetailVM$b", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/social_contact/bean/EmojiStickerDetailBean;", "data", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DialogVMSubscriber<EmojiStickerDetailBean> {
        public b() {
            super(EmojiStickerDetailVM.this, true);
        }

        public void onCCSuccess(@Nullable EmojiStickerDetailBean data) {
            EmojiStickerDetailVM.this.h(data);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/detail/EmojiStickerDetailVM$c", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/social_contact/bean/EmojiStickerDetailBean;", "data", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DialogVMSubscriber<EmojiStickerDetailBean> {
        public c() {
            super(EmojiStickerDetailVM.this, true);
        }

        public void onCCSuccess(@Nullable EmojiStickerDetailBean data) {
            EmojiStickerDetailVM.this.h(data);
        }
    }

    public final void h(@Nullable EmojiStickerDetailBean data) {
        if (data != null) {
            this.emojiStickerDetail.setValue(data);
            EmojiStickerDetailAdapter value = this.adapter.getValue();
            if (value != null) {
                value.setList(data.getEmojiList());
            }
            MutableLiveData<String> mutableLiveData = this.authUserCode;
            String appUserCode = data.getAppUserCode();
            if (appUserCode == null) {
                appUserCode = "";
            }
            mutableLiveData.setValue(appUserCode);
            MutableLiveData<BindingTitleBean> mutableLiveData2 = this.titleBean;
            BindingTitleBean value2 = mutableLiveData2.getValue();
            if (value2 != null) {
                value2.setTitleName(data.getEmojiBagName());
                Integer value3 = this.emojiStatus.getValue();
                value2.setShowRightSubIcon((value3 == null || value3.intValue() != 2 || data.getMyOwnFlag()) ? false : true);
            } else {
                value2 = null;
            }
            mutableLiveData2.setValue(value2);
            this.download.setValue(Boolean.valueOf(data.getDownloadFlag()));
            if (TextUtils.isEmpty(this.authName.getValue())) {
                this.authName.setValue(data.getAuthName());
            }
            if (TextUtils.isEmpty(this.authHeadImg.getValue())) {
                this.authHeadImg.setValue(data.getAuthHeadImg());
            }
        }
    }

    public final void i(@NotNull String emojiBagCode) {
        Intrinsics.checkNotNullParameter(emojiBagCode, "emojiBagCode");
        n76.e(this, this.model.f(emojiBagCode)).p5(new a());
    }

    @NotNull
    public final MutableLiveData<EmojiStickerDetailAdapter> j() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.authHeadImg;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.authName;
    }

    @NotNull
    public final MutableLiveData<String> m() {
        return this.authUserCode;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.download;
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        return this.downloadSuccess;
    }

    public final void p(String emojiBagCode) {
        n76.e(this, this.model.i(emojiBagCode)).p5(new b());
    }

    public final void q(@NotNull String emojiBagCode) {
        Intrinsics.checkNotNullParameter(emojiBagCode, "emojiBagCode");
        Integer value = this.emojiStatus.getValue();
        if (value != null && value.intValue() == 2) {
            p(emojiBagCode);
        } else {
            r(emojiBagCode);
        }
    }

    public final void r(String emojiBagCode) {
        n76.e(this, this.model.j(emojiBagCode)).p5(new c());
    }

    @NotNull
    public final MutableLiveData<Integer> s() {
        return this.emojiStatus;
    }

    @NotNull
    public final MutableLiveData<EmojiStickerDetailBean> t() {
        return this.emojiStickerDetail;
    }

    @NotNull
    public final MutableLiveData<Boolean> u() {
        return this.hideDownload;
    }

    @NotNull
    /* JADX INFO: renamed from: v, reason: from getter */
    public final UniverseModel getModel() {
        return this.model;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> w() {
        return this.titleBean;
    }
}
