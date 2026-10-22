package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.AssetModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.down.DownloadInfoModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.IncomeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.link.LinkModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.kg;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class NativeModel extends ASNPJsonResponseModel {
    public static final String JSON_KEY_SCHEME = "scheme";

    @kg(key = "asset")
    private List<AssetModel> asset;

    @kg(key = "dwinfo")
    private DownloadInfoModel downloadInfo;

    @kg(key = "income")
    private IncomeModel income;

    @kg(key = "interactionId")
    private String interactionId;

    @kg(key = "link")
    private LinkModel link;

    @kg(key = JSON_KEY_SCHEME)
    private List<RenderModel> render;

    @kg(key = "schemeId")
    private String renderId;

    @kg(key = "rotationUpdate")
    private int rotation;

    public static class NativeModelWrapper extends NativeModel {
        public NativeModelWrapper(JSONObject jSONObject) {
            super(jSONObject);
        }

        public void updateWrapperScheme(List<RenderModel> list) {
            ((NativeModel) this).render = list;
        }
    }

    public NativeModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public List<AssetModel> getAsset() {
        return this.asset;
    }

    public DownloadInfoModel getDownloadInfo() {
        return this.downloadInfo;
    }

    public IncomeModel getIncome() {
        return this.income;
    }

    public String getInteractionId() {
        return this.interactionId;
    }

    public LinkModel getLink() {
        return this.link;
    }

    public List<RenderModel> getRender() {
        return this.render;
    }

    public String getRenderId() {
        return this.renderId;
    }

    public int getRotation() {
        return this.rotation;
    }
}
