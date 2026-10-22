package com.kc.bw.common.nativepot;

import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class HtmlBean {
    public String code;
    public View view;

    public String getCode() {
        return this.code;
    }

    public View getView() {
        return this.view;
    }

    public HtmlBean setCode(String str) {
        this.code = str;
        return this;
    }

    public HtmlBean setView(View view) {
        this.view = view;
        return this;
    }
}
