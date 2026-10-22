package com.alibaba.triver.open.prefetch.context;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ImagePrefetchContext extends PrefetchContext implements Serializable {
    public ImageParams params;

    public static class ImageParams implements Serializable {
        public List<String> imgUrls;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("imgUrls=");
            List<String> list = this.imgUrls;
            sb.append(list == null ? "[]" : list.toString());
            return sb.toString();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", params=");
        ImageParams imageParams = this.params;
        sb.append(imageParams == null ? "{}" : imageParams.toString());
        return sb.toString();
    }
}
