package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.layout;

import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.layout.par.LayoutParamModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class LayoutModel extends ASNPJsonResponseModel {
    public static final String MODEL_KEY_CENTER_X = "centerX";
    public static final String MODEL_KEY_CENTER_Y = "centerY";
    public static final String MODEL_KEY_HEIGHT = "height";
    public static final String MODEL_KEY_MARGIN_BOTTOM = "marginBottom";
    public static final String MODEL_KEY_MARGIN_LEFT = "marginLeft";
    public static final String MODEL_KEY_MARGIN_RIGHT = "marginRight";
    public static final String MODEL_KEY_MARGIN_TOP = "marginTop";
    public static final String MODEL_KEY_WIDTH = "width";

    @kg(key = "autoHeight")
    private int autoHeight;

    @kg(key = "autoWidth")
    private int autoWidth;

    @kg(key = MODEL_KEY_CENTER_X)
    private LayoutParamModel centerX;

    @kg(key = MODEL_KEY_CENTER_Y)
    private LayoutParamModel centerY;

    @kg(key = "height")
    private LayoutParamModel height;

    @kg(key = MODEL_KEY_MARGIN_BOTTOM)
    private LayoutParamModel marginBottom;

    @kg(key = MODEL_KEY_MARGIN_LEFT)
    private LayoutParamModel marginLeft;

    @kg(key = MODEL_KEY_MARGIN_RIGHT)
    private LayoutParamModel marginRight;

    @kg(key = MODEL_KEY_MARGIN_TOP)
    private LayoutParamModel marginTop;

    @kg(key = "maxHeight")
    private String maxHeight;

    @kg(key = "maxWidth")
    private String maxWidth;

    @kg(key = "minHeight")
    private String minHeight;

    @kg(key = "minWidth")
    private String minWidth;

    @kg(key = "width")
    private LayoutParamModel width;

    public LayoutModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public LayoutParamModel getCenterX() {
        return this.centerX;
    }

    public LayoutParamModel getCenterY() {
        return this.centerY;
    }

    public LayoutParamModel getHeight() {
        return this.height;
    }

    public LayoutParamModel getMarginBottom() {
        return this.marginBottom;
    }

    public LayoutParamModel getMarginLeft() {
        return this.marginLeft;
    }

    public LayoutParamModel getMarginRight() {
        return this.marginRight;
    }

    public LayoutParamModel getMarginTop() {
        return this.marginTop;
    }

    public String getMaxHeight() {
        return this.maxHeight;
    }

    public String getMaxWidth() {
        return this.maxWidth;
    }

    public String getMinHeight() {
        return this.minHeight;
    }

    public String getMinWidth() {
        return this.minWidth;
    }

    public LayoutParamModel getWidth() {
        return this.width;
    }

    public boolean isAutoHeight() {
        LayoutParamModel layoutParamModel = this.height;
        if (layoutParamModel != null && !TextUtils.isEmpty(layoutParamModel.getSize())) {
            String strTrim = this.height.getSize().trim();
            if (!"0".equalsIgnoreCase(strTrim) && !"0%".equalsIgnoreCase(strTrim)) {
                return false;
            }
        }
        return true;
    }
}
