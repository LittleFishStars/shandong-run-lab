package com.huachenjie.social_contact.page.emoji_sticker.search;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.social_contact.api.UniverseModel;
import com.huachenjie.social_contact.bean.EmojiStickerBean;
import com.huachenjie.social_contact.bean.EmojiStickerDownloadBean;
import com.huachenjie.social_contact.page.emoji_sticker.adapter.EmojiStickerAdapter;
import com.huachenjie.social_contact.page.emoji_sticker.search.SearchEmojiStickerVM;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\r\u001a\u00020\u0002H\u0002R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R1\u0010\u001c\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0016 \u0017*\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00150\u00150\u00148\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u00148\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001bR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u00148\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\"\u0010\u001bR\u0016\u0010&\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/search/SearchEmojiStickerVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "t", "r", "", "Lcom/huachenjie/social_contact/bean/EmojiStickerBean;", GoodsSpecificationPreviewActivity.z, t.d, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "position", "k", "s", "Lcom/huachenjie/social_contact/api/UniverseModel;", "a", "Lcom/huachenjie/social_contact/api/UniverseModel;", "n", "()Lcom/huachenjie/social_contact/api/UniverseModel;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/social_contact/page/emoji_sticker/adapter/EmojiStickerAdapter;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "kotlin.jvm.PlatformType", "i", "Landroidx/lifecycle/MutableLiveData;", "m", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", "j", "p", "textSearchName", "", j.b, "showClear", "K", "I", "pageNum", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class SearchEmojiStickerVM extends BaseVM {

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
    public final MutableLiveData<String> textSearchName;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showClear;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/search/SearchEmojiStickerVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/social_contact/bean/EmojiStickerDownloadBean;", "downloadBean", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<EmojiStickerDownloadBean> {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EmojiStickerBean f36284a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, EmojiStickerBean emojiStickerBean) {
            super(SearchEmojiStickerVM.this, true);
            this.K = i;
            this.f36284a = emojiStickerBean;
        }

        public void onCCSuccess(@Nullable EmojiStickerDownloadBean downloadBean) {
            EmojiStickerAdapter<MultiItemEntity> value = SearchEmojiStickerVM.this.m().getValue();
            if (value != null) {
                int i = this.K;
                EmojiStickerBean emojiStickerBean = this.f36284a;
                Object obj = value.getData().get(i);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.huachenjie.social_contact.bean.EmojiStickerBean");
                EmojiStickerBean emojiStickerBean2 = (EmojiStickerBean) obj;
                emojiStickerBean2.setItemStatusType(5);
                emojiStickerBean2.setDownloadTotal(downloadBean != null ? downloadBean.getDownloadTotal() : 0);
                o03.f43639a.c(value.getContext(), emojiStickerBean.getEmojiBagCode());
                value.notifyItemChanged(i);
            }
            fv5.b("下载成功");
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\f"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/search/SearchEmojiStickerVM$b", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/social_contact/bean/EmojiStickerBean;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends BizSubscriber<PageEntity<EmojiStickerBean>> {
        public b() {
        }

        public void onFailed(int code, @Nullable String message) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
            if (SearchEmojiStickerVM.this.pageNum != 1) {
                SearchEmojiStickerVM.this.pageNum--;
                return;
            }
            EmojiStickerAdapter<MultiItemEntity> value = SearchEmojiStickerVM.this.m().getValue();
            if (value != null) {
                value.setList(null);
            }
            EmojiStickerAdapter<MultiItemEntity> value2 = SearchEmojiStickerVM.this.m().getValue();
            if (value2 != null) {
                value2.h();
            }
        }

        /* JADX WARN: Code duplicated, block: B:32:0x00b1  */
        public void onCCSuccess(@Nullable PageEntity<EmojiStickerBean> data) {
            BaseLoadMoreModule loadMoreModule;
            BaseLoadMoreModule loadMoreModule2;
            if (SearchEmojiStickerVM.this.pageNum == 1) {
                if ((data != null ? data.getList() : null) == null || data.getList().isEmpty()) {
                    EmojiStickerAdapter<MultiItemEntity> value = SearchEmojiStickerVM.this.m().getValue();
                    if (value != null) {
                        value.setList(null);
                    }
                    EmojiStickerAdapter<MultiItemEntity> value2 = SearchEmojiStickerVM.this.m().getValue();
                    if (value2 != null) {
                        value2.h();
                    }
                } else {
                    EmojiStickerAdapter<MultiItemEntity> value3 = SearchEmojiStickerVM.this.m().getValue();
                    if (value3 != null) {
                        value3.g();
                    }
                    EmojiStickerAdapter<MultiItemEntity> value4 = SearchEmojiStickerVM.this.m().getValue();
                    if (value4 != null) {
                        SearchEmojiStickerVM searchEmojiStickerVM = SearchEmojiStickerVM.this;
                        List<EmojiStickerBean> list = data.getList();
                        Intrinsics.checkNotNullExpressionValue(list, "data.list");
                        value4.setList(searchEmojiStickerVM.l(list));
                    }
                }
            } else {
                if ((data != null ? data.getList() : null) != null) {
                    List list2 = data.getList();
                    Intrinsics.checkNotNullExpressionValue(list2, "data.list");
                    if (!list2.isEmpty()) {
                        EmojiStickerAdapter<MultiItemEntity> value5 = SearchEmojiStickerVM.this.m().getValue();
                        if (value5 != null) {
                            SearchEmojiStickerVM searchEmojiStickerVM2 = SearchEmojiStickerVM.this;
                            List<EmojiStickerBean> list3 = data.getList();
                            Intrinsics.checkNotNullExpressionValue(list3, "data.list");
                            value5.addData((Collection) searchEmojiStickerVM2.l(list3));
                        }
                    } else {
                        SearchEmojiStickerVM.this.pageNum--;
                    }
                } else {
                    SearchEmojiStickerVM.this.pageNum--;
                }
            }
            if (data != null && data.getHasNext()) {
                EmojiStickerAdapter<MultiItemEntity> value6 = SearchEmojiStickerVM.this.m().getValue();
                if (value6 == null || (loadMoreModule2 = value6.getLoadMoreModule()) == null) {
                    return;
                }
                loadMoreModule2.loadMoreComplete();
                return;
            }
            EmojiStickerAdapter<MultiItemEntity> value7 = SearchEmojiStickerVM.this.m().getValue();
            if (value7 == null || (loadMoreModule = value7.getLoadMoreModule()) == null) {
                return;
            }
            BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
        }
    }

    public SearchEmojiStickerVM() {
        MutableLiveData<EmojiStickerAdapter<MultiItemEntity>> mutableLiveData = new MutableLiveData<>(new EmojiStickerAdapter());
        this.adapter = mutableLiveData;
        this.textSearchName = new MutableLiveData<>();
        this.showClear = new MutableLiveData<>(Boolean.FALSE);
        this.pageNum = 1;
        EmojiStickerAdapter<MultiItemEntity> value = mutableLiveData.getValue();
        if (value != null) {
            value.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.vx7
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    SearchEmojiStickerVM.q(this.f45482a);
                }
            });
        }
    }

    public static final void q(SearchEmojiStickerVM searchEmojiStickerVM) {
        Intrinsics.checkNotNullParameter(searchEmojiStickerVM, "this$0");
        searchEmojiStickerVM.r();
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

    @NotNull
    /* JADX INFO: renamed from: n, reason: from getter */
    public final UniverseModel getModel() {
        return this.model;
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        return this.showClear;
    }

    @NotNull
    public final MutableLiveData<String> p() {
        return this.textSearchName;
    }

    public final void r() {
        this.pageNum++;
        s();
    }

    public final void s() {
        UniverseModel universeModel = this.model;
        String value = this.textSearchName.getValue();
        if (value == null) {
            value = "";
        }
        n76.e(this, universeModel.r(value, 3, this.pageNum)).p5(new b());
    }

    public final void t() {
        this.pageNum = 1;
        s();
    }
}
