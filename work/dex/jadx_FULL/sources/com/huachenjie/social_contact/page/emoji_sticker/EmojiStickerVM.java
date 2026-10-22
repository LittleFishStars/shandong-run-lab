package com.huachenjie.social_contact.page.emoji_sticker;

import android.annotation.SuppressLint;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.social_contact.api.UniverseModel;
import com.huachenjie.social_contact.bean.EmojiPropBean;
import com.huachenjie.social_contact.bean.EmojiStickerBean;
import com.huachenjie.social_contact.bean.EmojiStickerDownloadBean;
import com.huachenjie.social_contact.bean.EmojiStickerTitleBean;
import com.huachenjie.social_contact.page.emoji_sticker.EmojiStickerVM;
import com.huachenjie.social_contact.page.emoji_sticker.adapter.EmojiStickerAdapter;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.n76;
import com.zj.adlib.o03;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.PageEntity;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0016\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000f\u001a\u00020\u0002H\u0002R\u0017\u0010\u0015\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR1\u0010\"\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001e \u001f*\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d0\u001d0\u00168\u0006¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b!\u0010\u001bR\u0016\u0010%\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0\u00168\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b&\u0010\u001bR#\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u00070\u00168\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b)\u0010\u001b¨\u0006-"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/EmojiStickerVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "n", "u", "v", "s", "", "Lcom/huachenjie/social_contact/bean/EmojiStickerBean;", GoodsSpecificationPreviewActivity.z, t.d, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "position", "k", "t", "Lcom/huachenjie/social_contact/api/UniverseModel;", "a", "Lcom/huachenjie/social_contact/api/UniverseModel;", "p", "()Lcom/huachenjie/social_contact/api/UniverseModel;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", "q", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "Lcom/huachenjie/social_contact/page/emoji_sticker/adapter/EmojiStickerAdapter;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "kotlin.jvm.PlatformType", "j", "m", "adapter", "K", "I", "pageNum", "getType", "type", "Lcom/huachenjie/social_contact/bean/EmojiPropBean;", j.b, "emojiPropList", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class EmojiStickerVM extends BaseVM {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final UniverseModel model = new UniverseModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<EmojiStickerAdapter<MultiItemEntity>> adapter;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> type;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<EmojiPropBean>> emojiPropList;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0015¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/EmojiStickerVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/social_contact/bean/EmojiStickerDownloadBean;", "downloadBean", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<EmojiStickerDownloadBean> {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EmojiStickerBean f36238a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, EmojiStickerBean emojiStickerBean) {
            super(EmojiStickerVM.this, true);
            this.K = i;
            this.f36238a = emojiStickerBean;
        }

        @SuppressLint({"NotifyDataSetChanged"})
        public void onCCSuccess(@Nullable EmojiStickerDownloadBean downloadBean) {
            EmojiStickerAdapter<MultiItemEntity> value = EmojiStickerVM.this.m().getValue();
            if (value != null) {
                int i = this.K;
                EmojiStickerBean emojiStickerBean = this.f36238a;
                Object obj = value.getData().get(i);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.huachenjie.social_contact.bean.EmojiStickerBean");
                EmojiStickerBean emojiStickerBean2 = (EmojiStickerBean) obj;
                emojiStickerBean2.setItemStatusType(5);
                emojiStickerBean2.setDownloadTotal(downloadBean != null ? downloadBean.getDownloadTotal() : 0);
                value.notifyDataSetChanged();
                o03.f43639a.c(value.getContext(), emojiStickerBean.getEmojiBagCode());
            }
            fv5.b("下载成功");
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014¨\u0006\u0007"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/EmojiStickerVM$b", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/social_contact/bean/EmojiPropBean;", "data", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends BizSubscriber<PageEntity<EmojiPropBean>> {
        public b() {
        }

        public void onCCSuccess(@Nullable PageEntity<EmojiPropBean> data) {
            EmojiStickerVM.this.o().setValue(data != null ? data.getList() : null);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\f"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/EmojiStickerVM$c", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/social_contact/bean/EmojiStickerBean;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends BizSubscriber<PageEntity<EmojiStickerBean>> {
        public c() {
        }

        public void onFailed(int code, @Nullable String message) {
            BaseLoadMoreModule loadMoreModule;
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
            boolean z = true;
            if (EmojiStickerVM.this.pageNum != 1) {
                EmojiStickerVM.this.pageNum--;
            }
            EmojiStickerAdapter<MultiItemEntity> value = EmojiStickerVM.this.m().getValue();
            if (value != null && (loadMoreModule = value.getLoadMoreModule()) != null) {
                BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
            }
            EmojiStickerAdapter<MultiItemEntity> value2 = EmojiStickerVM.this.m().getValue();
            List data = value2 != null ? value2.getData() : null;
            if (data != null && !data.isEmpty()) {
                z = false;
            }
            if (z) {
                EmojiStickerAdapter<MultiItemEntity> value3 = EmojiStickerVM.this.m().getValue();
                if (value3 != null) {
                    value3.h();
                    return;
                }
                return;
            }
            EmojiStickerAdapter<MultiItemEntity> value4 = EmojiStickerVM.this.m().getValue();
            if (value4 != null) {
                value4.g();
            }
        }

        /* JADX WARN: Code duplicated, block: B:37:0x00c2  */
        public void onCCSuccess(@Nullable PageEntity<EmojiStickerBean> data) {
            BaseLoadMoreModule loadMoreModule;
            BaseLoadMoreModule loadMoreModule2;
            List<EmojiStickerBean> list;
            if (EmojiStickerVM.this.pageNum == 1) {
                if (data != null && (list = data.getList()) != null) {
                    EmojiStickerVM emojiStickerVM = EmojiStickerVM.this;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new EmojiStickerTitleBean("最新入住", 0, 2, null));
                    arrayList.addAll(emojiStickerVM.l(list));
                    EmojiStickerAdapter<MultiItemEntity> value = emojiStickerVM.m().getValue();
                    if (value != null) {
                        value.addData((Collection) arrayList);
                    }
                }
                EmojiStickerAdapter<MultiItemEntity> value2 = EmojiStickerVM.this.m().getValue();
                Collection data2 = value2 != null ? value2.getData() : null;
                if (data2 == null || data2.isEmpty()) {
                    EmojiStickerAdapter<MultiItemEntity> value3 = EmojiStickerVM.this.m().getValue();
                    if (value3 != null) {
                        value3.h();
                    }
                } else {
                    EmojiStickerAdapter<MultiItemEntity> value4 = EmojiStickerVM.this.m().getValue();
                    if (value4 != null) {
                        value4.g();
                    }
                }
            } else {
                if ((data != null ? data.getList() : null) != null) {
                    List list2 = data.getList();
                    Intrinsics.checkNotNullExpressionValue(list2, "data.list");
                    if (!list2.isEmpty()) {
                        EmojiStickerAdapter<MultiItemEntity> value5 = EmojiStickerVM.this.m().getValue();
                        if (value5 != null) {
                            EmojiStickerVM emojiStickerVM2 = EmojiStickerVM.this;
                            List<EmojiStickerBean> list3 = data.getList();
                            Intrinsics.checkNotNullExpressionValue(list3, "data.list");
                            value5.addData((Collection) emojiStickerVM2.l(list3));
                        }
                    } else {
                        EmojiStickerVM.this.pageNum--;
                    }
                } else {
                    EmojiStickerVM.this.pageNum--;
                }
            }
            if (data != null && data.getHasNext()) {
                EmojiStickerAdapter<MultiItemEntity> value6 = EmojiStickerVM.this.m().getValue();
                if (value6 == null || (loadMoreModule2 = value6.getLoadMoreModule()) == null) {
                    return;
                }
                loadMoreModule2.loadMoreComplete();
                return;
            }
            EmojiStickerAdapter<MultiItemEntity> value7 = EmojiStickerVM.this.m().getValue();
            if (value7 == null || (loadMoreModule = value7.getLoadMoreModule()) == null) {
                return;
            }
            BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\f"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/EmojiStickerVM$d", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/social_contact/bean/EmojiStickerBean;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends DialogVMSubscriber<PageEntity<EmojiStickerBean>> {
        public d() {
            super(EmojiStickerVM.this, true, true);
        }

        public void onFailed(int code, @Nullable String message) {
            super.onFailed(code, message);
            EmojiStickerVM.this.a();
            EmojiStickerAdapter<MultiItemEntity> value = EmojiStickerVM.this.m().getValue();
            Collection data = value != null ? value.getData() : null;
            if (data == null || data.isEmpty()) {
                EmojiStickerAdapter<MultiItemEntity> value2 = EmojiStickerVM.this.m().getValue();
                if (value2 != null) {
                    value2.h();
                    return;
                }
                return;
            }
            EmojiStickerAdapter<MultiItemEntity> value3 = EmojiStickerVM.this.m().getValue();
            if (value3 != null) {
                value3.g();
            }
        }

        public void onCCSuccess(@Nullable PageEntity<EmojiStickerBean> data) {
            ArrayList arrayList = new ArrayList();
            if (data != null && data.getList() != null) {
                List list = data.getList();
                Intrinsics.checkNotNullExpressionValue(list, "data.list");
                if (!list.isEmpty()) {
                    arrayList.add(new EmojiStickerTitleBean("人气表情包住户", 0, 2, null));
                    EmojiStickerVM emojiStickerVM = EmojiStickerVM.this;
                    List<EmojiStickerBean> list2 = data.getList();
                    Intrinsics.checkNotNullExpressionValue(list2, "data.list");
                    arrayList.addAll(emojiStickerVM.l(list2));
                }
            }
            EmojiStickerAdapter<MultiItemEntity> value = EmojiStickerVM.this.m().getValue();
            if (value != null) {
                value.setList(arrayList);
            }
            EmojiStickerVM.this.v();
        }
    }

    public EmojiStickerVM() {
        MutableLiveData<EmojiStickerAdapter<MultiItemEntity>> mutableLiveData = new MutableLiveData<>(new EmojiStickerAdapter());
        this.adapter = mutableLiveData;
        this.pageNum = 1;
        this.type = new MutableLiveData<>();
        this.emojiPropList = new MutableLiveData<>();
        EmojiStickerAdapter<MultiItemEntity> value = mutableLiveData.getValue();
        if (value != null) {
            value.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.q03
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    EmojiStickerVM.r(this.f44094a);
                }
            });
        }
    }

    public static final void r(EmojiStickerVM emojiStickerVM) {
        Intrinsics.checkNotNullParameter(emojiStickerVM, "this$0");
        emojiStickerVM.s();
    }

    @NotNull
    public final MutableLiveData<Integer> getType() {
        return this.type;
    }

    public final void k(@NotNull EmojiStickerBean bean, int position) {
        Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
        n76.e(this, this.model.f(bean.getEmojiBagCode())).p5(new a(position, bean));
    }

    @NotNull
    public final List<EmojiStickerBean> l(@NotNull List<EmojiStickerBean> list) {
        Intrinsics.checkNotNullParameter(list, GoodsSpecificationPreviewActivity.z);
        for (EmojiStickerBean emojiStickerBean : list) {
            if (emojiStickerBean.getDownloadFlag()) {
                emojiStickerBean.setItemStatusType(5);
            } else {
                emojiStickerBean.setItemStatusType(4);
            }
        }
        return list;
    }

    @NotNull
    public final MutableLiveData<EmojiStickerAdapter<MultiItemEntity>> m() {
        return this.adapter;
    }

    public final void n() {
        n76.e(this, this.model.k()).p5(new b());
    }

    @NotNull
    public final MutableLiveData<List<EmojiPropBean>> o() {
        return this.emojiPropList;
    }

    @NotNull
    /* JADX INFO: renamed from: p, reason: from getter */
    public final UniverseModel getModel() {
        return this.model;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> q() {
        return this.titleBean;
    }

    public final void s() {
        this.pageNum++;
        t();
    }

    public final void t() {
        n76.e(this, this.model.r("", 3, this.pageNum)).p5(new c());
    }

    public final void u() {
        n76.e(this, this.model.s()).p5(new d());
    }

    public final void v() {
        this.pageNum = 1;
        t();
    }
}
