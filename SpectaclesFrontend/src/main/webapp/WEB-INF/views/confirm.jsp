<%@ include file="nav.jsp" %>


 <div class="cart-table table-responsive mb--40">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th class="pro-thumbnail">Image</th>
                                            <th class="pro-title">Product</th>
                                            <th class="pro-price">Price</th>
                                            <th class="pro-quantity">Quantity</th>
                                            <th class="pro-subtotal">Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="ord" items="${orderItems}">
                                        <tr>
                                            
                                            <td class="pro-thumbnail"><a href="#"><img src="${img}/product/${ord.getProductsId()}.jpg" alt="Product"></a></td>
                                            <td class="pro-title"><a href="#">${ord.getProducts().getProductsName()}</a></td>
                                            <td class="pro-price"><span>${ord.getProducts().getPrice()}</span></td>
                                            <td class="pro-price"><span>${ord.getProducts().getQuantity}</span></td>
                                            <td class="pro-subtotal"><span>$</span></td>
                                            
                                        </tr>
                                     </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                                    <div class="cart-summary-wrap">
                                        <h4>Cart Summary</h4>                                        
                                        <h2>Grand Total <span>${orders.getGrandTotal()}</span></h2>                                  
                                    </div>

<%@ include file="footer.jsp" %>