package com.huachenjie.common.bean;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public enum ClockMode {
    Free(1, "自由打卡", "生成4个点位，需打卡2个必选点+任意1个可选点卡"),
    Random(2, "随机打卡", "随机生成1个点位，完成后生成新的点位，需打卡3个"),
    Order(3, "顺序打卡", "生成3个点位，需按序号依次打卡"),
    NO_POINT(10, "无点位", "该区域无打卡点位，可进行自由锻炼");

    static Map<Integer, ClockMode> map = new HashMap();
    public String content;
    public int id;
    public String title;

    static {
        for (ClockMode clockMode : values()) {
            map.put(Integer.valueOf(clockMode.id), clockMode);
        }
    }

    ClockMode(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static ClockMode id2Object(int id) {
        return map.get(Integer.valueOf(id));
    }
}
