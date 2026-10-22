package com.fl.saas.s2s.sdk.helper;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdInfoPoJo implements Serializable {
    public long DOWN_TIME;
    public long PROGRESS;
    public long PROGRESS_PART_TIME;
    public long PROGRESS_SEC;
    public long READY_TIME;
    public long UP_TIME;
    public AdInteractiveMode adInteractiveMode;
    public int adv_id;
    public double click_value;
    public Creative creative;
    public int display_mask;
    public String end_html;
    public int height;
    public String hotspot;
    public int hotspot_type;
    public int left_right_margin;
    public String miniPath;
    public String miniProgramOriginId;
    public int price;
    public int rd_auto_time;
    public int rd_auto_type;
    public String rd_autoskip_sts;
    public int rd_click_time;
    public int rd_countdown;
    public int rd_type;
    public int realHeight;
    public int realWidth;
    public long reqTime;
    public int scale_type;
    public int second_price;
    public long showTime;
    public int template_type_id;
    public int top_bottom_margin;
    public String video_url;
    public int width;
    public String wxAppId;
    public String ret = "";
    public String place_id = "";
    public String trackId = "";
    public boolean isApiBidAd = false;
    public int sensitivity = 50;
    public String adid = "0";
    public String ac_type = "";
    public String click_url = "";
    public String deep_url = "";
    public String download_url = "";
    public String app_package = "";
    public String ad_logo = "";
    public String app_name = "";
    public String advertiser_name = "";
    public String app_version = "";
    public String package_size_bytes = "";
    public String permissions_url = "";
    public String privacy_agreement = "";
    public String permission_list = "";
    public String app_intro_url = "";
    public int autoPlayType = 0;
    public int draw_type = 0;
    public List<String> impress_notice_urls = new ArrayList();
    public List<String> click_notice_urls = new ArrayList();
    public List<String> deeplink_notice_urls = new ArrayList();
    public List<String> playing_end_notice_urls = new ArrayList();
    public List<String> download_start_notice_urls = new ArrayList();
    public List<String> download_notice_urls = new ArrayList();
    public List<String> install_start_notice_urls = new ArrayList();
    public List<String> install_end_notice_urls = new ArrayList();
    public List<String> open_notice_urls = new ArrayList();
    public List<String> video_view_urls = new ArrayList();
    public List<String> closes = new ArrayList();
    public List<String> video_start_notice_urls = new ArrayList();
    public List<String> video_first_quartile_notice_urls = new ArrayList();
    public List<String> video_midpoint_notice_urls = new ArrayList();
    public List<String> video_third_quartile_notice_urls = new ArrayList();
    public List<String> video_pause_notice_urls = new ArrayList();
    public List<String> video_fullscreen_notice_urls = new ArrayList();
    public List<String> video_continue_notice_urls = new ArrayList();
    public List<String> video_skip_notice_urls = new ArrayList();
    public List<String> video_mute_notice_urls = new ArrayList();
    public List<String> notice_success_urls = new ArrayList();
    public List<String> notice_failed_urls = new ArrayList();
    public List<String> app_installed_notice_urls = new ArrayList();
    public List<String> dp_attempt_notice_urls = new ArrayList();
    public List<String> dpfail_notice_urls = new ArrayList();
    public String img_url = "";
    public String title = "";
    public int type = 1;
    public String cbr = "";
    public String description = "";
    public String logo_icon = "";
    public String adtype = "2";
    public String clickId = "";
    public int down_x = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
    public int down_y = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
    public int up_x = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
    public int up_y = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
    public int abs_down_x = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
    public int abs_down_y = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
    public int abs_up_x = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
    public int abs_up_y = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
    public int shake_x = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
    public int shake_y = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
    public int shake_z = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
    public int VIDEO_TIME = 0;
    public int BEGIN_TIME = 0;
    public int END_TIME = 0;
    public int PLAY_FIRST_FRAME = 1;
    public int PLAY_LAST_FRAME = 0;
    public int SCENE = 1;
    public int TYPE = 1;
    public int BEHAVIOR = 1;
    public int STATUS = 0;
    public boolean isGDTClick = false;
    public String advName = "广告";
    public boolean isShowDownloadDialog = false;
    public int dp_result = 0;
    public int dp_reason = 0;
    public int rd_skip_time = -1;
    public ClickType clickType = ClickType.NORMAL;
    public int maxShowRatio = 100;
    public String clickArea = "1";
    public String clickIsDp = "2";
    public String adPool = "0";
    public String global_place_id = "";
    public String global_group_id = "";
    public String global_test_id = "";
    public int is_black = 0;
    public int bdt = 0;
    public int post_click_strategy = 0;

    public static class AdInteractiveMode implements Serializable {
        public String normalclick = "";
        public String shake = "";
        public String slideclick = "";
        public String twist = "";
    }

    public enum ClickType {
        NORMAL,
        SHAKE,
        SLIDE
    }

    public static class Creative implements Serializable {
        public String brand;
        public String button;
        public String cid;
        public int ctype;
        public String desc;
        public Img icon;
        public List<Img> imgs;
        public String title;
        public Video video;

        public boolean isVideo() {
            Video video;
            return (this.ctype != 2 || (video = this.video) == null || TextUtils.isEmpty(video.video_url)) ? false : true;
        }
    }

    public static class Img implements Serializable {
        public int height;
        public String url;
        public int width;
    }

    public static class Video implements Serializable {
        public Img cover;
        public int duration;
        public String end_url;
        public int height;
        public long size;
        public String video_url;
        public int width;
    }

    public boolean autoPlayCheckWifi() {
        return this.autoPlayType == 1;
    }

    public int getHotType() {
        return this.hotspot_type;
    }

    public int getShakeSpeed() {
        return this.sensitivity;
    }

    public boolean isAppAd() {
        return "1".equals(this.ac_type) || "6".equals(this.ac_type);
    }

    public boolean isHotArea() {
        return TextUtils.equals("A", this.hotspot);
    }
}
