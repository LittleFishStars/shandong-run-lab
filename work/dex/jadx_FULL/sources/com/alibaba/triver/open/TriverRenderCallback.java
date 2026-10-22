package com.alibaba.triver.open;

import com.alibaba.triver.open.container.OpenEmbedViewHolder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface TriverRenderCallback {
    int getHeight();

    int getWidth();

    void onFailure(String str, String str2);

    void onRefresh();

    void onSuccess(OpenEmbedViewHolder openEmbedViewHolder);
}
