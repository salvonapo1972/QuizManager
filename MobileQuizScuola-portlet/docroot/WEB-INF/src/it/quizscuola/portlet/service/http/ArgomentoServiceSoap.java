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

package it.quizscuola.portlet.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.quizscuola.portlet.service.ArgomentoServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link it.quizscuola.portlet.service.ArgomentoServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link it.quizscuola.portlet.model.ArgomentoSoap}.
 * If the method in the service utility returns a
 * {@link it.quizscuola.portlet.model.Argomento}, that is translated to a
 * {@link it.quizscuola.portlet.model.ArgomentoSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Salvatore
 * @see ArgomentoServiceHttp
 * @see it.quizscuola.portlet.model.ArgomentoSoap
 * @see it.quizscuola.portlet.service.ArgomentoServiceUtil
 * @generated
 */
public class ArgomentoServiceSoap {
	public static it.quizscuola.portlet.model.ArgomentoSoap addArgomento(
		com.liferay.portal.service.ServiceContext ctx,
		java.lang.String descArgomento, long idMateria)
		throws RemoteException {
		try {
			it.quizscuola.portlet.model.Argomento returnValue = ArgomentoServiceUtil.addArgomento(ctx,
					descArgomento, idMateria);

			return it.quizscuola.portlet.model.ArgomentoSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.quizscuola.portlet.model.ArgomentoSoap[] getArgumentos(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws RemoteException {
		try {
			java.util.List<it.quizscuola.portlet.model.Argomento> returnValue = ArgomentoServiceUtil.getArgumentos(start,
					end, orderByComparator);

			return it.quizscuola.portlet.model.ArgomentoSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.quizscuola.portlet.model.ArgomentoSoap[] getArgomentiByMateria(
		long idMateria, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws RemoteException {
		try {
			java.util.List<it.quizscuola.portlet.model.Argomento> returnValue = ArgomentoServiceUtil.getArgomentiByMateria(idMateria,
					start, end, orderByComparator);

			return it.quizscuola.portlet.model.ArgomentoSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getArgomentiByMateriaCount(long idMateria)
		throws RemoteException {
		try {
			int returnValue = ArgomentoServiceUtil.getArgomentiByMateriaCount(idMateria);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getArgomentiCount() throws RemoteException {
		try {
			int returnValue = ArgomentoServiceUtil.getArgomentiCount();

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.quizscuola.portlet.model.ArgomentoSoap removeArgomento(
		long id) throws RemoteException {
		try {
			it.quizscuola.portlet.model.Argomento returnValue = ArgomentoServiceUtil.removeArgomento(id);

			return it.quizscuola.portlet.model.ArgomentoSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.quizscuola.portlet.model.ArgomentoSoap[] getArgomentos()
		throws RemoteException {
		try {
			java.util.List<it.quizscuola.portlet.model.Argomento> returnValue = ArgomentoServiceUtil.getArgomentos();

			return it.quizscuola.portlet.model.ArgomentoSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.quizscuola.portlet.model.ArgomentoSoap updateArgomento(
		long idArgomento, java.lang.String descArgomento)
		throws RemoteException {
		try {
			it.quizscuola.portlet.model.Argomento returnValue = ArgomentoServiceUtil.updateArgomento(idArgomento,
					descArgomento);

			return it.quizscuola.portlet.model.ArgomentoSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteDomandasByArgomento(long idUtente, long idArgomento)
		throws RemoteException {
		try {
			ArgomentoServiceUtil.deleteDomandasByArgomento(idUtente, idArgomento);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteDomandasERisposteByArgomento(long idArgomento)
		throws RemoteException {
		try {
			ArgomentoServiceUtil.deleteDomandasERisposteByArgomento(idArgomento);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getJSONListaArgomenti(long idMateria)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = ArgomentoServiceUtil.getJSONListaArgomenti(idMateria);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ArgomentoServiceSoap.class);
}