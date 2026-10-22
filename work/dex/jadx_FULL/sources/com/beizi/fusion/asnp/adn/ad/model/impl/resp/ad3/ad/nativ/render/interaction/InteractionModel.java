package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction;

import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form.EulerAngleModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form.ShakeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.interaction.form.SlideModel;
import com.beizi.fusion.kg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class InteractionModel extends ASNPJsonResponseModel {

    @kg(key = "autoClose")
    private int autoClose;

    @kg(key = "bindEvent")
    private String bindEvent;

    @kg(key = "clickRemoveSensor")
    private boolean clickRemoveSensor;

    @kg(key = "coolTime")
    private long coolTime;

    @kg(key = "countDownTime")
    private int countDownTime;

    @kg(key = "interactionDuration")
    private int duration;

    @kg(key = "eulerAngle")
    private EulerAngleModel eulerAngle;

    @kg(key = "execution")
    private String execution;

    @kg(key = "feedbackAnimation")
    private int feedbackAnimation;

    @kg(key = "hideRemoveSensor")
    private boolean hideRemoveSensor;

    @kg(key = "passivationTime")
    private long passivationTime;

    @kg(key = "passivationType")
    private int passivationType;

    @kg(key = "protectTime")
    private long protectTime;

    @kg(key = "shake")
    private ShakeModel shake;

    @kg(key = "slide")
    private SlideModel slideModel;

    public InteractionModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String getBindEvent() {
        ShakeModel shakeModel;
        if (TextUtils.isEmpty(this.bindEvent) || "none".equalsIgnoreCase(this.bindEvent)) {
            return "";
        }
        return (!"shake".equals(this.bindEvent) || (shakeModel = this.shake) == null || shakeModel.getRegulatoryAngle() == null) ? this.bindEvent : "mixed";
    }

    public long getCoolTime() {
        return this.coolTime;
    }

    public int getCountDownTime() {
        return this.countDownTime;
    }

    public int getDuration() {
        return this.duration;
    }

    public EulerAngleModel getEulerAngle() {
        return this.eulerAngle;
    }

    public String getExecution() {
        return this.execution;
    }

    public int getFeedbackAnimation() {
        return this.feedbackAnimation;
    }

    public long getPassivationTime() {
        return this.passivationTime;
    }

    public int getPassivationType() {
        return this.passivationType;
    }

    public long getProtectTime() {
        return this.protectTime;
    }

    public ShakeModel getShake() {
        return this.shake;
    }

    public SlideModel getSlideModel() {
        return this.slideModel;
    }

    public boolean isAutoSkip() {
        return this.autoClose == 1;
    }

    public boolean isClickRemoveSensor() {
        return this.clickRemoveSensor;
    }

    public boolean isHideRemoveSensor() {
        return this.hideRemoveSensor;
    }
}
