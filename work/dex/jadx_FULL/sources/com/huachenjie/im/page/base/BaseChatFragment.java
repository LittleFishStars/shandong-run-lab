package com.huachenjie.im.page.base;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.bean.IMTokenBean;
import com.huachenjie.im.page.base.BaseChatFragment;
import com.huachenjie.im.vm.BaseChatVM;
import com.zj.adlib.fv5;
import com.zj.adlib.p44;
import com.zj.adlib.zj7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class BaseChatFragment<T extends BaseChatVM> extends BaseVMFragment<T> {
    public boolean isLoginMuted = false;
    public boolean isMuted = false;
    public DefaultCallback<IMTokenBean> loginCallback = new a();

    public class a extends DefaultCallback<IMTokenBean> {
        public a() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, IMTokenBean iMTokenBean, Throwable th) {
            if (i != 200) {
                BaseChatFragment.this.isLoginMuted = true;
                fv5.b("创建聊天失败,请关闭界面重试");
                return;
            }
            ((BaseChatVM) ((BaseVMFragment) BaseChatFragment.this).mState).j.setValue(iMTokenBean);
            if (iMTokenBean != null) {
                BaseChatFragment.this.isMuted = iMTokenBean.getMuted() == 1;
            }
            BaseChatFragment.this.afterLoginSuccess();
            BaseChatFragment.this.registerMessageChange();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0() {
        p44.x(this.loginCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initViewModel$1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ARouter.getInstance().build(zj7.h.OTHER_HOME).withString("appUserCode", str).navigation();
    }

    public abstract void afterLoginSuccess();

    public abstract void handleArguments(Bundle bundle);

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void init(Bundle bundle) {
        ((BaseChatVM) ((BaseVMFragment) this).mState).l();
        handleArguments(getArguments());
        getActivity().runOnUiThread(new Runnable() { // from class: com.zj.adlib.sn0
            @Override // java.lang.Runnable
            public final void run() {
                this.f44722a.lambda$init$0();
            }
        });
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initViewModel() {
        ((BaseChatVM) ((BaseVMFragment) this).mState).l.observe(this, new Observer() { // from class: com.zj.adlib.rn0
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseChatFragment.lambda$initViewModel$1((String) obj);
            }
        });
        observeDataChange();
    }

    public abstract void observeDataChange();

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        unregisterMessageChange();
        super.onDestroyView();
    }

    public abstract void registerMessageChange();

    public abstract void unregisterMessageChange();
}
