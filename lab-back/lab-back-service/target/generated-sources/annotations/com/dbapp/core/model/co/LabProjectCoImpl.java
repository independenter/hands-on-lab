package com.dbapp.core.model.co;

import com.dbapp.core.model.pojo.LabProject;
import com.dbapp.core.model.vo.LabProjectVo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-02T16:00:38+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
public class LabProjectCoImpl implements LabProjectCo {

    @Override
    public LabProjectVo toLabProjectVo(LabProject labProject) {
        if ( labProject == null ) {
            return null;
        }

        LabProjectVo labProjectVo = new LabProjectVo();

        labProjectVo.setDescription( labProject.getDescription() );
        labProjectVo.setHref( labProject.getHref() );
        labProjectVo.setTitle( labProject.getTitle() );

        labProjectVo.setDifficulty( difficultyConvert(labProject.getDifficulty()) );
        labProjectVo.setTime( TIME_CONVERT.apply(labProject.getTime()) );
        labProjectVo.setOpen( byte2Boolean(labProject.getOpen()) );

        return labProjectVo;
    }
}
