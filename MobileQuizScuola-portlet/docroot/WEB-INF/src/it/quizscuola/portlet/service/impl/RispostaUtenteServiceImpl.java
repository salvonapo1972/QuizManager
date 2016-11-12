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

package it.quizscuola.portlet.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.service.ServiceContext;

import it.quizscuola.portlet.model.RispostaUtente;
import it.quizscuola.portlet.service.base.RispostaUtenteServiceBaseImpl;

/**
 * The implementation of the risposta utente remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.quizscuola.portlet.service.RispostaUtenteService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Salvatore
 * @see it.quizscuola.portlet.service.base.RispostaUtenteServiceBaseImpl
 * @see it.quizscuola.portlet.service.RispostaUtenteServiceUtil
 */
public class RispostaUtenteServiceImpl extends RispostaUtenteServiceBaseImpl {
	
	public RispostaUtente addRispostaUtente(ServiceContext ctx,long idRisposta,long idDomanda){
		return rispostaUtenteLocalService.addRispostaUtente(ctx, idRisposta, idDomanda);
	}
	
	public JSONObject addJSONRispostaUtente(long idUtente,long idRisposta,long idDomanda){
		return rispostaUtenteLocalService.addJSONRispostaUtente(idUtente, idRisposta, idDomanda);
	}
	
	public JSONObject  removeRispostaUtente(long idUtente) throws SystemException{
		return rispostaUtenteLocalService.removeRispostaUtente(idUtente);
	}
	
	public RispostaUtente getRispostaUtente(long idDomanda,long idUtente){
		return rispostaUtenteLocalService.getRispostaUtente(idDomanda, idUtente);
	}
}