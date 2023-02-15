<%@page import="sun.java2d.pipe.DrawImage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.awt.Graphics2D" %>
<%@ page import="java.awt.image.renderable.ParameterBlock" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.media.jai.JAI" %>
<%@ page import="javax.media.jai.RenderedOp" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>

<%

   String imagePath = request.getRealPath("upload");
   int size = 1*1024*1024;
   String filename=""; // 파일네임은 파라미터 값을 저장해서 가져다가 쓸 예정 multipart request 사용할 예정
   
   
   try{
      
      MultipartRequest multi = new MultipartRequest(
            request, imagePath, size, "utf-8", new DefaultFileRenamePolicy());
            
            //enumeration은 utill에 있는 거 
            Enumeration files = multi.getFileNames();
            String file = (String)files.nextElement();
            
            filename = multi.getFilesystemName(file);

   }catch(Exception e){
      e.printStackTrace();
   }

      ParameterBlock pb = new ParameterBlock();
      pb.add(imagePath+"/"+filename);
      
      RenderedOp rOp = JAI.create("fileload", pb);
      
      BufferedImage bi = rOp.getAsBufferedImage();

      // 가로, 세로, 색상
      BufferedImage thumb = new BufferedImage(100,100, BufferedImage.TYPE_INT_RGB);
      
      Graphics2D g = thumb.createGraphics();
      
      g.drawImage(bi,0,0,100,100,null);

      //file객체는 io에 있는거
      File file = new File(imagePath+"/sm_"+filename);
      ImageIO.write(thumb, "jpg", file);


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 썸네일</title>
</head>
<body>
- 원본 이미지 -<br>
<img src="/upload/<%=filename%>"><p>
- 썸네일 이미지 -<br>
<img src="/upload/sm_<%=filename%>"><p>

</body>
</html>