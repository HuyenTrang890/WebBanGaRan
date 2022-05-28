<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.css" rel="stylesheet">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.js"></script>
<link href="${pageContext.request.contextPath}/css/TaiKhoan.css" />

    <title>Document</title>
</head>
<body>
   
          <div class="profile-sidebar">                          
            <div class="profile-userpic">
                <img src="https://hocwebgiare.com/thiet_ke_web_chuan_demo/bootstrap_user_profile/images/profile_user.jpg" class="img-responsive" alt="Thông tin cá nhân">               
            </div>                                            
            <div class="profile-usertitle">                   
             <div class="profile-usertitle-name">Xin chào ${userName}</div>                  
            </div>                                                
            <div class="profile-userbuttons">                 
             <button type="button" class="btn btn-success btn-sm">Trang chủ</button>                  
             <button type="button" class="btn btn-danger btn-sm">
             <c:url var="url" value="logout">
				</c:url>
             <a herf="${url}">Thoát ra</a></button>                
            </div>                                            
            <div class="profile-usermenu">                    
             <ul class="nav">
                
              <li><c:url var="url" value="Information">
				</c:url><a href="${url}"><i class="glyphicon glyphicon-info-sign"></i>Thông tin cá nhân</a>                        
                                   
              <li><a href="#" target="_blank"><i class="glyphicon glyphicon-shopping-cart"></i>Quản lý đơn hàng </a>                       
              </li>                       
                                   
              </li>                   
             </ul>                
            </div>                            
           </div>     
          </div>      
</body>
</html>