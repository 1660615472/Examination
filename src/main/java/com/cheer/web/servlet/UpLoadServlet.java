package com.cheer.web.servlet;

import com.cheer.model.Admin;
import com.cheer.poi.MainTest;

import com.cheer.utils.IOUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpLoadServlet", urlPatterns = "/servlet/UpLoadServlet")
public class UpLoadServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger ( UpLoadServlet.class );

    MainTest mainTest=new MainTest();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //定义文件存储路径
        String src =null;
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        File repository = (File) request.getServletContext().getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Parse the request
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        Admin user = new Admin();
        for (FileItem item : items) {
            // 判断是否是普通表单字段还是文件上传字段
                String name = item.getName();
                String tmpDir = System.getProperty("user.home");

                LOGGER.debug(tmpDir);
                File avatarDir = new File(tmpDir + "/avatar");
                if (!avatarDir.exists()) {
                    // 创建路径
                    if(!avatarDir.mkdirs()) {
                        LOGGER.error("创建路径失败！");
                        throw new ServletException("注册失败");
                    }
                }
                String fileName =name;
                src=avatarDir+"/"+fileName;
                //System.out.println(src);
                IOUtils.writeToFile(item.getInputStream(), avatarDir + "/" + fileName);
        }

        mainTest.uploadExcel(src);
        response.sendRedirect("../questionList.html");
    }
}
