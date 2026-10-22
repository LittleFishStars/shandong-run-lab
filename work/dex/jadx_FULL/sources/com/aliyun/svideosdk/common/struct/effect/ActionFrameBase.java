package com.aliyun.svideosdk.common.struct.effect;

import com.alipay.sdk.m.y.l;
import com.aliyun.Visible;
import com.zj.adlib.u15;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class ActionFrameBase<FRAME_VAL_PROPERTY> extends ActionBase {
    @Visible
    public void setFrameConfig(List<Frame<FRAME_VAL_PROPERTY>> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Frame<FRAME_VAL_PROPERTY> frame = list.get(i);
            sb.append(frame.time);
            sb.append(u15.f19942b);
            sb.append(frame.value.toString());
            sb.append(l.b);
        }
        this.mAnimationConfig = sb.toString();
    }
}
