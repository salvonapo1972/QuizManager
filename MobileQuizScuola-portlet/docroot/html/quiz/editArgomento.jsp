<%@page import="it.quizscuola.portlet.service.ArgomentoLocalServiceUtil"%>
<%@page import="it.quizscuola.portlet.model.Argomento"%>
<%@page import="it.quizscuola.portlet.service.MateriaLocalServiceUtil"%>
<%@page import="it.quizscuola.portlet.model.Materia"%>
<%@include file="init.jsp" %>

<%
String id = renderRequest.getParameter("idArgomento");
Argomento argomento = null;
String azione=null;
String idClasse = renderRequest.getParameter("idClasse");
String idMateria = renderRequest.getParameter("idMateria");
if(Validator.isNotNull(id)){
	argomento = ArgomentoLocalServiceUtil.getArgomento(Long.valueOf(id));
	azione = Constants.UPDATE;
}else{
	azione = Constants.ADD;
	
}

%>
<portlet:renderURL var="backArgomento">
   <portlet:param name="jspPage" value="/html/quiz/viewArgomento.jsp" />
    <portlet:param name="idClasse" value="<%=idClasse %>" />
    <portlet:param name="idMateria" value="<%=idMateria %>" />
</portlet:renderURL>

<liferay-ui:error key="error-edit-argomento" message="error-edit-argomento" />

<portlet:actionURL var="editArgomento" name="editArgomento" />

<aui:form  id="fmArgomento" name="fmArgomento" action="<%=editArgomento %>" method="post" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "save();" %>' >
    <aui:input type="hidden" name="<%=Constants.CMD %>" />
    
    <aui:input type="hidden" name="idMateria" value="<%=idMateria %>" />
    <aui:input type="hidden" name="idClasse" value="<%=idClasse %>" />
    <c:if test="<%=azione.equals(Constants.UPDATE) %>">
    	  <aui:input type="hidden" name="idArgomento" value="<%=argomento.getIdArgomento() %>" />
    </c:if>
	<aui:input name="descArgomento" label="desc-argomento" value="<%=Validator.isNotNull(argomento)?argomento.getDescArgomento():\"\" %>" />
	<aui:button type="submit" value="save" />
	<aui:button name="go-back" value="go-back" href="<%=backArgomento %>" />
</aui:form>
<aui:script>

function <portlet:namespace />save() {
		document.<portlet:namespace />fmArgomento.<portlet:namespace /><%= Constants.CMD %>.value = "<%= azione %>";

		submitForm(document.<portlet:namespace />fmArgomento);
	}
	
</aui:script>