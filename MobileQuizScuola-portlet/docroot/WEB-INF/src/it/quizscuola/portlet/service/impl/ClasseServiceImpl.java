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

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import it.quizscuola.portlet.NoSuchClasseException;
import it.quizscuola.portlet.model.Argomento;
import it.quizscuola.portlet.model.Classe;
import it.quizscuola.portlet.model.Materia;
import it.quizscuola.portlet.service.ClasseLocalServiceUtil;
import it.quizscuola.portlet.service.base.ClasseServiceBaseImpl;

/**
 * The implementation of the classe remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.quizscuola.portlet.service.ClasseService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Salvatore
 * @see it.quizscuola.portlet.service.base.ClasseServiceBaseImpl
 * @see it.quizscuola.portlet.service.ClasseServiceUtil
 */
public class ClasseServiceImpl extends ClasseServiceBaseImpl {
    public Classe addClasse(ServiceContext ctx,String descClasse){
		
		return ClasseLocalServiceUtil.addClasse(ctx, descClasse);
	}
    
    public List<Classe> getClasses(int start,int end,OrderByComparator orderByComparator) throws SystemException{
    	return classeLocalService.getClasses(start, end,orderByComparator);
    }
    
    public int getClasseCount() throws SystemException{
    	return classeLocalService.getClassesCount();
    }
    
    public Classe removeClasse(long id) throws PortalException, SystemException{
    	List<Materia> listaMaterie = materiaPersistence.findByClasse(id);
    	for(Materia mat:listaMaterie){
    		List<Argomento> listaArg = argomentoPersistence.findByMateria(mat.getIdMateria());
    		for(Argomento argom:listaArg){
    			argomentoLocalService.deleteArgomento(argom);
    		}
    		materiaLocalService.deleteMateria(mat);
    	}
    	return classeLocalService.deleteClasse(id);
    }
    
    public List<Classe> getClasses() throws SystemException{
    	return classeLocalService.getClasses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);    
    }
    
    public Classe updateClasse(long idClasse,String descClasse) throws NoSuchClasseException, SystemException{
    	return classeLocalService.updateClasse(idClasse, descClasse);
    }
    
    
    public JSONArray getJSONListaClassi() throws SystemException{
    	List<Classe> listaClassi = classeLocalService.getClasses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    	JSONArray jsonArray = new JSONFactoryUtil().createJSONArray();
    	for(Classe classe:listaClassi){
    		JSONObject jb = new JSONFactoryUtil().createJSONObject();
    		jb.put("id", classe.getId());
    		jb.put("descrizione", classe.getDescClasse());
    		jsonArray.put(jb);
    	}
    	
    	return jsonArray;
    }
}