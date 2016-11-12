<%@include file="init.jsp" %>

<%
String id = renderRequest.getParameter("id");
Classe classe = null;
String azione=null;
if(Validator.isNotNull(id)){
    classe = ClasseLocalServiceUtil.getClasse(Long.valueOf(id));
    azione = Constants.UPDATE;
}else{
	azione = Constants.ADD;
}
%>

<portlet:renderURL var="backClasse">
   <portlet:param name="jspPage" value="/html/quiz/view.jsp" />
</portlet:renderURL>

<liferay-ui:error key="error-edit-classe" message="error-edit-classe" />

<portlet:actionURL var="editClasse" name="editClasse" />


<aui:form  id="fmClasse" name="fmClasse" action="<%=editClasse %>" method="post" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "save();" %>' >
    <aui:input type="hidden" name="<%=Constants.CMD %>" />
	<aui:input name="descClasse" label="desc-classe" value="<%=Validator.isNotNull(classe)?classe.getDescClasse():\"\" %>" />
	<c:if test="<%=azione.equals(Constants.UPDATE) %>">
    	  <aui:input type="hidden" name="idClasse" value="<%=classe.getId() %>" />
    </c:if>
	<aui:button type="submit" value="save" />
	<aui:button name="go-back" value="go-back" href="<%=backClasse %>" />
</aui:form>
<aui:script>

function <portlet:namespace />save() {
		document.<portlet:namespace />fmClasse.<portlet:namespace /><%= Constants.CMD %>.value = "<%= azione %>";

		submitForm(document.<portlet:namespace />fmClasse);
	}
	
</aui:script>