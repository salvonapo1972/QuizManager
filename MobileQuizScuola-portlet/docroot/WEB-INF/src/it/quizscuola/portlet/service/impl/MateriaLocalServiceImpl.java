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

import it.quizscuola.portlet.NoSuchMateriaException;
import it.quizscuola.portlet.model.Argomento;
import it.quizscuola.portlet.model.Domanda;
import it.quizscuola.portlet.model.Materia;
import it.quizscuola.portlet.model.Risposta;
import it.quizscuola.portlet.model.RispostaUtente;
import it.quizscuola.portlet.service.ClasseLocalServiceUtil;
import it.quizscuola.portlet.service.MateriaLocalServiceUtil;
import it.quizscuola.portlet.service.base.MateriaLocalServiceBaseImpl;

/**
 * The implementation of the materia local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.quizscuola.portlet.service.MateriaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Salvatore
 * @see it.quizscuola.portlet.service.base.MateriaLocalServiceBaseImpl
 * @see it.quizscuola.portlet.service.MateriaLocalServiceUtil
 */
public class MateriaLocalServiceImpl extends MateriaLocalServiceBaseImpl {
	
	public Materia addMateria(ServiceContext ctx,String descMateria,long idClasse){
		Materia materia = null;
		try{
			materia = MateriaLocalServiceUtil.createMateria(CounterLocalServiceUtil.increment(Materia.class.getName()));
			materia.setCompanyId(ctx.getCompanyId());
			materia.setUserId(ctx.getUserId());
			materia.setCreateDate(new Date());
			materia.setDescMateria(descMateria);
			materia.setIdClasse(idClasse);
			materia.setGroupId(ctx.getScopeGroupId());
			materia.setUserName(UserLocalServiceUtil.getUser(ctx.getUserId()).getFullName());
			materia = materiaPersistence.update(materia);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return materia;
	}
	
	public Materia updateMateria(long idMateria,String descMateria) throws NoSuchMateriaException, SystemException{
		Materia materia = materiaPersistence.findByPrimaryKey(idMateria);
		materia.setDescMateria(descMateria);
		materia.setModifiedDate(new Date());
		materia = materiaPersistence.update(materia);
		return materia;
	}
	
	public void deleteMateriaByIdMateria(long idMateria) throws NoSuchMateriaException, SystemException{
		Materia materia = materiaPersistence.findByPrimaryKey(idMateria);
		List<Argomento> argomenti= argomentoPersistence.findByMateria(idMateria);
		for(Argomento argom:argomenti){
			//trovo le domande
			List<Domanda> domande =  domandaPersistence.findByArgomento(argom.getIdArgomento());
			for(Domanda dom:domande){
				List<Risposta> risposte = rispostaPersistence.findByDomanda(dom.getIdDomanda());
				List<RispostaUtente> rus = rispostaUtentePersistence.findByidDomanda(dom.getIdDomanda());
				for(Risposta risp:risposte){
					rispostaPersistence.remove(risp);
				}
				for(RispostaUtente ru:rus){
					rispostaUtentePersistence.remove(ru);
				}
				domandaPersistence.remove(dom);
			}
			argomentoPersistence.remove(argom);
		}
		materiaPersistence.remove(materia);
		
	}
	
	
	
	
	public List<Materia> getMaterias(int start,int end,OrderByComparator orderByComparator) throws SystemException{
		return materiaPersistence.findAll(start, end, orderByComparator);
	}
	
	public List<Materia> getMateriasByClasse(long idClasse,int start,int end,OrderByComparator orderByComparator) throws SystemException{
		return materiaPersistence.findByClasse(idClasse, start, end, orderByComparator);
	}
	
	public int getMateriasByClasseCount(long idClasse) throws SystemException{
		return materiaPersistence.findByClasse(idClasse).size();
	}
}