/**
 * 批量删除方法
 */
function deleteBatch(basePath) {
	$("#mainForm").attr("action", basePath+"servlet/DeleteBatchServlet");
	$("#mainForm").submit();
}
/**
 * 调用后台删除单一记录的方法
 * @param basePath
 * @param id
 */
function deleteOne(basePath,id) {
	if(confirm("确定吗？")) {
		$("#mainForm").attr("action", basePath+"servlet/DeleteOneServlet?id="+id);
		$("#mainForm").submit();
	}
}