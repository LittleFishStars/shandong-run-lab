package com.huachenjie.compat.page.personal;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.CommonUserInfo;
import com.zj.adlib.ai9;
import com.zj.adlib.fv5;
import com.zj.adlib.gq1;
import com.zj.adlib.n76;
import com.zj.adlib.ys8;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import huachenjie.sdk.http.ui.HttpVmDialog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class ChangeNickNameVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final gq1 f9240a = new gq1();
    public int K = 8;
    public MutableLiveData<BindingTitleBean> i = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediatorLiveData<String> f34130a = new MediatorLiveData<>();
    public MutableLiveData<String> j = new MutableLiveData<>("");
    public MutableLiveData<Boolean> k = new MutableLiveData<>();

    public class a extends DialogVMSubscriber<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonUserInfo f34131a;
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HttpVmDialog httpVmDialog, boolean z, CommonUserInfo commonUserInfo, String str) {
            super(httpVmDialog, z);
            this.f34131a = commonUserInfo;
            this.f = str;
        }

        public void onCCSuccess(Object obj) {
            fv5.b("修改成功");
            this.f34131a.setNickName(this.f);
            ai9.s(this.f34131a);
        }
    }

    public class b extends DialogVMSubscriber<Object> {
        public b(HttpVmDialog httpVmDialog, boolean z) {
            super(httpVmDialog, z);
        }

        public void onCCSuccess(Object obj) {
            fv5.b("修改成功");
            ChangeNickNameVM.this.k.setValue(Boolean.TRUE);
        }
    }

    public ChangeNickNameVM() {
        this.f34130a.setValue("");
        this.f34130a.addSource(this.j, new Observer() { // from class: com.zj.adlib.qh1
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f44207a.i((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(String str) {
        MediatorLiveData<String> mediatorLiveData = this.f34130a;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(str == null ? 0 : str.length());
        objArr[1] = Integer.valueOf(this.K);
        mediatorLiveData.setValue(ys8.c("%d/%d", objArr));
    }

    public void j(String str, String str2) {
        String strTrim = this.j.getValue().trim();
        if (strTrim.equals(str)) {
            return;
        }
        n76.e(this, this.f9240a.z(str2, strTrim)).p5(new b(this, true));
    }

    public void k() {
        String value = this.j.getValue();
        if (value == null) {
            return;
        }
        String strTrim = value.trim();
        if (TextUtils.isEmpty(strTrim)) {
            return;
        }
        CommonUserInfo commonUserInfoE = ai9.e();
        if (strTrim.equals(commonUserInfoE.getNickName())) {
            return;
        }
        n76.e(this, this.f9240a.D(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, strTrim, null, null)).p5(new a(this, true, commonUserInfoE, strTrim));
    }
}
