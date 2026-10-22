package com.fl.saas.common.saas.bean;

import com.fl.saas.base.rest.ConfigHelper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdPlace {
    public List<AdSource> ad_sources;
    public ArrayList<Integer> advCacheabledList;
    public List<AdSource> bid_ad_sources;
    public int bid_notice_type;
    public List<AdSource> bottom_ad_sources;
    public List<AdSource> c2s_bid_ad_sources;
    public String group_id;
    public int impress_freq_day;
    public int impress_freq_hour;
    public int impress_interval;
    public String place_id;
    public int refresh_num;
    public String req_id;
    public long request_logic;
    private String sourceStr;
    public String test_id;
    public String track_id;
    public long update_time;
    public int all_time = 30000;
    public int request_num = 1;
    public int api_timeout = 3000;
    public boolean isOpenCache = false;
    public int enhanceTarget = 0;
    public double floatingRatio = 1.0d;
    public long cacheValidTime = 0;
    public boolean has_api_bid = false;
    public int timeout = 3000;
    public int requestInterval = 500;
    public int client_timeout = 5000;
    public boolean server_verify = false;
    public int server_verify_time = 0;
    public int cache_queue_length = 1;
    public int use_public_adplace = 1;
    public int rela_public_adplace = 0;
    public int is_contrast = 0;
    public int lbs = 0;
    public int lbjg = 0;
    public int lbsx = 3;
    public int highest_bid_difference = 0;
    public int refresh = 0;
    public int refresh_time = 0;
    public int verify_ad_refresh = 0;
    public int fill_price = 1;
    public int is_need_header = 0;
    public int bdt = 0;
    public int post_click_strategy = 0;
    public boolean isHot = false;

    public AdPlace cloneObject(String str) {
        try {
            return ConfigHelper.getInstance().handleData(new JSONObject(this.sourceStr), str, this.place_id);
        } catch (Exception e) {
            e.printStackTrace();
            return this;
        }
    }

    public boolean isBidding() {
        List<AdSource> list = this.bid_ad_sources;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean isCachedECPMFirst() {
        return this.enhanceTarget == 2;
    }

    public boolean isCachedSpeedFirst() {
        return this.enhanceTarget == 1;
    }

    public boolean isOpenCycle() {
        return this.lbs == 1 && this.lbjg > 0;
    }

    public boolean isOpenPlaceCache() {
        return this.isOpenCache;
    }

    public void setSourceStr(String str) {
        this.sourceStr = str;
    }

    public String toString() {
        return "AdPlace{ad_sources=" + this.ad_sources + ", all_time=" + this.all_time + ", group_id='" + this.group_id + "', place_id='" + this.place_id + "', request_num=" + this.request_num + ", timeout=" + this.timeout + '}';
    }
}
