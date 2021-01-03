package com.dbapp.util;

import org.mapstruct.factory.Mappers;

public class ConvertUtil {

    public static <R> R convert(Class<R> coClass){
        R r = Mappers.getMapper(coClass);
        return r;
    }
}
