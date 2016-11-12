<%@page import="it.quizscuola.portlet.service.MateriaServiceUtil"%>

<%@include file="init.jsp" %>

<%String idClasse = renderRequest.getParameter("idClasse"); %>

<liferay-ui:error key="error-remove" message="error-remove" />

<portlet:renderURL var="addMateria">
   <portlet:param name="jspPage" value="/html/quiz/editMateria.jsp" />
   <portlet:param name="idClasse" value="<%=idClasse%>" />
</portlet:renderURL>

<portlet:renderURL var="backClasse">
   <portlet:param name="jspPage" value="/html/quiz/view.jsp" />
</portlet:renderURL>

<aui:nav-item dropdown="<%= true %>" id="addButtonContainer" label="add">
<aui:nav-item href="<%= addMateria %>"  label='add-materia' />
</aui:nav-item>

<aui:button name="go-back" value="go-back" href="<%=backClasse %>" />

<liferay-ui:search-container delta="10">


<liferay-ui:search-container-results results="<%=MateriaServiceUtil.getMateriasByClasse(Long.valueOf(idClasse),searchContainer.getStart(), searchContainer.getEnd(),searchContainer.getOrderByComparator()) %>" total="<%=MateriaServiceUtil.getMateriasByClasseCount(Long.valueOf(idClasse)) %>" />

<liferay-ui:search-container-row
		className="it.quizscuola.portlet.model.Materia"
		keyProperty="idMateria"
		modelVar="materia"
	>
	    <portlet:renderURL var="editMateria">
		   <portlet:param name="jspPage" value="/html/quiz/editMateria.jsp" />
		   <portlet:param name="id" value="<%=String.valueOf(materia.getIdMateria()) %>" />
		    <portlet:param name="idClasse" value="<%=idClasse%>" />
		</portlet:renderURL>
		
		<portlet:renderURL var="viewArgomento">
		   <portlet:param name="jspPage" value="/html/quiz/viewArgomento.jsp" />
		   <portlet:param name="idMateria" value="<%=String.valueOf(materia.getIdMateria()) %>" />
		   <portlet:param name="idClasse" value="<%=idClasse %>" />
		</portlet:renderURL>
		
		<portlet:actionURL name="deleteMateria" var="deleteMateria">
		   <portlet:param name="id" value="<%=String.valueOf(materia.getIdMateria()) %>" />
		    <portlet:param name="idClasse" value="<%=idClasse%>" />
		</portlet:actionURL>
		
		<liferay-ui:search-container-column-text
			name="id"
			value="<%= String.valueOf(materia.getIdMateria()) %>" href="<%=editMateria %>"
		/>

		<liferay-ui:search-container-column-text
			name="Descrizione"
			property="descMateria" href="<%=editMateria %>"
		/>
		
		<liferay-ui:search-container-column-text  name="AZIONI">
		<liferay-ui:icon-menu>

			<liferay-ui:icon image="edit" url="<%=editMateria.toString() %>" />
			<liferay-ui:icon image="view" label="view-argomento" message="view-argomento" url="<%=viewArgomento.toString() %>" />
			<liferay-ui:icon-delete image="delete" message="delete" confirmation="delete-mess" url="<%=deleteMateria.toString() %>" />
			
		</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>


<liferay-ui:search-iterator type="regular" />
</liferay-ui:search-container>