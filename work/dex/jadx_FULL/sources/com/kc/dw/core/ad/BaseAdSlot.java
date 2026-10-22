package com.kc.dw.core.ad;

import com.kc.dw.core.domain.SsdAdInfo;
import com.kc.dw.platform.ad_adapter.splash.ShakeResult;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class BaseAdSlot implements AdSlot {
    private String act_ext;
    private String action_desc;
    public int adPatternType;
    private int ad_type;
    private String ader_id;
    private int adg;
    private int adp;
    public long allTimes;
    public String appId;
    public String appName;
    private String app_feature;
    private String app_intor_url;
    private String app_intro;
    private List<SsdAdInfo.PermissionBean> app_permission;
    private String app_permission_url;
    private String app_privacy;
    private String app_size;
    private String app_ver;
    private String cat;
    private int cbc;
    private String cid;
    public String[] clickUrl;
    public String clickid;
    private int clkActType;
    private int clkPower;
    public int comments;
    public String[] dUrl;
    private SsdAdInfo.DClickData dclk;
    public String deep_link;
    private String defImage;
    private String default_coord;
    public String desc;
    private String developer;
    private int direct_market;
    public String[] dn_active;
    public String[] dn_inst_start;
    public String[] dn_inst_succ;
    public String[] dn_start;
    public String[] dn_succ;
    public int downNum;
    private String dpSign;
    public String[] dp_fail;
    public String[] dp_start;
    public String[] dp_succ;
    private String dpsign;
    private HashMap<String, String> dynamicMap;
    private int ecpm;
    private String[] errorUrl;
    private String[] eventUrl;
    private int expire_timestamp;
    private Integer fieldExport;
    public String fromLogo;
    public String from_id;
    private String h5_ext;
    private String h5_url;
    private String icon;
    public String iconUrl;
    public String[] imageUrls;
    public int interactionType;
    private boolean isAdClosed;
    private boolean isClkDynamic;
    private boolean isRewardTmpClick;
    private long loadedTime;
    private String[] lossUrl;
    private int material_timeout;
    public String[] monitorUrl;
    private int nativeSE;
    private int nop;
    public String packageName;
    private String payment_types;
    public String posId;
    private int power_count;
    private int power_delay;
    private int power_index;
    private int power_index2;
    private String privacy_agreement;
    private String req_id;
    public String[] responUrl;
    private int reward_tmp_id;
    private int reward_tmp_time;
    private int reward_tmp_type;
    private String reward_tmp_url;
    private Integer rs;
    private String s_code;
    private String s_ext;
    private String scheme;
    public float score;
    private ShakeResult shakeResult;
    public String title;
    private Integer uob;
    public String video_cover;
    private String[] winUrl;
    private String wx_appid;
    private String[] wx_fail;
    private String wx_path;
    private String[] wx_start;
    private String[] wx_succ;
    private String wx_username;
    private int clk_type = 3;
    private int drawing = 2;
    private int act_type = 2;
    private int scale_type = -1;
    private AppendInfo appendInfo = new AppendInfo();

    @Keep
    public static class AppendInfo implements Serializable {
        private static final long serialVersionUID = 1;
        private volatile boolean hasExposed;
        private volatile boolean hasVideoStart;

        public boolean isHasExposed() {
            return this.hasExposed;
        }

        public boolean isHasVideoStart() {
            return this.hasVideoStart;
        }

        public void setHasExposed(boolean z) {
            this.hasExposed = z;
        }

        public void setHasVideoStart(boolean z) {
            this.hasVideoStart = z;
        }
    }

    @Keep
    public abstract class Builder<T extends Builder, K extends BaseAdSlot> {
        public final BaseAdSlot this$0;

        public Builder(BaseAdSlot baseAdSlot) {
            this.this$0 = baseAdSlot;
        }

        public abstract K build();

        public abstract T returnThis();

        public T setActExt(String str) {
            this.this$0.act_ext = str;
            return (T) returnThis();
        }

        public T setActType(int i) {
            this.this$0.act_type = i;
            return (T) returnThis();
        }

        public T setActionDesc(String str) {
            this.this$0.action_desc = str;
            return (T) returnThis();
        }

        public T setAdPatternType(int i) {
            this.this$0.adPatternType = i;
            return (T) returnThis();
        }

        public T setAdType(int i) {
            this.this$0.ad_type = i;
            return (T) returnThis();
        }

        public T setAderId(String str) {
            this.this$0.ader_id = str;
            return (T) returnThis();
        }

        public T setAdg(int i) {
            this.this$0.adg = i;
            return (T) returnThis();
        }

        public T setAdp(int i) {
            this.this$0.adp = i;
            return (T) returnThis();
        }

        public T setAllTimes(long j) {
            this.this$0.allTimes = j;
            return (T) returnThis();
        }

        public T setAppFeature(String str) {
            this.this$0.app_feature = str;
            return (T) returnThis();
        }

        public T setAppId(String str) {
            this.this$0.appId = str;
            return (T) returnThis();
        }

        public T setAppIntro(String str) {
            this.this$0.app_intro = str;
            return (T) returnThis();
        }

        public T setAppIntroUrl(String str) {
            this.this$0.app_intor_url = str;
            return (T) returnThis();
        }

        public T setAppName(String str) {
            this.this$0.appName = str;
            return (T) returnThis();
        }

        public T setAppPrivacy(String str) {
            this.this$0.app_privacy = str;
            return (T) returnThis();
        }

        public T setAppSize(String str) {
            this.this$0.app_size = str;
            return (T) returnThis();
        }

        public T setAppVer(String str) {
            this.this$0.app_ver = str;
            return (T) returnThis();
        }

        public T setCBC(int i) {
            this.this$0.cbc = i;
            return (T) returnThis();
        }

        public T setCat(String str) {
            this.this$0.cat = str;
            return (T) returnThis();
        }

        public T setCid(String str) {
            this.this$0.cid = str;
            return (T) returnThis();
        }

        public T setClickType(int i) {
            this.this$0.clk_type = i;
            return (T) returnThis();
        }

        public T setClickUrl(String[] strArr) {
            this.this$0.clickUrl = strArr;
            return (T) returnThis();
        }

        public T setClickid(String str) {
            this.this$0.clickid = str;
            return (T) returnThis();
        }

        public T setComments(int i) {
            this.this$0.comments = i;
            return (T) returnThis();
        }

        public T setDClickData(SsdAdInfo.DClickData dClickData) {
            this.this$0.dclk = dClickData;
            return (T) returnThis();
        }

        public T setDPSIGN(String str) {
            this.this$0.dpSign = str;
            return (T) returnThis();
        }

        public T setDUrl(String[] strArr) {
            this.this$0.dUrl = strArr;
            return (T) returnThis();
        }

        public T setDeepLink(String str) {
            this.this$0.deep_link = str;
            return (T) returnThis();
        }

        public T setDefImage(String str) {
            this.this$0.defImage = str;
            return (T) returnThis();
        }

        public T setDefaultCoord(String str) {
            this.this$0.default_coord = str;
            return (T) returnThis();
        }

        public T setDesc(String str) {
            this.this$0.desc = str;
            return (T) returnThis();
        }

        public T setDeveloper(String str) {
            this.this$0.developer = str;
            return (T) returnThis();
        }

        public T setDirectMarket(int i) {
            this.this$0.direct_market = i;
            return (T) returnThis();
        }

        public T setDn_active(String[] strArr) {
            this.this$0.dn_active = strArr;
            return (T) returnThis();
        }

        public T setDn_inst_start(String[] strArr) {
            this.this$0.dn_inst_start = strArr;
            return (T) returnThis();
        }

        public T setDn_inst_succ(String[] strArr) {
            this.this$0.dn_inst_succ = strArr;
            return (T) returnThis();
        }

        public T setDn_start(String[] strArr) {
            this.this$0.dn_start = strArr;
            return (T) returnThis();
        }

        public T setDn_succ(String[] strArr) {
            this.this$0.dn_succ = strArr;
            return (T) returnThis();
        }

        public T setDownNum(int i) {
            this.this$0.downNum = i;
            return (T) returnThis();
        }

        public T setDpSign(String str) {
            this.this$0.dpsign = str;
            return (T) returnThis();
        }

        public T setDp_fail(String[] strArr) {
            this.this$0.dp_fail = strArr;
            return (T) returnThis();
        }

        public T setDp_start(String[] strArr) {
            this.this$0.dp_start = strArr;
            return (T) returnThis();
        }

        public T setDp_succ(String[] strArr) {
            this.this$0.dp_succ = strArr;
            return (T) returnThis();
        }

        public T setDrawing(int i) {
            this.this$0.drawing = i;
            return (T) returnThis();
        }

        public T setDynamicMap(HashMap<String, String> map) {
            this.this$0.dynamicMap = map;
            return (T) returnThis();
        }

        public T setEcpm(int i) {
            this.this$0.ecpm = i;
            return (T) returnThis();
        }

        public T setErrorUrl(String[] strArr) {
            this.this$0.errorUrl = strArr;
            return (T) returnThis();
        }

        public T setEventUrl(String[] strArr) {
            this.this$0.eventUrl = strArr;
            return (T) returnThis();
        }

        public T setExpireTimestamp(int i) {
            this.this$0.expire_timestamp = i;
            return (T) returnThis();
        }

        public T setFieldExport(Integer num) {
            this.this$0.fieldExport = num;
            return (T) returnThis();
        }

        public T setFromId(String str) {
            this.this$0.from_id = str;
            return (T) returnThis();
        }

        public T setFromLogo(String str) {
            this.this$0.fromLogo = str;
            return (T) returnThis();
        }

        public T setH5Ext(String str) {
            this.this$0.h5_ext = str;
            return (T) returnThis();
        }

        public T setH5Url(String str) {
            this.this$0.h5_url = str;
            return (T) returnThis();
        }

        public T setIcon(String str) {
            this.this$0.icon = str;
            return (T) returnThis();
        }

        public T setIconUrl(String str) {
            this.this$0.iconUrl = str;
            return (T) returnThis();
        }

        public T setImageUrls(String[] strArr) {
            this.this$0.imageUrls = strArr;
            return (T) returnThis();
        }

        public T setInteractionType(int i) {
            this.this$0.interactionType = i;
            return (T) returnThis();
        }

        public T setLoadedTime(long j) {
            this.this$0.loadedTime = j;
            return (T) returnThis();
        }

        public T setLossUrl(String[] strArr) {
            this.this$0.lossUrl = strArr;
            return (T) returnThis();
        }

        public T setMaterialTimeout(int i) {
            this.this$0.material_timeout = i;
            return (T) returnThis();
        }

        public T setMonitorUrl(String[] strArr) {
            this.this$0.monitorUrl = strArr;
            return (T) returnThis();
        }

        public T setNOP(int i) {
            this.this$0.nop = i;
            return (T) returnThis();
        }

        public T setNativeSE(int i) {
            this.this$0.nativeSE = i;
            return (T) returnThis();
        }

        public T setPackageName(String str) {
            this.this$0.packageName = str;
            return (T) returnThis();
        }

        public T setPaymentTypes(String str) {
            this.this$0.payment_types = str;
            return (T) returnThis();
        }

        public T setPermissionUrl(String str) {
            this.this$0.app_permission_url = str;
            return (T) returnThis();
        }

        public T setPermisssList(List<SsdAdInfo.PermissionBean> list) {
            this.this$0.app_permission = list;
            return (T) returnThis();
        }

        public T setPosId(String str) {
            this.this$0.posId = str;
            return (T) returnThis();
        }

        public T setPowerCount(int i) {
            this.this$0.power_count = i;
            return (T) returnThis();
        }

        public T setPowerDelay(int i) {
            this.this$0.power_delay = i;
            return (T) returnThis();
        }

        public T setPowerIndex(int i) {
            this.this$0.power_index = i;
            return (T) returnThis();
        }

        public T setPowerIndex2(int i) {
            this.this$0.power_index2 = i;
            return (T) returnThis();
        }

        public T setPrivacyAgreement(String str) {
            this.this$0.privacy_agreement = str;
            return (T) returnThis();
        }

        public T setReqId(String str) {
            this.this$0.req_id = str;
            return (T) returnThis();
        }

        public T setResponUrl(String[] strArr) {
            this.this$0.responUrl = strArr;
            return (T) returnThis();
        }

        public T setRewardTmpId(int i) {
            this.this$0.reward_tmp_id = i;
            return (T) returnThis();
        }

        public T setRewardTmpTime(int i) {
            this.this$0.reward_tmp_time = i;
            return (T) returnThis();
        }

        public T setRewardTmpType(int i) {
            this.this$0.reward_tmp_type = i;
            return (T) returnThis();
        }

        public T setRewardTmpUrl(String str) {
            this.this$0.reward_tmp_url = str;
            return (T) returnThis();
        }

        public T setRs(Integer num) {
            this.this$0.rs = num;
            return (T) returnThis();
        }

        public T setS_code(String str) {
            this.this$0.s_code = str;
            return (T) returnThis();
        }

        public T setS_ext(String str) {
            this.this$0.s_ext = str;
            return (T) returnThis();
        }

        public T setScaleType(int i) {
            this.this$0.scale_type = i;
            return (T) returnThis();
        }

        public T setScheme(String str) {
            this.this$0.scheme = str;
            return (T) returnThis();
        }

        public T setScore(float f) {
            this.this$0.score = f;
            return (T) returnThis();
        }

        public T setTitle(String str) {
            this.this$0.title = str;
            return (T) returnThis();
        }

        public T setUob(Integer num) {
            this.this$0.uob = num;
            return (T) returnThis();
        }

        public T setVideo_cover(String str) {
            this.this$0.video_cover = str;
            return (T) returnThis();
        }

        public T setWinUrl(String[] strArr) {
            this.this$0.winUrl = strArr;
            return (T) returnThis();
        }

        public T setWxAppId(String str) {
            this.this$0.wx_appid = str;
            return (T) returnThis();
        }

        public T setWxFail(String[] strArr) {
            this.this$0.wx_fail = strArr;
            return (T) returnThis();
        }

        public T setWxStart(String[] strArr) {
            this.this$0.wx_start = strArr;
            return (T) returnThis();
        }

        public T setWxSuccess(String[] strArr) {
            this.this$0.wx_succ = strArr;
            return (T) returnThis();
        }

        public T setWx_path(String str) {
            this.this$0.wx_path = str;
            return (T) returnThis();
        }

        public T setWx_username(String str) {
            this.this$0.wx_username = str;
            return (T) returnThis();
        }
    }

    public String getAct_ext() {
        return this.act_ext;
    }

    public int getAct_type() {
        return this.act_type;
    }

    public String getAction_desc() {
        return this.action_desc;
    }

    public int getAdPatternType() {
        return this.adPatternType;
    }

    public int getAd_type() {
        return this.ad_type;
    }

    public String getAder_id() {
        return this.ader_id;
    }

    public int getAdg() {
        return this.adg;
    }

    public int getAdp() {
        return this.adp;
    }

    public long getAllTimes() {
        return this.allTimes;
    }

    public String getAppId() {
        return this.appId;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String getAppName() {
        return this.appName;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String getApp_feature() {
        return this.app_feature;
    }

    public String getApp_intor_url() {
        return this.app_intor_url;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String getApp_intro() {
        return this.app_intro;
    }

    public List<SsdAdInfo.PermissionBean> getApp_permission() {
        return this.app_permission;
    }

    public String getApp_permission_url() {
        return this.app_permission_url;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String getApp_privacy() {
        return this.app_privacy;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String getApp_size() {
        return this.app_size;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String getApp_ver() {
        return this.app_ver;
    }

    public AppendInfo getAppendInfo() {
        return this.appendInfo;
    }

    public String getCat() {
        return this.cat;
    }

    public int getCbc() {
        return this.cbc;
    }

    public String getCid() {
        return this.cid;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String[] getClickUrl() {
        return this.clickUrl;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String getClickid() {
        return this.clickid;
    }

    public int getClkActType() {
        return this.clkActType;
    }

    public int getClkPower() {
        return this.clkPower;
    }

    public int getClk_type() {
        return this.clk_type;
    }

    public int getComments() {
        return this.comments;
    }

    public String getDPSIGN() {
        return this.dpSign;
    }

    public SsdAdInfo.DClickData getDclk() {
        return this.dclk;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String getDeep_link() {
        return this.deep_link;
    }

    public String getDefImage() {
        return this.defImage;
    }

    public String getDefault_coord() {
        return this.default_coord;
    }

    public String getDesc() {
        return this.desc;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String getDeveloper() {
        return this.developer;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public int getDirect_market() {
        return this.direct_market;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String[] getDn_active() {
        return new String[0];
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String[] getDn_inst_start() {
        return this.dn_inst_start;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String[] getDn_inst_succ() {
        return this.dn_inst_succ;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String[] getDn_start() {
        return this.dn_start;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String[] getDn_succ() {
        return this.dn_succ;
    }

    public int getDownNum() {
        return this.downNum;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String getDpSign() {
        return this.dpsign;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String[] getDp_fail() {
        return this.dp_fail;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String[] getDp_start() {
        return this.dp_start;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String[] getDp_succ() {
        return this.dp_succ;
    }

    public int getDrawing() {
        return this.drawing;
    }

    public HashMap<String, String> getDynamicMap() {
        return this.dynamicMap;
    }

    public int getEcpm() {
        return this.ecpm;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String[] getErrorUrl() {
        return this.errorUrl;
    }

    public String[] getEventUrl() {
        return this.eventUrl;
    }

    public int getExpire_timestamp() {
        return this.expire_timestamp;
    }

    public Integer getFieldExport() {
        return this.fieldExport;
    }

    public String getFromId() {
        return this.from_id;
    }

    public String getFromLogo() {
        return this.fromLogo;
    }

    public String getH5Ext() {
        return this.h5_ext;
    }

    public String getH5Url() {
        return this.h5_url;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String getIcon() {
        return this.icon;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String[] getImageUrls() {
        return this.imageUrls;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public int getInteractionType() {
        return this.interactionType;
    }

    public boolean getIsAdClosed() {
        return this.isAdClosed;
    }

    public boolean getIsRewardTmpClick() {
        return this.isRewardTmpClick;
    }

    public long getLoadedTime() {
        return this.loadedTime;
    }

    public String[] getLossUrl() {
        return this.lossUrl;
    }

    public int getMaterialTimeout(int i) {
        int i2 = this.material_timeout;
        return i2 > 0 ? i2 : i;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String[] getMonitorUrl() {
        return this.monitorUrl;
    }

    public int getNativeSE() {
        return this.nativeSE;
    }

    public int getNop() {
        return this.nop;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String getPayment_types() {
        return this.payment_types;
    }

    public String getPosId() {
        return this.posId;
    }

    public int getPower_count() {
        return this.power_count;
    }

    public int getPower_delay() {
        return this.power_delay;
    }

    public int getPower_index() {
        return this.power_index;
    }

    public int getPower_index2() {
        int i = this.power_index2;
        return i == 0 ? this.power_index : i;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String getPrivacy_agreement() {
        return this.privacy_agreement;
    }

    public String getReq_id() {
        return this.req_id;
    }

    public String[] getResponUrl() {
        return this.responUrl;
    }

    public int getRewardTmpId() {
        return this.reward_tmp_id;
    }

    public int getReward_tmp_time() {
        return this.reward_tmp_time;
    }

    public int getReward_tmp_type() {
        return this.reward_tmp_type;
    }

    public String getReward_tmp_url() {
        return this.reward_tmp_url;
    }

    public Integer getRs() {
        return this.rs;
    }

    public String getS_code() {
        return this.s_code;
    }

    public String getS_ext() {
        return this.s_ext;
    }

    public int getScale_type() {
        return this.scale_type;
    }

    public String getScheme() {
        return this.scheme;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public float getScore() {
        return this.score;
    }

    public ShakeResult getShakeResult() {
        return this.shakeResult;
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getUob() {
        return this.uob;
    }

    public String getVideo_cover() {
        return this.video_cover;
    }

    public String[] getWinUrl() {
        return this.winUrl;
    }

    public String getWx_appid() {
        return this.wx_appid;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String[] getWx_fail() {
        return this.wx_fail;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String getWx_path() {
        return this.wx_path;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String[] getWx_start() {
        return this.wx_start;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String[] getWx_succ() {
        return this.wx_succ;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String getWx_username() {
        return this.wx_username;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public String[] getdUrl() {
        return this.dUrl;
    }

    public boolean isDynamic() {
        return this.isClkDynamic;
    }

    public void setAct_type(int i) {
        this.act_type = i;
    }

    public void setAdClosed(boolean z) {
        this.isAdClosed = z;
    }

    public void setAdPatternType(int i) {
        this.adPatternType = i;
    }

    public void setAppendInfo(AppendInfo appendInfo) {
        if (appendInfo == null) {
            return;
        }
        this.appendInfo = appendInfo;
    }

    public void setClickUrl(String[] strArr) {
        this.clickUrl = strArr;
    }

    public void setClkActType(int i) {
        this.clkActType = i;
    }

    public void setClkPower(int i) {
        this.clkPower = i;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public void setDp_start(String[] strArr) {
        this.dp_start = strArr;
    }

    public void setDynamic(boolean z) {
        this.isClkDynamic = z;
    }

    public void setHasExposed(boolean z) {
        this.appendInfo.setHasExposed(z);
    }

    public void setHasVideoStart(boolean z) {
        this.appendInfo.setHasVideoStart(z);
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public void setImageUrls(String[] strArr) {
        this.imageUrls = strArr;
    }

    public void setMonitorUrl(String[] strArr) {
        this.monitorUrl = strArr;
    }

    public void setRewardTmpClick(boolean z) {
        this.isRewardTmpClick = z;
    }

    public void setShakeResult(ShakeResult shakeResult) {
        this.shakeResult = shakeResult;
    }

    @Override // com.kc.dw.core.ad.AdSlot
    public void setdUrl(String[] strArr) {
        this.dUrl = strArr;
    }
}
