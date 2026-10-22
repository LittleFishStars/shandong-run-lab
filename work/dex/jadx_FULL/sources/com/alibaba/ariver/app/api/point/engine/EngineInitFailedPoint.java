package com.alibaba.ariver.app.api.point.engine;

import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
public interface EngineInitFailedPoint extends Extension {
    public static final Comparator<Action> ACTION_COMPARATOR = new Comparator<Action>() { // from class: com.alibaba.ariver.app.api.point.engine.EngineInitFailedPoint.1
        @Override // java.util.Comparator
        public int compare(Action action, Action action2) {
            if (action == null) {
                return -1;
            }
            if (action2 != null && action.ordinal() <= action2.ordinal()) {
                return action.ordinal() < action2.ordinal() ? -1 : 0;
            }
            return 1;
        }
    };
    public static final ResultResolver<Action> RESULT_RESOLVER = new ResultResolver<Action>() { // from class: com.alibaba.ariver.app.api.point.engine.EngineInitFailedPoint.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alibaba.ariver.kernel.api.extension.resolver.ResultResolver
        public Action resolve(List<Action> list) {
            if (list == null || list.size() == 0) {
                return null;
            }
            Collections.sort(list, EngineInitFailedPoint.ACTION_COMPARATOR);
            return list.get(list.size() - 1);
        }
    };

    public enum Action {
        IGNORE,
        REENTER,
        SHOW_ERROR,
        SHOW_ALERT,
        EXIT
    }

    @ThreadType(ExecutorType.URGENT)
    Action onEngineInitFailed();
}
