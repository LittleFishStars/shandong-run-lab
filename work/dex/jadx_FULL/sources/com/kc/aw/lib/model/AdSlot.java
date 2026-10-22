package com.kc.aw.lib.model;

import android.view.View;
import android.view.ViewGroup;
import com.kc.aw._at;
import com.kc.aw._c9;
import com.kc.aw._cl;
import com.kc.aw._nr;
import com.kc.aw._v;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface AdSlot {
    public static final float NO_SET = 0.0f;

    @Keep
    public static class Builder {

        @Deprecated
        private ViewGroup adContainer;
        private long basePrice;
        private List<View> clickView;
        private String codeID;
        private int countdownTime;
        private List<View> creativeView;
        private String expressViewColor;
        private String mediaExtra;
        private int nativeAdType;
        private int orientation;
        private String ptgSlotID;
        private int rewardAmount;
        private String rewardName;
        private boolean selfRender;
        private int usedFor;
        private String userID;
        private int imgAcceptedWidth = 640;
        private int imgAcceptedHeight = 320;
        private float expressViewAcceptedWidth = 0.0f;
        private float expressViewAcceptedHeight = 0.0f;
        private boolean autoPlay = true;
        private boolean playMuted = true;
        public int currentReqLayer = 1;
        private PtgAdLoadType adLoadType = PtgAdLoadType.UNKNOWN;
        private boolean countdownVisibility = true;
        private int timeoutMs = 0;
        private float expressViewPaddingLeft = 0.0f;
        private float expressViewPaddingTop = 0.0f;
        private float expressViewPaddingRight = 0.0f;
        private float expressViewPaddingBottom = 0.0f;

        public AdSlot build() {
            _v _vVar = new _v();
            _vVar._h = 1;
            _vVar._a = this.ptgSlotID;
            _vVar._c = this.codeID;
            _vVar._d = this.imgAcceptedWidth;
            _vVar._e = this.imgAcceptedHeight;
            _vVar._f = this.expressViewAcceptedWidth;
            _vVar._g = this.expressViewAcceptedHeight;
            _vVar._H = this.rewardName;
            _vVar._I = this.rewardAmount;
            _vVar._J = this.mediaExtra;
            _vVar._K = this.userID;
            _vVar._i = this.orientation;
            _vVar._j = this.nativeAdType;
            _vVar._k = this.autoPlay;
            _vVar._n = new WeakReference<>(this.adContainer);
            _vVar._r = this.clickView;
            _vVar._s = this.creativeView;
            _vVar._l = this.playMuted;
            _vVar._z = this.selfRender;
            _vVar._A = this.usedFor;
            _vVar._B = this.currentReqLayer;
            _vVar._C = this.basePrice;
            _vVar._D = this.adLoadType;
            _vVar._E = this.countdownVisibility;
            _vVar._F = this.countdownTime;
            _vVar._T = this.timeoutMs;
            _vVar._O = this.expressViewPaddingLeft;
            _vVar._P = this.expressViewPaddingTop;
            _vVar._Q = this.expressViewPaddingRight;
            _vVar._R = this.expressViewPaddingBottom;
            _vVar._S = this.expressViewColor;
            return _vVar;
        }

        @Deprecated
        public Builder setAdContainer(ViewGroup viewGroup) {
            this.adContainer = viewGroup;
            return this;
        }

        public Builder setAdLoadType(PtgAdLoadType ptgAdLoadType) {
            this.adLoadType = ptgAdLoadType;
            return this;
        }

        public Builder setBasePrice(long j) {
            this.basePrice = j;
            return this;
        }

        public Builder setClickView(View... viewArr) {
            this.clickView = new ArrayList();
            for (View view : viewArr) {
                this.clickView.add(view);
            }
            return this;
        }

        public Builder setCodeId(String str) {
            this.codeID = str;
            return this;
        }

        public Builder setCountdownTime(int i) {
            this.countdownTime = i;
            return this;
        }

        public Builder setCountdownVisibility(boolean z) {
            this.countdownVisibility = z;
            return this;
        }

        public Builder setCreativeView(View... viewArr) {
            this.creativeView = new ArrayList();
            for (View view : viewArr) {
                this.creativeView.add(view);
            }
            return this;
        }

        public Builder setExpressViewAcceptedDpSize(float f, float f2) {
            this.expressViewAcceptedWidth = f;
            this.expressViewAcceptedHeight = f2;
            return this;
        }

        @Deprecated
        public Builder setExpressViewAcceptedSize(float f, float f2) {
            setExpressViewAcceptedDpSize(f, f2);
            return this;
        }

        public Builder setExpressViewColor(String str) {
            this.expressViewColor = str;
            return this;
        }

        public Builder setExpressViewPadding(float f, float f2, float f3, float f4) {
            this.expressViewPaddingLeft = f;
            this.expressViewPaddingTop = f2;
            this.expressViewPaddingRight = f3;
            this.expressViewPaddingBottom = f4;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.imgAcceptedWidth = i;
            this.imgAcceptedHeight = i2;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.autoPlay = z;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.mediaExtra = str;
            return this;
        }

        public Builder setNativeAdType(int i) {
            this.nativeAdType = i;
            return this;
        }

        @Deprecated
        public Builder setNeedSkipView(boolean z) {
            return this;
        }

        public Builder setNextLayer(int i) {
            this.currentReqLayer = i + 1;
            return this;
        }

        public Builder setOrientation(int i) {
            this.orientation = i;
            return this;
        }

        public Builder setPlayMuted(boolean z) {
            this.playMuted = z;
            return this;
        }

        public Builder setPtgSlotId(String str) {
            this.ptgSlotID = str;
            return this;
        }

        public Builder setRewardAmount(int i) {
            this.rewardAmount = i;
            return this;
        }

        public Builder setRewardName(String str) {
            this.rewardName = str;
            return this;
        }

        public Builder setSelfRender(boolean z) {
            this.selfRender = z;
            return this;
        }

        @Deprecated
        public Builder setSkipButtonOffsetTopDp(int i) {
            return this;
        }

        public Builder setTimeoutMs(int i) {
            this.timeoutMs = i;
            return this;
        }

        public Builder setUsedFor(int i) {
            this.usedFor = i;
            return this;
        }

        public Builder setUserID(String str) {
            this.userID = str;
            return this;
        }
    }

    void bind(_cl _clVar);

    AdSlot createCustomerAdSlot(_cl _clVar);

    @Deprecated
    ViewGroup getAdContainer();

    int getAdCount();

    PtgAdLoadType getAdLoadType();

    long getBasePrice();

    _at getBidAdm();

    int getCategoryType();

    List<View> getClickView();

    String getCodeId();

    long getCountdownTime();

    List<View> getCreativeView();

    int getCt();

    int getCurrentReqLayer();

    _c9 getDeviceInfo();

    _cl getDispatchPolicyCustomerItem();

    float getExpressViewAcceptedHeight();

    float getExpressViewAcceptedWidth();

    String getExpressViewColor();

    float getExpressViewPaddingBottom();

    float getExpressViewPaddingLeft();

    float getExpressViewPaddingRight();

    float getExpressViewPaddingTop();

    int getImgAcceptedHeight();

    int getImgAcceptedWidth();

    String getInteractionAdvUrl();

    String getMediaExtra();

    int getNativeAdType();

    int getOrientation();

    @Deprecated
    ViewGroup getOriginalAdContainer();

    int getPosition(int i);

    String getPtgSlotID();

    long getRandomTime();

    int getRandomToken();

    String getReqId();

    int getRewardAmount();

    String getRewardName();

    int getStype();

    int getTimeoutMs();

    _nr getTrackingData();

    int getUsedFor();

    String getUserID();

    String getVendorId();

    boolean isAdExposed();

    boolean isAutoPlay();

    boolean isConcurrent();

    boolean isCountdownVisibility();

    boolean isPlayMuted();

    boolean isSelfRender();

    boolean isUniqueReq();

    @Deprecated
    void setAdContainer(ViewGroup viewGroup);

    void setAdCount(int i);

    void setAdExposed(boolean z);

    void setAdLoadType(PtgAdLoadType ptgAdLoadType);

    void setBasePrice(long j);

    void setCategoryType(int i);

    void setCodeID(String str);

    void setConcurrent(boolean z);

    void setConsumerPrice(int i);

    void setCountdownTime(long j);

    void setCountdownVisibility(boolean z);

    void setCt(int i);

    void setDeviceInfo(_c9 _c9Var);

    void setDispatchPolicyCustomerItem(_cl _clVar);

    void setExpressViewColor(String str);

    void setInteractionAdvUrl(String str);

    void setNativeAdType(int i);

    void setNextLayer(int i);

    @Deprecated
    void setOriginalAdContainer(ViewGroup viewGroup);

    void setPtgSlotID(String str);

    void setRandomTime(long j);

    void setRandomToken(int i);

    void setStype(int i);

    void setTimeoutMs(int i);

    void setTrackingData(_nr _nrVar);

    void setUniqueReq(boolean z);

    void setVendorId(String str);

    void withBid(String str);

    AdSlot write(AdSlot adSlot);
}
