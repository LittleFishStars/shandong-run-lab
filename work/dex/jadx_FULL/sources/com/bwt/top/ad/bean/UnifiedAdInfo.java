package com.bwt.top.ad.bean;

import android.content.Context;
import android.view.View;
import com.bwt.top.UnifiedADContainer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface UnifiedAdInfo extends AdInfo {
    void bindAdToView(Context context, UnifiedADContainer unifiedADContainer, List<View> list);

    void bindAdToView(Context context, UnifiedADContainer unifiedADContainer, List<View> list, List<View> list2);

    UnifiedAdPatternType getAdPatternType();

    String getDesc();

    String getIconUrl();

    List<String> getImgList();

    String getImgUrl();

    String getTitle();
}
