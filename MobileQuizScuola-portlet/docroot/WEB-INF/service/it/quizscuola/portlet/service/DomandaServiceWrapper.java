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

package it.quizscuola.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DomandaService}.
 *
 * @author Salvatore
 * @see DomandaService
 * @generated
 */
public class DomandaServiceWrapper implements DomandaService,
	ServiceWrapper<DomandaService> {
	public DomandaServiceWrapper(DomandaService domandaService) {
		_domandaService = domandaService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _domandaService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_domandaService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _domandaService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public it.quizscuola.portlet.model.Domanda addDomanda(
		com.liferay.portal.service.ServiceContext ctx,
		java.lang.String descDomanda, long idArgomento,
		java.util.List<it.quizscuola.portlet.model.Risposta> listaRisposte) {
		return _domandaService.addDomanda(ctx, descDomanda, idArgomento,
			listaRisposte);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getDomandaRisposte(
		long idArgomento, int posizione) {
		return _domandaService.getDomandaRisposte(idArgomento, posizione);
	}

	@Override
	public it.quizscuola.portlet.model.Domanda deleteDomanda(long idDomanda)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _domandaService.deleteDomanda(idDomanda);
	}

	@Override
	public it.quizscuola.portlet.model.Domanda updateDomanda(long idDomanda,
		java.lang.String descDomanda)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchDomandaException {
		return _domandaService.updateDomanda(idDomanda, descDomanda);
	}

	@Override
	public java.util.List<it.quizscuola.portlet.model.Domanda> getDomandas(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _domandaService.getDomandas(start, end, orderByComparator);
	}

	@Override
	public java.util.List<it.quizscuola.portlet.model.Domanda> getDomandasByArgomento(
		long idArgomento, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _domandaService.getDomandasByArgomento(idArgomento, start, end,
			orderByComparator);
	}

	@Override
	public int getDomandasByArgomentoCount(long idArgomento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _domandaService.getDomandasByArgomentoCount(idArgomento);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getNumDomandeByArgomento(
		long idArgomento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _domandaService.getNumDomandeByArgomento(idArgomento);
	}

	@Override
	public it.quizscuola.portlet.model.Domanda updateDomanda(
		com.liferay.portal.service.ServiceContext ctx, long idDomanda,
		java.lang.String descDomanda, long idArgomento,
		java.util.List<it.quizscuola.portlet.model.Risposta> listaRisposte) {
		return _domandaService.updateDomanda(ctx, idDomanda, descDomanda,
			idArgomento, listaRisposte);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DomandaService getWrappedDomandaService() {
		return _domandaService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDomandaService(DomandaService domandaService) {
		_domandaService = domandaService;
	}

	@Override
	public DomandaService getWrappedService() {
		return _domandaService;
	}

	@Override
	public void setWrappedService(DomandaService domandaService) {
		_domandaService = domandaService;
	}

	private DomandaService _domandaService;
}