package com.bytedance.sdk.openadsdk;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface FilterWord {
    void addOption(FilterWord filterWord);

    String getId();

    boolean getIsSelected();

    String getName();

    List<FilterWord> getOptions();

    boolean hasSecondOptions();

    boolean isValid();

    void setIsSelected(boolean z);
}
