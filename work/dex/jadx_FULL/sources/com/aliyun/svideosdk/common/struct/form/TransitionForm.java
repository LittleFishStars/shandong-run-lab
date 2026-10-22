package com.aliyun.svideosdk.common.struct.form;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.effect.TransitionBase;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
@Deprecated
public class TransitionForm {
    private String mPath;
    private TransitionBase mTransition;

    public String getPath() {
        return this.mPath;
    }

    public TransitionBase getTransition() {
        return this.mTransition;
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public void setTransition(TransitionBase transitionBase) {
        this.mTransition = transitionBase;
    }
}
