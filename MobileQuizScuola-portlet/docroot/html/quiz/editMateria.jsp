<%@page import="it.quizscuola.portlet.service.MateriaLocalServiceUtil"%>
<%@page import="it.quizscuola.portlet.model.Materia"%>
<%@include file="init.jsp" %>

<%
String id = renderRequest.getParameter("id");
Materia materia = null;
String azione=null;
String idClasse = renderRequest.getParameter("idClasse");
if(Validator.isNotNull(id)){
	materia = MateriaLocalServiceUtil.getMateria(Long.valueOf(id));
	azione = Constants.UPDATE;
}else{
	azione = Constants.ADD;
	
}

%>
<portlet:renderURL var="backMateria">
   <portlet:param name="jspPage" value="/html/quiz/viewMateria.jsp" />
    <portlet:param name="idClasse" value="<%=idClasse %>" />
</portlet:renderURL>

<liferay-ui:error key="error-edit-materia" message="error-edit-materia" />

<portlet:actionURL var="editMateria" name="editMateria" />

<aui:form  id="fmMateria" name="fmMateria" action="<%=editMateria %>" method="post" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "save();" %>' >
    <aui:input type="hidden" name="<%=Constants.CMD %>" />
    
    <aui:input type="hidden" name="idClasse" value="<%=idClasse %>" />
    <c:if test="<%=azione.equals(Constants.UPDATE) %>">
    	  <aui:input type="hidden" name="idMateria" value="<%=materia.getIdMateria() %>" />
    </c:if>
	<aui:input name="descMateria" label="desc-materia" value="<%=Validator.isNotNull(materia)?materia.getDescMateria():\"\" %>" />
	<aui:button type="submit" value="save" />
	<aui:button name="go-back" value="go-back" href="<%=backMateria %>" />
</aui:form>
<aui:script>

function <portlet:namespace />save() {
		document.<portlet:namespace />fmMateria.<portlet:namespace /><%= Constants.CMD %>.value = "<%= azione %>";

		submitForm(document.<portlet:namespace />fmMateria);
	}
	
</aui:script>