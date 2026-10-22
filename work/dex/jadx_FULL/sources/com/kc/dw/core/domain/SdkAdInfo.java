package com.kc.dw.core.domain;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.alipay.sdk.m.n.b;
import com.fl.saas.base.cache.DatabaseHelper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.kc.dw.activity.a;
import com.kc.dw.core.loader.AdPlatformError;
import com.kc.dw.core.utils.z;
import com.kc.openset.sdk.dsp.util.QdActivityType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SdkAdInfo {
    private String accept_id;
    private int act_type;
    private int ad_type;
    private boolean alreadyLoaded;
    private String app_id;
    private String app_key;
    private AppendInfo appendInfo;
    private String big_group;
    private String clk;
    private String cls;
    private int codPrice;
    private String config_cls;
    private String custom_ext;
    private int drawing;
    private int ecpm;
    private String err;
    private String[] eventUrl;
    private int expire_timestamp;
    private String failMsg;
    private String finalRsp;
    private String general_ext;
    private String gmShowEcpm;
    private String group;
    private String group_id;
    private String imp;
    private int insert_new;
    private boolean isCache;
    private boolean isCsjGM;
    private boolean isCsjGMBidding;
    private int is_bidding;
    private long loadTime;
    private long loadedTime;
    private int maxPrice;
    private long msLoadedTime;
    private int originEcpm;
    private String pid;
    private int pre;
    private int price;
    private int priority;
    private String req;
    private String req_id;
    private int req_uid;
    private String reward_name;
    private int reward_num;
    private String rsp;
    private String s2sb;
    private String s_code;
    private String s_ext;
    private int score;
    private String sdk;
    private String strategy_dealid;
    private int clk_limit = -1;
    private String otype = "order";
    private String _pst = "__PST__";
    private String _err_pst = "__PST__";
    private String _s = "__S__";
    private String _price = "__PRICE__";
    private int at_rate = 100;
    private int cod = 0;

    @Keep
    public static class GeneralExt {
        private String app_key;

        public String getApp_key() {
            return this.app_key;
        }

        public void setApp_key(String str) {
            this.app_key = str;
        }
    }

    private int dealWithCod(int i, Integer num) {
        if (i > 0 && num != null) {
            try {
                if (num.intValue() <= 100 && num.intValue() >= 0) {
                    return Math.max((int) (((100.0d - ((double) num.intValue())) * ((double) i)) / 100.0d), 0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    public static SdkAdInfo fromJson(String str) {
        Object objOpt;
        SdkAdInfo sdkAdInfo = new SdkAdInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("req_uid")) {
                sdkAdInfo.setReq_uid(jSONObject.optInt("req_uid"));
            }
            if (jSONObject.has("sdk")) {
                sdkAdInfo.setSdk(jSONObject.optString("sdk"));
            }
            int iOptInt = jSONObject.has("cod") ? jSONObject.optInt("cod", 0) : 0;
            sdkAdInfo.setCod(iOptInt);
            if (jSONObject.has("app_id")) {
                sdkAdInfo.setApp_id(jSONObject.optString("app_id"));
            }
            if (jSONObject.has("pid")) {
                sdkAdInfo.setPid(jSONObject.optString("pid"));
            }
            if (jSONObject.has(HiAnalyticsConstant.Direction.REQUEST)) {
                sdkAdInfo.setReq(jSONObject.optString(HiAnalyticsConstant.Direction.REQUEST));
            }
            if (jSONObject.has(HiAnalyticsConstant.Direction.RESPONSE)) {
                sdkAdInfo.setRsp(jSONObject.optString(HiAnalyticsConstant.Direction.RESPONSE));
            }
            if (jSONObject.has("finalRsp")) {
                sdkAdInfo.setFinalRsp(jSONObject.optString("finalRsp"));
            }
            if (jSONObject.has("drawing")) {
                sdkAdInfo.setDrawing(jSONObject.optInt("drawing"));
            }
            if (jSONObject.has(QdActivityType.IMP)) {
                sdkAdInfo.setImp(jSONObject.optString(QdActivityType.IMP));
            }
            if (jSONObject.has("clk")) {
                sdkAdInfo.setClk(jSONObject.optString("clk"));
            }
            if (jSONObject.has(NotificationCompat.CATEGORY_ERROR)) {
                sdkAdInfo.setErr(jSONObject.optString(NotificationCompat.CATEGORY_ERROR));
            }
            if (jSONObject.has("req_id")) {
                sdkAdInfo.setReq_id(jSONObject.optString("req_id"));
            }
            if (jSONObject.has("group")) {
                sdkAdInfo.setGroup(jSONObject.optString("group"));
            }
            if (jSONObject.has("score")) {
                sdkAdInfo.setScore(jSONObject.optInt("score"));
            }
            if (jSONObject.has("price")) {
                sdkAdInfo.setPrice(jSONObject.optInt("price"), iOptInt);
            }
            if (jSONObject.has("ecpm")) {
                sdkAdInfo.setEcpm(jSONObject.optInt("ecpm"));
            }
            if (jSONObject.has("gmShowEcpm")) {
                sdkAdInfo.setGmShowEcpm(jSONObject.optString("gmShowEcpm"));
            }
            if (jSONObject.has("clk_limit")) {
                sdkAdInfo.setClk_limit(jSONObject.optInt("clk_limit", -1));
            }
            if (jSONObject.has("insert_new")) {
                sdkAdInfo.setInsert_new(jSONObject.optInt("insert_new"));
            }
            if (jSONObject.has("s_code")) {
                sdkAdInfo.setS_code(jSONObject.optString("s_code"));
            }
            if (jSONObject.has("s_ext")) {
                sdkAdInfo.setS_ext(jSONObject.optString("s_ext"));
            }
            if (jSONObject.has("reward_name")) {
                sdkAdInfo.setReward_name(jSONObject.optString("reward_name"));
            }
            if (jSONObject.has("reward_num")) {
                sdkAdInfo.setReward_num(jSONObject.optInt("reward_num"));
            }
            if (jSONObject.has("is_bidding")) {
                sdkAdInfo.setIs_bidding(jSONObject.optInt("is_bidding"));
            }
            if (jSONObject.has("accept_id")) {
                sdkAdInfo.setAccept_id(jSONObject.optString("accept_id"));
            }
            if (jSONObject.has("strategy_dealid")) {
                sdkAdInfo.setStrategy_dealid(jSONObject.optString("strategy_dealid"));
            }
            if (jSONObject.has("group_id")) {
                sdkAdInfo.setGroup_id(jSONObject.optString("group_id"));
            }
            if (jSONObject.has("pre")) {
                sdkAdInfo.setPre(jSONObject.optInt("pre"));
            }
            if (jSONObject.has("big_group")) {
                sdkAdInfo.setBig_group(jSONObject.optString("big_group"));
            }
            if (jSONObject.has("otype")) {
                sdkAdInfo.setOtype(jSONObject.optString("otype", "order"));
            }
            if (jSONObject.has("maxPrice")) {
                sdkAdInfo.setMaxPrice(jSONObject.optInt("maxPrice"));
            }
            if (jSONObject.has("loadTime")) {
                sdkAdInfo.setLoadTime(jSONObject.optLong("loadTime"));
            }
            if (jSONObject.has("loadedTime")) {
                sdkAdInfo.setLoadedTime(jSONObject.optLong("loadedTime"));
            }
            if (jSONObject.has("expire_timestamp")) {
                sdkAdInfo.setExpire_timestamp(jSONObject.optInt("expire_timestamp"));
            }
            if (jSONObject.has("priority")) {
                sdkAdInfo.setPriority(jSONObject.optInt("priority"));
            }
            if (jSONObject.has("isCache")) {
                sdkAdInfo.setCache(jSONObject.optBoolean("isCache"));
            }
            if (jSONObject.has("s2sb") && (objOpt = jSONObject.opt("s2sb")) != null && (objOpt instanceof String)) {
                sdkAdInfo.setS2sb(String.valueOf(objOpt));
            }
            if (jSONObject.has("alreadyLoaded")) {
                sdkAdInfo.setAlreadyLoaded(jSONObject.optBoolean("alreadyLoaded"));
            }
            if (jSONObject.has("msLoadedTime")) {
                sdkAdInfo.setMsLoadedTime(jSONObject.optLong("msLoadedTime"));
            }
            if (jSONObject.has("_pst")) {
                sdkAdInfo.set_pst(jSONObject.optString("_pst", "__PST__"));
            }
            if (jSONObject.has("_err_pst")) {
                sdkAdInfo.set_err_pst(jSONObject.optString("_err_pst", "__PST__"));
            }
            if (jSONObject.has("_s")) {
                sdkAdInfo.set_s(jSONObject.optString("_s", "__S__"));
            }
            if (jSONObject.has(DatabaseHelper.COLUMN_PRICE)) {
                sdkAdInfo.set_price(jSONObject.optString(DatabaseHelper.COLUMN_PRICE, "__PRICE__"));
            }
            if (jSONObject.has(b.h)) {
                sdkAdInfo.setApp_key(jSONObject.optString(b.h));
            }
            if (jSONObject.has("cls")) {
                sdkAdInfo.setCls(jSONObject.optString("cls"));
            }
            if (jSONObject.has("config_cls")) {
                sdkAdInfo.setInitCls(jSONObject.optString("config_cls"));
            }
            if (jSONObject.has("custom_ext")) {
                sdkAdInfo.setCustom_ext(jSONObject.optString("custom_ext"));
            }
            if (jSONObject.has("general_ext")) {
                sdkAdInfo.setGeneral_ext(jSONObject.optString("general_ext"));
            }
            if (jSONObject.has("act_type")) {
                sdkAdInfo.setAct_type(jSONObject.optInt("act_type"));
            }
            if (jSONObject.has("ad_type")) {
                sdkAdInfo.setAd_type(jSONObject.optInt("ad_type"));
            }
            if (jSONObject.has("isCsjGM")) {
                sdkAdInfo.setCsjGM(jSONObject.optBoolean("isCsjGM"));
            }
            if (jSONObject.has("isCsjGMBidding")) {
                sdkAdInfo.setCsjGMBidding(jSONObject.optBoolean("isCsjGMBidding"));
            }
            if (jSONObject.has("at_rate")) {
                sdkAdInfo.setAt_rate(jSONObject.optInt("at_rate", 100));
            }
            if (jSONObject.has("eventUrl")) {
                JSONArray jSONArray = jSONObject.getJSONArray("eventUrl");
                String[] strArr = new String[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    strArr[i] = jSONArray.getString(i);
                }
                sdkAdInfo.setEventUrl(strArr);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sdkAdInfo;
    }

    public String getAccept_id() {
        return this.accept_id;
    }

    public int getAct_type() {
        return this.act_type;
    }

    public int getAd_type() {
        return this.ad_type;
    }

    public boolean getAlreadyLoaded() {
        return this.alreadyLoaded;
    }

    public String getApp_id() {
        return this.app_id;
    }

    public String getApp_key() {
        return this.app_key;
    }

    public AppendInfo getAppendInfo() {
        return this.appendInfo;
    }

    public int getAt_rate() {
        return this.at_rate;
    }

    public String getBig_group() {
        return this.big_group;
    }

    public String getClk() {
        return this.clk;
    }

    public int getClk_limit() {
        return this.clk_limit;
    }

    public String getCls() {
        return this.cls;
    }

    public int getCodPrice() {
        return this.codPrice;
    }

    public String getCustom_ext() {
        return this.custom_ext;
    }

    public int getDrawing() {
        return this.drawing;
    }

    public int getEcpm() {
        return "bidding".equals(this.otype) ? this.ecpm : this.codPrice;
    }

    public String getErr() {
        return this.err;
    }

    public String[] getEventUrl() {
        return this.eventUrl;
    }

    public int getExpire_timestamp() {
        return this.expire_timestamp;
    }

    public String getFailMsg() {
        return this.failMsg;
    }

    public String getFinalRsp() {
        return this.finalRsp;
    }

    public String getGeneral_ext() {
        return this.general_ext;
    }

    public String getGmShowEcpm() {
        return this.gmShowEcpm;
    }

    public String getGroup() {
        return this.group;
    }

    public String getGroup_id() {
        return this.group_id;
    }

    public String getImp() {
        return this.imp;
    }

    public String getInitCls() {
        return this.config_cls;
    }

    public int getInsert_new() {
        return this.insert_new;
    }

    public int getIs_bidding() {
        return this.is_bidding;
    }

    public long getLoadTime() {
        return this.loadTime;
    }

    public long getLoadedTime() {
        return this.loadedTime;
    }

    public int getMaxPrice() {
        return this.maxPrice;
    }

    public long getMsLoadedTime() {
        return this.msLoadedTime;
    }

    public int getOriginEcpm() {
        return "bidding".equals(this.otype) ? this.originEcpm : this.price;
    }

    public String getOtype() {
        return this.otype;
    }

    public String getPid() {
        return this.pid;
    }

    public int getPre() {
        return this.pre;
    }

    public int getPrice() {
        return this.price;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getReq() {
        return this.req;
    }

    public String getReq_id() {
        return this.req_id;
    }

    public int getReq_uid() {
        return this.req_uid;
    }

    public String getReward_name() {
        return this.reward_name;
    }

    public int getReward_num() {
        return this.reward_num;
    }

    public String getRsp() {
        return this.rsp;
    }

    public String getS2sb() {
        return this.s2sb;
    }

    public String getS_code() {
        return this.s_code;
    }

    public String getS_ext() {
        return this.s_ext;
    }

    public int getScore() {
        return this.score;
    }

    public String getSdk() {
        return this.sdk;
    }

    public String getStrategy_dealid() {
        return this.strategy_dealid;
    }

    public String get_err_pst() {
        return this._err_pst;
    }

    public String get_price() {
        return this._price;
    }

    public String get_pst() {
        return this._pst;
    }

    public String get_s() {
        return this._s;
    }

    public boolean isCache() {
        return this.isCache;
    }

    public boolean isCsjGM() {
        return this.isCsjGM;
    }

    public boolean isCsjGMBidding() {
        return this.isCsjGMBidding;
    }

    public void replace() {
        String rsp = getRsp();
        String finalRsp = getFinalRsp();
        long jUptimeMillis = SystemClock.uptimeMillis() - getLoadTime();
        set_pst(String.valueOf(jUptimeMillis));
        String strReplace = rsp.replace("__PST__", String.valueOf(jUptimeMillis));
        String strValueOf = String.valueOf(getPrice() * 10);
        if (strReplace.contains("__PRICE__")) {
            StringBuilder sbA = a.a("ssp");
            sbA.append(Base64.encodeToString(strValueOf.getBytes(), 2));
            set_price(sbA.toString());
            strReplace = strReplace.replace("__PRICE__", "ssp" + Base64.encodeToString(strValueOf.getBytes(), 2));
        }
        StringBuilder sbA2 = a.a("ssp");
        sbA2.append(Base64.encodeToString(strValueOf.getBytes(), 2));
        String strReplace2 = finalRsp.replace("__PRICE__", sbA2.toString());
        setRsp(strReplace);
        setFinalRsp(strReplace2);
    }

    public void replaceErrorPst(AdPlatformError adPlatformError) {
        String err = getErr();
        long jUptimeMillis = SystemClock.uptimeMillis() - getLoadTime();
        set_err_pst(String.valueOf(jUptimeMillis));
        if (!TextUtils.isEmpty(err) && err.contains("__PST__")) {
            err = err.replace("__PST__", String.valueOf(jUptimeMillis));
        }
        setErr(err);
        if (!err.contains("__MS_ERRNO__") || adPlatformError == null) {
            return;
        }
        String strReplace = err.replace("__MS_ERRNO__", "1024").replace("__ERROR_CODE__", String.valueOf(adPlatformError.getCode())).replace("__P__", String.valueOf(getPrice())).replace("__TIMEOUT__", String.valueOf(0));
        z.a(strReplace, adPlatformError.getCode(), adPlatformError.getMessage());
        setErr(strReplace);
    }

    public void setAccept_id(String str) {
        this.accept_id = str;
    }

    public void setAct_type(int i) {
        this.act_type = i;
    }

    public void setAd_type(int i) {
        this.ad_type = i;
    }

    public void setAlreadyLoaded(boolean z) {
        this.alreadyLoaded = z;
    }

    public void setApp_id(String str) {
        this.app_id = str;
    }

    public void setApp_key(String str) {
        this.app_key = str;
    }

    public void setAppendInfo(AppendInfo appendInfo) {
        this.appendInfo = appendInfo;
    }

    public void setAt_rate(int i) {
        this.at_rate = i;
    }

    public void setBig_group(String str) {
        this.big_group = str;
    }

    public void setCache(boolean z) {
        this.isCache = z;
    }

    public void setClk(String str) {
        this.clk = str;
    }

    public void setClk_limit(int i) {
        this.clk_limit = i;
    }

    public void setCls(String str) {
        this.cls = str;
    }

    public void setCod(int i) {
        this.cod = i;
    }

    public void setCsjGM(boolean z) {
        this.isCsjGM = z;
    }

    public void setCsjGMBidding(boolean z) {
        this.isCsjGMBidding = z;
    }

    public void setCustom_ext(String str) {
        this.custom_ext = str;
    }

    public void setDrawing(int i) {
        this.drawing = i;
    }

    public void setEcpm(int i) {
        this.ecpm = i;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public void setEcpm(String str) {
        int i;
        try {
            if (TextUtils.isEmpty(str)) {
                i = 0;
            } else {
                try {
                    i = Integer.parseInt(str);
                    if (i < 0) {
                        i = 0;
                    }
                } catch (Exception unused) {
                }
            }
            this.originEcpm = i;
            this.ecpm = dealWithCod(i, Integer.valueOf(this.cod));
            int i2 = this.originEcpm;
            if (i2 <= 0) {
                i2 = this.price;
            }
            String strValueOf = String.valueOf(i2 * 10);
            set_price("ssp" + Base64.encodeToString(strValueOf.getBytes(), 2));
            set_s(str);
            String strReplace = this.rsp.replace("__PRICE__", "ssp" + Base64.encodeToString(strValueOf.getBytes(), 2)).replace("__S__", str);
            String strReplace2 = this.finalRsp.replace("__PRICE__", "ssp" + Base64.encodeToString(strValueOf.getBytes(), 2)).replace("__S__", str);
            String strReplace3 = this.imp.replace("__PRICE__", "ssp" + Base64.encodeToString(strValueOf.getBytes(), 2)).replace("__S__", str);
            int i3 = this.ecpm;
            if (i3 <= 0) {
                i3 = this.codPrice;
            }
            String strReplace4 = strReplace3.replace("__PRE__", "ssp" + Base64.encodeToString(String.valueOf(i3 * 10).getBytes(), 2));
            setRsp(strReplace);
            setFinalRsp(strReplace2);
            setImp(strReplace4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setErr(String str) {
        this.err = str;
    }

    public void setEventUrl(String[] strArr) {
        this.eventUrl = strArr;
    }

    public void setExpire_timestamp(int i) {
        this.expire_timestamp = i;
    }

    public void setFailMsg(String str) {
        this.failMsg = str;
    }

    public void setFinalRsp(String str) {
        this.finalRsp = str;
    }

    public void setGeneral_ext(String str) {
        this.general_ext = str;
    }

    public void setGmShowEcpm(String str) {
        this.gmShowEcpm = str;
    }

    public void setGroup(String str) {
        this.group = str;
    }

    public void setGroup_id(String str) {
        this.group_id = str;
    }

    public void setImp(String str) {
        this.imp = str;
    }

    public void setInitCls(String str) {
        this.config_cls = str;
    }

    public void setInsert_new(int i) {
        this.insert_new = i;
    }

    public void setIs_bidding(int i) {
        this.is_bidding = i;
    }

    public void setLoadTime(long j) {
        this.loadTime = j;
    }

    public void setLoadedTime(long j) {
        this.loadedTime = j;
    }

    public void setMaxPrice(int i) {
        this.maxPrice = i;
    }

    public void setMsLoadedTime(long j) {
        this.msLoadedTime = j;
    }

    public void setOtype(String str) {
        this.otype = str;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public void setPre(int i) {
        this.pre = i;
    }

    public void setPrice(int i, int i2) {
        int iMax = Math.max(i, 0);
        this.price = iMax;
        this.codPrice = dealWithCod(iMax, Integer.valueOf(i2));
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setReq(String str) {
        this.req = str;
    }

    public void setReq_id(String str) {
        this.req_id = str;
    }

    public void setReq_uid(int i) {
        this.req_uid = i;
    }

    public void setReward_name(String str) {
        this.reward_name = str;
    }

    public void setReward_num(int i) {
        this.reward_num = i;
    }

    public void setRsp(String str) {
        this.rsp = str;
    }

    public void setS2sb(String str) {
        this.s2sb = str;
    }

    public void setS_code(String str) {
        this.s_code = str;
    }

    public void setS_ext(String str) {
        this.s_ext = str;
    }

    public void setScore(int i) {
        this.score = i;
    }

    public void setSdk(String str) {
        this.sdk = str;
    }

    public void setStrategy_dealid(String str) {
        this.strategy_dealid = str;
    }

    public void set_err_pst(String str) {
        this._err_pst = str;
    }

    public void set_price(String str) {
        this._price = str;
    }

    public void set_pst(String str) {
        this._pst = str;
    }

    public void set_s(String str) {
        this._s = str;
    }
}
