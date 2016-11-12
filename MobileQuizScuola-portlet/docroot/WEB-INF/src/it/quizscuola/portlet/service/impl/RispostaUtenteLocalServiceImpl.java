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

import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.service.ServiceContext;

import it.quizscuola.portlet.model.Risposta;
import it.quizscuola.portlet.model.RispostaUtente;
import it.quizscuola.portlet.service.base.RispostaUtenteLocalServiceBaseImpl;

/**
 * The implementation of the risposta utente local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.quizscuola.portlet.service.RispostaUtenteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Salvatore
 * @see it.quizscuola.portlet.service.base.RispostaUtenteLocalServiceBaseImpl
 * @see it.quizscuola.portlet.service.RispostaUtenteLocalServiceUtil
 */
public class RispostaUtenteLocalServiceImpl
	extends RispostaUtenteLocalServiceBaseImpl {
	
	public RispostaUtente addRispostaUtente(ServiceContext ctx,long idRisposta,long idDomanda){
		RispostaUtente rispostaUtente = null;
		try{
			rispostaUtente = rispostaUtenteLocalService.createRispostaUtente(CounterLocalServiceUtil.increment(RispostaUtente.class.getName()));
			rispostaUtente.setDataRisposta(new Date());
			rispostaUtente.setIdRisposta(idRisposta);
			rispostaUtente.setIdUtente(ctx.getUserId());
			rispostaUtente = rispostaUtentePersistence.update(rispostaUtente);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return rispostaUtente;
	}
	
	public JSONObject  removeRispostaUtente(long idUtente) throws SystemException{
		List<RispostaUtente> listaRispUtente = rispostaUtentePersistence.findByIdUtente(idUtente);
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		try{
			for(RispostaUtente risp : listaRispUtente){
				rispostaUtentePersistence.remove(risp);
			}
			jsonObject.put("esito", "OK");
		}catch(Exception ex){
			jsonObject.put("esito", "KO");
		}
		return jsonObject;
	}
	
	public RispostaUtente getRispostaUtente(long idDomanda,long idUtente){
		RispostaUtente rispUtente=null;
		try{
			rispUtente = rispostaUtentePersistence.findByIdUtente_Domanda(idUtente, idDomanda);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return rispUtente;
	}
	
	
	
	
	public JSONObject addJSONRispostaUtente(long idUtente,long idRisposta,long idDomanda){
		RispostaUtente rispostaUtente = null;
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		try{
			rispostaUtente = rispostaUtenteLocalService.createRispostaUtente(CounterLocalServiceUtil.increment(RispostaUtente.class.getName()));
			rispostaUtente.setDataRisposta(new Date());
			rispostaUtente.setIdRisposta(idRisposta);
			rispostaUtente.setIdUtente(idUtente);
			rispostaUtente.setIdDomanda(idDomanda);
			rispostaUtente = rispostaUtentePersistence.update(rispostaUtente);
			jsonObject.put("esito", "OK");
		}catch(Exception ex){
			ex.printStackTrace();
			jsonObject.put("esito", "KO");
		}
		return jsonObject;
	}
}