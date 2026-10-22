package com.kc.aw;

import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.interf.PtgCustomController;
import com.kc.aw.lib.utils.TextUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ny implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        JSONArray jSONArrayOptJSONArray;
        PtgCustomController ptgCustomController = PtgAdSdk.getConfig()._m;
        List<String> mediaInstalledPackages = ptgCustomController != null ? ptgCustomController.getMediaInstalledPackages() : null;
        if (TextUtil.isEmpty(mediaInstalledPackages) || TextUtil.isNotEmpty(_o1._f)) {
            return;
        }
        try {
            String str = PtgAdSdk.getConfig()._u;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            int iMin = Math.min(jSONArray.length(), 100);
            for (int i = 0; i < iMin; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                String strOptString = jSONObjectOptJSONObject.optString("tagId");
                if (!TextUtils.isEmpty(strOptString) && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(ALPParamConstant.PACKAGENAME)) != null) {
                    int length = jSONArrayOptJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        String string = jSONArrayOptJSONArray.getString(i2);
                        if (!TextUtils.isEmpty(string) && mediaInstalledPackages.contains(string)) {
                            _o1._f.add(strOptString);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
