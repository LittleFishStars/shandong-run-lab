package com.huachenjie.common.run_interface;

import com.huachenjie.common.run_component.PauseTimerType;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J6\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0018\u0010\t\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/run_interface/IRunTimeStateChangeListener;", "Lcom/huachenjie/common/run_interface/RunStateChangeListener;", "Lcom/huachenjie/common/run_component/PauseTimerType;", "pauseTimerType", "Lcom/huachenjie/common/run_interface/RunStateChangeListener$State;", "state", "", "", "", "map", "", "a", "common_release"}, k = 1, mv = {1, 8, 0})
public interface IRunTimeStateChangeListener extends RunStateChangeListener {
    void a(@Nullable PauseTimerType pauseTimerType, @Nullable RunStateChangeListener.State state, @Nullable Map<String, ? extends Object> map);
}
