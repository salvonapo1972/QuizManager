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

import it.quizscuola.portlet.service.MateriaServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link it.quizscuola.portlet.service.MateriaServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link it.quizscuola.portlet.model.MateriaSoap}.
 * If the method in the service utility returns a
 * {@link it.quizscuola.portlet.model.Materia}, that is translated to a
 * {@link it.quizscuola.portlet.model.MateriaSoap}. Methods that SOAP cannot
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
 * @see MateriaServiceHttp
 * @see it.quizscuola.portlet.model.MateriaSoap
 * @see it.quizscuola.portlet.service.MateriaServiceUtil
 * @generated
 */
public class MateriaServiceSoap {
	public static it.quizscuola.portlet.model.MateriaSoap addMateria(
		com.liferay.portal.service.ServiceContext ctx,
		java.lang.String descMateria, long idClasse) throws RemoteException {
		try {
			it.quizscuola.portlet.model.Materia returnValue = MateriaServiceUtil.addMateria(ctx,
					descMateria, idClasse);

			return it.quizscuola.portlet.model.MateriaSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.quizscuola.portlet.model.MateriaSoap[] getMaterias(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws RemoteException {
		try {
			java.util.List<it.quizscuola.portlet.model.Materia> returnValue = MateriaServiceUtil.getMaterias(start,
					end, orderByComparator);

			return it.quizscuola.portlet.model.MateriaSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.quizscuola.portlet.model.MateriaSoap[] getMateriasByClasse(
		long idClasse, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws RemoteException {
		try {
			java.util.List<it.quizscuola.portlet.model.Materia> returnValue = MateriaServiceUtil.getMateriasByClasse(idClasse,
					start, end, orderByComparator);

			return it.quizscuola.portlet.model.MateriaSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getMateriasByClasseCount(long idClasse)
		throws RemoteException {
		try {
			int returnValue = MateriaServiceUtil.getMateriasByClasseCount(idClasse);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getMateriasCount() throws RemoteException {
		try {
			int returnValue = MateriaServiceUtil.getMateriasCount();

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.quizscuola.portlet.model.MateriaSoap removeMateria(long id)
		throws RemoteException {
		try {
			it.quizscuola.portlet.model.Materia returnValue = MateriaServiceUtil.removeMateria(id);

			return it.quizscuola.portlet.model.MateriaSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteMateriaByIdMateria(long idMateria)
		throws RemoteException {
		try {
			MateriaServiceUtil.deleteMateriaByIdMateria(idMateria);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.quizscuola.portlet.model.MateriaSoap[] getClasses()
		throws RemoteException {
		try {
			java.util.List<it.quizscuola.portlet.model.Materia> returnValue = MateriaServiceUtil.getClasses();

			return it.quizscuola.portlet.model.MateriaSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.quizscuola.portlet.model.MateriaSoap updateMateria(
		long idMateria, java.lang.String descMateria) throws RemoteException {
		try {
			it.quizscuola.portlet.model.Materia returnValue = MateriaServiceUtil.updateMateria(idMateria,
					descMateria);

			return it.quizscuola.portlet.model.MateriaSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getJSONListaMateria(long idClasse)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = MateriaServiceUtil.getJSONListaMateria(idClasse);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(MateriaServiceSoap.class);
}