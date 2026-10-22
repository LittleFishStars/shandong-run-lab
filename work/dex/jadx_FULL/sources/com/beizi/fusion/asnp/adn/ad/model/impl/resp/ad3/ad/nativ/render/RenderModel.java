package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.InteractionModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.layout.LayoutModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.view.ViewModel;
import com.beizi.fusion.kg;
import com.huachenjie.common.constants.UserConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class RenderModel extends ASNPJsonResponseModel {

    @kg(key = UserConstants.URL_PARAMS.b)
    private String id;

    @kg(key = "")
    private InteractionModel interactionModel;

    @kg(key = "layer")
    private int layer;

    @kg(key = "")
    private LayoutModel layoutModel;

    @kg(key = "superView")
    private String superView;

    @kg(key = "")
    private ViewModel viewModel;

    public RenderModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String getId() {
        return this.id;
    }

    public InteractionModel getInteractionModel() {
        return this.interactionModel;
    }

    public int getLayer() {
        return this.layer;
    }

    public LayoutModel getLayoutModel() {
        return this.layoutModel;
    }

    public String getSuperView() {
        return this.superView;
    }

    public ViewModel getViewModel() {
        return this.viewModel;
    }
}
