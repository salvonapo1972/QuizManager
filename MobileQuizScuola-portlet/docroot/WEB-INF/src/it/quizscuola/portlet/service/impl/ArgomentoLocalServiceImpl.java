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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import it.quizscuola.portlet.NoSuchArgomentoException;
import it.quizscuola.portlet.model.Argomento;
import it.quizscuola.portlet.model.Domanda;
import it.quizscuola.portlet.model.Risposta;
import it.quizscuola.portlet.model.RispostaUtente;
import it.quizscuola.portlet.service.ArgomentoLocalServiceUtil;
import it.quizscuola.portlet.service.base.ArgomentoLocalServiceBaseImpl;

/**
 * The implementation of the argomento local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.quizscuola.portlet.service.ArgomentoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Salvatore
 * @see it.quizscuola.portlet.service.base.ArgomentoLocalServiceBaseImpl
 * @see it.quizscuola.portlet.service.ArgomentoLocalServiceUtil
 */
public class ArgomentoLocalServiceImpl extends ArgomentoLocalServiceBaseImpl {
	
	public Argomento addArgomento(ServiceContext ctx,String descArgomento,long idMateria){
		Argomento argomento = null;
		try{
			argomento = ArgomentoLocalServiceUtil.createArgomento(CounterLocalServiceUtil.increment(Argomento.class.getName()));
			argomento.setCompanyId(ctx.getCompanyId());
			argomento.setUserId(ctx.getUserId());
			argomento.setCreateDate(new Date());
			argomento.setDescArgomento(descArgomento);
			argomento.setIdMateria(idMateria);
			argomento.setGroupId(ctx.getScopeGroupId());
			argomento.setUserName(UserLocalServiceUtil.getUser(ctx.getUserId()).getFullName());
			argomento = argomentoPersistence.update(argomento);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return argomento;
	}
	
	public Argomento updateArgomento(long idArgomento,String descArgomento) throws SystemException, NoSuchArgomentoException{
		Argomento argomento = argomentoPersistence.findByPrimaryKey(idArgomento);
		argomento.setDescArgomento(descArgomento);
		argomento.setModifiedDate(new Date());
		argomento = argomentoPersistence.update(argomento);
		return argomento;
	}

	public List<Argomento> getArgomentos(int start,int end,OrderByComparator orderByComparator) throws SystemException{
		return argomentoPersistence.findAll(start, end, orderByComparator);
	}
	
	public List<Argomento> getArgomentiByMateria(long idMateria,int start,int end,OrderByComparator orderByComparator) throws SystemException{
		return argomentoPersistence.findByMateria(idMateria, start, end, orderByComparator);
	}
	
	public int getArgomentiByMateriaCount(long idMateria) throws SystemException{
		return argomentoPersistence.findByMateria(idMateria).size();
	}
	
	public void deleteDomandasByArgomento(long idUtente,long idArgomento){
		
		RispostaUtente ru =null;
		
		try{
			//argomento = argomentoPersistence.findByPrimaryKey(idArgomento);
			List<Domanda> domandas = domandaPersistence.findByArgomento(idArgomento);
			for(Domanda domanda : domandas){
				ru = rispostaUtentePersistence.removeByIdUtente_Domanda(idUtente, domanda.getIdDomanda());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
    public void deleteDomandasERisposteByArgomento(long idArgomento){
		
		RispostaUtente ru =null;
		
		try{
			//argomento = argomentoPersistence.findByPrimaryKey(idArgomento);
			List<Domanda> domandas = domandaPersistence.findByArgomento(idArgomento);
			for(Domanda domanda : domandas){
				try{
					Domanda domanda1 = domandaPersistence.remove(domanda);
					rispostaPersistence.removeByDomanda(domanda.getIdDomanda());
					//ru = rispostaUtentePersistence.removeByIdUtente_Domanda(idUtente, domanda.getIdDomanda());
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
			argomentoPersistence.remove(idArgomento);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}