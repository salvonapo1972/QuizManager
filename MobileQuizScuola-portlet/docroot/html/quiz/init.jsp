<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"  %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"  %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="it.quizscuola.portlet.model.Classe"%>
<%@page import="it.quizscuola.portlet.service.ClasseLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="it.quizscuola.portlet.service.ClasseServiceUtil"%>

<%@page import="it.quizscuola.portlet.service.ArgomentoServiceUtil"%>
<%@page import="it.quizscuola.portlet.service.MateriaServiceUtil"%>

<portlet:defineObjects />
<theme:defineObjects />