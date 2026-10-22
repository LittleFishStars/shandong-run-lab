package com.fl.saas.s2s.sdk.helper;

import android.text.TextUtils;
import androidx.arch.core.util.Function;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.Check;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.http.HttpCallbackStringListener;
import com.fl.saas.config.http.NetDataUtils;
import com.fl.saas.config.utils.AesUtils;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.s2s.sdk.helper.S2sRequestHelper;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.kc.openset.sdk.dsp.util.QdActivityType;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class S2sRequestHelper {
    private static S2sRequestHelper sInstance;
    private int adCount;
    private long reqTime;

    /* JADX INFO: Access modifiers changed from: private */
    public void analyzeResponse(String str, OnYqAdListener onYqAdListener, AdSource adSource) {
        int i;
        int i2;
        int i3;
        int iOptInt;
        int i4;
        int i5;
        int iOptInt2;
        String strOptString;
        int i6;
        String str2;
        String str3 = "S";
        if (onYqAdListener == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            onYqAdListener.onAdFailed(YdError.create(20401, "return null-string response"));
            return;
        }
        try {
            JSONObject responseNew = NetDataUtils.parseResponseNew(str);
            int iOptInt3 = responseNew.optInt("code", -1);
            if (iOptInt3 == -1) {
                onYqAdListener.onAdFailed(YdError.create(20401, "ret==" + iOptInt3));
                return;
            }
            JSONArray jSONArrayOptJSONArray = responseNew.optJSONArray("ads");
            ArrayList arrayList = new ArrayList();
            int iOptInt4 = responseNew.optInt("adv_id", 0);
            if (iOptInt4 != 0) {
                adSource.adv_id = iOptInt4;
                adSource.mAdv_id = iOptInt4;
            }
            int iOptInt5 = responseNew.optInt("hotspot_type");
            int iOptInt6 = responseNew.optInt("scale_type");
            String strOptString2 = responseNew.optString("is_download", "S");
            String strOptString3 = responseNew.optString("hotspot");
            if (adSource.isApiBidAd) {
                adSource.parseJson(responseNew);
                int iOptInt7 = responseNew.optInt("sensitivity", 50);
                adSource.setCloseButtonShow(responseNew.optString("close_button_type", "A"));
                adSource.count_down = responseNew.optInt("count_down", 5);
                adSource.button_size = responseNew.optInt("button_size", 50);
                i = iOptInt7;
            } else {
                i = adSource.sensitivity;
            }
            int iOptInt8 = responseNew.optInt("template_type_id");
            int iOptInt9 = responseNew.optInt("left_right_margin");
            String str4 = strOptString2;
            int i7 = i;
            int i8 = iOptInt6;
            int iOptInt10 = responseNew.optInt("top_bottom_margin");
            double dOptDouble = responseNew.optDouble("click_callback_ratio", 100.0d);
            int i9 = adSource.rd_type;
            int i10 = adSource.rd_countdown;
            int i11 = adSource.rd_skip_time;
            int i12 = adSource.rd_click_time;
            int i13 = adSource.rd_auto_type;
            int i14 = adSource.rd_auto_time;
            String str5 = adSource.rd_autoskip_sts;
            if (responseNew.has("rd_countdown")) {
                int iOptInt11 = responseNew.optInt("rd_type", 1);
                int iOptInt12 = responseNew.optInt("rd_countdown", 15);
                iOptInt = responseNew.optInt("rd_skip_time", -1);
                int iOptInt13 = responseNew.optInt("rd_click_time", -1);
                int iOptInt14 = responseNew.optInt("rd_auto_type", 2);
                iOptInt2 = responseNew.optInt("rd_auto_time", 0);
                strOptString = responseNew.optString("rd_autoskip_sts", "S");
                i2 = iOptInt11;
                i3 = iOptInt12;
                i4 = iOptInt13;
                i5 = iOptInt14;
            } else {
                i2 = i9;
                i3 = i10;
                iOptInt = i11;
                i4 = i12;
                i5 = i13;
                iOptInt2 = i14;
                strOptString = str5;
            }
            int iOptInt15 = adSource.display_mask;
            if (responseNew.has("display_mask")) {
                iOptInt15 = responseNew.optInt("display_mask", 1);
            }
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                int i15 = 0;
                while (i15 < jSONArrayOptJSONArray.length()) {
                    AdInfoPoJo adInfoPojo = getAdInfoPojo(jSONArrayOptJSONArray.optJSONObject(i15));
                    adInfoPojo.post_click_strategy = adSource.post_click_strategy;
                    adInfoPojo.bdt = adSource.bdt;
                    adInfoPojo.autoPlayType = responseNew.optInt("auto_play_type", 0);
                    arrayList.add(adInfoPojo);
                    i15++;
                    jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                    iOptInt = iOptInt;
                }
            }
            int i16 = iOptInt;
            if (arrayList.size() == 0) {
                onYqAdListener.onAdFailed(YdError.create(20401, "adInfoList is empty"));
                return;
            }
            int i17 = 0;
            while (i17 < arrayList.size()) {
                arrayList.get(i17).place_id = adSource.place_id;
                arrayList.get(i17).trackId = adSource.track_id;
                if (iOptInt4 != 0) {
                    arrayList.get(i17).adv_id = iOptInt4;
                } else {
                    arrayList.get(i17).adv_id = adSource.adv_id;
                }
                arrayList.get(i17).hotspot = strOptString3;
                arrayList.get(i17).hotspot_type = iOptInt5;
                if (i8 != 0) {
                    i6 = i8;
                    arrayList.get(i17).scale_type = i6;
                } else {
                    i6 = i8;
                    arrayList.get(i17).scale_type = adSource.scale_type;
                }
                arrayList.get(i17).template_type_id = iOptInt8;
                arrayList.get(i17).left_right_margin = iOptInt9;
                int i18 = iOptInt10;
                arrayList.get(i17).top_bottom_margin = i18;
                int i19 = iOptInt8;
                int i20 = i7;
                arrayList.get(i17).sensitivity = i20;
                i7 = i20;
                arrayList.get(i17).isApiBidAd = adSource.isApiBidAd;
                if (str3.equals(adSource.is_download)) {
                    str2 = str4;
                    if (!str3.equals(str2)) {
                    }
                    arrayList.get(i17).rd_type = i2;
                    arrayList.get(i17).rd_countdown = i3;
                    int i21 = i16;
                    arrayList.get(i17).rd_skip_time = i21;
                    int i22 = i3;
                    int i23 = i4;
                    arrayList.get(i17).rd_click_time = i23;
                    i4 = i23;
                    int i24 = i5;
                    arrayList.get(i17).rd_auto_type = i24;
                    int i25 = iOptInt2;
                    arrayList.get(i17).rd_auto_time = i25;
                    String str6 = strOptString;
                    arrayList.get(i17).rd_autoskip_sts = str6;
                    int i26 = iOptInt15;
                    arrayList.get(i17).display_mask = i26;
                    double d = dOptDouble;
                    arrayList.get(i17).click_value = d;
                    i17++;
                    dOptDouble = d;
                    str3 = str3;
                    iOptInt8 = i19;
                    i3 = i22;
                    i5 = i24;
                    iOptInt2 = i25;
                    strOptString = str6;
                    str4 = str2;
                    i8 = i6;
                    iOptInt10 = i18;
                    i16 = i21;
                    iOptInt15 = i26;
                } else {
                    str2 = str4;
                }
                arrayList.get(i17).isShowDownloadDialog = true;
                arrayList.get(i17).rd_type = i2;
                arrayList.get(i17).rd_countdown = i3;
                int i27 = i16;
                arrayList.get(i17).rd_skip_time = i27;
                int i28 = i3;
                int i29 = i4;
                arrayList.get(i17).rd_click_time = i29;
                i4 = i29;
                int i210 = i5;
                arrayList.get(i17).rd_auto_type = i210;
                int i211 = iOptInt2;
                arrayList.get(i17).rd_auto_time = i211;
                String str7 = strOptString;
                arrayList.get(i17).rd_autoskip_sts = str7;
                int i212 = iOptInt15;
                arrayList.get(i17).display_mask = i212;
                double d2 = dOptDouble;
                arrayList.get(i17).click_value = d2;
                i17++;
                dOptDouble = d2;
                str3 = str3;
                iOptInt8 = i19;
                i3 = i28;
                i5 = i210;
                iOptInt2 = i211;
                strOptString = str7;
                str4 = str2;
                i8 = i6;
                iOptInt10 = i18;
                i16 = i27;
                iOptInt15 = i212;
            }
            AdInfoPoJo adInfoPoJo = (AdInfoPoJo) Check.findFirstNonNull(arrayList);
            if (adInfoPoJo != null) {
                adSource.setCtype(adInfoPoJo.creative.ctype);
                adSource.setTitle(adInfoPoJo.title);
                adSource.setDesc(adInfoPoJo.description);
                adSource.isDownLoad = "1".equals(adInfoPoJo.ac_type) && TextUtils.isEmpty(adInfoPoJo.deep_url);
                adSource.is_black = adInfoPoJo.is_black;
            }
            if (TextUtils.equals(responseNew.optString("priority_race"), "A")) {
                final int iOptInt16 = responseNew.optInt("floating_type");
                final int iOptInt17 = responseNew.optInt("floating_value");
                adSource.setPriorityStrategy(new Function() { // from class: com.zj.adlib.vq7
                    @Override // androidx.arch.core.util.Function
                    public final Object apply(Object obj) {
                        return S2sRequestHelper.lambda$analyzeResponse$0(iOptInt16, iOptInt17, (Integer) obj);
                    }
                });
            }
            adSource.price = arrayList.get(0).price;
            if (arrayList.get(0).price > 0 && adSource.isApiBidAd) {
                adSource.bidfloor = arrayList.get(0).price;
            }
            adSource.responseStr = str;
            onYqAdListener.onNativeAdReceived(arrayList);
        } catch (Exception e) {
            e.printStackTrace();
            onYqAdListener.onAdFailed(YdError.create(20401, e.getMessage()));
        }
    }

    private AdInfoPoJo getAdInfoPojo(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        AdInfoPoJo adInfoPoJo = new AdInfoPoJo();
        adInfoPoJo.reqTime = this.reqTime;
        adInfoPoJo.adid = jSONObject.optString("adid");
        adInfoPoJo.advName = jSONObject.optString("adv_name", "广告");
        adInfoPoJo.ac_type = jSONObject.optString("ac_type");
        adInfoPoJo.price = jSONObject.optInt("price");
        adInfoPoJo.click_url = jSONObject.optString("landing_page");
        adInfoPoJo.deep_url = jSONObject.optString("deeplink_url");
        adInfoPoJo.download_url = jSONObject.optString("download_url");
        adInfoPoJo.app_package = jSONObject.optString("app_package");
        adInfoPoJo.ad_logo = jSONObject.optString("ad_logo");
        adInfoPoJo.app_name = jSONObject.optString("app_name");
        adInfoPoJo.advertiser_name = jSONObject.optString("advertiser_name");
        adInfoPoJo.app_version = jSONObject.optString(AlibcCommonConstant.APP_VERSION);
        adInfoPoJo.package_size_bytes = jSONObject.optString("package_size_bytes");
        adInfoPoJo.permissions_url = jSONObject.optString("permissions_url");
        adInfoPoJo.privacy_agreement = jSONObject.optString("privacy_agreement");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("permission_list");
        if (jSONArrayOptJSONArray != null) {
            adInfoPoJo.permission_list = jSONArrayOptJSONArray.toString();
        }
        adInfoPoJo.app_intro_url = jSONObject.optString("app_intro_url");
        adInfoPoJo.wxAppId = jSONObject.optString("wx_app_id");
        adInfoPoJo.miniProgramOriginId = jSONObject.optString("wx_mini_pro_id");
        adInfoPoJo.miniPath = jSONObject.optString("wx_mini_pro_path");
        adInfoPoJo.autoPlayType = jSONObject.optInt("auto_play_type", 0);
        adInfoPoJo.draw_type = jSONObject.optInt("draw_type", 0);
        adInfoPoJo.is_black = jSONObject.optInt("is_black", 0);
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("creative");
        AdInfoPoJo.Creative creative = new AdInfoPoJo.Creative();
        if (jSONObjectOptJSONObject2 != null) {
            creative.cid = jSONObjectOptJSONObject2.optString("cid");
            creative.ctype = jSONObjectOptJSONObject2.optInt("ctype");
            creative.title = jSONObjectOptJSONObject2.optString("title");
            adInfoPoJo.title = jSONObjectOptJSONObject2.optString("title");
            creative.desc = jSONObjectOptJSONObject2.optString("desc");
            adInfoPoJo.description = jSONObjectOptJSONObject2.optString("desc");
            creative.button = jSONObjectOptJSONObject2.optString("button");
            creative.brand = jSONObjectOptJSONObject2.optString("brand");
            jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("video");
        } else {
            jSONObjectOptJSONObject = null;
        }
        AdInfoPoJo.Video video = new AdInfoPoJo.Video();
        if (jSONObjectOptJSONObject != null) {
            video.video_url = jSONObjectOptJSONObject.optString("video_url");
            adInfoPoJo.video_url = jSONObjectOptJSONObject.optString("video_url");
            video.width = jSONObjectOptJSONObject.optInt("width");
            video.height = jSONObjectOptJSONObject.optInt("height");
            video.duration = jSONObjectOptJSONObject.optInt("duration");
            adInfoPoJo.VIDEO_TIME = jSONObjectOptJSONObject.optInt("duration");
            video.size = jSONObjectOptJSONObject.optLong("size");
            video.end_url = jSONObjectOptJSONObject.optString("end_url");
            adInfoPoJo.end_html = jSONObjectOptJSONObject.optString("end_url");
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(AliyunVodHttpCommon.ImageType.IMAGETYPE_COVER);
            if (jSONObjectOptJSONObject3 != null) {
                AdInfoPoJo.Img img = new AdInfoPoJo.Img();
                img.url = jSONObjectOptJSONObject3.optString("url");
                img.width = jSONObjectOptJSONObject3.optInt("width");
                img.height = jSONObjectOptJSONObject3.optInt("height");
                video.cover = img;
            }
            creative.video = video;
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("imgs");
        ArrayList arrayList = new ArrayList();
        AdInfoPoJo.Img img2 = new AdInfoPoJo.Img();
        if (jSONArrayOptJSONArray2 != null) {
            for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
                JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i);
                img2.url = jSONObjectOptJSONObject4.optString("url");
                img2.width = jSONObjectOptJSONObject4.optInt("width");
                img2.height = jSONObjectOptJSONObject4.optInt("height");
                arrayList.add(img2);
                if (i == 0) {
                    adInfoPoJo.img_url = jSONObjectOptJSONObject4.optString("url");
                    adInfoPoJo.width = jSONObjectOptJSONObject4.optInt("width");
                    adInfoPoJo.height = jSONObjectOptJSONObject4.optInt("height");
                }
            }
        }
        creative.imgs = arrayList;
        JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject2.optJSONObject(RemoteMessageConst.Notification.ICON);
        AdInfoPoJo.Img img3 = new AdInfoPoJo.Img();
        if (jSONObjectOptJSONObject5 != null) {
            img3.url = jSONObjectOptJSONObject5.optString("url");
            img3.width = jSONObjectOptJSONObject5.optInt("width");
            img3.height = jSONObjectOptJSONObject5.optInt("height");
            creative.icon = img3;
            adInfoPoJo.logo_icon = jSONObjectOptJSONObject5.optString("url");
        }
        adInfoPoJo.creative = creative;
        AdInfoPoJo.AdInteractiveMode adInteractiveMode = new AdInfoPoJo.AdInteractiveMode();
        JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("ad_interactio_mode");
        if (jSONObjectOptJSONObject6 != null) {
            adInteractiveMode.normalclick = jSONObjectOptJSONObject6.optString("normalclick", "");
            adInteractiveMode.shake = jSONObjectOptJSONObject6.optString("shake", "");
            adInteractiveMode.slideclick = jSONObjectOptJSONObject6.optString("slideclick", "");
            adInteractiveMode.twist = jSONObjectOptJSONObject6.optString("twist", "");
        }
        adInfoPoJo.adInteractiveMode = adInteractiveMode;
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("imp_notice_urls");
        if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray3.length(); i2++) {
                adInfoPoJo.impress_notice_urls.add(jSONArrayOptJSONArray3.optString(i2));
            }
        }
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("notice_success_urls");
        if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray4.length(); i3++) {
                adInfoPoJo.notice_success_urls.add(jSONArrayOptJSONArray4.optString(i3));
            }
        }
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("notice_failed_urls");
        if (jSONArrayOptJSONArray5 != null && jSONArrayOptJSONArray5.length() > 0) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray5.length(); i4++) {
                adInfoPoJo.notice_failed_urls.add(jSONArrayOptJSONArray5.optString(i4));
            }
        }
        JSONArray jSONArrayOptJSONArray6 = jSONObject.optJSONArray("click_notice_urls");
        if (jSONArrayOptJSONArray6 != null && jSONArrayOptJSONArray6.length() > 0) {
            for (int i5 = 0; i5 < jSONArrayOptJSONArray6.length(); i5++) {
                adInfoPoJo.click_notice_urls.add(jSONArrayOptJSONArray6.optString(i5));
            }
        }
        JSONArray jSONArrayOptJSONArray7 = jSONObject.optJSONArray("dpsuccess_notice_urls");
        if (jSONArrayOptJSONArray7 != null && jSONArrayOptJSONArray7.length() > 0) {
            for (int i6 = 0; i6 < jSONArrayOptJSONArray7.length(); i6++) {
                adInfoPoJo.deeplink_notice_urls.add(jSONArrayOptJSONArray7.optString(i6));
            }
        }
        JSONArray jSONArrayOptJSONArray8 = jSONObject.optJSONArray("video_end_notice_urls");
        if (jSONArrayOptJSONArray8 != null && jSONArrayOptJSONArray8.length() > 0) {
            for (int i7 = 0; i7 < jSONArrayOptJSONArray8.length(); i7++) {
                adInfoPoJo.playing_end_notice_urls.add(jSONArrayOptJSONArray8.optString(i7));
            }
        }
        JSONArray jSONArrayOptJSONArray9 = jSONObject.optJSONArray("download_start_notice_urls");
        if (jSONArrayOptJSONArray9 != null && jSONArrayOptJSONArray9.length() > 0) {
            for (int i8 = 0; i8 < jSONArrayOptJSONArray9.length(); i8++) {
                adInfoPoJo.download_start_notice_urls.add(jSONArrayOptJSONArray9.optString(i8));
            }
        }
        JSONArray jSONArrayOptJSONArray10 = jSONObject.optJSONArray("download_end_notice_urls");
        if (jSONArrayOptJSONArray10 != null && jSONArrayOptJSONArray10.length() > 0) {
            for (int i9 = 0; i9 < jSONArrayOptJSONArray10.length(); i9++) {
                adInfoPoJo.download_notice_urls.add(jSONArrayOptJSONArray10.optString(i9));
            }
        }
        JSONArray jSONArrayOptJSONArray11 = jSONObject.optJSONArray("install_start_notice_urls");
        if (jSONArrayOptJSONArray11 != null && jSONArrayOptJSONArray11.length() > 0) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray11.length(); i10++) {
                adInfoPoJo.install_start_notice_urls.add(jSONArrayOptJSONArray11.optString(i10));
            }
        }
        JSONArray jSONArrayOptJSONArray12 = jSONObject.optJSONArray("install_end_notice_urls");
        if (jSONArrayOptJSONArray12 != null && jSONArrayOptJSONArray12.length() > 0) {
            for (int i11 = 0; i11 < jSONArrayOptJSONArray12.length(); i11++) {
                adInfoPoJo.install_end_notice_urls.add(jSONArrayOptJSONArray12.optString(i11));
            }
        }
        JSONArray jSONArrayOptJSONArray13 = jSONObject.optJSONArray("open_notice_urls");
        if (jSONArrayOptJSONArray13 != null && jSONArrayOptJSONArray13.length() > 0) {
            for (int i12 = 0; i12 < jSONArrayOptJSONArray13.length(); i12++) {
                adInfoPoJo.open_notice_urls.add(jSONArrayOptJSONArray13.optString(i12));
            }
        }
        JSONArray jSONArrayOptJSONArray14 = jSONObject.optJSONArray("video_view_urls");
        if (jSONArrayOptJSONArray14 != null && jSONArrayOptJSONArray14.length() > 0) {
            for (int i13 = 0; i13 < jSONArrayOptJSONArray14.length(); i13++) {
                adInfoPoJo.video_view_urls.add(jSONArrayOptJSONArray14.optString(i13));
            }
        }
        JSONArray jSONArrayOptJSONArray15 = jSONObject.optJSONArray("close");
        if (jSONArrayOptJSONArray15 != null && jSONArrayOptJSONArray15.length() > 0) {
            for (int i14 = 0; i14 < jSONArrayOptJSONArray15.length(); i14++) {
                adInfoPoJo.closes.add(jSONArrayOptJSONArray15.optString(i14));
            }
        }
        JSONArray jSONArrayOptJSONArray16 = jSONObject.optJSONArray("video_start_notice_urls");
        if (jSONArrayOptJSONArray16 != null && jSONArrayOptJSONArray16.length() > 0) {
            for (int i15 = 0; i15 < jSONArrayOptJSONArray16.length(); i15++) {
                adInfoPoJo.video_start_notice_urls.add(jSONArrayOptJSONArray16.optString(i15));
            }
        }
        JSONArray jSONArrayOptJSONArray17 = jSONObject.optJSONArray("video_pause_notice_urls");
        if (jSONArrayOptJSONArray17 != null && jSONArrayOptJSONArray17.length() > 0) {
            for (int i16 = 0; i16 < jSONArrayOptJSONArray17.length(); i16++) {
                adInfoPoJo.video_pause_notice_urls.add(jSONArrayOptJSONArray17.optString(i16));
            }
        }
        JSONArray jSONArrayOptJSONArray18 = jSONObject.optJSONArray("video_fullscreen_notice_urls");
        if (jSONArrayOptJSONArray18 != null && jSONArrayOptJSONArray18.length() > 0) {
            for (int i17 = 0; i17 < jSONArrayOptJSONArray18.length(); i17++) {
                adInfoPoJo.video_fullscreen_notice_urls.add(jSONArrayOptJSONArray18.optString(i17));
            }
        }
        JSONArray jSONArrayOptJSONArray19 = jSONObject.optJSONArray("video_continue_notice_urls");
        if (jSONArrayOptJSONArray19 != null && jSONArrayOptJSONArray19.length() > 0) {
            for (int i18 = 0; i18 < jSONArrayOptJSONArray19.length(); i18++) {
                adInfoPoJo.video_continue_notice_urls.add(jSONArrayOptJSONArray19.optString(i18));
            }
        }
        JSONArray jSONArrayOptJSONArray20 = jSONObject.optJSONArray("video_skip_notice_urls");
        if (jSONArrayOptJSONArray20 != null && jSONArrayOptJSONArray20.length() > 0) {
            for (int i19 = 0; i19 < jSONArrayOptJSONArray20.length(); i19++) {
                adInfoPoJo.video_skip_notice_urls.add(jSONArrayOptJSONArray20.optString(i19));
            }
        }
        JSONArray jSONArrayOptJSONArray21 = jSONObject.optJSONArray("video_mute_notice_urls");
        if (jSONArrayOptJSONArray21 != null && jSONArrayOptJSONArray21.length() > 0) {
            for (int i20 = 0; i20 < jSONArrayOptJSONArray21.length(); i20++) {
                adInfoPoJo.video_mute_notice_urls.add(jSONArrayOptJSONArray21.optString(i20));
            }
        }
        JSONArray jSONArrayOptJSONArray22 = jSONObject.optJSONArray("video_first_quartile_notice_urls");
        if (jSONArrayOptJSONArray22 != null && jSONArrayOptJSONArray22.length() > 0) {
            for (int i21 = 0; i21 < jSONArrayOptJSONArray22.length(); i21++) {
                adInfoPoJo.video_first_quartile_notice_urls.add(jSONArrayOptJSONArray22.optString(i21));
            }
        }
        JSONArray jSONArrayOptJSONArray23 = jSONObject.optJSONArray("video_midpoint_notice_urls");
        if (jSONArrayOptJSONArray23 != null && jSONArrayOptJSONArray23.length() > 0) {
            for (int i22 = 0; i22 < jSONArrayOptJSONArray23.length(); i22++) {
                adInfoPoJo.video_midpoint_notice_urls.add(jSONArrayOptJSONArray23.optString(i22));
            }
        }
        JSONArray jSONArrayOptJSONArray24 = jSONObject.optJSONArray("video_third_quartile_notice_urls");
        if (jSONArrayOptJSONArray24 != null && jSONArrayOptJSONArray24.length() > 0) {
            for (int i23 = 0; i23 < jSONArrayOptJSONArray24.length(); i23++) {
                adInfoPoJo.video_third_quartile_notice_urls.add(jSONArrayOptJSONArray24.optString(i23));
            }
        }
        JSONArray jSONArrayOptJSONArray25 = jSONObject.optJSONArray("app_installed_notice_urls");
        if (jSONArrayOptJSONArray25 != null && jSONArrayOptJSONArray25.length() > 0) {
            for (int i24 = 0; i24 < jSONArrayOptJSONArray25.length(); i24++) {
                adInfoPoJo.app_installed_notice_urls.add(jSONArrayOptJSONArray25.optString(i24));
            }
        }
        JSONArray jSONArrayOptJSONArray26 = jSONObject.optJSONArray("dp_attempt_notice_urls");
        if (jSONArrayOptJSONArray26 != null && jSONArrayOptJSONArray26.length() > 0) {
            for (int i25 = 0; i25 < jSONArrayOptJSONArray26.length(); i25++) {
                adInfoPoJo.dp_attempt_notice_urls.add(jSONArrayOptJSONArray26.optString(i25));
            }
        }
        JSONArray jSONArrayOptJSONArray27 = jSONObject.optJSONArray("dpfail_notice_urls");
        if (jSONArrayOptJSONArray27 != null && jSONArrayOptJSONArray27.length() > 0) {
            for (int i26 = 0; i26 < jSONArrayOptJSONArray27.length(); i26++) {
                adInfoPoJo.dpfail_notice_urls.add(jSONArrayOptJSONArray27.optString(i26));
            }
        }
        return adInfoPoJo;
    }

    private JSONObject getImp(AdSource adSource) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("adcount", Integer.valueOf(this.adCount));
            jSONObject.putOpt("adv_id", Integer.valueOf(adSource.adv_id));
            jSONObject.putOpt("tagid", adSource.tagid);
            jSONObject.putOpt("place_id", adSource.place_id);
            jSONObject.putOpt("bidfloor", Integer.valueOf(adSource.bidfloor));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static S2sRequestHelper getInstance() {
        if (sInstance == null) {
            synchronized (S2sRequestHelper.class) {
                sInstance = new S2sRequestHelper();
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$analyzeResponse$0(int i, int i2, Integer num) {
        return Integer.valueOf(i == 1 ? (num.intValue() * (i2 + 1)) / 100 : num.intValue() + i2);
    }

    private JSONObject requestBidParam(AdSource adSource) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", adSource.req_id);
            jSONObject.putOpt("version", "2.9.0");
            jSONObject.putOpt("sdkVersionCode", "29004");
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt("place_id", adSource.tagid);
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt("group_id", adSource.group_id);
            jSONObject.putOpt("test_id", adSource.test_id);
            jSONObject.putOpt("track_id", adSource.track_id);
            jSONObject.putOpt("ishs", Integer.valueOf(adSource.isHot ? 1 : 0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject requestParam(AdSource adSource) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", adSource.req_id);
            jSONObject.putOpt("version", "2.9.0");
            jSONObject.putOpt("sdkVersionCode", "29004");
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt(QdActivityType.IMP, getImp(adSource));
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt("group_id", adSource.group_id);
            jSONObject.putOpt("test_id", adSource.test_id);
            jSONObject.putOpt("track_id", adSource.track_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void requestAd(int i, final AdSource adSource, final OnYqAdListener onYqAdListener) {
        this.adCount = i;
        this.reqTime = DeviceUtil.getBootTime();
        if (adSource == null) {
            if (onYqAdListener == null) {
                return;
            }
            onYqAdListener.onAdFailed(YdError.create(20403, "adSource null"));
        } else {
            if (adSource.getAdCacheBean() != null) {
                analyzeResponse(adSource.getAdCacheBean().getValue(), onYqAdListener, adSource);
                return;
            }
            boolean z = adSource.isApiBidAd;
            if (!z) {
                adSource.isAdxFixed = true;
            }
            String str = z ? CommConstant.API.NEW_API_BID : CommConstant.API.NEW_S2S;
            String strEncrypt = AesUtils.encrypt((z ? requestBidParam(adSource) : requestParam(adSource)).toString());
            HashMap map = new HashMap();
            if (adSource.is_need_header == 1) {
                map.put("test", "1");
            }
            AdHttpUtils.getInstance().doPost(str, map, strEncrypt, new HttpCallbackStringListener() { // from class: com.fl.saas.s2s.sdk.helper.S2sRequestHelper.1
                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onError(Exception exc) {
                    LogcatUtil.e(exc.getMessage());
                    OnYqAdListener onYqAdListener2 = onYqAdListener;
                    if (onYqAdListener2 == null) {
                        return;
                    }
                    onYqAdListener2.onAdFailed(YdError.create(20403, exc.getMessage()));
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onJump(String str2) {
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onSuccess(String str2) {
                    LogcatUtil.d("requestAdxResponse");
                    S2sRequestHelper.this.analyzeResponse(str2, onYqAdListener, adSource);
                }
            });
        }
    }
}
