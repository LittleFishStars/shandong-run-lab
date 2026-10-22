package com.huachenjie.im.page;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemChildLongClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.base.bean.MoreOptBean;
import com.huachenjie.base.module_bridge.interfaces.CollegeMethodLoader;
import com.huachenjie.base.widget.MoreOptDialog;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.base.widget.dialog.OnSaveInputListener;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.dialog.AlertDialog;
import com.huachenjie.common.glide.SizeCallback;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.IIMModule;
import com.huachenjie.im.R;
import com.huachenjie.im.audio.ImAudioPlayCallback;
import com.huachenjie.im.bean.FriendUserInfo;
import com.huachenjie.im.custom.EmojiStickerAttachment;
import com.huachenjie.im.custom.GiftGivingAttachment;
import com.huachenjie.im.custom.MomentShareAttachment;
import com.huachenjie.im.custom.ShareChannelAttachment;
import com.huachenjie.im.custom.ShareCommodityAttachment;
import com.huachenjie.im.custom.ShareEmojiAttachment;
import com.huachenjie.im.custom.ShareGoodsAttachment;
import com.huachenjie.im.custom.ShareLinkAttachment;
import com.huachenjie.im.custom.ShareOrderAttachment;
import com.huachenjie.im.custom.ShareTopicAttachment;
import com.huachenjie.im.custom.ShareWorkAttachment;
import com.huachenjie.im.custom.StarAllianceAttachment;
import com.huachenjie.im.custom.TeamInvitationAttachment;
import com.huachenjie.im.databinding.FragmentSingleChatBinding;
import com.huachenjie.im.page.base.BaseChatFragment;
import com.huachenjie.im.page.base.InputPanelCallback;
import com.huachenjie.im.page.base.InputPanelFragment;
import com.huachenjie.im.vm.SingleChatVM;
import com.huachenjie.run.map.RouteOverlay;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.msg.MsgServiceObserve;
import com.netease.nimlib.sdk.msg.attachment.AudioAttachment;
import com.netease.nimlib.sdk.msg.attachment.ImageAttachment;
import com.netease.nimlib.sdk.msg.attachment.MsgAttachment;
import com.netease.nimlib.sdk.msg.constant.MsgTypeEnum;
import com.netease.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.ai9;
import com.zj.adlib.cd4;
import com.zj.adlib.dj1;
import com.zj.adlib.f64;
import com.zj.adlib.fe9;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.gm1;
import com.zj.adlib.i62;
import com.zj.adlib.k44;
import com.zj.adlib.ln1;
import com.zj.adlib.mu3;
import com.zj.adlib.n0a;
import com.zj.adlib.p44;
import com.zj.adlib.pn3;
import com.zj.adlib.su9;
import com.zj.adlib.yk0;
import com.zj.adlib.zj7;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class SingleChatFragment extends BaseChatFragment<SingleChatVM> implements OnItemChildClickListener {
    private RecyclerView mRecyclerView;
    private OperatePopupWindow operatePopupWindow;
    private final OperatePopupWindow.OnClickCallback operateCallback = new a();
    public String oppositeAccId = "";
    private final Observer<List<IMMessage>> messageObserver = new Observer<List<IMMessage>>() { // from class: com.huachenjie.im.page.SingleChatFragment.2
        public void onEvent(List<IMMessage> list) {
            if (list == null || list.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (IMMessage iMMessage : list) {
                if (iMMessage.getSessionType() == SessionTypeEnum.P2P) {
                    String fromAccount = iMMessage.getFromAccount();
                    if (fromAccount.equals(SingleChatFragment.this.oppositeAccId)) {
                        arrayList.add(((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).A(iMMessage));
                    } else if (((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).j.getValue() != null && ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).j.getValue().getAccid().equals(fromAccount)) {
                        arrayList.add(((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).B(iMMessage));
                    }
                }
            }
            ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).h().addData((Collection) arrayList);
            SingleChatFragment.this.smoothScrollToBottom();
        }
    };
    private final DefaultCallback sendCallback = new d();
    private final InputPanelCallback inputPanelCallback = new e();
    private int oppositeRoleType = 0;

    public class a implements OperatePopupWindow.OnClickCallback {

        /* JADX INFO: renamed from: com.huachenjie.im.page.SingleChatFragment$a$a, reason: collision with other inner class name */
        public class C0809a extends DefaultCallback {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ IMMessage f9895a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Object f9896a;

            public C0809a(IMMessage iMMessage, Object obj) {
                this.f9895a = iMMessage;
                this.f9896a = obj;
            }

            @Override // com.huachenjie.im.DefaultCallback
            public void onResult(int i, Object obj, Throwable th) {
                SingleChatFragment.this.dismissLoadingDialogs();
                if (i != 200) {
                    fv5.b("删除失败");
                } else {
                    f64.b().k(this.f9895a.getUuid());
                    ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).h().removeAt(((Integer) this.f9896a).intValue());
                }
            }
        }

        public a() {
        }

        @Override // com.huachenjie.base.widget.OperatePopupWindow.OnClickCallback
        public void a(View view, int i, Object obj) {
            if (view == null) {
                return;
            }
            if (i == 1001) {
                if (obj == null || !(obj instanceof Integer)) {
                    return;
                }
                IMMessage iMMessage = (IMMessage) ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).h().getData().get(((Integer) obj).intValue());
                SingleChatFragment.this.showLoadingDialog("正在删除中...", false);
                dj1.p(iMMessage, new C0809a(iMMessage, obj));
                return;
            }
            if (i == 1002 && obj != null && (obj instanceof Integer)) {
                IMMessage iMMessage2 = (IMMessage) ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).h().getData().get(((Integer) obj).intValue());
                if (iMMessage2.getMsgType().getValue() == MsgTypeEnum.text.getValue()) {
                    gm1.b(iMMessage2.getContent());
                    fv5.b("复制成功");
                }
            }
        }
    }

    public class b implements ImAudioPlayCallback {
        public b() {
        }

        @Override // com.huachenjie.im.audio.ImAudioPlayCallback
        public void a(String str) {
            ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).h().notifyItemChanged(((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).j(str));
        }

        @Override // com.huachenjie.im.audio.ImAudioPlayCallback
        public void b(String str) {
            ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).h().notifyItemChanged(((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).j(str));
        }
    }

    public class c implements Function2<MoreOptBean, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f34538a;

        public class a extends DefaultCallback<Void> {

            /* JADX INFO: renamed from: com.huachenjie.im.page.SingleChatFragment$c$a$a, reason: collision with other inner class name */
            public class C0810a extends DefaultCallback<Void> {
                public C0810a() {
                }

                @Override // com.huachenjie.im.DefaultCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResult(int i, @Nullable Void r2, @Nullable Throwable th) {
                    SingleChatFragment.this.getActivity().finish();
                }
            }

            public a() {
            }

            @Override // com.huachenjie.im.DefaultCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(int i, @Nullable Void r2, @Nullable Throwable th) {
                if (i == 200) {
                    dj1.q(SingleChatFragment.this.oppositeAccId, SessionTypeEnum.P2P, new C0810a());
                } else {
                    fv5.b("删除失败，请重试");
                }
            }
        }

        public class b implements OnSaveInputListener {

            public class a extends DefaultCallback<Void> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Dialog f34542a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ String f9899a;

                public a(String str, Dialog dialog) {
                    this.f9899a = str;
                    this.f34542a = dialog;
                }

                @Override // com.huachenjie.im.DefaultCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResult(int i, @Nullable Void r3, @Nullable Throwable th) {
                    if (i == 200) {
                        fv5.b("设置成功～");
                        p44.A(SingleChatFragment.this.oppositeAccId, this.f9899a);
                        pn3.f44021a.a(c.this.f34538a.getContext(), SingleChatFragment.this.oppositeAccId, this.f9899a);
                        FragmentActivity activity = SingleChatFragment.this.getActivity();
                        if (activity.isFinishing()) {
                            return;
                        }
                        if (activity instanceof SingleChatActivity) {
                            ((SingleChatActivity) activity).k0();
                        }
                    } else {
                        fv5.b("设置失败～");
                    }
                    this.f34542a.dismiss();
                }
            }

            public b() {
            }

            @Override // com.huachenjie.base.widget.dialog.OnSaveInputListener
            public void a(Dialog dialog, String str) {
                dj1.d0(SingleChatFragment.this.oppositeAccId, str, new a(str, dialog));
            }
        }

        /* JADX INFO: renamed from: com.huachenjie.im.page.SingleChatFragment$c$c, reason: collision with other inner class name */
        public class C0811c extends DefaultCallback<Void> {
            public C0811c() {
            }

            @Override // com.huachenjie.im.DefaultCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(int i, @Nullable Void r2, @Nullable Throwable th) {
                if (i == 200) {
                    fv5.b("已取消拉黑对方");
                } else {
                    fv5.b("取消失败，请重试");
                }
            }
        }

        public class d implements View.OnClickListener {

            public class a extends DefaultCallback<Void> {
                public a() {
                }

                @Override // com.huachenjie.im.DefaultCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResult(int i, @Nullable Void r2, @Nullable Throwable th) {
                    if (i == 200) {
                        fv5.b("已经拉黑对方");
                    } else {
                        fv5.b("拉黑失败，请重试");
                    }
                }
            }

            public d() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dj1.g(SingleChatFragment.this.oppositeAccId, new a());
            }
        }

        public c(View view) {
            this.f34538a = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(View view) {
            dj1.o(SingleChatFragment.this.oppositeAccId, new a());
        }

        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Unit invoke(MoreOptBean moreOptBean, Integer num) {
            String name = moreOptBean.getName();
            name.hashCode();
            switch (name) {
                case "关注":
                    n0a n0aVar = n0a.f43422a;
                    n0aVar.b(((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).q.getValue(), 6);
                    ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).p.setValue(Boolean.valueOf(n0aVar.l(((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).q.getValue(), true)));
                    break;
                case "已关注":
                    n0a n0aVar2 = n0a.f43422a;
                    n0aVar2.F(((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).q.getValue(), 6);
                    ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).p.setValue(Boolean.valueOf(n0aVar2.l(((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).q.getValue(), false)));
                    break;
                case "举报TA":
                    ARouter.getInstance().build(RoutePathConstants.SocialContact.d).withString(UserConstants.CHAT_PARAMS.g, ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).q.getValue()).withInt(UserConstants.CHAT_PARAMS.e, 1).navigation();
                    break;
                case "删除好友":
                    ft1.h(this.f34538a.getContext()).Q("你确定要删除该好友吗？").J(new View.OnClickListener() { // from class: com.zj.adlib.lh8
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f43067a.c(view);
                        }
                    }).Y();
                    break;
                case "取消拉黑":
                    dj1.K(SingleChatFragment.this.oppositeAccId, new C0811c());
                    break;
                case "拉黑TA":
                    ft1.h(this.f34538a.getContext()).Q("确定拉黑TA吗？拉黑成功后将不再收到TA的消息").J(new d()).Y();
                    break;
                case "设置备注":
                    ft1.w(this.f34538a.getContext(), "设置备注名", "", "请输入备注名", 10, new b());
                    break;
            }
            return null;
        }
    }

    public class d extends DefaultCallback<IMMessage> {
        public d() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, IMMessage iMMessage, Throwable th) {
            if (i != 200 || iMMessage == null) {
                fv5.b("发送失败");
            } else {
                ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).h().addData(iMMessage);
                SingleChatFragment.this.smoothScrollToBottom();
            }
        }
    }

    public class e implements InputPanelCallback {

        public class a implements SizeCallback {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ String f9900a;

            public a(String str) {
                this.f9900a = str;
            }

            @Override // com.huachenjie.common.glide.SizeCallback
            public void a(Size size) {
                EmojiStickerAttachment emojiStickerAttachment = new EmojiStickerAttachment();
                emojiStickerAttachment.setEmojiUrl(this.f9900a);
                emojiStickerAttachment.setWidth(size.getWidth());
                emojiStickerAttachment.setHeight(size.getHeight());
                SingleChatFragment singleChatFragment = SingleChatFragment.this;
                dj1.O(emojiStickerAttachment, singleChatFragment.oppositeAccId, singleChatFragment.sendCallback);
            }

            @Override // com.huachenjie.common.glide.SizeCallback
            public void onFailed() {
                fv5.b("发送失败");
            }
        }

        public e() {
        }

        @Override // com.huachenjie.im.page.base.InputPanelCallback
        public void a(String str) {
            if (SingleChatFragment.this.checkMutedBeforeSend()) {
                SingleChatFragment singleChatFragment = SingleChatFragment.this;
                dj1.S(str, singleChatFragment.oppositeAccId, singleChatFragment.sendCallback);
            }
        }

        @Override // com.huachenjie.im.page.base.InputPanelCallback
        public void d(String str) {
            if (SingleChatFragment.this.checkMutedBeforeSend()) {
                mu3.a(SingleChatFragment.this.getContext(), str, new a(str));
            }
        }

        @Override // com.huachenjie.im.page.base.InputPanelCallback
        public void e(File file, long j) {
            if (SingleChatFragment.this.checkMutedBeforeSend()) {
                SingleChatFragment singleChatFragment = SingleChatFragment.this;
                dj1.N(file, j, singleChatFragment.oppositeAccId, singleChatFragment.sendCallback);
            }
        }

        @Override // com.huachenjie.im.page.base.InputPanelCallback
        public void g(String str) {
            if (SingleChatFragment.this.checkMutedBeforeSend()) {
                SingleChatFragment singleChatFragment = SingleChatFragment.this;
                dj1.R(str, singleChatFragment.oppositeAccId, singleChatFragment.sendCallback);
            }
        }
    }

    public class f extends DefaultCallback<FriendUserInfo> {
        public f() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, @Nullable FriendUserInfo friendUserInfo, @Nullable Throwable th) {
            if (i != 200 || friendUserInfo == null) {
                ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).b.setAvatar("");
                ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).b.setAvatarFrameImgUrl("");
            } else {
                ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).b.setAvatar(friendUserInfo.getAvatar());
                ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).b.setAvatarFrameImgUrl(friendUserInfo.getAvatarFrameImgUrl());
            }
            if (friendUserInfo != null) {
                SingleChatFragment.this.updateTitle(friendUserInfo.formatNickName());
            }
        }
    }

    public class g implements androidx.p002lifecycle.Observer<String> {
        public g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(String str, View view) {
            ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).r(str, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(String str, View view) {
            ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).r(str, false);
        }

        @Override // androidx.p002lifecycle.Observer
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onChanged(final String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            AlertDialog.AlertDataBean alertDataBean = new AlertDialog.AlertDataBean();
            alertDataBean.setContent("同意加入他的队伍吗？");
            alertDataBean.setContentColor(-16777216);
            alertDataBean.setCancel("婉拒");
            alertDataBean.setConfirm("同意");
            alertDataBean.setConfirmColor(Color.parseColor(RouteOverlay.f12338c));
            AlertDialog.INSTANCE.c(alertDataBean, new View.OnClickListener() { // from class: com.zj.adlib.mh8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f43300a.c(str, view);
                }
            }, new View.OnClickListener() { // from class: com.zj.adlib.nh8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f43525a.d(str, view);
                }
            }).show(SingleChatFragment.this.getChildFragmentManager(), "AlertDialog");
            ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).m.setValue("");
        }
    }

    public class h implements androidx.p002lifecycle.Observer<String> {
        public h() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(String str, View view) {
            ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).p(str, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(String str, View view) {
            ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).p(str, false);
        }

        @Override // androidx.p002lifecycle.Observer
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onChanged(final String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            AlertDialog.AlertDataBean alertDataBean = new AlertDialog.AlertDataBean();
            alertDataBean.setContent("您愿意与好友结盟，一起解锁好友玩法吗？");
            alertDataBean.setContentColor(-16777216);
            alertDataBean.setCancel("婉拒");
            alertDataBean.setConfirm("同意");
            alertDataBean.setConfirmColor(Color.parseColor(RouteOverlay.f12338c));
            AlertDialog.INSTANCE.c(alertDataBean, new View.OnClickListener() { // from class: com.zj.adlib.oh8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f43752a.c(str, view);
                }
            }, new View.OnClickListener() { // from class: com.zj.adlib.ph8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f43981a.d(str, view);
                }
            }).show(SingleChatFragment.this.getChildFragmentManager(), "AlertDialog");
            ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).m.setValue("");
        }
    }

    public class i implements androidx.p002lifecycle.Observer<Boolean> {
        public i() {
        }

        @Override // androidx.p002lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            if (!bool.booleanValue() || SingleChatFragment.this.getActivity() == null) {
                return;
            }
            SingleChatFragment.this.getActivity().finish();
        }
    }

    public class j implements OnItemChildLongClickListener {
        public j() {
        }

        @Override // com.chad.library.adapter.base.listener.OnItemChildLongClickListener
        public boolean onItemChildLongClick(@NonNull BaseQuickAdapter baseQuickAdapter, @NonNull View view, int i) {
            if (view == null) {
                return false;
            }
            int id = view.getId();
            if (id == R.id.tvMessage) {
                SingleChatFragment.this.getPopupWindow().i(Integer.valueOf(i));
                SingleChatFragment.this.getPopupWindow().j(view, "delete", OperatePopupWindow.g);
                return true;
            }
            if (id != R.id.ivImage && id != R.id.gifImage && id != R.id.ll_audio_container) {
                return false;
            }
            SingleChatFragment.this.getPopupWindow().i(Integer.valueOf(i));
            SingleChatFragment.this.getPopupWindow().j(view, "delete");
            return true;
        }
    }

    public class k {
        public k() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit d(ShareOrderAttachment shareOrderAttachment) {
            SingleChatFragment singleChatFragment = SingleChatFragment.this;
            dj1.O(shareOrderAttachment, singleChatFragment.oppositeAccId, singleChatFragment.sendCallback);
            return null;
        }

        public void b(View view) {
            ShareGoodsAttachment value = ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).s.getValue();
            if (value == null) {
                fv5.b("商品不存在");
            } else {
                SingleChatFragment singleChatFragment = SingleChatFragment.this;
                dj1.O(value, singleChatFragment.oppositeAccId, singleChatFragment.sendCallback);
            }
        }

        public void c(View view) {
            IIMModule iIMModule = (IIMModule) cd4.a(IIMModule.class);
            if (iIMModule == null) {
                return;
            }
            String value = ((SingleChatVM) ((BaseVMFragment) SingleChatFragment.this).mState).r.getValue();
            if (value == null) {
                value = "";
            }
            iIMModule.a(SingleChatFragment.this.getChildFragmentManager(), value, new Function1() { // from class: com.zj.adlib.qh8
                public final Object invoke(Object obj) {
                    return this.f44210a.d((ShareOrderAttachment) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMutedBeforeSend() {
        if (this.isLoginMuted) {
            fv5.b("创建聊天失败，无法发送消息");
            return false;
        }
        if (this.isMuted) {
            fv5.b("您已被禁言，无法发送消息");
            return false;
        }
        if (!dj1.A(this.oppositeAccId)) {
            return true;
        }
        fv5.b("对方已被拉黑，无法发送消息");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OperatePopupWindow getPopupWindow() {
        if (this.operatePopupWindow == null) {
            OperatePopupWindow operatePopupWindow = new OperatePopupWindow(getContext(), ((BaseVM) ((SingleChatVM) ((BaseVMFragment) this).mState)).b.getValue().intValue());
            this.operatePopupWindow = operatePopupWindow;
            operatePopupWindow.h(this.operateCallback);
        }
        return this.operatePopupWindow;
    }

    private void initAdapter() {
        BaseQuickAdapter baseQuickAdapterH = ((SingleChatVM) ((BaseVMFragment) this).mState).h();
        int i2 = R.id.ivImage;
        int i3 = R.id.ll_audio_container;
        baseQuickAdapterH.addChildClickViewIds(R.id.ll_share_link, R.id.ivAvatar, R.id.rlGiftItem, i2, i3, R.id.llInvitationItem, R.id.starAlliance, R.id.emojiItem, R.id.fl_share_moment_image, R.id.l_share_moment_audio, R.id.fl_share_moment_video, R.id.cl_share_works, R.id.cl_share_channel, R.id.cl_share_topic, R.id.ll_share_commodity, R.id.ll_current_goods, R.id.ll_share_order);
        baseQuickAdapterH.setOnItemChildClickListener(this);
        baseQuickAdapterH.addChildLongClickViewIds(R.id.tvMessage, R.id.gifImage, i2, i3);
        baseQuickAdapterH.setOnItemChildLongClickListener(new j());
    }

    private void initInputPanel() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        InputPanelFragment inputPanelFragment = new InputPanelFragment();
        inputPanelFragment.setInputCallback(this.inputPanelCallback);
        fragmentTransactionBeginTransaction.add(R.id.input_panel_container, inputPanelFragment, InputPanelFragment.class.getName());
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        childFragmentManager.executePendingTransactions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initDataAfterView$0(View view) {
        hideInputForce();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initDataAfterView$1(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        hideInputForce();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTitle(String str) {
        FragmentActivity activity = getActivity();
        if (activity instanceof SingleChatActivity) {
            ((SingleChatActivity) activity).updateTitle(str);
        }
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment
    public void afterLoginSuccess() {
        dj1.z(this.oppositeAccId, new f());
        dj1.Z(this.oppositeAccId);
        if (((SingleChatVM) ((BaseVMFragment) this).mState).j.getValue() != null) {
            ((SingleChatVM) ((BaseVMFragment) this).mState).t().e(((SingleChatVM) ((BaseVMFragment) this).mState).j.getValue().getAccid());
        }
        ((SingleChatVM) ((BaseVMFragment) this).mState).z(this.oppositeAccId);
        ((SingleChatVM) ((BaseVMFragment) this).mState).y();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.fragment_single_chat), Integer.valueOf(yk0.L), ((BaseVMFragment) this).mState).a(Integer.valueOf(yk0.k), new k());
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment
    public void handleArguments(Bundle bundle) {
        if (bundle != null) {
            this.oppositeAccId = bundle.getString(UserConstants.CHAT_PARAMS.f33725a);
            this.oppositeRoleType = bundle.getInt(UserConstants.CHAT_PARAMS.b);
            CommonUserInfo commonUserInfoE = ai9.e();
            ((SingleChatVM) ((BaseVMFragment) this).mState).f34593a.setAvatar(commonUserInfoE.getAvatar());
            ((SingleChatVM) ((BaseVMFragment) this).mState).f34593a.setAvatarFrameImgUrl(commonUserInfoE.getAvatarFrameImgUrl());
            ((SingleChatVM) ((BaseVMFragment) this).mState).k.setValue(this.oppositeAccId);
            if (getActivity() == null || getActivity().getIntent() == null) {
                return;
            }
            Intent intent = getActivity().getIntent();
            ((SingleChatVM) ((BaseVMFragment) this).mState).r.setValue(intent.getStringExtra(UserConstants.CHAT_PARAMS.c));
            ((SingleChatVM) ((BaseVMFragment) this).mState).s.setValue((ShareGoodsAttachment) intent.getParcelableExtra(UserConstants.CHAT_PARAMS.d));
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initDataAfterView() {
        if (getBinding() != null && (getBinding() instanceof FragmentSingleChatBinding)) {
            this.mRecyclerView = ((FragmentSingleChatBinding) getBinding()).f9743a;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setStackFromEnd(true);
            this.mRecyclerView.setLayoutManager(linearLayoutManager);
            this.mRecyclerView.setAdapter(((SingleChatVM) ((BaseVMFragment) this).mState).h());
            this.mRecyclerView.setOverScrollMode(2);
            initAdapter();
            ((FragmentSingleChatBinding) getBinding()).f34439a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.jh8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f42586a.lambda$initDataAfterView$0(view);
                }
            });
            ((SingleChatVM) ((BaseVMFragment) this).mState).h().setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.kh8
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                    this.f42820a.lambda$initDataAfterView$1(baseQuickAdapter, view, i2);
                }
            });
        }
        initInputPanel();
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment
    public void observeDataChange() {
        ((SingleChatVM) ((BaseVMFragment) this).mState).m.observe(this, new g());
        ((SingleChatVM) ((BaseVMFragment) this).mState).o.observe(this, new h());
        ((SingleChatVM) ((BaseVMFragment) this).mState).h.observe(this, new i());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (getActivity() != null && getActivity().getWindow() != null) {
            getActivity().getWindow().setSoftInputMode(32);
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment, com.huachenjie.common.base.data_binding.BaseVMFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        f64.b().a();
        dj1.j();
        super.onDestroyView();
    }

    @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
    public void onItemChildClick(@NonNull BaseQuickAdapter<?, ?> baseQuickAdapter, @NonNull View view, int i2) {
        IMMessage iMMessage;
        MsgAttachment attachment;
        MsgAttachment attachment2;
        MsgAttachment attachment3;
        AudioAttachment attachment4;
        ImageAttachment attachment5;
        MsgAttachment attachment6;
        try {
            iMMessage = (IMMessage) baseQuickAdapter.getData().get(i2);
        } catch (Exception unused) {
            iMMessage = null;
        }
        if (iMMessage == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.ll_share_link) {
            MsgAttachment attachment7 = iMMessage.getAttachment();
            if (attachment7 == null || !(attachment7 instanceof ShareLinkAttachment)) {
                return;
            }
            ShareLinkAttachment shareLinkAttachment = (ShareLinkAttachment) attachment7;
            if (!shareLinkAttachment.getLink().contains("moxigame.cn")) {
                su9.v(getContext(), shareLinkAttachment.getLink());
                return;
            }
            CollegeMethodLoader collegeMethodLoaderB = ln1.a().b();
            if (collegeMethodLoaderB != null) {
                collegeMethodLoaderB.a(getContext(), shareLinkAttachment.getLink());
                return;
            }
            return;
        }
        if (id == R.id.ivAvatar) {
            if (16 == iMMessage.getFromClientType()) {
                return;
            }
            String fromAccount = iMMessage.getFromAccount();
            if (((SingleChatVM) ((BaseVMFragment) this).mState).j.getValue().getAccid().equals(fromAccount)) {
                return;
            }
            ((SingleChatVM) ((BaseVMFragment) this).mState).k(fromAccount);
            return;
        }
        if (view.getId() == R.id.rlGiftItem) {
            if (((SingleChatVM) ((BaseVMFragment) this).mState).j.getValue().getAccid().equals(iMMessage.getFromAccount()) || (attachment6 = iMMessage.getAttachment()) == null || !(attachment6 instanceof GiftGivingAttachment)) {
                return;
            }
            ((SingleChatVM) ((BaseVMFragment) this).mState).q(((GiftGivingAttachment) attachment6).getSendFriendCode());
            return;
        }
        if (view.getId() == R.id.ivImage) {
            if (iMMessage.getMsgType().getValue() == MsgTypeEnum.image.getValue() && (attachment5 = iMMessage.getAttachment()) != null && (attachment5 instanceof ImageAttachment)) {
                PicturePreviewUtil.i(view, attachment5.getUrl());
                return;
            }
            return;
        }
        if (view.getId() == R.id.ll_audio_container) {
            if (iMMessage.getMsgType().getValue() == MsgTypeEnum.audio.getValue() && (attachment4 = iMMessage.getAttachment()) != null && (attachment4 instanceof AudioAttachment)) {
                f64.b().i(getContext(), attachment4.getUrl(), iMMessage.getUuid(), new b());
                return;
            }
            return;
        }
        if (view.getId() == R.id.llInvitationItem) {
            if (((SingleChatVM) ((BaseVMFragment) this).mState).j.getValue().getAccid().equals(iMMessage.getFromAccount()) || (attachment3 = iMMessage.getAttachment()) == null || !(attachment3 instanceof TeamInvitationAttachment)) {
                return;
            }
            ((SingleChatVM) ((BaseVMFragment) this).mState).w(((TeamInvitationAttachment) attachment3).getInviteRecordCode());
            return;
        }
        if (view.getId() == R.id.starAlliance) {
            if (((SingleChatVM) ((BaseVMFragment) this).mState).j.getValue().getAccid().equals(iMMessage.getFromAccount()) || (attachment2 = iMMessage.getAttachment()) == null || !(attachment2 instanceof StarAllianceAttachment)) {
                return;
            }
            ((SingleChatVM) ((BaseVMFragment) this).mState).v(((StarAllianceAttachment) attachment2).getInviteCode());
            return;
        }
        if (view.getId() == R.id.emojiItem) {
            MsgAttachment attachment8 = iMMessage.getAttachment();
            if (attachment8 == null || !(attachment8 instanceof ShareEmojiAttachment)) {
                return;
            }
            ((SingleChatVM) ((BaseVMFragment) this).mState).s(((ShareEmojiAttachment) attachment8).getEmojiBagCode());
            return;
        }
        if (view.getId() == R.id.fl_share_moment_image || view.getId() == R.id.l_share_moment_audio || view.getId() == R.id.fl_share_moment_video) {
            MsgAttachment attachment9 = iMMessage.getAttachment();
            if (attachment9 == null || !(attachment9 instanceof MomentShareAttachment)) {
                return;
            }
            fv5.b("时刻作品已下架");
            return;
        }
        if (id == R.id.cl_share_works) {
            MsgAttachment attachment10 = iMMessage.getAttachment();
            if (attachment10 == null || !(attachment10 instanceof ShareWorkAttachment)) {
                return;
            }
            ((SingleChatVM) ((BaseVMFragment) this).mState).o(((ShareWorkAttachment) attachment10).getWorksNo());
            return;
        }
        if (id == R.id.cl_share_channel) {
            MsgAttachment attachment11 = iMMessage.getAttachment();
            if (attachment11 == null || !(attachment11 instanceof ShareChannelAttachment)) {
                return;
            }
            ((SingleChatVM) ((BaseVMFragment) this).mState).m(((ShareChannelAttachment) attachment11).getChannelNo());
            return;
        }
        if (id == R.id.cl_share_topic) {
            MsgAttachment attachment12 = iMMessage.getAttachment();
            if (attachment12 == null || !(attachment12 instanceof ShareTopicAttachment)) {
                return;
            }
            ((SingleChatVM) ((BaseVMFragment) this).mState).n(((ShareTopicAttachment) attachment12).getSubjectNo());
            return;
        }
        if (id == R.id.ll_share_commodity) {
            MsgAttachment attachment13 = iMMessage.getAttachment();
            if (attachment13 == null || !(attachment13 instanceof ShareCommodityAttachment)) {
                return;
            }
            ShareCommodityAttachment shareCommodityAttachment = (ShareCommodityAttachment) attachment13;
            ARouter.getInstance().build(zj7.g.GOOD_DETAIL).withString("goodsNo", shareCommodityAttachment.getGoodsNo()).withString("source", "11").withString("traceNo", shareCommodityAttachment.getTraceNo()).navigation();
            return;
        }
        if (id == R.id.ll_current_goods) {
            MsgAttachment attachment14 = iMMessage.getAttachment();
            if (attachment14 == null || !(attachment14 instanceof ShareGoodsAttachment)) {
                return;
            }
            ARouter.getInstance().build(zj7.g.GOOD_DETAIL).withString("goodsNo", ((ShareGoodsAttachment) attachment14).getGoodsNo()).navigation();
            return;
        }
        if (id == R.id.ll_share_order && (attachment = iMMessage.getAttachment()) != null && (attachment instanceof ShareOrderAttachment)) {
            ARouter.getInstance().build(zj7.g.ORDER_DETAIL).withString("orderNo", ((ShareOrderAttachment) attachment).getOrderNo()).navigation();
        }
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment
    public void registerMessageChange() {
        MsgServiceObserve msgServiceObserve = (MsgServiceObserve) k44.a(MsgServiceObserve.class);
        if (msgServiceObserve != null) {
            msgServiceObserve.observeReceiveMessage(this.messageObserver, true);
        }
    }

    public void smoothScrollToBottom() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.smoothScrollToPosition(((SingleChatVM) ((BaseVMFragment) this).mState).h().getItemCount());
    }

    public void startReportUser(View view) {
        Q q = ((BaseVMFragment) this).mState;
        if (q == 0) {
            fv5.b("正在初始化");
            return;
        }
        if (((SingleChatVM) q).q.getValue() == null) {
            fv5.b("正在初始化数据");
            return;
        }
        ArrayList<MoreOptBean> arrayList = new ArrayList<>();
        if (Boolean.TRUE.equals(((SingleChatVM) ((BaseVMFragment) this).mState).p.getValue())) {
            arrayList.add(new MoreOptBean("已关注", R.drawable.ic_pop_following, 2));
        } else {
            arrayList.add(new MoreOptBean(fe9.a.ATTENTION, R.drawable.ic_pop_focus_on, 1));
        }
        if (dj1.i(this.oppositeAccId)) {
            arrayList.add(new MoreOptBean("删除好友", R.drawable.ic_pop_delete_friend, 3));
            arrayList.add(new MoreOptBean("设置备注", R.drawable.ic_pop_remark, 3));
        }
        arrayList.add(new MoreOptBean("举报TA", R.drawable.ic_pop_report, 3));
        if (dj1.A(this.oppositeAccId)) {
            arrayList.add(new MoreOptBean("取消拉黑", R.drawable.ic_pop_add_black_list, 3));
        } else {
            arrayList.add(new MoreOptBean("拉黑TA", R.drawable.ic_pop_add_black_list, 3));
        }
        MoreOptDialog.INSTANCE.a(arrayList, new c(view)).show(getChildFragmentManager(), MoreOptDialog.class.getSimpleName());
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment
    public void unregisterMessageChange() {
        MsgServiceObserve msgServiceObserve = (MsgServiceObserve) k44.a(MsgServiceObserve.class);
        if (msgServiceObserve != null) {
            msgServiceObserve.observeReceiveMessage(this.messageObserver, false);
        }
    }
}
