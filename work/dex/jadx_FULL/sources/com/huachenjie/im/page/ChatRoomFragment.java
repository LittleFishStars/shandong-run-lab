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
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemChildLongClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.base.module_bridge.interfaces.CollegeMethodLoader;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.glide.SizeCallback;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.R;
import com.huachenjie.im.adapter.ChatRoomAdapter;
import com.huachenjie.im.audio.ImAudioPlayCallback;
import com.huachenjie.im.custom.EmojiStickerAttachment;
import com.huachenjie.im.custom.ShareChannelAttachment;
import com.huachenjie.im.custom.ShareCommodityAttachment;
import com.huachenjie.im.custom.ShareLinkAttachment;
import com.huachenjie.im.custom.ShareTopicAttachment;
import com.huachenjie.im.custom.ShareWorkAttachment;
import com.huachenjie.im.databinding.FragmentChatRoomBinding;
import com.huachenjie.im.page.base.BaseChatFragment;
import com.huachenjie.im.page.base.InputPanelCallback;
import com.huachenjie.im.page.base.InputPanelFragment;
import com.huachenjie.im.vm.ChatRoomVM;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.RequestCallbackWrapper;
import com.netease.nimlib.sdk.chatroom.ChatRoomService;
import com.netease.nimlib.sdk.chatroom.ChatRoomServiceObserver;
import com.netease.nimlib.sdk.chatroom.model.ChatRoomMessage;
import com.netease.nimlib.sdk.chatroom.model.ChatRoomRecallAttachment;
import com.netease.nimlib.sdk.chatroom.model.EnterChatRoomData;
import com.netease.nimlib.sdk.chatroom.model.EnterChatRoomResultData;
import com.netease.nimlib.sdk.msg.attachment.AudioAttachment;
import com.netease.nimlib.sdk.msg.attachment.ImageAttachment;
import com.netease.nimlib.sdk.msg.attachment.MsgAttachment;
import com.netease.nimlib.sdk.msg.constant.MsgTypeEnum;
import com.netease.nimlib.sdk.msg.constant.NotificationType;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.netease.nimlib.sdk.msg.model.QueryDirectionEnum;
import com.zj.adlib.dj1;
import com.zj.adlib.f64;
import com.zj.adlib.fj1;
import com.zj.adlib.fv5;
import com.zj.adlib.gm1;
import com.zj.adlib.i4a;
import com.zj.adlib.i62;
import com.zj.adlib.k44;
import com.zj.adlib.ln1;
import com.zj.adlib.mu3;
import com.zj.adlib.su9;
import com.zj.adlib.yk0;
import com.zj.adlib.zj7;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ChatRoomFragment extends BaseChatFragment<ChatRoomVM> {
    private String chatRoomId;
    private RecyclerView mRecyclerView;
    private OperatePopupWindow operatePopupWindow;
    private final OperatePopupWindow.OnClickCallback operateCallback = new a();
    public boolean accountEmpty = false;
    public boolean enterError = false;
    private int requestHistoryNum = 100;
    private final Observer<List<ChatRoomMessage>> messageObserver = new fj1(this);
    private final InputPanelCallback inputPanelCallback = new b();

    public class a implements OperatePopupWindow.OnClickCallback {
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
                Integer num = (Integer) obj;
                f64.b().k(((IMMessage) ((ChatRoomVM) ((BaseVMFragment) ChatRoomFragment.this).mState).h().getData().get(num.intValue())).getUuid());
                ((ChatRoomVM) ((BaseVMFragment) ChatRoomFragment.this).mState).h().removeAt(num.intValue());
                return;
            }
            if (i == 1002 && obj != null && (obj instanceof Integer)) {
                IMMessage iMMessage = (IMMessage) ((ChatRoomVM) ((BaseVMFragment) ChatRoomFragment.this).mState).h().getData().get(((Integer) obj).intValue());
                if (iMMessage.getMsgType().getValue() == MsgTypeEnum.text.getValue()) {
                    gm1.b(iMMessage.getContent());
                    fv5.b("复制成功");
                }
            }
        }
    }

    public class b implements InputPanelCallback {

        public class a implements SizeCallback {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ String f9889a;

            /* JADX INFO: renamed from: com.huachenjie.im.page.ChatRoomFragment$b$a$a, reason: collision with other inner class name */
            public class C0806a extends DefaultCallback<ChatRoomMessage> {
                public C0806a() {
                }

                @Override // com.huachenjie.im.DefaultCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResult(int i, ChatRoomMessage chatRoomMessage, Throwable th) {
                    if (i != 200 || chatRoomMessage == null) {
                        fv5.b("发送失败");
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(chatRoomMessage);
                    ChatRoomFragment.this.messageObserver.onEvent(arrayList);
                }
            }

            public a(String str) {
                this.f9889a = str;
            }

            @Override // com.huachenjie.common.glide.SizeCallback
            public void a(Size size) {
                EmojiStickerAttachment emojiStickerAttachment = new EmojiStickerAttachment();
                emojiStickerAttachment.setEmojiUrl(this.f9889a);
                emojiStickerAttachment.setWidth(size.getWidth());
                emojiStickerAttachment.setHeight(size.getHeight());
                dj1.U(emojiStickerAttachment, ChatRoomFragment.this.chatRoomId, ((ChatRoomVM) ((BaseVMFragment) ChatRoomFragment.this).mState).m.getValue(), new C0806a());
            }

            @Override // com.huachenjie.common.glide.SizeCallback
            public void onFailed() {
                fv5.b("发送失败");
            }
        }

        /* JADX INFO: renamed from: com.huachenjie.im.page.ChatRoomFragment$b$b, reason: collision with other inner class name */
        public class C0807b extends DefaultCallback<ChatRoomMessage> {
            public C0807b() {
            }

            @Override // com.huachenjie.im.DefaultCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(int i, ChatRoomMessage chatRoomMessage, Throwable th) {
                if (i != 200 || chatRoomMessage == null) {
                    fv5.b("发送失败");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(chatRoomMessage);
                ChatRoomFragment.this.messageObserver.onEvent(arrayList);
            }
        }

        public class c extends DefaultCallback<ChatRoomMessage> {
            public c() {
            }

            @Override // com.huachenjie.im.DefaultCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(int i, ChatRoomMessage chatRoomMessage, Throwable th) {
                if (i != 200 || chatRoomMessage == null) {
                    fv5.b("发送失败");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(chatRoomMessage);
                ChatRoomFragment.this.messageObserver.onEvent(arrayList);
            }
        }

        public class d extends DefaultCallback<ChatRoomMessage> {
            public d() {
            }

            @Override // com.huachenjie.im.DefaultCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(int i, ChatRoomMessage chatRoomMessage, Throwable th) {
                if (i != 200 || chatRoomMessage == null) {
                    fv5.b("发送失败");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(chatRoomMessage);
                ChatRoomFragment.this.messageObserver.onEvent(arrayList);
            }
        }

        public b() {
        }

        @Override // com.huachenjie.im.page.base.InputPanelCallback
        public void a(String str) {
            if (ChatRoomFragment.this.checkMutedBeforeSend()) {
                dj1.X(str, ChatRoomFragment.this.chatRoomId, ((ChatRoomVM) ((BaseVMFragment) ChatRoomFragment.this).mState).m.getValue(), new C0807b());
            }
        }

        @Override // com.huachenjie.im.page.base.InputPanelCallback
        public void d(String str) {
            if (ChatRoomFragment.this.checkMutedBeforeSend()) {
                mu3.a(ChatRoomFragment.this.getContext(), str, new a(str));
            }
        }

        @Override // com.huachenjie.im.page.base.InputPanelCallback
        public void e(File file, long j) {
            if (ChatRoomFragment.this.checkMutedBeforeSend() && file != null) {
                dj1.T(file, j, ChatRoomFragment.this.chatRoomId, ((ChatRoomVM) ((BaseVMFragment) ChatRoomFragment.this).mState).m.getValue(), new d());
            }
        }

        @Override // com.huachenjie.im.page.base.InputPanelCallback
        public void g(String str) {
            if (ChatRoomFragment.this.checkMutedBeforeSend()) {
                dj1.V(str, ChatRoomFragment.this.chatRoomId, ((ChatRoomVM) ((BaseVMFragment) ChatRoomFragment.this).mState).m.getValue(), new c());
            }
        }
    }

    public class c implements RequestCallback<EnterChatRoomResultData> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f9890a;

        public c(String str) {
            this.f9890a = str;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(EnterChatRoomResultData enterChatRoomResultData) {
            ChatRoomFragment.this.enterError = false;
            if (enterChatRoomResultData != null && enterChatRoomResultData.getRoomInfo() != null) {
                int onlineUserCount = enterChatRoomResultData.getRoomInfo().getOnlineUserCount();
                if (ChatRoomFragment.this.getActivity() != null && !ChatRoomFragment.this.getActivity().isFinishing() && (ChatRoomFragment.this.getActivity() instanceof ChatRoomActivity)) {
                    ((ChatRoomActivity) ChatRoomFragment.this.getActivity()).i0(onlineUserCount);
                }
            }
            ChatRoomFragment.this.refreshHistory(this.f9890a);
        }

        public void onException(Throwable th) {
            ChatRoomFragment.this.enterError = true;
        }

        public void onFailed(int i) {
            ChatRoomFragment.this.enterError = true;
            i4a.a("进入群聊（" + this.f9890a + "）失败：" + i);
        }
    }

    public class d extends RequestCallbackWrapper<List<ChatRoomMessage>> {
        public d() {
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, List<ChatRoomMessage> list, Throwable th) {
            i4a.a("pullMessageHistory success");
            i4a.a("code ：" + i);
            if (list == null || list.size() == 0) {
                return;
            }
            Collections.reverse(list);
            ((ChatRoomVM) ((BaseVMFragment) ChatRoomFragment.this).mState).h().addData((Collection) list);
        }
    }

    public class e implements ImAudioPlayCallback {
        public e() {
        }

        @Override // com.huachenjie.im.audio.ImAudioPlayCallback
        public void a(String str) {
            ((ChatRoomVM) ((BaseVMFragment) ChatRoomFragment.this).mState).h().notifyItemChanged(((ChatRoomVM) ((BaseVMFragment) ChatRoomFragment.this).mState).j(str));
        }

        @Override // com.huachenjie.im.audio.ImAudioPlayCallback
        public void b(String str) {
            ((ChatRoomVM) ((BaseVMFragment) ChatRoomFragment.this).mState).h().notifyItemChanged(((ChatRoomVM) ((BaseVMFragment) ChatRoomFragment.this).mState).j(str));
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
        if (this.accountEmpty) {
            fv5.b("群聊不存在，无法发送消息");
            return false;
        }
        if (this.enterError) {
            fv5.b("进入群聊失败，无法发送消息");
            return false;
        }
        if (((ChatRoomVM) ((BaseVMFragment) this).mState).m.getValue() != null) {
            return true;
        }
        fv5.b("用户信息获取失败，无法发送消息");
        return false;
    }

    public static Bundle createArguments(String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("accountId", str);
        bundle.putInt(UserConstants.CHAT_ROOM_PARAMS.d, i);
        return bundle;
    }

    private OperatePopupWindow getPopupWindow() {
        if (this.operatePopupWindow == null) {
            OperatePopupWindow operatePopupWindow = new OperatePopupWindow(getContext(), ((ChatRoomVM) ((BaseVMFragment) this).mState).b.getValue().intValue());
            this.operatePopupWindow = operatePopupWindow;
            operatePopupWindow.h(this.operateCallback);
        }
        return this.operatePopupWindow;
    }

    private void initAdapter() {
        final BaseQuickAdapter baseQuickAdapterH = ((ChatRoomVM) ((BaseVMFragment) this).mState).h();
        int i = R.id.ivImage;
        int i2 = R.id.ll_audio_container;
        baseQuickAdapterH.addChildClickViewIds(R.id.ll_share_link, R.id.ivAvatar, i, i2, R.id.cl_share_works, R.id.cl_share_channel, R.id.cl_share_topic, R.id.ll_share_commodity);
        baseQuickAdapterH.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.gj1
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                this.f16784a.lambda$initAdapter$2(baseQuickAdapterH, baseQuickAdapter, view, i3);
            }
        });
        baseQuickAdapterH.addChildLongClickViewIds(R.id.tvMessage, R.id.gifImage, i, i2);
        baseQuickAdapterH.setOnItemChildLongClickListener(new OnItemChildLongClickListener() { // from class: com.zj.adlib.hj1
            @Override // com.chad.library.adapter.base.listener.OnItemChildLongClickListener
            public final boolean onItemChildLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                return this.f42134a.lambda$initAdapter$3(baseQuickAdapter, view, i3);
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
    public /* synthetic */ void lambda$initAdapter$2(BaseQuickAdapter baseQuickAdapter, BaseQuickAdapter baseQuickAdapter2, View view, int i) {
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
        if (id == R.id.ll_share_link) {
            MsgAttachment attachment4 = iMMessage.getAttachment();
            if (attachment4 == null || !(attachment4 instanceof ShareLinkAttachment)) {
                return;
            }
            ShareLinkAttachment shareLinkAttachment = (ShareLinkAttachment) attachment4;
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
            if (((ChatRoomVM) ((BaseVMFragment) this).mState).j.getValue().getAccid().equals(fromAccount)) {
                return;
            }
            ((ChatRoomVM) ((BaseVMFragment) this).mState).k(fromAccount);
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
                f64.b().i(getContext(), attachment2.getUrl(), iMMessage.getUuid(), new e());
                return;
            }
            return;
        }
        if (id == R.id.cl_share_works) {
            MsgAttachment attachment5 = iMMessage.getAttachment();
            if (attachment5 == null || !(attachment5 instanceof ShareWorkAttachment)) {
                return;
            }
            ((ChatRoomVM) ((BaseVMFragment) this).mState).o(((ShareWorkAttachment) attachment5).getWorksNo());
            return;
        }
        if (id == R.id.cl_share_channel) {
            MsgAttachment attachment6 = iMMessage.getAttachment();
            if (attachment6 == null || !(attachment6 instanceof ShareChannelAttachment)) {
                return;
            }
            ((ChatRoomVM) ((BaseVMFragment) this).mState).m(((ShareChannelAttachment) attachment6).getChannelNo());
            return;
        }
        if (id == R.id.cl_share_topic) {
            MsgAttachment attachment7 = iMMessage.getAttachment();
            if (attachment7 == null || !(attachment7 instanceof ShareTopicAttachment)) {
                return;
            }
            ((ChatRoomVM) ((BaseVMFragment) this).mState).n(((ShareTopicAttachment) attachment7).getSubjectNo());
            return;
        }
        if (id == R.id.ll_share_commodity && (attachment = iMMessage.getAttachment()) != null && (attachment instanceof ShareCommodityAttachment)) {
            ShareCommodityAttachment shareCommodityAttachment = (ShareCommodityAttachment) attachment;
            ARouter.getInstance().build(zj7.g.GOOD_DETAIL).withString("goodsNo", shareCommodityAttachment.getGoodsNo()).withString("source", "11").withString("traceNo", shareCommodityAttachment.getTraceNo()).navigation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initAdapter$3(BaseQuickAdapter baseQuickAdapter, View view, int i) {
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
    public /* synthetic */ void lambda$initDataAfterView$0(View view) {
        hideInputForce();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initDataAfterView$1(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        hideInputForce();
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
            ChatRoomMessage chatRoomMessage = (ChatRoomMessage) it.next();
            ChatRoomRecallAttachment attachment = chatRoomMessage.getAttachment();
            if (attachment != null && (attachment instanceof ChatRoomRecallAttachment)) {
                ChatRoomRecallAttachment chatRoomRecallAttachment = attachment;
                if (chatRoomRecallAttachment.getType().getValue() == NotificationType.ChatRoomRecall.getValue()) {
                    withdrawMessage(chatRoomMessage, chatRoomRecallAttachment.getMsgUuid(), chatRoomRecallAttachment.getMsgTime());
                }
            }
            arrayList.add(chatRoomMessage);
        }
        if (arrayList.size() > 0) {
            onReceiveMessage(arrayList);
        }
    }

    public static ChatRoomFragment newInstance(String str, int i) {
        ChatRoomFragment chatRoomFragment = new ChatRoomFragment();
        chatRoomFragment.setArguments(createArguments(str, i));
        return chatRoomFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshHistory(String str) {
        ChatRoomService chatRoomService = (ChatRoomService) k44.a(ChatRoomService.class);
        if (chatRoomService == null) {
            this.enterError = true;
        } else {
            i4a.a("service is not null.---> pullMessageHistoryEx");
            chatRoomService.pullMessageHistoryEx(str, System.currentTimeMillis(), this.requestHistoryNum, QueryDirectionEnum.QUERY_OLD).setCallback(new d());
        }
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment
    public void afterLoginSuccess() {
        BaseQuickAdapter baseQuickAdapterH = ((ChatRoomVM) ((BaseVMFragment) this).mState).h();
        if ((baseQuickAdapterH instanceof ChatRoomAdapter) && ((ChatRoomVM) ((BaseVMFragment) this).mState).j.getValue() != null) {
            ((ChatRoomAdapter) baseQuickAdapterH).e(((ChatRoomVM) ((BaseVMFragment) this).mState).j.getValue().getAccid());
        }
        enterChatRoomAndRefreshHistory(this.chatRoomId);
    }

    public void enterChatRoomAndRefreshHistory(String str) {
        if (TextUtils.isEmpty(str)) {
            this.accountEmpty = true;
            return;
        }
        ChatRoomService chatRoomService = (ChatRoomService) k44.a(ChatRoomService.class);
        if (chatRoomService == null) {
            this.enterError = true;
        } else {
            chatRoomService.enterChatRoomEx(new EnterChatRoomData(str), 5).setCallback(new c(str));
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.fragment_chat_room), Integer.valueOf(yk0.p0), ((BaseVMFragment) this).mState);
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment
    public void handleArguments(Bundle bundle) {
        if (bundle != null) {
            this.chatRoomId = bundle.getString("accountId");
            this.requestHistoryNum = bundle.getInt(UserConstants.CHAT_ROOM_PARAMS.d, 0);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initDataAfterView() {
        initInputPanel();
        if (getBinding() == null || !(getBinding() instanceof FragmentChatRoomBinding)) {
            return;
        }
        FragmentChatRoomBinding fragmentChatRoomBinding = (FragmentChatRoomBinding) getBinding();
        this.mRecyclerView = fragmentChatRoomBinding.f9669a;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setStackFromEnd(true);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRecyclerView.setAdapter(((ChatRoomVM) ((BaseVMFragment) this).mState).h());
        this.mRecyclerView.setOverScrollMode(2);
        initAdapter();
        fragmentChatRoomBinding.f34413a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ij1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f42366a.lambda$initDataAfterView$0(view);
            }
        });
        ((ChatRoomVM) ((BaseVMFragment) this).mState).h().setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.jj1
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                this.f42600a.lambda$initDataAfterView$1(baseQuickAdapter, view, i);
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
        super.onDestroyView();
    }

    public void onReceiveMessage(List<ChatRoomMessage> list) {
        i4a.a("onReceiveMessage");
        if (((ChatRoomVM) ((BaseVMFragment) this).mState).h() != null) {
            ((ChatRoomVM) ((BaseVMFragment) this).mState).h().addData((Collection) list);
            smoothScrollToBottom(this.mRecyclerView);
        }
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment
    public void registerMessageChange() {
        ChatRoomServiceObserver chatRoomServiceObserver = (ChatRoomServiceObserver) k44.a(ChatRoomServiceObserver.class);
        if (chatRoomServiceObserver != null) {
            chatRoomServiceObserver.observeReceiveMessage(this.messageObserver, true);
        }
    }

    public void smoothScrollToBottom(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(recyclerView.getAdapter().getItemCount() - 1, Integer.MIN_VALUE);
        }
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment
    public void unregisterMessageChange() {
        ChatRoomServiceObserver chatRoomServiceObserver = (ChatRoomServiceObserver) k44.a(ChatRoomServiceObserver.class);
        if (chatRoomServiceObserver != null) {
            chatRoomServiceObserver.observeReceiveMessage(this.messageObserver, false);
        }
    }

    public void withdrawMessage(ChatRoomMessage chatRoomMessage, String str, long j) {
        BaseQuickAdapter baseQuickAdapterH = ((ChatRoomVM) ((BaseVMFragment) this).mState).h();
        if (baseQuickAdapterH == null) {
            return;
        }
        for (Object obj : baseQuickAdapterH.getData()) {
            if (obj != null && (obj instanceof ChatRoomMessage)) {
                ChatRoomMessage chatRoomMessage2 = (ChatRoomMessage) obj;
                String uuid = chatRoomMessage2.getUuid();
                long time = chatRoomMessage2.getTime();
                if (str.equals(uuid) && j == time) {
                    f64.b().k(chatRoomMessage2.getUuid());
                    baseQuickAdapterH.remove(obj);
                    return;
                }
            }
        }
    }
}
