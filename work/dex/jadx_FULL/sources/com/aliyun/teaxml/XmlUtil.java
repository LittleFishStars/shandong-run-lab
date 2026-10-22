package com.aliyun.teaxml;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.utils.StringUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class XmlUtil {
    public static Map<String, Object> DeserializeXml(String str, Class cls) throws IllegalAccessException, DocumentException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Field field;
        HashMap map = new HashMap();
        if (StringUtils.isEmpty((CharSequence) str)) {
            return map;
        }
        Element rootElement = DocumentHelper.parseText(str).getRootElement();
        if (cls != null) {
            Field[] fields = cls.getFields();
            int length = fields.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    field = null;
                    break;
                }
                field = fields[i];
                field.setAccessible(true);
                NameInMap nameInMap = (NameInMap) field.getAnnotation(NameInMap.class);
                if ((nameInMap == null ? field.getName() : nameInMap.value()).equals(rootElement.getName())) {
                    break;
                }
                i++;
            }
            if (field != null) {
                if (String.class == field.getType()) {
                    map.put(rootElement.getName(), rootElement.getText());
                    return map;
                }
                map.put(rootElement.getName(), getValueFromXml(rootElement, field.getType()));
            }
        } else {
            ElementToMap(rootElement, map);
        }
        return map;
    }

    private static Object ElementToMap(Element element, Map<String, Object> map) {
        List<Element> listElements = element.elements();
        if (listElements.size() == 0) {
            Object textTrim = StringUtils.isEmpty((CharSequence) element.getTextTrim()) ? null : element.getTextTrim();
            if (map != null) {
                map.put(element.getName(), textTrim);
            }
            return textTrim;
        }
        HashMap map2 = new HashMap();
        if (map != null) {
            map.put(element.getName(), map2);
        }
        for (Element element2 : listElements) {
            if (map2.containsKey(element2.getName())) {
                Object obj = map2.get(element2.getName());
                Class<?> cls = obj.getClass();
                if (List.class.isAssignableFrom(cls)) {
                    ((List) obj).add(ElementToMap(element2, null));
                } else if (Map.class.isAssignableFrom(cls)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add((Map) map2.remove(element2.getName()));
                    arrayList.add(ElementToMap(element2, null));
                    map2.put(element2.getName(), arrayList);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(map2.remove(element2.getName()));
                    arrayList2.add(ElementToMap(element2, null));
                    map2.put(element2.getName(), arrayList2);
                }
            } else {
                ElementToMap(element2, map2);
            }
        }
        return map2;
    }

    private static Object castType(Class cls, String str) {
        if (Boolean.TYPE == cls || Boolean.class == cls) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
        if (Integer.TYPE == cls || Integer.class == cls) {
            return Integer.valueOf(Integer.parseInt(str));
        }
        return (Long.TYPE == cls || Long.class == cls) ? Long.valueOf(Long.parseLong(str)) : str;
    }

    private static Map<String, Object> getValueFromXml(Element element, Class cls) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        HashMap map = new HashMap();
        for (Field field : cls.getFields()) {
            NameInMap nameInMap = (NameInMap) field.getAnnotation(NameInMap.class);
            String name = nameInMap == null ? field.getName() : nameInMap.value();
            if (List.class.isAssignableFrom(field.getType())) {
                List listElements = element.elements(name);
                Type type = ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
                Class cls2 = type instanceof Class ? (Class) type : null;
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < listElements.size(); i++) {
                    arrayList.add(TeaModel.toModel(getValueFromXml((Element) listElements.get(i), cls2), (TeaModel) cls2.newInstance()));
                }
                map.put(name, arrayList);
            } else if (TeaModel.class.isAssignableFrom(field.getType())) {
                Element element2 = element.element(name);
                if (element2 != null) {
                    map.put(name, getValueFromXml(element2, field.getType()));
                }
            } else {
                Element element3 = element.element(name);
                if (element3 != null) {
                    map.put(name, castType(field.getType(), element3.getText()));
                }
            }
        }
        return map;
    }

    public static String mapToXml(Map<String, Object> map) throws IllegalAccessException {
        if (map == null || map.isEmpty()) {
            return "";
        }
        if (map.size() != 1) {
            throw new RuntimeException("This map does not have a unique root tag");
        }
        String str = ((String[]) map.keySet().toArray(new String[0]))[0];
        Document documentCreateDocument = DocumentHelper.createDocument();
        setValue(documentCreateDocument.addElement(str), str, map.get(str));
        return documentCreateDocument.asXML();
    }

    private static void setValue(Element element, String str, Object obj) throws IllegalAccessException {
        Class<?> cls = obj.getClass();
        if (Map.class.isAssignableFrom(cls)) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                if (entry.getValue() != null) {
                    if (List.class.isAssignableFrom(entry.getValue().getClass())) {
                        setValue(element, (String) entry.getKey(), entry.getValue());
                    } else {
                        setValue(element.addElement((String) entry.getKey()), (String) entry.getKey(), entry.getValue());
                    }
                }
            }
            return;
        }
        if (List.class.isAssignableFrom(cls)) {
            for (Object obj2 : (List) obj) {
                if (obj2 != null) {
                    setValue(element.addElement(str), str, obj2);
                }
            }
            return;
        }
        if (!TeaModel.class.isAssignableFrom(cls)) {
            element.setText(String.valueOf(obj));
            return;
        }
        for (Map.Entry<String, Object> entry2 : ((TeaModel) obj).toMap().entrySet()) {
            if (entry2.getValue() != null) {
                if (List.class.isAssignableFrom(entry2.getValue().getClass())) {
                    setValue(element, entry2.getKey(), entry2.getValue());
                } else {
                    setValue(element.addElement(entry2.getKey()), entry2.getKey(), entry2.getValue());
                }
            }
        }
    }
}
