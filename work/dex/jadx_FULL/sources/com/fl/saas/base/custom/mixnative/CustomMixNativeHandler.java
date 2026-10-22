package com.fl.saas.base.custom.mixnative;

import android.content.Context;
import android.text.TextUtils;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.annotation.MixNativeLoad;
import com.fl.saas.base.custom.MedProConst;
import com.fl.saas.base.innterNative.NativeStyle;
import com.fl.saas.base.widget.JsonUtil;
import com.fl.saas.config.exception.YdError;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class CustomMixNativeHandler extends MixNativeHandler {
    @MixNativeLoad
    public void handle() {
        HashMap map = new HashMap();
        map.put("appId", getAdSource().app_id);
        map.put(MedProConst.AD_PLACEID, getAdSource().tagid);
        map.put("appKey", getAdSource().app_key);
        if (!TextUtils.isEmpty(getAdSource().customParameJson)) {
            map.clear();
            map.putAll(JsonUtil.jsonObjectToMap(getAdSource().customParameJson));
        }
        if (getAdStyle() == NativeStyle.EXPRESS) {
            loadExpress(getContext(), map, getAdParams().getExpressWidth(), getAdParams().getExpressHeight());
        } else {
            loadNative(getContext(), map);
        }
    }

    @Override // com.fl.saas.base.adapter.MixNativeHandler
    public void init() {
    }

    public abstract void loadExpress(Context context, Map<String, Object> map, float f, float f2);

    public abstract void loadNative(Context context, Map<String, Object> map);

    public void onNativeAdLoadError(int i, String str) {
        onAdFailed(YdError.create(i, str));
    }
}
