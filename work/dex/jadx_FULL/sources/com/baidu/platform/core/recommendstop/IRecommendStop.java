package com.baidu.platform.core.recommendstop;

import com.baidu.mapapi.search.recommendstop.OnGetRecommendStopResultListener;
import com.baidu.mapapi.search.recommendstop.RecommendStopSearchOption;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface IRecommendStop {
    void destroy();

    boolean requestRecommendStop(RecommendStopSearchOption recommendStopSearchOption);

    void setOnGetRecommendStopResultListener(OnGetRecommendStopResultListener onGetRecommendStopResultListener);
}
