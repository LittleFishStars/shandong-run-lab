package com.huachenjie.works.external.bean;

import com.alibaba.ariver.kernel.common.service.executor.RVScheduleType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/works/external/bean/WorkItemType;", "", "()V", "ACTIVITY", "", "BROADCAST_FLOOR", "FIRST_ITEM", "LOCAL_DRAFT", "NATIVE_AD", RVScheduleType.NORMAL, "RECOMMEND", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WorkItemType {
    public static final int ACTIVITY = 3;
    public static final int BROADCAST_FLOOR = 6;
    public static final int FIRST_ITEM = 2;

    @NotNull
    public static final WorkItemType INSTANCE = new WorkItemType();
    public static final int LOCAL_DRAFT = 1;
    public static final int NATIVE_AD = 4;
    public static final int NORMAL = 0;
    public static final int RECOMMEND = 5;

    private WorkItemType() {
    }
}
