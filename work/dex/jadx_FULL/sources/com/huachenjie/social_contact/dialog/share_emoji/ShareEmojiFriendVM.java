package com.huachenjie.social_contact.dialog.share_emoji;

import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.custom.ShareEmojiAttachment;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.api.UniverseModel;
import com.huachenjie.social_contact.bean.MirrorDimensionBean;
import com.huachenjie.social_contact.dialog.share_emoji.ShareEmojiFriendVM;
import com.kuaishou.weapon.p0.t;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.dj1;
import com.zj.adlib.fv5;
import com.zj.adlib.n76;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\n8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000eR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\n8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0014\u0010\u000eR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\n8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0016\u0010\u000eR\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\n8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/social_contact/dialog/share_emoji/ShareEmojiFriendVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "n", "Lcom/huachenjie/social_contact/api/UniverseModel;", "a", "Lcom/huachenjie/social_contact/api/UniverseModel;", j.b, "()Lcom/huachenjie/social_contact/api/UniverseModel;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/social_contact/dialog/share_emoji/ShareEmojiFriendAdapter;", "i", "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", "j", "k", "emojiBagCode", t.d, ShareEmojiFriendDialog.EMOJI_BAG_NAME, "m", ShareEmojiFriendDialog.EMOJI_URL, "", "closeDialog", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class ShareEmojiFriendVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final UniverseModel model = new UniverseModel();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ShareEmojiFriendAdapter> adapter;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> emojiBagCode;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> emojiBagName;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> emojiUrl;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> closeDialog;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/social_contact/dialog/share_emoji/ShareEmojiFriendVM$a", "Lcom/huachenjie/im/DefaultCallback;", "Lcom/netease/nimlib/sdk/msg/model/IMMessage;", "", "code", "result", "", c.f25231a, "", "a", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DefaultCallback<IMMessage> {
        public a() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int code, @Nullable IMMessage result, @Nullable Throwable exception) {
            ShareEmojiFriendVM.this.a();
            if (code == 200) {
                fv5.b("表情包分享成功");
            } else {
                fv5.b("表情包分享失败");
            }
            ShareEmojiFriendVM.this.j().setValue(Boolean.TRUE);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00040\u0001J$\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0014¨\u0006\b"}, d2 = {"com/huachenjie/social_contact/dialog/share_emoji/ShareEmojiFriendVM$b", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Ljava/util/ArrayList;", "Lcom/huachenjie/social_contact/bean/MirrorDimensionBean;", "Lkotlin/collections/ArrayList;", "data", "", "onCCSuccess", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nShareEmojiFriendVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShareEmojiFriendVM.kt\ncom/huachenjie/social_contact/dialog/share_emoji/ShareEmojiFriendVM$getFriendList$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,81:1\n766#2:82\n857#2,2:83\n*S KotlinDebug\n*F\n+ 1 ShareEmojiFriendVM.kt\ncom/huachenjie/social_contact/dialog/share_emoji/ShareEmojiFriendVM$getFriendList$1$1\n*L\n74#1:82\n74#1:83,2\n*E\n"})
    public static final class b extends BizSubscriber<ArrayList<MirrorDimensionBean>> {
        public b() {
            super(true);
        }

        public void onCCSuccess(@Nullable ArrayList<MirrorDimensionBean> data) {
            if (data != null) {
                ShareEmojiFriendVM shareEmojiFriendVM = ShareEmojiFriendVM.this;
                ArrayList arrayList = new ArrayList();
                for (Object obj : data) {
                    if (((MirrorDimensionBean) obj).getType() != 0) {
                        arrayList.add(obj);
                    }
                }
                ShareEmojiFriendAdapter value = shareEmojiFriendVM.i().getValue();
                if (value != null) {
                    value.setList(arrayList);
                }
            }
        }
    }

    public ShareEmojiFriendVM() {
        MutableLiveData<ShareEmojiFriendAdapter> mutableLiveData = new MutableLiveData<>();
        this.adapter = mutableLiveData;
        this.emojiBagCode = new MutableLiveData<>();
        this.emojiBagName = new MutableLiveData<>();
        this.emojiUrl = new MutableLiveData<>();
        this.closeDialog = new MutableLiveData<>();
        mutableLiveData.setValue(new ShareEmojiFriendAdapter());
        final ShareEmojiFriendAdapter value = mutableLiveData.getValue();
        if (value != null) {
            value.addChildClickViewIds(R.id.tv_share);
            value.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.u88
                @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    ShareEmojiFriendVM.p(this.f20005a, value, baseQuickAdapter, view, i);
                }
            });
        }
    }

    public static final void p(ShareEmojiFriendVM shareEmojiFriendVM, ShareEmojiFriendAdapter shareEmojiFriendAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(shareEmojiFriendVM, "this$0");
        Intrinsics.checkNotNullParameter(shareEmojiFriendAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        ShareEmojiAttachment shareEmojiAttachment = new ShareEmojiAttachment();
        String value = shareEmojiFriendVM.emojiBagCode.getValue();
        if (value == null) {
            value = "";
        }
        shareEmojiAttachment.setEmojiBagCode(value);
        String value2 = shareEmojiFriendVM.emojiBagName.getValue();
        if (value2 == null) {
            value2 = "";
        }
        shareEmojiAttachment.setEmojiBagName(value2);
        String value3 = shareEmojiFriendVM.emojiUrl.getValue();
        shareEmojiAttachment.setEmojiUrl(value3 != null ? value3 : "");
        dj1.P(shareEmojiAttachment, shareEmojiFriendAdapter.getData().get(i).getAccId(), shareEmojiFriendVM.new a());
    }

    @NotNull
    public final MutableLiveData<ShareEmojiFriendAdapter> i() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Boolean> j() {
        return this.closeDialog;
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.emojiBagCode;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.emojiBagName;
    }

    @NotNull
    public final MutableLiveData<String> m() {
        return this.emojiUrl;
    }

    public final void n() {
        if (this.adapter.getValue() != null) {
            n76.e(this, this.model.l()).p5(new b());
        }
    }

    @NotNull
    /* JADX INFO: renamed from: o, reason: from getter */
    public final UniverseModel getModel() {
        return this.model;
    }
}
