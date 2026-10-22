package com.huachenjie.im.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.heytap.mcssdk.constant.a;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.dj1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class SingleChatAdapter extends ChatAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f34400a;

    public SingleChatAdapter(String str) {
        super(str);
        this.f34400a = 0L;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(@NonNull Collection<? extends IMMessage> collection) {
        super.addData((Collection) f(collection));
    }

    public final List<IMMessage> f(Collection<? extends IMMessage> collection) {
        ArrayList arrayList = new ArrayList();
        if (collection == null) {
            return arrayList;
        }
        for (IMMessage iMMessage : collection) {
            if (iMMessage.getTime() >= this.f34400a) {
                arrayList.add(dj1.m(iMMessage));
                this.f34400a = g(iMMessage.getTime());
            }
            arrayList.add(iMMessage);
        }
        return arrayList;
    }

    public final long g(long j) {
        return ((j / a.h) + 1) * a.h;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setList(@Nullable Collection<? extends IMMessage> collection) {
        super.addData((Collection) f(collection));
    }
}
