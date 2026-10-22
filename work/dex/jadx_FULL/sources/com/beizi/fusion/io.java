package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.model.impl.db.StrategyEventDBModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.filter.StrategyFilterModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.filter.frequency.StrategyFrequencyModel;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class io {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27419a;
    private final String b;

    public io(Context context, String str) {
        this.f27419a = context;
        this.b = str;
    }

    public boolean a(StrategyFilterModel strategyFilterModel) {
        List<StrategyFrequencyModel> frequencyModels;
        if (strategyFilterModel == null || (frequencyModels = strategyFilterModel.getFrequencyModels()) == null || frequencyModels.isEmpty()) {
            return false;
        }
        for (StrategyFrequencyModel strategyFrequencyModel : frequencyModels) {
            LinkedList linkedListB = ((q0) r0.a().b(this.f27419a)).b(this.b, strategyFrequencyModel.getEventCode());
            long relativeTime = strategyFrequencyModel.getRelativeTime();
            long[] absoluteTime = strategyFrequencyModel.getAbsoluteTime();
            int count = strategyFrequencyModel.getCount();
            if (linkedListB != null && linkedListB.size() >= count) {
                if (a(relativeTime, linkedListB, count)) {
                    return true;
                }
                return a(absoluteTime, linkedListB);
            }
        }
        return false;
    }

    private boolean a(long[] jArr, LinkedList linkedList) {
        return jArr != null && jArr.length > 1 && a(jArr) && ((StrategyEventDBModel) linkedList.getLast()).getEventTime() > jArr[0];
    }

    private boolean a(long j, LinkedList linkedList, int i) {
        return j > 0 && ((StrategyEventDBModel) linkedList.get(linkedList.size() - i)).getEventTime() + j > System.currentTimeMillis();
    }

    private boolean a(long[] jArr) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return jArr[0] <= jCurrentTimeMillis && jCurrentTimeMillis <= jArr[1];
    }
}
