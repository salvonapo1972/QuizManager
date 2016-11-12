<%@include file="init.jsp" %>

<portlet:renderURL var="addClass">
   <portlet:param name="jspPage" value="/html/quiz/editClasse.jsp" />
</portlet:renderURL>

<aui:nav-item dropdown="<%= true %>" id="addButtonContainer" label="add">
<aui:nav-item href="<%= addClass %>"  label='add-class' />
</aui:nav-item>