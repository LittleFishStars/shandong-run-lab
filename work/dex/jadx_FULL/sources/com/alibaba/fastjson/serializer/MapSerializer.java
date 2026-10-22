package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MapSerializer extends SerializeFilterable implements ObjectSerializer {
    public static MapSerializer instance = new MapSerializer();
    private static final int NON_STRINGKEY_AS_STRING = SerializerFeature.of(new SerializerFeature[]{SerializerFeature.BrowserCompatible, SerializerFeature.WriteNonStringKeyAsString, SerializerFeature.BrowserSecure});

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0155 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x0159 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x0161 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x0180 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x0189  */
    /* JADX WARN: Code duplicated, block: B:11:0x0022 A[PHI: r1
      0x0022: PHI (r1v66 java.util.Map<java.lang.String, java.lang.Object>) = 
      (r1v2 java.util.Map<java.lang.String, java.lang.Object>)
      (r1v2 java.util.Map<java.lang.String, java.lang.Object>)
      (r1v2 java.util.Map<java.lang.String, java.lang.Object>)
      (r1v1 java.util.Map<java.lang.String, java.lang.Object>)
     binds: [B:16:0x0030, B:18:0x0034, B:219:0x0022, B:9:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:121:0x018f A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0197 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x01b3 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x01bd A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x01c5 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x01e1 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x01ea A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:162:0x0222 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:165:0x023d A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:171:0x0255 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:173:0x025a A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:176:0x0265 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:178:0x026c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:179:0x026e A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:182:0x0279 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:184:0x0281 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:190:0x0297 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:191:0x02a1 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:193:0x02a9 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:194:0x02af  */
    /* JADX WARN: Code duplicated, block: B:197:0x02ba A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:204:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:206:0x02e1 A[Catch: all -> 0x0313, TRY_LEAVE, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0090  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ed A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x00f1 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x0121 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0125 A[Catch: all -> 0x0313, TryCatch #0 {all -> 0x0313, blocks: (B:28:0x0052, B:29:0x0055, B:31:0x0061, B:42:0x0080, B:44:0x0091, B:45:0x00a1, B:47:0x00a7, B:49:0x00b9, B:52:0x00c1, B:55:0x00c6, B:57:0x00d0, B:59:0x00d4, B:62:0x00df, B:65:0x00ed, B:67:0x00f1, B:70:0x00f9, B:73:0x00fe, B:75:0x0108, B:77:0x010c, B:80:0x0117, B:83:0x0121, B:85:0x0125, B:88:0x012d, B:91:0x0132, B:93:0x013c, B:95:0x0140, B:98:0x014b, B:101:0x0155, B:103:0x0159, B:106:0x0161, B:109:0x0166, B:111:0x0170, B:113:0x0174, B:116:0x0180, B:119:0x018b, B:121:0x018f, B:124:0x0197, B:127:0x019c, B:129:0x01a6, B:131:0x01aa, B:132:0x01b3, B:133:0x01b9, B:135:0x01bd, B:138:0x01c5, B:141:0x01ca, B:143:0x01d4, B:145:0x01d8, B:146:0x01e1, B:149:0x01ea, B:152:0x01ef, B:154:0x01f3, B:160:0x01fd, B:165:0x023d, B:169:0x024f, B:171:0x0255, B:173:0x025a, B:174:0x025d, B:176:0x0265, B:177:0x0268, B:190:0x0297, B:191:0x02a1, B:193:0x02a9, B:195:0x02b0, B:197:0x02ba, B:199:0x02be, B:201:0x02c2, B:203:0x02cd, B:205:0x02d3, B:206:0x02e1, B:179:0x026e, B:180:0x0271, B:182:0x0279, B:187:0x028d, B:188:0x0290, B:184:0x0281, B:186:0x0285, B:162:0x0222, B:37:0x0075), top: B:220:0x0052 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i, boolean z) throws IOException {
        Map<String, Object> treeMap;
        boolean z2;
        List<PropertyPreFilter> list;
        List<PropertyFilter> list2;
        List<PropertyFilter> list3;
        List<NameFilter> list4;
        List<NameFilter> list5;
        String str;
        String str2;
        Object objProcessValue;
        Object obj3;
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        ObjectSerializer objectSerializer;
        Type type2;
        Object obj4 = obj;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj4 == null) {
            serializeWriter.writeNull();
            return;
        }
        Map<String, Object> innerMap = (Map) obj4;
        int i2 = SerializerFeature.MapSortField.mask;
        if ((serializeWriter.features & i2) == 0 && (i2 & i) == 0) {
            treeMap = innerMap;
        } else {
            if (innerMap instanceof JSONObject) {
                innerMap = ((JSONObject) innerMap).getInnerMap();
            }
            if ((innerMap instanceof SortedMap) || (innerMap instanceof LinkedHashMap)) {
                treeMap = innerMap;
            } else {
                try {
                    treeMap = new TreeMap(innerMap);
                } catch (Exception unused) {
                    treeMap = innerMap;
                }
            }
        }
        if (jSONSerializer.containsReference(obj)) {
            jSONSerializer.writeReference(obj);
            return;
        }
        SerialContext serialContext = jSONSerializer.context;
        boolean z3 = false;
        jSONSerializer.setContext(serialContext, obj4, obj2, 0);
        if (!z) {
            try {
                serializeWriter.write(123);
            } catch (Throwable th) {
                jSONSerializer.context = serialContext;
                throw th;
            }
        }
        jSONSerializer.incrementIndent();
        boolean z4 = true;
        if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
            String str3 = jSONSerializer.config.typeKey;
            Class<?> cls4 = treeMap.getClass();
            if (((cls4 == JSONObject.class || cls4 == HashMap.class || cls4 == LinkedHashMap.class) && treeMap.containsKey(str3)) == true) {
                z2 = true;
            } else {
                serializeWriter.writeFieldName(str3);
                serializeWriter.writeString(obj.getClass().getName());
                z2 = false;
            }
        } else {
            z2 = true;
        }
        boolean z5 = z2;
        Class<?> cls5 = null;
        ObjectSerializer objectWriter = null;
        for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            List<PropertyPreFilter> list6 = jSONSerializer.propertyPreFilters;
            if (list6 == null || list6.size() <= 0) {
                list = this.propertyPreFilters;
                if (list != null || list.size() <= 0) {
                    list2 = jSONSerializer.propertyFilters;
                    if (list2 != null || list2.size() <= 0) {
                        list3 = this.propertyFilters;
                        if (list3 != null && list3.size() > 0) {
                            if (key != null || (key instanceof String)) {
                                if (!apply(jSONSerializer, obj4, key, value)) {
                                    cls5 = cls5;
                                    z4 = z4 ? 1 : 0;
                                    z4 = z4;
                                    cls5 = cls5;
                                    z3 = false;
                                }
                            } else if ((key.getClass().isPrimitive() || (key instanceof Number)) && !apply(jSONSerializer, obj4, JSON.toJSONString(key), value)) {
                                cls5 = cls5;
                                z4 = z4 ? 1 : 0;
                                z4 = z4;
                                cls5 = cls5;
                                z3 = false;
                            }
                        }
                        list4 = jSONSerializer.nameFilters;
                        if (list4 != null && list4.size() > 0) {
                            if (key != null || (key instanceof String)) {
                                key = processKey(jSONSerializer, obj4, key, value);
                            } else if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                key = processKey(jSONSerializer, obj4, JSON.toJSONString(key), value);
                            }
                        }
                        list5 = this.nameFilters;
                        if (list5 != null && list5.size() > 0) {
                            if (key != null || (key instanceof String)) {
                                key = processKey(jSONSerializer, obj4, key, value);
                            } else if (key.getClass().isPrimitive() || (key instanceof Number)) {
                                key = processKey(jSONSerializer, obj4, JSON.toJSONString(key), value);
                            }
                        }
                        str = key;
                        if (str != null || (str instanceof String)) {
                            str2 = str;
                            objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                        } else {
                            if (((str instanceof Map) || (str instanceof Collection)) ? z4 ? 1 : 0 : z3) {
                                str2 = str;
                                cls5 = cls5;
                                z4 = z4 ? 1 : 0;
                                obj3 = value;
                            } else {
                                str2 = str;
                                objProcessValue = processValue(jSONSerializer, null, obj, JSON.toJSONString(str), value, i);
                            }
                            if (obj3 == null || SerializerFeature.isEnabled(serializeWriter.features, i, SerializerFeature.WriteMapNullValue)) {
                                if (str2 instanceof String) {
                                    String str4 = str2;
                                    if (!z5) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer.println();
                                    }
                                    serializeWriter.writeFieldName(str4, z4);
                                } else {
                                    if (!z5) {
                                        serializeWriter.write(44);
                                    }
                                    if ((!serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING) || SerializerFeature.isEnabled(i, SerializerFeature.WriteNonStringKeyAsString)) && !(str2 instanceof Enum)) {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    } else {
                                        jSONSerializer.write((Object) str2);
                                    }
                                    serializeWriter.write(58);
                                }
                                if (obj3 == null) {
                                    serializeWriter.writeNull();
                                    z4 = z4 ? 1 : 0;
                                    cls5 = cls5;
                                    z3 = false;
                                    z5 = false;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        objectWriter = jSONSerializer.getObjectWriter(cls);
                                        cls3 = cls;
                                    } else {
                                        cls3 = cls2;
                                    }
                                    objectSerializer = objectWriter;
                                    if (SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName) || !(objectSerializer instanceof JavaBeanSerializer)) {
                                        objectWriter = objectSerializer;
                                        objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                    } else {
                                        if (type instanceof ParameterizedType) {
                                            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                                            if (actualTypeArguments.length == 2) {
                                                type2 = actualTypeArguments[z4 ? 1 : 0];
                                            } else {
                                                type2 = null;
                                            }
                                        } else {
                                            type2 = null;
                                        }
                                        objectWriter = objectSerializer;
                                        ((JavaBeanSerializer) objectSerializer).writeNoneASM(jSONSerializer, obj3, str2, type2, i);
                                    }
                                    cls5 = cls3;
                                    z3 = false;
                                    z5 = false;
                                    z4 = z4 ? 1 : 0;
                                }
                            } else {
                                z4 = z4;
                                cls5 = cls5;
                                z3 = false;
                            }
                        }
                        obj3 = objProcessValue;
                        if (obj3 == null) {
                        }
                        if (str2 instanceof String) {
                            String str5 = str2;
                            if (!z5) {
                                serializeWriter.write(44);
                            }
                            if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                jSONSerializer.println();
                            }
                            serializeWriter.writeFieldName(str5, z4);
                        } else {
                            if (!z5) {
                                serializeWriter.write(44);
                            }
                            if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                jSONSerializer.write(JSON.toJSONString(str2));
                            } else {
                                jSONSerializer.write(JSON.toJSONString(str2));
                            }
                            serializeWriter.write(58);
                        }
                        if (obj3 == null) {
                            serializeWriter.writeNull();
                            z4 = z4 ? 1 : 0;
                            cls5 = cls5;
                            z3 = false;
                            z5 = false;
                        } else {
                            cls = obj3.getClass();
                            cls2 = cls5;
                            if (cls != cls2) {
                                objectWriter = jSONSerializer.getObjectWriter(cls);
                                cls3 = cls;
                            } else {
                                cls3 = cls2;
                            }
                            objectSerializer = objectWriter;
                            if (SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName)) {
                                objectWriter = objectSerializer;
                                objectWriter.write(jSONSerializer, obj3, str2, null, i);
                            } else {
                                objectWriter = objectSerializer;
                                objectWriter.write(jSONSerializer, obj3, str2, null, i);
                            }
                            cls5 = cls3;
                            z3 = false;
                            z5 = false;
                            z4 = z4 ? 1 : 0;
                        }
                    } else {
                        if (key == null || (key instanceof String)) {
                            if (apply(jSONSerializer, obj4, key, value)) {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!apply(jSONSerializer, obj4, key, value)) {
                                        }
                                    } else if (!apply(jSONSerializer, obj4, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                    obj3 = objProcessValue;
                                } else {
                                    str2 = str;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                    obj3 = objProcessValue;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str6 = str2;
                                    if (!z5) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer.println();
                                    }
                                    serializeWriter.writeFieldName(str6, z4);
                                } else {
                                    if (!z5) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    } else {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (obj3 == null) {
                                    serializeWriter.writeNull();
                                    z4 = z4 ? 1 : 0;
                                    cls5 = cls5;
                                    z3 = false;
                                    z5 = false;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        objectWriter = jSONSerializer.getObjectWriter(cls);
                                        cls3 = cls;
                                    } else {
                                        cls3 = cls2;
                                    }
                                    objectSerializer = objectWriter;
                                    if (SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName)) {
                                        objectWriter = objectSerializer;
                                        objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                    } else {
                                        objectWriter = objectSerializer;
                                        objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                    }
                                    cls5 = cls3;
                                    z3 = false;
                                    z5 = false;
                                    z4 = z4 ? 1 : 0;
                                }
                            }
                        } else if ((!key.getClass().isPrimitive() && !(key instanceof Number)) || apply(jSONSerializer, obj4, JSON.toJSONString(key), value)) {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!apply(jSONSerializer, obj4, key, value)) {
                                    }
                                } else if (!apply(jSONSerializer, obj4, key, value)) {
                                }
                            }
                            list4 = jSONSerializer.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                obj3 = objProcessValue;
                            } else {
                                str2 = str;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                obj3 = objProcessValue;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str7 = str2;
                                if (!z5) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer.println();
                                }
                                serializeWriter.writeFieldName(str7, z4);
                            } else {
                                if (!z5) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                } else {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                }
                                serializeWriter.write(58);
                            }
                            if (obj3 == null) {
                                serializeWriter.writeNull();
                                z4 = z4 ? 1 : 0;
                                cls5 = cls5;
                                z3 = false;
                                z5 = false;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    objectWriter = jSONSerializer.getObjectWriter(cls);
                                    cls3 = cls;
                                } else {
                                    cls3 = cls2;
                                }
                                objectSerializer = objectWriter;
                                if (SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName)) {
                                    objectWriter = objectSerializer;
                                    objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                } else {
                                    objectWriter = objectSerializer;
                                    objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                }
                                cls5 = cls3;
                                z3 = false;
                                z5 = false;
                                z4 = z4 ? 1 : 0;
                            }
                        }
                        cls5 = cls5;
                        z4 = z4 ? 1 : 0;
                        z4 = z4;
                        cls5 = cls5;
                        z3 = false;
                    }
                } else {
                    if (key == null || (key instanceof String)) {
                        if (applyName(jSONSerializer, obj4, key)) {
                            list2 = jSONSerializer.propertyFilters;
                            if (list2 != null) {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!apply(jSONSerializer, obj4, key, value)) {
                                        }
                                    } else if (!apply(jSONSerializer, obj4, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                    obj3 = objProcessValue;
                                } else {
                                    str2 = str;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                    obj3 = objProcessValue;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str8 = str2;
                                    if (!z5) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer.println();
                                    }
                                    serializeWriter.writeFieldName(str8, z4);
                                } else {
                                    if (!z5) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    } else {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (obj3 == null) {
                                    serializeWriter.writeNull();
                                    z4 = z4 ? 1 : 0;
                                    cls5 = cls5;
                                    z3 = false;
                                    z5 = false;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        objectWriter = jSONSerializer.getObjectWriter(cls);
                                        cls3 = cls;
                                    } else {
                                        cls3 = cls2;
                                    }
                                    objectSerializer = objectWriter;
                                    if (SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName)) {
                                        objectWriter = objectSerializer;
                                        objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                    } else {
                                        objectWriter = objectSerializer;
                                        objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                    }
                                    cls5 = cls3;
                                    z3 = false;
                                    z5 = false;
                                    z4 = z4 ? 1 : 0;
                                }
                            } else {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!apply(jSONSerializer, obj4, key, value)) {
                                        }
                                    } else if (!apply(jSONSerializer, obj4, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                    obj3 = objProcessValue;
                                } else {
                                    str2 = str;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                    obj3 = objProcessValue;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str9 = str2;
                                    if (!z5) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer.println();
                                    }
                                    serializeWriter.writeFieldName(str9, z4);
                                } else {
                                    if (!z5) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    } else {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (obj3 == null) {
                                    serializeWriter.writeNull();
                                    z4 = z4 ? 1 : 0;
                                    cls5 = cls5;
                                    z3 = false;
                                    z5 = false;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        objectWriter = jSONSerializer.getObjectWriter(cls);
                                        cls3 = cls;
                                    } else {
                                        cls3 = cls2;
                                    }
                                    objectSerializer = objectWriter;
                                    if (SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName)) {
                                        objectWriter = objectSerializer;
                                        objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                    } else {
                                        objectWriter = objectSerializer;
                                        objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                    }
                                    cls5 = cls3;
                                    z3 = false;
                                    z5 = false;
                                    z4 = z4 ? 1 : 0;
                                }
                            }
                        }
                    } else if ((!key.getClass().isPrimitive() && !(key instanceof Number)) || applyName(jSONSerializer, obj4, JSON.toJSONString(key))) {
                        list2 = jSONSerializer.propertyFilters;
                        if (list2 != null) {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!apply(jSONSerializer, obj4, key, value)) {
                                    }
                                } else if (!apply(jSONSerializer, obj4, key, value)) {
                                }
                            }
                            list4 = jSONSerializer.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                obj3 = objProcessValue;
                            } else {
                                str2 = str;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                obj3 = objProcessValue;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str10 = str2;
                                if (!z5) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer.println();
                                }
                                serializeWriter.writeFieldName(str10, z4);
                            } else {
                                if (!z5) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                } else {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                }
                                serializeWriter.write(58);
                            }
                            if (obj3 == null) {
                                serializeWriter.writeNull();
                                z4 = z4 ? 1 : 0;
                                cls5 = cls5;
                                z3 = false;
                                z5 = false;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    objectWriter = jSONSerializer.getObjectWriter(cls);
                                    cls3 = cls;
                                } else {
                                    cls3 = cls2;
                                }
                                objectSerializer = objectWriter;
                                if (SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName)) {
                                    objectWriter = objectSerializer;
                                    objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                } else {
                                    objectWriter = objectSerializer;
                                    objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                }
                                cls5 = cls3;
                                z3 = false;
                                z5 = false;
                                z4 = z4 ? 1 : 0;
                            }
                        } else {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!apply(jSONSerializer, obj4, key, value)) {
                                    }
                                } else if (!apply(jSONSerializer, obj4, key, value)) {
                                }
                            }
                            list4 = jSONSerializer.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                obj3 = objProcessValue;
                            } else {
                                str2 = str;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                obj3 = objProcessValue;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str11 = str2;
                                if (!z5) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer.println();
                                }
                                serializeWriter.writeFieldName(str11, z4);
                            } else {
                                if (!z5) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                } else {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                }
                                serializeWriter.write(58);
                            }
                            if (obj3 == null) {
                                serializeWriter.writeNull();
                                z4 = z4 ? 1 : 0;
                                cls5 = cls5;
                                z3 = false;
                                z5 = false;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    objectWriter = jSONSerializer.getObjectWriter(cls);
                                    cls3 = cls;
                                } else {
                                    cls3 = cls2;
                                }
                                objectSerializer = objectWriter;
                                if (SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName)) {
                                    objectWriter = objectSerializer;
                                    objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                } else {
                                    objectWriter = objectSerializer;
                                    objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                }
                                cls5 = cls3;
                                z3 = false;
                                z5 = false;
                                z4 = z4 ? 1 : 0;
                            }
                        }
                    }
                    cls5 = cls5;
                    z4 = z4 ? 1 : 0;
                    z4 = z4;
                    cls5 = cls5;
                    z3 = false;
                }
            } else {
                if (key == null || (key instanceof String)) {
                    if (applyName(jSONSerializer, obj4, key)) {
                        list = this.propertyPreFilters;
                        if (list != null) {
                            list2 = jSONSerializer.propertyFilters;
                            if (list2 != null) {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!apply(jSONSerializer, obj4, key, value)) {
                                        }
                                    } else if (!apply(jSONSerializer, obj4, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                    obj3 = objProcessValue;
                                } else {
                                    str2 = str;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                    obj3 = objProcessValue;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str12 = str2;
                                    if (!z5) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer.println();
                                    }
                                    serializeWriter.writeFieldName(str12, z4);
                                } else {
                                    if (!z5) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    } else {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (obj3 == null) {
                                    serializeWriter.writeNull();
                                    z4 = z4 ? 1 : 0;
                                    cls5 = cls5;
                                    z3 = false;
                                    z5 = false;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        objectWriter = jSONSerializer.getObjectWriter(cls);
                                        cls3 = cls;
                                    } else {
                                        cls3 = cls2;
                                    }
                                    objectSerializer = objectWriter;
                                    if (SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName)) {
                                        objectWriter = objectSerializer;
                                        objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                    } else {
                                        objectWriter = objectSerializer;
                                        objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                    }
                                    cls5 = cls3;
                                    z3 = false;
                                    z5 = false;
                                    z4 = z4 ? 1 : 0;
                                }
                            } else {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!apply(jSONSerializer, obj4, key, value)) {
                                        }
                                    } else if (!apply(jSONSerializer, obj4, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                    obj3 = objProcessValue;
                                } else {
                                    str2 = str;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                    obj3 = objProcessValue;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str13 = str2;
                                    if (!z5) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer.println();
                                    }
                                    serializeWriter.writeFieldName(str13, z4);
                                } else {
                                    if (!z5) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    } else {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (obj3 == null) {
                                    serializeWriter.writeNull();
                                    z4 = z4 ? 1 : 0;
                                    cls5 = cls5;
                                    z3 = false;
                                    z5 = false;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        objectWriter = jSONSerializer.getObjectWriter(cls);
                                        cls3 = cls;
                                    } else {
                                        cls3 = cls2;
                                    }
                                    objectSerializer = objectWriter;
                                    if (SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName)) {
                                        objectWriter = objectSerializer;
                                        objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                    } else {
                                        objectWriter = objectSerializer;
                                        objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                    }
                                    cls5 = cls3;
                                    z3 = false;
                                    z5 = false;
                                    z4 = z4 ? 1 : 0;
                                }
                            }
                        } else {
                            list2 = jSONSerializer.propertyFilters;
                            if (list2 != null) {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!apply(jSONSerializer, obj4, key, value)) {
                                        }
                                    } else if (!apply(jSONSerializer, obj4, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                    obj3 = objProcessValue;
                                } else {
                                    str2 = str;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                    obj3 = objProcessValue;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str14 = str2;
                                    if (!z5) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer.println();
                                    }
                                    serializeWriter.writeFieldName(str14, z4);
                                } else {
                                    if (!z5) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    } else {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (obj3 == null) {
                                    serializeWriter.writeNull();
                                    z4 = z4 ? 1 : 0;
                                    cls5 = cls5;
                                    z3 = false;
                                    z5 = false;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        objectWriter = jSONSerializer.getObjectWriter(cls);
                                        cls3 = cls;
                                    } else {
                                        cls3 = cls2;
                                    }
                                    objectSerializer = objectWriter;
                                    if (SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName)) {
                                        objectWriter = objectSerializer;
                                        objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                    } else {
                                        objectWriter = objectSerializer;
                                        objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                    }
                                    cls5 = cls3;
                                    z3 = false;
                                    z5 = false;
                                    z4 = z4 ? 1 : 0;
                                }
                            } else {
                                list3 = this.propertyFilters;
                                if (list3 != null) {
                                    if (key != null) {
                                        if (!apply(jSONSerializer, obj4, key, value)) {
                                        }
                                    } else if (!apply(jSONSerializer, obj4, key, value)) {
                                    }
                                }
                                list4 = jSONSerializer.nameFilters;
                                if (list4 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    }
                                }
                                list5 = this.nameFilters;
                                if (list5 != null) {
                                    if (key != null) {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    } else {
                                        key = processKey(jSONSerializer, obj4, key, value);
                                    }
                                }
                                str = key;
                                if (str != null) {
                                    str2 = str;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                    obj3 = objProcessValue;
                                } else {
                                    str2 = str;
                                    objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                    obj3 = objProcessValue;
                                }
                                if (obj3 == null) {
                                }
                                if (str2 instanceof String) {
                                    String str15 = str2;
                                    if (!z5) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                        jSONSerializer.println();
                                    }
                                    serializeWriter.writeFieldName(str15, z4);
                                } else {
                                    if (!z5) {
                                        serializeWriter.write(44);
                                    }
                                    if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    } else {
                                        jSONSerializer.write(JSON.toJSONString(str2));
                                    }
                                    serializeWriter.write(58);
                                }
                                if (obj3 == null) {
                                    serializeWriter.writeNull();
                                    z4 = z4 ? 1 : 0;
                                    cls5 = cls5;
                                    z3 = false;
                                    z5 = false;
                                } else {
                                    cls = obj3.getClass();
                                    cls2 = cls5;
                                    if (cls != cls2) {
                                        objectWriter = jSONSerializer.getObjectWriter(cls);
                                        cls3 = cls;
                                    } else {
                                        cls3 = cls2;
                                    }
                                    objectSerializer = objectWriter;
                                    if (SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName)) {
                                        objectWriter = objectSerializer;
                                        objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                    } else {
                                        objectWriter = objectSerializer;
                                        objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                    }
                                    cls5 = cls3;
                                    z3 = false;
                                    z5 = false;
                                    z4 = z4 ? 1 : 0;
                                }
                            }
                        }
                    }
                } else if ((!key.getClass().isPrimitive() && !(key instanceof Number)) || applyName(jSONSerializer, obj4, JSON.toJSONString(key))) {
                    list = this.propertyPreFilters;
                    if (list != null) {
                        list2 = jSONSerializer.propertyFilters;
                        if (list2 != null) {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!apply(jSONSerializer, obj4, key, value)) {
                                    }
                                } else if (!apply(jSONSerializer, obj4, key, value)) {
                                }
                            }
                            list4 = jSONSerializer.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                obj3 = objProcessValue;
                            } else {
                                str2 = str;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                obj3 = objProcessValue;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str16 = str2;
                                if (!z5) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer.println();
                                }
                                serializeWriter.writeFieldName(str16, z4);
                            } else {
                                if (!z5) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                } else {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                }
                                serializeWriter.write(58);
                            }
                            if (obj3 == null) {
                                serializeWriter.writeNull();
                                z4 = z4 ? 1 : 0;
                                cls5 = cls5;
                                z3 = false;
                                z5 = false;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    objectWriter = jSONSerializer.getObjectWriter(cls);
                                    cls3 = cls;
                                } else {
                                    cls3 = cls2;
                                }
                                objectSerializer = objectWriter;
                                if (SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName)) {
                                    objectWriter = objectSerializer;
                                    objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                } else {
                                    objectWriter = objectSerializer;
                                    objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                }
                                cls5 = cls3;
                                z3 = false;
                                z5 = false;
                                z4 = z4 ? 1 : 0;
                            }
                        } else {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!apply(jSONSerializer, obj4, key, value)) {
                                    }
                                } else if (!apply(jSONSerializer, obj4, key, value)) {
                                }
                            }
                            list4 = jSONSerializer.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                obj3 = objProcessValue;
                            } else {
                                str2 = str;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                obj3 = objProcessValue;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str17 = str2;
                                if (!z5) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer.println();
                                }
                                serializeWriter.writeFieldName(str17, z4);
                            } else {
                                if (!z5) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                } else {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                }
                                serializeWriter.write(58);
                            }
                            if (obj3 == null) {
                                serializeWriter.writeNull();
                                z4 = z4 ? 1 : 0;
                                cls5 = cls5;
                                z3 = false;
                                z5 = false;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    objectWriter = jSONSerializer.getObjectWriter(cls);
                                    cls3 = cls;
                                } else {
                                    cls3 = cls2;
                                }
                                objectSerializer = objectWriter;
                                if (SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName)) {
                                    objectWriter = objectSerializer;
                                    objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                } else {
                                    objectWriter = objectSerializer;
                                    objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                }
                                cls5 = cls3;
                                z3 = false;
                                z5 = false;
                                z4 = z4 ? 1 : 0;
                            }
                        }
                    } else {
                        list2 = jSONSerializer.propertyFilters;
                        if (list2 != null) {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!apply(jSONSerializer, obj4, key, value)) {
                                    }
                                } else if (!apply(jSONSerializer, obj4, key, value)) {
                                }
                            }
                            list4 = jSONSerializer.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                obj3 = objProcessValue;
                            } else {
                                str2 = str;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                obj3 = objProcessValue;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str18 = str2;
                                if (!z5) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer.println();
                                }
                                serializeWriter.writeFieldName(str18, z4);
                            } else {
                                if (!z5) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                } else {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                }
                                serializeWriter.write(58);
                            }
                            if (obj3 == null) {
                                serializeWriter.writeNull();
                                z4 = z4 ? 1 : 0;
                                cls5 = cls5;
                                z3 = false;
                                z5 = false;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    objectWriter = jSONSerializer.getObjectWriter(cls);
                                    cls3 = cls;
                                } else {
                                    cls3 = cls2;
                                }
                                objectSerializer = objectWriter;
                                if (SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName)) {
                                    objectWriter = objectSerializer;
                                    objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                } else {
                                    objectWriter = objectSerializer;
                                    objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                }
                                cls5 = cls3;
                                z3 = false;
                                z5 = false;
                                z4 = z4 ? 1 : 0;
                            }
                        } else {
                            list3 = this.propertyFilters;
                            if (list3 != null) {
                                if (key != null) {
                                    if (!apply(jSONSerializer, obj4, key, value)) {
                                    }
                                } else if (!apply(jSONSerializer, obj4, key, value)) {
                                }
                            }
                            list4 = jSONSerializer.nameFilters;
                            if (list4 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                }
                            }
                            list5 = this.nameFilters;
                            if (list5 != null) {
                                if (key != null) {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                } else {
                                    key = processKey(jSONSerializer, obj4, key, value);
                                }
                            }
                            str = key;
                            if (str != null) {
                                str2 = str;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                obj3 = objProcessValue;
                            } else {
                                str2 = str;
                                objProcessValue = processValue(jSONSerializer, null, obj, str2, value, i);
                                obj3 = objProcessValue;
                            }
                            if (obj3 == null) {
                            }
                            if (str2 instanceof String) {
                                String str19 = str2;
                                if (!z5) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat)) {
                                    jSONSerializer.println();
                                }
                                serializeWriter.writeFieldName(str19, z4);
                            } else {
                                if (!z5) {
                                    serializeWriter.write(44);
                                }
                                if (serializeWriter.isEnabled(NON_STRINGKEY_AS_STRING)) {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                } else {
                                    jSONSerializer.write(JSON.toJSONString(str2));
                                }
                                serializeWriter.write(58);
                            }
                            if (obj3 == null) {
                                serializeWriter.writeNull();
                                z4 = z4 ? 1 : 0;
                                cls5 = cls5;
                                z3 = false;
                                z5 = false;
                            } else {
                                cls = obj3.getClass();
                                cls2 = cls5;
                                if (cls != cls2) {
                                    objectWriter = jSONSerializer.getObjectWriter(cls);
                                    cls3 = cls;
                                } else {
                                    cls3 = cls2;
                                }
                                objectSerializer = objectWriter;
                                if (SerializerFeature.isEnabled(i, SerializerFeature.WriteClassName)) {
                                    objectWriter = objectSerializer;
                                    objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                } else {
                                    objectWriter = objectSerializer;
                                    objectWriter.write(jSONSerializer, obj3, str2, null, i);
                                }
                                cls5 = cls3;
                                z3 = false;
                                z5 = false;
                                z4 = z4 ? 1 : 0;
                            }
                        }
                    }
                }
                cls5 = cls5;
                z4 = z4 ? 1 : 0;
                z4 = z4;
                cls5 = cls5;
                z3 = false;
            }
            obj4 = obj;
        }
        jSONSerializer.context = serialContext;
        jSONSerializer.decrementIdent();
        if (serializeWriter.isEnabled(SerializerFeature.PrettyFormat) && treeMap.size() > 0) {
            jSONSerializer.println();
        }
        if (z) {
            return;
        }
        serializeWriter.write(125);
    }
}
