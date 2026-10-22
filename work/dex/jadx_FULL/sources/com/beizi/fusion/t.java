package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.bid.BidAuction;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.bid.BiddingModel3;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.AssetModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.down.DownloadInfoModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.link.LinkModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.rule.CSensorModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;
import com.huachenjie.common.video.VideoPlayerActivity;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile t f27766a;

    private t() {
    }

    public static t a() {
        if (f27766a == null) {
            synchronized (t.class) {
                if (f27766a == null) {
                    f27766a = new t();
                }
            }
        }
        return f27766a;
    }

    public Map a(Context context, ba baVar, AdTraceModel adTraceModel, AdItemModel adItemModel) {
        if (baVar != null && adTraceModel != null) {
            HashMap map = new HashMap();
            a(map, baVar, adTraceModel, adItemModel);
            a(context, map, baVar, adItemModel);
            a(map, baVar, adTraceModel);
            return map;
        }
        return Collections.EMPTY_MAP;
    }

    private void a(Map map, ba baVar, AdTraceModel adTraceModel, AdItemModel adItemModel) {
        if (adTraceModel == null || baVar == null) {
            return;
        }
        JSONObject jSONObjectB = mg.b();
        mg.a(jSONObjectB, "requestUuid", adTraceModel.getRequestTracSessionID());
        int iA = s.a(baVar.c(), "materialInfo", 0);
        if (iA > 0 && adItemModel != null && (iA == 1 || iA == 101 || iA == 1001)) {
            JSONObject jSONObjectA = a(adTraceModel, adItemModel);
            if (iA == 101 || iA == 1001) {
                a(jSONObjectA, adItemModel);
                if (iA == 1001) {
                    String orderID = adTraceModel.getOrderID();
                    if (!TextUtils.isEmpty(orderID)) {
                        mg.a(jSONObjectA, "orderId", orderID);
                    }
                }
            }
            mg.a(jSONObjectB, "materialInfo", jSONObjectA);
        }
        map.put("materialInfo", jSONObjectB.toString());
    }

    private JSONObject a(AdTraceModel adTraceModel, AdItemModel adItemModel) {
        String url;
        List<AssetModel> asset = adItemModel.getNativeModel() != null ? adItemModel.getNativeModel().getAsset() : null;
        JSONObject jSONObjectB = mg.b();
        mg.a(jSONObjectB, "crid", adTraceModel.getCreateID());
        String url2 = "";
        if (asset == null || asset.isEmpty()) {
            url = "";
        } else {
            url = "";
            for (AssetModel assetModel : asset) {
                if (assetModel != null && "1001".equals(assetModel.getId()) && assetModel.getImage() != null) {
                    url2 = assetModel.getImage().getUrl();
                }
                if (assetModel != null && assetModel.getVideo() != null) {
                    url = assetModel.getVideo().getUrl();
                }
            }
        }
        if (!TextUtils.isEmpty(url2)) {
            mg.a(jSONObjectB, "imageUrl", url2);
        }
        if (!TextUtils.isEmpty(url)) {
            mg.a(jSONObjectB, VideoPlayerActivity.t, url);
        }
        return jSONObjectB;
    }

    private void a(JSONObject jSONObject, AdItemModel adItemModel) {
        if (adItemModel == null || adItemModel.getNativeModel() == null) {
            return;
        }
        NativeModel nativeModel = adItemModel.getNativeModel();
        DownloadInfoModel downloadInfo = nativeModel.getDownloadInfo();
        LinkModel link = nativeModel.getLink();
        if (link != null) {
            mg.a(jSONObject, "deeplinkUrl", link.getDeeplink());
            mg.a(jSONObject, "landingPageUrl", link.getLandingPageURL());
            mg.a(jSONObject, "downloadUrl", link.getDownloadURL());
            if (downloadInfo != null) {
                mg.a(jSONObject, ALPParamConstant.PACKAGENAME, downloadInfo.getBundle());
            }
            mg.a(jSONObject, "miniProgramId", link.getWxOriginalId());
            mg.a(jSONObject, "miniProgramPath", link.getWxProgramPath());
        }
    }

    private void a(Map map, ba baVar, AdTraceModel adTraceModel) {
        String str;
        String str2;
        String string;
        String dit;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        if (baVar == null || adTraceModel == null || s.a(baVar.c(), "sensorInfo", 0) != 1) {
            return;
        }
        CSensorModel cSensorModel = adTraceModel.getCSensorModel();
        int interactiveType = adTraceModel.getInteractiveType();
        HashMap map2 = new HashMap();
        if (interactiveType != 3) {
            map2.put("actionType", "0");
        } else if (cSensorModel != null) {
            int type = cSensorModel.getType();
            if (type == 1) {
                str = cSensorModel.getAcc() + "";
                str2 = cSensorModel.getAgl() + "";
                string = cSensorModel.getDut() + "";
                dit = cSensorModel.getDit();
            } else {
                str = "";
                str2 = str;
                string = str2;
                dit = string;
            }
            if (type == 2) {
                we.c sensorRecord = adTraceModel.getSensorRecord();
                if (sensorRecord != null) {
                    float fA = sensorRecord.a(1).a(cSensorModel.getDit());
                    float fA2 = sensorRecord.a(4).a(cSensorModel.getDit());
                    long jA = sensorRecord.a();
                    if (fA > cSensorModel.getAcc()) {
                        sb = new StringBuilder();
                    } else {
                        sb = new StringBuilder();
                        fA = nl.a(cSensorModel.getAcc());
                    }
                    sb.append(fA);
                    sb.append("");
                    String string2 = sb.toString();
                    if (fA2 > cSensorModel.getAgl()) {
                        sb2 = new StringBuilder();
                    } else {
                        sb2 = new StringBuilder();
                        fA2 = nl.a(cSensorModel.getAgl());
                    }
                    sb2.append(fA2);
                    sb2.append("");
                    String string3 = sb2.toString();
                    if (jA > cSensorModel.getDut()) {
                        sb3 = new StringBuilder();
                        sb3.append(jA);
                    } else {
                        sb3 = new StringBuilder();
                        sb3.append(nl.a(cSensorModel.getDut()));
                    }
                    sb3.append("");
                    str = string2;
                    str2 = string3;
                    string = sb3.toString();
                }
                dit = cSensorModel.getDit();
            }
            map2.put("actionType", "1");
            map2.put("maxAcc", str);
            map2.put("angle", str2);
            map2.put("duration", string);
            map2.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, dit);
        }
        map.put("sensorInfo", map2);
    }

    private void a(Context context, Map map, ba baVar, AdItemModel adItemModel) {
        BiddingModel3 biddingModel;
        if (baVar == null || adItemModel == null || s.a(baVar.c(), "auctionInfo", 0) != 1 || (biddingModel = adItemModel.getBiddingModel()) == null) {
            return;
        }
        BidAuction auction = biddingModel.getAuction();
        JSONObject jSONObjectB = mg.b();
        if (auction != null) {
            mg.a(jSONObjectB, "raiseSortPrice", Integer.valueOf(auction.getSortRaise()));
            mg.a(jSONObjectB, "effectRate", Integer.valueOf(auction.getRandom()));
            mg.a(jSONObjectB, "auctionType", Integer.valueOf(auction.getType()));
            mg.a(jSONObjectB, "isLastLook", Integer.valueOf(auction.getIsClose()));
            mg.a(jSONObjectB, "winPriceMin", auction.getMinRate());
            mg.a(jSONObjectB, "winPriceMax", auction.getMaxRate());
            mg.a(jSONObjectB, "secondPrice", Integer.valueOf(auction.getSecondPrice()));
            mg.a(jSONObjectB, "customData", auction.getCustomData());
        } else {
            mg.a(jSONObjectB, "raiseSortPrice", (Object) (-1));
            mg.a(jSONObjectB, "effectRate", (Object) (-1));
            mg.a(jSONObjectB, "auctionType", (Object) (-1));
            mg.a(jSONObjectB, "isLastLook", (Object) (-1));
            mg.a(jSONObjectB, "secondPrice", (Object) 0);
            mg.a(jSONObjectB, "winPriceMin", "");
            mg.a(jSONObjectB, "winPriceMax", "");
            mg.a(jSONObjectB, "customData", "");
        }
        String strB = ((id) dh.a().b(context)).b(jSONObjectB.toString(), "101,1001", id.a.STEP_BY_STEP, false);
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        map.put("auctionInfo", strB);
    }
}
