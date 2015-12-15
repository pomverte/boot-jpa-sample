package com.pomverte.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

public class ListBeanUtils {

    public static <T, U> List<U> copyProperties(List<T> sourceList, Class<U> clazz)
            throws InstantiationException, IllegalAccessException {
        List<U> result = new ArrayList<>();
        for (T source : sourceList) {
            U target = clazz.newInstance();
            BeanUtils.copyProperties(source, target);
            result.add(target);
        }
        return result;
    }

}
