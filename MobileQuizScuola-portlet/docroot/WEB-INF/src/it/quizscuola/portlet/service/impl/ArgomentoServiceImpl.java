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

import it.quizscuola.portlet.NoSuchArgomentoException;
import it.quizscuola.portlet.NoSuchMateriaException;
import it.quizscuola.portlet.model.Argomento;
import it.quizscuola.portlet.model.Materia;
import it.quizscuola.portlet.service.base.ArgomentoServiceBaseImpl;

/**
 * The implementation of the argomento remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.quizscuola.portlet.service.ArgomentoService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Salvatore
 * @see it.quizscuola.portlet.service.base.ArgomentoServiceBaseImpl
 * @see it.quizscuola.portlet.service.ArgomentoServiceUtil
 */
public class ArgomentoServiceImpl extends ArgomentoServiceBaseImpl {
	
	public Argomento addArgomento(ServiceContext ctx,String descArgomento,long idMateria){
		
		return argomentoLocalService.addArgomento(ctx, descArgomento, idMateria);
	}
    
    public List<Argomento> getArgumentos(int start,int end,OrderByComparator orderByComparator) throws SystemException{
    	return argomentoLocalService.getArgomentos(start, end,orderByComparator);
    }
    
    public List<Argomento> getArgomentiByMateria(long idMateria,int start,int end,OrderByComparator orderByComparator) throws SystemException{
    	return argomentoLocalService.getArgomentiByMateria(idMateria, start, end, orderByComparator);
    }
    
    public int getArgomentiByMateriaCount(long idMateria) throws SystemException{
    	return argomentoLocalService.getArgomentiByMateriaCount(idMateria);
    }
    
    public int getArgomentiCount() throws SystemException{
    	return argomentoLocalService.getArgomentosCount();
    }
    
    public Argomento removeArgomento(long id) throws PortalException, SystemException{
    	return argomentoLocalService.deleteArgomento(id);
    }
    
    public List<Argomento> getArgomentos() throws SystemException{
    	return argomentoLocalService.getArgomentos(QueryUtil.ALL_POS, QueryUtil.ALL_POS);    
    }
    
    public Argomento updateArgomento(long idArgomento,String descArgomento) throws  SystemException, NoSuchArgomentoException{
    	return argomentoLocalService.updateArgomento(idArgomento, descArgomento);
    }
    
    public void deleteDomandasByArgomento(long idUtente,long idArgomento){
    	argomentoLocalService.deleteDomandasByArgomento(idUtente, idArgomento);
    }
    
    public void deleteDomandasERisposteByArgomento(long idArgomento){
    	 argomentoLocalService.deleteDomandasERisposteByArgomento(idArgomento);
    	
    }
    
    public JSONArray getJSONListaArgomenti(long idMateria) throws SystemException{
    	List<Argomento> listaArgomenti = argomentoLocalService.getArgomentiByMateria(idMateria, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    	JSONArray jsonArray = new JSONFactoryUtil().createJSONArray();
    	for(Argomento argomento:listaArgomenti){
    		JSONObject jb = new JSONFactoryUtil().createJSONObject();
    		jb.put("id", argomento.getIdArgomento());
    		jb.put("idMateria", argomento.getIdMateria());
    		jb.put("descArgomento", argomento.getDescArgomento());
    		jsonArray.put(jb);
    	}
    	
    	return jsonArray;
    }
}