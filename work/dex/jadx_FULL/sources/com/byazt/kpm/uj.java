package com.byazt.kpm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_OPTIMIZE_RETRY, 15})
public final class uj {

    public interface c<T> {
        T c();

        boolean c(T t);
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_OPTIMIZE_RETRY, 153})
    public static class tt<T> implements c<T> {
        public final Object[] c;
        public int tt;

        public tt(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.c = new Object[i];
        }

        private boolean tt(T t) {
            for (int i = 0; i < this.tt; i++) {
                if (this.c[i] == t) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.byazt.kpm.uj.c
        public T c() {
            int i = this.tt;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            Object[] objArr = this.c;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.tt = i - 1;
            return t;
        }

        @Override // com.byazt.kpm.uj.c
        public boolean c(T t) {
            if (!tt(t)) {
                int i = this.tt;
                Object[] objArr = this.c;
                if (i >= objArr.length) {
                    return false;
                }
                objArr[i] = t;
                this.tt = i + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }
}
