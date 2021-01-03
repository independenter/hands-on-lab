package com.dbapp.core.api;

import cn.hutool.core.io.FileUtil;
import com.dbapp.core.model.co.LabProjectCo;
import com.dbapp.core.model.pojo.LabProject;
import com.dbapp.core.model.vo.LabProjectVo;
import com.dbapp.core.response.Response;
import com.dbapp.core.mapper.LabProjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dobb
 */
@RestController
public class BaseController {

    @Resource
    LabProjectMapper labProjectMapper;

    @RequestMapping(value = "/lab",method = RequestMethod.GET)
    public Response getLabList(){
        List<LabProject> labProjects = labProjectMapper.listAllProjects();
        List<LabProjectVo> labProjectVos = labProjects.stream().map(LabProjectCo.INSTANCE::toLabProjectVo).collect(Collectors.toList());
        return Response.success(labProjectVos);
    }

    @RequestMapping(value = "/file", method = RequestMethod.GET)
    public Response file(){
        File file = new File("/Users/dobb/Workspace/lsjy/hands-on-lab/lab-back/lab-back-base/src/main/java/com/dbapp/core/api/BaseController.java");
        return Response.success(FileUtil.readUtf8String(file));
    }
}
