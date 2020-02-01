<%@ include file = "nav.jsp" %>

<!-- Checkout Page Start -->
        <div class="checkout_area pt--120 pb--60">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                    <!-- Checkout Form s-->
                        <c:url var="add" value="/placeorder"/>
                        <form:form method="post" action="${add}" class="checkout-form" modelAttribute="shipping">
                            <div class="row">
                                
                                <div class="col-lg-7 mb--20">
                                    
                                    <!-- Billing Address -->
                                    <div id="billing-form" class="mb--40">
                                        <h4 class="checkout-title">Shipping Address</h4>

                                        <div class="row">
                                        
                                        <div class="col-md-6 col-12 mb--20">
                                                <label>Ship ID</label>
                                                <form:input type="text" placeholder="First Name" path="shipId" />
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Ship Name*</label>
                                                <form:input type="text" placeholder="First Name" path="shipName" />
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Phone no*</label>
                                                <form:input type="text" placeholder="Phone number" path="shipPhoneNo"/>
                                            </div>


                                            <div class="col-12 mb--20">
                                                <label>Address*</label>
                                                <form:input type="text" placeholder="Address line 1" path="shipAddress"/>
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Country*</label>
                                                <form:select class="nice-select" path="shipCountry">
                                                        <option>Bangladesh</option>
                                                        <option>China</option>
                                                        <option>country</option>
                                                        <option>India</option>
                                                        <option>Japan</option>
                                                </form:select>
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Town/City*</label>
                                                <form:input type="text" placeholder="Town/City" path="shipCity"/>
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>State*</label>
                                                <form:input type="text" placeholder="State" path="shipState"/>
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Zip Code*</label>
                                                <form:input type="text" placeholder="Zip Code" path="shipZipCode" />
                                            </div>

                                            <div class="col-12 mb--20">
                                                <div class="check-box">
                                                    <input type="checkbox" id="create_account">
                                                    <label for="create_account">Create an Acount?</label>
                                                </div>
                                                <div class="check-box">
                                                    <input type="checkbox" id="shiping_address" data-shipping>
                                                    <label for="shiping_address">Ship to Different Address</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <!-- Shipping Address -->
                                    <div id="shipping-form">
                                        <h4 class="checkout-title">Shipping Address</h4>
                                        <div class="row">
                                            <div class="col-md-6 col-12 mb--20">
                                                <label>First Name*</label>
                                                <input type="text" placeholder="First Name">
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Last Name*</label>
                                                <input type="text" placeholder="Last Name">
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Email Address*</label>
                                                <input type="email" placeholder="Email Address">
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Phone no*</label>
                                                <input type="text" placeholder="Phone number">
                                            </div>

                                            <div class="col-12 mb--20">
                                                <label>Company Name</label>
                                                <input type="text" placeholder="Company Name">
                                            </div>

                                            <div class="col-12 mb--20">
                                                <label>Address*</label>
                                                <input type="text" placeholder="Address line 1">
                                                <input type="text" placeholder="Address line 2">
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Country*</label>
                                                <select class="nice-select">
                                                        <option>Bangladesh</option>
                                                        <option>China</option>
                                                        <option>country</option>
                                                        <option>India</option>
                                                        <option>Japan</option>
                                                </select>
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Town/City*</label>
                                                <input type="text" placeholder="Town/City">
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>State*</label>
                                                <input type="text" placeholder="State">
                                            </div>

                                            <div class="col-md-6 col-12 mb--20">
                                                <label>Zip Code*</label>
                                                <input type="text" placeholder="Zip Code">
                                            </div>

                                        </div>

                                    </div>
                                    
                                </div>
                                
                                <div class="col-lg-5">
                                    <div class="row">
                                        
                                        <!-- Cart Total -->
                                        <div class="col-12 mb--60">
                                        
                                            <h4 class="checkout-title">Cart Total</h4>
                                    
                                            <div class="checkout-cart-total">

                                                <h4>Product <span>Total</span></h4>
                                                <c:forEach var="prod" items="${CartItems}">
                                                <ul>
                                                    <li>${prod.getProducts().getProductsName()} <span>${prod.getProducts().getPrice()}</span></li>
                                                   
                                                </ul>
                                                </c:forEach>
                                                <h4>Grand Total <span>${cart.getGrandTotal()}</span></h4>
                                                
                                                
                                            </div>
                                            
                                        </div>
                                        
                                        <!-- Payment Method -->
                                        <div class="col-12 mb--60">
                                        
                                            <h4 class="checkout-title">Payment Method</h4>
                                    
                                            <div class="checkout-payment-method">
                                                
                                                
                                                    <input type="radio" id="payment-method" name="payment-method" value="card">
                                                <center>    <label for="payment_check">Card</label>
                                                
                                                </center>
                                                   
                                                
                                                    <input type="radio" id="payment-method" name="payment-method" value="cash">
                                                    <center><label for="payment_cash">Cash on Delivery</label>
                                                   </center>
                                                
                                                
                                                
                                            </div>
                                            
                                            <button class="place-order">Place order</button>
                                            
                                        </div>
                                        
                                    </div>
                                </div>
                                
                            </div>
                        </form:form>
                        
                    </div>
                </div>
            </div>
        </div>
        <!-- Checkout Page End --> 
      
<%@ include file="footer.jsp" %>