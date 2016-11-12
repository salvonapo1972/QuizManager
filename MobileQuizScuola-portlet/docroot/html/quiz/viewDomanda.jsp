<%@page import="it.quizscuola.portlet.service.DomandaServiceUtil"%>
<%@include file="init.jsp" %>


<%String idClasse = renderRequest.getParameter("idClasse"); 
  String idMateria = renderRequest.getParameter("idMateria");
  String idArgomento = renderRequest.getParameter("idArgomento");
%>
<liferay-ui:error key="error-remove" message="error-remove" />

<liferay-portlet:renderURL varImpl="iterator">
       <portlet:param name="jspPage" value="/html/quiz/viewDomanda.jsp" />
</liferay-portlet:renderURL>


<portlet:renderURL var="addDomanda">
   <portlet:param name="jspPage" value="/html/quiz/editDomanda.jsp" />
   <portlet:param name="idClasse" value="<%=idClasse%>" />
   <portlet:param name="idMateria" value="<%=idMateria%>" />
   <portlet:param name="idArgomento" value="<%=idArgomento%>" />
</portlet:renderURL>

<portlet:renderURL var="backArgomento">
   <portlet:param name="jspPage" value="/html/quiz/viewArgomento.jsp" />
   <portlet:param name="idClasse" value="<%=idClasse%>" />
    <portlet:param name="idMateria" value="<%=idMateria%>" />
</portlet:renderURL>

<aui:nav-item dropdown="<%= true %>" id="addButtonContainer" label="add">
<aui:nav-item href="<%= addDomanda %>"  label='add-domanda' />
</aui:nav-item>

<aui:button name="go-back" value="go-back" href="<%=backArgomento %>" />

<liferay-ui:search-container emptyResultsMessage="there-are-no-questions" delta="20" iteratorURL="<%=iterator %>">


<liferay-ui:search-container-results results="<%=DomandaServiceUtil.getDomandasByArgomento(Long.valueOf(idArgomento),searchContainer.getStart(), searchContainer.getEnd(),searchContainer.getOrderByComparator()) %>" total="<%=DomandaServiceUtil.getDomandasByArgomentoCount(Long.valueOf(idArgomento)) %>" />
        <%
           System.out.println("start:" + searchContainer.getStart());
        System.out.println("end:" + searchContainer.getEnd());
           searchContainer.getIteratorURL().setParameter("idClasse",idClasse);
           searchContainer.getIteratorURL().setParameter("idMateria",idMateria);
           searchContainer.getIteratorURL().setParameter("idArgomento",idArgomento);
        %>
<liferay-ui:search-container-row
		className="it.quizscuola.portlet.model.Domanda"
		keyProperty="idDomanda"
		modelVar="domanda"
	>
	<portlet:renderURL var="editDomanda">
		   <portlet:param name="jspPage" value="/html/quiz/editDomanda.jsp" />
		   <portlet:param name="idDomanda" value="<%=String.valueOf(domanda.getIdDomanda()) %>" />
		   <portlet:param name="idClasse" value="<%=idClasse%>" />
		   <portlet:param name="idMateria" value="<%=idMateria%>" />
		   <portlet:param name="idArgomento" value="<%=idArgomento%>" />
		</portlet:renderURL>
		
		<portlet:actionURL name="deleteDomanda" var="deleteDomanda">
		   <portlet:param name="idDomanda" value="<%=String.valueOf(domanda.getIdDomanda()) %>" />
		   <portlet:param name="idClasse" value="<%=idClasse%>" />
           <portlet:param name="idMateria" value="<%=idMateria%>" />
           <portlet:param name="idArgomento" value="<%=idArgomento%>" />
		</portlet:actionURL>
		
		<liferay-ui:search-container-column-text
			name="id"
			value="<%= String.valueOf(domanda.getIdDomanda()) %>" href="<%=editDomanda %>"
		/>

		<liferay-ui:search-container-column-text
			name="Descrizione"
			property="descDomanda" href="<%=editDomanda %>"
		/>
		
		<liferay-ui:search-container-column-text  name="AZIONI">
		<liferay-ui:icon-menu>

			<liferay-ui:icon image="edit" url="<%=editDomanda.toString() %>" />
			
			<liferay-ui:icon-delete image="delete" message="delete" confirmation="delete-mess" url="<%=deleteDomanda.toString() %>" />
			
		</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>


<liferay-ui:search-iterator type="regular" searchContainer="<%=searchContainer %>" />
</liferay-ui:search-container>