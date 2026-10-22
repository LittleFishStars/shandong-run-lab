package com.huachenjie.im.adapter;

import androidx.annotation.NonNull;
import com.heytap.mcssdk.constant.a;
import com.huachenjie.im.R;
import com.huachenjie.im.viewHolder.BaseChatViewHolder;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.dj1;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class SignalTowerAdapter extends ChatAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f34399a;

    public SignalTowerAdapter(String str) {
        super(str);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(@NonNull Collection<? extends IMMessage> collection) {
        if (getData().isEmpty()) {
            this.f34399a = 0L;
        }
        ArrayList arrayList = new ArrayList();
        for (IMMessage iMMessage : collection) {
            if (iMMessage.getTime() >= this.f34399a) {
                arrayList.add(dj1.m(iMMessage));
                this.f34399a = f(iMMessage.getTime());
            }
            arrayList.add(iMMessage);
        }
        super.addData((Collection) arrayList);
    }

    public final long f(long j) {
        return ((j / a.h) + 1) * a.h;
    }

    @Override // com.huachenjie.im.adapter.ChatAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NonNull BaseChatViewHolder baseChatViewHolder, IMMessage iMMessage) {
        try {
            baseChatViewHolder.setGone(R.id.llNickName, false);
        } catch (Exception unused) {
        }
        baseChatViewHolder.a(iMMessage);
    }
}
