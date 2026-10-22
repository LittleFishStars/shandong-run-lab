package com.byazt.fqu;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTCustomController;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1010, 15})
public class uj {
    public static final SparseArray<Object> c(final TTCustomController tTCustomController) {
        com.byazt.rl.ve veVarC = com.byazt.rl.ve.c();
        veVarC.c(262101, new Supplier<Boolean>() { // from class: com.byazt.fqu.uj.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseLocation());
            }
        });
        veVarC.c(262102, new Supplier<SparseArray<Object>>() { // from class: com.byazt.fqu.uj.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SparseArray<Object> get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return ve.c(tTCustomController2 == null ? null : tTCustomController2.getTTLocation());
            }
        });
        veVarC.c(262103, new Supplier<Boolean>() { // from class: com.byazt.fqu.uj.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.alist());
            }
        });
        veVarC.c(262104, new Supplier<Boolean>() { // from class: com.byazt.fqu.uj.10
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUsePhoneState());
            }
        });
        veVarC.c(262105, new Supplier<String>() { // from class: com.byazt.fqu.uj.11
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = tTCustomController;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getDevImei();
            }
        });
        veVarC.c(262106, new Supplier<Boolean>() { // from class: com.byazt.fqu.uj.12
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseWifiState());
            }
        });
        veVarC.c(262107, new Supplier<String>() { // from class: com.byazt.fqu.uj.13
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = tTCustomController;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getMacAddress();
            }
        });
        veVarC.c(262108, new Supplier<Boolean>() { // from class: com.byazt.fqu.uj.14
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseWriteExternal());
            }
        });
        veVarC.c(262109, new Supplier<String>() { // from class: com.byazt.fqu.uj.15
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = tTCustomController;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getDevOaid();
            }
        });
        veVarC.c(262110, new Supplier<Boolean>() { // from class: com.byazt.fqu.uj.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseAndroidId());
            }
        });
        veVarC.c(262113, (tTCustomController == null || tTCustomController.getMediationPrivacyConfig() == null) ? null : com.byazt.jt.tt.c(tTCustomController.getMediationPrivacyConfig()));
        veVarC.c(262112, new Supplier<String>() { // from class: com.byazt.fqu.uj.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public String get() {
                TTCustomController tTCustomController2 = tTCustomController;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.getAndroidId();
            }
        });
        veVarC.c(262111, new Supplier<Boolean>() { // from class: com.byazt.fqu.uj.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUsePermissionRecordAudio());
            }
        });
        veVarC.c(262119, new Supplier<Map>() { // from class: com.byazt.fqu.uj.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Map get() {
                TTCustomController tTCustomController2 = tTCustomController;
                if (tTCustomController2 == null) {
                    return null;
                }
                return tTCustomController2.userPrivacyConfig();
            }
        });
        veVarC.c(262120, new Supplier<Boolean>() { // from class: com.byazt.fqu.uj.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                TTCustomController tTCustomController2 = tTCustomController;
                return Boolean.valueOf(tTCustomController2 == null || tTCustomController2.isCanUseMessage());
            }
        });
        veVarC.c(262121, new Supplier<Boolean>() { // from class: com.byazt.fqu.uj.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(tTCustomController == null);
            }
        });
        return veVarC.tt().sparseArray();
    }
}
