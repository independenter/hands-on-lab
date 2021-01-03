package com.dbapp.core.mapper;

import com.dbapp.core.model.pojo.LabProject;
import org.apache.ibatis.annotations.Mapper;import java.util.List;

@Mapper
public interface LabProjectMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(LabProject record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(LabProject record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    LabProject selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(LabProject record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(LabProject record);

    /**
     * all records
     *
     * @return objects
     */
    List<LabProject> listAllProjects();
}