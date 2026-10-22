package com.facebook.imagepipeline.request;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseRepeatedPostProcessor extends BasePostprocessor implements RepeatedPostprocessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RepeatedPostprocessorRunner f30035a;

    @Override // com.facebook.imagepipeline.request.RepeatedPostprocessor
    public synchronized void c(RepeatedPostprocessorRunner repeatedPostprocessorRunner) {
        this.f30035a = repeatedPostprocessorRunner;
    }

    public final synchronized RepeatedPostprocessorRunner f() {
        return this.f30035a;
    }

    public void update() {
        RepeatedPostprocessorRunner repeatedPostprocessorRunnerF = f();
        if (repeatedPostprocessorRunnerF != null) {
            repeatedPostprocessorRunnerF.update();
        }
    }
}
