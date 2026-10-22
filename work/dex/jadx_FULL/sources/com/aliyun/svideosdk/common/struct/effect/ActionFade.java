package com.aliyun.svideosdk.common.struct.effect;

import android.util.Pair;
import com.aliyun.Visible;
import com.google.common.net.b;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class ActionFade extends ActionFrameBase<Float> {

    @SerializedName(b.t)
    protected float mFromAlpha;

    @SerializedName("To")
    protected float mToAlpha;

    public ActionFade() {
        this.mType = ActionBase.Type.alpha;
    }

    public float getFromAlpha() {
        return this.mFromAlpha;
    }

    public float getToAlpha() {
        return this.mToAlpha;
    }

    public void setAnimationConfig(List<Pair<Float, Float>> list) {
    }

    public void setFromAlpha(float f) {
        this.mFromAlpha = f;
    }

    public void setToAlpha(float f) {
        this.mToAlpha = f;
    }
}
