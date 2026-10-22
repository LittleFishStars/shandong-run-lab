package com.alibaba.ariver.resource.prepare.controller;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.CallSuper;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.log.AppLog;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.api.prepare.PrepareStep;
import com.alibaba.ariver.resource.api.prepare.StepCreator;
import com.alibaba.ariver.resource.api.prepare.StepInterceptor;
import com.alibaba.ariver.resource.api.prepare.StepType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public abstract class BasePrepareController implements PrepareController, Timer.TimeoutListener {
    private static final String TAG = "AriverRes:PrepareController";
    private AtomicBoolean appInfoSetted;
    protected PrepareCallback callback;
    protected PrepareContext context;
    protected PrepareStep currentExecutingStep;
    protected boolean errorIntercepted;
    private Set<PrepareStep> interceptedBeforeSteps;
    protected List<StepInterceptor> interceptors;
    private boolean locked;
    private Object lockedKey;
    private PrepareStep pendingAfterStep;
    private PrepareController.Status status;
    protected Queue<PrepareStep> steps;
    Timer timer;

    public BasePrepareController() {
        this.interceptedBeforeSteps = new HashSet();
        this.status = PrepareController.Status.INIT;
        this.locked = false;
        this.appInfoSetted = new AtomicBoolean(false);
        this.lockedKey = null;
        this.interceptors = Collections.EMPTY_LIST;
        this.context = null;
        this.callback = null;
        this.errorIntercepted = false;
        this.timer = null;
        this.steps = new ArrayBlockingQueue(4);
        StepCreator stepCreatorGenerateStepCreator = generateStepCreator();
        this.steps.add(stepCreatorGenerateStepCreator.createStep(StepType.SETUP));
        this.steps.add(stepCreatorGenerateStepCreator.createStep(StepType.UPDATE));
        this.steps.add(stepCreatorGenerateStepCreator.createStep(StepType.OFFLINE));
        this.steps.add(stepCreatorGenerateStepCreator.createStep(StepType.START));
    }

    private boolean interceptAfter(PrepareStep prepareStep) {
        try {
            RVTraceUtils.traceBeginSection(RVTraceKey.RV_Prepare_After_ + prepareStep.getType());
            RVLogger.d(TAG, "step " + prepareStep.getType() + " interceptAfter");
            for (StepInterceptor stepInterceptor : this.interceptors) {
                if (stepInterceptor.after(prepareStep, this)) {
                    RVLogger.d(TAG, "step " + prepareStep.getType() + " intercepted after by " + stepInterceptor.getClass().getName());
                    prepareStep.finish();
                    RVTraceUtils.traceEndSection(RVTraceKey.RV_Prepare_After_ + prepareStep.getType());
                    return true;
                }
            }
            prepareStep.finish();
            RVTraceUtils.traceEndSection(RVTraceKey.RV_Prepare_After_ + prepareStep.getType());
            return false;
        } catch (Throwable th) {
            if (prepareStep != null) {
                prepareStep.finish();
                RVTraceUtils.traceEndSection(RVTraceKey.RV_Prepare_After_ + prepareStep.getType());
            }
            throw th;
        }
    }

    private boolean interceptBefore(PrepareStep prepareStep) {
        StringBuilder sb;
        StepType type;
        String string;
        try {
            RVLogger.d(TAG, "step " + prepareStep.getType() + " interceptBefore");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(RVTraceKey.RV_Prepare_Before_);
            sb2.append(prepareStep.getType());
            RVTraceUtils.traceBeginSection(sb2.toString());
            this.interceptedBeforeSteps.add(prepareStep);
            for (StepInterceptor stepInterceptor : this.interceptors) {
                if (stepInterceptor.before(prepareStep, this)) {
                    RVLogger.d(TAG, "step " + prepareStep.getType() + " intercepted before by " + stepInterceptor.getClass().getName());
                    return true;
                }
            }
            return false;
        } finally {
            RVTraceUtils.traceEndSection(RVTraceKey.RV_Prepare_Before_ + prepareStep.getType());
        }
    }

    private boolean interceptOnError(PrepareException prepareException) {
        Iterator<StepInterceptor> it = this.interceptors.iterator();
        while (it.hasNext()) {
            if (it.next().onError(prepareException, this)) {
                return true;
            }
        }
        return false;
    }

    private void onPrepareFail(PrepareContext prepareContext, PrepareException prepareException) {
        String str;
        if (prepareContext == null) {
            return;
        }
        prepareContext.getPrepareData().setEndTime(SystemClock.elapsedRealtime());
        if (prepareException == null) {
            str = "";
        } else {
            str = prepareException.getCode() + LoginConstants.UNDER_LINE + prepareException.getMessage();
        }
        AppLogger.log(new AppLog.Builder().setState(AppLog.APP_LOG_PREPARE_FAIL).setAppId(prepareContext.getAppId()).setParentId(BundleUtils.getString(prepareContext.getStartParams(), RVParams.START_APP_SESSION_ID)).setDesc(str).build());
    }

    public void bindContext(PrepareContext prepareContext, PrepareCallback prepareCallback) {
        this.context = prepareContext;
        this.callback = prepareCallback;
    }

    public Timer createTimer(Timer.TimeoutListener timeoutListener) {
        return new Timer(timeoutListener);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareController
    @CallSuper
    public void finish() {
        RVLogger.d(TAG, "finish");
        this.status = PrepareController.Status.FINISH;
        Timer timer = this.timer;
        if (timer != null) {
            timer.invalidTimeout();
        }
        this.steps.clear();
    }

    public StepCreator generateStepCreator() {
        return new DefaultStepCreator();
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareController
    public PrepareController.Status getStatus() {
        return this.status;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareController
    public void lock(Object obj) {
        RVLogger.d(TAG, "locked with key: " + obj);
        this.lockedKey = obj;
        this.locked = true;
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareController
    @CallSuper
    public void moveToError(PrepareException prepareException) {
        if (this.currentExecutingStep != null && prepareException != null && prepareException.getStage() == null) {
            prepareException.setStage(this.currentExecutingStep.getType().name());
        }
        if (!this.status.canContinue()) {
            this.errorIntercepted = true;
            onPrepareFail(this.context, prepareException);
            return;
        }
        RVLogger.e(TAG, "moveToError!", prepareException);
        unlock(this.lockedKey);
        this.errorIntercepted = false;
        if (interceptOnError(prepareException)) {
            this.errorIntercepted = true;
            onPrepareFail(this.context, prepareException);
            return;
        }
        this.locked = false;
        this.status = PrepareController.Status.ERROR;
        this.steps.clear();
        Timer timer = this.timer;
        if (timer != null) {
            timer.invalidTimeout();
        }
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareController
    public void moveToNext() {
        if (this.locked) {
            RVLogger.e(TAG, "controller locked by " + this.currentExecutingStep + " cannot moveToNext!");
            return;
        }
        if (!this.status.canContinue()) {
            RVLogger.e(TAG, "controller cannot moveToNext with status: " + this.status);
            return;
        }
        this.status = PrepareController.Status.EXECUTING;
        PrepareStep prepareStep = this.pendingAfterStep;
        if (prepareStep != null) {
            boolean zInterceptAfter = interceptAfter(prepareStep);
            this.pendingAfterStep = null;
            if (zInterceptAfter) {
                return;
            }
        }
        PrepareStep prepareStepPeek = this.steps.peek();
        if (prepareStepPeek == null) {
            finish();
            return;
        }
        this.currentExecutingStep = prepareStepPeek;
        if (this.interceptedBeforeSteps.contains(prepareStepPeek) || !interceptBefore(prepareStepPeek)) {
            try {
                this.steps.poll();
                RVLogger.d(TAG, "step " + prepareStepPeek.getType() + " execute");
                this.pendingAfterStep = prepareStepPeek;
                prepareStepPeek.execute(this, this.context, this.callback);
                if (this.locked || prepareStepPeek.isFinished()) {
                    return;
                }
                if (this.status.canContinue()) {
                    this.pendingAfterStep = null;
                    if (interceptAfter(prepareStepPeek)) {
                        return;
                    }
                    moveToNext();
                    return;
                }
                RVLogger.w(TAG, "step " + prepareStepPeek.getType() + " can't continue after execute. status: " + this.status);
            } catch (PrepareException e) {
                RVLogger.e(TAG, prepareStepPeek.getType() + " execute error!", e);
                moveToError(e);
            }
        }
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareController
    public void onGetAppInfo(@NonNull AppModel appModel) {
        RVLogger.d(TAG, "onGetAppInfo");
        Iterator<StepInterceptor> it = this.interceptors.iterator();
        while (it.hasNext()) {
            it.next().onGetAppInfo(appModel);
        }
        if (this.appInfoSetted.getAndSet(true)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("appInfo", appModel);
        IpcServerUtils.sendMsgToClient(this.context.getAppId(), this.context.getStartToken(), 15, bundle);
    }

    @Override // com.alibaba.ariver.resource.prepare.controller.Timer.TimeoutListener
    public void onTimeout(long j) {
        RVLogger.e(TAG, "onTimeout! elapsed time: " + j);
        if (this.status != PrepareController.Status.FINISH) {
            if (this.currentExecutingStep == null) {
                moveToError(new PrepareException("3", "Procedure timeout"));
                return;
            }
            PrepareException prepareException = new PrepareException("3", "Procedure timeout on " + this.currentExecutingStep.getType());
            prepareException.setStage(this.currentExecutingStep.getType().name());
            moveToError(prepareException);
        }
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareController
    public synchronized void postTimeOut(long j) {
        if (this.timer == null) {
            this.timer = createTimer(this);
        }
        RVLogger.d(TAG, "postTimeout " + j);
        this.timer.postTimeout(j);
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareController
    public void setInterceptors(@NonNull List<StepInterceptor> list) {
        if (this.status != PrepareController.Status.INIT) {
            throw new IllegalStateException("You cannot set interceptor after execute");
        }
        ArrayList arrayList = new ArrayList(list);
        this.interceptors = arrayList;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((StepInterceptor) it.next()).init(this.context, this.callback);
        }
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareController
    public void start() {
        moveToNext();
    }

    @Override // com.alibaba.ariver.resource.api.prepare.PrepareController
    public void unlock(Object obj) {
        if (this.locked) {
            RVLogger.d(TAG, "unlocked with key: " + obj + ", lockedKey: " + this.lockedKey);
            if (obj != this.lockedKey) {
                return;
            }
            this.locked = false;
            this.lockedKey = null;
        }
    }

    @VisibleForTesting
    public BasePrepareController(PrepareStep... prepareStepArr) {
        this.interceptedBeforeSteps = new HashSet();
        this.status = PrepareController.Status.INIT;
        this.locked = false;
        this.appInfoSetted = new AtomicBoolean(false);
        this.lockedKey = null;
        this.interceptors = Collections.EMPTY_LIST;
        this.context = null;
        this.callback = null;
        this.errorIntercepted = false;
        this.timer = null;
        this.steps = new LinkedList(Arrays.asList(prepareStepArr));
    }
}
