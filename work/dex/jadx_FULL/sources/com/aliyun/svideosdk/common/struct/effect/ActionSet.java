package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class ActionSet extends ActionBase {

    @SerializedName("ActionList")
    private List<ActionBase> mActionList;

    @SerializedName("Mode")
    private int mMode = AnimationMode.Dependent.ordinal();

    public enum AnimationMode {
        Dependent,
        Independent
    }

    public ActionSet() {
        this.mTimelineIn = -1.0f;
        this.mTimelineOut = -1.0f;
        this.mType = ActionBase.Type.action_set;
        this.mActionList = new ArrayList();
    }

    public void addAction(ActionBase actionBase) {
        this.mActionList.add(actionBase);
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.ActionBase
    public void setAnimationConfig(String str) {
        throw new RuntimeException("Not Support");
    }

    public void setMode(AnimationMode animationMode) {
        this.mMode = animationMode.ordinal();
    }
}
