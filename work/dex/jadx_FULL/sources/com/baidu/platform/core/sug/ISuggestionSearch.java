package com.baidu.platform.core.sug;

import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface ISuggestionSearch {
    void destroy();

    boolean requestSuggestion(SuggestionSearchOption suggestionSearchOption);

    void setOnGetSuggestionResultListener(OnGetSuggestionResultListener onGetSuggestionResultListener);
}
