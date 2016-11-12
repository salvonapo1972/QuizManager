/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.quizscuola.portlet.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import it.quizscuola.portlet.service.ArgomentoLocalServiceUtil;
import it.quizscuola.portlet.service.ArgomentoServiceUtil;
import it.quizscuola.portlet.service.ClasseLocalServiceUtil;
import it.quizscuola.portlet.service.ClasseServiceUtil;
import it.quizscuola.portlet.service.ClpSerializer;
import it.quizscuola.portlet.service.DomandaLocalServiceUtil;
import it.quizscuola.portlet.service.DomandaServiceUtil;
import it.quizscuola.portlet.service.MateriaLocalServiceUtil;
import it.quizscuola.portlet.service.MateriaServiceUtil;
import it.quizscuola.portlet.service.RispostaLocalServiceUtil;
import it.quizscuola.portlet.service.RispostaServiceUtil;
import it.quizscuola.portlet.service.RispostaUtenteLocalServiceUtil;
import it.quizscuola.portlet.service.RispostaUtenteServiceUtil;

/**
 * @author Salvatore
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			ArgomentoLocalServiceUtil.clearService();

			ArgomentoServiceUtil.clearService();
			ClasseLocalServiceUtil.clearService();

			ClasseServiceUtil.clearService();
			DomandaLocalServiceUtil.clearService();

			DomandaServiceUtil.clearService();
			MateriaLocalServiceUtil.clearService();

			MateriaServiceUtil.clearService();
			RispostaLocalServiceUtil.clearService();

			RispostaServiceUtil.clearService();
			RispostaUtenteLocalServiceUtil.clearService();

			RispostaUtenteServiceUtil.clearService();
		}
	}
}