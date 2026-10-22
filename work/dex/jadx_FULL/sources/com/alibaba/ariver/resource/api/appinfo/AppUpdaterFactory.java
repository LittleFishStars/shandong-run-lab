package com.alibaba.ariver.resource.api.appinfo;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppUpdaterFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<Rule> f24420a = new ArrayList();

    public interface Rule {
        IAppUpdater findUpdater(String str, @Nullable Bundle bundle);
    }

    public static void clearRules() {
        List<Rule> list = f24420a;
        synchronized (list) {
            list.clear();
        }
    }

    public static IAppUpdater createUpdater(String str, @Nullable Bundle bundle) {
        List<Rule> list = f24420a;
        synchronized (list) {
            for (int size = list.size() - 1; size >= 0; size--) {
                IAppUpdater iAppUpdaterFindUpdater = f24420a.get(size).findUpdater(str, bundle);
                if (iAppUpdaterFindUpdater != null) {
                    return iAppUpdaterFindUpdater;
                }
            }
            return null;
        }
    }

    public static void registerRule(Rule rule) {
        List<Rule> list = f24420a;
        synchronized (list) {
            list.add(rule);
        }
    }

    public static void unRegisterRule(Rule rule) {
        List<Rule> list = f24420a;
        synchronized (list) {
            list.remove(rule);
        }
    }
}
