package com.alibaba.ariver.kernel.track;

import android.os.SystemClock;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.track.Event;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DefaultEventTracker implements EventTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24296a = "AriverKernel:EventTracker";

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public void addAttr(Node node, String str, String str2) {
        RVLogger.d(f24296a, "EventTracker addAttr " + str + " " + str2);
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event cost(Node node, String str, long j) {
        RVLogger.d(f24296a, "EventTracker cost " + str);
        Event.Cost cost = new Event.Cost(j);
        cost.setTrackId(str);
        return cost;
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event error(Node node, String str, String str2) {
        RVLogger.d(f24296a, "EventTracker error " + str);
        Event.Error error = new Event.Error(str2);
        error.setTrackId(str);
        return error;
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public void event(Node node, Event event) {
        RVLogger.d(f24296a, "EventTracker event " + event);
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event interceptLoad(Node node, String str, Map<String, Object> map) {
        RVLogger.d(f24296a, "EventTracker interceptLoad " + str);
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public void logPageAbnormal(Node node) {
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event stub(Node node, String str) {
        return stub(node, str, SystemClock.elapsedRealtime());
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event whiteScreen(Node node, String str, String str2, Map<String, Object> map) {
        RVLogger.d(f24296a, "EventTracker whiteScreen " + str);
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event stub(Node node, String str, long j) {
        RVLogger.d(f24296a, "EventTracker stub " + str);
        Event.Stub stub = new Event.Stub(j);
        stub.setTrackId(str);
        return stub;
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event whiteScreen(Node node, String str, String str2, String str3, Map<String, Object> map) {
        RVLogger.d(f24296a, "EventTracker whiteScreen " + str);
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.track.EventTracker
    public Event whiteScreen(String str, String str2, Map<String, Object> map) {
        RVLogger.d(f24296a, "EventTracker whiteScreen " + str);
        return null;
    }
}
