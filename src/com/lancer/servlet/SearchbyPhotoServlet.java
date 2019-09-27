package com.lancer.servlet;

import Service.AuthService;
import Util.Base64Util;
import Util.FileUtil;
import Util.GsonUtils;
import Util.HttpUtil;
import dao.PersonDao;
import dao.impl.PersonDaoImpl;
import entity.InformationTable;
import entity.ResultInformation;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SearchbyPhotoServlet")
public class SearchbyPhotoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";

    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }

        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // 中文处理
        upload.setHeaderEncoding("UTF-8");

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = request.getServletContext().getRealPath("./")+ UPLOAD_DIRECTORY;

        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName="123";
                        System.out.println(fileName);
                        String filePath = uploadPath + File.separator + fileName+".jpg";
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        System.out.println(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                        //读取图片
                        byte[] bytes= FileUtil.readFileByBytes(filePath);
                        //转为Base64
                        String image= Base64Util.encode(bytes);
                        //上传到人脸库(人脸注册)
                        String resultInformation=search(image);
                        if(storeFile.exists()){
                            storeFile.delete();
                        }
                        ResultInformation information=GsonUtils.fromJson(resultInformation, ResultInformation.class);
                        System.out.println(information.getResult().getFace_list().get(0).getUser_list().get(0).getUser_id());
                        //输入上传结果信息
                        String search_result_userID=information.getResult().getFace_list().get(0).getUser_list().get(0).getUser_id();
                        System.out.println(search_result_userID);
                        String student_id=null;
                        String teacher_id=null;
                        if (search_result_userID.startsWith("_")){
                            System.out.println("1");
                            teacher_id=search_result_userID.substring(2);
                            student_id="-1";
                        }else {
                            System.out.println("2");
                            String[] strings=search_result_userID.split("_");
                            student_id=strings[0];
                            teacher_id="-1";
                        }

                        System.out.println(student_id);
                        System.out.println(teacher_id);
                      request.setAttribute("message", "文件上传成功!");
                        PersonDaoImpl personDao=new PersonDaoImpl();
                        List<InformationTable> informations=personDao.find(student_id,teacher_id);
                        request.setAttribute("informations",informations);
                        request.getRequestDispatcher("/jspnofilter/photoresult.jsp").forward(request,response);
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "错误信息: " + ex.getMessage());
        }
        // 跳转到 message.jsp
        request.getServletContext().getRequestDispatcher("/userjsp/message.jsp").forward(
                request, response);

    }


    protected String search(String image){
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/multi-search";
        System.out.println(url);
        System.out.println("1111");
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("image", image);
            map.put("liveness_control", "NONE");
            map.put("group_id_list", "homework");
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");
            map.put("match_threshold",50);

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = AuthService.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println("kaishi");
            System.out.println(result);
            System.out.println(result);
            System.out.println("jieshu");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
