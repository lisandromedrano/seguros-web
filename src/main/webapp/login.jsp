<%@page contentType="text/html" pageEncoding="UTF-8"%>
	 <link rel="shortcut icon" href="css/icons/favicon.ico" type="image/x-icon" />

<!--     <script type="text/javascript"   src="ext/ext-all.js"></script> -->
    <jsp:include page="WEB-INF/jsp/constants.jsp"></jsp:include>
    
 <title>Gestion de Asegurados</title>
    <!-- <x-compile> -->
        <!-- <x-bootstrap> -->
            <link rel="stylesheet" href="bootstrap.css">
            <link rel="stylesheet" href="css/seguros.css">
            <script src="ext/ext-all.js"></script>
        <!-- </x-bootstrap> -->
<!--         <script src="app.js"></script> -->


</script>
    <script type="text/javascript"   src="Login.js"></script>
<!--     <script type="text/javascript"   src="constsants.js"></script> -->
<style type="text/css">
#login{
	width:417px;
    height:262px;
    position:absolute;
    left:50%;
    top:50%;
    margin:-100px 0 0 -150px;    
}
.login-bg{
    background-image: url(css/images/fondo_login.jpg);	
/*     height: 100%; */
/*   	width:100%;	 */
	background-size:   cover;                      /* <------ */
    background-repeat: no-repeat;
}
.seguros-login-logo{
   max-height: 100px !important;
	padding-bottom: 0px !important;
	max-width: 350px;
}
</style>

<html>

<body class="login-bg">
	<div id="login"></div>
</body>
</html>

