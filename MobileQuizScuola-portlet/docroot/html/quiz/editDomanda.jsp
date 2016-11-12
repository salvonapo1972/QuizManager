<%@page import="it.quizscuola.portlet.model.Risposta"%>
<%@page import="java.util.List"%>
<%@page import="it.quizscuola.portlet.service.DomandaServiceUtil"%>
<%@page import="it.quizscuola.portlet.service.RispostaServiceUtil"%>
<%@page import="it.quizscuola.portlet.service.DomandaLocalServiceUtil"%>
<%@page import="it.quizscuola.portlet.model.Domanda"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.WindowState"%>
<%@include file="init.jsp" %>

<%
String idClasse = renderRequest.getParameter("idClasse"); 
String idMateria = renderRequest.getParameter("idMateria");
String idArgomento = renderRequest.getParameter("idArgomento");
String idDomanda = renderRequest.getParameter("idDomanda");
Domanda domanda = null;
String cmd = Constants.ADD;
List<Risposta> listaRisp=null;
if(Validator.isNotNull(idDomanda)){
	domanda = DomandaLocalServiceUtil.getDomanda(Long.valueOf(idDomanda));
	//RispostaServiceUtil.
	listaRisp = RispostaServiceUtil.getRispostas(Long.valueOf(idDomanda));
	cmd = Constants.UPDATE;
}
%>

<portlet:renderURL var="backDomanda">
   <portlet:param name="jspPage" value="/html/quiz/viewDomanda.jsp" />
    <portlet:param name="idClasse" value="<%=idClasse %>" />
    <portlet:param name="idMateria" value="<%=idMateria %>" />
    <portlet:param name="idArgomento" value="<%=idArgomento %>" />
</portlet:renderURL>

<liferay-ui:error key="error-edit-domanda" message="error-edit-domanda" />

<portlet:actionURL var="editDomanda" windowState="<%= WindowState.NORMAL.toString()%>">
  <portlet:param name="<%=ActionRequest.ACTION_NAME%>" value="editDomanda" />
</portlet:actionURL>
<h3>Domanda</h3>


<aui:form action="<%=editDomanda%>" method="post" name="LiferayAutoFieldForm">
   <aui:input name="cmd" type="hidden" value="<%=cmd %>" />
   <aui:fieldset id="domanda">
  		<aui:input type="textarea" label="domanda" name="domanda" value="<%=Validator.isNotNull(domanda)?domanda.getDescDomanda():\"\" %>" />
  </aui:fieldset>
  <aui:input name="idArgomento" type="hidden" value="<%=idArgomento %>" />
  <aui:input name="idClasse" type="hidden" value="<%=idClasse %>" />
  <aui:input name="idMateria" type="hidden" value="<%=idMateria %>" />
   
  <aui:fieldset id="risposte">
  <div id="new-fields">

    
      
        <%if(Validator.isNull(domanda)){ %>
        <div class="lfr-form-row lfr-form-row-inline">
        <div class="row-fields">
        <aui:input inlineField="true" fieldParam='field0' id='0' name="field0" label="answer" />
        <aui:input inlineField="true" type="checkbox" id="fieldTypeId0" name="fieldTypeId0" label="esatta" />
        <%}else{
        	
            int cont=0;
        	for(Risposta risp:listaRisp){
        	  String fieldParam = "field" + cont;
        	  String id = String.valueOf(cont);
        	  String fieldTypeId = "fieldTypeId" + cont;
        	  String fieldIdHiddenRisposta = "fieldHidden" + cont;
        	%>
        	 <aui:input name="idDomanda" type="hidden" value="<%=idDomanda %>" />
        	<div class="lfr-form-row lfr-form-row-inline">
            <div class="row-fields">
	            <aui:input inlineField="true" fieldParam='<%=fieldParam %>' id='<%=String.valueOf(cont) %>' value="<%=risp.getDescRisposta() %>" name="<%=fieldParam %>" label="answer" />
	            <aui:input inlineField="true" type="checkbox" id="<%=fieldTypeId %>" name="<%=fieldTypeId %>" label="esatta" checked="<%=risp.getEsatta() %>" />
	            <aui:input  type="hidden" id="<%=fieldIdHiddenRisposta %>" name="<%=fieldIdHiddenRisposta %>" value="<%=risp.getIdRisposta() %>"   />
	            <br>
            </div>
            </div>
           <%cont++;
             }
        	} %>
      </div>
    </div>
  </div>
  </aui:fieldset>
  <aui:layout>
    <aui:column>
      <aui:button type="submit" value="save" name="saveQuestions"
        onClick="saveData();"></aui:button>
        <aui:button name="go-back" value="go-back" href="<%=backDomanda %>" />
    </aui:column>
  </aui:layout>
<aui:script use="liferay-auto-fields">
 new Liferay.AutoFields(
       {
           contentBox: '#new-fields',
           fieldIndexes: '<portlet:namespace />responseIndexes'
       }
   ).render();
</aui:script>
</aui:form>