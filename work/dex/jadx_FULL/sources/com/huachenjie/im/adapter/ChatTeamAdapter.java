package com.huachenjie.im.adapter;

import androidx.annotation.NonNull;
import com.heytap.mcssdk.constant.a;
import com.huachenjie.im.R;
import com.huachenjie.im.viewHolder.BaseChatViewHolder;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.dj1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ChatTeamAdapter extends ChatAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f34393a;

    public ChatTeamAdapter(String str) {
        super(str);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void addData(@NonNull IMMessage iMMessage) {
        super.addData((Collection) h(Arrays.asList(iMMessage)));
    }

    public final long g(long j) {
        return ((j / a.h) + 1) * a.h;
    }

    public final List<IMMessage> h(List<IMMessage> list) {
        try {
            if (getData().isEmpty()) {
                this.f34393a = 0L;
            }
            ArrayList arrayList = new ArrayList();
            for (IMMessage iMMessage : list) {
                if (iMMessage.getTime() >= this.f34393a) {
                    arrayList.add(dj1.m(iMMessage));
                    this.f34393a = g(iMMessage.getTime());
                }
                arrayList.add(iMMessage);
            }
            return arrayList;
        } catch (Exception unused) {
            return list;
        }
    }

    public final long i(long j) {
        return ((j / a.h) - 1) * a.h;
    }

    public final List<IMMessage> j(List<IMMessage> list) {
        try {
            if (getData() != null && getData().size() != 0) {
                ArrayList arrayList = new ArrayList();
                IMMessage iMMessage = getData().get(0);
                long jI = i(iMMessage.getTime());
                Collections.reverse(list);
                for (IMMessage iMMessage2 : list) {
                    if (iMMessage2.getTime() < jI) {
                        arrayList.add(dj1.m(iMMessage));
                        jI = i(iMMessage2.getTime());
                    }
                    arrayList.add(iMMessage2);
                    iMMessage = iMMessage2;
                }
                Collections.reverse(arrayList);
                return arrayList;
            }
            return h(list);
        } catch (Exception unused) {
            return list;
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(@NonNull Collection<? extends IMMessage> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<? extends IMMessage> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        super.addData((Collection) h(arrayList));
    }

    @Override // com.huachenjie.im.adapter.ChatAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NonNull BaseChatViewHolder baseChatViewHolder, IMMessage iMMessage) {
        try {
            baseChatViewHolder.setGone(R.id.llNickName, false);
        } catch (Exception unused) {
        }
        baseChatViewHolder.a(iMMessage);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(int i, @NonNull Collection<? extends IMMessage> collection) {
        if (collection == null || collection.size() == 0) {
            return;
        }
        if (i == 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<? extends IMMessage> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            super.addData(i, (Collection) j(arrayList));
            return;
        }
        super.addData(i, (Collection) collection);
    }
}
