package com.kwad.components.core.innerEc.live.base;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class QLiveMessage implements Serializable {
    public static final int AUTO_HISTORY_MESSAGE = 1;
    public static final int MANUAL_HISTORY_MESSAGE = 2;
    public static final int NOT_YET_DETERMINED = 0;
    private static final long serialVersionUID = -5104152816886417231L;
    public String content;
    public boolean enableKwaiEmoji;
    public String id;
    public UserInfo user;
    public int wealthGrade;
}
