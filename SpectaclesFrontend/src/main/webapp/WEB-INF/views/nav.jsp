<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!doctype html>
<html class="no-js" lang="zxx">
<head>
<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />
<spring:url value="/resources/img" var="img" /> 



	<meta charset="utf-8">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>Spectacles Store</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Favicon -->
	<link rel="shortcut icon" href="${img}/favicon.ico" type="image/x-icon">
	<link rel="apple-touch-icon" href="${img}/icon.png">

	<!-- Plugins -->
	<link rel="stylesheet" href="${css}/bootstrap.min.css">
	<link rel="stylesheet" href="${css}/plugins.css">

	<!-- Style Css -->
      	<link rel="stylesheet" href="${css}/style.css">

	<!-- Custom Styles -->
	<link rel="stylesheet" href="${css}/custom.css">
	<link rel="stylesheet" href="${css}/loginstyle.css">
</head>


<body>


	<!-- Wrapper -->
	<div id="wrapper" class="wrapper">
		<!-- Header -->
		<header class="header chasmishco_header bg-cat--4 header--two">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-xl-3 col-lg-2 col-md-4">
						<div class="logo">
							<a href="<c:url value="/"/>">
								<img src="${img}/logo/2.png" alt="Spectacles Store Logo">
							</a>
						</div>
					</div>
					<div class="col-xl-9 col-lg-10 col-md-8">
						<div class="header_right_sidebar">
							<div class="login_account">
								<div class="account white_text">
									<ul>
									<c:if test="${pageContext.request.userPrincipal.name==null}">
										<li>
                                            <a href="<c:url value="/login"/>">Login</a>
                                        </li>
                                        <li>
                                            <a href="<c:url value="/register"/>">Register</a>
                                        </li>
                                        </c:if>
                                        
                                        <c:if test="${pageContext.request.userPrincipal.name!=null}">
					<li><a href="<c:url value='/j_spring_security_logout'/>">
							 WELCOME&nbsp;
							${pageContext.request.userPrincipal.name}
							&nbsp;
							Sign out
					</a></li>
				</c:if>
									</ul>
								</div>
								<div class="">
									<div class="shop_cart_icon  ">
										<a href="<c:url value="/cart"/>"><img src="${img}/icons/icon2.png" alt="icons">
										<span class="shop_count white_text"></span>
										<span class="cart_text white_text">cart</span></a>
									</div>
								</div>
							</div>
							<div class="glass_toggle_menu">

								<nav class="mainmenu_nav mainmenu__nav white_text">
									<ul class="main_menu">
                                        <li class="drop">
                                            <a href="<c:url value="/"/>">Home</a>
                                          
                                        </li>
                                        <li class="drop">
                                            <a href="<c:url value="/viewproducts"/>">Shop</a>
                                        </li>
                                        
                                        <li>
                                            <a href="about.html">About</a>
                                        </li>
                                        <li class="drop">
                                            <a href="#">Pages</a>
                                            <ul class="dropdown">
                                                <li>
                                                    <a href="<c:url value="/wishlist"/>">Wishlist Page</a>
                                                </li>
                                                <li>
                                                    <a href="<c:url value="/myaccount"/>">My Account</a>
                                                </li>
                                                <li>
                                                    <a href="<c:url value="/checkout"/>">Checkout Page</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li>
                                            <a href="<c:url value="/contact"/>">Contact</a>
                                        </li>
                                        <security:authorize access="hasRole('ROLE_ADMIN')">
                                        <li>
                                        <a href="<c:url value="/admin/supplier"/>">Add Supplier</a>
                                        </li>
                                        <li>
                                        <a href="<c:url value="/admin/products"/>">Add Products</a>
                                        </li>
                                        <li>
                                        <a href="<c:url value="/admin/category"/>">Add Category</a>
                                        </li>
                                        </security:authorize>
                                    </ul>
								</nav>

								<div class="hamburger-box button mobile-toggle white_text">
									<span class="mobile-toggle__icon"></span>
								</div>
							</div>
							<!-- Mobile Menu -->
							<div class="mobile-menu d-block d-lg-none"></div>
							<!-- Mobile Menu -->
						</div>
					</div>
				</div>
				
			</div>
		</header>
		</div>	
  </div>
 
	</body>

</html>