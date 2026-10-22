package com.kwad.components.ad.reward.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.n.r;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    private String liveStartTime;

    @Nullable
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private String originPrice;
    private int playableStyle;
    private String price;
    private String tT;
    private String tU;
    private String title;
    private List<String> vO;
    private String vP;
    private String vQ;
    private String vR;
    private boolean vS;
    private String vT;
    private String vU = "查看详情";
    private String vV = "立即预约";
    private List<String> vW;

    @Nullable
    private AdTemplate vX;

    private void T(String str) {
        this.vQ = str;
    }

    private void U(String str) {
        this.vR = str;
    }

    @Nullable
    public static a V(AdTemplate adTemplate) {
        CouponInfo firstCouponList;
        if (adTemplate == null) {
            return null;
        }
        AdInfo adInfoEO = e.eO(adTemplate);
        AdProductInfo adProductInfoDc = com.kwad.sdk.core.response.helper.a.dc(adInfoEO);
        a aVar = new a();
        String name = adProductInfoDc.getName();
        aVar.title = name;
        if (TextUtils.isEmpty(name)) {
            aVar.title = com.kwad.sdk.core.response.helper.a.aD(adInfoEO);
        }
        aVar.tT = adProductInfoDc.getIcon();
        aVar.tU = com.kwad.sdk.core.response.helper.a.aA(adInfoEO);
        aVar.price = adProductInfoDc.getPrice();
        aVar.originPrice = adProductInfoDc.getOriginPrice();
        if (!adProductInfoDc.isCouponListEmpty() && (firstCouponList = adProductInfoDc.getFirstCouponList()) != null) {
            aVar.U(CouponInfo.jinniuFormatCoupon(firstCouponList));
            aVar.T(firstCouponList.getFormattedJinniuPrefix());
        }
        return aVar;
    }

    @Nullable
    public static a W(AdTemplate adTemplate) {
        AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfoDU = com.kwad.sdk.core.response.helper.b.dU(adTemplate);
        a aVar = new a();
        aVar.tT = merchantLiveReservationInfoDU.userHeadUrl;
        aVar.liveStartTime = merchantLiveReservationInfoDU.liveStartTime;
        aVar.title = merchantLiveReservationInfoDU.title;
        aVar.vS = merchantLiveReservationInfoDU.needShowSubscriberCount();
        aVar.vT = merchantLiveReservationInfoDU.getFormattedLiveSubscribeCount();
        aVar.vW = merchantLiveReservationInfoDU.bookUserUrlList;
        AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo = merchantLiveReservationInfoDU.playEndCard;
        aVar.vU = liveReservationPlayEndInfo.detailBtnTitle;
        aVar.vV = liveReservationPlayEndInfo.reservationBtnTitle;
        aVar.vX = adTemplate;
        return aVar;
    }

    @Nullable
    public static a a(r rVar, boolean z) {
        AdTemplate adTemplate;
        if (rVar == null || (adTemplate = rVar.getAdTemplate()) == null) {
            return null;
        }
        AdInfo adInfoEO = e.eO(adTemplate);
        a aVar = new a();
        aVar.title = com.kwad.sdk.core.response.helper.a.cs(adInfoEO);
        aVar.tT = com.kwad.sdk.core.response.helper.a.cv(adInfoEO);
        aVar.tU = com.kwad.sdk.core.response.helper.a.aA(adInfoEO);
        aVar.vO = com.kwad.sdk.core.response.helper.d.eF(adTemplate);
        aVar.vP = com.kwad.sdk.core.response.helper.a.aK(adInfoEO);
        aVar.playableStyle = e.o(adTemplate, z);
        aVar.vX = adTemplate;
        aVar.mApkDownloadHelper = rVar.iv();
        return aVar;
    }

    public final String getOriginPrice() {
        return this.originPrice;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String hA() {
        return this.tT;
    }

    public final String hB() {
        return this.tU;
    }

    public final String iA() {
        return this.vV;
    }

    public final boolean iB() {
        return this.vS;
    }

    public final List<String> iC() {
        return this.vW;
    }

    public final String iE() {
        return this.liveStartTime;
    }

    public final String is() {
        return this.vR;
    }

    public final String it() {
        return this.vQ;
    }

    @Nullable
    public final AdTemplate iu() {
        return this.vX;
    }

    @Nullable
    public final com.kwad.components.core.e.d.d iv() {
        return this.mApkDownloadHelper;
    }

    public final List<String> iw() {
        return this.vO;
    }

    public final boolean ix() {
        List<String> list = this.vO;
        return list == null || list.size() == 0;
    }

    public final int iy() {
        return this.playableStyle;
    }

    public final String iz() {
        return this.vT;
    }
}
