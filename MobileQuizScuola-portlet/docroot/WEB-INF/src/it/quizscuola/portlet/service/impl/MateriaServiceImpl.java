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

import it.quizscuola.portlet.NoSuchMateriaException;
import it.quizscuola.portlet.model.Argomento;
import it.quizscuola.portlet.model.Classe;
import it.quizscuola.portlet.model.Materia;
import it.quizscuola.portlet.service.ClasseLocalServiceUtil;
import it.quizscuola.portlet.service.MateriaLocalServiceUtil;
import it.quizscuola.portlet.service.base.MateriaServiceBaseImpl;

/**
 * The implementation of the materia remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.quizscuola.portlet.service.MateriaService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Salvatore
 * @see it.quizscuola.portlet.service.base.MateriaServiceBaseImpl
 * @see it.quizscuola.portlet.service.MateriaServiceUtil
 */
public class MateriaServiceImpl extends MateriaServiceBaseImpl {
	
	    public Materia addMateria(ServiceContext ctx,String descMateria,long idClasse){
			
			return materiaLocalService.addMateria(ctx, descMateria,idClasse);
		}
	    
	    public List<Materia> getMaterias(int start,int end,OrderByComparator orderByComparator) throws SystemException{
	    	return materiaLocalService.getMaterias(start, end,orderByComparator);
	    }
	    
	    public List<Materia> getMateriasByClasse(long idClasse,int start,int end,OrderByComparator orderByComparator) throws SystemException{
	    	return materiaLocalService.getMateriasByClasse(idClasse, start, end, orderByComparator);
	    }
	    
	    public int getMateriasByClasseCount(long idClasse) throws SystemException{
	    	return materiaLocalService.getMateriasByClasseCount(idClasse);
	    }
	    
	    public int getMateriasCount() throws SystemException{
	    	return materiaLocalService.getMateriasCount();
	    }
	    
	    public Materia removeMateria(long id) throws PortalException, SystemException{
	    	List<Argomento> listaArg = argomentoPersistence.findByMateria(id);
    		for(Argomento argom:listaArg){
    			argomentoLocalService.deleteArgomento(argom);
    		}
	    	return materiaLocalService.deleteMateria(id);
	    }
	    
	    public void deleteMateriaByIdMateria(long idMateria) throws NoSuchMateriaException, SystemException{
	    	materiaLocalService.deleteMateriaByIdMateria(idMateria);
	    }
	    
	    public List<Materia> getClasses() throws SystemException{
	    	return materiaLocalService.getMaterias(QueryUtil.ALL_POS, QueryUtil.ALL_POS);    
	    }
	    
	    public Materia updateMateria(long idMateria,String descMateria) throws NoSuchMateriaException, SystemException{
	    	return materiaLocalService.updateMateria(idMateria, descMateria);
	    }
	    
	    
	    public JSONArray getJSONListaMateria(long idClasse) throws SystemException{
	    	List<Materia> listaMaterie = materiaLocalService.getMateriasByClasse(idClasse, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	    	JSONArray jsonArray = new JSONFactoryUtil().createJSONArray();
	    	for(Materia materia:listaMaterie){
	    		JSONObject jb = new JSONFactoryUtil().createJSONObject();
	    		jb.put("id", materia.getIdMateria());
	    		jb.put("idClasse", materia.getIdClasse());
	    		jb.put("descMateria", materia.getDescMateria());
	    		jsonArray.put(jb);
	    	}
	    	
	    	return jsonArray;
	    }
}