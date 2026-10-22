package com.byazt.rl;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 117, 13})
public class tt {
    public boolean c = false;
    public int tt = -1;
    public String ve = null;
    public ValueSet uj = null;

    @com.byazt.zqa.c(c = {0, 1, 117, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static final class c implements Result {
        public final boolean c;
        public final int tt;
        public final ValueSet uj;
        public final String ve;

        @Override // com.bykv.vk.openvk.api.proto.Result
        public int code() {
            return this.tt;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public boolean isSuccess() {
            return this.c;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public String message() {
            return this.ve;
        }

        @Override // com.bykv.vk.openvk.api.proto.Result
        public ValueSet values() {
            return this.uj;
        }

        private c(boolean z, int i, String str, ValueSet valueSet) {
            this.c = z;
            this.tt = i;
            this.ve = str;
            this.uj = valueSet;
        }
    }

    private tt() {
    }

    public static final tt c() {
        return new tt();
    }

    public Result tt() {
        boolean z = this.c;
        int i = this.tt;
        String str = this.ve;
        ValueSet valueSetTt = this.uj;
        if (valueSetTt == null) {
            valueSetTt = ve.c().tt();
        }
        return new c(z, i, str, valueSetTt);
    }

    public tt c(boolean z) {
        this.c = z;
        return this;
    }

    public tt c(int i) {
        this.tt = i;
        return this;
    }

    public tt c(String str) {
        this.ve = str;
        return this;
    }

    public tt c(ValueSet valueSet) {
        this.uj = valueSet;
        return this;
    }
}
