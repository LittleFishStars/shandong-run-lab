package com.huachenjie.im.page;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemChildLongClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.glide.SizeCallback;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.R;
import com.huachenjie.im.adapter.ChatAdapter;
import com.huachenjie.im.audio.ImAudioPlayCallback;
import com.huachenjie.im.bean.RemoteExtBean;
import com.huachenjie.im.custom.EmojiStickerAttachment;
import com.huachenjie.im.custom.ShareChannelAttachment;
import com.huachenjie.im.custom.ShareCommodityAttachment;
import com.huachenjie.im.custom.ShareTopicAttachment;
import com.huachenjie.im.custom.ShareWorkAttachment;
import com.huachenjie.im.databinding.FragmentChatTeamBinding;
import com.huachenjie.im.page.base.BaseChatFragment;
import com.huachenjie.im.page.base.InputPanelCallback;
import com.huachenjie.im.page.base.InputPanelFragment;
import com.huachenjie.im.page.team_member.TeamMemberActivity;
import com.huachenjie.im.vm.TeamChatVM;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.msg.MsgServiceObserve;
import com.netease.nimlib.sdk.msg.attachment.AudioAttachment;
import com.netease.nimlib.sdk.msg.attachment.ImageAttachment;
import com.netease.nimlib.sdk.msg.attachment.MsgAttachment;
import com.netease.nimlib.sdk.msg.constant.MsgTypeEnum;
import com.netease.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.netease.nimlib.sdk.team.model.Team;
import com.zj.adlib.ai9;
import com.zj.adlib.dj1;
import com.zj.adlib.f64;
import com.zj.adlib.fv5;
import com.zj.adlib.gm1;
import com.zj.adlib.i4a;
import com.zj.adlib.i62;
import com.zj.adlib.j64;
import com.zj.adlib.k44;
import com.zj.adlib.mu3;
import com.zj.adlib.qa4;
import com.zj.adlib.s19;
import com.zj.adlib.yk0;
import com.zj.adlib.z19;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class TeamChatFragment extends BaseChatFragment<TeamChatVM> {
    private String chatTeamId;
    private Team currentTeam;
    private RecyclerView mRecyclerView;
    private OperatePopupWindow operatePopupWindow;
    private final OperatePopupWindow.OnClickCallback operateCallback = new OperatePopupWindow.OnClickCallback() { // from class: com.zj.adlib.v19
        @Override // com.huachenjie.base.widget.OperatePopupWindow.OnClickCallback
        public final void a(View view, int i, Object obj) {
            this.f45271a.lambda$new$0(view, i, obj);
        }
    };
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.w19
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            this.f45506a.lambda$new$1();
        }
    };
    private final Observer<List<IMMessage>> messageObserver = new s19(this);
    private final DefaultCallback<IMMessage> sendCallback = new a();
    private final InputPanelCallback inputPanelCallback = new b();

    public class a extends DefaultCallback<IMMessage> {
        public a() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, @Nullable IMMessage iMMessage, @Nullable Throwable th) {
            if (i != 200 || iMMessage == null) {
                fv5.b("发送失败");
            } else {
                ((TeamChatVM) ((BaseVMFragment) TeamChatFragment.this).mState).h().addData(iMMessage);
                TeamChatFragment.this.smoothScrollToBottom(-1);
            }
        }
    }

    public class b implements InputPanelCallback {

        public class a implements SizeCallback {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ String f9901a;

            public a(String str) {
                this.f9901a = str;
            }

            @Override // com.huachenjie.common.glide.SizeCallback
            public void a(Size size) {
                EmojiStickerAttachment emojiStickerAttachment = new EmojiStickerAttachment();
                emojiStickerAttachment.setEmojiUrl(this.f9901a);
                emojiStickerAttachment.setWidth(size.getWidth());
                emojiStickerAttachment.setHeight(size.getHeight());
                z19.y(emojiStickerAttachment, TeamChatFragment.this.chatTeamId, TeamChatFragment.this.sendCallback);
            }

            @Override // com.huachenjie.common.glide.SizeCallback
            public void onFailed() {
                fv5.b("发送失败");
            }
        }

        public b() {
        }

        @Override // com.huachenjie.im.page.base.InputPanelCallback
        public void a(String str) {
            if (TeamChatFragment.this.checkMutedBeforeSend(null)) {
                z19.A(str, TeamChatFragment.this.chatTeamId, TeamChatFragment.this.sendCallback);
            }
        }

        @Override // com.huachenjie.im.page.base.InputPanelCallback
        public void d(String str) {
            if (TeamChatFragment.this.checkMutedBeforeSend(null)) {
                mu3.a(TeamChatFragment.this.getContext(), str, new a(str));
            }
        }

        @Override // com.huachenjie.im.page.base.InputPanelCallback
        public void e(File file, long j) {
            if (TeamChatFragment.this.checkMutedBeforeSend(null)) {
                z19.x(file, j, TeamChatFragment.this.chatTeamId, TeamChatFragment.this.sendCallback);
            }
        }

        @Override // com.huachenjie.im.page.base.InputPanelCallback
        public void g(String str) {
            if (TeamChatFragment.this.checkMutedBeforeSend(null)) {
                z19.z(str, TeamChatFragment.this.chatTeamId, TeamChatFragment.this.sendCallback);
            }
        }
    }

    public class c extends DefaultCallback<Team> {
        public c() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, @Nullable Team team, @Nullable Throwable th) {
            if (i != 200 || team == null) {
                return;
            }
            TeamChatFragment.this.currentTeam = team;
            if (TeamChatFragment.this.getActivity() == null || TeamChatFragment.this.getActivity().isFinishing() || !(TeamChatFragment.this.getActivity() instanceof TeamChatActivity)) {
                return;
            }
            ((TeamChatActivity) TeamChatFragment.this.getActivity()).k0(team.getMemberCount());
        }
    }

    public class d implements ImAudioPlayCallback {
        public d() {
        }

        @Override // com.huachenjie.im.audio.ImAudioPlayCallback
        public void a(String str) {
            ((TeamChatVM) ((BaseVMFragment) TeamChatFragment.this).mState).h().notifyItemChanged(((TeamChatVM) ((BaseVMFragment) TeamChatFragment.this).mState).j(str));
        }

        @Override // com.huachenjie.im.audio.ImAudioPlayCallback
        public void b(String str) {
            ((TeamChatVM) ((BaseVMFragment) TeamChatFragment.this).mState).h().notifyItemChanged(((TeamChatVM) ((BaseVMFragment) TeamChatFragment.this).mState).j(str));
        }
    }

    public class e {
        public e() {
        }

        public void a(View view) {
            qa4.b(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMutedBeforeSend(String str) {
        if (this.isLoginMuted) {
            fv5.b("创建聊天失败，无法发送消息");
            return false;
        }
        if (this.isMuted) {
            if (TextUtils.isEmpty(str)) {
                fv5.b("您已被禁言，无法发送消息");
            } else {
                fv5.b("您已被禁言，${tipContent}");
            }
            return false;
        }
        if (((TeamChatVM) ((BaseVMFragment) this).mState).n.getValue() != null) {
            return true;
        }
        RemoteExtBean remoteExtBean = new RemoteExtBean();
        CommonUserInfo commonUserInfoE = ai9.e();
        remoteExtBean.setAvatar(commonUserInfoE.getAvatar());
        remoteExtBean.setAvatarFrameImgUrl(commonUserInfoE.getAvatarFrameImgUrl());
        remoteExtBean.setNickName(commonUserInfoE.getNickName());
        ((TeamChatVM) ((BaseVMFragment) this).mState).n.setValue(remoteExtBean);
        z19.u(remoteExtBean);
        return true;
    }

    public static Bundle createArguments(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("accountId", str);
        return bundle;
    }

    private OperatePopupWindow getPopupWindow() {
        if (this.operatePopupWindow == null) {
            OperatePopupWindow operatePopupWindow = new OperatePopupWindow(getContext(), ((TeamChatVM) ((BaseVMFragment) this).mState).b.getValue().intValue());
            this.operatePopupWindow = operatePopupWindow;
            operatePopupWindow.h(this.operateCallback);
        }
        return this.operatePopupWindow;
    }

    private void initAdapter() {
        final BaseQuickAdapter baseQuickAdapterH = ((TeamChatVM) ((BaseVMFragment) this).mState).h();
        int i = R.id.ivImage;
        int i2 = R.id.ll_audio_container;
        baseQuickAdapterH.addChildClickViewIds(R.id.ivAvatar, i, i2, R.id.ll_share_commodity, R.id.cl_share_works, R.id.cl_share_channel, R.id.cl_share_topic);
        baseQuickAdapterH.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.t19
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                this.f19694a.lambda$initAdapter$3(baseQuickAdapterH, baseQuickAdapter, view, i3);
            }
        });
        baseQuickAdapterH.addChildLongClickViewIds(R.id.tvMessage, R.id.gifImage, i, i2);
        baseQuickAdapterH.setOnItemChildLongClickListener(new OnItemChildLongClickListener() { // from class: com.zj.adlib.u19
            @Override // com.chad.library.adapter.base.listener.OnItemChildLongClickListener
            public final boolean onItemChildLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                return this.f45047a.lambda$initAdapter$4(baseQuickAdapter, view, i3);
            }
        });
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initAdapter$3(BaseQuickAdapter baseQuickAdapter, BaseQuickAdapter baseQuickAdapter2, View view, int i) {
        IMMessage iMMessage;
        MsgAttachment attachment;
        AudioAttachment attachment2;
        ImageAttachment attachment3;
        if (view == null) {
            i4a.c("view is null");
            return;
        }
        try {
            iMMessage = (IMMessage) baseQuickAdapter.getData().get(i);
        } catch (Exception unused) {
            iMMessage = null;
        }
        if (iMMessage == null) {
            i4a.c("bean is null");
            return;
        }
        int id = view.getId();
        if (id == R.id.ivAvatar) {
            if (16 == iMMessage.getFromClientType()) {
                return;
            }
            String fromAccount = iMMessage.getFromAccount();
            if (((TeamChatVM) ((BaseVMFragment) this).mState).j.getValue().getAccid().equals(fromAccount)) {
                return;
            }
            ((TeamChatVM) ((BaseVMFragment) this).mState).k(fromAccount);
            return;
        }
        if (id == R.id.ivImage) {
            if (iMMessage.getMsgType().getValue() == MsgTypeEnum.image.getValue() && (attachment3 = iMMessage.getAttachment()) != null && (attachment3 instanceof ImageAttachment)) {
                PicturePreviewUtil.i(view, attachment3.getUrl());
                return;
            }
            return;
        }
        if (id == R.id.ll_audio_container) {
            if (iMMessage.getMsgType().getValue() == MsgTypeEnum.audio.getValue() && (attachment2 = iMMessage.getAttachment()) != null && (attachment2 instanceof AudioAttachment)) {
                f64.b().i(getContext(), attachment2.getUrl(), iMMessage.getUuid(), new d());
                return;
            }
            return;
        }
        if (id == R.id.cl_share_works) {
            MsgAttachment attachment4 = iMMessage.getAttachment();
            if (attachment4 == null || !(attachment4 instanceof ShareWorkAttachment)) {
                return;
            }
            ((TeamChatVM) ((BaseVMFragment) this).mState).o(((ShareWorkAttachment) attachment4).getWorksNo());
            return;
        }
        if (id == R.id.cl_share_channel) {
            MsgAttachment attachment5 = iMMessage.getAttachment();
            if (attachment5 == null || !(attachment5 instanceof ShareChannelAttachment)) {
                return;
            }
            ((TeamChatVM) ((BaseVMFragment) this).mState).m(((ShareChannelAttachment) attachment5).getChannelNo());
            return;
        }
        if (id == R.id.cl_share_topic) {
            MsgAttachment attachment6 = iMMessage.getAttachment();
            if (attachment6 == null || !(attachment6 instanceof ShareTopicAttachment)) {
                return;
            }
            ((TeamChatVM) ((BaseVMFragment) this).mState).n(((ShareTopicAttachment) attachment6).getSubjectNo());
            return;
        }
        if (id == R.id.ll_share_commodity && (attachment = iMMessage.getAttachment()) != null && (attachment instanceof ShareCommodityAttachment)) {
            fv5.b("查看商品详情");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initAdapter$4(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        if (view == null) {
            return false;
        }
        int id = view.getId();
        if (id == R.id.tvMessage) {
            getPopupWindow().i(Integer.valueOf(i));
            getPopupWindow().j(view, "delete", OperatePopupWindow.g);
            return true;
        }
        if (id != R.id.ivImage && id != R.id.gifImage && id != R.id.ll_audio_container) {
            return false;
        }
        getPopupWindow().i(Integer.valueOf(i));
        getPopupWindow().j(view, "delete");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initDataAfterView$2(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        hideInputForce();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view, int i, Object obj) {
        if (view == null) {
            return;
        }
        if (i == 1001) {
            if (obj == null || !(obj instanceof Integer)) {
                return;
            }
            Integer num = (Integer) obj;
            f64.b().k(((IMMessage) ((TeamChatVM) ((BaseVMFragment) this).mState).h().getData().get(num.intValue())).getUuid());
            ((TeamChatVM) ((BaseVMFragment) this).mState).h().removeAt(num.intValue());
            return;
        }
        if (i == 1002 && obj != null && (obj instanceof Integer)) {
            IMMessage iMMessage = (IMMessage) ((TeamChatVM) ((BaseVMFragment) this).mState).h().getData().get(((Integer) obj).intValue());
            if (iMMessage.getMsgType().getValue() == MsgTypeEnum.text.getValue()) {
                gm1.b(iMMessage.getContent());
                fv5.b("复制成功");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        ((TeamChatVM) ((BaseVMFragment) this).mState).q(this.chatTeamId, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$9b1c5750$1(List list) {
        i4a.a("onEvent -> onReceivedMessage");
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            IMMessage iMMessage = (IMMessage) it.next();
            if (iMMessage.getSessionType() == SessionTypeEnum.Team && TextUtils.equals(this.chatTeamId, iMMessage.getSessionId()) && j64.t(iMMessage)) {
                arrayList.add(iMMessage);
            }
        }
        if (arrayList.size() == 0) {
            return;
        }
        ((TeamChatVM) ((BaseVMFragment) this).mState).h().addData((Collection) arrayList);
    }

    public static TeamChatFragment newInstance(String str) {
        TeamChatFragment teamChatFragment = new TeamChatFragment();
        teamChatFragment.setArguments(createArguments(str));
        return teamChatFragment;
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment
    public void afterLoginSuccess() {
        dj1.a0(this.chatTeamId);
        BaseQuickAdapter baseQuickAdapterH = ((TeamChatVM) ((BaseVMFragment) this).mState).h();
        if ((baseQuickAdapterH instanceof ChatAdapter) && ((TeamChatVM) ((BaseVMFragment) this).mState).j.getValue() != null) {
            ((ChatAdapter) baseQuickAdapterH).e(((TeamChatVM) ((BaseVMFragment) this).mState).j.getValue().getAccid());
        }
        z19.r(this.chatTeamId, new c());
        ((TeamChatVM) ((BaseVMFragment) this).mState).q(this.chatTeamId, false);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.fragment_chat_team), Integer.valueOf(yk0.p0), ((BaseVMFragment) this).mState).a(Integer.valueOf(yk0.k), new e()).a(Integer.valueOf(yk0.R), this.onRefreshListener);
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment
    public void handleArguments(Bundle bundle) {
        if (bundle != null) {
            this.chatTeamId = bundle.getString("accountId");
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initDataAfterView() {
        initInputPanel();
        if (getBinding() == null || !(getBinding() instanceof FragmentChatTeamBinding)) {
            return;
        }
        this.mRecyclerView = ((FragmentChatTeamBinding) getBinding()).f9675a;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setStackFromEnd(true);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRecyclerView.setAdapter(((TeamChatVM) ((BaseVMFragment) this).mState).h());
        this.mRecyclerView.setOverScrollMode(2);
        initAdapter();
        ((TeamChatVM) ((BaseVMFragment) this).mState).h().setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.x19
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                this.f45730a.lambda$initDataAfterView$2(baseQuickAdapter, view, i);
            }
        });
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment
    public void observeDataChange() {
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

    @Override // com.huachenjie.im.page.base.BaseChatFragment
    public void registerMessageChange() {
        MsgServiceObserve msgServiceObserve = (MsgServiceObserve) k44.a(MsgServiceObserve.class);
        if (msgServiceObserve != null) {
            msgServiceObserve.observeReceiveMessage(this.messageObserver, true);
        }
    }

    public void smoothScrollToBottom(int i) {
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            List data = ((TeamChatVM) ((BaseVMFragment) this).mState).h().getData();
            if (i < 0 || i >= data.size()) {
                i = data.size() - 1;
            }
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, 0);
        }
    }

    public void startTeamMemberActivity() {
        if (this.currentTeam == null || ((TeamChatVM) ((BaseVMFragment) this).mState).j.getValue() == null) {
            fv5.b("数据丢失");
        } else {
            TeamMemberActivity.INSTANCE.a(getContext(), this.chatTeamId, this.currentTeam.getMemberCount(), ((TeamChatVM) ((BaseVMFragment) this).mState).j.getValue().getAccid());
        }
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment
    public void unregisterMessageChange() {
        MsgServiceObserve msgServiceObserve = (MsgServiceObserve) k44.a(MsgServiceObserve.class);
        if (msgServiceObserve != null) {
            msgServiceObserve.observeReceiveMessage(this.messageObserver, false);
        }
    }
}
