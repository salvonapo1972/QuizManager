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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.service.ServiceContext;

import it.quizscuola.portlet.NoSuchRispostaException;
import it.quizscuola.portlet.model.Domanda;
import it.quizscuola.portlet.model.Risposta;
import it.quizscuola.portlet.service.base.RispostaServiceBaseImpl;

/**
 * The implementation of the risposta remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.quizscuola.portlet.service.RispostaService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Salvatore
 * @see it.quizscuola.portlet.service.base.RispostaServiceBaseImpl
 * @see it.quizscuola.portlet.service.RispostaServiceUtil
 */
public class RispostaServiceImpl extends RispostaServiceBaseImpl {
	
	public Risposta addRisposta(ServiceContext ctx,String descRisposta,boolean esatta,long idDomanda){
		
		return rispostaLocalService.addRisposta(ctx, descRisposta,esatta, idDomanda);
	}
	
	public JSONArray getRisultati(long idUtente,long idArgomento){
		return rispostaLocalService.getRisultati(idUtente, idArgomento);
	}
	public JSONObject getRisultatiDomande(long idUtente,long idArgomento){
		return rispostaLocalService.getRisultatiDomande(idUtente, idArgomento);
	}
	
	public List<Risposta> getRispostas(long idDomanda) throws SystemException{
		return rispostaLocalService.getRispostas(idDomanda);
	}
	
	public Risposta updateRisposta(ServiceContext ctx,long idDomanda,long idRisposta,String descRisposta,boolean esatta) throws  SystemException, NoSuchRispostaException{
		return rispostaLocalService.updateRisposta(ctx,idDomanda,idRisposta, descRisposta,esatta);
	}
}