<%@ include file="common/header.jsp"%>
<div class="col-md-12">
	<div class="x_panel">
		<div class="x_title">
			<h2 style="padding:0 500px 0 20px;">数据字典维护</h2>
			<form action="showDictionary.html" class="form-horizontal form-label-left">
				<div class="input-group">	
				<label>类型值Name：</label>
					<input type="text" name="valueName" class="btn btn-default" value="${valueName }">
						<button type="submit" class="btn btn-primary">查询</button>
					</span>
				</div>
		</div>
		</form>
	</div>
	<div class="x_content">

		<p>数据类型字典表维护，便于满足开发者更多的需求</p>

		<!-- start project list -->
		<table class="table table-striped projects">
			<thead>
				<tr>
					<th style="width: 1%"></th>
					<th style="width: 20%">类型编码</th>
					<th>类型名称</th>
					<th>类型值ID</th>
					<th>类型值Name</th>
					<th style="width: 20%">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dictionary" items="${dicList }">
					<tr>
						<td>${ dictionary.id}</td>
						<td>${dictionary.typeCode}</td>
						<td>${dictionary.typeName}
							</ul>
						</td>
						<td class="project_progress">${dictionary.valueId}</td>
						<td>${dictionary.valueName}</td>
						<td><a href="#" class="btn btn-info btn-xs"><i
								class="fa fa-pencil"></i> Edit </a> <a href="#"
							class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i>
								Delete </a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav aria-label="Page navigation">
			<ul class="pagination">
				<li><a
					href="${pageContext.request.contextPath }/sys/dic/showDictionary.html?currentPageNo=${page.currentPageNo-1}&valueName=${valueName }"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<c:forEach var="i" begin="1" end="${page.totalPageCount}">
					<li><a
						href="${pageContext.request.contextPath }/sys/dic/showDictionary.html?currentPageNo=${i }&valueName=${valueName }">${i }</a></li>
				</c:forEach>
				<li><a
					href="${pageContext.request.contextPath }/sys/dic/showDictionary.html?currentPageNo=${page.currentPageNo+1}&valueName=${valueName }"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div>
</div>
</div>
<%@ include file="common/footer.jsp"%>