package com.huachenjie.im.vm;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.adapter.ChatRoomAdapter;
import com.huachenjie.im.bean.RemoteExtBean;
import com.zj.adlib.p44;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ChatRoomVM extends BaseChatVM {
    public MutableLiveData<RemoteExtBean> m = new MutableLiveData<>();

    public class a extends DefaultCallback<RemoteExtBean> {
        public a() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, RemoteExtBean remoteExtBean, Throwable th) {
            if (i != 200 || remoteExtBean == null) {
                return;
            }
            ChatRoomVM.this.m.setValue(remoteExtBean);
        }
    }

    @Override // com.huachenjie.im.vm.BaseChatVM
    @NotNull
    public BaseQuickAdapter h() {
        if (this.i.getValue() != null) {
            return this.i.getValue();
        }
        ChatRoomAdapter chatRoomAdapter = new ChatRoomAdapter("");
        this.i.setValue(chatRoomAdapter);
        return chatRoomAdapter;
    }

    @Override // com.huachenjie.im.vm.BaseChatVM
    public void l() {
        if (this.m.getValue() == null) {
            p44.m(new a());
        }
    }
}
