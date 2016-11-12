<%@include file="init.jsp" %>

<%String idClasse = renderRequest.getParameter("idClasse"); 
  String idMateria = renderRequest.getParameter("idMateria");
%>
<liferay-ui:error key="error-remove" message="error-remove" />

<portlet:renderURL var="addArgomento">
   <portlet:param name="jspPage" value="/html/quiz/editArgomento.jsp" />
   <portlet:param name="idClasse" value="<%=idClasse%>" />
   <portlet:param name="idMateria" value="<%=idMateria%>" />
</portlet:renderURL>

<portlet:renderURL var="backMateria">
   <portlet:param name="jspPage" value="/html/quiz/viewMateria.jsp" />
   <portlet:param name="idClasse" value="<%=idClasse%>" />
</portlet:renderURL>

<aui:nav-item dropdown="<%= true %>" id="addButtonContainer" label="add">
<aui:nav-item href="<%= addArgomento %>"  label='add-argomento' />
</aui:nav-item>

<aui:button name="go-back" value="go-back" href="<%=backMateria %>" />

<liferay-ui:search-container delta="10">


<liferay-ui:search-container-results results="<%=ArgomentoServiceUtil.getArgomentiByMateria(Long.valueOf(idMateria),searchContainer.getStart(), searchContainer.getEnd(),searchContainer.getOrderByComparator()) %>" total="<%=ArgomentoServiceUtil.getArgomentiByMateriaCount(Long.valueOf(idMateria)) %>" />

<liferay-ui:search-container-row
		className="it.quizscuola.portlet.model.Argomento"
		keyProperty="idArgomento"
		modelVar="argomento"
	>
	<portlet:renderURL var="editArgomento">
		   <portlet:param name="jspPage" value="/html/quiz/editArgomento.jsp" />
		   <portlet:param name="idArgomento" value="<%=String.valueOf(argomento.getIdArgomento()) %>" />
		    <portlet:param name="idClasse" value="<%=idClasse%>" />
		    <portlet:param name="idMateria" value="<%=idMateria%>" />
		</portlet:renderURL>
		
		<portlet:actionURL name="deleteArgomento" var="deleteArgomento">
		   <portlet:param name="idArgomento" value="<%=String.valueOf(argomento.getIdArgomento()) %>" />
		   <portlet:param name="idClasse" value="<%=idClasse%>" />
           <portlet:param name="idMateria" value="<%=idMateria%>" />
		</portlet:actionURL>
		
		<portlet:renderURL var="viewDomanda">
		   <portlet:param name="jspPage" value="/html/quiz/viewDomanda.jsp" />
		   <portlet:param name="idMateria" value="<%=idMateria %>" />
		   <portlet:param name="idClasse" value="<%=idClasse %>" />
		   <portlet:param name="idArgomento" value="<%=String.valueOf(argomento.getIdArgomento()) %>" />
		</portlet:renderURL>
		
		<liferay-ui:search-container-column-text
			name="id"
			value="<%= String.valueOf(argomento.getIdArgomento()) %>" href="<%=editArgomento %>"
		/>

		<liferay-ui:search-container-column-text
			name="Descrizione"
			property="descArgomento" href="<%=editArgomento %>"
		/>
		
		<liferay-ui:search-container-column-text  name="AZIONI">
		<liferay-ui:icon-menu>

			<liferay-ui:icon image="edit" url="<%=editArgomento.toString() %>" />
			<liferay-ui:icon image="view" label="view-domanda" message="view-domanda" url="<%=viewDomanda.toString() %>" />
			<liferay-ui:icon-delete image="delete" message="delete" confirmation="delete-mess" url="<%=deleteArgomento.toString() %>" />
			
		</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>


<liferay-ui:search-iterator type="regular" />
</liferay-ui:search-container>