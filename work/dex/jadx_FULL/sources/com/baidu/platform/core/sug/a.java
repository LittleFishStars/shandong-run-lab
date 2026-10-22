package com.baidu.platform.core.sug;

import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.platform.base.SearchType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a extends com.baidu.platform.base.a implements ISuggestionSearch {
    private OnGetSuggestionResultListener g = null;

    @Override // com.baidu.platform.core.sug.ISuggestionSearch
    public void destroy() {
        this.c.lock();
        this.g = null;
        this.c.unlock();
    }

    @Override // com.baidu.platform.core.sug.ISuggestionSearch
    public boolean requestSuggestion(SuggestionSearchOption suggestionSearchOption) {
        b bVar = new b();
        bVar.a(SearchType.SUGGESTION_SEARCH_TYPE);
        return a(new c(suggestionSearchOption), this.g, bVar);
    }

    @Override // com.baidu.platform.core.sug.ISuggestionSearch
    public void setOnGetSuggestionResultListener(OnGetSuggestionResultListener onGetSuggestionResultListener) {
        this.c.lock();
        this.g = onGetSuggestionResultListener;
        this.c.unlock();
    }
}
