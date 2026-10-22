package cn.hzjizhun.admin;

import cn.hzjizhun.admin.api.bean.BaseBean;
import cn.hzjizhun.admin.api.bean.InitConfigBean;
import cn.hzjizhun.admin.exception.JZAdError;
import cn.hzjizhun.admin.http.RequestCallback;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class kadas implements RequestCallback {
    public abstract void a(InitConfigBean initConfigBean, String str);

    public abstract void b(JZAdError jZAdError);

    @Override // cn.hzjizhun.admin.http.RequestCallback
    public void onFail(Throwable th) {
        b(new JZAdError(102, th.getMessage()));
    }

    @Override // cn.hzjizhun.admin.http.RequestCallback
    public void onSuccess(String str) {
        if (str == null || str.length() <= 0) {
            b(new JZAdError(101, "response data null"));
            return;
        }
        try {
            BaseBean bean = BaseBean.toBean(str);
            if (bean.isOk()) {
                a(bean.getInitConfig(), bean.getResultJson());
            } else {
                b(new JZAdError(101, "response data not ok"));
            }
        } catch (Throwable th) {
            th.printStackTrace();
            b(new JZAdError(101, "response data error"));
        }
    }
}
