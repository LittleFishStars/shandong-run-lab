package com.aliyun.common.utils;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.utils.StringUtils;
import com.google.gson.Gson;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class XmlUtil {
    public static Map<String, Object> DeserializeXml(String str, Class cls) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Field field;
        HashMap map = new HashMap();
        if (StringUtils.isEmpty((CharSequence) str)) {
            return map;
        }
        try {
            Element rootElement = DocumentHelper.parseText(str).getRootElement();
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
            return map;
        } catch (DocumentException unused) {
            return (Map) new Gson().fromJson(str, Map.class);
        }
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
            if (field.getType().isArray()) {
                List listElements = element.elements(name);
                Object[] objArr = (Object[]) Array.newInstance(field.getType().getComponentType(), listElements.size());
                for (int i = 0; i < listElements.size(); i++) {
                    Array.set(objArr, i, TeaModel.toModel(getValueFromXml((Element) listElements.get(i), field.getType().getComponentType()), (TeaModel) field.getType().getComponentType().newInstance()));
                }
                map.put(name, objArr);
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
