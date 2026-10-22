package com.googlecode.mp4parser.util;

import java.util.logging.Level;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class JuliLogger extends Logger {
    java.util.logging.Logger logger;

    public JuliLogger(String str) {
        this.logger = java.util.logging.Logger.getLogger(str);
    }

    @Override // com.googlecode.mp4parser.util.Logger
    public void logDebug(String str) {
        this.logger.log(Level.FINE, str);
    }

    @Override // com.googlecode.mp4parser.util.Logger
    public void logError(String str) {
        this.logger.log(Level.SEVERE, str);
    }

    @Override // com.googlecode.mp4parser.util.Logger
    public void logWarn(String str) {
        this.logger.log(Level.WARNING, str);
    }
}
