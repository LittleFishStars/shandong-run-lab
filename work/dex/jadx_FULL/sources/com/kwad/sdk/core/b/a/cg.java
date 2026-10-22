package com.kwad.sdk.core.b.a;

import com.kc.openset.advertisers.hl.HLADNID;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class cg implements com.kwad.sdk.core.d<BlockEvent> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((BlockEvent) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((BlockEvent) bVar, jSONObject);
    }

    private static void a(BlockEvent blockEvent, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        blockEvent.blockDuration = jSONObject.optLong("blockDuration");
        blockEvent.blockTimeThreshold = jSONObject.optLong("blockTimeThreshold", new Long(HLADNID.Reason.OTHER).longValue());
        blockEvent.blockLoopInterval = jSONObject.optLong("blockLoopInterval", new Long("100").longValue());
        blockEvent.calcBlockOverhead = jSONObject.optLong("calcBlockOverhead");
        blockEvent.currentActivity = jSONObject.optString("currentActivity");
        if (JSONObject.NULL.toString().equals(blockEvent.currentActivity)) {
            blockEvent.currentActivity = "";
        }
        blockEvent.processName = jSONObject.optString("processName");
        if (JSONObject.NULL.toString().equals(blockEvent.processName)) {
            blockEvent.processName = "";
        }
        blockEvent.stackTraceSample = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("stackTraceSample");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                BlockEvent.a aVar = new BlockEvent.a();
                aVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                blockEvent.stackTraceSample.add(aVar);
            }
        }
    }

    private static JSONObject b(BlockEvent blockEvent, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = blockEvent.blockDuration;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "blockDuration", j);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "blockTimeThreshold", blockEvent.blockTimeThreshold);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "blockLoopInterval", blockEvent.blockLoopInterval);
        long j2 = blockEvent.calcBlockOverhead;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "calcBlockOverhead", j2);
        }
        String str = blockEvent.currentActivity;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "currentActivity", blockEvent.currentActivity);
        }
        String str2 = blockEvent.processName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "processName", blockEvent.processName);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "stackTraceSample", blockEvent.stackTraceSample);
        return jSONObject;
    }
}
