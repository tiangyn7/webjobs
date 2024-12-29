<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>开始使用CKEditor</title>
        <link rel="stylesheet" href="https://cdn.ckeditor.com/ckeditor5/44.1.0/ckeditor5.css" />
        <link rel="stylesheet"
            href="https://cdn.ckeditor.com/ckeditor5-premium-features/44.1.0/ckeditor5-premium-features.css" />

        <script src="https://cdn.ckeditor.com/ckeditor5/44.1.0/ckeditor5.umd.js"></script>
        <script
            src="https://cdn.ckeditor.com/ckeditor5-premium-features/44.1.0/ckeditor5-premium-features.umd.js"></script>
    </head>

    <body>
        <form class="layui-form" action="${pageContext.request.contextPath }/SaveContentServlet" method="post">
            <textarea id="content" name="content"></textarea>
            <br />
            <button class="layui-btn" type="submit">提交</button>
        </form>
        <script>
            ClassicEditor.create(document.querySelector('#content'), {
                language: 'zh-cn',
                toolbar: ['heading', '|', 'bold', 'italic', 'link', 'imageUpload', 'blockQuote', '|', 'undo', 'redo'],
                ckfinder: {
                    uploadUrl: '${pageContext.request.contextPath}/UploadPhotoServlet'
                },
            });
        </script>
    </body>

    </html>