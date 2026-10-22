package com.zj.adlib;

import android.content.Context;
import android.widget.Toast;
import com.alibaba.alibctriver.AlibcNavigateCenter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class x88 implements AlibcNavigateCenter.IUrlNavigate {
    @Override // com.alibaba.alibctriver.AlibcNavigateCenter.IUrlNavigate
    public boolean openUrl(Context context, String url) {
        Toast.makeText(context, "分享链接: " + url, 1).show();
        return true;
    }
}
