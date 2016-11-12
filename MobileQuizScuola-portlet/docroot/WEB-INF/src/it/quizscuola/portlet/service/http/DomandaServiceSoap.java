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

import it.quizscuola.portlet.service.DomandaServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link it.quizscuola.portlet.service.DomandaServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link it.quizscuola.portlet.model.DomandaSoap}.
 * If the method in the service utility returns a
 * {@link it.quizscuola.portlet.model.Domanda}, that is translated to a
 * {@link it.quizscuola.portlet.model.DomandaSoap}. Methods that SOAP cannot
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
 * @see DomandaServiceHttp
 * @see it.quizscuola.portlet.model.DomandaSoap
 * @see it.quizscuola.portlet.service.DomandaServiceUtil
 * @generated
 */
public class DomandaServiceSoap {
	public static it.quizscuola.portlet.model.DomandaSoap addDomanda(
		com.liferay.portal.service.ServiceContext ctx,
		java.lang.String descDomanda, long idArgomento,
		it.quizscuola.portlet.model.RispostaSoap[] listaRisposte)
		throws RemoteException {
		try {
			it.quizscuola.portlet.model.Domanda returnValue = DomandaServiceUtil.addDomanda(ctx,
					descDomanda, idArgomento,
					it.quizscuola.portlet.model.impl.RispostaModelImpl.toModels(
						listaRisposte));

			return it.quizscuola.portlet.model.DomandaSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getDomandaRisposte(long idArgomento,
		int posizione) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = DomandaServiceUtil.getDomandaRisposte(idArgomento,
					posizione);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.quizscuola.portlet.model.DomandaSoap deleteDomanda(
		long idDomanda) throws RemoteException {
		try {
			it.quizscuola.portlet.model.Domanda returnValue = DomandaServiceUtil.deleteDomanda(idDomanda);

			return it.quizscuola.portlet.model.DomandaSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.quizscuola.portlet.model.DomandaSoap updateDomanda(
		long idDomanda, java.lang.String descDomanda) throws RemoteException {
		try {
			it.quizscuola.portlet.model.Domanda returnValue = DomandaServiceUtil.updateDomanda(idDomanda,
					descDomanda);

			return it.quizscuola.portlet.model.DomandaSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.quizscuola.portlet.model.DomandaSoap[] getDomandas(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws RemoteException {
		try {
			java.util.List<it.quizscuola.portlet.model.Domanda> returnValue = DomandaServiceUtil.getDomandas(start,
					end, orderByComparator);

			return it.quizscuola.portlet.model.DomandaSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.quizscuola.portlet.model.DomandaSoap[] getDomandasByArgomento(
		long idArgomento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws RemoteException {
		try {
			java.util.List<it.quizscuola.portlet.model.Domanda> returnValue = DomandaServiceUtil.getDomandasByArgomento(idArgomento,
					start, end, orderByComparator);

			return it.quizscuola.portlet.model.DomandaSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getDomandasByArgomentoCount(long idArgomento)
		throws RemoteException {
		try {
			int returnValue = DomandaServiceUtil.getDomandasByArgomentoCount(idArgomento);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getNumDomandeByArgomento(long idArgomento)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = DomandaServiceUtil.getNumDomandeByArgomento(idArgomento);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.quizscuola.portlet.model.DomandaSoap updateDomanda(
		com.liferay.portal.service.ServiceContext ctx, long idDomanda,
		java.lang.String descDomanda, long idArgomento,
		it.quizscuola.portlet.model.RispostaSoap[] listaRisposte)
		throws RemoteException {
		try {
			it.quizscuola.portlet.model.Domanda returnValue = DomandaServiceUtil.updateDomanda(ctx,
					idDomanda, descDomanda, idArgomento,
					it.quizscuola.portlet.model.impl.RispostaModelImpl.toModels(
						listaRisposte));

			return it.quizscuola.portlet.model.DomandaSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(DomandaServiceSoap.class);
}