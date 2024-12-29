package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadPhotoServlet")
@MultipartConfig
public class UploadPhotoServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "uploaded_images"; // 上传文件保存的目录

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置响应类型为 JSON
        response.setContentType("application/json;charset=UTF-8");

        // 获取上传文件保存的目录路径
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
        File uploadDir = new File(uploadPath);

        // 如果保存目录不存在，则创建目录
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        PrintWriter out = response.getWriter();

        try {
            // 获取上传的文件部分
            Part filePart = request.getPart("upload");
            if (filePart != null) {
                // 获取上传文件的文件名
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

                // 将文件保存到上传目录
                String filePath = uploadPath + File.separator + fileName;
                filePart.write(filePath);

                // 构建文件的访问 URL，返回给 CKEditor
                String fileUrl = request.getContextPath() + "/" + UPLOAD_DIR + "/" + fileName;

                // 返回 JSON 响应
                out.println("{");
                out.println("\"url\": \"" + fileUrl + "\"");
                out.println("}");
            } else {
                // 如果没有文件上传，返回错误信息
                out.println("{\"error\": \"未上传文件。\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 上传失败时返回错误信息
            out.println("{\"error\": \"文件上传失败。\"}");
        }
    }
}
