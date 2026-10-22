package cj.mobile.wm;

import android.text.TextUtils;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class t4 implements o4 {
    public final Map<String, List<s4>> dexc;
    public volatile Map<String, String> dexd;

    public static final class dexa {
        public static final String dexe;
        public static final Map<String, List<s4>> dexf;
        public boolean dexa = true;
        public Map<String, List<s4>> dexb = dexf;
        public boolean dexc = true;
        public boolean dexd = true;

        static {
            String property = System.getProperty("http.agent");
            dexe = property;
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(property)) {
                map.put("User-Agent", Collections.singletonList(new dexb(property)));
            }
            map.put("Accept-Encoding", Collections.singletonList(new dexb(HlsPlaylistParser.V)));
            dexf = Collections.unmodifiableMap(map);
        }

        public t4 dexa() {
            this.dexa = true;
            return new t4(this.dexb);
        }
    }

    public static final class dexb implements s4 {
        public final String dexa;

        public dexb(String str) {
            this.dexa = str;
        }

        @Override // cj.mobile.wm.s4
        public String a() {
            return this.dexa;
        }

        public boolean equals(Object obj) {
            if (obj instanceof dexb) {
                return this.dexa.equals(((dexb) obj).dexa);
            }
            return false;
        }

        public int hashCode() {
            return this.dexa.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.dexa + "'}";
        }
    }

    public t4(Map<String, List<s4>> map) {
        this.dexc = Collections.unmodifiableMap(map);
    }

    private Map<String, String> dexa() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<s4>> entry : this.dexc.entrySet()) {
            StringBuilder sb = new StringBuilder();
            List<s4> value = entry.getValue();
            for (int i = 0; i < value.size(); i++) {
                sb.append(value.get(i).a());
                if (i != value.size() - 1) {
                    sb.append(',');
                }
            }
            map.put(entry.getKey(), sb.toString());
        }
        return map;
    }

    @Override // cj.mobile.wm.o4
    public Map<String, String> a() {
        if (this.dexd == null) {
            synchronized (this) {
                if (this.dexd == null) {
                    this.dexd = Collections.unmodifiableMap(dexa());
                }
            }
        }
        return this.dexd;
    }

    public boolean equals(Object obj) {
        if (obj instanceof t4) {
            return this.dexc.equals(((t4) obj).dexc);
        }
        return false;
    }

    public int hashCode() {
        return this.dexc.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.dexc + '}';
    }
}
