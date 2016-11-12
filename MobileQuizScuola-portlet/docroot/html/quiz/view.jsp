<%@include file="init.jsp" %>


<liferay-ui:error key="error-remove" message="error-remove" />


<portlet:renderURL var="addClass">
   <portlet:param name="jspPage" value="/html/quiz/editClasse.jsp" />
</portlet:renderURL>

<aui:nav-item dropdown="<%= true %>" id="addButtonContainer" label="add">
<aui:nav-item href="<%= addClass %>"  label='add-class' />
</aui:nav-item>

<liferay-ui:search-container delta="10">
<liferay-ui:search-container-results results="<%=ClasseServiceUtil.getClasses(searchContainer.getStart(), searchContainer.getEnd(),searchContainer.getOrderByComparator()) %>" total="<%=ClasseServiceUtil.getClasseCount() %>" />

<liferay-ui:search-container-row
		className="it.quizscuola.portlet.model.Classe"
		keyProperty="id"
		modelVar="classe"
	>
	    <portlet:renderURL var="editClasse">
		   <portlet:param name="jspPage" value="/html/quiz/editClasse.jsp" />
		   <portlet:param name="id" value="<%=String.valueOf(classe.getId()) %>" />
		</portlet:renderURL>
		
		<portlet:actionURL name="deleteClasse" var="deleteClasse">
		   <portlet:param name="id" value="<%=String.valueOf(classe.getId()) %>" />
		</portlet:actionURL>
		 <portlet:renderURL var="viewMateria">
		   <portlet:param name="jspPage" value="/html/quiz/viewMateria.jsp" />
		   <portlet:param name="idClasse" value="<%=String.valueOf(classe.getId()) %>" />
		</portlet:renderURL>
		
		<liferay-ui:search-container-column-text
			name="id"
			value="<%= String.valueOf(classe.getId()) %>" href="<%=editClasse %>"
		/>

		<liferay-ui:search-container-column-text
			name="Descrizione"
			property="descClasse" href="<%=editClasse %>"
		/>
		
		<liferay-ui:search-container-column-text  name="AZIONI">
		<liferay-ui:icon-menu>

			<liferay-ui:icon image="edit" url="<%=editClasse.toString() %>" />
			
			<liferay-ui:icon-delete image="delete" message="Elimina" confirmation="delete-mess" url="<%=deleteClasse.toString() %>" />
			<liferay-ui:icon image="view" label="view-materia" message="view-materia" url="<%=viewMateria.toString() %>" />
		</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>


<liferay-ui:search-iterator type="regular" />
</liferay-ui:search-container>