<%@ include file="common/header.jsp"%>
<div class="col-md-12">
	<div class="x_panel">
		<div class="x_title">
			<h2>App分类管理</h2>
			
			<div class="clearfix"></div>
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
			<!-- end project list -->

		</div>
	</div>
</div>

<%@ include file="common/footer.jsp"%>