<% 
String Base_url2 = request.getContextPath()+"/";
%>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>-->
<script src="<%=Base_url2%>resourses/adm/js/jquery.min.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<%=Base_url2%>resourses/adm/js/bootstrap.min.js"></script>
					
 
<script src="<%=Base_url2%>resourses/adm/js/bootstrap-table.min.js"></script>
<script src="<%=Base_url2%>resourses/adm/js/bootstrap-table-pt-BR.min.js"></script>

<script src="<%=Base_url2%>resourses/adm/js/tableExport.js"></script>
<script src="<%=Base_url2%>resourses/adm/js/bootstrap-table-export.js"></script>

<script src="<%=Base_url2%>resourses/adm/js/Jquery.form.js"></script>  

<script src="<%=Base_url2%>resourses/adm/js/jquery.mask.min.js"></script>

<script src="<%=Base_url2%>resourses/adm/js/date.js"></script>

<script src="<%=Base_url2%>resourses/adm/js/Geral.js"></script>
<% 

String currentPage2 = request.getRequestURI();
String[] pastas2 = currentPage2.split("/");	

String arquivoUrl2 = pastas2[pastas2.length - 1];
String arquivoImportar2 = "";
if(arquivoUrl2.length()> 4){
	arquivoImportar2 = arquivoUrl2.substring(0,arquivoUrl2.length()- 4);
}

out.println("<script src=\""+ Base_url2 +"resourses/adm/js/"+ arquivoImportar2 +".js\"></script>");

%>