package com.kwad.components.core.innerEc.live.comment.sendcomment;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LiveSendCommentResponse extends BaseResultData {
    private static final long serialVersionUID = 7815753927934092662L;
    public int commentCode;
    public String commentId;

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String responseData = d.getResponseData(jSONObject.optString("data"));
            if (TextUtils.isEmpty(responseData)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(responseData);
            this.commentId = jSONObject2.optString("commentId");
            this.commentCode = jSONObject2.optInt("commentCode");
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
    }
}
