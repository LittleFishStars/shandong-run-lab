package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class ActionShader extends ActionBase {

    @SerializedName("FragmentShader")
    private String mFragmentFunction;

    @SerializedName("VertexShader")
    private String mVertexFunction;

    public ActionShader() {
        this.mType = ActionBase.Type.custom;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.ActionBase
    public void setAnimationConfig(String str) {
        throw new RuntimeException("Not Support");
    }

    public void setShader(String str, String str2) {
        this.mVertexFunction = str;
        this.mFragmentFunction = str2;
    }
}
