package com.beizi.fusion.model;

import androidx.annotation.NonNull;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.permission.b;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.beizi.fusion.asnp.adn.ad.model.impl.db.StrategyEventDBModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.layout.LayoutModel;
import com.byazt.bv.BaseConstants;
import com.byazt.dyf.tt;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huachenjie.run.page.activities_run.dialog.MoreDistanceDialog;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ipd.dsp.internal.e1.f;
import com.ipd.dsp.internal.l.a;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AdSpacesBean {
    public static final int DIRECT_DOWNLOAD_APP_DECIDE = 0;
    public static final int DIRECT_DOWNLOAD_SERVER_NO = 1;
    public static final int DIRECT_DOWNLOAD_SERVER_YES = 2;

    @JsonNode(key = "adType")
    private String adType;

    @JsonNode(key = "appId")
    private String appId;

    @JsonNode(key = "bid")
    private BidBean bid;

    @JsonNode(key = "bidComponent")
    private BidComponent bidComponent;

    @JsonNode(key = "buyer")
    private List<BuyerBean> buyer;

    @JsonNode(key = "bzComponentSsid")
    private String bzComponentSsid;

    @JsonNode(key = AlibcProtocolConstant.CALL_TYPE_COMPONENT)
    private ComponentBean component;

    @JsonNode(key = "componentSsid")
    private String componentSsid;

    @JsonNode(key = "eventStrategy")
    private EventStrategyBean eventStrategy;

    @JsonNode(key = "filter")
    private FilterBean filter;

    @JsonNode(key = "filterSsid")
    private String filterSsid;

    @JsonNode(key = "modelType")
    private int modelType;

    @JsonNode(key = StrategyEventDBModel.COLUMN_SPACE_ID)
    private String spaceId;

    @JsonNode(key = "switchFiveVersion")
    private int switchFiveVersion;

    public static class AdSizeBean {

        @JsonNode(key = "height")
        private String height;

        @JsonNode(key = "width")
        private String width;

        public static AdSizeBean objectFromData(String str) {
            try {
                return (AdSizeBean) JsonResolver.fromJson(str, AdSizeBean.class);
            } catch (Exception unused) {
                return null;
            }
        }

        public String getHeight() {
            return this.height;
        }

        public String getWidth() {
            return this.width;
        }

        public void setHeight(String str) {
            this.height = str;
        }

        public void setWidth(String str) {
            this.width = str;
        }

        public String toString() {
            return "AdSizeBean{, width=" + this.width + ", height=" + this.height + '}';
        }
    }

    public static class BidBean {

        @JsonNode(key = "bidTime")
        private int bidTime;

        @JsonNode(key = "reserveFRWTime")
        private int reserveFRWTime;

        @JsonNode(key = "reserveTime")
        private int reserveTime;

        @JsonNode(key = "timeOut")
        private int timeOut;

        public static BidBean objectFromData(String str) {
            try {
                return (BidBean) JsonResolver.fromJson(str, BidBean.class);
            } catch (Exception unused) {
                return null;
            }
        }

        public int getBidTime() {
            return this.bidTime;
        }

        public int getReserveFRWTime() {
            return this.reserveFRWTime;
        }

        public int getReserveTime() {
            return this.reserveTime;
        }

        public int getTimeOut() {
            return this.timeOut;
        }

        public void setBidTime(int i) {
            this.bidTime = i;
        }

        public void setReserveFRWTime(int i) {
            this.reserveFRWTime = i;
        }

        public void setReserveTime(int i) {
            this.reserveTime = i;
        }

        public void setTimeOut(int i) {
            this.timeOut = i;
        }

        public String toString() {
            return "BidBean{reserveFRWTime=" + this.reserveFRWTime + ", reserveTime=" + this.reserveTime + ", bidTime=" + this.bidTime + ", timeOut=" + this.timeOut + '}';
        }
    }

    public static class BidComponent {

        @JsonNode(key = "bidList")
        private List<ForwardBean> bidList;

        @JsonNode(key = "rules")
        private List<RulesBean> rules;

        public List<ForwardBean> getBidList() {
            return this.bidList;
        }

        public List<RulesBean> getRules() {
            return this.rules;
        }

        public void setBidList(List<ForwardBean> list) {
            this.bidList = list;
        }

        public void setRules(List<RulesBean> list) {
            this.rules = list;
        }

        public String toString() {
            return "BidComponent{rules=" + this.rules + ", bidList=" + this.bidList + '}';
        }
    }

    public static class BuyerBean implements Cloneable {

        @JsonNode(key = "adSize")
        private AdSizeBean adSize;

        @JsonNode(key = "adType")
        private String adType;

        @JsonNode(key = "adWorker")
        private String adWorker;

        @JsonNode(key = "appId")
        private String appId;

        @JsonNode(key = "avgPrice")
        private double avgPrice;

        @JsonNode(key = "bidPrice")
        private double bidPrice;

        @JsonNode(key = "bidType")
        private String bidType;

        @JsonNode(key = "buyerSpaceUuId")
        private String buyerSpaceUuId;

        @JsonNode(key = "cache")
        private int cache;

        @JsonNode(key = "cacheNum")
        private int cacheNum;

        @JsonNode(key = "callBackStrategy")
        private List<CallBackStrategyBean> callBackStrategy;

        @JsonNode(key = "callBackStrategyUuid")
        private String callBackStrategyUuid;

        @JsonNode(key = "complain")
        private ComplainBean complain;

        @JsonNode(key = "directDownload")
        private int directDownload;

        @JsonNode(key = tt.AD_TAG_DISLIKE)
        private DislikeConfigBean dislikeConfig;

        @JsonNode(key = "eulerAngleRule")
        private EulerAngleViewBean eulerAngleRule;

        @JsonNode(key = "filter")
        private FilterBean filter;

        @JsonNode(key = "filterSsid")
        private String filterSsid;

        @JsonNode(key = "fullScreenClick")
        private FullScreenClickBean fullScreenClick;

        @JsonNode(key = "id")
        private String id;

        @JsonNode(key = "interactionRules")
        private List<RenderRulesBean> interactionRules;

        @JsonNode(key = "isAnimation")
        private int isAnimation;

        @JsonNode(key = "isHideInteraction")
        private int isHideInteraction;

        @JsonNode(key = "isImageSpeed")
        private int isImageSpeed;

        @JsonNode(key = "isPlaceHolder")
        private int isPlaceHolder;

        @JsonNode(key = "isSendBidData")
        private int isSendBidData;

        @JsonNode(key = "lastTime")
        private int lastTime;

        @JsonNode(key = "minShowTime")
        private int minShowTime;

        @JsonNode(key = "nativeOptimize")
        private NativeOptimizeBean nativeOptimize;

        @JsonNode(key = "nativeRule")
        private NativeRuleBean nativeRule;

        @JsonNode(key = "priceDict")
        private List<PriceDictBean> priceDict;

        @JsonNode(key = "regionalClickView")
        private RegionalClickViewBean regionalClickView;

        @JsonNode(key = "renderAds")
        private RenderAds renderAds;

        @JsonNode(key = "renderView")
        private List<RenderViewBean> renderView;

        @JsonNode(key = "renderViewSsid")
        private String renderViewSsid;

        @JsonNode(key = "reqTimeOutType")
        private int reqTimeOutType;

        @JsonNode(key = "rollView")
        private RollViewBean rollView;

        @JsonNode(key = "screenConfigVo")
        private List<ScreenConfigVoBean> screenConfigVo;

        @JsonNode(key = "scrollClick")
        private ScrollClickBean scrollClick;

        @JsonNode(key = "shakeView")
        private ShakeViewBean shakeView;

        @JsonNode(key = "sizeRatio")
        private int sizeRatio;

        @JsonNode(key = StrategyEventDBModel.COLUMN_SPACE_ID)
        private String spaceId;

        @JsonNode(key = "template")
        private int template;

        @JsonNode(key = HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME)
        private int waitTime;

        @JsonNode(key = "zone")
        private String zone;

        public static class AliaseShakeViewBean {

            @JsonNode(key = "passivationTime")
            private int passivationTime;

            @JsonNode(key = "rotatAmplitude")
            private double rotatAmplitude;

            @JsonNode(key = "rotatCount")
            private int rotatCount;

            @JsonNode(key = "shakeCount")
            private int shakeCount;

            @JsonNode(key = "shakeEndAmplitude")
            private double shakeEndAmplitude;

            @JsonNode(key = "shakeStartAmplitude")
            private double shakeStartAmplitude;

            public int getPassivationTime() {
                return this.passivationTime;
            }

            public double getRotatAmplitude() {
                return this.rotatAmplitude;
            }

            public int getRotatCount() {
                return this.rotatCount;
            }

            public int getShakeCount() {
                return this.shakeCount;
            }

            public double getShakeEndAmplitude() {
                return this.shakeEndAmplitude;
            }

            public double getShakeStartAmplitude() {
                return this.shakeStartAmplitude;
            }

            public void setPassivationTime(int i) {
                this.passivationTime = i;
            }

            public void setRotatAmplitude(double d) {
                this.rotatAmplitude = d;
            }

            public void setRotatCount(int i) {
                this.rotatCount = i;
            }

            public void setShakeCount(int i) {
                this.shakeCount = i;
            }

            public void setShakeEndAmplitude(double d) {
                this.shakeEndAmplitude = d;
            }

            public void setShakeStartAmplitude(double d) {
                this.shakeStartAmplitude = d;
            }
        }

        public static class CoolRollViewBean {

            @JsonNode(key = "coolTime")
            private long coolTime;

            @JsonNode(key = "rollMinusAmplitude")
            private double rollMinusAmplitude;

            @JsonNode(key = "rollPlusAmplitude")
            private double rollPlusAmplitude;

            @JsonNode(key = "rollTime")
            private long rollTime;

            @JsonNode(key = "userProtectTime")
            private long userProtectTime;

            public long getCoolTime() {
                return this.coolTime;
            }

            public double getRollMinusAmplitude() {
                return this.rollMinusAmplitude;
            }

            public double getRollPlusAmplitude() {
                return this.rollPlusAmplitude;
            }

            public long getRollTime() {
                return this.rollTime;
            }

            public long getUserProtectTime() {
                return this.userProtectTime;
            }

            public void setCoolTime(long j) {
                this.coolTime = j;
            }

            public void setRollMinusAmplitude(double d) {
                this.rollMinusAmplitude = d;
            }

            public void setRollPlusAmplitude(double d) {
                this.rollPlusAmplitude = d;
            }

            public void setRollTime(long j) {
                this.rollTime = j;
            }

            public void setUserProtectTime(long j) {
                this.userProtectTime = j;
            }
        }

        public static class CoolShakeViewBean {

            @JsonNode(key = "coolTime")
            private long coolTime;

            @JsonNode(key = "feedback")
            private int feedback;

            @JsonNode(key = "rotatAmplitude")
            private double rotatAmplitude;

            @JsonNode(key = "rotatCount")
            private int rotatCount;

            @JsonNode(key = "shakeCount")
            private int shakeCount;

            @JsonNode(key = "shakeEndAmplitude")
            private double shakeEndAmplitude;

            @JsonNode(key = "shakeStartAmplitude")
            private double shakeStartAmplitude;

            @JsonNode(key = "userProtectTime")
            private long userProtectTime;

            public long getCoolTime() {
                return this.coolTime;
            }

            public int getFeedback() {
                return this.feedback;
            }

            public double getRotatAmplitude() {
                return this.rotatAmplitude;
            }

            public int getRotatCount() {
                return this.rotatCount;
            }

            public int getShakeCount() {
                return this.shakeCount;
            }

            public double getShakeEndAmplitude() {
                return this.shakeEndAmplitude;
            }

            public double getShakeStartAmplitude() {
                return this.shakeStartAmplitude;
            }

            public long getUserProtectTime() {
                return this.userProtectTime;
            }

            public void setCoolTime(long j) {
                this.coolTime = j;
            }

            public void setFeedback(int i) {
                this.feedback = i;
            }

            public void setRotatAmplitude(double d) {
                this.rotatAmplitude = d;
            }

            public void setRotatCount(int i) {
                this.rotatCount = i;
            }

            public void setShakeCount(int i) {
                this.shakeCount = i;
            }

            public void setShakeEndAmplitude(double d) {
                this.shakeEndAmplitude = d;
            }

            public void setShakeStartAmplitude(double d) {
                this.shakeStartAmplitude = d;
            }

            public void setUserProtectTime(long j) {
                this.userProtectTime = j;
            }
        }

        public static class DislikeConfigBean {

            @JsonNode(key = "coolTime")
            private long coolTime;

            @JsonNode(key = "dislikeUuid")
            private String dislikeUuid;

            @JsonNode(key = "isHide")
            private int isHide;

            @JsonNode(key = "isShowDialog")
            private int isShowDialog;

            @JsonNode(key = "orderData")
            private List<OrderDataDislikeConfigBean> orderData;

            @JsonNode(key = "randomNum")
            private int randomNum;

            public long getCoolTime() {
                return this.coolTime;
            }

            public String getDislikeUuid() {
                return this.dislikeUuid;
            }

            public int getIsHide() {
                return this.isHide;
            }

            public int getIsShowDialog() {
                return this.isShowDialog;
            }

            public List<OrderDataDislikeConfigBean> getOrderData() {
                return this.orderData;
            }

            public int getRandomNum() {
                return this.randomNum;
            }

            public void setCoolTime(long j) {
                this.coolTime = j;
            }

            public void setDislikeUuid(String str) {
                this.dislikeUuid = str;
            }

            public void setIsHide(int i) {
                this.isHide = i;
            }

            public void setIsShowDialog(int i) {
                this.isShowDialog = i;
            }

            public void setOrderData(List<OrderDataDislikeConfigBean> list) {
                this.orderData = list;
            }

            public void setRandomNum(int i) {
                this.randomNum = i;
            }
        }

        public static class EulerAngleRenderBean {

            @JsonNode(key = LayoutModel.MODEL_KEY_CENTER_X)
            private String centerX;

            @JsonNode(key = LayoutModel.MODEL_KEY_CENTER_Y)
            private String centerY;

            @JsonNode(key = "color")
            private String color;

            @JsonNode(key = "height")
            private String height;

            @JsonNode(key = "width")
            private String width;

            public String getCenterX() {
                return this.centerX;
            }

            public String getCenterY() {
                return this.centerY;
            }

            public String getColor() {
                return this.color;
            }

            public String getHeight() {
                return this.height;
            }

            public String getWidth() {
                return this.width;
            }

            public void setCenterX(String str) {
                this.centerX = str;
            }

            public void setCenterY(String str) {
                this.centerY = str;
            }

            public void setColor(String str) {
                this.color = str;
            }

            public void setHeight(String str) {
                this.height = str;
            }

            public void setWidth(String str) {
                this.width = str;
            }
        }

        public static class EulerAngleRuleBean {

            @JsonNode(key = "angle")
            private double angle;

            @JsonNode(key = "axis")
            private String axis;

            @JsonNode(key = HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)
            private String direction;

            @JsonNode(key = MediationConstant.ADN_PANGLE)
            private double pangle;

            public double getAngle() {
                return this.angle;
            }

            public String getAxis() {
                return this.axis;
            }

            public String getDirection() {
                return this.direction;
            }

            public double getPangle() {
                return this.pangle;
            }

            public void setAngle(double d) {
                this.angle = d;
            }

            public void setAxis(String str) {
                this.axis = str;
            }

            public void setDirection(String str) {
                this.direction = str;
            }

            public void setPangle(double d) {
                this.pangle = d;
            }
        }

        public static class EulerAngleStyleBean {

            @JsonNode(key = "downloadSubTitle")
            private String downloadSubTitle;

            @JsonNode(key = "imgs")
            private List<String> imgs;

            @JsonNode(key = RVParams.LONG_SUB_TITLE)
            private String subTitle;

            @JsonNode(key = "title")
            private String title;

            public String getDownloadSubTitle() {
                return this.downloadSubTitle;
            }

            public List<String> getImgs() {
                return this.imgs;
            }

            public String getSubTitle() {
                return this.subTitle;
            }

            public String getTitle() {
                return this.title;
            }

            public void setDownloadSubTitle(String str) {
                this.downloadSubTitle = str;
            }

            public void setImgs(List<String> list) {
                this.imgs = list;
            }

            public void setSubTitle(String str) {
                this.subTitle = str;
            }

            public void setTitle(String str) {
                this.title = str;
            }
        }

        public static class EulerAngleViewBean {

            @JsonNode(key = "coolRule")
            private EulerAngleViewRuleBean coolRule;

            @JsonNode(key = "eulerAngleUuid")
            private String eulerAngleUuid;

            @JsonNode(key = "nomalRule")
            private EulerAngleViewRuleBean nomalRule;

            @JsonNode(key = "orderData")
            private List<OrderDataEulerAngleViewBean> orderData;

            @JsonNode(key = "render")
            private EulerAngleRenderBean render;

            public EulerAngleViewRuleBean getCoolRule() {
                return this.coolRule;
            }

            public String getEulerAngleUuid() {
                return this.eulerAngleUuid;
            }

            public EulerAngleViewRuleBean getNomalRule() {
                return this.nomalRule;
            }

            public List<OrderDataEulerAngleViewBean> getOrderData() {
                return this.orderData;
            }

            public EulerAngleRenderBean getRender() {
                return this.render;
            }

            public void setCoolRule(EulerAngleViewRuleBean eulerAngleViewRuleBean) {
                this.coolRule = eulerAngleViewRuleBean;
            }

            public void setEulerAngleUuid(String str) {
                this.eulerAngleUuid = str;
            }

            public void setNomalRule(EulerAngleViewRuleBean eulerAngleViewRuleBean) {
                this.nomalRule = eulerAngleViewRuleBean;
            }

            public void setOrderData(List<OrderDataEulerAngleViewBean> list) {
                this.orderData = list;
            }

            public void setRender(EulerAngleRenderBean eulerAngleRenderBean) {
                this.render = eulerAngleRenderBean;
            }
        }

        public static class EulerAngleViewRuleBean {

            @JsonNode(key = "coolTime")
            private long coolTime;

            @JsonNode(key = "passivationTime")
            private int passivationTime;

            @JsonNode(key = "rules")
            private List<EulerAngleRuleBean> rules;

            @JsonNode(key = "style")
            private EulerAngleStyleBean style;

            @JsonNode(key = "userProtectTime")
            private long userProtectTime;

            public long getCoolTime() {
                return this.coolTime;
            }

            public int getPassivationTime() {
                return this.passivationTime;
            }

            public List<EulerAngleRuleBean> getRules() {
                return this.rules;
            }

            public EulerAngleStyleBean getStyle() {
                return this.style;
            }

            public long getUserProtectTime() {
                return this.userProtectTime;
            }

            public void setCoolTime(long j) {
                this.coolTime = j;
            }

            public void setPassivationTime(int i) {
                this.passivationTime = i;
            }

            public void setRules(List<EulerAngleRuleBean> list) {
                this.rules = list;
            }

            public void setStyle(EulerAngleStyleBean eulerAngleStyleBean) {
                this.style = eulerAngleStyleBean;
            }

            public void setUserProtectTime(long j) {
                this.userProtectTime = j;
            }
        }

        public static class FullScreenClickBean {

            @JsonNode(key = "fullScreenClickUuid")
            private String fullScreenClickUuid;

            @JsonNode(key = "orderData")
            private List<OrderDataFullScreenClickBean> orderData;

            @JsonNode(key = "randomClickNum")
            private int randomClickNum;

            public String getFullScreenClickUuid() {
                return this.fullScreenClickUuid;
            }

            public List<OrderDataFullScreenClickBean> getOrderData() {
                return this.orderData;
            }

            public int getRandomClickNum() {
                return this.randomClickNum;
            }

            public void setFullScreenClickUuid(String str) {
                this.fullScreenClickUuid = str;
            }

            public void setOrderData(List<OrderDataFullScreenClickBean> list) {
                this.orderData = list;
            }

            public void setRandomClickNum(int i) {
                this.randomClickNum = i;
            }
        }

        public static class OrderDataDislikeConfigBean {

            @JsonNode(key = tt.AD_TAG_DISLIKE)
            private DislikeConfigBean dislike;

            @JsonNode(key = "orderList")
            private List<String> orderList;

            public DislikeConfigBean getDislike() {
                return this.dislike;
            }

            public List<String> getOrderList() {
                return this.orderList;
            }

            public void setDislike(DislikeConfigBean dislikeConfigBean) {
                this.dislike = dislikeConfigBean;
            }

            public void setOrderList(List<String> list) {
                this.orderList = list;
            }
        }

        public static class OrderDataEulerAngleViewBean {

            @JsonNode(key = "eulerAngleRule")
            private EulerAngleViewBean eulerAngleRule;

            @JsonNode(key = "orderList")
            private List<String> orderList;

            public EulerAngleViewBean getEulerAngleRule() {
                return this.eulerAngleRule;
            }

            public List<String> getOrderList() {
                return this.orderList;
            }

            public void setEulerAngleRule(EulerAngleViewBean eulerAngleViewBean) {
                this.eulerAngleRule = eulerAngleViewBean;
            }

            public void setOrderList(List<String> list) {
                this.orderList = list;
            }
        }

        public static class OrderDataFullScreenClickBean {

            @JsonNode(key = "fullScreenClick")
            private FullScreenClickBean fullScreenClick;

            @JsonNode(key = "orderList")
            private List<String> orderList;

            public FullScreenClickBean getFullScreenClick() {
                return this.fullScreenClick;
            }

            public List<String> getOrderList() {
                return this.orderList;
            }

            public void setFullScreenClick(FullScreenClickBean fullScreenClickBean) {
                this.fullScreenClick = fullScreenClickBean;
            }

            public void setOrderList(List<String> list) {
                this.orderList = list;
            }
        }

        public static class OrderDataRegionalClickViewBean {

            @JsonNode(key = "orderList")
            private List<String> orderList;

            @JsonNode(key = "regionalClickView")
            private RegionalClickViewBean regionalClickView;

            public List<String> getOrderList() {
                return this.orderList;
            }

            public RegionalClickViewBean getRegionalClickView() {
                return this.regionalClickView;
            }

            public void setOrderList(List<String> list) {
                this.orderList = list;
            }

            public void setRegionalClickView(RegionalClickViewBean regionalClickViewBean) {
                this.regionalClickView = regionalClickViewBean;
            }
        }

        public static class OrderDataRollViewBean {

            @JsonNode(key = "orderList")
            private List<String> orderList;

            @JsonNode(key = "rollView")
            private RollViewBean rollView;

            public List<String> getOrderList() {
                return this.orderList;
            }

            public RollViewBean getRollView() {
                return this.rollView;
            }

            public void setOrderList(List<String> list) {
                this.orderList = list;
            }

            public void setRollView(RollViewBean rollViewBean) {
                this.rollView = rollViewBean;
            }
        }

        public static class OrderDataScrollViewOrderBean {

            @JsonNode(key = "orderList")
            private List<String> orderList;

            @JsonNode(key = "scrollClick")
            private ScrollClickBean scrollClick;

            public List<String> getOrderList() {
                return this.orderList;
            }

            public ScrollClickBean getScrollClick() {
                return this.scrollClick;
            }

            public void setOrderList(List<String> list) {
                this.orderList = list;
            }

            public void setScrollClick(ScrollClickBean scrollClickBean) {
                this.scrollClick = scrollClickBean;
            }
        }

        public static class OrderDataShakeViewBean {

            @JsonNode(key = "orderList")
            private List<String> orderList;

            @JsonNode(key = "shakeView")
            private ShakeViewBean shakeView;

            public List<String> getOrderList() {
                return this.orderList;
            }

            public ShakeViewBean getShakeView() {
                return this.shakeView;
            }

            public void setOrderList(List<String> list) {
                this.orderList = list;
            }

            public void setShakeView(ShakeViewBean shakeViewBean) {
                this.shakeView = shakeViewBean;
            }
        }

        public static class PercentPositionBean {

            @JsonNode(key = LayoutModel.MODEL_KEY_CENTER_X)
            private String centerX;

            @JsonNode(key = LayoutModel.MODEL_KEY_CENTER_Y)
            private String centerY;

            @JsonNode(key = "height")
            private String height;

            @JsonNode(key = "width")
            private String width;

            public String getCenterX() {
                return this.centerX;
            }

            public String getCenterY() {
                return this.centerY;
            }

            public String getHeight() {
                return this.height;
            }

            public String getWidth() {
                return this.width;
            }

            public void setCenterX(String str) {
                this.centerX = str;
            }

            public void setCenterY(String str) {
                this.centerY = str;
            }

            public void setHeight(String str) {
                this.height = str;
            }

            public void setWidth(String str) {
                this.width = str;
            }

            @NonNull
            public String toString() {
                return "PercentPositionBean{centerX='" + this.centerX + "', centerY='" + this.centerY + "', width='" + this.width + "', height='" + this.height + "'}";
            }
        }

        public static class PriceDictBean {

            @JsonNode(key = "name")
            private String name;

            @JsonNode(key = "price")
            private int price;

            public String getName() {
                return this.name;
            }

            public int getPrice() {
                return this.price;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setPrice(int i) {
                this.price = i;
            }

            public String toString() {
                return "PriceDictBean{name='" + this.name + "', price=" + this.price + '}';
            }
        }

        public static class RegionalClickViewBean {

            @JsonNode(key = "backgroundAlpha")
            private double backgroundAlpha;

            @JsonNode(key = "backgroundColor")
            private String backgroundColor;

            @JsonNode(key = "downloadTitle")
            private String downloadTitle;

            @JsonNode(key = "isDisableClick")
            private int isDisableClick;

            @JsonNode(key = "orderData")
            private List<OrderDataRegionalClickViewBean> orderData;

            @JsonNode(key = "position")
            private PercentPositionBean position;

            @JsonNode(key = "regionalClickUuid")
            private String regionalClickUuid;

            @JsonNode(key = "title")
            private String title;

            @JsonNode(key = RVParams.LONG_TITLE_COLOR)
            private String titleColor;

            public double getBackgroundAlpha() {
                return this.backgroundAlpha;
            }

            public String getBackgroundColor() {
                return this.backgroundColor;
            }

            public String getDownloadTitle() {
                return this.downloadTitle;
            }

            public int getIsDisableClick() {
                return this.isDisableClick;
            }

            public List<OrderDataRegionalClickViewBean> getOrderData() {
                return this.orderData;
            }

            public PercentPositionBean getPosition() {
                return this.position;
            }

            public String getRegionalClickUuid() {
                return this.regionalClickUuid;
            }

            public String getTitle() {
                return this.title;
            }

            public String getTitleColor() {
                return this.titleColor;
            }

            public void setBackgroundAlpha(double d) {
                this.backgroundAlpha = d;
            }

            public void setBackgroundColor(String str) {
                this.backgroundColor = str;
            }

            public void setDownloadTitle(String str) {
                this.downloadTitle = str;
            }

            public void setIsDisableClick(int i) {
                this.isDisableClick = i;
            }

            public void setOrderData(List<OrderDataRegionalClickViewBean> list) {
                this.orderData = list;
            }

            public void setPosition(PercentPositionBean percentPositionBean) {
                this.position = percentPositionBean;
            }

            public void setRegionalClickUuid(String str) {
                this.regionalClickUuid = str;
            }

            public void setTitle(String str) {
                this.title = str;
            }

            public void setTitleColor(String str) {
                this.titleColor = str;
            }
        }

        public static class RenderAds {

            @JsonNode(key = "actionCoordinate")
            private String actionCoordinate;

            @JsonNode(key = "adCoordinate")
            private String adCoordinate;

            @JsonNode(key = "autoClose")
            private String autoClose;

            @JsonNode(key = "bgCoordinate")
            private String bgCoordinate;

            @JsonNode(key = "cec")
            private String cec;

            @JsonNode(key = "clickView")
            private List<String> clickView;

            @JsonNode(key = "closeCoordinate")
            private String closeCoordinate;

            @JsonNode(key = "descCoordinate")
            private String descCoordinate;

            @JsonNode(key = "iconCoordinate")
            private String iconCoordinate;

            @JsonNode(key = "imageCoordinate")
            private String imageCoordinate;

            @JsonNode(key = "maxTime")
            private String maxTime;

            @JsonNode(key = "minTime")
            private String minTime;

            @JsonNode(key = "renderAdsUuid")
            private String renderAdsUuid;

            @JsonNode(key = "rmc")
            private String rmc;

            @JsonNode(key = "scrollCoordinate")
            private String scrollCoordinate;

            @JsonNode(key = "slac")
            private String slac;

            @JsonNode(key = "slc")
            private String slc;

            @JsonNode(key = "titleCoordinate")
            private String titleCoordinate;

            private int strToInt(String str) {
                try {
                    return Integer.parseInt(str);
                } catch (Exception unused) {
                    return 0;
                }
            }

            public String getActionCoordinate() {
                return this.actionCoordinate;
            }

            public String getAdCoordinate() {
                return this.adCoordinate;
            }

            public int getAutoClose() {
                return strToInt(this.autoClose);
            }

            public String getBgCoordinate() {
                return this.bgCoordinate;
            }

            public int getCec() {
                return strToInt(this.cec);
            }

            public List<String> getClickView() {
                return this.clickView;
            }

            public String getCloseCoordinate() {
                return this.closeCoordinate;
            }

            public String getDescCoordinate() {
                return this.descCoordinate;
            }

            public String getIconCoordinate() {
                return this.iconCoordinate;
            }

            public String getImageCoordinate() {
                return this.imageCoordinate;
            }

            public int getMaxTime() {
                return strToInt(this.maxTime);
            }

            public int getMinTime() {
                return strToInt(this.minTime);
            }

            public String getRenderAdsUuid() {
                return this.renderAdsUuid;
            }

            public int getRmc() {
                return strToInt(this.rmc);
            }

            public String getScrollCoordinate() {
                return this.scrollCoordinate;
            }

            public int getSlac() {
                return strToInt(this.slac);
            }

            public int getSlc() {
                return strToInt(this.slc);
            }

            public String getTitleCoordinate() {
                return this.titleCoordinate;
            }

            public void setActionCoordinate(String str) {
                this.actionCoordinate = str;
            }

            public void setAdCoordinate(String str) {
                this.adCoordinate = str;
            }

            public void setAutoClose(String str) {
                this.autoClose = str;
            }

            public void setBgCoordinate(String str) {
                this.bgCoordinate = str;
            }

            public void setCec(String str) {
                this.cec = str;
            }

            public void setClickView(List<String> list) {
                this.clickView = list;
            }

            public void setCloseCoordinate(String str) {
                this.closeCoordinate = str;
            }

            public void setDescCoordinate(String str) {
                this.descCoordinate = str;
            }

            public void setIconCoordinate(String str) {
                this.iconCoordinate = str;
            }

            public void setImageCoordinate(String str) {
                this.imageCoordinate = str;
            }

            public void setMaxTime(String str) {
                this.maxTime = str;
            }

            public void setMinTime(String str) {
                this.minTime = str;
            }

            public void setRenderAdsUuid(String str) {
                this.renderAdsUuid = str;
            }

            public void setRmc(String str) {
                this.rmc = str;
            }

            public void setScrollCoordinate(String str) {
                this.scrollCoordinate = str;
            }

            public void setSlac(String str) {
                this.slac = str;
            }

            public void setSlc(String str) {
                this.slc = str;
            }

            public void setTitleCoordinate(String str) {
                this.titleCoordinate = str;
            }
        }

        public static class RenderRulesBean {

            @JsonNode(key = "results")
            private Integer[] results;

            @JsonNode(key = "type")
            private String type;

            public Integer[] getResults() {
                return this.results;
            }

            public String getType() {
                return this.type;
            }

            public void setResults(Integer[] numArr) {
                this.results = numArr;
            }

            public void setType(String str) {
                this.type = str;
            }
        }

        public static class RollViewBean {

            @JsonNode(key = "bgColor")
            private String bgColor;

            @JsonNode(key = "coolRollView")
            private CoolRollViewBean coolRollView;

            @JsonNode(key = "downloadSubTitle")
            private String downloadSubTitle;

            @JsonNode(key = "isClick")
            private int isClick;

            @JsonNode(key = "orderData")
            private List<OrderDataRollViewBean> orderData;

            @JsonNode(key = "position")
            private PercentPositionBean position;

            @JsonNode(key = "rollMinusAmplitude")
            private double rollMinusAmplitude;

            @JsonNode(key = "rollPlusAmplitude")
            private double rollPlusAmplitude;

            @JsonNode(key = "rollTime")
            private long rollTime;

            @JsonNode(key = "rollViewUuid")
            private String rollViewUuid;

            @JsonNode(key = RVParams.LONG_SUB_TITLE)
            private String subTitle;

            @JsonNode(key = "title")
            private String title;

            public String getBgColor() {
                return this.bgColor;
            }

            public CoolRollViewBean getCoolRollView() {
                return this.coolRollView;
            }

            public String getDownloadSubTitle() {
                return this.downloadSubTitle;
            }

            public int getIsClick() {
                return this.isClick;
            }

            public List<OrderDataRollViewBean> getOrderData() {
                return this.orderData;
            }

            public PercentPositionBean getPosition() {
                return this.position;
            }

            public double getRollMinusAmplitude() {
                return this.rollMinusAmplitude;
            }

            public double getRollPlusAmplitude() {
                return this.rollPlusAmplitude;
            }

            public long getRollTime() {
                return this.rollTime;
            }

            public String getRollViewUuid() {
                return this.rollViewUuid;
            }

            public String getSubTitle() {
                return this.subTitle;
            }

            public String getTitle() {
                return this.title;
            }

            public void setBgColor(String str) {
                this.bgColor = str;
            }

            public void setCoolRollView(CoolRollViewBean coolRollViewBean) {
                this.coolRollView = coolRollViewBean;
            }

            public void setDownloadSubTitle(String str) {
                this.downloadSubTitle = str;
            }

            public void setIsClick(int i) {
                this.isClick = i;
            }

            public void setOrderData(List<OrderDataRollViewBean> list) {
                this.orderData = list;
            }

            public void setPosition(PercentPositionBean percentPositionBean) {
                this.position = percentPositionBean;
            }

            public void setRollMinusAmplitude(double d) {
                this.rollMinusAmplitude = d;
            }

            public void setRollPlusAmplitude(double d) {
                this.rollPlusAmplitude = d;
            }

            public void setRollTime(long j) {
                this.rollTime = j;
            }

            public void setRollViewUuid(String str) {
                this.rollViewUuid = str;
            }

            public void setSubTitle(String str) {
                this.subTitle = str;
            }

            public void setTitle(String str) {
                this.title = str;
            }
        }

        public static class ScrollClickBean {

            @JsonNode(key = a.l)
            private int animation;

            @JsonNode(key = "coolScrollClick")
            private ScrollClickBean coolScrollClick;

            @JsonNode(key = "coolTime")
            private long coolTime;

            @JsonNode(key = BaseConstants.MARKET_URI_AUTHORITY_DETAIL)
            private String details;

            @JsonNode(key = "detailsFont")
            private int detailsFont;

            @JsonNode(key = "downloadDetails")
            private String downloadDetails;

            @JsonNode(key = "orderData")
            private List<OrderDataScrollViewOrderBean> orderData;

            @JsonNode(key = "position")
            private ScrollClickPositionBean position;

            @JsonNode(key = "randomClickNum")
            private int randomClickNum;

            @JsonNode(key = "randomClickTime")
            private int randomClickTime;

            @JsonNode(key = "regionalSlide")
            private int regionalSlide;

            @JsonNode(key = "scrollClickUuid")
            private String scrollClickUuid;

            @JsonNode(key = "scrollDirection")
            private String scrollDirection;

            @JsonNode(key = RVParams.LONG_TITLE_SCROLLDISTANCE)
            private int scrollDistance;

            @JsonNode(key = "style")
            private int style;

            @JsonNode(key = "supportClick")
            private int supportClick;

            @JsonNode(key = "title")
            private String title;

            @JsonNode(key = "titleFont")
            private int titleFont;

            @JsonNode(key = "userProtectTime")
            private long userProtectTime;

            public int getAnimation() {
                return this.animation;
            }

            public ScrollClickBean getCoolScrollClick() {
                return this.coolScrollClick;
            }

            public long getCoolTime() {
                return this.coolTime;
            }

            public String getDetails() {
                return this.details;
            }

            public int getDetailsFont() {
                return this.detailsFont;
            }

            public String getDownloadDetails() {
                return this.downloadDetails;
            }

            public List<OrderDataScrollViewOrderBean> getOrderData() {
                return this.orderData;
            }

            public ScrollClickPositionBean getPosition() {
                return this.position;
            }

            public int getRandomClickNum() {
                return this.randomClickNum;
            }

            public int getRandomClickTime() {
                return this.randomClickTime;
            }

            public int getRegionalSlide() {
                return this.regionalSlide;
            }

            public String getScrollClickUuid() {
                return this.scrollClickUuid;
            }

            public String getScrollDirection() {
                return this.scrollDirection;
            }

            public int getScrollDistance() {
                return this.scrollDistance;
            }

            public int getStyle() {
                return this.style;
            }

            public int getSupportClick() {
                return this.supportClick;
            }

            public String getTitle() {
                return this.title;
            }

            public int getTitleFont() {
                return this.titleFont;
            }

            public long getUserProtectTime() {
                return this.userProtectTime;
            }

            public void setAnimation(int i) {
                this.animation = i;
            }

            public void setCoolScrollClick(ScrollClickBean scrollClickBean) {
                this.coolScrollClick = scrollClickBean;
            }

            public void setCoolTime(long j) {
                this.coolTime = j;
            }

            public void setDetails(String str) {
                this.details = str;
            }

            public void setDetailsFont(int i) {
                this.detailsFont = i;
            }

            public void setDownloadDetails(String str) {
                this.downloadDetails = str;
            }

            public void setOrderData(List<OrderDataScrollViewOrderBean> list) {
                this.orderData = list;
            }

            public void setPosition(ScrollClickPositionBean scrollClickPositionBean) {
                this.position = scrollClickPositionBean;
            }

            public void setRandomClickNum(int i) {
                this.randomClickNum = i;
            }

            public void setRandomClickTime(int i) {
                this.randomClickTime = i;
            }

            public void setRegionalSlide(int i) {
                this.regionalSlide = i;
            }

            public void setScrollClickUuid(String str) {
                this.scrollClickUuid = str;
            }

            public void setScrollDirection(String str) {
                this.scrollDirection = str;
            }

            public void setScrollDistance(int i) {
                this.scrollDistance = i;
            }

            public void setStyle(int i) {
                this.style = i;
            }

            public void setSupportClick(int i) {
                this.supportClick = i;
            }

            public void setTitle(String str) {
                this.title = str;
            }

            public void setTitleFont(int i) {
                this.titleFont = i;
            }

            public void setUserProtectTime(long j) {
                this.userProtectTime = j;
            }
        }

        public static class ScrollClickPositionBean {

            @JsonNode(key = LayoutModel.MODEL_KEY_CENTER_X)
            private String centerX;

            @JsonNode(key = "height")
            private String height;

            @JsonNode(key = f.l)
            private String top;

            @JsonNode(key = "width")
            private String width;

            public String getCenterX() {
                return this.centerX;
            }

            public String getHeight() {
                return this.height;
            }

            public String getTop() {
                return this.top;
            }

            public String getWidth() {
                return this.width;
            }

            public void setCenterX(String str) {
                this.centerX = str;
            }

            public void setHeight(String str) {
                this.height = str;
            }

            public void setTop(String str) {
                this.top = str;
            }

            public void setWidth(String str) {
                this.width = str;
            }
        }

        public static class ShakeViewBean {

            @JsonNode(key = "aliaseShakeView")
            private AliaseShakeViewBean aliaseShakeView;

            @JsonNode(key = "animationInterval")
            private int animationInterval;

            @JsonNode(key = "clkremove")
            private int clkremove;

            @JsonNode(key = "compliantAngle")
            private int compliantAngle;

            @JsonNode(key = "coolShakeView")
            private CoolShakeViewBean coolShakeView;

            @JsonNode(key = "downloadTitle")
            private String downloadTitle;

            @JsonNode(key = "duration")
            private int duration;

            @JsonNode(key = "feedback")
            private int feedback;

            @JsonNode(key = "imageURL")
            private List<String> imageURL;

            @JsonNode(key = "isHideAnim")
            private int isHideAnim;

            @JsonNode(key = "isUnidirection")
            private int isUnidirection;

            @JsonNode(key = "maxAcc")
            private int maxAcc;

            @JsonNode(key = "orderData")
            private List<OrderDataShakeViewBean> orderData;

            @JsonNode(key = "position")
            private PercentPositionBean position;

            @JsonNode(key = "randomClickNum")
            private int randomClickNum;

            @JsonNode(key = "randomClickTime")
            private int randomClickTime;

            @JsonNode(key = "regulatoryAngle")
            private int regulatoryAngle;

            @JsonNode(key = "renderRate")
            private int renderRate;

            @JsonNode(key = "returnAngle")
            private boolean returnAngle;

            @JsonNode(key = "rotatAmplitude")
            private double rotatAmplitude;

            @JsonNode(key = "rotatCount")
            private int rotatCount;

            @JsonNode(key = "sensorParam")
            private int sensorParam;

            @JsonNode(key = "shakeCount")
            private int shakeCount;

            @JsonNode(key = "shakeEndAmplitude")
            private double shakeEndAmplitude;

            @JsonNode(key = "shakeStartAmplitude")
            private double shakeStartAmplitude;

            @JsonNode(key = "shakeViewUuid")
            private String shakeViewUuid;

            @JsonNode(key = "title")
            private String title;

            public AliaseShakeViewBean getAliaseShakeView() {
                return this.aliaseShakeView;
            }

            public int getAnimationInterval() {
                return this.animationInterval;
            }

            public int getClkremove() {
                return this.clkremove;
            }

            public int getCompliantAngle() {
                return this.compliantAngle;
            }

            public CoolShakeViewBean getCoolShakeView() {
                return this.coolShakeView;
            }

            public String getDownloadTitle() {
                return this.downloadTitle;
            }

            public int getDuration() {
                return this.duration;
            }

            public int getFeedback() {
                return this.feedback;
            }

            public List<String> getImageURL() {
                return this.imageURL;
            }

            public int getIsHideAnim() {
                return this.isHideAnim;
            }

            public int getIsUnidirection() {
                return this.isUnidirection;
            }

            public int getMaxAcc() {
                return this.maxAcc;
            }

            public List<OrderDataShakeViewBean> getOrderData() {
                return this.orderData;
            }

            public PercentPositionBean getPosition() {
                return this.position;
            }

            public int getRandomClickNum() {
                return this.randomClickNum;
            }

            public int getRandomClickTime() {
                return this.randomClickTime;
            }

            public int getRegulatoryAngle() {
                return this.regulatoryAngle;
            }

            public int getRenderRate() {
                return this.renderRate;
            }

            public double getRotatAmplitude() {
                return this.rotatAmplitude;
            }

            public int getRotatCount() {
                return this.rotatCount;
            }

            public int getSensorParam() {
                return this.sensorParam;
            }

            public int getShakeCount() {
                return this.shakeCount;
            }

            public double getShakeEndAmplitude() {
                return this.shakeEndAmplitude;
            }

            public double getShakeStartAmplitude() {
                return this.shakeStartAmplitude;
            }

            public String getShakeViewUuid() {
                return this.shakeViewUuid;
            }

            public String getTitle() {
                return this.title;
            }

            public boolean isReturnAngle() {
                return this.returnAngle;
            }

            public void setAliaseShakeView(AliaseShakeViewBean aliaseShakeViewBean) {
                this.aliaseShakeView = aliaseShakeViewBean;
            }

            public void setAnimationInterval(int i) {
                this.animationInterval = i;
            }

            public void setClkremove(int i) {
                this.clkremove = i;
            }

            public void setCompliantAngle(int i) {
                this.compliantAngle = i;
            }

            public void setCoolShakeView(CoolShakeViewBean coolShakeViewBean) {
                this.coolShakeView = coolShakeViewBean;
            }

            public void setDownloadTitle(String str) {
                this.downloadTitle = str;
            }

            public void setDuration(int i) {
                this.duration = i;
            }

            public void setFeedback(int i) {
                this.feedback = i;
            }

            public void setImageURL(List<String> list) {
                this.imageURL = list;
            }

            public void setIsHideAnim(int i) {
                this.isHideAnim = i;
            }

            public void setIsUnidirection(int i) {
                this.isUnidirection = i;
            }

            public void setMaxAcc(int i) {
                this.maxAcc = i;
            }

            public void setOrderData(List<OrderDataShakeViewBean> list) {
                this.orderData = list;
            }

            public void setPosition(PercentPositionBean percentPositionBean) {
                this.position = percentPositionBean;
            }

            public void setRandomClickNum(int i) {
                this.randomClickNum = i;
            }

            public void setRandomClickTime(int i) {
                this.randomClickTime = i;
            }

            public void setRegulatoryAngle(int i) {
                this.regulatoryAngle = i;
            }

            public void setRenderRate(int i) {
                this.renderRate = i;
            }

            public void setReturnAngle(boolean z) {
                this.returnAngle = z;
            }

            public void setRotatAmplitude(double d) {
                this.rotatAmplitude = d;
            }

            public void setRotatCount(int i) {
                this.rotatCount = i;
            }

            public void setSensorParam(int i) {
                this.sensorParam = i;
            }

            public void setShakeCount(int i) {
                this.shakeCount = i;
            }

            public void setShakeEndAmplitude(double d) {
                this.shakeEndAmplitude = d;
            }

            public void setShakeStartAmplitude(double d) {
                this.shakeStartAmplitude = d;
            }

            public void setShakeViewUuid(String str) {
                this.shakeViewUuid = str;
            }

            public void setTitle(String str) {
                this.title = str;
            }
        }

        public static BuyerBean objectFromData(String str) {
            try {
                return (BuyerBean) JsonResolver.fromJson(str, BuyerBean.class);
            } catch (Exception unused) {
                return null;
            }
        }

        public AdSizeBean getAdSize() {
            return this.adSize;
        }

        public String getAdType() {
            return this.adType;
        }

        public String getAdWorker() {
            return this.adWorker;
        }

        public String getAppId() {
            return this.appId;
        }

        public double getAvgPrice() {
            return this.avgPrice;
        }

        public double getBidPrice() {
            return this.bidPrice;
        }

        public String getBidType() {
            return this.bidType;
        }

        public String getBuyerSpaceUuId() {
            return this.buyerSpaceUuId;
        }

        public int getCache() {
            return this.cache;
        }

        public int getCacheNum() {
            return this.cacheNum;
        }

        public List<CallBackStrategyBean> getCallBackStrategy() {
            return this.callBackStrategy;
        }

        public String getCallBackStrategyUuid() {
            return this.callBackStrategyUuid;
        }

        public ComplainBean getComplain() {
            return this.complain;
        }

        public int getDirectDownload() {
            return this.directDownload;
        }

        public DislikeConfigBean getDislikeConfig() {
            return this.dislikeConfig;
        }

        public EulerAngleViewBean getEulerAngleRule() {
            return this.eulerAngleRule;
        }

        public FilterBean getFilter() {
            return this.filter;
        }

        public String getFilterSsid() {
            return this.filterSsid;
        }

        public FullScreenClickBean getFullScreenClick() {
            return this.fullScreenClick;
        }

        public String getId() {
            return this.id;
        }

        public List<RenderRulesBean> getInteractionRules() {
            return this.interactionRules;
        }

        public int getIsAnimation() {
            return this.isAnimation;
        }

        public int getIsHideInteraction() {
            return this.isHideInteraction;
        }

        public int getIsImageSpeed() {
            return this.isImageSpeed;
        }

        public int getIsPlaceHolder() {
            return this.isPlaceHolder;
        }

        public int getIsSendBidData() {
            return this.isSendBidData;
        }

        public int getLastTime() {
            return this.lastTime;
        }

        public int getMinShowTime() {
            return this.minShowTime;
        }

        public NativeOptimizeBean getNativeOptimize() {
            return this.nativeOptimize;
        }

        public NativeRuleBean getNativeRule() {
            return this.nativeRule;
        }

        public List<PriceDictBean> getPriceDict() {
            return this.priceDict;
        }

        public RegionalClickViewBean getRegionalClickView() {
            return this.regionalClickView;
        }

        public RenderAds getRenderAds() {
            return this.renderAds;
        }

        public List<RenderViewBean> getRenderView() {
            return this.renderView;
        }

        public String getRenderViewSsid() {
            return this.renderViewSsid;
        }

        public int getReqTimeOutType() {
            return this.reqTimeOutType;
        }

        public RollViewBean getRollView() {
            return this.rollView;
        }

        public List<ScreenConfigVoBean> getScreenConfigVo() {
            return this.screenConfigVo;
        }

        public ScrollClickBean getScrollClick() {
            return this.scrollClick;
        }

        public ShakeViewBean getShakeView() {
            return this.shakeView;
        }

        public int getSizeRatio() {
            return this.sizeRatio;
        }

        public String getSpaceId() {
            return this.spaceId;
        }

        public int getTemplate() {
            return this.template;
        }

        public int getWaitTime() {
            return this.waitTime;
        }

        public String getZone() {
            return this.zone;
        }

        public void setAdSize(AdSizeBean adSizeBean) {
            this.adSize = adSizeBean;
        }

        public void setAdType(String str) {
            this.adType = str;
        }

        public void setAdWorker(String str) {
            this.adWorker = str;
        }

        public void setAppId(String str) {
            this.appId = str;
        }

        public void setAvgPrice(double d) {
            this.avgPrice = d;
        }

        public void setBidPrice(double d) {
            this.bidPrice = d;
        }

        public void setBidType(String str) {
            this.bidType = str;
        }

        public void setBuyerSpaceUuId(String str) {
            this.buyerSpaceUuId = str;
        }

        public void setCache(int i) {
            this.cache = i;
        }

        public void setCacheNum(int i) {
            this.cacheNum = i;
        }

        public void setCallBackStrategy(List<CallBackStrategyBean> list) {
            this.callBackStrategy = list;
        }

        public void setCallBackStrategyUuid(String str) {
            this.callBackStrategyUuid = str;
        }

        public void setComplain(ComplainBean complainBean) {
            this.complain = complainBean;
        }

        public void setDirectDownload(int i) {
            this.directDownload = i;
        }

        public void setDislikeConfig(DislikeConfigBean dislikeConfigBean) {
            this.dislikeConfig = dislikeConfigBean;
        }

        public void setEulerAngleRule(EulerAngleViewBean eulerAngleViewBean) {
            this.eulerAngleRule = eulerAngleViewBean;
        }

        public void setFilter(FilterBean filterBean) {
            this.filter = filterBean;
        }

        public void setFilterSsid(String str) {
            this.filterSsid = str;
        }

        public void setFullScreenClick(FullScreenClickBean fullScreenClickBean) {
            this.fullScreenClick = fullScreenClickBean;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setInteractionRules(List<RenderRulesBean> list) {
            this.interactionRules = list;
        }

        public void setIsAnimation(int i) {
            this.isAnimation = i;
        }

        public void setIsHideInteraction(int i) {
            this.isHideInteraction = i;
        }

        public void setIsImageSpeed(int i) {
            this.isImageSpeed = i;
        }

        public void setIsPlaceHolder(int i) {
            this.isPlaceHolder = i;
        }

        public void setIsSendBidData(int i) {
            this.isSendBidData = i;
        }

        public void setLastTime(int i) {
            this.lastTime = i;
        }

        public void setMinShowTime(int i) {
            this.minShowTime = i;
        }

        public void setNativeOptimize(NativeOptimizeBean nativeOptimizeBean) {
            this.nativeOptimize = nativeOptimizeBean;
        }

        public void setNativeRule(NativeRuleBean nativeRuleBean) {
            this.nativeRule = nativeRuleBean;
        }

        public void setPriceDict(List<PriceDictBean> list) {
            this.priceDict = list;
        }

        public void setRegionalClickView(RegionalClickViewBean regionalClickViewBean) {
            this.regionalClickView = regionalClickViewBean;
        }

        public void setRenderAds(RenderAds renderAds) {
            this.renderAds = renderAds;
        }

        public void setRenderView(List<RenderViewBean> list) {
            this.renderView = list;
        }

        public void setRenderViewSsid(String str) {
            this.renderViewSsid = str;
        }

        public void setReqTimeOutType(int i) {
            this.reqTimeOutType = i;
        }

        public void setRollView(RollViewBean rollViewBean) {
            this.rollView = rollViewBean;
        }

        public void setScreenConfigVo(List<ScreenConfigVoBean> list) {
            this.screenConfigVo = list;
        }

        public void setScrollClick(ScrollClickBean scrollClickBean) {
            this.scrollClick = scrollClickBean;
        }

        public void setShakeView(ShakeViewBean shakeViewBean) {
            this.shakeView = shakeViewBean;
        }

        public void setSizeRatio(int i) {
            this.sizeRatio = i;
        }

        public void setSpaceId(String str) {
            this.spaceId = str;
        }

        public void setTemplate(int i) {
            this.template = i;
        }

        public void setWaitTime(int i) {
            this.waitTime = i;
        }

        public void setZone(String str) {
            this.zone = str;
        }

        @NonNull
        public String toString() {
            return "BuyerBean{id='" + this.id + "', buyerSpaceUuId='" + this.buyerSpaceUuId + "', zone='" + this.zone + "', appId='" + this.appId + "', spaceId='" + this.spaceId + "', avgPrice=" + this.avgPrice + ", adWorker='" + this.adWorker + "', filter=" + this.filter + ", reqTimeOutType=" + this.reqTimeOutType + ", renderView=" + this.renderView + ", adSize=" + this.adSize + ", directDownload=" + this.directDownload + ", renderViewSsid='" + this.renderViewSsid + "', filterSsid='" + this.filterSsid + "', bidType='" + this.bidType + "', cache='" + this.cache + "'}";
        }

        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public BuyerBean m168clone() throws CloneNotSupportedException {
            return (BuyerBean) super.clone();
        }
    }

    public static class CallBackStrategyBean {

        @JsonNode(key = "count")
        private String count;

        @JsonNode(key = StrategyEventDBModel.COLUMN_EVENT_CODE)
        private String eventCode;

        @JsonNode(key = "interval")
        private String interval;

        @JsonNode(key = "rate")
        private String rate;

        public String getCount() {
            return this.count;
        }

        public String getEventCode() {
            return this.eventCode;
        }

        public String getInterval() {
            return this.interval;
        }

        public String getRate() {
            return this.rate;
        }

        public void setCount(String str) {
            this.count = str;
        }

        public void setEventCode(String str) {
            this.eventCode = str;
        }

        public void setInterval(String str) {
            this.interval = str;
        }

        public void setRate(String str) {
            this.rate = str;
        }
    }

    public static class ComplainBean {

        @JsonNode(key = "duration")
        private long duration;

        @JsonNode(key = "open")
        private int open;

        public long getDuration() {
            return this.duration;
        }

        public int getOpen() {
            return this.open;
        }

        public void setDuration(long j) {
            this.duration = j;
        }

        public void setOpen(int i) {
            this.open = i;
        }
    }

    public static class ComponentBean {

        @JsonNode(key = "content")
        private String content;

        @JsonNode(key = ALPParamConstant.PLUGIN_RULE_FORWARD)
        private List<ForwardBean> forward;

        public String getContent() {
            return this.content;
        }

        public List<ForwardBean> getForward() {
            return this.forward;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setForward(List<ForwardBean> list) {
            this.forward = list;
        }

        @NonNull
        public String toString() {
            return "ComponentBean{content='" + this.content + "', forward=" + this.forward + '}';
        }
    }

    public static class DpLinkUrlListBean {

        @JsonNode(key = "dpLinkUrL")
        private String dpLinkUrL;

        @JsonNode(key = "optimizePercent")
        private int optimizePercent;

        public static DpLinkUrlListBean objectFromData(String str) {
            try {
                return (DpLinkUrlListBean) JsonResolver.fromJson(str, DpLinkUrlListBean.class);
            } catch (Exception unused) {
                return null;
            }
        }

        public String getDpLinkUrL() {
            return this.dpLinkUrL;
        }

        public int getOptimizePercent() {
            return this.optimizePercent;
        }

        public void setDpLinkUrL(String str) {
            this.dpLinkUrL = str;
        }

        public void setOptimizePercent(int i) {
            this.optimizePercent = i;
        }

        public String toString() {
            return "DpLinkUrlListBean{dpLinkUrL='" + this.dpLinkUrL + "', optimizePercent=" + this.optimizePercent + '}';
        }
    }

    public static class EventStrategyBean {

        @JsonNode(key = "randomStrategy")
        private List<RandomStrategyBean> randomStrategy;

        @JsonNode(key = "validTimeShow")
        private int validTimeShow;

        public List<RandomStrategyBean> getRandomStrategy() {
            return this.randomStrategy;
        }

        public int getValidTimeShow() {
            return this.validTimeShow;
        }

        public void setRandomStrategy(List<RandomStrategyBean> list) {
            this.randomStrategy = list;
        }

        public void setValidTimeShow(int i) {
            this.validTimeShow = i;
        }
    }

    public static class FilterBean {

        @JsonNode(key = "frequency")
        private List<FreqItem> frequency;

        @JsonNode(key = "imeiLength")
        private List<Integer> imeiLength;

        @JsonNode(key = "minAdLoadTime")
        private int minAdLoadTime;

        @JsonNode(key = "privilege")
        private List<String> privilege;

        @JsonNode(key = "uniteControl")
        private UniteControlBean uniteControl;

        public static FilterBean objectFromData(String str) {
            try {
                return (FilterBean) JsonResolver.fromJson(str, FilterBean.class);
            } catch (Exception unused) {
                return null;
            }
        }

        public List<FreqItem> getFrequency() {
            return this.frequency;
        }

        public List<Integer> getImeiLength() {
            return this.imeiLength;
        }

        public int getMinAdLoadTime() {
            return this.minAdLoadTime;
        }

        public List<String> getPrivilege() {
            return this.privilege;
        }

        public UniteControlBean getUniteControl() {
            return this.uniteControl;
        }

        public void setFrequency(List<FreqItem> list) {
            this.frequency = list;
        }

        public void setImeiLength(List<Integer> list) {
            this.imeiLength = list;
        }

        public void setMinAdLoadTime(int i) {
            this.minAdLoadTime = i;
        }

        public void setPrivilege(List<String> list) {
            this.privilege = list;
        }

        public void setUniteControl(UniteControlBean uniteControlBean) {
            this.uniteControl = uniteControlBean;
        }

        public String toString() {
            return "FilterBean{minAdLoadTime=" + this.minAdLoadTime + ", privilege=" + this.privilege + ", imeiLength=" + this.imeiLength + ", frequency=" + this.frequency + '}';
        }
    }

    public static class ForwardBean implements Cloneable {

        @JsonNode(key = "baseId")
        private String baseId;

        @JsonNode(key = "buyerId")
        private String buyerId;

        @JsonNode(key = "buyerSpaceUuId")
        private String buyerSpaceUuId;

        @JsonNode(key = AlibcProtocolConstant.CALL_TYPE_COMPONENT)
        private ComponentBean component;

        @JsonNode(key = "forwardId")
        private String forwardId;

        @JsonNode(key = "hotRequestDelay")
        private long hotRequestDelay;

        @JsonNode(key = b.b)
        private String level;

        @JsonNode(key = "parentForwardId")
        private String parentForwardId;

        @JsonNode(key = "rules")
        private List<RulesBean> rules;

        @JsonNode(key = "sleepTime")
        private long sleepTime;

        public static ForwardBean objectFromData(String str) {
            try {
                return (ForwardBean) JsonResolver.fromJson(str, ForwardBean.class);
            } catch (Exception unused) {
                return null;
            }
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public String getBaseId() {
            return this.baseId;
        }

        public String getBuyerId() {
            return this.buyerId;
        }

        public String getBuyerSpaceUuId() {
            return this.buyerSpaceUuId;
        }

        public ComponentBean getComponent() {
            return this.component;
        }

        public String getForwardId() {
            return this.forwardId;
        }

        public long getHotRequestDelay() {
            return this.hotRequestDelay;
        }

        public String getLevel() {
            return this.level;
        }

        public String getParentForwardId() {
            return this.parentForwardId;
        }

        public List<RulesBean> getRules() {
            return this.rules;
        }

        public long getSleepTime() {
            return this.sleepTime;
        }

        public void setBaseId(String str) {
            this.baseId = str;
        }

        public void setBuyerId(String str) {
            this.buyerId = str;
        }

        public void setBuyerSpaceUuId(String str) {
            this.buyerSpaceUuId = str;
        }

        public void setComponent(ComponentBean componentBean) {
            this.component = componentBean;
        }

        public void setForwardId(String str) {
            this.forwardId = str;
        }

        public void setHotRequestDelay(long j) {
            this.hotRequestDelay = j;
        }

        public void setLevel(String str) {
            this.level = str;
        }

        public void setParentForwardId(String str) {
            this.parentForwardId = str;
        }

        public void setRules(List<RulesBean> list) {
            this.rules = list;
        }

        public void setSleepTime(long j) {
            this.sleepTime = j;
        }

        public String toString() {
            return "ForwardBean{buyerId='" + this.buyerId + "', baseId='" + this.baseId + "', sleepTime=" + this.sleepTime + ", hotRequestDelay=" + this.hotRequestDelay + ", forwardId='" + this.forwardId + "', parentForwardId='" + this.parentForwardId + "', level='" + this.level + "', buyerSpaceUuId='" + this.buyerSpaceUuId + "', component=" + this.component + ", rules=" + this.rules + '}';
        }
    }

    public static class NativeOptimizeAdSlideBean {

        @JsonNode(key = SchoolActivitySuccessActivity.x)
        private int distance;

        @JsonNode(key = "isTouchUp")
        private int isTouchUp;

        @JsonNode(key = "needTime")
        private int needTime;

        @JsonNode(key = "randomNum")
        private int randomNum;

        public int getDistance() {
            return this.distance;
        }

        public int getIsTouchUp() {
            return this.isTouchUp;
        }

        public int getNeedTime() {
            return this.needTime;
        }

        public int getRandomNum() {
            return this.randomNum;
        }

        public void setDistance(int i) {
            this.distance = i;
        }

        public void setIsTouchUp(int i) {
            this.isTouchUp = i;
        }

        public void setNeedTime(int i) {
            this.needTime = i;
        }

        public void setRandomNum(int i) {
            this.randomNum = i;
        }
    }

    public static class NativeOptimizeBean {

        @JsonNode(key = "adSlide")
        private NativeOptimizeAdSlideBean adSlide;

        @JsonNode(key = "addClickNum")
        private int addClickNum;

        @JsonNode(key = "clickArea")
        private NativeOptimizeClickAreaBean clickArea;

        @JsonNode(key = "closeClickNum")
        private int closeClickNum;

        @JsonNode(key = "holdSlideNum")
        private int holdSlideNum;

        @JsonNode(key = "nativeUuid")
        private String nativeUuid;

        @JsonNode(key = "touchDownNum")
        private int touchDownNum;

        public NativeOptimizeAdSlideBean getAdSlide() {
            return this.adSlide;
        }

        public int getAddClickNum() {
            return this.addClickNum;
        }

        public NativeOptimizeClickAreaBean getClickArea() {
            return this.clickArea;
        }

        public int getCloseClickNum() {
            return this.closeClickNum;
        }

        public int getHoldSlideNum() {
            return this.holdSlideNum;
        }

        public String getNativeUuid() {
            return this.nativeUuid;
        }

        public int getTouchDownNum() {
            return this.touchDownNum;
        }

        public void setAdSlide(NativeOptimizeAdSlideBean nativeOptimizeAdSlideBean) {
            this.adSlide = nativeOptimizeAdSlideBean;
        }

        public void setAddClickNum(int i) {
            this.addClickNum = i;
        }

        public void setClickArea(NativeOptimizeClickAreaBean nativeOptimizeClickAreaBean) {
            this.clickArea = nativeOptimizeClickAreaBean;
        }

        public void setCloseClickNum(int i) {
            this.closeClickNum = i;
        }

        public void setHoldSlideNum(int i) {
            this.holdSlideNum = i;
        }

        public void setNativeUuid(String str) {
            this.nativeUuid = str;
        }

        public void setTouchDownNum(int i) {
            this.touchDownNum = i;
        }
    }

    public static class NativeOptimizeClickAreaBean {

        @JsonNode(key = "height")
        private String height;

        @JsonNode(key = "horizontalSpace")
        private String horizontalSpace;

        @JsonNode(key = "randomNum")
        private int randomNum;

        @JsonNode(key = "reference")
        private int reference;

        @JsonNode(key = "verticalSpace")
        private String verticalSpace;

        @JsonNode(key = "width")
        private String width;

        public String getHeight() {
            return this.height;
        }

        public String getHorizontalSpace() {
            return this.horizontalSpace;
        }

        public int getRandomNum() {
            return this.randomNum;
        }

        public int getReference() {
            return this.reference;
        }

        public String getVerticalSpace() {
            return this.verticalSpace;
        }

        public String getWidth() {
            return this.width;
        }

        public void setHeight(String str) {
            this.height = str;
        }

        public void setHorizontalSpace(String str) {
            this.horizontalSpace = str;
        }

        public void setRandomNum(int i) {
            this.randomNum = i;
        }

        public void setReference(int i) {
            this.reference = i;
        }

        public void setVerticalSpace(String str) {
            this.verticalSpace = str;
        }

        public void setWidth(String str) {
            this.width = str;
        }
    }

    public static class NativeRuleBean {

        @JsonNode(key = "nativeRuleUuid")
        private String nativeRuleUuid;

        @JsonNode(key = "needNum")
        private int needNum;

        @JsonNode(key = "needTime")
        private int needTime;

        public String getNativeRuleUuid() {
            return this.nativeRuleUuid;
        }

        public int getNeedNum() {
            return this.needNum;
        }

        public int getNeedTime() {
            return this.needTime;
        }

        public void setNativeRuleUuid(String str) {
            this.nativeRuleUuid = str;
        }

        public void setNeedNum(int i) {
            this.needNum = i;
        }

        public void setNeedTime(int i) {
            this.needTime = i;
        }
    }

    public static class PassPolicyBean {

        @JsonNode(key = "passPercent")
        private int passPercent;

        @JsonNode(key = "passType")
        private String passType;

        public static PassPolicyBean objectFromData(String str) {
            try {
                return (PassPolicyBean) JsonResolver.fromJson(str, PassPolicyBean.class);
            } catch (Exception unused) {
                return null;
            }
        }

        public int getPassPercent() {
            return this.passPercent;
        }

        public String getPassType() {
            return this.passType;
        }

        public void setPassPercent(int i) {
            this.passPercent = i;
        }

        public void setPassType(String str) {
            this.passType = str;
        }

        public String toString() {
            return "passPolicyBean{passType='" + this.passType + "', passPercent=" + this.passPercent + '}';
        }
    }

    public static class PositionBean {

        @JsonNode(key = LayoutModel.MODEL_KEY_CENTER_X)
        private double centerX;

        @JsonNode(key = LayoutModel.MODEL_KEY_CENTER_Y)
        private double centerY;

        @JsonNode(key = "height")
        private double height;

        @JsonNode(key = "width")
        private double width;

        public static PositionBean objectFromData(String str) {
            try {
                return (PositionBean) JsonResolver.fromJson(str, PositionBean.class);
            } catch (Exception unused) {
                return null;
            }
        }

        public double getCenterX() {
            return this.centerX;
        }

        public double getCenterY() {
            return this.centerY;
        }

        public double getHeight() {
            return this.height;
        }

        public double getWidth() {
            return this.width;
        }

        public void setCenterX(double d) {
            this.centerX = d;
        }

        public void setCenterY(double d) {
            this.centerY = d;
        }

        public void setHeight(double d) {
            this.height = d;
        }

        public void setWidth(double d) {
            this.width = d;
        }

        public String toString() {
            return "PositionBean{centerX=" + this.centerX + ", centerY=" + this.centerY + ", width=" + this.width + ", height=" + this.height + '}';
        }
    }

    public static class RandomStrategyBean {

        @JsonNode(key = "action")
        private int action;

        @JsonNode(key = "eventType")
        private String eventType;

        @JsonNode(key = "max")
        private int max;

        @JsonNode(key = MoreDistanceDialog.VALUE_MIN)
        private int min;

        public int getAction() {
            return this.action;
        }

        public String getEventType() {
            return this.eventType;
        }

        public int getMax() {
            return this.max;
        }

        public int getMin() {
            return this.min;
        }

        public void setAction(int i) {
            this.action = i;
        }

        public void setEventType(String str) {
            this.eventType = str;
        }

        public void setMax(int i) {
            this.max = i;
        }

        public void setMin(int i) {
            this.min = i;
        }
    }

    public static class RenderViewBean {

        @JsonNode(key = "borderHeight")
        private String borderHeight;

        @JsonNode(key = "borderWidth")
        private String borderWidth;

        @JsonNode(key = "clickNum")
        private int clickNum;

        @JsonNode(key = "countDownColor")
        private String countDownColor;

        @JsonNode(key = "delayDisplaySkipButton")
        private long delayDisplaySkipButton;

        @JsonNode(key = HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)
        private String direction;

        @JsonNode(key = "dpLinkUrlList")
        private List<DpLinkUrlListBean> dpLinkUrlList;

        @JsonNode(key = "imageUrl")
        private String imageUrl;

        @JsonNode(key = "layerPosition")
        private PositionBean layerPosition;

        @JsonNode(key = b.b)
        private int level;

        @JsonNode(key = RequestParameters.SUBRESOURCE_LOCATION)
        private String location;

        @JsonNode(key = "optimizePercent")
        private int optimizePercent;

        @JsonNode(key = "optimizeSize")
        private int optimizeSize;

        @JsonNode(key = "paddingHeight")
        private double paddingHeight;

        @JsonNode(key = "passPolicy")
        private List<PassPolicyBean> passPolicy;

        @JsonNode(key = "picSkipTime")
        private int picSkipTime;

        @JsonNode(key = "randomClick")
        private int randomClick;

        @JsonNode(key = RVParams.LONG_TITLE_SCROLLDISTANCE)
        private String scrollDistance;

        @JsonNode(key = "scrollDistancePercent")
        private int scrollDistancePercent;

        @JsonNode(key = "showBorder")
        private int showBorder;

        @JsonNode(key = "showCountDown")
        private int showCountDown;

        @JsonNode(key = "size")
        private String size;

        @JsonNode(key = "skipText")
        private String skipText;

        @JsonNode(key = "skipUnavailableTime")
        private long skipUnavailableTime;

        @JsonNode(key = "skipViewTotalTime")
        private long skipViewTotalTime;

        @JsonNode(key = "tapPosition")
        private PositionBean tapPosition;

        @JsonNode(key = "textColor")
        private String textColor;

        @JsonNode(key = "type")
        private String type;

        @JsonNode(key = "videoSkipTime")
        private int videoSkipTime;

        public static RenderViewBean objectFromData(String str) {
            try {
                return (RenderViewBean) JsonResolver.fromJson(str, RenderViewBean.class);
            } catch (Exception unused) {
                return null;
            }
        }

        public String getBorderHeight() {
            return this.borderHeight;
        }

        public String getBorderWidth() {
            return this.borderWidth;
        }

        public int getClickNum() {
            return this.clickNum;
        }

        public String getCountDownColor() {
            return this.countDownColor;
        }

        public long getDelayDisplaySkipButton() {
            return this.delayDisplaySkipButton;
        }

        public String getDirection() {
            return this.direction;
        }

        public List<DpLinkUrlListBean> getDpLinkUrlList() {
            return this.dpLinkUrlList;
        }

        public String getImageUrl() {
            return this.imageUrl;
        }

        public PositionBean getLayerPosition() {
            return this.layerPosition;
        }

        public int getLevel() {
            return this.level;
        }

        public String getLocation() {
            return this.location;
        }

        public int getOptimizePercent() {
            return this.optimizePercent;
        }

        public int getOptimizeSize() {
            return this.optimizeSize;
        }

        public double getPaddingHeight() {
            return this.paddingHeight;
        }

        public List<PassPolicyBean> getPassPolicy() {
            return this.passPolicy;
        }

        public int getPicSkipTime() {
            return this.picSkipTime;
        }

        public int getRandomClick() {
            return this.randomClick;
        }

        public String getScrollDistance() {
            return this.scrollDistance;
        }

        public int getScrollDistancePercent() {
            return this.scrollDistancePercent;
        }

        public int getShowBorder() {
            return this.showBorder;
        }

        public int getShowCountDown() {
            return this.showCountDown;
        }

        public String getSize() {
            return this.size;
        }

        public String getSkipText() {
            return this.skipText;
        }

        public long getSkipUnavailableTime() {
            return this.skipUnavailableTime;
        }

        public long getSkipViewTotalTime() {
            return this.skipViewTotalTime;
        }

        public PositionBean getTapPosition() {
            return this.tapPosition;
        }

        public String getTextColor() {
            return this.textColor;
        }

        public String getType() {
            return this.type;
        }

        public int getVideoSkipTime() {
            return this.videoSkipTime;
        }

        public void setBorderHeight(String str) {
            this.borderHeight = str;
        }

        public void setBorderWidth(String str) {
            this.borderWidth = str;
        }

        public void setClickNum(int i) {
            this.clickNum = i;
        }

        public void setCountDownColor(String str) {
            this.countDownColor = str;
        }

        public void setDelayDisplaySkipButton(long j) {
            this.delayDisplaySkipButton = j;
        }

        public void setDirection(String str) {
            this.direction = str;
        }

        public void setDpLinkUrlList(List<DpLinkUrlListBean> list) {
            this.dpLinkUrlList = list;
        }

        public void setImageUrl(String str) {
            this.imageUrl = str;
        }

        public void setLayerPosition(PositionBean positionBean) {
            this.layerPosition = positionBean;
        }

        public void setLevel(int i) {
            this.level = i;
        }

        public void setLocation(String str) {
            this.location = str;
        }

        public void setOptimizePercent(int i) {
            this.optimizePercent = i;
        }

        public void setOptimizeSize(int i) {
            this.optimizeSize = i;
        }

        public void setPaddingHeight(double d) {
            this.paddingHeight = d;
        }

        public void setPassPolicy(List<PassPolicyBean> list) {
            this.passPolicy = list;
        }

        public void setPicSkipTime(int i) {
            this.picSkipTime = i;
        }

        public void setRandomClick(int i) {
            this.randomClick = i;
        }

        public void setScrollDistance(String str) {
            this.scrollDistance = str;
        }

        public void setScrollDistancePercent(int i) {
            this.scrollDistancePercent = i;
        }

        public void setShowBorder(int i) {
            this.showBorder = i;
        }

        public void setShowCountDown(int i) {
            this.showCountDown = i;
        }

        public void setSize(String str) {
            this.size = str;
        }

        public void setSkipText(String str) {
            this.skipText = str;
        }

        public void setSkipUnavailableTime(long j) {
            this.skipUnavailableTime = j;
        }

        public void setSkipViewTotalTime(long j) {
            this.skipViewTotalTime = j;
        }

        public void setTapPosition(PositionBean positionBean) {
            this.tapPosition = positionBean;
        }

        public void setTextColor(String str) {
            this.textColor = str;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setVideoSkipTime(int i) {
            this.videoSkipTime = i;
        }

        public String toString() {
            return "RenderViewBean{type='" + this.type + "', dpLinkUrlList=" + this.dpLinkUrlList + ", optimizePercent=" + this.optimizePercent + ", optimizeSize=" + this.optimizeSize + ", scrollDistance='" + this.scrollDistance + "', scrollDistancePercent=" + this.scrollDistancePercent + ", direction='" + this.direction + "', level=" + this.level + ", skipUnavailableTime=" + this.skipUnavailableTime + ", skipViewTotalTime=" + this.skipViewTotalTime + ", layerPosition=" + this.layerPosition + ", tapPosition=" + this.tapPosition + ", imageUrl='" + this.imageUrl + "', passPolicy=" + this.passPolicy + ", delayDisplaySkipButton=" + this.delayDisplaySkipButton + ", paddingHeight=" + this.paddingHeight + ", skipText='" + this.skipText + "', textColor='" + this.textColor + "', showCountDown=" + this.showCountDown + ", countDownColor='" + this.countDownColor + "', showBorder=" + this.showBorder + '}';
        }
    }

    public static class RulesBean {

        @JsonNode(key = "baseId")
        private String baseId;

        @JsonNode(key = "formula")
        private String formula;

        @JsonNode(key = "results")
        private Integer[] results;

        @JsonNode(key = "rules")
        private List<RulesBean> rules;

        public String getBaseId() {
            return this.baseId;
        }

        public String getFormula() {
            return this.formula;
        }

        public Integer[] getResults() {
            return this.results;
        }

        public List<RulesBean> getRules() {
            return this.rules;
        }

        public void setBaseId(String str) {
            this.baseId = str;
        }

        public void setFormula(String str) {
            this.formula = str;
        }

        public void setResults(Integer[] numArr) {
            this.results = numArr;
        }

        public void setRules(List<RulesBean> list) {
            this.rules = list;
        }

        @NonNull
        public String toString() {
            return "RulesBean{formula='" + this.formula + "', results=" + Arrays.toString(this.results) + ", rules=" + this.rules + '}';
        }
    }

    public static class ScreenConfigVoBean {

        @JsonNode(key = "screenH")
        private String screenH;

        @JsonNode(key = "screenImage")
        private String screenImage;

        @JsonNode(key = "screenPriority")
        private String screenPriority;

        @JsonNode(key = "screenW")
        private String screenW;

        @JsonNode(key = "screenX")
        private String screenX;

        @JsonNode(key = "screenY")
        private String screenY;

        public String getScreenH() {
            return this.screenH;
        }

        public String getScreenImage() {
            return this.screenImage;
        }

        public String getScreenPriority() {
            return this.screenPriority;
        }

        public String getScreenW() {
            return this.screenW;
        }

        public String getScreenX() {
            return this.screenX;
        }

        public String getScreenY() {
            return this.screenY;
        }

        public void setScreenH(String str) {
            this.screenH = str;
        }

        public void setScreenImage(String str) {
            this.screenImage = str;
        }

        public void setScreenPriority(String str) {
            this.screenPriority = str;
        }

        public void setScreenW(String str) {
            this.screenW = str;
        }

        public void setScreenX(String str) {
            this.screenX = str;
        }

        public void setScreenY(String str) {
            this.screenY = str;
        }
    }

    public static class UniteControlBean {

        @JsonNode(key = "duration")
        private long duration;

        @JsonNode(key = "random")
        private int random;

        public long getDuration() {
            return this.duration;
        }

        public int getRandom() {
            return this.random;
        }

        public void setDuration(long j) {
            this.duration = j;
        }

        public void setRandom(int i) {
            this.random = i;
        }
    }

    public static AdSpacesBean objectFromData(String str) {
        try {
            return (AdSpacesBean) JsonResolver.fromJson(str, AdSpacesBean.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getAdType() {
        return this.adType;
    }

    public String getAppId() {
        return this.appId;
    }

    public BidBean getBid() {
        return this.bid;
    }

    public BidComponent getBidComponent() {
        return this.bidComponent;
    }

    public List<BuyerBean> getBuyer() {
        return this.buyer;
    }

    public String getBzComponentSsid() {
        return this.bzComponentSsid;
    }

    public ComponentBean getComponent() {
        return this.component;
    }

    public String getComponentSsid() {
        return this.componentSsid;
    }

    public EventStrategyBean getEventStrategy() {
        return this.eventStrategy;
    }

    public FilterBean getFilter() {
        return this.filter;
    }

    public String getFilterSsid() {
        return this.filterSsid;
    }

    public int getModelType() {
        return this.modelType;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public int getSwitchFiveVersion() {
        return this.switchFiveVersion;
    }

    public void setAdType(String str) {
        this.adType = str;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setBid(BidBean bidBean) {
        this.bid = bidBean;
    }

    public void setBidComponent(BidComponent bidComponent) {
        this.bidComponent = bidComponent;
    }

    public void setBuyer(List<BuyerBean> list) {
        this.buyer = list;
    }

    public void setBzComponentSsid(String str) {
        this.bzComponentSsid = str;
    }

    public void setComponent(ComponentBean componentBean) {
        this.component = componentBean;
    }

    public void setComponentSsid(String str) {
        this.componentSsid = str;
    }

    public void setEventStrategy(EventStrategyBean eventStrategyBean) {
        this.eventStrategy = eventStrategyBean;
    }

    public void setFilter(FilterBean filterBean) {
        this.filter = filterBean;
    }

    public void setFilterSsid(String str) {
        this.filterSsid = str;
    }

    public void setModelType(int i) {
        this.modelType = i;
    }

    public void setSpaceId(String str) {
        this.spaceId = str;
    }

    public void setSwitchFiveVersion(int i) {
        this.switchFiveVersion = i;
    }

    @NonNull
    public String toString() {
        return "AdSpacesBean{spaceId='" + this.spaceId + "', appId='" + this.appId + "', adType='" + this.adType + "', modelType=" + this.modelType + ", filter=" + this.filter + ", bid=" + this.bid + ", buyer=" + this.buyer + ", component=" + this.component + ", eventStrategy=" + this.eventStrategy + '}';
    }
}
