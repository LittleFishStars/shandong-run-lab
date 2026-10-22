package cn.hzjizhun.admin.ad.bean;

import android.content.Context;
import android.view.View;
import cn.hzjizhun.admin.JZUnifiedADContainer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface JZUnifiedAdInfo extends JZAdInfo {
    void bindJZAdToView(Context context, JZUnifiedADContainer jZUnifiedADContainer, List<View> list);

    void bindJZAdToView(Context context, JZUnifiedADContainer jZUnifiedADContainer, List<View> list, List<View> list2);

    JZUnifiedAdPatternType getJZAdPatternType();

    String getJZDesc();

    String getJZIconUrl();

    List<String> getJZImgList();

    String getJZImgUrl();

    String getJZTitle();
}
