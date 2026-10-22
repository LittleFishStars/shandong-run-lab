package com.huachenjie.social_contact.vm;

import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.GiftBean;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.adapter.WorldLetterAdapter;
import com.huachenjie.social_contact.api.UniverseModel;
import com.huachenjie.social_contact.bean.NoticeBean;
import com.huachenjie.social_contact.dialog.PropLetterDialog;
import com.huachenjie.social_contact.dialog.ReceiveSysGiftDialog;
import com.huachenjie.social_contact.vm.WorldLetterVM;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.n76;
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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R0\u0010 \u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u001b0\u001b0\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R(\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b!\u0010\u0019R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/huachenjie/social_contact/vm/WorldLetterVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "Lcom/huachenjie/social_contact/adapter/WorldLetterAdapter;", t.d, "", "t", "p", "Lcom/huachenjie/social_contact/bean/NoticeBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "r", "s", "", "pageNum", "q", "Lcom/huachenjie/social_contact/api/UniverseModel;", "a", "Lcom/huachenjie/social_contact/api/UniverseModel;", "messageModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "w", "(Landroidx/lifecycle/MutableLiveData;)V", "titleBean", "", "kotlin.jvm.PlatformType", "j", j.b, "v", "isRefreshing", "u", "adapter", "K", "I", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class WorldLetterVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final UniverseModel messageModel = new UniverseModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<WorldLetterAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/social_contact/vm/WorldLetterVM$a", "Lcom/huachenjie/social_contact/dialog/PropLetterDialog$OnClickCallback;", "", "a", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements PropLetterDialog.OnClickCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NoticeBean f36342a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ WorldLetterVM f13086a;

        public a(NoticeBean noticeBean, WorldLetterVM worldLetterVM) {
            this.f36342a = noticeBean;
            this.f13086a = worldLetterVM;
        }

        @Override // com.huachenjie.social_contact.dialog.PropLetterDialog.OnClickCallback
        public void a() {
            this.f36342a.setReceiveType(true);
            this.f36342a.setReadStatus(1);
            WorldLetterAdapter value = this.f13086a.j().getValue();
            Intrinsics.checkNotNull(value);
            value.notifyDataSetChanged();
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\f"}, d2 = {"com/huachenjie/social_contact/vm/WorldLetterVM$b", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/social_contact/bean/NoticeBean;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends BizSubscriber<PageEntity<NoticeBean>> {
        public b() {
        }

        public void onFailed(int code, @Nullable String message) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
            WorldLetterVM.this.o().setValue(Boolean.FALSE);
        }

        public void onCCSuccess(@NotNull PageEntity<NoticeBean> data) {
            WorldLetterAdapter value;
            Intrinsics.checkNotNullParameter(data, "data");
            WorldLetterVM.this.o().setValue(Boolean.FALSE);
            if (data.getPageNum() == 1) {
                WorldLetterAdapter value2 = WorldLetterVM.this.j().getValue();
                Intrinsics.checkNotNull(value2);
                value2.setList(data.getList());
            } else if (data.getList() != null && (value = WorldLetterVM.this.j().getValue()) != null) {
                List list = data.getList();
                Intrinsics.checkNotNullExpressionValue(list, "data.list");
                value.addData((Collection) list);
            }
            if (data.getHasNext()) {
                WorldLetterAdapter value3 = WorldLetterVM.this.j().getValue();
                Intrinsics.checkNotNull(value3);
                value3.getLoadMoreModule().loadMoreComplete();
            } else {
                WorldLetterAdapter value4 = WorldLetterVM.this.j().getValue();
                Intrinsics.checkNotNull(value4);
                BaseLoadMoreModule.loadMoreEnd$default(value4.getLoadMoreModule(), false, 1, null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/social_contact/vm/WorldLetterVM$c", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "", "data", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends BizSubscriber<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NoticeBean f36344a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ WorldLetterVM f13087a;

        public c(NoticeBean noticeBean, WorldLetterVM worldLetterVM) {
            this.f36344a = noticeBean;
            this.f13087a = worldLetterVM;
        }

        public void onCCSuccess(@Nullable Object data) {
            this.f36344a.setReadStatus(1);
            WorldLetterAdapter value = this.f13087a.j().getValue();
            Intrinsics.checkNotNull(value);
            value.notifyDataSetChanged();
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/social_contact/vm/WorldLetterVM$d", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends DialogVMSubscriber<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NoticeBean f36345a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(NoticeBean noticeBean) {
            super(WorldLetterVM.this, true);
            this.f36345a = noticeBean;
        }

        public void onCCSuccess(@Nullable Object data) {
            this.f36345a.setReceiveType(true);
            this.f36345a.setReadStatus(1);
            WorldLetterAdapter value = WorldLetterVM.this.j().getValue();
            Intrinsics.checkNotNull(value);
            value.notifyDataSetChanged();
            ArrayList<GiftBean> arrayList = new ArrayList<>();
            arrayList.addAll(this.f36345a.getGiftList());
            WorldLetterVM.this.g.setValue(ReceiveSysGiftDialog.INSTANCE.a(arrayList));
        }

        public void onFailed(int code, @Nullable String message) {
            super.onFailed(code, message);
        }
    }

    public static final void m(WorldLetterVM worldLetterVM, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(worldLetterVM, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "_adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object obj = baseQuickAdapter.getData().get(i);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.huachenjie.social_contact.bean.NoticeBean");
        NoticeBean noticeBean = (NoticeBean) obj;
        if (view.getId() != R.id.rl_letter) {
            if (view.getId() == R.id.rl_letter_annex) {
                if (noticeBean.getReceiveType()) {
                    fv5.b("您已经领取过该礼物了");
                    return;
                } else {
                    worldLetterVM.s(noticeBean);
                    return;
                }
            }
            return;
        }
        if (noticeBean.getReadStatus() == 0 && noticeBean.getMessageType() != 1) {
            worldLetterVM.r(noticeBean);
        }
        if (noticeBean.getMessageType() == 1) {
            worldLetterVM.g.setValue(PropLetterDialog.INSTANCE.a(noticeBean, new a(noticeBean, worldLetterVM)));
        } else {
            ARouter.getInstance().build(RoutePathConstants.Common.c).withString("title", noticeBean.getNoticeType() != 1 ? "闪动号" : "校园公告").withString("url", noticeBean.getNoticeUrl()).navigation();
        }
    }

    public static final void n(WorldLetterVM worldLetterVM) {
        Intrinsics.checkNotNullParameter(worldLetterVM, "this$0");
        worldLetterVM.p();
    }

    @NotNull
    public final MutableLiveData<WorldLetterAdapter> j() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> k() {
        return this.titleBean;
    }

    @Nullable
    public final WorldLetterAdapter l() {
        if (this.adapter.getValue() != null) {
            return this.adapter.getValue();
        }
        WorldLetterAdapter worldLetterAdapter = new WorldLetterAdapter();
        worldLetterAdapter.addChildClickViewIds(R.id.rl_letter, R.id.rl_letter_annex);
        worldLetterAdapter.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.q0a
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                WorldLetterVM.m(this.f44095a, baseQuickAdapter, view, i);
            }
        });
        worldLetterAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.r0a
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                WorldLetterVM.n(this.f44337a);
            }
        });
        this.adapter.setValue(worldLetterAdapter);
        return worldLetterAdapter;
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        return this.isRefreshing;
    }

    public final void p() {
        int i = this.pageNum + 1;
        this.pageNum = i;
        q(i);
    }

    public final void q(int pageNum) {
        n76.e(this, this.messageModel.t(2, pageNum)).p5(new b());
    }

    public final void r(NoticeBean bean) {
        n76.e(this, this.messageModel.v(bean.getNoticeCode(), 2, 1)).p5(new c(bean, this));
    }

    public final void s(NoticeBean bean) {
        n76.e(this, this.messageModel.w(bean.getNoticeCode())).p5(new d(bean));
    }

    public final void t() {
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        q(1);
    }

    public final void u(@NotNull MutableLiveData<WorldLetterAdapter> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.adapter = mutableLiveData;
    }

    public final void v(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.isRefreshing = mutableLiveData;
    }

    public final void w(@NotNull MutableLiveData<BindingTitleBean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.titleBean = mutableLiveData;
    }
}
