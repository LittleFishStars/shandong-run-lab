package com.huachenjie.im.page.emoji;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.adapter.ViewPager2Adapter;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.im.bean.EmojiItemData;
import com.huachenjie.im.bean.EmojiListData;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.j44;
import com.zj.adlib.n76;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\n8\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u0012\u0010\u000fR%\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\n8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\f\u0010\u000fR#\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\n8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0019\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/im/page/emoji/EmojiPanelVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "m", "Lcom/zj/adlib/j44;", "a", "Lcom/zj/adlib/j44;", "j", "()Lcom/zj/adlib/j44;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "showEmptySticker", "Lcom/huachenjie/base/adapter/ViewPager2Adapter;", t.d, "viewPagerAdapter", "Lcom/huachenjie/im/page/emoji/StickerItemAdapter;", "kotlin.jvm.PlatformType", "itemAdapter", "", "Lcom/huachenjie/im/bean/EmojiItemData;", y6b.g, "emojiBagList", "<init>", "()V", "IM_release"}, k = 1, mv = {1, 8, 0})
public final class EmojiPanelVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final j44 model = new j44();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showEmptySticker = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ViewPager2Adapter> viewPagerAdapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<StickerItemAdapter> itemAdapter = new MutableLiveData<>(new StickerItemAdapter());

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<EmojiItemData>> emojiBagList = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/im/page/emoji/EmojiPanelVM$a", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/huachenjie/im/bean/EmojiListData;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "IM_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends BizSubscriber<EmojiListData> {
        public a() {
        }

        public void onFailed(int code, @Nullable String message) {
            EmojiPanelVM.this.h().setValue(null);
            EmojiPanelVM.this.k().setValue(Boolean.TRUE);
        }

        public void onCCSuccess(@Nullable EmojiListData data) {
            if (data != null) {
                List<EmojiItemData> emojiBagList = data.getEmojiBagList();
                boolean z = false;
                if (emojiBagList != null && (!emojiBagList.isEmpty())) {
                    z = true;
                }
                if (z) {
                    EmojiPanelVM.this.h().setValue(data.getEmojiBagList());
                    EmojiPanelVM.this.k().setValue(Boolean.FALSE);
                    return;
                }
            }
            EmojiPanelVM.this.h().setValue(null);
            EmojiPanelVM.this.k().setValue(Boolean.TRUE);
        }
    }

    @NotNull
    public final MutableLiveData<List<EmojiItemData>> h() {
        return this.emojiBagList;
    }

    @NotNull
    public final MutableLiveData<StickerItemAdapter> i() {
        return this.itemAdapter;
    }

    @NotNull
    /* JADX INFO: renamed from: j, reason: from getter */
    public final j44 getModel() {
        return this.model;
    }

    @NotNull
    public final MutableLiveData<Boolean> k() {
        return this.showEmptySticker;
    }

    @NotNull
    public final MutableLiveData<ViewPager2Adapter> l() {
        return this.viewPagerAdapter;
    }

    public final void m() {
        n76.e(this, this.model.o()).p5(new a());
    }
}
