package com.kwad.components.core.innerEc.live.comment.history;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.core.innerEc.f;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model.PBHelper;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model.PbCommentFeed;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.BaseResultData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class HistoryCommentsResponse extends BaseResultData {
    private static final String TAG = "HistoryCommentsResponse";
    private static final long serialVersionUID = -4823133990581662360L;
    public int autoBackTraceSize;
    public List<PbCommentFeed> historyFeedList = new ArrayList();

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            PBHelper pBHelperRi = f.ri();
            String responseData = d.getResponseData(jSONObject.optString("data"));
            if (TextUtils.isEmpty(responseData)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(responseData);
            this.autoBackTraceSize = jSONObject2.optInt("autoBackTraceSize", 0);
            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray(MediationConstant.RIT_TYPE_FEED);
            if (jSONArrayOptJSONArray != null) {
                for (int length = jSONArrayOptJSONArray.length() - 1; length >= 0; length--) {
                    this.historyFeedList.add((PbCommentFeed) pBHelperRi.parseFrom(Base64.decode(jSONArrayOptJSONArray.optString(length), 0), PbCommentFeed.class));
                }
            }
        } catch (Exception e) {
            c.printStackTrace(e);
        }
    }
}
