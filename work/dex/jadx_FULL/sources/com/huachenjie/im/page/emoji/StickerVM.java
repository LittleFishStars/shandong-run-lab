package com.huachenjie.im.page.emoji;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.im.bean.EmojiBean;
import com.huachenjie.im.bean.EmojiDetailData;
import com.zj.adlib.j44;
import com.zj.adlib.n76;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR%\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f8\u0006¢\u0006\f\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/im/page/emoji/StickerVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "emojiBagCode", "", "j", "Lcom/zj/adlib/j44;", "a", "Lcom/zj/adlib/j44;", "i", "()Lcom/zj/adlib/j44;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/im/page/emoji/StickerAdapter;", "kotlin.jvm.PlatformType", "Landroidx/lifecycle/MutableLiveData;", y6b.g, "()Landroidx/lifecycle/MutableLiveData;", "adapter", "<init>", "()V", "IM_release"}, k = 1, mv = {1, 8, 0})
public final class StickerVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final j44 model = new j44();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<StickerAdapter> adapter = new MutableLiveData<>(new StickerAdapter());

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/im/page/emoji/StickerVM$a", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/huachenjie/im/bean/EmojiDetailData;", "data", "", "onCCSuccess", "IM_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends BizSubscriber<EmojiDetailData> {
        public a() {
        }

        public void onCCSuccess(@Nullable EmojiDetailData data) {
            List<EmojiBean> emojiList;
            StickerAdapter value;
            if (data == null || (emojiList = data.getEmojiList()) == null || (value = StickerVM.this.h().getValue()) == null) {
                return;
            }
            value.setList(emojiList);
        }
    }

    @NotNull
    public final MutableLiveData<StickerAdapter> h() {
        return this.adapter;
    }

    @NotNull
    /* JADX INFO: renamed from: i, reason: from getter */
    public final j44 getModel() {
        return this.model;
    }

    public final void j(@NotNull String emojiBagCode) {
        Intrinsics.checkNotNullParameter(emojiBagCode, "emojiBagCode");
        n76.e(this, this.model.n(emojiBagCode)).p5(new a());
    }
}
