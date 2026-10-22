package com.huachenjie.im.page;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemChildLongClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.base.util.MaskUtil;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.common.glide.SizeCallback;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.huachenjie.im.R;
import com.huachenjie.im.RoomChatHelper;
import com.huachenjie.im.adapter.SignalTowerAdapter;
import com.huachenjie.im.audio.ImAudioPlayCallback;
import com.huachenjie.im.custom.EmojiStickerAttachment;
import com.huachenjie.im.databinding.FragmentSignalTowerBinding;
import com.huachenjie.im.page.base.BaseSignalTowerFragment;
import com.huachenjie.im.page.base.InputPanelCallback;
import com.huachenjie.im.page.base.InputPanelFragment;
import com.huachenjie.im.vm.SignalTowerVM;
import com.netease.nimlib.sdk.chatroom.model.ChatRoomMessage;
import com.netease.nimlib.sdk.msg.attachment.AudioAttachment;
import com.netease.nimlib.sdk.msg.attachment.ImageAttachment;
import com.netease.nimlib.sdk.msg.constant.MsgTypeEnum;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.dj1;
import com.zj.adlib.f64;
import com.zj.adlib.fv5;
import com.zj.adlib.gm1;
import com.zj.adlib.i62;
import com.zj.adlib.mu3;
import com.zj.adlib.r90;
import com.zj.adlib.yk0;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class SignalTowerFragment extends BaseSignalTowerFragment<SignalTowerVM> {
    private TextView bottomTabOvert;
    private TextView bottomTabTeam;
    private OperatePopupWindow operatePopupWindow;
    private final int bottomTabSelectedColor = Color.parseColor("#2C3E50");
    private final int bottomTabUnselectedColor = Color.parseColor("#8997A4");
    private final InputPanelCallback inputPanelCallback = new a();
    private final long lastTimeSendTime = 0;
    private final long lastSendTime = 0;
    private final long lastNationwideSendTime = 0;
    private final OnItemChildClickListener itemClickListener = new b();
    private final OperatePopupWindow.OnClickCallback operateCallback = new c();
    private final OnItemChildLongClickListener itemLongClickListener = new d();

    public class a implements InputPanelCallback {

        /* JADX INFO: renamed from: com.huachenjie.im.page.SignalTowerFragment$a$a, reason: collision with other inner class name */
        public class C0808a implements SizeCallback {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ String f9893a;

            public C0808a(String str) {
                this.f9893a = str;
            }

            @Override // com.huachenjie.common.glide.SizeCallback
            public void a(Size size) {
                EmojiStickerAttachment emojiStickerAttachment = new EmojiStickerAttachment();
                emojiStickerAttachment.setEmojiUrl(this.f9893a);
                emojiStickerAttachment.setWidth(size.getWidth());
                emojiStickerAttachment.setHeight(size.getHeight());
                if (((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).m.getValue().intValue() == 0) {
                    if (SignalTowerFragment.this.checkTeamSend()) {
                        RoomChatHelper roomChatHelperK = RoomChatHelper.k();
                        SignalTowerFragment signalTowerFragment = SignalTowerFragment.this;
                        roomChatHelperK.q(emojiStickerAttachment, signalTowerFragment.teamId, ((SignalTowerVM) ((BaseVMFragment) signalTowerFragment).mState).p.getValue());
                        return;
                    }
                    return;
                }
                if (((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).m.getValue().intValue() == 1) {
                    if (((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).n.getValue().intValue() == 0) {
                        if (SignalTowerFragment.this.checkOvertSend()) {
                            RoomChatHelper roomChatHelperK2 = RoomChatHelper.k();
                            SignalTowerFragment signalTowerFragment2 = SignalTowerFragment.this;
                            roomChatHelperK2.q(emojiStickerAttachment, signalTowerFragment2.overtId, ((SignalTowerVM) ((BaseVMFragment) signalTowerFragment2).mState).p.getValue());
                            return;
                        }
                        return;
                    }
                    if (((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).n.getValue().intValue() == 1 && SignalTowerFragment.this.checkNationwideSend()) {
                        RoomChatHelper roomChatHelperK3 = RoomChatHelper.k();
                        SignalTowerFragment signalTowerFragment3 = SignalTowerFragment.this;
                        roomChatHelperK3.q(emojiStickerAttachment, signalTowerFragment3.nationwideId, ((SignalTowerVM) ((BaseVMFragment) signalTowerFragment3).mState).p.getValue());
                    }
                }
            }

            @Override // com.huachenjie.common.glide.SizeCallback
            public void onFailed() {
                fv5.b("发送失败");
            }
        }

        public a() {
        }

        @Override // com.huachenjie.im.page.base.InputPanelCallback
        public void a(String str) {
            if (((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).m.getValue().intValue() == 0) {
                if (SignalTowerFragment.this.checkTeamSend()) {
                    RoomChatHelper roomChatHelperK = RoomChatHelper.k();
                    SignalTowerFragment signalTowerFragment = SignalTowerFragment.this;
                    roomChatHelperK.t(str, signalTowerFragment.teamId, ((SignalTowerVM) ((BaseVMFragment) signalTowerFragment).mState).p.getValue());
                    return;
                }
                return;
            }
            if (((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).m.getValue().intValue() == 1) {
                if (((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).n.getValue().intValue() == 0) {
                    if (SignalTowerFragment.this.checkOvertSend()) {
                        RoomChatHelper roomChatHelperK2 = RoomChatHelper.k();
                        SignalTowerFragment signalTowerFragment2 = SignalTowerFragment.this;
                        roomChatHelperK2.t(str, signalTowerFragment2.overtId, ((SignalTowerVM) ((BaseVMFragment) signalTowerFragment2).mState).p.getValue());
                        return;
                    }
                    return;
                }
                if (((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).n.getValue().intValue() == 1 && SignalTowerFragment.this.checkNationwideSend()) {
                    RoomChatHelper roomChatHelperK3 = RoomChatHelper.k();
                    SignalTowerFragment signalTowerFragment3 = SignalTowerFragment.this;
                    roomChatHelperK3.t(str, signalTowerFragment3.nationwideId, ((SignalTowerVM) ((BaseVMFragment) signalTowerFragment3).mState).p.getValue());
                }
            }
        }

        @Override // com.huachenjie.im.page.base.InputPanelCallback
        public void d(String str) {
            mu3.a(SignalTowerFragment.this.getContext(), str, new C0808a(str));
        }

        @Override // com.huachenjie.im.page.base.InputPanelCallback
        public void e(File file, long j) {
            if (((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).m.getValue().intValue() == 0) {
                if (file == null || !SignalTowerFragment.this.checkTeamSend()) {
                    return;
                }
                RoomChatHelper roomChatHelperK = RoomChatHelper.k();
                SignalTowerFragment signalTowerFragment = SignalTowerFragment.this;
                roomChatHelperK.r(file, j, signalTowerFragment.teamId, ((SignalTowerVM) ((BaseVMFragment) signalTowerFragment).mState).p.getValue());
                return;
            }
            if (((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).m.getValue().intValue() != 1 || file == null) {
                return;
            }
            if (((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).n.getValue().intValue() == 0) {
                if (SignalTowerFragment.this.checkOvertSend()) {
                    RoomChatHelper roomChatHelperK2 = RoomChatHelper.k();
                    SignalTowerFragment signalTowerFragment2 = SignalTowerFragment.this;
                    roomChatHelperK2.r(file, j, signalTowerFragment2.overtId, ((SignalTowerVM) ((BaseVMFragment) signalTowerFragment2).mState).p.getValue());
                    return;
                }
                return;
            }
            if (((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).n.getValue().intValue() == 1 && SignalTowerFragment.this.checkNationwideSend()) {
                RoomChatHelper roomChatHelperK3 = RoomChatHelper.k();
                SignalTowerFragment signalTowerFragment3 = SignalTowerFragment.this;
                roomChatHelperK3.r(file, j, signalTowerFragment3.nationwideId, ((SignalTowerVM) ((BaseVMFragment) signalTowerFragment3).mState).p.getValue());
            }
        }

        @Override // com.huachenjie.im.page.base.InputPanelCallback
        public void g(String str) {
            if (((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).m.getValue().intValue() == 0) {
                if (SignalTowerFragment.this.checkTeamSend()) {
                    RoomChatHelper roomChatHelperK = RoomChatHelper.k();
                    SignalTowerFragment signalTowerFragment = SignalTowerFragment.this;
                    roomChatHelperK.s(str, signalTowerFragment.teamId, ((SignalTowerVM) ((BaseVMFragment) signalTowerFragment).mState).p.getValue());
                    return;
                }
                return;
            }
            if (((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).m.getValue().intValue() == 1) {
                if (((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).n.getValue().intValue() == 0) {
                    if (SignalTowerFragment.this.checkOvertSend()) {
                        RoomChatHelper roomChatHelperK2 = RoomChatHelper.k();
                        SignalTowerFragment signalTowerFragment2 = SignalTowerFragment.this;
                        roomChatHelperK2.s(str, signalTowerFragment2.overtId, ((SignalTowerVM) ((BaseVMFragment) signalTowerFragment2).mState).p.getValue());
                        return;
                    }
                    return;
                }
                if (((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).n.getValue().intValue() == 1 && SignalTowerFragment.this.checkNationwideSend()) {
                    RoomChatHelper roomChatHelperK3 = RoomChatHelper.k();
                    SignalTowerFragment signalTowerFragment3 = SignalTowerFragment.this;
                    roomChatHelperK3.s(str, signalTowerFragment3.nationwideId, ((SignalTowerVM) ((BaseVMFragment) signalTowerFragment3).mState).p.getValue());
                }
            }
        }
    }

    public class b implements OnItemChildClickListener {

        public class a implements ImAudioPlayCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BaseQuickAdapter f34528a;

            public a(BaseQuickAdapter baseQuickAdapter) {
                this.f34528a = baseQuickAdapter;
            }

            @Override // com.huachenjie.im.audio.ImAudioPlayCallback
            public void a(String str) {
                this.f34528a.notifyItemChanged(((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).i(this.f34528a, str));
            }

            @Override // com.huachenjie.im.audio.ImAudioPlayCallback
            public void b(String str) {
                this.f34528a.notifyItemChanged(((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).i(this.f34528a, str));
            }
        }

        public b() {
        }

        @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
        public void onItemChildClick(@NonNull BaseQuickAdapter<?, ?> baseQuickAdapter, @NonNull View view, int i) {
            ChatRoomMessage chatRoomMessage;
            int iX;
            AudioAttachment attachment;
            ImageAttachment attachment2;
            try {
                chatRoomMessage = (ChatRoomMessage) baseQuickAdapter.getData().get(i);
            } catch (Exception unused) {
                chatRoomMessage = null;
            }
            if (chatRoomMessage == null || 16 == chatRoomMessage.getFromClientType() || (iX = dj1.x(chatRoomMessage)) == 1 || iX == 2) {
                return;
            }
            if (view.getId() == R.id.ivAvatar) {
                String fromAccount = chatRoomMessage.getFromAccount();
                if (((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).j.getValue().getAccid().equals(fromAccount)) {
                    return;
                }
                ((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).k(fromAccount);
                return;
            }
            if (view.getId() == R.id.ivImage) {
                if (chatRoomMessage.getMsgType().getValue() == MsgTypeEnum.image.getValue() && (attachment2 = chatRoomMessage.getAttachment()) != null && (attachment2 instanceof ImageAttachment)) {
                    PicturePreviewUtil.i(view, attachment2.getUrl());
                    return;
                }
                return;
            }
            if (view.getId() == R.id.ll_audio_container && chatRoomMessage.getMsgType().getValue() == MsgTypeEnum.audio.getValue() && (attachment = chatRoomMessage.getAttachment()) != null && (attachment instanceof AudioAttachment)) {
                f64.b().i(SignalTowerFragment.this.getContext(), attachment.getUrl(), chatRoomMessage.getUuid(), new a(baseQuickAdapter));
            }
        }
    }

    public class c implements OperatePopupWindow.OnClickCallback {
        public c() {
        }

        @Override // com.huachenjie.base.widget.OperatePopupWindow.OnClickCallback
        public void a(View view, int i, Object obj) {
            if (view == null || SignalTowerFragment.this.getCurrentAdapter() == null || i == 1001 || i != 1002 || obj == null || !(obj instanceof Integer)) {
                return;
            }
            IMMessage iMMessage = (IMMessage) SignalTowerFragment.this.getCurrentAdapter().getData().get(((Integer) obj).intValue());
            if (iMMessage.getMsgType().getValue() == MsgTypeEnum.text.getValue()) {
                gm1.b(iMMessage.getContent());
                fv5.b("复制成功");
            }
        }
    }

    public class d implements OnItemChildLongClickListener {
        public d() {
        }

        @Override // com.chad.library.adapter.base.listener.OnItemChildLongClickListener
        public boolean onItemChildLongClick(@NonNull BaseQuickAdapter baseQuickAdapter, @NonNull View view, int i) {
            if (view == null || view.getId() != R.id.tvMessage) {
                return false;
            }
            SignalTowerFragment.this.getPopupWindow().i(Integer.valueOf(i));
            SignalTowerFragment.this.getPopupWindow().j(view, OperatePopupWindow.g);
            return true;
        }
    }

    public class e implements Observer<Integer> {
        public e() {
        }

        @Override // androidx.p002lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            if (num != null && SignalTowerFragment.this.showType == 2) {
                if (num.intValue() == 0) {
                    if (SignalTowerFragment.this.bottomTabTeam != null) {
                        SignalTowerFragment.this.bottomTabTeam.setTextColor(SignalTowerFragment.this.bottomTabSelectedColor);
                    }
                    if (SignalTowerFragment.this.bottomTabOvert != null) {
                        SignalTowerFragment.this.bottomTabOvert.setTextColor(SignalTowerFragment.this.bottomTabUnselectedColor);
                    }
                    if (!SignalTowerFragment.this.hideNationwide.booleanValue()) {
                        ((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).o.setValue(Boolean.TRUE);
                    }
                } else if (num.intValue() == 1) {
                    if (SignalTowerFragment.this.bottomTabTeam != null) {
                        SignalTowerFragment.this.bottomTabTeam.setTextColor(SignalTowerFragment.this.bottomTabUnselectedColor);
                    }
                    if (SignalTowerFragment.this.bottomTabOvert != null) {
                        SignalTowerFragment.this.bottomTabOvert.setTextColor(SignalTowerFragment.this.bottomTabSelectedColor);
                    }
                    if (!SignalTowerFragment.this.hideNationwide.booleanValue()) {
                        ((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).o.setValue(Boolean.FALSE);
                    }
                }
                SignalTowerFragment.this.saveTabStatus();
            }
        }
    }

    public class f implements Observer<Integer> {
        public f() {
        }

        @Override // androidx.p002lifecycle.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            SignalTowerFragment.this.saveTabStatus();
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.bottomTabTeam) {
                ((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).m.setValue(0);
            } else if (id == R.id.bottomTabOvert) {
                ((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).m.setValue(1);
                SignalTowerFragment.this.checkMask();
            }
        }
    }

    public class h {
        public h() {
        }

        public void a(View view) {
            Integer value = ((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).n.getValue();
            if (value == null || value.intValue() == 0) {
                if (TextUtils.isEmpty(SignalTowerFragment.this.nationwideId)) {
                    fv5.b("全国频道已关闭，请稍后再试");
                    return;
                } else {
                    fv5.b("您已切换至全国频道");
                    ((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).n.setValue(1);
                    return;
                }
            }
            if (TextUtils.isEmpty(SignalTowerFragment.this.overtId)) {
                fv5.b("本校频道已关闭，请稍后再试");
            } else {
                fv5.b("您已切换至本校频道");
                ((SignalTowerVM) ((BaseVMFragment) SignalTowerFragment.this).mState).n.setValue(0);
            }
        }

        public void b(View view) {
            SignalTowerFragment.this.getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkMask() {
        if (!r90.A().booleanValue() || this.hideNationwide.booleanValue() || getBinding() == null || !(getBinding() instanceof FragmentSignalTowerBinding)) {
            return;
        }
        FragmentSignalTowerBinding fragmentSignalTowerBinding = (FragmentSignalTowerBinding) getBinding();
        if (((SignalTowerVM) ((BaseVMFragment) this).mState).m.getValue().intValue() != 1) {
            return;
        }
        MaskUtil.g(getActivity(), fragmentSignalTowerBinding.c, R.layout.mask_signal_tower, new View.OnClickListener() { // from class: com.zj.adlib.cc8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r90.e0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkNationwideSend() {
        if (this.isLoginMuted) {
            fv5.b("进入群聊失败，无法发送消息");
            return false;
        }
        if (this.isMuted) {
            fv5.b("您已被禁言，无法发送消息");
            return false;
        }
        if (((SignalTowerVM) ((BaseVMFragment) this).mState).p.getValue() != null) {
            return true;
        }
        fv5.b("用户信息获取失败，无法发送消息");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkOvertSend() {
        if (this.isLoginMuted) {
            fv5.b("进入群聊失败，无法发送消息");
            return false;
        }
        if (this.isMuted) {
            fv5.b("您已被禁言，无法发送消息");
            return false;
        }
        if (((SignalTowerVM) ((BaseVMFragment) this).mState).p.getValue() != null) {
            return true;
        }
        fv5.b("用户信息获取失败，无法发送消息");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkTeamSend() {
        if (this.isLoginMuted) {
            fv5.b("进入群聊失败，无法发送消息");
            return false;
        }
        if (((SignalTowerVM) ((BaseVMFragment) this).mState).p.getValue() != null) {
            return true;
        }
        fv5.b("用户信息获取失败，无法发送消息");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseQuickAdapter getCurrentAdapter() {
        if (((SignalTowerVM) ((BaseVMFragment) this).mState).m.getValue().intValue() == 0) {
            return this.mTeamAdapter;
        }
        if (((SignalTowerVM) ((BaseVMFragment) this).mState).m.getValue().intValue() != 1) {
            return null;
        }
        if (((SignalTowerVM) ((BaseVMFragment) this).mState).n.getValue().intValue() == 0) {
            return this.mOvertAdapter;
        }
        if (((SignalTowerVM) ((BaseVMFragment) this).mState).n.getValue().intValue() == 1) {
            return this.mNationwideAdapter;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OperatePopupWindow getPopupWindow() {
        if (this.operatePopupWindow == null) {
            OperatePopupWindow operatePopupWindow = new OperatePopupWindow(getContext(), ((SignalTowerVM) ((BaseVMFragment) this).mState).b.getValue().intValue());
            this.operatePopupWindow = operatePopupWindow;
            operatePopupWindow.h(this.operateCallback);
        }
        return this.operatePopupWindow;
    }

    private void initInputPanel() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
        InputPanelFragment inputPanelFragmentA = InputPanelFragment.INSTANCE.a(true);
        inputPanelFragmentA.setInputCallback(this.inputPanelCallback);
        fragmentTransactionBeginTransaction.add(R.id.input_panel_container, inputPanelFragmentA, InputPanelFragment.class.getName());
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
        childFragmentManager.executePendingTransactions();
    }

    private void initTab(@io.reactivex.annotations.NonNull FragmentSignalTowerBinding fragmentSignalTowerBinding) {
        this.bottomTabTeam = fragmentSignalTowerBinding.f9734b;
        this.bottomTabOvert = fragmentSignalTowerBinding.f9729a;
        int i = this.showType;
        if (i == 1 || i == 3) {
            fragmentSignalTowerBinding.f9733a.setVisibility(8);
            return;
        }
        fragmentSignalTowerBinding.f9733a.setVisibility(0);
        g gVar = new g();
        this.bottomTabTeam.setOnClickListener(gVar);
        this.bottomTabOvert.setOnClickListener(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initDataAfterView$0(View view) {
        hideInputForce();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initDataAfterView$1(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        hideInputForce();
    }

    public static SignalTowerFragment newInstance(String str, String str2, int i, int i2, ArrayList<String> arrayList, String str3, Boolean bool, int i3, int i4, int i5) {
        SignalTowerFragment signalTowerFragment = new SignalTowerFragment();
        Bundle bundleCreateArguments = BaseSignalTowerFragment.createArguments(str, str2, i, i2, arrayList, str3, bool, i3);
        bundleCreateArguments.putInt(BaseSignalTowerFragment.TAB_INDEX, i4);
        bundleCreateArguments.putInt(BaseSignalTowerFragment.OVERT_TYPE, i5);
        signalTowerFragment.setArguments(bundleCreateArguments);
        return signalTowerFragment;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.fragment_signal_tower), Integer.valueOf(yk0.p0), ((BaseVMFragment) this).mState).a(Integer.valueOf(yk0.k), new h());
    }

    @Override // com.huachenjie.im.page.base.BaseSignalTowerFragment, com.huachenjie.im.page.base.BaseChatFragment
    public void handleArguments(Bundle bundle) {
        super.handleArguments(bundle);
        if (this.hideNationwide.booleanValue()) {
            ((SignalTowerVM) ((BaseVMFragment) this).mState).o.setValue(this.hideNationwide);
        } else if (getArguments().getInt(BaseSignalTowerFragment.TAB_INDEX, 0) == 0) {
            ((SignalTowerVM) ((BaseVMFragment) this).mState).o.setValue(Boolean.TRUE);
        } else {
            ((SignalTowerVM) ((BaseVMFragment) this).mState).o.setValue(Boolean.FALSE);
        }
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment, com.huachenjie.common.base.data_binding.BaseVMFragment
    public void init(Bundle bundle) {
        super.init(bundle);
    }

    @Override // com.huachenjie.im.page.base.BaseSignalTowerFragment
    public void initChatRecycler(RecyclerView recyclerView, BaseQuickAdapter baseQuickAdapter) {
        super.initChatRecycler(recyclerView, baseQuickAdapter);
        baseQuickAdapter.addChildLongClickViewIds(R.id.tvMessage);
        baseQuickAdapter.addChildClickViewIds(R.id.ivAvatar, R.id.rlGiftItem, R.id.ivImage, R.id.ll_audio_container, R.id.llInvitationItem);
        baseQuickAdapter.setOnItemChildClickListener(this.itemClickListener);
        baseQuickAdapter.setOnItemChildLongClickListener(this.itemLongClickListener);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initDataAfterView() {
        if (getBinding() != null && (getBinding() instanceof FragmentSignalTowerBinding)) {
            FragmentSignalTowerBinding fragmentSignalTowerBinding = (FragmentSignalTowerBinding) getBinding();
            initTab(fragmentSignalTowerBinding);
            this.mTeamRecycler = fragmentSignalTowerBinding.f9736c;
            SignalTowerAdapter signalTowerAdapter = new SignalTowerAdapter("");
            this.mTeamAdapter = signalTowerAdapter;
            initChatRecycler(this.mTeamRecycler, signalTowerAdapter);
            this.mOvertRecycler = fragmentSignalTowerBinding.f9735b;
            SignalTowerAdapter signalTowerAdapter2 = new SignalTowerAdapter("");
            this.mOvertAdapter = signalTowerAdapter2;
            initChatRecycler(this.mOvertRecycler, signalTowerAdapter2);
            this.mNationwideRecycler = fragmentSignalTowerBinding.f9730a;
            SignalTowerAdapter signalTowerAdapter3 = new SignalTowerAdapter("");
            this.mNationwideAdapter = signalTowerAdapter3;
            initChatRecycler(this.mNationwideRecycler, signalTowerAdapter3);
            fragmentSignalTowerBinding.f9728a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.dc8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f41152a.lambda$initDataAfterView$0(view);
                }
            });
            OnItemClickListener onItemClickListener = new OnItemClickListener() { // from class: com.zj.adlib.ec8
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    this.f41405a.lambda$initDataAfterView$1(baseQuickAdapter, view, i);
                }
            };
            this.mTeamAdapter.setOnItemClickListener(onItemClickListener);
            this.mOvertAdapter.setOnItemClickListener(onItemClickListener);
            this.mNationwideAdapter.setOnItemClickListener(onItemClickListener);
            if (getArguments() != null) {
                ((SignalTowerVM) ((BaseVMFragment) this).mState).m.setValue(Integer.valueOf(getArguments().getInt(BaseSignalTowerFragment.TAB_INDEX, 0)));
                ((SignalTowerVM) ((BaseVMFragment) this).mState).n.setValue(Integer.valueOf(getArguments().getInt(BaseSignalTowerFragment.OVERT_TYPE, 0)));
            }
            if (this.mRoomChatType == 6) {
                fragmentSignalTowerBinding.f9734b.setText("我的宿舍");
            } else {
                fragmentSignalTowerBinding.f9729a.setText("队内发送");
            }
            int i = this.mRoomChatType;
            if (i == 6) {
                fragmentSignalTowerBinding.f9729a.setText("全国宿舍");
            } else if (i == 5) {
                fragmentSignalTowerBinding.f9729a.setText("附近发送");
            } else {
                fragmentSignalTowerBinding.f9729a.setText("公开发送");
            }
            checkMask();
        }
        initInputPanel();
    }

    @Override // com.huachenjie.im.page.base.BaseSignalTowerFragment, com.huachenjie.im.page.base.BaseRoomChatFragment
    public void initRoomIdList(List<String> list) {
        super.initRoomIdList(list);
        Q q = ((BaseVMFragment) this).mState;
        if (q == 0 || ((SignalTowerVM) q).j == null || ((SignalTowerVM) q).j.getValue() == null) {
            return;
        }
        BaseQuickAdapter baseQuickAdapter = this.mTeamAdapter;
        if (baseQuickAdapter != null) {
            ((SignalTowerAdapter) baseQuickAdapter).e(((SignalTowerVM) ((BaseVMFragment) this).mState).j.getValue().getAccid());
        }
        BaseQuickAdapter baseQuickAdapter2 = this.mOvertAdapter;
        if (baseQuickAdapter2 != null) {
            ((SignalTowerAdapter) baseQuickAdapter2).e(((SignalTowerVM) ((BaseVMFragment) this).mState).j.getValue().getAccid());
        }
        BaseQuickAdapter baseQuickAdapter3 = this.mNationwideAdapter;
        if (baseQuickAdapter3 != null) {
            ((SignalTowerAdapter) baseQuickAdapter3).e(((SignalTowerVM) ((BaseVMFragment) this).mState).j.getValue().getAccid());
        }
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment
    public void observeDataChange() {
        ((SignalTowerVM) ((BaseVMFragment) this).mState).m.observe(this, new e());
        ((SignalTowerVM) ((BaseVMFragment) this).mState).n.observe(this, new f());
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
        Intent intent = new Intent();
        intent.putExtra(BaseSignalTowerFragment.TAB_INDEX, ((SignalTowerVM) ((BaseVMFragment) this).mState).m.getValue());
        intent.putExtra(BaseSignalTowerFragment.OVERT_TYPE, ((SignalTowerVM) ((BaseVMFragment) this).mState).n.getValue());
        getActivity().setResult(-1, intent);
        super.onDestroyView();
    }

    public void saveTabStatus() {
        if (getActivity() == null && getActivity().isFinishing()) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(BaseSignalTowerFragment.TAB_INDEX, ((SignalTowerVM) ((BaseVMFragment) this).mState).m.getValue());
        intent.putExtra(BaseSignalTowerFragment.OVERT_TYPE, ((SignalTowerVM) ((BaseVMFragment) this).mState).n.getValue());
        getActivity().setResult(-1, intent);
    }
}
