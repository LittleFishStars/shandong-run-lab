package com.baidu.platform.core.recommendstop;

import com.baidu.mapapi.search.recommendstop.OnGetRecommendStopResultListener;
import com.baidu.mapapi.search.recommendstop.RecommendStopSearchOption;
import com.baidu.platform.base.SearchType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a extends com.baidu.platform.base.a implements IRecommendStop {
    private OnGetRecommendStopResultListener g = null;

    @Override // com.baidu.platform.core.recommendstop.IRecommendStop
    public void destroy() {
        this.c.lock();
        this.g = null;
        this.c.unlock();
    }

    @Override // com.baidu.platform.core.recommendstop.IRecommendStop
    public boolean requestRecommendStop(RecommendStopSearchOption recommendStopSearchOption) {
        b bVar = new b();
        bVar.a(SearchType.RECOMMEND_STOP);
        return a(new c(recommendStopSearchOption), this.g, bVar);
    }

    @Override // com.baidu.platform.core.recommendstop.IRecommendStop
    public void setOnGetRecommendStopResultListener(OnGetRecommendStopResultListener onGetRecommendStopResultListener) {
        this.c.lock();
        this.g = onGetRecommendStopResultListener;
        this.c.unlock();
    }
}
