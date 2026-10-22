package com.alibaba.ariver.resource.prepare.controller;

import com.alibaba.ariver.resource.api.prepare.PrepareStep;
import com.alibaba.ariver.resource.api.prepare.StepCreator;
import com.alibaba.ariver.resource.api.prepare.StepType;
import com.alibaba.ariver.resource.prepare.steps.DownloadStep;
import com.alibaba.ariver.resource.prepare.steps.SetupStep;
import com.alibaba.ariver.resource.prepare.steps.StartStep;
import com.alibaba.ariver.resource.prepare.steps.UpdateStep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class DefaultStepCreator implements StepCreator {

    /* JADX INFO: renamed from: com.alibaba.ariver.resource.prepare.controller.DefaultStepCreator$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$resource$api$prepare$StepType;

        static {
            int[] iArr = new int[StepType.values().length];
            $SwitchMap$com$alibaba$ariver$resource$api$prepare$StepType = iArr;
            try {
                iArr[StepType.SETUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$resource$api$prepare$StepType[StepType.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$resource$api$prepare$StepType[StepType.OFFLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$resource$api$prepare$StepType[StepType.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.alibaba.ariver.resource.api.prepare.StepCreator
    public PrepareStep createStep(StepType stepType) {
        int i = AnonymousClass1.$SwitchMap$com$alibaba$ariver$resource$api$prepare$StepType[stepType.ordinal()];
        if (i == 1) {
            return new SetupStep();
        }
        if (i == 2) {
            return new UpdateStep();
        }
        if (i == 3) {
            return new DownloadStep();
        }
        if (i != 4) {
            return null;
        }
        return new StartStep();
    }
}
