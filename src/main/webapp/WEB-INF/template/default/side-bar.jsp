<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<!-- <input type="text" class="form-control" placeholder="Search"> -->
				<span class="glyphicon glyphicon-user"> Hi! : ${pageContext.request.userPrincipal.name} </span>
					
			</div>
		</form>
		<ul class="nav menu">
			<li class="active"><a href="index.html"><span class="glyphicon glyphicon-dashboard"></span> Dashboard</a></li>
			<!-- <li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-list"></span> Applications <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="applicationForGrant">
							<span class="glyphicon glyphicon-share-alt"></span> Application for grants
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"></span> Book for interviews
						</a>
					</li>
					<li>
						<a class="" href="#">
							<span class="glyphicon glyphicon-share-alt"></span> Download my L/A
						</a>
					</li>
				</ul>
			</li> -->
			<!-- <li><a href="downloadFormsForLA.do"><span class="glyphicon glyphicon-file"></span> Forms Download </a></li> -->
			
			
			<li class="parent ">
				<a href="#">
					<span class="glyphicon glyphicon-file"></span> Forms Download <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="glyphicon glyphicon-s glyphicon-plus"></em></span> 
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="downloadFormsForLA.do">
							<span class="glyphicon glyphicon-share-alt"></span> Letter of admin forms
						</a>
					</li>
					
				</ul>
			</li>
			
			<li><a href="myTransactions?username=${pageContext.request.userPrincipal.name}"><span class="glyphicon glyphicon-th-list"></span> My Transactions</a></li>
			
		<!-- 	<li role="presentation" class="divider"></li> -->
			<li><a href="login.html"><span class="glyphicon glyphicon-user"></span> Manage My Account</a></li>
			<li><a href="login.html"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
		</ul>
		<div class="attribution">Developed by <a href="http://www.mzcltd.com">MZCL</a></div>
	</div><!--/.sidebar-->