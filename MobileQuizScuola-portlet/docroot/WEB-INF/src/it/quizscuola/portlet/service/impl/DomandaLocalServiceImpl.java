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
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import it.quizscuola.portlet.NoSuchDomandaException;
import it.quizscuola.portlet.NoSuchMateriaException;
import it.quizscuola.portlet.model.Argomento;
import it.quizscuola.portlet.model.Domanda;
import it.quizscuola.portlet.model.Materia;
import it.quizscuola.portlet.model.Risposta;
import it.quizscuola.portlet.service.ArgomentoLocalServiceUtil;
import it.quizscuola.portlet.service.base.DomandaLocalServiceBaseImpl;
import it.quizscuola.portlet.service.persistence.RispostaExportActionableDynamicQuery;

/**
 * The implementation of the domanda local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.quizscuola.portlet.service.DomandaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Salvatore
 * @see it.quizscuola.portlet.service.base.DomandaLocalServiceBaseImpl
 * @see it.quizscuola.portlet.service.DomandaLocalServiceUtil
 */
public class DomandaLocalServiceImpl extends DomandaLocalServiceBaseImpl {
	
	public Domanda addDomanda(ServiceContext ctx,String descDomanda,long idArgomento,List<Risposta> listaRisposte){
		Domanda domanda = null;
		try{
			
			domanda = domandaLocalService.createDomanda(CounterLocalServiceUtil.increment(Domanda.class.getName()));
			domanda.setCompanyId(ctx.getCompanyId());
			domanda.setUserId(ctx.getUserId());
			domanda.setCreateDate(new Date());
			domanda.setDescDomanda(descDomanda);
			domanda.setPosizione(domandaPersistence.findByArgomento(idArgomento).size());
			domanda.setIdArgomento(idArgomento);
			domanda.setGroupId(ctx.getScopeGroupId());
			domanda.setUserName(UserLocalServiceUtil.getUser(ctx.getUserId()).getFullName());
			domanda = domandaPersistence.update(domanda);
			//Dopo aver inserito la domanda inserisco la risposta
			for(Risposta risposta:listaRisposte){
				rispostaLocalService.addRisposta(ctx, risposta.getDescRisposta(),risposta.getEsatta(), domanda.getIdDomanda());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return domanda;
	}
	
	
	public Domanda updateDomanda(ServiceContext ctx, long idDomanda,String descDomanda,long idArgomento,List<Risposta> listaRisposte){
		Domanda domanda = null;
		try{
			
			//domanda = domandaLocalService.createDomanda(CounterLocalServiceUtil.increment(Domanda.class.getName()));
			domanda = domandaPersistence.findByPrimaryKey(idDomanda);
			
			domanda.setModifiedDate(new Date());
			domanda.setDescDomanda(descDomanda);
			//domanda.setPosizione(domandaPersistence.findByArgomento(idArgomento).size());
			//domanda.setIdArgomento(idArgomento);
			domanda = domandaPersistence.update(domanda);
			//Dopo aver inserito la domanda inserisco la risposta
			for(Risposta risposta:listaRisposte){
				rispostaLocalService.updateRisposta(ctx,idDomanda,risposta.getIdRisposta(), risposta.getDescRisposta(),risposta.getEsatta());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return domanda;
	}
	
	public Domanda updateDomanda(long idDomanda,String descDomanda) throws  SystemException, NoSuchDomandaException{
		Domanda domanda = domandaPersistence.findByPrimaryKey(idDomanda);
		domanda.setDescDomanda(descDomanda);
		domanda.setModifiedDate(new Date());
		domanda = domandaPersistence.update(domanda);
		return domanda;
	}
	
	public Domanda deleteDomanda(long idDomanda){
		Domanda domanda = null;
		try{
			domanda = domandaPersistence.findByPrimaryKey(idDomanda);
			List<Risposta> listaRisp = rispostaPersistence.findByDomanda(idDomanda);
			for(Risposta risp:listaRisp){
				rispostaPersistence.remove(risp.getIdRisposta());
			}
			domanda = domandaPersistence.remove(domanda);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return domanda;
	}
	
	public JSONObject getDomandaRisposte(long idArgomento,int posizione){
		Domanda domanda = null;
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject jsonObject = null;
		try{
			jsonObject = JSONFactoryUtil.createJSONObject();
			domanda = domandaPersistence.findByArgomento_Pos(idArgomento, posizione);
			jsonObject.put("descDomanda", domanda.getDescDomanda());
			jsonObject.put("idDomanda", domanda.getIdDomanda());
			jsonObject.put("idArgomento", idArgomento);
			jsonObject.put("posizione", posizione);
			//jsonArray.put(jsonObject);
			//ricavo le risposte
			List<Risposta> risposte = rispostaPersistence.findByDomanda(domanda.getIdDomanda());
			for(Risposta risp : risposte){
				JSONObject jsonObjectRisp = JSONFactoryUtil.createJSONObject();
				jsonObjectRisp.put("idRisposta", risp.getIdRisposta());
				jsonObjectRisp.put("descRisposta", risp.getDescRisposta());
				jsonArray.put(jsonObjectRisp);
			}
			jsonObject.put("Risposte",jsonArray);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return jsonObject;
	}
	
	public JSONObject getNumDomandeByArgomento(long idArgomento) throws SystemException{
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("numDomande", domandaPersistence.findByArgomento(idArgomento).size());
		return jsonObject;
	}
	
	
	public List<Domanda> getDomandas(int start,int end,OrderByComparator orderByComparator) throws SystemException{
		return domandaPersistence.findAll(start, end, orderByComparator);
	}
	
	public List<Domanda> getDomandasByArgomento(long idArgomento,int start,int end,OrderByComparator orderByComparator) throws SystemException{
		return domandaPersistence.findByArgomento(idArgomento, start, end, orderByComparator);
	}
	
	public int getDomandasByArgomentoCount(long idArgomento) throws SystemException{
		return domandaPersistence.findByArgomento(idArgomento).size();
	}
}