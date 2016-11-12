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
 * Provides a wrapper for {@link RispostaService}.
 *
 * @author Salvatore
 * @see RispostaService
 * @generated
 */
public class RispostaServiceWrapper implements RispostaService,
	ServiceWrapper<RispostaService> {
	public RispostaServiceWrapper(RispostaService rispostaService) {
		_rispostaService = rispostaService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _rispostaService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_rispostaService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _rispostaService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public it.quizscuola.portlet.model.Risposta addRisposta(
		com.liferay.portal.service.ServiceContext ctx,
		java.lang.String descRisposta, boolean esatta, long idDomanda) {
		return _rispostaService.addRisposta(ctx, descRisposta, esatta, idDomanda);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getRisultati(
		long idUtente, long idArgomento) {
		return _rispostaService.getRisultati(idUtente, idArgomento);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getRisultatiDomande(
		long idUtente, long idArgomento) {
		return _rispostaService.getRisultatiDomande(idUtente, idArgomento);
	}

	@Override
	public java.util.List<it.quizscuola.portlet.model.Risposta> getRispostas(
		long idDomanda)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rispostaService.getRispostas(idDomanda);
	}

	@Override
	public it.quizscuola.portlet.model.Risposta updateRisposta(
		com.liferay.portal.service.ServiceContext ctx, long idDomanda,
		long idRisposta, java.lang.String descRisposta, boolean esatta)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchRispostaException {
		return _rispostaService.updateRisposta(ctx, idDomanda, idRisposta,
			descRisposta, esatta);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RispostaService getWrappedRispostaService() {
		return _rispostaService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRispostaService(RispostaService rispostaService) {
		_rispostaService = rispostaService;
	}

	@Override
	public RispostaService getWrappedService() {
		return _rispostaService;
	}

	@Override
	public void setWrappedService(RispostaService rispostaService) {
		_rispostaService = rispostaService;
	}

	private RispostaService _rispostaService;
}