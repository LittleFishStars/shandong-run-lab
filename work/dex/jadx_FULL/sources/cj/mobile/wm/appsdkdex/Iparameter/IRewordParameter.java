package cj.mobile.wm.appsdkdex.Iparameter;

import cj.mobile.wm.common.Ibase.IBaseParameter;
import cj.mobile.wm.common.Ilistener.XAdRewardVideoListener;
import cj.mobile.wm.common.bean.RewordBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IRewordParameter extends IBaseParameter<RewordBean> {
    int getOrientation();

    String getRewardExtMap();

    XAdRewardVideoListener getRewardListener();

    String getUserId();

    boolean isMuted();
}
