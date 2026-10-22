package com.huachenjie.run.page.run_detail;

import com.huachenjie.run.bean.RunDetailEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class RunDetailActivity$initDataObserve$1 extends FunctionReferenceImpl implements Function1<RunDetailEntity, Unit> {
    public RunDetailActivity$initDataObserve$1(Object obj) {
        super(1, obj, RunDetailActivity.class, "queryRunDetailSuccess", "queryRunDetailSuccess(Lcom/huachenjie/run/bean/RunDetailEntity;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RunDetailEntity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable RunDetailEntity runDetailEntity) {
        ((RunDetailActivity) ((CallableReference) this).receiver).V0(runDetailEntity);
    }
}
