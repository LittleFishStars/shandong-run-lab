package com.beizi.fusion.asnp.adn.ad.model.impl.trace;

import com.beizi.fusion.nn;
import com.beizi.fusion.tb;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class InitTraceModel implements tb {
    private long mInitEndTs;
    private long mInitStartTs;
    private final String mStartID;

    public InitTraceModel() {
        this.mInitStartTs = -1L;
        this.mInitEndTs = -1L;
        this.mStartID = nn.d();
    }

    public long getInitEndTs() {
        return this.mInitEndTs;
    }

    public long getInitStartTs() {
        return this.mInitStartTs;
    }

    public long getRoundTripTime() {
        long j = this.mInitStartTs;
        if (j == -1) {
            return 0L;
        }
        long j2 = this.mInitEndTs;
        if (j2 != -1) {
            return j2 - j;
        }
        return 0L;
    }

    public String getStartID() {
        return this.mStartID;
    }

    public void setInitEndTs(long j) {
        this.mInitEndTs = j;
    }

    public void setInitStartTs(long j) {
        this.mInitStartTs = j;
        this.mInitEndTs = -1L;
    }

    /* JADX INFO: renamed from: deepCopy, reason: merged with bridge method [inline-methods] */
    public InitTraceModel m166deepCopy() {
        return new InitTraceModel(this);
    }

    private InitTraceModel(InitTraceModel initTraceModel) {
        this.mInitStartTs = -1L;
        this.mInitEndTs = -1L;
        this.mStartID = initTraceModel.mStartID;
        this.mInitStartTs = initTraceModel.getInitStartTs();
        this.mInitEndTs = initTraceModel.getInitEndTs();
    }
}
