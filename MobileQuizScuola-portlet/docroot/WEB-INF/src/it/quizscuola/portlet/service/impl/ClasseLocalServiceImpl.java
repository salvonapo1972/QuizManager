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

import it.quizscuola.portlet.NoSuchClasseException;
import it.quizscuola.portlet.model.Classe;
import it.quizscuola.portlet.service.ClasseLocalServiceUtil;
import it.quizscuola.portlet.service.base.ClasseLocalServiceBaseImpl;

/**
 * The implementation of the classe local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.quizscuola.portlet.service.ClasseLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Salvatore
 * @see it.quizscuola.portlet.service.base.ClasseLocalServiceBaseImpl
 * @see it.quizscuola.portlet.service.ClasseLocalServiceUtil
 */
public class ClasseLocalServiceImpl extends ClasseLocalServiceBaseImpl {
	
	public Classe addClasse(ServiceContext ctx,String descClasse){
		Classe classe = null;
		try{
		 classe = ClasseLocalServiceUtil.createClasse(CounterLocalServiceUtil.increment(Classe.class.getName()));
		 classe.setCompanyId(ctx.getCompanyId());
		 classe.setUserId(ctx.getUserId());
		 classe.setCreateDate(new Date());
		 classe.setDescClasse(descClasse);
		 classe.setGroupId(ctx.getScopeGroupId());
		 classe.setUserName(UserLocalServiceUtil.getUser(ctx.getUserId()).getFullName());
		 classe = classePersistence.update(classe);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return classe;
	}
	
	public Classe updateClasse(long idClasse,String descClasse) throws NoSuchClasseException, SystemException{
		Classe classe = classePersistence.findByPrimaryKey(idClasse);
		classe.setDescClasse(descClasse);
		classe.setModifiedDate(new Date());
		classe = classePersistence.update(classe);
		return classe;
	}
	
	
	public List<Classe> getClasses(int start,int end,OrderByComparator orderByComparator) throws SystemException{
		return classePersistence.findAll(start, end, orderByComparator);
	}
}