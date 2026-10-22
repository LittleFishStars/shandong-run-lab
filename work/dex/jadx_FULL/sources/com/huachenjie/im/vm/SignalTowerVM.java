package com.huachenjie.im.vm;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.bean.RemoteExtBean;
import com.zj.adlib.p44;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class SignalTowerVM extends BaseSignalTowerVM {
    public MutableLiveData<Boolean> o = new MutableLiveData<>();
    public MutableLiveData<RemoteExtBean> p = new MutableLiveData<>();

    public class a extends DefaultCallback<RemoteExtBean> {
        public a() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, RemoteExtBean remoteExtBean, Throwable th) {
            if (i != 200 || remoteExtBean == null) {
                return;
            }
            SignalTowerVM.this.p.setValue(remoteExtBean);
        }
    }

    @Override // com.huachenjie.im.vm.BaseChatVM
    public void l() {
        if (this.p.getValue() == null) {
            p44.m(new a());
        }
    }
}
