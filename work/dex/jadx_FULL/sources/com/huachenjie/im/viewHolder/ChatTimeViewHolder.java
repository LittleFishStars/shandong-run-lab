package com.huachenjie.im.viewHolder;

import android.view.View;
import androidx.annotation.NonNull;
import com.huachenjie.im.R;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.s72;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ChatTimeViewHolder extends BaseChatViewHolder {
    public ChatTimeViewHolder(@NonNull View view) {
        super(view);
    }

    @Override // com.huachenjie.im.viewHolder.BaseChatViewHolder
    public void a(IMMessage iMMessage) {
        setText(R.id.tvSendTime, f(iMMessage.getTime()));
    }

    public final String f(long j) {
        if (s72.A(j)) {
            return s72.c(j, "HH:mm");
        }
        if (!s72.B(j)) {
            return s72.z(j) ? s72.c(j, "MM月dd日 HH:mm") : s72.c(j, "yyyy年MM月dd日 HH:mm");
        }
        return "昨天 " + s72.c(j, "HH:mm");
    }
}
