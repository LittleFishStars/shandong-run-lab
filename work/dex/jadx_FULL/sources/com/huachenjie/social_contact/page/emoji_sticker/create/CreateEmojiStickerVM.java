package com.huachenjie.social_contact.page.emoji_sticker.create;

import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.social_contact.api.UniverseModel;
import com.huachenjie.social_contact.bean.EmojiStickerAddBean;
import com.huachenjie.social_contact.bean.EmojiStickerAddResultBean;
import com.huachenjie.social_contact.bean.EmojiStickerDetailBean;
import com.huachenjie.social_contact.bean.EmojiStickerFileBean;
import com.huachenjie.social_contact.bean.EmojiStickerImageBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.n76;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0014\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u001c\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0002R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R1\u0010\u001f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001c \u001d*\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b0\u001b0\u00158\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019R\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b \u0010\u0019R#\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00070\u00158\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b#\u0010\u0019R0\u0010)\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010%0%0\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/create/CreateEmojiStickerVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "emojiBagCode", "", t.d, "s", "", "Lcom/huachenjie/social_contact/bean/EmojiStickerFileBean;", "emojiList", y6b.g, "t", "i", "url", "j", "Lcom/huachenjie/social_contact/api/UniverseModel;", "a", "Lcom/huachenjie/social_contact/api/UniverseModel;", "m", "()Lcom/huachenjie/social_contact/api/UniverseModel;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "Landroidx/lifecycle/MutableLiveData;", j.b, "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "Lcom/huachenjie/social_contact/page/emoji_sticker/create/CreateEmojiStickerAdapter;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "kotlin.jvm.PlatformType", "k", "adapter", "n", "textEmojiName", "Lcom/huachenjie/social_contact/bean/EmojiStickerImageBean;", "p", "uploadEmojiList", "", "q", "r", "(Landroidx/lifecycle/MutableLiveData;)V", "uploadFinish", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class CreateEmojiStickerVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final UniverseModel model = new UniverseModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<CreateEmojiStickerAdapter<MultiItemEntity>> adapter = new MutableLiveData<>(new CreateEmojiStickerAdapter());

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> textEmojiName = new MutableLiveData<>();

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<EmojiStickerImageBean>> uploadEmojiList = new MutableLiveData<>();

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<Boolean> uploadFinish = new MutableLiveData<>(Boolean.FALSE);

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/create/CreateEmojiStickerVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/social_contact/bean/EmojiStickerAddResultBean;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<EmojiStickerAddResultBean> {
        public a() {
            super(CreateEmojiStickerVM.this, true);
        }

        public void onFailed(int code, @Nullable String message) {
            super.onFailed(code, message);
            CreateEmojiStickerVM.this.q().setValue(Boolean.FALSE);
        }

        public void onCCSuccess(@Nullable EmojiStickerAddResultBean data) {
            fv5.b("提交审核中，请耐心等待~");
            CreateEmojiStickerVM.this.q().setValue(Boolean.TRUE);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/create/CreateEmojiStickerVM$b", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/social_contact/bean/EmojiStickerDetailBean;", "data", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DialogVMSubscriber<EmojiStickerDetailBean> {
        public b() {
            super(CreateEmojiStickerVM.this, true);
        }

        public void onCCSuccess(@Nullable EmojiStickerDetailBean data) {
            String emojiBagName;
            List<EmojiStickerImageBean> emojiList;
            if (data != null && (emojiList = data.getEmojiList()) != null) {
                CreateEmojiStickerVM createEmojiStickerVM = CreateEmojiStickerVM.this;
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(emojiList);
                if (emojiList.size() < 16) {
                    arrayList.add(new EmojiStickerAddBean());
                }
                CreateEmojiStickerAdapter<MultiItemEntity> value = createEmojiStickerVM.k().getValue();
                if (value != null) {
                    value.setList(arrayList);
                }
            }
            MutableLiveData<String> mutableLiveDataN = CreateEmojiStickerVM.this.n();
            if (data == null || (emojiBagName = data.getEmojiBagName()) == null) {
                emojiBagName = "";
            }
            mutableLiveDataN.setValue(emojiBagName);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/create/CreateEmojiStickerVM$c", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/social_contact/bean/EmojiStickerAddResultBean;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DialogVMSubscriber<EmojiStickerAddResultBean> {
        public c() {
            super(CreateEmojiStickerVM.this, true);
        }

        public void onFailed(int code, @Nullable String message) {
            super.onFailed(code, message);
            CreateEmojiStickerVM.this.q().setValue(Boolean.FALSE);
        }

        public void onCCSuccess(@Nullable EmojiStickerAddResultBean data) {
            fv5.b("提交审核中，请耐心等待~");
            CreateEmojiStickerVM.this.q().setValue(Boolean.TRUE);
        }
    }

    public final void h(@NotNull List<EmojiStickerFileBean> emojiList) {
        Intrinsics.checkNotNullParameter(emojiList, "emojiList");
        ArrayList arrayList = new ArrayList();
        for (EmojiStickerFileBean emojiStickerFileBean : emojiList) {
            if (TextUtils.isEmpty(emojiStickerFileBean.getFileUrl())) {
                arrayList.add(Integer.valueOf(emojiList.indexOf(emojiStickerFileBean) + 1));
            }
        }
        if (!(!arrayList.isEmpty())) {
            UniverseModel universeModel = this.model;
            String value = this.textEmojiName.getValue();
            if (value == null) {
                value = "";
            }
            n76.e(this, universeModel.a(value, j(emojiList.get(0).getFileUrl()), i(emojiList))).p5(new a());
            return;
        }
        this.uploadFinish.setValue(Boolean.FALSE);
        fv5.b((char) 31532 + arrayList + "张图片上传失败");
    }

    public final List<EmojiStickerFileBean> i(List<EmojiStickerFileBean> emojiList) {
        ArrayList arrayList = new ArrayList();
        for (EmojiStickerFileBean emojiStickerFileBean : emojiList) {
            if (StringsKt.startsWith$default(emojiStickerFileBean.getFileUrl(), "http", false, 2, (Object) null)) {
                emojiStickerFileBean.setFileUrl(j(emojiStickerFileBean.getFileUrl()));
            }
            arrayList.add(emojiStickerFileBean);
        }
        return emojiList;
    }

    public final String j(String url) {
        if (TextUtils.isEmpty(url)) {
            return "";
        }
        String path = Uri.parse(url).getPath();
        if (TextUtils.isEmpty(path)) {
            return "";
        }
        Intrinsics.checkNotNull(path);
        if (!StringsKt.startsWith$default(path, WVNativeCallbackUtil.SEPERATER, false, 2, (Object) null)) {
            return path;
        }
        String strSubstring = path.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    @NotNull
    public final MutableLiveData<CreateEmojiStickerAdapter<MultiItemEntity>> k() {
        return this.adapter;
    }

    public final void l(@NotNull String emojiBagCode) {
        Intrinsics.checkNotNullParameter(emojiBagCode, "emojiBagCode");
        n76.e(this, this.model.j(emojiBagCode)).p5(new b());
    }

    @NotNull
    /* JADX INFO: renamed from: m, reason: from getter */
    public final UniverseModel getModel() {
        return this.model;
    }

    @NotNull
    public final MutableLiveData<String> n() {
        return this.textEmojiName;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> o() {
        return this.titleBean;
    }

    @NotNull
    public final MutableLiveData<List<EmojiStickerImageBean>> p() {
        return this.uploadEmojiList;
    }

    @NotNull
    public final MutableLiveData<Boolean> q() {
        return this.uploadFinish;
    }

    public final void r(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.uploadFinish = mutableLiveData;
    }

    public final void s() {
        CreateEmojiStickerAdapter<MultiItemEntity> value = this.adapter.getValue();
        if (value != null) {
            ArrayList arrayList = new ArrayList();
            for (T t : value.getData()) {
                if (t instanceof EmojiStickerImageBean) {
                    arrayList.add(t);
                }
            }
            this.uploadEmojiList.setValue(arrayList);
        }
    }

    public final void t(@NotNull String emojiBagCode, @NotNull List<EmojiStickerFileBean> emojiList) {
        Intrinsics.checkNotNullParameter(emojiBagCode, "emojiBagCode");
        Intrinsics.checkNotNullParameter(emojiList, "emojiList");
        ArrayList arrayList = new ArrayList();
        for (EmojiStickerFileBean emojiStickerFileBean : emojiList) {
            if (TextUtils.isEmpty(emojiStickerFileBean.getFileUrl())) {
                arrayList.add(Integer.valueOf(emojiList.indexOf(emojiStickerFileBean) + 1));
            }
        }
        if (!(!arrayList.isEmpty())) {
            UniverseModel universeModel = this.model;
            String value = this.textEmojiName.getValue();
            if (value == null) {
                value = "";
            }
            n76.e(this, universeModel.F(value, emojiBagCode, j(emojiList.get(0).getFileUrl()), i(emojiList))).p5(new c());
            return;
        }
        this.uploadFinish.setValue(Boolean.FALSE);
        fv5.b((char) 31532 + arrayList + "张图片上传失败");
    }
}
