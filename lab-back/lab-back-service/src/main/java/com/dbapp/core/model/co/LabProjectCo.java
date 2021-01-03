package com.dbapp.core.model.co;

import cn.hutool.core.convert.impl.BooleanConverter;
import com.dbapp.core.model.pojo.LabProject;
import com.dbapp.core.model.vo.LabProjectVo;
import com.dbapp.exception.ServiceException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.function.Function;

/**
 * @author dobb
 */
@Mapper
public interface LabProjectCo {

    LabProjectCo INSTANCE = Mappers.getMapper( LabProjectCo.class );

    String[] DIFFICULTIES = {"非常简单","简单","一般","较难","困难","非常困难"};

    Function<Integer, String> TIME_CONVERT = (time) -> time + "分钟";

    /**
     *  转换方法
     * @param labProject pojo
     * @return vo
     */
    @Mappings({
        @Mapping(source = "title", target = "title"),
        @Mapping(target = "difficulty",expression = "java(difficultyConvert(labProject.getDifficulty()))"),
        @Mapping(expression = "java(TIME_CONVERT.apply(labProject.getTime()))", target = "time"),
        @Mapping(source = "description", target = "description"),
        @Mapping(source = "href", target = "href"),
        @Mapping(target = "open", expression = "java(byte2Boolean(labProject.getOpen()))"),
    })
    LabProjectVo toLabProjectVo(LabProject labProject);

    /**
     * 转换是否开放
     * @param i 存储参数
     * @return 是否开放
     */
    default boolean byte2Boolean(Byte i){
        BooleanConverter converter = new BooleanConverter();
        return converter.convert(i, false);
    }

    /**
     * 转换难度
     * @param difficulty 级别
     * @return 难度
     */
    default String difficultyConvert(int difficulty){
        ServiceException.trueThrow(difficulty >= DIFFICULTIES.length,"配置有误，连接管理员");
        return DIFFICULTIES[difficulty];
    }
}
