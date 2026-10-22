package com.byazt.dj;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 15})
public class uj {
    public final PluginValueSet pluginValueSet;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 123})
    public static class c {
        public final com.byazt.rl.c c = com.byazt.rl.c.c();

        public c a(boolean z) {
            this.c.c(262110, z);
            return this;
        }

        public c c(boolean z) {
            this.c.c(262101, z);
            return this;
        }

        public c n(boolean z) {
            this.c.c(262108, z);
            return this;
        }

        public c sp(boolean z) {
            this.c.c(262111, z);
            return this;
        }

        public c tt(boolean z) {
            this.c.c(262103, z);
            return this;
        }

        public c uj(boolean z) {
            this.c.c(262106, z);
            return this;
        }

        public c ve(boolean z) {
            this.c.c(262104, z);
            return this;
        }

        public c c(ve veVar) {
            this.c.c(262102, veVar);
            return this;
        }

        public c tt(String str) {
            this.c.c(262107, str);
            return this;
        }

        public c uj(String str) {
            this.c.c(262112, str);
            return this;
        }

        public c ve(String str) {
            this.c.c(262109, str);
            return this;
        }

        public c c(String str) {
            this.c.c(262105, str);
            return this;
        }

        public uj c() {
            return new uj(this.c.tt().sparseArray());
        }
    }

    public uj(SparseArray<Object> sparseArray) {
        this.pluginValueSet = com.byazt.rl.c.c(sparseArray).tt();
    }

    public boolean alist() {
        return this.pluginValueSet.booleanValue(262103);
    }

    public String getAndroidId() {
        return (String) this.pluginValueSet.objectValue(262112, String.class);
    }

    public String getDevImei() {
        return (String) this.pluginValueSet.objectValue(262105, String.class);
    }

    public String getDevOaid() {
        return (String) this.pluginValueSet.objectValue(262109, String.class);
    }

    public String getMacAddress() {
        return (String) this.pluginValueSet.objectValue(262107, String.class);
    }

    public com.byazt.je.tt getMediationPrivacyConfig() {
        SparseArray sparseArray = (SparseArray) this.pluginValueSet.objectValue(262113, SparseArray.class);
        if (sparseArray != null) {
            return new com.byazt.je.tt(sparseArray);
        }
        return null;
    }

    public ve getTTLocation() {
        SparseArray sparseArray = (SparseArray) this.pluginValueSet.objectValue(262102, SparseArray.class);
        if (sparseArray != null) {
            return new ve(sparseArray);
        }
        return null;
    }

    public boolean isCanUseAndroidId() {
        return this.pluginValueSet.booleanValue(262110);
    }

    public boolean isCanUseLocation() {
        return this.pluginValueSet.booleanValue(262101);
    }

    public boolean isCanUseMessage() {
        return this.pluginValueSet.booleanValue(262120);
    }

    public boolean isCanUsePermissionRecordAudio() {
        return this.pluginValueSet.booleanValue(262111);
    }

    public boolean isCanUsePhoneState() {
        return this.pluginValueSet.booleanValue(262104);
    }

    public boolean isCanUseWifiState() {
        return this.pluginValueSet.booleanValue(262106);
    }

    public boolean isCanUseWriteExternal() {
        return this.pluginValueSet.booleanValue(262108);
    }

    public boolean isDefaultController() {
        return this.pluginValueSet.booleanValue(262121);
    }

    public Map<String, Object> userPrivacyConfig() {
        return (Map) this.pluginValueSet.objectValue(262119, Map.class);
    }
}
