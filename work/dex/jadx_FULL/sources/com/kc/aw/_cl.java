package com.kc.aw;

import android.text.TextUtils;
import com.alibaba.ariver.permission.b;
import com.kc.aw.lib.utils.Logger;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _cl {
    public String _P;
    public String _Q;
    public boolean _R;
    public boolean _S;
    public String _c;
    public int _d;
    public _cf _m;
    public int _n;
    public long _o;
    public boolean _p;
    public String _q;
    public _ci _r;
    public String _s;
    public String _t;
    public String _u;
    public String _v;
    public String _w;
    public String _x;
    public String _y;
    public String _z;
    public String _a = "";
    public long _b = 0;
    public int _e = 1;
    public int _f = 0;
    public double _g = 1.0d;
    public long _h = 0;
    public long _i = 0;
    public int _T = 1;
    public HashSet _j = new HashSet();
    public HashSet _k = new HashSet();
    public HashSet _l = new HashSet();
    public HashSet _N = new HashSet();
    public HashSet _O = new HashSet();
    public HashSet _L = new HashSet();
    public HashSet _M = new HashSet();
    public Set<String> _A = new HashSet();
    public Set<String> _B = new HashSet();
    public Set<String> _C = new HashSet();
    public Set<String> _D = new HashSet();
    public Set<String> _E = new HashSet();
    public Set<String> _F = new HashSet();
    public Set<String> _G = new HashSet();
    public Set<String> _H = new HashSet();
    public Set<String> _I = new HashSet();
    public Set<String> _J = new HashSet();
    public Set<String> _K = new HashSet();

    public final Set<String> _a() {
        if (this._F.isEmpty()) {
            String str = this._y;
            if (!TextUtils.isEmpty(str)) {
                this._F.add(str);
            }
        }
        return this._F;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0255  */
    /* JADX WARN: Code duplicated, block: B:102:0x0256 A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x0261  */
    /* JADX WARN: Code duplicated, block: B:106:0x0262 A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x026d  */
    /* JADX WARN: Code duplicated, block: B:110:0x026e A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x0279  */
    /* JADX WARN: Code duplicated, block: B:114:0x027a A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x0285  */
    /* JADX WARN: Code duplicated, block: B:118:0x0286 A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0291  */
    /* JADX WARN: Code duplicated, block: B:122:0x0292 A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x029d  */
    /* JADX WARN: Code duplicated, block: B:126:0x029e A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:130:0x02aa A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:134:0x02b6 A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:151:0x0126 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:152:0x0126 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:155:0x0162 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:156:0x0162 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:15:0x0087  */
    /* JADX WARN: Code duplicated, block: B:16:0x0089 A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x008f  */
    /* JADX WARN: Code duplicated, block: B:20:0x0095 A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x00a4 A[Catch: JSONException -> 0x0319, TRY_LEAVE, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x00da A[Catch: Exception -> 0x00f2, TryCatch #2 {Exception -> 0x00f2, blocks: (B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:145:0x00b0, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ef A[Catch: Exception -> 0x00f2, TRY_LEAVE, TryCatch #2 {Exception -> 0x00f2, blocks: (B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:145:0x00b0, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0105  */
    /* JADX WARN: Code duplicated, block: B:43:0x010c A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0112 A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0121 A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0141  */
    /* JADX WARN: Code duplicated, block: B:54:0x0148 A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x014e A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x015d A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0176  */
    /* JADX WARN: Code duplicated, block: B:65:0x017d A[Catch: JSONException -> 0x0319, LOOP:2: B:63:0x0177->B:65:0x017d, LOOP_END, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0195  */
    /* JADX WARN: Code duplicated, block: B:71:0x019c A[Catch: JSONException -> 0x0319, LOOP:3: B:69:0x0196->B:71:0x019c, LOOP_END, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:77:0x01bb A[Catch: JSONException -> 0x0319, LOOP:4: B:75:0x01b5->B:77:0x01bb, LOOP_END, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x01cf A[Catch: JSONException -> 0x0319, TRY_LEAVE, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x01ec A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:87:0x01ed A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x01f8 A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x023d  */
    /* JADX WARN: Code duplicated, block: B:94:0x023e A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0249  */
    /* JADX WARN: Code duplicated, block: B:98:0x024a A[Catch: JSONException -> 0x0319, TryCatch #1 {JSONException -> 0x0319, blocks: (B:3:0x0007, B:5:0x0042, B:11:0x0078, B:13:0x007f, B:19:0x0090, B:21:0x0097, B:23:0x00a4, B:37:0x00f3, B:38:0x00f5, B:41:0x0106, B:43:0x010c, B:45:0x0112, B:47:0x0121, B:48:0x0126, B:49:0x0129, B:52:0x0142, B:54:0x0148, B:56:0x014e, B:58:0x015d, B:59:0x0162, B:60:0x0165, B:63:0x0177, B:65:0x017d, B:66:0x018d, B:69:0x0196, B:71:0x019c, B:72:0x01ac, B:75:0x01b5, B:77:0x01bb, B:78:0x01c7, B:80:0x01cf, B:87:0x01ed, B:84:0x01e6, B:88:0x01ef, B:90:0x01f8, B:91:0x0239, B:95:0x0243, B:99:0x024f, B:103:0x025b, B:107:0x0267, B:111:0x0273, B:115:0x027f, B:119:0x028b, B:123:0x0297, B:127:0x02a3, B:131:0x02af, B:135:0x02bb, B:134:0x02b6, B:130:0x02aa, B:126:0x029e, B:122:0x0292, B:118:0x0286, B:114:0x027a, B:110:0x026e, B:106:0x0262, B:102:0x0256, B:98:0x024a, B:94:0x023e, B:16:0x0089, B:20:0x0095, B:8:0x0071, B:12:0x007d, B:81:0x01d4, B:25:0x00b0, B:27:0x00da, B:29:0x00e2, B:34:0x00ef), top: B:143:0x0007, inners: #0, #2 }] */
    public final boolean _a(JSONObject jSONObject, _cm _cmVar, _cn _cnVar) {
        int iOptInt;
        JSONObject jSONObject2;
        long jOptLong;
        JSONObject jSONObject3;
        JSONArray jSONArrayOptJSONArray;
        HashMap map;
        JSONArray jSONArrayOptJSONArray2;
        HashMap map2;
        JSONArray jSONArrayOptJSONArray3;
        JSONArray jSONArrayOptJSONArray4;
        JSONArray jSONArrayOptJSONArray5;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        Set<String> hashSet;
        Set<String> hashSet2;
        Set<String> hashSet3;
        Set<String> hashSet4;
        Set<String> hashSet5;
        Set<String> hashSet6;
        Set<String> hashSet7;
        Set<String> hashSet8;
        Set<String> hashSet9;
        Set<String> hashSet10;
        Set<String> hashSet11;
        _cf _cfVar;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        JSONObject jSONObject4;
        _av _avVar_a;
        int i5;
        JSONObject jSONObject5;
        _av _avVar_a2;
        String strOptString;
        _ci _ciVar;
        boolean z2;
        try {
            this._b = jSONObject.optLong("adKey");
            this._e = jSONObject.optInt("weight");
            this._g = jSONObject.optDouble("discRatio", 1.0d);
            this._T = jSONObject.optInt("layer");
            this._p = jSONObject.optBoolean("ignore");
            this._d = jSONObject.optInt("consumerSlotType");
            try {
                this._f = jSONObject.getInt(b.b);
            } catch (Exception unused) {
            }
            this._R = jSONObject.optBoolean("hotSpot");
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("consumer");
            this._c = jSONObjectOptJSONObject3.optString("consumerType");
            this._P = jSONObjectOptJSONObject3.optString("vendorId");
            this._Q = jSONObjectOptJSONObject3.optString("consumerSlotId");
            if (!jSONObjectOptJSONObject3.has("bidCreativeQuantity")) {
                if (jSONObject.has("bidCreativeQuantity")) {
                    jSONObject2 = jSONObject;
                } else {
                    iOptInt = _cmVar._h;
                }
                this._n = iOptInt;
                if (jSONObjectOptJSONObject3.has("creativeAliveDuration")) {
                    if (jSONObject.has("creativeAliveDuration")) {
                        jSONObject3 = jSONObject;
                    } else {
                        jOptLong = _cmVar._g;
                    }
                    this._o = jOptLong;
                    this._S = _cmVar._x;
                    if (jSONObjectOptJSONObject3.has("extended_fields")) {
                        strOptString = jSONObjectOptJSONObject3.optString("extended_fields");
                        this._q = strOptString;
                        if (!TextUtils.isEmpty(strOptString)) {
                            try {
                                JSONObject jSONObject6 = new JSONObject(strOptString);
                                _ciVar = new _ci();
                                _ciVar._a = jSONObject6.optString("mockPackageName");
                                _ciVar._b = jSONObject6.optString("mockCsjAppId");
                                _ciVar._c = jSONObject6.optString("mockGdtAppId");
                                if (!TextUtils.isEmpty(_ciVar._a) || TextUtils.isEmpty(_ciVar._b) || TextUtils.isEmpty(_ciVar._c)) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                if (z2) {
                                    this._r = _ciVar;
                                }
                            } catch (Exception unused2) {
                                this._r = null;
                            }
                        }
                    }
                    jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray(b.c);
                    map = new HashMap(_cmVar._i);
                    if (jSONArrayOptJSONArray != null) {
                        for (i5 = 0; i5 < jSONArrayOptJSONArray.length(); i5++) {
                            jSONObject5 = jSONArrayOptJSONArray.getJSONObject(i5);
                            if (jSONObject5 != null) {
                                _avVar_a2 = new _av()._a(jSONObject5);
                                if (_avVar_a2._a()) {
                                    map.put(_avVar_a2._b, _avVar_a2);
                                }
                            }
                        }
                    }
                    this._L.addAll(map.values());
                    jSONArrayOptJSONArray2 = jSONObjectOptJSONObject3.optJSONArray("blockPacket");
                    map2 = new HashMap(_cmVar._j);
                    if (jSONArrayOptJSONArray2 != null) {
                        for (i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                            jSONObject4 = jSONArrayOptJSONArray2.getJSONObject(i4);
                            if (jSONObject4 != null) {
                                _avVar_a = new _av()._a(jSONObject4);
                                if (_avVar_a._a()) {
                                    map2.put(_avVar_a._b, _avVar_a);
                                }
                            }
                        }
                    }
                    this._M.addAll(map2.values());
                    jSONArrayOptJSONArray3 = jSONObject.optJSONArray("geoCode");
                    if (jSONArrayOptJSONArray3 != null) {
                        for (i3 = 0; i3 != jSONArrayOptJSONArray3.length(); i3++) {
                            this._j.add(Long.valueOf(jSONArrayOptJSONArray3.getLong(i3)));
                        }
                    }
                    jSONArrayOptJSONArray4 = jSONObject.optJSONArray("hour");
                    if (jSONArrayOptJSONArray4 != null) {
                        for (i2 = 0; i2 != jSONArrayOptJSONArray4.length(); i2++) {
                            this._k.add(Long.valueOf(jSONArrayOptJSONArray4.getLong(i2)));
                        }
                    }
                    jSONArrayOptJSONArray5 = jSONObject.optJSONArray("osVersion");
                    if (jSONArrayOptJSONArray5 != null) {
                        for (i = 0; i != jSONArrayOptJSONArray5.length(); i++) {
                            this._l.add(jSONArrayOptJSONArray5.getString(i));
                        }
                    }
                    jSONObjectOptJSONObject = jSONObject.optJSONObject("freqControl");
                    if (jSONObjectOptJSONObject != null) {
                        _cfVar = new _cf();
                        try {
                            jSONObjectOptJSONObject.getInt("freqCount");
                            jSONObjectOptJSONObject.getInt("periodUnit");
                            jSONObjectOptJSONObject.getInt("periodCount");
                            z = true;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            z = false;
                        }
                        if (!z) {
                            return false;
                        }
                        this._m = _cfVar;
                    }
                    jSONObjectOptJSONObject2 = jSONObject.optJSONObject("trackingData");
                    if (jSONObjectOptJSONObject2 != null) {
                        this._s = jSONObjectOptJSONObject2.optString("tracking");
                        this._u = jSONObjectOptJSONObject2.optString("impTracking");
                        this._v = jSONObjectOptJSONObject2.optString("clickTracking");
                        this._t = jSONObjectOptJSONObject2.optString("bidTracking");
                        this._w = jSONObjectOptJSONObject2.optString("errorTracking");
                        this._x = jSONObjectOptJSONObject2.optString("bidSucTracking");
                        this._y = jSONObjectOptJSONObject2.optString("bidSelectedTracking");
                        this._z = jSONObjectOptJSONObject2.optString("dpTracking");
                    }
                    hashSet = _cnVar._D;
                    if (hashSet != null) {
                        hashSet = new HashSet<>();
                    }
                    this._F = hashSet;
                    hashSet2 = _cnVar._C;
                    if (hashSet2 != null) {
                        hashSet2 = new HashSet<>();
                    }
                    this._E = hashSet2;
                    hashSet3 = _cnVar._y;
                    if (hashSet3 != null) {
                        hashSet3 = new HashSet<>();
                    }
                    this._A = hashSet3;
                    hashSet4 = _cnVar._A;
                    if (hashSet4 != null) {
                        hashSet4 = new HashSet<>();
                    }
                    this._C = hashSet4;
                    hashSet5 = _cnVar._E;
                    if (hashSet5 != null) {
                        hashSet5 = new HashSet<>();
                    }
                    this._G = hashSet5;
                    hashSet6 = _cnVar._B;
                    if (hashSet6 != null) {
                        hashSet6 = new HashSet<>();
                    }
                    this._D = hashSet6;
                    hashSet7 = _cnVar._z;
                    if (hashSet7 != null) {
                        hashSet7 = new HashSet<>();
                    }
                    this._B = hashSet7;
                    hashSet8 = _cnVar._F;
                    if (hashSet8 != null) {
                        hashSet8 = new HashSet<>();
                    }
                    this._H = hashSet8;
                    hashSet9 = _cnVar._G;
                    if (hashSet9 != null) {
                        hashSet9 = new HashSet<>();
                    }
                    this._I = hashSet9;
                    hashSet10 = _cnVar._H;
                    if (hashSet10 != null) {
                        hashSet10 = new HashSet<>();
                    }
                    this._J = hashSet10;
                    hashSet11 = _cnVar._I;
                    if (hashSet11 != null) {
                        hashSet11 = new HashSet<>();
                    }
                    this._K = hashSet11;
                    _a().addAll(_cmVar._p);
                    _b().addAll(_cmVar._o);
                    _c().addAll(_cmVar._k);
                    _d().addAll(_cmVar._m);
                    _e().addAll(_cmVar._q);
                    _f().addAll(_cmVar._n);
                    _g().addAll(_cmVar._l);
                    this._H.addAll(_cmVar._r);
                    this._I.addAll(_cmVar._s);
                    this._J.addAll(_cmVar._t);
                    this._K.addAll(_cmVar._u);
                    return true;
                }
                jSONObject3 = jSONObjectOptJSONObject3;
                jOptLong = jSONObject3.optLong("creativeAliveDuration");
                this._o = jOptLong;
                this._S = _cmVar._x;
                if (jSONObjectOptJSONObject3.has("extended_fields")) {
                    strOptString = jSONObjectOptJSONObject3.optString("extended_fields");
                    this._q = strOptString;
                    if (!TextUtils.isEmpty(strOptString)) {
                        JSONObject jSONObject7 = new JSONObject(strOptString);
                        _ciVar = new _ci();
                        _ciVar._a = jSONObject7.optString("mockPackageName");
                        _ciVar._b = jSONObject7.optString("mockCsjAppId");
                        _ciVar._c = jSONObject7.optString("mockGdtAppId");
                        if (TextUtils.isEmpty(_ciVar._a)) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            this._r = _ciVar;
                        }
                    }
                }
                jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray(b.c);
                map = new HashMap(_cmVar._i);
                if (jSONArrayOptJSONArray != null) {
                    while (i5 < jSONArrayOptJSONArray.length()) {
                        jSONObject5 = jSONArrayOptJSONArray.getJSONObject(i5);
                        if (jSONObject5 != null) {
                            _avVar_a2 = new _av()._a(jSONObject5);
                            if (_avVar_a2._a()) {
                                map.put(_avVar_a2._b, _avVar_a2);
                            }
                        }
                    }
                }
                this._L.addAll(map.values());
                jSONArrayOptJSONArray2 = jSONObjectOptJSONObject3.optJSONArray("blockPacket");
                map2 = new HashMap(_cmVar._j);
                if (jSONArrayOptJSONArray2 != null) {
                    while (i4 < jSONArrayOptJSONArray2.length()) {
                        jSONObject4 = jSONArrayOptJSONArray2.getJSONObject(i4);
                        if (jSONObject4 != null) {
                            _avVar_a = new _av()._a(jSONObject4);
                            if (_avVar_a._a()) {
                                map2.put(_avVar_a._b, _avVar_a);
                            }
                        }
                    }
                }
                this._M.addAll(map2.values());
                jSONArrayOptJSONArray3 = jSONObject.optJSONArray("geoCode");
                if (jSONArrayOptJSONArray3 != null) {
                    while (i3 != jSONArrayOptJSONArray3.length()) {
                        this._j.add(Long.valueOf(jSONArrayOptJSONArray3.getLong(i3)));
                    }
                }
                jSONArrayOptJSONArray4 = jSONObject.optJSONArray("hour");
                if (jSONArrayOptJSONArray4 != null) {
                    while (i2 != jSONArrayOptJSONArray4.length()) {
                        this._k.add(Long.valueOf(jSONArrayOptJSONArray4.getLong(i2)));
                    }
                }
                jSONArrayOptJSONArray5 = jSONObject.optJSONArray("osVersion");
                if (jSONArrayOptJSONArray5 != null) {
                    while (i != jSONArrayOptJSONArray5.length()) {
                        this._l.add(jSONArrayOptJSONArray5.getString(i));
                    }
                }
                jSONObjectOptJSONObject = jSONObject.optJSONObject("freqControl");
                if (jSONObjectOptJSONObject != null) {
                    _cfVar = new _cf();
                    jSONObjectOptJSONObject.getInt("freqCount");
                    jSONObjectOptJSONObject.getInt("periodUnit");
                    jSONObjectOptJSONObject.getInt("periodCount");
                    z = true;
                    if (!z) {
                        return false;
                    }
                    this._m = _cfVar;
                }
                jSONObjectOptJSONObject2 = jSONObject.optJSONObject("trackingData");
                if (jSONObjectOptJSONObject2 != null) {
                    this._s = jSONObjectOptJSONObject2.optString("tracking");
                    this._u = jSONObjectOptJSONObject2.optString("impTracking");
                    this._v = jSONObjectOptJSONObject2.optString("clickTracking");
                    this._t = jSONObjectOptJSONObject2.optString("bidTracking");
                    this._w = jSONObjectOptJSONObject2.optString("errorTracking");
                    this._x = jSONObjectOptJSONObject2.optString("bidSucTracking");
                    this._y = jSONObjectOptJSONObject2.optString("bidSelectedTracking");
                    this._z = jSONObjectOptJSONObject2.optString("dpTracking");
                }
                hashSet = _cnVar._D;
                if (hashSet != null) {
                    hashSet = new HashSet<>();
                }
                this._F = hashSet;
                hashSet2 = _cnVar._C;
                if (hashSet2 != null) {
                    hashSet2 = new HashSet<>();
                }
                this._E = hashSet2;
                hashSet3 = _cnVar._y;
                if (hashSet3 != null) {
                    hashSet3 = new HashSet<>();
                }
                this._A = hashSet3;
                hashSet4 = _cnVar._A;
                if (hashSet4 != null) {
                    hashSet4 = new HashSet<>();
                }
                this._C = hashSet4;
                hashSet5 = _cnVar._E;
                if (hashSet5 != null) {
                    hashSet5 = new HashSet<>();
                }
                this._G = hashSet5;
                hashSet6 = _cnVar._B;
                if (hashSet6 != null) {
                    hashSet6 = new HashSet<>();
                }
                this._D = hashSet6;
                hashSet7 = _cnVar._z;
                if (hashSet7 != null) {
                    hashSet7 = new HashSet<>();
                }
                this._B = hashSet7;
                hashSet8 = _cnVar._F;
                if (hashSet8 != null) {
                    hashSet8 = new HashSet<>();
                }
                this._H = hashSet8;
                hashSet9 = _cnVar._G;
                if (hashSet9 != null) {
                    hashSet9 = new HashSet<>();
                }
                this._I = hashSet9;
                hashSet10 = _cnVar._H;
                if (hashSet10 != null) {
                    hashSet10 = new HashSet<>();
                }
                this._J = hashSet10;
                hashSet11 = _cnVar._I;
                if (hashSet11 != null) {
                    hashSet11 = new HashSet<>();
                }
                this._K = hashSet11;
                _a().addAll(_cmVar._p);
                _b().addAll(_cmVar._o);
                _c().addAll(_cmVar._k);
                _d().addAll(_cmVar._m);
                _e().addAll(_cmVar._q);
                _f().addAll(_cmVar._n);
                _g().addAll(_cmVar._l);
                this._H.addAll(_cmVar._r);
                this._I.addAll(_cmVar._s);
                this._J.addAll(_cmVar._t);
                this._K.addAll(_cmVar._u);
                return true;
            }
            jSONObject2 = jSONObjectOptJSONObject3;
            iOptInt = jSONObject2.optInt("bidCreativeQuantity");
            this._n = iOptInt;
            if (jSONObjectOptJSONObject3.has("creativeAliveDuration")) {
                if (jSONObject.has("creativeAliveDuration")) {
                    jSONObject3 = jSONObject;
                } else {
                    jOptLong = _cmVar._g;
                }
                this._o = jOptLong;
                this._S = _cmVar._x;
                if (jSONObjectOptJSONObject3.has("extended_fields")) {
                    strOptString = jSONObjectOptJSONObject3.optString("extended_fields");
                    this._q = strOptString;
                    if (!TextUtils.isEmpty(strOptString)) {
                        JSONObject jSONObject8 = new JSONObject(strOptString);
                        _ciVar = new _ci();
                        _ciVar._a = jSONObject8.optString("mockPackageName");
                        _ciVar._b = jSONObject8.optString("mockCsjAppId");
                        _ciVar._c = jSONObject8.optString("mockGdtAppId");
                        if (TextUtils.isEmpty(_ciVar._a)) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            this._r = _ciVar;
                        }
                    }
                }
                jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray(b.c);
                map = new HashMap(_cmVar._i);
                if (jSONArrayOptJSONArray != null) {
                    while (i5 < jSONArrayOptJSONArray.length()) {
                        jSONObject5 = jSONArrayOptJSONArray.getJSONObject(i5);
                        if (jSONObject5 != null) {
                            _avVar_a2 = new _av()._a(jSONObject5);
                            if (_avVar_a2._a()) {
                                map.put(_avVar_a2._b, _avVar_a2);
                            }
                        }
                    }
                }
                this._L.addAll(map.values());
                jSONArrayOptJSONArray2 = jSONObjectOptJSONObject3.optJSONArray("blockPacket");
                map2 = new HashMap(_cmVar._j);
                if (jSONArrayOptJSONArray2 != null) {
                    while (i4 < jSONArrayOptJSONArray2.length()) {
                        jSONObject4 = jSONArrayOptJSONArray2.getJSONObject(i4);
                        if (jSONObject4 != null) {
                            _avVar_a = new _av()._a(jSONObject4);
                            if (_avVar_a._a()) {
                                map2.put(_avVar_a._b, _avVar_a);
                            }
                        }
                    }
                }
                this._M.addAll(map2.values());
                jSONArrayOptJSONArray3 = jSONObject.optJSONArray("geoCode");
                if (jSONArrayOptJSONArray3 != null) {
                    while (i3 != jSONArrayOptJSONArray3.length()) {
                        this._j.add(Long.valueOf(jSONArrayOptJSONArray3.getLong(i3)));
                    }
                }
                jSONArrayOptJSONArray4 = jSONObject.optJSONArray("hour");
                if (jSONArrayOptJSONArray4 != null) {
                    while (i2 != jSONArrayOptJSONArray4.length()) {
                        this._k.add(Long.valueOf(jSONArrayOptJSONArray4.getLong(i2)));
                    }
                }
                jSONArrayOptJSONArray5 = jSONObject.optJSONArray("osVersion");
                if (jSONArrayOptJSONArray5 != null) {
                    while (i != jSONArrayOptJSONArray5.length()) {
                        this._l.add(jSONArrayOptJSONArray5.getString(i));
                    }
                }
                jSONObjectOptJSONObject = jSONObject.optJSONObject("freqControl");
                if (jSONObjectOptJSONObject != null) {
                    _cfVar = new _cf();
                    jSONObjectOptJSONObject.getInt("freqCount");
                    jSONObjectOptJSONObject.getInt("periodUnit");
                    jSONObjectOptJSONObject.getInt("periodCount");
                    z = true;
                    if (!z) {
                        return false;
                    }
                    this._m = _cfVar;
                }
                jSONObjectOptJSONObject2 = jSONObject.optJSONObject("trackingData");
                if (jSONObjectOptJSONObject2 != null) {
                    this._s = jSONObjectOptJSONObject2.optString("tracking");
                    this._u = jSONObjectOptJSONObject2.optString("impTracking");
                    this._v = jSONObjectOptJSONObject2.optString("clickTracking");
                    this._t = jSONObjectOptJSONObject2.optString("bidTracking");
                    this._w = jSONObjectOptJSONObject2.optString("errorTracking");
                    this._x = jSONObjectOptJSONObject2.optString("bidSucTracking");
                    this._y = jSONObjectOptJSONObject2.optString("bidSelectedTracking");
                    this._z = jSONObjectOptJSONObject2.optString("dpTracking");
                }
                hashSet = _cnVar._D;
                if (hashSet != null) {
                    hashSet = new HashSet<>();
                }
                this._F = hashSet;
                hashSet2 = _cnVar._C;
                if (hashSet2 != null) {
                    hashSet2 = new HashSet<>();
                }
                this._E = hashSet2;
                hashSet3 = _cnVar._y;
                if (hashSet3 != null) {
                    hashSet3 = new HashSet<>();
                }
                this._A = hashSet3;
                hashSet4 = _cnVar._A;
                if (hashSet4 != null) {
                    hashSet4 = new HashSet<>();
                }
                this._C = hashSet4;
                hashSet5 = _cnVar._E;
                if (hashSet5 != null) {
                    hashSet5 = new HashSet<>();
                }
                this._G = hashSet5;
                hashSet6 = _cnVar._B;
                if (hashSet6 != null) {
                    hashSet6 = new HashSet<>();
                }
                this._D = hashSet6;
                hashSet7 = _cnVar._z;
                if (hashSet7 != null) {
                    hashSet7 = new HashSet<>();
                }
                this._B = hashSet7;
                hashSet8 = _cnVar._F;
                if (hashSet8 != null) {
                    hashSet8 = new HashSet<>();
                }
                this._H = hashSet8;
                hashSet9 = _cnVar._G;
                if (hashSet9 != null) {
                    hashSet9 = new HashSet<>();
                }
                this._I = hashSet9;
                hashSet10 = _cnVar._H;
                if (hashSet10 != null) {
                    hashSet10 = new HashSet<>();
                }
                this._J = hashSet10;
                hashSet11 = _cnVar._I;
                if (hashSet11 != null) {
                    hashSet11 = new HashSet<>();
                }
                this._K = hashSet11;
                _a().addAll(_cmVar._p);
                _b().addAll(_cmVar._o);
                _c().addAll(_cmVar._k);
                _d().addAll(_cmVar._m);
                _e().addAll(_cmVar._q);
                _f().addAll(_cmVar._n);
                _g().addAll(_cmVar._l);
                this._H.addAll(_cmVar._r);
                this._I.addAll(_cmVar._s);
                this._J.addAll(_cmVar._t);
                this._K.addAll(_cmVar._u);
                return true;
            }
            jSONObject3 = jSONObjectOptJSONObject3;
            jOptLong = jSONObject3.optLong("creativeAliveDuration");
            this._o = jOptLong;
            this._S = _cmVar._x;
            if (jSONObjectOptJSONObject3.has("extended_fields")) {
                strOptString = jSONObjectOptJSONObject3.optString("extended_fields");
                this._q = strOptString;
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject9 = new JSONObject(strOptString);
                    _ciVar = new _ci();
                    _ciVar._a = jSONObject9.optString("mockPackageName");
                    _ciVar._b = jSONObject9.optString("mockCsjAppId");
                    _ciVar._c = jSONObject9.optString("mockGdtAppId");
                    if (TextUtils.isEmpty(_ciVar._a)) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        this._r = _ciVar;
                    }
                }
            }
            jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray(b.c);
            map = new HashMap(_cmVar._i);
            if (jSONArrayOptJSONArray != null) {
                while (i5 < jSONArrayOptJSONArray.length()) {
                    jSONObject5 = jSONArrayOptJSONArray.getJSONObject(i5);
                    if (jSONObject5 != null) {
                        _avVar_a2 = new _av()._a(jSONObject5);
                        if (_avVar_a2._a()) {
                            map.put(_avVar_a2._b, _avVar_a2);
                        }
                    }
                }
            }
            this._L.addAll(map.values());
            jSONArrayOptJSONArray2 = jSONObjectOptJSONObject3.optJSONArray("blockPacket");
            map2 = new HashMap(_cmVar._j);
            if (jSONArrayOptJSONArray2 != null) {
                while (i4 < jSONArrayOptJSONArray2.length()) {
                    jSONObject4 = jSONArrayOptJSONArray2.getJSONObject(i4);
                    if (jSONObject4 != null) {
                        _avVar_a = new _av()._a(jSONObject4);
                        if (_avVar_a._a()) {
                            map2.put(_avVar_a._b, _avVar_a);
                        }
                    }
                }
            }
            this._M.addAll(map2.values());
            jSONArrayOptJSONArray3 = jSONObject.optJSONArray("geoCode");
            if (jSONArrayOptJSONArray3 != null) {
                while (i3 != jSONArrayOptJSONArray3.length()) {
                    this._j.add(Long.valueOf(jSONArrayOptJSONArray3.getLong(i3)));
                }
            }
            jSONArrayOptJSONArray4 = jSONObject.optJSONArray("hour");
            if (jSONArrayOptJSONArray4 != null) {
                while (i2 != jSONArrayOptJSONArray4.length()) {
                    this._k.add(Long.valueOf(jSONArrayOptJSONArray4.getLong(i2)));
                }
            }
            jSONArrayOptJSONArray5 = jSONObject.optJSONArray("osVersion");
            if (jSONArrayOptJSONArray5 != null) {
                while (i != jSONArrayOptJSONArray5.length()) {
                    this._l.add(jSONArrayOptJSONArray5.getString(i));
                }
            }
            jSONObjectOptJSONObject = jSONObject.optJSONObject("freqControl");
            if (jSONObjectOptJSONObject != null) {
                _cfVar = new _cf();
                jSONObjectOptJSONObject.getInt("freqCount");
                jSONObjectOptJSONObject.getInt("periodUnit");
                jSONObjectOptJSONObject.getInt("periodCount");
                z = true;
                if (!z) {
                    return false;
                }
                this._m = _cfVar;
            }
            jSONObjectOptJSONObject2 = jSONObject.optJSONObject("trackingData");
            if (jSONObjectOptJSONObject2 != null) {
                this._s = jSONObjectOptJSONObject2.optString("tracking");
                this._u = jSONObjectOptJSONObject2.optString("impTracking");
                this._v = jSONObjectOptJSONObject2.optString("clickTracking");
                this._t = jSONObjectOptJSONObject2.optString("bidTracking");
                this._w = jSONObjectOptJSONObject2.optString("errorTracking");
                this._x = jSONObjectOptJSONObject2.optString("bidSucTracking");
                this._y = jSONObjectOptJSONObject2.optString("bidSelectedTracking");
                this._z = jSONObjectOptJSONObject2.optString("dpTracking");
            }
            hashSet = _cnVar._D;
            if (hashSet != null) {
                hashSet = new HashSet<>();
            }
            this._F = hashSet;
            hashSet2 = _cnVar._C;
            if (hashSet2 != null) {
                hashSet2 = new HashSet<>();
            }
            this._E = hashSet2;
            hashSet3 = _cnVar._y;
            if (hashSet3 != null) {
                hashSet3 = new HashSet<>();
            }
            this._A = hashSet3;
            hashSet4 = _cnVar._A;
            if (hashSet4 != null) {
                hashSet4 = new HashSet<>();
            }
            this._C = hashSet4;
            hashSet5 = _cnVar._E;
            if (hashSet5 != null) {
                hashSet5 = new HashSet<>();
            }
            this._G = hashSet5;
            hashSet6 = _cnVar._B;
            if (hashSet6 != null) {
                hashSet6 = new HashSet<>();
            }
            this._D = hashSet6;
            hashSet7 = _cnVar._z;
            if (hashSet7 != null) {
                hashSet7 = new HashSet<>();
            }
            this._B = hashSet7;
            hashSet8 = _cnVar._F;
            if (hashSet8 != null) {
                hashSet8 = new HashSet<>();
            }
            this._H = hashSet8;
            hashSet9 = _cnVar._G;
            if (hashSet9 != null) {
                hashSet9 = new HashSet<>();
            }
            this._I = hashSet9;
            hashSet10 = _cnVar._H;
            if (hashSet10 != null) {
                hashSet10 = new HashSet<>();
            }
            this._J = hashSet10;
            hashSet11 = _cnVar._I;
            if (hashSet11 != null) {
                hashSet11 = new HashSet<>();
            }
            this._K = hashSet11;
            _a().addAll(_cmVar._p);
            _b().addAll(_cmVar._o);
            _c().addAll(_cmVar._k);
            _d().addAll(_cmVar._m);
            _e().addAll(_cmVar._q);
            _f().addAll(_cmVar._n);
            _g().addAll(_cmVar._l);
            this._H.addAll(_cmVar._r);
            this._I.addAll(_cmVar._s);
            this._J.addAll(_cmVar._t);
            this._K.addAll(_cmVar._u);
            return true;
        } catch (JSONException e2) {
            Logger.d(e2.getMessage());
            return false;
        }
    }

    public final Set<String> _b() {
        if (this._E.isEmpty()) {
            String str = this._x;
            if (!TextUtils.isEmpty(str)) {
                this._E.add(str);
            }
        }
        return this._E;
    }

    public final Set<String> _c() {
        if (this._A.isEmpty()) {
            String str = TextUtils.isEmpty(this._t) ? this._s : this._t;
            if (!TextUtils.isEmpty(str)) {
                this._A.add(str);
            }
        }
        return this._A;
    }

    public final Set<String> _d() {
        if (this._C.isEmpty()) {
            String str = TextUtils.isEmpty(this._v) ? this._s : this._v;
            if (!TextUtils.isEmpty(str)) {
                this._C.add(str);
            }
        }
        return this._C;
    }

    public final Set<String> _e() {
        if (this._G.isEmpty()) {
            String str = this._z;
            if (!TextUtils.isEmpty(str)) {
                this._G.add(str);
            }
        }
        return this._G;
    }

    public final Set<String> _f() {
        if (this._D.isEmpty()) {
            String str = TextUtils.isEmpty(this._w) ? this._s : this._w;
            if (!TextUtils.isEmpty(str)) {
                this._D.add(str);
            }
        }
        return this._D;
    }

    public final Set<String> _g() {
        if (this._B.isEmpty()) {
            String str = TextUtils.isEmpty(this._v) ? this._s : this._u;
            if (!TextUtils.isEmpty(str)) {
                this._B.add(str);
            }
        }
        return this._B;
    }

    public final int _h() {
        return this._e;
    }

    public final String toString() {
        StringBuilder sb_a = _jf._a("DispatchPolicyCustomerItem{hashcode='");
        sb_a.append(hashCode());
        sb_a.append('\'');
        sb_a.append("slotId='");
        StringBuilder sb_a2 = _mm._a(sb_a, this._a, '\'', ", adKey=");
        sb_a2.append(this._b);
        sb_a2.append(", consumerType='");
        StringBuilder sb_a3 = _mm._a(sb_a2, this._c, '\'', ", consumerSlotType=");
        sb_a3.append(this._d);
        sb_a3.append(", weight=");
        sb_a3.append(this._e);
        sb_a3.append(", level=");
        sb_a3.append(this._f);
        sb_a3.append(", discRatio=");
        sb_a3.append(this._g);
        sb_a3.append(", consumerPrice=");
        sb_a3.append(this._h);
        sb_a3.append(", consumerOrgPrice=");
        sb_a3.append(this._i);
        sb_a3.append(", targetingGeo=");
        sb_a3.append(this._j);
        sb_a3.append(", targetingHour=");
        sb_a3.append(this._k);
        sb_a3.append(", targetingOsVersion=");
        sb_a3.append(this._l);
        sb_a3.append(", frequencyPolicy=");
        sb_a3.append(this._m);
        sb_a3.append(", bidCreativeQuantity=");
        sb_a3.append(this._n);
        sb_a3.append(", creativeAliveDuration=");
        sb_a3.append(this._o);
        sb_a3.append(", ignore=");
        sb_a3.append(this._p);
        sb_a3.append(", extendedFields='");
        StringBuilder sb_a4 = _mm._a(sb_a3, this._q, '\'', ", dispatchMock=");
        sb_a4.append(this._r);
        sb_a4.append(", tracking='");
        StringBuilder sb_a5 = _mm._a(_mm._a(_mm._a(_mm._a(_mm._a(_mm._a(_mm._a(_mm._a(sb_a4, this._s, '\'', ", bidTracking='"), this._t, '\'', ", impTracking='"), this._u, '\'', ", clickTracking='"), this._v, '\'', ", errorTracking='"), this._w, '\'', ", bidSucTracking='"), this._x, '\'', ", bidSelectedTracking='"), this._y, '\'', ", dpTracking='"), this._z, '\'', ", bidTrackingUrls=");
        sb_a5.append(this._A);
        sb_a5.append(", impTrackingUrls=");
        sb_a5.append(this._B);
        sb_a5.append(", clickTrackingUrls=");
        sb_a5.append(this._C);
        sb_a5.append(", errorTrackingUrls=");
        sb_a5.append(this._D);
        sb_a5.append(", bidSucTrackingUrls=");
        sb_a5.append(this._E);
        sb_a5.append(", bidSelectedTrackingUrls=");
        sb_a5.append(this._F);
        sb_a5.append(", dpTrackingUrls=");
        sb_a5.append(this._G);
        sb_a5.append(", vpTrackingUrls=");
        sb_a5.append(this._H);
        sb_a5.append(", filterTrackingUrls=");
        sb_a5.append(this._I);
        sb_a5.append(", noticeBidLossTracking=");
        sb_a5.append(this._J);
        sb_a5.append(", noticeBidWinTracking=");
        sb_a5.append(this._K);
        sb_a5.append(", whitelist=");
        sb_a5.append(this._L);
        sb_a5.append(", blockPackets=");
        sb_a5.append(this._M);
        sb_a5.append(", blackAppList=");
        sb_a5.append(this._N);
        sb_a5.append(", blackKeywordList=");
        sb_a5.append(this._O);
        sb_a5.append(", vendorId='");
        StringBuilder sb_a6 = _mm._a(_mm._a(sb_a5, this._P, '\'', ", consumerSlotId='"), this._Q, '\'', ", hotSpot=");
        sb_a6.append(this._R);
        sb_a6.append(", twicePrompt=");
        sb_a6.append(this._S);
        sb_a6.append(", layer=");
        sb_a6.append(this._T);
        sb_a6.append('}');
        return sb_a6.toString();
    }
}
