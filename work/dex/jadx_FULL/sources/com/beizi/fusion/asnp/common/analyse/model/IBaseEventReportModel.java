package com.beizi.fusion.asnp.common.analyse.model;

import com.beizi.fusion.tb;
import com.beizi.fusion.ua;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class IBaseEventReportModel extends ua implements tb {
    protected final IStringEventEnum event;

    public IBaseEventReportModel(IStringEventEnum iStringEventEnum) {
        this.event = iStringEventEnum;
    }

    public abstract /* synthetic */ tb deepCopy();

    public String getEventCode() {
        IStringEventEnum iStringEventEnum = this.event;
        return iStringEventEnum != null ? iStringEventEnum.getEventCode() : "";
    }
}
