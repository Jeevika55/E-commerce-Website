<%@ include file = "nav.jsp" %>
<body style="counter-reset:section;text-align:center;background:#E7DFDE;">

<div class="contain">
  <h1>Login</h1>
  ${mlog}
<c:url value="/j_spring_security_check" var="login" />
    <form:form action="${login}" method="post" style="margin-top:25px; display:inline-block;">
  <br />
    <div class="fields">
     <span>
       <input class="inputfields" placeholder="User Email ID" type="text" name="j_username"  >
    </span>
     <br />
     <span>
       <input class="inputfields" placeholder="Password" type="password" name="j_password"  >
    </span>
    </div>
    <br />
    <div class="submit">
      <input style="background:rgb(0,0,0);
  color:#fff;
  position:relative;
  left:9px;
  top:25px; 
  width:100px;
  cursor:pointer;" class="submit" value="Login" type="submit" />
    </div>
  </form:form>
</div>
</body>
<%@ include file="footer.jsp" %>