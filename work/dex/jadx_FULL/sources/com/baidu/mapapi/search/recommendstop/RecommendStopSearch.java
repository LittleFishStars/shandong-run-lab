package com.baidu.mapapi.search.recommendstop;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.b;
import com.baidu.platform.core.recommendstop.IRecommendStop;
import com.baidu.platform.core.recommendstop.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class RecommendStopSearch extends b {
    private boolean b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IRecommendStop f26549a = new a();

    private RecommendStopSearch() {
    }

    public static RecommendStopSearch newInstance() {
        BMapManager.init();
        return new RecommendStopSearch();
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        IRecommendStop iRecommendStop = this.f26549a;
        if (iRecommendStop != null) {
            iRecommendStop.destroy();
        }
        BMapManager.destroy();
    }

    public boolean requestRecommendStop(RecommendStopSearchOption recommendStopSearchOption) {
        if (this.f26549a == null) {
            throw new IllegalStateException("BDMapSDKException: RecommendStopSearch is null, please call newInstance() first.");
        }
        if (recommendStopSearchOption == null || recommendStopSearchOption.getLocation() == null) {
            throw new IllegalStateException("BDMapSDKException: option or location can not be null");
        }
        return this.f26549a.requestRecommendStop(recommendStopSearchOption);
    }

    public void setOnGetRecommendStopResultListener(OnGetRecommendStopResultListener onGetRecommendStopResultListener) {
        IRecommendStop iRecommendStop = this.f26549a;
        if (iRecommendStop == null) {
            throw new IllegalStateException("BDMapSDKException: RecommendStopSearch is null, please call newInstance() first.");
        }
        if (onGetRecommendStopResultListener == null) {
            throw new IllegalStateException("BDMapSDKException: OnGetRecommendStopResultListener can not be null");
        }
        iRecommendStop.setOnGetRecommendStopResultListener(onGetRecommendStopResultListener);
    }
}
