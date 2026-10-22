package com.huachenjie.im.vm;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.im.bean.ChatUserBean;
import com.huachenjie.im.bean.IMTokenBean;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.j44;
import com.zj.adlib.n76;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import huachenjie.sdk.http.ui.HttpVmDialog;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class BaseChatVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j44 f34588a = new j44();
    public MutableLiveData<BaseQuickAdapter> i = new MutableLiveData<>();
    public MutableLiveData<IMTokenBean> j = new MutableLiveData<>();
    public MutableLiveData<String> k = new MutableLiveData<>("");
    public MutableLiveData<String> l = new MutableLiveData<>("");

    public class a extends DialogVMSubscriber<ChatUserBean> {
        public a(HttpVmDialog httpVmDialog, boolean z) {
            super(httpVmDialog, z);
        }

        public void onCCSuccess(ChatUserBean chatUserBean) {
            if (chatUserBean == null) {
                return;
            }
            String appUserCode = chatUserBean.getAppUserCode();
            if (TextUtils.isEmpty(appUserCode)) {
                return;
            }
            BaseChatVM.this.l.setValue(appUserCode);
        }
    }

    @NotNull
    public abstract BaseQuickAdapter h();

    public int i(BaseQuickAdapter baseQuickAdapter, String str) {
        for (int i = 0; i < baseQuickAdapter.getData().size(); i++) {
            Object obj = baseQuickAdapter.getData().get(i);
            if (obj != null && (obj instanceof IMMessage) && str.equals(((IMMessage) obj).getUuid())) {
                return i;
            }
        }
        return 0;
    }

    public int j(String str) {
        return i(h(), str);
    }

    public void k(String str) {
        n76.e(this, this.f34588a.j(str)).p5(new a(this, true));
    }

    public void l() {
    }

    public void m(String str) {
        ARouter.getInstance().build(zj7.b.CHANNEL_MAIN).withString("channelNo", str).navigation();
    }

    public void n(String str) {
        ARouter.getInstance().build(zj7.b.TOPIC_MAIN).withString(yj7.b.SUBJECT_NO, str).navigation();
    }

    public void o(String str) {
        ARouter.getInstance().build(zj7.i.WORKS_DETAIL).withString(yj7.g.WORKS_NO, str).navigation();
    }
}
