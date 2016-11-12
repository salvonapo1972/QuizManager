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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import it.quizscuola.portlet.NoSuchDomandaException;
import it.quizscuola.portlet.NoSuchRispostaException;
import it.quizscuola.portlet.model.Domanda;
import it.quizscuola.portlet.model.Risposta;
import it.quizscuola.portlet.model.RispostaUtente;
import it.quizscuola.portlet.service.base.RispostaLocalServiceBaseImpl;

/**
 * The implementation of the risposta local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.quizscuola.portlet.service.RispostaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Salvatore
 * @see it.quizscuola.portlet.service.base.RispostaLocalServiceBaseImpl
 * @see it.quizscuola.portlet.service.RispostaLocalServiceUtil
 */
public class RispostaLocalServiceImpl extends RispostaLocalServiceBaseImpl {
	
	public Risposta addRisposta(ServiceContext ctx,String descRisposta,boolean esatta,long idDomanda){
		Risposta risposta = null;
		try{
			
			risposta = rispostaLocalService.createRisposta(CounterLocalServiceUtil.increment(Risposta.class.getName()));
			risposta.setCompanyId(ctx.getCompanyId());
			risposta.setUserId(ctx.getUserId());
			risposta.setCreateDate(new Date());
			risposta.setDescRisposta(descRisposta);
			risposta.setIdDomanda(idDomanda);
			risposta.setEsatta(esatta);
			risposta.setGroupId(ctx.getScopeGroupId());
			risposta.setUserName(UserLocalServiceUtil.getUser(ctx.getUserId()).getFullName());
			risposta = rispostaPersistence.update(risposta);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return risposta;
	}
	
	public Risposta updateRisposta(ServiceContext ctx,long idDomanda,long idRisposta,String descRisposta,boolean esatta) throws  SystemException, NoSuchRispostaException{
		Risposta risposta = null;
		try{
			risposta = rispostaPersistence.findByPrimaryKey(idRisposta);
			risposta.setDescRisposta(descRisposta);
			risposta.setModifiedDate(new Date());
			risposta.setEsatta(esatta);
			risposta = rispostaPersistence.update(risposta);
		}catch(Exception ex){
			//bisogna controllare se la domanda è nuova o è stata eliminata
			addRisposta(ctx, descRisposta, esatta, idDomanda);
		}
		return risposta;
	}
	
	public List<Risposta> getRispostas(long idDomanda) throws SystemException{
		return rispostaPersistence.findByDomanda(idDomanda);
	}
	
	public JSONObject getRisultatiDomande(long idUtente,long idArgomento){
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonObject1 = JSONFactoryUtil.createJSONObject();
		JSONObject jsonObject = null;
		int contEsatte = 0;
		int contErrata = 0;
		try{
			List<Domanda> listaDomande = domandaLocalService.getDomandasByArgomento(idArgomento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
			for(Domanda domanda:listaDomande){
				//Ricavo le risposte esatta
				Risposta rispEsatta = rispostaPersistence.findByDomanda_RispEsatta(domanda.getIdDomanda(),true);
				//Ricavo la risposta dell'utente
				RispostaUtente rispUtente = rispostaUtenteLocalService.getRispostaUtente(domanda.getIdDomanda(), idUtente);
				if(rispUtente.getIdRisposta() == rispEsatta.getIdRisposta()){
					jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("descRispostaEsatta", rispEsatta.getDescRisposta());
					jsonObject.put("descRispostaErrata", rispostaLocalService.getRisposta(rispUtente.getIdRisposta()).getDescRisposta());
					++contEsatte;
				}else{
					jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("descRispostaEsatta", rispEsatta.getDescRisposta());
					jsonObject.put("descRispostaErrata", rispostaLocalService.getRisposta(rispUtente.getIdRisposta()).getDescRisposta());
					++contErrata;
					
				}
				jsonArray.put(jsonObject);
				
			}
			
			jsonObject1.put("esatte", contEsatte);
			jsonObject1.put("errate", contErrata);
			jsonObject1.put("RisposteUtente", jsonArray);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return jsonObject1;
	}
	
	public JSONArray getRisultati(long idUtente,long idArgomento){
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonObject = null;
		int contEsatte = 0;
		int contErrata = 0;
		try{
			List<Domanda> listaDomande = domandaLocalService.getDomandasByArgomento(idArgomento, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
			for(Domanda domanda:listaDomande){
				//Ricavo le risposte esatta
				Risposta rispEsatta = rispostaPersistence.findByDomanda_RispEsatta(domanda.getIdDomanda(),true);
				//Ricavo la risposta dell'utente
				RispostaUtente rispUtente = rispostaUtenteLocalService.getRispostaUtente(domanda.getIdDomanda(), idUtente);
				if(rispUtente.getIdRisposta() == rispEsatta.getIdRisposta()){
					jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("esatta", rispEsatta.getDescRisposta());
					++contEsatte;
					//jsonObject.put("contatoreEsatta", ++contEsatte);
				}else{
					jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("errata", rispostaLocalService.getRisposta(rispUtente.getIdRisposta()).getDescRisposta());
					++contErrata;
					//jsonObject.put("contatoreErrata", ++contErrata);
				}
				//jsonArray.put(jsonObject);
				
			}
			JSONObject jsonObject1 = JSONFactoryUtil.createJSONObject();
			jsonObject1.put("esatte", contEsatte);
			jsonArray.put(jsonObject1);
			JSONObject jsonObject2 = JSONFactoryUtil.createJSONObject();
			jsonObject2.put("errate", contErrata);
			jsonArray.put(jsonObject2);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return jsonArray;
	}
}