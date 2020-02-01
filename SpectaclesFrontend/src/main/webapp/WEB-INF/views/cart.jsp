<%@ include file="nav.jsp" %>

<script>

function add()
{
	var q=document.getElementById("qu").value;
	var p=document.getElementById("price").innerText;
	var t=p*q;
	document.getElementById("total").innerHTML=t;
	
}
</script>
<body >
        <!-- Cart Page Start -->
        <div class="cart_area pt--120 pb--80">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <form action="#">				
                            <!-- Cart Table -->
                            <div class="cart-table table-responsive mb--40">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th class="pro-thumbnail">Image</th>
                                            <th class="pro-title">Product</th>
                                            <th class="pro-price">Price</th>
                                            <th class="pro-quantity">Quantity</th>
                                            <th class="pro-subtotal">Total</th>
                                            <th class="pro-remove">Remove</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="car" items="${CartItems}">
                                        <tr>
                                            
                                            <td class="pro-thumbnail"><a href="#"><img src="${img}/product/${car.getProducts().getProductsId()}.jpg" alt="Product"></a></td>
                                            <td class="pro-title"><a href="#">${car.getProducts().getProductsName()}</a></td>
                                            <td class="pro-price"  id="price"><span>${car.getProducts().getPrice()}</span></td>
                                            <td class="pro-quantity"><div class="pro-qty" onclick="add()"> <input type="number" id="qu" value="1"></div></td>
                                            <td class="pro-subtotal"  id="total"><span>${car.getProducts().getPrice()}</span></td>
                                            <td class="pro-remove"><a href="<c:url value="/remove/cartitems/${car.getCartItemsId()}"/>"><i class="fa fa-trash-o"></i></a></td>
                                        </tr>
                                     </c:forEach>
                                        <tr>
                                        <td>${mess}</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            
                        </form>	
                            
                        <div class="row">

                            <div class="col-lg-6 col-12 mb--15">
                               
                               
                               
                            </div>

                            <!-- Cart Summary -->
                            <div class="col-lg-6 col-12 mb--40 d-flex">
                                <div class="cart-summary">
                                    <div class="cart-summary-wrap">
                                        <h4>Cart Summary</h4>                                        
                                        <h2>Grand Total <span>${cart.getGrandTotal()}</span></h2>                                  
                                    </div>
                                    <div class="cart-summary-button">
                                        <button class="checkout-btn"><a href="<c:url value="/checkout"/>">CHECKOUT</a></button>
                                        <button class="update-btn"><a href="<c:url value="/viewproducts"/>">Update Cart</a></button>
                                    </div>
                                </div>
                            </div>

                        </div>
                        
                    </div>
                </div>
            </div>
        </div>

        <!-- Cart Page End --> 
<%@ include file="footer.jsp" %>
        </body>