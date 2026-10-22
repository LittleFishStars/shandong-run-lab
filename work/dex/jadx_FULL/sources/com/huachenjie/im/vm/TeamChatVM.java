package com.huachenjie.im.vm;

import androidx.annotation.Nullable;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.adapter.ChatTeamAdapter;
import com.huachenjie.im.bean.RemoteExtBean;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.i4a;
import com.zj.adlib.j64;
import com.zj.adlib.p44;
import com.zj.adlib.s72;
import com.zj.adlib.z19;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class TeamChatVM extends BaseChatVM {
    public MutableLiveData<Boolean> m = new MutableLiveData<>(Boolean.FALSE);
    public MutableLiveData<RemoteExtBean> n = new MutableLiveData<>();

    public class a extends DefaultCallback<RemoteExtBean> {
        public a() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, RemoteExtBean remoteExtBean, Throwable th) {
            if (i != 200 || remoteExtBean == null) {
                return;
            }
            TeamChatVM.this.n.setValue(remoteExtBean);
            z19.u(remoteExtBean);
        }
    }

    public class b extends DefaultCallback<Long> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f9912a;

        public b(String str) {
            this.f9912a = str;
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, @Nullable Long l, @Nullable Throwable th) {
            TeamChatVM.this.p(this.f9912a, Long.valueOf((l == null || l.longValue() == 0) ? System.currentTimeMillis() : l.longValue()), false);
        }
    }

    public class c extends DefaultCallback<List<IMMessage>> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f9913a;

        public c(boolean z) {
            this.f9913a = z;
        }

        @Override // com.huachenjie.im.DefaultCallback
        public void onResult(int i, @Nullable List<IMMessage> list, @Nullable Throwable th) {
            if (i != 200 || list == null || list.isEmpty()) {
                TeamChatVM.this.m.setValue(Boolean.FALSE);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (IMMessage iMMessage : list) {
                if (j64.t(iMMessage)) {
                    arrayList.add(iMMessage);
                }
            }
            Collections.reverse(arrayList);
            TeamChatVM.this.m.setValue(Boolean.FALSE);
            if (this.f9913a) {
                i4a.a("addData:" + arrayList.size());
                TeamChatVM.this.h().addData(0, (Collection) arrayList);
                return;
            }
            i4a.a("setList:" + arrayList.size());
            TeamChatVM.this.h().addData((Collection) arrayList);
        }
    }

    @Override // com.huachenjie.im.vm.BaseChatVM
    @NotNull
    public BaseQuickAdapter h() {
        if (this.i.getValue() != null) {
            return this.i.getValue();
        }
        ChatTeamAdapter chatTeamAdapter = new ChatTeamAdapter("");
        this.i.setValue(chatTeamAdapter);
        return chatTeamAdapter;
    }

    @Override // com.huachenjie.im.vm.BaseChatVM
    public void l() {
        if (this.n.getValue() == null) {
            p44.m(new a());
        }
    }

    public void p(String str, Long l, boolean z) {
        i4a.a("pullMessageHistory:" + z);
        i4a.a("pullMessageHistory:" + s72.c(l.longValue(), "yyyy/MM/dd HH:mm:ss"));
        z19.o(str, l.longValue(), new c(z));
    }

    public void q(String str, boolean z) {
        i4a.a("refreshHistoryMessage:" + z);
        if (!z) {
            i4a.a("getSystemTime:" + z);
            p44.n(new b(str));
            return;
        }
        Boolean bool = Boolean.TRUE;
        if (bool.equals(this.m.getValue())) {
            return;
        }
        this.m.setValue(bool);
        long time = (h().getData() == null || h().getData().isEmpty()) ? 0L : ((IMMessage) h().getData().get(0)).getTime();
        if (time == 0) {
            time = System.currentTimeMillis();
        }
        p(str, Long.valueOf(time), true);
    }
}
