package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.view;

import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.view.status.StatusTextModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.view.status.StatusTitleModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ViewModel extends ASNPJsonResponseModel {

    @kg(key = "animationType")
    private String animationType;

    @kg(key = "assetId")
    private String assetsId;

    @kg(key = "bgColor")
    private String bgColor;

    @kg(key = "borderColor")
    private String borderColor;

    @kg(key = "borderRadius")
    private String borderRadius;

    @kg(key = "borderSize")
    private String borderSize;
    private String cmd5;

    @kg(key = "controlType")
    private String controlType;

    @kg(key = "fontSize")
    private int fontSize;

    @kg(key = "fontWeight")
    private float fontWeight;

    @kg(key = "imageUrl")
    private String imgUrl;

    @kg(key = "interactiveSubTitle")
    private StatusTitleModel interactiveSubTitle;

    @kg(key = "interactiveTitle")
    private StatusTitleModel interactiveTitle;

    @kg(key = "lineCount")
    private int lineCount;

    @kg(key = "lineHeight")
    private float lineHeight;

    @kg(key = "replay")
    private int replay;

    @kg(key = "scrollInterval")
    private int scrollInterval;

    @kg(key = "textAlign")
    private String textAlign;

    @kg(key = "textColor")
    private String textColor;

    @kg(key = "title")
    private String title;

    @kg(key = "titleInfo")
    private StatusTextModel titleInfo;

    @kg(key = "isBlur")
    private boolean useGaussianBlur;

    @kg(key = "voiceOn")
    private int voiceOn;

    public ViewModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String getAnimationType() {
        return this.animationType;
    }

    public String getAssetsId() {
        return this.assetsId;
    }

    public String getBgColor() {
        return this.bgColor;
    }

    public String getBorderColor() {
        return this.borderColor;
    }

    public String getBorderRadius() {
        return this.borderRadius;
    }

    public String getBorderSize() {
        return this.borderSize;
    }

    public String getCMD5() {
        return this.cmd5;
    }

    public String getControlType() {
        return this.controlType;
    }

    public int getFontSize() {
        return this.fontSize;
    }

    public float getFontWeight() {
        return this.fontWeight;
    }

    public String getImageURL() {
        return this.imgUrl;
    }

    public StatusTitleModel getInteractiveSubTitle() {
        return this.interactiveSubTitle;
    }

    public StatusTitleModel getInteractiveTitle() {
        return this.interactiveTitle;
    }

    public int getLineCount() {
        int i = this.lineCount;
        if (i > 0) {
            return i;
        }
        return 1;
    }

    public float getLineHeight() {
        return this.lineHeight;
    }

    public int getReplay() {
        return this.replay;
    }

    public int getScrollInterval() {
        return this.scrollInterval;
    }

    public String getTextAlign() {
        return this.textAlign;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public String getTitle() {
        return this.title;
    }

    public StatusTextModel getTitleInfo() {
        return this.titleInfo;
    }

    public boolean isMute() {
        return this.voiceOn <= 0;
    }

    public void setCMD5(String str) {
        this.cmd5 = str;
    }

    public boolean useGaussianBlur() {
        return this.useGaussianBlur;
    }
}
