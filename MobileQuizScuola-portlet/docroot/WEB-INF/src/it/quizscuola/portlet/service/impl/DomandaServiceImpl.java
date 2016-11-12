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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import it.quizscuola.portlet.NoSuchDomandaException;
import it.quizscuola.portlet.model.Domanda;
import it.quizscuola.portlet.model.Risposta;
import it.quizscuola.portlet.service.base.DomandaServiceBaseImpl;

/**
 * The implementation of the domanda remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.quizscuola.portlet.service.DomandaService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Salvatore
 * @see it.quizscuola.portlet.service.base.DomandaServiceBaseImpl
 * @see it.quizscuola.portlet.service.DomandaServiceUtil
 */
public class DomandaServiceImpl extends DomandaServiceBaseImpl {
	
	public Domanda addDomanda(ServiceContext ctx,String descDomanda,long idArgomento,List<Risposta> listaRisposte){
		return domandaLocalService.addDomanda(ctx, descDomanda, idArgomento,listaRisposte);
	}
	
	public JSONObject getDomandaRisposte(long idArgomento,int posizione){
		return domandaLocalService.getDomandaRisposte( idArgomento, posizione);
	}
	
	public Domanda deleteDomanda(long idDomanda) throws PortalException, SystemException{
		return domandaLocalService.deleteDomanda(idDomanda);
	}
	
	public Domanda updateDomanda(long idDomanda,String descDomanda) throws  SystemException, NoSuchDomandaException{
		return domandaLocalService.updateDomanda(idDomanda, descDomanda);
	}
	
	public List<Domanda> getDomandas(int start,int end,OrderByComparator orderByComparator) throws SystemException{
		return domandaLocalService.getDomandas(start, end, orderByComparator);
	}
	
	public List<Domanda> getDomandasByArgomento(long idArgomento,int start,int end,OrderByComparator orderByComparator) throws SystemException{
		return domandaLocalService.getDomandasByArgomento(idArgomento, start, end, orderByComparator);
	}
	
	public int getDomandasByArgomentoCount(long idArgomento) throws SystemException{
		return domandaLocalService.getDomandasByArgomentoCount(idArgomento);
	}
	
	public JSONObject getNumDomandeByArgomento(long idArgomento) throws SystemException{
		return domandaLocalService.getNumDomandeByArgomento(idArgomento);
	}
	
	public Domanda updateDomanda(ServiceContext ctx,long idDomanda,String descDomanda,long idArgomento,List<Risposta> listaRisposte){
		return domandaLocalService.updateDomanda(ctx,idDomanda, descDomanda, idArgomento, listaRisposte);
	}
}