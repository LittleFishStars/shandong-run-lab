package com.huachenjie.im.viewHolder;

import android.view.View;
import androidx.annotation.NonNull;
import com.huachenjie.im.R;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.j64;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ChatTextViewHolder extends BaseChatViewHolder {
    public ChatTextViewHolder(@NonNull View view) {
        super(view);
    }

    @Override // com.huachenjie.im.viewHolder.BaseChatViewHolder
    public void c(IMMessage iMMessage) {
        setText(R.id.tvMessage, j64.b(iMMessage.getMsgType(), iMMessage.getContent(), iMMessage.getAttachment(), Boolean.TRUE));
    }
}
