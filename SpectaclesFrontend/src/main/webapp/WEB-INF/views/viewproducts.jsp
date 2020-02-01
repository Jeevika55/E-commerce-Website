<%@ include file="nav.jsp" %>

<!-- Start Shop Area -->
        <div class="shop_area section-ptb-xl bg--white">
            <div class="container">
                <div class="row">

                    <div class="col-lg-3 col-12 order-2 order-lg-1 sm-mt--30 md-mt--30">
                        <div class="shop_sidebar">
                            <!-- Start Single Wedget -->
                            <div class="sidebar_widget search mb--60">
                                <h2 class="sidebar_title">Search</h2>
                                <div class="sidebar_search">
                                    <form action="#">
                                        <input type="text" placeholder="Search for:">
                                        <button type="submit"><i class="ti-search"></i></button>
                                    </form>
                                </div>
                            </div>
                            <!-- End Single Wedget -->

                            <!-- Start Single Wedget -->
                            <div class="sidebar_widget widget_price_filter mb--60">
								<h2 class="sidebar_title">Filter</h2>
								

                                <div class="sidebar_filter">
									<div class="nstSlider" data-range_min="0" data-range_max="100" data-cur_min="10"    data-cur_max="80">
										<div class="bar"></div>
										<div class="leftGrip"></div>
										<div class="rightGrip"></div>
									</div>
									<div class="leftLabel"></div>
									<div class="rightLabel"></div>

								</div>
								


								
                            </div>
                            <!-- End Single Wedget -->

                            <!-- Start Single Wedget -->
                            <div class="sidebar_widget widget_categories mb--60">
                                <h2 class="sidebar_title">Categories</h2>
                                <ul class="sidebar_categories">
                                <li><a href="#">All <span>(01)</span></a></li>
                                <c:forEach var="cat" items="${categories}">
                                    <li><a href="<c:url value="/viewproducts/${cat.getCatId()}"/>" >${cat.getCatName()}</a></li>
                                </c:forEach>
                                </ul>
                            </div>
                            <!-- End Single Wedget -->
                        </div>
					</div>
					
                    <div class="col-lg-9 col-12 order-1 order-lg-2">
						<div class="shop_product_area">
							<div class="shop-bar-area">
								<div class="shop-filter-tab">
									<div class="view_mode justify-content-center nav" role="tablist">
										<a class="active" href="#tab1" data-toggle="tab"> <i class="ti-layout-grid4-alt"></i></a>
										<a class="" href="#tab2" data-toggle="tab"><i class="ti-list"></i></a>
									</div>
								</div>
								<div class="shop-found-selector">
									<p>Showing results</p>
									<select>
										<option>Sort by popularity</option>
										<option>Sort by average rating</option>
										<option>Sort by newness</option>
										<option>Sort by price: low to high</option>
										<option>Sort by price: high to low</option>
									</select>
								</div>
							</div>
                        <c:forEach var="cat" items="${categories}">
							<a href="<c:url value="/viewproducts/${cat.getCatId()}"/>" >${cat.getCatName()}</a>
						</c:forEach>
							<div class="tab_content">

								<div class="row single_grid_product tab-pane fade show active" id="tab1" role="tabpanel">
								
								
									<!-- Start Single Product -->
									<c:forEach var="prod" items="${productss}">
									<div class="col-lg-6 col-xl-4 col-sm-6 col-12">
										<div class="product">
											<div class="thumb">
												<a href="single-product.html">
													<img src="${img}/product/${prod.getProductsId()}.jpg" alt="product img">
												</a>
												<div class="product_action">
													<h4><a href="<c:url value="/viewproducts/${prod.getProductsId()}"/>" >${prod.getProductsName()}</a></h4>
													<ul class="cart_action">
														<li><a href="<c:url value="/add/To/cart/${prod.getProductsId()}"/>"><img src="${img}/icons/add_to_cart.png" alt="icons"></a></li>
														<li><a href="#"><img src="${img}/icons/compare_icon.png" alt="icons"></a></li>
														<li><a href="wishlist.html"><img src="${img}/icons/wishlist_icon.png" alt="icons"></a></li>
														<li><a title="Quick View" class="quickview" href="#"><img src="${img}/icons/quick_view.png" alt="icons"></a></li>
													</ul>
												</div>
												<div class="content">
													<h4><a href="<c:url value="/viewproducts/${prod.getProductsId()}"/>" >${prod.getProductsName()}</a></h4>
													<ul class="price">
														<li>${prod.getPrice()}</li>
													</ul>
												</div>
											</div>
										</div>
									</div>
									</c:forEach>
									<!-- End Single Product -->
									
								</div>
							</div>
<!-- 							<ul class="pagination_style"> -->
<!-- 								<li><a class="active" href="#">1</a></li> -->
<!-- 								<li><a href="#">2</a></li> -->
<!-- 								<li><a href="#"><i class="ti-angle-right"></i></a></li> -->
<!-- 							</ul> -->
						</div>
					</div>

				</div>
				
            </div>
        </div>
        <!-- End Shop Area -->



<%@ include file="footer.jsp" %>