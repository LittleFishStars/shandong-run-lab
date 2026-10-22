package com.alibaba.ariver.resource.api.prepare;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface PrepareStep {
    void execute(PrepareController prepareController, PrepareContext prepareContext, PrepareCallback prepareCallback);

    void finish();

    StepType getType();

    boolean isFinished();
}
