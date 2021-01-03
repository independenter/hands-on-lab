package com.dbapp.core.response;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * @author independenter
 * @since
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Response {

	/**
	 * 保证我的data字段即使为空,也会返回
	 */
	private static final transient SerializerFeature[] FEATURES = {
            //输出key时是否使用双引号,默认为true
			SerializerFeature.QuoteFieldNames,
            //是否输出值为null的字段,默认为false
			SerializerFeature.WriteMapNullValue,
            //数值字段如果为null,输出为0,而非null
			SerializerFeature.WriteNullNumberAsZero,
            //List字段如果为null,输出为[],而非null
			SerializerFeature.WriteNullListAsEmpty,
            //字符类型字段如果为null,输出为”“,而非null
			SerializerFeature.WriteNullStringAsEmpty,
            //Boolean字段如果为null,输出为false,而非null
			SerializerFeature.WriteNullBooleanAsFalse,
            //不进行压缩,去掉$ref符号
			SerializerFeature.DisableCircularReferenceDetect,
	};

	int code;
    String msg;
    Object data;
    long total;

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

	public static Response success(){
        return success(null);
    }

    public static <T> Response success(T data){
        if(data != null && data instanceof PageInfo){
            @SuppressWarnings("rawtypes")
			PageInfo pageInfo = (PageInfo)data;
            return success(pageInfo.getList(),pageInfo.getTotal());
        }
        long total = ObjectUtil.length(data);
        return success(data,total);
    }

	public static <T,R> Response success(PageInfo<T> pageInfo, Function<T,R> function){
        List<R> results = pageInfo.getList().stream().map(function).collect(Collectors.toList());
        return success(results,pageInfo.getTotal());
    }

    public static <T> Response success(T data,long total){
        return new Response(ResponseEnum.OK.getCode(),ResponseEnum.OK.getMsg(),data, total);
    }

    public static Response error(){
        return error(ResponseEnum.ERROR.getCode(),ResponseEnum.ERROR.getMsg());
    }

    public static Response error(int code){
        return error(code,ResponseEnum.ERROR.getMsg());
    }

    public static Response error(String msg){
        return error(ResponseEnum.ERROR.getCode(), msg);
    }

    public static Response error(int code,String msg){
        return new Response(code,msg);
    }

	 /** (non-Javadoc)
	 * <p>Title: toString</p>
	 * <p>Description: </p>
	 * @return
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		return JSON.toJSONString(this,FEATURES);
	}
}
