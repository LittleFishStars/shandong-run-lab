package com.fl.saas.common.saas.bean;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.camera.video.AudioStats;
import com.fl.saas.base.cache.AdCacheBean;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.config.utils.DeviceUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdSource {
    private AdCacheBean adCacheBean;
    public int adHierarchy;
    public int adSizeH;
    public int adSizeW;
    public int ad_style;
    public int ad_type;
    public int animate_start_time;
    public int animate_time;
    private String auto_close;
    public int bidfloor;
    public String bidfloor_filter_sts;
    private CloseButtonPosition button_position;
    public int c2sSumNum;
    private long cacheTime;
    public int close_button_freq;
    public int close_button_interval;
    private int close_countdown;
    public String cp_close_button;
    public int cp_display_countdown;
    private int ctype;
    private String desc;
    public int display_countdown;
    public int display_mask;
    public long distanceFromShowTime;
    private Orientation draw_type;
    private String ext;
    public double floating_value;
    public String hotspot;
    public int hotspot_type;
    public int is_full_screen;
    private int is_gromore;
    public int only_button;
    public int price;
    private Function<Integer, Integer> priorityStrategy;
    public int rd_auto_time;
    public int rd_auto_type;
    public String rd_autoskip_sts;
    public int rd_click_time;
    public int rd_countdown;
    public int rd_type;
    private String red_package_rain;
    public long reqTime;
    public int resp_area_ratio;
    public long responseTime;
    public int scale_type;
    public int sequence;
    public long showTime;
    public int sumNum;
    private String title;
    public int uqfPrice;
    public String responseStr = "";
    public int adv_id = 0;
    public String app_id = "";
    public String app_key = "";
    public String slot_id = "";
    public String tagid = "";
    public String customClassName = "";
    public String req_id = "";
    public String group_id = "";
    public String place_id = "";
    public String test_id = "";
    public int is_contrast = 0;
    public String skip = "S";
    public String is_download = "S";
    public boolean isApiBidAd = false;
    public int mAdv_id = 0;
    public String mTagid = "";
    public boolean isSDKBidAd = false;
    public String token = "";
    public String buyer_id = "";
    public String sdk_info = "";
    public String opensdk_ver = "";
    public String track_id = "";
    public String nurl = "";
    public String lurl = "";
    public String customParameJson = "";
    public boolean isBottomAd = false;
    public boolean isC2SBidAd = false;
    private boolean isCloseButtonShow = false;
    public int count_down = 5;
    public int button_size = 50;
    public int sensitivity = 50;
    public String advName = "广告";
    public String creative_id = "";
    public boolean isTop = false;
    public int c2sSecondPrice = 0;
    public int c2sSecondAdvId = 0;
    public boolean isCacheAd = false;
    public boolean isPopCacheAd = false;
    public boolean isEyeAd = false;
    public boolean isPreload = false;
    public long cost_time = 0;
    public String display_effective_count = "";
    public int rd_skip_time = -1;
    public String adPool = "0";
    public String global_place_id = "";
    public String global_group_id = "";
    public String global_test_id = "";
    public int refresh = 0;
    public int refresh_time = 0;
    public int is_black = 0;
    public boolean is_cycle = false;
    public int style_mix_option = 0;
    public int reward_callback_option = 1;
    public boolean isAdxFixed = false;
    public int uqf = 0;
    public boolean isHot = false;
    public int is_need_header = 0;
    public boolean isDownLoad = false;
    public int bdt = 0;
    public int post_click_strategy = 0;
    public boolean hasClickCallBack = false;

    private String subText(String str, int i) {
        return (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i - 1);
    }

    public void copyAdConfig(AdSource adSource) {
        if (adSource == null) {
            return;
        }
        adSource.setHotSpotValue(this.hotspot);
        adSource.isCloseButtonShow = this.isCloseButtonShow;
        adSource.hotspot_type = this.hotspot_type;
        adSource.scale_type = this.scale_type;
        adSource.setRedPackageRainValue(this.red_package_rain);
        CloseButtonPosition closeButtonPosition = this.button_position;
        if (closeButtonPosition != null) {
            adSource.setCloseButtonPos(closeButtonPosition.getValue());
        }
        Orientation orientation = this.draw_type;
        if (orientation != null) {
            setInterstitialStyle(orientation.getValue());
        }
        adSource.button_size = this.button_size;
        adSource.ad_type = this.ad_type;
        adSource.ad_style = this.ad_style;
        adSource.customClassName = this.customClassName;
        adSource.customParameJson = this.customParameJson;
        adSource.ext = this.ext;
        adSource.auto_close = this.auto_close;
        adSource.is_gromore = this.is_gromore;
        adSource.close_countdown = this.close_countdown;
        adSource.cp_display_countdown = this.cp_display_countdown;
        adSource.cp_close_button = this.cp_close_button;
        adSource.only_button = this.only_button;
        adSource.resp_area_ratio = this.resp_area_ratio;
        adSource.close_button_freq = this.close_button_freq;
        adSource.close_button_interval = this.close_button_interval;
        adSource.display_effective_count = this.display_effective_count;
        adSource.display_countdown = this.display_countdown;
        adSource.animate_start_time = this.animate_start_time;
        adSource.animate_time = this.animate_time;
        adSource.is_full_screen = this.is_full_screen;
        adSource.rd_countdown = this.rd_countdown;
        adSource.rd_type = this.rd_type;
        adSource.rd_skip_time = this.rd_skip_time;
        adSource.rd_click_time = this.rd_click_time;
        adSource.rd_auto_type = this.rd_auto_type;
        adSource.rd_auto_time = this.rd_auto_time;
        adSource.rd_autoskip_sts = this.rd_autoskip_sts;
        adSource.floating_value = this.floating_value;
        adSource.display_mask = this.display_mask;
        adSource.is_black = this.is_black;
        adSource.style_mix_option = this.style_mix_option;
        adSource.reward_callback_option = this.reward_callback_option;
    }

    public boolean equalsAD(AdSource adSource) {
        return adSource != null && this.adv_id == adSource.adv_id && TextUtils.equals(this.tagid, adSource.tagid);
    }

    public AdCacheBean getAdCacheBean() {
        return this.adCacheBean;
    }

    public int getAdStyle() {
        return this.ad_style;
    }

    public int getAdType() {
        return this.ad_type;
    }

    public int getAdvPrice() {
        if (this.isC2SBidAd) {
            double d = this.floating_value;
            if (d != AudioStats.AUDIO_AMPLITUDE_NONE) {
                int i = this.price;
                if (i <= 0) {
                    i = this.bidfloor;
                }
                int i2 = (int) ((((double) i) * (100.0d - d)) / 100.0d);
                if (i2 < 0) {
                    return 0;
                }
                return i2;
            }
        }
        if (this.isAdxFixed) {
            return Math.max(0, this.bidfloor);
        }
        int i3 = this.price;
        return i3 > 0 ? i3 : this.bidfloor;
    }

    public int getAdv_id() {
        return this.adv_id;
    }

    public String getAutoClose() {
        return this.auto_close;
    }

    public int getBidPriceTemp() {
        if (this.uqf == 1) {
            return this.uqfPrice;
        }
        if (this.isC2SBidAd) {
            double d = this.floating_value;
            if (d != AudioStats.AUDIO_AMPLITUDE_NONE) {
                int i = this.price;
                if (i <= 0) {
                    i = this.bidfloor;
                }
                int i2 = (int) ((((double) i) * (100.0d - d)) / 100.0d);
                if (i2 < 0) {
                    return 0;
                }
                return i2;
            }
        }
        if (this.isAdxFixed) {
            return Math.max(0, this.bidfloor);
        }
        int i3 = this.price;
        return i3 > 0 ? i3 : this.bidfloor;
    }

    public long getCatchTime() {
        if (this.cacheTime == 0) {
            this.cacheTime = DeviceUtil.getBootTime();
        }
        return this.cacheTime;
    }

    @NonNull
    public CloseButtonPosition getCloseButtonPos() {
        CloseButtonPosition closeButtonPosition = this.button_position;
        return closeButtonPosition == null ? CloseButtonPosition.FLOAT_TOP_RIGHT : closeButtonPosition;
    }

    public int getCloseCountdown() {
        return this.close_countdown;
    }

    public int getCtype() {
        return this.ctype;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getECPM() {
        return Math.max(0, getAdvPrice());
    }

    public String getExt() {
        return this.ext;
    }

    public Orientation getInterstitialStyle() {
        Orientation orientation = this.draw_type;
        return orientation == null ? Orientation.VERTICAL : orientation;
    }

    public String getPreLoadStr() {
        return this.isPreload ? "1" : "0";
    }

    public int getPrice() {
        if (this.isAdxFixed) {
            return Math.max(0, this.bidfloor);
        }
        int i = this.price;
        if (i <= 0) {
            i = this.bidfloor;
        }
        return Math.max(0, i);
    }

    @Nullable
    public Function<Integer, Integer> getPriorityStrategy() {
        return this.priorityStrategy;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isAutoClose() {
        String str = this.auto_close;
        if (str != null) {
            return "A".equals(str);
        }
        return false;
    }

    public boolean isCloseButtonShow() {
        return this.isCloseButtonShow;
    }

    public boolean isDisplayCountDown() {
        return this.cp_display_countdown == 1;
    }

    public boolean isFilterBidFloor() {
        return "A".equals(this.bidfloor_filter_sts);
    }

    public boolean isFullScreenInterstitial() {
        return this.is_full_screen == 1;
    }

    public boolean isGromore() {
        return this.is_gromore == 1;
    }

    public boolean isHotSpot() {
        return TextUtils.equals(this.hotspot, "A");
    }

    public boolean isLayerSlide() {
        return "A".equals(this.hotspot) && this.hotspot_type == 8;
    }

    public boolean isRedPackageRain() {
        return TextUtils.equals(this.red_package_rain, "A");
    }

    public boolean isUnifiedCloseButtonShow() {
        return TextUtils.equals(this.cp_close_button, "A");
    }

    public boolean needShowShakeTips() {
        return "A".equals(this.hotspot) && this.hotspot_type == 2;
    }

    public boolean needShowSlideTips() {
        return "A".equals(this.hotspot) && this.hotspot_type == 5;
    }

    public Optional<JSONObject> parseCustomJson() {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(this.customParameJson)) {
            jSONObject = null;
        } else {
            try {
                jSONObject = new JSONObject(this.customParameJson);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return Optional.ofNullable(jSONObject);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            setHotSpotValue(jSONObject.optString("hotspot", "S"));
            setRedPackageRainValue(jSONObject.optString("red_package_rain", "S"));
            setCloseButtonPos(jSONObject.optInt("button_position"));
            setInterstitialStyle(jSONObject.optInt("draw_type"));
            this.ad_type = jSONObject.optInt("ad_type", 0);
            this.ad_style = jSONObject.optInt("ad_style", 0);
            this.auto_close = jSONObject.optString("auto_close", "S");
            this.is_gromore = jSONObject.optInt("is_gromore", 0);
            this.close_countdown = jSONObject.optInt("close_countdown", 0);
            this.cp_display_countdown = jSONObject.optInt("cp_display_countdown", 1);
            this.cp_close_button = jSONObject.optString("cp_close_button", "S");
            this.only_button = jSONObject.optInt("only_button", 0);
            this.hotspot_type = jSONObject.optInt("hotspot_type", 1);
            this.scale_type = jSONObject.optInt("scale_type", 0);
            this.resp_area_ratio = jSONObject.optInt("resp_area_ratio", 0);
            this.close_button_freq = jSONObject.optInt("close_button_freq", 0);
            this.close_button_interval = jSONObject.optInt("close_button_interval", 0);
            this.display_effective_count = jSONObject.optString("display_effective_count", "");
            this.display_countdown = jSONObject.optInt("display_countdown", 0);
            this.animate_start_time = jSONObject.optInt("animate_start_time", 500);
            this.animate_time = jSONObject.optInt("animate_time", 5);
            this.is_full_screen = jSONObject.optInt("is_full_screen", 0);
            this.rd_type = jSONObject.optInt("rd_type", 1);
            this.rd_countdown = jSONObject.optInt("rd_countdown", 15);
            this.rd_skip_time = jSONObject.optInt("rd_skip_time", -1);
            this.rd_click_time = jSONObject.optInt("rd_click_time", -1);
            this.rd_auto_type = jSONObject.optInt("rd_auto_type", 2);
            this.rd_auto_time = jSONObject.optInt("rd_auto_time", 0);
            this.rd_autoskip_sts = jSONObject.optString("rd_autoskip_sts", "S");
            this.floating_value = jSONObject.optDouble("floating_value", AudioStats.AUDIO_AMPLITUDE_NONE);
            this.display_mask = jSONObject.optInt("display_mask", 1);
            this.is_black = jSONObject.optInt("is_black", 0);
            this.style_mix_option = jSONObject.optInt("style_mix_option", 0);
            this.reward_callback_option = jSONObject.optInt("reward_callback_option", 1);
            setExt(jSONObject);
        }
    }

    public void setAdCacheBean(AdCacheBean adCacheBean) {
        this.adCacheBean = adCacheBean;
    }

    public void setAdv_id(int i) {
        this.adv_id = i;
    }

    public void setAutoClose(String str) {
        this.auto_close = str;
    }

    public void setCloseButtonPos(int i) {
        this.button_position = CloseButtonPosition.create(i);
    }

    public void setCloseButtonShow(String str) {
        this.isCloseButtonShow = TextUtils.equals(str, "A");
    }

    public void setCloseCountdown(int i) {
        this.close_countdown = i;
    }

    public void setCtype(int i) {
        this.ctype = i;
    }

    public void setDesc(String str) {
        this.desc = subText(str, 30);
    }

    public void setExt(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.ext = jSONObject.optString("ext1");
    }

    public void setHotSpotValue(String str) {
        this.hotspot = str;
    }

    public void setInterstitialStyle(int i) {
        this.draw_type = Orientation.create(i);
    }

    public void setPriorityStrategy(Function<Integer, Integer> function) {
        this.priorityStrategy = function;
    }

    public void setRedPackageRainValue(String str) {
        this.red_package_rain = str;
    }

    public void setTitle(String str) {
        this.title = subText(str, 30);
    }

    public String toString() {
        return "AdSource{adv_id=" + this.adv_id + ", app_id='" + this.app_id + "', ad_style='" + this.ad_style + "', app_key='" + this.app_key + "', tagid='" + this.tagid + "', customClassName='" + this.customClassName + "', req_id='" + this.req_id + "', isApiBidAd=" + this.isApiBidAd + ", price=" + getAdvPrice() + ", isSDKBidAd=" + this.isSDKBidAd + ", isBottomAd=" + this.isBottomAd + ", isC2SBidAd=" + this.isC2SBidAd + ", isTop=" + this.isTop + ", isCacheAd=" + this.isCacheAd + ", isPreload=" + this.isPreload + '}';
    }
}
