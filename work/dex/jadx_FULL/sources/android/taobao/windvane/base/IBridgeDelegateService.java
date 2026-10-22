package android.taobao.windvane.base;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface IBridgeDelegateService {
    public static final String TAG = "JsBridge";
    public static final String WINDVANE_CORE_JS = "(function(f){try{if(f.__windvane__.nativeCall){var h=f.__windvane__||(f.__windvane__={});var c=\"wvapi:\"+(Math.floor(Math.random()*(1<<16))),a=0,b={},g=function(j){if(j&&typeof j==\"string\"){try{return JSON.parse(j)}catch(i){return{ret:\"HY_RESULT_PARSE_ERROR\"}}}else{return j||{}}};h.call=function(i,m,l,e,k){if(typeof l!=\"function\"){l=null}if(typeof e!=\"function\"){e=null}var j=c+(a++);b[j]={s:l,f:e,};if(k>0){b[j].t=setTimeout(function(){h.onFailure(j,{ret:\"HY_TIMEOUT\"})},k)}if(!m){m={}}if(typeof m!=\"string\"){m=JSON.stringify(m)}f.__windvane__.nativeCall(i,m,j,location.href)};h.find=function(i,j){var e=b[i]||{};if(e.t){clearTimeout(e.t);delete e.t}if(!j){delete b[i]}return e};h.onSuccess=function(j,e,k){var i=h.find(j,k).s;if(i){i(g(e))}};h.onFailure=function(j,e){var i=h.find(j,false).f;if(i){i(g(e))}}}}catch(d){}})(window);";

    void addEntry(String str, Object obj);

    void fireEvent(String str, String str2);

    Object getEntry(String str);

    void hybridCall(android.taobao.windvane.d.b bVar, String str);

    void initBridge(Context context, android.taobao.windvane.d.b bVar);

    void loadUrl(String str);

    void nativeCall(String str, String str2, String str3, String str4);

    void onActivityResult(int i, int i2, Intent intent);

    void onDestroy();

    void onPause();

    void onResume();

    void onScrollChanged(int i, int i2, int i3, int i4);

    void setEnabled(boolean z);
}
