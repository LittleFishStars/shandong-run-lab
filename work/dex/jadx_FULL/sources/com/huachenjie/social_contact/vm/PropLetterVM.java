package com.huachenjie.social_contact.vm;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.bean.GiftBean;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.social_contact.api.UniverseModel;
import com.huachenjie.social_contact.bean.NoticeBean;
import com.huachenjie.social_contact.dialog.ReceiveSysGiftDialog;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.n76;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\r\u001a\u0004\b\f\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/social_contact/vm/PropLetterVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "Lcom/huachenjie/social_contact/bean/NoticeBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "k", "Lcom/huachenjie/social_contact/api/UniverseModel;", "a", "Lcom/huachenjie/social_contact/api/UniverseModel;", "messageModel", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "n", "(Landroidx/lifecycle/MutableLiveData;)V", "title", y6b.g, t.d, "content", "", "m", "receiveType", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class PropLetterVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final UniverseModel messageModel = new UniverseModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<String> title = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<String> content = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<Boolean> receiveType = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/social_contact/vm/PropLetterVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NoticeBean f36334a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NoticeBean noticeBean) {
            super(PropLetterVM.this, true);
            this.f36334a = noticeBean;
        }

        public void onCCSuccess(@Nullable Object data) {
            this.f36334a.setReceiveType(true);
            PropLetterVM.this.i().setValue(Boolean.TRUE);
            ArrayList<GiftBean> arrayList = new ArrayList<>();
            arrayList.addAll(this.f36334a.getGiftList());
            PropLetterVM.this.g.setValue(ReceiveSysGiftDialog.INSTANCE.a(arrayList));
        }

        public void onFailed(int code, @Nullable String message) {
            super.onFailed(code, message);
        }
    }

    @NotNull
    public final MutableLiveData<String> h() {
        return this.content;
    }

    @NotNull
    public final MutableLiveData<Boolean> i() {
        return this.receiveType;
    }

    @NotNull
    public final MutableLiveData<String> j() {
        return this.title;
    }

    public final void k(@NotNull NoticeBean bean) {
        Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
        n76.e(this, this.messageModel.w(bean.getNoticeCode())).p5(new a(bean));
    }

    public final void l(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.content = mutableLiveData;
    }

    public final void m(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.receiveType = mutableLiveData;
    }

    public final void n(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.title = mutableLiveData;
    }
}
