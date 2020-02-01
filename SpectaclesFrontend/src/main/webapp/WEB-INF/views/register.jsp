  
<%@ include file = "nav.jsp" %>
<body style="counter-reset:section;text-align:center;background:#E7DFDE;">
<div class="contain"  style="height:1200px;">
   <h1 style="color:black;">Registration Form</h1>
  <c:url var="add" value="/addUsers" />
  <form:form method="post" action="${add}"  style="margin-top:25px; display:inline-block;" modelAttribute="register">
  <br />
    <div class="fields">
    
    
    
       <form:input class="inputfields" path="usersId" placeholder="User ID" type="hidden" />
    
    <br />
    
    
      <span>
       <form:input class="inputfields" path="usersName" placeholder="Name" type="text" />
    </span>
    <br />
    
    
     <span>
       <form:input class="inputfields" path="usersAddress" placeholder="Address" type="text" />
    </span>
    <br />
    
    
     <span>
       <form:input class="inputfields" path="usersPhoneNo" placeholder="Phone Number" type="text" />
    </span>
    <br />
    
    
     <span>
       <form:input class="inputfields" path="usersEmailId" placeholder="Email Id" type="text" />
    </span>
     <br />
     
     
     <span>
       <form:input class="inputfields" path="usersPassword" placeholder="Password" type="password" />
    </span>
    <br />
    
      <span>
         <form:input  class="inputfields" path="billing.billCity" placeholder="Enter Your City" type="text" />
        </span>
         <br />
         
         
         
         <span>
         <form:input  class="inputfields" path="billing.billState" placeholder="Enter Your State" type="text" />
         </span>
         <br />
         
         <span>
         <form:input  class="inputfields" path="billing.billAddress" placeholder="Enter your Address" type="text" />
         </span>  
         <br />  
    
    
    
    <div class="submit">
      <input style="background:rgb(0,0,0);
  color:#fff;
  position:relative;
  left:9px;
  top:25px; 
  width:100px;
  cursor:pointer;" class="submit" value="Submit" type="submit" />
    </div>
  </form:form>
</div>

</body>

<%@ include file="footer.jsp" %>