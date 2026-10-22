package com.kc.bw.permission;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class DeniedResult {
    public final boolean allNeverAsked;
    public final List<String> deniedPerms;
    public final List<String> neverAskedPerms = new ArrayList();
    public final List<String> showRationalePerms;

    public DeniedResult(List<String> list, List<String> list2) {
        this.deniedPerms = list;
        this.showRationalePerms = list2;
        this.allNeverAsked = list2.isEmpty();
        for (String str : list) {
            if (!list2.contains(str)) {
                this.neverAskedPerms.add(str);
            }
        }
    }

    public List<String> getDeniedPerms() {
        return this.deniedPerms;
    }

    public List<String> getNeverAskedPerms() {
        return this.neverAskedPerms;
    }

    public List<String> getShowRationalePerms() {
        return this.showRationalePerms;
    }

    public boolean isAllNeverAsked() {
        return this.allNeverAsked;
    }

    public String toString() {
        return "DeniedResult{deniedPerms=" + this.deniedPerms + ", showRationalePerms=" + this.showRationalePerms + ", neverAskedPerms=" + this.neverAskedPerms + ", allNeverAsked=" + this.allNeverAsked + '}';
    }
}
