package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class AdGlobalConfigInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static final long AUTH_SERVICE_TOKEN_CHECK_FAIL = 180003;
    private static final long serialVersionUID = -2622260965144406821L;

    @Nullable
    public AdVideoPreCacheConfig adVideoPreCacheConfig;
    public long authError;
    public CycleAggregationInfo cycleAggregationInfo;
    public int neoPageType;
    public NeoScanAggregationSceneInfo neoScanAggregationSceneInfo;
    public RefreshToken refreshToken;
    public boolean uaidEnable;

    @KsJson
    public static class CycleAggregationInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 6065877559133029298L;
        public int cycleAggregationInterval;
        public boolean cycleAggregationSwitch;
    }

    @KsJson
    public static class NeoScanAggregationSceneInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -4381505798843439175L;
        public boolean guidSwipezShowMore;
        public boolean mute;
        public boolean neoCountDownNeedSwipeTrigger;
        public int neoCountDownTime;
        public boolean noActionStopCountDown;
        public int noActionTime;
    }

    @KsJson
    public static class RefreshToken extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 947047463687920991L;
        public long expire;
        public String serviceToken;
        public String sid;
        public long userId;
        public String userName;

        public long getExpire() {
            return this.expire;
        }

        public String getServiceToken() {
            return this.serviceToken;
        }

        public String getSid() {
            return this.sid;
        }

        public long getUserId() {
            return this.userId;
        }

        public String getUserName() {
            return this.userName;
        }

        public boolean isDataValid() {
            return this.expire > 0 && !TextUtils.isEmpty(this.serviceToken) && !TextUtils.isEmpty(this.sid) && this.userId > 0;
        }
    }

    public boolean isNeoScan() {
        return this.neoPageType == 1;
    }
}
