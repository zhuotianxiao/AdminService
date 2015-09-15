package cn.fundview.modules.web.util;

import cn.fundview.common.utils.FileUtils;
import cn.fundview.common.utils.IdGen;
import cn.fundview.modules.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/9/10 0010.
 * 图片上传controller
 */
@Controller
@RequestMapping(value = "/${adminPath}/util/img")
@MultipartConfig
public class ImgController {

    @Autowired
    private IdGen idGen;
    private long IMG_MAX_SIZE = 1572864; //1.5m;// 图片200k , 1048576 1m
    private long FILE_MAX_SIZE = 5120000;// 文件 5M

    @ResponseBody
    @RequestMapping(value = "/upload-temp",produces = "application/json;charset=UTF-8")
    public Map<String,Object> uploadTemp(MultipartFile file, HttpServletRequest request) {


        String uploadPath = Constants.TEMP_UPLOAD_PATH;

        Map<String,Object> result = new HashMap();
        // 判断文件大小 5M
        if (file != null) {

            //生成文件名
            String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
            String fileName = idGen.getNextId()+"." + type;
            // 拷贝到服务器临时目录
            String tempPath = request.getSession().getServletContext().getRealPath(uploadPath)+File.separator;
            System.out.println(tempPath+fileName);
            try {
                File file1 = new File(tempPath + fileName);
                if (!file1.getParentFile().exists()) {

                    file1.getParentFile().mkdirs();
                }
                file.transferTo(file1);
                result.put("result","1");
                result.put("imgPath",uploadPath +"/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
                result.put("result","0");
            }
            //生成url

        }else {

            result.put("result","0");
        }

        return result;
    }
}
