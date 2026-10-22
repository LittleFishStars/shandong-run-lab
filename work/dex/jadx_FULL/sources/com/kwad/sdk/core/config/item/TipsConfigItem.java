package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.ac;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class TipsConfigItem extends b<TipConfigData> {

    public static class TipConfigData implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 268961350883157950L;
        private String tipInfo;
        private transient Map<String, String> tipMap = new HashMap();
        private int tipShowSwitch;

        private void genTipMap(JSONObject jSONObject) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                this.tipMap.put(next, jSONObject.optString(next, ""));
            }
        }

        @Nullable
        public String getTipInfoData() {
            return this.tipInfo;
        }

        public int getTipShowSwitch() {
            return this.tipShowSwitch;
        }

        public String getTips(String str) {
            return this.tipMap.get(str);
        }

        public boolean isShowTips() {
            return this.tipShowSwitch == 0;
        }

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            setTipInfoData(jSONObject.optString("tipInfo"));
            this.tipShowSwitch = jSONObject.optInt("tipShowSwitch", 0);
        }

        public void setTipInfoData(String str) {
            this.tipInfo = str;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str)) {
                return;
            }
            try {
                genTipMap(new JSONObject(str));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
        }

        public void setTipShowSwitch(int i) {
            this.tipShowSwitch = i;
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            ac.putValue(jSONObject, "tipShowSwitch", this.tipShowSwitch);
            ac.putValue(jSONObject, "tipInfo", this.tipInfo);
            return jSONObject;
        }
    }

    public TipsConfigItem() {
        super("tipConfig", new TipConfigData());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        TipConfigData value = getValue();
        if (value == null) {
            value = new TipConfigData();
        }
        value.setTipShowSwitch(sharedPreferences.getInt("tipsSwitch", 0));
        value.setTipInfoData(sharedPreferences.getString("tipsInfo", ""));
        setValue(value);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putInt("tipsSwitch", getValue().getTipShowSwitch());
        if (getValue().getTipInfoData() != null) {
            editor.putString("tipsInfo", getValue().getTipInfoData());
        } else {
            editor.putString("tipsInfo", "");
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void l(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject(getKey())) == null) {
            setValue(Lc());
            return;
        }
        TipConfigData tipConfigData = new TipConfigData();
        tipConfigData.parseJson(jSONObjectOptJSONObject);
        setValue(tipConfigData);
    }
}
