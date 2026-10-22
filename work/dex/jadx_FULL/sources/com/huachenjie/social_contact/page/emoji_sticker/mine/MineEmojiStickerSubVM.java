package com.huachenjie.social_contact.page.emoji_sticker.mine;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.social_contact.api.UniverseModel;
import com.huachenjie.social_contact.bean.EmojiStickerBean;
import com.huachenjie.social_contact.page.emoji_sticker.adapter.EmojiStickerAdapter;
import com.huachenjie.social_contact.page.emoji_sticker.mine.MineEmojiStickerSubVM;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.n76;
import com.zj.adlib.o03;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.PageEntity;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\f\u001a\u00020\u0002H\u0002R\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R1\u0010\u001b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0015 \u0016*\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00140\u00140\u00138\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00138\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u0016\u0010\"\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/mine/MineEmojiStickerSubVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "s", "q", "", "Lcom/huachenjie/social_contact/bean/EmojiStickerBean;", GoodsSpecificationPreviewActivity.z, "m", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, t.d, "k", "r", "Lcom/huachenjie/social_contact/api/UniverseModel;", "a", "Lcom/huachenjie/social_contact/api/UniverseModel;", j.b, "()Lcom/huachenjie/social_contact/api/UniverseModel;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/social_contact/page/emoji_sticker/adapter/EmojiStickerAdapter;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "kotlin.jvm.PlatformType", "i", "Landroidx/lifecycle/MutableLiveData;", "n", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", "j", "getType", "type", "K", "I", "pageNum", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class MineEmojiStickerSubVM extends BaseVM {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final UniverseModel model = new UniverseModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<EmojiStickerAdapter<MultiItemEntity>> adapter;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> type;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/mine/MineEmojiStickerSubVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "downloadBean", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EmojiStickerBean f36276a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(EmojiStickerBean emojiStickerBean) {
            super(MineEmojiStickerSubVM.this, true);
            this.f36276a = emojiStickerBean;
        }

        public void onCCSuccess(@Nullable Object downloadBean) {
            EmojiStickerAdapter<MultiItemEntity> value = MineEmojiStickerSubVM.this.n().getValue();
            if (value != null) {
                value.remove(this.f36276a);
            }
            EmojiStickerAdapter<MultiItemEntity> value2 = MineEmojiStickerSubVM.this.n().getValue();
            if (value2 != null) {
                o03.f43639a.b(value2.getContext(), this.f36276a.getEmojiBagCode());
            }
            fv5.b("删除成功");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/mine/MineEmojiStickerSubVM$b", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "downloadBean", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DialogVMSubscriber<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EmojiStickerBean f36277a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EmojiStickerBean emojiStickerBean) {
            super(MineEmojiStickerSubVM.this, true);
            this.f36277a = emojiStickerBean;
        }

        public void onCCSuccess(@Nullable Object downloadBean) {
            EmojiStickerAdapter<MultiItemEntity> value = MineEmojiStickerSubVM.this.n().getValue();
            if (value != null) {
                value.remove(this.f36277a);
            }
            EmojiStickerAdapter<MultiItemEntity> value2 = MineEmojiStickerSubVM.this.n().getValue();
            if (value2 != null) {
                o03.f43639a.b(value2.getContext(), this.f36277a.getEmojiBagCode());
            }
            fv5.b("删除成功");
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\f"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/mine/MineEmojiStickerSubVM$c", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/social_contact/bean/EmojiStickerBean;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends BizSubscriber<PageEntity<EmojiStickerBean>> {
        public c() {
        }

        public void onFailed(int code, @Nullable String message) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
            if (MineEmojiStickerSubVM.this.pageNum != 1) {
                MineEmojiStickerSubVM.this.pageNum--;
                return;
            }
            EmojiStickerAdapter<MultiItemEntity> value = MineEmojiStickerSubVM.this.n().getValue();
            if (value != null) {
                value.setList(null);
            }
            EmojiStickerAdapter<MultiItemEntity> value2 = MineEmojiStickerSubVM.this.n().getValue();
            if (value2 != null) {
                value2.h();
            }
        }

        /* JADX WARN: Code duplicated, block: B:32:0x00b1  */
        public void onCCSuccess(@Nullable PageEntity<EmojiStickerBean> data) {
            BaseLoadMoreModule loadMoreModule;
            BaseLoadMoreModule loadMoreModule2;
            if (MineEmojiStickerSubVM.this.pageNum == 1) {
                if ((data != null ? data.getList() : null) == null || data.getList().isEmpty()) {
                    EmojiStickerAdapter<MultiItemEntity> value = MineEmojiStickerSubVM.this.n().getValue();
                    if (value != null) {
                        value.setList(null);
                    }
                    EmojiStickerAdapter<MultiItemEntity> value2 = MineEmojiStickerSubVM.this.n().getValue();
                    if (value2 != null) {
                        value2.h();
                    }
                } else {
                    EmojiStickerAdapter<MultiItemEntity> value3 = MineEmojiStickerSubVM.this.n().getValue();
                    if (value3 != null) {
                        value3.g();
                    }
                    EmojiStickerAdapter<MultiItemEntity> value4 = MineEmojiStickerSubVM.this.n().getValue();
                    if (value4 != null) {
                        MineEmojiStickerSubVM mineEmojiStickerSubVM = MineEmojiStickerSubVM.this;
                        List<EmojiStickerBean> list = data.getList();
                        Intrinsics.checkNotNullExpressionValue(list, "data.list");
                        value4.setList(mineEmojiStickerSubVM.m(list));
                    }
                }
            } else {
                if ((data != null ? data.getList() : null) != null) {
                    List list2 = data.getList();
                    Intrinsics.checkNotNullExpressionValue(list2, "data.list");
                    if (!list2.isEmpty()) {
                        EmojiStickerAdapter<MultiItemEntity> value5 = MineEmojiStickerSubVM.this.n().getValue();
                        if (value5 != null) {
                            MineEmojiStickerSubVM mineEmojiStickerSubVM2 = MineEmojiStickerSubVM.this;
                            List<EmojiStickerBean> list3 = data.getList();
                            Intrinsics.checkNotNullExpressionValue(list3, "data.list");
                            value5.addData((Collection) mineEmojiStickerSubVM2.m(list3));
                        }
                    } else {
                        MineEmojiStickerSubVM.this.pageNum--;
                    }
                } else {
                    MineEmojiStickerSubVM.this.pageNum--;
                }
            }
            if (data != null && data.getHasNext()) {
                EmojiStickerAdapter<MultiItemEntity> value6 = MineEmojiStickerSubVM.this.n().getValue();
                if (value6 == null || (loadMoreModule2 = value6.getLoadMoreModule()) == null) {
                    return;
                }
                loadMoreModule2.loadMoreComplete();
                return;
            }
            EmojiStickerAdapter<MultiItemEntity> value7 = MineEmojiStickerSubVM.this.n().getValue();
            if (value7 == null || (loadMoreModule = value7.getLoadMoreModule()) == null) {
                return;
            }
            BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
        }
    }

    public MineEmojiStickerSubVM() {
        MutableLiveData<EmojiStickerAdapter<MultiItemEntity>> mutableLiveData = new MutableLiveData<>(new EmojiStickerAdapter());
        this.adapter = mutableLiveData;
        this.type = new MutableLiveData<>();
        this.pageNum = 1;
        EmojiStickerAdapter<MultiItemEntity> value = mutableLiveData.getValue();
        if (value != null) {
            value.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.lp5
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    MineEmojiStickerSubVM.p(this.f43122a);
                }
            });
        }
    }

    public static final void p(MineEmojiStickerSubVM mineEmojiStickerSubVM) {
        Intrinsics.checkNotNullParameter(mineEmojiStickerSubVM, "this$0");
        mineEmojiStickerSubVM.q();
    }

    @NotNull
    public final MutableLiveData<Integer> getType() {
        return this.type;
    }

    public final void k(@NotNull EmojiStickerBean bean) {
        Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
        n76.e(this, this.model.d(bean.getEmojiBagCode())).p5(new a(bean));
    }

    public final void l(@NotNull EmojiStickerBean bean) {
        Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
        n76.e(this, this.model.e(bean.getEmojiBagCode())).p5(new b(bean));
    }

    @NotNull
    public final List<EmojiStickerBean> m(@NotNull List<EmojiStickerBean> list) {
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        Integer value = this.type.getValue();
        if (value != null && value.intValue() == 1) {
            for (EmojiStickerBean emojiStickerBean : list) {
                if (emojiStickerBean.getAuidtStatus() == 2) {
                    emojiStickerBean.setItemStatusType(2);
                } else {
                    emojiStickerBean.setItemStatusType(1);
                }
            }
        } else {
            Integer value2 = this.type.getValue();
            if (value2 != null && value2.intValue() == 2) {
                Iterator<EmojiStickerBean> it = list.iterator();
                while (it.hasNext()) {
                    it.next().setItemStatusType(3);
                }
            }
        }
        return list;
    }

    @NotNull
    public final MutableLiveData<EmojiStickerAdapter<MultiItemEntity>> n() {
        return this.adapter;
    }

    @NotNull
    /* JADX INFO: renamed from: o, reason: from getter */
    public final UniverseModel getModel() {
        return this.model;
    }

    public final void q() {
        this.pageNum++;
        r();
    }

    public final void r() {
        UniverseModel universeModel = this.model;
        Integer value = this.type.getValue();
        if (value == null) {
            value = 0;
        }
        n76.e(this, universeModel.r("", value.intValue(), this.pageNum)).p5(new c());
    }

    public final void s() {
        this.pageNum = 1;
        r();
    }
}
