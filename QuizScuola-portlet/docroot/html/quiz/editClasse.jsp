<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="it.quizscuola.portlet.model.Classe"%>
<%@page import="it.quizscuola.portlet.service.ClasseLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@include file="init.jsp" %>

<%
String id = renderRequest.getParameter("id");
Classe classe = null;
if(Validator.isNotNull(id)){
    classe = ClasseLocalServiceUtil.getClasse(Long.valueOf(id));
}
%>

<portlet:actionURL var="editClasse" name="editClasse" />

<aui:form name="fmClasse" action="<%=editClasse %>" method="post" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "save();" %>' >
	<aui:input name="descClasse"  />
	<aui:button type="submit" value="save" />
</aui:form>
<aui:script>

function <portlet:namespace />save() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (classe == null) ? Constants.ADD : Constants.UPDATE %>";

		submitForm(document.<portlet:namespace />fm);
	}
	
</aui:script>